package com.jieli.jl_bt_ota.model.response;

import com.jieli.jl_bt_ota.model.base.CommonResponse;

/* loaded from: classes10.dex */
public class InquireUpdateResponse extends CommonResponse {
    private int canUpdateFlag;

    public InquireUpdateResponse(int i) {
        this.canUpdateFlag = i;
    }

    public int getCanUpdateFlag() {
        return this.canUpdateFlag;
    }

    @Override // com.jieli.jl_bt_ota.model.base.CommonResponse
    public String toString() {
        return "InquireUpdateResponse{canUpdateFlag=" + this.canUpdateFlag + '}';
    }
}
