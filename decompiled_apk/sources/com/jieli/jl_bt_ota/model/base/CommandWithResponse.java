package com.jieli.jl_bt_ota.model.base;

import com.jieli.jl_bt_ota.model.base.CommonResponse;

/* loaded from: classes10.dex */
public class CommandWithResponse<R extends CommonResponse> extends CommandBase<BaseParameter, R> {
    public CommandWithResponse(int i, String str) {
        super(i, str, 3);
    }
}
