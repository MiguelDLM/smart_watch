package com.jieli.jl_rcsp.model.parameter;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import java.io.UnsupportedEncodingException;

/* loaded from: classes10.dex */
public class StopLargeFileTransferParam extends BaseParameter {
    private String name;
    private int reason;

    public String getName() {
        return this.name;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
    public byte[] getParamData() {
        try {
            return this.name.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return getName().getBytes();
        }
    }

    public int getReason() {
        return this.reason;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setReason(int i) {
        this.reason = i;
    }
}
