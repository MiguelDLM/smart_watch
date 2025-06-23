package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.AttributeSet;
import android.view.Surface;
import com.huawei.hms.ads.dw;
import com.huawei.hms.ads.dx;
import com.huawei.hms.ads.dy;
import com.huawei.hms.ads.dz;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.kv;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.bf;
import com.huawei.openalliance.ad.views.BaseVideoView;

/* loaded from: classes10.dex */
public abstract class BaseGlVideoView extends BaseVideoView implements kv {
    protected int B;
    protected int C;
    protected final dy Code;
    protected Integer D;
    protected Integer F;
    protected dz I;
    protected volatile Float L;
    protected d S;
    protected dw V;

    /* renamed from: a, reason: collision with root package name */
    protected volatile boolean f17415a;
    private final dx q;
    private float[] r;
    private volatile boolean s;

    public BaseGlVideoView(Context context) {
        super(context);
        dx dxVar = new dx();
        this.q = dxVar;
        this.Code = new dy(dxVar);
        this.f17415a = false;
        this.r = new float[16];
        this.s = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(int i, int i2) {
        fb.V(getLogTag(), "onSurfaceChanged");
        B(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.I == null || this.V == null) {
            fb.I(getLogTag(), "render failed, textureProgram:%s, windowSurface:%s", ay.V(this.I), ay.V(this.V));
            return;
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16384);
        if (this.s) {
            this.Code.Code(this.I, this.r);
            this.V.Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        fb.V(getLogTag(), "onSurfaceDestroyed");
        this.d = false;
        Code();
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView
    public void B() {
        Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.BaseGlVideoView.3
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                GLES20.glClear(16384);
            }
        });
    }

    public void C() {
        Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.BaseGlVideoView.4
            @Override // java.lang.Runnable
            public void run() {
                BaseGlVideoView.this.i();
            }
        });
    }

    public void Code() {
        Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.BaseGlVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                dw dwVar = BaseGlVideoView.this.V;
                if (dwVar != null) {
                    dwVar.B();
                    BaseGlVideoView.this.V = null;
                }
            }
        });
    }

    public void I() {
        if (this.f17415a) {
            fb.I(getLogTag(), "renderVideo, destroyed");
        } else {
            Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.BaseGlVideoView.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (BaseGlVideoView.this.f17415a) {
                            fb.I(BaseGlVideoView.this.getLogTag(), "renderVideo, destroyed");
                            return;
                        }
                        SurfaceTexture surfaceTexture = BaseGlVideoView.this.h;
                        if (surfaceTexture != null) {
                            surfaceTexture.updateTexImage();
                        }
                        BaseGlVideoView baseGlVideoView = BaseGlVideoView.this;
                        if (baseGlVideoView.V != null) {
                            GLES20.glViewport(0, 0, baseGlVideoView.B, baseGlVideoView.C);
                            BaseGlVideoView.this.V.I();
                            BaseGlVideoView.this.h();
                        }
                    } catch (Throwable th) {
                        fb.Code(3, BaseGlVideoView.this.getLogTag(), "render exception", th);
                    }
                }
            });
        }
    }

    public void V(final int i, final int i2) {
        Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.BaseGlVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                BaseGlVideoView.this.Z(i, i2);
                bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.BaseGlVideoView.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BaseGlVideoView baseGlVideoView = BaseGlVideoView.this;
                        baseGlVideoView.o.Code(baseGlVideoView.m, baseGlVideoView.n);
                    }
                });
            }
        });
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView, com.huawei.hms.ads.kw
    public void destroyView() {
        super.destroyView();
        this.f17415a = true;
        this.s = false;
        Code();
    }

    public abstract String getLogTag();

    public void setVideoRatio(Float f) {
        fb.Code(getLogTag(), "setVideoRatio %s", f);
        this.L = f;
    }

    public BaseGlVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        dx dxVar = new dx();
        this.q = dxVar;
        this.Code = new dy(dxVar);
        this.f17415a = false;
        this.r = new float[16];
        this.s = false;
    }

    private void B(int i, int i2) {
        this.B = i;
        this.C = i2;
        Code(i, i2);
        if (this.L != null) {
            float floatValue = this.L.floatValue();
            int i3 = this.B;
            int i4 = this.C;
            Code(floatValue, i3 / i4, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(Surface surface) {
        fb.V(getLogTag(), "onSurfaceAvailable");
        this.d = true;
        if (this.S != null && surface != null && surface.isValid()) {
            try {
                this.S.V();
                dw dwVar = new dw(this.S.S(), surface);
                this.V = dwVar;
                dwVar.I();
                this.S.Code();
                this.g = this.S.I();
                this.I = this.S.C();
                this.Code.Code(this.S.Z());
                this.h = this.S.B();
                this.e.Code(this.g);
                B(this.V.Code(), this.V.V());
                if (this.l == null) {
                    BaseVideoView.i iVar = new BaseVideoView.i(this.o);
                    this.l = iVar;
                    this.e.Code(iVar);
                }
                if (this.c) {
                    Code(this.i);
                }
            } catch (Throwable th) {
                fb.I(getLogTag(), "exception: %s", th.getClass().getSimpleName());
            }
        }
        I();
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView
    public void Code(float f, float f2, int i, int i2) {
        int i3 = this.j;
        if (i3 == 1) {
            Code(this.B, this.C);
            return;
        }
        if (i3 != 2) {
            return;
        }
        if (f2 < f) {
            this.D = Integer.valueOf(i2);
            this.F = Integer.valueOf((int) (i2 * f));
        } else {
            this.F = Integer.valueOf(i);
            this.D = Integer.valueOf((int) (i / f));
        }
        this.Code.Code(this.F.intValue(), this.D.intValue());
    }

    public BaseGlVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        dx dxVar = new dx();
        this.q = dxVar;
        this.Code = new dy(dxVar);
        this.f17415a = false;
        this.r = new float[16];
        this.s = false;
    }

    public void Code(int i, int i2) {
        GLES20.glViewport(0, 0, i, i2);
        float f = i;
        float f2 = i2;
        Matrix.orthoM(this.r, 0, 0.0f, f, 0.0f, f2, -1.0f, 1.0f);
        float f3 = f / 2.0f;
        float f4 = f2 / 2.0f;
        Integer num = this.F;
        if (num != null) {
            i = num.intValue();
        }
        Integer num2 = this.D;
        if (num2 != null) {
            i2 = num2.intValue();
        }
        this.Code.Code(i, i2);
        this.Code.V(f3, f4);
    }

    public void Code(final Surface surface) {
        Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.BaseGlVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                BaseGlVideoView.this.V(surface);
            }
        });
    }

    public void Code(Runnable runnable) {
        d dVar = this.S;
        if (dVar != null) {
            dVar.Code(runnable);
        }
    }
}
