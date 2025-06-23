package com.jieli.jl_bt_ota.model.command;

import com.jieli.jl_bt_ota.model.base.CommandWithParamAndResponse;
import com.jieli.jl_bt_ota.model.parameter.InquireUpdateParam;
import com.jieli.jl_bt_ota.model.response.InquireUpdateResponse;

/* loaded from: classes10.dex */
public class InquireUpdateCmd extends CommandWithParamAndResponse<InquireUpdateParam, InquireUpdateResponse> {
    public InquireUpdateCmd(InquireUpdateParam inquireUpdateParam) {
        super(226, InquireUpdateCmd.class.getSimpleName(), inquireUpdateParam);
    }
}
