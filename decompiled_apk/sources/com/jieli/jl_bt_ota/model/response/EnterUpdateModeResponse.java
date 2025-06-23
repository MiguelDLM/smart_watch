package com.jieli.jl_bt_ota.model.response;

import com.jieli.jl_bt_ota.model.base.CommonResponse;

/* loaded from: classes10.dex */
public class EnterUpdateModeResponse extends CommonResponse {
    private int canUpdateFlag;

    public EnterUpdateModeResponse(int i) {
        this.canUpdateFlag = i;
    }

    public int getCanUpdateFlag() {
        return this.canUpdateFlag;
    }

    @Override // com.jieli.jl_bt_ota.model.base.CommonResponse
    public String toString() {
        int length;
        StringBuilder sb = new StringBuilder();
        sb.append("EnterUpdateModeResponse{rawData size =");
        if (getRawData() == null) {
            length = 0;
        } else {
            length = getRawData().length;
        }
        sb.append(length);
        sb.append("\nxmOpCode=");
        sb.append(getXmOpCode());
        sb.append("\ncanUpdateFlag=");
        sb.append(this.canUpdateFlag);
        sb.append('}');
        return sb.toString();
    }
}
