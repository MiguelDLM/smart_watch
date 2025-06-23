package com.goodix.ble.gr.libdfu.task;

import com.goodix.ble.gr.libdfu.dfu.entity.DfuFile;
import com.goodix.ble.gr.libdfu.task.param.SkipOverwriteCheck;
import com.goodix.ble.gr.libdfu.task.sub.CheckOverlayTask;
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
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.Executor;

/* loaded from: classes9.dex */
public class DeviceFirmwareUpdate implements IEventListener {
    private static final String h = "DeviceFirmwareUpdate";

    /* renamed from: a, reason: collision with root package name */
    private final TaskQueue f16097a;
    private final TidyImgInfoListTask b;
    private final UploadDfuFileTask c;
    private final CheckOverlayTask d;
    private Listener e;
    private ILogger f;
    private final SkipOverwriteCheck g = new SkipOverwriteCheck(false);

    /* loaded from: classes9.dex */
    public interface Listener {
        void onDfuCanceled();

        void onDfuComplete();

        void onDfuError(String str, Error error);

        void onDfuErrorFirmwareOverlap();

        void onDfuProgressUpdate(int i);

        void onDfuStart();
    }

    public DeviceFirmwareUpdate() {
        TidyImgInfoListTask tidyImgInfoListTask = new TidyImgInfoListTask();
        this.b = tidyImgInfoListTask;
        UploadDfuFileTask uploadDfuFileTask = new UploadDfuFileTask();
        this.c = uploadDfuFileTask;
        CheckOverlayTask checkOverlayTask = new CheckOverlayTask();
        this.d = checkOverlayTask;
        TaskQueue taskQueue = new TaskQueue();
        this.f16097a = taskQueue;
        taskQueue.setAbortOnException(true);
        taskQueue.setExecutor((Executor) new UiExec());
        taskQueue.addTask(new GetCurrentBootInfoTask());
        taskQueue.addTask(checkOverlayTask);
        taskQueue.addTask(new GetImgListTask());
        taskQueue.addTask(tidyImgInfoListTask);
        taskQueue.addTask(uploadDfuFileTask);
        tidyImgInfoListTask.evtStart().register(this);
        uploadDfuFileTask.evtProgress().register(this);
        taskQueue.evtFinished().register(this);
        uploadDfuFileTask.setDebounceProgressEvent(true);
    }

    public void cancel() {
        this.f16097a.abort();
    }

    public UploadDfuFileTask getUploadDfuFileTask() {
        return this.c;
    }

    @Override // com.goodix.ble.libcomx.event.IEventListener
    public void onEvent(Object obj, int i, Object obj2) {
        Listener listener;
        Listener listener2;
        if (obj == this.b && i == 340) {
            Listener listener3 = this.e;
            if (listener3 != null) {
                listener3.onDfuStart();
                return;
            }
            return;
        }
        if (obj == this.c && i == 341) {
            if (this.e != null) {
                this.e.onDfuProgressUpdate(((Integer) obj2).intValue());
                return;
            }
            return;
        }
        if (obj == this.f16097a && i == 342) {
            ITaskResult iTaskResult = (ITaskResult) obj2;
            if (iTaskResult.getCode() == -2) {
                Listener listener4 = this.e;
                if (listener4 != null) {
                    listener4.onDfuCanceled();
                }
            } else if (iTaskResult.getCode() == 0) {
                Listener listener5 = this.e;
                if (listener5 != null) {
                    listener5.onDfuComplete();
                }
            } else if (iTaskResult.getCode() == 800 && (listener = this.e) != null) {
                listener.onDfuErrorFirmwareOverlap();
                return;
            }
            if (iTaskResult.getError() != null && (listener2 = this.e) != null) {
                listener2.onDfuError(iTaskResult.getError().getRootCause().getMessage(), iTaskResult.getError());
            }
        }
    }

    public DeviceFirmwareUpdate setAsCopyMode(int i) {
        setOverwriteFw(true);
        this.c.setAsCopyMode(i);
        this.d.setStartAddressInFlash(Integer.valueOf(i), false, false);
        return this;
    }

    public DeviceFirmwareUpdate setAsDfuMode(boolean z) {
        this.c.setAsDfuMode(z);
        this.d.setStartAddressInFlash(null, false, false);
        return this;
    }

    public DeviceFirmwareUpdate setDfuFile(File file) {
        try {
            DfuFile dfuFile = new DfuFile();
            FileInputStream fileInputStream = new FileInputStream(file);
            dfuFile.load(fileInputStream);
            this.f16097a.setParameter(DfuFile.class, dfuFile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            ILogger iLogger = this.f;
            if (iLogger != null) {
                iLogger.e(h, "Can not open the file: " + file.getAbsolutePath(), e);
            }
        }
        return this;
    }

    public DeviceFirmwareUpdate setListener(Listener listener) {
        this.e = listener;
        return this;
    }

    public DeviceFirmwareUpdate setLogger(ILogger iLogger) {
        this.f = iLogger;
        this.f16097a.setLogger(iLogger);
        return this;
    }

    public DeviceFirmwareUpdate setOverwriteFw(boolean z) {
        this.g.setSkip(z);
        this.f16097a.setParameter(this.g);
        return this;
    }

    public DeviceFirmwareUpdate setTransceiver(ITransceiver iTransceiver) {
        this.f16097a.setParameter(ITransceiver.class, iTransceiver);
        return this;
    }

    public DeviceFirmwareUpdate start() {
        this.f16097a.start(null, null);
        return this;
    }

    public DeviceFirmwareUpdate setDfuFile(DfuFile dfuFile) {
        this.f16097a.setParameter(DfuFile.class, dfuFile);
        return this;
    }
}
