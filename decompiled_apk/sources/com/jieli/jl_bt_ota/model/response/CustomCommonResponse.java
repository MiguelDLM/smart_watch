package com.jieli.jl_bt_ota.model.response;

import com.jieli.jl_bt_ota.model.base.CommonResponse;
import java.util.Arrays;

/* loaded from: classes10.dex */
public class CustomCommonResponse extends CommonResponse {
    private int jlOpCode;

    public int getJlOpCode() {
        return this.jlOpCode;
    }

    public void setJlOpCode(int i) {
        this.jlOpCode = i;
    }

    @Override // com.jieli.jl_bt_ota.model.base.CommonResponse
    public String toString() {
        return "CustomCommonResponse{rawData=" + Arrays.toString(getRawData()) + "\nxmOpCode=" + getXmOpCode() + "\njlOpCode=" + this.jlOpCode + '}';
    }
}
