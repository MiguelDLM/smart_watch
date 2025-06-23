package com.facebook.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.VisibleForTesting;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.WorkQueue;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes8.dex */
public final class ImageDownloader {
    private static final int CACHE_READ_QUEUE_MAX_CONCURRENT = 2;
    private static final int DOWNLOAD_QUEUE_MAX_CONCURRENT = 8;

    @OXOo.oOoXoXO
    private static Handler handler;

    @OXOo.OOXIXo
    public static final ImageDownloader INSTANCE = new ImageDownloader();

    @OXOo.OOXIXo
    private static final WorkQueue downloadQueue = new WorkQueue(8, null, 2, null);

    @OXOo.OOXIXo
    private static final WorkQueue cacheReadQueue = new WorkQueue(2, null, 2, null);

    @OXOo.OOXIXo
    private static final Map<RequestKey, DownloaderContext> pendingRequests = new HashMap();

    /* loaded from: classes8.dex */
    public static final class CacheReadWorkItem implements Runnable {
        private final boolean allowCachedRedirects;

        @OXOo.OOXIXo
        private final RequestKey key;

        public CacheReadWorkItem(@OXOo.OOXIXo RequestKey key, boolean z) {
            IIX0o.x0xO0oo(key, "key");
            this.key = key;
            this.allowCachedRedirects = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    ImageDownloader.INSTANCE.readFromCache(this.key, this.allowCachedRedirects);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class DownloadImageWorkItem implements Runnable {

        @OXOo.OOXIXo
        private final RequestKey key;

        public DownloadImageWorkItem(@OXOo.OOXIXo RequestKey key) {
            IIX0o.x0xO0oo(key, "key");
            this.key = key;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    ImageDownloader.INSTANCE.download(this.key);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        }
    }

    @VisibleForTesting(otherwise = 2)
    /* loaded from: classes8.dex */
    public static final class DownloaderContext {
        private boolean isCancelled;

        @OXOo.OOXIXo
        private ImageRequest request;

        @OXOo.oOoXoXO
        private WorkQueue.WorkItem workItem;

        public DownloaderContext(@OXOo.OOXIXo ImageRequest request) {
            IIX0o.x0xO0oo(request, "request");
            this.request = request;
        }

        @OXOo.OOXIXo
        public final ImageRequest getRequest() {
            return this.request;
        }

        @OXOo.oOoXoXO
        public final WorkQueue.WorkItem getWorkItem() {
            return this.workItem;
        }

        public final boolean isCancelled() {
            return this.isCancelled;
        }

        public final void setCancelled(boolean z) {
            this.isCancelled = z;
        }

        public final void setRequest(@OXOo.OOXIXo ImageRequest imageRequest) {
            IIX0o.x0xO0oo(imageRequest, "<set-?>");
            this.request = imageRequest;
        }

        public final void setWorkItem(@OXOo.oOoXoXO WorkQueue.WorkItem workItem) {
            this.workItem = workItem;
        }
    }

    @VisibleForTesting(otherwise = 2)
    /* loaded from: classes8.dex */
    public static final class RequestKey {

        @OXOo.OOXIXo
        public static final Companion Companion = new Companion(null);
        private static final int HASH_MULTIPLIER = 37;
        private static final int HASH_SEED = 29;

        @OXOo.OOXIXo
        private Object tag;

        @OXOo.OOXIXo
        private Uri uri;

        /* loaded from: classes8.dex */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
                this();
            }

            private Companion() {
            }
        }

        public RequestKey(@OXOo.OOXIXo Uri uri, @OXOo.OOXIXo Object tag) {
            IIX0o.x0xO0oo(uri, "uri");
            IIX0o.x0xO0oo(tag, "tag");
            this.uri = uri;
            this.tag = tag;
        }

        public boolean equals(@OXOo.oOoXoXO Object obj) {
            if (obj == null || !(obj instanceof RequestKey)) {
                return false;
            }
            RequestKey requestKey = (RequestKey) obj;
            if (requestKey.uri != this.uri || requestKey.tag != this.tag) {
                return false;
            }
            return true;
        }

        @OXOo.OOXIXo
        public final Object getTag() {
            return this.tag;
        }

