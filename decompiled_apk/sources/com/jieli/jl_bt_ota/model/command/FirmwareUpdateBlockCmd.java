package com.jieli.jl_bt_ota.model.command;

import com.jieli.jl_bt_ota.model.base.CommandWithParamAndResponse;
import com.jieli.jl_bt_ota.model.parameter.FirmwareUpdateBlockParam;
import com.jieli.jl_bt_ota.model.response.FirmwareUpdateBlockResponse;

/* loaded from: classes10.dex */
public class FirmwareUpdateBlockCmd extends CommandWithParamAndResponse<FirmwareUpdateBlockParam, FirmwareUpdateBlockResponse> {
    public FirmwareUpdateBlockCmd(FirmwareUpdateBlockParam firmwareUpdateBlockParam) {
        super(229, FirmwareUpdateBlockCmd.class.getSimpleName(), firmwareUpdateBlockParam);
    }
}
