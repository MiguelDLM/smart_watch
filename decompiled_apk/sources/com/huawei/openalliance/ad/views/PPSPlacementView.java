package com.huawei.openalliance.ad.views;

import O0xOxO.Oxx0IOOO;
import android.content.Context;
import android.content.Intent;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.alimm.tanx.core.request.TanxError;
import com.google.android.exoplayer2.I0Io;
import com.google.android.exoplayer2.util.MimeTypes;
import com.huawei.hms.ads.Cif;
import com.huawei.hms.ads.cj;
import com.huawei.hms.ads.ed;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.fo;
import com.huawei.hms.ads.fp;
import com.huawei.hms.ads.gj;
import com.huawei.hms.ads.gv;
import com.huawei.hms.ads.hf;
import com.huawei.hms.ads.hg;
import com.huawei.hms.ads.hr;
import com.huawei.hms.ads.ht;
import com.huawei.hms.ads.hu;
import com.huawei.hms.ads.is;
import com.huawei.hms.ads.iz;
import com.huawei.hms.ads.jo;
import com.huawei.hms.ads.jp;
import com.huawei.hms.ads.kj;
import com.huawei.hms.ads.ko;
import com.huawei.hms.ads.kp;
import com.huawei.hms.ads.kw;
import com.huawei.openalliance.ad.activity.ComplianceActivity;
import com.huawei.openalliance.ad.constant.bm;
import com.huawei.openalliance.ad.constant.bq;
import com.huawei.openalliance.ad.constant.ca;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.inter.data.n;
import com.huawei.openalliance.ad.inter.data.p;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.bf;
import com.huawei.openalliance.ad.utils.bh;
import com.huawei.openalliance.ad.utils.q;
import com.huawei.openalliance.ad.utils.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes10.dex */
public class PPSPlacementView extends AutoScaleSizeRelativeLayout implements fo, kj, kw, com.huawei.openalliance.ad.media.listener.f, com.huawei.openalliance.ad.media.listener.i {
    int B;
    protected gv Code;
    private boolean D;
    private ImageView E;
    private MaterialClickInfo F;
    private boolean G;
    private boolean H;
    protected gv I;
    private boolean J;
    private boolean K;
    private is L;
    private MaterialClickInfo M;
    private List<View> N;
    private boolean O;
    private long P;
    private com.huawei.openalliance.ad.media.listener.e Q;
    private int R;
    private boolean T;
    private AudioManager U;
    protected gv V;
    private Object W;

    /* renamed from: a, reason: collision with root package name */
    private fp f17426a;
    private bq aa;
    private com.huawei.openalliance.ad.media.listener.g ab;
    private Handler ac;
    private com.huawei.openalliance.ad.media.listener.i ad;
    private View.OnTouchListener ae;
    private View.OnClickListener af;
    private AudioManager.OnAudioFocusChangeListener ag;
    private List<n> b;
    private n c;
    private n d;
    private int e;
    private a f;
    private List<View> g;
    private boolean h;
    private boolean i;
    private PlacementMediaView j;
    private PlacementMediaView k;
    private PlacementMediaView l;
    private com.huawei.openalliance.ad.media.listener.b m;
    private com.huawei.openalliance.ad.media.listener.f n;
    private com.huawei.openalliance.ad.media.listener.c o;
    private kp p;
    private ko q;
    private int[] r;
    private PlacementMediaView s;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private boolean x;
    private boolean y;
    private int z;

    /* loaded from: classes10.dex */
    public interface a {
        void Code();
    }

    /* loaded from: classes10.dex */
    public static class b implements AudioManager.OnAudioFocusChangeListener {
        private WeakReference<PPSPlacementView> Code;

