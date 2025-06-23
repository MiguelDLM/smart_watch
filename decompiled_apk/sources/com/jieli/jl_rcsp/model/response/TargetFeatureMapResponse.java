package com.jieli.jl_rcsp.model.response;

import com.jieli.jl_rcsp.model.base.CommonResponse;

/* loaded from: classes10.dex */
public class TargetFeatureMapResponse extends CommonResponse {
    private int mask;

    public int getMask() {
        return this.mask;
    }

    public TargetFeatureMapResponse setMask(int i) {
        this.mask = i;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.base.CommonResponse
    public String toString() {
        return "GetTargetFeatureMapResponse{mask=" + this.mask + '}';
    }
}
