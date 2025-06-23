package androidx.emoji2.text;

import XXO0.oIX0oI;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

public class FontRequestEmojiCompatConfig extends EmojiCompat.Config {
    private static final FontProviderHelper DEFAULT_FONTS_CONTRACT = new FontProviderHelper();

    public static class ExponentialBackoffRetryPolicy extends RetryPolicy {
        private long mRetryOrigin;
        private final long mTotalMs;

        public ExponentialBackoffRetryPolicy(long j) {
            this.mTotalMs = j;
        }

        public long getRetryDelay() {
            if (this.mRetryOrigin == 0) {
                this.mRetryOrigin = SystemClock.uptimeMillis();
                return 0;
            }
            long uptimeMillis = SystemClock.uptimeMillis() - this.mRetryOrigin;
            if (uptimeMillis > this.mTotalMs) {
                return -1;
            }
            return Math.min(Math.max(uptimeMillis, 1000), this.mTotalMs - uptimeMillis);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class FontProviderHelper {
        @Nullable
        public Typeface buildTypeface(@NonNull Context context, @NonNull FontsContractCompat.FontInfo fontInfo) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.buildTypeface(context, (CancellationSignal) null, new FontsContractCompat.FontInfo[]{fontInfo});
        }

        @NonNull
        public FontsContractCompat.FontFamilyResult fetchFonts(@NonNull Context context, @NonNull FontRequest fontRequest) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.fetchFonts(context, (CancellationSignal) null, fontRequest);
        }

        public void registerObserver(@NonNull Context context, @NonNull Uri uri, @NonNull ContentObserver contentObserver) {
            context.getContentResolver().registerContentObserver(uri, false, contentObserver);
        }

