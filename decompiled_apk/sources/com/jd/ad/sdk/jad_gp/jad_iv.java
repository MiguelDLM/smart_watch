package com.jd.ad.sdk.jad_gp;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.InputStream;

/* loaded from: classes10.dex */
public class jad_iv extends FilterInputStream {
    public int jad_an;

    public jad_iv(@NonNull InputStream inputStream) {
        super(inputStream);
        this.jad_an = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        int i = this.jad_an;
        return i == Integer.MIN_VALUE ? super.available() : Math.min(i, super.available());
    }

    public final long jad_bo(long j) {
        int i = this.jad_an;
        if (i == 0) {
            return -1L;
        }
        if (i != Integer.MIN_VALUE) {
            long j2 = i;
            if (j > j2) {
                return j2;
            }
        }
        return j;
    }

    public final void jad_cp(long j) {
        int i = this.jad_an;
        if (i == Integer.MIN_VALUE || j == -1) {
            return;
        }
        this.jad_an = (int) (i - j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        super.mark(i);
        this.jad_an = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        if (jad_bo(1L) == -1) {
            return -1;
        }
        int read = super.read();
        jad_cp(1L);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        super.reset();
        this.jad_an = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) {
        long jad_bo = jad_bo(j);
        if (jad_bo == -1) {
            return 0L;
        }
        long skip = super.skip(jad_bo);
        jad_cp(skip);
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i, int i2) {
        int jad_bo = (int) jad_bo(i2);
        if (jad_bo == -1) {
            return -1;
        }
        int read = super.read(bArr, i, jad_bo);
        jad_cp(read);
        return read;
    }
}
