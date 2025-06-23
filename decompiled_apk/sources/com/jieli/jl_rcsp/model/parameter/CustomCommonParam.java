package com.jieli.jl_rcsp.model.parameter;

import com.jieli.jl_rcsp.model.base.BaseParameter;

/* loaded from: classes10.dex */
public class CustomCommonParam extends BaseParameter {
    private final int customOp;

    public CustomCommonParam(int i) {
        this.customOp = i;
    }

    public int getCustomOp() {
        return this.customOp;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
    public byte[] getParamData() {
        return new byte[]{(byte) this.customOp};
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter
    public String toString() {
        return "CustomCommonParam{xmOpCode=" + getXmOpCode() + "\ncustomOp=" + this.customOp + '}';
    }
}
