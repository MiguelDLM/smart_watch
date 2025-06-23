package com.goodix.ble.libcomx.transceiver.buffer.ring;

/* loaded from: classes9.dex */
public interface IRingBuffer {
    int get(int i);

    int get(int i, byte[] bArr);

    int getFreeSize();

    int getIntValue(int i, int i2, boolean z);

    int getReadPos();

    int getSize();

    int getWritePos();
}
