package com.baidu.xclient.gdid.e;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes8.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public EGL10 f10233a;
    public EGLDisplay b;
    public EGLConfig c;
    public EGLSurface d;
    public EGLContext e;
    public GL10 f;
    public Object h;
    public int g = 1;
    public int i = 8;
    public int j = 8;
    public int k = 8;
    public int l = 8;
    public int m = 16;
    public int n = 4;
    public EGLContext o = EGL10.EGL_NO_CONTEXT;

    public final EGLSurface a(int[] iArr) {
        int i = this.g;
        return i != 2 ? i != 3 ? this.f10233a.eglCreatePbufferSurface(this.b, this.c, iArr) : this.f10233a.eglCreateWindowSurface(this.b, this.c, this.h, iArr) : this.f10233a.eglCreatePixmapSurface(this.b, this.c, this.h, iArr);
    }

    public void b() {
        EGL10 egl10 = this.f10233a;
        EGLDisplay eGLDisplay = this.b;
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        this.f10233a.eglDestroySurface(this.b, this.d);
        this.f10233a.eglDestroyContext(this.b, this.e);
        this.f10233a.eglTerminate(this.b);
    }

    public void a() {
        EGL10 egl10 = this.f10233a;
        EGLDisplay eGLDisplay = this.b;
        EGLSurface eGLSurface = this.d;
        egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.e);
        this.f = (GL10) this.e.getGL();
    }

    public boolean a(int i, int i2) {
        int[] iArr = {12324, this.i, 12323, this.j, 12322, this.k, 12321, this.l, 12325, this.m, 12352, this.n, 12344};
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.f10233a = egl10;
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.b = eglGetDisplay;
        this.f10233a.eglInitialize(eglGetDisplay, new int[2]);
        int[] iArr2 = new int[1];
        this.f10233a.eglChooseConfig(this.b, iArr, null, 0, iArr2);
        int i3 = iArr2[0];
        if (i3 == 0) {
            return false;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[i3];
        this.f10233a.eglChooseConfig(this.b, iArr, eGLConfigArr, i3, iArr2);
        this.c = eGLConfigArr[0];
        this.d = a(new int[]{12375, i, 12374, i2, 12344});
        this.e = this.f10233a.eglCreateContext(this.b, this.c, this.o, new int[]{12440, 2, 12344});
        a();
        return true;
    }
}
