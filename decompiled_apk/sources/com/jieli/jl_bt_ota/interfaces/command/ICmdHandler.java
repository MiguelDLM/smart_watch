package com.jieli.jl_bt_ota.interfaces.command;

import com.jieli.jl_bt_ota.model.base.BasePacket;
import com.jieli.jl_bt_ota.model.base.CommandBase;

/* loaded from: classes10.dex */
public interface ICmdHandler {
    CommandBase parseDataToCmd(BasePacket basePacket, CommandBase commandBase);
}
