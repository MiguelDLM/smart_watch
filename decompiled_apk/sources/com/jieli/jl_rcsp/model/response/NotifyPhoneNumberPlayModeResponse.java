package com.jieli.jl_rcsp.model.response;

import com.jieli.jl_rcsp.model.base.CommonResponse;

/* loaded from: classes10.dex */
public class NotifyPhoneNumberPlayModeResponse extends CommonResponse {
    private int reason = -1;

    public NotifyPhoneNumberPlayModeResponse() {
    }

    public int getReason() {
        return this.reason;
    }

    public NotifyPhoneNumberPlayModeResponse setReason(int i) {
        this.reason = i;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.base.CommonResponse
    public String toString() {
        return "NotifyPhoneNumberPlayModeResponse{reason=" + this.reason + "} " + super.toString();
    }

    public NotifyPhoneNumberPlayModeResponse(int i) {
        setReason(i);
    }
}
