package com.kwad.sdk.utils.a;

import androidx.work.WorkInfo;
import com.garmin.fit.OOxOOxIO;
import java.nio.charset.Charset;
import okio.Utf8;

/* loaded from: classes11.dex */
public final class b {
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    private char[] aSu;
    public byte[] aSv;
    public int position;

    public b(int i) {
        this(new byte[i], 0);
    }

    private int C(int i, int i2) {
        while ((i2 & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT) != 0) {
            this.aSv[i] = (byte) ((i2 & 127) | 128);
            i2 >>>= 7;
            i++;
        }
        int i3 = i + 1;
        this.aSv[i] = (byte) i2;
        return i3;
    }

    public static int ek(int i) {
        if ((i >> 7) == 0) {
            return 1;
        }
        if ((i >> 14) == 0) {
            return 2;
        }
        if ((i >> 21) == 0) {
            return 3;
        }
        return (i >> 28) == 0 ? 4 : 5;
    }

    private char[] em(int i) {
        char[] cArr = this.aSu;
        if (cArr == null) {
            if (i <= 256) {
                this.aSu = new char[256];
            } else {
                this.aSu = new char[2048];
            }
        } else if (cArr.length < i) {
            this.aSu = new char[2048];
        }
        return this.aSu;
    }

    private String en(int i) {
        if (i > 2048) {
            return new String(this.aSv, this.position, i, UTF_8);
        }
        char[] em = em(i);
        byte[] bArr = this.aSv;
        int i2 = this.position;
        int i3 = i + i2;
        int i4 = 0;
        while (i2 < i3) {
            int i5 = i2 + 1;
            byte b = bArr[i2];
            if (b > 0) {
                em[i4] = (char) (b ^ 1);
                i4++;
                i2 = i5;
            } else if (b < -32) {
                i2 += 2;
                em[i4] = (char) ((bArr[i5] & Utf8.REPLACEMENT_BYTE) | ((b & 31) << 6));
                i4++;
            } else if (b < -16) {
                int i6 = i2 + 2;
                byte b2 = bArr[i5];
                i2 += 3;
                byte b3 = bArr[i6];
                em[i4] = (char) (((b2 & Utf8.REPLACEMENT_BYTE) << 6) | ((b & 15) << 12) | (b3 & Utf8.REPLACEMENT_BYTE));
                i4++;
            } else {
                byte b4 = bArr[i5];
                int i7 = i2 + 3;
                byte b5 = bArr[i2 + 2];
                i2 += 4;
                byte b6 = bArr[i7];
                int i8 = ((b4 & Utf8.REPLACEMENT_BYTE) << 12) | ((b & 7) << 18) | ((b5 & Utf8.REPLACEMENT_BYTE) << 6) | (b6 & Utf8.REPLACEMENT_BYTE);
                int i9 = i4 + 1;
                em[i4] = (char) ((i8 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                i4 += 2;
                em[i9] = (char) ((i8 & 1023) + Utf8.LOG_SURROGATE_HEADER);
            }
        }
        if (i2 <= i3) {
            return new String(em, 0, i4);
        }
        throw new IllegalArgumentException("Invalid String");
    }

    private String eo(int i) {
        if (i > 2048) {
            return new String(this.aSv, this.position, i, UTF_8);
        }
        char[] em = em(i);
        byte[] bArr = this.aSv;
        int i2 = this.position;
        int i3 = i + i2;
        int i4 = 0;
        while (i2 < i3) {
            int i5 = i2 + 1;
            byte b = bArr[i2];
            if (b > 0) {
                em[i4] = (char) b;
                i4++;
                i2 = i5;
            } else if (b < -32) {
                i2 += 2;
                em[i4] = (char) ((bArr[i5] & Utf8.REPLACEMENT_BYTE) | ((b & 31) << 6));
                i4++;
            } else if (b < -16) {
                int i6 = i2 + 2;
                byte b2 = bArr[i5];
                i2 += 3;
                byte b3 = bArr[i6];
                em[i4] = (char) (((b2 & Utf8.REPLACEMENT_BYTE) << 6) | ((b & 15) << 12) | (b3 & Utf8.REPLACEMENT_BYTE));
                i4++;
            } else {
                byte b4 = bArr[i5];
                int i7 = i2 + 3;
                byte b5 = bArr[i2 + 2];
                i2 += 4;
                byte b6 = bArr[i7];
                int i8 = ((b4 & Utf8.REPLACEMENT_BYTE) << 12) | ((b & 7) << 18) | ((b5 & Utf8.REPLACEMENT_BYTE) << 6) | (b6 & Utf8.REPLACEMENT_BYTE);
                int i9 = i4 + 1;
                em[i4] = (char) ((i8 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                i4 += 2;
                em[i9] = (char) ((i8 & 1023) + Utf8.LOG_SURROGATE_HEADER);
            }
        }
        if (i2 <= i3) {
            return new String(em, 0, i4);
        }
        throw new IllegalArgumentException("Invalid String");
    }

    private long getLong(int i) {
        byte[] bArr = this.aSv;
        int i2 = i + 6;
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i2] & 255) << 48) | (bArr[i + 7] << 56);
    }

    public static int hn(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            char charAt = str.charAt(i);
            if (charAt < 128) {
                i2++;
            } else if (charAt < 2048) {
                i2 += 2;
            } else if (charAt >= 55296 && charAt <= 57343) {
                i += 2;
                i2 += 4;
            } else {
                i2 += 3;
            }
            i = i3;
        }
        return i2;
    }

