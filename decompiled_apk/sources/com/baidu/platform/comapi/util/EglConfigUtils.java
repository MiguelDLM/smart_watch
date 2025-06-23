package com.baidu.platform.comapi.util;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* loaded from: classes8.dex */
public class EglConfigUtils {
    public static boolean isSupport24DepthSize() {
        try {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            egl10.eglInitialize(eglGetDisplay, new int[2]);
            EGLConfig[] eGLConfigArr = new EGLConfig[100];
            egl10.eglGetConfigs(eglGetDisplay, eGLConfigArr, 100, new int[100]);
            for (int i = 0; i < 100; i++) {
                int[] iArr = new int[1];
                EGLConfig eGLConfig = eGLConfigArr[i];
                if (eGLConfig == null) {
                    break;
                }
                egl10.eglGetConfigAttrib(eglGetDisplay, eGLConfig, 12324, iArr);
                int i2 = iArr[0];
                egl10.eglGetConfigAttrib(eglGetDisplay, eGLConfigArr[i], 12323, iArr);
                int i3 = iArr[0];
                egl10.eglGetConfigAttrib(eglGetDisplay, eGLConfigArr[i], 12322, iArr);
                int i4 = iArr[0];
                egl10.eglGetConfigAttrib(eglGetDisplay, eGLConfigArr[i], 12325, iArr);
                int[] iArr2 = {i2, i3, i4, iArr[0]};
                int i5 = iArr2[0];
                if ((i5 == 5 && iArr2[1] == 6 && iArr2[2] == 5 && iArr2[3] == 24) || (i5 == 8 && iArr2[1] == 8 && iArr2[2] == 8 && iArr2[3] == 24)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean isSupportConfig(int i, int i2, int i3, int i4, int i5, int i6) {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        egl10.eglInitialize(eglGetDisplay, new int[2]);
        int[] iArr = new int[1];
        if (egl10.eglChooseConfig(eglGetDisplay, new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344}, new EGLConfig[100], 100, iArr) && iArr[0] > 0) {
            return true;
        }
        return false;
    }
}
