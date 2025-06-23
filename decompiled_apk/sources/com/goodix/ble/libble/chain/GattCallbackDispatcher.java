package com.goodix.ble.libble.chain;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import androidx.annotation.Keep;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes9.dex */
public class GattCallbackDispatcher extends BluetoothGattCallback {

    /* renamed from: a, reason: collision with root package name */
    private CopyOnWriteArrayList<BluetoothGattCallback> f16143a = new CopyOnWriteArrayList<>();

    @Override // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
        Iterator<BluetoothGattCallback> it = this.f16143a.iterator();
        while (it.hasNext()) {
            it.next().onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
        Iterator<BluetoothGattCallback> it = this.f16143a.iterator();
        while (it.hasNext()) {
            it.next().onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
        Iterator<BluetoothGattCallback> it = this.f16143a.iterator();
        while (it.hasNext()) {
            it.next().onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        super.onConnectionStateChange(bluetoothGatt, i, i2);
        Iterator<BluetoothGattCallback> it = this.f16143a.iterator();
        while (it.hasNext()) {
            it.next().onConnectionStateChange(bluetoothGatt, i, i2);
        }
    }

    @Keep
    @RequiresApi(api = 26)
    public void onConnectionUpdated(BluetoothGatt bluetoothGatt, int i, int i2, int i3, int i4) {
        Iterator<BluetoothGattCallback> it = this.f16143a.iterator();
        while (it.hasNext()) {
            BluetoothGattCallback next = it.next();
            try {
                Method[] declaredMethods = next.getClass().getDeclaredMethods();
                int length = declaredMethods.length;
                int i5 = 0;
                while (true) {
                    if (i5 < length) {
                        Method method = declaredMethods[i5];
                        if ("onConnectionUpdated".equals(method.getName())) {
                            method.invoke(next, bluetoothGatt, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                            break;
                        }
                        i5++;
                    }
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        super.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
        Iterator<BluetoothGattCallback> it = this.f16143a.iterator();
        while (it.hasNext()) {
            it.next().onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
        Iterator<BluetoothGattCallback> it = this.f16143a.iterator();
        while (it.hasNext()) {
            it.next().onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    @RequiresApi(api = 21)
    public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
        super.onMtuChanged(bluetoothGatt, i, i2);
        Iterator<BluetoothGattCallback> it = this.f16143a.iterator();
        while (it.hasNext()) {
            it.next().onMtuChanged(bluetoothGatt, i, i2);
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    @RequiresApi(api = 26)
    public void onPhyRead(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
        super.onPhyRead(bluetoothGatt, i, i2, i3);
        Iterator<BluetoothGattCallback> it = this.f16143a.iterator();
        while (it.hasNext()) {
            it.next().onPhyRead(bluetoothGatt, i, i2, i3);
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    @RequiresApi(api = 26)
    public void onPhyUpdate(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
        super.onPhyUpdate(bluetoothGatt, i, i2, i3);
        Iterator<BluetoothGattCallback> it = this.f16143a.iterator();
        while (it.hasNext()) {
            it.next().onPhyUpdate(bluetoothGatt, i, i2, i3);
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
        super.onReadRemoteRssi(bluetoothGatt, i, i2);
        Iterator<BluetoothGattCallback> it = this.f16143a.iterator();
        while (it.hasNext()) {
            it.next().onReadRemoteRssi(bluetoothGatt, i, i2);
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i) {
        super.onReliableWriteCompleted(bluetoothGatt, i);
        Iterator<BluetoothGattCallback> it = this.f16143a.iterator();
        while (it.hasNext()) {
            it.next().onReliableWriteCompleted(bluetoothGatt, i);
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        super.onServicesDiscovered(bluetoothGatt, i);
        Iterator<BluetoothGattCallback> it = this.f16143a.iterator();
        while (it.hasNext()) {
            it.next().onServicesDiscovered(bluetoothGatt, i);
        }
    }

    public void register(BluetoothGattCallback bluetoothGattCallback) {
        this.f16143a.addIfAbsent(bluetoothGattCallback);
    }

    public void remove(BluetoothGattCallback bluetoothGattCallback) {
        this.f16143a.remove(bluetoothGattCallback);
    }
}
