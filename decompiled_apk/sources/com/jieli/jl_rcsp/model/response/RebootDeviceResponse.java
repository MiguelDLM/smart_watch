package com.jieli.jl_rcsp.model.response;

import com.jieli.jl_rcsp.model.base.CommonResponse;

/* loaded from: classes10.dex */
public class RebootDeviceResponse extends CommonResponse {
    private final int result;

    public RebootDeviceResponse(int i) {
        this.result = i;
    }

    public int getResult() {
        return this.result;
    }

    @Override // com.jieli.jl_rcsp.model.base.CommonResponse
    public String toString() {
        int length;
        StringBuilder sb = new StringBuilder();
        sb.append("RebootDeviceResponse{rawData size =");
        if (getRawData() == null) {
            length = 0;
        } else {
            length = getRawData().length;
        }
        sb.append(length);
        sb.append("\nxmOpCode=");
        sb.append(getXmOpCode());
        sb.append("\nresult=");
        sb.append(this.result);
        sb.append('}');
        return sb.toString();
    }
}
