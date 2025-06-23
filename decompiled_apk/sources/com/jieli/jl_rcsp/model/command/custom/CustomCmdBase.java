package com.jieli.jl_rcsp.model.command.custom;

import com.jieli.jl_rcsp.model.base.CommandWithParam;
import com.jieli.jl_rcsp.model.parameter.CustomCommonParam;

/* loaded from: classes10.dex */
class CustomCmdBase<T extends CustomCommonParam> extends CommandWithParam<T> {
    public CustomCmdBase(String str, T t) {
        super(240, str, t);
    }
}
