package com.jieli.bluetooth_connect.interfaces;

import android.bluetooth.BluetoothDevice;
import androidx.annotation.IntRange;
import com.jieli.bluetooth_connect.interfaces.listener.OnBtDevicePairListener;
import java.util.List;

/* loaded from: classes10.dex */
public interface IBluetoothPair extends IBluetoothBase<OnBtDevicePairListener> {
    List<BluetoothDevice> getPairedDevices();

    boolean isPaired(BluetoothDevice device);

    boolean isPairing(BluetoothDevice device);

    boolean pair(BluetoothDevice device);

    boolean pair(BluetoothDevice device, @IntRange(from = 0, to = 2) int pairWay);

    boolean tryToPair(BluetoothDevice device);

    boolean tryToPair(BluetoothDevice device, @IntRange(from = 0, to = 2) int pairWay);

    boolean tryToUnPair(BluetoothDevice device);

    boolean unPair(BluetoothDevice device);
}
