package com.jieli.jl_rcsp.model.command.tws;

import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.parameter.SetADVInfoParam;
import com.jieli.jl_rcsp.model.response.SetADVResponse;

/* loaded from: classes10.dex */
public class SetADVInfoCmd extends CommandWithParamAndResponse<SetADVInfoParam, SetADVResponse> {
    public SetADVInfoCmd(SetADVInfoParam setADVInfoParam) {
        super(192, SetADVInfoCmd.class.getSimpleName(), setADVInfoParam);
    }
}
