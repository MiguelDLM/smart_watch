package com.jieli.jl_rcsp.model.response;

import com.jieli.jl_rcsp.model.base.CommonResponse;

/* loaded from: classes10.dex */
public class StopFileTransferResponse extends CommonResponse {
    private int reason = 0;

    public int getReason() {
        return this.reason;
    }

    public StopFileTransferResponse setReason(int i) {
        this.reason = i;
        return this;
    }
}
