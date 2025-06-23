package com.goodix.ble.libble.v2.impl;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;

/* loaded from: classes9.dex */
interface a {

    /* renamed from: a, reason: collision with root package name */
    public static final int f16156a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;

    boolean onCharacteristicChanged(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i);

    boolean onDescriptorChanged(BluetoothGattDescriptor bluetoothGattDescriptor, int i);
}
