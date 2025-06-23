package com.jieli.jl_bt_ota.model.command.tws;

import com.jieli.jl_bt_ota.model.base.CommandWithParam;
import com.jieli.jl_bt_ota.model.parameter.tws.NotifyAdvInfoParam;

/* loaded from: classes10.dex */
public class NotifyAdvInfoCmd extends CommandWithParam<NotifyAdvInfoParam> {
    public NotifyAdvInfoCmd(NotifyAdvInfoParam notifyAdvInfoParam) {
        super(194, NotifyAdvInfoCmd.class.getSimpleName(), notifyAdvInfoParam);
    }
}
