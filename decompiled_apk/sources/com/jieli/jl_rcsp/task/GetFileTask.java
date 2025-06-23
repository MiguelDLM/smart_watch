package com.jieli.jl_rcsp.task;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.jieli.jl_fatfs.tool.ReadFileThread;
import com.jieli.jl_rcsp.constant.WatchError;
import com.jieli.jl_rcsp.impl.RcspOpImpl;
import com.jieli.jl_rcsp.interfaces.IHandleResult;
import com.jieli.jl_rcsp.interfaces.OnOperationCallback;
import com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.data.DataCmd;
import com.jieli.jl_rcsp.model.command.file_op.ReadFileFromDeviceCmd;
import com.jieli.jl_rcsp.model.parameter.DataParam;
import com.jieli.jl_rcsp.tool.BooleanRcspActionCallback;
import com.jieli.jl_rcsp.tool.CustomRcspActionCallback;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.CryptoUtil;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* loaded from: classes10.dex */
public abstract class GetFileTask extends TaskBase {
    public static final String BYTE_ARRAY_STREAM = "byte_array_stream";
    public static final int REASON_CANCEL_TASK = 0;
    public static final int REASON_CRC_ERROR = 2;
    public static final int REASON_LOST_DATA = 1;
    public static final int l = 8705;
    public static final int m = 8706;
    public final String b;
    public OutputStream c;
    public byte[] d;
    public final Param e;
    public boolean f;
    public HandlerThread g;
    public Handler h;
    public final Handler i;
    public final Handler.Callback j;
    public final OnRcspCallback k;
    protected boolean useCrc;

    /* loaded from: classes10.dex */
    public static class Param {
        public short lastCrc;
        public int lastOffset;
        public int lastProgress;
        public int totalSize;

        public Param() {
            this.lastOffset = 0;
            this.lastCrc = (short) 0;
            this.lastProgress = -1;
        }

        public void reset() {
            this.totalSize = 0;
            this.lastOffset = 0;
            this.lastCrc = (short) 0;
            this.lastProgress = -1;
        }
    }