        public b(PPSPlacementView pPSPlacementView) {
            this.Code = new WeakReference<>(pPSPlacementView);
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.b.1
                @Override // java.lang.Runnable
                public void run() {
                    PPSPlacementView pPSPlacementView = (PPSPlacementView) b.this.Code.get();
                    if (pPSPlacementView == null) {
                        return;
                    }
                    fb.V("PPSPlacementView", "onAudioFocusChange %d previous: %d", Integer.valueOf(i), Integer.valueOf(pPSPlacementView.R));
                    int i2 = i;
                    if (i2 == -3) {
                        b.this.V(pPSPlacementView);
                    } else if (i2 == -2 || i2 == -1) {
                        b.this.Code(pPSPlacementView);
                    } else if (i2 == 1 || i2 == 2) {
                        b.this.I(pPSPlacementView);
                    }
                    pPSPlacementView.R = i;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void I(PPSPlacementView pPSPlacementView) {
            fb.V("PPSPlacementView", "handleAudioFocusGain.");
            if (!pPSPlacementView.T || pPSPlacementView.s == null) {
                return;
            }
            pPSPlacementView.s.B();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void V(PPSPlacementView pPSPlacementView) {
            fb.V("PPSPlacementView", "handleAudioFocusLossTransientCanDuck soundMuted: " + pPSPlacementView.t);
            if (pPSPlacementView.t || pPSPlacementView.s == null) {
                return;
            }
            pPSPlacementView.s.I();
            pPSPlacementView.T = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Code(PPSPlacementView pPSPlacementView) {
            V(pPSPlacementView);
        }
    }

    public PPSPlacementView(Context context) {
        super(context);
        this.D = true;
        this.Code = new gj();
        this.V = new gj();
        this.I = new gj();
        this.b = new ArrayList(4);
        this.e = 0;
        this.h = false;
        this.i = false;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.t = false;
        this.u = false;
        this.v = -1;
        this.w = -1;
        this.x = false;
        this.y = false;
        this.z = -1;
        this.E = null;
        this.G = false;
        this.H = false;
        this.J = false;
        this.K = false;
        this.R = 0;
        this.T = false;
        this.B = -1;
        this.aa = new bq();
        this.ab = new com.huawei.openalliance.ad.media.listener.g() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.1
            @Override // com.huawei.openalliance.ad.media.listener.g
            public void Code() {
                fb.V("PPSPlacementView", "videoRenderStart");
                PPSPlacementView.this.k();
                if (!PPSPlacementView.this.H || PPSPlacementView.this.p == null) {
                    return;
                }
                PPSPlacementView.this.H = false;
                PPSPlacementView.this.J = true;
                fb.V("PPSPlacementView", "onMediaStart callback, playTime: %s", Integer.valueOf(PPSPlacementView.this.v));
                PPSPlacementView.this.p.Code(PPSPlacementView.this.v);
                PPSPlacementView.this.l();
            }
        };
        this.ac = new Handler(Looper.myLooper(), new Handler.Callback() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.12
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int i;
                n currentAd = PPSPlacementView.this.getCurrentAd();
                p currentMediaFile = PPSPlacementView.this.getCurrentMediaFile();
                String str = "";
                String a2 = currentAd != null ? currentAd.a() : "";
                if (currentMediaFile != null) {
                    str = currentMediaFile.Z();
                    i = (int) currentMediaFile.d();
                } else {
                    i = 0;
                }
                fb.V("PPSPlacementView", "callback timeout: %s", a2);
                if (PPSPlacementView.this.s != null) {
                    fb.V("PPSPlacementView", "notify Error");
                    PPSPlacementView.this.B(a2, str, i);
                }
                return true;
            }
        });
        this.ad = new com.huawei.openalliance.ad.media.listener.i() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.17
            @Override // com.huawei.openalliance.ad.media.listener.i
            public void Code(String str, String str2, int i) {
                PPSPlacementView pPSPlacementView;
                gv gvVar;
                gv gvVar2;
                if (fb.Code()) {
                    fb.Code("PPSPlacementView", "OM onSegmentMediaStart");
                }
                PPSPlacementView.this.O = false;
                if (PPSPlacementView.this.s instanceof PlacementVideoView) {
                    boolean V = PPSPlacementView.this.aa.V(bq.a.SINGLE_INST);
                    if (i > 0) {
                        if (V) {
                            gvVar2 = PPSPlacementView.this.I;
                        } else {
                            gvVar2 = PPSPlacementView.this.aa.V(bq.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V;
                        }
                        gvVar2.f();
                        return;
                    }
                    if (V) {
                        pPSPlacementView = PPSPlacementView.this;
                        gvVar = pPSPlacementView.I;
                    } else if (PPSPlacementView.this.aa.V(bq.a.MAIN_VIEW)) {
                        pPSPlacementView = PPSPlacementView.this;
                        gvVar = pPSPlacementView.Code;
                    } else {
                        pPSPlacementView = PPSPlacementView.this;
                        gvVar = pPSPlacementView.V;
                    }
                    pPSPlacementView.Code(gvVar);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.i
            public void I(String str, String str2, int i) {
                if (fb.Code()) {
                    fb.Code("PPSPlacementView", "OM onSegmentMediaStop");
                }
                if (str != null && !str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) {
                    fb.V("PPSPlacementView", "OM onSegmentMediaStop not equals");
                } else {
                    if (PPSPlacementView.this.O) {
                        return;
                    }
                    PPSPlacementView.this.O = true;
                    if (PPSPlacementView.this.s instanceof PlacementVideoView) {
                        (PPSPlacementView.this.aa.V(bq.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.aa.V(bq.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).a();
                    }
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.i
            public void V(String str, String str2, int i) {
                if (fb.Code()) {
                    fb.Code("PPSPlacementView", "OM onSegmentMediaPause");
                }
                if ((str == null || str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) && (PPSPlacementView.this.s instanceof PlacementVideoView)) {
                    (PPSPlacementView.this.aa.V(bq.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.aa.V(bq.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).e();
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.i
            public void Z(String str, String str2, int i) {
                if (fb.Code()) {
                    fb.Code("PPSPlacementView", "OM onSegmentMediaCompletion");
                }
                if (str != null && !str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) {
                    fb.V("PPSPlacementView", "OM onSegmentMediaCompletion not equals");
                } else {
                    if (PPSPlacementView.this.O) {
                        return;
                    }
                    PPSPlacementView.this.O = true;
                    if (PPSPlacementView.this.s instanceof PlacementVideoView) {
                        (PPSPlacementView.this.aa.V(bq.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.aa.V(bq.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).a();
                    }
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.i
            public void Code(String str, String str2, int i, int i2) {
                gv gvVar;
                if ((str == null || str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) && !PPSPlacementView.this.O && (PPSPlacementView.this.s instanceof PlacementVideoView)) {
                    if (PPSPlacementView.this.aa.V(bq.a.SINGLE_INST)) {
                        gvVar = PPSPlacementView.this.I;
                    } else {
                        gvVar = PPSPlacementView.this.aa.V(bq.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V;
                    }
                    gvVar.Code(i);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.i
            public void Code(String str, String str2, int i, int i2, int i3) {
            }
        };
        this.ae = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.22
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                fb.Code("PPSPlacementView", "clickable.OnTouchListener.ontouch");
                try {
                    int Code = jo.Code(motionEvent);
                    if (Code == 0) {
                        PPSPlacementView.this.F = jo.Code(view, motionEvent);
                        PPSPlacementView.this.F.Code(jp.Code(PPSPlacementView.this));
                    }
                    if (1 == Code) {
                        jo.Code(view, motionEvent, null, PPSPlacementView.this.F);
                    }
                } catch (Throwable th) {
                    fb.I("PPSPlacementView", "clickable.OnTouchListener.ontouch exception : %s", th.getClass().getSimpleName());
                }
                return false;
            }
        };
        this.af = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.23.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PPSPlacementView.this.c();
                    }
                });
            }
        };
        this.ag = new b(this);
        Code(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        if (this.x) {
            return;
        }
        this.x = true;
        this.L.V();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        this.g = arrayList;
        V(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public n getCurrentAd() {
        if (this.e < this.b.size()) {
            return this.b.get(this.e);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getCurrentAdDuration() {
        p S;
        n currentAd = getCurrentAd();
        if (currentAd == null || (S = currentAd.S()) == null) {
            return 0L;
        }
        return S.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCurrentContentId() {
        n currentAd = getCurrentAd();
        if (currentAd == null) {
            return null;
        }
        return currentAd.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public p getCurrentMediaFile() {
        if (getCurrentAd() != null) {
            return getCurrentAd().S();
        }
        return null;
    }

    private com.huawei.openalliance.ad.media.b getCurrentMediaState() {
        PlacementMediaView placementMediaView = this.s;
        if (placementMediaView == null) {
            return null;
        }
        return placementMediaView.getMediaState();
    }

    private int getCurrentPlayTime() {
        int i = this.e;
        if (i < 1) {
            return 0;
        }
        return this.r[i - 1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public n getNextAd() {
        if (this.e < this.b.size() - 1) {
            return this.b.get(this.e + 1);
        }
        return null;
    }

    private void h() {
        PlacementMediaView placementMediaView;
        n nextAd = getNextAd();
        if (nextAd != null) {
            this.f17426a.V(nextAd.u(), nextAd.v());
        }
        this.L.Code(nextAd);
        this.L.Z();
        bq bqVar = this.aa;
        bq.a aVar = bq.a.SINGLE_INST;
        if (bqVar.V(aVar)) {
            this.l = V(this.l, nextAd);
            Code(new bq(aVar), nextAd, this.l);
            Code(this.l);
        } else {
            if (Math.abs(this.j.getAlpha() - 1.0f) < 0.01f) {
                this.aa.Code(bq.a.BACKUP_VIEW);
                Code(this.k);
                placementMediaView = this.j;
            } else {
                this.aa.Code(bq.a.MAIN_VIEW);
                Code(this.j);
                placementMediaView = this.k;
            }
            Code(placementMediaView, false);
        }
        this.f17426a.b();
        fb.V("PPSPlacementView", "show " + this.e + " ad");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.K = false;
        fb.V("PPSPlacementView", "timeout, cancel.");
        this.ac.removeMessages(1001);
    }

    private void j() {
        if (this.E == null) {
            return;
        }
        try {
            fb.V("PPSPlacementView", "showLastFrame");
            this.G = false;
            this.E.setVisibility(0);
            this.E.setScaleType(ImageView.ScaleType.FIT_CENTER);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            addView(this.E, layoutParams);
        } catch (Throwable unused) {
            fb.I("PPSPlacementView", "showLastFrame error.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        String str;
        AudioFocusRequest.Builder onAudioFocusChangeListener;
        AudioFocusRequest build;
        if (!n()) {
            fb.I("PPSPlacementView", "audio focus is not needed");
            return;
        }
        try {
            fb.V("PPSPlacementView", "requestAudioFocus");
            if (Build.VERSION.SDK_INT < 26) {
                this.U.requestAudioFocus(this.ag, 3, 2);
            } else {
                I0Io.oIX0oI();
                onAudioFocusChangeListener = Oxx0IOOO.oIX0oI(2).setOnAudioFocusChangeListener(this.ag);
                build = onAudioFocusChangeListener.build();
                this.W = build;
                this.U.requestAudioFocus(build);
            }
        } catch (IllegalStateException unused) {
            str = "requestAudioFocus IllegalStateException";
            fb.I("PPSPlacementView", str);
        } catch (Exception e) {
            str = "requestAudioFocus " + e.getClass().getSimpleName();
            fb.I("PPSPlacementView", str);
        }
    }

    private boolean n() {
        fb.V("PPSPlacementView", "isNeedAudioFocus type: %s soundMute: %s", Integer.valueOf(this.z), Boolean.valueOf(this.t));
        int i = this.z;
        if (i == 0) {
            return true;
        }
        if (i == 2) {
            return false;
        }
        return (i == 1 && this.t) ? false : true;
    }

    @Override // com.huawei.hms.ads.fo
    public void a_() {
        this.v = -1;
        this.u = false;
    }

    @Override // com.huawei.hms.ads.kw
    public void destroyView() {
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.13
            @Override // java.lang.Runnable
            public void run() {
                fb.V("PPSPlacementView", "destroyView");
                if (PPSPlacementView.this.s != null) {
                    PPSPlacementView.this.s.F();
                    PPSPlacementView.this.s.destroyView();
                }
                PPSPlacementView.this.F();
                PPSPlacementView.this.D();
                PPSPlacementView.this.i();
                PPSPlacementView.this.Code.I();
                PPSPlacementView.this.V.I();
                PPSPlacementView.this.I.I();
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            int Code = jo.Code(motionEvent);
            if (Code == 0) {
                this.M = jo.Code(this, motionEvent);
            }
            if (1 == Code) {
                jo.Code(this, motionEvent, null, this.M);
            }
        } catch (Throwable th) {
            fb.I("PPSPlacementView", "dispatchTouchEvent exception : %s", th.getClass().getSimpleName());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void hideAdvertiserInfoDialog() {
        com.huawei.openalliance.ad.msgnotify.b.Code(getContext(), bm.B, new Intent(com.huawei.openalliance.ad.activity.a.I));
    }

    public void hideTransparencyDialog() {
        com.huawei.openalliance.ad.msgnotify.b.Code(getContext(), com.huawei.openalliance.ad.utils.g.I(getContext()), bm.B, new Intent(com.huawei.openalliance.ad.activity.a.I));
    }

    public boolean isPlaying() {
        PlacementMediaView placementMediaView = this.s;
        if (placementMediaView != null) {
            return placementMediaView.D();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fb.Code("PPSPlacementView", "onAttachedToWindow");
        this.f17426a.D();
        iz.Code(getContext()).V(getContext());
    }

    public void onClose() {
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.3
            @Override // java.lang.Runnable
            public void run() {
                fb.V("PPSPlacementView", "onClose");
                PPSPlacementView.this.L.Code();
                (PPSPlacementView.this.aa.V(bq.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.aa.V(bq.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).d();
                PPSPlacementView.this.Code.I();
                PPSPlacementView.this.V.I();
                PPSPlacementView.this.I.I();
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fb.V("PPSPlacementView", "onDetechedFromWindow");
        this.f17426a.L();
        this.Code.I();
        this.V.I();
        this.I.I();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        this.f17426a.a();
    }

    public void pause() {
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.5
            @Override // java.lang.Runnable
            public void run() {
                fb.V("PPSPlacementView", "pause");
                if (PPSPlacementView.this.s != null) {
                    PPSPlacementView.this.s.S();
                }
            }
        });
    }

    @Override // com.huawei.hms.ads.kw
    public void pauseView() {
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.11
            @Override // java.lang.Runnable
            public void run() {
                fb.V("PPSPlacementView", "pauseView");
                if (PPSPlacementView.this.s != null) {
                    PPSPlacementView.this.s.pauseView();
                    PPSPlacementView.this.s.S();
                    PPSPlacementView.this.i();
                }
            }
        });
    }

    @Override // com.huawei.hms.ads.kw
    public void resumeView() {
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.10
            @Override // java.lang.Runnable
            public void run() {
                fb.V("PPSPlacementView", "resumeView");
                if (PPSPlacementView.this.s != null) {
                    PPSPlacementView.this.s.resumeView();
                    PPSPlacementView.this.s.Code(true, PPSPlacementView.this.t);
                    PPSPlacementView pPSPlacementView = PPSPlacementView.this;
                    pPSPlacementView.Code(pPSPlacementView.getCurrentAdDuration() * 2);
                }
            }
        });
    }

    public void setAudioFocusType(int i) {
        this.z = i;
    }

    public void setMediaPlayerReleaseListener(com.huawei.openalliance.ad.media.listener.e eVar) {
        if (eVar == null) {
            return;
        }
        this.Q = eVar;
    }

    public void setOnPlacementAdClickListener(a aVar) {
        this.f = aVar;
    }

    public void setOverlays(List<View> list) {
        this.N = list;
    }

    public void setSoundVolume(final float f) {
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.8
            @Override // java.lang.Runnable
            public void run() {
                fb.V("PPSPlacementView", "set sound volume: %s", Float.valueOf(f));
                if (PPSPlacementView.this.s != null) {
                    PPSPlacementView.this.s.setSoundVolume(f);
                    (PPSPlacementView.this.aa.V(bq.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.aa.V(bq.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).V(f);
                }
            }
        });
    }

    public void showAdvertiserInfoDialog(View view, boolean z) {
        if (view == null) {
            fb.I("PPSPlacementView", "anchorView is null");
        }
        try {
            n currentAd = getCurrentAd();
            if (currentAd == null) {
                fb.I("PPSPlacementView", TanxError.ERROR_ADINFO_NULL);
                return;
            }
            AdContentData n = currentAd.n();
            if (ad.Code(n.aL())) {
                fb.I("PPSPlacementView", "advertiser Info is null");
            } else {
                ComplianceActivity.Code(getContext(), view, n, z);
            }
        } catch (Throwable th) {
            fb.I("PPSPlacementView", "showAdvertiserInfoDialog has exception %s", th.getClass().getSimpleName());
        }
    }

    public void showTransparencyDialog(View view) {
        if (view == null) {
            fb.I("PPSPlacementView", "anchorView is null");
        }
        try {
            n currentAd = getCurrentAd();
            if (currentAd == null) {
                fb.I("PPSPlacementView", TanxError.ERROR_ADINFO_NULL);
            } else {
                cj.Code(getContext(), view, currentAd.n());
            }
        } catch (Throwable th) {
            fb.I("PPSPlacementView", "showTransparencyDialog has exception %s", th.getClass().getSimpleName());
        }
    }

    public void stop() {
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.6
            @Override // java.lang.Runnable
            public void run() {
                fb.V("PPSPlacementView", "stop");
                if (PPSPlacementView.this.s != null) {
                    PPSPlacementView.this.s.F();
                }
            }
        });
    }

    public PPSPlacementView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = true;
        this.Code = new gj();
        this.V = new gj();
        this.I = new gj();
        this.b = new ArrayList(4);
        this.e = 0;
        this.h = false;
        this.i = false;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.t = false;
        this.u = false;
        this.v = -1;
        this.w = -1;
        this.x = false;
        this.y = false;
        this.z = -1;
        this.E = null;
        this.G = false;
        this.H = false;
        this.J = false;
        this.K = false;
        this.R = 0;
        this.T = false;
        this.B = -1;
        this.aa = new bq();
        this.ab = new com.huawei.openalliance.ad.media.listener.g() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.1
            @Override // com.huawei.openalliance.ad.media.listener.g
            public void Code() {
                fb.V("PPSPlacementView", "videoRenderStart");
                PPSPlacementView.this.k();
                if (!PPSPlacementView.this.H || PPSPlacementView.this.p == null) {
                    return;
                }
                PPSPlacementView.this.H = false;
                PPSPlacementView.this.J = true;
                fb.V("PPSPlacementView", "onMediaStart callback, playTime: %s", Integer.valueOf(PPSPlacementView.this.v));
                PPSPlacementView.this.p.Code(PPSPlacementView.this.v);
                PPSPlacementView.this.l();
            }
        };
        this.ac = new Handler(Looper.myLooper(), new Handler.Callback() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.12
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int i;
                n currentAd = PPSPlacementView.this.getCurrentAd();
                p currentMediaFile = PPSPlacementView.this.getCurrentMediaFile();
                String str = "";
                String a2 = currentAd != null ? currentAd.a() : "";
                if (currentMediaFile != null) {
                    str = currentMediaFile.Z();
                    i = (int) currentMediaFile.d();
                } else {
                    i = 0;
                }
                fb.V("PPSPlacementView", "callback timeout: %s", a2);
                if (PPSPlacementView.this.s != null) {
                    fb.V("PPSPlacementView", "notify Error");
                    PPSPlacementView.this.B(a2, str, i);
                }
                return true;
            }
        });
        this.ad = new com.huawei.openalliance.ad.media.listener.i() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.17
            @Override // com.huawei.openalliance.ad.media.listener.i
            public void Code(String str, String str2, int i) {
                PPSPlacementView pPSPlacementView;
                gv gvVar;
                gv gvVar2;
                if (fb.Code()) {
                    fb.Code("PPSPlacementView", "OM onSegmentMediaStart");
                }
                PPSPlacementView.this.O = false;
                if (PPSPlacementView.this.s instanceof PlacementVideoView) {
                    boolean V = PPSPlacementView.this.aa.V(bq.a.SINGLE_INST);
                    if (i > 0) {
                        if (V) {
                            gvVar2 = PPSPlacementView.this.I;
                        } else {
                            gvVar2 = PPSPlacementView.this.aa.V(bq.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V;
                        }
                        gvVar2.f();
                        return;
                    }
                    if (V) {
                        pPSPlacementView = PPSPlacementView.this;
                        gvVar = pPSPlacementView.I;
                    } else if (PPSPlacementView.this.aa.V(bq.a.MAIN_VIEW)) {
                        pPSPlacementView = PPSPlacementView.this;
                        gvVar = pPSPlacementView.Code;
                    } else {
                        pPSPlacementView = PPSPlacementView.this;
                        gvVar = pPSPlacementView.V;
                    }
                    pPSPlacementView.Code(gvVar);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.i
            public void I(String str, String str2, int i) {
                if (fb.Code()) {
                    fb.Code("PPSPlacementView", "OM onSegmentMediaStop");
                }
                if (str != null && !str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) {
                    fb.V("PPSPlacementView", "OM onSegmentMediaStop not equals");
                } else {
                    if (PPSPlacementView.this.O) {
                        return;
                    }
                    PPSPlacementView.this.O = true;
                    if (PPSPlacementView.this.s instanceof PlacementVideoView) {
                        (PPSPlacementView.this.aa.V(bq.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.aa.V(bq.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).a();
                    }
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.i
            public void V(String str, String str2, int i) {
                if (fb.Code()) {
                    fb.Code("PPSPlacementView", "OM onSegmentMediaPause");
                }
                if ((str == null || str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) && (PPSPlacementView.this.s instanceof PlacementVideoView)) {
                    (PPSPlacementView.this.aa.V(bq.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.aa.V(bq.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).e();
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.i
            public void Z(String str, String str2, int i) {
                if (fb.Code()) {
                    fb.Code("PPSPlacementView", "OM onSegmentMediaCompletion");
                }
                if (str != null && !str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) {
                    fb.V("PPSPlacementView", "OM onSegmentMediaCompletion not equals");
                } else {
                    if (PPSPlacementView.this.O) {
                        return;
                    }
                    PPSPlacementView.this.O = true;
                    if (PPSPlacementView.this.s instanceof PlacementVideoView) {
                        (PPSPlacementView.this.aa.V(bq.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.aa.V(bq.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).a();
                    }
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.i
            public void Code(String str, String str2, int i, int i2) {
                gv gvVar;
                if ((str == null || str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) && !PPSPlacementView.this.O && (PPSPlacementView.this.s instanceof PlacementVideoView)) {
                    if (PPSPlacementView.this.aa.V(bq.a.SINGLE_INST)) {
                        gvVar = PPSPlacementView.this.I;
                    } else {
                        gvVar = PPSPlacementView.this.aa.V(bq.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V;
                    }
                    gvVar.Code(i);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.i
            public void Code(String str, String str2, int i, int i2, int i3) {
            }
        };
        this.ae = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.22
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                fb.Code("PPSPlacementView", "clickable.OnTouchListener.ontouch");
                try {
                    int Code = jo.Code(motionEvent);
                    if (Code == 0) {
                        PPSPlacementView.this.F = jo.Code(view, motionEvent);
                        PPSPlacementView.this.F.Code(jp.Code(PPSPlacementView.this));
                    }
                    if (1 == Code) {
                        jo.Code(view, motionEvent, null, PPSPlacementView.this.F);
                    }
                } catch (Throwable th) {
                    fb.I("PPSPlacementView", "clickable.OnTouchListener.ontouch exception : %s", th.getClass().getSimpleName());
                }
                return false;
            }
        };
        this.af = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.23.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PPSPlacementView.this.c();
                    }
                });
            }
        };
        this.ag = new b(this);
        Code(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(final String str, final String str2, final int i) {
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.16
            @Override // java.lang.Runnable
            public void run() {
                PPSPlacementView.this.Code(str, str2, i, -1, -1);
            }
        });
    }

    private void Z(gv gvVar) {
        List<View> list;
        hg V = gvVar.V();
        if (V == null || (list = this.N) == null || list.size() <= 0) {
            return;
        }
        Iterator<View> it = this.N.iterator();
        while (it.hasNext()) {
            V.Code(it.next(), hf.OTHER, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        bq bqVar;
        n nVar;
        PlacementMediaView placementMediaView;
        bq bqVar2 = this.aa;
        bq.a aVar = bq.a.SINGLE_INST;
        fb.Code("PPSPlacementView", "initPlacementView, singlePlayerInst: %s", Boolean.valueOf(bqVar2.V(aVar)));
        this.f17426a.V(this.c.u(), this.c.v());
        this.L.Code(this.c);
        if (this.aa.V(aVar)) {
            PlacementMediaView V = V(this.l, this.c);
            this.l = V;
            V.setMediaPlayerReleaseListener(this.Q);
            bqVar = new bq(aVar);
            nVar = this.c;
            placementMediaView = this.l;
        } else {
            this.j = V(this.j, this.c);
            Code(new bq(bq.a.MAIN_VIEW), this.c, this.j);
            this.k = V(this.k, this.d);
            bqVar = new bq(bq.a.BACKUP_VIEW);
            nVar = this.d;
            placementMediaView = this.k;
        }
        Code(bqVar, nVar, placementMediaView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        String valueOf = String.valueOf(this.P);
        this.L.Code(valueOf);
        this.L.Code(this.P);
        PlacementMediaView placementMediaView = this.l;
        if (placementMediaView != null) {
            placementMediaView.Code(valueOf);
            this.l.Code(this.P);
        }
        PlacementMediaView placementMediaView2 = this.j;
        if (placementMediaView2 != null) {
            placementMediaView2.Code(valueOf);
            this.j.Code(this.P);
        }
        PlacementMediaView placementMediaView3 = this.k;
        if (placementMediaView3 != null) {
            placementMediaView3.Code(valueOf);
            this.k.Code(this.P);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.D) {
            q.V();
            this.D = false;
            fb.V("PPSPlacementView", "onClick");
            Code((Integer) 1);
            if (this.M == null) {
                this.M = this.F;
            }
            this.L.Code(this.M);
            this.F = null;
            this.M = null;
            V(this.aa.V(bq.a.SINGLE_INST) ? this.I : this.aa.V(bq.a.MAIN_VIEW) ? this.Code : this.V);
            a aVar = this.f;
            if (aVar != null) {
                aVar.Code();
            }
            bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.2
                @Override // java.lang.Runnable
                public void run() {
                    PPSPlacementView.this.D = true;
                }
            }, 500L);
        }
    }

    private boolean f() {
        return this.e == this.b.size() - 1;
    }

    private void g() {
        bq bqVar;
        n nVar;
        PlacementMediaView placementMediaView;
        this.e++;
        fb.V("PPSPlacementView", "load " + this.e + " ad");
        if (getNextAd() == null || this.aa.V(bq.a.SINGLE_INST)) {
            return;
        }
        if (Math.abs(this.j.getAlpha() - 1.0f) < 0.01f) {
            n nextAd = getNextAd();
            this.d = nextAd;
            this.k = V(this.k, nextAd);
            bqVar = new bq(bq.a.BACKUP_VIEW);
            nVar = this.d;
            placementMediaView = this.k;
        } else {
            n nextAd2 = getNextAd();
            this.c = nextAd2;
            this.j = V(this.j, nextAd2);
            bqVar = new bq(bq.a.MAIN_VIEW);
            nVar = this.c;
            placementMediaView = this.j;
        }
        Code(bqVar, nVar, placementMediaView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.15
            @Override // java.lang.Runnable
            public void run() {
                if (PPSPlacementView.this.E == null) {
                    return;
                }
                try {
                    fb.V("PPSPlacementView", "hide last frame.");
                    PPSPlacementView.this.E.setVisibility(8);
                    PPSPlacementView pPSPlacementView = PPSPlacementView.this;
                    pPSPlacementView.removeView(pPSPlacementView.E);
                    PPSPlacementView.this.E = null;
                    PPSPlacementView.this.G = true;
                } catch (Throwable unused) {
                    fb.I("PPSPlacementView", "hideLastFrame error.");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        String str;
        try {
            try {
                fb.V("PPSPlacementView", "abandonAudioFocus");
                if (Build.VERSION.SDK_INT < 26) {
                    this.U.abandonAudioFocus(this.ag);
                } else {
                    if (com.huawei.openalliance.ad.media.oIX0oI.oIX0oI(this.W)) {
                        this.U.abandonAudioFocusRequest(androidx.media.II0xO0.oIX0oI(this.W));
                    }
                    this.W = null;
                }
            } catch (IllegalStateException unused) {
                str = "abandonAudioFocus IllegalStateException";
                fb.I("PPSPlacementView", str);
                this.T = false;
                this.R = 0;
            } catch (Exception e) {
                str = "abandonAudioFocus " + e.getClass().getSimpleName();
                fb.I("PPSPlacementView", str);
                this.T = false;
                this.R = 0;
            }
            this.T = false;
            this.R = 0;
        } catch (Throwable th) {
            this.T = false;
            this.R = 0;
            throw th;
        }
    }

    public void C() {
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.7
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                fb.V("PPSPlacementView", "muteSound");
                boolean z2 = true;
                PPSPlacementView.this.t = true;
                if (PPSPlacementView.this.z == 1) {
                    PPSPlacementView.this.m();
                }
                if (PPSPlacementView.this.j != null) {
                    PPSPlacementView.this.j.I();
                    z = true;
                } else {
                    z = false;
                }
                if (PPSPlacementView.this.k != null) {
                    PPSPlacementView.this.k.I();
                    z = true;
                }
                if (PPSPlacementView.this.l != null) {
                    PPSPlacementView.this.l.I();
                } else {
                    z2 = z;
                }
                if (z2) {
                    PPSPlacementView.this.L.Code(PPSPlacementView.this.t);
                }
            }
        });
    }

    public void D() {
        this.p = null;
    }

    public void F() {
        this.q = null;
    }

    @Override // com.huawei.hms.ads.fo
    public void I() {
        this.y = true;
        this.h = false;
        this.i = false;
        long Code = w.Code();
        this.P = Code;
        fb.Code("PPSPlacementView", "onViewPhysicalShowStart: %s", Long.valueOf(Code));
        n currentAd = getCurrentAd();
        if (currentAd != null) {
            currentAd.I(false);
            currentAd.B(false);
        }
        b();
        if (this.c != null) {
            L();
            (this.aa.V(bq.a.SINGLE_INST) ? this.I : this.aa.V(bq.a.MAIN_VIEW) ? this.Code : this.V).L();
        }
    }

    public void S() {
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.9
            @Override // java.lang.Runnable
            public void run() {
                fb.V("PPSPlacementView", "unmuteSound");
                boolean z = false;
                PPSPlacementView.this.t = false;
                boolean z2 = true;
                if (PPSPlacementView.this.z == 1) {
                    PPSPlacementView.this.l();
                }
                if (PPSPlacementView.this.j != null) {
                    PPSPlacementView.this.j.B();
                    z = true;
                }
                if (PPSPlacementView.this.k != null) {
                    PPSPlacementView.this.k.B();
                    z = true;
                }
                if (PPSPlacementView.this.l != null) {
                    PPSPlacementView.this.l.B();
                } else {
                    z2 = z;
                }
                if (z2) {
                    PPSPlacementView.this.L.Code(PPSPlacementView.this.t);
                }
            }
        });
    }

    public void showTransparencyDialog(View view, int[] iArr) {
        if (view == null) {
            fb.I("PPSPlacementView", "anchorView is null");
        }
        try {
            n currentAd = getCurrentAd();
            if (currentAd == null) {
                fb.I("PPSPlacementView", TanxError.ERROR_ADINFO_NULL);
            } else {
                cj.Code(getContext(), view, iArr, currentAd.n());
            }
        } catch (Throwable th) {
            fb.I("PPSPlacementView", "showTransparencyDialog has exception %s", th.getClass().getSimpleName());
        }
    }

    public PPSPlacementView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.D = true;
        this.Code = new gj();
        this.V = new gj();
        this.I = new gj();
        this.b = new ArrayList(4);
        this.e = 0;
        this.h = false;
        this.i = false;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.t = false;
        this.u = false;
        this.v = -1;
        this.w = -1;
        this.x = false;
        this.y = false;
        this.z = -1;
        this.E = null;
        this.G = false;
        this.H = false;
        this.J = false;
        this.K = false;
        this.R = 0;
        this.T = false;
        this.B = -1;
        this.aa = new bq();
        this.ab = new com.huawei.openalliance.ad.media.listener.g() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.1
            @Override // com.huawei.openalliance.ad.media.listener.g
            public void Code() {
                fb.V("PPSPlacementView", "videoRenderStart");
                PPSPlacementView.this.k();
                if (!PPSPlacementView.this.H || PPSPlacementView.this.p == null) {
                    return;
                }
                PPSPlacementView.this.H = false;
                PPSPlacementView.this.J = true;
                fb.V("PPSPlacementView", "onMediaStart callback, playTime: %s", Integer.valueOf(PPSPlacementView.this.v));
                PPSPlacementView.this.p.Code(PPSPlacementView.this.v);
                PPSPlacementView.this.l();
            }
        };
        this.ac = new Handler(Looper.myLooper(), new Handler.Callback() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.12
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int i2;
                n currentAd = PPSPlacementView.this.getCurrentAd();
                p currentMediaFile = PPSPlacementView.this.getCurrentMediaFile();
                String str = "";
                String a2 = currentAd != null ? currentAd.a() : "";
                if (currentMediaFile != null) {
                    str = currentMediaFile.Z();
                    i2 = (int) currentMediaFile.d();
                } else {
                    i2 = 0;
                }
                fb.V("PPSPlacementView", "callback timeout: %s", a2);
                if (PPSPlacementView.this.s != null) {
                    fb.V("PPSPlacementView", "notify Error");
                    PPSPlacementView.this.B(a2, str, i2);
                }
                return true;
            }
        });
        this.ad = new com.huawei.openalliance.ad.media.listener.i() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.17
            @Override // com.huawei.openalliance.ad.media.listener.i
            public void Code(String str, String str2, int i2) {
                PPSPlacementView pPSPlacementView;
                gv gvVar;
                gv gvVar2;
                if (fb.Code()) {
                    fb.Code("PPSPlacementView", "OM onSegmentMediaStart");
                }
                PPSPlacementView.this.O = false;
                if (PPSPlacementView.this.s instanceof PlacementVideoView) {
                    boolean V = PPSPlacementView.this.aa.V(bq.a.SINGLE_INST);
                    if (i2 > 0) {
                        if (V) {
                            gvVar2 = PPSPlacementView.this.I;
                        } else {
                            gvVar2 = PPSPlacementView.this.aa.V(bq.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V;
                        }
                        gvVar2.f();
                        return;
                    }
                    if (V) {
                        pPSPlacementView = PPSPlacementView.this;
                        gvVar = pPSPlacementView.I;
                    } else if (PPSPlacementView.this.aa.V(bq.a.MAIN_VIEW)) {
                        pPSPlacementView = PPSPlacementView.this;
                        gvVar = pPSPlacementView.Code;
                    } else {
                        pPSPlacementView = PPSPlacementView.this;
                        gvVar = pPSPlacementView.V;
                    }
                    pPSPlacementView.Code(gvVar);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.i
            public void I(String str, String str2, int i2) {
                if (fb.Code()) {
                    fb.Code("PPSPlacementView", "OM onSegmentMediaStop");
                }
                if (str != null && !str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) {
                    fb.V("PPSPlacementView", "OM onSegmentMediaStop not equals");
                } else {
                    if (PPSPlacementView.this.O) {
                        return;
                    }
                    PPSPlacementView.this.O = true;
                    if (PPSPlacementView.this.s instanceof PlacementVideoView) {
                        (PPSPlacementView.this.aa.V(bq.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.aa.V(bq.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).a();
                    }
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.i
            public void V(String str, String str2, int i2) {
                if (fb.Code()) {
                    fb.Code("PPSPlacementView", "OM onSegmentMediaPause");
                }
                if ((str == null || str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) && (PPSPlacementView.this.s instanceof PlacementVideoView)) {
                    (PPSPlacementView.this.aa.V(bq.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.aa.V(bq.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).e();
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.i
            public void Z(String str, String str2, int i2) {
                if (fb.Code()) {
                    fb.Code("PPSPlacementView", "OM onSegmentMediaCompletion");
                }
                if (str != null && !str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) {
                    fb.V("PPSPlacementView", "OM onSegmentMediaCompletion not equals");
                } else {
                    if (PPSPlacementView.this.O) {
                        return;
                    }
                    PPSPlacementView.this.O = true;
                    if (PPSPlacementView.this.s instanceof PlacementVideoView) {
                        (PPSPlacementView.this.aa.V(bq.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.aa.V(bq.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).a();
                    }
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.i
            public void Code(String str, String str2, int i2, int i22) {
                gv gvVar;
                if ((str == null || str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) && !PPSPlacementView.this.O && (PPSPlacementView.this.s instanceof PlacementVideoView)) {
                    if (PPSPlacementView.this.aa.V(bq.a.SINGLE_INST)) {
                        gvVar = PPSPlacementView.this.I;
                    } else {
                        gvVar = PPSPlacementView.this.aa.V(bq.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V;
                    }
                    gvVar.Code(i2);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.i
            public void Code(String str, String str2, int i2, int i22, int i3) {
            }
        };
        this.ae = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.22
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                fb.Code("PPSPlacementView", "clickable.OnTouchListener.ontouch");
                try {
                    int Code = jo.Code(motionEvent);
                    if (Code == 0) {
                        PPSPlacementView.this.F = jo.Code(view, motionEvent);
                        PPSPlacementView.this.F.Code(jp.Code(PPSPlacementView.this));
                    }
                    if (1 == Code) {
                        jo.Code(view, motionEvent, null, PPSPlacementView.this.F);
                    }
                } catch (Throwable th) {
                    fb.I("PPSPlacementView", "clickable.OnTouchListener.ontouch exception : %s", th.getClass().getSimpleName());
                }
                return false;
            }
        };
        this.af = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.23.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PPSPlacementView.this.c();
                    }
                });
            }
        };
        this.ag = new b(this);
        Code(context);
    }

    private gv Code(bq bqVar) {
        if (bqVar.V(bq.a.SINGLE_INST)) {
            this.I.I();
            gj gjVar = new gj();
            this.I = gjVar;
            return gjVar;
        }
        if (bqVar.V(bq.a.MAIN_VIEW)) {
            this.Code.I();
            gj gjVar2 = new gj();
            this.Code = gjVar2;
            return gjVar2;
        }
        this.V.I();
        gj gjVar3 = new gj();
        this.V = gjVar3;
        return gjVar3;
    }

    private void I(long j, int i) {
        n currentAd = getCurrentAd();
        if (currentAd == null || this.h || j <= currentAd.u()) {
            return;
        }
        this.h = true;
        Code(Long.valueOf(j), Integer.valueOf(i), (Integer) null);
    }

    private PlacementMediaView V(PlacementMediaView placementMediaView, n nVar) {
        boolean z = false;
        if (nVar == null) {
            return null;
        }
        fb.Code("PPSPlacementView", "init media view for content:%s", nVar.a());
        if (Code(placementMediaView, nVar)) {
            Code(placementMediaView, false);
        } else {
            Code(placementMediaView, true);
            placementMediaView = null;
        }
        if (placementMediaView == null) {
            placementMediaView = Code(nVar);
            z = true;
        }
        if (placementMediaView != null) {
            fb.V("PPSPlacementView", "meida view created");
            placementMediaView.Code((com.huawei.openalliance.ad.media.listener.i) this);
            com.huawei.openalliance.ad.media.listener.b bVar = this.m;
            if (bVar != null) {
                placementMediaView.Code(bVar);
            }
            com.huawei.openalliance.ad.media.listener.g gVar = this.ab;
            if (gVar != null) {
                placementMediaView.Code(gVar);
            }
            com.huawei.openalliance.ad.media.listener.f fVar = this.n;
            if (fVar != null) {
                placementMediaView.Code(fVar);
            }
            placementMediaView.Code((com.huawei.openalliance.ad.media.listener.f) this);
            com.huawei.openalliance.ad.media.listener.c cVar = this.o;
            if (cVar != null) {
                placementMediaView.Code(cVar);
            }
            com.huawei.openalliance.ad.media.listener.i iVar = this.ad;
            if (iVar != null) {
                placementMediaView.I(iVar);
            }
            if (z) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(13);
                addView(placementMediaView, layoutParams);
            }
            placementMediaView.setAlpha(0.0f);
            placementMediaView.setPlacementAd(nVar);
            placementMediaView.setAudioFocusType(2);
        }
        return placementMediaView;
    }

    @Override // com.huawei.openalliance.ad.media.listener.i
    public void Z(String str, String str2, int i) {
        PlacementMediaView placementMediaView;
        String currentContentId = getCurrentContentId();
        if (str == null || str.equalsIgnoreCase(currentContentId)) {
            boolean f = f();
            if (!f) {
                PlacementMediaView placementMediaView2 = this.s;
                if (placementMediaView2 instanceof PlacementVideoView) {
                    this.E = placementMediaView2.getLastFrame();
                    j();
                }
            }
            PlacementMediaView placementMediaView3 = this.s;
            if (placementMediaView3 instanceof PlacementVideoView) {
                placementMediaView3.V(i);
            }
            i();
            fb.V("PPSPlacementView", "onSegmentMediaCompletion, contentId: %s, url: %s", str, bh.Code(str2));
            Code(i);
            this.f17426a.c();
            this.s.Code(i);
            V(f);
            if (this.p != null && f) {
                int currentPlayTime = getCurrentPlayTime() + i;
                fb.V("PPSPlacementView", "mediaCompletion callback, playedTime: %s", Integer.valueOf(currentPlayTime));
                this.p.Z(currentPlayTime);
                if (this.aa.V(bq.a.SINGLE_INST) && (placementMediaView = this.l) != null) {
                    placementMediaView.V();
                }
            }
            is isVar = this.L;
            if (isVar != null) {
                long j = i;
                isVar.Code(getContext(), j, j);
                return;
            }
            return;
        }
        fb.V("PPSPlacementView", "onCompletion, %s not match current contentId: %s.", str, currentContentId);
    }

    private void I(gv gvVar) {
        if (gvVar != null) {
            gvVar.D();
        }
    }

    @Override // com.huawei.openalliance.ad.media.listener.f
    public void V() {
        fb.V("PPSPlacementView", "onUnmute");
        this.t = false;
    }

    @Override // com.huawei.openalliance.ad.media.listener.i
    public void I(String str, String str2, int i) {
        fb.V("PPSPlacementView", "onSegmentMediaStop, contentId: %s, url: %s", str, bh.Code(str2));
        if (str != null && str.equalsIgnoreCase(getCurrentContentId())) {
            Code(i);
        }
        if (this.p == null || !str.equalsIgnoreCase(getCurrentContentId())) {
            fb.V("PPSPlacementView", "skip mediaStop callback, listener null ? %s, currentContentId: %s", Boolean.valueOf(this.p == null), getCurrentContentId());
            return;
        }
        int currentPlayTime = getCurrentPlayTime() + i;
        fb.V("PPSPlacementView", "mediaStop callback, playedTime: %s", Integer.valueOf(currentPlayTime));
        PlacementMediaView placementMediaView = this.s;
        if (placementMediaView instanceof PlacementVideoView) {
            placementMediaView.V(i);
        }
        this.p.I(currentPlayTime);
    }

    @Override // com.huawei.hms.ads.fo
    public void V(long j, int i) {
        if (!this.i) {
            this.i = true;
            this.L.Code(j, i, this.B);
        }
        this.y = false;
        this.x = false;
    }

    private PlacementMediaView Code(n nVar) {
        if (nVar == null) {
            fb.I("PPSPlacementView", "create media view with null ad");
            return null;
        }
        fb.Code("PPSPlacementView", "create media view for content:%s", nVar.a());
        if (nVar.V()) {
            fb.V("PPSPlacementView", "create video view");
            return new PlacementVideoView(getContext());
        }
        if (nVar.I()) {
            fb.V("PPSPlacementView", "create image view");
            return new PlacementImageView(getContext());
        }
        fb.V("PPSPlacementView", "return image view for default");
        return new PlacementImageView(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(List<com.huawei.openalliance.ad.inter.data.h> list) {
        p S;
        p S2;
        if (ad.Code(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        this.b.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            com.huawei.openalliance.ad.inter.data.h hVar = (com.huawei.openalliance.ad.inter.data.h) arrayList.get(i);
            if ((hVar instanceof n) && (S2 = hVar.S()) != null) {
                String Z = S2.Z();
                if (2 == S2.c() || (Z != null && Z.startsWith(ca.CONTENT.toString()))) {
                    this.b.add((n) hVar);
                } else {
                    fb.V("PPSPlacementView", "has no cache, discard " + hVar.a());
                }
            }
        }
        int size2 = this.b.size();
        this.r = new int[size2];
        if (ad.Code(this.b)) {
            return;
        }
        Collections.sort(this.b);
        for (int i2 = 0; i2 < size2; i2++) {
            n nVar = this.b.get(i2);
            int d = (nVar == null || (S = nVar.S()) == null) ? 0 : (int) S.d();
            int[] iArr = this.r;
            if (i2 == 0) {
                iArr[i2] = d;
            } else {
                iArr[i2] = d + iArr[i2 - 1];
            }
        }
    }

    private void V(gv gvVar) {
        if (gvVar != null) {
            gvVar.Code(hr.CLICK);
        }
    }

    @Override // com.huawei.openalliance.ad.media.listener.f
    public void Code() {
        fb.V("PPSPlacementView", "onMute");
        this.t = true;
    }

    public void V(com.huawei.openalliance.ad.media.listener.f fVar) {
        if (fVar == null) {
            return;
        }
        PlacementMediaView placementMediaView = this.j;
        if (placementMediaView != null) {
            placementMediaView.V(fVar);
        } else {
            this.n = null;
        }
    }

    private void Code(int i) {
        int i2;
        if (this.u && (i2 = this.v) >= 0) {
            this.w = i - i2;
            this.u = false;
        }
        this.v = -1;
    }

    @Override // com.huawei.openalliance.ad.media.listener.i
    public void V(String str, String str2, int i) {
        fb.V("PPSPlacementView", "onSegmentMediaPause:" + bh.Code(str2));
        if (str != null && str.equalsIgnoreCase(getCurrentContentId())) {
            Code(i);
            PlacementMediaView placementMediaView = this.s;
            if (placementMediaView instanceof PlacementVideoView) {
                placementMediaView.I(i);
            }
        }
        if (this.p != null) {
            int currentPlayTime = getCurrentPlayTime() + i;
            fb.V("PPSPlacementView", "mediaPause callback, playedTime: %s", Integer.valueOf(currentPlayTime));
            this.p.V(currentPlayTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(long j) {
        if (this.K) {
            return;
        }
        this.K = true;
        fb.V("PPSPlacementView", "timeout, submit: %s", Long.valueOf(j));
        this.ac.sendEmptyMessageDelayed(1001, j);
    }

    public void V(List<View> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : list) {
            if (view instanceof PlacementVideoView) {
                ((PlacementVideoView) view).setOnClickListener(this.af);
            } else {
                view.setOnClickListener(this.af);
                view.setOnTouchListener(this.ae);
            }
        }
    }

    private void V(boolean z) {
        if (this.e < this.b.size() - 1) {
            h();
            if (z) {
                return;
            }
            g();
        }
    }

    @Override // com.huawei.hms.ads.fo
    public void Code(long j, int i) {
        I(this.w, i);
    }

    private void Code(Context context) {
        bq bqVar;
        bq.a aVar;
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        setUseRatioInMatchParentMode(false);
        this.L = new Cif(context, this);
        this.f17426a = new fp(this, this);
        this.U = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (ed.Code(context).aj()) {
            bqVar = this.aa;
            aVar = bq.a.SINGLE_INST;
        } else {
            bqVar = this.aa;
            aVar = bq.a.MAIN_VIEW;
        }
        bqVar.Code(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(gv gvVar) {
        if (gvVar == null || getCurrentAd() == null || getCurrentAd().S() == null) {
            return;
        }
        fb.V("PPSPlacementView", "om start");
        gvVar.Code((float) getCurrentAd().S().d(), !"y".equals(getCurrentAd().S().S()));
    }

    private void Code(gv gvVar, PlacementMediaView placementMediaView) {
        if (placementMediaView instanceof PlacementVideoView) {
            gvVar.Code(hu.Code(0.0f, true, ht.STANDALONE));
            ((PlacementVideoView) placementMediaView).Code(gvVar);
        } else if (placementMediaView instanceof PlacementImageView) {
            gvVar.L();
        }
    }

    public void Code(ko koVar) {
        if (koVar == null) {
            return;
        }
        this.q = koVar;
    }

    public void Code(kp kpVar) {
        if (kpVar == null) {
            return;
        }
        this.p = kpVar;
    }

    private void Code(bq bqVar, com.huawei.openalliance.ad.inter.data.d dVar, PlacementMediaView placementMediaView) {
        if (dVar instanceof n) {
            AdContentData n = ((n) dVar).n();
            gv Code = Code(bqVar);
            Code.Code(getContext(), n, placementMediaView, true);
            Z(Code);
            Code.Z();
            Code(Code, placementMediaView);
        }
    }

    public void Code(com.huawei.openalliance.ad.media.listener.f fVar) {
        if (fVar == null) {
            return;
        }
        PlacementMediaView placementMediaView = this.j;
        if (placementMediaView != null) {
            placementMediaView.Code(fVar);
        } else {
            this.n = fVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(PlacementMediaView placementMediaView) {
        if (placementMediaView == null) {
            fb.I("PPSPlacementView", "show ad with null media view");
            return;
        }
        this.w = -1;
        fb.Code("PPSPlacementView", "showAd:%s", Integer.valueOf(this.e));
        this.s = placementMediaView;
        placementMediaView.setAlpha(1.0f);
        placementMediaView.Code(true, this.t);
        if (!isShown()) {
            fb.I("PPSPlacementView", "view not visible, pause.");
            pauseView();
        }
        Code(placementMediaView.getDuration() * 2);
    }

    private void Code(final PlacementMediaView placementMediaView, boolean z) {
        if (placementMediaView != null) {
            com.huawei.openalliance.ad.inter.data.h placementAd = placementMediaView.getPlacementAd();
            fb.V("PPSPlacementView", "unloadMediaView, contentId: %s, remove: %s", placementAd != null ? placementAd.a() : null, Boolean.valueOf(z));
            placementMediaView.F();
            placementMediaView.setPlacementAd(null);
            final ViewParent parent = placementMediaView.getParent();
            if (parent == null || !(parent instanceof ViewGroup)) {
                return;
            }
            placementMediaView.setAlpha(0.0f);
            if (z) {
                bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.20
                    @Override // java.lang.Runnable
                    public void run() {
                        ViewParent viewParent = parent;
                        if (viewParent != null) {
                            ((ViewGroup) viewParent).removeView(placementMediaView);
                        }
                    }
                });
            }
        }
    }

    public void Code(Integer num) {
        Code(Long.valueOf(System.currentTimeMillis() - this.f17426a.Z()), Integer.valueOf(this.f17426a.I()), num);
    }

    private void Code(Long l, Integer num, Integer num2) {
        n currentAd = getCurrentAd();
        if (currentAd == null) {
            return;
        }
        boolean Code = com.huawei.openalliance.ad.utils.c.Code(currentAd.F(), num2);
        if (!currentAd.af() || (Code && !currentAd.X())) {
            this.L.Code(ay.Code(Long.valueOf(this.P)));
            this.L.Code(this.P);
            this.L.Code(l.longValue(), num.intValue(), num2);
            if (Code) {
                currentAd.B(true);
            }
            if (currentAd.af()) {
                return;
            }
            currentAd.I(true);
            I(this.aa.V(bq.a.SINGLE_INST) ? this.I : this.aa.V(bq.a.MAIN_VIEW) ? this.Code : this.V);
        }
    }

    @Override // com.huawei.openalliance.ad.media.listener.i
    public void Code(String str, String str2, int i) {
        fb.V("PPSPlacementView", "onSegmentMediaStart, contentId: %s, url: %s", str, bh.Code(str2));
        this.u = true;
        this.v = i;
        PlacementMediaView placementMediaView = this.s;
        if (placementMediaView != null) {
            placementMediaView.setAlpha(1.0f);
        }
        if (this.p != null && this.e == 0) {
            fb.V("PPSPlacementView", "need notify media start.");
            this.H = true;
        }
        if (this.q != null && this.s != null) {
            fb.V("PPSPlacementView", "mediaChange callback.");
            this.q.Code(this.s.getPlacementAd());
        }
        PlacementMediaView placementMediaView2 = this.s;
        if (placementMediaView2 instanceof PlacementVideoView) {
            placementMediaView2.C();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0090  */
    @Override // com.huawei.openalliance.ad.media.listener.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void Code(java.lang.String r12, java.lang.String r13, int r14, int r15) {
        /*
            r11 = this;
            com.huawei.openalliance.ad.media.b r14 = r11.getCurrentMediaState()
            java.lang.String r0 = "PPSPlacementView"
            if (r14 == 0) goto L16
            com.huawei.openalliance.ad.media.d r1 = com.huawei.openalliance.ad.media.d.PLAYING
            boolean r14 = r14.V(r1)
            if (r14 == 0) goto L16
            java.lang.String r12 = "progress callback on nonPlaying state."
            com.huawei.hms.ads.fb.I(r0, r12)
            return
        L16:
            java.lang.String r14 = r11.getCurrentContentId()
            if (r12 == 0) goto L23
            boolean r14 = r12.equalsIgnoreCase(r14)
            if (r14 != 0) goto L23
            return
        L23:
            long r7 = r11.getCurrentAdDuration()
            boolean r14 = r11.u
            r9 = 0
            r10 = 1
            if (r14 != 0) goto L36
            int r1 = r11.v
            if (r1 >= 0) goto L36
            r11.v = r15
            r11.u = r10
            goto L66
        L36:
            if (r14 == 0) goto L66
            int r14 = r11.v
            if (r14 < 0) goto L66
            int r14 = r15 - r14
            r11.w = r14
            long r1 = (long) r14
            com.huawei.hms.ads.fp r14 = r11.f17426a
            int r14 = r14.I()
            r11.I(r1, r14)
            int r14 = r11.w
            long r1 = (long) r14
            long r3 = r11.getCurrentAdDuration()
            int r14 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r14 < 0) goto L57
            r14 = 1
            goto L58
        L57:
            r14 = 0
        L58:
            com.huawei.hms.ads.is r1 = r11.L
            if (r1 == 0) goto L67
            android.content.Context r2 = r11.getContext()
            long r3 = (long) r15
            r5 = r7
            r1.Code(r2, r3, r5)
            goto L67
        L66:
            r14 = 0
        L67:
            com.huawei.hms.ads.kp r1 = r11.p
            if (r1 != 0) goto L71
            boolean r1 = r11.u
            if (r1 != 0) goto L71
            if (r15 <= 0) goto L93
        L71:
            long r1 = (long) r15
            int r3 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r3 <= 0) goto L7d
            r1 = 0
            int r3 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r3 <= 0) goto L7d
            int r15 = (int) r7
        L7d:
            int r1 = r11.getCurrentPlayTime()
            int r1 = r1 + r15
            r11.B = r1
            int[] r2 = r11.r
            int r3 = r2.length
            int r3 = r3 - r10
            r2 = r2[r3]
            int r2 = r1 / r2
            com.huawei.hms.ads.kp r3 = r11.p
            if (r3 == 0) goto L93
            r3.Code(r2, r1)
        L93:
            if (r15 <= 0) goto L9c
            boolean r1 = r11.G
            if (r1 != 0) goto L9c
            r11.k()
        L9c:
            if (r15 <= 0) goto Lb2
            boolean r1 = r11.H
            if (r1 == 0) goto Lb2
            com.huawei.hms.ads.kp r1 = r11.p
            if (r1 == 0) goto Lb2
            r11.H = r9
            r11.J = r10
            int r2 = r11.v
            r1.Code(r2)
            r11.l()
        Lb2:
            if (r14 == 0) goto Lc8
            java.lang.String r14 = "time countdown finish, manual stop."
            com.huawei.hms.ads.fb.V(r0, r14)
            com.huawei.openalliance.ad.views.PlacementMediaView r14 = r11.s
            r14.F()
            com.huawei.openalliance.ad.media.listener.i r14 = r11.ad
            if (r14 == 0) goto Lc5
            r14.Z(r12, r13, r15)
        Lc5:
            r11.Z(r12, r13, r15)
        Lc8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.views.PPSPlacementView.Code(java.lang.String, java.lang.String, int, int):void");
    }

    @Override // com.huawei.openalliance.ad.media.listener.i
    public void Code(String str, String str2, int i, int i2, int i3) {
        PlacementMediaView placementMediaView;
        p S;
        fb.V("PPSPlacementView", "onSegmentMediaError, contentId: %s, url: %s", str, bh.Code(str2));
        String currentContentId = getCurrentContentId();
        if (str != null && !str.equalsIgnoreCase(currentContentId)) {
            fb.V("PPSPlacementView", "onError, contentId not match, currentConentId: %s", currentContentId);
            return;
        }
        k();
        i();
        fb.I("PPSPlacementView", "onSegmentMediaError:" + bh.Code(str2) + ", playTime:" + i + ",errorCode:" + i2 + ",extra:" + i3);
        Code(i);
        if (this.p != null) {
            int currentPlayTime = getCurrentPlayTime() + i;
            fb.V("PPSPlacementView", "mediaError callback, playedTime: %s", Integer.valueOf(currentPlayTime));
            this.p.Code(currentPlayTime, i2, i3);
        }
        if (!this.J) {
            fb.V("PPSPlacementView", "error before start callback.");
            this.H = true;
        }
        this.f17426a.c();
        this.s.Code(i);
        n currentAd = getCurrentAd();
        if (currentAd != null && (S = currentAd.S()) != null) {
            this.L.Code(S.Z(), i2, i3, currentAd);
        }
        boolean f = f();
        V(f);
        if (this.p == null || !f || this.r.length <= 0) {
            return;
        }
        fb.V("PPSPlacementView", "last ad play error");
        kp kpVar = this.p;
        int[] iArr = this.r;
        kpVar.Z(iArr[iArr.length - 1]);
        if (!this.aa.V(bq.a.SINGLE_INST) || (placementMediaView = this.l) == null) {
            return;
        }
        placementMediaView.V();
    }

    public void Code(final List<com.huawei.openalliance.ad.inter.data.h> list) {
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.18
            @Override // java.lang.Runnable
            public void run() {
                StringBuilder sb = new StringBuilder();
                sb.append("register:");
                List list2 = list;
                sb.append(list2 == null ? 0 : list2.size());
                fb.V("PPSPlacementView", sb.toString());
                PPSPlacementView.this.I((List<com.huawei.openalliance.ad.inter.data.h>) list);
                if (ad.Code(list) || ad.Code(PPSPlacementView.this.b)) {
                    return;
                }
                PPSPlacementView.this.e = 0;
                PPSPlacementView pPSPlacementView = PPSPlacementView.this;
                pPSPlacementView.c = pPSPlacementView.getCurrentAd();
                PPSPlacementView pPSPlacementView2 = PPSPlacementView.this;
                pPSPlacementView2.d = pPSPlacementView2.getNextAd();
                PPSPlacementView.this.a();
                PPSPlacementView.this.e();
                PlacementMediaView placementMediaView = PPSPlacementView.this.aa.V(bq.a.SINGLE_INST) ? PPSPlacementView.this.l : PPSPlacementView.this.j;
                PPSPlacementView.this.b();
                PPSPlacementView.this.Code(placementMediaView);
                if (PPSPlacementView.this.y) {
                    PPSPlacementView.this.L();
                }
            }
        });
    }

    private boolean Code(PlacementMediaView placementMediaView, n nVar) {
        return ((placementMediaView instanceof PlacementVideoView) && nVar.V()) || ((placementMediaView instanceof PlacementImageView) && nVar.I());
    }
}
