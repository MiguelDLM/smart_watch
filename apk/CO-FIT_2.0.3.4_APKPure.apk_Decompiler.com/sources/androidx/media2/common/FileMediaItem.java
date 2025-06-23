package androidx.media2.common;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import androidx.media2.common.MediaItem;
import java.io.IOException;

public class FileMediaItem extends MediaItem {
    public static final long FD_LENGTH_UNKNOWN = 576460752303423487L;
    private static final String TAG = "FileMediaItem";
    @GuardedBy("mLock")
    private boolean mClosed;
    private final long mFDLength;
    private final long mFDOffset;
    private final Object mLock = new Object();
    private final ParcelFileDescriptor mPFD;
    @GuardedBy("mLock")
    private int mRefCount;

    public static final class Builder extends MediaItem.Builder {
        long mFDLength = 576460752303423487L;
        long mFDOffset = 0;
        ParcelFileDescriptor mPFD;

        public Builder(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
            Preconditions.checkNotNull(parcelFileDescriptor);
            this.mPFD = parcelFileDescriptor;
            this.mFDOffset = 0;
            this.mFDLength = 576460752303423487L;
        }

        @NonNull
        public Builder setFileDescriptorLength(long j) {
            if (j < 0) {
                j = 576460752303423487L;
            }
            this.mFDLength = j;
            return this;
        }

        @NonNull
        public Builder setFileDescriptorOffset(long j) {
            if (j < 0) {
                j = 0;
            }
            this.mFDOffset = j;
            return this;
        }

        @NonNull
        public FileMediaItem build() {
            return new FileMediaItem(this);
        }

        @NonNull
        public Builder setEndPosition(long j) {
            return (Builder) super.setEndPosition(j);
        }

        @NonNull
        public Builder setMetadata(@Nullable MediaMetadata mediaMetadata) {
            return (Builder) super.setMetadata(mediaMetadata);
        }

        @NonNull
        public Builder setStartPosition(long j) {
            return (Builder) super.setStartPosition(j);
        }
    }

    public FileMediaItem(Builder builder) {
        super((MediaItem.Builder) builder);
        this.mPFD = builder.mPFD;
        this.mFDOffset = builder.mFDOffset;
        this.mFDLength = builder.mFDLength;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void close() throws IOException {
        synchronized (this.mLock) {
            try {
                ParcelFileDescriptor parcelFileDescriptor = this.mPFD;
                if (parcelFileDescriptor != null) {
                    parcelFileDescriptor.close();
                }
                this.mClosed = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0046, code lost:
        return;
     */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void decreaseRefCount() {
        /*
            r6 = this;
            java.lang.Object r0 = r6.mLock
            monitor-enter(r0)
            boolean r1 = r6.mClosed     // Catch:{ all -> 0x0010 }
            if (r1 == 0) goto L_0x0012
            java.lang.String r1 = "FileMediaItem"
            java.lang.String r2 = "ParcelFileDescriptorClient is already closed."
            android.util.Log.w(r1, r2)     // Catch:{ all -> 0x0010 }
            monitor-exit(r0)     // Catch:{ all -> 0x0010 }
            return
        L_0x0010:
            r1 = move-exception
            goto L_0x0047
        L_0x0012:
            int r1 = r6.mRefCount     // Catch:{ all -> 0x0010 }
            r2 = 1
            int r1 = r1 - r2
            r6.mRefCount = r1     // Catch:{ all -> 0x0010 }
            if (r1 > 0) goto L_0x0045
            android.os.ParcelFileDescriptor r1 = r6.mPFD     // Catch:{ IOException -> 0x0024 }
            if (r1 == 0) goto L_0x0026
            r1.close()     // Catch:{ IOException -> 0x0024 }
            goto L_0x0026
        L_0x0022:
            r1 = move-exception
            goto L_0x0042
        L_0x0024:
            r1 = move-exception
            goto L_0x0029
        L_0x0026:
            r6.mClosed = r2     // Catch:{ all -> 0x0010 }
            goto L_0x0045
        L_0x0029:
            java.lang.String r3 = "FileMediaItem"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0022 }
            r4.<init>()     // Catch:{ all -> 0x0022 }
            java.lang.String r5 = "Failed to close the ParcelFileDescriptor "
            r4.append(r5)     // Catch:{ all -> 0x0022 }
            android.os.ParcelFileDescriptor r5 = r6.mPFD     // Catch:{ all -> 0x0022 }
            r4.append(r5)     // Catch:{ all -> 0x0022 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0022 }
            android.util.Log.e(r3, r4, r1)     // Catch:{ all -> 0x0022 }
            goto L_0x0026
        L_0x0042:
            r6.mClosed = r2     // Catch:{ all -> 0x0010 }
            throw r1     // Catch:{ all -> 0x0010 }
        L_0x0045:
            monitor-exit(r0)     // Catch:{ all -> 0x0010 }
            return
        L_0x0047:
            monitor-exit(r0)     // Catch:{ all -> 0x0010 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media2.common.FileMediaItem.decreaseRefCount():void");
    }

    public long getFileDescriptorLength() {
        return this.mFDLength;
    }

    public long getFileDescriptorOffset() {
        return this.mFDOffset;
    }

    @NonNull
    public ParcelFileDescriptor getParcelFileDescriptor() {
        return this.mPFD;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void increaseRefCount() {
        synchronized (this.mLock) {
            try {
                if (this.mClosed) {
                    Log.w(TAG, "ParcelFileDescriptorClient is already closed.");
                } else {
                    this.mRefCount++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isClosed() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mClosed;
        }
        return z;
    }
}
