package com.jieli.jl_rcsp.model.command.file_op;

import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.model.parameter.NotifyFileTransferParam;

@Deprecated
/* loaded from: classes10.dex */
public class NotifyFileTransferOpCmd extends CommandWithParamAndResponse<NotifyFileTransferParam, CommonResponse> {
    public NotifyFileTransferOpCmd(NotifyFileTransferParam notifyFileTransferParam) {
        super(24, NotifyFileTransferOpCmd.class.getSimpleName(), notifyFileTransferParam);
    }
}
