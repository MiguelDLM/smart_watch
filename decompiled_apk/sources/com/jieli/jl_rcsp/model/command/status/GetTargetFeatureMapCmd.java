package com.jieli.jl_rcsp.model.command.status;

import com.jieli.jl_rcsp.model.base.CommandWithResponse;
import com.jieli.jl_rcsp.model.response.TargetFeatureMapResponse;

/* loaded from: classes10.dex */
public class GetTargetFeatureMapCmd extends CommandWithResponse<TargetFeatureMapResponse> {
    public GetTargetFeatureMapCmd() {
        super(2, GetTargetFeatureMapCmd.class.getSimpleName());
    }
}
