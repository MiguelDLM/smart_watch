package com.jieli.jl_rcsp.model.parameter;

import com.jieli.jl_rcsp.model.base.BaseParameter;

/* loaded from: classes10.dex */
public class SetADVInfoParam extends BaseParameter {
    private byte[] payload;

    public SetADVInfoParam(byte[] bArr) {
        this.payload = bArr;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
    public byte[] getParamData() {
        return this.payload;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter
    public byte[] getPayload() {
        return this.payload;
    }

    public SetADVInfoParam setPayload(byte[] bArr) {
        this.payload = bArr;
        return this;
    }
}
