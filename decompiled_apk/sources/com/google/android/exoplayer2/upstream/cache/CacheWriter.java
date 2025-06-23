package com.google.android.exoplayer2.upstream.cache;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.io.IOException;
import java.io.InterruptedIOException;

/* loaded from: classes9.dex */
public final class CacheWriter {
    public static final int DEFAULT_BUFFER_SIZE_BYTES = 131072;
    private long bytesCached;
    private final Cache cache;
    private final String cacheKey;
    private final CacheDataSource dataSource;
    private final DataSpec dataSpec;
    private long endPosition;
    private volatile boolean isCanceled;
    private long nextPosition;

    @Nullable
    private final ProgressListener progressListener;
    private final byte[] temporaryBuffer;

    /* loaded from: classes9.dex */
    public interface ProgressListener {
        void onProgress(long j, long j2, long j3);
    }

    public CacheWriter(CacheDataSource cacheDataSource, DataSpec dataSpec, @Nullable byte[] bArr, @Nullable ProgressListener progressListener) {
        this.dataSource = cacheDataSource;
        this.cache = cacheDataSource.getCache();
        this.dataSpec = dataSpec;
        this.temporaryBuffer = bArr == null ? new byte[131072] : bArr;
        this.progressListener = progressListener;
        this.cacheKey = cacheDataSource.getCacheKeyFactory().buildCacheKey(dataSpec);
        this.nextPosition = dataSpec.position;
    }

    private long getLength() {
        long j = this.endPosition;
        if (j == -1) {
            return -1L;
        }
        return j - this.dataSpec.position;
    }

    private void onNewBytesCached(long j) {
        this.bytesCached += j;
        ProgressListener progressListener = this.progressListener;
        if (progressListener != null) {
            progressListener.onProgress(getLength(), this.bytesCached, j);
        }
    }

