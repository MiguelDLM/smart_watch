package com.goodix.ble.libble.v2.impl.procedure;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import com.goodix.ble.libble.v2.impl.BleGattX;

/* loaded from: classes9.dex */
public class MtuExchange extends BleBaseProcedure {

    /* renamed from: a, reason: collision with root package name */
    private a f16177a;
    private int b;

    /* loaded from: classes9.dex */
    public class a extends BluetoothGattCallback {
        public a() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            super.onMtuChanged(bluetoothGatt, i, i2);
            MtuExchange mtuExchange = MtuExchange.this;
            if (i2 == 0) {
                if (mtuExchange.b == i) {
                    MtuExchange.this.finishedWithDone();
                    return;
                }
                MtuExchange.this.finishedWithError("Failed to change MTU to " + MtuExchange.this.b + " , now it's " + i);
                return;
            }
            if (mtuExchange.gattX != null && mtuExchange.b == i) {
                MtuExchange.this.finishedWithDone();
                return;
            }
            MtuExchange.this.finishedWithError("Failed to request MTU " + MtuExchange.this.b + " : " + BleGattX.gattStatusToString(i2));
        }
    }

    @Override // com.goodix.ble.libble.v2.impl.procedure.BleBaseProcedure
    public int doWork2() {
        String str;
        if (this.b < 23) {
            str = "MTU is less than 23: " + this.b;
        } else if (this.gattX.isConnected()) {
            BluetoothGatt gatt = this.gattX.getGatt();
            if (gatt == null) {
                str = "Abort requesting MTU for null gatt.";
            } else {
                a aVar = new a();
                this.f16177a = aVar;
                this.gattX.register(aVar);
                if (gatt.requestMtu(this.b)) {
                    return 31000;
                }
                str = "Failed to request MTU.";
            }
        } else {
            str = "Failed to exchange MTU. The connection is not established.";
        }
        finishedWithError(str);
        return 0;
    }

    @Override // com.goodix.ble.libble.v2.impl.procedure.BleBaseProcedure, com.goodix.ble.libcomx.task.Task
    public void onCleanup() {
        BleGattX bleGattX;
        a aVar = this.f16177a;
        if (aVar != null && (bleGattX = this.gattX) != null) {
            bleGattX.remove(aVar);
        }
        super.onCleanup();
    }

    public void setMtu(int i) {
        this.b = i;
    }
}
