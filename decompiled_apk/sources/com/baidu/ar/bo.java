package com.baidu.ar;

import android.os.Looper;

/* loaded from: classes7.dex */
public class bo {
    private cd kB;
    private bn kC;

    /* loaded from: classes7.dex */
    public static class a {
        private static bo kD = new bo();
    }

    private bo() {
        this.kB = new cd();
        this.kC = new bn();
    }

    public static bo bR() {
        return a.kD;
    }

    public void a(Looper looper) {
        this.kB.b(looper);
    }
}
