package com.baidu.platform.comapi.map;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.platform.comapi.map.ah;

/* loaded from: classes8.dex */
class ai extends SurfaceView implements SurfaceHolder.Callback2 {
    protected ag k;

    public ai(Context context) {
        super(context);
        a(context, ah.a.OPENGL_ES, true);
    }

    public void a(Context context, ah.a aVar, boolean z) {
        if (this.k != null) {
            return;
        }
        this.k = a(aVar, z, context);
        getHolder().addCallback(this);
    }

    public Bitmap captureImageFromSurface(int i, int i2, int i3, int i4, Object obj, Bitmap.Config config) {
        return this.k.a(i, i2, i3, i4, obj, config);
    }

    public int getDebugFlags() {
        return this.k.f();
    }

    public ag getRenderControl() {
        return this.k;
    }

    public int getRenderMode() {
        return this.k.g();
    }

    public ah.a getViewType() {
        ag agVar = this.k;
        if (agVar != null) {
            return agVar.b();
        }
        return ah.a.AUTO;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.k.k();
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        this.k.l();
        super.onDetachedFromWindow();
    }

    public void onPause() {
        this.k.i();
    }

    public void onResume() {
        this.k.j();
    }

    public void queueEvent(Runnable runnable) {
        this.k.a(runnable);
    }

    public void requestRender() {
        this.k.h();
    }

    public void setDebugFlags(int i) {
        this.k.b(i);
    }

    public void setRenderMode(int i) {
        this.k.d(i);
    }

    public void setRenderer(SurfaceRenderer surfaceRenderer) {
        this.k.a(surfaceRenderer);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.k.surfaceChanged(surfaceHolder, i, i2, i3);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.k.surfaceCreated(surfaceHolder);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.k.surfaceDestroyed(surfaceHolder);
    }

    @Deprecated
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
    }

    @TargetApi(26)
    public void surfaceRedrawNeededAsync(SurfaceHolder surfaceHolder, Runnable runnable) {
        this.k.surfaceRedrawNeededAsync(surfaceHolder, runnable);
    }

    public ai(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, ah.a.OPENGL_ES, true);
    }

    public ai(Context context, ah.a aVar) {
        super(context);
        a(context, aVar, true);
    }

    public ag a(ah.a aVar, boolean z, Context context) {
        return ah.a(this, aVar, z, context);
    }

    public ai(Context context, ah.a aVar, boolean z) {
        super(context);
        a(context, aVar, z);
    }

    public ai(Context context, boolean z) {
        super(context);
        a(context, ah.a.OPENGL_ES, z);
    }
}
