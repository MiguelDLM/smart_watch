package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.ed;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.fn;
import com.huawei.hms.ads.fs;
import com.huawei.hms.ads.gj;
import com.huawei.hms.ads.gv;
import com.huawei.hms.ads.hr;
import com.huawei.hms.ads.ir;
import com.huawei.hms.ads.ja;
import com.huawei.hms.ads.jh;
import com.huawei.hms.ads.km;
import com.huawei.openalliance.ad.beans.metadata.InteractCfg;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.utils.bf;
import com.huawei.openalliance.ad.utils.k;

/* loaded from: classes10.dex */
public abstract class PPSBaseView<P extends ir> extends RelativeLayout implements km {
    protected P B;
    protected gv C;
    protected fn D;
    protected int F;
    protected AdContentData S;

    /* renamed from: a, reason: collision with root package name */
    private boolean f17421a;
    private Long b;
    private View c;
    private jh d;
    private int l;
    private int m;
    private int n;
    private int o;
    private MaterialClickInfo p;
    private fs q;
    private View.OnTouchListener r;
    private View.OnTouchListener s;
    private View.OnTouchListener t;

    /* loaded from: classes10.dex */
    public class a implements jh.a {
        private a() {
        }

        @Override // com.huawei.hms.ads.jh.a
        public void Code(float f, float f2, float f3) {
            float sqrt = (float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
            if (fb.Code()) {
                fb.Code("PPSBaseView", "accLimitNew: %s, xAcc: %s yAcc: %s zAcc: %s, sqrtAcc: %s", Integer.valueOf(PPSBaseView.this.n), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(sqrt));
            }
            if (PPSBaseView.this.b == null || sqrt < PPSBaseView.this.n) {
                return;
            }
            fb.V("PPSBaseView", "meet, accLimitNew: %s, sqrtAcc: %s", Integer.valueOf(PPSBaseView.this.n), Float.valueOf(sqrt));
            PPSBaseView.this.d.V();
            PPSBaseView.this.p = new MaterialClickInfo.a().I(x.df).V(PPSBaseView.this.getWidth() + "*" + PPSBaseView.this.getHeight()).Code(Float.valueOf(com.huawei.openalliance.ad.utils.d.a(PPSBaseView.this.getContext()))).Code();
            PPSBaseView pPSBaseView = PPSBaseView.this;
            pPSBaseView.B.Code(0, 0, pPSBaseView.S, pPSBaseView.b, PPSBaseView.this.p, 19);
            PPSBaseView.this.C.Code(hr.CLICK);
        }
    }

