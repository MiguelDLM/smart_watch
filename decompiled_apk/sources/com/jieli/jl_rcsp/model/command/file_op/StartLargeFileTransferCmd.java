package com.jieli.jl_rcsp.model.command.file_op;

import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.parameter.StartLargeFileTransferParam;
import com.jieli.jl_rcsp.model.response.StartLargeFileTransferResponse;

/* loaded from: classes10.dex */
public class StartLargeFileTransferCmd extends CommandWithParamAndResponse<StartLargeFileTransferParam, StartLargeFileTransferResponse> {
    public StartLargeFileTransferCmd(StartLargeFileTransferParam startLargeFileTransferParam) {
        super(27, StartLargeFileTransferCmd.class.getSimpleName(), startLargeFileTransferParam);
    }
}
