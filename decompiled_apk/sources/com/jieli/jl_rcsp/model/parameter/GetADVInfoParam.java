package com.jieli.jl_rcsp.model.parameter;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class GetADVInfoParam extends BaseParameter {
    private int mask;

    public GetADVInfoParam(int i) {
        this.mask = i;
    }

    public int getMask() {
        return this.mask;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
    public byte[] getParamData() {
        return CHexConver.intToBigBytes(this.mask);
    }

    public GetADVInfoParam setMask(int i) {
        this.mask = i;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter
    public String toString() {
        return "GetADVInfoParam{mask=" + this.mask + "} " + super.toString();
    }
}
