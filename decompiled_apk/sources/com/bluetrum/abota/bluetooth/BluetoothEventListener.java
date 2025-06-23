package com.bluetrum.abota.bluetooth;

import android.bluetooth.BluetoothGatt;

/* loaded from: classes8.dex */
public interface BluetoothEventListener {
    void onBluetoothReady();

    void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2);

    void onReceive(byte[] bArr);

    void onSend(byte[] bArr);
}
