package com.jieli.jl_rcsp.model.command.file_op;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.base.CommonResponse;

/* loaded from: classes10.dex */
public class CancelLargeFileTransferCmd extends CommandWithParamAndResponse<BaseParameter, CommonResponse> {
    public CancelLargeFileTransferCmd() {
        super(30, CancelLargeFileTransferCmd.class.getSimpleName(), new BaseParameter());
    }
}
