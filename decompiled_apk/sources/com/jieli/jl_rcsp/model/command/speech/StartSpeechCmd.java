package com.jieli.jl_rcsp.model.command.speech;

import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.parameter.StartSpeechParam;
import com.jieli.jl_rcsp.model.response.StartSpeechResponse;

/* loaded from: classes10.dex */
public class StartSpeechCmd extends CommandWithParamAndResponse<StartSpeechParam, StartSpeechResponse> {
    public StartSpeechCmd(StartSpeechParam startSpeechParam) {
        super(4, StartSpeechCmd.class.getSimpleName(), startSpeechParam);
    }
}