        @OXOo.OOXIXo
        public final Uri getUri() {
            return this.uri;
        }

        public int hashCode() {
            return ((1073 + this.uri.hashCode()) * 37) + this.tag.hashCode();
        }

        public final void setTag(@OXOo.OOXIXo Object obj) {
            IIX0o.x0xO0oo(obj, "<set-?>");
            this.tag = obj;
        }

        public final void setUri(@OXOo.OOXIXo Uri uri) {
            IIX0o.x0xO0oo(uri, "<set-?>");
            this.uri = uri;
        }
    }

    private ImageDownloader() {
    }

    @XO0OX.x0XOIxOo
    public static final boolean cancelRequest(@OXOo.OOXIXo ImageRequest request) {
        boolean z;
        IIX0o.x0xO0oo(request, "request");
        RequestKey requestKey = new RequestKey(request.getImageUri(), request.getCallerTag());
        Map<RequestKey, DownloaderContext> map = pendingRequests;
        synchronized (map) {
            try {
                DownloaderContext downloaderContext = map.get(requestKey);
                if (downloaderContext != null) {
                    WorkQueue.WorkItem workItem = downloaderContext.getWorkItem();
                    z = true;
                    if (workItem != null && workItem.cancel()) {
                        map.remove(requestKey);
                    } else {
                        downloaderContext.setCancelled(true);
                    }
                } else {
                    z = false;
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @XO0OX.x0XOIxOo
    public static final void clearCache() {
        ImageResponseCache imageResponseCache = ImageResponseCache.INSTANCE;
        ImageResponseCache.clearCache();
        UrlRedirectCache urlRedirectCache = UrlRedirectCache.INSTANCE;
        UrlRedirectCache.clearCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v6, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void download(com.facebook.internal.ImageDownloader.RequestKey r11) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.ImageDownloader.download(com.facebook.internal.ImageDownloader$RequestKey):void");
    }

    @XO0OX.x0XOIxOo
    public static final void downloadAsync(@OXOo.oOoXoXO ImageRequest imageRequest) {
        if (imageRequest == null) {
            return;
        }
        RequestKey requestKey = new RequestKey(imageRequest.getImageUri(), imageRequest.getCallerTag());
        Map<RequestKey, DownloaderContext> map = pendingRequests;
        synchronized (map) {
            try {
                DownloaderContext downloaderContext = map.get(requestKey);
                if (downloaderContext != null) {
                    downloaderContext.setRequest(imageRequest);
                    downloaderContext.setCancelled(false);
                    WorkQueue.WorkItem workItem = downloaderContext.getWorkItem();
                    if (workItem != null) {
                        workItem.moveToFront();
                        oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                    }
                } else {
                    INSTANCE.enqueueCacheRead(imageRequest, requestKey, imageRequest.isCachedRedirectAllowed());
                    oXIO0o0XI oxio0o0xi2 = oXIO0o0XI.f29392oIX0oI;
                }
            } finally {
            }
        }
    }

    private final void enqueueCacheRead(ImageRequest imageRequest, RequestKey requestKey, boolean z) {
        enqueueRequest(imageRequest, requestKey, cacheReadQueue, new CacheReadWorkItem(requestKey, z));
    }

    private final void enqueueDownload(ImageRequest imageRequest, RequestKey requestKey) {
        enqueueRequest(imageRequest, requestKey, downloadQueue, new DownloadImageWorkItem(requestKey));
    }

    private final void enqueueRequest(ImageRequest imageRequest, RequestKey requestKey, WorkQueue workQueue, Runnable runnable) {
        Map<RequestKey, DownloaderContext> map = pendingRequests;
        synchronized (map) {
            DownloaderContext downloaderContext = new DownloaderContext(imageRequest);
            map.put(requestKey, downloaderContext);
            downloaderContext.setWorkItem(WorkQueue.addActiveWorkItem$default(workQueue, runnable, false, 2, null));
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        }
    }

    private final synchronized Handler getHandler() {
        try {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
        } catch (Throwable th) {
            throw th;
        }
        return handler;
    }

    private final void issueResponse(RequestKey requestKey, final Exception exc, final Bitmap bitmap, final boolean z) {
        ImageRequest.Callback callback;
        Handler handler2;
        DownloaderContext removePendingRequest = removePendingRequest(requestKey);
        if (removePendingRequest != null && !removePendingRequest.isCancelled()) {
            final ImageRequest request = removePendingRequest.getRequest();
            if (request == null) {
                callback = null;
            } else {
                callback = request.getCallback();
            }
            final ImageRequest.Callback callback2 = callback;
            if (callback2 != null && (handler2 = getHandler()) != null) {
                handler2.post(new Runnable() { // from class: com.facebook.internal.x0XOIxOo
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImageDownloader.m208issueResponse$lambda4(ImageRequest.this, exc, z, bitmap, callback2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: issueResponse$lambda-4, reason: not valid java name */
    public static final void m208issueResponse$lambda4(ImageRequest request, Exception exc, boolean z, Bitmap bitmap, ImageRequest.Callback callback) {
        IIX0o.x0xO0oo(request, "$request");
        callback.onCompleted(new ImageResponse(request, exc, z, bitmap));
    }

    @XO0OX.x0XOIxOo
    public static final void prioritizeRequest(@OXOo.OOXIXo ImageRequest request) {
        WorkQueue.WorkItem workItem;
        IIX0o.x0xO0oo(request, "request");
        RequestKey requestKey = new RequestKey(request.getImageUri(), request.getCallerTag());
        Map<RequestKey, DownloaderContext> map = pendingRequests;
        synchronized (map) {
            try {
                DownloaderContext downloaderContext = map.get(requestKey);
                if (downloaderContext != null && (workItem = downloaderContext.getWorkItem()) != null) {
                    workItem.moveToFront();
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void readFromCache(com.facebook.internal.ImageDownloader.RequestKey r5, boolean r6) {
        /*
            r4 = this;
            r0 = 0
            r1 = 0
            if (r6 == 0) goto L1a
            com.facebook.internal.UrlRedirectCache r6 = com.facebook.internal.UrlRedirectCache.INSTANCE
            android.net.Uri r6 = r5.getUri()
            android.net.Uri r6 = com.facebook.internal.UrlRedirectCache.getRedirectedUri(r6)
            if (r6 == 0) goto L1a
            com.facebook.internal.ImageResponseCache r2 = com.facebook.internal.ImageResponseCache.INSTANCE
            java.io.InputStream r6 = com.facebook.internal.ImageResponseCache.getCachedImageStream(r6)
            if (r6 == 0) goto L1b
            r1 = 1
            goto L1b
        L1a:
            r6 = r0
        L1b:
            if (r1 != 0) goto L27
            com.facebook.internal.ImageResponseCache r6 = com.facebook.internal.ImageResponseCache.INSTANCE
            android.net.Uri r6 = r5.getUri()
            java.io.InputStream r6 = com.facebook.internal.ImageResponseCache.getCachedImageStream(r6)
        L27:
            if (r6 == 0) goto L36
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r6)
            com.facebook.internal.Utility r3 = com.facebook.internal.Utility.INSTANCE
            com.facebook.internal.Utility.closeQuietly(r6)
            r4.issueResponse(r5, r0, r2, r1)
            goto L4e
        L36:
            com.facebook.internal.ImageDownloader$DownloaderContext r6 = r4.removePendingRequest(r5)
            if (r6 != 0) goto L3d
            goto L41
        L3d:
            com.facebook.internal.ImageRequest r0 = r6.getRequest()
        L41:
            if (r6 == 0) goto L4e
            boolean r6 = r6.isCancelled()
            if (r6 != 0) goto L4e
            if (r0 == 0) goto L4e
            r4.enqueueDownload(r0, r5)
        L4e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.ImageDownloader.readFromCache(com.facebook.internal.ImageDownloader$RequestKey, boolean):void");
    }

    private final DownloaderContext removePendingRequest(RequestKey requestKey) {
        DownloaderContext remove;
        Map<RequestKey, DownloaderContext> map = pendingRequests;
        synchronized (map) {
            remove = map.remove(requestKey);
        }
        return remove;
    }

    @OXOo.OOXIXo
    @VisibleForTesting(otherwise = 2)
    public final Map<RequestKey, DownloaderContext> getPendingRequests() {
        return pendingRequests;
    }
}
