package com.jieli.jl_rcsp.model.response;

import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class CustomCommonResponse extends CommonResponse {
    private int jlOpCode;

    public int getJlOpCode() {
        return this.jlOpCode;
    }

    public CustomCommonResponse setJlOpCode(int i) {
        this.jlOpCode = i;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.base.CommonResponse
    public String toString() {
        return "CustomCommonResponse{rawData=" + CHexConver.byte2HexStr(getRawData()) + "\nxmOpCode=" + getXmOpCode() + "\njlOpCode=" + this.jlOpCode + '}';
    }
}
