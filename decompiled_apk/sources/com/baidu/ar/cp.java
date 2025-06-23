package com.baidu.ar;

/* loaded from: classes7.dex */
public class cp {
    private int mErrorNum;
    private String nL;
    private cs nM;

    public void a(cs csVar) {
        this.nM = csVar;
    }

    public int cE() {
        return this.mErrorNum;
    }

    public cs cF() {
        return this.nM;
    }

    public String getMessage() {
        return this.nL;
    }

    public void r(int i) {
        this.mErrorNum = i;
    }

    public void setMessage(String str) {
        this.nL = str;
    }
}
