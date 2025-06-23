package com.goodix.ble.gr.toolbox.app.libfastdfu;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.goodix.ble.gr.libdfu.dfu.entity.DfuFile;
import com.goodix.ble.gr.libdfu.task.util.UiExec;
import com.goodix.ble.gr.toolbox.app.libfastdfu.task.ChecksumTask;
import com.goodix.ble.gr.toolbox.app.libfastdfu.task.DownloadDataTask;
import com.goodix.ble.gr.toolbox.app.libfastdfu.task.DownloadDataTask2;
import com.goodix.ble.gr.toolbox.app.libfastdfu.task.EraseFlashTask;
import com.goodix.ble.gr.toolbox.app.libfastdfu.task.FastDfuProfile;
import com.goodix.ble.gr.toolbox.app.libfastdfu.task.FlashSelectTask;
import com.goodix.ble.gr.toolbox.app.libfastdfu.task.GetVersionTask;
import com.goodix.ble.gr.toolbox.app.libfastdfu.task.StartCopyTask;
import com.goodix.ble.gr.toolbox.app.libfastdfu.task.WirteBootInfoTask;
import com.goodix.ble.libble.v2.gb.GBRemoteDevice;
import com.goodix.ble.libble.v2.impl.BleRemoteDevice;
import com.goodix.ble.libcomx.ILogger;
import com.goodix.ble.libcomx.event.IEventListener;
import com.goodix.ble.libcomx.task.ITask;
import com.goodix.ble.libcomx.task.ITaskResult;
import com.goodix.ble.libcomx.task.TaskError;
import com.goodix.ble.libcomx.task.TaskQueue;
import com.goodix.ble.libcomx.util.SimpleTask;
import java.io.InputStream;

/* loaded from: classes9.dex */
public class FastDfu {
    private static final int e = 0;
    private static final int f = 1;
    private static final int g = 2;

    /* renamed from: a, reason: collision with root package name */
    private FastDfuProgressCallback f16125a;
    private boolean b;
    private ITask c;
    private ILogger d;

    /* loaded from: classes9.dex */
    public class a implements SimpleTask.Work {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TaskQueue f16126a;

        public a(TaskQueue taskQueue) {
            this.f16126a = taskQueue;
        }

        @Override // com.goodix.ble.libcomx.util.SimpleTask.Work
        public void onWork(SimpleTask simpleTask, Object obj) {
            TaskQueue taskQueue;
            ITask downloadDataTask;
            GetVersionTask getVersionTask = (GetVersionTask) simpleTask.getPreviousTask();
            this.f16126a.clearTask();
            if (getVersionTask.version == 3) {
                taskQueue = this.f16126a;
                downloadDataTask = new DownloadDataTask2();
            } else {
                taskQueue = this.f16126a;
                downloadDataTask = new DownloadDataTask();
            }
            taskQueue.addTask(downloadDataTask);
        }
    }

    /* loaded from: classes9.dex */
    public class b implements IEventListener<Void> {
        public b() {
        }

