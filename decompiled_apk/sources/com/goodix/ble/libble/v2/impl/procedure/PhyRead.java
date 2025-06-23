package com.goodix.ble.libble.v2.impl.procedure;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.os.Build;
import com.goodix.ble.libble.v2.impl.BleGattX;
import com.iflytek.sparkchain.utils.constants.ErrorCode;

/* loaded from: classes9.dex */
public class PhyRead extends BleBaseProcedure {

    /* renamed from: a, reason: collision with root package name */
    private a f16181a;

    /* loaded from: classes9.dex */
    public class a extends BluetoothGattCallback {
        public a() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onPhyRead(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
            super.onPhyRead(bluetoothGatt, i, i2, i3);
            PhyRead phyRead = PhyRead.this;
            if (i3 == 0) {
                phyRead.finishedWithDone();
                return;
            }
            phyRead.finishedWithError("Failed to read PHY: " + BleGattX.gattStatusToString(i3));
        }
    }

    @Override // com.goodix.ble.libble.v2.impl.procedure.BleBaseProcedure
    public int doWork2() {
        String str;
        if (this.gattX.isConnected()) {
            BluetoothGatt gatt = this.gattX.getGatt();
            if (gatt == null) {
                str = "Abort Reading PHY for null gatt.";
            } else {
                if (Build.VERSION.SDK_INT >= 26) {
                    a aVar = new a();
                    this.f16181a = aVar;
                    this.gattX.register(aVar);
                    gatt.readPhy();
                    return ErrorCode.MSP_ERROR_HTTP_BASE;
                }
                str = "Reading PHY requires API level 26.";
            }
        } else {
            str = "Failed to read PHY. The connection is not established.";
        }
        finishedWithError(str);
        return 0;
    }

    @Override // com.goodix.ble.libble.v2.impl.procedure.BleBaseProcedure, com.goodix.ble.libcomx.task.Task
    public void onCleanup() {
        BleGattX bleGattX;
        a aVar = this.f16181a;
        if (aVar != null && (bleGattX = this.gattX) != null) {
            bleGattX.remove(aVar);
        }
        super.onCleanup();
    }
}
