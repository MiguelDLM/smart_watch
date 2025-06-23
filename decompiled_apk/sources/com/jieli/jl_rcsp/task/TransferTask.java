package com.jieli.jl_rcsp.task;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.jieli.jl_filebrowse.FileBrowseManager;
import com.jieli.jl_filebrowse.bean.Folder;
import com.jieli.jl_filebrowse.bean.SDCardBean;
import com.jieli.jl_rcsp.constant.WatchError;
import com.jieli.jl_rcsp.impl.RcspOpImpl;
import com.jieli.jl_rcsp.interfaces.IHandleResult;
import com.jieli.jl_rcsp.interfaces.OnOperationCallback;
import com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback;
import com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.NotifyPrepareEnvCmd;
import com.jieli.jl_rcsp.model.command.data.DataCmd;
import com.jieli.jl_rcsp.model.command.file_op.CancelLargeFileTransferCmd;
import com.jieli.jl_rcsp.model.command.file_op.DeviceExtendParamCmd;
import com.jieli.jl_rcsp.model.command.file_op.LargeFileTransferGetNameCmd;
import com.jieli.jl_rcsp.model.command.file_op.LargeFileTransferOpCmd;
import com.jieli.jl_rcsp.model.command.file_op.StartLargeFileTransferCmd;
import com.jieli.jl_rcsp.model.command.file_op.StopLargeFileTransferCmd;
import com.jieli.jl_rcsp.model.device.DeviceInfo;
import com.jieli.jl_rcsp.model.parameter.DataParam;
import com.jieli.jl_rcsp.model.parameter.LargeFileTransferOpParam;
import com.jieli.jl_rcsp.model.parameter.StartLargeFileTransferParam;
import com.jieli.jl_rcsp.model.response.StartLargeFileTransferResponse;
import com.jieli.jl_rcsp.tool.BooleanRcspActionCallback;
import com.jieli.jl_rcsp.tool.CustomRcspActionCallback;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.CommandBuilder;
import com.jieli.jl_rcsp.util.CryptoUtil;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes10.dex */
public class TransferTask extends TaskBase {
    public String b;
    public final CacheVar c;
    public final Param d;
    public final Handler e;
    protected ExecutorService executor;
    public final OnRcspCallback f;
    public int maxRenameCount;

    /* loaded from: classes10.dex */
    public static class CacheVar {
        public static final int l = 50;

        /* renamed from: a, reason: collision with root package name */
        public RandomAccessFile f17954a;
        public short b;
        public int c;
        public long d;
        public int e;
        public int f;
        public final LinkedBlockingQueue<SendData> g;
        public boolean h;
        public long i;
        public long j;
        public long k;

        public CacheVar() {
            this.f = 0;
            this.g = new LinkedBlockingQueue<>();
            this.j = -1L;
            this.k = 50L;
        }

        public void a() {
            RandomAccessFile randomAccessFile = this.f17954a;
            if (randomAccessFile != null) {
                try {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } finally {
                    this.f17954a = null;
                }
            }
        }

        public void b() {
            this.c = 0;
            this.d = 0L;
            this.e = 0;
            this.f = 0;
            this.h = false;
            this.i = 0L;
            this.j = -1L;
            this.k = 50L;
            this.g.clear();
            a();
        }
    }

    /* loaded from: classes10.dex */
    public static class Param {
        public int devHandler;
        public String outputDirPath;
        public boolean appHasCrc16 = true;
        public boolean useFlash = false;
        public boolean isOtherEncode = false;
        public String encodeType = StandardCharsets.UTF_16LE.name();

        /* renamed from: a, reason: collision with root package name */
        public boolean f17955a = false;

        public String toString() {
            return "Param{devHandler=" + this.devHandler + ", appHasCrc16=" + this.appHasCrc16 + ", useFlash=" + this.useFlash + ", firmwareHasCrc16=" + this.f17955a + ", isOtherEncode=" + this.isOtherEncode + ", encodeType=" + this.encodeType + ", outputDirPath=" + this.outputDirPath + '}';
        }
    }

    /* loaded from: classes10.dex */
    public static class SendData {

        /* renamed from: a, reason: collision with root package name */
        public int f17956a;
        public byte[] b;

        public SendData(int i, byte[] bArr) {
            this.f17956a = i;
            this.b = bArr;
        }
    }

