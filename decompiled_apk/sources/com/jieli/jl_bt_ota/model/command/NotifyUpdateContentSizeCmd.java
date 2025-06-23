package com.jieli.jl_bt_ota.model.command;

import com.jieli.jl_bt_ota.model.base.CommandWithParamAndResponse;
import com.jieli.jl_bt_ota.model.base.CommonResponse;
import com.jieli.jl_bt_ota.model.parameter.NotifyUpdateContentSizeParam;

/* loaded from: classes10.dex */
public class NotifyUpdateContentSizeCmd extends CommandWithParamAndResponse<NotifyUpdateContentSizeParam, CommonResponse> {
    public NotifyUpdateContentSizeCmd(NotifyUpdateContentSizeParam notifyUpdateContentSizeParam) {
        super(232, NotifyUpdateContentSizeCmd.class.getSimpleName(), notifyUpdateContentSizeParam);
    }
}
