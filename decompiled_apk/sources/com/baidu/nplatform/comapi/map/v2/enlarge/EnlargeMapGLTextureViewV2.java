package com.baidu.nplatform.comapi.map.v2.enlarge;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.view.View;
import com.baidu.navisdk.module.cloudconfig.f;
import com.baidu.navisdk.util.common.r;
import com.baidu.nplatform.comapi.map.d;
import com.baidu.nplatform.comapi.map.g;
import com.baidu.platform.comapi.map.GLTextureView;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class EnlargeMapGLTextureViewV2 extends GLTextureView implements g {

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    public static final String TAG = "Enlarge_textviewv2";
    private boolean mDirtyMode;
    private final Handler mHandler;

    @oOoXoXO
    private EnlargeMapRenderer mRenderer;

    @OOXIXo
    private final Runnable mRequestRunnable;
    private g.a mSurfaceDetachListener;

    /* loaded from: classes8.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }
    }

    public EnlargeMapGLTextureViewV2(@oOoXoXO Context context) {
        super(context);
        this.mHandler = d.d().a();
        this.mRequestRunnable = new Runnable() { // from class: com.baidu.nplatform.comapi.map.v2.enlarge.EnlargeMapGLTextureViewV2$mRequestRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                Handler handler;
                Handler handler2;
                z = EnlargeMapGLTextureViewV2.this.mDirtyMode;
                if (z) {
                    EnlargeMapGLTextureViewV2.this.requestRender();
                    handler = EnlargeMapGLTextureViewV2.this.mHandler;
                    handler.removeCallbacks(this);
                    handler2 = EnlargeMapGLTextureViewV2.this.mHandler;
                    handler2.postDelayed(this, (long) (1000.0d / f.c().c.m0));
                }
            }
        };
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.MAP;
        if (gVar.d()) {
            gVar.e(TAG, "Constructor: --> ");
        }
        setEGLContextClientVersion(2);
        try {
            if (f.c().q.g && r.a(8, 8, 8, 8, 24, 0, 1, 4)) {
                setEGLConfigChooser(8, 8, 8, 8, 24, 0, 4);
            } else if (r.a(8, 8, 8, 8, 24, 0)) {
                setEGLConfigChooser(8, 8, 8, 8, 24, 0);
            } else {
                setEGLConfigChooser(true);
            }
        } catch (IllegalArgumentException unused) {
            setEGLConfigChooser(true);
        }
        initRender();
    }

    private final void initRender() {
        EnlargeMapRenderer enlargeMapRenderer = new EnlargeMapRenderer();
        this.mRenderer = enlargeMapRenderer;
        setRenderer(enlargeMapRenderer);
        this.mDirtyMode = f.c().c.l0;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.MAP;
        if (gVar.d()) {
            gVar.e(TAG, "dirtyMode: --> " + this.mDirtyMode);
        }
        setRenderMode(!this.mDirtyMode ? 1 : 0);
    }

    @Override // com.baidu.nplatform.comapi.map.g
    public void awakeDrawWaitEvent() {
        EnlargeMapRenderer enlargeMapRenderer = this.mRenderer;
        if (enlargeMapRenderer != null) {
            enlargeMapRenderer.awakeDrawWaitEvent();
        }
    }

    @oOoXoXO
    public final EnlargeMapRenderer getMRenderer() {
        return this.mRenderer;
    }

    @OOXIXo
    public final Runnable getMRequestRunnable() {
        return this.mRequestRunnable;
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView, android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.MAP;
        if (gVar.d()) {
            gVar.e(TAG, "onAttachedToWindow: --> ");
        }
        if (this.mDirtyMode) {
            this.mHandler.removeCallbacks(this.mRequestRunnable);
            this.mHandler.post(this.mRequestRunnable);
        }
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView, android.view.View
    public void onDetachedFromWindow() {
        awakeDrawWaitEvent();
        super.onDetachedFromWindow();
        if (this.mDirtyMode) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.nplatform.comapi.map.v2.enlarge.EnlargeMapGLTextureViewV2$onDetachedFromWindow$1
                @Override // java.lang.Runnable
                public final void run() {
                    Handler handler;
                    handler = EnlargeMapGLTextureViewV2.this.mHandler;
                    handler.removeCallbacks(EnlargeMapGLTextureViewV2.this.getMRequestRunnable());
                }
            });
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.MAP;
        if (gVar.d()) {
            gVar.e(TAG, "onDetachedFromWindow: --> ");
        }
        g.a aVar = this.mSurfaceDetachListener;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView
    public void onPause() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.MAP;
        if (gVar.d()) {
            gVar.e(TAG, "onPause: --> ");
        }
        awakeDrawWaitEvent();
        super.onPause();
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView
    public void onResume() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.MAP;
        if (gVar.d()) {
            gVar.e(TAG, "onResume: --> ");
        }
        awakeDrawWaitEvent();
        super.onResume();
    }

    @Override // android.view.TextureView, android.view.View
    public void onVisibilityChanged(@OOXIXo View view, int i) {
        super.onVisibilityChanged(view, i);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.MAP;
        if (gVar.d()) {
            gVar.e(TAG, "onVisibilityChanged" + i);
        }
        if (i == 0) {
            onResume();
        } else {
            onPause();
        }
    }

    @Override // com.baidu.nplatform.comapi.map.g
    public void setDetachWindowListener(@OOXIXo g.a aVar) {
        this.mSurfaceDetachListener = aVar;
    }

    public final void setMRenderer(@oOoXoXO EnlargeMapRenderer enlargeMapRenderer) {
        this.mRenderer = enlargeMapRenderer;
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView
    public void surfaceChanged(@OOXIXo SurfaceTexture surfaceTexture, int i, int i2, int i3) {
        awakeDrawWaitEvent();
        super.surfaceChanged(surfaceTexture, i, i2, i3);
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView
    public void surfaceDestroyed(@OOXIXo SurfaceTexture surfaceTexture) {
        super.surfaceDestroyed(surfaceTexture);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.MAP;
        if (gVar.d()) {
            gVar.e(TAG, "surfaceDestroyed: --> ");
        }
        EnlargeMapRenderer enlargeMapRenderer = this.mRenderer;
        if (enlargeMapRenderer != null) {
            enlargeMapRenderer.dynamicWindowShutDown();
        }
    }
}
