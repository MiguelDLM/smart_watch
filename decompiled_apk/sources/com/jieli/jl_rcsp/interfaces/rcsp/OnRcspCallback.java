package com.jieli.jl_rcsp.interfaces.rcsp;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.base.CommandBase;

/* loaded from: classes8.dex */
public abstract class OnRcspCallback {
    public void onConnectStateChange(BluetoothDevice bluetoothDevice, int i) {
    }

    public void onMandatoryUpgrade(BluetoothDevice bluetoothDevice) {
    }

    public void onPutDataToDataHandler(BluetoothDevice bluetoothDevice, byte[] bArr) {
    }

    public void onRcspCommand(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
    }

    public void onRcspDataCmd(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
    }

    public void onRcspError(BluetoothDevice bluetoothDevice, BaseError baseError) {
    }

    public void onRcspInit(BluetoothDevice bluetoothDevice, boolean z) {
    }

    public void onSwitchConnectedDevice(BluetoothDevice bluetoothDevice) {
    }
}
