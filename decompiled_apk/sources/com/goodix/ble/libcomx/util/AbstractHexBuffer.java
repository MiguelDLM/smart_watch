package com.goodix.ble.libcomx.util;

/* loaded from: classes9.dex */
public abstract class AbstractHexBuffer {
    protected boolean bigEndian = false;
    protected byte[] buffer;
    protected int pos;
    protected int posEnd;
    protected int posStart;

    public byte[] getBuffer() {
        return this.buffer;
    }

    public int getPos() {
        return this.pos - this.posStart;
    }

    public int getRemainSize() {
        return this.posEnd - this.pos;
    }

    public void setBuffer(byte[] bArr) {
        this.buffer = bArr;
        this.pos = 0;
        setRange(0, bArr.length);
    }

    public void setEndian(boolean z) {
        this.bigEndian = z;
    }

    public void setPos(int i) {
        int i2 = this.posStart;
        int i3 = i + i2;
        this.pos = i3;
        if (i3 < i2) {
            this.pos = i2;
        }
        int i4 = this.pos;
        int i5 = this.posEnd;
        if (i4 > i5) {
            this.pos = i5;
        }
    }

    public void setRange(int i, int i2) {
        if (this.pos < i) {
            this.pos = i;
        }
        this.posStart = i;
        int i3 = i + i2;
        this.posEnd = i3;
        byte[] bArr = this.buffer;
        if (i3 > bArr.length) {
            this.posEnd = bArr.length;
        }
    }
}
