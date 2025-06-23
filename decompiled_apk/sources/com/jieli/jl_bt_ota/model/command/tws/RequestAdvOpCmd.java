package com.jieli.jl_bt_ota.model.command.tws;

import com.jieli.jl_bt_ota.model.base.CommandWithParamAndResponse;
import com.jieli.jl_bt_ota.model.base.CommonResponse;
import com.jieli.jl_bt_ota.model.parameter.tws.RequestAdvOpParam;

/* loaded from: classes10.dex */
public class RequestAdvOpCmd extends CommandWithParamAndResponse<RequestAdvOpParam, CommonResponse> {
    public RequestAdvOpCmd(RequestAdvOpParam requestAdvOpParam) {
        super(196, RequestAdvOpCmd.class.getSimpleName(), requestAdvOpParam);
    }
}
