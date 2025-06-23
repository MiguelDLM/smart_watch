package com.baidu.ar;

import android.view.Surface;

/* loaded from: classes7.dex */
class bm {
    private DuMixOutput ay;
    private Surface iJ;
    private String kw;

    public bm(DuMixOutput duMixOutput) {
        this.ay = duMixOutput;
    }

    public void M(String str) {
        this.kw = str;
    }

    public String bQ() {
        return this.kw;
    }

    public Surface getSurface() {
        return this.iJ;
    }

    public void setSurface(Surface surface) {
        this.iJ = surface;
    }
}
