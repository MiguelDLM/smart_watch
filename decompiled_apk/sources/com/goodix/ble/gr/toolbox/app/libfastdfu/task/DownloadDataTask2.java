package com.goodix.ble.gr.toolbox.app.libfastdfu.task;

import com.goodix.ble.gr.libdfu.dfu.entity.DfuFile;
import com.goodix.ble.libble.v2.gb.procedure.GBGattProcedureWrite;
import com.goodix.ble.libble.v2.impl.procedure.CharacteristicWrite;
import com.goodix.ble.libcomx.ILogger;
import com.goodix.ble.libcomx.event.EventDisposer;
import com.goodix.ble.libcomx.event.IEventListener;
import com.goodix.ble.libcomx.task.ITaskResult;
import com.goodix.ble.libcomx.task.Task;
import com.goodix.ble.libcomx.task.TaskParameter;
import com.goodix.ble.libcomx.util.HexBuilder;

/* loaded from: classes9.dex */
public class DownloadDataTask2 extends Task implements IEventListener {
    private static final int h = 2;

    /* renamed from: a, reason: collision with root package name */
    @TaskParameter
    private DfuFile f16133a;

    @TaskParameter
    private FastDfuProfile b;
    private GBGattProcedureWrite d;
    private GBGattProcedureWrite e;
    private ILogger g;
    private final EventDisposer c = new EventDisposer();
    private int f = 5000;

    @Override // com.goodix.ble.libcomx.task.Task
    public int doWork() {
        byte[] firmware = this.f16133a.getFirmware();
        GBGattProcedureWrite writeByCommand = this.b.getFdsDat().writeByCommand(null, false);
        this.d = writeByCommand;
        ((CharacteristicWrite) writeByCommand).setLargeValue(firmware, 0, firmware.length);
        HexBuilder hexBuilder = new HexBuilder(5);
        hexBuilder.put(1196379972, 4);
        hexBuilder.put(2, 1);
        this.e = this.b.getFdsCmd().writeByCommand(hexBuilder.getBuffer(), false);
        this.b.getFdsCmd().evtNotify().subEvent().setExecutor(getExecutor()).setDisposer(this.c).register(this);
        this.d.evtProgress().subEvent().setExecutor(getExecutor()).setDisposer(this.c).register(this);
        this.d.evtFinished().subEvent().setExecutor(getExecutor()).setDisposer(this.c).register(this);
        this.e.evtFinished().subEvent().setExecutor(getExecutor()).setDisposer(this.c).register(this);
        this.d.setDebounceProgressEvent(false);
        this.d.start(this, null);
        this.b.getSpeedometer().start();
        ILogger logger = this.b.getRemoteDevice().getLogger();
        this.g = logger;
        if (logger != null) {
            this.b.getRemoteDevice().setLogger(null);
            this.g.i(getName(), "remove logger for high speed temporarily.");
        }
        return this.f;
    }

    @Override // com.goodix.ble.libcomx.task.Task
    public void onCleanup() {
        super.onCleanup();
        this.c.disposeAll(this);
        FastDfuProfile fastDfuProfile = this.b;
        if (fastDfuProfile != null) {
            fastDfuProfile.getSpeedometer().stop();
            ILogger iLogger = this.g;
            if (iLogger != null) {
                iLogger.i(getName(), "recover logger.");
                this.b.getRemoteDevice().setLogger(this.g);
            }
            GBGattProcedureWrite gBGattProcedureWrite = this.d;
            if (gBGattProcedureWrite != null) {
                gBGattProcedureWrite.abort();
            }
        }
    }

    @Override // com.goodix.ble.libcomx.event.IEventListener
    public void onEvent(Object obj, int i, Object obj2) {
        byte[] bArr;
        ITaskResult iTaskResult;
        if (obj == this.d) {
            if (i == 341) {
                publishProgress(((Integer) obj2).intValue());
                return;
            } else {
                if (i != 342) {
                    return;
                }
                iTaskResult = (ITaskResult) obj2;
                if (iTaskResult.getError() == null) {
                    refreshTaskTimeout();
                    this.e.start(this, this.d);
                    return;
                }
            }
        } else {
            if (obj != this.e || i != 342) {
                if (obj == this.b.getFdsCmd() && i == 55 && (bArr = (byte[]) obj2) != null && bArr.length == 1 && bArr[0] == 2) {
                    finishedWithDone();
                    return;
                }
                return;
            }
            iTaskResult = (ITaskResult) obj2;
            if (iTaskResult.getError() == null) {
                return;
            }
        }
        finished(iTaskResult.getCode(), iTaskResult.getError());
    }

    public DownloadDataTask2 setTimeout(int i) {
        this.f = i;
        return this;
    }
}
