package com.goodix.ble.gr.libdfu.task.sub;

import com.goodix.ble.gr.libdfu.define.MemoryLayout;
import com.goodix.ble.gr.libdfu.dfu.cmd.Cmd;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XSystemConfig;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XSystemConfigResponse;
import com.goodix.ble.gr.libdfu.dfu.entity.BootInfo;
import com.goodix.ble.gr.libdfu.dfu.entity.DfuFile;
import com.goodix.ble.gr.libdfu.task.param.DfuFileList;
import com.goodix.ble.libcomx.ILogger;
import com.goodix.ble.libcomx.event.IEventListener;
import com.goodix.ble.libcomx.task.Task;
import com.goodix.ble.libcomx.task.TaskOutput;
import com.goodix.ble.libcomx.task.TaskParameter;
import com.goodix.ble.libcomx.transceiver.IFrameSdu4Rx;
import com.goodix.ble.libcomx.transceiver.ITransceiver;
import com.goodix.ble.libcomx.util.IntUtil;
import java.util.Locale;

/* loaded from: classes9.dex */
public class FwSelectionTask extends Task implements IEventListener<IFrameSdu4Rx> {
    private static final String d = "FwSelectionTask";

    /* renamed from: a, reason: collision with root package name */
    @TaskParameter
    private ITransceiver f16112a;

    @TaskParameter
    private DfuFileList b;

    @TaskOutput
    private DfuFile c;

    @Override // com.goodix.ble.libcomx.task.Task
    public int doWork() {
        if (this.b.getList() != null && !this.b.getList().isEmpty()) {
            this.f16112a.evtRcvFrame().subEvent(this).setExecutor(getExecutor()).register(this);
            XSystemConfig txSdu = Cmd.SystemConfig.getTxSdu();
            MemoryLayout memoryLayout = MemoryLayout.BOOT_INFO;
            txSdu.address = memoryLayout.getAddress();
            txSdu.length = memoryLayout.getSize();
            txSdu.opUdate = false;
            if (this.f16112a.send(Cmd.SystemConfig.CODE, txSdu)) {
                return 5000;
            }
            finishedWithError(ResultCode.SEND_CMD_FAILD, "Failed to send command.");
            return 0;
        }
        finished(-4, null);
        return 0;
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public void onCleanup() {
        ITransceiver iTransceiver = this.f16112a;
        if (iTransceiver != null) {
            iTransceiver.evtRcvFrame().clear(this);
        }
    }

    @Override // com.goodix.ble.libcomx.event.IEventListener
    public void onEvent(Object obj, int i, IFrameSdu4Rx iFrameSdu4Rx) {
        if (i == Cmd.SystemConfig.CODE) {
            XSystemConfigResponse xSystemConfigResponse = (XSystemConfigResponse) iFrameSdu4Rx;
            if (xSystemConfigResponse.response == 1 && !xSystemConfigResponse.imgInfos.isEmpty()) {
                BootInfo bootInfo = xSystemConfigResponse.imgInfos.get(0).getBootInfo();
                for (DfuFile dfuFile : this.b.getList()) {
                    if (!IntUtil.memoryOverlap(bootInfo.getLoadAddr(), bootInfo.getAppSize(), dfuFile.getImgInfo().getBootInfo().getLoadAddr(), dfuFile.getImgInfo().getBootInfo().getAppSize())) {
                        ILogger iLogger = this.logger;
                        if (iLogger != null) {
                            iLogger.v(d, String.format(Locale.US, "Selected: 0x%08X  %s", Integer.valueOf(dfuFile.getImgInfo().getBootInfo().getLoadAddr()), dfuFile.getImgInfo().getComment()));
                        }
                        this.c = dfuFile;
                        setParameter(DfuFile.class, dfuFile);
                        finished(0, null);
                        return;
                    }
                }
                finishedWithError(ResultCode.INVALID_FILE, "Invalid DFU file list.");
            }
            finishedWithError(67, "Failed to get image list.");
        }
    }
}
