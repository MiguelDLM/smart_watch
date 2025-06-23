package com.goodix.ble.libcomx.util;

/* loaded from: classes9.dex */
public class HexBuilder extends AbstractHexBuffer {
    public HexBuilder(int i) {
        setBuffer(new byte[i < 0 ? 0 : i]);
    }

    public int peek(int i) {
        int i2 = i + this.posStart;
        if (i2 < this.posEnd) {
            return this.buffer[i2] & 255;
        }
        return 0;
    }

    public HexBuilder put(int i, int i2) {
        return put(i, i2, this.bigEndian);
    }

    public HexBuilder putLong(long j, int i, boolean z) {
        int i2 = this.pos;
        if (i2 + i <= this.posEnd) {
            HexEndian.toByteLong(j, this.buffer, i2, i, z);
            this.pos += i;
            return this;
        }
        throw new IllegalStateException("buffer is to small. pos = [" + this.pos + "], size = [" + i + "]");
    }

    public HexBuilder put(int i, int i2, boolean z) {
        int i3 = this.pos;
        if (i3 + i2 <= this.posEnd) {
            HexEndian.toByte(i, this.buffer, i3, i2, z);
            this.pos += i2;
            return this;
        }
        throw new IllegalStateException("buffer is to small. pos = [" + this.pos + "], size = [" + i2 + "]");
    }

    public HexBuilder put(byte[] bArr) {
        return bArr != null ? put(bArr, 0, bArr.length) : this;
    }

    public HexBuilder put(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            if (this.pos + i2 > this.posEnd) {
                throw new IllegalStateException("buffer is to small. pos = [" + i + "], size = [" + i2 + "]");
            }
            for (int i3 = 0; i3 < i2; i3++) {
                byte[] bArr2 = this.buffer;
                int i4 = this.pos;
                bArr2[i4] = bArr[i];
                this.pos = i4 + 1;
                i++;
            }
        }
        return this;
    }
}
