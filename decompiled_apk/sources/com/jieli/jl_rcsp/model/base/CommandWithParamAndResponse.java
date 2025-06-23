package com.jieli.jl_rcsp.model.base;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.model.base.CommonResponse;

/* loaded from: classes10.dex */
public class CommandWithParamAndResponse<P extends BaseParameter, R extends CommonResponse> extends CommandBase<P, R> {
    public CommandWithParamAndResponse(int i, String str, P p) {
        super(i, str, 2);
        setParam(p);
    }
}
