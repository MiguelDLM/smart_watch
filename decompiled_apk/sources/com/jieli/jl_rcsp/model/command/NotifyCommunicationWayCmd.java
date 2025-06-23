package com.jieli.jl_rcsp.model.command;

import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.model.parameter.NotifyCommunicationWayParam;

/* loaded from: classes10.dex */
public class NotifyCommunicationWayCmd extends CommandWithParamAndResponse<NotifyCommunicationWayParam, CommonResponse> {
    public NotifyCommunicationWayCmd(NotifyCommunicationWayParam notifyCommunicationWayParam) {
        super(11, NotifyCommunicationWayCmd.class.getSimpleName(), notifyCommunicationWayParam);
    }
}
