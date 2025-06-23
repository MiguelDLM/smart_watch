package com.baidu.ar;

/* loaded from: classes7.dex */
public class hd {
    private long mTimestamp;
    private boolean vU;
    private String vV;
    private boolean vW;
    private long vX;

    public hd(long j) {
        this.mTimestamp = j;
    }

    public void C(boolean z) {
        this.vU = z;
    }

    public void D(boolean z) {
        this.vW = z;
    }

    public void f(long j) {
        this.vX = j;
    }

    public String getFileName() {
        return this.vV;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public void setFileName(String str) {
        this.vV = str;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }
}
