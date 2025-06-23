package com.jieli.jl_bt_ota.model.command;

import com.jieli.jl_bt_ota.model.base.CommandWithResponse;
import com.jieli.jl_bt_ota.model.response.UpdateFileOffsetResponse;

/* loaded from: classes10.dex */
public class GetUpdateFileOffsetCmd extends CommandWithResponse<UpdateFileOffsetResponse> {
    public GetUpdateFileOffsetCmd() {
        super(225, GetUpdateFileOffsetCmd.class.getSimpleName());
    }
}
