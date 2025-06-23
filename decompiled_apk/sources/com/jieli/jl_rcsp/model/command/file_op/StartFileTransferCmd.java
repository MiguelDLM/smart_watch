package com.jieli.jl_rcsp.model.command.file_op;

import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.parameter.StartFileTransferParam;
import com.jieli.jl_rcsp.model.response.StartFileTranferResponse;

@Deprecated
/* loaded from: classes10.dex */
public class StartFileTransferCmd extends CommandWithParamAndResponse<StartFileTransferParam, StartFileTranferResponse> {
    public StartFileTransferCmd(StartFileTransferParam startFileTransferParam) {
        super(22, StartFileTransferCmd.class.getSimpleName(), startFileTransferParam);
    }
}
