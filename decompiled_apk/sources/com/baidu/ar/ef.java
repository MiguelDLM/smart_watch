package com.baidu.ar;

/* loaded from: classes7.dex */
public class ef {
    private int mState = 0;
    private a rf;

    /* loaded from: classes7.dex */
    public interface a {
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static ef rg = new ef();
    }

    public static ef dA() {
        return b.rg;
    }

    public void release() {
        this.rf = null;
        ed.shutdown();
    }
}
