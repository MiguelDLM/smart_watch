package com.jieli.jl_rcsp.model.parameter;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class RequestAdvOpParam extends BaseParameter {
    private int op;

    public RequestAdvOpParam(int i) {
        this.op = i;
    }

    public int getOp() {
        return this.op;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
    public byte[] getParamData() {
        return new byte[CHexConver.intToByte(this.op)];
    }

    public RequestAdvOpParam setOp(int i) {
        this.op = i;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter
    public String toString() {
        return "RequestAdvOpParam{op=" + this.op + "} " + super.toString();
    }
}
