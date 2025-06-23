package com.baidu.ar;

/* loaded from: classes7.dex */
public class pd extends pg implements pb {
    private String Ij = "*";

    @Override // com.baidu.ar.pb
    public void cH(String str) {
        if (str == null) {
            throw new IllegalArgumentException("http resource descriptor must not be null");
        }
        this.Ij = str;
    }

    @Override // com.baidu.ar.pa
    public String jK() {
        return this.Ij;
    }
}
