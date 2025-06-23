package com.goodix.ble.libble.v2.misc;

import com.goodix.ble.libble.v2.gb.GBRemoteDevice;
import com.goodix.ble.libcomx.event.IEventListener;
import com.goodix.ble.libcomx.task.Task;
import com.goodix.ble.libcomx.task.TaskParameter;

/* loaded from: classes9.dex */
public class WaitConnectionTask extends Task implements IEventListener<Integer> {

    /* renamed from: a, reason: collision with root package name */
    @TaskParameter
    private GBRemoteDevice f16189a;
    private int b = 30000;

    @Override // com.goodix.ble.libcomx.task.Task
    public int doWork() {
        GBRemoteDevice gBRemoteDevice = this.f16189a;
        if (gBRemoteDevice == null) {
            finishedWithError("Device is null.");
            return 0;
        }
        gBRemoteDevice.evtStateChanged().subEvent(this).setExecutor(getExecutor()).register2(this);
        if (this.f16189a.isConnected()) {
            finishedWithDone();
        }
        return this.b;
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public void onCleanup() {
        super.onCleanup();
        GBRemoteDevice gBRemoteDevice = this.f16189a;
        if (gBRemoteDevice != null) {
            gBRemoteDevice.evtStateChanged().clear(this);
        }
    }

    @Override // com.goodix.ble.libcomx.event.IEventListener
    public void onEvent(Object obj, int i, Integer num) {
        if (num.intValue() == 2) {
            finishedWithDone();
        }
    }

    public WaitConnectionTask setDevice(GBRemoteDevice gBRemoteDevice) {
        this.f16189a = gBRemoteDevice;
        return this;
    }

    public WaitConnectionTask setTimeout(int i) {
        this.b = i;
        return this;
    }
}
