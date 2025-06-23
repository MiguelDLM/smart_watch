package com.jieli.jl_rcsp.model.parameter;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class CustomParam extends BaseParameter {
    private byte[] data;

    public CustomParam(byte[] bArr) {
        this.data = bArr;
    }

    public byte[] getData() {
        return this.data;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
    public byte[] getParamData() {
        byte[] bArr = this.data;
        if (bArr == null) {
            return new byte[0];
        }
        return bArr;
    }

    public CustomParam setData(byte[] bArr) {
        this.data = bArr;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter
    public String toString() {
        return "CustomParam{data=" + CHexConver.byte2HexStr(this.data) + '}';
    }

    public CustomParam() {
    }
}
