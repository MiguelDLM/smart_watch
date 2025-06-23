package com.goodix.ble.gr.libdfu.task.sub;

import com.goodix.ble.gr.libdfu.dfu.cmd.Cmd;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XConfigExtFlash;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XEmptyResponse;
import com.goodix.ble.libcomx.event.Event;
import com.goodix.ble.libcomx.event.IEventListener;
import com.goodix.ble.libcomx.task.Task;
import com.goodix.ble.libcomx.task.TaskParameter;
import com.goodix.ble.libcomx.transceiver.IFrameSdu4Rx;
import com.goodix.ble.libcomx.transceiver.ITransceiver;

/* loaded from: classes9.dex */
public class CfgExtFlashTask extends Task implements IEventListener<IFrameSdu4Rx> {

    /* renamed from: a, reason: collision with root package name */
    @TaskParameter
    private ITransceiver f16110a;

    @TaskParameter
    private XConfigExtFlash b;
    private Event c;

    @Override // com.goodix.ble.libcomx.task.Task
    public int doWork() {
        Event<IFrameSdu4Rx> subEvent = this.f16110a.evtRcvFrame().subEvent();
        this.c = subEvent;
        subEvent.setExecutor(getExecutor());
        this.c.register(this);
        if (this.f16110a.send(Cmd.ConfigExtFlash.CODE, this.b)) {
            return 5000;
        }
        finishedWithError(ResultCode.SEND_CMD_FAILD, "Failed to send command.");
        return 0;
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public void onCleanup() {
        Event event = this.c;
        if (event != null) {
            event.clear();
            this.c = null;
        }
    }

    @Override // com.goodix.ble.libcomx.event.IEventListener
    public void onEvent(Object obj, int i, IFrameSdu4Rx iFrameSdu4Rx) {
        if (i == Cmd.ConfigExtFlash.CODE) {
            if (((XEmptyResponse) iFrameSdu4Rx).response == 1) {
                finished(0, null);
            } else {
                finishedWithError(23, "Failed to reset device.");
            }
        }
    }
}
