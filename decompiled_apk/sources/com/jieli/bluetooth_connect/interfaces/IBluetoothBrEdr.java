package com.jieli.bluetooth_connect.interfaces;

import android.bluetooth.BluetoothDevice;
import com.jieli.bluetooth_connect.interfaces.listener.OnBrEdrListener;

/* loaded from: classes10.dex */
public interface IBluetoothBrEdr extends IBluetoothBase<OnBrEdrListener> {
    boolean connectBrEdrDevice(BluetoothDevice device);

    boolean connectByA2dp(BluetoothDevice device);

    boolean connectByHfp(BluetoothDevice device);

    boolean connectByProfiles(BluetoothDevice device);

    boolean disconnectByProfiles(BluetoothDevice device);

    boolean disconnectFromA2dp(BluetoothDevice device);

    boolean disconnectFromHfp(BluetoothDevice device);

    BluetoothDevice getActivityBluetoothDevice();

    BluetoothDevice getConnectingBrEdrDevice();

    boolean isBrEdrConnecting();

    int isConnectedByA2dp(BluetoothDevice device);

    int isConnectedByHfp(BluetoothDevice device);

    int isConnectedByProfile(BluetoothDevice device);

    boolean setActivityBluetoothDevice(BluetoothDevice device);
}
