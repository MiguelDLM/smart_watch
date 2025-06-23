package com.jieli.jl_rcsp.model.response;

import com.jieli.jl_rcsp.model.base.CommonResponse;

/* loaded from: classes10.dex */
public class SetADVResponse extends CommonResponse {
    private int result;

    public SetADVResponse() {
    }

    public int getResult() {
        return this.result;
    }

    public SetADVResponse setResult(int i) {
        this.result = i;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.base.CommonResponse
    public String toString() {
        return "SetADVResponse{result=" + this.result + "} " + super.toString();
    }

    public SetADVResponse(int i) {
        setResult(i);
    }
}
