package com.goodix.ble.libble.v2.impl.procedure;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import androidx.annotation.Keep;
import com.goodix.ble.libble.v2.impl.BleGattX;

/* loaded from: classes9.dex */
public class CiSet extends BleBaseProcedure {

    /* renamed from: a, reason: collision with root package name */
    private CB f16163a;
    private int b;

    /* loaded from: classes9.dex */
    public class CB extends BluetoothGattCallback {
        public CB() {
        }

        @Keep
        public void onConnectionUpdated(BluetoothGatt bluetoothGatt, int i, int i2, int i3, int i4) {
            if (i4 == 0) {
                CiSet.this.finishedWithDone();
                return;
            }
            if (i4 == 59) {
                CiSet.this.finishedWithError("Connection parameters update failed with status: UNACCEPT CONN INTERVAL (0x3b) (interval: " + (i * 1.25d) + "ms, latency: " + i2 + ", timeout: " + (i3 * 10) + "ms)");
                return;
            }
            CiSet.this.finishedWithError("Connection parameters update failed with status " + BleGattX.gattStatusToString(i4) + " (interval: " + (i * 1.25d) + "ms, latency: " + i2 + ", timeout: " + (i3 * 10) + "ms)");
        }
    }

    @Override // com.goodix.ble.libble.v2.impl.procedure.BleBaseProcedure
    public int doWork2() {
        String str;
        if (this.b > 2) {
            str = "Invalid connection priority: " + this.b;
        } else if (this.gattX.isConnected()) {
            BluetoothGatt gatt = this.gattX.getGatt();
            if (gatt == null) {
                str = "Abort setting connection priority for null gatt.";
            } else {
                CB cb = new CB();
                this.f16163a = cb;
                this.gattX.register(cb);
                int i = this.b;
                if (i == 0) {
                    this.b = 0;
                } else if (i == 1) {
                    this.b = 1;
                } else if (i == 2) {
                    this.b = 2;
                }
                if (gatt.requestConnectionPriority(this.b)) {
                    return 31000;
                }
                str = "Failed to set connection priority.";
            }
        } else {
            str = "Failed to set CI. The connection is not established.";
        }
        finishedWithError(str);
        return 0;
    }

    @Override // com.goodix.ble.libble.v2.impl.procedure.BleBaseProcedure, com.goodix.ble.libcomx.task.Task
    public void onCleanup() {
        BleGattX bleGattX;
        CB cb = this.f16163a;
        if (cb != null && (bleGattX = this.gattX) != null) {
            bleGattX.remove(cb);
        }
        super.onCleanup();
    }

    public void setPriority(int i) {
        this.b = i;
    }
}
