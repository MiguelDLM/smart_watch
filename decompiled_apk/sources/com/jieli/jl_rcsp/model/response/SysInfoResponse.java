package com.jieli.jl_rcsp.model.response;

import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.model.device.AttrBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes10.dex */
public class SysInfoResponse extends CommonResponse {
    private List<AttrBean> attrs;
    private byte function;

    public List<AttrBean> getAttrs() {
        return this.attrs;
    }

    public byte getFunction() {
        return this.function;
    }

    public SysInfoResponse setAttrs(List<AttrBean> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.attrs = list;
        return this;
    }

    public SysInfoResponse setFunction(byte b) {
        this.function = b;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.base.CommonResponse
    public String toString() {
        return "SysInfoResponse{function=" + ((int) this.function) + ", attrs=" + this.attrs + "} " + super.toString();
    }
}
