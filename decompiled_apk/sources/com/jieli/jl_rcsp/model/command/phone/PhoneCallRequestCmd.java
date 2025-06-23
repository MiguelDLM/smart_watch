package com.jieli.jl_rcsp.model.command.phone;

import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.model.parameter.PhoneCallRequestParam;

/* loaded from: classes10.dex */
public class PhoneCallRequestCmd extends CommandWithParamAndResponse<PhoneCallRequestParam, CommonResponse> {
    public PhoneCallRequestCmd(PhoneCallRequestParam phoneCallRequestParam) {
        super(10, PhoneCallRequestCmd.class.getSimpleName(), phoneCallRequestParam);
    }
}
