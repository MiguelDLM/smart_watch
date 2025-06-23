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
import oOoIIO0.xoIox;
import oOoIIO0.xxIXOIIO;

/* loaded from: classes.dex */
public class ADPInterstitial extends com.adp.sdk.e {
    private Activity g;
    private String h;
    private ADPInterstitialListener i;
    private AdItem j;
    private TTAdNative m;
    private UnifiedInterstitialAD n;
    private TTFullScreenVideoAd o;
    private xxIXOIIO p;
    private boolean q;
    private ADPDownloadConfirmListener r;
    private SourceVO s;
    private KsInterstitialAd u;
    private ExpressInterstitialAd x;
    private InterstitialAd y;
    private boolean k = false;
    private boolean l = false;
    private ArrayList<SourceVO> t = new ArrayList<>();
    private boolean v = true;
    private boolean w = true;
    private Handler z = new Handler();

    /* loaded from: classes.dex */
    public interface ADPInterstitialListener {
        void onADClicked();

        void onADClosed();

        void onADError(AdpError adpError);

        void onADOpened();

        void onADPresent();

        void onADReceive();

        void onVideoCached();
    }

    /* loaded from: classes.dex */
    public class a implements UnifiedInterstitialADListener {

        /* renamed from: com.adp.sdk.ADPInterstitial$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0087a implements DownloadConfirmListener {

            /* renamed from: com.adp.sdk.ADPInterstitial$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C0088a implements ADPDownloadConfirmCallBack {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ DownloadConfirmCallBack f4654a;

                public C0088a(C0087a c0087a, DownloadConfirmCallBack downloadConfirmCallBack) {
                    this.f4654a = downloadConfirmCallBack;
                }

                @Override // com.adp.sdk.listener.ADPDownloadConfirmCallBack
                public void onCancel() {
                    DownloadConfirmCallBack downloadConfirmCallBack = this.f4654a;
                    if (downloadConfirmCallBack != null) {
                        downloadConfirmCallBack.onCancel();
                    }
                }

                @Override // com.adp.sdk.listener.ADPDownloadConfirmCallBack
                public void onConfirm() {
                    DownloadConfirmCallBack downloadConfirmCallBack = this.f4654a;
                    if (downloadConfirmCallBack != null) {
                        downloadConfirmCallBack.onConfirm();
                    }
                }
            }

            public C0087a() {
            }

            @Override // com.qq.e.comm.compliance.DownloadConfirmListener
            public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
                ADPInterstitial.this.r.onDownloadConfirm(activity, i, str, new C0088a(this, downloadConfirmCallBack));
            }
        }

        public a() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClicked() {
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADClicked();
            }
            ADPInterstitial aDPInterstitial = ADPInterstitial.this;
            aDPInterstitial.a(aDPInterstitial.g, ADPInterstitial.this.h, "tencent", "2", ADPInterstitial.this.s);
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClosed() {
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADClosed();
            }
            ADPInterstitial.this.l = false;
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADExposure() {
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADPresent();
            }
            ADPInterstitial aDPInterstitial = ADPInterstitial.this;
            aDPInterstitial.e(aDPInterstitial.g, ADPInterstitial.this.h, "tencent", "2", ADPInterstitial.this.s);
            com.adp.sdk.a.a(ADPInterstitial.this.j, ADPInterstitial.this.g);
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADLeftApplication() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADOpened() {
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADOpened();
            }
            ADPInterstitial.this.l = false;
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADReceive() {
            ADPInterstitial.this.e();
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADReceive();
            }
            ADPInterstitial.this.q = false;
            ADPInterstitial.this.l = false;
            ADPInterstitial aDPInterstitial = ADPInterstitial.this;
            aDPInterstitial.b(aDPInterstitial.g, ADPInterstitial.this.h, "tencent", "2", ADPInterstitial.this.s);
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onNoAD(AdError adError) {
            ADPInterstitial.this.l = false;
            if (ADPInterstitial.this.t.size() > 0) {
                ADPInterstitial.this.c();
                return;
            }
            ADPInterstitial.this.a("tencent", new AdpError(adError.getErrorCode() + "", adError.getErrorMsg()));
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderFail() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderSuccess() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onVideoCached() {
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onVideoCached();
            }
            if (ADPInterstitial.this.r != null && ADPInterstitial.this.n != null) {
                try {
                    ADPInterstitial.this.n.setDownloadConfirmListener(new C0087a());
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements xoIox {
        public b() {
        }

        @Override // oOoIIO0.xoIox
        public void onAdCacheLoaded() {
        }

        @Override // oOoIIO0.xoIox
        public void onAdClicked() {
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADClicked();
            }
            ADPInterstitial aDPInterstitial = ADPInterstitial.this;
            aDPInterstitial.a(aDPInterstitial.g, ADPInterstitial.this.h, "octopus", "2", ADPInterstitial.this.s);
        }

        @Override // oOoIIO0.xoIox
        public void onAdClosed() {
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADClosed();
            }
            ADPInterstitial.this.l = false;
            ADPInterstitial.this.p = null;
        }

        @Override // oOoIIO0.xoIox
        public void onAdFailedToLoad(int i) {
            ADPInterstitial.this.l = false;
            if (ADPInterstitial.this.t.size() > 0) {
                ADPInterstitial.this.c();
                return;
            }
            ADPInterstitial.this.a("octopus", new AdpError(i + "", "octo:errorCode" + i));
        }

        @Override // oOoIIO0.xoIox
        public void onAdLoaded() {
            try {
                if (ADPInterstitial.this.p == null) {
                    ADPInterstitial aDPInterstitial = ADPInterstitial.this;
                    aDPInterstitial.b(aDPInterstitial.g, ADPInterstitial.this.h, "octopus", "2", ADPInterstitial.this.s);
                } else {
                    ADPInterstitial aDPInterstitial2 = ADPInterstitial.this;
                    Activity activity = aDPInterstitial2.g;
                    String str = ADPInterstitial.this.h;
                    aDPInterstitial2.a(activity, str, "octopus", "2", ADPInterstitial.this.s, ADPInterstitial.this.p.OOXIXo() + "");
                }
                if (ADPInterstitial.this.s.getPrice() != null) {
                    int parseInt = Integer.parseInt(ADPInterstitial.this.s.getPrice());
                    if (parseInt > ADPInterstitial.this.p.OOXIXo()) {
                        ADPInterstitial.this.p.II0XooXoX(parseInt, oOoIIO0.oIX0oI.f32047II0xO0, oOoIIO0.oIX0oI.f32051Oxx0IOOO);
                        ADPInterstitial.this.l = false;
                        if (ADPInterstitial.this.t.size() > 0) {
                            ADPInterstitial.this.c();
                            return;
                        } else {
                            ADPInterstitial.this.a("octopus", new AdpError("-1", "没有找到合适广告"));
                            return;
                        }
                    }
                    ADPInterstitial.this.p.II0xO0(parseInt);
                }
            } catch (Exception unused) {
            }
            ADPInterstitial.this.l = false;
            ADPInterstitial.this.q = true;
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADReceive();
            }
        }

        @Override // oOoIIO0.xoIox
        public void onAdShown() {
            ADPInterstitial.this.l = false;
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADOpened();
            }
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADPresent();
            }
            ADPInterstitial aDPInterstitial = ADPInterstitial.this;
            aDPInterstitial.e(aDPInterstitial.g, ADPInterstitial.this.h, "octopus", "2", ADPInterstitial.this.s);
            com.adp.sdk.a.a(ADPInterstitial.this.j, ADPInterstitial.this.g);
        }
    }

    /* loaded from: classes.dex */
    public class c extends AdListener {
        public c() {
        }

