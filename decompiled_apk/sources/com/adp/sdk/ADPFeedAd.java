package com.adp.sdk;

import OoOoXO0.xoXoI;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.adp.sdk.dto.AdInfo;
import com.adp.sdk.dto.AdItem;
import com.adp.sdk.dto.AdpError;
import com.adp.sdk.dto.SourceVO;
import com.adp.sdk.f;
import com.adp.sdk.g;
import com.adp.sdk.listener.ADPDownloadConfirmCallBack;
import com.adp.sdk.listener.ADPDownloadConfirmListener;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdSlot;
import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.hms.ads.nativead.NativeAd;
import com.huawei.hms.ads.nativead.NativeAdConfiguration;
import com.huawei.hms.ads.nativead.NativeAdLoader;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.feed.JADFeed;
import com.jd.ad.sdk.feed.JADFeedListener;
import com.jd.ad.sdk.multi.BuildConfig;
import com.kwad.components.offline.api.explore.model.ExploreConstants;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.octopus.ad.NativeAdResponse;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.List;
import oOoIIO0.oOoXoXO;
import oOoIIO0.ooOOo0oXI;

/* loaded from: classes.dex */
public class ADPFeedAd extends com.adp.sdk.e {
    private Activity g;
    private String h;
    private String i;
    private AdItem j;
    private ADPFeedAdListener k;
    private TTAdNative l;
    private SourceVO m;
    private int o;
    private int p;
    private ADPDownloadConfirmListener q;
    private ArrayList<SourceVO> n = new ArrayList<>();
    private boolean r = true;
    private boolean s = true;
    private Handler t = new Handler();

    /* loaded from: classes.dex */
    public interface ADPFeedAdListener {
        void onADClicked(ADPFeedAdView aDPFeedAdView);

        void onADClosed(ADPFeedAdView aDPFeedAdView);

        void onADError(AdpError adpError);

        void onADPresent(ADPFeedAdView aDPFeedAdView);

        void onADReceive(ADPFeedAdView aDPFeedAdView);
    }

    /* loaded from: classes.dex */
    public class a implements ooOOo0oXI {

        /* renamed from: a, reason: collision with root package name */
        ADPFeedAdView f4633a = null;
        final /* synthetic */ oOoXoXO b;

        /* renamed from: com.adp.sdk.ADPFeedAd$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0085a implements xXoOI00O.oIX0oI {

            /* renamed from: a, reason: collision with root package name */
            boolean f4634a = false;

            public C0085a() {
            }

            @Override // xXoOI00O.oIX0oI
            public void onADExposed() {
                if (ADPFeedAd.this.k != null) {
                    ADPFeedAd.this.k.onADPresent(a.this.f4633a);
                }
                ADPFeedAd aDPFeedAd = ADPFeedAd.this;
                aDPFeedAd.e(aDPFeedAd.g, ADPFeedAd.this.h, "octopus", "6", ADPFeedAd.this.m);
                if (!this.f4634a) {
                    com.adp.sdk.a.a(ADPFeedAd.this.j, ADPFeedAd.this.g);
                    this.f4634a = true;
                }
            }

            @Override // xXoOI00O.oIX0oI
            public void onAdClick() {
                if (ADPFeedAd.this.k != null) {
                    ADPFeedAd.this.k.onADClicked(a.this.f4633a);
                }
                ADPFeedAd aDPFeedAd = ADPFeedAd.this;
                aDPFeedAd.a(aDPFeedAd.g, ADPFeedAd.this.h, "kuaishou", "6", ADPFeedAd.this.m);
            }

            @Override // xXoOI00O.oIX0oI
            public void onAdClose() {
                if (ADPFeedAd.this.k != null) {
                    ADPFeedAd.this.k.onADClosed(a.this.f4633a);
                }
            }

            @Override // xXoOI00O.oIX0oI
            public void onAdRenderFailed(int i) {
                ADPFeedAd.this.a("octopus", new AdpError("-1", "octo onAdRenderFailed"));
            }
        }

        public a(oOoXoXO oooxoxo) {
            this.b = oooxoxo;
        }

        private xXoOI00O.oIX0oI a() {
            return new C0085a();
        }

        @Override // oOoIIO0.ooOOo0oXI
        public void onAdFailed(int i) {
            if (ADPFeedAd.this.n.size() > 0) {
                ADPFeedAd.this.d();
                return;
            }
            ADPFeedAd.this.a("octopus", new AdpError(i + "", "octo:" + i));
        }

