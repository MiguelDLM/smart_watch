package com.jieli.jl_bt_ota.model.command;

import com.jieli.jl_bt_ota.model.base.CommandWithResponse;
import com.jieli.jl_bt_ota.model.response.FirmwareUpdateStatusResponse;

/* loaded from: classes10.dex */
public class FirmwareUpdateStatusCmd extends CommandWithResponse<FirmwareUpdateStatusResponse> {
    public FirmwareUpdateStatusCmd() {
        super(230, FirmwareUpdateStatusCmd.class.getSimpleName());
    }
}
