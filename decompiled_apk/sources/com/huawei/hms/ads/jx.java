package com.huawei.hms.ads;

import java.util.List;

/* loaded from: classes10.dex */
public class jx {
    private String Code;
    private Boolean I;
    private Boolean V;
    private List<String> Z;

    public jx() {
        Boolean bool = Boolean.TRUE;
        this.V = bool;
        this.I = bool;
    }

    public String Code() {
        return this.Code;
    }

    public Boolean I() {
        return this.I;
    }

    public Boolean V() {
        return this.V;
    }

    public List<String> Z() {
        return this.Z;
    }

    public void Code(Boolean bool) {
        this.V = bool;
    }

    public void V(Boolean bool) {
        this.I = bool;
    }

    public void Code(String str) {
        this.Code = str;
    }

    public void Code(List<String> list) {
        this.Z = list;
    }
}
