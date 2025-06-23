package com.jieli.jl_rcsp.task.format;

import com.jieli.jl_rcsp.impl.RcspOpImpl;
import com.jieli.jl_rcsp.interfaces.OnOperationCallback;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.command.NotifyPrepareEnvCmd;
import com.jieli.jl_rcsp.model.command.file_op.DeviceFormatCmd;
import com.jieli.jl_rcsp.task.TaskBase;
import com.jieli.jl_rcsp.tool.BooleanRcspActionCallback;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class FormatCmdTask extends TaskBase {
    public final byte b;
    public final int c;

    public FormatCmdTask(RcspOpImpl rcspOpImpl, byte b, int i) {
        super(rcspOpImpl);
        this.b = b;
        this.c = i;
    }

    @Override // com.jieli.jl_rcsp.task.ITask
    public void cancel(byte b) {
    }

    @Override // com.jieli.jl_rcsp.task.ITask
    public void start() {
        callbackBegin();
        b();
    }

    public final void a() {
        this.mRcspOp.sendRcspCommand(getConnectedDevice(), new DeviceFormatCmd(new DeviceFormatCmd.Param(this.c)), 30000, new BooleanRcspActionCallback("formatDevice", new OnOperationCallback<Boolean>() { // from class: com.jieli.jl_rcsp.task.format.FormatCmdTask.2
            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onFailed(BaseError baseError) {
                FormatCmdTask.this.callbackError(baseError.getSubCode(), baseError.getMessage());
            }

            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onSuccess(Boolean bool) {
                FormatCmdTask.this.callbackFinish();
            }
        }));
    }

    public final void b() {
        this.mRcspOp.sendRcspCommand(getConnectedDevice(), new NotifyPrepareEnvCmd(new NotifyPrepareEnvCmd.Param((byte) 2)), new BooleanRcspActionCallback("prepareDelEnv", new OnOperationCallback<Boolean>() { // from class: com.jieli.jl_rcsp.task.format.FormatCmdTask.1
            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onFailed(BaseError baseError) {
                FormatCmdTask.this.callbackError(baseError.getSubCode(), baseError.getMessage());
            }

            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onSuccess(Boolean bool) {
                FormatCmdTask.this.a();
            }
        }));
    }
}
