package com.goodix.ble.libble.v2.impl.procedure;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Build;
import com.goodix.ble.libble.v2.gb.procedure.GBGattProcedureWrite;
import com.goodix.ble.libble.v2.impl.BleDescriptorX;
import com.goodix.ble.libble.v2.impl.BleGattX;
import com.goodix.ble.libble.v2.impl.data.BleIntState;
import com.goodix.ble.libcomx.ILogger;
import com.goodix.ble.libcomx.event.IEventListener;
import com.goodix.ble.libcomx.task.Task;
import com.iflytek.sparkchain.utils.constants.ErrorCode;

/* loaded from: classes9.dex */
public class DescriptorWrite extends BleBaseProcedure implements GBGattProcedureWrite, IEventListener<BleIntState> {
    private static final String d = "DescriptorWrite";

    /* renamed from: a, reason: collision with root package name */
    private BleDescriptorX f16167a;
    private byte[] b;
    private a c;

    /* loaded from: classes9.dex */
    public class a extends BluetoothGattCallback {
        public a() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
            if (i == 0) {
                DescriptorWrite.this.finishedWithDone();
                return;
            }
            if (i == 5 || i == 8 || i == 137) {
                DescriptorWrite.this.finishedWithError("Insufficient Authentication");
                return;
            }
            String str = "Error on writing descriptor <" + bluetoothGattDescriptor.getUuid() + ">: " + BleGattX.gattStatusToString(i);
            ILogger iLogger = ((Task) DescriptorWrite.this).logger;
            if (iLogger != null) {
                iLogger.e(DescriptorWrite.d, str);
            }
            DescriptorWrite.this.finishedWithError(str);
        }
    }

    @Override // com.goodix.ble.libble.v2.impl.procedure.BleBaseProcedure
    public int doWork2() {
        String str;
        if (this.f16167a == null) {
            str = "Target descriptor is null.";
        } else {
            if (!this.gattX.isConnected()) {
                finishedWithError("Failed to write descriptor. The connection is not established.");
                return 0;
            }
            BluetoothGattDescriptor gattDescriptor = this.f16167a.getGattDescriptor();
            if (gattDescriptor == null) {
                str = "Target descriptor is not discovered.";
            } else if (this.b == null) {
                str = "Value is null.";
            } else {
                if (!this.gattX.isConnected()) {
                    finishedWithError("Failed to write descriptor. The connection is not established.");
                    return 0;
                }
                a aVar = new a();
                this.c = aVar;
                this.gattX.register(aVar);
                gattDescriptor.setValue(this.b);
                if (this.gattX.tryWriteDescriptor(gattDescriptor)) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        return ErrorCode.MSP_ERROR_HTTP_BASE;
                    }
                    this.gattX.evtBondStateChanged().subEvent(this).setExecutor(getExecutor()).register2(this);
                    return ErrorCode.MSP_ERROR_HTTP_BASE;
                }
                str = "Failed to write descriptor.";
            }
        }
        finishedWithError(str);
        return 0;
    }

    @Override // com.goodix.ble.libble.v2.impl.procedure.BleBaseProcedure, com.goodix.ble.libcomx.task.Task
    public void onCleanup() {
        BleGattX bleGattX = this.gattX;
        if (bleGattX != null) {
            bleGattX.evtBondStateChanged().clear(this);
            a aVar = this.c;
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
                iLogger.v(d, "Retry to write descriptor after bonded");
            }
            if (this.gattX.tryWriteDescriptor(this.f16167a.getGattDescriptor())) {
                return;
            }
            finishedWithError("Failed to write descriptor after bonded.");
        }
    }

    public void setTargetDescriptor(BleDescriptorX bleDescriptorX) {
        this.f16167a = bleDescriptorX;
    }

    @Override // com.goodix.ble.libble.v2.gb.procedure.GBGattProcedureWrite
    public void setValue(byte[] bArr) {
        this.b = bArr;
    }
}
