package com.jieli.jl_rcsp.model.command.upgrade;

import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.model.parameter.NotifyUpdateContentSizeParam;

/* loaded from: classes10.dex */
public class NotifyUpdateContentSizeCmd extends CommandWithParamAndResponse<NotifyUpdateContentSizeParam, CommonResponse> {
    public NotifyUpdateContentSizeCmd(NotifyUpdateContentSizeParam notifyUpdateContentSizeParam) {
        super(232, NotifyUpdateContentSizeCmd.class.getSimpleName(), notifyUpdateContentSizeParam);
    }
}
