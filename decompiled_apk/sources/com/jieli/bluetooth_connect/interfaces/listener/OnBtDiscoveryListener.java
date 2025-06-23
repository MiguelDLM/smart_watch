package com.jieli.bluetooth_connect.interfaces.listener;

import android.bluetooth.BluetoothDevice;
import com.jieli.bluetooth_connect.bean.ErrorInfo;
import com.jieli.bluetooth_connect.bean.ble.BleScanMessage;

/* loaded from: classes10.dex */
public interface OnBtDiscoveryListener {
    void onDiscoveryDevice(BluetoothDevice device, BleScanMessage bleScanMessage);

    void onDiscoveryError(ErrorInfo error);

    void onDiscoveryStatusChange(boolean isBle, boolean bStart);

    void onShowProductDialog(BluetoothDevice device, BleScanMessage bleScanMessage);
}
