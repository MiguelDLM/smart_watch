package com.jieli.jl_rcsp.model.parameter;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class GetSysInfoParam extends BaseParameter {
    private byte function;
    private int mask;

    public GetSysInfoParam(byte b, int i) {
        this.mask = i;
        this.function = b;
    }

    public byte getFunction() {
        return this.function;
    }

    public int getMask() {
        return this.mask;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
    public byte[] getParamData() {
        byte[] bArr = new byte[5];
        bArr[0] = this.function;
        System.arraycopy(CHexConver.intToBigBytes(this.mask), 0, bArr, 1, 4);
        return bArr;
    }

    public GetSysInfoParam setFunction(byte b) {
        this.function = b;
        return this;
    }

    public GetSysInfoParam setMask(int i) {
        this.mask = i;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter
    public String toString() {
        return "GetSysInfoParam{function=" + ((int) this.function) + "mask=" + this.mask + '}';
    }
}
