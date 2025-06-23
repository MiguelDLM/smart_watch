package com.goodix.ble.gr.libdfu.task;

import com.goodix.ble.gr.libdfu.task.DeviceFirmwareUpdate;
import com.goodix.ble.gr.libdfu.task.param.DfuFileList;
import com.goodix.ble.gr.libdfu.task.sub.CheckOverlayTask;
import com.goodix.ble.gr.libdfu.task.sub.FwSelectionTask;
import com.goodix.ble.gr.libdfu.task.sub.GetCurrentBootInfoTask;
import com.goodix.ble.gr.libdfu.task.sub.GetImgListTask;
import com.goodix.ble.gr.libdfu.task.sub.TidyImgInfoListTask;
import com.goodix.ble.gr.libdfu.task.sub.UploadDfuFileTask;
import com.goodix.ble.gr.libdfu.task.util.UiExec;
import com.goodix.ble.libcomx.ILogger;
import com.goodix.ble.libcomx.event.IEventListener;
import com.goodix.ble.libcomx.task.ITaskResult;
import com.goodix.ble.libcomx.task.TaskQueue;
import com.goodix.ble.libcomx.transceiver.ITransceiver;
import java.util.concurrent.Executor;

/* loaded from: classes9.dex */
public class DeviceFirmwareUpdateAB implements IEventListener {
    private static final String h = "DeviceFirmwareUpdateAB";

    /* renamed from: a, reason: collision with root package name */
    private final TaskQueue f16098a;
    private final FwSelectionTask b;
    private final TidyImgInfoListTask c;
    private final UploadDfuFileTask d;
    private final CheckOverlayTask e;
    private DeviceFirmwareUpdate.Listener f;
    private ILogger g;

    public DeviceFirmwareUpdateAB() {
        FwSelectionTask fwSelectionTask = new FwSelectionTask();
        this.b = fwSelectionTask;
        TidyImgInfoListTask tidyImgInfoListTask = new TidyImgInfoListTask();
        this.c = tidyImgInfoListTask;
        UploadDfuFileTask uploadDfuFileTask = new UploadDfuFileTask();
        this.d = uploadDfuFileTask;
        CheckOverlayTask checkOverlayTask = new CheckOverlayTask();
        this.e = checkOverlayTask;
        TaskQueue taskQueue = new TaskQueue();
        this.f16098a = taskQueue;
        taskQueue.setAbortOnException(true);
        taskQueue.setExecutor((Executor) new UiExec());
        taskQueue.addTask(fwSelectionTask);
        taskQueue.addTask(new GetCurrentBootInfoTask());
        taskQueue.addTask(checkOverlayTask);
        taskQueue.addTask(new GetImgListTask());
        taskQueue.addTask(tidyImgInfoListTask);
        taskQueue.addTask(uploadDfuFileTask);
        tidyImgInfoListTask.setCanOverwrite(true);
        uploadDfuFileTask.setAsDfuMode(true);
        uploadDfuFileTask.setDebounceProgressEvent(true);
        tidyImgInfoListTask.evtStart().register(this);
        uploadDfuFileTask.evtProgress().register(this);
        taskQueue.evtFinished().register(this);
    }

    public void cancel() {
        this.f16098a.abort();
    }

    @Override // com.goodix.ble.libcomx.event.IEventListener
    public void onEvent(Object obj, int i, Object obj2) {
        DeviceFirmwareUpdate.Listener listener;
        DeviceFirmwareUpdate.Listener listener2;
        TaskQueue taskQueue = this.f16098a;
        if (obj == taskQueue && i == 340) {
            DeviceFirmwareUpdate.Listener listener3 = this.f;
            if (listener3 != null) {
                listener3.onDfuStart();
                return;
            }
            return;
        }
        if (obj == this.d && i == 341) {
            int intValue = ((Integer) obj2).intValue();
            DeviceFirmwareUpdate.Listener listener4 = this.f;
            if (listener4 != null) {
                listener4.onDfuProgressUpdate(intValue);
                return;
            }
            return;
        }
        if (obj == taskQueue && i == 342) {
            ITaskResult iTaskResult = (ITaskResult) obj2;
            if (iTaskResult.getCode() == -2) {
                DeviceFirmwareUpdate.Listener listener5 = this.f;
                if (listener5 != null) {
                    listener5.onDfuCanceled();
                }
            } else if (iTaskResult.getCode() == 0) {
                DeviceFirmwareUpdate.Listener listener6 = this.f;
                if (listener6 != null) {
                    listener6.onDfuComplete();
                }
            } else if (iTaskResult.getCode() == 800 && (listener = this.f) != null) {
                listener.onDfuErrorFirmwareOverlap();
                return;
            }
            if (iTaskResult.getError() != null && (listener2 = this.f) != null) {
                listener2.onDfuError(iTaskResult.getError().getRootCause().getMessage(), iTaskResult.getError());
            }
        }
    }

    public DeviceFirmwareUpdateAB setDfuFile(DfuFileList dfuFileList) {
        this.f16098a.setParameter(dfuFileList);
        return this;
    }

    public DeviceFirmwareUpdateAB setListener(DeviceFirmwareUpdate.Listener listener) {
        this.f = listener;
        return this;
    }

    public DeviceFirmwareUpdateAB setLogger(ILogger iLogger) {
        this.g = iLogger;
        this.f16098a.setLogger(iLogger);
        return this;
    }

    public DeviceFirmwareUpdateAB setTransceiver(ITransceiver iTransceiver) {
        this.f16098a.setParameter(ITransceiver.class, iTransceiver);
        return this;
    }

    public DeviceFirmwareUpdateAB start() {
        this.f16098a.start(null, null);
        return this;
    }
}
