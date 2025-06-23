package com.jieli.jl_rcsp.model.parameter;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class GetTargetInfoParam extends BaseParameter {
    private int mask;
    private byte platform;

    public GetTargetInfoParam(int i) {
        this.mask = i;
        setPlatform((byte) 0);
    }

    public int getMask() {
        return this.mask;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
    public byte[] getParamData() {
        byte[] bArr = new byte[5];
        byte[] intToBigBytes = CHexConver.intToBigBytes(this.mask);
        System.arraycopy(intToBigBytes, 0, bArr, 0, intToBigBytes.length);
        bArr[4] = this.platform;
        return bArr;
    }

    public byte getPlatform() {
        return this.platform;
    }

    public GetTargetInfoParam setMask(int i) {
        this.mask = i;
        return this;
    }

    public GetTargetInfoParam setPlatform(byte b) {
        this.platform = b;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter
    public String toString() {
        return "GetTargetInfoParam{mask=" + this.mask + '}';
    }
}
