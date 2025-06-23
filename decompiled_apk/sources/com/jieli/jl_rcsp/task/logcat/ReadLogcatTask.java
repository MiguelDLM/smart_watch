package com.jieli.jl_rcsp.task.logcat;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.jieli.jl_rcsp.constant.WatchError;
import com.jieli.jl_rcsp.impl.RcspOpImpl;
import com.jieli.jl_rcsp.interfaces.IHandleResult;
import com.jieli.jl_rcsp.interfaces.OnOperationCallback;
import com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback;
import com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.ReadErrorMsgCmd;
import com.jieli.jl_rcsp.model.command.data.DataCmd;
import com.jieli.jl_rcsp.model.parameter.DataParam;
import com.jieli.jl_rcsp.task.TaskBase;
import com.jieli.jl_rcsp.tool.CustomRcspActionCallback;
import com.jieli.jl_rcsp.util.CommandBuilder;
import com.jieli.jl_rcsp.util.CryptoUtil;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes10.dex */
public class ReadLogcatTask extends TaskBase {
    public static int WAIT_CMD_TIMEOUT = 12000;
    public static final int g = 4118;
    public BluetoothDevice b;
    public final ByteArrayOutputStream c;
    public ReadErrorMsgCmd.ReadErrorMsgResponse d;
    public final Handler e;
    public final OnRcspCallback f;

