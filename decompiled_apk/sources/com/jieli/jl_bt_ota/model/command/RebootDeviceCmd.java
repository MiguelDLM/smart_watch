package com.jieli.jl_bt_ota.model.command;

import com.jieli.jl_bt_ota.model.base.CommandWithParamAndResponse;
import com.jieli.jl_bt_ota.model.parameter.RebootDeviceParam;
import com.jieli.jl_bt_ota.model.response.RebootDeviceResponse;

/* loaded from: classes10.dex */
public class RebootDeviceCmd extends CommandWithParamAndResponse<RebootDeviceParam, RebootDeviceResponse> {
    public RebootDeviceCmd(RebootDeviceParam rebootDeviceParam) {
        super(231, RebootDeviceCmd.class.getSimpleName(), rebootDeviceParam);
    }
}
