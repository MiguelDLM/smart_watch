package com.jieli.jl_bt_ota.model.command;

import com.jieli.jl_bt_ota.model.base.CommandBase;
import com.jieli.jl_bt_ota.model.parameter.CustomParam;
import com.jieli.jl_bt_ota.model.response.CustomResponse;

/* loaded from: classes10.dex */
public class CustomCmd extends CommandBase<CustomParam, CustomResponse> {
    public CustomCmd(CustomParam customParam) {
        this(2, customParam);
    }

    public CustomCmd(int i, CustomParam customParam) {
        super(255, CustomCmd.class.getSimpleName(), i);
        setParam(customParam);
    }
}
