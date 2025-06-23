package com.jieli.jl_bt_ota.model.parameter;

import com.jieli.jl_bt_ota.model.base.BaseParameter;

/* loaded from: classes10.dex */
public class NotifyCommunicationWayParam extends BaseParameter {
    private int reconnect;
    private int way;

    public NotifyCommunicationWayParam(int i, int i2) {
        this.way = i;
        this.reconnect = i2;
    }

    @Override // com.jieli.jl_bt_ota.model.base.BaseParameter, com.jieli.jl_bt_ota.interfaces.command.IParamBase
    public byte[] getParamData() {
        return new byte[]{(byte) this.way, (byte) this.reconnect};
    }

    public int getReconnect() {
        return this.reconnect;
    }

    public int getWay() {
        return this.way;
    }

    @Override // com.jieli.jl_bt_ota.model.base.BaseParameter
    public String toString() {
        return "NotifyCommunicationWayParam{way=" + this.way + "reconnect=" + this.reconnect + '}';
    }
}
