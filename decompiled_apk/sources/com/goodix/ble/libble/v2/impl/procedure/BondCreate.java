package com.goodix.ble.libble.v2.impl.procedure;

import android.bluetooth.BluetoothDevice;
import com.goodix.ble.libble.v2.impl.BleGattX;
import com.goodix.ble.libble.v2.impl.data.BleIntState;
import com.goodix.ble.libcomx.event.IEventListener;
import com.iflytek.sparkchain.utils.constants.ErrorCode;

/* loaded from: classes9.dex */
public class BondCreate extends BleBaseProcedure implements IEventListener<BleIntState> {
    @Override // com.goodix.ble.libble.v2.impl.procedure.BleBaseProcedure
    public int doWork2() {
        String str;
        BluetoothDevice bluetoothDevice = this.remoteDevice.getBluetoothDevice();
        if (bluetoothDevice == null) {
            str = "Abort creating bond for null device.";
        } else {
            if (bluetoothDevice.getBondState() == 12) {
                finishedWithDone();
                return 0;
            }
            this.gattX.evtBondStateChanged().subEvent(this).setExecutor(getExecutor()).register2(this);
            if (this.gattX.tryCreateBond()) {
                return ErrorCode.MSP_ERROR_HTTP_BASE;
            }
            str = "Failed to create bond.";
        }
        finishedWithError(str);
        return 0;
    }

    @Override // com.goodix.ble.libble.v2.impl.procedure.BleBaseProcedure, com.goodix.ble.libcomx.task.Task
    public void onCleanup() {
        BleGattX bleGattX = this.gattX;
        if (bleGattX != null) {
            bleGattX.evtBondStateChanged().clear(this);
        }
        super.onCleanup();
    }

    @Override // com.goodix.ble.libcomx.event.IEventListener
    public void onEvent(Object obj, int i, BleIntState bleIntState) {
        String str;
        int i2 = bleIntState.state;
        if (i2 != 10) {
            if (i2 != 12) {
                return;
            }
            finishedWithDone();
            return;
        }
        int i3 = bleIntState.prvState;
        if (i3 == 11) {
            str = "Failed to create bond.";
        } else if (i3 != 12) {
            return;
        } else {
            str = "Bond has been removed.";
        }
        finishedWithError(str);
    }
}
