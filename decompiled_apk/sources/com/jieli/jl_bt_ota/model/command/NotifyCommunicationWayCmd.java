package com.jieli.jl_bt_ota.model.command;

import com.jieli.jl_bt_ota.model.base.CommandWithParamAndResponse;
import com.jieli.jl_bt_ota.model.parameter.NotifyCommunicationWayParam;
import com.jieli.jl_bt_ota.model.response.NotifyCommunicationWayResponse;

/* loaded from: classes10.dex */
public class NotifyCommunicationWayCmd extends CommandWithParamAndResponse<NotifyCommunicationWayParam, NotifyCommunicationWayResponse> {
    public NotifyCommunicationWayCmd(NotifyCommunicationWayParam notifyCommunicationWayParam) {
        super(11, NotifyCommunicationWayCmd.class.getSimpleName(), notifyCommunicationWayParam);
    }
}
