package com.jieli.watchtesttool.tool.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import com.jieli.bluetooth_connect.bean.ErrorInfo;
import com.jieli.bluetooth_connect.bean.ble.BleScanMessage;

/* loaded from: classes10.dex */
public abstract class BluetoothEventListener {
    public void onAdapterStatus(boolean z) {
    }

    public void onBleMtuChange(BluetoothGatt bluetoothGatt, int i, int i2) {
    }

    public void onBtDiscovery(BluetoothDevice bluetoothDevice, BleScanMessage bleScanMessage) {
    }

    public void onBtDiscoveryStatus(boolean z, boolean z2) {
    }

    public void onConnection(BluetoothDevice bluetoothDevice, int i) {
    }

    public void onError(ErrorInfo errorInfo) {
    }

    public void onReceiveData(BluetoothDevice bluetoothDevice, byte[] bArr) {
    }

    public void onShowDialog(BluetoothDevice bluetoothDevice, BleScanMessage bleScanMessage) {
    }

    public void onSwitchConnectedDevice(BluetoothDevice bluetoothDevice) {
    }
}
