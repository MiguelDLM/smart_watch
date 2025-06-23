package androidx.media2.common;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class MediaItem extends CustomVersionedParcelable {
    static final long LONG_MAX = 576460752303423487L;
    public static final long POSITION_UNKNOWN = 576460752303423487L;
    private static final String TAG = "MediaItem";
    long mEndPositionMs;
    @GuardedBy("mLock")
    private final List<Pair<OnMetadataChangedListener, Executor>> mListeners;
    private final Object mLock;
    @GuardedBy("mLock")
    MediaMetadata mMetadata;
    long mStartPositionMs;

    public static class Builder {
        long mEndPositionMs = 576460752303423487L;
        MediaMetadata mMetadata;
        long mStartPositionMs = 0;

        @NonNull
        public MediaItem build() {
            return new MediaItem(this);
        }

        @NonNull
        public Builder setEndPosition(long j) {
            if (j < 0) {
                j = 576460752303423487L;
            }
            this.mEndPositionMs = j;
            return this;
        }

        @NonNull
        public Builder setMetadata(@Nullable MediaMetadata mediaMetadata) {
            this.mMetadata = mediaMetadata;
            return this;
        }

        @NonNull
        public Builder setStartPosition(long j) {
            if (j < 0) {
                j = 0;
            }
            this.mStartPositionMs = j;
            return this;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface OnMetadataChangedListener {
        void onMetadataChanged(@NonNull MediaItem mediaItem, @Nullable MediaMetadata mediaMetadata);
    }

    public MediaItem() {
        this.mLock = new Object();
        this.mStartPositionMs = 0;
        this.mEndPositionMs = 576460752303423487L;
        this.mListeners = new ArrayList();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void addOnMetadataChangedListener(Executor executor, OnMetadataChangedListener onMetadataChangedListener) {
        synchronized (this.mLock) {
            try {
                for (Pair<OnMetadataChangedListener, Executor> pair : this.mListeners) {
                    if (pair.first == onMetadataChangedListener) {
                        return;
                    }
                }
                this.mListeners.add(new Pair(onMetadataChangedListener, executor));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public long getEndPosition() {
        return this.mEndPositionMs;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getMediaId() {
        String str;
        synchronized (this.mLock) {
            try {
                MediaMetadata mediaMetadata = this.mMetadata;
                if (mediaMetadata != null) {
                    str = mediaMetadata.getString("android.media.metadata.MEDIA_ID");
                } else {
                    str = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    @Nullable
    public MediaMetadata getMetadata() {
        MediaMetadata mediaMetadata;
        synchronized (this.mLock) {
            mediaMetadata = this.mMetadata;
        }
        return mediaMetadata;
    }

    public long getStartPosition() {
        return this.mStartPositionMs;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void onPreParceling(boolean z) {
        if (getClass() == MediaItem.class) {
            super.onPreParceling(z);
            return;
        }
        throw new RuntimeException("MediaItem's subclasses shouldn't be parcelized.");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void removeOnMetadataChangedListener(OnMetadataChangedListener onMetadataChangedListener) {
        synchronized (this.mLock) {
            try {
                for (int size = this.mListeners.size() - 1; size >= 0; size--) {
                    if (this.mListeners.get(size).first == onMetadataChangedListener) {
                        this.mListeners.remove(size);
                        return;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0033, code lost:
        r0 = r0.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
        if (r0.hasNext() == false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003d, code lost:
        r1 = (androidx.core.util.Pair) r0.next();
        r2 = (androidx.media2.common.MediaItem.OnMetadataChangedListener) r1.first;
        ((java.util.concurrent.Executor) r1.second).execute(new androidx.media2.common.MediaItem.AnonymousClass1(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setMetadata(@androidx.annotation.Nullable final androidx.media2.common.MediaMetadata r5) {
        /*
            r4 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.Object r1 = r4.mLock
            monitor-enter(r1)
            androidx.media2.common.MediaMetadata r2 = r4.mMetadata     // Catch:{ all -> 0x000e }
            if (r2 != r5) goto L_0x0010
            monitor-exit(r1)     // Catch:{ all -> 0x000e }
            return
        L_0x000e:
            r5 = move-exception
            goto L_0x0055
        L_0x0010:
            if (r2 == 0) goto L_0x002b
            if (r5 == 0) goto L_0x002b
            java.lang.String r2 = r4.getMediaId()     // Catch:{ all -> 0x000e }
            java.lang.String r3 = r5.getMediaId()     // Catch:{ all -> 0x000e }
            boolean r2 = android.text.TextUtils.equals(r2, r3)     // Catch:{ all -> 0x000e }
            if (r2 != 0) goto L_0x002b
            java.lang.String r5 = "MediaItem"
            java.lang.String r0 = "MediaItem's media ID shouldn't be changed"
            android.util.Log.w(r5, r0)     // Catch:{ all -> 0x000e }
            monitor-exit(r1)     // Catch:{ all -> 0x000e }
            return
        L_0x002b:
            r4.mMetadata = r5     // Catch:{ all -> 0x000e }
            java.util.List<androidx.core.util.Pair<androidx.media2.common.MediaItem$OnMetadataChangedListener, java.util.concurrent.Executor>> r2 = r4.mListeners     // Catch:{ all -> 0x000e }
            r0.addAll(r2)     // Catch:{ all -> 0x000e }
            monitor-exit(r1)     // Catch:{ all -> 0x000e }
            java.util.Iterator r0 = r0.iterator()
        L_0x0037:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0054
            java.lang.Object r1 = r0.next()
            androidx.core.util.Pair r1 = (androidx.core.util.Pair) r1
            F r2 = r1.first
            androidx.media2.common.MediaItem$OnMetadataChangedListener r2 = (androidx.media2.common.MediaItem.OnMetadataChangedListener) r2
            S r1 = r1.second
            java.util.concurrent.Executor r1 = (java.util.concurrent.Executor) r1
            androidx.media2.common.MediaItem$1 r3 = new androidx.media2.common.MediaItem$1
            r3.<init>(r2, r5)
            r1.execute(r3)
            goto L_0x0037
        L_0x0054:
            return
        L_0x0055:
            monitor-exit(r1)     // Catch:{ all -> 0x000e }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media2.common.MediaItem.setMetadata(androidx.media2.common.MediaMetadata):void");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(getClass().getSimpleName());
        synchronized (this.mLock) {
            sb.append("{Media Id=");
            sb.append(getMediaId());
            sb.append(", mMetadata=");
            sb.append(this.mMetadata);
            sb.append(", mStartPositionMs=");
            sb.append(this.mStartPositionMs);
            sb.append(", mEndPositionMs=");
            sb.append(this.mEndPositionMs);
            sb.append('}');
        }
        return sb.toString();
    }

    public MediaItem(Builder builder) {
        this(builder.mMetadata, builder.mStartPositionMs, builder.mEndPositionMs);
    }

    public MediaItem(MediaItem mediaItem) {
        this(mediaItem.mMetadata, mediaItem.mStartPositionMs, mediaItem.mEndPositionMs);
    }

    public MediaItem(@Nullable MediaMetadata mediaMetadata, long j, long j2) {
        this.mLock = new Object();
        this.mStartPositionMs = 0;
        this.mEndPositionMs = 576460752303423487L;
        this.mListeners = new ArrayList();
        if (j <= j2) {
            if (mediaMetadata != null && mediaMetadata.containsKey("android.media.metadata.DURATION")) {
                long j3 = mediaMetadata.getLong("android.media.metadata.DURATION");
                if (!(j3 == Long.MIN_VALUE || j2 == 576460752303423487L || j2 <= j3)) {
                    throw new IllegalStateException("endPositionMs shouldn't be greater than duration in the metdata, endPositionMs=" + j2 + ", durationMs=" + j3);
                }
            }
            this.mMetadata = mediaMetadata;
            this.mStartPositionMs = j;
            this.mEndPositionMs = j2;
            return;
        }
        throw new IllegalStateException("Illegal start/end position: " + j + " : " + j2);
    }
}