    public PPSBaseView(Context context) {
        super(context);
        this.C = new gj();
        this.f17421a = false;
        this.b = null;
        this.q = new fs(this) { // from class: com.huawei.openalliance.ad.views.PPSBaseView.1
            @Override // com.huawei.hms.ads.fs
            public void Code() {
                fn fnVar = PPSBaseView.this.D;
                if (fnVar != null) {
                    fnVar.L();
                }
            }

            @Override // com.huawei.hms.ads.fs
            public void Code(long j, int i) {
                PPSBaseView.this.S();
                if (PPSBaseView.this.b == null) {
                    fb.I("PPSBaseView", "onViewShowEnd - no adShowStartTime");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis() - PPSBaseView.this.b.longValue();
                PPSBaseView pPSBaseView = PPSBaseView.this;
                P p = pPSBaseView.B;
                if (p != null) {
                    p.Code(pPSBaseView.S, currentTimeMillis, 100);
                    PPSBaseView.this.B.S();
                }
                PPSBaseView.this.b = null;
                bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSBaseView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PPSBaseView.this.C.I();
                    }
                }, 150L);
            }
        };
        this.r = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSBaseView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return PPSBaseView.this.Code(view, motionEvent);
            }
        };
        this.s = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSBaseView.3
            private float I;
            private float V;

            private boolean Code(float f, float f2) {
                if (PPSBaseView.this.o != 0 || f2 < PPSBaseView.this.l) {
                    return 1 == PPSBaseView.this.o && Math.sqrt((double) ((f * f) + (f2 * f2))) >= ((double) PPSBaseView.this.l);
                }
                return true;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return Code(motionEvent);
            }

            private boolean Code(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.V = motionEvent.getX();
                    this.I = motionEvent.getY();
                    if (fb.Code()) {
                        fb.Code("PPSBaseView", "startX = %s, startY = %s", Float.valueOf(this.V), Float.valueOf(this.I));
                    }
                    PPSBaseView pPSBaseView = PPSBaseView.this;
                    pPSBaseView.p = k.Code(pPSBaseView, motionEvent);
                }
                if (2 == motionEvent.getAction()) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    if (fb.Code()) {
                        fb.Code("PPSBaseView", " endX= %s, endY = %s, startX - endX= %s, startY - endY= %s", Float.valueOf(x), Float.valueOf(y), Float.valueOf(this.V - x), Float.valueOf(this.I - y));
                    }
                    if (Code(this.V - x, this.I - y)) {
                        PPSBaseView.this.setOnTouchListener(null);
                        PPSBaseView pPSBaseView2 = PPSBaseView.this;
                        k.Code(pPSBaseView2, motionEvent, x.de, pPSBaseView2.p);
                        PPSBaseView pPSBaseView3 = PPSBaseView.this;
                        pPSBaseView3.B.Code(0, 0, pPSBaseView3.S, pPSBaseView3.b, PPSBaseView.this.p, 18);
                        PPSBaseView.this.p = null;
                        PPSBaseView.this.C.Code(hr.CLICK);
                    }
                }
                return true;
            }
        };
        this.t = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSBaseView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        };
        setOnTouchListener(this.r);
    }

    private void L() {
        jh jhVar = new jh(getContext());
        this.d = jhVar;
        jhVar.Code(new a());
        this.d.Code();
    }

    @Override // com.huawei.hms.ads.km
    public void B() {
        this.D.F();
    }

    @Override // com.huawei.hms.ads.km
    public boolean C() {
        return false;
    }

    public void S() {
    }

    @Override // com.huawei.hms.ads.kw
    public void destroyView() {
        jh jhVar = this.d;
        if (jhVar != null) {
            jhVar.V();
        }
    }

    @Override // com.huawei.hms.ads.km
    public fn getAdMediator() {
        return this.D;
    }

    @Override // com.huawei.hms.ads.gf
    public View getOpenMeasureView() {
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fs fsVar = this.q;
        if (fsVar != null) {
            fsVar.D();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fb.V("PPSBaseView", "detached from window");
        fs fsVar = this.q;
        if (fsVar != null) {
            fsVar.L();
        }
        this.C.I();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        fs fsVar = this.q;
        if (fsVar != null) {
            fsVar.a();
        }
    }

    @Override // com.huawei.hms.ads.kw
    public void pauseView() {
    }

    @Override // com.huawei.hms.ads.kw
    public void resumeView() {
    }

    @Override // com.huawei.hms.ads.km
    public void setAdContent(AdContentData adContentData) {
        this.S = adContentData;
        if (adContentData.aA() == null) {
            this.l = ed.Code(getContext()).A();
            this.n = ed.Code(getContext()).H();
            this.m = ed.Code(getContext()).G();
        } else {
            InteractCfg aA = adContentData.aA();
            this.l = (aA.V() == null || aA.V().intValue() <= 0) ? ed.Code(getContext()).A() : aA.V().intValue();
            this.n = (aA.I() == null || aA.I().intValue() <= 0) ? ed.Code(getContext()).H() : aA.I().intValue();
            this.m = (aA.Z() == null || aA.Z().intValue() <= 0) ? ed.Code(getContext()).G() : aA.Z().intValue();
            this.o = aA.C().intValue();
        }
    }

    @Override // com.huawei.hms.ads.km
    public void setAdMediator(fn fnVar) {
        this.D = fnVar;
    }

    @Override // com.huawei.hms.ads.km
    public void setAudioFocusType(int i) {
    }

    @Override // com.huawei.hms.ads.km
    public void setDisplayDuration(int i) {
        this.F = i;
    }

    @Override // com.huawei.hms.ads.km
    public void D() {
        P p = this.B;
        if (p != null) {
            p.V(this.b);
        }
    }

    @Override // com.huawei.hms.ads.km
    public void F() {
        P p = this.B;
        if (p != null) {
            p.Code(this.b);
        }
    }

    @Override // com.huawei.hms.ads.km
    public void I(int i) {
        this.D.C(i);
    }

    @Override // com.huawei.hms.ads.km
    public void V() {
        fb.V("PPSBaseView", "show ad");
        this.B.Code(this.S);
    }

    @Override // com.huawei.hms.ads.km
    public void Z() {
        fb.V("PPSBaseView", "notifyAdLoaded");
        this.f17421a = true;
        this.b = Long.valueOf(System.currentTimeMillis());
        this.D.Code(this.S);
    }

    public void V(int i) {
        this.D.I(i);
    }

    public void Code() {
        this.D.n();
    }

    @Override // com.huawei.hms.ads.km
    public void Code(int i) {
        this.D.V(i);
    }

    @Override // com.huawei.hms.ads.km
    public void Code(int i, int i2) {
        fb.V("PPSBaseView", "user click skip button");
        this.B.Code(i, i2, this.b);
        this.C.d();
        this.C.I();
    }

    @Override // com.huawei.hms.ads.km
    public void Code(View view, Integer num) {
        this.c = view;
        if (view != null) {
            view.setOnTouchListener(this.r);
        }
        AdContentData adContentData = this.S;
        String v = adContentData == null ? null : adContentData.v();
        int C = ja.C(v);
        if (fb.Code()) {
            fb.Code("PPSBaseView", "ctrlswitch:%s", v);
            fb.Code("PPSBaseView", "splashpro mode:%s, splashInteractCfg: %s", Integer.valueOf(C), num);
        }
        if (C == 2) {
            setOnTouchListener(null);
            if (num == null) {
                return;
            }
            if (1 == num.intValue() || 4 == num.intValue()) {
                setOnTouchListener(this.s);
                if (this.c == null || 1 != num.intValue()) {
                    return;
                }
                this.c.setOnTouchListener(null);
                return;
            }
            if (2 == num.intValue() || 3 == num.intValue()) {
                setOnTouchListener(this.t);
                L();
                if (this.c == null || 2 != num.intValue()) {
                    return;
                }
                this.c.setOnTouchListener(null);
            }
        }
    }

    @Override // com.huawei.hms.ads.km
    public void Code(gv gvVar) {
        if (gvVar != null) {
            this.C = gvVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Code(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            setOnTouchListener(null);
            view.setEnabled(false);
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            if (fb.Code()) {
                fb.Code("PPSBaseView", "touch down image x=%f, y=%f", Float.valueOf(rawX), Float.valueOf(rawY));
            }
            MaterialClickInfo Code = k.Code(view, motionEvent);
            this.p = Code;
            if (Code != null) {
                Code.V(x.dd);
                this.p.Code(Float.valueOf(com.huawei.openalliance.ad.utils.d.a(getContext())));
            }
            P p = this.B;
            int i = (int) rawX;
            int i2 = (int) rawY;
            AdContentData adContentData = this.S;
            p.Code(i, i2, adContentData, this.b, this.p, 2 == ja.C(adContentData.v()) ? 17 : 7);
            this.C.Code(hr.CLICK);
        }
        return true;
    }
}
