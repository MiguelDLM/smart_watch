package com.goodix.ble.libble.v2.impl.procedure;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Build;
import com.goodix.ble.libble.v2.gb.procedure.GBGattProcedureRead;
import com.goodix.ble.libble.v2.impl.BleCharacteristicX;
import com.goodix.ble.libble.v2.impl.BleGattX;
import com.goodix.ble.libble.v2.impl.data.BleIntState;
import com.goodix.ble.libcomx.ILogger;
import com.goodix.ble.libcomx.event.IEventListener;
import com.goodix.ble.libcomx.task.Task;
import com.iflytek.sparkchain.utils.constants.ErrorCode;

/* loaded from: classes9.dex */
public class CharacteristicRead extends BleBaseProcedure implements GBGattProcedureRead, IEventListener<BleIntState> {
    private static final String d = "CharacteristicRead";

    /* renamed from: a, reason: collision with root package name */
    private BleCharacteristicX f16159a;
    private a b;
    private byte[] c;

    /* loaded from: classes9.dex */
    public class a extends BluetoothGattCallback {
        public a() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
            if (i == 0) {
                CharacteristicRead.this.c = bluetoothGattCharacteristic.getValue();
                CharacteristicRead.this.finishedWithDone();
                return;
            }
            if (i == 5 || i == 8 || i == 137) {
                CharacteristicRead.this.finishedWithError("Insufficient Authentication");
                return;
            }
            String str = "Error on reading characteristic <" + bluetoothGattCharacteristic.getUuid() + ">: " + BleGattX.gattStatusToString(i);
            ILogger iLogger = ((Task) CharacteristicRead.this).logger;
            if (iLogger != null) {
                iLogger.e(CharacteristicRead.d, str);
            }
            CharacteristicRead.this.finishedWithError(str);
        }
    }

    @Override // com.goodix.ble.libble.v2.impl.procedure.BleBaseProcedure
    public int doWork2() {
        String str;
        BleCharacteristicX bleCharacteristicX = this.f16159a;
        if (bleCharacteristicX == null) {
            str = "Target characteristic is null.";
        } else {
            BluetoothGattCharacteristic gattCharacteristic = bleCharacteristicX.getGattCharacteristic();
            if (gattCharacteristic == null) {
                str = "Target characteristic is not discovered.";
            } else if (this.gattX.isConnected()) {
                a aVar = new a();
                this.b = aVar;
                this.gattX.register(aVar);
                if (this.gattX.tryReadCharacteristic(gattCharacteristic)) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        return ErrorCode.MSP_ERROR_HTTP_BASE;
                    }
                    this.gattX.evtBondStateChanged().subEvent(this).setExecutor(getExecutor()).register2(this);
                    return ErrorCode.MSP_ERROR_HTTP_BASE;
                }
                str = "Failed to read characteristic.";
            } else {
                str = "Failed to read characteristic. The connection is not established.";
            }
        }
        finishedWithError(str);
        return 0;
    }

    @Override // com.goodix.ble.libble.v2.gb.procedure.GBGattProcedureRead
    public byte[] getValue() {
        return this.c;
    }

    @Override // com.goodix.ble.libble.v2.impl.procedure.BleBaseProcedure, com.goodix.ble.libcomx.task.Task
    public void onCleanup() {
        BleGattX bleGattX = this.gattX;
        if (bleGattX != null) {
            bleGattX.evtBondStateChanged().clear(this);
            a aVar = this.b;
            if (aVar != null) {
                this.gattX.remove(aVar);
            }
        }
        super.onCleanup();
    }

    @Override // com.goodix.ble.libcomx.event.IEventListener
    public void onEvent(Object obj, int i, BleIntState bleIntState) {
        if (bleIntState.state == 12) {
            ILogger iLogger = this.logger;
            if (iLogger != null) {
                iLogger.v(d, "Retry to read characteristic after bonded");
            }
            if (this.gattX.tryReadCharacteristic(this.f16159a.getGattCharacteristic())) {
                return;
            }
            finishedWithError("Failed to read characteristic after bonded.");
        }
    }

    public void setTargetCharacteristic(BleCharacteristicX bleCharacteristicX) {
        this.f16159a = bleCharacteristicX;
    }
}
