package com.jieli.jl_rcsp.model.response;

import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class CustomResponse extends CommonResponse {
    private byte[] data;

    public CustomResponse(byte[] bArr) {
        this.data = bArr;
    }

    public byte[] getData() {
        return this.data;
    }

    public CustomResponse setData(byte[] bArr) {
        this.data = bArr;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.base.CommonResponse
    public String toString() {
        return "CustomParam{data=" + CHexConver.byte2HexStr(this.data) + '}';
    }

    public CustomResponse() {
    }
}
