package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: classes10.dex */
public class fm extends fj {
    boolean f;
    private final int h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;

    public fm(kk kkVar) {
        super(kkVar);
        this.h = hashCode();
        this.i = false;
        this.j = false;
        this.f = false;
        this.k = false;
        this.l = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        Context context;
        fb.V("RealtimeAdMediator", "doOnShowSloganEnd");
        this.j = true;
        if (this.k) {
            fb.V("RealtimeAdMediator", "Ad fails to display or loading timeout, ad dismiss");
            I(com.huawei.openalliance.ad.constant.ah.y);
            a();
        } else {
            if (this.f) {
                return;
            }
            fb.V(p(), "doOnShowSloganEnd Ad has been loaded, but not shown yet");
            if (this.l && (context = this.e) != null) {
                com.huawei.openalliance.ad.ipc.g.V(context).Code("getNormalSplashAd", String.valueOf(this.C.I()), new RemoteCallResultCallback<AdContentData>() { // from class: com.huawei.hms.ads.fm.3
                    @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                    public void onRemoteCallResult(String str, final CallResult<AdContentData> callResult) {
                        com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.fm.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                fm.this.B = (AdContentData) callResult.getData();
                                fm fmVar = fm.this;
                                AdContentData adContentData = fmVar.B;
                                String p = fmVar.p();
                                if (adContentData == null) {
                                    fb.V(p, "linked loaded, do not call play");
                                    fm.this.I(-6);
                                    fm.this.a();
                                } else {
                                    fb.V(p, "linked loaded, display normal when slogan ends");
                                    fm fmVar2 = fm.this;
                                    fmVar2.I(fmVar2.B);
                                    fm.this.Z(1202);
                                }
                            }
                        });
                    }
                }, AdContentData.class);
            } else if (this.B != null) {
                fb.V(p(), "show splash");
                I(this.B);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        AdContentData adContentData;
        fb.V("RealtimeAdMediator", "doOnReachMinSloganShowTime");
        this.i = true;
        if (!this.f && (adContentData = this.B) != null) {
            I(adContentData);
            return;
        }
        fb.V("RealtimeAdMediator", "doOnReachMinSloganShowTime adFailToDisplay: %s", Boolean.valueOf(this.k));
        if (this.k) {
            fb.V("RealtimeAdMediator", "ad fail to load when reach min slogan show time");
            I(com.huawei.openalliance.ad.constant.ah.y);
            a();
        }
    }

    @Override // com.huawei.hms.ads.fj
    public void I(AdContentData adContentData) {
        fb.V("RealtimeAdMediator", "on content loaded");
        this.B = adContentData;
        if (adContentData == null) {
            I(494);
            n();
            return;
        }
        kk g = g();
        if (g == null) {
            I(com.huawei.openalliance.ad.constant.ah.w);
            n();
            return;
        }
        dc dcVar = new dc(g.getContext());
        if (dcVar.Code()) {
            I(com.huawei.openalliance.ad.constant.ah.v);
            n();
            return;
        }
        if (this.B.l() != 12) {
            if (!this.i && !this.j) {
                fb.V("RealtimeAdMediator", "slogan hasn't reach min show time or end, show ad later");
                return;
            }
            if (dcVar.Code()) {
                I(com.huawei.openalliance.ad.constant.ah.v);
                n();
                return;
            }
            boolean V = V(this.B);
            this.f = true;
            if (V) {
                return;
            }
            V(com.huawei.openalliance.ad.constant.ah.w);
            return;
        }
        if (Z() == 1 && (I() instanceof com.huawei.openalliance.ad.inter.listeners.m)) {
            fb.V("RealtimeAdMediator", "on linked loaded, sloganShowEnd:" + this.j);
            if (!this.j) {
                com.huawei.openalliance.ad.inter.listeners.m mVar = (com.huawei.openalliance.ad.inter.listeners.m) I();
                com.huawei.openalliance.ad.inter.data.k Code = jd.Code(this.B);
                fb.V(p(), "on content loaded, linkedAd loaded. ");
                this.F = System.currentTimeMillis();
                mVar.Code(Code);
                this.L = this.B;
                this.l = true;
                B(200);
                return;
            }
        }
        com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.fm.4
            @Override // java.lang.Runnable
            public void run() {
                fm.this.I(1200);
                fm.this.n();
            }
        });
    }

    @Override // com.huawei.hms.ads.fj
    public String d() {
        return String.valueOf(2);
    }

    @Override // com.huawei.hms.ads.fn
    public void m() {
        fb.V("RealtimeAdMediator", "start");
        kk g = g();
        if (g == null) {
            I(-4);
            a();
        } else {
            c();
            com.huawei.openalliance.ad.utils.h.Code(new Runnable() { // from class: com.huawei.hms.ads.fm.1
                @Override // java.lang.Runnable
                public void run() {
                    fm.this.D();
                }
            });
            g.Code(new ky() { // from class: com.huawei.hms.ads.fm.2
                @Override // com.huawei.hms.ads.ky
                public void Code() {
                    com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.fm.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            fm.this.r();
                        }
                    });
                }

                @Override // com.huawei.hms.ads.ky
                public void V() {
                    com.huawei.openalliance.ad.utils.bf.Code(new Runnable() { // from class: com.huawei.hms.ads.fm.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            fm.this.q();
                        }
                    });
                }
            });
            e();
        }
    }

    @Override // com.huawei.hms.ads.fn
    public void n() {
        fb.V("RealtimeAdMediator", "onAdFailToDisplay - reachMinSloganShowTime: %s sloganShowEnd: %s", Boolean.valueOf(this.i), Boolean.valueOf(this.j));
        this.k = true;
        if (this.i || this.j) {
            a();
        }
    }

    public String p() {
        return "RealtimeAdMediator" + this.h;
    }
}
