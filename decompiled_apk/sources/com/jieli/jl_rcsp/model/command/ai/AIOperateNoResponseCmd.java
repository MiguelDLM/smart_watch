package com.jieli.jl_rcsp.model.command.ai;

import com.jieli.jl_rcsp.model.base.CommandWithParam;
import com.jieli.jl_rcsp.model.parameter.AIOperateParam;

/* loaded from: classes10.dex */
public class AIOperateNoResponseCmd extends CommandWithParam<AIOperateParam> {
    public AIOperateNoResponseCmd(AIOperateParam aIOperateParam) {
        super(50, AIOperateNoResponseCmd.class.getSimpleName(), aIOperateParam);
    }
}
