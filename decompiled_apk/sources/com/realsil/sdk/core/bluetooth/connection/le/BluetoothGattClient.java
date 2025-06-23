package com.realsil.sdk.core.bluetooth.connection.le;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import androidx.annotation.Keep;
import com.realsil.sdk.core.RtkCore;
import com.realsil.sdk.core.bluetooth.GlobalGatt;
import com.realsil.sdk.core.bluetooth.RtkBluetoothManager;
import com.realsil.sdk.core.bluetooth.RtkBluetoothManagerCallback;
import com.realsil.sdk.core.bluetooth.connection.BluetoothClient;
import com.realsil.sdk.core.bluetooth.utils.BluetoothHelper;
import com.realsil.sdk.core.logger.ZLogger;
import java.util.UUID;

/* loaded from: classes11.dex */
public class BluetoothGattClient extends BluetoothClient {
    public static final UUID CLIENT_CHARACTERISTIC_CONFIG_DESCRIPTOR_UUID = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    public RtkBluetoothManager e;

    @Keep
    public BluetoothGatt mBluetoothGatt;

    @Keep
    public GattConnParams mGattConnParams;

    @Keep
    public GlobalGatt mGlobalGatt;
    public boolean b = false;

    @Keep
    public String mDeviceAddress = null;
    public int c = 2;
    public boolean d = true;
    public Object f = new Object();
    public final a g = new a();

    /* loaded from: classes11.dex */
    public class a extends RtkBluetoothManagerCallback {
        public a() {
        }

        @Override // com.realsil.sdk.core.bluetooth.RtkBluetoothManagerCallback
        public final void onBondStateChanged(BluetoothDevice bluetoothDevice, int i) {
            super.onBondStateChanged(bluetoothDevice, i);
            BluetoothGattClient.this.processBondStateChanged(bluetoothDevice, i);
        }
    }

    public final void a(long j) {
        synchronized (this.f) {
            try {
                try {
                    if (this.VDBG) {
                        ZLogger.v("waitConnLock");
                    }
                    this.f.wait(j);
                } catch (InterruptedException e) {
                    ZLogger.d(this.DBG, "wait conn lock interrupted: " + e.toString());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean connect(GattConnParams gattConnParams) {
        if (gattConnParams == null) {
            ZLogger.w("connectParams can not be null");
            return false;
        }
        if (gattConnParams.getAddress() == null) {
            ZLogger.w("address is null");
            return false;
        }
        return true;
    }

    @Override // com.realsil.sdk.core.bluetooth.connection.BluetoothClient
    public synchronized void destroy() {
        super.destroy();
        ZLogger.v(this.DBG, "destroy");
        RtkBluetoothManager rtkBluetoothManager = this.e;
        if (rtkBluetoothManager != null) {
            rtkBluetoothManager.removeManagerCallback(this.g);
        }
    }

    public void disconnect() {
        if (this.DBG) {
            ZLogger.d("disconnect()");
        }
        this.d = true;
        notifyConnLock();
    }

    @Override // com.realsil.sdk.core.bluetooth.connection.BluetoothClient
    public boolean isConnected() {
        GlobalGatt globalGatt = this.mGlobalGatt;
        if (globalGatt == null) {
            return false;
        }
        return globalGatt.isConnected(this.mDeviceAddress);
    }

    public void notifyCccdEnabled(boolean z) {
        this.b = z;
        notifyConnLock();
    }

    public void notifyConnLock() {
        try {
            synchronized (this.f) {
                try {
                    if (this.VDBG) {
                        ZLogger.v("notifyConnLock");
                    }
                    this.f.notifyAll();
                } finally {
                }
            }
        } catch (Exception e) {
            ZLogger.w(e.toString());
        }
    }

    public void processBondStateChanged(BluetoothDevice bluetoothDevice, int i) {
    }

    public boolean setCharacteristicNotification(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z) {
        boolean z2;
        byte[] bArr;
        int properties = bluetoothGattCharacteristic.getProperties();
        if ((properties & 16) == 0) {
            ZLogger.w("check properties failed: " + properties);
            dispatchError(4);
            return false;
        }
        if (this.DBG) {
            ZLogger.v(String.format("setCharacteristicNotification(%s) - uuid:%s, enabled:%b ", BluetoothHelper.formatAddress(bluetoothGatt.getDevice().getAddress(), true), bluetoothGattCharacteristic.getUuid(), Boolean.valueOf(z)));
        } else {
            ZLogger.v("setCharacteristicNotification() enabled: " + z);
        }
        if (!bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, z)) {
            ZLogger.w("setCharacteristicNotification failed");
            dispatchError(4);
            return false;
        }
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG_DESCRIPTOR_UUID);
        if (descriptor == null) {
            ZLogger.w("no descriptor exist");
            dispatchError(4);
            return false;
        }
        if (descriptor.getValue() != null && descriptor.getValue().length == 2 && descriptor.getValue()[0] > 0 && descriptor.getValue()[1] == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        ZLogger.v(this.DBG, "current cccd state: " + z2);
        if (z && z2) {
            this.b = true;
            ZLogger.w("cccd already enabled");
            return true;
        }
        if (!z && !z2) {
            this.b = true;
            ZLogger.w("cccd already disable");
            return true;
        }
        if (z) {
            bArr = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        } else {
            bArr = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        }
        descriptor.setValue(bArr);
        if (!bluetoothGatt.writeDescriptor(descriptor)) {
            ZLogger.w("writeDescriptor failed");
            dispatchError(5);
            return false;
        }
        if (!this.b) {
            a(5000L);
            if (!this.b && !this.d) {
                ZLogger.w("cccd timeout");
                dispatchError(6);
                return false;
            }
        }
        return true;
    }

    public final void a() {
        this.DBG = RtkCore.DEBUG;
        this.VDBG = RtkCore.VDBG;
        this.mBluetoothAdapter = com.realsil.sdk.core.b.a.a(this.mContext);
        this.f19486a = 0;
        RtkBluetoothManager rtkBluetoothManager = RtkBluetoothManager.getInstance();
        this.e = rtkBluetoothManager;
        if (rtkBluetoothManager == null) {
            RtkBluetoothManager.initial(this.mContext);
            this.e = RtkBluetoothManager.getInstance();
        }
        RtkBluetoothManager rtkBluetoothManager2 = this.e;
        if (rtkBluetoothManager2 != null) {
            rtkBluetoothManager2.addManagerCallback(this.g);
        } else {
            ZLogger.w(this.DBG, "BluetoothProfileManager not initialized");
        }
        GlobalGatt globalGatt = GlobalGatt.getInstance();
        this.mGlobalGatt = globalGatt;
        if (globalGatt == null) {
            GlobalGatt.initial(this.mContext);
            this.mGlobalGatt = GlobalGatt.getInstance();
        }
    }
}
