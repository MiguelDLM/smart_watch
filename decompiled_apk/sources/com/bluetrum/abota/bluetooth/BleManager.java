package com.bluetrum.abota.bluetooth;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import com.bluetrum.abota.time.Timber;
import com.bluetrum.fota.abota.ABOta;
import com.bluetrum.fota.utils.HexUtils;
import java.util.UUID;

@SuppressLint({"MissingPermission"})
/* loaded from: classes8.dex */
public final class BleManager implements BluetoothManager, ABOta.SendCallback {
    private static final String TAG = "BleManager";
    private final BluetoothDevice bleDevice;
    private BluetoothGatt bluetoothGatt;
    private final Context context;
    private BluetoothGattCharacteristic dataInCharacteristic;
    private BluetoothGattCharacteristic dataOutCharacteristic;
    private BluetoothEventListener eventListener;
    private BluetoothGattService otaService;
    private static final UUID OTA_SERVICE_UUID = UUID.fromString("0000ff12-0000-1000-8000-00805f9b34fb");
    private static final UUID OTA_DATA_IN_UUID = UUID.fromString("0000ff14-0000-1000-8000-00805f9b34fb");
    private static final UUID OTA_DATA_OUT_UUID = UUID.fromString("0000ff15-0000-1000-8000-00805f9b34fb");
    private static final UUID CLIENT_CHARACTERISTIC_CONFIG_UUID = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    private boolean isReady = false;
    private int mtu = 23;
    private final BluetoothGattCallback gattCallback = new BluetoothGattCallback() { // from class: com.bluetrum.abota.bluetooth.BleManager.1
        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            byte[] value = bluetoothGattCharacteristic.getValue();
            Timber.tag(BleManager.TAG).v("BLE_READ: %s", HexUtils.bytesToHex(value));
            if (BleManager.this.eventListener != null) {
                BleManager.this.eventListener.onReceive(value);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (i == 0 && BleManager.this.eventListener != null) {
                BleManager.this.eventListener.onSend(null);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (i2 == 2) {
                BleManager.this.bluetoothGatt.discoverServices();
            } else if (i2 == 0) {
                BleManager.this.isReady = false;
            }
            if (BleManager.this.eventListener != null) {
                BleManager.this.eventListener.onConnectionStateChange(bluetoothGatt, i, i2);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            if (i == 0) {
                BleManager.this.bluetoothGatt.requestMtu(517);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            Timber.tag(BleManager.TAG).d("onMtuChanged: mtu = %s", Integer.valueOf(i));
            BleManager.this.mtu = i;
            BleManager.this.isReady = true;
            if (BleManager.this.eventListener != null) {
                BleManager.this.eventListener.onBluetoothReady();
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            if (i == 0) {
                BleManager.this.findCharacteristics();
            } else {
                BleManager.this.close();
            }
        }
    };

    public BleManager(@NonNull Context context, @NonNull BluetoothDevice bluetoothDevice) {
        this.context = context;
        this.bleDevice = bluetoothDevice;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void findCharacteristics() {
        BluetoothGattService service = this.bluetoothGatt.getService(OTA_SERVICE_UUID);
        this.otaService = service;
        if (service == null) {
            Timber.e("FOTA service not found", new Object[0]);
            return;
        }
        this.dataInCharacteristic = service.getCharacteristic(OTA_DATA_IN_UUID);
        BluetoothGattCharacteristic characteristic = this.otaService.getCharacteristic(OTA_DATA_OUT_UUID);
        this.dataOutCharacteristic = characteristic;
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.dataInCharacteristic;
        if (bluetoothGattCharacteristic != null && characteristic != null) {
            if (!this.bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, true)) {
                Timber.e("Error subscribe FOTA Data In", new Object[0]);
                return;
            }
            BluetoothGattDescriptor descriptor = this.dataInCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG_UUID);
            if (descriptor == null) {
                Timber.e("FOTA CCC not found", new Object[0]);
                return;
            } else {
                descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                this.bluetoothGatt.writeDescriptor(descriptor);
                return;
            }
        }
        Timber.e("FOTA characteristic(s) not found", new Object[0]);
    }

    @Override // com.bluetrum.abota.bluetooth.BluetoothManager
    public void close() {
        BluetoothGatt bluetoothGatt = this.bluetoothGatt;
        if (bluetoothGatt != null) {
            bluetoothGatt.close();
            this.bluetoothGatt = null;
        }
        this.otaService = null;
        this.dataInCharacteristic = null;
        this.dataOutCharacteristic = null;
    }

    public int getMaxPacketSize() {
        return this.mtu - 3;
    }

    @Override // com.bluetrum.abota.bluetooth.BluetoothManager
    public boolean isReady() {
        return this.isReady;
    }

    @Override // com.bluetrum.abota.bluetooth.BluetoothManager
    public void open() {
        BluetoothGatt connectGatt;
        if (Build.VERSION.SDK_INT >= 23) {
            connectGatt = this.bleDevice.connectGatt(this.context, false, this.gattCallback, 2);
            this.bluetoothGatt = connectGatt;
        } else {
            this.bluetoothGatt = this.bleDevice.connectGatt(this.context, false, this.gattCallback);
        }
    }

    @Override // com.bluetrum.abota.bluetooth.BluetoothManager
    public void send(byte[] bArr) {
        this.dataOutCharacteristic.setValue(bArr);
        this.dataOutCharacteristic.setWriteType(1);
        this.bluetoothGatt.writeCharacteristic(this.dataOutCharacteristic);
        Timber.tag(TAG).v("BLE_WRITE: %s", HexUtils.bytesToHex(bArr));
    }

    @Override // com.bluetrum.fota.abota.ABOta.SendCallback
    public void sendData(byte[] bArr) {
        send(bArr);
    }

    @Override // com.bluetrum.abota.bluetooth.BluetoothManager
    public void setEventListener(BluetoothEventListener bluetoothEventListener) {
        this.eventListener = bluetoothEventListener;
    }
}
