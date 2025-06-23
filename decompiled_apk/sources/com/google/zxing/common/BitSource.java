package com.google.zxing.common;

/* loaded from: classes10.dex */
public final class BitSource {
    private int bitOffset;
    private int byteOffset;
    private final byte[] bytes;

    public BitSource(byte[] bArr) {
        this.bytes = bArr;
    }

    public int available() {
        return ((this.bytes.length - this.byteOffset) * 8) - this.bitOffset;
    }

    public int getBitOffset() {
        return this.bitOffset;
    }

    public int getByteOffset() {
        return this.byteOffset;
    }

    public int readBits(int i) {
        int i2;
        if (i > 0 && i <= 32 && i <= available()) {
            int i3 = this.bitOffset;
            int i4 = 0;
            if (i3 > 0) {
                int i5 = 8 - i3;
                if (i < i5) {
                    i2 = i;
                } else {
                    i2 = i5;
                }
                int i6 = i5 - i2;
                byte[] bArr = this.bytes;
                int i7 = this.byteOffset;
                int i8 = (((255 >> (8 - i2)) << i6) & bArr[i7]) >> i6;
                i -= i2;
                int i9 = i3 + i2;
                this.bitOffset = i9;
                if (i9 == 8) {
                    this.bitOffset = 0;
                    this.byteOffset = i7 + 1;
                }
                i4 = i8;
            }
            if (i > 0) {
                while (i >= 8) {
                    int i10 = i4 << 8;
                    byte[] bArr2 = this.bytes;
                    int i11 = this.byteOffset;
                    i4 = (bArr2[i11] & 255) | i10;
                    this.byteOffset = i11 + 1;
                    i -= 8;
                }
                if (i > 0) {
                    int i12 = 8 - i;
                    int i13 = (i4 << i) | ((((255 >> i12) << i12) & this.bytes[this.byteOffset]) >> i12);
                    this.bitOffset += i;
                    return i13;
                }
                return i4;
            }
            return i4;
        }
        throw new IllegalArgumentException(String.valueOf(i));
    }
}
