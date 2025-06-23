package com.baidu.nplatform.comapi.map;

import android.content.Context;
import android.view.SurfaceHolder;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes8.dex */
public class q extends BaiduGLSurfaceView implements h {
    public s o;
    private com.baidu.navisdk.util.worker.f<String, String> p;

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.f<String, String> {
        public a(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            q.this.b();
            com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) q.this.p, false);
            com.baidu.navisdk.util.worker.c.a().a(q.this.p, new com.baidu.navisdk.util.worker.e(2, 0), 1000L);
            return null;
        }
    }

    public q(Context context) {
        super(context);
        this.p = new a("miniMapRequestTask", null);
        setEGLContextFactory(new p());
        setRestartGLThreadOnAttach(false);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("MapSwitchGLSurfaceView", "MapSwitchGLSurfaceView: --> create instance");
        }
        setEGLContextClientVersion(2);
        setZOrderMediaOverlay(true);
        try {
            if (com.baidu.navisdk.util.common.r.a(8, 8, 8, 8, 24, 8)) {
                a(8, 8, 8, 8, 24, 8);
            } else {
                setEGLConfigChooser(true);
            }
        } catch (IllegalArgumentException unused) {
            setEGLConfigChooser(true);
        }
        getHolder().setFormat(-3);
        e();
    }

    private void e() {
        s sVar = new s();
        this.o = sVar;
        setRenderer(sVar);
        setRenderMode(0);
    }

    @Override // com.baidu.nplatform.comapi.map.BaiduGLSurfaceView, android.view.SurfaceView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.navisdk.util.worker.c.a().b(this.p, new com.baidu.navisdk.util.worker.e(2, 0), 20L);
    }

    @Override // com.baidu.nplatform.comapi.map.BaiduGLSurfaceView, android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.p, false);
    }

    @Override // com.baidu.nplatform.comapi.map.BaiduGLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("MapSwitchGLSurfaceView", "MapSwitchGLSurfaceView --> surfaceChanged");
        }
        s sVar = this.o;
        if (sVar != null) {
            sVar.a(i2, i3, 0);
        }
        super.surfaceChanged(surfaceHolder, i, i2, i3);
    }

    @Override // com.baidu.nplatform.comapi.map.BaiduGLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        super.surfaceCreated(surfaceHolder);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("MapSwitchGLSurfaceView", "MapSwitchGLSurfaceView: --> surfaceCreated");
        }
    }

    @Override // com.baidu.nplatform.comapi.map.BaiduGLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        super.surfaceDestroyed(surfaceHolder);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("MapSwitchGLSurfaceView", " BaiduGLSurfaceView --> surfaceDestroyed");
        }
    }

    @Override // com.baidu.nplatform.comapi.map.h
    public void unInit() {
        a();
        s sVar = this.o;
        if (sVar != null) {
            sVar.a();
        }
        this.o = null;
    }
}
