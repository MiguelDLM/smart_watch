package com.baidu.navisdk.module.ar.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* loaded from: classes7.dex */
public class c extends BNGLTextureView {
    public d o;

    public c(Context context, com.baidu.navisdk.module.ar.jni.a aVar) {
        super(context);
        setEGLContextClientVersion(2);
        try {
            if (d()) {
                a(8, 8, 8, 8, 24, 0);
            } else if (c()) {
                a(8, 8, 8, 8, 16, 0);
            } else {
                setEGLConfigChooser(true);
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            setEGLConfigChooser(true);
        }
        d dVar = new d(new WeakReference(this), aVar);
        this.o = dVar;
        setRenderer(dVar);
        setRenderMode(1);
    }

    private boolean c() {
        return b(8, 8, 8, 8, 16, 0);
    }

    private boolean d() {
        return b(8, 8, 8, 8, 24, 0);
    }

    @Override // com.baidu.navisdk.module.ar.view.BNGLTextureView
    public void a(SurfaceTexture surfaceTexture) {
        super.a(surfaceTexture);
    }

    @Override // com.baidu.navisdk.module.ar.view.BNGLTextureView
    public void b(SurfaceTexture surfaceTexture) {
        super.b(surfaceTexture);
    }

    private boolean b(int i, int i2, int i3, int i4, int i5, int i6) {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        egl10.eglInitialize(eglGetDisplay, new int[2]);
        int[] iArr = new int[1];
        egl10.eglGetConfigs(eglGetDisplay, null, 0, iArr);
        int i7 = iArr[0];
        if (i7 <= 0) {
            return false;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[i7];
        int[] iArr2 = new int[1];
        egl10.eglGetConfigs(eglGetDisplay, eGLConfigArr, i7, iArr);
        int i8 = 0;
        while (i8 < i7) {
            EGLConfig eGLConfig = eGLConfigArr[i8];
            if (eGLConfig != null) {
                egl10.eglGetConfigAttrib(eglGetDisplay, eGLConfig, 12324, iArr2);
                if (iArr2[0] == i) {
                    egl10.eglGetConfigAttrib(eglGetDisplay, eGLConfigArr[i8], 12323, iArr2);
                    if (iArr2[0] == i2) {
                        egl10.eglGetConfigAttrib(eglGetDisplay, eGLConfigArr[i8], 12322, iArr2);
                        if (iArr2[0] == i3) {
                            if (i4 > 0) {
                                egl10.eglGetConfigAttrib(eglGetDisplay, eGLConfigArr[i8], 12321, iArr2);
                                if (iArr2[0] != i4) {
                                    continue;
                                }
                            }
                            if (i5 > 0) {
                                egl10.eglGetConfigAttrib(eglGetDisplay, eGLConfigArr[i8], 12325, iArr2);
                                if (iArr2[0] != i5) {
                                    continue;
                                }
                            }
                            if (i6 <= 0) {
                                break;
                            }
                            egl10.eglGetConfigAttrib(eglGetDisplay, eGLConfigArr[i8], 12326, iArr2);
                            if (iArr2[0] == i6) {
                                break;
                            }
                        } else {
                            continue;
                        }
                        i8++;
                    }
                    i8++;
                }
            }
            i8++;
        }
        return i8 != i7 && egl10.eglChooseConfig(eglGetDisplay, new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344}, null, 0, iArr) && iArr[0] > 0;
    }

    @Override // com.baidu.navisdk.module.ar.view.BNGLTextureView
    public void a(SurfaceTexture surfaceTexture, int i, int i2, int i3) {
        super.a(surfaceTexture, i, i2, i3);
    }
}
