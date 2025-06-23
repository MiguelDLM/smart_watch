package com.jieli.jl_bt_ota.model.parameter;

import com.jieli.jl_bt_ota.model.base.BaseParameter;
import com.jieli.jl_bt_ota.util.CHexConver;

/* loaded from: classes10.dex */
public class SettingsMtuParam extends BaseParameter {
    private int mtu;

    public SettingsMtuParam(int i) {
        this.mtu = i;
    }

    public int getMtu() {
        return this.mtu;
    }

    @Override // com.jieli.jl_bt_ota.model.base.BaseParameter, com.jieli.jl_bt_ota.interfaces.command.IParamBase
    public byte[] getParamData() {
        return CHexConver.int2byte2(this.mtu);
    }

    public void setMtu(int i) {
        this.mtu = i;
    }
}
