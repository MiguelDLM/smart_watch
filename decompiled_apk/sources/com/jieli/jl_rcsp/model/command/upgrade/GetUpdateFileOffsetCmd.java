package com.jieli.jl_rcsp.model.command.upgrade;

import com.jieli.jl_rcsp.model.base.CommandWithResponse;
import com.jieli.jl_rcsp.model.response.UpdateFileOffsetResponse;

/* loaded from: classes10.dex */
public class GetUpdateFileOffsetCmd extends CommandWithResponse<UpdateFileOffsetResponse> {
    public GetUpdateFileOffsetCmd() {
        super(225, GetUpdateFileOffsetCmd.class.getSimpleName());
    }
}
