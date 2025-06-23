package com.goodix.ble.libble.v2.misc;

import com.goodix.ble.libble.v2.gb.GBRemoteDevice;
import com.goodix.ble.libcomx.event.IEventListener;
import com.goodix.ble.libcomx.task.Task;
import com.goodix.ble.libcomx.task.TaskParameter;

/* loaded from: classes9.dex */
public class WaitGattReadyTask extends Task implements IEventListener<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    @TaskParameter
    GBRemoteDevice f16191a;
    private int b = 30000;

    @Override // com.goodix.ble.libcomx.task.Task
    public int doWork() {
        this.f16191a.evtReady().subEvent(this).setExecutor(getExecutor()).register2(this);
        if (!this.f16191a.isReady()) {
            return this.b;
        }
        finishedWithDone();
        return 0;
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public void onCleanup() {
        this.f16191a.evtReady().clear(this);
    }

    @Override // com.goodix.ble.libcomx.event.IEventListener
    public void onEvent(Object obj, int i, Boolean bool) {
        if (obj == this.f16191a && i == 108) {
            if (bool.booleanValue()) {
                finishedWithDone();
            } else {
                finishedWithError("Failed to setup GATT.");
            }
        }
    }

    public WaitGattReadyTask setGatt(GBRemoteDevice gBRemoteDevice) {
        this.f16191a = gBRemoteDevice;
        return this;
    }

    public WaitGattReadyTask setTimeout(int i) {
        this.b = i;
        return this;
    }
}
