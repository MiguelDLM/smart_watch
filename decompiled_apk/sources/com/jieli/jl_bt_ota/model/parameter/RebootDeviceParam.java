package com.jieli.jl_bt_ota.model.parameter;

import com.jieli.jl_bt_ota.model.base.BaseParameter;

/* loaded from: classes10.dex */
public class RebootDeviceParam extends BaseParameter {
    private int param;

    public RebootDeviceParam(int i) {
        this.param = i;
    }

    @Override // com.jieli.jl_bt_ota.model.base.BaseParameter, com.jieli.jl_bt_ota.interfaces.command.IParamBase
    public byte[] getParamData() {
        return new byte[]{(byte) this.param};
    }

    @Override // com.jieli.jl_bt_ota.model.base.BaseParameter
    public String toString() {
        return "RebootDeviceParam{param=" + this.param + '}';
    }
}
