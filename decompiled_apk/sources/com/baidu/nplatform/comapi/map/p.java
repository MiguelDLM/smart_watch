package com.baidu.nplatform.comapi.map;

import android.opengl.GLSurfaceView;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.util.common.LogUtil;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.jieli.jl_bt_ota.constant.ErrorCode;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* loaded from: classes8.dex */
public class p implements GLSurfaceView.EGLContextFactory {
    private void a() {
        BNMapController.getInstance().ResetGLHandleWhenCreateOrDestroyContext(true);
    }

    public void b(String str, int i) {
        throw new RuntimeException(a(str, i));
    }

    @Override // android.opengl.GLSurfaceView.EGLContextFactory
    public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
    }

    @Override // android.opengl.GLSurfaceView.EGLContextFactory
    public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
        if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("MapContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
            }
            b("eglDestroyContex", egl10.eglGetError());
            throw null;
        }
        a();
    }

    public String a(String str, int i) {
        return str + " failed: " + a(i);
    }

    private String a(int i) {
        switch (i) {
            case 12288:
                return "EGL_SUCCESS";
            case 12289:
                return "EGL_NOT_INITIALIZED";
            case 12290:
                return "EGL_BAD_ACCESS";
            case 12291:
                return "EGL_BAD_ALLOC";
            case 12292:
                return "EGL_BAD_ATTRIBUTE";
            case 12293:
                return "EGL_BAD_CONFIG";
            case 12294:
                return "EGL_BAD_CONTEXT";
            case ErrorCode.SUB_ERR_SEND_TIMEOUT /* 12295 */:
                return "EGL_BAD_CURRENT_SURFACE";
            case ErrorCode.SUB_ERR_RESPONSE_BAD_STATUS /* 12296 */:
                return "EGL_BAD_DISPLAY";
            case 12297:
                return "EGL_BAD_MATCH";
            case ErrorCode.SUB_ERR_RESPONSE_BAD_RESULT /* 12298 */:
                return "EGL_BAD_NATIVE_PIXMAP";
            case ErrorCode.SUB_ERR_WAITING_COMMAND_TIMEOUT /* 12299 */:
                return "EGL_BAD_NATIVE_WINDOW";
            case 12300:
                return "EGL_BAD_PARAMETER";
            case 12301:
                return "EGL_BAD_SURFACE";
            case 12302:
                return "EGL_CONTEXT_LOST";
            default:
                return b(i);
        }
    }

    private String b(int i) {
        return HexStringBuilder.DEFAULT_PREFIX + Integer.toHexString(i);
    }
}
