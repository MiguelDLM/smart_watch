package com.jieli.jl_rcsp.interfaces.rcsp;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.model.base.CommandBase;

/* loaded from: classes8.dex */
public interface IRcspOp {
    void registerOnRcspCallback(OnRcspCallback onRcspCallback);

    void registerOnRcspEventListener(OnRcspEventListener onRcspEventListener);

    void release();

    <T extends CommandBase> void sendCommandAsync(BluetoothDevice bluetoothDevice, CommandBase commandBase, int i, RcspCommandCallback<T> rcspCommandCallback);

    <T extends CommandBase> void sendCommandResponse(BluetoothDevice bluetoothDevice, CommandBase commandBase, RcspCommandCallback<T> rcspCommandCallback);

    void switchConnectedDevice(BluetoothDevice bluetoothDevice);

    void unregisterOnRcspCallback(OnRcspCallback onRcspCallback);

    void unregisterOnRcspEventListener(OnRcspEventListener onRcspEventListener);
}
