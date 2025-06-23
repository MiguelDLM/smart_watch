package com.jieli.bluetooth_connect.interfaces;

import android.bluetooth.BluetoothDevice;
import com.jieli.bluetooth_connect.interfaces.listener.OnBtSppListener;
import java.util.List;

/* loaded from: classes10.dex */
public interface IBluetoothSpp extends IBluetoothBase<OnBtSppListener> {
    boolean connectSPPDevice(BluetoothDevice device);

    boolean disconnectSPPDevice(BluetoothDevice device);

    BluetoothDevice getConnectedSPPDevice();

    List<BluetoothDevice> getConnectedSppDevices();

    BluetoothDevice getSppConnectingDevice();

    boolean isConnectedSppDevice(BluetoothDevice device);

    boolean isSppConnecting();

    void setConnectedSppDevice(BluetoothDevice device);

    void setConnectingSppDevice(BluetoothDevice connectingSppDevice);

    boolean writeDataToSppDevice(BluetoothDevice device, byte[] data);
}
