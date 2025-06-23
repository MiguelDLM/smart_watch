package com.jieli.jl_rcsp.model.parameter;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class SettingsMtuParam extends BaseParameter {
    private final int mtu;

    public SettingsMtuParam(int i) {
        this.mtu = i;
    }

    public int getMtu() {
        return this.mtu;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
    public byte[] getParamData() {
        return CHexConver.int2byte2(this.mtu);
    }
}
