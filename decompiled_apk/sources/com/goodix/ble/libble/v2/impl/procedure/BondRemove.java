package com.goodix.ble.libble.v2.impl.procedure;

import android.bluetooth.BluetoothDevice;
import com.goodix.ble.libble.v2.impl.BleGattX;
import com.goodix.ble.libble.v2.impl.BleRemoteDevice;
import com.goodix.ble.libble.v2.impl.data.BleIntState;
import com.goodix.ble.libcomx.event.IEventListener;
import com.iflytek.sparkchain.utils.constants.ErrorCode;

/* loaded from: classes9.dex */
public class BondRemove extends BleBaseProcedure implements IEventListener<BleIntState> {

    /* renamed from: a, reason: collision with root package name */
    private boolean f16158a;

    @Override // com.goodix.ble.libble.v2.impl.procedure.BleBaseProcedure
    public int doWork2() {
        String str;
        BluetoothDevice bluetoothDevice = this.remoteDevice.getBluetoothDevice();
        if (bluetoothDevice == null) {
            str = "Abort removing bond for null device.";
        } else if (bluetoothDevice.getBondState() == 10) {
            str = "Device is not bonded: " + bluetoothDevice.getName();
        } else {
            BleRemoteDevice bleRemoteDevice = this.remoteDevice;
            bleRemoteDevice.expectConnection = false;
            this.f16158a = false;
            if (bleRemoteDevice.isDisconnected()) {
                this.f16158a = true;
                this.gattX.setupReceiver();
            }
            this.gattX.evtBondStateChanged().subEvent(this).setExecutor(getExecutor()).register2(this);
            if (this.gattX.tryRemoveBond()) {
                return ErrorCode.MSP_ERROR_HTTP_BASE;
            }
            str = "Failed to remove bond.";
        }
        finishedWithError(str);
        return 0;
    }

    @Override // com.goodix.ble.libble.v2.impl.procedure.BleBaseProcedure, com.goodix.ble.libcomx.task.Task
    public void onCleanup() {
        BleGattX bleGattX = this.gattX;
        if (bleGattX != null) {
            bleGattX.evtBondStateChanged().clear(this);
            if (this.f16158a && this.remoteDevice.isDisconnected()) {
                this.f16158a = false;
                this.gattX.cleanReceiver();
            }
        }
        super.onCleanup();
    }

    @Override // com.goodix.ble.libcomx.event.IEventListener
    public void onEvent(Object obj, int i, BleIntState bleIntState) {
        int i2 = bleIntState.state;
        if (i2 == 10) {
            finishedWithDone();
        } else {
            if (i2 != 12) {
                return;
            }
            finishedWithError("Bond has been created.");
        }
    }
}
