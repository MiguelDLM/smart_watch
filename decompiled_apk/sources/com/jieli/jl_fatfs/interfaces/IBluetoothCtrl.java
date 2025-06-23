package com.jieli.jl_fatfs.interfaces;

import android.bluetooth.BluetoothDevice;

/* loaded from: classes10.dex */
public interface IBluetoothCtrl {
    BluetoothDevice getConnectedDevice();

    void readFatDataFromDevice(BluetoothDevice bluetoothDevice, int i, int i2);

    void release();

    void sendWriteFlag(BluetoothDevice bluetoothDevice, boolean z);

    void writeFatDataToDevice(BluetoothDevice bluetoothDevice, int i, byte[] bArr);
}