        public void unregisterObserver(@NonNull Context context, @NonNull ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    public static class FontRequestMetadataLoader implements EmojiCompat.MetadataRepoLoader {
        private static final String S_TRACE_BUILD_TYPEFACE = "EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface";
        @GuardedBy("mLock")
        @Nullable
        EmojiCompat.MetadataRepoLoaderCallback mCallback;
        @NonNull
        private final Context mContext;
        @GuardedBy("mLock")
        @Nullable
        private Executor mExecutor;
        @NonNull
        private final FontProviderHelper mFontProviderHelper;
        @NonNull
        private final Object mLock = new Object();
        @GuardedBy("mLock")
        @Nullable
        private Handler mMainHandler;
        @GuardedBy("mLock")
        @Nullable
        private Runnable mMainHandlerLoadCallback;
        @GuardedBy("mLock")
        @Nullable
        private ThreadPoolExecutor mMyThreadPoolExecutor;
        @GuardedBy("mLock")
        @Nullable
        private ContentObserver mObserver;
        @NonNull
        private final FontRequest mRequest;
        @GuardedBy("mLock")
        @Nullable
        private RetryPolicy mRetryPolicy;

        public FontRequestMetadataLoader(@NonNull Context context, @NonNull FontRequest fontRequest, @NonNull FontProviderHelper fontProviderHelper) {
            Preconditions.checkNotNull(context, "Context cannot be null");
            Preconditions.checkNotNull(fontRequest, "FontRequest cannot be null");
            this.mContext = context.getApplicationContext();
            this.mRequest = fontRequest;
            this.mFontProviderHelper = fontProviderHelper;
        }

        private void cleanUp() {
            synchronized (this.mLock) {
                try {
                    this.mCallback = null;
                    ContentObserver contentObserver = this.mObserver;
                    if (contentObserver != null) {
                        this.mFontProviderHelper.unregisterObserver(this.mContext, contentObserver);
                        this.mObserver = null;
                    }
                    Handler handler = this.mMainHandler;
                    if (handler != null) {
                        handler.removeCallbacks(this.mMainHandlerLoadCallback);
                    }
                    this.mMainHandler = null;
                    ThreadPoolExecutor threadPoolExecutor = this.mMyThreadPoolExecutor;
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.shutdown();
                    }
                    this.mExecutor = null;
                    this.mMyThreadPoolExecutor = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @WorkerThread
        private FontsContractCompat.FontInfo retrieveFontInfo() {
            try {
                FontsContractCompat.FontFamilyResult fetchFonts = this.mFontProviderHelper.fetchFonts(this.mContext, this.mRequest);
                if (fetchFonts.getStatusCode() == 0) {
                    FontsContractCompat.FontInfo[] fonts = fetchFonts.getFonts();
                    if (fonts != null && fonts.length != 0) {
                        return fonts[0];
                    }
                    throw new RuntimeException("fetchFonts failed (empty result)");
                }
                throw new RuntimeException("fetchFonts failed (" + fetchFonts.getStatusCode() + oIX0oI.I0Io.f17331I0Io);
            } catch (PackageManager.NameNotFoundException e) {
                throw new RuntimeException("provider not found", e);
            }
        }

        @RequiresApi(19)
        @WorkerThread
        private void scheduleRetry(Uri uri, long j) {
            synchronized (this.mLock) {
                try {
                    Handler handler = this.mMainHandler;
                    if (handler == null) {
                        handler = ConcurrencyHelpers.mainHandlerAsync();
                        this.mMainHandler = handler;
                    }
                    if (this.mObserver == null) {
                        AnonymousClass1 r2 = new ContentObserver(handler) {
                            public void onChange(boolean z, Uri uri) {
                                FontRequestMetadataLoader.this.loadInternal();
                            }
                        };
                        this.mObserver = r2;
                        this.mFontProviderHelper.registerObserver(this.mContext, uri, r2);
                    }
                    if (this.mMainHandlerLoadCallback == null) {
                        this.mMainHandlerLoadCallback = new XO(this);
                    }
                    handler.postDelayed(this.mMainHandlerLoadCallback, j);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r0 = retrieveFontInfo();
            r1 = r0.getResultCode();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
            if (r1 != 2) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0018, code lost:
            r2 = r8.mLock;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x001a, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r3 = r8.mRetryPolicy;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x001d, code lost:
            if (r3 == null) goto L_0x0034;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x001f, code lost:
            r3 = r3.getRetryDelay();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0027, code lost:
            if (r3 < 0) goto L_0x0034;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0029, code lost:
            scheduleRetry(r0.getUri(), r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0030, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0031, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0032, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0034, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0038, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x003a, code lost:
            if (r1 != 0) goto L_0x0081;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            androidx.core.os.TraceCompat.beginSection(S_TRACE_BUILD_TYPEFACE);
            r1 = r8.mFontProviderHelper.buildTypeface(r8.mContext, r0);
            r0 = androidx.core.graphics.TypefaceCompatUtil.mmap(r8.mContext, (android.os.CancellationSignal) null, r0.getUri());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0054, code lost:
            if (r0 == null) goto L_0x0075;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0056, code lost:
            if (r1 == null) goto L_0x0075;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0058, code lost:
            r0 = androidx.emoji2.text.MetadataRepo.create(r1, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
            androidx.core.os.TraceCompat.endSection();
            r1 = r8.mLock;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0061, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
            r2 = r8.mCallback;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0064, code lost:
            if (r2 == null) goto L_0x006c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0066, code lost:
            r2.onLoaded(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x006a, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x006c, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
            cleanUp();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x0073, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x007c, code lost:
            throw new java.lang.RuntimeException("Unable to open file.");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
            androidx.core.os.TraceCompat.endSection();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0080, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x009c, code lost:
            throw new java.lang.RuntimeException("fetchFonts result is not OK. (" + r1 + XXO0.oIX0oI.I0Io.f17331I0Io);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x009f, code lost:
            monitor-enter(r8.mLock);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
            r2 = r8.mCallback;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x00a2, code lost:
            if (r2 != null) goto L_0x00a4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x00a4, code lost:
            r2.onFailed(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x00a8, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x00ab, code lost:
            cleanUp();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x00b0, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
            return;
         */
        @androidx.annotation.RequiresApi(19)
        @androidx.annotation.WorkerThread
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void createMetadata() {
            /*
                r8 = this;
                java.lang.Object r0 = r8.mLock
                monitor-enter(r0)
                androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback r1 = r8.mCallback     // Catch:{ all -> 0x0009 }
                if (r1 != 0) goto L_0x000c
                monitor-exit(r0)     // Catch:{ all -> 0x0009 }
                return
            L_0x0009:
                r1 = move-exception
                goto L_0x00b1
            L_0x000c:
                monitor-exit(r0)     // Catch:{ all -> 0x0009 }
                androidx.core.provider.FontsContractCompat$FontInfo r0 = r8.retrieveFontInfo()     // Catch:{ all -> 0x0038 }
                int r1 = r0.getResultCode()     // Catch:{ all -> 0x0038 }
                r2 = 2
                if (r1 != r2) goto L_0x003a
                java.lang.Object r2 = r8.mLock     // Catch:{ all -> 0x0038 }
                monitor-enter(r2)     // Catch:{ all -> 0x0038 }
                androidx.emoji2.text.FontRequestEmojiCompatConfig$RetryPolicy r3 = r8.mRetryPolicy     // Catch:{ all -> 0x0032 }
                if (r3 == 0) goto L_0x0034
                long r3 = r3.getRetryDelay()     // Catch:{ all -> 0x0032 }
                r5 = 0
                int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r7 < 0) goto L_0x0034
                android.net.Uri r0 = r0.getUri()     // Catch:{ all -> 0x0032 }
                r8.scheduleRetry(r0, r3)     // Catch:{ all -> 0x0032 }
                monitor-exit(r2)     // Catch:{ all -> 0x0032 }
                return
            L_0x0032:
                r0 = move-exception
                goto L_0x0036
            L_0x0034:
                monitor-exit(r2)     // Catch:{ all -> 0x0032 }
                goto L_0x003a
            L_0x0036:
                monitor-exit(r2)     // Catch:{ all -> 0x0032 }
                throw r0     // Catch:{ all -> 0x0038 }
            L_0x0038:
                r0 = move-exception
                goto L_0x009d
            L_0x003a:
                if (r1 != 0) goto L_0x0081
                java.lang.String r1 = "EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface"
                androidx.core.os.TraceCompat.beginSection(r1)     // Catch:{ all -> 0x0073 }
                androidx.emoji2.text.FontRequestEmojiCompatConfig$FontProviderHelper r1 = r8.mFontProviderHelper     // Catch:{ all -> 0x0073 }
                android.content.Context r2 = r8.mContext     // Catch:{ all -> 0x0073 }
                android.graphics.Typeface r1 = r1.buildTypeface(r2, r0)     // Catch:{ all -> 0x0073 }
                android.content.Context r2 = r8.mContext     // Catch:{ all -> 0x0073 }
                android.net.Uri r0 = r0.getUri()     // Catch:{ all -> 0x0073 }
                r3 = 0
                java.nio.ByteBuffer r0 = androidx.core.graphics.TypefaceCompatUtil.mmap(r2, r3, r0)     // Catch:{ all -> 0x0073 }
                if (r0 == 0) goto L_0x0075
                if (r1 == 0) goto L_0x0075
                androidx.emoji2.text.MetadataRepo r0 = androidx.emoji2.text.MetadataRepo.create((android.graphics.Typeface) r1, (java.nio.ByteBuffer) r0)     // Catch:{ all -> 0x0073 }
                androidx.core.os.TraceCompat.endSection()     // Catch:{ all -> 0x0038 }
                java.lang.Object r1 = r8.mLock     // Catch:{ all -> 0x0038 }
                monitor-enter(r1)     // Catch:{ all -> 0x0038 }
                androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback r2 = r8.mCallback     // Catch:{ all -> 0x006a }
                if (r2 == 0) goto L_0x006c
                r2.onLoaded(r0)     // Catch:{ all -> 0x006a }
                goto L_0x006c
            L_0x006a:
                r0 = move-exception
                goto L_0x0071
            L_0x006c:
                monitor-exit(r1)     // Catch:{ all -> 0x006a }
                r8.cleanUp()     // Catch:{ all -> 0x0038 }
                goto L_0x00ae
            L_0x0071:
                monitor-exit(r1)     // Catch:{ all -> 0x006a }
                throw r0     // Catch:{ all -> 0x0038 }
            L_0x0073:
                r0 = move-exception
                goto L_0x007d
            L_0x0075:
                java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x0073 }
                java.lang.String r1 = "Unable to open file."
                r0.<init>(r1)     // Catch:{ all -> 0x0073 }
                throw r0     // Catch:{ all -> 0x0073 }
            L_0x007d:
                androidx.core.os.TraceCompat.endSection()     // Catch:{ all -> 0x0038 }
                throw r0     // Catch:{ all -> 0x0038 }
            L_0x0081:
                java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x0038 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0038 }
                r2.<init>()     // Catch:{ all -> 0x0038 }
                java.lang.String r3 = "fetchFonts result is not OK. ("
                r2.append(r3)     // Catch:{ all -> 0x0038 }
                r2.append(r1)     // Catch:{ all -> 0x0038 }
                java.lang.String r1 = ")"
                r2.append(r1)     // Catch:{ all -> 0x0038 }
                java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0038 }
                r0.<init>(r1)     // Catch:{ all -> 0x0038 }
                throw r0     // Catch:{ all -> 0x0038 }
            L_0x009d:
                java.lang.Object r1 = r8.mLock
                monitor-enter(r1)
                androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback r2 = r8.mCallback     // Catch:{ all -> 0x00a8 }
                if (r2 == 0) goto L_0x00aa
                r2.onFailed(r0)     // Catch:{ all -> 0x00a8 }
                goto L_0x00aa
            L_0x00a8:
                r0 = move-exception
                goto L_0x00af
            L_0x00aa:
                monitor-exit(r1)     // Catch:{ all -> 0x00a8 }
                r8.cleanUp()
            L_0x00ae:
                return
            L_0x00af:
                monitor-exit(r1)     // Catch:{ all -> 0x00a8 }
                throw r0
            L_0x00b1:
                monitor-exit(r0)     // Catch:{ all -> 0x0009 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.FontRequestEmojiCompatConfig.FontRequestMetadataLoader.createMetadata():void");
        }

        @RequiresApi(19)
        public void load(@NonNull EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            Preconditions.checkNotNull(metadataRepoLoaderCallback, "LoaderCallback cannot be null");
            synchronized (this.mLock) {
                this.mCallback = metadataRepoLoaderCallback;
            }
            loadInternal();
        }

        @RequiresApi(19)
        public void loadInternal() {
            synchronized (this.mLock) {
                try {
                    if (this.mCallback != null) {
                        if (this.mExecutor == null) {
                            ThreadPoolExecutor createBackgroundPriorityExecutor = ConcurrencyHelpers.createBackgroundPriorityExecutor("emojiCompat");
                            this.mMyThreadPoolExecutor = createBackgroundPriorityExecutor;
                            this.mExecutor = createBackgroundPriorityExecutor;
                        }
                        this.mExecutor.execute(new X0o0xo(this));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void setExecutor(@NonNull Executor executor) {
            synchronized (this.mLock) {
                this.mExecutor = executor;
            }
        }

        public void setRetryPolicy(@Nullable RetryPolicy retryPolicy) {
            synchronized (this.mLock) {
                this.mRetryPolicy = retryPolicy;
            }
        }
    }

    public static abstract class RetryPolicy {
        public abstract long getRetryDelay();
    }

    public FontRequestEmojiCompatConfig(@NonNull Context context, @NonNull FontRequest fontRequest) {
        super(new FontRequestMetadataLoader(context, fontRequest, DEFAULT_FONTS_CONTRACT));
    }

    @NonNull
    @Deprecated
    public FontRequestEmojiCompatConfig setHandler(@Nullable Handler handler) {
        if (handler == null) {
            return this;
        }
        setLoadingExecutor(ConcurrencyHelpers.convertHandlerToExecutor(handler));
        return this;
    }

    @NonNull
    public FontRequestEmojiCompatConfig setLoadingExecutor(@NonNull Executor executor) {
        ((FontRequestMetadataLoader) getMetadataRepoLoader()).setExecutor(executor);
        return this;
    }

    @NonNull
    public FontRequestEmojiCompatConfig setRetryPolicy(@Nullable RetryPolicy retryPolicy) {
        ((FontRequestMetadataLoader) getMetadataRepoLoader()).setRetryPolicy(retryPolicy);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public FontRequestEmojiCompatConfig(@NonNull Context context, @NonNull FontRequest fontRequest, @NonNull FontProviderHelper fontProviderHelper) {
        super(new FontRequestMetadataLoader(context, fontRequest, fontProviderHelper));
    }
}
