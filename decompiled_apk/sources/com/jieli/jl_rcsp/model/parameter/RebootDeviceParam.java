package com.jieli.jl_rcsp.model.parameter;

import com.jieli.jl_rcsp.model.base.BaseParameter;

/* loaded from: classes10.dex */
public class RebootDeviceParam extends BaseParameter {
    private final int flag;

    public RebootDeviceParam(int i) {
        this.flag = i;
    }

    public int getFlag() {
        return this.flag;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
    public byte[] getParamData() {
        return new byte[]{(byte) this.flag};
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter
    public String toString() {
        return "RebootDeviceParam{flag=" + this.flag + '}';
    }
}
