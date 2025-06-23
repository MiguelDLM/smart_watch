package com.jieli.jl_rcsp.interfaces.bluetooth;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.base.BasePacket;

/* loaded from: classes8.dex */
public interface IBluetoothProxy {
    <E extends BaseError> void callbackErrorEvent(E e);

    BluetoothDevice getConnectedDevice();

    boolean isDeviceConnected(BluetoothDevice bluetoothDevice);

    void notifyBtDeviceConnection(BluetoothDevice bluetoothDevice, int i);

    void notifyReceiveDeviceData(BluetoothDevice bluetoothDevice, byte[] bArr);

    void receiveDataFromDevice(BluetoothDevice bluetoothDevice, BasePacket basePacket);

    boolean sendDataToDevice(BluetoothDevice bluetoothDevice, byte[] bArr);

    void setCmdSnGenerator(CmdSnGenerator cmdSnGenerator);
}
