package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import com.google.android.exoplayer2.ExoPlayer;
import com.huawei.hms.ads.BiddingInfo;
import com.huawei.hms.ads.dynamic.ObjectWrapper;
import com.huawei.hms.ads.jb;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.hms.ads.splash.R;
import com.huawei.hms.ads.splash.SplashAdDisplayListener;
import com.huawei.hms.ads.splash.SplashView;
import com.huawei.hms.ads.uiengine.IRemoteCreator;
import com.huawei.hms.ads.uiengine.d;
import com.huawei.openalliance.ad.beans.inner.AnalysisEventReport;
import com.huawei.openalliance.ad.beans.inner.SplashAdReqParam;
import com.huawei.openalliance.ad.beans.metadata.DelayInfo;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.constant.bn;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.c;
import com.huawei.openalliance.ad.utils.h;
import com.huawei.openalliance.ad.views.PPSSplashView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public abstract class fj implements fn {
    protected AdContentData B;
    protected ed C;
    private ji H;
    protected WeakReference<km> I;
    protected AdContentData L;
    protected com.huawei.openalliance.ad.constant.b Z;
    protected RewardVerifyConfig b;
    protected int c;
    protected String d;
    protected Context e;
    private WeakReference<kk> i;
    private com.huawei.openalliance.ad.inter.listeners.b j;
    private SplashView.SplashAdLoadListener k;
    private com.huawei.openalliance.ad.inter.listeners.a t;
    private SplashAdDisplayListener u;
    private CountDownTimer v;
    private String w;
    private gv h = new gj();
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;
    protected boolean S = false;
    private boolean o = false;
    private final String p = "load_timeout_" + hashCode();
    private boolean q = false;
    private boolean r = false;
    private boolean s = false;
    private long x = 0;
    private long y = -1;
    protected long F = 0;
    private int z = 0;
    protected boolean D = false;

    /* renamed from: a, reason: collision with root package name */
    protected DelayInfo f17287a = new DelayInfo();
    private boolean A = false;
    private boolean E = false;
    private boolean G = false;

    /* renamed from: com.huawei.hms.ads.fj$2, reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass2 implements RemoteCallResultCallback<String> {
        final /* synthetic */ int Code;

        public AnonymousClass2(int i) {
            this.Code = i;
        }

        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
        public void onRemoteCallResult(String str, final CallResult<String> callResult) {
            com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.fj.2.1
                @Override // java.lang.Runnable
                public void run() {
                    fj.this.d = (String) callResult.getData();
                    final AdContentData adContentData = (AdContentData) com.huawei.openalliance.ad.utils.aa.V((String) callResult.getData(), AdContentData.class, new Class[0]);
                    if (adContentData != null) {
                        fj.this.F = System.currentTimeMillis();
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        fj.this.S(anonymousClass2.Code);
                        fj.this.B = adContentData;
                        com.huawei.openalliance.ad.utils.h.I(new Runnable() { // from class: com.huawei.hms.ads.fj.2.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                fj fjVar = fj.this;
                                fjVar.Code(fjVar.e, adContentData, anonymousClass22.Code);
                            }
                        });
                        if (fj.this.V(adContentData)) {
                            return;
                        } else {
                            fj.this.I(com.huawei.openalliance.ad.constant.ah.w);
                        }
                    } else {
                        AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                        fj.this.I(anonymousClass22.Code);
                    }
                    fj.this.n();
                }
            });
        }
    }

    /* renamed from: com.huawei.hms.ads.fj$4, reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass4 implements Runnable {
        final /* synthetic */ AdSlotParam Code;
        final /* synthetic */ SplashAdReqParam V;

        /* renamed from: com.huawei.hms.ads.fj$4$1, reason: invalid class name */
        /* loaded from: classes10.dex */
        public class AnonymousClass1 implements RemoteCallResultCallback<String> {

            /* renamed from: com.huawei.hms.ads.fj$4$1$1, reason: invalid class name and collision with other inner class name */
            /* loaded from: classes10.dex */
            public class RunnableC06361 implements Runnable {
                final /* synthetic */ long Code;
                final /* synthetic */ CallResult V;

                public RunnableC06361(long j, CallResult callResult) {
                    this.Code = j;
                    this.V = callResult;
                }

                @Override // java.lang.Runnable
                public void run() {
                    fj.this.f17287a.D(com.huawei.openalliance.ad.utils.w.Code() - this.Code);
                    fj.this.d = (String) this.V.getData();
                    AdContentData adContentData = (AdContentData) com.huawei.openalliance.ad.utils.aa.V((String) this.V.getData(), AdContentData.class, new Class[0]);
                    if (adContentData != null) {
                        fj.this.w = adContentData.M();
                    }
                    if (adContentData != null) {
                        fj.this.I(adContentData);
                    } else {
                        com.huawei.openalliance.ad.ipc.g.V(fj.this.e).Code("getSpareSplashAd", String.valueOf(fj.this.C.I()), new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.fj.4.1.1.1
                            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                            public void onRemoteCallResult(String str, final CallResult<String> callResult) {
                                com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.fj.4.1.1.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        fj.this.d = (String) callResult.getData();
                                        AdContentData adContentData2 = (AdContentData) com.huawei.openalliance.ad.utils.aa.V((String) callResult.getData(), AdContentData.class, new Class[0]);
                                        if (adContentData2 != null) {
                                            fj.this.Code(adContentData2, 494);
                                        } else {
                                            fj.this.I((AdContentData) null);
                                        }
                                    }
                                });
                            }
                        }, String.class);
                    }
                }
            }

            public AnonymousClass1() {
            }

            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                fb.V("AdMediator", "onDownloaded");
                fj fjVar = fj.this;
                fjVar.f17287a.Code(fjVar.x, System.currentTimeMillis());
                synchronized (fj.this) {
                    try {
                        fb.V("AdMediator", "onDownloaded, loadingTimeout:" + fj.this.l);
                        fj fjVar2 = fj.this;
                        if (!fjVar2.S) {
                            fjVar2.S = true;
                        }
                        if (callResult.getCode() != 200) {
                            fj.this.f17287a.V(Integer.valueOf(callResult.getCode()));
                        }
                        if (fj.this.l) {
                            fj.this.f17287a.I(-2);
                            fj.this.o = true;
                        } else {
                            fj.this.l = true;
                            com.huawei.openalliance.ad.utils.bf.Code(fj.this.p);
                            fb.V("AdMediator", "cancel loadTimeoutTask");
                            fj fjVar3 = fj.this;
                            fjVar3.f17287a.Z(fjVar3.x, System.currentTimeMillis());
                            com.huawei.openalliance.ad.utils.bf.Code(new RunnableC06361(com.huawei.openalliance.ad.utils.w.Code(), callResult));
                        }
                        if (fj.this.o) {
                            fj.this.B((AdContentData) com.huawei.openalliance.ad.utils.aa.V(callResult.getData(), AdContentData.class, new Class[0]));
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        public AnonymousClass4(AdSlotParam adSlotParam, SplashAdReqParam splashAdReqParam) {
            this.Code = adSlotParam;
            this.V = splashAdReqParam;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context = fj.this.e;
            if (context == null) {
                return;
            }
            iy.Code(context, com.huawei.openalliance.ad.constant.x.cl, this.Code, com.huawei.openalliance.ad.utils.aa.V(this.V), new AnonymousClass1(), String.class);
        }
    }

    /* renamed from: com.huawei.hms.ads.fj$5, reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass5 implements Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (fj.this) {
                try {
                    fb.V("AdMediator", "on load task timeout, loadingTimeout: %s", Boolean.valueOf(fj.this.l));
                    if (!fj.this.l) {
                        fj.this.l = true;
                        com.huawei.openalliance.ad.ipc.g.V(fj.this.e).Code("getSpareSplashAd", String.valueOf(fj.this.C.I()), new RemoteCallResultCallback<AdContentData>() { // from class: com.huawei.hms.ads.fj.5.1
                            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                            public void onRemoteCallResult(String str, final CallResult<AdContentData> callResult) {
                                com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.fj.5.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        AdContentData adContentData = (AdContentData) callResult.getData();
                                        if (adContentData != null) {
                                            fj.this.Code(adContentData, -2);
                                        } else {
                                            fj.this.I(-2);
                                            fj.this.f();
                                        }
                                    }
                                });
                            }
                        }, AdContentData.class);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public fj(kk kkVar) {
        this.i = new WeakReference<>(kkVar);
        this.c = kkVar.getAdType();
        Context applicationContext = kkVar.getContext().getApplicationContext();
        this.e = applicationContext;
        this.C = ed.Code(applicationContext);
        o();
    }

    private void o() {
        com.huawei.openalliance.ad.utils.h.I(new Runnable() { // from class: com.huawei.hms.ads.fj.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    fj fjVar = fj.this;
                    fjVar.H = new ji(fjVar.e);
                    fj.this.H.Code();
                    d V = g.V();
                    if (V != null) {
                        V.Code(fj.this.c, (Bundle) null);
                    }
                } catch (Throwable th) {
                    fb.V("AdMediator", "inform err: %s", th.getClass().getSimpleName());
                }
            }
        });
    }

    private String p() {
        return com.huawei.openalliance.ad.utils.bc.Code(g());
    }

    private void q() {
        long j = this.y;
        if (j <= 0) {
            j = com.huawei.openalliance.ad.utils.w.Code();
        }
        this.B.Z(j);
    }

    private void r() {
        CountDownTimer countDownTimer = new CountDownTimer(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, 500L) { // from class: com.huawei.hms.ads.fj.7
            @Override // android.os.CountDownTimer
            public void onFinish() {
                fb.V("AdMediator", "onFinish");
                fj fjVar = fj.this;
                if (fjVar.Z != com.huawei.openalliance.ad.constant.b.LOADED) {
                    fjVar.I(-10);
                    fj.this.n();
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                fb.Code("AdMediator", "onTick = %s", Long.valueOf(j));
            }
        };
        this.v = countDownTimer;
        countDownTimer.start();
    }

    private boolean s() {
        return this.q;
    }

    private String t() {
        AdContentData adContentData;
        if (!this.E || (adContentData = this.B) == null || 3 == adContentData.aF() || this.B.aU() == null) {
            return null;
        }
        return this.B.aU().Code();
    }

    private void u() {
        fb.Code("AdMediator", "onAdEnd");
        try {
            if (this.G) {
                fb.V("AdMediator", "already end");
                return;
            }
            fb.V("AdMediator", "onAdEnd");
            this.G = true;
            ji jiVar = this.H;
            if (jiVar != null) {
                jiVar.V();
            }
            d V = g.V();
            if (V != null) {
                V.V(this.c, (Bundle) null);
            }
        } catch (Throwable th) {
            fb.V("AdMediator", "end err: %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.hms.ads.fn
    public void C() {
        Code(11, "feedback hasShowFinish", Long.valueOf(this.F));
        km h = h();
        if (h != null) {
            h.D();
        }
    }

    public void D() {
        Context context = this.e;
        if (context != null) {
            com.huawei.openalliance.ad.ipc.g.V(context).Code("resetDisplayDateAndCount", null, null, null);
        }
    }

    @Override // com.huawei.hms.ads.fn
    public void F() {
        this.f17287a.I(this.x, System.currentTimeMillis());
    }

    public abstract void I(AdContentData adContentData);

    @Override // com.huawei.hms.ads.fn
    public void L() {
        if (this.s) {
            return;
        }
        this.s = true;
        jc.Code(this.e, this.B);
        gv gvVar = this.h;
        if (gvVar != null) {
            gvVar.L();
        }
    }

    public void S() {
        com.huawei.openalliance.ad.inter.listeners.a aVar = this.t;
        if (aVar != null) {
            aVar.V();
        }
        SplashAdDisplayListener splashAdDisplayListener = this.u;
        if (splashAdDisplayListener != null) {
            splashAdDisplayListener.onAdClick();
        }
        com.huawei.openalliance.ad.utils.bb.V(this.e);
    }

    @Override // com.huawei.hms.ads.fn
    public com.huawei.openalliance.ad.constant.b V() {
        return this.Z;
    }

    public int Z() {
        return this.z;
    }

    @Override // com.huawei.hms.ads.fn
    public void a() {
        fb.V("AdMediator", "notifyAdDismissed");
        if (this.m) {
            fb.V("AdMediator", "ad already dismissed");
            return;
        }
        this.m = true;
        com.huawei.openalliance.ad.inter.listeners.b bVar = this.j;
        if (bVar != null) {
            bVar.V();
        }
        SplashView.SplashAdLoadListener splashAdLoadListener = this.k;
        if (splashAdLoadListener != null) {
            splashAdLoadListener.onAdDismissed();
        }
        AdContentData adContentData = this.B;
        if (adContentData != null && adContentData.aF() != 3) {
            jf.Code(this.e).Code(this.B, -10);
        }
        km h = h();
        if (h != null) {
            h.destroyView();
        }
    }

    public AdSlotParam b() {
        kk g = g();
        if (g == null) {
            return null;
        }
        AdSlotParam adSlotParam = g.getAdSlotParam();
        if (adSlotParam != null) {
            this.f17287a.Code(adSlotParam.Code());
        }
        return adSlotParam;
    }

    public void c() {
        AdSlotParam b = b();
        if (b == null) {
            I((AdContentData) null);
            return;
        }
        Context context = this.e;
        b.I(context != null ? com.huawei.openalliance.ad.inter.g.Code(context).I() : null);
        SplashAdReqParam splashAdReqParam = new SplashAdReqParam();
        splashAdReqParam.Code(d());
        splashAdReqParam.Code(this.x);
        String B = com.huawei.openalliance.ad.utils.w.B();
        this.w = B;
        b.V(B);
        b.Code(this.c);
        Code(b, splashAdReqParam);
    }

    public abstract String d();

    public void e() {
        int a2 = this.C.a();
        fb.V("AdMediator", "startAdLoadTimeoutTask - max load time: %d", Integer.valueOf(a2));
        com.huawei.openalliance.ad.utils.bf.Code(new AnonymousClass5(), this.p, a2);
    }

    public void f() {
        a();
    }

    public kk g() {
        return this.i.get();
    }

    public km h() {
        WeakReference<km> weakReference = this.I;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.huawei.hms.ads.fn
    public void j() {
        fb.V("AdMediator", "onDisplayTimeUp hasShowFinish: %s", Boolean.valueOf(this.A));
        if (this.A) {
            return;
        }
        this.A = true;
        com.huawei.openalliance.ad.utils.bb.V(this.e);
        a();
    }

    @Override // com.huawei.hms.ads.fn
    public String k() {
        AdContentData adContentData = this.B;
        if (adContentData != null) {
            return adContentData.aa();
        }
        return null;
    }

    @Override // com.huawei.hms.ads.fn
    public BiddingInfo l() {
        if (this.B == null) {
            return null;
        }
        BiddingInfo.a aVar = new BiddingInfo.a();
        aVar.Code(this.B.aV()).Code(this.B.aW()).V(this.B.aX()).I(this.B.aY());
        return aVar.Code();
    }

    private void F(int i) {
        if (this.L != null) {
            Code(this.e, i, this.w, d(), this.L);
            com.huawei.openalliance.ad.inter.listeners.b bVar = this.j;
            if (bVar instanceof com.huawei.openalliance.ad.inter.listeners.m) {
                bVar.Code(-6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(int i) {
        if (i == -6) {
            Code(this.e, i, this.w, d(), this.L);
        } else {
            Code(this.e, i, this.w, d(), this.B);
        }
        B(i);
    }

    @Override // com.huawei.hms.ads.fn
    public void B() {
        Code(10, "onWhyThisAd hasShowFinish", Long.valueOf(this.F));
        km h = h();
        if (h != null) {
            h.F();
        }
    }

    @Override // com.huawei.hms.ads.fn
    public void C(int i) {
        kk g = g();
        if (g != null) {
            g.I(i);
        }
    }

    public com.huawei.openalliance.ad.inter.listeners.b I() {
        return this.j;
    }

    @Override // com.huawei.hms.ads.fn
    public void V(int i) {
        Context context;
        fb.V("AdMediator", "toShowSpare");
        if (!this.B.aq() && (context = this.e) != null) {
            com.huawei.openalliance.ad.ipc.g.V(context).Code("getSpareSplashAd", String.valueOf(this.C.I()), new AnonymousClass2(i), String.class);
        } else {
            I(i);
            n();
        }
    }

    public void Z(int i) {
        F(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(AdContentData adContentData) {
        if (adContentData == null) {
            return;
        }
        adContentData.n();
        Context context = this.e;
        if (context != null) {
            com.huawei.openalliance.ad.ipc.g.V(context).Code("updateContentOnAdLoad", com.huawei.openalliance.ad.utils.aa.V(adContentData), null, null);
        }
    }

    private void S(AdContentData adContentData) {
        if (this.h == null) {
            return;
        }
        if (adContentData != null && adContentData.l() == 9) {
            this.h.Code(hu.Code(0.0f, true, ht.STANDALONE));
        } else if (adContentData != null) {
            if (adContentData.l() == 4 || adContentData.l() == 2) {
                this.h.L();
            }
        }
    }

    public void B(int i) {
        this.o = true;
        this.f17287a.I(i);
        B(this.B);
    }

    public km Code(AdContentData adContentData, kk kkVar) {
        if (adContentData == null) {
            return null;
        }
        km V = kkVar.V(adContentData.l());
        if (V == null) {
            return V;
        }
        V.setAdContent(adContentData);
        V.setAdMediator(this);
        if (adContentData.l() == 2 || adContentData.l() == 4) {
            V.setDisplayDuration((adContentData.ar() > 0 ? adContentData.ar() : 0) + (adContentData.as() >= 2000 ? adContentData.as() : this.C.V()));
        }
        Code(V, adContentData, kkVar);
        return V;
    }

    @Override // com.huawei.hms.ads.fn
    public void I(int i) {
        fb.V("AdMediator", "ad failed:" + i);
        if (this.n) {
            fb.V("AdMediator", "ad is already failed");
            return;
        }
        this.n = true;
        this.F = System.currentTimeMillis();
        com.huawei.openalliance.ad.inter.listeners.b bVar = this.j;
        if (bVar != null) {
            bVar.Code(i);
        }
        SplashView.SplashAdLoadListener splashAdLoadListener = this.k;
        if (splashAdLoadListener != null) {
            splashAdLoadListener.onAdFailedToLoad(com.huawei.hms.ads.utils.b.Code(i));
        }
        com.huawei.openalliance.ad.utils.bb.V(this.e);
        u();
        S(i);
    }

    @Override // com.huawei.hms.ads.fn
    public void V(long j) {
        this.x = j;
    }

    @Override // com.huawei.hms.ads.fn
    public void Z(AdContentData adContentData) {
        final String jSONObject;
        if (adContentData == null) {
            return;
        }
        try {
            if (!com.huawei.openalliance.ad.utils.w.I() && !com.huawei.openalliance.ad.utils.w.a(this.e)) {
                jSONObject = adContentData.a();
                com.huawei.openalliance.ad.utils.h.Code(new Runnable() { // from class: com.huawei.hms.ads.fj.8
                    @Override // java.lang.Runnable
                    public void run() {
                        com.huawei.openalliance.ad.utils.h.I(new Runnable() { // from class: com.huawei.hms.ads.fj.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.huawei.openalliance.ad.ipc.g.V(fj.this.e).Code(com.huawei.openalliance.ad.constant.s.r, jSONObject, null, null);
                            }
                        });
                    }
                });
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("content_id", adContentData.a());
            jSONObject2.put("templateId", adContentData.aE());
            jSONObject2.put("slotid", adContentData.L());
            jSONObject2.put("apiVer", adContentData.aF());
            jSONObject = jSONObject2.toString();
            com.huawei.openalliance.ad.utils.h.Code(new Runnable() { // from class: com.huawei.hms.ads.fj.8
                @Override // java.lang.Runnable
                public void run() {
                    com.huawei.openalliance.ad.utils.h.I(new Runnable() { // from class: com.huawei.hms.ads.fj.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.huawei.openalliance.ad.ipc.g.V(fj.this.e).Code(com.huawei.openalliance.ad.constant.s.r, jSONObject, null, null);
                        }
                    });
                }
            });
        } catch (Throwable th) {
            fb.V("AdMediator", "onMaterialLoadFailed err: %s", th.getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(AdContentData adContentData) {
        if (this.S && this.o && this.e != null) {
            fb.V("AdMediator", "reportSplashCostTime");
            this.o = false;
            this.f17287a.Code(d());
            this.f17287a.V(this.x, this.F);
            cy.Code(this.e, this.w, this.c, adContentData, this.f17287a);
        }
    }

    private void V(boolean z) {
        this.q = z;
    }

    @Override // com.huawei.hms.ads.fn
    public void Code(int i) {
        this.z = i;
    }

    @Override // com.huawei.hms.ads.fn
    public void Code(int i, int i2) {
        km h = h();
        if (h != null) {
            h.Code(i, i2);
        }
        if (this.A) {
            return;
        }
        this.A = true;
        com.huawei.openalliance.ad.utils.bb.V(this.e);
        jc.Code(this.e, this.B, i, i2, (List<String>) null);
        Code(Long.valueOf(this.F), 3, false);
        a();
    }

    private void Code(int i, int i2, com.huawei.openalliance.ad.uriaction.p pVar, Long l, MaterialClickInfo materialClickInfo, int i3) {
        Code(l, 1, true);
        jb jbVar = new jb();
        jbVar.B(t());
        jc.Code(this.e, this.B, i, i2, pVar.I(), i3, materialClickInfo, com.huawei.openalliance.ad.utils.b.Code(g()), com.huawei.openalliance.ad.utils.bc.V(g()), jbVar);
        if (this.A) {
            fb.V("AdMediator", "onDoActionSucc hasShowFinish");
            return;
        }
        this.A = true;
        com.huawei.openalliance.ad.utils.bb.V(this.e);
        S();
    }

    private void Code(int i, String str, Long l) {
        Code(l, i, false);
        if (this.A) {
            fb.V("AdMediator", str);
        } else {
            this.A = true;
            com.huawei.openalliance.ad.utils.bb.V(this.e);
        }
    }

    public boolean V(AdContentData adContentData) {
        fb.V("AdMediator", "showAdContent");
        if (this.b != null) {
            fb.V("AdMediator", "set verifyConfig.");
            adContentData.q(this.b.getData());
            adContentData.r(this.b.getUserId());
        }
        this.D = true;
        kk g = g();
        if (g == null) {
            return false;
        }
        fb.V("AdMediator", "showAdContent, getTemplateIdV3 = %s", adContentData.aE());
        if (!com.huawei.openalliance.ad.utils.ay.Code(adContentData.aE()) || c.Code(this.e, adContentData.aU(), adContentData.L(), 1)) {
            this.E = true;
            if (!(g instanceof PPSSplashView)) {
                fb.I("AdMediator", "not PPSSplashView");
                return false;
            }
            IRemoteCreator Code = g.Code(this.e);
            if (Code != null) {
                ci ciVar = new ci(g.getContext(), this, adContentData);
                Bundle bundle = new Bundle();
                bundle.putInt("audioFocusType", g.getAudioFocusType());
                PPSSplashView pPSSplashView = (PPSSplashView) g;
                bundle.putInt(bn.f.S, pPSSplashView.getMediaNameResId());
                bundle.putInt(bn.f.C, pPSSplashView.getLogoResId());
                bundle.putString("content", this.d);
                fb.Code("AdMediator", "contentJson : %s", this.d);
                AdSlotParam b = b();
                if (b != null) {
                    bundle.putInt(bn.f.V, b.V());
                    bundle.putInt(bn.f.B, b.f() != null ? b.f().intValue() : 1);
                }
                try {
                    View view = (View) ObjectWrapper.unwrap(Code.newSplashTemplateView(bundle, ciVar));
                    if (view == null) {
                        fb.I("AdMediator", "templateView is null;");
                        return false;
                    }
                    this.h = null;
                    g.Code(view);
                    Code.bindData(ObjectWrapper.wrap(view), this.d);
                    r();
                } catch (Throwable th) {
                    fb.I("AdMediator", "create splashTemplateView err: %s", th.getClass().getSimpleName());
                    return false;
                }
            } else {
                fb.V("AdMediator", "Creator is null");
                return false;
            }
        } else {
            this.I = null;
            km Code2 = Code(adContentData, g);
            if (Code2 == null) {
                return false;
            }
            gv gvVar = this.h;
            if (gvVar != null) {
                gvVar.Z();
            }
            S(adContentData);
            g.Code(Code2, g.Code(adContentData));
            Code2.V();
            this.I = new WeakReference<>(Code2);
        }
        return true;
    }

    @Override // com.huawei.hms.ads.fn
    public void Code(long j) {
        this.y = j;
    }

    private void Code(Context context, int i, String str, String str2, AdContentData adContentData) {
        List<String> Code;
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        if (adContentData == null) {
            adContentData = new AdContentData();
        }
        adContentData.d(this.c);
        analysisEventReport.Code(adContentData);
        analysisEventReport.Code(i);
        analysisEventReport.I(str);
        analysisEventReport.D(adContentData.aE());
        analysisEventReport.L(adContentData.L());
        analysisEventReport.F(adContentData.a());
        analysisEventReport.I(adContentData.aF());
        try {
            analysisEventReport.V(Integer.parseInt(str2));
        } catch (NumberFormatException e) {
            fb.Code("AdMediator", "setShowMode error%s", e.getClass().getSimpleName());
        }
        if (b() != null && (Code = b().Code()) != null && !Code.isEmpty()) {
            fb.Code("AdMediator", "setSlotId: %s", Code.get(0));
            analysisEventReport.Z(Code.get(0));
        }
        if (context != null) {
            com.huawei.openalliance.ad.ipc.g.V(context).Code("rptSplashFailedEvt", com.huawei.openalliance.ad.utils.aa.V(analysisEventReport), null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(Context context, AdContentData adContentData, int i) {
        if (context == null) {
            return;
        }
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.Code(adContentData);
        analysisEventReport.Code(i);
        if (adContentData != null) {
            analysisEventReport.D(adContentData.aE());
            analysisEventReport.L(adContentData.L());
            analysisEventReport.F(adContentData.a());
            analysisEventReport.I(adContentData.aF());
        }
        com.huawei.openalliance.ad.ipc.g.V(context).Code("rptStartSpareSplashAd", com.huawei.openalliance.ad.utils.aa.V(analysisEventReport), null, null);
    }

    private void Code(km kmVar, AdContentData adContentData, kk kkVar) {
        if (adContentData == null || kmVar == null || this.h == null) {
            fb.I("AdMediator", "there is no splash ad or adView is null");
            return;
        }
        fb.V("AdMediator", "initOmsdkResource");
        this.h.Code(this.e, adContentData, kkVar, true);
        kmVar.Code(this.h);
    }

    @Override // com.huawei.hms.ads.fn
    public void Code(RewardVerifyConfig rewardVerifyConfig) {
        this.b = rewardVerifyConfig;
    }

    @Override // com.huawei.hms.ads.fn
    public void Code(SplashAdDisplayListener splashAdDisplayListener) {
        this.u = splashAdDisplayListener;
    }

    @Override // com.huawei.hms.ads.fn
    public void Code(SplashView.SplashAdLoadListener splashAdLoadListener) {
        this.k = splashAdLoadListener;
    }

    private void Code(AdSlotParam adSlotParam, SplashAdReqParam splashAdReqParam) {
        com.huawei.openalliance.ad.utils.h.Code(new AnonymousClass4(adSlotParam, splashAdReqParam), h.a.SPLASH_NET, false);
    }

    @Override // com.huawei.hms.ads.fn
    public void Code(final AdContentData adContentData) {
        com.huawei.openalliance.ad.utils.h.Code(new Runnable() { // from class: com.huawei.hms.ads.fj.3
            @Override // java.lang.Runnable
            public void run() {
                if (fj.this.E && 3 != adContentData.aF()) {
                    ee.Code(fj.this.e).Code(adContentData.L(), System.currentTimeMillis());
                }
                fj.this.C(adContentData);
            }
        });
        kk g = g();
        if (g != null) {
            int c = adContentData.c();
            g.Code(adContentData.c(), !this.E);
            g.V();
            if (!this.E) {
                g.Code(adContentData, this.C.F());
                g.Code(ja.C(adContentData.v()), ja.S(adContentData.v()), adContentData.av(), 1 == c, g.Code(adContentData));
            }
        }
        this.Z = com.huawei.openalliance.ad.constant.b.LOADED;
        CountDownTimer countDownTimer = this.v;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        fb.V("AdMediator", "ad loaded");
        this.F = System.currentTimeMillis();
        com.huawei.openalliance.ad.inter.listeners.b bVar = this.j;
        if (bVar != null) {
            bVar.Code();
        }
        SplashView.SplashAdLoadListener splashAdLoadListener = this.k;
        if (splashAdLoadListener != null) {
            splashAdLoadListener.onAdLoaded();
        }
        q();
        L();
        if (!this.C.k()) {
            Code((Long) null, (Integer) null, (Integer) null, false);
        }
        B(200);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(final AdContentData adContentData, final int i) {
        if (adContentData != null) {
            fb.V("AdMediator", "use spare ad");
            this.S = true;
            this.w = adContentData.M();
            this.F = System.currentTimeMillis();
            S(i);
            adContentData.S(true);
            com.huawei.openalliance.ad.utils.h.I(new Runnable() { // from class: com.huawei.hms.ads.fj.6
                @Override // java.lang.Runnable
                public void run() {
                    fj fjVar = fj.this;
                    fjVar.Code(fjVar.e, adContentData, i);
                }
            });
            I(adContentData);
        }
    }

    @Override // com.huawei.hms.ads.fn
    public void Code(AdContentData adContentData, long j, int i) {
        String str;
        u();
        if (!this.C.k()) {
            fb.I("AdMediator", "onAdShowEnd - use old adshow event");
            return;
        }
        fb.V("AdMediator", "onAdShowEnd duration: %d showRatio: %d", Long.valueOf(j), Integer.valueOf(i));
        jc.Code(this.e, adContentData, j, i);
        if (adContentData != null) {
            MetaData S = adContentData.S();
            if (S != null) {
                if (j < S.F() || i < S.D()) {
                    fb.I("AdMediator", "duration or show ratio is invalid for showId %s", adContentData.D());
                    return;
                } else {
                    Code(Long.valueOf(j), Integer.valueOf(i), (Integer) null, false);
                    return;
                }
            }
            str = "onAdShowEnd - metaData is null";
        } else {
            str = "onAdShowEnd - content record is null";
        }
        fb.I("AdMediator", str);
    }

    @Override // com.huawei.hms.ads.fn
    public void Code(com.huawei.openalliance.ad.inter.listeners.a aVar) {
        this.t = aVar;
    }

    @Override // com.huawei.hms.ads.fn
    public void Code(com.huawei.openalliance.ad.inter.listeners.b bVar) {
        this.j = bVar;
    }

    private void Code(Long l, int i, boolean z) {
        Code(l != null ? Long.valueOf(System.currentTimeMillis() - l.longValue()) : null, (Integer) 100, Integer.valueOf(i), z);
    }

    public void Code(Long l, Integer num, Integer num2, boolean z) {
        AdContentData adContentData = this.B;
        boolean Code = c.Code(adContentData != null ? adContentData.V() : null, num2);
        if (s() && (!Code || Code())) {
            fb.I("AdMediator", "show event already reported before, ignore this");
            return;
        }
        String p = p();
        AdContentData adContentData2 = this.B;
        if (adContentData2 != null) {
            fb.Code("AdMediator", "slotId: %s, contentId: %s, slot pos: %s", adContentData2.L(), this.B.a(), p);
        }
        jb.a aVar = new jb.a();
        if (z) {
            aVar.V(Long.valueOf(com.huawei.openalliance.ad.utils.w.Code()));
        }
        if (!com.huawei.openalliance.ad.utils.ay.Code(p)) {
            aVar.B(p);
        }
        Object g = g();
        aVar.Code(l).Code(num).V(num2).V(t()).I(com.huawei.openalliance.ad.utils.b.Code(g));
        if (g instanceof View) {
            aVar.Code(jp.Code((View) g));
        }
        jc.Code(this.e, this.B, aVar.Code());
        if (Code) {
            Code(true);
        }
        if (s()) {
            return;
        }
        V(true);
        com.huawei.openalliance.ad.inter.listeners.a aVar2 = this.t;
        if (aVar2 != null) {
            aVar2.Code();
        }
        SplashAdDisplayListener splashAdDisplayListener = this.u;
        if (splashAdDisplayListener != null) {
            splashAdDisplayListener.onAdShowed();
        }
        gv gvVar = this.h;
        if (gvVar != null) {
            gvVar.D();
        }
    }

    public void Code(boolean z) {
        this.r = z;
    }

    public boolean Code() {
        return this.r;
    }

    @Override // com.huawei.hms.ads.fn
    public boolean Code(int i, int i2, AdContentData adContentData, Long l, MaterialClickInfo materialClickInfo, int i3) {
        boolean z;
        fb.V("AdMediator", "onTouch");
        Context context = g() instanceof View ? ((View) g()).getContext() : this.e;
        com.huawei.openalliance.ad.uriaction.p Code = com.huawei.openalliance.ad.uriaction.q.Code(context, adContentData, new HashMap(0));
        if (Code instanceof com.huawei.openalliance.ad.uriaction.e) {
            Code.Code(new jl() { // from class: com.huawei.hms.ads.fj.9
                @Override // com.huawei.hms.ads.jl
                public void Code(int i4) {
                    fb.V("AdMediator", "FA action status is %s", Integer.valueOf(i4));
                    if (i4 == -1 || i4 == 200) {
                        fj.this.a();
                    }
                }
            });
        }
        if (Code.Code()) {
            if (18 == i3 && (context instanceof Activity)) {
                ((Activity) context).overridePendingTransition(R.anim.hiad_open, R.anim.hiad_close);
            }
            Code(i, i2, Code, l, materialClickInfo, i3);
            z = true;
        } else {
            z = false;
        }
        com.huawei.openalliance.ad.inter.d.Code(this.e).Code(false);
        return z;
    }
}
