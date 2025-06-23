package com.jieli.bluetooth_connect.interfaces.listener;

import android.bluetooth.BluetoothDevice;
import java.util.UUID;

/* loaded from: classes10.dex */
public interface OnBtSppListener {
    void onSppConnection(BluetoothDevice device, UUID uuid, int status);

    void onSppDataNotify(BluetoothDevice device, UUID sppUUID, byte[] data);

    void onSwitchSppDevice(BluetoothDevice device);
}
