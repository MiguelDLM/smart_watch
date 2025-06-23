package com.jieli.jl_rcsp.model.parameter;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class StopFileTransferParam extends BaseParameter {
    private int reason;

    public StopFileTransferParam(int i) {
        this.reason = i;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
    public byte[] getParamData() {
        return new byte[]{CHexConver.intToByte(this.reason)};
    }

    public int getReason() {
        return this.reason;
    }

    public void setReason(int i) {
        this.reason = i;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter
    public String toString() {
        return "StopFileTransferParam{reason=" + this.reason + "}\n" + super.toString();
    }
}
