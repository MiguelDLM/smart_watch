package com.goodix.ble.libble.v2.impl.procedure;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.os.Build;
import com.goodix.ble.libble.BleUuid;
import com.goodix.ble.libble.v2.gb.gatt.GBGattCharacteristic;
import com.goodix.ble.libble.v2.gb.gatt.GBGattService;
import com.goodix.ble.libble.v2.impl.BleCharacteristicX;
import com.goodix.ble.libble.v2.impl.BleGattX;
import com.goodix.ble.libble.v2.impl.BleServiceX;
import com.goodix.ble.libble.v2.impl.procedure.GattDiscover;
import com.goodix.ble.libcomx.event.IEventListener;
import com.goodix.ble.libcomx.logger.Logger;
import com.goodix.ble.libcomx.task.ITaskResult;
import com.goodix.ble.libcomx.task.Task;
import com.goodix.ble.libcomx.task.TaskError;
import com.goodix.ble.libcomx.task.TaskQueue;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes9.dex */
public class GattDiscover extends BleBaseProcedure {
    private static final String b = "GattDiscover";

    /* renamed from: a, reason: collision with root package name */
    private a f16173a;

    /* loaded from: classes9.dex */
    public class a extends BluetoothGattCallback {
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(Object obj, int i, ITaskResult iTaskResult) {
            TaskError error = iTaskResult.getError();
            if (error == null) {
                GattDiscover.this.remoteDevice.setDiscovered(true);
                GattDiscover.this.finishedWithDone();
                return;
            }
            GattDiscover.this.finished(-1, new TaskError(GattDiscover.this, "Failed to setup predefined characteristic : " + error.getRawMessage(), error));
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (i2 == 0) {
                GattDiscover.this.finishedWithError("Connection has been terminated.");
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            int i2;
            if (((Task) GattDiscover.this).taskState != 2) {
                Logger.w(((Task) GattDiscover.this).logger, GattDiscover.b, "Discovering is not running.");
                return;
            }
            if (i != 0) {
                GattDiscover.this.finishedWithError("Error on discovering service: " + BleGattX.gattStatusToString(i));
                return;
            }
            ArrayList<String> arrayList = new ArrayList<>(16);
            GattDiscover.this.remoteDevice.onDiscovered(bluetoothGatt, arrayList);
            if (!arrayList.isEmpty()) {
                StringBuilder sb = new StringBuilder(arrayList.size() * 128);
                sb.append("Failed to discovery all services: ");
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    sb.append(it.next());
                    sb.append(" ");
                }
                GattDiscover.this.finishedWithError(sb.toString());
                return;
            }
            ArrayList<BleServiceX> serviceList = GattDiscover.this.remoteDevice.getServiceList();
            TaskQueue taskQueue = new TaskQueue();
            taskQueue.setName("EnableDefinedChar");
            taskQueue.setAbortOnException(true);
            if (GattDiscover.this.remoteDevice.getBluetoothDevice().getBondState() == 12 && ((i2 = Build.VERSION.SDK_INT) < 23 || i2 == 26 || i2 == 27 || i2 == 28)) {
                Logger.v(((Task) GattDiscover.this).logger, GattDiscover.b, "Enable SCC for bond device.");
                for (GBGattService gBGattService : GattDiscover.this.remoteDevice.getService(BleUuid.GENERIC_ATTRIBUTE_SERVICE)) {
                    Logger.v(((Task) GattDiscover.this).logger, GattDiscover.b, "Found GENERIC_ATTRIBUTE_SERVICE");
                    for (GBGattCharacteristic gBGattCharacteristic : gBGattService.getCharacteristic(BleUuid.SERVICE_CHANGED_CHARACTERISTIC)) {
                        Logger.v(((Task) GattDiscover.this).logger, GattDiscover.b, "Found SERVICE_CHANGED_CHARACTERISTIC");
                        taskQueue.addTask(gBGattCharacteristic.setEnableIndicate(true));
                    }
                }
            }
            Iterator<BleServiceX> it2 = serviceList.iterator();
            while (it2.hasNext()) {
                BleServiceX next = it2.next();
                if (next.isDiscovered()) {
                    Iterator<BleCharacteristicX> it3 = next.getCharacteristicList().iterator();
                    while (it3.hasNext()) {
                        BleCharacteristicX next2 = it3.next();
                        if (next2.isDiscovered()) {
                            if (next2.needEnableIndicate) {
                                Logger.v(((Task) GattDiscover.this).logger, GattDiscover.b, "Try to enable indicate after discovery for: " + next2.getUuid());
                                taskQueue.addTask(next2.setEnableIndicate(true));
                            }
                            if (next2.needEnableNotify) {
                                Logger.v(((Task) GattDiscover.this).logger, GattDiscover.b, "Try to enable notify after discovery for: " + next2.getUuid());
                                taskQueue.addTask(next2.setEnableNotify(true));
                            }
                        }
                    }
                }
            }
            taskQueue.setExecutor(GattDiscover.this.getExecutor()).evtFinished().register2(new IEventListener() { // from class: com.goodix.ble.libble.v2.impl.procedure.I0Io
                @Override // com.goodix.ble.libcomx.event.IEventListener
                public final void onEvent(Object obj, int i3, Object obj2) {
                    GattDiscover.a.this.a(obj, i3, (ITaskResult) obj2);
                }
            });
            GattDiscover.this.remoteDevice.getLocker().releaseLock(GattDiscover.this);
            taskQueue.setLogger(((Task) GattDiscover.this).logger);
            taskQueue.start(null, null);
        }
    }

    @Override // com.goodix.ble.libble.v2.impl.procedure.BleBaseProcedure
    public int doWork2() {
        String str;
        BluetoothGatt gatt = this.gattX.getGatt();
        if (gatt == null) {
            str = "Abort discovering service for null gatt.";
        } else if (this.gattX.isConnected()) {
            a aVar = new a();
            this.f16173a = aVar;
            this.gattX.register(aVar);
            if (gatt.discoverServices()) {
                return 31000;
            }
            str = "Failed to start discovering service.";
        } else {
            str = "Failed to start discovering service. The connection is not established.";
        }
        finishedWithError(str);
        return 0;
    }

    @Override // com.goodix.ble.libble.v2.impl.procedure.BleBaseProcedure, com.goodix.ble.libcomx.task.Task
    public void onCleanup() {
        BleGattX bleGattX;
        a aVar = this.f16173a;
        if (aVar != null && (bleGattX = this.gattX) != null) {
            bleGattX.remove(aVar);
        }
        super.onCleanup();
    }
}
