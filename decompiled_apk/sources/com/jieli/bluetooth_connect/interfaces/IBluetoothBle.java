package com.jieli.bluetooth_connect.interfaces;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import com.jieli.bluetooth_connect.interfaces.listener.OnBtBleListener;
import com.jieli.bluetooth_connect.interfaces.listener.OnWriteDataCallback;
import java.util.List;
import java.util.UUID;

/* loaded from: classes10.dex */
public interface IBluetoothBle extends IBluetoothBase<OnBtBleListener> {
    boolean connectBLEDevice(BluetoothDevice device);

    boolean disconnectBLEDevice(BluetoothDevice device);

    int getBleMtu(BluetoothDevice device);

    BluetoothDevice getConnectedBleDevice();

    List<BluetoothDevice> getConnectedBleDevices();

    BluetoothDevice getConnectingBleDevice();

    BluetoothGatt getDeviceGatt(BluetoothDevice device);

    boolean isBleConnecting();

    boolean isConnectedBleDevice(BluetoothDevice device);

    boolean requestBleMtu(BluetoothDevice device, int mtu);

    void setConnectedBleDevice(BluetoothDevice device);

    void writeDataByBleAsync(BluetoothDevice device, UUID serviceUUID, UUID characteristicUUID, byte[] data, OnWriteDataCallback callback);

    boolean writeDataByBleSync(BluetoothDevice device, UUID serviceUUID, UUID characteristicUUID, byte[] data);
}
