package com.jieli.jl_bt_ota.model.command;

import com.jieli.jl_bt_ota.model.base.CommandWithResponse;
import com.jieli.jl_bt_ota.model.response.GetDevMD5Response;

/* loaded from: classes10.dex */
public class GetDevMD5Cmd extends CommandWithResponse<GetDevMD5Response> {
    public GetDevMD5Cmd() {
        super(212, GetDevMD5Cmd.class.getSimpleName());
    }
}
