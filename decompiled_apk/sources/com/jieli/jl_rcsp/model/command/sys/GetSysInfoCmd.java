package com.jieli.jl_rcsp.model.command.sys;

import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.parameter.GetSysInfoParam;
import com.jieli.jl_rcsp.model.response.SysInfoResponse;

/* loaded from: classes10.dex */
public class GetSysInfoCmd extends CommandWithParamAndResponse<GetSysInfoParam, SysInfoResponse> {
    public GetSysInfoCmd(GetSysInfoParam getSysInfoParam) {
        super(7, GetSysInfoCmd.class.getSimpleName(), getSysInfoParam);
    }
}
