package com.realsil.sdk.core.bluetooth;

import android.bluetooth.BluetoothDevice;

/* loaded from: classes11.dex */
public abstract class BluetoothProfileCallback {
    public void onA2dpPlayingStateChanged(BluetoothDevice bluetoothDevice, int i) {
    }

    public void onA2dpStateChanged(BluetoothDevice bluetoothDevice, int i) {
    }

    public void onHfpAudioStateChanged(BluetoothDevice bluetoothDevice, int i) {
    }

    public void onHfpConnectionStateChanged(BluetoothDevice bluetoothDevice, int i) {
    }

    public void onHidStateChanged(BluetoothDevice bluetoothDevice, int i) {
    }

    public void onVendorSpecificHeadsetEvent(BluetoothDevice bluetoothDevice, String str, int i, Object[] objArr) {
    }
}
