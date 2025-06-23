package com.baidu.nplatform.comapi.map;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.view.View;
import com.baidu.nplatform.comapi.map.g;

/* loaded from: classes8.dex */
public class c extends BNGLTextureView implements g {
    private String r;
    public f s;
    private g.a t;
    private final Handler u;
    private boolean v;
    public final Runnable w;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.v) {
                c.this.e();
                c.this.u.removeCallbacks(c.this.w);
                c.this.u.postDelayed(c.this.w, (long) (1000.0d / com.baidu.navisdk.module.cloudconfig.f.c().c.m0));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.u.removeCallbacks(c.this.w);
        }
    }

    public c(Context context) {
        super(context);
        this.r = "CommonWindowLife-TextureView";
        this.u = d.d().a();
        this.w = new a();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.MAP;
        if (gVar.d()) {
            gVar.e(this.r, "Constructor: --> ");
        }
        setEGLContextClientVersion(2);
        try {
            if (com.baidu.navisdk.module.cloudconfig.f.c().q.g && com.baidu.navisdk.util.common.r.a(8, 8, 8, 8, 24, 0, 1, 4)) {
                a(8, 8, 8, 8, 24, 0, 1, 4);
            } else if (com.baidu.navisdk.util.common.r.a(8, 8, 8, 8, 24, 0)) {
                a(8, 8, 8, 8, 24, 0);
            } else {
                setEGLConfigChooser(true);
            }
        } catch (IllegalArgumentException unused) {
            setEGLConfigChooser(true);
        }
        j();
    }

    private void j() {
        f fVar = new f();
        this.s = fVar;
        setRenderer(fVar);
        this.v = com.baidu.navisdk.module.cloudconfig.f.c().c.l0;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.MAP;
        if (gVar.d()) {
            gVar.e(this.r, "dirtyMode: --> " + this.v);
        }
        if (this.v) {
            setRenderMode(0);
        } else {
            setRenderMode(1);
        }
    }

    @Override // com.baidu.nplatform.comapi.map.g
    public void awakeDrawWaitEvent() {
        f fVar = this.s;
        if (fVar != null) {
            fVar.a();
        }
    }

    @Override // com.baidu.nplatform.comapi.map.BNGLTextureView
    public void c() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.MAP;
        if (gVar.d()) {
            gVar.e(this.r, "onResume: --> ");
        }
        awakeDrawWaitEvent();
        super.c();
    }

    @Override // com.baidu.nplatform.comapi.map.BNGLTextureView
    public String getName() {
        return "Enlarge";
    }

    @Override // com.baidu.nplatform.comapi.map.BNGLTextureView, android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.MAP;
        if (gVar.d()) {
            gVar.e(this.r, "onAttachedToWindow: --> ");
        }
        if (this.v) {
            this.u.removeCallbacks(this.w);
            this.u.post(this.w);
        }
    }

    @Override // com.baidu.nplatform.comapi.map.BNGLTextureView, android.view.View
    public void onDetachedFromWindow() {
        awakeDrawWaitEvent();
        super.onDetachedFromWindow();
        if (this.v) {
            this.u.post(new b());
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.MAP;
        if (gVar.d()) {
            gVar.e(this.r, "onDetachedFromWindow: --> ");
        }
        g.a aVar = this.t;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Override // android.view.TextureView, android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.MAP;
        if (gVar.d()) {
            gVar.e(this.r, "onVisibilityChanged" + i);
        }
        if (i == 0) {
            c();
        } else {
            b();
        }
    }

    @Override // com.baidu.nplatform.comapi.map.g
    public void setDetachWindowListener(g.a aVar) {
        this.t = aVar;
    }

    @Override // com.baidu.nplatform.comapi.map.BNGLTextureView
    public void a(SurfaceTexture surfaceTexture, int i, int i2, int i3) {
        awakeDrawWaitEvent();
        super.a(surfaceTexture, i, i2, i3);
    }

    @Override // com.baidu.nplatform.comapi.map.BNGLTextureView
    public void b(SurfaceTexture surfaceTexture) {
        super.b(surfaceTexture);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.MAP;
        if (gVar.d()) {
            gVar.e(this.r, "surfaceDestroyed: --> ");
        }
        f fVar = this.s;
        if (fVar != null) {
            fVar.b();
        }
    }

    @Override // com.baidu.nplatform.comapi.map.BNGLTextureView
    public boolean a() {
        return com.baidu.navisdk.util.common.g.MAP.d();
    }

    @Override // com.baidu.nplatform.comapi.map.BNGLTextureView
    public void b() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.MAP;
        if (gVar.d()) {
            gVar.e(this.r, "onPause: --> ");
        }
        awakeDrawWaitEvent();
        super.b();
    }
}
