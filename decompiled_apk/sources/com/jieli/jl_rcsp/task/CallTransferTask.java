package com.jieli.jl_rcsp.task;

import com.jieli.jl_rcsp.impl.RcspOpImpl;
import com.jieli.jl_rcsp.interfaces.OnOperationCallback;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.command.file_op.DeleteFileByNameCmd;
import com.jieli.jl_rcsp.task.TransferTask;
import com.jieli.jl_rcsp.tool.BooleanRcspActionCallback;
import java.io.File;

/* loaded from: classes10.dex */
public class CallTransferTask extends TransferTask {
    public CallTransferTask(RcspOpImpl rcspOpImpl, String str, TransferTask.Param param) {
        super(rcspOpImpl, str, param);
    }

    @Override // com.jieli.jl_rcsp.task.TransferTask, com.jieli.jl_rcsp.task.ITask
    public void start() {
        this.mRcspOp.sendRcspCommand(getConnectedDevice(), new DeleteFileByNameCmd(new DeleteFileByNameCmd.Param(new File(getPath()).getName())), new BooleanRcspActionCallback("DeleteFileByName", new OnOperationCallback<Boolean>() { // from class: com.jieli.jl_rcsp.task.CallTransferTask.1
            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onFailed(BaseError baseError) {
                CallTransferTask.this.onError(baseError.getSubCode(), baseError.getMessage());
            }

            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onSuccess(Boolean bool) {
                CallTransferTask.super.start();
            }
        }));
    }
}
