package com.jd.ad.sdk.jad_gp;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes10.dex */
public final class jad_cp extends FilterInputStream {
    public final long jad_an;
    public int jad_bo;

    public jad_cp(@NonNull InputStream inputStream, long j) {
        super(inputStream);
        this.jad_an = j;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        return (int) Math.max(this.jad_an - this.jad_bo, ((FilterInputStream) this).in.available());
    }

    public final int jad_an(int i) {
        if (i >= 0) {
            this.jad_bo += i;
        } else if (this.jad_an - this.jad_bo > 0) {
            StringBuilder jad_an = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("Failed to read all expected data, expected: ");
            jad_an.append(this.jad_an);
            jad_an.append(", but read: ");
            jad_an.append(this.jad_bo);
            throw new IOException(jad_an.toString());
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        int read;
        read = super.read();
        jad_an(read >= 0 ? 1 : -1);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) {
        return jad_an(super.read(bArr, i, i2));
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        int jad_an;
        int length = bArr.length;
        synchronized (this) {
            jad_an = jad_an(super.read(bArr, 0, length));
        }
        return jad_an;
    }
}
