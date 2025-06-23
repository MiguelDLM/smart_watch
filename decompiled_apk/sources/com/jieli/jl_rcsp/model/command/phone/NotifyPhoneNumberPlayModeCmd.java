package com.jieli.jl_rcsp.model.command.phone;

import com.jieli.jl_rcsp.constant.Command;
import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.parameter.NotifyPhoneNumberPlayModeParam;
import com.jieli.jl_rcsp.model.response.NotifyPhoneNumberPlayModeResponse;

/* loaded from: classes10.dex */
public class NotifyPhoneNumberPlayModeCmd extends CommandWithParamAndResponse<NotifyPhoneNumberPlayModeParam, NotifyPhoneNumberPlayModeResponse> {
    public NotifyPhoneNumberPlayModeCmd(NotifyPhoneNumberPlayModeParam notifyPhoneNumberPlayModeParam) {
        super(Command.CMD_PHONE_NUMBER_PLAY_MODE, NotifyPhoneNumberPlayModeCmd.class.getSimpleName(), notifyPhoneNumberPlayModeParam);
    }
}
