package com.jieli.jl_rcsp.model.command.file_op;

import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.parameter.DelDevFileParam;
import com.jieli.jl_rcsp.model.response.DelDevFileResponse;

/* loaded from: classes10.dex */
public class DelDevFileCmd extends CommandWithParamAndResponse<DelDevFileParam, DelDevFileResponse> {
    public DelDevFileCmd(DelDevFileParam delDevFileParam) {
        super(31, DelDevFileCmd.class.getSimpleName(), delDevFileParam);
    }
}
