package com.jieli.jl_bt_ota.model.response;

import com.jieli.jl_bt_ota.model.base.CommonResponse;

/* loaded from: classes10.dex */
public class TargetFeatureMapResponse extends CommonResponse {
    private int mask;

    public TargetFeatureMapResponse() {
    }

    public int getMask() {
        return this.mask;
    }

    public void setMask(int i) {
        this.mask = i;
    }

    @Override // com.jieli.jl_bt_ota.model.base.CommonResponse
    public String toString() {
        return "GetTargetFeatureMapResponse{mask=" + this.mask + '}';
    }

    public TargetFeatureMapResponse(int i) {
        setMask(i);
    }
}
