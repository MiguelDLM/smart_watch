package androidx.media2.common;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public static class Builder {
        MediaMetadata mMetadata;
        long mStartPositionMs = 0;
        long mEndPositionMs = 576460752303423487L;

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
    /* loaded from: classes.dex */
    public interface OnMetadataChangedListener {
        void onMetadataChanged(@NonNull MediaItem mediaItem, @Nullable MediaMetadata mediaMetadata);
    }

    public MediaItem() {
        this.mLock = new Object();
        this.mStartPositionMs = 0L;
        this.mEndPositionMs = 576460752303423487L;
        this.mListeners = new ArrayList();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void addOnMetadataChangedListener(Executor executor, OnMetadataChangedListener onMetadataChangedListener) {
        synchronized (this.mLock) {
            try {
                Iterator<Pair<OnMetadataChangedListener, Executor>> it = this.mListeners.iterator();
                while (it.hasNext()) {
                    if (it.next().first == onMetadataChangedListener) {
                        return;
                    }
                }
                this.mListeners.add(new Pair<>(onMetadataChangedListener, executor));
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

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
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

    public void setMetadata(@Nullable final MediaMetadata mediaMetadata) {
        ArrayList<Pair> arrayList = new ArrayList();
        synchronized (this.mLock) {
            try {
                MediaMetadata mediaMetadata2 = this.mMetadata;
                if (mediaMetadata2 == mediaMetadata) {
                    return;
                }
                if (mediaMetadata2 != null && mediaMetadata != null && !TextUtils.equals(getMediaId(), mediaMetadata.getMediaId())) {
                    Log.w(TAG, "MediaItem's media ID shouldn't be changed");
                    return;
                }
                this.mMetadata = mediaMetadata;
                arrayList.addAll(this.mListeners);
                for (Pair pair : arrayList) {
                    final OnMetadataChangedListener onMetadataChangedListener = (OnMetadataChangedListener) pair.first;
                    ((Executor) pair.second).execute(new Runnable() { // from class: androidx.media2.common.MediaItem.1
                        @Override // java.lang.Runnable
                        public void run() {
                            onMetadataChangedListener.onMetadataChanged(MediaItem.this, mediaMetadata);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
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
        this.mStartPositionMs = 0L;
        this.mEndPositionMs = 576460752303423487L;
        this.mListeners = new ArrayList();
        if (j <= j2) {
            if (mediaMetadata != null && mediaMetadata.containsKey("android.media.metadata.DURATION")) {
                long j3 = mediaMetadata.getLong("android.media.metadata.DURATION");
                if (j3 != Long.MIN_VALUE && j2 != 576460752303423487L && j2 > j3) {
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
