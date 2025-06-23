package com.adp.sdk;

import OoOoXO0.xoXoI;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import androidx.annotation.Nullable;
import com.adp.sdk.dto.AdInfo;
import com.adp.sdk.dto.AdItem;
import com.adp.sdk.dto.AdpError;
import com.adp.sdk.dto.SourceVO;
import com.adp.sdk.f;
import com.adp.sdk.g;
import com.adp.sdk.listener.ADPDownloadConfirmCallBack;
import com.adp.sdk.listener.ADPDownloadConfirmListener;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.ExpressInterstitialListener;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdSlot;
import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.InterstitialAd;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.kwad.components.offline.api.explore.model.ExploreConstants;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.List;
import oOoIIO0.oIX0oI;
import oOoIIO0.xoIox;
import oOoIIO0.xxIXOIIO;

public class ADPInterstitial extends e {
    /* access modifiers changed from: private */
    public Activity g;
    /* access modifiers changed from: private */
    public String h;
    /* access modifiers changed from: private */
    public ADPInterstitialListener i;
    /* access modifiers changed from: private */
    public AdItem j;
    private boolean k = false;
    /* access modifiers changed from: private */
    public boolean l = false;
    private TTAdNative m;
    /* access modifiers changed from: private */
    public UnifiedInterstitialAD n;
    /* access modifiers changed from: private */
    public TTFullScreenVideoAd o;
    /* access modifiers changed from: private */
    public xxIXOIIO p;
    /* access modifiers changed from: private */
    public boolean q;
    /* access modifiers changed from: private */
    public ADPDownloadConfirmListener r;
    /* access modifiers changed from: private */
    public SourceVO s;
    /* access modifiers changed from: private */
    public ArrayList<SourceVO> t = new ArrayList<>();
    /* access modifiers changed from: private */
    public KsInterstitialAd u;
    /* access modifiers changed from: private */
    public boolean v = true;
    private boolean w = true;
    /* access modifiers changed from: private */
    public ExpressInterstitialAd x;
    /* access modifiers changed from: private */
    public InterstitialAd y;
    /* access modifiers changed from: private */
    public Handler z = new Handler();

    public interface ADPInterstitialListener {
        void onADClicked();

        void onADClosed();

        void onADError(AdpError adpError);

        void onADOpened();

        void onADPresent();

        void onADReceive();

        void onVideoCached();
    }

    public class a implements UnifiedInterstitialADListener {

        /* renamed from: com.adp.sdk.ADPInterstitial$a$a  reason: collision with other inner class name */
        public class C0007a implements DownloadConfirmListener {

            /* renamed from: com.adp.sdk.ADPInterstitial$a$a$a  reason: collision with other inner class name */
            public class C0008a implements ADPDownloadConfirmCallBack {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ DownloadConfirmCallBack f660a;

                public C0008a(C0007a aVar, DownloadConfirmCallBack downloadConfirmCallBack) {
                    this.f660a = downloadConfirmCallBack;
                }

                public void onCancel() {
                    DownloadConfirmCallBack downloadConfirmCallBack = this.f660a;
                    if (downloadConfirmCallBack != null) {
                        downloadConfirmCallBack.onCancel();
                    }
                }

                public void onConfirm() {
                    DownloadConfirmCallBack downloadConfirmCallBack = this.f660a;
                    if (downloadConfirmCallBack != null) {
                        downloadConfirmCallBack.onConfirm();
                    }
                }
            }

            public C0007a() {
            }

            public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
                ADPInterstitial.this.r.onDownloadConfirm(activity, i, str, new C0008a(this, downloadConfirmCallBack));
            }
        }

        public a() {
        }

