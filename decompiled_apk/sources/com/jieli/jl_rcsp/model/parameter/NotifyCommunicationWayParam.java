package com.jieli.jl_rcsp.model.parameter;

import com.jieli.jl_rcsp.model.base.BaseParameter;

/* loaded from: classes10.dex */
public class NotifyCommunicationWayParam extends BaseParameter {
    private final int reconnect;
    private final int way;

    public NotifyCommunicationWayParam(int i, int i2) {
        this.way = i;
        this.reconnect = i2;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
    public byte[] getParamData() {
        return new byte[]{(byte) this.way, (byte) this.reconnect};
    }

    public int getReconnect() {
        return this.reconnect;
    }

    public int getWay() {
        return this.way;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter
    public String toString() {
        return "NotifyCommunicationWayParam{way=" + this.way + '}';
    }
}
