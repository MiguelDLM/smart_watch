package com.jieli.jl_rcsp.model.command;

import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.model.parameter.FunctionParam;

/* loaded from: classes10.dex */
public class FunctionCmd extends CommandWithParamAndResponse<FunctionParam, CommonResponse> {
    public FunctionCmd(FunctionParam functionParam) {
        super(14, FunctionCmd.class.getSimpleName(), functionParam);
    }
}
