package com.jieli.jl_rcsp.model.response;

import com.jieli.jl_rcsp.model.base.CommonResponse;

/* loaded from: classes10.dex */
public class StartLargeFileTransferResponse extends CommonResponse {
    private short transferMtu;

    public StartLargeFileTransferResponse(short s) {
        this.transferMtu = s;
    }

    public short getTransferMtu() {
        return this.transferMtu;
    }

    public void setTransferMtu(short s) {
        this.transferMtu = s;
    }

    @Override // com.jieli.jl_rcsp.model.base.CommonResponse
    public String toString() {
        return "StartLargeFileTransferResponse{transferMtu=" + ((int) this.transferMtu) + '}';
    }

    public StartLargeFileTransferResponse() {
        this.transferMtu = (short) 265;
    }
}
