package com.baidu.ar;

/* loaded from: classes7.dex */
public class jt {
    private String AI;
    private int cj;
    private int ck;
    private int mCacheSize = 5;
    private int vZ;
    private int wa;

    public void H(int i) {
        this.vZ = i;
    }

    public void I(int i) {
        this.wa = i;
    }

    public void bT(String str) {
        this.AI = str;
    }

    public int gA() {
        return this.wa;
    }

    public int getCacheSize() {
        return this.mCacheSize;
    }

    public int getTargetHeight() {
        return this.ck;
    }

    public int getTargetWidth() {
        return this.cj;
    }

    public String gp() {
        return this.AI;
    }

    public int gz() {
        return this.vZ;
    }

    public void setTargetHeight(int i) {
        this.ck = i;
    }

    public void setTargetWidth(int i) {
        this.cj = i;
    }
}
