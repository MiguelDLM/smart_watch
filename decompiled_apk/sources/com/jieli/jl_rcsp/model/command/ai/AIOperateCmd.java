package com.jieli.jl_rcsp.model.command.ai;

import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.parameter.AIOperateParam;
import com.jieli.jl_rcsp.model.response.AIOperateResponse;

/* loaded from: classes10.dex */
public class AIOperateCmd extends CommandWithParamAndResponse<AIOperateParam, AIOperateResponse> {
    public AIOperateCmd(AIOperateParam aIOperateParam) {
        super(50, AIOperateCmd.class.getSimpleName(), aIOperateParam);
    }
}
