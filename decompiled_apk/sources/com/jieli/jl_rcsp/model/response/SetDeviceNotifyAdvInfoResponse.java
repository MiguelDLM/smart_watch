package com.jieli.jl_rcsp.model.response;

import com.jieli.jl_rcsp.model.base.CommonResponse;

/* loaded from: classes10.dex */
public class SetDeviceNotifyAdvInfoResponse extends CommonResponse {
    private int result;

    public SetDeviceNotifyAdvInfoResponse(int i) {
        this.result = i;
    }

    public int getResult() {
        return this.result;
    }

    public SetDeviceNotifyAdvInfoResponse setResult(int i) {
        this.result = i;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.base.CommonResponse
    public String toString() {
        return "SetDeviceNotifyAdvInfoResponse{result=" + this.result + "} " + super.toString();
    }
}
