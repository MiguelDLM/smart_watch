package com.jieli.jl_bt_ota.model.response;

import com.jieli.jl_bt_ota.model.base.CommonResponse;

/* loaded from: classes10.dex */
public class FirmwareUpdateStatusResponse extends CommonResponse {
    private int result;

    public FirmwareUpdateStatusResponse(int i) {
        this.result = i;
    }

    public int getResult() {
        return this.result;
    }

    @Override // com.jieli.jl_bt_ota.model.base.CommonResponse
    public String toString() {
        int length;
        StringBuilder sb = new StringBuilder();
        sb.append("FirmwareUpdateStatusResponse{rawData size =");
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
