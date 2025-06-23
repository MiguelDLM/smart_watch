package com.baidu.nplatform.comapi.map;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.jni.nativeif.JNIBaseMap;
import com.baidu.navisdk.util.common.LogUtil;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes8.dex */
public class s implements GLSurfaceView.Renderer {
    private static final String d = "s";

    /* renamed from: a, reason: collision with root package name */
    private boolean f9523a;
    private int b = 0;
    private int c = 0;

    public void a(int i, int i2, int i3) {
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(d, "onDrawFrame--->");
        }
        if (this.f9523a) {
            JNIBaseMap.GLDrawMinimap();
        }
        try {
            if (com.baidu.navisdk.util.drivertool.d.e && com.baidu.navisdk.util.drivertool.d.b) {
                com.baidu.navisdk.util.drivertool.e.l().a(this.b, this.c, 3);
            }
            if (com.baidu.navisdk.debug.d.c()) {
                com.baidu.navisdk.debug.d.g().a(this.b, this.c, 2);
            }
        } catch (Exception e) {
            com.baidu.navisdk.util.drivertool.d.a(false);
            e.printStackTrace();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(d, "MapSwitchRenderer(BaiduGLSurfaceView) --> onSurfaceChanged width = " + i + ", height = " + i2);
        }
        this.b = i;
        this.c = i2;
        if (this.f9523a) {
            BNMapController.getInstance().SetMinimapWinSize(i, i2);
        }
        if (com.baidu.navisdk.util.drivertool.d.b || com.baidu.navisdk.debug.d.c()) {
            GLES20.glViewport(0, 0, i, i2);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(d, "MapSwitchRenderer(BaiduGLSurfaceView) --> onSurfaceCreated");
        }
        Thread currentThread = Thread.currentThread();
        currentThread.setName("MiniWinGL" + currentThread.getId());
        if (!this.f9523a) {
            BNMapController.getInstance().createMiniMapControl();
            BNMapController.getInstance().initMiniRenderEngine(0, this.b, this.c);
            this.f9523a = true;
            return;
        }
        BNMapController.getInstance().initMiniRenderEngine(0, this.b, this.c);
    }

    public void a() {
        if (this.f9523a) {
            BNMapController.getInstance().destroyMiniMapControl();
            this.f9523a = false;
        }
    }
}
