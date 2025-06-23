package com.huawei.hms.ads;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.view.Surface;

/* loaded from: classes10.dex */
public class dw {
    private final dv Code;
    private EGLSurface V;

    public dw(dv dvVar, Surface surface) {
        this.Code = dvVar;
        this.V = dvVar.Code(surface);
    }

    public void B() {
        this.Code.Code(this.V);
        this.V = EGL14.EGL_NO_SURFACE;
    }

    public int Code() {
        return this.Code.Code(this.V, 12375);
    }

    public void I() {
        this.Code.V(this.V);
    }

    public int V() {
        return this.Code.Code(this.V, 12374);
    }

    public void Z() {
        this.Code.I(this.V);
    }
}
