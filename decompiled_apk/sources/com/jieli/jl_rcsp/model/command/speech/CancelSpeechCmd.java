package com.jieli.jl_rcsp.model.command.speech;

import com.jieli.jl_rcsp.model.base.CommandWithResponse;
import com.jieli.jl_rcsp.model.base.CommonResponse;

/* loaded from: classes10.dex */
public class CancelSpeechCmd extends CommandWithResponse<CommonResponse> {
    public CancelSpeechCmd() {
        super(210, CancelSpeechCmd.class.getSimpleName());
    }
}
