package com.goodix.ble.gr.libdfu.task;

import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XConfigExtFlash;
import com.goodix.ble.gr.libdfu.task.param.ExtFlashId;
import com.goodix.ble.gr.libdfu.task.sub.CfgExtFlashTask;
import com.goodix.ble.gr.libdfu.task.sub.GetExtFlashIdTask;
import com.goodix.ble.gr.libdfu.task.util.UiExec;
import com.goodix.ble.libcomx.ILogger;
import com.goodix.ble.libcomx.event.IEventListener;
import com.goodix.ble.libcomx.task.ITaskResult;
import com.goodix.ble.libcomx.task.TaskQueue;
import com.goodix.ble.libcomx.transceiver.ITransceiver;
import java.util.concurrent.Executor;

/* loaded from: classes9.dex */
public class DeviceExtFlashCfg {
    private static final String f = "DeviceExtFlashCfg";

    /* renamed from: a, reason: collision with root package name */
    private TaskQueue f16094a;
    private final CfgExtFlashTask b;
    private final GetExtFlashIdTask c;
    private Listener d;
    private ILogger e;

    /* loaded from: classes9.dex */
    public interface Listener {
        void onExtFlashCfgCanceled();

        void onExtFlashCfgComplete(int i);

        void onExtFlashCfgError(String str, Error error);

        void onExtFlashCfgStart();
    }

    /* loaded from: classes9.dex */
    public class a implements IEventListener<Void> {
        public a() {
        }

        @Override // com.goodix.ble.libcomx.event.IEventListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onEvent(Object obj, int i, Void r3) {
            if (DeviceExtFlashCfg.this.d != null) {
                DeviceExtFlashCfg.this.d.onExtFlashCfgStart();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements IEventListener<ITaskResult> {
        public b() {
        }

        @Override // com.goodix.ble.libcomx.event.IEventListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onEvent(Object obj, int i, ITaskResult iTaskResult) {
            if (iTaskResult.getCode() == -2) {
                if (DeviceExtFlashCfg.this.d != null) {
                    DeviceExtFlashCfg.this.d.onExtFlashCfgCanceled();
                }
            } else if (iTaskResult.getCode() == 0 && DeviceExtFlashCfg.this.d != null) {
                ExtFlashId extFlashId = DeviceExtFlashCfg.this.c.getExtFlashId();
                if (extFlashId != null) {
                    DeviceExtFlashCfg.this.d.onExtFlashCfgComplete(extFlashId.getId());
                } else {
                    DeviceExtFlashCfg.this.d.onExtFlashCfgComplete(0);
                }
            }
            if (iTaskResult.getError() != null && DeviceExtFlashCfg.this.d != null) {
                DeviceExtFlashCfg.this.d.onExtFlashCfgError(iTaskResult.getError().getRootCause().getMessage(), iTaskResult.getError());
            }
        }
    }

    public DeviceExtFlashCfg() {
        CfgExtFlashTask cfgExtFlashTask = new CfgExtFlashTask();
        this.b = cfgExtFlashTask;
        GetExtFlashIdTask getExtFlashIdTask = new GetExtFlashIdTask();
        this.c = getExtFlashIdTask;
        TaskQueue taskQueue = new TaskQueue();
        this.f16094a = taskQueue;
        taskQueue.setAbortOnException();
        this.f16094a.setExecutor((Executor) new UiExec());
        this.f16094a.setOneshot(true);
        this.f16094a.addTask(cfgExtFlashTask);
        this.f16094a.addTask(getExtFlashIdTask);
    }

    public void cancel() {
        this.f16094a.abort();
    }

    public DeviceExtFlashCfg setListener(Listener listener) {
        this.d = listener;
        return this;
    }

    public DeviceExtFlashCfg setLogger(ILogger iLogger) {
        this.e = iLogger;
        this.f16094a.setLogger(iLogger);
        return this;
    }

    public DeviceExtFlashCfg setTranceiver(ITransceiver iTransceiver) {
        this.f16094a.setParameter(ITransceiver.class, iTransceiver);
        return this;
    }

    public DeviceExtFlashCfg start(XConfigExtFlash xConfigExtFlash) {
        if (xConfigExtFlash == null) {
            return this;
        }
        this.f16094a.setParameter(XConfigExtFlash.class, xConfigExtFlash);
        this.f16094a.evtStart().register(new a());
        this.f16094a.evtFinished().register(new b());
        this.f16094a.start(null, null);
        return this;
    }
}
