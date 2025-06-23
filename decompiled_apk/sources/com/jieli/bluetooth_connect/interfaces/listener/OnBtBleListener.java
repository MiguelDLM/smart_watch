package com.jieli.bluetooth_connect.interfaces.listener;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import java.util.UUID;

/* loaded from: classes10.dex */
public abstract class OnBtBleListener extends BluetoothGattCallback {
    public abstract void onBleBond(BluetoothDevice device, int bondStatus);

    public abstract void onBleConnection(BluetoothDevice device, int status);

    public abstract void onBleDataNotify(BluetoothDevice device, UUID serviceUuid, UUID characteristicsUuid, byte[] data);

    public abstract void onBleMtuChanged(BluetoothDevice device, int block, int status);

    public abstract void onBleNotificationStatus(BluetoothDevice device, UUID serviceUuid, UUID characteristicUuid, boolean bEnabled);

    public abstract void onBleWriteStatus(BluetoothDevice device, UUID serviceUuid, UUID characteristicsUuid, byte[] data, int status);

    public abstract void onConnectionUpdatedCallback(BluetoothGatt gatt, int interval, int latency, int timeout, int status);

    public abstract void onSwitchBleDevice(BluetoothDevice device);
}
