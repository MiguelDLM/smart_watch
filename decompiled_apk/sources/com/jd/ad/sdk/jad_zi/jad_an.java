package com.jd.ad.sdk.jad_zi;

import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.EOFException;
import java.io.Flushable;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;

/* loaded from: classes10.dex */
public final class jad_an implements jad_bo, Closeable, Flushable, WritableByteChannel, Cloneable, ByteChannel {

    @Nullable
    public jad_jw jad_an;
    public long jad_bo;

    public Object clone() {
        jad_an jad_anVar = new jad_an();
        if (this.jad_bo != 0) {
            jad_jw jad_bo = this.jad_an.jad_bo();
            jad_anVar.jad_an = jad_bo;
            jad_bo.jad_jt = jad_bo;
            jad_bo.jad_fs = jad_bo;
            jad_jw jad_jwVar = this.jad_an;
            while (true) {
                jad_jwVar = jad_jwVar.jad_fs;
                if (jad_jwVar == this.jad_an) {
                    break;
                }
                jad_anVar.jad_an.jad_jt.jad_an(jad_jwVar.jad_bo());
            }
            jad_anVar.jad_bo = this.jad_bo;
        }
        return jad_anVar;
    }

    @Override // com.jd.ad.sdk.jad_zi.jad_mz, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof jad_an)) {
            return false;
        }
        jad_an jad_anVar = (jad_an) obj;
        long j = this.jad_bo;
        if (j != jad_anVar.jad_bo) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        jad_jw jad_jwVar = this.jad_an;
        jad_jw jad_jwVar2 = jad_anVar.jad_an;
        int i = jad_jwVar.jad_bo;
        int i2 = jad_jwVar2.jad_bo;
        while (j2 < this.jad_bo) {
            long min = Math.min(jad_jwVar.jad_cp - i, jad_jwVar2.jad_cp - i2);
            int i3 = 0;
            while (i3 < min) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (jad_jwVar.jad_an[i] != jad_jwVar2.jad_an[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == jad_jwVar.jad_cp) {
                jad_jwVar = jad_jwVar.jad_fs;
                i = jad_jwVar.jad_bo;
            }
            if (i2 == jad_jwVar2.jad_cp) {
                jad_jwVar2 = jad_jwVar2.jad_fs;
                i2 = jad_jwVar2.jad_bo;
            }
            j2 += min;
        }
        return true;
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    public int hashCode() {
        jad_jw jad_jwVar = this.jad_an;
        if (jad_jwVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = jad_jwVar.jad_cp;
            for (int i3 = jad_jwVar.jad_bo; i3 < i2; i3++) {
                i = (i * 31) + jad_jwVar.jad_an[i3];
            }
            jad_jwVar = jad_jwVar.jad_fs;
        } while (jad_jwVar != this.jad_an);
        return i;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // com.jd.ad.sdk.jad_zi.jad_bo
    public int jad_an(jad_fs jad_fsVar) {
        int jad_an = jad_an(jad_fsVar, false);
        if (jad_an == -1) {
            return -1;
        }
        try {
            jad_dq(jad_fsVar.jad_an[jad_an].jad_cp());
            return jad_an;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    public byte jad_bo() {
        long j = this.jad_bo;
        if (j == 0) {
            throw new IllegalStateException("size == 0");
        }
        jad_jw jad_jwVar = this.jad_an;
        int i = jad_jwVar.jad_bo;
        int i2 = jad_jwVar.jad_cp;
        int i3 = i + 1;
        byte b = jad_jwVar.jad_an[i];
        this.jad_bo = j - 1;
        if (i3 == i2) {
            this.jad_an = jad_jwVar.jad_an();
            jad_kx.jad_an(jad_jwVar);
        } else {
            jad_jwVar.jad_bo = i3;
        }
        return b;
    }

    public jad_an jad_cp(int i) {
        jad_jw jad_an = jad_an(4);
        byte[] bArr = jad_an.jad_an;
        int i2 = jad_an.jad_cp;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        jad_an.jad_cp = i2 + 4;
        this.jad_bo += 4;
        return this;
    }

    public void jad_dq(long j) {
        while (j > 0) {
            if (this.jad_an == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, r0.jad_cp - r0.jad_bo);
            long j2 = min;
            this.jad_bo -= j2;
            j -= j2;
            jad_jw jad_jwVar = this.jad_an;
            int i = jad_jwVar.jad_bo + min;
            jad_jwVar.jad_bo = i;
            if (i == jad_jwVar.jad_cp) {
                this.jad_an = jad_jwVar.jad_an();
                jad_kx.jad_an(jad_jwVar);
            }
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        jad_jw jad_jwVar = this.jad_an;
        if (jad_jwVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), jad_jwVar.jad_cp - jad_jwVar.jad_bo);
        byteBuffer.put(jad_jwVar.jad_an, jad_jwVar.jad_bo, min);
        int i = jad_jwVar.jad_bo + min;
        jad_jwVar.jad_bo = i;
        this.jad_bo -= min;
        if (i == jad_jwVar.jad_cp) {
            this.jad_an = jad_jwVar.jad_an();
            jad_kx.jad_an(jad_jwVar);
        }
        return min;
    }

    public String toString() {
        jad_cp jad_lyVar;
        long j = this.jad_bo;
        if (j <= 2147483647L) {
            int i = (int) j;
            if (i == 0) {
                jad_lyVar = jad_cp.jad_er;
            } else {
                jad_lyVar = new jad_ly(this, i);
            }
            return jad_lyVar.toString();
        }
        StringBuilder jad_an = jad_pc.jad_an("size > Integer.MAX_VALUE: ");
        jad_an.append(this.jad_bo);
        throw new IllegalArgumentException(jad_an.toString());
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int remaining = byteBuffer.remaining();
        int i = remaining;
        while (i > 0) {
            jad_jw jad_an = jad_an(1);
            int min = Math.min(i, 8192 - jad_an.jad_cp);
            byteBuffer.get(jad_an.jad_an, jad_an.jad_cp, min);
            i -= min;
            jad_an.jad_cp += min;
        }
        this.jad_bo += remaining;
        return remaining;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0055, code lost:
    
        if (r19 == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0057, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0058, code lost:
    
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int jad_an(com.jd.ad.sdk.jad_zi.jad_fs r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 158
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_zi.jad_an.jad_an(com.jd.ad.sdk.jad_zi.jad_fs, boolean):int");
    }

    public final byte jad_bo(long j) {
        int i;
        jad_ob.jad_an(this.jad_bo, j, 1L);
        long j2 = this.jad_bo;
        if (j2 - j <= j) {
            long j3 = j - j2;
            jad_jw jad_jwVar = this.jad_an;
            do {
                jad_jwVar = jad_jwVar.jad_jt;
                int i2 = jad_jwVar.jad_cp;
                i = jad_jwVar.jad_bo;
                j3 += i2 - i;
            } while (j3 < 0);
            return jad_jwVar.jad_an[i + ((int) j3)];
        }
        jad_jw jad_jwVar2 = this.jad_an;
        while (true) {
            int i3 = jad_jwVar2.jad_cp;
            int i4 = jad_jwVar2.jad_bo;
            long j4 = i3 - i4;
            if (j < j4) {
                return jad_jwVar2.jad_an[i4 + ((int) j)];
            }
            j -= j4;
            jad_jwVar2 = jad_jwVar2.jad_fs;
        }
    }

    public byte[] jad_cp(long j) {
        jad_ob.jad_an(this.jad_bo, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        int i = (int) j;
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int jad_an = jad_an(bArr, i2, i - i2);
            if (jad_an == -1) {
                throw new EOFException();
            }
            i2 += jad_an;
        }
        return bArr;
    }

    public int jad_an(byte[] bArr, int i, int i2) {
        jad_ob.jad_an(bArr.length, i, i2);
        jad_jw jad_jwVar = this.jad_an;
        if (jad_jwVar == null) {
            return -1;
        }
        int min = Math.min(i2, jad_jwVar.jad_cp - jad_jwVar.jad_bo);
        System.arraycopy(jad_jwVar.jad_an, jad_jwVar.jad_bo, bArr, i, min);
        int i3 = jad_jwVar.jad_bo + min;
        jad_jwVar.jad_bo = i3;
        this.jad_bo -= min;
        if (i3 == jad_jwVar.jad_cp) {
            this.jad_an = jad_jwVar.jad_an();
            jad_kx.jad_an(jad_jwVar);
        }
        return min;
    }

    public jad_an jad_bo(int i) {
        jad_jw jad_an = jad_an(1);
        byte[] bArr = jad_an.jad_an;
        int i2 = jad_an.jad_cp;
        jad_an.jad_cp = i2 + 1;
        bArr[i2] = (byte) i;
        this.jad_bo++;
        return this;
    }

    @Override // com.jd.ad.sdk.jad_zi.jad_mz
    public long jad_an(jad_an jad_anVar, long j) {
        if (jad_anVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        long j2 = this.jad_bo;
        if (j2 == 0) {
            return -1L;
        }
        if (j > j2) {
            j = j2;
        }
        jad_anVar.jad_bo(this, j);
        return j;
    }

    public void jad_bo(jad_an jad_anVar, long j) {
        jad_jw jad_an;
        if (jad_anVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        jad_ob.jad_an(jad_anVar.jad_bo, 0L, j);
        while (j > 0) {
            jad_jw jad_jwVar = jad_anVar.jad_an;
            int i = jad_jwVar.jad_cp - jad_jwVar.jad_bo;
            if (j < i) {
                jad_jw jad_jwVar2 = this.jad_an;
                jad_jw jad_jwVar3 = jad_jwVar2 != null ? jad_jwVar2.jad_jt : null;
                if (jad_jwVar3 != null && jad_jwVar3.jad_er) {
                    if ((jad_jwVar3.jad_cp + j) - (jad_jwVar3.jad_dq ? 0 : jad_jwVar3.jad_bo) <= 8192) {
                        jad_jwVar.jad_an(jad_jwVar3, (int) j);
                        jad_anVar.jad_bo -= j;
                        this.jad_bo += j;
                        return;
                    }
                }
                int i2 = (int) j;
                if (i2 > 0 && i2 <= i) {
                    if (i2 >= 1024) {
                        jad_an = jad_jwVar.jad_bo();
                    } else {
                        jad_an = jad_kx.jad_an();
                        System.arraycopy(jad_jwVar.jad_an, jad_jwVar.jad_bo, jad_an.jad_an, 0, i2);
                    }
                    jad_an.jad_cp = jad_an.jad_bo + i2;
                    jad_jwVar.jad_bo += i2;
                    jad_jwVar.jad_jt.jad_an(jad_an);
                    jad_anVar.jad_an = jad_an;
                } else {
                    throw new IllegalArgumentException();
                }
            }
            jad_jw jad_jwVar4 = jad_anVar.jad_an;
            long j2 = jad_jwVar4.jad_cp - jad_jwVar4.jad_bo;
            jad_anVar.jad_an = jad_jwVar4.jad_an();
            jad_jw jad_jwVar5 = this.jad_an;
            if (jad_jwVar5 == null) {
                this.jad_an = jad_jwVar4;
                jad_jwVar4.jad_jt = jad_jwVar4;
                jad_jwVar4.jad_fs = jad_jwVar4;
            } else {
                jad_jw jad_an2 = jad_jwVar5.jad_jt.jad_an(jad_jwVar4);
                jad_jw jad_jwVar6 = jad_an2.jad_jt;
                if (jad_jwVar6 == jad_an2) {
                    throw new IllegalStateException();
                }
                if (jad_jwVar6.jad_er) {
                    int i3 = jad_an2.jad_cp - jad_an2.jad_bo;
                    if (i3 <= (8192 - jad_jwVar6.jad_cp) + (jad_jwVar6.jad_dq ? 0 : jad_jwVar6.jad_bo)) {
                        jad_an2.jad_an(jad_jwVar6, i3);
                        jad_an2.jad_an();
                        jad_kx.jad_an(jad_an2);
                    }
                }
            }
            jad_anVar.jad_bo -= j2;
            this.jad_bo += j2;
            j -= j2;
        }
    }

    @Override // com.jd.ad.sdk.jad_zi.jad_bo
    public long jad_an(jad_cp jad_cpVar) {
        return jad_an(jad_cpVar, 0L);
    }

    public long jad_an(jad_cp jad_cpVar, long j) {
        int i;
        long j2 = 0;
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        jad_jw jad_jwVar = this.jad_an;
        if (jad_jwVar == null) {
            return -1L;
        }
        long j3 = this.jad_bo;
        if (j3 - j < j) {
            while (j3 > j) {
                jad_jwVar = jad_jwVar.jad_jt;
                j3 -= jad_jwVar.jad_cp - jad_jwVar.jad_bo;
            }
        } else {
            while (true) {
                long j4 = (jad_jwVar.jad_cp - jad_jwVar.jad_bo) + j2;
                if (j4 >= j) {
                    break;
                }
                jad_jwVar = jad_jwVar.jad_fs;
                j2 = j4;
            }
            j3 = j2;
        }
        if (jad_cpVar.jad_cp() == 2) {
            byte jad_an = jad_cpVar.jad_an(0);
            byte jad_an2 = jad_cpVar.jad_an(1);
            while (j3 < this.jad_bo) {
                byte[] bArr = jad_jwVar.jad_an;
                i = (int) ((jad_jwVar.jad_bo + j) - j3);
                int i2 = jad_jwVar.jad_cp;
                while (i < i2) {
                    byte b = bArr[i];
                    if (b != jad_an && b != jad_an2) {
                        i++;
                    }
                    return (i - jad_jwVar.jad_bo) + j3;
                }
                j3 += jad_jwVar.jad_cp - jad_jwVar.jad_bo;
                jad_jwVar = jad_jwVar.jad_fs;
                j = j3;
            }
            return -1L;
        }
        byte[] jad_bo = jad_cpVar.jad_bo();
        while (j3 < this.jad_bo) {
            byte[] bArr2 = jad_jwVar.jad_an;
            i = (int) ((jad_jwVar.jad_bo + j) - j3);
            int i3 = jad_jwVar.jad_cp;
            while (i < i3) {
                byte b2 = bArr2[i];
                for (byte b3 : jad_bo) {
                    if (b2 == b3) {
                        return (i - jad_jwVar.jad_bo) + j3;
                    }
                }
                i++;
            }
            j3 += jad_jwVar.jad_cp - jad_jwVar.jad_bo;
            jad_jwVar = jad_jwVar.jad_fs;
            j = j3;
        }
        return -1L;
    }

    @Override // com.jd.ad.sdk.jad_zi.jad_bo
    public jad_an jad_an() {
        return this;
    }

    public jad_an jad_an(String str, int i, int i2) {
        char charAt;
        int i3;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        while (i < i2) {
            char charAt2 = str.charAt(i);
            if (charAt2 < 128) {
                jad_jw jad_an = jad_an(1);
                byte[] bArr = jad_an.jad_an;
                int i4 = jad_an.jad_cp - i;
                int min = Math.min(i2, 8192 - i4);
                int i5 = i + 1;
                bArr[i + i4] = (byte) charAt2;
                while (true) {
                    i = i5;
                    if (i >= min || (charAt = str.charAt(i)) >= 128) {
                        break;
                    }
                    i5 = i + 1;
                    bArr[i + i4] = (byte) charAt;
                }
                int i6 = jad_an.jad_cp;
                int i7 = (i4 + i) - i6;
                jad_an.jad_cp = i6 + i7;
                this.jad_bo += i7;
            } else {
                if (charAt2 < 2048) {
                    i3 = (charAt2 >> 6) | 192;
                } else if (charAt2 < 55296 || charAt2 > 57343) {
                    jad_bo((charAt2 >> '\f') | 224);
                    i3 = ((charAt2 >> 6) & 63) | 128;
                } else {
                    int i8 = i + 1;
                    char charAt3 = i8 < i2 ? str.charAt(i8) : (char) 0;
                    if (charAt2 > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                        jad_bo(63);
                        i = i8;
                    } else {
                        int i9 = (((charAt2 & 10239) << 10) | (9215 & charAt3)) + 65536;
                        jad_bo((i9 >> 18) | 240);
                        jad_bo(((i9 >> 12) & 63) | 128);
                        jad_bo(((i9 >> 6) & 63) | 128);
                        jad_bo((i9 & 63) | 128);
                        i += 2;
                    }
                }
                jad_bo(i3);
                jad_bo((charAt2 & '?') | 128);
                i++;
            }
        }
        return this;
    }

    public jad_jw jad_an(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        jad_jw jad_jwVar = this.jad_an;
        if (jad_jwVar != null) {
            jad_jw jad_jwVar2 = jad_jwVar.jad_jt;
            return (jad_jwVar2.jad_cp + i > 8192 || !jad_jwVar2.jad_er) ? jad_jwVar2.jad_an(jad_kx.jad_an()) : jad_jwVar2;
        }
        jad_jw jad_an = jad_kx.jad_an();
        this.jad_an = jad_an;
        jad_an.jad_jt = jad_an;
        jad_an.jad_fs = jad_an;
        return jad_an;
    }

    public String jad_an(long j, Charset charset) {
        jad_ob.jad_an(this.jad_bo, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return "";
        }
        jad_jw jad_jwVar = this.jad_an;
        int i = jad_jwVar.jad_bo;
        if (i + j > jad_jwVar.jad_cp) {
            return new String(jad_cp(j), charset);
        }
        String str = new String(jad_jwVar.jad_an, i, (int) j, charset);
        int i2 = (int) (jad_jwVar.jad_bo + j);
        jad_jwVar.jad_bo = i2;
        this.jad_bo -= j;
        if (i2 == jad_jwVar.jad_cp) {
            this.jad_an = jad_jwVar.jad_an();
            jad_kx.jad_an(jad_jwVar);
        }
        return str;
    }

    @Override // com.jd.ad.sdk.jad_zi.jad_bo
    public boolean jad_an(long j) {
        return this.jad_bo >= j;
    }
}
