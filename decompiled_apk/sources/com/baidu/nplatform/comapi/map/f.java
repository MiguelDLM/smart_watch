package com.baidu.nplatform.comapi.map;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.util.common.LogUtil;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes8.dex */
public class f implements GLSurfaceView.Renderer {

    /* renamed from: a, reason: collision with root package name */
    private int f9499a;
    private int b;
    private boolean c = false;
    private boolean d = true;
    private final Object e = new Object();

    public void a() {
        synchronized (this.e) {
            this.d = false;
            BNMapController.getInstance().awakeDrawWaitEvent();
        }
    }

    public void b() {
        BNMapController.getInstance().dynamicWindowShutDown(4617);
        this.c = true;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        if (this.d) {
            synchronized (this.e) {
                try {
                    if (!this.d) {
                        LogUtil.e("CommonWindowLife-Render", "dynamicWindowDraw:多线程导致 isDrawEnable == false! ");
                        return;
                    }
                    BNMapController.getInstance().dynamicWindowDraw(4617);
                    try {
                        if (com.baidu.navisdk.util.drivertool.d.d && com.baidu.navisdk.util.drivertool.d.b) {
                            com.baidu.navisdk.util.drivertool.e.l().a(this.f9499a, this.b, 2);
                        }
                        if (com.baidu.navisdk.debug.d.b()) {
                            com.baidu.navisdk.debug.d.g().a(this.f9499a, this.b, 1);
                        }
                    } catch (Exception e) {
                        com.baidu.navisdk.util.drivertool.d.a(false);
                        if (LogUtil.LOGGABLE) {
                            e.printStackTrace();
                        }
                    }
                } finally {
                }
            }
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        LogUtil.e("CommonWindowLife-Render", "surfaceChanged: --> mInit: " + this.c + ", width: " + i + ",  height: " + i2);
        if (this.c) {
            this.c = false;
            Bundle bundle = new Bundle();
            bundle.putInt("x", 0);
            bundle.putInt("y", 0);
            bundle.putInt("iWidth", i);
            bundle.putInt("iHeight", i2);
            BNMapController.getInstance().dynamicWindowInit(4617, bundle);
        } else {
            BNMapController.getInstance().dynamicWindowChange(4617, i, i2);
        }
        if (!this.c) {
            synchronized (this.e) {
                this.d = true;
            }
        }
        this.f9499a = i;
        this.b = i2;
        if (com.baidu.navisdk.util.drivertool.d.b || com.baidu.navisdk.debug.d.b()) {
            GLES20.glViewport(0, 0, i, i2);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        LogUtil.e("CommonWindowLife-Render", "CommonWindowRenderer --> onSurfaceCreated");
        this.c = true;
        Thread currentThread = Thread.currentThread();
        currentThread.setName("EnlargeGL" + currentThread.getId());
    }
}