        @Override // oOoIIO0.ooOOo0oXI
        public void onAdLoaded(NativeAdResponse nativeAdResponse) {
            int a2;
            if (ADPFeedAd.this.g == null) {
                return;
            }
            if (nativeAdResponse == null) {
                ADPFeedAd aDPFeedAd = ADPFeedAd.this;
                aDPFeedAd.b(aDPFeedAd.g, ADPFeedAd.this.h, "octopus", "6", ADPFeedAd.this.m);
            } else {
                ADPFeedAd aDPFeedAd2 = ADPFeedAd.this;
                aDPFeedAd2.a(aDPFeedAd2.g, ADPFeedAd.this.h, "octopus", "6", ADPFeedAd.this.m, nativeAdResponse.getPrice() + "");
            }
            if (nativeAdResponse == null) {
                if (ADPFeedAd.this.n.size() > 0) {
                    ADPFeedAd.this.d();
                    return;
                } else {
                    ADPFeedAd.this.a("octopus", new AdpError("-1", "octo ad is null"));
                    return;
                }
            }
            try {
                if (ADPFeedAd.this.m.getPrice() != null) {
                    int parseInt = Integer.parseInt(ADPFeedAd.this.m.getPrice());
                    if (parseInt > nativeAdResponse.getPrice()) {
                        this.b.II0XooXoX(parseInt, oOoIIO0.oIX0oI.f32047II0xO0, oOoIIO0.oIX0oI.f32051Oxx0IOOO);
                        ADPFeedAd.this.d();
                        return;
                    }
                    this.b.II0xO0(parseInt);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f4633a = new ADPFeedAdView(ADPFeedAd.this.g, a(), nativeAdResponse);
            if (ADPFeedAd.this.o <= 0) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) ADPFeedAd.this.g.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                a2 = displayMetrics.widthPixels;
            } else {
                a2 = com.adp.sdk.utils.h.a(ADPFeedAd.this.g, ADPFeedAd.this.o);
            }
            this.f4633a.setLayoutParams(new ViewGroup.LayoutParams(a2, -2));
            if (ADPFeedAd.this.k != null) {
                ADPFeedAd.this.k.onADReceive(this.f4633a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements g.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4635a;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                ADPFeedAd.this.f(bVar.f4635a);
            }
        }

        public b(String str) {
            this.f4635a = str;
        }

        @Override // com.adp.sdk.g.b
        public void a() {
            if (ADPFeedAd.this.n.size() > 0) {
                ADPFeedAd.this.d();
            } else {
                ADPFeedAd.this.a("gromore", new AdpError("-1", "gdt error GDTAdSdk.start"));
            }
        }

        @Override // com.adp.sdk.g.b
        public void success() {
            ADPFeedAd.this.t.post(new a());
        }
    }

    /* loaded from: classes.dex */
    public class c implements NativeExpressAD.NativeExpressADListener {

        /* renamed from: a, reason: collision with root package name */
        boolean f4637a = false;

        /* loaded from: classes.dex */
        public class a implements DownloadConfirmListener {

