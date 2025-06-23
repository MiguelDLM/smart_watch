package com.jieli.jl_rcsp.model.parameter;

import com.jieli.jl_rcsp.model.base.BaseParameter;

/* loaded from: classes10.dex */
public class FunctionParam extends BaseParameter {
    private byte cmd;
    private byte[] extend;
    private byte function;

    public FunctionParam(byte b, byte b2) {
        this.function = b;
        this.cmd = b2;
    }

    public byte getCmd() {
        return this.cmd;
    }

    public byte[] getExtend() {
        return this.extend;
    }

    public byte getFunction() {
        return this.function;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
    public byte[] getParamData() {
        byte[] bArr = this.extend;
        if (bArr != null && bArr.length != 0) {
            byte[] bArr2 = new byte[bArr.length + 2];
            bArr2[0] = this.function;
            bArr2[1] = this.cmd;
            System.arraycopy(bArr, 0, bArr2, 2, bArr.length);
            return bArr2;
        }
        return new byte[]{this.function, this.cmd};
    }

    public FunctionParam setCmd(byte b) {
        this.cmd = b;
        return this;
    }

    public FunctionParam setExtend(byte[] bArr) {
        this.extend = bArr;
        return this;
    }

    public FunctionParam setFunction(byte b) {
        this.function = b;
        return this;
    }

    public FunctionParam() {
    }
}
