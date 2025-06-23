package com.jieli.jl_rcsp.model.command.tws;

import com.jieli.jl_rcsp.model.base.CommandWithResponse;
import com.jieli.jl_rcsp.model.response.GetLowLatencySettingsResponse;

/* loaded from: classes10.dex */
public class GetLowLatencySettingsCmd extends CommandWithResponse<GetLowLatencySettingsResponse> {
    public GetLowLatencySettingsCmd() {
        super(213, GetLowLatencySettingsCmd.class.getSimpleName());
    }
}
