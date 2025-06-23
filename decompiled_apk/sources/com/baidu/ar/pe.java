package com.baidu.ar;

/* loaded from: classes7.dex */
public class pe extends pg implements pi {
    private short Jv;
    private String Jw;

    @Override // com.baidu.ar.pi
    public void a(short s) {
        this.Jv = s;
    }

    @Override // com.baidu.ar.pi
    public void cI(String str) {
        this.Jw = str;
    }

    @Override // com.baidu.ar.ph
    public String jL() {
        return this.Jw;
    }
}
