package com.jieli.jl_rcsp.model.command;

import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.parameter.SettingsMtuParam;
import com.jieli.jl_rcsp.model.response.SettingsMtuResponse;

/* loaded from: classes10.dex */
public class SettingsMtuCmd extends CommandWithParamAndResponse<SettingsMtuParam, SettingsMtuResponse> {
    public SettingsMtuCmd(SettingsMtuParam settingsMtuParam) {
        super(209, SettingsMtuCmd.class.getSimpleName(), settingsMtuParam);
    }
}
