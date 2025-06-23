package com.baidu.ar;

/* loaded from: classes7.dex */
public class hj {
    private int gm;
    private String mErrorMessage;
    private boolean pb;
    private hi wf;

    public void E(boolean z) {
        this.pb = z;
    }

    public void a(hi hiVar) {
        this.wf = hiVar;
    }

    public void bd(String str) {
        this.mErrorMessage = str;
    }

    public String fb() {
        return this.mErrorMessage;
    }

    public hi fc() {
        return this.wf;
    }

    public int getErrorCode() {
        return this.gm;
    }

    public boolean isSuccess() {
        return this.pb;
    }
}
