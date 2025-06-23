package com.jieli.jl_rcsp.model.command.tws;

import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.model.parameter.RequestAdvOpParam;

/* loaded from: classes10.dex */
public class RequestAdvOpCmd extends CommandWithParamAndResponse<RequestAdvOpParam, CommonResponse> {
    public RequestAdvOpCmd(RequestAdvOpParam requestAdvOpParam) {
        super(196, RequestAdvOpCmd.class.getSimpleName(), requestAdvOpParam);
    }
}
