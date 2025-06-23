package com.jd.ad.sdk.jad_rc;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes10.dex */
public class jad_sf extends FilterInputStream {
    public volatile byte[] jad_an;
    public int jad_bo;
    public int jad_cp;
    public int jad_dq;
    public int jad_er;
    public final com.jd.ad.sdk.jad_lw.jad_bo jad_fs;

    /* loaded from: classes10.dex */
    public static class jad_an extends IOException {
        public jad_an(String str) {
            super(str);
        }
    }

    public jad_sf(@NonNull InputStream inputStream, @NonNull com.jd.ad.sdk.jad_lw.jad_bo jad_boVar) {
        this(inputStream, jad_boVar, 65536);
    }

    public static IOException jad_cp() {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.jad_an == null || inputStream == null) {
            jad_cp();
            throw null;
        }
        return inputStream.available() + (this.jad_bo - this.jad_er);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.jad_an != null) {
            this.jad_fs.jad_an((com.jd.ad.sdk.jad_lw.jad_bo) this.jad_an);
            this.jad_an = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public final int jad_an(InputStream inputStream, byte[] bArr) {
        int i = this.jad_dq;
        if (i != -1) {
            int i2 = this.jad_er - i;
            int i3 = this.jad_cp;
            if (i2 < i3) {
                if (i == 0 && i3 > bArr.length && this.jad_bo == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i3) {
                        i3 = length;
                    }
                    byte[] bArr2 = (byte[]) this.jad_fs.jad_an(i3, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.jad_an = bArr2;
                    this.jad_fs.jad_an((com.jd.ad.sdk.jad_lw.jad_bo) bArr);
                    bArr = bArr2;
                } else if (i > 0) {
                    System.arraycopy(bArr, i, bArr, 0, bArr.length - i);
                }
                int i4 = this.jad_er - this.jad_dq;
                this.jad_er = i4;
                this.jad_dq = 0;
                this.jad_bo = 0;
                int read = inputStream.read(bArr, i4, bArr.length - i4);
                int i5 = this.jad_er;
                if (read > 0) {
                    i5 += read;
                }
                this.jad_bo = i5;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.jad_dq = -1;
            this.jad_er = 0;
            this.jad_bo = read2;
        }
        return read2;
    }

    public synchronized void jad_bo() {
        if (this.jad_an != null) {
            this.jad_fs.jad_an((com.jd.ad.sdk.jad_lw.jad_bo) this.jad_an);
            this.jad_an = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.jad_cp = Math.max(this.jad_cp, i);
        this.jad_dq = this.jad_er;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        byte[] bArr = this.jad_an;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            jad_cp();
            throw null;
        }
        if (this.jad_er >= this.jad_bo && jad_an(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.jad_an && (bArr = this.jad_an) == null) {
            jad_cp();
            throw null;
        }
        int i = this.jad_bo;
        int i2 = this.jad_er;
        if (i - i2 <= 0) {
            return -1;
        }
        this.jad_er = i2 + 1;
        return bArr[i2] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        if (this.jad_an == null) {
            throw new IOException("Stream is closed");
        }
        int i = this.jad_dq;
        if (-1 == i) {
            StringBuilder jad_an2 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("Mark has been invalidated, pos: ");
            jad_an2.append(this.jad_er);
            jad_an2.append(" markLimit: ");
            jad_an2.append(this.jad_cp);
            throw new jad_an(jad_an2.toString());
        }
        this.jad_er = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) {
        if (j < 1) {
            return 0L;
        }
        byte[] bArr = this.jad_an;
        if (bArr == null) {
            jad_cp();
            throw null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            jad_cp();
            throw null;
        }
        int i = this.jad_bo;
        int i2 = this.jad_er;
        if (i - i2 >= j) {
            this.jad_er = (int) (i2 + j);
            return j;
        }
        long j2 = i - i2;
        this.jad_er = i;
        if (this.jad_dq == -1 || j > this.jad_cp) {
            long skip = inputStream.skip(j - j2);
            if (skip > 0) {
                this.jad_dq = -1;
            }
            return j2 + skip;
        }
        if (jad_an(inputStream, bArr) == -1) {
            return j2;
        }
        int i3 = this.jad_bo;
        int i4 = this.jad_er;
        if (i3 - i4 >= j - j2) {
            this.jad_er = (int) ((i4 + j) - j2);
            return j;
        }
        long j3 = (j2 + i3) - i4;
        this.jad_er = i3;
        return j3;
    }

    @VisibleForTesting
    public jad_sf(@NonNull InputStream inputStream, @NonNull com.jd.ad.sdk.jad_lw.jad_bo jad_boVar, int i) {
        super(inputStream);
        this.jad_dq = -1;
        this.jad_fs = jad_boVar;
        this.jad_an = (byte[]) jad_boVar.jad_an(i, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(@NonNull byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        byte[] bArr2 = this.jad_an;
        if (bArr2 == null) {
            jad_cp();
            throw null;
        }
        if (i2 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            jad_cp();
            throw null;
        }
        int i5 = this.jad_er;
        int i6 = this.jad_bo;
        if (i5 < i6) {
            int i7 = i6 - i5;
            if (i7 >= i2) {
                i7 = i2;
            }
            System.arraycopy(bArr2, i5, bArr, i, i7);
            this.jad_er += i7;
            if (i7 == i2 || inputStream.available() == 0) {
                return i7;
            }
            i += i7;
            i3 = i2 - i7;
        } else {
            i3 = i2;
        }
        while (true) {
            if (this.jad_dq == -1 && i3 >= bArr2.length) {
                i4 = inputStream.read(bArr, i, i3);
                if (i4 == -1) {
                    return i3 != i2 ? i2 - i3 : -1;
                }
            } else {
                if (jad_an(inputStream, bArr2) == -1) {
                    return i3 != i2 ? i2 - i3 : -1;
                }
                if (bArr2 != this.jad_an && (bArr2 = this.jad_an) == null) {
                    jad_cp();
                    throw null;
                }
                int i8 = this.jad_bo;
                int i9 = this.jad_er;
                i4 = i8 - i9;
                if (i4 >= i3) {
                    i4 = i3;
                }
                System.arraycopy(bArr2, i9, bArr, i, i4);
                this.jad_er += i4;
            }
            i3 -= i4;
            if (i3 == 0) {
                return i2;
            }
            if (inputStream.available() == 0) {
                return i2 - i3;
            }
            i += i4;
        }
    }
}
