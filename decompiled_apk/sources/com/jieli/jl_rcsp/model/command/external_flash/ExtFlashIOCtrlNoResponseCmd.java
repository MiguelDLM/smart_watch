package com.jieli.jl_rcsp.model.command.external_flash;

import com.jieli.jl_rcsp.model.base.CommandWithParam;
import com.jieli.jl_rcsp.model.parameter.ExternalFlashIOCtrlParam;

/* loaded from: classes10.dex */
public class ExtFlashIOCtrlNoResponseCmd extends CommandWithParam<ExternalFlashIOCtrlParam> {
    public ExtFlashIOCtrlNoResponseCmd(ExternalFlashIOCtrlParam externalFlashIOCtrlParam) {
        super(26, ExtFlashIOCtrlNoResponseCmd.class.getSimpleName(), externalFlashIOCtrlParam);
    }
}