    private void ho(String str) {
        byte[] bArr = this.aSv;
        int i = this.position;
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            char charAt = str.charAt(i2);
            if (charAt < 128) {
                bArr[i] = (byte) (charAt ^ 1);
                i++;
            } else if (charAt < 2048) {
                int i4 = i + 1;
                bArr[i] = (byte) ((charAt >>> 6) | 192);
                i += 2;
                bArr[i4] = (byte) ((charAt & '?') | 128);
            } else if (charAt >= 55296 && charAt <= 57343) {
                i2 += 2;
                int charAt2 = ((charAt << '\n') + str.charAt(i3)) - 56613888;
                bArr[i] = (byte) ((charAt2 >>> 18) | 240);
                bArr[i + 1] = (byte) (((charAt2 >>> 12) & 63) | 128);
                int i5 = i + 3;
                bArr[i + 2] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i += 4;
                bArr[i5] = (byte) ((charAt2 & 63) | 128);
            } else {
                bArr[i] = (byte) ((charAt >>> '\f') | 224);
                int i6 = i + 2;
                bArr[i + 1] = (byte) (((charAt >>> 6) & 63) | 128);
                i += 3;
                bArr[i6] = (byte) ((charAt & '?') | 128);
            }
            i2 = i3;
        }
        this.position = i;
    }

    public static byte[] hp(String str) {
        byte[] bArr = new byte[hn(str)];
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            char charAt = str.charAt(i);
            if (charAt < 128) {
                bArr[i2] = (byte) (charAt ^ 1);
                i2++;
            } else if (charAt < 2048) {
                int i4 = i2 + 1;
                bArr[i2] = (byte) ((charAt >>> 6) | 192);
                i2 += 2;
                bArr[i4] = (byte) ((charAt & '?') | 128);
            } else if (charAt >= 55296 && charAt <= 57343) {
                i += 2;
                int charAt2 = ((charAt << '\n') + str.charAt(i3)) - 56613888;
                bArr[i2] = (byte) ((charAt2 >>> 18) | 240);
                bArr[i2 + 1] = (byte) (((charAt2 >>> 12) & 63) | 128);
                int i5 = i2 + 3;
                bArr[i2 + 2] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i2 += 4;
                bArr[i5] = (byte) ((charAt2 & 63) | 128);
            } else {
                bArr[i2] = (byte) ((charAt >>> '\f') | 224);
                int i6 = i2 + 2;
                bArr[i2 + 1] = (byte) (((charAt >>> 6) & 63) | 128);
                i2 += 3;
                bArr[i6] = (byte) ((charAt & '?') | 128);
            }
            i = i3;
        }
        return bArr;
    }

    public static String j(byte[] bArr, int i) {
        char[] cArr = new char[bArr.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b > 0) {
                cArr[i3] = (char) (b ^ 1);
                i3++;
                i2 = i4;
            } else if (b < -32) {
                i2 += 2;
                cArr[i3] = (char) ((bArr[i4] & Utf8.REPLACEMENT_BYTE) | ((b & 31) << 6));
                i3++;
            } else if (b < -16) {
                int i5 = i2 + 2;
                byte b2 = bArr[i4];
                i2 += 3;
                byte b3 = bArr[i5];
                cArr[i3] = (char) (((b2 & Utf8.REPLACEMENT_BYTE) << 6) | ((b & 15) << 12) | (b3 & Utf8.REPLACEMENT_BYTE));
                i3++;
            } else {
                byte b4 = bArr[i4];
                int i6 = i2 + 3;
                byte b5 = bArr[i2 + 2];
                i2 += 4;
                byte b6 = bArr[i6];
                int i7 = ((b4 & Utf8.REPLACEMENT_BYTE) << 12) | ((b & 7) << 18) | ((b5 & Utf8.REPLACEMENT_BYTE) << 6) | (b6 & Utf8.REPLACEMENT_BYTE);
                int i8 = i3 + 1;
                cArr[i3] = (char) ((i7 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                i3 += 2;
                cArr[i8] = (char) ((i7 & 1023) + Utf8.LOG_SURROGATE_HEADER);
            }
        }
        if (i2 <= i) {
            return new String(cArr, 0, i3);
        }
        throw new IllegalArgumentException("Invalid String");
    }

    public final void B(int i, int i2) {
        byte[] bArr = this.aSv;
        bArr[i] = (byte) i2;
        bArr[i + 1] = (byte) (i2 >> 8);
        bArr[i + 2] = (byte) (i2 >> 16);
        bArr[i + 3] = (byte) (i2 >> 24);
    }

    public final long D(int i, int i2) {
        long j = 0;
        if (i2 <= 0) {
            return 0L;
        }
        int i3 = i2 >> 3;
        int i4 = i2 & 7;
        int i5 = 0;
        int i6 = i;
        for (int i7 = 0; i7 < i3; i7++) {
            j ^= getLong(i6);
            i6 += 8;
        }
        while (i5 < (i4 << 3)) {
            j ^= (this.aSv[i6] & 255) << i5;
            i5 += 8;
            i6++;
        }
        int i8 = (i & 7) << 3;
        return (j >>> (64 - i8)) | (j << i8);
    }

    public final int Of() {
        byte[] bArr = this.aSv;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        byte b = bArr[i];
        if ((b >> 7) == 0) {
            return b;
        }
        int i3 = i + 2;
        this.position = i3;
        int i4 = (bArr[i2] << 7) | (b & Byte.MAX_VALUE);
        if ((i4 >> 14) == 0) {
            return i4;
        }
        int i5 = i4 & OOxOOxIO.f12624oIX0oI;
        int i6 = i + 3;
        this.position = i6;
        int i7 = i5 | (bArr[i3] << 14);
        if ((i7 >> 21) == 0) {
            return i7;
        }
        int i8 = i + 4;
        this.position = i8;
        int i9 = (i7 & 2097151) | (bArr[i6] << 21);
        if ((i9 >> 28) == 0) {
            return i9;
        }
        this.position = i + 5;
        return (bArr[i8] << 28) | (i9 & 268435455);
    }

    public final void a(short s) {
        byte[] bArr = this.aSv;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        bArr[i] = (byte) s;
        this.position = i + 2;
        bArr[i2] = (byte) (s >> 8);
    }

    public final void aO(long j) {
        f(this.position, j);
        this.position += 8;
    }

    public final void e(byte b) {
        byte[] bArr = this.aSv;
        int i = this.position;
        this.position = i + 1;
        bArr[i] = b;
    }

    public final void ei(int i) {
        byte[] bArr = this.aSv;
        int i2 = this.position;
        int i3 = i2 + 1;
        this.position = i3;
        bArr[i2] = (byte) i;
        int i4 = i2 + 2;
        this.position = i4;
        bArr[i3] = (byte) (i >> 8);
        int i5 = i2 + 3;
        this.position = i5;
        bArr[i4] = (byte) (i >> 16);
        this.position = i2 + 4;
        bArr[i5] = (byte) (i >> 24);
    }

    public final void ej(int i) {
        this.position = C(this.position, i);
    }

    public final String el(int i) {
        if (i < 0) {
            return null;
        }
        if (i == 0) {
            return "";
        }
        String eo = eo(i);
        this.position += i;
        return eo;
    }

    public final void f(int i, long j) {
        byte[] bArr = this.aSv;
        bArr[i] = (byte) j;
        bArr[i + 1] = (byte) (j >> 8);
        bArr[i + 2] = (byte) (j >> 16);
        bArr[i + 3] = (byte) (j >> 24);
        bArr[i + 4] = (byte) (j >> 32);
        bArr[i + 5] = (byte) (j >> 40);
        bArr[i + 6] = (byte) (j >> 48);
        bArr[i + 7] = (byte) (j >> 56);
    }

    public final byte get() {
        byte[] bArr = this.aSv;
        int i = this.position;
        this.position = i + 1;
        return bArr[i];
    }

    public final byte[] getBytes(int i) {
        byte[] bArr = new byte[i];
        System.arraycopy(this.aSv, this.position, bArr, 0, i);
        this.position += i;
        return bArr;
    }

    public final double getDouble() {
        return Double.longBitsToDouble(getLong());
    }

    public final float getFloat() {
        return Float.intBitsToFloat(getInt());
    }

    public final int getInt() {
        byte[] bArr = this.aSv;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = bArr[i] & 255;
        int i4 = i + 2;
        this.position = i4;
        int i5 = ((bArr[i2] & 255) << 8) | i3;
        int i6 = i + 3;
        this.position = i6;
        int i7 = i5 | ((bArr[i4] & 255) << 16);
        this.position = i + 4;
        return (bArr[i6] << 24) | i7;
    }

    public final short getShort() {
        byte[] bArr = this.aSv;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = bArr[i] & 255;
        this.position = i + 2;
        return (short) ((bArr[i2] << 8) | i3);
    }

    public final String getString(int i) {
        if (i < 0) {
            return null;
        }
        if (i == 0) {
            return "";
        }
        String en = en(i);
        this.position += i;
        return en;
    }

    public final void hm(String str) {
        if (str != null && !str.isEmpty()) {
            ho(str);
        }
    }

    public final void n(byte[] bArr) {
        int length = bArr.length;
        if (length > 0) {
            System.arraycopy(bArr, 0, this.aSv, this.position, length);
            this.position += length;
        }
    }

    public b(byte[] bArr) {
        this(bArr, 0);
    }

    public final long getLong() {
        long j = getLong(this.position);
        this.position += 8;
        return j;
    }

    public b(byte[] bArr, int i) {
        this.aSu = null;
        this.aSv = bArr;
        this.position = i;
    }
}