        public void onADClicked() {
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADClicked();
            }
            ADPInterstitial aDPInterstitial = ADPInterstitial.this;
            aDPInterstitial.a(aDPInterstitial.g, ADPInterstitial.this.h, "tencent", "2", ADPInterstitial.this.s);
        }

        public void onADClosed() {
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADClosed();
            }
            boolean unused = ADPInterstitial.this.l = false;
        }

        public void onADExposure() {
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADPresent();
            }
            ADPInterstitial aDPInterstitial = ADPInterstitial.this;
            aDPInterstitial.e(aDPInterstitial.g, ADPInterstitial.this.h, "tencent", "2", ADPInterstitial.this.s);
            a.a(ADPInterstitial.this.j, (Context) ADPInterstitial.this.g);
        }

        public void onADLeftApplication() {
        }

        public void onADOpened() {
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADOpened();
            }
            boolean unused = ADPInterstitial.this.l = false;
        }

        public void onADReceive() {
            ADPInterstitial.this.e();
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADReceive();
            }
            boolean unused = ADPInterstitial.this.q = false;
            boolean unused2 = ADPInterstitial.this.l = false;
            ADPInterstitial aDPInterstitial = ADPInterstitial.this;
            aDPInterstitial.b(aDPInterstitial.g, ADPInterstitial.this.h, "tencent", "2", ADPInterstitial.this.s);
        }

        public void onNoAD(AdError adError) {
            boolean unused = ADPInterstitial.this.l = false;
            if (ADPInterstitial.this.t.size() <= 0) {
                ADPInterstitial aDPInterstitial = ADPInterstitial.this;
                aDPInterstitial.a("tencent", new AdpError(adError.getErrorCode() + "", adError.getErrorMsg()));
                return;
            }
            ADPInterstitial.this.c();
        }

        public void onRenderFail() {
        }

        public void onRenderSuccess() {
        }

        public void onVideoCached() {
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onVideoCached();
            }
            if (ADPInterstitial.this.r != null && ADPInterstitial.this.n != null) {
                try {
                    ADPInterstitial.this.n.setDownloadConfirmListener(new C0007a());
                } catch (Exception unused) {
                }
            }
        }
    }

    public class b implements xoIox {
        public b() {
        }

        public void onAdCacheLoaded() {
        }

        public void onAdClicked() {
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADClicked();
            }
            ADPInterstitial aDPInterstitial = ADPInterstitial.this;
            aDPInterstitial.a(aDPInterstitial.g, ADPInterstitial.this.h, "octopus", "2", ADPInterstitial.this.s);
        }

        public void onAdClosed() {
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADClosed();
            }
            boolean unused = ADPInterstitial.this.l = false;
            xxIXOIIO unused2 = ADPInterstitial.this.p = null;
        }

        public void onAdFailedToLoad(int i) {
            boolean unused = ADPInterstitial.this.l = false;
            if (ADPInterstitial.this.t.size() <= 0) {
                ADPInterstitial.this.a("octopus", new AdpError(i + "", "octo:errorCode" + i));
                return;
            }
            ADPInterstitial.this.c();
        }

        public void onAdLoaded() {
            try {
                if (ADPInterstitial.this.p == null) {
                    ADPInterstitial aDPInterstitial = ADPInterstitial.this;
                    aDPInterstitial.b(aDPInterstitial.g, ADPInterstitial.this.h, "octopus", "2", ADPInterstitial.this.s);
                } else {
                    ADPInterstitial aDPInterstitial2 = ADPInterstitial.this;
                    Activity i = aDPInterstitial2.g;
                    String j = ADPInterstitial.this.h;
                    SourceVO k = ADPInterstitial.this.s;
                    aDPInterstitial2.a(i, j, "octopus", "2", k, ADPInterstitial.this.p.OOXIXo() + "");
                }
                if (ADPInterstitial.this.s.getPrice() != null) {
                    int parseInt = Integer.parseInt(ADPInterstitial.this.s.getPrice());
                    if (parseInt > ADPInterstitial.this.p.OOXIXo()) {
                        ADPInterstitial.this.p.II0XooXoX(parseInt, oIX0oI.f6142II0xO0, oIX0oI.f6146Oxx0IOOO);
                        boolean unused = ADPInterstitial.this.l = false;
                        if (ADPInterstitial.this.t.size() <= 0) {
                            ADPInterstitial.this.a("octopus", new AdpError("-1", "没有找到合适广告"));
                            return;
                        }
                        ADPInterstitial.this.c();
                        return;
                    }
                    ADPInterstitial.this.p.II0xO0(parseInt);
                }
            } catch (Exception unused2) {
            }
            boolean unused3 = ADPInterstitial.this.l = false;
            boolean unused4 = ADPInterstitial.this.q = true;
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADReceive();
            }
        }

        public void onAdShown() {
            boolean unused = ADPInterstitial.this.l = false;
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADOpened();
            }
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADPresent();
            }
            ADPInterstitial aDPInterstitial = ADPInterstitial.this;
            aDPInterstitial.e(aDPInterstitial.g, ADPInterstitial.this.h, "octopus", "2", ADPInterstitial.this.s);
            a.a(ADPInterstitial.this.j, (Context) ADPInterstitial.this.g);
        }
    }

    public class c extends AdListener {
        public c() {
        }

        @GlobalApi
        public void onAdClicked() {
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADClicked();
            }
            ADPInterstitial aDPInterstitial = ADPInterstitial.this;
            aDPInterstitial.a(aDPInterstitial.g, ADPInterstitial.this.h, "huawei", "2", ADPInterstitial.this.s);
        }

        @GlobalApi
        public void onAdClosed() {
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADClosed();
            }
            boolean unused = ADPInterstitial.this.l = false;
            InterstitialAd unused2 = ADPInterstitial.this.y = null;
        }

        @GlobalApi
        public void onAdFailed(int i) {
            boolean unused = ADPInterstitial.this.l = false;
            if (ADPInterstitial.this.t.size() <= 0) {
                ADPInterstitial.this.a("huawei", new AdpError("" + i, i + ">huawei"));
                return;
            }
            ADPInterstitial.this.c();
        }

        @GlobalApi
        public void onAdImpression() {
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADPresent();
            }
            ADPInterstitial aDPInterstitial = ADPInterstitial.this;
            aDPInterstitial.e(aDPInterstitial.g, ADPInterstitial.this.h, "huawei", "2", ADPInterstitial.this.s);
        }

        @GlobalApi
        public void onAdLeave() {
        }

        @GlobalApi
        public void onAdLoaded() {
            ADPInterstitial aDPInterstitial = ADPInterstitial.this;
            aDPInterstitial.b(aDPInterstitial.g, ADPInterstitial.this.h, "huawei", "2", ADPInterstitial.this.s);
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADReceive();
            }
            boolean unused = ADPInterstitial.this.q = false;
            boolean unused2 = ADPInterstitial.this.l = false;
        }

        @GlobalApi
        public void onAdOpened() {
            boolean unused = ADPInterstitial.this.l = false;
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADOpened();
            }
            a.a(ADPInterstitial.this.j, (Context) ADPInterstitial.this.g);
        }
    }

    public class d implements ExpressInterstitialListener {
        public d() {
        }

        public void onADExposed() {
            boolean unused = ADPInterstitial.this.l = false;
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADOpened();
            }
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADPresent();
            }
            ADPInterstitial aDPInterstitial = ADPInterstitial.this;
            aDPInterstitial.e(aDPInterstitial.g, ADPInterstitial.this.h, "baidu", "2", ADPInterstitial.this.s);
            a.a(ADPInterstitial.this.j, (Context) ADPInterstitial.this.g);
        }

        public void onADExposureFailed() {
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADClosed();
            }
            boolean unused = ADPInterstitial.this.l = false;
            KsInterstitialAd unused2 = ADPInterstitial.this.u = null;
        }

        public void onADLoaded() {
        }

        public void onAdCacheFailed() {
            boolean unused = ADPInterstitial.this.l = false;
            if (ADPInterstitial.this.t.size() <= 0) {
                ADPInterstitial.this.a("baidu", new AdpError("-1", "缓存失败"));
            } else {
                ADPInterstitial.this.c();
            }
        }

        public void onAdCacheSuccess() {
            ADPInterstitial aDPInterstitial = ADPInterstitial.this;
            aDPInterstitial.b(aDPInterstitial.g, ADPInterstitial.this.h, "baidu", "2", ADPInterstitial.this.s);
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADReceive();
            }
            boolean unused = ADPInterstitial.this.q = false;
            boolean unused2 = ADPInterstitial.this.l = false;
        }

        public void onAdClick() {
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADClicked();
            }
            ADPInterstitial aDPInterstitial = ADPInterstitial.this;
            aDPInterstitial.a(aDPInterstitial.g, ADPInterstitial.this.h, "baidu", "2", ADPInterstitial.this.s);
        }

        public void onAdClose() {
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADClosed();
            }
            boolean unused = ADPInterstitial.this.l = false;
            KsInterstitialAd unused2 = ADPInterstitial.this.u = null;
            ExpressInterstitialAd unused3 = ADPInterstitial.this.x = null;
        }

        public void onAdFailed(int i, String str) {
            boolean unused = ADPInterstitial.this.l = false;
            if (ADPInterstitial.this.t.size() <= 0) {
                ADPInterstitial aDPInterstitial = ADPInterstitial.this;
                aDPInterstitial.a("baidu", new AdpError(i + "", str));
                return;
            }
            ADPInterstitial.this.c();
        }

        public void onLpClosed() {
        }

        public void onNoAd(int i, String str) {
            boolean unused = ADPInterstitial.this.l = false;
            if (ADPInterstitial.this.t.size() <= 0) {
                ADPInterstitial aDPInterstitial = ADPInterstitial.this;
                aDPInterstitial.a("baidu", new AdpError(i + "", str));
                return;
            }
            ADPInterstitial.this.c();
        }

        public void onVideoDownloadFailed() {
        }

        public void onVideoDownloadSuccess() {
        }
    }

    public class e implements KsLoadManager.InterstitialAdListener {
        public e() {
        }

        public void onError(int i, String str) {
            boolean unused = ADPInterstitial.this.l = false;
            if (ADPInterstitial.this.t.size() <= 0) {
                ADPInterstitial aDPInterstitial = ADPInterstitial.this;
                aDPInterstitial.a("tencent", new AdpError(i + "", str));
                return;
            }
            ADPInterstitial.this.c();
        }

        public void onInterstitialAdLoad(@Nullable List<KsInterstitialAd> list) {
            if (list == null || list.size() <= 0) {
                KsInterstitialAd unused = ADPInterstitial.this.u = null;
                boolean unused2 = ADPInterstitial.this.l = false;
                if (list.size() <= 0) {
                    ADPInterstitial.this.a("adsplus", new AdpError("-1", "kuaisou adlist is null"));
                } else {
                    ADPInterstitial.this.c();
                }
            } else {
                ADPInterstitial aDPInterstitial = ADPInterstitial.this;
                aDPInterstitial.b(aDPInterstitial.g, ADPInterstitial.this.h, "kuaishou", "2", ADPInterstitial.this.s);
                KsInterstitialAd unused3 = ADPInterstitial.this.u = list.get(0);
                if (ADPInterstitial.this.i != null) {
                    ADPInterstitial.this.i.onADReceive();
                }
                boolean unused4 = ADPInterstitial.this.q = false;
                boolean unused5 = ADPInterstitial.this.l = false;
            }
        }

        public void onRequestResult(int i) {
        }
    }

    public class f implements KsInterstitialAd.AdInteractionListener {
        public f() {
        }

        public void onAdClicked() {
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADClicked();
            }
            ADPInterstitial aDPInterstitial = ADPInterstitial.this;
            aDPInterstitial.a(aDPInterstitial.g, ADPInterstitial.this.h, "kuaishou", "2", ADPInterstitial.this.s);
        }

        public void onAdClosed() {
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADClosed();
            }
            boolean unused = ADPInterstitial.this.l = false;
            KsInterstitialAd unused2 = ADPInterstitial.this.u = null;
        }

        public void onAdShow() {
            boolean unused = ADPInterstitial.this.l = false;
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADOpened();
            }
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADPresent();
            }
            ADPInterstitial aDPInterstitial = ADPInterstitial.this;
            aDPInterstitial.e(aDPInterstitial.g, ADPInterstitial.this.h, "kuaishou", "2", ADPInterstitial.this.s);
            a.a(ADPInterstitial.this.j, (Context) ADPInterstitial.this.g);
        }

        public void onPageDismiss() {
            KsInterstitialAd unused = ADPInterstitial.this.u = null;
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADClosed();
            }
            boolean unused2 = ADPInterstitial.this.l = false;
        }

        public void onSkippedAd() {
            KsInterstitialAd unused = ADPInterstitial.this.u = null;
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADClosed();
            }
            boolean unused2 = ADPInterstitial.this.l = false;
        }

        public void onVideoPlayEnd() {
        }

        public void onVideoPlayError(int i, int i2) {
            KsInterstitialAd unused = ADPInterstitial.this.u = null;
        }

        public void onVideoPlayStart() {
        }
    }

    public class g implements TTAdNative.FullScreenVideoAdListener {

        public class a implements TTFullScreenVideoAd.FullScreenVideoAdInteractionListener {
            public a() {
            }

            public void onAdClose() {
                if (ADPInterstitial.this.i != null) {
                    ADPInterstitial.this.i.onADClosed();
                }
                TTFullScreenVideoAd unused = ADPInterstitial.this.o = null;
                boolean unused2 = ADPInterstitial.this.l = false;
            }

            public void onAdShow() {
                boolean unused = ADPInterstitial.this.l = false;
                if (ADPInterstitial.this.i != null) {
                    ADPInterstitial.this.i.onADOpened();
                }
                if (ADPInterstitial.this.i != null) {
                    ADPInterstitial.this.i.onADPresent();
                }
                ADPInterstitial aDPInterstitial = ADPInterstitial.this;
                aDPInterstitial.e(aDPInterstitial.g, ADPInterstitial.this.h, "gromore", "2", ADPInterstitial.this.s);
                a.a(ADPInterstitial.this.j, (Context) ADPInterstitial.this.g);
            }

            public void onAdVideoBarClick() {
                if (ADPInterstitial.this.i != null) {
                    ADPInterstitial.this.i.onADClicked();
                }
                ADPInterstitial aDPInterstitial = ADPInterstitial.this;
                aDPInterstitial.a(aDPInterstitial.g, ADPInterstitial.this.h, "gromore", "2", ADPInterstitial.this.s);
            }

            public void onSkippedVideo() {
            }

            public void onVideoComplete() {
            }
        }

        public g() {
        }

        public void onError(int i, String str) {
            TTFullScreenVideoAd unused = ADPInterstitial.this.o = null;
            boolean unused2 = ADPInterstitial.this.l = false;
            if (ADPInterstitial.this.t.size() <= 0) {
                ADPInterstitial aDPInterstitial = ADPInterstitial.this;
                aDPInterstitial.a("gromore", new AdpError(i + "", str));
                return;
            }
            ADPInterstitial.this.c();
        }

        public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
            TTFullScreenVideoAd unused = ADPInterstitial.this.o = tTFullScreenVideoAd;
            boolean unused2 = ADPInterstitial.this.q = false;
            ADPInterstitial aDPInterstitial = ADPInterstitial.this;
            aDPInterstitial.b(aDPInterstitial.g, ADPInterstitial.this.h, "gromore", "2", ADPInterstitial.this.s);
            ADPInterstitial.this.o.setFullScreenVideoAdInteractionListener(new a());
        }

        public void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd) {
        }

        public void onFullScreenVideoCached() {
            boolean unused = ADPInterstitial.this.l = false;
            boolean unused2 = ADPInterstitial.this.q = true;
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADReceive();
            }
            boolean unused3 = ADPInterstitial.this.v;
        }
    }

    public class h implements f.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f668a;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                h hVar = h.this;
                ADPInterstitial.this.d(hVar.f668a);
            }
        }

        public h(String str) {
            this.f668a = str;
        }

        public void a(int i, String str) {
            boolean unused = ADPInterstitial.this.l = false;
            if (ADPInterstitial.this.t.size() <= 0) {
                ADPInterstitial aDPInterstitial = ADPInterstitial.this;
                aDPInterstitial.a("gromore", new AdpError(i + "", str));
                return;
            }
            ADPInterstitial.this.c();
        }

        public void success() {
            ADPInterstitial.this.g.runOnUiThread(new a());
        }
    }

    public class i implements g.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f670a;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                i iVar = i.this;
                ADPInterstitial.this.i(iVar.f670a);
            }
        }

        public i(String str) {
            this.f670a = str;
        }

        public void a() {
            boolean unused = ADPInterstitial.this.l = false;
            if (ADPInterstitial.this.t.size() <= 0) {
                ADPInterstitial.this.a("gromore", new AdpError("-1", "gdt error GDTAdSdk.start"));
            } else {
                ADPInterstitial.this.c();
            }
        }

        public void success() {
            ADPInterstitial.this.z.post(new a());
        }
    }

    public class j implements UnifiedInterstitialMediaListener {
        public j(ADPInterstitial aDPInterstitial) {
        }

        public void onVideoComplete() {
        }

        public void onVideoError(AdError adError) {
        }

        public void onVideoInit() {
        }

        public void onVideoLoading() {
        }

        public void onVideoPageClose() {
        }

        public void onVideoPageOpen() {
        }

        public void onVideoPause() {
        }

        public void onVideoReady(long j) {
        }

        public void onVideoStart() {
        }
    }

    private ADPInterstitial() {
    }

    private void load() {
        if (ADP.isInitSuccess()) {
            a();
            b();
            return;
        }
        this.l = false;
        a("adsplus", new AdpError("-1", "adp sdk is not initialized"));
    }

    public void close() {
        this.l = false;
        UnifiedInterstitialAD unifiedInterstitialAD = this.n;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.close();
        }
        if (this.u != null) {
            this.u = null;
        }
        TTFullScreenVideoAd tTFullScreenVideoAd = this.o;
        if (tTFullScreenVideoAd != null && tTFullScreenVideoAd.getMediationManager() != null) {
            this.o.getMediationManager().destroy();
        }
    }

    public void destroy() {
        this.l = false;
        UnifiedInterstitialAD unifiedInterstitialAD = this.n;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.destroy();
        }
        if (this.u != null) {
            this.u = null;
        }
        TTFullScreenVideoAd tTFullScreenVideoAd = this.o;
        if (tTFullScreenVideoAd != null && tTFullScreenVideoAd.getMediationManager() != null) {
            this.o.getMediationManager().destroy();
        }
    }

    public void enableAudio(boolean z2) {
        this.w = z2;
    }

    public boolean isAdValid() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.n;
        if ((unifiedInterstitialAD != null && unifiedInterstitialAD.isValid()) || this.u != null) {
            return true;
        }
        xxIXOIIO xxixoiio = this.p;
        if (xxixoiio != null && xxixoiio.x0XOIxOo()) {
            return true;
        }
        ExpressInterstitialAd expressInterstitialAd = this.x;
        if (expressInterstitialAd != null && expressInterstitialAd.isReady()) {
            return true;
        }
        InterstitialAd interstitialAd = this.y;
        if (interstitialAd != null && interstitialAd.isLoaded()) {
            return true;
        }
        if (this.o == null || !this.q) {
            return false;
        }
        return true;
    }

    public void loadAD() {
        a();
        if (this.l) {
            Log.e("adsplus", "已经打开误重复Load,请show或者close");
        }
        if (!this.l) {
            this.l = true;
            load();
        }
    }

    public void setDownloadConfirmListener(ADPDownloadConfirmListener aDPDownloadConfirmListener) {
        this.r = aDPDownloadConfirmListener;
    }

    public void show() {
        this.l = false;
        UnifiedInterstitialAD unifiedInterstitialAD = this.n;
        if (unifiedInterstitialAD == null || !unifiedInterstitialAD.isValid()) {
            TTFullScreenVideoAd tTFullScreenVideoAd = this.o;
            if (tTFullScreenVideoAd == null || !this.q) {
                xxIXOIIO xxixoiio = this.p;
                if (xxixoiio == null || !xxixoiio.x0XOIxOo()) {
                    ExpressInterstitialAd expressInterstitialAd = this.x;
                    if (expressInterstitialAd == null || !expressInterstitialAd.isReady()) {
                        InterstitialAd interstitialAd = this.y;
                        if (interstitialAd == null || !interstitialAd.isLoaded()) {
                            g();
                        } else {
                            this.y.show(this.g);
                        }
                    } else {
                        this.x.show();
                    }
                } else {
                    this.p.IIXOooo(this.g);
                }
            } else {
                tTFullScreenVideoAd.showFullScreenVideoAd(this.g);
            }
        } else if (this.k) {
            this.n.showFullScreenAD(this.g);
        } else {
            this.n.show();
        }
    }

    private void d() {
        if ("tencent".equals(this.s.getSource())) {
            h(this.s.getId());
        } else if ("kuaishou".equals(this.s.getSource())) {
            f(this.s.getId());
        } else if ("gromore".equals(this.s.getSource())) {
            c(this.s.getId());
        } else if ("bytedance".equals(this.s.getSource())) {
            c(this.s.getId());
        } else if ("octopus".equals(this.s.getSource())) {
            g(this.s.getId());
        } else if ("baidu".equals(this.s.getSource())) {
            b(this.s.getId());
        } else if ("huawei".equals(this.s.getSource())) {
            e(this.s.getId());
        } else {
            this.l = false;
            if (this.t.size() <= 0) {
                a("gromore", new AdpError("-1", "no ad ads"));
            } else {
                c();
            }
        }
    }

    private void e(String str) {
        try {
            if (!h.a()) {
                h.a((Context) this.g.getApplication());
            }
            c(this.g, this.h, "huawei", "2", this.s);
            InterstitialAd interstitialAd = new InterstitialAd(this.g);
            this.y = interstitialAd;
            interstitialAd.setAdId(str);
            this.y.setAdListener(new c());
            AdParam a2 = h.a(5000);
            VideoConfiguration.Builder builder = new VideoConfiguration.Builder();
            builder.setStartMuted(!this.w);
            this.y.setVideoConfiguration(builder.build());
            this.y.loadAd(a2);
        } catch (Exception e2) {
            e2.printStackTrace();
            this.l = false;
            if (this.t.size() <= 0) {
                a("adsplus", new AdpError("-1", "" + e2.getMessage()));
                return;
            }
            c();
        }
    }

    private void f(String str) {
        long j2;
        try {
            j2 = Long.parseLong(str);
        } catch (NumberFormatException unused) {
            try {
                a("adsplus", new AdpError("-1", "adid NumberFormatException"));
                this.l = false;
                j2 = 0;
            } catch (Exception e2) {
                e2.printStackTrace();
                this.l = false;
                if (this.t.size() <= 0) {
                    a("kuaishou", new AdpError("-1", "" + e2.getMessage()));
                    return;
                }
                c();
                return;
            }
        }
        this.u = null;
        c(this.g, this.h, "kuaishou", "2", this.s);
        KsAdSDK.getLoadManager().loadInterstitialAd(new KsScene.Builder(j2).setBackUrl("ksad://returnback").build(), new e());
    }

    private void g(String str) {
        try {
            if (!com.adp.sdk.utils.b.a("com.octopus.ad.InterstitialAd")) {
                this.l = false;
                if (this.t.size() <= 0) {
                    a("octopus", new AdpError("-1", "没有合适的广告"));
                } else {
                    c();
                }
            } else {
                try {
                    if (!k.a()) {
                        k.a((Context) this.g);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.p = null;
                c(this.g, this.h, "octopus", "2", this.s);
                xxIXOIIO xxixoiio = new xxIXOIIO(this.g, str, new b());
                this.p = xxixoiio;
                xxixoiio.Oxx0xo(true);
                this.p.Oo();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            this.l = false;
            if (this.t.size() <= 0) {
                a("octopus", new AdpError("-1", "" + e3.getMessage()));
                return;
            }
            c();
        }
    }

    private void h(String str) {
        if (g.a()) {
            i(str);
        } else if (!g.a(this.g, new i(str))) {
            this.l = false;
            if (this.t.size() <= 0) {
                a("gromore", new AdpError("-1", "ads gdt is error"));
            } else {
                c();
            }
        }
    }

    /* access modifiers changed from: private */
    public void i(String str) {
        try {
            a(str);
            f();
            this.k = this.j.getFullScreen();
            c(this.g, this.h, "tencent", "2", this.s);
            if (this.k) {
                this.n.loadFullScreenAD();
            } else {
                this.n.loadAD();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            this.l = false;
            if (this.t.size() <= 0) {
                a("tencent", new AdpError("-1", "" + e2.getMessage()));
                return;
            }
            c();
        }
    }

    private void j(String str) {
        Activity activity = this.g;
        if (activity != null) {
            new com.adp.sdk.utils.d(activity).a("intersititial_index", str);
        }
    }

    public void c(Context context, String str, String str2, String str3, SourceVO sourceVO) {
        super.c(context, str, str2, str3, sourceVO);
    }

    /* access modifiers changed from: private */
    public void c() {
        int size = this.t.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            if ((this.s.getId() + "").equals(this.t.get(size).getId() + "")) {
                this.t.remove(size);
                break;
            }
            size--;
        }
        if (this.t.size() > 0) {
            this.s = this.t.get(0);
            this.t.remove(0);
            d();
        }
    }

    private void b() {
        AdInfo adInfo = a.b;
        int i2 = 0;
        if (adInfo == null || adInfo.getAdUnits() == null || adInfo.getAdUnits().size() <= 0 || !"0".equals(adInfo.getStatus())) {
            a("adsplus", new AdpError("B002", this.g.getString(R.string.B002)));
            this.l = false;
            return;
        }
        for (AdItem next : adInfo.getAdUnits()) {
            if (ExploreConstants.SCENE_INTERSTITIAL.equals(next.getType()) && this.h.equals(next.getAdUnitId())) {
                this.j = next;
            }
        }
        AdItem adItem = this.j;
        if (adItem == null) {
            a("adsplus", new AdpError("B003", this.g.getString(R.string.B003)));
            this.l = false;
        } else if (!adItem.isEnable()) {
            a("adsplus", new AdpError("B004", this.g.getString(R.string.B004)));
            this.l = false;
        } else {
            String b2 = a.b(this.j, (Context) this.g);
            if (b2 != null) {
                a("adsplus", new AdpError("C001", b2));
            } else if (this.j.getAdSource() == null || this.j.getAdSource().isEmpty()) {
                a("adsplus", new AdpError("B003", this.g.getString(R.string.B003)));
            } else {
                try {
                    this.v = this.j.isOpenLogs();
                } catch (Exception unused) {
                }
                int parseInt = Integer.parseInt(new com.adp.sdk.utils.d(this.g).b("intersititial_index", "0"));
                if (!b.a(this.j, parseInt)) {
                    i2 = parseInt;
                }
                SourceVO a2 = b.a(this.j, i2, this.g);
                this.s = a2;
                if (a2 == null) {
                    a("adsplus", new AdpError("B003", this.g.getString(R.string.B003)));
                    return;
                }
                this.t = b.a(this.j, a2);
                d();
                j((i2 + 1) + "");
            }
        }
    }

    public ADPInterstitial(Activity activity, String str, ADPInterstitialListener aDPInterstitialListener) {
        this.g = activity;
        this.h = str;
        this.i = aDPInterstitialListener;
        d.a(activity.getApplication(), (com.adp.sdk.listener.a) null);
    }

    /* access modifiers changed from: private */
    public void a(String str, AdpError adpError) {
        ADPInterstitialListener aDPInterstitialListener = this.i;
        if (aDPInterstitialListener != null) {
            aDPInterstitialListener.onADError(adpError);
        }
        String str2 = str + xoXoI.f16453oxoX + adpError.getCode() + xoXoI.f16453oxoX + adpError.getMessage();
        if (this.v) {
            c.a().a((Context) this.g, this.h, str2, "2", this.s);
        }
    }

    private void c(String str) {
        Activity activity = this.g;
        if (activity == null || activity.isFinishing() || !ADP.isInitSuccess()) {
            a("adsplus", new AdpError("-1", "ad is not init"));
        } else if (!f.a()) {
            f.a(this.g, new h(str));
        } else {
            d(str);
        }
    }

    private void a(String str) {
        UnifiedInterstitialAD unifiedInterstitialAD = this.n;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.close();
            this.n.destroy();
        }
        this.n = new UnifiedInterstitialAD(this.g, str, new a());
    }

    private void f() {
        VideoOption.Builder builder = new VideoOption.Builder();
        builder.build();
        this.n.setVideoOption(builder.setAutoPlayMuted(!this.w).setAutoPlayPolicy(1).setDetailPageMuted(false).build());
    }

    /* access modifiers changed from: private */
    public void e() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.n;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.setMediaListener(new j(this));
        }
    }

    /* access modifiers changed from: private */
    public void d(String str) {
        try {
            if (this.m == null) {
                this.m = ADP.getTTAdManager().createAdNative(this.g);
            }
            this.k = this.j.getFullScreen();
            c(this.g, this.h, "gromore", "2", this.s);
            this.m.loadFullScreenVideoAd(new AdSlot.Builder().setCodeId(str).setOrientation(1).setMediationAdSlot(new MediationAdSlot.Builder().setMuted(!this.w).setVolume(0.1f).setBidNotify(true).build()).build(), new g());
        } catch (Exception e2) {
            e2.printStackTrace();
            this.l = false;
            if (this.t.size() <= 0) {
                a("gromore", new AdpError("-1", "" + e2.getMessage()));
                return;
            }
            c();
        }
    }

    private void g() {
        if (this.u != null) {
            KsVideoPlayConfig build = new KsVideoPlayConfig.Builder().videoSoundEnable(this.w).showLandscape(this.g.getRequestedOrientation() == 0).build();
            this.u.setAdInteractionListener(new f());
            this.u.showInterstitialAd(this.g, build);
        }
    }

    private void b(String str) {
        try {
            if (d.a()) {
                c(this.g, this.h, "baidu", "2", this.s);
                ExpressInterstitialAd expressInterstitialAd = new ExpressInterstitialAd(this.g, str);
                this.x = expressInterstitialAd;
                expressInterstitialAd.setLoadListener(new d());
                this.x.setDialogFrame(true);
                this.x.load();
            } else if (this.t.size() <= 0) {
                a("adsplus", new AdpError("-1", "bd:no ads"));
            } else {
                c();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            this.l = false;
            if (this.t.size() <= 0) {
                a("adsplus", new AdpError("-1", "" + e2.getMessage()));
                return;
            }
            c();
        }
    }
}
