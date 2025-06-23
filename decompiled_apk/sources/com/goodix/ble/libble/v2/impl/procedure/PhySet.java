package com.goodix.ble.libble.v2.impl.procedure;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.os.Build;
import com.goodix.ble.libble.v2.impl.BleGattX;

/* loaded from: classes9.dex */
public class PhySet extends BleBaseProcedure {

    /* renamed from: a, reason: collision with root package name */
    private a f16183a;
    private int b;
    private int c;
    private int d;

    /* loaded from: classes9.dex */
    public class a extends BluetoothGattCallback {
        public a() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onPhyUpdate(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
            super.onPhyUpdate(bluetoothGatt, i, i2, i3);
            PhySet phySet = PhySet.this;
            if (i3 == 0) {
                phySet.finishedWithDone();
                return;
            }
            phySet.finishedWithError("Failed to set preferred PHY: " + BleGattX.gattStatusToString(i3));
        }
    }

    private int a(int i) {
        if (Build.VERSION.SDK_INT < 26) {
            return 0;
        }
        int i2 = (i & 1) != 0 ? 1 : 0;
        if ((i & 2) != 0) {
            i2 |= 2;
        }
        if ((i & 4) != 0) {
            return 3;
        }
        return i2;
    }

    private int b(int i) {
        if (Build.VERSION.SDK_INT < 26) {
            return 0;
        }
        int i2 = (65536 & i) != 0 ? 1 : 0;
        if ((i & 131072) != 0) {
            return 2;
        }
        return i2;
    }

    @Override // com.goodix.ble.libble.v2.impl.procedure.BleBaseProcedure
    public int doWork2() {
        String str;
        if (this.gattX.isConnected()) {
            BluetoothGatt gatt = this.gattX.getGatt();
            if (gatt == null) {
                str = "Abort setting preferred PHY for null gatt.";
            } else {
                if (Build.VERSION.SDK_INT >= 26) {
                    a aVar = new a();
                    this.f16183a = aVar;
                    this.gattX.register(aVar);
                    gatt.setPreferredPhy(a(this.b), a(this.c), b(this.d));
                    return 31000;
                }
                str = "Setting preferred PHY requires API level 26.";
            }
        } else {
            str = "Failed to set PHY. The connection is not established.";
        }
        finishedWithError(str);
        return 0;
    }

    @Override // com.goodix.ble.libble.v2.impl.procedure.BleBaseProcedure, com.goodix.ble.libcomx.task.Task
    public void onCleanup() {
        BleGattX bleGattX;
        a aVar = this.f16183a;
        if (aVar != null && (bleGattX = this.gattX) != null) {
            bleGattX.remove(aVar);
        }
        super.onCleanup();
    }

    public void setPhy(int i, int i2, int i3) {
        this.b = i;
        this.c = i2;
        this.d = i3;
    }
}
