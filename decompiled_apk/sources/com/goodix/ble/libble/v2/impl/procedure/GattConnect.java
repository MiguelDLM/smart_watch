package com.goodix.ble.libble.v2.impl.procedure;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.os.SystemClock;
import com.goodix.ble.libble.v2.gb.procedure.GBProcedureConnect;
import com.goodix.ble.libble.v2.impl.BleGattX;
import com.goodix.ble.libcomx.ILogger;
import com.goodix.ble.libcomx.task.Task;

/* loaded from: classes9.dex */
public class GattConnect extends BleBaseProcedure implements GBProcedureConnect {
    private static final long h = 20000;

    /* renamed from: a, reason: collision with root package name */
    private int f16169a = 0;
    private int b = 0;
    private int c = 0;
    private boolean d = false;
    private a e;
    private long f;
    private int g;

    /* loaded from: classes9.dex */
    public class a extends BluetoothGattCallback {
        public a() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            BleGattX bleGattX;
            if (i == 0) {
                if (i2 != 2) {
                    GattConnect.this.finishedWithError("Disconnect successfully?");
                    return;
                } else {
                    GattConnect.this.f = 0L;
                    GattConnect.this.finishedWithDone();
                    return;
                }
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - GattConnect.this.f;
            if (GattConnect.this.f > 0 && elapsedRealtime > 20000) {
                GattConnect.this.finishedWithError("GATT Timeout.");
                return;
            }
            if (GattConnect.this.g >= GattConnect.this.b) {
                if (!GattConnect.this.d && (bleGattX = GattConnect.this.gattX) != null && i2 != 2) {
                    bleGattX.tryCloseGatt();
                }
                GattConnect.this.finishedWithError("Failed to connect device after " + GattConnect.this.g + " retry(s). Last status: " + i);
                return;
            }
            if (GattConnect.this.c <= 0) {
                GattConnect.this.onTimeout(1);
                return;
            }
            ILogger iLogger = ((Task) GattConnect.this).logger;
            if (iLogger != null) {
                iLogger.d(GattConnect.this.getName(), "wait " + GattConnect.this.c + "ms to retry.");
            }
            GattConnect.this.startTimer(1, r8.c);
            BleGattX bleGattX2 = GattConnect.this.gattX;
            if (bleGattX2 != null) {
                bleGattX2.tryCloseGatt();
            }
        }
    }

    @Override // com.goodix.ble.libble.v2.impl.procedure.BleBaseProcedure
    public int doWork2() {
        this.remoteDevice.expectConnection = true;
        if (this.gattX.isConnected()) {
            finishedWithDone();
            return 0;
        }
        a aVar = new a();
        this.e = aVar;
        this.gattX.register(aVar);
        this.g = 0;
        BleGattX bleGattX = this.gattX;
        int i = this.f16169a;
        if (bleGattX.tryConnect(i != 0 ? i : 1, this.d)) {
            this.f = SystemClock.elapsedRealtime();
            return 31000;
        }
        finishedWithError("Failed to start connecting.");
        return 0;
    }

    @Override // com.goodix.ble.libble.v2.impl.procedure.BleBaseProcedure, com.goodix.ble.libcomx.task.Task
    public void onCleanup() {
        BleGattX bleGattX;
        BleGattX bleGattX2;
        if (getResult().getCode() == -2 && (bleGattX2 = this.gattX) != null) {
            bleGattX2.tryDisconnect();
            this.gattX.tryCloseGatt();
        }
        a aVar = this.e;
        if (aVar != null && (bleGattX = this.gattX) != null) {
            bleGattX.remove(aVar);
        }
        super.onCleanup();
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public void onTimeout(int i) {
        super.onTimeout(i);
        if (i == 1) {
            this.g++;
            ILogger iLogger = this.logger;
            if (iLogger != null) {
                iLogger.d(getName(), "Retry connecting... #" + this.g);
            }
            BleGattX gatt = this.remoteDevice.getGatt();
            int i2 = this.f16169a;
            if (!gatt.tryConnect(i2 != 0 ? i2 : 1, this.d)) {
                finishedWithError("Failed to retry connecting.");
            } else {
                this.f = SystemClock.elapsedRealtime();
                refreshTaskTimeout();
            }
        }
    }

    @Override // com.goodix.ble.libble.v2.gb.procedure.GBProcedureConnect
    public GBProcedureConnect setBackgroundMode(boolean z) {
        this.d = z;
        return this;
    }

    public void setPreferredPhy(int i) {
        this.f16169a = i;
    }

    @Override // com.goodix.ble.libble.v2.gb.procedure.GBProcedureConnect
    public GBProcedureConnect setRetry(int i, int i2) {
        this.b = i;
        this.c = i2;
        return this;
    }
}
