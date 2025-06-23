package com.realsil.sdk.core.bluetooth.connection;

/* loaded from: classes11.dex */
public abstract class BluetoothClientCallback {
    public void onConnectionStateChanged(BluetoothClient bluetoothClient, boolean z, int i) {
    }

    public void onDataReceive(BluetoothClient bluetoothClient, byte[] bArr) {
    }

    public void onError(int i) {
    }

    public void onDataReceive(byte[] bArr) {
    }
}
