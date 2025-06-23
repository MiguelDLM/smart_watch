package com.jieli.jl_rcsp.model.command.sys;

import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.model.parameter.SetSysInfoParam;

/* loaded from: classes10.dex */
public class SetSysInfoCmd extends CommandWithParamAndResponse<SetSysInfoParam, CommonResponse> {
    public SetSysInfoCmd(SetSysInfoParam setSysInfoParam) {
        super(8, SetSysInfoCmd.class.getSimpleName(), setSysInfoParam);
    }
}
