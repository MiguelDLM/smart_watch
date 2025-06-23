package com.jieli.jl_rcsp.model.command.custom;

import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.parameter.CustomCommonParam;
import com.jieli.jl_rcsp.model.response.CustomCommonResponse;

/* loaded from: classes10.dex */
class CustomCmdWithResponse<P extends CustomCommonParam, R extends CustomCommonResponse> extends CommandWithParamAndResponse {
    private R customResponse;

    public CustomCmdWithResponse(String str, P p) {
        super(240, str, p);
    }

    public R getCustomResponse() {
        return this.customResponse;
    }

    public void setCustomResponse(R r) {
        this.customResponse = r;
        setResponse(r);
    }
}
