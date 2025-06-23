package com.jieli.jl_rcsp.model.command.file_op;

import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.parameter.StopFileTransferParam;
import com.jieli.jl_rcsp.model.response.StopFileTransferResponse;

@Deprecated
/* loaded from: classes10.dex */
public class StopFileTransferCmd extends CommandWithParamAndResponse<StopFileTransferParam, StopFileTransferResponse> {
    public StopFileTransferCmd(StopFileTransferParam stopFileTransferParam) {
        super(23, StopFileTransferCmd.class.getSimpleName(), stopFileTransferParam);
    }
}
