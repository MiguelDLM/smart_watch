package com.goodix.ble.gr.libdfu.task.sub;

import com.goodix.ble.gr.libdfu.define.MemoryLayout;
import com.goodix.ble.gr.libdfu.dfu.cmd.Cmd;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XSystemConfig;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XSystemConfigResponse;
import com.goodix.ble.gr.libdfu.dfu.entity.DfuFile;
import com.goodix.ble.gr.libdfu.task.param.ImgInfoList;
import com.goodix.ble.gr.libdfu.task.param.SkipOverwriteCheck;
import com.goodix.ble.gr.libdfu.util.ImgInfoUtil;
import com.goodix.ble.libcomx.event.Event;
import com.goodix.ble.libcomx.event.IEventListener;
import com.goodix.ble.libcomx.task.Task;
import com.goodix.ble.libcomx.task.TaskParameter;
import com.goodix.ble.libcomx.transceiver.IFrameSdu4Rx;
import com.goodix.ble.libcomx.transceiver.ITransceiver;

/* loaded from: classes9.dex */
public class TidyImgInfoListTask extends Task implements IEventListener<IFrameSdu4Rx> {

    /* renamed from: a, reason: collision with root package name */
    @TaskParameter
    private DfuFile f16116a;

    @TaskParameter
    private ITransceiver b;

    @TaskParameter
    private ImgInfoList c;

    @TaskParameter(nullable = true)
    private SkipOverwriteCheck d;
    private Event e;

    @Override // com.goodix.ble.libcomx.task.Task
    public int doWork() {
        if (!this.f16116a.isValidDfuFile()) {
            finishedWithError(ResultCode.INVALID_FILE, "DFU file is invalid.");
            return 0;
        }
        if (this.c.isEncrypted() != this.f16116a.isEncrypted()) {
            finishedWithError(ResultCode.INVALID_FILE, "Encryption of device is not equal to file: " + this.c.isEncrypted() + " != " + this.f16116a.isEncrypted());
            return 0;
        }
        if (ImgInfoUtil.checkCollision(this.f16116a.getImgInfo(), this.c.getList())) {
            SkipOverwriteCheck skipOverwriteCheck = this.d;
            if (skipOverwriteCheck != null && skipOverwriteCheck.isSkip()) {
                ImgInfoUtil.overwriteImgInfo(this.f16116a.getImgInfo(), this.c.getList());
                ImgInfoUtil.sortImgList(this.c.getList());
                Event<IFrameSdu4Rx> subEvent = this.b.evtRcvFrame().subEvent();
                this.e = subEvent;
                subEvent.setExecutor(getExecutor());
                this.e.register(this);
                XSystemConfig txSdu = Cmd.SystemConfig.getTxSdu();
                txSdu.address = MemoryLayout.SYSTEM_CONFIG.getAddress();
                txSdu.opUdate = true;
                txSdu.imgInfos = this.c.getList();
                if (this.b.send(Cmd.SystemConfig.CODE, txSdu)) {
                    return 5000;
                }
                finishedWithError(ResultCode.SEND_CMD_FAILD, "Failed to send command.");
            } else {
                finishedWithError(800, "DFU file could overwrite the firmware on device.");
            }
        } else {
            finishedWithDone();
        }
        return 0;
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public void onCleanup() {
        Event event = this.e;
        if (event != null) {
            event.clear();
            this.e = null;
        }
    }

    public TidyImgInfoListTask setCanOverwrite(boolean z) {
        SkipOverwriteCheck skipOverwriteCheck = this.d;
        if (skipOverwriteCheck != null) {
            skipOverwriteCheck.setSkip(z);
        } else {
            this.d = new SkipOverwriteCheck(z);
        }
        return this;
    }

    @Override // com.goodix.ble.libcomx.event.IEventListener
    public void onEvent(Object obj, int i, IFrameSdu4Rx iFrameSdu4Rx) {
        if (i == Cmd.SystemConfig.CODE) {
            XSystemConfigResponse xSystemConfigResponse = (XSystemConfigResponse) iFrameSdu4Rx;
            if (xSystemConfigResponse.response == 1) {
                if (xSystemConfigResponse.opUdated) {
                    finished(0, null);
                    return;
                }
                return;
            }
            finishedWithError(ResultCode.SET_IMG_LIST_FAILED, "Failed to update image list.");
        }
    }
}