        @Override // com.huawei.hms.ads.AdListener
        @GlobalApi
        public void onAdClicked() {
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADClicked();
            }
            ADPInterstitial aDPInterstitial = ADPInterstitial.this;
            aDPInterstitial.a(aDPInterstitial.g, ADPInterstitial.this.h, "huawei", "2", ADPInterstitial.this.s);
        }

        @Override // com.huawei.hms.ads.AdListener
        @GlobalApi
        public void onAdClosed() {
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADClosed();
            }
            ADPInterstitial.this.l = false;
            ADPInterstitial.this.y = null;
        }

        @Override // com.huawei.hms.ads.AdListener
        @GlobalApi
        public void onAdFailed(int i) {
            ADPInterstitial.this.l = false;
            if (ADPInterstitial.this.t.size() > 0) {
                ADPInterstitial.this.c();
                return;
            }
            ADPInterstitial.this.a("huawei", new AdpError("" + i, i + ">huawei"));
        }

        @Override // com.huawei.hms.ads.AdListener
        @GlobalApi
        public void onAdImpression() {
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADPresent();
            }
            ADPInterstitial aDPInterstitial = ADPInterstitial.this;
            aDPInterstitial.e(aDPInterstitial.g, ADPInterstitial.this.h, "huawei", "2", ADPInterstitial.this.s);
        }

        @Override // com.huawei.hms.ads.AdListener
        @GlobalApi
        public void onAdLeave() {
        }

        @Override // com.huawei.hms.ads.AdListener
        @GlobalApi
        public void onAdLoaded() {
            ADPInterstitial aDPInterstitial = ADPInterstitial.this;
            aDPInterstitial.b(aDPInterstitial.g, ADPInterstitial.this.h, "huawei", "2", ADPInterstitial.this.s);
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADReceive();
            }
            ADPInterstitial.this.q = false;
            ADPInterstitial.this.l = false;
        }

        @Override // com.huawei.hms.ads.AdListener
        @GlobalApi
        public void onAdOpened() {
            ADPInterstitial.this.l = false;
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADOpened();
            }
            com.adp.sdk.a.a(ADPInterstitial.this.j, ADPInterstitial.this.g);
        }
    }

    /* loaded from: classes.dex */
    public class d implements ExpressInterstitialListener {
        public d() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onADExposed() {
            ADPInterstitial.this.l = false;
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADOpened();
            }
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADPresent();
            }
            ADPInterstitial aDPInterstitial = ADPInterstitial.this;
            aDPInterstitial.e(aDPInterstitial.g, ADPInterstitial.this.h, "baidu", "2", ADPInterstitial.this.s);
            com.adp.sdk.a.a(ADPInterstitial.this.j, ADPInterstitial.this.g);
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onADExposureFailed() {
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADClosed();
            }
            ADPInterstitial.this.l = false;
            ADPInterstitial.this.u = null;
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onADLoaded() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onAdCacheFailed() {
            ADPInterstitial.this.l = false;
            if (ADPInterstitial.this.t.size() > 0) {
                ADPInterstitial.this.c();
            } else {
                ADPInterstitial.this.a("baidu", new AdpError("-1", "缓存失败"));
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onAdCacheSuccess() {
            ADPInterstitial aDPInterstitial = ADPInterstitial.this;
            aDPInterstitial.b(aDPInterstitial.g, ADPInterstitial.this.h, "baidu", "2", ADPInterstitial.this.s);
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADReceive();
            }
            ADPInterstitial.this.q = false;
            ADPInterstitial.this.l = false;
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onAdClick() {
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADClicked();
            }
            ADPInterstitial aDPInterstitial = ADPInterstitial.this;
            aDPInterstitial.a(aDPInterstitial.g, ADPInterstitial.this.h, "baidu", "2", ADPInterstitial.this.s);
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onAdClose() {
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADClosed();
            }
            ADPInterstitial.this.l = false;
            ADPInterstitial.this.u = null;
            ADPInterstitial.this.x = null;
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onAdFailed(int i, String str) {
            ADPInterstitial.this.l = false;
            if (ADPInterstitial.this.t.size() > 0) {
                ADPInterstitial.this.c();
                return;
            }
            ADPInterstitial.this.a("baidu", new AdpError(i + "", str));
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onLpClosed() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onNoAd(int i, String str) {
            ADPInterstitial.this.l = false;
            if (ADPInterstitial.this.t.size() > 0) {
                ADPInterstitial.this.c();
                return;
            }
            ADPInterstitial.this.a("baidu", new AdpError(i + "", str));
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onVideoDownloadFailed() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onVideoDownloadSuccess() {
        }
    }

    /* loaded from: classes.dex */
    public class e implements KsLoadManager.InterstitialAdListener {
        public e() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public void onError(int i, String str) {
            ADPInterstitial.this.l = false;
            if (ADPInterstitial.this.t.size() > 0) {
                ADPInterstitial.this.c();
                return;
            }
            ADPInterstitial.this.a("tencent", new AdpError(i + "", str));
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public void onInterstitialAdLoad(@Nullable List<KsInterstitialAd> list) {
            if (list == null || list.size() <= 0) {
                ADPInterstitial.this.u = null;
                ADPInterstitial.this.l = false;
                if (list.size() > 0) {
                    ADPInterstitial.this.c();
                    return;
                } else {
                    ADPInterstitial.this.a("adsplus", new AdpError("-1", "kuaisou adlist is null"));
                    return;
                }
            }
            ADPInterstitial aDPInterstitial = ADPInterstitial.this;
            aDPInterstitial.b(aDPInterstitial.g, ADPInterstitial.this.h, "kuaishou", "2", ADPInterstitial.this.s);
            ADPInterstitial.this.u = list.get(0);
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADReceive();
            }
            ADPInterstitial.this.q = false;
            ADPInterstitial.this.l = false;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public void onRequestResult(int i) {
        }
    }

    /* loaded from: classes.dex */
    public class f implements KsInterstitialAd.AdInteractionListener {
        public f() {
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onAdClicked() {
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADClicked();
            }
            ADPInterstitial aDPInterstitial = ADPInterstitial.this;
            aDPInterstitial.a(aDPInterstitial.g, ADPInterstitial.this.h, "kuaishou", "2", ADPInterstitial.this.s);
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onAdClosed() {
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADClosed();
            }
            ADPInterstitial.this.l = false;
            ADPInterstitial.this.u = null;
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onAdShow() {
            ADPInterstitial.this.l = false;
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADOpened();
            }
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADPresent();
            }
            ADPInterstitial aDPInterstitial = ADPInterstitial.this;
            aDPInterstitial.e(aDPInterstitial.g, ADPInterstitial.this.h, "kuaishou", "2", ADPInterstitial.this.s);
            com.adp.sdk.a.a(ADPInterstitial.this.j, ADPInterstitial.this.g);
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onPageDismiss() {
            ADPInterstitial.this.u = null;
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADClosed();
            }
            ADPInterstitial.this.l = false;
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onSkippedAd() {
            ADPInterstitial.this.u = null;
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADClosed();
            }
            ADPInterstitial.this.l = false;
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onVideoPlayEnd() {
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onVideoPlayError(int i, int i2) {
            ADPInterstitial.this.u = null;
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onVideoPlayStart() {
        }
    }

    /* loaded from: classes.dex */
    public class g implements TTAdNative.FullScreenVideoAdListener {

        /* loaded from: classes.dex */
        public class a implements TTFullScreenVideoAd.FullScreenVideoAdInteractionListener {
            public a() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onAdClose() {
                if (ADPInterstitial.this.i != null) {
                    ADPInterstitial.this.i.onADClosed();
                }
                ADPInterstitial.this.o = null;
                ADPInterstitial.this.l = false;
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onAdShow() {
                ADPInterstitial.this.l = false;
                if (ADPInterstitial.this.i != null) {
                    ADPInterstitial.this.i.onADOpened();
                }
                if (ADPInterstitial.this.i != null) {
                    ADPInterstitial.this.i.onADPresent();
                }
                ADPInterstitial aDPInterstitial = ADPInterstitial.this;
                aDPInterstitial.e(aDPInterstitial.g, ADPInterstitial.this.h, "gromore", "2", ADPInterstitial.this.s);
                com.adp.sdk.a.a(ADPInterstitial.this.j, ADPInterstitial.this.g);
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onAdVideoBarClick() {
                if (ADPInterstitial.this.i != null) {
                    ADPInterstitial.this.i.onADClicked();
                }
                ADPInterstitial aDPInterstitial = ADPInterstitial.this;
                aDPInterstitial.a(aDPInterstitial.g, ADPInterstitial.this.h, "gromore", "2", ADPInterstitial.this.s);
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onSkippedVideo() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onVideoComplete() {
            }
        }

        public g() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onError(int i, String str) {
            ADPInterstitial.this.o = null;
            ADPInterstitial.this.l = false;
            if (ADPInterstitial.this.t.size() > 0) {
                ADPInterstitial.this.c();
                return;
            }
            ADPInterstitial.this.a("gromore", new AdpError(i + "", str));
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
            ADPInterstitial.this.o = tTFullScreenVideoAd;
            ADPInterstitial.this.q = false;
            ADPInterstitial aDPInterstitial = ADPInterstitial.this;
            aDPInterstitial.b(aDPInterstitial.g, ADPInterstitial.this.h, "gromore", "2", ADPInterstitial.this.s);
            ADPInterstitial.this.o.setFullScreenVideoAdInteractionListener(new a());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoCached() {
            ADPInterstitial.this.l = false;
            ADPInterstitial.this.q = true;
            if (ADPInterstitial.this.i != null) {
                ADPInterstitial.this.i.onADReceive();
            }
            boolean unused = ADPInterstitial.this.v;
        }
    }

    /* loaded from: classes.dex */
    public class h implements f.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4662a;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                h hVar = h.this;
                ADPInterstitial.this.d(hVar.f4662a);
            }
        }

        public h(String str) {
            this.f4662a = str;
        }

        @Override // com.adp.sdk.f.c
        public void a(int i, String str) {
            ADPInterstitial.this.l = false;
            if (ADPInterstitial.this.t.size() > 0) {
                ADPInterstitial.this.c();
                return;
            }
            ADPInterstitial.this.a("gromore", new AdpError(i + "", str));
        }

        @Override // com.adp.sdk.f.c
        public void success() {
            ADPInterstitial.this.g.runOnUiThread(new a());
        }
    }

    /* loaded from: classes.dex */
    public class i implements g.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4664a;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                i iVar = i.this;
                ADPInterstitial.this.i(iVar.f4664a);
            }
        }

        public i(String str) {
            this.f4664a = str;
        }

        @Override // com.adp.sdk.g.b
        public void a() {
            ADPInterstitial.this.l = false;
            if (ADPInterstitial.this.t.size() > 0) {
                ADPInterstitial.this.c();
            } else {
                ADPInterstitial.this.a("gromore", new AdpError("-1", "gdt error GDTAdSdk.start"));
            }
        }

        @Override // com.adp.sdk.g.b
        public void success() {
            ADPInterstitial.this.z.post(new a());
        }
    }

    /* loaded from: classes.dex */
    public class j implements UnifiedInterstitialMediaListener {
        public j(ADPInterstitial aDPInterstitial) {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public void onVideoComplete() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public void onVideoError(AdError adError) {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public void onVideoInit() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public void onVideoLoading() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public void onVideoPageClose() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public void onVideoPageOpen() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public void onVideoPause() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public void onVideoReady(long j) {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public void onVideoStart() {
        }
    }

    private ADPInterstitial() {
    }

    private void load() {
        if (ADP.isInitSuccess()) {
            a();
            b();
        } else {
            this.l = false;
            a("adsplus", new AdpError("-1", "adp sdk is not initialized"));
        }
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

    public void enableAudio(boolean z) {
        this.w = z;
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
        if (this.o != null && this.q) {
            return true;
        }
        return false;
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
        if (unifiedInterstitialAD != null && unifiedInterstitialAD.isValid()) {
            if (this.k) {
                this.n.showFullScreenAD(this.g);
                return;
            } else {
                this.n.show();
                return;
            }
        }
        TTFullScreenVideoAd tTFullScreenVideoAd = this.o;
        if (tTFullScreenVideoAd != null && this.q) {
            tTFullScreenVideoAd.showFullScreenVideoAd(this.g);
            return;
        }
        xxIXOIIO xxixoiio = this.p;
        if (xxixoiio != null && xxixoiio.x0XOIxOo()) {
            this.p.IIXOooo(this.g);
            return;
        }
        ExpressInterstitialAd expressInterstitialAd = this.x;
        if (expressInterstitialAd != null && expressInterstitialAd.isReady()) {
            this.x.show();
            return;
        }
        InterstitialAd interstitialAd = this.y;
        if (interstitialAd != null && interstitialAd.isLoaded()) {
            this.y.show(this.g);
        } else {
            g();
        }
    }

    private void d() {
        if ("tencent".equals(this.s.getSource())) {
            h(this.s.getId());
            return;
        }
        if ("kuaishou".equals(this.s.getSource())) {
            f(this.s.getId());
            return;
        }
        if ("gromore".equals(this.s.getSource())) {
            c(this.s.getId());
            return;
        }
        if ("bytedance".equals(this.s.getSource())) {
            c(this.s.getId());
            return;
        }
        if ("octopus".equals(this.s.getSource())) {
            g(this.s.getId());
            return;
        }
        if ("baidu".equals(this.s.getSource())) {
            b(this.s.getId());
            return;
        }
        if ("huawei".equals(this.s.getSource())) {
            e(this.s.getId());
            return;
        }
        this.l = false;
        if (this.t.size() <= 0) {
            a("gromore", new AdpError("-1", "no ad ads"));
        } else {
            c();
        }
    }

    private void e(String str) {
        try {
            if (!com.adp.sdk.h.a()) {
                com.adp.sdk.h.a(this.g.getApplication());
            }
            c(this.g, this.h, "huawei", "2", this.s);
            InterstitialAd interstitialAd = new InterstitialAd(this.g);
            this.y = interstitialAd;
            interstitialAd.setAdId(str);
            this.y.setAdListener(new c());
            AdParam a2 = com.adp.sdk.h.a(5000);
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
            try {
                j2 = Long.parseLong(str);
            } catch (NumberFormatException unused) {
                a("adsplus", new AdpError("-1", "adid NumberFormatException"));
                this.l = false;
                j2 = 0;
            }
            this.u = null;
            c(this.g, this.h, "kuaishou", "2", this.s);
            KsAdSDK.getLoadManager().loadInterstitialAd(new KsScene.Builder(j2).setBackUrl("ksad://returnback").build(), new e());
        } catch (Exception e2) {
            e2.printStackTrace();
            this.l = false;
            if (this.t.size() <= 0) {
                a("kuaishou", new AdpError("-1", "" + e2.getMessage()));
                return;
            }
            c();
        }
    }

    private void g(String str) {
        try {
            if (!com.adp.sdk.utils.b.a("com.octopus.ad.InterstitialAd")) {
                this.l = false;
                if (this.t.size() <= 0) {
                    a("octopus", new AdpError("-1", "没有合适的广告"));
                    return;
                } else {
                    c();
                    return;
                }
            }
            try {
                if (!k.a()) {
                    k.a(this.g);
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
        if (com.adp.sdk.g.a()) {
            i(str);
            return;
        }
        if (com.adp.sdk.g.a(this.g, new i(str))) {
            return;
        }
        this.l = false;
        if (this.t.size() <= 0) {
            a("gromore", new AdpError("-1", "ads gdt is error"));
        } else {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    @Override // com.adp.sdk.e
    public void c(Context context, String str, String str2, String str3, SourceVO sourceVO) {
        super.c(context, str, str2, str3, sourceVO);
    }

    /* JADX INFO: Access modifiers changed from: private */
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
        AdInfo adInfo = com.adp.sdk.a.b;
        if (adInfo != null && adInfo.getAdUnits() != null && adInfo.getAdUnits().size() > 0 && "0".equals(adInfo.getStatus())) {
            for (AdItem adItem : adInfo.getAdUnits()) {
                if (ExploreConstants.SCENE_INTERSTITIAL.equals(adItem.getType()) && this.h.equals(adItem.getAdUnitId())) {
                    this.j = adItem;
                }
            }
            AdItem adItem2 = this.j;
            if (adItem2 == null) {
                a("adsplus", new AdpError("B003", this.g.getString(R.string.B003)));
                this.l = false;
                return;
            }
            if (!adItem2.isEnable()) {
                a("adsplus", new AdpError("B004", this.g.getString(R.string.B004)));
                this.l = false;
                return;
            }
            String b2 = com.adp.sdk.a.b(this.j, this.g);
            if (b2 != null) {
                a("adsplus", new AdpError("C001", b2));
                return;
            }
            if (this.j.getAdSource() != null && !this.j.getAdSource().isEmpty()) {
                try {
                    this.v = this.j.isOpenLogs();
                } catch (Exception unused) {
                }
                int parseInt = Integer.parseInt(new com.adp.sdk.utils.d(this.g).b("intersititial_index", "0"));
                int i2 = com.adp.sdk.b.a(this.j, parseInt) ? 0 : parseInt;
                SourceVO a2 = com.adp.sdk.b.a(this.j, i2, this.g);
                this.s = a2;
                if (a2 == null) {
                    a("adsplus", new AdpError("B003", this.g.getString(R.string.B003)));
                    return;
                }
                this.t = com.adp.sdk.b.a(this.j, a2);
                d();
                j((i2 + 1) + "");
                return;
            }
            a("adsplus", new AdpError("B003", this.g.getString(R.string.B003)));
            return;
        }
        a("adsplus", new AdpError("B002", this.g.getString(R.string.B002)));
        this.l = false;
    }

    public ADPInterstitial(Activity activity, String str, ADPInterstitialListener aDPInterstitialListener) {
        this.g = activity;
        this.h = str;
        this.i = aDPInterstitialListener;
        com.adp.sdk.d.a(activity.getApplication(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, AdpError adpError) {
        ADPInterstitialListener aDPInterstitialListener = this.i;
        if (aDPInterstitialListener != null) {
            aDPInterstitialListener.onADError(adpError);
        }
        String str2 = str + xoXoI.f2670oxoX + adpError.getCode() + xoXoI.f2670oxoX + adpError.getMessage();
        if (this.v) {
            com.adp.sdk.c.a().a(this.g, this.h, str2, "2", this.s);
        }
    }

    private void c(String str) {
        Activity activity = this.g;
        if (activity != null && !activity.isFinishing() && ADP.isInitSuccess()) {
            if (!com.adp.sdk.f.a()) {
                com.adp.sdk.f.a(this.g, new h(str));
                return;
            } else {
                d(str);
                return;
            }
        }
        a("adsplus", new AdpError("-1", "ad is not init"));
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

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.n;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.setMediaListener(new j(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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
            if (!com.adp.sdk.d.a()) {
                if (this.t.size() <= 0) {
                    a("adsplus", new AdpError("-1", "bd:no ads"));
                    return;
                } else {
                    c();
                    return;
                }
            }
            c(this.g, this.h, "baidu", "2", this.s);
            ExpressInterstitialAd expressInterstitialAd = new ExpressInterstitialAd(this.g, str);
            this.x = expressInterstitialAd;
            expressInterstitialAd.setLoadListener(new d());
            this.x.setDialogFrame(true);
            this.x.load();
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
