package com.jieli.jl_rcsp.model.parameter;

import com.jieli.jl_rcsp.model.base.BaseParameter;

/* loaded from: classes10.dex */
public class SetDeviceNotifyAdvInfoParam extends BaseParameter {
    private int op;

    public SetDeviceNotifyAdvInfoParam(int i) {
        this.op = i;
    }

    public int getOp() {
        return this.op;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
    public byte[] getParamData() {
        return new byte[]{(byte) this.op};
    }

    public SetDeviceNotifyAdvInfoParam setOp(int i) {
        this.op = i;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter
    public String toString() {
        return "SetDeviceNotifyAdvInfoParam{op=" + this.op + "} " + super.toString();
    }
}
