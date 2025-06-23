package com.jieli.jl_rcsp.model.response;

import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class AIOperateResponse extends CommonResponse {
    private byte[] data;
    private int result;

    public AIOperateResponse(int i) {
        setResult(i);
    }

    public byte[] getData() {
        return this.data;
    }

    public int getResult() {
        return this.result;
    }

    public AIOperateResponse setData(byte[] bArr) {
        this.data = bArr;
        return this;
    }

    public AIOperateResponse setResult(int i) {
        this.result = i;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.base.CommonResponse
    public String toString() {
        return "AIOperateResponse{result=" + this.result + ", data=" + CHexConver.byte2HexStr(this.data) + '}';
    }
}
