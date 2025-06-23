package com.baidu.navisdk.module.ar.view;

import android.opengl.GLSurfaceView;
import android.os.SystemClock;
import android.view.View;
import com.baidu.navisdk.util.common.ScreenUtil;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes7.dex */
public class d implements GLSurfaceView.Renderer {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.module.ar.jni.a f7023a;
    private float d;
    private int b = ScreenUtil.DEFAULT_WIDTH;
    private int c = ScreenUtil.DEFAULT_HEIGHT;
    private Object e = new Object();

    public d(WeakReference<View> weakReference, com.baidu.navisdk.module.ar.jni.a aVar) {
        this.f7023a = aVar;
        this.d = weakReference.get().getResources().getDisplayMetrics().density;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f7023a.a();
        long elapsedRealtime2 = 60 - (SystemClock.elapsedRealtime() - elapsedRealtime);
        if (elapsedRealtime2 > 0) {
            synchronized (this.e) {
                try {
                    this.e.wait(elapsedRealtime2);
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        this.b = i;
        this.c = i2;
        this.f7023a.a(i, i2);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Thread currentThread = Thread.currentThread();
        currentThread.setName("BNArRenderer " + currentThread.getId());
        this.f7023a.a(this.b, this.c, this.d);
    }
}
