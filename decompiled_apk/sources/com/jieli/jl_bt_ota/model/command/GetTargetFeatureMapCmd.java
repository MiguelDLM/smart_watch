package com.jieli.jl_bt_ota.model.command;

import com.jieli.jl_bt_ota.model.base.CommandWithResponse;
import com.jieli.jl_bt_ota.model.response.TargetFeatureMapResponse;

/* loaded from: classes10.dex */
public class GetTargetFeatureMapCmd extends CommandWithResponse<TargetFeatureMapResponse> {
    public GetTargetFeatureMapCmd() {
        super(2, GetTargetFeatureMapCmd.class.getSimpleName());
    }
}
