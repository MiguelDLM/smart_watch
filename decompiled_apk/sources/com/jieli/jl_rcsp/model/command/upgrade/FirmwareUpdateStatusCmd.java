package com.jieli.jl_rcsp.model.command.upgrade;

import com.jieli.jl_rcsp.model.base.CommandWithResponse;
import com.jieli.jl_rcsp.model.response.FirmwareUpdateStatusResponse;

/* loaded from: classes10.dex */
public class FirmwareUpdateStatusCmd extends CommandWithResponse<FirmwareUpdateStatusResponse> {
    public FirmwareUpdateStatusCmd() {
        super(230, FirmwareUpdateStatusCmd.class.getSimpleName());
    }
}
