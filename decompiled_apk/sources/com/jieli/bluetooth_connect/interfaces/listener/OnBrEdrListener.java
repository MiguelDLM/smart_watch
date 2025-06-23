package com.jieli.bluetooth_connect.interfaces.listener;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.os.ParcelUuid;

/* loaded from: classes10.dex */
public interface OnBrEdrListener {
    void onA2dpStatus(BluetoothDevice device, int status);

    void onBrEdrConnection(BluetoothDevice device, int status);

    void onDeviceUuids(BluetoothDevice device, ParcelUuid[] uuids);

    void onEdrService(boolean isConnected, int profile, BluetoothProfile proxy);

    void onHfpStatus(BluetoothDevice device, int status);
}
