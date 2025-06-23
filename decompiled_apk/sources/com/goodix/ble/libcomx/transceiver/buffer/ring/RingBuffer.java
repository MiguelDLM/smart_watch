package com.goodix.ble.libcomx.transceiver.buffer.ring;

/* loaded from: classes9.dex */
public class RingBuffer implements IRingBufferMutable {
    private byte[] buffer;
    private int readPos;
    private int writePos;

    public RingBuffer(int i) {
        this.buffer = new byte[i];
    }

    @Override // com.goodix.ble.libcomx.transceiver.buffer.ring.IRingBufferMutable
    public void drop(int i) {
        int i2 = this.writePos;
        int i3 = this.readPos;
        int i4 = i2 - i3;
        if (i4 < 0) {
            byte[] bArr = this.buffer;
            if (i < bArr.length + i4) {
                this.readPos = (i3 + i) % bArr.length;
                return;
            } else {
                this.readPos = i2;
                return;
            }
        }
        if (i < i4) {
            this.readPos = i3 + i;
        } else {
            this.readPos = i2;
        }
    }

    @Override // com.goodix.ble.libcomx.transceiver.buffer.ring.IRingBufferMutable
    public void dropAll() {
        this.readPos = this.writePos;
    }

    @Override // com.goodix.ble.libcomx.transceiver.buffer.ring.IRingBuffer
    public int get(int i) {
        int i2 = i + this.readPos;
        byte[] bArr = this.buffer;
        if (i2 >= bArr.length) {
            i2 %= bArr.length;
        }
        return bArr[i2] & 255;
    }

    @Override // com.goodix.ble.libcomx.transceiver.buffer.ring.IRingBuffer
    public int getFreeSize() {
        int length = (this.buffer.length - getSize()) - 1;
        if (length < 0) {
            return 0;
        }
        return length;
    }

    @Override // com.goodix.ble.libcomx.transceiver.buffer.ring.IRingBuffer
    public int getIntValue(int i, int i2, boolean z) {
        int size = getSize();
        if (size <= 0) {
            return 0;
        }
        if (i > size) {
            i %= size;
        }
        int i3 = i + this.readPos;
        if (i2 > 4) {
            i2 = 4;
        }
        if (size > i2) {
            size = i2;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            int i6 = i3 + i5;
            byte[] bArr = this.buffer;
            if (i6 >= bArr.length) {
                i6 -= bArr.length;
            }
            i4 = (i4 << 8) | (bArr[i6] & 255);
        }
        if (!z) {
            int i7 = 0;
            for (int i8 = 0; i8 < size; i8++) {
                i7 = (i7 << 8) | (i4 & 255);
                i4 >>= 8;
            }
            return i7;
        }
        return i4;
    }

    @Override // com.goodix.ble.libcomx.transceiver.buffer.ring.IRingBuffer
    public int getReadPos() {
        return this.readPos;
    }

    @Override // com.goodix.ble.libcomx.transceiver.buffer.ring.IRingBuffer
    public int getSize() {
        int i = this.writePos - this.readPos;
        if (i < 0) {
            return i + this.buffer.length;
        }
        return i;
    }

    @Override // com.goodix.ble.libcomx.transceiver.buffer.ring.IRingBuffer
    public int getWritePos() {
        return this.writePos;
    }

    @Override // com.goodix.ble.libcomx.transceiver.buffer.ring.IRingBufferMutable
    public int pop(int i, byte[] bArr) {
        int i2 = get(i, bArr);
        drop(i + i2);
        return i2;
    }

    @Override // com.goodix.ble.libcomx.transceiver.buffer.ring.IRingBufferMutable
    public int put(byte[] bArr, int i, int i2) {
        int length;
        int i3 = 0;
        if (bArr == null || (this.buffer.length - getSize()) - 1 <= 0) {
            return 0;
        }
        if (i2 <= 0) {
            i2 = bArr.length;
        }
        if (i2 <= length) {
            length = i2;
        }
        while (i3 < length) {
            put(bArr[i]);
            i3++;
            i++;
        }
        return length;
    }

    @Override // com.goodix.ble.libcomx.transceiver.buffer.ring.IRingBufferMutable
    public boolean put(byte b) {
        int i = this.writePos;
        int i2 = i + 1;
        byte[] bArr = this.buffer;
        if (i2 >= bArr.length) {
            i2 -= bArr.length;
        }
        if (i2 == this.readPos) {
            return false;
        }
        bArr[i] = b;
        this.writePos = i2;
        return true;
    }

    @Override // com.goodix.ble.libcomx.transceiver.buffer.ring.IRingBuffer
    public int get(int i, byte[] bArr) {
        int size;
        if (bArr == null || (size = getSize()) <= 0) {
            return 0;
        }
        if (i > size) {
            i %= size;
        }
        int i2 = i + this.readPos;
        if (size > bArr.length) {
            size = bArr.length;
        }
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = i2 + i3;
            byte[] bArr2 = this.buffer;
            if (i4 >= bArr2.length) {
                i4 -= bArr2.length;
            }
            bArr[i3] = bArr2[i4];
        }
        return size;
    }
}