            /* renamed from: com.adp.sdk.ADPFeedAd$c$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C0086a implements ADPDownloadConfirmCallBack {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ DownloadConfirmCallBack f4639a;

                public C0086a(a aVar, DownloadConfirmCallBack downloadConfirmCallBack) {
                    this.f4639a = downloadConfirmCallBack;
                }

                @Override // com.adp.sdk.listener.ADPDownloadConfirmCallBack
                public void onCancel() {
                    DownloadConfirmCallBack downloadConfirmCallBack = this.f4639a;
                    if (downloadConfirmCallBack != null) {
                        downloadConfirmCallBack.onCancel();
                    }
                }

                @Override // com.adp.sdk.listener.ADPDownloadConfirmCallBack
                public void onConfirm() {
                    DownloadConfirmCallBack downloadConfirmCallBack = this.f4639a;
                    if (downloadConfirmCallBack != null) {
                        downloadConfirmCallBack.onConfirm();
                    }
                }
            }

            public a() {
            }

            @Override // com.qq.e.comm.compliance.DownloadConfirmListener
            public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
                ADPFeedAd.this.q.onDownloadConfirm(activity, i, str, new C0086a(this, downloadConfirmCallBack));
            }
        }

        public c() {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClicked(NativeExpressADView nativeExpressADView) {
            ADPFeedAdView aDPFeedAdView;
            if (ADPFeedAd.this.k != null) {
                if (nativeExpressADView.getParent() != null && (nativeExpressADView.getParent() instanceof ADPFeedAdView)) {
                    aDPFeedAdView = (ADPFeedAdView) nativeExpressADView.getParent();
                } else {
                    aDPFeedAdView = null;
                }
                ADPFeedAd.this.k.onADClicked(aDPFeedAdView);
            }
            ADPFeedAd aDPFeedAd = ADPFeedAd.this;
            aDPFeedAd.a(aDPFeedAd.g, ADPFeedAd.this.h, "tencent", "6", ADPFeedAd.this.m);
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClosed(NativeExpressADView nativeExpressADView) {
            ADPFeedAdView aDPFeedAdView;
            if (ADPFeedAd.this.k != null) {
                if (nativeExpressADView.getParent() != null && (nativeExpressADView.getParent() instanceof ADPFeedAdView)) {
                    aDPFeedAdView = (ADPFeedAdView) nativeExpressADView.getParent();
                } else {
                    aDPFeedAdView = null;
                }
                ADPFeedAd.this.k.onADClosed(aDPFeedAdView);
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADExposure(NativeExpressADView nativeExpressADView) {
            ADPFeedAdView aDPFeedAdView;
            if (nativeExpressADView.getParent() != null && (nativeExpressADView.getParent() instanceof ADPFeedAdView)) {
                aDPFeedAdView = (ADPFeedAdView) nativeExpressADView.getParent();
            } else {
                aDPFeedAdView = null;
            }
            if (ADPFeedAd.this.k != null) {
                ADPFeedAd.this.k.onADPresent(aDPFeedAdView);
            }
            ADPFeedAd aDPFeedAd = ADPFeedAd.this;
            aDPFeedAd.e(aDPFeedAd.g, ADPFeedAd.this.h, "tencent", "6", ADPFeedAd.this.m);
            if (!this.f4637a) {
                com.adp.sdk.a.a(ADPFeedAd.this.j, ADPFeedAd.this.g);
                this.f4637a = true;
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLoaded(List<NativeExpressADView> list) {
            if (ADPFeedAd.this.k != null && ADPFeedAd.this.g != null) {
                ADPFeedAd.this.k.onADReceive(new ADPFeedAdView((Context) ADPFeedAd.this.g, list.get(0)));
                ADPFeedAd aDPFeedAd = ADPFeedAd.this;
                aDPFeedAd.b(aDPFeedAd.g, ADPFeedAd.this.h, "tencent", "6", ADPFeedAd.this.m);
                if (list.size() > 0 && ADPFeedAd.this.q != null) {
                    try {
                        list.get(0).setDownloadConfirmListener(new a());
                    } catch (Exception unused) {
                    }
                }
            }
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            if (ADPFeedAd.this.n.size() > 0) {
                ADPFeedAd.this.d();
                return;
            }
            ADPFeedAd.this.a("tencent", new AdpError(adError.getErrorCode() + "", adError.getErrorMsg()));
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderFail(NativeExpressADView nativeExpressADView) {
            if (ADPFeedAd.this.n.size() > 0) {
                ADPFeedAd.this.d();
            } else {
                ADPFeedAd.this.a("tencent", new AdpError("-1", "onRenderFail"));
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
        }
    }

    /* loaded from: classes.dex */
    public class d implements KsLoadManager.FeedAdListener {

        /* renamed from: a, reason: collision with root package name */
        ADPFeedAdView f4640a = null;

        /* loaded from: classes.dex */
        public class a implements KsFeedAd.AdInteractionListener {

            /* renamed from: a, reason: collision with root package name */
            boolean f4641a = false;

            public a() {
            }

            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onAdClicked() {
                if (ADPFeedAd.this.k != null) {
                    ADPFeedAd.this.k.onADClicked(d.this.f4640a);
                }
                ADPFeedAd aDPFeedAd = ADPFeedAd.this;
                aDPFeedAd.a(aDPFeedAd.g, ADPFeedAd.this.h, "kuaishou", "6", ADPFeedAd.this.m);
            }

            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onAdShow() {
                if (ADPFeedAd.this.k != null) {
                    ADPFeedAd.this.k.onADPresent(d.this.f4640a);
                }
                ADPFeedAd aDPFeedAd = ADPFeedAd.this;
                aDPFeedAd.e(aDPFeedAd.g, ADPFeedAd.this.h, "kuaishou", "6", ADPFeedAd.this.m);
                if (!this.f4641a) {
                    com.adp.sdk.a.a(ADPFeedAd.this.j, ADPFeedAd.this.g);
                    this.f4641a = true;
                }
            }

            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onDislikeClicked() {
                if (ADPFeedAd.this.k != null) {
                    ADPFeedAd.this.k.onADClosed(d.this.f4640a);
                }
            }

            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onDownloadTipsDialogDismiss() {
            }

            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onDownloadTipsDialogShow() {
            }
        }

