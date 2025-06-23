package com.jieli.jl_rcsp.model.command.external_flash;

import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.parameter.ExternalFlashIOCtrlParam;
import com.jieli.jl_rcsp.model.response.ExternalFlashIOCtrlResponse;

/* loaded from: classes10.dex */
public class ExternalFlashIOCtrlCmd extends CommandWithParamAndResponse<ExternalFlashIOCtrlParam, ExternalFlashIOCtrlResponse> {
    public ExternalFlashIOCtrlCmd(ExternalFlashIOCtrlParam externalFlashIOCtrlParam) {
        super(26, ExternalFlashIOCtrlCmd.class.getSimpleName(), externalFlashIOCtrlParam);
    }
}