    public GetFileTask(RcspOpImpl rcspOpImpl, String str) {
        super(rcspOpImpl);
        this.c = null;
        this.d = new byte[0];
        this.useCrc = true;
        this.f = false;
        this.i = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.jieli.jl_rcsp.task.oIX0oI
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean a2;
                a2 = GetFileTask.this.a(message);
                return a2;
            }
        });
        this.j = new Handler.Callback() { // from class: com.jieli.jl_rcsp.task.II0xO0
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean b;
                b = GetFileTask.this.b(message);
                return b;
            }
        };
        this.k = new OnRcspCallback() { // from class: com.jieli.jl_rcsp.task.GetFileTask.4
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
            public void onConnectStateChange(BluetoothDevice bluetoothDevice, int i) {
                if (GetFileTask.this.isRun() && i != 1) {
                    GetFileTask.this.onError(8192);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
            public void onRcspCommand(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
                if (!GetFileTask.this.isRun() || commandBase.getId() != 36) {
                    return;
                }
                ReadFileFromDeviceCmd readFileFromDeviceCmd = (ReadFileFromDeviceCmd) commandBase;
                ReadFileFromDeviceCmd.Param param = (ReadFileFromDeviceCmd.Param) readFileFromDeviceCmd.getParam();
                if (param == null) {
                    return;
                }
                byte b = param.op;
                if (b != Byte.MIN_VALUE) {
                    if (b == -127) {
                        GetFileTask.this.b(((ReadFileFromDeviceCmd.CancelParam) param).reason);
                    }
                } else {
                    byte b2 = ((ReadFileFromDeviceCmd.StopParam) param).ret;
                    if (b2 != 0) {
                        BaseError buildResponseBadResult = GetFileTask.this.buildResponseBadResult(readFileFromDeviceCmd.getId(), b2);
                        GetFileTask.this.onError(buildResponseBadResult.getSubCode(), buildResponseBadResult.getMessage());
                    } else if (GetFileTask.this.h != null && !GetFileTask.this.h.sendEmptyMessage(GetFileTask.m)) {
                        JL_Log.w(GetFileTask.this.tag, "MSG_READ_FINISH", "lost message.");
                    }
                }
                readFileFromDeviceCmd.setOpCodeSn(commandBase.getOpCodeSn());
                readFileFromDeviceCmd.setStatus(0);
                readFileFromDeviceCmd.setParam(new ReadFileFromDeviceCmd.Param(((ReadFileFromDeviceCmd.Param) readFileFromDeviceCmd.getParam()).op));
                GetFileTask.this.mRcspOp.sendCommandResponse(bluetoothDevice, readFileFromDeviceCmd, null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
            public void onRcspDataCmd(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
                if (!GetFileTask.this.isRun() || commandBase.getId() != 1) {
                    return;
                }
                DataCmd dataCmd = (DataCmd) commandBase;
                if (((DataParam) dataCmd.getParam()).getXmOpCode() != 36) {
                    return;
                }
                byte[] data = ((DataParam) dataCmd.getParam()).getData();
                if (GetFileTask.this.h != null && !GetFileTask.this.h.sendMessage(GetFileTask.this.h.obtainMessage(GetFileTask.l, data))) {
                    JL_Log.w(GetFileTask.this.tag, "MSG_RECEIVE_DATA", "lost message.");
                }
            }
        };
        this.b = str;
        this.e = new Param();
    }

    @Override // com.jieli.jl_rcsp.task.ITask
    public void cancel(byte b) {
        a(b, (String) null);
    }

    public abstract ReadFileFromDeviceCmd.Param createParam(BluetoothDevice bluetoothDevice);

    public byte[] getCacheData() {
        return this.d;
    }

    public final void onError(int i) {
        onError(i, null);
    }

    public final void release() {
        this.mDeviceStatusManager.updateFileTransfer(getConnectedDevice(), false);
        this.e.reset();
        this.f = false;
        this.mRcspOp.unregisterOnRcspCallback(this.k);
        this.i.removeCallbacksAndMessages(null);
        Handler handler = this.h;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.h = null;
        }
        HandlerThread handlerThread = this.g;
        if (handlerThread != null && !handlerThread.isInterrupted()) {
            this.g.quit();
        }
        this.g = null;
        OutputStream outputStream = this.c;
        if (outputStream != null) {
            try {
                outputStream.flush();
                this.c.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                this.c = null;
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
            return;
        }
        if (isDeviceInCalling()) {
            onError(12545);
            return;
        }
        b();
        HandlerThread handlerThread = new HandlerThread(ReadFileThread.d);
        this.g = handlerThread;
        handlerThread.start();
        this.h = new Handler(this.g.getLooper(), this.j);
        if (BYTE_ARRAY_STREAM.equals(this.b)) {
            this.c = new ByteArrayOutputStream();
        } else {
            try {
                this.c = new FileOutputStream(this.b);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                onError(4097, RcspUtil.formatString("%s File not found.", WatchError.getErrorDesc(4097)));
                return;
            }
        }
        c();
    }

    public final void c() {
        this.mRcspOp.sendRcspCommand(getConnectedDevice(), new ReadFileFromDeviceCmd(createParam(getConnectedDevice())), new CustomRcspActionCallback("ReadFileFromDevice", new OnOperationCallback<ReadFileFromDeviceCmd.StartResponse>() { // from class: com.jieli.jl_rcsp.task.GetFileTask.1
            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onFailed(BaseError baseError) {
                GetFileTask.this.onError(baseError.getSubCode(), baseError.getMessage());
            }

            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onSuccess(ReadFileFromDeviceCmd.StartResponse startResponse) {
                GetFileTask.this.e.totalSize = startResponse.size;
                GetFileTask.this.e.lastCrc = (short) 0;
                GetFileTask.this.i.removeMessages(4386);
                GetFileTask.this.i.sendEmptyMessageDelayed(4386, TaskBase.TIMEOUT);
            }
        }, new IHandleResult<ReadFileFromDeviceCmd.StartResponse, ReadFileFromDeviceCmd>() { // from class: com.jieli.jl_rcsp.task.GetFileTask.2
            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public int hasResult(BluetoothDevice bluetoothDevice, ReadFileFromDeviceCmd readFileFromDeviceCmd) {
                return 0;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public ReadFileFromDeviceCmd.StartResponse handleResult(BluetoothDevice bluetoothDevice, ReadFileFromDeviceCmd readFileFromDeviceCmd) {
                if (readFileFromDeviceCmd != null && readFileFromDeviceCmd.getStatus() == 0 && (readFileFromDeviceCmd.getResponse() instanceof ReadFileFromDeviceCmd.StartResponse)) {
                    return (ReadFileFromDeviceCmd.StartResponse) readFileFromDeviceCmd.getResponse();
                }
                return null;
            }
        }));
    }

    public final void onError(int i, String str) {
        JL_Log.e(this.tag, "onError ", "code = " + i + ", " + str);
        release();
        if (str == null) {
            callbackError(i);
        } else {
            callbackError(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean b(Message message) {
        if (message == null) {
            return false;
        }
        int i = message.what;
        if (i != 8705) {
            if (i != 8706) {
                return true;
            }
            a();
            return true;
        }
        Object obj = message.obj;
        if (!(obj instanceof byte[])) {
            return true;
        }
        a((byte[]) obj);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(Message message) {
        if (message.what != 4386) {
            return true;
        }
        JL_Log.w(this.tag, "MSG_WAITING_FOR_DATA_TIMEOUT", "");
        onError(12290, "Waiting for data timeout.");
        return true;
    }

    public final void a(final int i, final String str) {
        if (isRun() && this.f) {
            JL_Log.w(this.tag, "cancelBigFileTransfer", "reason : " + i + ", " + str);
            this.f = true;
            this.mRcspOp.sendRcspCommand(getConnectedDevice(), new ReadFileFromDeviceCmd(new ReadFileFromDeviceCmd.CancelParam(CHexConver.intToByte(i))), new BooleanRcspActionCallback("cancelBigFileTransfer", new OnOperationCallback<Boolean>() { // from class: com.jieli.jl_rcsp.task.GetFileTask.3
                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onFailed(BaseError baseError) {
                    GetFileTask.this.onError(baseError.getSubCode(), baseError.getMessage());
                }

                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onSuccess(Boolean bool) {
                    int i2 = i;
                    if (i2 != 0) {
                        GetFileTask.this.onError(i2, str);
                    } else {
                        GetFileTask.this.b(0);
                    }
                }
            }));
        }
    }

    public final void b() {
        this.e.reset();
        this.d = new byte[0];
        this.f = false;
        this.mRcspOp.registerOnRcspCallback(this.k);
        this.mDeviceStatusManager.updateFileTransfer(getConnectedDevice(), true);
        callbackBegin();
    }

    public final void a(byte[] bArr) {
        byte[] bArr2;
        ByteBuffer byteBuffer;
        if (!isRun() || bArr == null || bArr.length < 4) {
            return;
        }
        this.i.removeMessages(4386);
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        int i = wrap.getInt();
        JL_Log.d(this.tag, "onData", "offset = " + i + ", lastOffset = " + this.e.lastOffset + ", data size = " + bArr.length);
        Param param = this.e;
        if (param.lastOffset == 0) {
            param.lastOffset = i;
        }
        int i2 = param.lastOffset;
        if (i2 != i) {
            a(1, RcspUtil.formatString("Offset does not match. sdk count offset = %d, firmware return offset = %d.", Integer.valueOf(i2), Integer.valueOf(i)));
            return;
        }
        final int i3 = (int) (((i2 * 1.0f) / param.totalSize) * 100.0f);
        if (param.lastProgress != i3) {
            param.lastProgress = i3;
            this.i.post(new Runnable() { // from class: com.jieli.jl_rcsp.task.I0Io
                @Override // java.lang.Runnable
                public final void run() {
                    GetFileTask.this.a(i3);
                }
            });
        }
        if (this.useCrc) {
            short s = wrap.getShort();
            bArr2 = new byte[wrap.remaining()];
            byteBuffer = wrap.get(bArr2);
            Param param2 = this.e;
            param2.lastCrc = CryptoUtil.CRC16(bArr2, param2.lastCrc);
            JL_Log.d(this.tag, "onData", RcspUtil.formatString("crc = %d(0x%X), lastCrc = %d(0x%X)", Short.valueOf(s), Short.valueOf(s), Short.valueOf(this.e.lastCrc), Short.valueOf(this.e.lastCrc)));
            short s2 = this.e.lastCrc;
            if (s != s2) {
                a(2, RcspUtil.formatString("CRC error. data crc = 0x%X, firmware return crc = 0x%X", Short.valueOf(s2), Short.valueOf(s)));
                return;
            }
        } else {
            bArr2 = new byte[wrap.remaining()];
            byteBuffer = wrap.get(bArr2);
        }
        try {
            this.c.write(bArr2);
            this.e.lastOffset = i + bArr2.length;
            JL_Log.d(this.tag, "onData", "buf size = " + bArr2.length + ", lastOffset = " + this.e.lastOffset);
            this.i.sendEmptyMessageDelayed(4386, (long) TaskBase.TIMEOUT);
            byteBuffer.rewind();
        } catch (IOException e) {
            e.printStackTrace();
            a(1, "IO exception : " + e.getMessage());
        }
    }

    public final void b(int i) {
        release();
        callbackCancel(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i) {
        callbackProgress(i);
    }

    public final void a() {
        long length;
        if (isRun()) {
            OutputStream outputStream = this.c;
            if (outputStream instanceof ByteArrayOutputStream) {
                byte[] byteArray = ((ByteArrayOutputStream) outputStream).toByteArray();
                this.d = byteArray;
                length = byteArray.length;
            } else {
                length = outputStream instanceof FileOutputStream ? new File(this.b).length() : 0L;
            }
            if (length != this.e.totalSize) {
                onError(16387, "Data loss. Firmware return data size = " + this.e.totalSize + ", Actual received data size = " + length);
                return;
            }
            JL_Log.i(this.tag, "onFinish", "Reading file completed. " + this.b);
            release();
            callbackProgress(100);
            callbackFinish();
        }
    }
}
