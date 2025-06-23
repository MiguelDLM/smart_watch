package com.realsil.sdk.bbpro.core.gatt;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import com.realsil.sdk.core.bluetooth.connection.le.BluetoothGattClient;
import com.realsil.sdk.core.bluetooth.connection.le.BluetoothGattClientCallback;
import com.realsil.sdk.core.bluetooth.connection.le.BluetoothGattClientImpl;
import com.realsil.sdk.core.bluetooth.utils.BluetoothUuid;
import com.realsil.sdk.core.logger.ZLogger;
import java.util.UUID;

/* loaded from: classes11.dex */
public class GattLayer extends BluetoothGattClientImpl {
    public static final UUID c = UUID.fromString("000002fd-3C17-D293-8E48-14FE2E4DA212");
    public static final UUID d = BluetoothUuid.fromShortValue(64771);
    public static final UUID e = BluetoothUuid.fromShortValue(64772);

    /* renamed from: a, reason: collision with root package name */
    public BluetoothGattCharacteristic f19458a;
    public BluetoothGattCharacteristic b;

    public GattLayer(BluetoothGattClientCallback bluetoothGattClientCallback) {
        super(null, bluetoothGattClientCallback);
        if (this.VDBG) {
            ZLogger.v("GattLayer initial");
        }
    }

    @Override // com.realsil.sdk.core.bluetooth.connection.le.BluetoothGattClientImpl
    public boolean enableCccd() {
        super.enableCccd();
        return setCharacteristicNotification(this.mBluetoothGatt, this.b, true);
    }

    @Override // com.realsil.sdk.core.bluetooth.connection.le.BluetoothGattClientImpl
    public void processCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super.processCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
        byte[] value = bluetoothGattCharacteristic.getValue();
        if (bluetoothGattCharacteristic.getUuid().equals(e)) {
            dispatchDataReceived(value);
        }
    }

    @Override // com.realsil.sdk.core.bluetooth.connection.le.BluetoothGattClientImpl
    public void processDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        super.processDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
        boolean z = false;
        if (i == 0) {
            if (BluetoothGattClient.CLIENT_CHARACTERISTIC_CONFIG_DESCRIPTOR_UUID.equals(bluetoothGattDescriptor.getUuid()) && bluetoothGattDescriptor.getCharacteristic().getUuid().equals(this.b.getUuid())) {
                if (bluetoothGattDescriptor.getValue()[0] == 1) {
                    z = true;
                }
                if (z) {
                    if (this.DBG) {
                        ZLogger.d(" Notification enabled");
                    }
                } else if (this.DBG) {
                    ZLogger.w("Notification  not enabled!!!");
                }
                notifyCccdEnabled(z);
                return;
            }
            return;
        }
        if (this.DBG) {
            ZLogger.w("Descriptor write error: " + i);
        }
        notifyCccdEnabled(false);
    }

    @Override // com.realsil.sdk.core.bluetooth.connection.le.BluetoothGattClientImpl
    public boolean processServices(BluetoothGatt bluetoothGatt) {
        UUID uuid = c;
        BluetoothGattService service = bluetoothGatt.getService(uuid);
        if (service == null) {
            ZLogger.w("not find BBPRO_SERVICE_UUID:" + uuid);
            return false;
        }
        UUID uuid2 = d;
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(uuid2);
        this.f19458a = characteristic;
        if (characteristic == null) {
            ZLogger.w("not find BBPRO_TX_CHARACTERISTIC_UUID:" + uuid2);
            return false;
        }
        UUID uuid3 = e;
        BluetoothGattCharacteristic characteristic2 = service.getCharacteristic(uuid3);
        this.b = characteristic2;
        if (characteristic2 == null) {
            ZLogger.w("not find BBPRO_RX_CHARACTERISTIC_UUID:" + uuid3);
            return false;
        }
        return true;
    }

    public boolean sendData(byte[] bArr) {
        if (this.f19458a == null) {
            if (this.DBG) {
                ZLogger.w("mTXCharacteristic == null.");
            }
            return false;
        }
        if (!this.mGlobalGatt.isConnected(this.mDeviceAddress)) {
            if (this.DBG) {
                ZLogger.w("disconnect.");
            }
            return false;
        }
        this.f19458a.setValue(bArr);
        this.mGlobalGatt.writeCharacteristic(this.mDeviceAddress, this.f19458a);
        return true;
    }
}