    public ReadLogcatTask(RcspOpImpl rcspOpImpl) throws RuntimeException {
        super(rcspOpImpl);
        this.c = new ByteArrayOutputStream();
        this.e = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.jieli.jl_rcsp.task.logcat.oIX0oI
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean a2;
                a2 = ReadLogcatTask.this.a(message);
                return a2;
            }
        });
        this.f = new OnRcspCallback() { // from class: com.jieli.jl_rcsp.task.logcat.ReadLogcatTask.4
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
            public void onRcspCommand(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
                super.onRcspCommand(bluetoothDevice, commandBase);
                if (commandBase != null && commandBase.getId() == 41 && ReadLogcatTask.this.a(bluetoothDevice)) {
                    ReadErrorMsgCmd readErrorMsgCmd = (ReadErrorMsgCmd) commandBase;
                    if (((ReadErrorMsgCmd.ReadErrorMsgParam) readErrorMsgCmd.getParam()).getOp() == 1) {
                        ReadLogcatTask.this.a(readErrorMsgCmd);
                    }
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
            public void onRcspDataCmd(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
                DataParam dataParam;
                super.onRcspDataCmd(bluetoothDevice, commandBase);
                if (ReadLogcatTask.this.a(bluetoothDevice) && (dataParam = (DataParam) ((DataCmd) commandBase).getParam()) != null && dataParam.getXmOpCode() == 41) {
                    ReadLogcatTask.this.a(dataParam.getData());
                }
            }
        };
    }

    @Override // com.jieli.jl_rcsp.task.ITask
    public void cancel(byte b) {
    }

    public byte[] getResult() {
        return this.c.toByteArray();
    }

    public final void release() {
        this.b = null;
        this.mRcspOp.unregisterOnRcspCallback(this.f);
        this.e.removeCallbacksAndMessages(null);
    }

    @Override // com.jieli.jl_rcsp.task.ITask
    public void start() {
        if (isRun()) {
            JL_Log.w(this.tag, "start", "Task is in progress.");
            return;
        }
        if (!this.mRcspOp.isRcspInit()) {
            a(8192);
        } else if (!this.mRcspOp.getDeviceInfo().isSupportReadErrorMSg()) {
            a(4353);
        } else {
            JL_Log.d(this.tag, "start", "device support reading error message.");
            c();
        }
    }

    public final void b() {
        this.b = getConnectedDevice();
        this.c.reset();
        this.mRcspOp.registerOnRcspCallback(this.f);
        callbackBegin();
    }

    public final void c() {
        b();
        this.mRcspOp.sendRcspCommand(this.b, CommandBuilder.buildStartReadErrorMsgCmd(), new CustomRcspActionCallback("startReadLogcat", new OnOperationCallback<ReadErrorMsgCmd.ReadErrorMsgResponse>() { // from class: com.jieli.jl_rcsp.task.logcat.ReadLogcatTask.1
            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onFailed(BaseError baseError) {
                ReadLogcatTask.this.a(baseError.getSubCode(), baseError.getMessage());
            }

            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onSuccess(ReadErrorMsgCmd.ReadErrorMsgResponse readErrorMsgResponse) {
                if (readErrorMsgResponse != null) {
                    ReadLogcatTask.this.a(readErrorMsgResponse);
                    if (ReadLogcatTask.this.d.getSize() <= 0) {
                        JL_Log.w(((TaskBase) ReadLogcatTask.this).tag, "startReadLogcat", "Device has no abnormal information. file size = " + ReadLogcatTask.this.d.getSize());
                        ReadLogcatTask.this.a();
                        return;
                    }
                    ReadLogcatTask.this.e.removeMessages(4118);
                    ReadLogcatTask.this.e.sendEmptyMessageDelayed(4118, ReadLogcatTask.WAIT_CMD_TIMEOUT);
                    return;
                }
                onFailed(new BaseError(12289, WatchError.getErrorDesc(12289)));
            }
        }, new IHandleResult<ReadErrorMsgCmd.ReadErrorMsgResponse, ReadErrorMsgCmd>() { // from class: com.jieli.jl_rcsp.task.logcat.ReadLogcatTask.2
            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public int hasResult(BluetoothDevice bluetoothDevice, ReadErrorMsgCmd readErrorMsgCmd) {
                return 0;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public ReadErrorMsgCmd.ReadErrorMsgResponse handleResult(BluetoothDevice bluetoothDevice, ReadErrorMsgCmd readErrorMsgCmd) {
                if (readErrorMsgCmd == null || readErrorMsgCmd.getStatus() != 0) {
                    return null;
                }
                return (ReadErrorMsgCmd.ReadErrorMsgResponse) readErrorMsgCmd.getResponse();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(Message message) {
        if (message.what != 4118) {
            return true;
        }
        JL_Log.w(this.tag, "MSG_WAIT_COMMAND_TIMEOUT", "");
        if (!isRun()) {
            return true;
        }
        a(12290, "Waiting for data timeout.");
        return true;
    }

    public final void a(ReadErrorMsgCmd.ReadErrorMsgResponse readErrorMsgResponse) {
        this.d = readErrorMsgResponse;
    }

    public final void a(byte[] bArr) {
        if (bArr != null && bArr.length != 0 && isRun()) {
            try {
                try {
                    if (this.e.hasMessages(4118)) {
                        this.e.removeMessages(4118);
                    }
                    this.c.write(bArr);
                    int size = this.c.size();
                    if (this.d.getSize() > 0) {
                        int size2 = (size * 100) / this.d.getSize();
                        if (size2 >= 100) {
                            size2 = 99;
                        }
                        callbackProgress(size2);
                    }
                    try {
                        this.c.close();
                        return;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return;
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                    callbackError(16389, "IO Exception = " + e2.getMessage());
                    try {
                        this.c.close();
                        return;
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
            } catch (Throwable th) {
                try {
                    this.c.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                throw th;
            }
        }
        JL_Log.w(this.tag, "handleLogcat", "invalid param.");
    }

    public final void a(ReadErrorMsgCmd readErrorMsgCmd) {
        if (readErrorMsgCmd != null && isRun()) {
            byte[] byteArray = this.c.toByteArray();
            final short CRC16 = CryptoUtil.CRC16(byteArray, (short) 0);
            final short crc = this.d.getCrc();
            final int i = crc == CRC16 ? 0 : 6;
            JL_Log.d(this.tag, "handleStopRead", RcspUtil.formatString("sdk read logcat crc = %d(0x%X), firmware crc = %d(0x%X), status = %d", Short.valueOf(CRC16), Short.valueOf(CRC16), Short.valueOf(crc), Short.valueOf(crc), Integer.valueOf(i)));
            readErrorMsgCmd.setStatus(i);
            ReadErrorMsgCmd.ResponseReadResult responseReadResult = new ReadErrorMsgCmd.ResponseReadResult();
            responseReadResult.setSize(byteArray.length);
            responseReadResult.setCrc(CRC16);
            readErrorMsgCmd.setParam(responseReadResult);
            this.mRcspOp.sendCommandResponse(this.b, readErrorMsgCmd, new RcspCommandCallback<ReadErrorMsgCmd>() { // from class: com.jieli.jl_rcsp.task.logcat.ReadLogcatTask.3
                @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
                public void onErrCode(BluetoothDevice bluetoothDevice, BaseError baseError) {
                    ReadLogcatTask.this.a(baseError.getSubCode(), baseError.getMessage());
                }

                @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
                public void onCommandResponse(BluetoothDevice bluetoothDevice, ReadErrorMsgCmd readErrorMsgCmd2) {
                    if (i == 0) {
                        ReadLogcatTask.this.a();
                        return;
                    }
                    ReadLogcatTask.this.a(12544, "Check data crc error. firmware crc = " + ((int) crc) + ", data crc = " + ((int) CRC16));
                }
            });
            return;
        }
        JL_Log.w(this.tag, "handleStopRead", "Reading logcat did not start.");
    }

    public final boolean a(BluetoothDevice bluetoothDevice) {
        return (bluetoothDevice == null || this.b == null || !bluetoothDevice.getAddress().equals(this.b.getAddress())) ? false : true;
    }

    public final void a(int i) {
        a(i, (String) null);
    }

    public final void a(int i, String str) {
        JL_Log.w(this.tag, "postError", "code : " + i + ", " + str);
        if (str == null) {
            callbackError(i);
        } else {
            callbackError(i, str);
        }
        release();
    }

    public final void a() {
        callbackProgress(100);
        callbackFinish();
        release();
    }
}
