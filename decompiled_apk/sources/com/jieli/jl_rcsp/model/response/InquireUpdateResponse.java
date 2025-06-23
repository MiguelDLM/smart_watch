package com.jieli.jl_rcsp.model.response;

import com.jieli.jl_rcsp.model.base.CommonResponse;

/* loaded from: classes10.dex */
public class InquireUpdateResponse extends CommonResponse {
    private final int canUpdateFlag;

    public InquireUpdateResponse(int i) {
        this.canUpdateFlag = i;
    }

    public int getCanUpdateFlag() {
        return this.canUpdateFlag;
    }

    @Override // com.jieli.jl_rcsp.model.base.CommonResponse
    public String toString() {
        return "InquireUpdateResponse{canUpdateFlag=" + this.canUpdateFlag + '}';
    }
}
