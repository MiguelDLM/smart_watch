package com.jieli.jl_rcsp.task.smallfile;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.impl.RcspOpImpl;
import com.jieli.jl_rcsp.interfaces.IHandleResult;
import com.jieli.jl_rcsp.interfaces.OnOperationCallback;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.command.file_op.SmallFileTransferCmd;
import com.jieli.jl_rcsp.task.TaskBase;
import com.jieli.jl_rcsp.tool.CustomRcspActionCallback;
import com.jieli.jl_rcsp.util.JL_Log;

/* loaded from: classes10.dex */
public class DeleteFileTask extends TaskBase {
    public final Param b;

    /* loaded from: classes10.dex */
    public static class Param {

        /* renamed from: a, reason: collision with root package name */
        public final byte f17991a;
        public final short b;

        public Param(byte b, short s) {
            this.b = s;
            this.f17991a = b;
        }

        public short getId() {
            return this.b;
        }

        public byte getType() {
            return this.f17991a;
        }
    }

    public DeleteFileTask(RcspOpImpl rcspOpImpl, Param param) throws RuntimeException {
        super(rcspOpImpl);
        if (param != null) {
            this.b = param;
            return;
        }
        throw new RuntimeException("DeleteFileTask.Param can not be null.");
    }

    @Override // com.jieli.jl_rcsp.task.ITask
    public void cancel(byte b) {
    }

    @Override // com.jieli.jl_rcsp.task.ITask
    public void start() {
        if (isRun()) {
            JL_Log.w(this.tag, "start", "Task is in progress.");
            return;
        }
        callbackBegin();
        SmallFileTransferCmd.DeleteFileParam deleteFileParam = new SmallFileTransferCmd.DeleteFileParam(this.b.f17991a, this.b.b);
        this.mRcspOp.sendRcspCommand(getConnectedDevice(), new SmallFileTransferCmd(deleteFileParam), 5000, new CustomRcspActionCallback(this.tag + "#SmallFileTransfer", new OnOperationCallback<Boolean>() { // from class: com.jieli.jl_rcsp.task.smallfile.DeleteFileTask.1
            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onFailed(BaseError baseError) {
                DeleteFileTask.this.callbackError(baseError.getSubCode(), baseError.getMessage());
            }

            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onSuccess(Boolean bool) {
                DeleteFileTask.this.callbackFinish();
            }
        }, new IHandleResult<Boolean, SmallFileTransferCmd>() { // from class: com.jieli.jl_rcsp.task.smallfile.DeleteFileTask.2
            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public Boolean handleResult(BluetoothDevice bluetoothDevice, SmallFileTransferCmd smallFileTransferCmd) {
                return Boolean.TRUE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public int hasResult(BluetoothDevice bluetoothDevice, SmallFileTransferCmd smallFileTransferCmd) {
                if (smallFileTransferCmd == null) {
                    return -1;
                }
                SmallFileTransferCmd.Response response = (SmallFileTransferCmd.Response) smallFileTransferCmd.getResponse();
                if (response instanceof SmallFileTransferCmd.ResultResponse) {
                    return ((SmallFileTransferCmd.ResultResponse) response).ret;
                }
                return -1;
            }
        }));
    }
}