        @Override // com.goodix.ble.libcomx.event.IEventListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onEvent(Object obj, int i, Void r3) {
            FastDfu.this.b = true;
            if (FastDfu.this.f16125a != null) {
                FastDfu.this.f16125a.onDfuStart();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements IEventListener<ITaskResult> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ EraseFlashTask f16128a;
        final /* synthetic */ TaskQueue b;
        final /* synthetic */ GBRemoteDevice c;

        public c(EraseFlashTask eraseFlashTask, TaskQueue taskQueue, GBRemoteDevice gBRemoteDevice) {
            this.f16128a = eraseFlashTask;
            this.b = taskQueue;
            this.c = gBRemoteDevice;
        }

        @Override // com.goodix.ble.libcomx.event.IEventListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onEvent(Object obj, int i, ITaskResult iTaskResult) {
            FastDfuProgressCallback fastDfuProgressCallback;
            String message;
            TaskError error;
            FastDfu.this.b = false;
            if (FastDfu.this.f16125a != null) {
                if (iTaskResult.getError() != null) {
                    int code = iTaskResult.getCode();
                    if (code == 230) {
                        fastDfuProgressCallback = FastDfu.this.f16125a;
                        error = iTaskResult.getError();
                        message = "OVERLAP";
                    } else if (code == -2) {
                        fastDfuProgressCallback = FastDfu.this.f16125a;
                        error = iTaskResult.getError();
                        message = "ABORT";
                    } else if (code == 113) {
                        fastDfuProgressCallback = FastDfu.this.f16125a;
                        error = iTaskResult.getError();
                        message = "FAILED";
                    } else if (code == 114) {
                        fastDfuProgressCallback = FastDfu.this.f16125a;
                        error = iTaskResult.getError();
                        message = "NO_EXT_FLASH";
                    } else {
                        fastDfuProgressCallback = FastDfu.this.f16125a;
                        message = iTaskResult.getError().getMessage();
                        error = iTaskResult.getError();
                    }
                    fastDfuProgressCallback.onDfuError(code, message, error);
                } else {
                    FastDfu.this.f16125a.onDfuComplete();
                }
            }
            this.f16128a.evtProgress().clear(FastDfu.this);
            this.b.evtProgress().clear(FastDfu.this);
            if (((ITask) obj).getParameter("releaseConnection") == Boolean.TRUE) {
                this.c.disconnect(true).startProcedure();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements IEventListener<Integer> {
        public d() {
        }

        @Override // com.goodix.ble.libcomx.event.IEventListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onEvent(Object obj, int i, Integer num) {
            if (FastDfu.this.f16125a != null) {
                FastDfu.this.f16125a.onDfuErase(num.intValue());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements IEventListener<Integer> {
        public e() {
        }

        @Override // com.goodix.ble.libcomx.event.IEventListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onEvent(Object obj, int i, Integer num) {
            if (FastDfu.this.f16125a != null) {
                FastDfu.this.f16125a.onDfuProgress(num.intValue());
            }
        }
    }

    public boolean cancel() {
        ITask iTask;
        if (!this.b || (iTask = this.c) == null) {
            return false;
        }
        iTask.abort();
        return true;
    }

    public void setListener(FastDfuProgressCallback fastDfuProgressCallback) {
        this.f16125a = fastDfuProgressCallback;
    }

    public void setLogger(ILogger iLogger) {
        this.d = iLogger;
    }

    public boolean startDfu(Context context, BluetoothDevice bluetoothDevice, InputStream inputStream) {
        if (this.b) {
            return false;
        }
        BleRemoteDevice bleRemoteDevice = new BleRemoteDevice(context);
        bleRemoteDevice.setBluetoothDevice(bluetoothDevice);
        bleRemoteDevice.setLogger(this.d);
        FastDfuProfile fastDfuProfile = new FastDfuProfile();
        fastDfuProfile.bindTo(bleRemoteDevice);
        TaskQueue a2 = a(context, fastDfuProfile, inputStream, 0, false, 0);
        this.c = a2;
        a2.start(null, null);
        return true;
    }

    public boolean startDfuInCopyMode(Context context, BluetoothDevice bluetoothDevice, InputStream inputStream, int i) {
        if (this.b) {
            return false;
        }
        BleRemoteDevice bleRemoteDevice = new BleRemoteDevice(context);
        bleRemoteDevice.setBluetoothDevice(bluetoothDevice);
        bleRemoteDevice.setLogger(this.d);
        FastDfuProfile fastDfuProfile = new FastDfuProfile();
        fastDfuProfile.bindTo(bleRemoteDevice);
        TaskQueue a2 = a(context, fastDfuProfile, inputStream, 1, false, i);
        this.c = a2;
        a2.start(null, null);
        return true;
    }

    public boolean startUpdateResource(Context context, BluetoothDevice bluetoothDevice, InputStream inputStream, boolean z, int i) {
        if (this.b) {
            return false;
        }
        BleRemoteDevice bleRemoteDevice = new BleRemoteDevice(context);
        bleRemoteDevice.setBluetoothDevice(bluetoothDevice);
        bleRemoteDevice.setLogger(this.d);
        FastDfuProfile fastDfuProfile = new FastDfuProfile();
        fastDfuProfile.bindTo(bleRemoteDevice);
        TaskQueue a2 = a(context, fastDfuProfile, inputStream, 2, z, i);
        this.c = a2;
        a2.start(null, null);
        return true;
    }

    private TaskQueue a(Context context, FastDfuProfile fastDfuProfile, InputStream inputStream, int i, boolean z, int i2) {
        ITask startCopyTask;
        String str;
        TaskQueue taskQueue = new TaskQueue();
        taskQueue.setAbortOnException(true);
        taskQueue.setOneshot(true);
        taskQueue.setName("FastDfuSteps");
        DfuFile dfuFile = new DfuFile();
        dfuFile.load(inputStream);
        taskQueue.setParameter(DfuFile.class, dfuFile);
        GBRemoteDevice remoteDevice = fastDfuProfile.getRemoteDevice();
        taskQueue.setParameter(FastDfuProfile.class, fastDfuProfile);
        if (!remoteDevice.isConnected()) {
            taskQueue.addTask(remoteDevice.connect(0).setRetry(10, 1000));
            taskQueue.addTask(remoteDevice.discoverServices());
            taskQueue.addTask(remoteDevice.setMtu(247));
            taskQueue.setParameter("releaseConnection", (String) Boolean.TRUE);
        }
        EraseFlashTask eraseFlashTask = new EraseFlashTask(fastDfuProfile, i != 0 ? i2 : dfuFile.getImgInfo().getBootInfo().getLoadAddr(), dfuFile.getFirmware().length);
        taskQueue.addTask(new FlashSelectTask(i == 2 && z));
        taskQueue.addTask(eraseFlashTask);
        TaskQueue taskQueue2 = new TaskQueue();
        taskQueue2.setAbortOnException(true);
        taskQueue2.setName("DownloadDataTaskWrapper");
        taskQueue.addTask(new GetVersionTask());
        taskQueue.addTask(new SimpleTask("JudgeVersion", 0, new a(taskQueue2)));
        taskQueue.addTask(taskQueue2);
        taskQueue.addTask(new ChecksumTask());
        if (i != 0) {
            if (i == 1) {
                startCopyTask = new StartCopyTask(fastDfuProfile, dfuFile.getImgInfo(), i2, dfuFile.getFirmware().length);
                str = "开始拷贝";
            }
            UiExec uiExec = new UiExec();
            taskQueue.evtStart().setExecutor(uiExec).register2(new b());
            taskQueue.evtFinished().setExecutor(uiExec).register2(new c(eraseFlashTask, taskQueue2, remoteDevice));
            eraseFlashTask.evtProgress().subEvent(this).setExecutor(uiExec).register2(new d());
            taskQueue2.evtProgress().subEvent(this).setExecutor(uiExec).register2(new e());
            taskQueue.setLogger(this.d);
            return taskQueue;
        }
        startCopyTask = new WirteBootInfoTask(fastDfuProfile, dfuFile.getImgInfo());
        str = "写BootInfo";
        taskQueue.addTask(startCopyTask.setName(str));
        UiExec uiExec2 = new UiExec();
        taskQueue.evtStart().setExecutor(uiExec2).register2(new b());
        taskQueue.evtFinished().setExecutor(uiExec2).register2(new c(eraseFlashTask, taskQueue2, remoteDevice));
        eraseFlashTask.evtProgress().subEvent(this).setExecutor(uiExec2).register2(new d());
        taskQueue2.evtProgress().subEvent(this).setExecutor(uiExec2).register2(new e());
        taskQueue.setLogger(this.d);
        return taskQueue;
    }

    public boolean startDfu(Context context, FastDfuProfile fastDfuProfile, InputStream inputStream) {
        if (this.b) {
            return false;
        }
        TaskQueue a2 = a(context, fastDfuProfile, inputStream, 0, false, 0);
        this.c = a2;
        a2.start(null, null);
        return true;
    }

    public boolean startDfuInCopyMode(Context context, FastDfuProfile fastDfuProfile, InputStream inputStream, int i) {
        if (this.b) {
            return false;
        }
        TaskQueue a2 = a(context, fastDfuProfile, inputStream, 1, false, i);
        this.c = a2;
        a2.start(null, null);
        return true;
    }

    public boolean startUpdateResource(Context context, FastDfuProfile fastDfuProfile, InputStream inputStream, boolean z, int i) {
        if (this.b) {
            return false;
        }
        TaskQueue a2 = a(context, fastDfuProfile, inputStream, 2, z, i);
        this.c = a2;
        a2.start(null, null);
        return true;
    }
}
