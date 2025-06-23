package com.jieli.bluetooth_connect.interfaces;

import android.bluetooth.BluetoothDevice;
import com.jieli.bluetooth_connect.interfaces.listener.OnBtDiscoveryListener;
import java.util.ArrayList;

/* loaded from: classes10.dex */
public interface IBluetoothDiscovery extends IBluetoothBase<OnBtDiscoveryListener> {
    ArrayList<BluetoothDevice> getDiscoveredBluetoothDevices();

    int getScanType();

    boolean isBleScanning();

    boolean isDeviceScanning();

    boolean isScanning();

    boolean startBLEScan(long timeout);

    boolean startDeviceScan(int type, long timeout);

    boolean startDeviceScan(long timeout);

    boolean stopBLEScan();

    boolean stopDeviceScan();
}
