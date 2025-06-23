package com.jieli.jl_rcsp.model.response;

import com.jieli.jl_rcsp.model.base.CommonResponse;

/* loaded from: classes10.dex */
public class BaseNFCResponse extends CommonResponse {
    private final byte[] data;
    private final byte result;

    public BaseNFCResponse(byte b, byte[] bArr) {
        this.result = b;
        this.data = bArr;
    }

    public byte[] getData() {
        return this.data;
    }

    public byte getResult() {
        return this.result;
    }
}
