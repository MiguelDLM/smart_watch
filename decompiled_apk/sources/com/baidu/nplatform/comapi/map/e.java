package com.baidu.nplatform.comapi.map;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.SurfaceHolder;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.map.g;

/* loaded from: classes8.dex */
public class e extends GLSurfaceView implements g {

    /* renamed from: a, reason: collision with root package name */
    public f f9498a;
    private g.a b;

    public e(Context context) {
        super(context);
        LogUtil.e("CommonWindowLife-SurfaceView", "Constructor: --> ");
        setEGLContextClientVersion(2);
        getHolder().setFormat(-2);
        setZOrderOnTop(true);
        setZOrderMediaOverlay(true);
        try {
            if (com.baidu.navisdk.util.common.r.a(8, 8, 8, 8, 24, 0)) {
                setEGLConfigChooser(8, 8, 8, 8, 24, 0);
            } else {
                setEGLConfigChooser(true);
            }
        } catch (IllegalArgumentException unused) {
            setEGLConfigChooser(true);
        }
        a();
    }

    public void a() {
        f fVar = new f();
        this.f9498a = fVar;
        setRenderer(fVar);
        setRenderMode(1);
    }

    @Override // com.baidu.nplatform.comapi.map.g
    public void awakeDrawWaitEvent() {
        f fVar = this.f9498a;
        if (fVar != null) {
            fVar.a();
        }
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        LogUtil.e("CommonWindowLife-SurfaceView", "onAttachedToWindow:  --> ");
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        awakeDrawWaitEvent();
        super.onDetachedFromWindow();
        LogUtil.e("CommonWindowLife-SurfaceView", "onDetachedFromWindow:  --> ");
        g.a aVar = this.b;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        LogUtil.e("CommonWindowLife-SurfaceView", "onPause:  --> ");
        super.onPause();
        awakeDrawWaitEvent();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        LogUtil.e("CommonWindowLife-SurfaceView", "onResume:  --> ");
        super.onResume();
        awakeDrawWaitEvent();
    }

    @Override // com.baidu.nplatform.comapi.map.g
    public void setDetachWindowListener(g.a aVar) {
        this.b = aVar;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        LogUtil.e("CommonWindowLife-SurfaceView", "surfaceChanged:  --> ");
        super.surfaceChanged(surfaceHolder, i, i2, i3);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        super.surfaceCreated(surfaceHolder);
        LogUtil.e("CommonWindowLife-SurfaceView", "surfaceCreated:  --> ");
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        LogUtil.e("CommonWindowLife-SurfaceView", "surfaceDestroyed:  --> ");
        super.surfaceDestroyed(surfaceHolder);
        f fVar = this.f9498a;
        if (fVar != null) {
            fVar.b();
        }
    }
}
