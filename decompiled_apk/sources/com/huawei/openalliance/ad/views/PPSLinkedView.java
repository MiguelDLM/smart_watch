package com.huawei.openalliance.ad.views;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.DisplayCutout;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.garmin.fit.OxXXx0X;
import com.huawei.hms.ads.ck;
import com.huawei.hms.ads.cy;
import com.huawei.hms.ads.ed;
import com.huawei.hms.ads.eg;
import com.huawei.hms.ads.ev;
import com.huawei.hms.ads.ew;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.fn;
import com.huawei.hms.ads.fq;
import com.huawei.hms.ads.fw;
import com.huawei.hms.ads.gj;
import com.huawei.hms.ads.gv;
import com.huawei.hms.ads.hr;
import com.huawei.hms.ads.id;
import com.huawei.hms.ads.ip;
import com.huawei.hms.ads.ja;
import com.huawei.hms.ads.jh;
import com.huawei.hms.ads.ji;
import com.huawei.hms.ads.jo;
import com.huawei.hms.ads.kh;
import com.huawei.hms.ads.splash.R;
import com.huawei.openalliance.ad.beans.inner.AnalysisEventReport;
import com.huawei.openalliance.ad.beans.metadata.InteractCfg;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.inter.data.VideoInfo;
import com.huawei.openalliance.ad.inter.data.k;
import com.huawei.openalliance.ad.inter.listeners.m;
import com.huawei.openalliance.ad.media.MediaPlayerAgent;
import com.huawei.openalliance.ad.media.listener.MediaStateListener;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.bf;
import com.huawei.openalliance.ad.utils.n;
import com.huawei.openalliance.ad.utils.w;
import com.huawei.openalliance.ad.views.dialog.PPSAdvertiserInfoDialog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes10.dex */
public class PPSLinkedView extends RelativeLayout implements fq.a, kh {
    private static View.OnTouchListener bq = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.6
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };
    private List<View> A;
    private PPSSplashView E;
    private WindowManager G;
    private MediaPlayerAgent H;
    private PPSSkipButton J;
    private ImageView K;
    private boolean M;
    private h N;
    private View O;
    private int P;
    private ViewStub Q;
    private View R;
    private View T;
    private int U;
    private boolean W;
    private boolean aA;
    private boolean aB;
    private boolean aC;
    private boolean aD;
    private ValueAnimator aE;
    private boolean aF;
    private boolean aG;
    private int aH;
    private boolean aI;
    private Integer aJ;
    private boolean aK;
    private boolean aL;
    private boolean aM;
    private boolean aN;
    private int aO;
    private final String aP;
    private PPSSplashProView aQ;
    private PPSSplashSwipeView aR;
    private PPSSplashTwistView aS;
    private ji aT;
    private jh aU;
    private double aV;
    private double aW;
    private double aX;
    private float aY;
    private float aZ;
    private long aa;
    private long ab;
    private long ac;
    private long ad;
    private boolean ae;
    private boolean af;
    private final String ag;
    private int ah;
    private int ai;
    private float aj;
    private float ak;
    private int al;
    private int am;
    private int an;
    private int ao;
    private float ap;
    private float aq;
    private float ar;
    private int[] as;
    private boolean at;
    private boolean au;
    private m av;
    private boolean aw;
    private boolean ax;
    private boolean ay;
    private boolean az;
    private long ba;
    private int bb;
    private int bc;
    private int bd;
    private int be;
    private WeakReference<Context> bf;
    private int bg;
    private PPSSplashSwipeClickView bh;
    private PPSSplashTwistClickView bi;
    private boolean bj;
    private com.huawei.openalliance.ad.media.listener.g bk;
    private MediaStateListener bl;
    private final com.huawei.openalliance.ad.media.listener.h bm;
    private com.huawei.openalliance.ad.media.listener.d bn;
    private View.OnClickListener bo;
    private View.OnTouchListener bp;
    private View.OnTouchListener br;
    private View.OnTouchListener bs;
    private com.huawei.openalliance.ad.media.listener.c bt;
    private com.huawei.openalliance.ad.media.listener.f bu;
    private com.huawei.openalliance.ad.media.listener.b bv;
    private View.OnClickListener bw;
    private gv c;
    private MaterialClickInfo d;
    private PPSAdvertiserInfoDialog e;
    private Context f;
    private ed g;
    private PPSWLSView h;
    private PPSSplashAdSourceView i;
    private boolean j;
    private fq k;
    private k l;
    private fn m;
    private int n;
    private VideoInfo o;
    private ip p;
    private g q;
    private e r;
    private f s;
    private com.huawei.openalliance.ad.media.listener.a t;
    private com.huawei.openalliance.ad.media.listener.f u;
    private SplashLinkedVideoView v;
    private com.huawei.openalliance.ad.views.d w;
    private LinkedSurfaceView x;
    private TextureGlVideoView y;
    private PPSDestView z;

    /* loaded from: classes10.dex */
    public static class a implements View.OnClickListener {
        private WeakReference<PPSLinkedView> Code;
        private AdContentData V;

        public a(PPSLinkedView pPSLinkedView, AdContentData adContentData) {
            this.Code = new WeakReference<>(pPSLinkedView);
            this.V = adContentData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            final PPSLinkedView pPSLinkedView = this.Code.get();
            if (pPSLinkedView != null) {
                final int[] choiceViewLoc = pPSLinkedView.h.getChoiceViewLoc();
                final int[] choiceViewSize = pPSLinkedView.h.getChoiceViewSize();
                if (w.Code(choiceViewLoc, 2) && w.Code(choiceViewSize, 2)) {
                    bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            pPSLinkedView.Code(a.this.V, choiceViewLoc, choiceViewSize);
                        }
                    });
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class b extends BroadcastReceiver {
        private WeakReference<PPSLinkedView> Code;

        public b(PPSLinkedView pPSLinkedView) {
            this.Code = new WeakReference<>(pPSLinkedView);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                PPSLinkedView pPSLinkedView = this.Code.get();
                if (pPSLinkedView == null) {
                    fb.I("PPSLinkedView", "view is null");
                    return;
                }
                VideoInfo videoInfo = pPSLinkedView.o;
                k kVar = pPSLinkedView.l;
                m mVar = pPSLinkedView.av;
                if (!ew.Code.equals(intent.getAction())) {
                    if (!ew.V.equals(intent.getAction()) || videoInfo == null) {
                        return;
                    }
                    fb.V("PPSLinkedView", "LinkedSplashAdReceiver, progress resume %s  soundSwitch %s", Integer.valueOf(videoInfo.L()), videoInfo.a());
                    if (kVar != null) {
                        kVar.Code(videoInfo);
                    }
                    if (mVar != null) {
                        mVar.V(kVar);
                    }
                    ev.Code(context).V();
                    return;
                }
                int intExtra = intent.getIntExtra(ew.Z, 0);
                String stringExtra = intent.getStringExtra(ew.B);
                fb.V("PPSLinkedView", "LinkedSplashAdReceiver playProgress " + intExtra);
                if (videoInfo != null) {
                    videoInfo.Code(stringExtra);
                    videoInfo.Code(intExtra);
                }
            } catch (Throwable th) {
                fb.I("PPSLinkedView", "LinkedSplashAdReceiver error: %s", th.getClass().getSimpleName());
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements jh.a {
        private c() {
        }

        @Override // com.huawei.hms.ads.jh.a
        public void Code(float f, float f2, float f3) {
            if (fb.Code()) {
                fb.Code("PPSLinkedView", "limitAcc: %s, xAcc: %s yAcc: %s zAcc: %s", Integer.valueOf(PPSLinkedView.this.be), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3));
            }
            if (Math.abs(f) >= PPSLinkedView.this.be && PPSLinkedView.this.aY * f <= 0.0f) {
                PPSLinkedView.ae(PPSLinkedView.this);
                PPSLinkedView.this.aY = f;
            } else if (Math.abs(f2) >= PPSLinkedView.this.be && PPSLinkedView.this.aZ * f2 <= 0.0f) {
                PPSLinkedView.ae(PPSLinkedView.this);
                PPSLinkedView.this.aZ = f2;
            }
            Code(PPSLinkedView.this.bd);
        }

        private void Code(int i) {
            String str;
            if (PPSLinkedView.this.ba == 0) {
                PPSLinkedView.this.ba = System.currentTimeMillis();
                return;
            }
            if (PPSLinkedView.this.bb <= 2 || System.currentTimeMillis() - PPSLinkedView.this.ba <= 1000) {
                return;
            }
            double d = i;
            if (PPSLinkedView.this.aV >= d || PPSLinkedView.this.aW >= d || PPSLinkedView.this.aX >= d) {
                fb.V("PPSLinkedView", "limitDegree: %s X: %s Y: %s Z: %s", Integer.valueOf(i), Double.valueOf(PPSLinkedView.this.aV), Double.valueOf(PPSLinkedView.this.aW), Double.valueOf(PPSLinkedView.this.aX));
                PPSLinkedView.this.ba = System.currentTimeMillis();
                PPSLinkedView.this.bb = 0;
                PPSLinkedView.this.aU.V();
                PPSLinkedView.this.aT.V();
                if (PPSLinkedView.this.v != null) {
                    str = PPSLinkedView.this.v.getWidth() + "*" + PPSLinkedView.this.v.getHeight();
                } else {
                    str = null;
                }
                PPSLinkedView.this.d = new MaterialClickInfo.a().Code(Float.valueOf(com.huawei.openalliance.ad.utils.d.a(PPSLinkedView.this.getContext()))).V(str).I(x.df).Code();
                PPSLinkedView.this.I(19);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d implements ji.a {
        private int B;
        private int C;
        private Integer I;
        private int S;
        private Integer V;
        private Integer Z;

        private d() {
        }

        @Override // com.huawei.hms.ads.ji.a
        public void Code(double d, double d2, double d3) {
            fb.V("PPSLinkedView", "xDegree=%s, yDegree=%s, zDegree=%s", Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3));
            if (this.V == null) {
                this.V = Integer.valueOf((int) d);
            }
            if (this.I == null) {
                this.I = Integer.valueOf((int) d2);
            }
            if (this.Z == null) {
                this.Z = Integer.valueOf((int) d3);
            }
            PPSLinkedView pPSLinkedView = PPSLinkedView.this;
            double abs = Math.abs(d - this.B);
            double abs2 = Math.abs(d - this.V.intValue());
            if (abs > 180.0d) {
                abs2 = 360.0d - abs2;
            }
            pPSLinkedView.aV = abs2;
            PPSLinkedView.this.aW = Math.abs(d2 - ((double) this.C)) > 180.0d ? 360.0d - Math.abs(d2 - this.I.intValue()) : Math.abs(d - this.V.intValue());
            PPSLinkedView.this.aX = Math.abs(d3 - ((double) this.S)) > 180.0d ? 360.0d - Math.abs(d3 - this.Z.intValue()) : Math.abs(d - this.V.intValue());
            if (fb.Code()) {
                fb.Code("PPSLinkedView", "diffX: %s diffY: %s diffZ: %s", Double.valueOf(PPSLinkedView.this.aV), Double.valueOf(PPSLinkedView.this.aW), Double.valueOf(PPSLinkedView.this.aX));
            }
            this.B = (int) d;
            this.C = (int) d2;
            this.S = (int) d3;
        }
    }

    /* loaded from: classes10.dex */
    public interface e {
        void Code(int i);
    }

    /* loaded from: classes10.dex */
    public interface f {
        void Code();
    }

    /* loaded from: classes10.dex */
    public interface g {
        void Code(int i);
    }

    /* loaded from: classes10.dex */
    public class h extends CountDownTimer {
        final /* synthetic */ PPSLinkedView Code;

        @Override // android.os.CountDownTimer
        public void onFinish() {
            fb.V("PPSLinkedView", "CountDownTimer onFinish");
            if (this.Code.an == 1) {
                this.Code.Code((Integer) 8, false);
                this.Code.aH = 2;
                bf.Code(this.Code.aP);
                if (this.Code.aC) {
                    return;
                }
                this.Code.u();
                this.Code.aC = true;
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            fb.Code("PPSLinkedView", "onTick: %s", Long.valueOf(j));
        }
    }

    public PPSLinkedView(Context context) {
        super(context);
        this.c = new gj();
        this.j = true;
        this.n = 1;
        this.M = true;
        this.U = 0;
        this.W = false;
        this.ac = -1L;
        this.ae = false;
        this.af = false;
        this.ag = x.ak + hashCode();
        this.ah = 0;
        this.ai = 0;
        this.ao = OxXXx0X.f13024OIII0O;
        this.as = new int[2];
        this.at = false;
        this.au = false;
        this.aw = false;
        this.ax = false;
        this.ay = false;
        this.az = false;
        this.aA = false;
        this.aB = false;
        this.aC = false;
        this.aD = false;
        this.aF = false;
        this.aG = false;
        this.aI = true;
        this.aK = true;
        this.aL = true;
        this.aM = false;
        this.aN = false;
        this.aO = 0;
        this.aP = "skip_btn_delay_id_" + hashCode();
        this.bj = false;
        this.bk = new com.huawei.openalliance.ad.media.listener.g() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.21
            @Override // com.huawei.openalliance.ad.media.listener.g
            public void Code() {
                fb.Code("PPSLinkedView", "onVideoRenderStart, alreadyNotified: %s", Boolean.valueOf(PPSLinkedView.this.aM));
                if (PPSLinkedView.this.aM) {
                    return;
                }
                PPSLinkedView.this.aM = true;
                PPSLinkedView.this.x();
            }
        };
        this.bl = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.22
            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i) {
                fb.V("PPSLinkedView", "onMediaCompletion: %s", Integer.valueOf(i));
                PPSLinkedView.this.Code(i, true);
                PPSLinkedView.this.bj = true;
                if (PPSLinkedView.this.an == 2 && PPSLinkedView.this.k != null && PPSLinkedView.this.k.F()) {
                    fb.V("PPSLinkedView", "onMediaCompletion, start play");
                    PPSLinkedView.this.H.V();
                    PPSLinkedView.this.setPlaying(true);
                }
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.Z(i);
                }
                if (PPSLinkedView.this.p != null) {
                    long j = i;
                    PPSLinkedView.this.p.Code(PPSLinkedView.this.f, j, j);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i) {
                fb.V("PPSLinkedView", "onMediaPause: %s", Integer.valueOf(i));
                PPSLinkedView.this.Code(i, false);
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.V(i);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i) {
                fb.V("PPSLinkedView", "onMediaStart: %s", Integer.valueOf(i));
                PPSLinkedView.this.W = true;
                PPSLinkedView.this.setPlaying(true);
                PPSLinkedView.this.ad = i;
                PPSLinkedView.this.ab = System.currentTimeMillis();
                if (!PPSLinkedView.this.at) {
                    PPSLinkedView.this.w();
                    PPSLinkedView.this.i();
                }
                if (i > 0) {
                    PPSLinkedView.this.p.L();
                    PPSLinkedView.this.c.f();
                } else {
                    PPSLinkedView.this.p.D();
                    if (PPSLinkedView.this.c != null && PPSLinkedView.this.o != null) {
                        fb.V("PPSLinkedView", "om start");
                        PPSLinkedView.this.c.Code(PPSLinkedView.this.o.I(), !"y".equals(PPSLinkedView.this.o.a()));
                    }
                }
                if (PPSLinkedView.this.l != null && PPSLinkedView.this.l.I()) {
                    cy.Code(PPSLinkedView.this.f, PPSLinkedView.this.l.o(), PPSLinkedView.this.l.a(), (System.currentTimeMillis() - PPSLinkedView.this.g.Q().longValue()) - PPSLinkedView.this.g.R(), PPSLinkedView.this.l.n(), "84");
                }
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.Code(i);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i) {
                fb.V("PPSLinkedView", "onMediaStop: %s", Integer.valueOf(i));
                PPSLinkedView.this.Code(i, false);
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.I(i);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onProgress(int i, int i2) {
                if (i2 > 0 && !PPSLinkedView.this.aM) {
                    fb.Code("PPSLinkedView", "onProgress onRenderStart, playtime: %s", Integer.valueOf(i2));
                    PPSLinkedView.this.aM = true;
                    PPSLinkedView.this.x();
                }
                if (i2 > 0) {
                    PPSLinkedView.this.o.Code(i2);
                    PPSLinkedView.this.setPlaying(true);
                }
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.Code(i, i2);
                }
                if (PPSLinkedView.this.W) {
                    PPSLinkedView.this.c.Code(i);
                }
                if (PPSLinkedView.this.p != null) {
                    PPSLinkedView.this.p.Code(PPSLinkedView.this.f, i2, PPSLinkedView.this.o == null ? 0L : PPSLinkedView.this.o.I());
                }
            }
        };
        this.bm = new com.huawei.openalliance.ad.media.listener.h() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.2
            @Override // com.huawei.openalliance.ad.media.listener.h
            public void Code(long j) {
                if (fb.Code()) {
                    fb.Code("PPSLinkedView", "reportVideoTime: %s", Long.valueOf(j));
                }
                if (PPSLinkedView.this.p != null) {
                    PPSLinkedView.this.p.Code(PPSLinkedView.this.getContext(), j);
                }
            }
        };
        this.bn = new com.huawei.openalliance.ad.media.listener.d() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.3
            @Override // com.huawei.openalliance.ad.media.listener.d
            public void Code(int i) {
                fb.V("PPSLinkedView", "onDurationReady:");
                if (!PPSLinkedView.this.aG && PPSLinkedView.this.s != null) {
                    PPSLinkedView.this.aG = true;
                    PPSLinkedView.this.s.Code();
                }
                if (PPSLinkedView.this.aJ == null) {
                    PPSLinkedView.this.aJ = Integer.valueOf(i);
                    if (PPSLinkedView.this.l == null || PPSLinkedView.this.l.C() == null) {
                        return;
                    }
                    PPSLinkedView.this.l.C().V(i);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.d
            public void V(int i) {
            }
        };
        this.bo = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                if (PPSLinkedView.this.j) {
                    if (PPSLinkedView.this.an == 1) {
                        PPSLinkedView pPSLinkedView = PPSLinkedView.this;
                        if (!pPSLinkedView.Code(pPSLinkedView.d)) {
                            return;
                        }
                    }
                    PPSLinkedView.this.j = false;
                    fb.V("PPSLinkedView", "onClick");
                    if (PPSLinkedView.this.an == 2) {
                        i = 10;
                    } else {
                        i = 2 == PPSLinkedView.this.aQ.getMode() ? 17 : 9;
                        PPSLinkedView.this.m();
                    }
                    PPSLinkedView.this.I(i);
                    bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PPSLinkedView.this.j = true;
                        }
                    }, 500L);
                }
            }
        };
        this.bp = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.5
            private float I;
            private float V;

            private boolean Code(float f2, float f3) {
                if (PPSLinkedView.this.bg != 0 || f3 < PPSLinkedView.this.bc) {
                    return 1 == PPSLinkedView.this.bg && Math.sqrt((double) ((f2 * f2) + (f3 * f3))) >= ((double) PPSLinkedView.this.bc);
                }
                return true;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.V = motionEvent.getX();
                    this.I = motionEvent.getY();
                    if (fb.Code()) {
                        fb.Code("PPSLinkedView", "startX = %s, startY = %s", Float.valueOf(this.V), Float.valueOf(this.I));
                    }
                    PPSLinkedView.this.d = jo.Code(view, motionEvent);
                }
                if (2 == motionEvent.getAction()) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    if (fb.Code()) {
                        fb.Code("PPSLinkedView", "endX = %s, endY = %s, startX - endX = %s, startY-endY = %s", Float.valueOf(x), Float.valueOf(y), Float.valueOf(this.V - x), Float.valueOf(this.I - y));
                    }
                    if (Code(this.V - x, this.I - y)) {
                        jo.Code(view, motionEvent, x.de, PPSLinkedView.this.d);
                        PPSLinkedView.this.v.setOnTouchListener(null);
                        PPSLinkedView.this.I(18);
                    }
                }
                return true;
            }
        };
        this.br = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.setEnabled(false);
                PPSLinkedView.this.v.setOnTouchListener(null);
                if (motionEvent.getAction() != 0) {
                    return true;
                }
                PPSLinkedView.this.d = com.huawei.openalliance.ad.utils.k.Code(view, motionEvent);
                if (PPSLinkedView.this.d != null) {
                    PPSLinkedView.this.d.V(x.dd);
                    PPSLinkedView.this.d.Code(Float.valueOf(com.huawei.openalliance.ad.utils.d.a(view.getContext())));
                }
                PPSLinkedView.this.I(17);
                return true;
            }
        };
        this.bs = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    PPSLinkedView.this.d = jo.Code(view, motionEvent);
                }
                if (1 != motionEvent.getAction()) {
                    return false;
                }
                jo.Code(view, motionEvent, null, PPSLinkedView.this.d);
                return false;
            }
        };
        this.bt = new com.huawei.openalliance.ad.media.listener.c() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.9
            @Override // com.huawei.openalliance.ad.media.listener.c
            public void Code(MediaPlayerAgent mediaPlayerAgent, int i, int i2, int i3) {
                fb.I("PPSLinkedView", "media play error, isMoved: %s", Boolean.valueOf(PPSLinkedView.this.at));
                PPSLinkedView.this.E();
                PPSLinkedView.this.G();
                PPSLinkedView.this.setPlaying(false);
                if (PPSLinkedView.this.t != null) {
                    fb.V("PPSLinkedView", "call onMediaError. ");
                    PPSLinkedView.this.t.Code(i, i2, i3);
                }
            }
        };
        this.bu = new com.huawei.openalliance.ad.media.listener.f() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.10
            @Override // com.huawei.openalliance.ad.media.listener.f
            public void Code() {
                fb.V("PPSLinkedView", "onMute");
                if (PPSLinkedView.this.u != null) {
                    PPSLinkedView.this.u.Code();
                }
                PPSLinkedView.this.c.V(0.0f);
            }

            @Override // com.huawei.openalliance.ad.media.listener.f
            public void V() {
                fb.V("PPSLinkedView", "onUnmute");
                if (PPSLinkedView.this.u != null) {
                    PPSLinkedView.this.u.V();
                }
                PPSLinkedView.this.c.V(1.0f);
            }
        };
        this.bv = new com.huawei.openalliance.ad.media.listener.b() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.11
            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code() {
                PPSLinkedView.this.c.b();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void V() {
                PPSLinkedView.this.c.c();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code(int i) {
            }
        };
        this.bw = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PPSLinkedView.this.V(!view.isSelected());
            }
        };
        V(context);
    }

    private void H() {
        k kVar = this.l;
        if (kVar != null) {
            kVar.F(false);
        }
        this.l = null;
        this.E = null;
        this.O = null;
        this.T = null;
        LinkedSurfaceView linkedSurfaceView = this.x;
        if (linkedSurfaceView != null) {
            linkedSurfaceView.Z();
        }
        TextureGlVideoView textureGlVideoView = this.y;
        if (textureGlVideoView != null) {
            textureGlVideoView.destroyView();
        }
        com.huawei.openalliance.ad.views.d dVar = this.w;
        if (dVar != null) {
            dVar.D();
        }
        setPlaying(false);
        M();
        bf.Code(this.aP);
        this.c.I();
        com.huawei.openalliance.ad.inter.d.Code(this.f).Code(false);
    }

    private boolean O() {
        return this.aF;
    }

    public static /* synthetic */ int ae(PPSLinkedView pPSLinkedView) {
        int i = pPSLinkedView.bb;
        pPSLinkedView.bb = i + 1;
        return i;
    }

    private void setDestViewClickable(PPSDestView pPSDestView) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(pPSDestView);
        V(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaying(boolean z) {
        this.aF = z;
    }

    private void setSkipBtnDelayTime(AdContentData adContentData) {
        if (adContentData == null || adContentData.ar() <= 0) {
            return;
        }
        this.aO = adContentData.ar();
    }

    private void setSplashViewClickable(SplashLinkedVideoView splashLinkedVideoView) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(splashLinkedVideoView);
        V(arrayList);
    }

    private void t() {
        fb.V("PPSLinkedView", "addMonitor");
        fq fqVar = new fq(this, this);
        this.k = fqVar;
        fqVar.D();
        k kVar = this.l;
        if (kVar != null) {
            this.k.V(kVar.u(), this.l.v());
        }
        this.k.Code(this.l);
    }

    private void v() {
        h hVar = this.N;
        if (hVar != null) {
            hVar.cancel();
            this.N = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        long currentTimeMillis = System.currentTimeMillis();
        this.aa = currentTimeMillis;
        fn fnVar = this.m;
        if (fnVar != null) {
            fnVar.Code(currentTimeMillis);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (!this.ae) {
            this.ae = true;
            k kVar = this.l;
            if (kVar != null && kVar.I()) {
                com.huawei.openalliance.ad.ipc.d.Code(getContext()).Code("dismissSlogan", null, null, null);
            }
            this.ac = System.currentTimeMillis();
            if (!this.g.k()) {
                Code((Long) null, (Integer) null, (Integer) 8, false);
                this.au = true;
            }
            if (this.an == 1) {
                P();
                N();
                V(this.l);
                A();
                Code(this.l);
            }
        }
        View view = this.O;
        if (view != null) {
            view.setVisibility(8);
            this.O = null;
        }
        if (this.E != null) {
            fb.Code("PPSLinkedView", "PPSSplashView is not null. ");
            this.E.setVisibility(8);
            this.E = null;
        }
        View view2 = this.T;
        if (view2 != null) {
            view2.setVisibility(8);
            this.T = null;
        }
    }

    private void z() {
        ji jiVar = new ji(getContext());
        this.aT = jiVar;
        jiVar.Code(new d());
        this.aT.Code();
        jh jhVar = new jh(getContext());
        this.aU = jhVar;
        jhVar.Code(new c());
        this.aU.Code();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            int Code = jo.Code(motionEvent);
            if (Code == 0) {
                this.d = jo.Code(this, motionEvent);
            }
            if (1 == Code) {
                jo.Code(this, motionEvent, null, this.d);
            }
        } catch (Throwable th) {
            fb.I("PPSLinkedView", "dispatchTouchEvent exception : %s", th.getClass().getSimpleName());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.huawei.hms.ads.kh
    public String getSplashViewSlotPosition() {
        return bc.Code((fw) this.E);
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        DisplayCutout displayCutout;
        List boundingRects;
        int i = Build.VERSION.SDK_INT;
        fb.V("PPSLinkedView", "onApplyWindowInsets, sdk: %s", Integer.valueOf(i));
        if (bc.V() && windowInsets != null) {
            displayCutout = windowInsets.getDisplayCutout();
            if (displayCutout != null) {
                boundingRects = displayCutout.getBoundingRects();
                if (!ad.Code(boundingRects)) {
                    this.ah = ((Rect) boundingRects.get(0)).height();
                }
            } else {
                fb.V("PPSLinkedView", "DisplayCutout is null");
            }
        }
        if (this.ah <= 0 && i >= 26 && ck.Code(this.f).Code(getContext())) {
            this.ah = Math.max(this.ah, ck.Code(this.f).Code(this));
        }
        fb.V("PPSLinkedView", "notchHeight:" + this.ah);
        return super.onApplyWindowInsets(windowInsets);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fb.Code("PPSLinkedView", "onAttachedToWindow");
        fq fqVar = this.k;
        if (fqVar != null) {
            fqVar.D();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fb.Code("PPSLinkedView", "onDetechedFromWindow");
        fq fqVar = this.k;
        if (fqVar != null) {
            fqVar.L();
        }
        bf.Code(this.aP);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        fb.Code("PPSLinkedView", "onVisibilityChanged:");
        fq fqVar = this.k;
        if (fqVar != null) {
            fqVar.a();
        }
    }

    public void setLinkedAdActionListener(com.huawei.openalliance.ad.inter.listeners.a aVar) {
        fb.V("PPSLinkedView", "setLinkedAdActionListener. ");
        ip ipVar = this.p;
        if (ipVar != null) {
            ipVar.Code(aVar);
        }
    }

    public void setMuteOnlyOnLostAudioFocus(boolean z) {
        this.aI = z;
    }

    public void setOnLinkedAdClickListener(e eVar) {
        this.r = eVar;
    }

    public void setOnLinkedAdPreparedListener(f fVar) {
        this.s = fVar;
    }

    public void setOnLinkedAdSwitchListener(g gVar) {
        this.q = gVar;
    }

    public PPSLinkedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new gj();
        this.j = true;
        this.n = 1;
        this.M = true;
        this.U = 0;
        this.W = false;
        this.ac = -1L;
        this.ae = false;
        this.af = false;
        this.ag = x.ak + hashCode();
        this.ah = 0;
        this.ai = 0;
        this.ao = OxXXx0X.f13024OIII0O;
        this.as = new int[2];
        this.at = false;
        this.au = false;
        this.aw = false;
        this.ax = false;
        this.ay = false;
        this.az = false;
        this.aA = false;
        this.aB = false;
        this.aC = false;
        this.aD = false;
        this.aF = false;
        this.aG = false;
        this.aI = true;
        this.aK = true;
        this.aL = true;
        this.aM = false;
        this.aN = false;
        this.aO = 0;
        this.aP = "skip_btn_delay_id_" + hashCode();
        this.bj = false;
        this.bk = new com.huawei.openalliance.ad.media.listener.g() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.21
            @Override // com.huawei.openalliance.ad.media.listener.g
            public void Code() {
                fb.Code("PPSLinkedView", "onVideoRenderStart, alreadyNotified: %s", Boolean.valueOf(PPSLinkedView.this.aM));
                if (PPSLinkedView.this.aM) {
                    return;
                }
                PPSLinkedView.this.aM = true;
                PPSLinkedView.this.x();
            }
        };
        this.bl = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.22
            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i) {
                fb.V("PPSLinkedView", "onMediaCompletion: %s", Integer.valueOf(i));
                PPSLinkedView.this.Code(i, true);
                PPSLinkedView.this.bj = true;
                if (PPSLinkedView.this.an == 2 && PPSLinkedView.this.k != null && PPSLinkedView.this.k.F()) {
                    fb.V("PPSLinkedView", "onMediaCompletion, start play");
                    PPSLinkedView.this.H.V();
                    PPSLinkedView.this.setPlaying(true);
                }
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.Z(i);
                }
                if (PPSLinkedView.this.p != null) {
                    long j = i;
                    PPSLinkedView.this.p.Code(PPSLinkedView.this.f, j, j);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i) {
                fb.V("PPSLinkedView", "onMediaPause: %s", Integer.valueOf(i));
                PPSLinkedView.this.Code(i, false);
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.V(i);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i) {
                fb.V("PPSLinkedView", "onMediaStart: %s", Integer.valueOf(i));
                PPSLinkedView.this.W = true;
                PPSLinkedView.this.setPlaying(true);
                PPSLinkedView.this.ad = i;
                PPSLinkedView.this.ab = System.currentTimeMillis();
                if (!PPSLinkedView.this.at) {
                    PPSLinkedView.this.w();
                    PPSLinkedView.this.i();
                }
                if (i > 0) {
                    PPSLinkedView.this.p.L();
                    PPSLinkedView.this.c.f();
                } else {
                    PPSLinkedView.this.p.D();
                    if (PPSLinkedView.this.c != null && PPSLinkedView.this.o != null) {
                        fb.V("PPSLinkedView", "om start");
                        PPSLinkedView.this.c.Code(PPSLinkedView.this.o.I(), !"y".equals(PPSLinkedView.this.o.a()));
                    }
                }
                if (PPSLinkedView.this.l != null && PPSLinkedView.this.l.I()) {
                    cy.Code(PPSLinkedView.this.f, PPSLinkedView.this.l.o(), PPSLinkedView.this.l.a(), (System.currentTimeMillis() - PPSLinkedView.this.g.Q().longValue()) - PPSLinkedView.this.g.R(), PPSLinkedView.this.l.n(), "84");
                }
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.Code(i);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i) {
                fb.V("PPSLinkedView", "onMediaStop: %s", Integer.valueOf(i));
                PPSLinkedView.this.Code(i, false);
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.I(i);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onProgress(int i, int i2) {
                if (i2 > 0 && !PPSLinkedView.this.aM) {
                    fb.Code("PPSLinkedView", "onProgress onRenderStart, playtime: %s", Integer.valueOf(i2));
                    PPSLinkedView.this.aM = true;
                    PPSLinkedView.this.x();
                }
                if (i2 > 0) {
                    PPSLinkedView.this.o.Code(i2);
                    PPSLinkedView.this.setPlaying(true);
                }
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.Code(i, i2);
                }
                if (PPSLinkedView.this.W) {
                    PPSLinkedView.this.c.Code(i);
                }
                if (PPSLinkedView.this.p != null) {
                    PPSLinkedView.this.p.Code(PPSLinkedView.this.f, i2, PPSLinkedView.this.o == null ? 0L : PPSLinkedView.this.o.I());
                }
            }
        };
        this.bm = new com.huawei.openalliance.ad.media.listener.h() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.2
            @Override // com.huawei.openalliance.ad.media.listener.h
            public void Code(long j) {
                if (fb.Code()) {
                    fb.Code("PPSLinkedView", "reportVideoTime: %s", Long.valueOf(j));
                }
                if (PPSLinkedView.this.p != null) {
                    PPSLinkedView.this.p.Code(PPSLinkedView.this.getContext(), j);
                }
            }
        };
        this.bn = new com.huawei.openalliance.ad.media.listener.d() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.3
            @Override // com.huawei.openalliance.ad.media.listener.d
            public void Code(int i) {
                fb.V("PPSLinkedView", "onDurationReady:");
                if (!PPSLinkedView.this.aG && PPSLinkedView.this.s != null) {
                    PPSLinkedView.this.aG = true;
                    PPSLinkedView.this.s.Code();
                }
                if (PPSLinkedView.this.aJ == null) {
                    PPSLinkedView.this.aJ = Integer.valueOf(i);
                    if (PPSLinkedView.this.l == null || PPSLinkedView.this.l.C() == null) {
                        return;
                    }
                    PPSLinkedView.this.l.C().V(i);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.d
            public void V(int i) {
            }
        };
        this.bo = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                if (PPSLinkedView.this.j) {
                    if (PPSLinkedView.this.an == 1) {
                        PPSLinkedView pPSLinkedView = PPSLinkedView.this;
                        if (!pPSLinkedView.Code(pPSLinkedView.d)) {
                            return;
                        }
                    }
                    PPSLinkedView.this.j = false;
                    fb.V("PPSLinkedView", "onClick");
                    if (PPSLinkedView.this.an == 2) {
                        i = 10;
                    } else {
                        i = 2 == PPSLinkedView.this.aQ.getMode() ? 17 : 9;
                        PPSLinkedView.this.m();
                    }
                    PPSLinkedView.this.I(i);
                    bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PPSLinkedView.this.j = true;
                        }
                    }, 500L);
                }
            }
        };
        this.bp = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.5
            private float I;
            private float V;

            private boolean Code(float f2, float f3) {
                if (PPSLinkedView.this.bg != 0 || f3 < PPSLinkedView.this.bc) {
                    return 1 == PPSLinkedView.this.bg && Math.sqrt((double) ((f2 * f2) + (f3 * f3))) >= ((double) PPSLinkedView.this.bc);
                }
                return true;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.V = motionEvent.getX();
                    this.I = motionEvent.getY();
                    if (fb.Code()) {
                        fb.Code("PPSLinkedView", "startX = %s, startY = %s", Float.valueOf(this.V), Float.valueOf(this.I));
                    }
                    PPSLinkedView.this.d = jo.Code(view, motionEvent);
                }
                if (2 == motionEvent.getAction()) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    if (fb.Code()) {
                        fb.Code("PPSLinkedView", "endX = %s, endY = %s, startX - endX = %s, startY-endY = %s", Float.valueOf(x), Float.valueOf(y), Float.valueOf(this.V - x), Float.valueOf(this.I - y));
                    }
                    if (Code(this.V - x, this.I - y)) {
                        jo.Code(view, motionEvent, x.de, PPSLinkedView.this.d);
                        PPSLinkedView.this.v.setOnTouchListener(null);
                        PPSLinkedView.this.I(18);
                    }
                }
                return true;
            }
        };
        this.br = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.setEnabled(false);
                PPSLinkedView.this.v.setOnTouchListener(null);
                if (motionEvent.getAction() != 0) {
                    return true;
                }
                PPSLinkedView.this.d = com.huawei.openalliance.ad.utils.k.Code(view, motionEvent);
                if (PPSLinkedView.this.d != null) {
                    PPSLinkedView.this.d.V(x.dd);
                    PPSLinkedView.this.d.Code(Float.valueOf(com.huawei.openalliance.ad.utils.d.a(view.getContext())));
                }
                PPSLinkedView.this.I(17);
                return true;
            }
        };
        this.bs = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    PPSLinkedView.this.d = jo.Code(view, motionEvent);
                }
                if (1 != motionEvent.getAction()) {
                    return false;
                }
                jo.Code(view, motionEvent, null, PPSLinkedView.this.d);
                return false;
            }
        };
        this.bt = new com.huawei.openalliance.ad.media.listener.c() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.9
            @Override // com.huawei.openalliance.ad.media.listener.c
            public void Code(MediaPlayerAgent mediaPlayerAgent, int i, int i2, int i3) {
                fb.I("PPSLinkedView", "media play error, isMoved: %s", Boolean.valueOf(PPSLinkedView.this.at));
                PPSLinkedView.this.E();
                PPSLinkedView.this.G();
                PPSLinkedView.this.setPlaying(false);
                if (PPSLinkedView.this.t != null) {
                    fb.V("PPSLinkedView", "call onMediaError. ");
                    PPSLinkedView.this.t.Code(i, i2, i3);
                }
            }
        };
        this.bu = new com.huawei.openalliance.ad.media.listener.f() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.10
            @Override // com.huawei.openalliance.ad.media.listener.f
            public void Code() {
                fb.V("PPSLinkedView", "onMute");
                if (PPSLinkedView.this.u != null) {
                    PPSLinkedView.this.u.Code();
                }
                PPSLinkedView.this.c.V(0.0f);
            }

            @Override // com.huawei.openalliance.ad.media.listener.f
            public void V() {
                fb.V("PPSLinkedView", "onUnmute");
                if (PPSLinkedView.this.u != null) {
                    PPSLinkedView.this.u.V();
                }
                PPSLinkedView.this.c.V(1.0f);
            }
        };
        this.bv = new com.huawei.openalliance.ad.media.listener.b() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.11
            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code() {
                PPSLinkedView.this.c.b();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void V() {
                PPSLinkedView.this.c.c();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code(int i) {
            }
        };
        this.bw = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PPSLinkedView.this.V(!view.isSelected());
            }
        };
        V(context);
    }

    private void A() {
        String str;
        try {
            if (this.R == null) {
                View inflate = this.Q.inflate();
                this.R = inflate;
                inflate.setId(R.id.hiad_full_logo_region);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.R.getLayoutParams();
            if (this.ah > 0) {
                fb.Code("PPSLinkedView", "left:%s, top:%s, right:%s", Integer.valueOf(layoutParams.leftMargin), Integer.valueOf(layoutParams.topMargin), Integer.valueOf(layoutParams.rightMargin));
                layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin + this.ah, layoutParams.rightMargin, layoutParams.bottomMargin);
                this.R.setLayoutParams(layoutParams);
            }
            ImageView imageView = (ImageView) this.R.findViewById(R.id.hiad_full_mode_logo);
            int i = this.P;
            if (i > 0) {
                imageView.setImageResource(i);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            TextView textView = (TextView) this.R.findViewById(R.id.hiad_media_name);
            int i2 = this.U;
            if (i2 <= 0) {
                textView.setVisibility(8);
            } else {
                textView.setText(i2);
                textView.setVisibility(0);
            }
        } catch (Resources.NotFoundException unused) {
            str = "showFullModeLogo res not found";
            fb.I("PPSLinkedView", str);
        } catch (Exception e2) {
            str = "showFullModeLogo " + e2.getClass().getSimpleName();
            fb.I("PPSLinkedView", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        if (this.an != 1 || this.at) {
            return;
        }
        this.at = true;
        v();
        this.an = 0;
        TextureGlVideoView textureGlVideoView = this.y;
        if (textureGlVideoView != null) {
            textureGlVideoView.L();
            this.y.destroyView();
        }
        setPlaying(false);
        s();
        com.huawei.openalliance.ad.views.d dVar = this.w;
        if (dVar != null) {
            dVar.D();
        }
        this.E = null;
        this.O = null;
        this.T = null;
        M();
        PPSSplashProView pPSSplashProView = this.aQ;
        if (pPSSplashProView != null) {
            pPSSplashProView.Code();
        }
        if (this.au || !this.W) {
            return;
        }
        fb.Code("PPSLinkedView", "report imp and phyImp on splash. ");
        this.p.Code(System.currentTimeMillis() - this.ab, 100);
        Code((Integer) 8, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        fb.V("PPSLinkedView", "reportDisplayError, adMediator: %s, linkedAdListener: %s", ay.V(this.m), ay.V(this.av));
        boolean z = this.aN;
        if (!z && this.m != null) {
            fb.V("PPSLinkedView", "report display error. ");
            this.aN = true;
            this.m.I(-3);
            this.m.n();
            return;
        }
        if (z) {
            return;
        }
        fb.V("PPSLinkedView", "report fail to display. ");
        this.aN = true;
        Z(-3);
    }

    private int I(AdContentData adContentData) {
        return (adContentData.aA() == null || adContentData.aA().Code() == null) ? this.g.w() : adContentData.aA().Code().intValue();
    }

    private void M() {
        List<View> list = this.A;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : this.A) {
            if (view != null) {
                view.setOnClickListener(null);
            }
        }
        setOnClickListener(null);
    }

    private void N() {
        if (this.M && this.K == null) {
            ImageView imageView = new ImageView(getContext());
            this.K = imageView;
            imageView.setImageResource(R.drawable.hiad_selector_ic_sound_check);
            bc.Code(this.K);
            Resources resources = getContext().getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.hiad_8_dp);
            this.K.setPadding(0, dimensionPixelSize, resources.getDimensionPixelSize(R.dimen.hiad_page_margin_side), dimensionPixelSize);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(21);
            int i = R.dimen.haid_splash_sound_margin_right;
            layoutParams.rightMargin = resources.getDimensionPixelSize(i);
            int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.haid_splash_sound_margin_bottom);
            layoutParams.bottomMargin = dimensionPixelOffset;
            layoutParams.bottomMargin = dimensionPixelOffset + bc.I(getContext());
            layoutParams.setMarginEnd(resources.getDimensionPixelSize(i));
            this.v.addView(this.K, layoutParams);
            this.K.bringToFront();
            this.K.setSelected(false);
            this.K.setOnClickListener(this.bw);
        }
    }

    private void P() {
        if (this.J != null) {
            fb.Code("PPSLinkedView", "%d delay, skip btn show", Integer.valueOf(this.aO));
            if (this.aO > 0) {
                bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.15
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PPSLinkedView.this.J != null) {
                            fb.Code("PPSLinkedView", "skip btn show");
                            PPSLinkedView.this.J.setVisibility(0);
                        }
                    }
                }, this.aP, this.aO);
            } else {
                fb.Code("PPSLinkedView", "skip btn show");
                this.J.setVisibility(0);
            }
        }
    }

    private Integer Z(AdContentData adContentData) {
        return Code(Integer.valueOf(I(adContentData)), ja.C(adContentData.v()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        fb.V("PPSLinkedView", "reportAdShowStartEvent");
        this.af = false;
        String valueOf = String.valueOf(this.aa);
        k kVar = this.l;
        if (kVar == null) {
            fb.I("PPSLinkedView", "linkedSplashAd is null! please register first");
            return;
        }
        kVar.m(valueOf);
        this.l.Code(this.aa);
        this.l.C(false);
        this.l.B(false);
        this.l.F(true);
        if (!this.l.aw()) {
            this.l.I(true);
        }
        this.p.Code(valueOf);
        this.p.Code(this.aa);
        fb.Code("PPSLinkedView", "report showStart. ");
        this.p.S();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        fb.V("PPSLinkedView", "calculateScaleAndTrans");
        n();
        if (this.aj <= 0.0f || this.ak <= 0.0f) {
            fb.I("PPSLinkedView", "calculateScaleAndTrans, get screen size failed. ");
            G();
            D();
            return;
        }
        boolean F = bc.F(this.f);
        fb.V("PPSLinkedView", "calculateScaleAndTrans, MultiWindow:%s, screenHeight:%s,  screenWidth:%s", Boolean.valueOf(F), Float.valueOf(this.aj), Float.valueOf(this.ak));
        this.z.getLocationOnScreen(this.as);
        this.al = this.z.getHeight();
        this.am = this.z.getWidth();
        fb.V("PPSLinkedView", "calculateScaleAndTrans, destViewHeight:%s, destViewWidth:%s, locationX:%s, locationY:%s", Integer.valueOf(this.al), Integer.valueOf(this.am), Integer.valueOf(this.as[0]), Integer.valueOf(this.as[1]));
        Point point = new Point();
        this.G.getDefaultDisplay().getRealSize(point);
        fb.Code("PPSLinkedView", "calculateScaleAndTrans, screenHeight:%s, point.y:%s", Float.valueOf(this.aj), Integer.valueOf(point.y));
        if (this.ah <= 0 && ck.Code(this.f).Code(this.f)) {
            this.ah = Math.max(this.ah, ck.Code(this.f).Code(this));
        }
        if ((point.y - this.ah) - this.aj > bc.C(this.f)) {
            this.ai = bc.S(getContext());
        } else {
            this.ai = 0;
        }
        fb.V("PPSLinkedView", "calculateScaleAndTrans, NotchEnable: %s, scrennHeight:%s, screenWidth:%s, navigationBarHeight:%s, notchHeight:%s", Boolean.valueOf(ck.Code(this.f).Code(this.f)), Float.valueOf(this.aj), Float.valueOf(this.ak), Integer.valueOf(this.ai), Integer.valueOf(this.ah));
        if (ck.Code(this.f).Code(this.f)) {
            int i = this.al;
            float f7 = i * 1.0f;
            if (F) {
                f5 = this.aj;
                int i2 = this.ah;
                this.ap = f7 / (i2 + f5);
                f4 = this.as[1] + ((i * 1.0f) / 2.0f);
                f6 = i2;
            } else {
                float f8 = this.aj;
                int i3 = this.ah;
                int i4 = this.ai;
                this.ap = f7 / ((i3 + f8) + i4);
                f4 = this.as[1] + ((i * 1.0f) / 2.0f);
                f5 = f8 + i3;
                f6 = i4;
            }
            f3 = f4 - (((f5 + f6) * 1.0f) / 2.0f);
        } else {
            int i5 = this.al;
            float f9 = i5 * 1.0f;
            if (F) {
                float f10 = this.aj;
                this.ap = f9 / f10;
                f2 = (this.as[1] + ((i5 * 1.0f) / 2.0f)) - ((f10 * 1.0f) / 2.0f);
            } else {
                int i6 = this.ai;
                float f11 = this.aj;
                this.ap = f9 / (i6 + f11);
                f2 = (this.as[1] + ((i5 * 1.0f) / 2.0f)) - (((f11 + i6) * 1.0f) / 2.0f);
            }
            f3 = f2 - this.ah;
        }
        this.aq = f3;
        this.ar = ((this.am * 1.0f) / this.ak) * 1.0f;
    }

    private void n() {
        DisplayMetrics displayMetrics = this.f.getResources().getDisplayMetrics();
        this.aj = displayMetrics.heightPixels;
        this.ak = displayMetrics.widthPixels;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        fb.V("PPSLinkedView", "switchViewOnAnimationEnd. ");
        Code(this.aK);
        if (fb.Code()) {
            fb.Code("PPSLinkedView", "isMoved: %s, linkedAdListener on switch: %s ", Boolean.valueOf(this.at), this.av);
        }
        if (this.av == null) {
            fb.I("PPSLinkedView", "linkedAdListener is null. ");
        } else {
            fb.Code("PPSLinkedView", "splash show end. ");
            this.av.V();
        }
    }

    private boolean p() {
        boolean q = q();
        boolean r = r();
        if (!q && !r) {
            return true;
        }
        fb.I("PPSLinkedView", "checkDestView, destView change null, linkedAdListener: %s, isMoved:%s. ", ay.V(this.av), Boolean.valueOf(this.at));
        fb.V("PPSLinkedView", "isDestViewNull:%s, isDestViewNotAvalible:%s", Boolean.valueOf(q), Boolean.valueOf(r));
        if (!this.aN) {
            this.aN = true;
            Z(-5);
            m mVar = this.av;
            if (mVar != null) {
                mVar.V();
            }
        }
        if (!this.at) {
            this.at = true;
            this.an = 0;
            TextureGlVideoView textureGlVideoView = this.y;
            if (textureGlVideoView != null) {
                textureGlVideoView.L();
                this.y.destroyView();
            }
            setPlaying(false);
            s();
            M();
            g gVar = this.q;
            if (gVar != null) {
                gVar.Code(this.aH);
            }
        }
        return false;
    }

    private boolean q() {
        PPSDestView pPSDestView = this.z;
        return pPSDestView == null || pPSDestView.getHeight() == 0 || this.z.getWidth() == 0;
    }

    private boolean r() {
        TextureGlVideoView textureGlVideoView = this.y;
        return textureGlVideoView == null || !textureGlVideoView.h();
    }

    private void s() {
        fb.V("PPSLinkedView", "removeSplashView");
        SplashLinkedVideoView splashLinkedVideoView = this.v;
        if (splashLinkedVideoView != null) {
            splashLinkedVideoView.setVisibility(8);
            this.v.V();
        }
        LinkedSurfaceView linkedSurfaceView = this.x;
        if (linkedSurfaceView != null) {
            linkedSurfaceView.Z();
            com.huawei.openalliance.ad.views.d dVar = this.w;
            if (dVar != null) {
                dVar.V(this.x);
            }
            this.x = null;
        }
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.18
            @Override // java.lang.Runnable
            public void run() {
                if (PPSLinkedView.this.v != null) {
                    if (PPSLinkedView.this.v.isAttachedToWindow()) {
                        PPSLinkedView.this.G.removeView(PPSLinkedView.this.v);
                    }
                    PPSLinkedView.this.v.I();
                    PPSLinkedView.this.v = null;
                }
            }
        }, 20L);
        PPSSplashProView pPSSplashProView = this.aQ;
        if (pPSSplashProView != null) {
            pPSSplashProView.Code();
        }
        PPSSplashSwipeView pPSSplashSwipeView = this.aR;
        if (pPSSplashSwipeView != null) {
            pPSSplashSwipeView.V();
        }
        ji jiVar = this.aT;
        if (jiVar != null) {
            jiVar.V();
        }
        jh jhVar = this.aU;
        if (jhVar != null) {
            jhVar.V();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        fb.V("PPSLinkedView", "startScaleDown. ");
        v();
        if (!p()) {
            if (this.au || this.ac == -1) {
                return;
            }
            this.p.Code(System.currentTimeMillis() - this.ac, 100);
            this.ac = -1L;
            return;
        }
        this.aD = true;
        m();
        this.v.setClickable(false);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.aE = ofFloat;
        ofFloat.setInterpolator(new eg(0.4f, 0.0f, 0.2f, 1.0f));
        this.aE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.19
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    float animatedFraction = (valueAnimator.getAnimatedFraction() * (PPSLinkedView.this.ap - 1.0f)) + 1.0f;
                    float animatedFraction2 = (valueAnimator.getAnimatedFraction() * (PPSLinkedView.this.ar - 1.0f)) + 1.0f;
                    PPSLinkedView.this.x.Code(animatedFraction, valueAnimator.getAnimatedFraction() * PPSLinkedView.this.aq, animatedFraction2, (int) (PPSLinkedView.this.ak * animatedFraction2), (int) (PPSLinkedView.this.aj * animatedFraction));
                } catch (Throwable th) {
                    fb.V("PPSLinkedView", "scaleAndTransAnimation err: %s", th.getClass().getSimpleName());
                }
            }
        });
        this.aE.addListener(new Animator.AnimatorListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.20
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LinkedSurfaceView linkedSurfaceView;
                float floatValue;
                float f2;
                int i;
                int i2;
                fb.V("PPSLinkedView", "onAnimationEnd");
                try {
                    if (PPSLinkedView.this.al > 0 && PPSLinkedView.this.o != null) {
                        if (PPSLinkedView.this.o.g().floatValue() < 1.0f) {
                            linkedSurfaceView = PPSLinkedView.this.x;
                            floatValue = (PPSLinkedView.this.am * 1.0f) / (PPSLinkedView.this.al * 1.0f);
                            f2 = (PPSLinkedView.this.am * 1.0f) / (PPSLinkedView.this.al * 1.0f);
                            i = PPSLinkedView.this.am;
                            i2 = PPSLinkedView.this.al;
                        } else {
                            linkedSurfaceView = PPSLinkedView.this.x;
                            floatValue = PPSLinkedView.this.o.g().floatValue();
                            f2 = (PPSLinkedView.this.am * 1.0f) / (PPSLinkedView.this.al * 1.0f);
                            i = PPSLinkedView.this.am;
                            i2 = PPSLinkedView.this.al;
                        }
                        linkedSurfaceView.Code(floatValue, f2, i, i2);
                    }
                    PPSLinkedView.this.o();
                    PPSLinkedView.this.an = 2;
                } catch (Throwable th) {
                    fb.V("PPSLinkedView", "onAnimationEnd err: %s", th.getClass().getSimpleName());
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                fb.V("PPSLinkedView", "onAnimationStart");
                if (PPSLinkedView.this.e != null) {
                    PPSLinkedView.this.e.setVisibility(8);
                }
                if (PPSLinkedView.this.K != null) {
                    PPSLinkedView.this.K.setVisibility(8);
                }
                if (PPSLinkedView.this.J != null) {
                    PPSLinkedView.this.J.setVisibility(8);
                }
                if (PPSLinkedView.this.i != null) {
                    PPSLinkedView.this.i.Code();
                    PPSLinkedView.this.i.setVisibility(8);
                }
                if (PPSLinkedView.this.h != null) {
                    PPSLinkedView.this.h.setVisibility(8);
                }
                if (PPSLinkedView.this.R != null) {
                    PPSLinkedView.this.R.setVisibility(8);
                }
                if (PPSLinkedView.this.aQ != null) {
                    PPSLinkedView.this.aQ.setVisibility(8);
                    PPSLinkedView.this.aQ.Code();
                }
                if (PPSLinkedView.this.aR != null) {
                    PPSLinkedView.this.aR.setVisibility(8);
                    PPSLinkedView.this.aR.V();
                }
                if (PPSLinkedView.this.aS != null) {
                    PPSLinkedView.this.aS.setVisibility(8);
                }
                if (PPSLinkedView.this.bi != null) {
                    PPSLinkedView.this.bi.setVisibility(8);
                }
                if (PPSLinkedView.this.bh != null) {
                    PPSLinkedView.this.bh.setVisibility(8);
                }
                if (PPSLinkedView.this.v != null) {
                    PPSLinkedView.this.v.setOnTouchListener(null);
                }
                if (PPSLinkedView.this.aT != null) {
                    PPSLinkedView.this.aT.V();
                }
                if (PPSLinkedView.this.aU != null) {
                    PPSLinkedView.this.aU.V();
                }
            }
        });
        this.aE.setDuration(1000L).start();
    }

    private void y() {
        int y = this.g.y();
        if (y > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aQ.getLayoutParams();
            int V = w.V(getContext(), y);
            this.aQ.setPadding(V, V, V, V);
            if (layoutParams.isMarginRelative()) {
                layoutParams.setMarginStart(layoutParams.leftMargin - V);
                layoutParams.setMarginEnd(layoutParams.rightMargin - V);
            } else {
                layoutParams.setMargins(layoutParams.leftMargin - V, layoutParams.topMargin, layoutParams.rightMargin - V, layoutParams.bottomMargin);
            }
            this.aQ.setLayoutParams(layoutParams);
        }
    }

    @Override // com.huawei.hms.ads.fq.a
    public void B() {
        fb.V("PPSLinkedView", "onViewShownBetweenFullAndPartial: ");
        if (this.y == null || this.H == null) {
            return;
        }
        fb.V("PPSLinkedView", "onViewShownBetweenFullAndPartial, start mute");
        this.H.D();
        this.H.e();
        VideoInfo videoInfo = this.o;
        if (videoInfo != null) {
            videoInfo.Code("n");
        }
    }

    public void D() {
        fb.V("PPSLinkedView", "unregister. ");
        H();
    }

    public SplashLinkedVideoView h() {
        return this.v;
    }

    public PPSLinkedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new gj();
        this.j = true;
        this.n = 1;
        this.M = true;
        this.U = 0;
        this.W = false;
        this.ac = -1L;
        this.ae = false;
        this.af = false;
        this.ag = x.ak + hashCode();
        this.ah = 0;
        this.ai = 0;
        this.ao = OxXXx0X.f13024OIII0O;
        this.as = new int[2];
        this.at = false;
        this.au = false;
        this.aw = false;
        this.ax = false;
        this.ay = false;
        this.az = false;
        this.aA = false;
        this.aB = false;
        this.aC = false;
        this.aD = false;
        this.aF = false;
        this.aG = false;
        this.aI = true;
        this.aK = true;
        this.aL = true;
        this.aM = false;
        this.aN = false;
        this.aO = 0;
        this.aP = "skip_btn_delay_id_" + hashCode();
        this.bj = false;
        this.bk = new com.huawei.openalliance.ad.media.listener.g() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.21
            @Override // com.huawei.openalliance.ad.media.listener.g
            public void Code() {
                fb.Code("PPSLinkedView", "onVideoRenderStart, alreadyNotified: %s", Boolean.valueOf(PPSLinkedView.this.aM));
                if (PPSLinkedView.this.aM) {
                    return;
                }
                PPSLinkedView.this.aM = true;
                PPSLinkedView.this.x();
            }
        };
        this.bl = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.22
            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i2) {
                fb.V("PPSLinkedView", "onMediaCompletion: %s", Integer.valueOf(i2));
                PPSLinkedView.this.Code(i2, true);
                PPSLinkedView.this.bj = true;
                if (PPSLinkedView.this.an == 2 && PPSLinkedView.this.k != null && PPSLinkedView.this.k.F()) {
                    fb.V("PPSLinkedView", "onMediaCompletion, start play");
                    PPSLinkedView.this.H.V();
                    PPSLinkedView.this.setPlaying(true);
                }
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.Z(i2);
                }
                if (PPSLinkedView.this.p != null) {
                    long j = i2;
                    PPSLinkedView.this.p.Code(PPSLinkedView.this.f, j, j);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i2) {
                fb.V("PPSLinkedView", "onMediaPause: %s", Integer.valueOf(i2));
                PPSLinkedView.this.Code(i2, false);
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.V(i2);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i2) {
                fb.V("PPSLinkedView", "onMediaStart: %s", Integer.valueOf(i2));
                PPSLinkedView.this.W = true;
                PPSLinkedView.this.setPlaying(true);
                PPSLinkedView.this.ad = i2;
                PPSLinkedView.this.ab = System.currentTimeMillis();
                if (!PPSLinkedView.this.at) {
                    PPSLinkedView.this.w();
                    PPSLinkedView.this.i();
                }
                if (i2 > 0) {
                    PPSLinkedView.this.p.L();
                    PPSLinkedView.this.c.f();
                } else {
                    PPSLinkedView.this.p.D();
                    if (PPSLinkedView.this.c != null && PPSLinkedView.this.o != null) {
                        fb.V("PPSLinkedView", "om start");
                        PPSLinkedView.this.c.Code(PPSLinkedView.this.o.I(), !"y".equals(PPSLinkedView.this.o.a()));
                    }
                }
                if (PPSLinkedView.this.l != null && PPSLinkedView.this.l.I()) {
                    cy.Code(PPSLinkedView.this.f, PPSLinkedView.this.l.o(), PPSLinkedView.this.l.a(), (System.currentTimeMillis() - PPSLinkedView.this.g.Q().longValue()) - PPSLinkedView.this.g.R(), PPSLinkedView.this.l.n(), "84");
                }
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.Code(i2);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i2) {
                fb.V("PPSLinkedView", "onMediaStop: %s", Integer.valueOf(i2));
                PPSLinkedView.this.Code(i2, false);
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.I(i2);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onProgress(int i2, int i22) {
                if (i22 > 0 && !PPSLinkedView.this.aM) {
                    fb.Code("PPSLinkedView", "onProgress onRenderStart, playtime: %s", Integer.valueOf(i22));
                    PPSLinkedView.this.aM = true;
                    PPSLinkedView.this.x();
                }
                if (i22 > 0) {
                    PPSLinkedView.this.o.Code(i22);
                    PPSLinkedView.this.setPlaying(true);
                }
                if (PPSLinkedView.this.t != null) {
                    PPSLinkedView.this.t.Code(i2, i22);
                }
                if (PPSLinkedView.this.W) {
                    PPSLinkedView.this.c.Code(i2);
                }
                if (PPSLinkedView.this.p != null) {
                    PPSLinkedView.this.p.Code(PPSLinkedView.this.f, i22, PPSLinkedView.this.o == null ? 0L : PPSLinkedView.this.o.I());
                }
            }
        };
        this.bm = new com.huawei.openalliance.ad.media.listener.h() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.2
            @Override // com.huawei.openalliance.ad.media.listener.h
            public void Code(long j) {
                if (fb.Code()) {
                    fb.Code("PPSLinkedView", "reportVideoTime: %s", Long.valueOf(j));
                }
                if (PPSLinkedView.this.p != null) {
                    PPSLinkedView.this.p.Code(PPSLinkedView.this.getContext(), j);
                }
            }
        };
        this.bn = new com.huawei.openalliance.ad.media.listener.d() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.3
            @Override // com.huawei.openalliance.ad.media.listener.d
            public void Code(int i2) {
                fb.V("PPSLinkedView", "onDurationReady:");
                if (!PPSLinkedView.this.aG && PPSLinkedView.this.s != null) {
                    PPSLinkedView.this.aG = true;
                    PPSLinkedView.this.s.Code();
                }
                if (PPSLinkedView.this.aJ == null) {
                    PPSLinkedView.this.aJ = Integer.valueOf(i2);
                    if (PPSLinkedView.this.l == null || PPSLinkedView.this.l.C() == null) {
                        return;
                    }
                    PPSLinkedView.this.l.C().V(i2);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.d
            public void V(int i2) {
            }
        };
        this.bo = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i2;
                if (PPSLinkedView.this.j) {
                    if (PPSLinkedView.this.an == 1) {
                        PPSLinkedView pPSLinkedView = PPSLinkedView.this;
                        if (!pPSLinkedView.Code(pPSLinkedView.d)) {
                            return;
                        }
                    }
                    PPSLinkedView.this.j = false;
                    fb.V("PPSLinkedView", "onClick");
                    if (PPSLinkedView.this.an == 2) {
                        i2 = 10;
                    } else {
                        i2 = 2 == PPSLinkedView.this.aQ.getMode() ? 17 : 9;
                        PPSLinkedView.this.m();
                    }
                    PPSLinkedView.this.I(i2);
                    bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PPSLinkedView.this.j = true;
                        }
                    }, 500L);
                }
            }
        };
        this.bp = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.5
            private float I;
            private float V;

            private boolean Code(float f2, float f3) {
                if (PPSLinkedView.this.bg != 0 || f3 < PPSLinkedView.this.bc) {
                    return 1 == PPSLinkedView.this.bg && Math.sqrt((double) ((f2 * f2) + (f3 * f3))) >= ((double) PPSLinkedView.this.bc);
                }
                return true;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.V = motionEvent.getX();
                    this.I = motionEvent.getY();
                    if (fb.Code()) {
                        fb.Code("PPSLinkedView", "startX = %s, startY = %s", Float.valueOf(this.V), Float.valueOf(this.I));
                    }
                    PPSLinkedView.this.d = jo.Code(view, motionEvent);
                }
                if (2 == motionEvent.getAction()) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    if (fb.Code()) {
                        fb.Code("PPSLinkedView", "endX = %s, endY = %s, startX - endX = %s, startY-endY = %s", Float.valueOf(x), Float.valueOf(y), Float.valueOf(this.V - x), Float.valueOf(this.I - y));
                    }
                    if (Code(this.V - x, this.I - y)) {
                        jo.Code(view, motionEvent, x.de, PPSLinkedView.this.d);
                        PPSLinkedView.this.v.setOnTouchListener(null);
                        PPSLinkedView.this.I(18);
                    }
                }
                return true;
            }
        };
        this.br = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.setEnabled(false);
                PPSLinkedView.this.v.setOnTouchListener(null);
                if (motionEvent.getAction() != 0) {
                    return true;
                }
                PPSLinkedView.this.d = com.huawei.openalliance.ad.utils.k.Code(view, motionEvent);
                if (PPSLinkedView.this.d != null) {
                    PPSLinkedView.this.d.V(x.dd);
                    PPSLinkedView.this.d.Code(Float.valueOf(com.huawei.openalliance.ad.utils.d.a(view.getContext())));
                }
                PPSLinkedView.this.I(17);
                return true;
            }
        };
        this.bs = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    PPSLinkedView.this.d = jo.Code(view, motionEvent);
                }
                if (1 != motionEvent.getAction()) {
                    return false;
                }
                jo.Code(view, motionEvent, null, PPSLinkedView.this.d);
                return false;
            }
        };
        this.bt = new com.huawei.openalliance.ad.media.listener.c() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.9
            @Override // com.huawei.openalliance.ad.media.listener.c
            public void Code(MediaPlayerAgent mediaPlayerAgent, int i2, int i22, int i3) {
                fb.I("PPSLinkedView", "media play error, isMoved: %s", Boolean.valueOf(PPSLinkedView.this.at));
                PPSLinkedView.this.E();
                PPSLinkedView.this.G();
                PPSLinkedView.this.setPlaying(false);
                if (PPSLinkedView.this.t != null) {
                    fb.V("PPSLinkedView", "call onMediaError. ");
                    PPSLinkedView.this.t.Code(i2, i22, i3);
                }
            }
        };
        this.bu = new com.huawei.openalliance.ad.media.listener.f() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.10
            @Override // com.huawei.openalliance.ad.media.listener.f
            public void Code() {
                fb.V("PPSLinkedView", "onMute");
                if (PPSLinkedView.this.u != null) {
                    PPSLinkedView.this.u.Code();
                }
                PPSLinkedView.this.c.V(0.0f);
            }

            @Override // com.huawei.openalliance.ad.media.listener.f
            public void V() {
                fb.V("PPSLinkedView", "onUnmute");
                if (PPSLinkedView.this.u != null) {
                    PPSLinkedView.this.u.V();
                }
                PPSLinkedView.this.c.V(1.0f);
            }
        };
        this.bv = new com.huawei.openalliance.ad.media.listener.b() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.11
            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code() {
                PPSLinkedView.this.c.b();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void V() {
                PPSLinkedView.this.c.c();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code(int i2) {
            }
        };
        this.bw = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PPSLinkedView.this.V(!view.isSelected());
            }
        };
        V(context);
    }

    private void B(int i) {
        String str;
        String str2;
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        k kVar = this.l;
        if (kVar != null) {
            str = kVar.q();
            str2 = this.l.o();
            AdContentData adContentData = new AdContentData();
            adContentData.B(this.l.a());
            adContentData.D(this.l.q());
            analysisEventReport.Code(adContentData);
        } else {
            str = null;
            str2 = null;
        }
        analysisEventReport.Code(i);
        analysisEventReport.I(str);
        analysisEventReport.Z(str2);
        com.huawei.openalliance.ad.ipc.g.V(this.f).Code("rptSplashFailedEvt", aa.V(analysisEventReport), null, null);
    }

    private String Z(InteractCfg interactCfg) {
        if (interactCfg != null) {
            return interactCfg.L();
        }
        return null;
    }

    @Override // com.huawei.hms.ads.fq.a
    public void Z() {
        fb.V("PPSLinkedView", "onViewPartialHidden: ");
        if (this.y == null || this.H == null) {
            return;
        }
        fb.V("PPSLinkedView", "onViewPartialHidden, start pause");
        this.H.D();
        VideoInfo videoInfo = this.o;
        if (videoInfo != null) {
            videoInfo.Code("n");
        }
        this.H.Z();
        this.H.e();
        setPlaying(false);
    }

    private String I(InteractCfg interactCfg) {
        if (interactCfg != null) {
            return interactCfg.D();
        }
        return null;
    }

    private void Z(int i) {
        m mVar = this.av;
        if (mVar != null) {
            mVar.Code(i);
        }
        B(i);
    }

    @Override // com.huawei.hms.ads.fq.a
    public void I() {
        VideoInfo videoInfo;
        MediaPlayerAgent mediaPlayerAgent;
        long j;
        fb.V("PPSLinkedView", "onViewFullShown: ");
        if (this.y == null || (videoInfo = this.o) == null || this.H == null) {
            return;
        }
        int L = videoInfo.L();
        if (O()) {
            return;
        }
        fb.V("PPSLinkedView", "onViewFullShown, start play, duration: %s, playProgress: %s", this.aJ, Integer.valueOf(L));
        this.H.I(L);
        this.H.V();
        setPlaying(true);
        Integer num = this.aJ;
        if (num == null || Math.abs(num.intValue() - L) >= 1000) {
            mediaPlayerAgent = this.H;
            j = L;
        } else {
            fb.V("PPSLinkedView", "onViewFullShown, seek to 0");
            mediaPlayerAgent = this.H;
            j = 0;
        }
        mediaPlayerAgent.Code(j, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(int i) {
        e eVar;
        ev.Code(getContext()).Code(new b(this));
        Code(this.an);
        if (this.p.Code(i, this.d)) {
            v();
            if (18 == i) {
                Context context = this.bf.get();
                if (context instanceof Activity) {
                    ((Activity) context).overridePendingTransition(R.anim.hiad_open, R.anim.hiad_close);
                }
            }
        }
        this.d = null;
        this.c.Code(hr.CLICK);
        int i2 = this.an;
        int i3 = 1;
        if (i2 == 1) {
            this.aH = 3;
            eVar = this.r;
            if (eVar == null) {
                return;
            }
        } else {
            i3 = 2;
            if (i2 != 2) {
                return;
            }
            this.aH = 4;
            eVar = this.r;
            if (eVar == null) {
                return;
            }
        }
        eVar.Code(i3);
    }

    private String V(InteractCfg interactCfg) {
        if (interactCfg != null) {
            return interactCfg.F();
        }
        return null;
    }

    private Integer Code(Integer num, int i) {
        fb.V("PPSLinkedView", "initial mode: %s", num);
        if (i == 0) {
            return null;
        }
        int w = num == null ? this.g.w() : num.intValue();
        if (w == 0) {
            return Integer.valueOf(w);
        }
        Map<String, String> Code = aa.Code(ed.Code(getContext()).ah());
        if (Code != null) {
            if ((2 == w || 3 == w) && Code(ay.I(Code.get(x.ct)))) {
                w = 4;
            }
            if ((1 == w || 4 == w) && Code(ay.I(Code.get(x.cs)))) {
                return 0;
            }
        }
        if (1 != getResources().getConfiguration().orientation || 2 != i) {
            return 0;
        }
        if (!V(w)) {
            return Integer.valueOf(w);
        }
        fb.V("PPSLinkedView", "can't use twist, enable : %s", Boolean.valueOf(this.g.f()));
        return 0;
    }

    private String V(InteractCfg interactCfg, String str) {
        return !TextUtils.isEmpty(str) ? str : (interactCfg == null || interactCfg.a() == null) ? this.g.E() : interactCfg.a();
    }

    private String Code(InteractCfg interactCfg) {
        if (interactCfg != null) {
            return interactCfg.S();
        }
        return null;
    }

    private String V(AdContentData adContentData) {
        String Code = com.huawei.openalliance.ad.utils.c.Code(getContext(), adContentData, 0);
        return !TextUtils.isEmpty(Code) ? Code : !TextUtils.isEmpty(this.g.x()) ? this.g.x() : adContentData.av();
    }

    private String Code(InteractCfg interactCfg, String str) {
        return !TextUtils.isEmpty(str) ? str : (interactCfg == null || interactCfg.a() == null) ? this.g.z() : interactCfg.a();
    }

    @Override // com.huawei.hms.ads.fq.a
    public void V() {
        k kVar;
        fb.V("PPSLinkedView", "onViewPhysicalShowStart");
        if (!this.at || (kVar = this.l) == null || kVar.aH()) {
            return;
        }
        w();
        i();
    }

    @Override // com.huawei.hms.ads.fq.a
    public void Code() {
        fb.V("PPSLinkedView", "onViewShowStartRecord");
        k kVar = this.l;
        if (kVar == null || !this.at) {
            return;
        }
        fb.Code("PPSLinkedView", "ad.getMinEffectiveShowTime: %s. ", Long.valueOf(kVar.u()));
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.1
            @Override // java.lang.Runnable
            public void run() {
                PPSLinkedView pPSLinkedView;
                Long valueOf;
                Integer valueOf2;
                int i;
                k kVar2 = PPSLinkedView.this.l;
                if (kVar2 != null) {
                    if (PPSLinkedView.this.an == 2) {
                        pPSLinkedView = PPSLinkedView.this;
                        valueOf = Long.valueOf(kVar2.u());
                        valueOf2 = Integer.valueOf(PPSLinkedView.this.k.B());
                        i = 9;
                    } else {
                        pPSLinkedView = PPSLinkedView.this;
                        valueOf = Long.valueOf(kVar2.u());
                        valueOf2 = Integer.valueOf(PPSLinkedView.this.k.B());
                        i = 8;
                    }
                    pPSLinkedView.Code(valueOf, valueOf2, Integer.valueOf(i), false);
                }
            }
        }, this.ag, kVar.u());
    }

    @Override // com.huawei.hms.ads.fq.a
    public void V(long j, int i) {
        fb.V("PPSLinkedView", "onViewPhysicalShowEnd: ");
        bf.Code(this.ag);
        k kVar = this.l;
        if (kVar != null) {
            kVar.F(false);
        }
        if (this.y != null) {
            fb.V("PPSLinkedView", "onViewPhysicalShowEnd, start pause. ");
            this.H.Z();
            this.H.e();
            setPlaying(false);
        }
        fb.Code("PPSLinkedView", "onViewPhysicalShowEnd, noPhyImp: %s. ", Boolean.valueOf(this.au));
        if (this.au || i <= 0) {
            return;
        }
        fb.Code("PPSLinkedView", "report phyImp. ");
        if (this.ac == -1) {
            this.p.Code(j, i);
        } else {
            this.p.Code(System.currentTimeMillis() - this.ac, i);
            this.ac = -1L;
        }
    }

    private void Code(int i) {
        int i2;
        if (i == 1) {
            i2 = 12;
        } else if (i != 2) {
            return;
        } else {
            i2 = 13;
        }
        Code(Integer.valueOf(i2), true);
    }

    private void V(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f = applicationContext;
        this.g = ed.Code(applicationContext);
        this.p = new id(this.f, this);
        this.G = (WindowManager) context.getSystemService("window");
        this.aL = ck.Code(this.f).V();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(int i, boolean z) {
        VideoInfo videoInfo = this.o;
        if (videoInfo != null) {
            videoInfo.Code(z ? 0 : i);
        }
        if (this.W) {
            this.W = false;
            ip ipVar = this.p;
            long j = this.ab;
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = this.ad;
            long j3 = i;
            if (z) {
                ipVar.Code(j, currentTimeMillis, j2, j3);
                this.c.a();
            } else {
                ipVar.V(j, currentTimeMillis, j2, j3);
                this.c.e();
            }
        }
        setPlaying(false);
    }

    private void V(k kVar) {
        fb.V("PPSLinkedView", "LinkedSplashAd:%s, isChinaRom:%s", kVar, Boolean.valueOf(this.aL));
        if (kVar != null) {
            Integer Z = Z(kVar.aJ());
            InteractCfg aA = kVar.aJ().aA();
            Integer B = aA == null ? null : aA.B();
            if (this.aL) {
                this.i.setAdMediator(this.m);
                this.i.Code(this, Z, B, w.Code(true, kVar.aa(), kVar.Y()));
                this.i.setVisibility(0);
                this.i.Code(kVar.aJ(), false, this.ah, 1, false);
                return;
            }
            this.h.setPpsLinkedView(this);
            this.h.Code(Z, B);
            this.h.setVisibility(0);
            this.h.Code(kVar.aJ(), false, this.ah, 1, false);
            if (ad.Code(kVar.aL())) {
                return;
            }
            this.h.setChoiceViewOnClickListener(new a(this, kVar.aJ()));
        }
    }

    private void V(List<View> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : list) {
            if (view != null) {
                view.setOnClickListener(this.bo);
            }
        }
    }

    @Override // com.huawei.hms.ads.fq.a
    public void Code(long j, int i) {
        fb.V("PPSLinkedView", "onViewShowEndRecord");
        bf.Code(this.ag);
        if (!this.k.Code(j) || this.af) {
            return;
        }
        this.af = true;
        Code(Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.an == 2 ? 9 : 8), false);
    }

    private void Code(AdContentData adContentData) {
        if (adContentData.aA() == null) {
            this.bc = ed.Code(getContext()).A();
            this.be = ed.Code(getContext()).H();
            this.bd = ed.Code(getContext()).G();
        } else {
            InteractCfg aA = adContentData.aA();
            this.bc = (aA.V() == null || aA.V().intValue() <= 0) ? ed.Code(getContext()).A() : aA.V().intValue();
            this.be = (aA.I() == null || aA.I().intValue() <= 0) ? ed.Code(getContext()).H() : aA.I().intValue();
            this.bd = (aA.Z() == null || aA.Z().intValue() <= 0) ? ed.Code(getContext()).G() : aA.Z().intValue();
            this.bg = aA.C().intValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(boolean z) {
        MediaPlayerAgent mediaPlayerAgent;
        VideoInfo videoInfo;
        String str;
        fb.V("PPSLinkedView", "switchSound enableSound: " + z);
        if (this.x == null || (mediaPlayerAgent = this.H) == null) {
            return;
        }
        if (z) {
            mediaPlayerAgent.L();
            this.K.setSelected(true);
            videoInfo = this.o;
            if (videoInfo != null) {
                str = "y";
                videoInfo.Code(str);
            }
            this.p.V(!z);
        }
        mediaPlayerAgent.D();
        this.K.setSelected(false);
        videoInfo = this.o;
        if (videoInfo != null) {
            str = "n";
            videoInfo.Code(str);
        }
        this.p.V(!z);
    }

    private void Code(AdContentData adContentData, int i) {
        y();
        this.aQ.setVisibility(4);
        this.aQ.setDesc(V(adContentData));
        this.aQ.Code(false, i);
        if (i != 0) {
            this.aQ.setVisibility(0);
        }
        this.v.setOnTouchListener(this.bs);
    }

    private boolean V(int i) {
        if (2 != i && 3 != i) {
            return false;
        }
        if (this.g.f()) {
            return !n.Z(getContext().getApplicationContext());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(AdContentData adContentData, int[] iArr, int[] iArr2) {
        if (w.Code(iArr, 2) && w.Code(iArr2, 2) && adContentData != null) {
            if (fb.Code()) {
                fb.Code("PPSLinkedView", "addComplianceDialog, loc: %s, %s", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
                fb.Code("PPSLinkedView", "addComplianceDialog, size: %s, %s", Integer.valueOf(iArr2[0]), Integer.valueOf(iArr2[1]));
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            PPSAdvertiserInfoDialog pPSAdvertiserInfoDialog = new PPSAdvertiserInfoDialog(getContext(), iArr, iArr2);
            this.e = pPSAdvertiserInfoDialog;
            this.v.addView(pPSAdvertiserInfoDialog, layoutParams);
            this.e.setScreenWidth(this.v.getMeasuredWidth());
            this.e.setScreenHeight(this.v.getMeasuredHeight());
            this.e.setAdContent(adContentData);
        }
    }

    private void Code(k kVar) {
        AdContentData aJ;
        Integer Z;
        if (this.aQ == null || kVar == null || (aJ = kVar.aJ()) == null) {
            return;
        }
        int C = ja.C(aJ.v());
        int S = ja.S(aJ.v());
        fb.V("PPSLinkedView", "set splashpro mode:" + C);
        if (C == 0 || (Z = Z(aJ)) == null) {
            this.aQ.setVisibility(8);
        } else if (Z.intValue() == 0) {
            Code(aJ, S);
        } else {
            Code(aJ);
            Code(false, Z.intValue(), aJ);
        }
        this.aQ.setMode(C);
    }

    public void Code(Integer num, boolean z) {
        fb.Code("PPSLinkedView", "reportSplashAdShowEvent. ");
        Code(Long.valueOf(System.currentTimeMillis() - this.ab), (Integer) 100, num, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(Long l, Integer num, Integer num2, boolean z) {
        fb.Code("PPSLinkedView", "reportAdShowEvent. ");
        k kVar = this.l;
        if (kVar == null) {
            return;
        }
        boolean Code = com.huawei.openalliance.ad.utils.c.Code(kVar.F(), num2);
        if (!this.l.aB() || (Code && !this.l.X())) {
            if (!this.g.k()) {
                this.l.C(true);
                this.p.Code((Long) null, (Integer) null, num2, z);
            } else if (z || l.longValue() >= this.l.u()) {
                this.l.C(true);
                fb.Code("PPSLinkedView", "report imp. ");
                this.p.Code(l, num, num2, z);
            }
            if (Code) {
                this.l.B(true);
            }
            this.c.D();
        }
    }

    private void Code(boolean z) {
        fb.V("PPSLinkedView", "moveLinkedView");
        if (p() && !this.at) {
            s();
            g gVar = this.q;
            if (gVar != null) {
                gVar.Code(this.aH);
            }
            if (z) {
                t();
            }
            this.at = true;
        }
    }

    private void Code(boolean z, int i, AdContentData adContentData) {
        PPSSplashSwipeClickView pPSSplashSwipeClickView;
        this.v.setOnClickListener(null);
        InteractCfg aA = adContentData.aA();
        String Code = com.huawei.openalliance.ad.utils.c.Code(getContext(), adContentData, i);
        if (1 == i) {
            PPSSplashSwipeView pPSSplashSwipeView = this.aR;
            if (pPSSplashSwipeView == null) {
                return;
            }
            pPSSplashSwipeView.setVisibility(4);
            this.aR.Code(Code(aA), Code(aA, Code));
            this.aR.setShowLogo(z);
            this.aR.setVisibility(0);
            this.v.setOnTouchListener(this.bp);
            return;
        }
        if (2 == i) {
            PPSSplashTwistView pPSSplashTwistView = this.aS;
            if (pPSSplashTwistView == null) {
                return;
            }
            pPSSplashTwistView.setVisibility(4);
            this.aS.Code(V(aA), V(aA, Code));
            this.aS.setShowLogo(z);
            this.aS.setVisibility(0);
            this.v.setOnTouchListener(bq);
            z();
            return;
        }
        if (3 != i) {
            if (4 != i || (pPSSplashSwipeClickView = this.bh) == null) {
                return;
            }
            pPSSplashSwipeClickView.setVisibility(4);
            this.bh.Code(I(aA), Code(aA, Code));
            this.bh.setShowLogo(z);
            this.bh.setVisibility(0);
            this.v.setOnTouchListener(this.bp);
            this.bh.getClickAreaView().setOnTouchListener(this.br);
            return;
        }
        PPSSplashTwistClickView pPSSplashTwistClickView = this.bi;
        if (pPSSplashTwistClickView == null) {
            return;
        }
        pPSSplashTwistClickView.setVisibility(4);
        this.bi.Code(Z(aA), V(aA, Code));
        this.bi.setShowLogo(z);
        this.bi.setVisibility(0);
        this.v.setOnTouchListener(bq);
        this.bi.getClickAreaView().setOnTouchListener(this.br);
        z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Code(MaterialClickInfo materialClickInfo) {
        PPSSplashProView pPSSplashProView = this.aQ;
        if (pPSSplashProView != null && materialClickInfo != null) {
            int mode = pPSSplashProView.getMode();
            if (fb.Code()) {
                fb.Code("PPSLinkedView", "splashpro mode:" + mode);
            }
            if (1 != mode && mode != 0) {
                Rect rect = new Rect();
                this.aQ.getHitRect(rect);
                boolean contains = rect.contains(materialClickInfo.Code().intValue(), materialClickInfo.V().intValue());
                fb.V("PPSLinkedView", "check result:" + contains);
                return contains;
            }
        }
        return true;
    }

    private boolean Code(Long l) {
        if (l == null) {
            return false;
        }
        long ag = ed.Code(getContext()).ag();
        return ag == -1 || System.currentTimeMillis() < (ag * 86400000) + l.longValue();
    }
}
