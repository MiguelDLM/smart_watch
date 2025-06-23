package com.goodix.ble.libcomx.transceiver.buffer.ring;

/* loaded from: classes9.dex */
public interface IRingBufferMutable extends IRingBuffer {
    void drop(int i);

    void dropAll();

    int pop(int i, byte[] bArr);

    int put(byte[] bArr, int i, int i2);

    boolean put(byte b);
}