    private void onRequestEndPosition(long j) {
        if (this.endPosition == j) {
            return;
        }
        this.endPosition = j;
        ProgressListener progressListener = this.progressListener;
        if (progressListener != null) {
            progressListener.onProgress(getLength(), this.bytesCached, 0L);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006f A[Catch: IOException -> 0x0068, TryCatch #0 {IOException -> 0x0068, blocks: (B:25:0x0064, B:33:0x006f, B:36:0x007d, B:42:0x0085), top: B:24:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0085 A[Catch: IOException -> 0x0068, TRY_LEAVE, TryCatch #0 {IOException -> 0x0068, blocks: (B:25:0x0064, B:33:0x006f, B:36:0x007d, B:42:0x0085), top: B:24:0x0064 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private long readBlockToCache(long r10, long r12) throws java.io.IOException {
        /*
            r9 = this;
            long r0 = r10 + r12
            long r2 = r9.endPosition
            r4 = 1
            r5 = 0
            r6 = -1
            int r8 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r8 == 0) goto L13
            int r0 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r0 != 0) goto L11
            goto L13
        L11:
            r0 = 0
            goto L14
        L13:
            r0 = 1
        L14:
            int r1 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r1 == 0) goto L36
            com.google.android.exoplayer2.upstream.DataSpec r1 = r9.dataSpec
            com.google.android.exoplayer2.upstream.DataSpec$Builder r1 = r1.buildUpon()
            com.google.android.exoplayer2.upstream.DataSpec$Builder r1 = r1.setPosition(r10)
            com.google.android.exoplayer2.upstream.DataSpec$Builder r12 = r1.setLength(r12)
            com.google.android.exoplayer2.upstream.DataSpec r12 = r12.build()
            com.google.android.exoplayer2.upstream.cache.CacheDataSource r13 = r9.dataSource     // Catch: java.io.IOException -> L31
            long r12 = r13.open(r12)     // Catch: java.io.IOException -> L31
            goto L38
        L31:
            com.google.android.exoplayer2.upstream.cache.CacheDataSource r12 = r9.dataSource
            com.google.android.exoplayer2.upstream.DataSourceUtil.closeQuietly(r12)
        L36:
            r12 = r6
            r4 = 0
        L38:
            if (r4 != 0) goto L5d
            r9.throwIfCanceled()
            com.google.android.exoplayer2.upstream.DataSpec r12 = r9.dataSpec
            com.google.android.exoplayer2.upstream.DataSpec$Builder r12 = r12.buildUpon()
            com.google.android.exoplayer2.upstream.DataSpec$Builder r12 = r12.setPosition(r10)
            com.google.android.exoplayer2.upstream.DataSpec$Builder r12 = r12.setLength(r6)
            com.google.android.exoplayer2.upstream.DataSpec r12 = r12.build()
            com.google.android.exoplayer2.upstream.cache.CacheDataSource r13 = r9.dataSource     // Catch: java.io.IOException -> L56
            long r12 = r13.open(r12)     // Catch: java.io.IOException -> L56
            goto L5d
        L56:
            r10 = move-exception
            com.google.android.exoplayer2.upstream.cache.CacheDataSource r11 = r9.dataSource
            com.google.android.exoplayer2.upstream.DataSourceUtil.closeQuietly(r11)
            throw r10
        L5d:
            if (r0 == 0) goto L6a
            int r1 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r1 == 0) goto L6a
            long r12 = r12 + r10
            r9.onRequestEndPosition(r12)     // Catch: java.io.IOException -> L68
            goto L6a
        L68:
            r10 = move-exception
            goto L8b
        L6a:
            r12 = 0
            r13 = 0
        L6c:
            r1 = -1
            if (r12 == r1) goto L83
            r9.throwIfCanceled()     // Catch: java.io.IOException -> L68
            com.google.android.exoplayer2.upstream.cache.CacheDataSource r12 = r9.dataSource     // Catch: java.io.IOException -> L68
            byte[] r2 = r9.temporaryBuffer     // Catch: java.io.IOException -> L68
            int r3 = r2.length     // Catch: java.io.IOException -> L68
            int r12 = r12.read(r2, r5, r3)     // Catch: java.io.IOException -> L68
            if (r12 == r1) goto L6c
            long r1 = (long) r12     // Catch: java.io.IOException -> L68
            r9.onNewBytesCached(r1)     // Catch: java.io.IOException -> L68
            int r13 = r13 + r12
            goto L6c
        L83:
            if (r0 == 0) goto L91
            long r0 = (long) r13     // Catch: java.io.IOException -> L68
            long r10 = r10 + r0
            r9.onRequestEndPosition(r10)     // Catch: java.io.IOException -> L68
            goto L91
        L8b:
            com.google.android.exoplayer2.upstream.cache.CacheDataSource r11 = r9.dataSource
            com.google.android.exoplayer2.upstream.DataSourceUtil.closeQuietly(r11)
            throw r10
        L91:
            com.google.android.exoplayer2.upstream.cache.CacheDataSource r10 = r9.dataSource
            r10.close()
            long r10 = (long) r13
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.cache.CacheWriter.readBlockToCache(long, long):long");
    }

    private void throwIfCanceled() throws InterruptedIOException {
        if (!this.isCanceled) {
        } else {
            throw new InterruptedIOException();
        }
    }

    @WorkerThread
    public void cache() throws IOException {
        long j;
        throwIfCanceled();
        Cache cache = this.cache;
        String str = this.cacheKey;
        DataSpec dataSpec = this.dataSpec;
        this.bytesCached = cache.getCachedBytes(str, dataSpec.position, dataSpec.length);
        DataSpec dataSpec2 = this.dataSpec;
        long j2 = dataSpec2.length;
        if (j2 != -1) {
            this.endPosition = dataSpec2.position + j2;
        } else {
            long oIX0oI2 = I0Io.oIX0oI(this.cache.getContentMetadata(this.cacheKey));
            if (oIX0oI2 == -1) {
                oIX0oI2 = -1;
            }
            this.endPosition = oIX0oI2;
        }
        ProgressListener progressListener = this.progressListener;
        if (progressListener != null) {
            progressListener.onProgress(getLength(), this.bytesCached, 0L);
        }
        while (true) {
            long j3 = this.endPosition;
            if (j3 != -1 && this.nextPosition >= j3) {
                return;
            }
            throwIfCanceled();
            long j4 = this.endPosition;
            if (j4 == -1) {
                j = Long.MAX_VALUE;
            } else {
                j = j4 - this.nextPosition;
            }
            long cachedLength = this.cache.getCachedLength(this.cacheKey, this.nextPosition, j);
            if (cachedLength > 0) {
                this.nextPosition += cachedLength;
            } else {
                long j5 = -cachedLength;
                if (j5 == Long.MAX_VALUE) {
                    j5 = -1;
                }
                long j6 = this.nextPosition;
                this.nextPosition = j6 + readBlockToCache(j6, j5);
            }
        }
    }

    public void cancel() {
        this.isCanceled = true;
    }
}
