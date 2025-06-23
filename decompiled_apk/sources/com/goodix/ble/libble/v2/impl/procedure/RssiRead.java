package com.goodix.ble.libble.v2.impl.procedure;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import com.goodix.ble.libble.v2.gb.procedure.GBProcedureRssiRead;
import com.goodix.ble.libble.v2.impl.BleGattX;
import com.iflytek.sparkchain.utils.constants.ErrorCode;

/* loaded from: classes9.dex */
public class RssiRead extends BleBaseProcedure implements GBProcedureRssiRead {

    /* renamed from: a, reason: collision with root package name */
    private a f16185a;
    private int b;

    /* loaded from: classes9.dex */
    public class a extends BluetoothGattCallback {
        public a() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
            super.onReadRemoteRssi(bluetoothGatt, i, i2);
            RssiRead rssiRead = RssiRead.this;
            if (i2 == 0) {
                rssiRead.b = i;
                RssiRead.this.finishedWithDone();
            } else {
                rssiRead.finishedWithError("Failed to read RSSI: " + BleGattX.gattStatusToString(i2));
            }
        }
    }

    @Override // com.goodix.ble.libble.v2.impl.procedure.BleBaseProcedure
    public int doWork2() {
        String str;
        if (this.gattX.isConnected()) {
            BluetoothGatt gatt = this.gattX.getGatt();
            if (gatt == null) {
                str = "Abort reading RSSI for null gatt.";
            } else {
                a aVar = new a();
                this.f16185a = aVar;
                this.gattX.register(aVar);
                if (gatt.readRemoteRssi()) {
                    return ErrorCode.MSP_ERROR_HTTP_BASE;
                }
                str = "Failed to read RSSI.";
            }
        } else {
            str = "Failed to read RSSI. The connection is not established.";
        }
        finishedWithError(str);
        return 0;
    }

    @Override // com.goodix.ble.libble.v2.gb.procedure.GBProcedureRssiRead
    public int getRssi() {
        return this.b;
    }

    @Override // com.goodix.ble.libble.v2.impl.procedure.BleBaseProcedure, com.goodix.ble.libcomx.task.Task
    public void onCleanup() {
        BleGattX bleGattX;
        a aVar = this.f16185a;
        if (aVar != null && (bleGattX = this.gattX) != null) {
            bleGattX.remove(aVar);
        }
        super.onCleanup();
    }
}
