package com.goodix.ble.libble.v2.impl.data;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes9.dex */
public class BleValue {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private BluetoothGatt f16157a;

    @NonNull
    private BluetoothGattCharacteristic b;

    @Nullable
    private byte[] c;
    private int d;

    public BleValue(@NonNull BluetoothGatt bluetoothGatt, @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.f16157a = bluetoothGatt;
        this.b = bluetoothGattCharacteristic;
        this.c = bluetoothGattCharacteristic.getValue();
    }

    @NonNull
    public BluetoothGattCharacteristic getCharacteristic() {
        return this.b;
    }

    @Nullable
    public byte[] getData() {
        return this.c;
    }

    @NonNull
    public BluetoothGatt getGatt() {
        return this.f16157a;
    }

    public int getStatus() {
        return this.d;
    }

    public BleValue(@NonNull BluetoothGatt bluetoothGatt, @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        this.f16157a = bluetoothGatt;
        this.b = bluetoothGattCharacteristic;
        this.c = bluetoothGattCharacteristic.getValue();
        this.d = i;
    }

    public BleValue(@NonNull BluetoothGatt bluetoothGatt, @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, @Nullable byte[] bArr, int i) {
        this.f16157a = bluetoothGatt;
        this.b = bluetoothGattCharacteristic;
        this.c = bArr;
        this.d = i;
    }
}
