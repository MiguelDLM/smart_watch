package com.jieli.jl_rcsp.model.command.upgrade;

import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.parameter.InquireUpdateParam;
import com.jieli.jl_rcsp.model.response.InquireUpdateResponse;

/* loaded from: classes10.dex */
public class InquireUpdateCmd extends CommandWithParamAndResponse<InquireUpdateParam, InquireUpdateResponse> {
    public InquireUpdateCmd(InquireUpdateParam inquireUpdateParam) {
        super(226, InquireUpdateCmd.class.getSimpleName(), inquireUpdateParam);
    }
}
