package com.jieli.jl_rcsp.model.parameter;

import com.jieli.jl_rcsp.model.base.BaseParameter;

/* loaded from: classes10.dex */
public class StopFileBrowseParam extends BaseParameter {
    private byte reason;

    public StopFileBrowseParam(byte b) {
        this.reason = b;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
    public byte[] getParamData() {
        return new byte[]{this.reason};
    }

    public byte getReason() {
        return this.reason;
    }

    public void setReason(byte b) {
        this.reason = b;
    }
}
