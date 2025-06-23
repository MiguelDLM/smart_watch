package com.jieli.jl_rcsp.model.response;

import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.util.RcspUtil;

/* loaded from: classes10.dex */
public class GetLowLatencySettingsResponse extends CommonResponse {
    private int delayMs;
    private int mtu;

    public GetLowLatencySettingsResponse() {
        this(20);
    }

    public int getDelayMs() {
        return this.delayMs;
    }

    public int getMtu() {
        return this.mtu;
    }

    public GetLowLatencySettingsResponse setDelayMs(int i) {
        this.delayMs = i;
        return this;
    }

    public GetLowLatencySettingsResponse setMtu(int i) {
        this.mtu = RcspUtil.formatBleMtu(i);
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.base.CommonResponse
    public String toString() {
        return "GetLowLatencySettingsResponse{mtu=" + this.mtu + ", delayMs=" + this.delayMs + "} " + super.toString();
    }

    public GetLowLatencySettingsResponse(int i) {
        this(i, 50);
    }

    public GetLowLatencySettingsResponse(int i, int i2) {
        this.mtu = 20;
        this.delayMs = 50;
        setMtu(i);
        setDelayMs(i2);
    }
}
