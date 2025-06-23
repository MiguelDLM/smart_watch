package com.jieli.jl_rcsp.model.parameter;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class NotifyFileTransferParam extends BaseParameter {
    private int op;

    public NotifyFileTransferParam() {
    }

    public int getOp() {
        return this.op;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
    public byte[] getParamData() {
        return new byte[]{CHexConver.intToByte(this.op)};
    }

    public NotifyFileTransferParam setOp(int i) {
        this.op = i;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter
    public String toString() {
        return "NotifyFileTransferParam{op=" + this.op + "} " + super.toString();
    }

    public NotifyFileTransferParam(int i) {
        setOp(i);
    }
}
