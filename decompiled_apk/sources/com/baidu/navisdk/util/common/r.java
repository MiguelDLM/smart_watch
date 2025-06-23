package com.baidu.navisdk.util.common;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* loaded from: classes8.dex */
public class r {
    public static boolean a(int i, int i2, int i3, int i4, int i5, int i6) {
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

    public static boolean a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        egl10.eglInitialize(eglGetDisplay, new int[2]);
        int[] iArr = new int[1];
        egl10.eglGetConfigs(eglGetDisplay, null, 0, iArr);
        int i9 = iArr[0];
        if (i9 <= 0) {
            return false;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[i9];
        int[] iArr2 = new int[1];
        egl10.eglGetConfigs(eglGetDisplay, eGLConfigArr, i9, iArr);
        int i10 = 0;
        while (i10 < i9) {
            EGLConfig eGLConfig = eGLConfigArr[i10];
            if (eGLConfig != null) {
                egl10.eglGetConfigAttrib(eglGetDisplay, eGLConfig, 12324, iArr2);
                if (iArr2[0] != i) {
                    continue;
                } else {
                    egl10.eglGetConfigAttrib(eglGetDisplay, eGLConfigArr[i10], 12323, iArr2);
                    if (iArr2[0] != i2) {
                        continue;
                    } else {
                        egl10.eglGetConfigAttrib(eglGetDisplay, eGLConfigArr[i10], 12322, iArr2);
                        if (iArr2[0] == i3) {
                            if (i4 > 0) {
                                egl10.eglGetConfigAttrib(eglGetDisplay, eGLConfigArr[i10], 12321, iArr2);
                                if (iArr2[0] != i4) {
                                    continue;
                                }
                            }
                            if (i5 > 0) {
                                egl10.eglGetConfigAttrib(eglGetDisplay, eGLConfigArr[i10], 12325, iArr2);
                                if (iArr2[0] != i5) {
                                    continue;
                                }
                            }
                            if (i6 > 0) {
                                egl10.eglGetConfigAttrib(eglGetDisplay, eGLConfigArr[i10], 12326, iArr2);
                                if (iArr2[0] != i6) {
                                    continue;
                                }
                            }
                            if (i7 > 0) {
                                egl10.eglGetConfigAttrib(eglGetDisplay, eGLConfigArr[i10], 12338, iArr2);
                                if (iArr2[0] != i7) {
                                    continue;
                                }
                            }
                            if (i8 <= 0) {
                                break;
                            }
                            egl10.eglGetConfigAttrib(eglGetDisplay, eGLConfigArr[i10], 12337, iArr2);
                            if (iArr2[0] == i8) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            i10++;
        }
        return i10 != i9 && egl10.eglChooseConfig(eglGetDisplay, new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12338, i7, 12337, i8, 12344}, null, 0, iArr) && iArr[0] > 0;
    }
}