        public d() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public void onError(int i, String str) {
            if (ADPFeedAd.this.n.size() > 0) {
                ADPFeedAd.this.d();
                return;
            }
            ADPFeedAd.this.a("kuaishou", new AdpError(i + "", str));
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
            if (ADPFeedAd.this.g == null) {
                return;
            }
            if (list != null && !list.isEmpty()) {
                ADPFeedAd aDPFeedAd = ADPFeedAd.this;
                aDPFeedAd.b(aDPFeedAd.g, ADPFeedAd.this.h, "kuaishou", "6", ADPFeedAd.this.m);
                list.get(0).setAdInteractionListener(new a());
                View feedView = list.get(0).getFeedView(ADPFeedAd.this.g);
                if (feedView != null && feedView.getParent() == null) {
                    this.f4640a = new ADPFeedAdView(ADPFeedAd.this.g, feedView);
                    if (ADPFeedAd.this.k != null) {
                        ADPFeedAd.this.k.onADReceive(this.f4640a);
                        return;
                    }
                    return;
                }
                if (list.isEmpty()) {
                    if (list.size() > 0) {
                        ADPFeedAd.this.d();
                        return;
                    } else {
                        ADPFeedAd.this.a("adsplus", new AdpError("-1", "ks ad is null"));
                        return;
                    }
                }
                return;
            }
            if (list.size() > 0) {
                ADPFeedAd.this.d();
            } else {
                ADPFeedAd.this.a("adsplus", new AdpError("-1", "ks ad is null"));
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements JADFeedListener {

        /* renamed from: a, reason: collision with root package name */
        ADPFeedAdView f4642a = null;
        boolean b = false;

        public e() {
        }

        @Override // com.jd.ad.sdk.feed.JADFeedListener
        public void onClick() {
            if (ADPFeedAd.this.k != null) {
                ADPFeedAd.this.k.onADClicked(this.f4642a);
            }
            ADPFeedAd aDPFeedAd = ADPFeedAd.this;
            aDPFeedAd.a(aDPFeedAd.g, ADPFeedAd.this.h, BuildConfig.FLAVOR, "6", ADPFeedAd.this.m);
        }

        @Override // com.jd.ad.sdk.feed.JADFeedListener
        public void onClose() {
            if (ADPFeedAd.this.k != null) {
                ADPFeedAd.this.k.onADClosed(this.f4642a);
            }
        }

        @Override // com.jd.ad.sdk.feed.JADFeedListener
        public void onExposure() {
            if (ADPFeedAd.this.k != null) {
                ADPFeedAd.this.k.onADPresent(this.f4642a);
            }
            ADPFeedAd aDPFeedAd = ADPFeedAd.this;
            aDPFeedAd.e(aDPFeedAd.g, ADPFeedAd.this.h, BuildConfig.FLAVOR, "6", ADPFeedAd.this.m);
            if (!this.b) {
                com.adp.sdk.a.a(ADPFeedAd.this.j, ADPFeedAd.this.g);
                this.b = true;
            }
        }

        @Override // com.jd.ad.sdk.feed.JADFeedListener
        public void onLoadFailure(int i, String str) {
            if (ADPFeedAd.this.n.size() > 0) {
                ADPFeedAd.this.d();
                return;
            }
            ADPFeedAd.this.a(BuildConfig.FLAVOR, new AdpError(i + "", str));
        }

        @Override // com.jd.ad.sdk.feed.JADFeedListener
        public void onLoadSuccess() {
        }

        @Override // com.jd.ad.sdk.feed.JADFeedListener
        public void onRenderFailure(int i, String str) {
            ADPFeedAd.this.a(BuildConfig.FLAVOR, new AdpError(i + "", "jd:" + str));
        }

        @Override // com.jd.ad.sdk.feed.JADFeedListener
        public void onRenderSuccess(View view) {
            if (ADPFeedAd.this.g == null) {
                return;
            }
            if (view == null) {
                if (ADPFeedAd.this.n.size() > 0) {
                    ADPFeedAd.this.d();
                    return;
                } else {
                    ADPFeedAd.this.a("adsplus", new AdpError("-1", "jd ad is null"));
                    return;
                }
            }
            ADPFeedAd aDPFeedAd = ADPFeedAd.this;
            aDPFeedAd.b(aDPFeedAd.g, ADPFeedAd.this.h, BuildConfig.FLAVOR, "6", ADPFeedAd.this.m);
            this.f4642a = new ADPFeedAdView(ADPFeedAd.this.g, view);
            if (ADPFeedAd.this.k != null) {
                ADPFeedAd.this.k.onADReceive(this.f4642a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements TTAdDislike.DislikeInteractionCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ADPFeedAdView f4643a;

        public f(ADPFeedAdView aDPFeedAdView) {
            this.f4643a = aDPFeedAdView;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onCancel() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onSelected(int i, String str, boolean z) {
            if (ADPFeedAd.this.k != null) {
                ADPFeedAd.this.k.onADClosed(this.f4643a);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onShow() {
        }
    }

    /* loaded from: classes.dex */
    public class g implements TTAdNative.NativeExpressAdListener {

        /* loaded from: classes.dex */
        public class a implements TTNativeExpressAd.ExpressAdInteractionListener {

            /* renamed from: a, reason: collision with root package name */
            boolean f4645a = false;
            final /* synthetic */ ADPFeedAdView b;
            final /* synthetic */ TTNativeExpressAd c;

            public a(ADPFeedAdView aDPFeedAdView, TTNativeExpressAd tTNativeExpressAd) {
                this.b = aDPFeedAdView;
                this.c = tTNativeExpressAd;
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i) {
                if (ADPFeedAd.this.k != null) {
                    ADPFeedAd.this.k.onADClicked(this.b);
                }
                ADPFeedAd aDPFeedAd = ADPFeedAd.this;
                aDPFeedAd.a(aDPFeedAd.g, ADPFeedAd.this.h, "gromore", "6", ADPFeedAd.this.m);
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i) {
                if (ADPFeedAd.this.k != null) {
                    ADPFeedAd.this.k.onADPresent(this.b);
                }
                ADPFeedAd aDPFeedAd = ADPFeedAd.this;
                aDPFeedAd.e(aDPFeedAd.g, ADPFeedAd.this.h, "gromore", "6", ADPFeedAd.this.m);
                if (!this.f4645a) {
                    com.adp.sdk.a.a(ADPFeedAd.this.j, ADPFeedAd.this.g);
                    this.f4645a = true;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i) {
                ADPFeedAd.this.a("gromore", new AdpError(i + "", "onRenderFail:" + str));
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f, float f2) {
                if (f2 >= 180.0f && ("imageLeft".equals(ADPFeedAd.this.j.getStyle()) || "imageRight".equals(ADPFeedAd.this.j.getStyle()))) {
                    if (ADPFeedAd.this.k != null) {
                        ADPFeedAd.this.a("gromore", new AdpError("-1", "ads onRenderFail:广告尺寸不符合要求，过滤该广告"));
                    }
                } else if (this.c != null) {
                    this.b.removeAllViews();
                    this.b.setView(this.c.getExpressAdView());
                }
            }
        }

        public g() {
        }

        private TTNativeExpressAd.ExpressAdInteractionListener a(TTNativeExpressAd tTNativeExpressAd, ADPFeedAdView aDPFeedAdView) {
            return new a(aDPFeedAdView, tTNativeExpressAd);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onError(int i, String str) {
            if (ADPFeedAd.this.n.size() > 0) {
                ADPFeedAd.this.d();
                return;
            }
            ADPFeedAd.this.a("gromore", new AdpError(i + "", str));
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            if (ADPFeedAd.this.g == null) {
                return;
            }
            if (list == null || list.size() == 0) {
                ADPFeedAd.this.a("gromore", new AdpError("-1", "not ad"));
                return;
            }
            ADPFeedAdView aDPFeedAdView = new ADPFeedAdView(ADPFeedAd.this.g, list.get(0));
            ADPFeedAd.this.a(list.get(0), aDPFeedAdView);
            list.get(0).setExpressInteractionListener(a(list.get(0), aDPFeedAdView));
            if (ADPFeedAd.this.k != null) {
                ADPFeedAd.this.k.onADReceive(aDPFeedAdView);
            }
            ADPFeedAd aDPFeedAd = ADPFeedAd.this;
            aDPFeedAd.b(aDPFeedAd.g, ADPFeedAd.this.h, "gromore", "6", ADPFeedAd.this.m);
        }
    }

    /* loaded from: classes.dex */
    public class h implements f.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4646a;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                h hVar = h.this;
                ADPFeedAd.this.b(hVar.f4646a);
            }
        }

        public h(String str) {
            this.f4646a = str;
        }

        @Override // com.adp.sdk.f.c
        public void a(int i, String str) {
            if (ADPFeedAd.this.n.size() > 0) {
                ADPFeedAd.this.d();
                return;
            }
            ADPFeedAd.this.a("gromore", new AdpError(i + "", str));
        }

        @Override // com.adp.sdk.f.c
        public void success() {
            ADPFeedAd.this.g.runOnUiThread(new a());
        }
    }

    /* loaded from: classes.dex */
    public class i implements com.adp.sdk.listener.b {
        public i() {
        }

        @Override // com.adp.sdk.listener.b
        public void a(ADPFeedAdView aDPFeedAdView) {
            if (ADPFeedAd.this.k != null) {
                ADPFeedAd.this.k.onADClosed(aDPFeedAdView);
            }
        }
    }

    /* loaded from: classes.dex */
    public class j extends AdListener {

        /* renamed from: a, reason: collision with root package name */
        boolean f4649a = false;
        final /* synthetic */ ADPFeedAdView b;

        public j(ADPFeedAdView aDPFeedAdView) {
            this.b = aDPFeedAdView;
        }

        @Override // com.huawei.hms.ads.AdListener
        public void onAdClicked() {
            if (ADPFeedAd.this.k != null) {
                ADPFeedAd.this.k.onADClicked(this.b);
            }
            ADPFeedAd aDPFeedAd = ADPFeedAd.this;
            aDPFeedAd.a(aDPFeedAd.g, ADPFeedAd.this.h, "huawei", "6", ADPFeedAd.this.m);
        }

        @Override // com.huawei.hms.ads.AdListener
        public void onAdClosed() {
        }

        @Override // com.huawei.hms.ads.AdListener
        public void onAdFailed(int i) {
            if (ADPFeedAd.this.n.size() > 0) {
                ADPFeedAd.this.d();
                return;
            }
            ADPFeedAd.this.a("huawei", new AdpError(i + "", i + ">Huawei"));
        }

        @Override // com.huawei.hms.ads.AdListener
        public void onAdImpression() {
            if (this.f4649a) {
                return;
            }
            if (ADPFeedAd.this.k != null) {
                ADPFeedAd.this.k.onADPresent(this.b);
            }
            ADPFeedAd aDPFeedAd = ADPFeedAd.this;
            aDPFeedAd.e(aDPFeedAd.g, ADPFeedAd.this.h, "huawei", "6", ADPFeedAd.this.m);
            this.f4649a = true;
            com.adp.sdk.a.a(ADPFeedAd.this.j, ADPFeedAd.this.g);
        }

        @Override // com.huawei.hms.ads.AdListener
        public void onAdLoaded() {
        }

        @Override // com.huawei.hms.ads.AdListener
        public void onAdOpened() {
        }
    }

    /* loaded from: classes.dex */
    public class k implements NativeAd.NativeAdLoadedListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ADPFeedAdView f4650a;

        public k(ADPFeedAdView aDPFeedAdView) {
            this.f4650a = aDPFeedAdView;
        }

        private boolean a(NativeAd nativeAd) {
            int creativeType = nativeAd.getCreativeType();
            if (creativeType != 2 && creativeType != 102 && creativeType != 3 && creativeType != 6 && creativeType != 103 && creativeType != 106 && creativeType != 7 && creativeType != 107 && creativeType != 8 && creativeType != 108) {
                return false;
            }
            return true;
        }

        @Override // com.huawei.hms.ads.nativead.NativeAd.NativeAdLoadedListener
        public void onNativeAdLoaded(NativeAd nativeAd) {
            this.f4650a.setNativeHuaweiAd(nativeAd);
            if (!a(nativeAd)) {
                if (ADPFeedAd.this.n.size() > 0) {
                    ADPFeedAd.this.d();
                    return;
                } else {
                    ADPFeedAd.this.a("huawei", new AdpError("-1", "华为广告类型错误"));
                    return;
                }
            }
            ADPFeedAd aDPFeedAd = ADPFeedAd.this;
            aDPFeedAd.b(aDPFeedAd.g, ADPFeedAd.this.h, "huawei", "6", ADPFeedAd.this.m);
            if (ADPFeedAd.this.k != null && ADPFeedAd.this.g != null) {
                ADPFeedAd.this.k.onADReceive(this.f4650a);
            }
        }
    }

    private ADPFeedAd() {
    }

    private void load() {
        if (ADP.isInitSuccess()) {
            a();
            c();
        } else {
            a("adsplus", new AdpError("-1", "adp sdk is not initialized"));
        }
    }

    public void enableAudio(boolean z) {
        this.s = z;
    }

    public void loadAD() {
        load();
    }

    public void setAdHeight(int i2) {
        this.p = i2;
    }

    public void setAdWidth(int i2) {
        this.o = i2;
    }

    public void setDownloadConfirmListener(ADPDownloadConfirmListener aDPDownloadConfirmListener) {
        this.q = aDPDownloadConfirmListener;
    }

    private void c() {
        AdInfo adInfo = com.adp.sdk.a.b;
        if (adInfo != null && adInfo.getAdUnits() != null && adInfo.getAdUnits().size() > 0 && "0".equals(adInfo.getStatus())) {
            for (AdItem adItem : adInfo.getAdUnits()) {
                if (ExploreConstants.SCENE_FEED.equals(adItem.getType()) && this.h.equals(adItem.getAdUnitId())) {
                    this.j = adItem;
                }
            }
            AdItem adItem2 = this.j;
            if (adItem2 == null) {
                a("adsplus", new AdpError("B003", this.g.getString(R.string.B003)));
                return;
            }
            if (!adItem2.isEnable()) {
                a("adsplus", new AdpError("B004", this.g.getString(R.string.B004)));
                return;
            }
            String b2 = com.adp.sdk.a.b(this.j, this.g);
            if (b2 != null) {
                a("adsplus", new AdpError("C001", b2));
                return;
            }
            if (this.j.getAdSource() != null && !this.j.getAdSource().isEmpty()) {
                try {
                    this.r = this.j.isOpenLogs();
                } catch (Exception unused) {
                }
                int parseInt = Integer.parseInt(new com.adp.sdk.utils.d(this.g).b("feedad_index", "0"));
                if (com.adp.sdk.b.a(this.j, parseInt)) {
                    parseInt = 0;
                }
                SourceVO a2 = com.adp.sdk.b.a(this.j, parseInt, this.g);
                this.m = a2;
                if (a2 == null) {
                    a("adsplus", new AdpError("B003", this.g.getString(R.string.B003)));
                    return;
                }
                this.n = com.adp.sdk.b.a(this.j, a2);
                e();
                h((parseInt + 1) + "");
                return;
            }
            a("adsplus", new AdpError("B003", this.g.getString(R.string.B003)));
            return;
        }
        a("adsplus", new AdpError("B002", this.g.getString(R.string.B002)));
    }

    private void d(String str) {
        try {
            if (!com.adp.sdk.j.a()) {
                com.adp.sdk.j.a(this.g);
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) this.g.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            if (this.o <= 0) {
                this.o = com.adp.sdk.utils.h.b(this.g, displayMetrics.widthPixels);
            }
            if (this.p <= 0) {
                this.p = (int) (this.o * 0.33d);
            }
            c(this.g, this.h, BuildConfig.FLAVOR, "6", this.m);
            new JADFeed(this.g, new JADSlot.Builder().setSlotID(str).setSize(this.o, this.p).setCloseButtonHidden(false).build()).loadAd(new e());
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.n.size() <= 0) {
                a("adsplus", new AdpError("-1", "jd:no ads"));
            } else {
                d();
            }
        }
    }

    private void e() {
        if ("tencent".equals(this.m.getSource())) {
            g(this.m.getId());
            return;
        }
        if ("kuaishou".equals(this.m.getSource())) {
            e(this.m.getId());
            return;
        }
        if ("gromore".equals(this.m.getSource())) {
            a(this.m.getId());
            return;
        }
        if ("bytedance".equals(this.m.getSource())) {
            a(this.m.getId());
            return;
        }
        if ("octopus".equals(this.m.getSource())) {
            a(this.m.getId(), (oOoXoXO) null);
            return;
        }
        if ("huawei".equals(this.m.getSource())) {
            c(this.m.getId());
            return;
        }
        if (BuildConfig.FLAVOR.equals(this.m.getSource())) {
            d(this.m.getId());
        } else if (this.n.size() <= 0) {
            a("adsplus", new AdpError("-1", "no ad ads"));
        } else {
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str) {
        try {
            this.i = str;
            c(this.g, this.h, "tencent", "6", this.m);
            NativeExpressAD nativeExpressAD = new NativeExpressAD(this.g, new ADSize(-1, -2), str, new c());
            VideoOption b2 = b();
            if (b2 != null) {
                nativeExpressAD.setVideoOption(b2);
            }
            nativeExpressAD.setMinVideoDuration(0);
            nativeExpressAD.setMaxVideoDuration(0);
            nativeExpressAD.loadAD(1);
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.n.size() <= 0) {
                a("adsplus", new AdpError("-1", "no ads"));
            } else {
                d();
            }
        }
    }

    private void g(String str) {
        if (com.adp.sdk.g.a()) {
            f(str);
        } else {
            if (com.adp.sdk.g.a(this.g, new b(str))) {
                return;
            }
            if (this.n.size() <= 0) {
                a("gromore", new AdpError("-1", "ads gdt is error"));
            } else {
                d();
            }
        }
    }

    private void h(String str) {
        Activity activity = this.g;
        if (activity != null) {
            new com.adp.sdk.utils.d(activity).a("feedad_index", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        int a2;
        int a3;
        try {
            this.i = str;
            if (this.l == null) {
                this.l = ADP.getTTAdManager().createAdNative(this.g);
            }
            int i2 = this.o;
            if (i2 <= 0) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) this.g.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                a2 = displayMetrics.widthPixels;
            } else {
                a2 = com.adp.sdk.utils.h.a(this.g, i2);
            }
            int i3 = this.p;
            if (i3 <= 0) {
                if (!"imageTop".equals(this.j.getStyle()) && !"imageBottom".equals(this.j.getStyle())) {
                    a3 = com.adp.sdk.utils.h.a(this.g, 100);
                }
                a3 = com.adp.sdk.utils.h.a(this.g, 200);
            } else {
                a3 = com.adp.sdk.utils.h.a(this.g, i3);
            }
            AdSlot build = new AdSlot.Builder().setCodeId(str).setImageAcceptedSize(a2, a3).supportRenderControl().setExpressViewAcceptedSize(com.adp.sdk.utils.h.b(this.g, a2), 0.0f).setAdCount(1).setMediationAdSlot(new MediationAdSlot.Builder().setExtraObject(MediationConstant.KEY_GDT_VIDEO_OPTION, new VideoOption.Builder().setAutoPlayMuted(false).setAutoPlayPolicy(1).build()).setExtraObject(MediationConstant.KEY_BAIDU_REQUEST_PARAMETERS, new RequestParameters.Builder().downloadAppConfirmPolicy(2).build()).setExtraObject(MediationConstant.KEY_BAIDU_CACHE_VIDEO_ONLY_WIFI, Boolean.TRUE).setExtraObject(MediationConstant.KEY_GDT_DOWN_APP_CONFIG_POLICY, DownAPPConfirmPolicy.NOConfirm).build()).build();
            c(this.g, this.h, "gromore", "6", this.m);
            this.l.loadNativeExpressAd(build, new g());
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.n.size() <= 0) {
                a("adsplus", new AdpError("-1", "no ads"));
            } else {
                d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, AdpError adpError) {
        ADPFeedAdListener aDPFeedAdListener = this.k;
        if (aDPFeedAdListener != null) {
            aDPFeedAdListener.onADError(adpError);
        }
        String str2 = str + xoXoI.f2670oxoX + adpError.getCode() + xoXoI.f2670oxoX + adpError.getMessage();
        if (this.r) {
            com.adp.sdk.c.a().a(this.g, this.h, str2, "6", this.m);
        }
    }

    public ADPFeedAd(Activity activity, String str, ADPFeedAdListener aDPFeedAdListener) {
        this.g = activity;
        this.h = str;
        this.k = aDPFeedAdListener;
    }

    private void a(String str, oOoXoXO oooxoxo) {
        try {
            if (!com.adp.sdk.utils.b.a("com.octopus.ad.NativeAd")) {
                if (this.n.size() <= 0) {
                    a("adsplus", new AdpError("-1", "找不到合适的广告"));
                    return;
                } else {
                    d();
                    return;
                }
            }
            try {
                if (!com.adp.sdk.k.a()) {
                    com.adp.sdk.k.a(this.g);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            c(this.g, this.h, "octopus", "6", this.m);
            oOoXoXO oooxoxo2 = new oOoXoXO(this.g, str, new a(oooxoxo));
            oooxoxo2.Oo(true);
            oooxoxo2.x0xO0oo();
        } catch (Exception e3) {
            e3.printStackTrace();
            if (this.n.size() <= 0) {
                a("adsplus", new AdpError("-1", "章鱼:exception"));
            } else {
                d();
            }
        }
    }

    private void e(String str) {
        long j2;
        int a2;
        try {
            try {
                j2 = Long.parseLong(str);
            } catch (NumberFormatException unused) {
                a("adsplus", new AdpError("-1", "adid NumberFormatException"));
                j2 = 0;
            }
            int i2 = this.o;
            if (i2 <= 0) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) this.g.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                a2 = displayMetrics.widthPixels;
            } else {
                a2 = com.adp.sdk.utils.h.a(this.g, i2);
            }
            float f2 = a2;
            c(this.g, this.h, "kuaishou", "6", this.m);
            KsAdSDK.getLoadManager().loadConfigFeedAd(new KsScene.Builder(j2).width((int) f2).adNum(1).build(), new d());
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.n.size() <= 0) {
                a("adsplus", new AdpError("-1", "no ads"));
            } else {
                d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        int size = this.n.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            if ((this.m.getId() + "").equals(this.n.get(size).getId() + "")) {
                this.n.remove(size);
                break;
            }
            size--;
        }
        if (this.n.size() > 0) {
            this.m = this.n.get(0);
            this.n.remove(0);
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TTNativeExpressAd tTNativeExpressAd, ADPFeedAdView aDPFeedAdView) {
        tTNativeExpressAd.setDislikeCallback(this.g, new f(aDPFeedAdView));
    }

    private void a(String str) {
        Activity activity = this.g;
        if (activity != null && !activity.isFinishing() && ADP.isInitSuccess()) {
            if (!com.adp.sdk.f.a()) {
                com.adp.sdk.f.a(this.g, new h(str));
                return;
            } else {
                b(str);
                return;
            }
        }
        a("adsplus", new AdpError("-1", "ad is not init"));
    }

    private void c(String str) {
        if (!com.adp.sdk.h.a()) {
            com.adp.sdk.h.a(this.g);
        }
        this.i = str;
        c(this.g, this.h, "huawei", "6", this.m);
        NativeAdLoader.Builder builder = new NativeAdLoader.Builder(this.g, this.i);
        ADPFeedAdView aDPFeedAdView = new ADPFeedAdView(this.g, (NativeAd) null, new i());
        builder.setNativeAdLoadedListener(new k(aDPFeedAdView)).setAdListener(new j(aDPFeedAdView));
        builder.setNativeAdOptions(new NativeAdConfiguration.Builder().setChoicesPosition(2).setVideoConfiguration(new VideoConfiguration.Builder().setStartMuted(true).build()).setRequestMultiImages(true).setRequestCustomDislikeThisAd(true).build()).build().loadAd(com.adp.sdk.h.a(5000));
    }

    private VideoOption b() {
        VideoOption.Builder builder = new VideoOption.Builder();
        builder.setAutoPlayPolicy(1);
        builder.setAutoPlayMuted(this.s);
        builder.setDetailPageMuted(false);
        return builder.build();
    }
}
