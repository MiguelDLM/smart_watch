package com.goodix.ble.libcomx.util;

import java.nio.charset.Charset;

/* loaded from: classes9.dex */
public class HexReader extends AbstractHexBuffer {
    public HexReader(byte[] bArr) {
        setBuffer(bArr);
    }

    public int get(int i) {
        return get(i, this.bigEndian);
    }

    public long getLong(int i, boolean z) {
        int i2 = this.pos;
        if (i2 + i > this.posEnd) {
            return 0L;
        }
        long fromByteLong = HexEndian.fromByteLong(this.buffer, i2, i, z);
        this.pos += i;
        return fromByteLong;
    }

    public String getString(Charset charset, int i) {
        int i2 = this.pos;
        int i3 = i2 + i;
        int i4 = this.posEnd;
        if (i3 > i4) {
            i = i4 - i2;
        }
        String str = new String(this.buffer, i2, i, charset);
        this.pos += i;
        return str;
    }

    public int get(int i, boolean z) {
        int i2 = this.pos;
        if (i2 + i > this.posEnd) {
            return 0;
        }
        int fromByte = HexEndian.fromByte(this.buffer, i2, i, z);
        this.pos += i;
        return fromByte;
    }

    public void get(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = this.pos;
                byte[] bArr2 = this.buffer;
                if (i4 >= bArr2.length || i >= bArr.length) {
                    return;
                }
                bArr[i] = bArr2[i4];
                this.pos = i4 + 1;
                i++;
            }
        }
    }

    public void get(byte[] bArr) {
        if (bArr != null) {
            get(bArr, 0, bArr.length);
        }
    }
}
