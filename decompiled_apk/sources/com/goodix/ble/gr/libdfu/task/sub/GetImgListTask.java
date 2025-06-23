package com.goodix.ble.gr.libdfu.task.sub;

import com.goodix.ble.gr.libdfu.define.MemoryLayout;
import com.goodix.ble.gr.libdfu.dfu.cmd.Cmd;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XSystemConfig;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XSystemConfigResponse;
import com.goodix.ble.gr.libdfu.task.param.ImgInfoList;
import com.goodix.ble.libcomx.event.Event;
import com.goodix.ble.libcomx.event.IEventListener;
import com.goodix.ble.libcomx.task.Task;
import com.goodix.ble.libcomx.task.TaskOutput;
import com.goodix.ble.libcomx.task.TaskParameter;
import com.goodix.ble.libcomx.transceiver.IFrameSdu4Rx;
import com.goodix.ble.libcomx.transceiver.ITransceiver;

/* loaded from: classes9.dex */
public class GetImgListTask extends Task implements IEventListener<IFrameSdu4Rx> {

    /* renamed from: a, reason: collision with root package name */
    @TaskParameter
    private ITransceiver f16114a;
    private Event c;

    @TaskOutput
    private ImgInfoList b = new ImgInfoList();
    protected MemoryLayout targetMemory = MemoryLayout.SYSTEM_CONFIG;

    @Override // com.goodix.ble.libcomx.task.Task
    public int doWork() {
        Event<IFrameSdu4Rx> subEvent = this.f16114a.evtRcvFrame().subEvent();
        this.c = subEvent;
        subEvent.setExecutor(getExecutor());
        this.c.register(this);
        XSystemConfig txSdu = Cmd.SystemConfig.getTxSdu();
        txSdu.address = this.targetMemory.getAddress();
        txSdu.length = this.targetMemory.getSize();
        txSdu.opUdate = false;
        if (this.f16114a.send(Cmd.SystemConfig.CODE, txSdu)) {
            return 5000;
        }
        finishedWithError(ResultCode.SEND_CMD_FAILD, "Failed to send command.");
        return 0;
    }

    public ImgInfoList getImgInfoList() {
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
        if (i == Cmd.SystemConfig.CODE) {
            XSystemConfigResponse xSystemConfigResponse = (XSystemConfigResponse) iFrameSdu4Rx;
            this.b.setList(xSystemConfigResponse.imgInfos);
            this.b.setEncrypted(xSystemConfigResponse.opEncrypted);
            setParameter(this.b);
            if (xSystemConfigResponse.response == 1) {
                finished(0, null);
            } else {
                finishedWithError(67, "Failed to get image list.");
            }
        }
    }
}
