package com.baidu.nplatform.comapi.map;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.View;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes8.dex */
public class r extends BNGLTextureView implements h {
    public s r;
    private com.baidu.navisdk.util.worker.f<String, String> s;

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.f<String, String> {
        public a(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            r.this.e();
            com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) r.this.s, false);
            com.baidu.navisdk.util.worker.c.a().a(r.this.s, new com.baidu.navisdk.util.worker.e(2, 0), 1000L);
            return null;
        }
    }

    public r(Context context) {
        super(context);
        this.s = new a("miniMapRequestTask", null);
        setEGLContextFactory(new p());
        setRestartGLThreadOnAttach(false);
        setPreserveEGLContextOnPause(true);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("MapSwitchGLTextureView", "MapSwitchGLTextureView: --> create instance");
        }
        setEGLContextClientVersion(2);
        try {
            if (com.baidu.navisdk.util.common.r.a(8, 8, 8, 8, 24, 8)) {
                a(8, 8, 8, 8, 24, 8);
            } else {
                setEGLConfigChooser(true);
            }
        } catch (IllegalArgumentException unused) {
            setEGLConfigChooser(true);
        }
        j();
    }

    private void j() {
        s sVar = new s();
        this.r = sVar;
        setRenderer(sVar);
        setRenderMode(0);
    }

    @Override // com.baidu.nplatform.comapi.map.BNGLTextureView
    public void b() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("MapSwitchGLTextureView", "MapSwitchGLTextureView --> onPause");
        }
        super.b();
    }

    @Override // com.baidu.nplatform.comapi.map.BNGLTextureView
    public void c() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("MapSwitchGLTextureView", "MapSwitchGLTextureView --> onResume");
        }
        try {
            super.c();
        } catch (Exception e) {
            LogUtil.e("MapSwitchGLTextureView", "onResume error:" + e.getMessage());
        }
    }

    @Override // com.baidu.nplatform.comapi.map.BNGLTextureView
    public String getName() {
        return "MiniWin";
    }

    @Override // com.baidu.nplatform.comapi.map.BNGLTextureView, android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.navisdk.util.worker.c.a().b(this.s, new com.baidu.navisdk.util.worker.e(2, 0), 20L);
    }

    @Override // com.baidu.nplatform.comapi.map.BNGLTextureView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.s, false);
    }

    @Override // android.view.TextureView, android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.MAP;
        if (gVar.d()) {
            gVar.e("onVisibilityChanged" + i);
        }
        if (i == 0) {
            c();
        } else {
            b();
        }
    }

    @Override // com.baidu.nplatform.comapi.map.h
    public void unInit() {
        d();
        s sVar = this.r;
        if (sVar != null) {
            sVar.a();
        }
        this.r = null;
    }

    @Override // com.baidu.nplatform.comapi.map.BNGLTextureView
    public void a(SurfaceTexture surfaceTexture) {
        super.a(surfaceTexture);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("MapSwitchGLTextureView", "MapSwitchGLTextureView: --> surfaceCreated");
        }
    }

    @Override // com.baidu.nplatform.comapi.map.BNGLTextureView
    public void b(SurfaceTexture surfaceTexture) {
        super.b(surfaceTexture);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("MapSwitchGLTextureView", " MapSwitchGLTextureView --> surfaceDestroyed:" + surfaceTexture);
        }
    }

    @Override // com.baidu.nplatform.comapi.map.BNGLTextureView
    public void a(SurfaceTexture surfaceTexture, int i, int i2, int i3) {
        if (surfaceTexture == null) {
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("MapSwitchGLTextureView", "MapSwitchGLTextureView --> surfaceChanged:" + surfaceTexture);
        }
        s sVar = this.r;
        if (sVar != null) {
            sVar.a(i2, i3, 0);
        }
        super.a(surfaceTexture, i, i2, i3);
    }
}
