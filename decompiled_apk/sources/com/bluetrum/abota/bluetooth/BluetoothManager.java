package com.bluetrum.abota.bluetooth;

/* loaded from: classes8.dex */
public interface BluetoothManager {
    void close();

    boolean isReady();

    void open();

    void send(byte[] bArr);

    void setEventListener(BluetoothEventListener bluetoothEventListener);
}
