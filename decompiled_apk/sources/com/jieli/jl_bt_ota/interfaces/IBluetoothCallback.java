package com.jieli.jl_bt_ota.interfaces;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_bt_ota.model.BleScanMessage;
import com.jieli.jl_bt_ota.model.base.BaseError;
import com.jieli.jl_bt_ota.model.base.CommandBase;

/* loaded from: classes10.dex */
public interface IBluetoothCallback {
    void onA2dpStatus(BluetoothDevice bluetoothDevice, int i);

    void onAdapterStatus(boolean z, boolean z2);

    void onBleDataBlockChanged(BluetoothDevice bluetoothDevice, int i, int i2);

    void onBtDeviceConnection(BluetoothDevice bluetoothDevice, int i);

    void onConnection(BluetoothDevice bluetoothDevice, int i);

    void onDiscovery(BluetoothDevice bluetoothDevice, BleScanMessage bleScanMessage);

    void onDiscoveryStatus(boolean z, boolean z2);

    void onError(BaseError baseError);

    void onHfpStatus(BluetoothDevice bluetoothDevice, int i);

    void onMandatoryUpgrade(BluetoothDevice bluetoothDevice);

    void onReceiveCommand(BluetoothDevice bluetoothDevice, CommandBase commandBase);
}
