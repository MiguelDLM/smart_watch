package com.jieli.jl_rcsp.model.parameter;

import com.jieli.jl_rcsp.model.base.BaseParameter;

/* loaded from: classes10.dex */
public class NotifyAppInfoParam extends BaseParameter {
    private final int XiaoMiFlag;

    public NotifyAppInfoParam(int i) {
        this.XiaoMiFlag = i;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
    public byte[] getParamData() {
        return new byte[]{(byte) this.XiaoMiFlag};
    }

    public int getXiaoMiFlag() {
        return this.XiaoMiFlag;
    }
}
