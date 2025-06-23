package com.jieli.jl_rcsp.model.command.external_flash;

import com.jieli.jl_rcsp.constant.Command;
import com.jieli.jl_rcsp.model.base.CommandWithResponse;
import com.jieli.jl_rcsp.model.response.ExternalFlashMsgResponse;

/* loaded from: classes10.dex */
public class GetExternalFlashMsgCmd extends CommandWithResponse<ExternalFlashMsgResponse> {
    public GetExternalFlashMsgCmd() {
        super(Command.CMD_GET_EXTERNAL_FLASH_MSG, GetExternalFlashMsgCmd.class.getSimpleName());
    }
}
