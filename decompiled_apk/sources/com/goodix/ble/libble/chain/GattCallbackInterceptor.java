package com.goodix.ble.libble.chain;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;

/* loaded from: classes9.dex */
public class GattCallbackInterceptor extends BluetoothGattCallback {

    /* renamed from: a, reason: collision with root package name */
    private BluetoothGattCallback f16144a;

    @Nullable
    public static BluetoothGattCallback getGattCallback(BluetoothGatt bluetoothGatt) {
        if (bluetoothGatt == null) {
            return null;
        }
        try {
            Field declaredField = bluetoothGatt.getClass().getDeclaredField("mCallback");
            declaredField.setAccessible(true);
            return (BluetoothGattCallback) declaredField.get(bluetoothGatt);
        } catch (ClassCastException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void interceptGattCallback(BluetoothGatt bluetoothGatt) {
        if (bluetoothGatt == null) {
            return;
        }
        try {
            Field declaredField = bluetoothGatt.getClass().getDeclaredField("mCallback");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(bluetoothGatt);
            if (obj != this) {
                this.f16144a = (BluetoothGattCallback) obj;
                declaredField.set(bluetoothGatt, this);
            }
        } catch (ClassCastException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
        BluetoothGattCallback bluetoothGattCallback = this.f16144a;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
        BluetoothGattCallback bluetoothGattCallback = this.f16144a;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
        BluetoothGattCallback bluetoothGattCallback = this.f16144a;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        super.onConnectionStateChange(bluetoothGatt, i, i2);
        BluetoothGattCallback bluetoothGattCallback = this.f16144a;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onConnectionStateChange(bluetoothGatt, i, i2);
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        super.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
        BluetoothGattCallback bluetoothGattCallback = this.f16144a;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
        BluetoothGattCallback bluetoothGattCallback = this.f16144a;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    @RequiresApi(api = 21)
    public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
        super.onMtuChanged(bluetoothGatt, i, i2);
        BluetoothGattCallback bluetoothGattCallback = this.f16144a;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onMtuChanged(bluetoothGatt, i, i2);
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    @RequiresApi(api = 26)
    public void onPhyRead(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
        super.onPhyRead(bluetoothGatt, i, i2, i3);
        BluetoothGattCallback bluetoothGattCallback = this.f16144a;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onPhyRead(bluetoothGatt, i, i2, i3);
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    @RequiresApi(api = 26)
    public void onPhyUpdate(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
        super.onPhyUpdate(bluetoothGatt, i, i2, i3);
        BluetoothGattCallback bluetoothGattCallback = this.f16144a;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onPhyUpdate(bluetoothGatt, i, i2, i3);
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
        super.onReadRemoteRssi(bluetoothGatt, i, i2);
        BluetoothGattCallback bluetoothGattCallback = this.f16144a;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onReadRemoteRssi(bluetoothGatt, i, i2);
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i) {
        super.onReliableWriteCompleted(bluetoothGatt, i);
        BluetoothGattCallback bluetoothGattCallback = this.f16144a;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onReliableWriteCompleted(bluetoothGatt, i);
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        super.onServicesDiscovered(bluetoothGatt, i);
        BluetoothGattCallback bluetoothGattCallback = this.f16144a;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onServicesDiscovered(bluetoothGatt, i);
        }
    }

    public final void setOriginGattCallback(BluetoothGattCallback bluetoothGattCallback) {
        if (bluetoothGattCallback == this) {
            return;
        }
        this.f16144a = bluetoothGattCallback;
    }
}
