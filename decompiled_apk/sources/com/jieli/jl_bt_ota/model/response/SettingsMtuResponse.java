package com.jieli.jl_bt_ota.model.response;

import com.jieli.jl_bt_ota.model.base.CommonResponse;

/* loaded from: classes10.dex */
public class SettingsMtuResponse extends CommonResponse {
    private int realMtu;

    public SettingsMtuResponse(int i) {
        this.realMtu = i;
    }

    public int getRealMtu() {
        return this.realMtu;
    }

    public SettingsMtuResponse setRealMtu(int i) {
        this.realMtu = i;
        return this;
    }
}