    public TransferTask(RcspOpImpl rcspOpImpl, String str, Param param) throws RuntimeException {
        super(rcspOpImpl);
        this.maxRenameCount = 9;
        this.executor = Executors.newSingleThreadExecutor();
        this.e = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.jieli.jl_rcsp.task.Oxx0IOOO
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean a2;
                a2 = TransferTask.this.a(message);
                return a2;
            }
        });
        this.f = new OnRcspCallback() { // from class: com.jieli.jl_rcsp.task.TransferTask.8
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
            public void onConnectStateChange(BluetoothDevice bluetoothDevice, int i) {
                if (TransferTask.this.isRun() && i != 1) {
                    TransferTask.this.onError(8192, null);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
            public void onRcspCommand(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
                if (TransferTask.this.isRun() && commandBase != null) {
                    switch (commandBase.getId()) {
                        case 28:
                            StopLargeFileTransferCmd stopLargeFileTransferCmd = (StopLargeFileTransferCmd) commandBase;
                            StopLargeFileTransferCmd.Param param2 = (StopLargeFileTransferCmd.Param) stopLargeFileTransferCmd.getParam();
                            if (param2 == null) {
                                return;
                            }
                            int reason = param2.getReason();
                            stopLargeFileTransferCmd.setParam(null);
                            stopLargeFileTransferCmd.setStatus(0);
                            TransferTask.this.mRcspOp.sendCommandResponse(bluetoothDevice, stopLargeFileTransferCmd, null);
                            TransferTask.this.a(reason);
                            return;
                        case 29:
                            LargeFileTransferOpCmd largeFileTransferOpCmd = (LargeFileTransferOpCmd) commandBase;
                            if (TransferTask.this.c.c != 0) {
                                TransferTask.this.a(largeFileTransferOpCmd);
                                return;
                            } else {
                                JL_Log.e(TransferTask.this.tag, "onRcspCommand", "mtu is 0");
                                return;
                            }
                        case 30:
                            CancelLargeFileTransferCmd cancelLargeFileTransferCmd = (CancelLargeFileTransferCmd) commandBase;
                            cancelLargeFileTransferCmd.setParam(null);
                            cancelLargeFileTransferCmd.setStatus(0);
                            TransferTask.this.mRcspOp.sendCommandResponse(bluetoothDevice, cancelLargeFileTransferCmd, null);
                            TransferTask.this.f();
                            return;
                        case 31:
                        default:
                            return;
                        case 32:
                            TransferTask.this.a((LargeFileTransferGetNameCmd) commandBase);
                            return;
                    }
                }
            }
        };
        if (param != null) {
            this.d = param;
            JL_Log.d(this.tag, "init", param + ", class = " + this);
            this.c = new CacheVar();
            setPath(str);
            return;
        }
        throw new RuntimeException("TransferTask.Param can not be null.");
    }

    @Override // com.jieli.jl_rcsp.task.ITask
    public void cancel(byte b) {
        if (!isRun()) {
            return;
        }
        this.mRcspOp.sendRcspCommand(getConnectedDevice(), new CancelLargeFileTransferCmd(), new BooleanRcspActionCallback("cancel", new OnOperationCallback<Boolean>() { // from class: com.jieli.jl_rcsp.task.TransferTask.1
            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onFailed(BaseError baseError) {
                TransferTask.this.onError(baseError.getSubCode(), baseError.getMessage());
            }

            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onSuccess(Boolean bool) {
                TransferTask.this.f();
            }
        }));
    }

    public String getPath() {
        return this.b;
    }

    public final void i() {
        if (!isRun()) {
            return;
        }
        Param param = this.d;
        this.mRcspOp.sendRcspCommand(getConnectedDevice(), new DeviceExtendParamCmd(new DeviceExtendParamCmd.FileTransferParam(param.devHandler, param.appHasCrc16)), new CustomRcspActionCallback("readExternParam", new OnOperationCallback<Boolean>() { // from class: com.jieli.jl_rcsp.task.TransferTask.4
            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onFailed(BaseError baseError) {
                TransferTask.this.onError(baseError.getSubCode(), baseError.getMessage());
            }

            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onSuccess(Boolean bool) {
                TransferTask.this.d.f17955a = bool.booleanValue();
                TransferTask.this.k();
            }
        }, new IHandleResult<Boolean, DeviceExtendParamCmd>() { // from class: com.jieli.jl_rcsp.task.TransferTask.5
            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public int hasResult(BluetoothDevice bluetoothDevice, DeviceExtendParamCmd deviceExtendParamCmd) {
                return 0;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public Boolean handleResult(BluetoothDevice bluetoothDevice, DeviceExtendParamCmd deviceExtendParamCmd) {
                if (deviceExtendParamCmd != null && (deviceExtendParamCmd.getResponse() instanceof DeviceExtendParamCmd.FileTransferResponse)) {
                    return Boolean.valueOf(((DeviceExtendParamCmd.FileTransferResponse) deviceExtendParamCmd.getResponse()).hasCrc16);
                }
                return Boolean.FALSE;
            }
        }));
    }

    public final void j() {
        if (!isRun()) {
            return;
        }
        JL_Log.d(this.tag, "startFileTransferFlow", "" + this.d);
        if (this.d.useFlash) {
            File file = new File(this.b);
            a("/" + file.getName(), (int) file.length());
            return;
        }
        h();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k() {
        /*
            Method dump skipped, instructions count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jieli.jl_rcsp.task.TransferTask.k():void");
    }

    public void onError(int i) {
        onError(i, null);
    }

    public void release() {
        this.mDeviceStatusManager.updateFileTransfer(getConnectedDevice(), false);
        this.c.b();
        this.mRcspOp.unregisterOnRcspCallback(this.f);
        this.e.removeCallbacksAndMessages(null);
        if (!this.executor.isShutdown()) {
            this.executor.shutdownNow();
        }
    }

    public void setPath(String str) {
        this.b = str;
        int lastIndexOf = str.lastIndexOf(File.separator);
        if (lastIndexOf != -1) {
            if (str.length() - (lastIndexOf + 1) > 9) {
                this.maxRenameCount = 32;
            } else {
                this.maxRenameCount = 9;
            }
        }
    }

    @Override // com.jieli.jl_rcsp.task.ITask
    public void start() {
        if (isRun()) {
            JL_Log.w(this.tag, "start", "Task is in progress.");
            return;
        }
        if (isFileTransfer()) {
            JL_Log.w(this.tag, "start", "SDK in file transfer.");
            onError(4352);
        } else if (isDeviceInCalling()) {
            JL_Log.w(this.tag, "start", "Device in calling.");
            onError(12545);
        } else {
            if (this.executor.isShutdown()) {
                this.executor = Executors.newSingleThreadExecutor();
            }
            g();
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        FileInputStream fileInputStream;
        File file = new File(this.b);
        if (file.exists() && !file.isDirectory()) {
            long j = 0;
            if (file.length() != 0) {
                long b = b();
                FileInputStream fileInputStream2 = null;
                try {
                    try {
                        try {
                            this.c.f17954a = new RandomAccessFile(file, "r");
                            this.c.f = (int) file.length();
                            fileInputStream = new FileInputStream(file);
                        } catch (Exception e) {
                            e = e;
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                    }
                    try {
                        long available = fileInputStream.available();
                        byte[] bArr = new byte[2048];
                        short s = 0;
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byte[] bArr2 = new byte[read];
                            System.arraycopy(bArr, 0, bArr2, 0, read);
                            s = CryptoUtil.CRC16(bArr2, s);
                            j += read;
                        }
                        long a2 = a(b);
                        this.c.b = s;
                        JL_Log.d(this.tag, "countFileCrc", RcspUtil.formatString("Take data time = %d, file len = %d, file size = %d, data size = %d, crc = %d(0x%X)", Long.valueOf(a2), Integer.valueOf(this.c.f), Long.valueOf(available), Long.valueOf(j), Short.valueOf(s), Short.valueOf(s)));
                        CacheVar cacheVar = this.c;
                        if (cacheVar.f != j) {
                            cacheVar.f = (int) j;
                        }
                        j();
                        fileInputStream.close();
                    } catch (Exception e2) {
                        e = e2;
                        fileInputStream2 = fileInputStream;
                        e.printStackTrace();
                        this.e.post(new Runnable() { // from class: com.jieli.jl_rcsp.task.oxoX
                            @Override // java.lang.Runnable
                            public final void run() {
                                TransferTask.this.a(e);
                            }
                        });
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                    return;
                } catch (IOException e4) {
                    e4.printStackTrace();
                    return;
                }
            }
        }
        onError(4097, RcspUtil.formatString("Path is invalid. path = " + this.b, new Object[0]));
    }

    public final long b() {
        return System.currentTimeMillis();
    }

    public final SDCardBean c() {
        List<SDCardBean> onlineDev = FileBrowseManager.getInstance().getOnlineDev();
        if (onlineDev != null && !onlineDev.isEmpty()) {
            for (SDCardBean sDCardBean : onlineDev) {
                if (sDCardBean.getDevHandler() == this.d.devHandler) {
                    return sDCardBean;
                }
            }
        }
        return null;
    }

    public final void e() {
        if (this.c.g.isEmpty()) {
            this.c.h = false;
            if (isRun()) {
                this.e.removeMessages(4386);
                this.e.sendEmptyMessageDelayed(4386, TaskBase.TIMEOUT);
                return;
            }
            return;
        }
        SendData poll = this.c.g.poll();
        if (poll == null) {
            return;
        }
        a(poll.f17956a, poll.b, new OnOperationCallback<Boolean>() { // from class: com.jieli.jl_rcsp.task.TransferTask.7
            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onFailed(BaseError baseError) {
                TransferTask.this.onError(baseError.getSubCode(), baseError.getMessage());
            }

            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onSuccess(Boolean bool) {
                TransferTask.this.e();
            }
        });
    }

    public final void f() {
        release();
        callbackCancel(0);
    }

    public final void g() {
        this.c.b();
        this.mRcspOp.registerOnRcspCallback(this.f);
        this.mDeviceStatusManager.updateFileTransfer(getConnectedDevice(), true);
        callbackBegin();
    }

    public final void h() {
        if (isRun()) {
            this.mRcspOp.sendRcspCommand(getConnectedDevice(), new NotifyPrepareEnvCmd(new NotifyPrepareEnvCmd.NotifyPrepareTransferLargeFileParam()), new BooleanRcspActionCallback("prepareBigFileTransferEnv", new OnOperationCallback<Boolean>() { // from class: com.jieli.jl_rcsp.task.TransferTask.3
                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onFailed(BaseError baseError) {
                    TransferTask.this.onError(baseError.getSubCode(), baseError.getMessage());
                }

                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onSuccess(Boolean bool) {
                    DeviceInfo deviceInfo = TransferTask.this.mRcspOp.getDeviceInfo();
                    if (deviceInfo == null || deviceInfo.isSupportPackageCrc16()) {
                        TransferTask.this.i();
                    } else {
                        TransferTask.this.k();
                    }
                }
            }));
        }
    }

    public void onError(int i, String str) {
        release();
        if (str == null) {
            callbackError(i);
        } else {
            callbackError(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(Message message) {
        if (message.what != 4386) {
            return true;
        }
        onError(12290);
        return true;
    }

    public final long a(long j) {
        return b() - j;
    }

    public final void a(LargeFileTransferGetNameCmd largeFileTransferGetNameCmd) {
        if (isRun()) {
            this.e.removeMessages(4386);
            this.e.sendEmptyMessageDelayed(4386, TaskBase.TIMEOUT);
            String name = new File(this.b).getName();
            JL_Log.d(this.tag, "onGetName", "File name = " + name + ", retryName = " + this.c.e);
            largeFileTransferGetNameCmd.setParam(new LargeFileTransferGetNameCmd.Param(name, this.c.e).setOtherEncode(this.d.isOtherEncode).setEncodeType(this.d.encodeType));
            largeFileTransferGetNameCmd.setStatus(this.c.e >= this.maxRenameCount ? 1 : 0);
            largeFileTransferGetNameCmd.setOpCodeSn(largeFileTransferGetNameCmd.getOpCodeSn());
            this.mRcspOp.sendCommandResponse(getConnectedDevice(), largeFileTransferGetNameCmd, null);
            if (this.d.useFlash) {
                return;
            }
            CacheVar cacheVar = this.c;
            int i = cacheVar.e;
            if (i >= this.maxRenameCount) {
                onError(16898);
            } else {
                cacheVar.e = i + 1;
            }
        }
    }

    public final void a(int i) {
        Folder currentReadFile;
        long a2 = a(this.c.d);
        JL_Log.i(this.tag, "onStop", "Transfer file take time -->" + a2 + ", reason = " + i);
        if (i != 0) {
            int i2 = i != 1 ? i != 2 ? i != 3 ? i != 4 ? 12293 : 16897 : 12544 : WatchError.ERR_DATA_OVER_LIMIT : WatchError.ERR_FAT_WRITE;
            onError(i2, WatchError.getErrorDesc(i2));
            return;
        }
        JL_Log.i(this.tag, "onStop", "Transfer of large file is complete.");
        SDCardBean c = c();
        if (c != null && (currentReadFile = FileBrowseManager.getInstance().getCurrentReadFile(c)) != null) {
            currentReadFile.setLoadFinished(false);
        }
        release();
        callbackProgress(100);
        callbackFinish();
    }

    public final void a() {
        try {
            this.executor.execute(new Runnable() { // from class: com.jieli.jl_rcsp.task.II0XooXoX
                @Override // java.lang.Runnable
                public final void run() {
                    TransferTask.this.d();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            onError(16389, "Exception : " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Exception exc) {
        onError(16389, "IO Exception : " + exc.getMessage());
    }

    public final void a(String str, int i) {
        if (isRun()) {
            this.mRcspOp.sendRcspCommand(getConnectedDevice(), CommandBuilder.buildExternalFlashInsertNewFileStartCmd(str, i), new BooleanRcspActionCallback("startCreateFlashFile", new OnOperationCallback<Boolean>() { // from class: com.jieli.jl_rcsp.task.TransferTask.2
                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onFailed(BaseError baseError) {
                    TransferTask.this.onError(baseError.getSubCode(), baseError.getMessage());
                }

                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onSuccess(Boolean bool) {
                    TransferTask.this.h();
                }
            }));
        }
    }

    public final void a(byte[] bArr, int i, short s) {
        JL_Log.d(this.tag, "startBigFileTransfer", RcspUtil.formatString("size = %d, crc16 = %d(0x%X)", Integer.valueOf(i), Short.valueOf(s), Short.valueOf(s)));
        long b = b();
        CacheVar cacheVar = this.c;
        cacheVar.d = b;
        cacheVar.i = b;
        this.mRcspOp.sendRcspCommand(getConnectedDevice(), new StartLargeFileTransferCmd(new StartLargeFileTransferParam(bArr, i, s)), new RcspCommandCallback<StartLargeFileTransferCmd>() { // from class: com.jieli.jl_rcsp.task.TransferTask.6
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
            public void onErrCode(BluetoothDevice bluetoothDevice, BaseError baseError) {
                JL_Log.e(TransferTask.this.tag, "startBigFileTransfer", "onErrCode ---> " + baseError);
                TransferTask.this.onError(baseError.getSubCode(), baseError.getMessage());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
            public void onCommandResponse(BluetoothDevice bluetoothDevice, StartLargeFileTransferCmd startLargeFileTransferCmd) {
                BaseError buildResponseBadState;
                if (startLargeFileTransferCmd.getStatus() == 0) {
                    TransferTask.this.c.c = ((StartLargeFileTransferResponse) startLargeFileTransferCmd.getResponse()).getTransferMtu();
                    JL_Log.d(TransferTask.this.tag, "startBigFileTransfer", "transferMtu = " + TransferTask.this.c.c);
                    if (TransferTask.this.c.c > 0) {
                        TransferTask.this.e.removeMessages(4386);
                        TransferTask.this.e.sendEmptyMessageDelayed(4386, TaskBase.TIMEOUT);
                        return;
                    } else {
                        onErrCode(bluetoothDevice, new BaseError(4097, RcspUtil.formatString("Device[%s] return an invalid mtu : %d.", bluetoothDevice, Integer.valueOf(TransferTask.this.c.c))));
                        return;
                    }
                }
                short transferMtu = ((StartLargeFileTransferResponse) startLargeFileTransferCmd.getResponse()).getTransferMtu();
                if (transferMtu != 0) {
                    buildResponseBadState = TransferTask.this.buildResponseBadResult(startLargeFileTransferCmd.getId(), transferMtu);
                } else {
                    buildResponseBadState = TransferTask.this.buildResponseBadState(startLargeFileTransferCmd.getId(), startLargeFileTransferCmd.getStatus());
                }
                onErrCode(bluetoothDevice, buildResponseBadState);
            }
        });
    }

    public final void a(int i, byte[] bArr, OnOperationCallback<Boolean> onOperationCallback) {
        DataParam dataParam = new DataParam(bArr);
        dataParam.setXmOpCode(i);
        this.mRcspOp.sendRcspCommand(getConnectedDevice(), new DataCmd(dataParam), new BooleanRcspActionCallback("sendData", onOperationCallback));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(final LargeFileTransferOpCmd largeFileTransferOpCmd) {
        final int i = this.c.c;
        if (!isRun() || i <= 0 || this.c.f17954a == null) {
            return;
        }
        LargeFileTransferOpParam largeFileTransferOpParam = (LargeFileTransferOpParam) largeFileTransferOpCmd.getParam();
        final int offset = largeFileTransferOpParam.getOffset();
        final short buffer = largeFileTransferOpParam.getBuffer();
        long a2 = a(this.c.i);
        CacheVar cacheVar = this.c;
        if (cacheVar.j == offset && a2 < cacheVar.k) {
            JL_Log.w(this.tag, "pullData", RcspUtil.formatString("Received same packet.Skip! offset = %d, take time = %d, limit = %d", Integer.valueOf(offset), Long.valueOf(a2), Long.valueOf(this.c.k)));
            return;
        }
        this.e.removeMessages(4386);
        if (offset > 512) {
            int i2 = this.c.f;
            float f = i2 == 0 ? 0.0f : (offset * 100.0f) / i2;
            callbackProgress((int) (f <= 100.0f ? f : 100.0f));
        }
        try {
            this.executor.execute(new Runnable() { // from class: com.jieli.jl_rcsp.task.xxIXOIIO
                @Override // java.lang.Runnable
                public final void run() {
                    TransferTask.this.a(offset, buffer, i, largeFileTransferOpCmd);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            onError(16389, "Exception = " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final int i, final int i2, int i3, LargeFileTransferOpCmd largeFileTransferOpCmd) {
        int i4;
        byte[] bArr;
        try {
            CacheVar cacheVar = this.c;
            long j = i;
            cacheVar.j = j;
            cacheVar.i = b();
            this.c.f17954a.seek(j);
            byte[] bArr2 = new byte[0];
            final int min = Math.min(i2, this.c.f - i);
            if (min >= 0) {
                bArr2 = new byte[min];
                i4 = this.c.f17954a.read(bArr2);
            } else {
                i4 = -1;
            }
            if (i4 == -1) {
                this.e.post(new Runnable() { // from class: com.jieli.jl_rcsp.task.X0o0xo
                    @Override // java.lang.Runnable
                    public final void run() {
                        TransferTask.this.a(i, min, i2);
                    }
                });
                return;
            }
            byte[] copyOfRange = Arrays.copyOfRange(bArr2, 0, i4);
            this.c.k = (long) Math.max((i4 * 10.0d) / i3, 10.0d);
            int i5 = 0;
            int i6 = 0;
            while (i5 < i4) {
                int min2 = Math.min(i3, i4 - i5);
                int i7 = i5 + min2;
                byte[] copyOfRange2 = Arrays.copyOfRange(copyOfRange, i5, i7);
                Param param = this.d;
                if (param.appHasCrc16 && param.f17955a) {
                    bArr = new byte[min2 + 3];
                    short CRC16 = CryptoUtil.CRC16(copyOfRange2, (short) 0);
                    bArr[1] = (byte) ((CRC16 >> 8) & 255);
                    bArr[2] = (byte) (CRC16 & 255);
                    System.arraycopy(copyOfRange2, 0, bArr, 3, min2);
                } else {
                    bArr = new byte[min2 + 1];
                    System.arraycopy(copyOfRange2, 0, bArr, 1, min2);
                }
                bArr[0] = CHexConver.intToByte(i6);
                this.c.g.add(new SendData(largeFileTransferOpCmd.getId(), bArr));
                i6++;
                i5 = i7;
            }
            if (this.c.h) {
                return;
            }
            e();
        } catch (IOException e) {
            e.printStackTrace();
            this.e.post(new Runnable() { // from class: com.jieli.jl_rcsp.task.XO
                @Override // java.lang.Runnable
                public final void run() {
                    TransferTask.this.a(e);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i, int i2, int i3) {
        onError(16389, "Failed to read data. offset = " + i + ", packetSize = " + i2 + ", buffer : " + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(IOException iOException) {
        onError(16389, "IO Exception = " + iOException.getMessage());
    }
}
