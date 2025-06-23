package com.goodix.ble.gr.libdfu.task.sub;

import com.goodix.ble.gr.libdfu.dfu.cmd.Cmd;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XGetFlashInfoResponse;
import com.goodix.ble.gr.libdfu.task.param.ExtFlashId;
import com.goodix.ble.libcomx.event.Event;
import com.goodix.ble.libcomx.event.IEventListener;
import com.goodix.ble.libcomx.task.Task;
import com.goodix.ble.libcomx.task.TaskOutput;
import com.goodix.ble.libcomx.task.TaskParameter;
import com.goodix.ble.libcomx.transceiver.IFrameSdu4Rx;
import com.goodix.ble.libcomx.transceiver.ITransceiver;

/* loaded from: classes9.dex */
public class GetExtFlashIdTask extends Task implements IEventListener<IFrameSdu4Rx> {

    /* renamed from: a, reason: collision with root package name */
    @TaskParameter
    private ITransceiver f16113a;

    @TaskOutput
    private ExtFlashId b;
    private Event c;

    @Override // com.goodix.ble.libcomx.task.Task
    public int doWork() {
        Event<IFrameSdu4Rx> subEvent = this.f16113a.evtRcvFrame().subEvent();
        this.c = subEvent;
        subEvent.setExecutor(getExecutor());
        this.c.register(this);
        if (this.f16113a.send(Cmd.GetExtFlashId.CODE, Cmd.GetExtFlashId.getTxSdu().setFlashType(true))) {
            return 5000;
        }
        finishedWithError(ResultCode.SEND_CMD_FAILD, "Failed to send command.");
        return 0;
    }

    public ExtFlashId getExtFlashId() {
        return this.b;
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
        if (i == Cmd.GetExtFlashId.CODE) {
            XGetFlashInfoResponse xGetFlashInfoResponse = (XGetFlashInfoResponse) iFrameSdu4Rx;
            if (xGetFlashInfoResponse.response == 1) {
                ExtFlashId extFlashId = new ExtFlashId();
                this.b = extFlashId;
                extFlashId.setId(xGetFlashInfoResponse.id);
                setParameter(this.b);
                finished(0, null);
                return;
            }
            finishedWithError(23, "Failed to reset device.");
        }
    }
}
