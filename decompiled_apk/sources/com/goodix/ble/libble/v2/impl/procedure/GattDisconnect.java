package com.goodix.ble.libble.v2.impl.procedure;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import com.goodix.ble.libble.v2.gb.procedure.GBProcedureConnect;
import com.goodix.ble.libble.v2.impl.BleGattX;

/* loaded from: classes9.dex */
public class GattDisconnect extends BleBaseProcedure {

    /* renamed from: a, reason: collision with root package name */
    private a f16171a;
    private boolean b = false;

    /* loaded from: classes9.dex */
    public class a extends BluetoothGattCallback {
        public a() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (i2 == 0) {
                GattDisconnect.this.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.b) {
            this.gattX.tryRefreshDeviceCache();
        }
        this.gattX.tryCloseGatt();
        startTimer(1, 300L);
    }

    @Override // com.goodix.ble.libble.v2.impl.procedure.BleBaseProcedure
    public boolean acquireLock() {
        Object owner = this.remoteDevice.getLocker().getOwner();
        if (owner instanceof GBProcedureConnect) {
            ((GBProcedureConnect) owner).abort();
        }
        return super.acquireLock();
    }

    @Override // com.goodix.ble.libble.v2.impl.procedure.BleBaseProcedure
    public int doWork2() {
        this.remoteDevice.expectConnection = false;
        if (this.gattX.getConnectionState() == 0) {
            a();
            finishedWithDone();
            return 0;
        }
        a aVar = new a();
        this.f16171a = aVar;
        this.gattX.register(aVar);
        boolean isConnected = this.gattX.isConnected();
        if (!this.gattX.tryDisconnect()) {
            finishedWithError("Failed to disconnect.");
            return 0;
        }
        if (isConnected) {
            return 31000;
        }
        a();
        return 31000;
    }

    @Override // com.goodix.ble.libble.v2.impl.procedure.BleBaseProcedure, com.goodix.ble.libcomx.task.Task
    public void onCleanup() {
        BleGattX bleGattX;
        a aVar = this.f16171a;
        if (aVar != null && (bleGattX = this.gattX) != null) {
            bleGattX.remove(aVar);
        }
        super.onCleanup();
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public void onTimeout(int i) {
        super.onTimeout(i);
        if (i == 1) {
            finishedWithDone();
        }
    }

    public void setClearCache(boolean z) {
        this.b = z;
    }
}
