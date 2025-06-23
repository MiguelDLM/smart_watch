package com.jieli.jl_rcsp.model.command;

import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.model.parameter.NotifyAppInfoParam;

/* loaded from: classes10.dex */
public class NotifyAppInfoCmd extends CommandWithParamAndResponse<NotifyAppInfoParam, CommonResponse> {
    public NotifyAppInfoCmd(NotifyAppInfoParam notifyAppInfoParam) {
        super(208, NotifyAppInfoCmd.class.getSimpleName(), notifyAppInfoParam);
    }
}
