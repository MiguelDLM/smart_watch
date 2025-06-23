package com.jieli.jl_rcsp.model.command.status;

import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.parameter.GetTargetInfoParam;
import com.jieli.jl_rcsp.model.response.TargetInfoResponse;

/* loaded from: classes10.dex */
public class GetTargetInfoCmd extends CommandWithParamAndResponse<GetTargetInfoParam, TargetInfoResponse> {
    public GetTargetInfoCmd(GetTargetInfoParam getTargetInfoParam) {
        super(3, GetTargetInfoCmd.class.getSimpleName(), getTargetInfoParam);
    }
}
