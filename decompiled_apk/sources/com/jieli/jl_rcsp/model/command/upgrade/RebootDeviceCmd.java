package com.jieli.jl_rcsp.model.command.upgrade;

import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.parameter.RebootDeviceParam;
import com.jieli.jl_rcsp.model.response.RebootDeviceResponse;

/* loaded from: classes10.dex */
public class RebootDeviceCmd extends CommandWithParamAndResponse<RebootDeviceParam, RebootDeviceResponse> {
    public RebootDeviceCmd(RebootDeviceParam rebootDeviceParam) {
        super(231, RebootDeviceCmd.class.getSimpleName(), rebootDeviceParam);
    }
}
