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
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
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
import xXoOI00O.oIX0oI;

public class ADPFeedAd extends e {
    /* access modifiers changed from: private */
    public Activity g;
    /* access modifiers changed from: private */
    public String h;
    private String i;
    /* access modifiers changed from: private */
    public AdItem j;
    /* access modifiers changed from: private */
    public ADPFeedAdListener k;
    private TTAdNative l;
    /* access modifiers changed from: private */
    public SourceVO m;
    /* access modifiers changed from: private */
    public ArrayList<SourceVO> n = new ArrayList<>();
    /* access modifiers changed from: private */
    public int o;
    private int p;
    /* access modifiers changed from: private */
    public ADPDownloadConfirmListener q;
    private boolean r = true;
    private boolean s = true;
    /* access modifiers changed from: private */
    public Handler t = new Handler();

    public interface ADPFeedAdListener {
        void onADClicked(ADPFeedAdView aDPFeedAdView);

        void onADClosed(ADPFeedAdView aDPFeedAdView);

        void onADError(AdpError adpError);

        void onADPresent(ADPFeedAdView aDPFeedAdView);

        void onADReceive(ADPFeedAdView aDPFeedAdView);
    }

    public class a implements ooOOo0oXI {

        /* renamed from: a  reason: collision with root package name */
        ADPFeedAdView f639a = null;
        final /* synthetic */ oOoXoXO b;

        /* renamed from: com.adp.sdk.ADPFeedAd$a$a  reason: collision with other inner class name */
        public class C0005a implements oIX0oI {

            /* renamed from: a  reason: collision with root package name */
            boolean f640a = false;

            public C0005a() {
            }

            public void onADExposed() {
                if (ADPFeedAd.this.k != null) {
                    ADPFeedAd.this.k.onADPresent(a.this.f639a);
                }
                ADPFeedAd aDPFeedAd = ADPFeedAd.this;
                aDPFeedAd.e(aDPFeedAd.g, ADPFeedAd.this.h, "octopus", "6", ADPFeedAd.this.m);
                if (!this.f640a) {
                    a.a(ADPFeedAd.this.j, (Context) ADPFeedAd.this.g);
                    this.f640a = true;
                }
            }

            public void onAdClick() {
                if (ADPFeedAd.this.k != null) {
                    ADPFeedAd.this.k.onADClicked(a.this.f639a);
                }
                ADPFeedAd aDPFeedAd = ADPFeedAd.this;
                aDPFeedAd.a(aDPFeedAd.g, ADPFeedAd.this.h, "kuaishou", "6", ADPFeedAd.this.m);
            }

            public void onAdClose() {
                if (ADPFeedAd.this.k != null) {
                    ADPFeedAd.this.k.onADClosed(a.this.f639a);
                }
            }

            public void onAdRenderFailed(int i) {
                ADPFeedAd.this.a("octopus", new AdpError("-1", "octo onAdRenderFailed"));
            }
        }

        public a(oOoXoXO oooxoxo) {
            this.b = oooxoxo;
        }

        private oIX0oI a() {
            return new C0005a();
        }

        public void onAdFailed(int i) {
            if (ADPFeedAd.this.n.size() <= 0) {
                ADPFeedAd.this.a("octopus", new AdpError(i + "", "octo:" + i));
                return;
            }
            ADPFeedAd.this.d();
        }

        public void onAdLoaded(NativeAdResponse nativeAdResponse) {
            int a2;
            if (ADPFeedAd.this.g != null) {
                if (nativeAdResponse == null) {
                    ADPFeedAd aDPFeedAd = ADPFeedAd.this;
                    aDPFeedAd.b(aDPFeedAd.g, ADPFeedAd.this.h, "octopus", "6", ADPFeedAd.this.m);
                } else {
                    ADPFeedAd aDPFeedAd2 = ADPFeedAd.this;
                    Activity e = aDPFeedAd2.g;
                    String f = ADPFeedAd.this.h;
                    SourceVO g = ADPFeedAd.this.m;
                    aDPFeedAd2.a(e, f, "octopus", "6", g, nativeAdResponse.getPrice() + "");
                }
                if (nativeAdResponse != null) {
                    try {
                        if (ADPFeedAd.this.m.getPrice() != null) {
                            int parseInt = Integer.parseInt(ADPFeedAd.this.m.getPrice());
                            if (parseInt > nativeAdResponse.getPrice()) {
                                this.b.II0XooXoX(parseInt, oOoIIO0.oIX0oI.f6142II0xO0, oOoIIO0.oIX0oI.f6146Oxx0IOOO);
                                ADPFeedAd.this.d();
                                return;
                            }
                            this.b.II0xO0(parseInt);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    this.f639a = new ADPFeedAdView((Context) ADPFeedAd.this.g, a(), nativeAdResponse);
                    if (ADPFeedAd.this.o <= 0) {
                        DisplayMetrics displayMetrics = new DisplayMetrics();
                        ((WindowManager) ADPFeedAd.this.g.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                        a2 = displayMetrics.widthPixels;
                    } else {
                        a2 = com.adp.sdk.utils.h.a(ADPFeedAd.this.g, ADPFeedAd.this.o);
                    }
                    this.f639a.setLayoutParams(new ViewGroup.LayoutParams((int) ((float) a2), -2));
                    if (ADPFeedAd.this.k != null) {
                        ADPFeedAd.this.k.onADReceive(this.f639a);
                    }
                } else if (ADPFeedAd.this.n.size() <= 0) {
                    ADPFeedAd.this.a("octopus", new AdpError("-1", "octo ad is null"));
                } else {
                    ADPFeedAd.this.d();
                }
            }
        }
    }

    public class b implements g.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f641a;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                b bVar = b.this;
                ADPFeedAd.this.f(bVar.f641a);
            }
        }

        public b(String str) {
            this.f641a = str;
        }

        public void a() {
            if (ADPFeedAd.this.n.size() <= 0) {
                ADPFeedAd.this.a("gromore", new AdpError("-1", "gdt error GDTAdSdk.start"));
            } else {
                ADPFeedAd.this.d();
            }
        }

        public void success() {
            ADPFeedAd.this.t.post(new a());
        }
    }

    public class c implements NativeExpressAD.NativeExpressADListener {

        /* renamed from: a  reason: collision with root package name */
        boolean f643a = false;

        public class a implements DownloadConfirmListener {

            /* renamed from: com.adp.sdk.ADPFeedAd$c$a$a  reason: collision with other inner class name */
            public class C0006a implements ADPDownloadConfirmCallBack {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ DownloadConfirmCallBack f645a;

                public C0006a(a aVar, DownloadConfirmCallBack downloadConfirmCallBack) {
                    this.f645a = downloadConfirmCallBack;
                }

                public void onCancel() {
                    DownloadConfirmCallBack downloadConfirmCallBack = this.f645a;
                    if (downloadConfirmCallBack != null) {
                        downloadConfirmCallBack.onCancel();
                    }
                }

                public void onConfirm() {
                    DownloadConfirmCallBack downloadConfirmCallBack = this.f645a;
                    if (downloadConfirmCallBack != null) {
                        downloadConfirmCallBack.onConfirm();
                    }
                }
            }

            public a() {
            }

            public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
                ADPFeedAd.this.q.onDownloadConfirm(activity, i, str, new C0006a(this, downloadConfirmCallBack));
            }
        }

        public c() {
        }

        public void onADClicked(NativeExpressADView nativeExpressADView) {
            ADPFeedAdView aDPFeedAdView;
            if (ADPFeedAd.this.k != null) {
                if (nativeExpressADView.getParent() == null || !(nativeExpressADView.getParent() instanceof ADPFeedAdView)) {
                    aDPFeedAdView = null;
                } else {
                    aDPFeedAdView = (ADPFeedAdView) nativeExpressADView.getParent();
                }
                ADPFeedAd.this.k.onADClicked(aDPFeedAdView);
            }
            ADPFeedAd aDPFeedAd = ADPFeedAd.this;
            aDPFeedAd.a(aDPFeedAd.g, ADPFeedAd.this.h, "tencent", "6", ADPFeedAd.this.m);
        }

        public void onADClosed(NativeExpressADView nativeExpressADView) {
            ADPFeedAdView aDPFeedAdView;
            if (ADPFeedAd.this.k != null) {
                if (nativeExpressADView.getParent() == null || !(nativeExpressADView.getParent() instanceof ADPFeedAdView)) {
                    aDPFeedAdView = null;
                } else {
                    aDPFeedAdView = (ADPFeedAdView) nativeExpressADView.getParent();
                }
                ADPFeedAd.this.k.onADClosed(aDPFeedAdView);
            }
        }

        public void onADExposure(NativeExpressADView nativeExpressADView) {
            ADPFeedAdView aDPFeedAdView;
            if (nativeExpressADView.getParent() == null || !(nativeExpressADView.getParent() instanceof ADPFeedAdView)) {
                aDPFeedAdView = null;
            } else {
                aDPFeedAdView = (ADPFeedAdView) nativeExpressADView.getParent();
            }
            if (ADPFeedAd.this.k != null) {
                ADPFeedAd.this.k.onADPresent(aDPFeedAdView);
            }
            ADPFeedAd aDPFeedAd = ADPFeedAd.this;
            aDPFeedAd.e(aDPFeedAd.g, ADPFeedAd.this.h, "tencent", "6", ADPFeedAd.this.m);
            if (!this.f643a) {
                a.a(ADPFeedAd.this.j, (Context) ADPFeedAd.this.g);
                this.f643a = true;
            }
        }

        public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
        }

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

        public void onNoAD(AdError adError) {
            if (ADPFeedAd.this.n.size() <= 0) {
                ADPFeedAd aDPFeedAd = ADPFeedAd.this;
                aDPFeedAd.a("tencent", new AdpError(adError.getErrorCode() + "", adError.getErrorMsg()));
                return;
            }
            ADPFeedAd.this.d();
        }

        public void onRenderFail(NativeExpressADView nativeExpressADView) {
            if (ADPFeedAd.this.n.size() <= 0) {
                ADPFeedAd.this.a("tencent", new AdpError("-1", "onRenderFail"));
            } else {
                ADPFeedAd.this.d();
            }
        }

        public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
        }
    }

    public class d implements KsLoadManager.FeedAdListener {

        /* renamed from: a  reason: collision with root package name */
        ADPFeedAdView f646a = null;

        public class a implements KsFeedAd.AdInteractionListener {

            /* renamed from: a  reason: collision with root package name */
            boolean f647a = false;

            public a() {
            }

            public void onAdClicked() {
                if (ADPFeedAd.this.k != null) {
                    ADPFeedAd.this.k.onADClicked(d.this.f646a);
                }
                ADPFeedAd aDPFeedAd = ADPFeedAd.this;
                aDPFeedAd.a(aDPFeedAd.g, ADPFeedAd.this.h, "kuaishou", "6", ADPFeedAd.this.m);
            }

            public void onAdShow() {
                if (ADPFeedAd.this.k != null) {
                    ADPFeedAd.this.k.onADPresent(d.this.f646a);
                }
                ADPFeedAd aDPFeedAd = ADPFeedAd.this;
                aDPFeedAd.e(aDPFeedAd.g, ADPFeedAd.this.h, "kuaishou", "6", ADPFeedAd.this.m);
                if (!this.f647a) {
                    a.a(ADPFeedAd.this.j, (Context) ADPFeedAd.this.g);
                    this.f647a = true;
                }
            }

            public void onDislikeClicked() {
                if (ADPFeedAd.this.k != null) {
                    ADPFeedAd.this.k.onADClosed(d.this.f646a);
                }
            }

            public void onDownloadTipsDialogDismiss() {
            }

            public void onDownloadTipsDialogShow() {
            }
        }

        public d() {
        }

        public void onError(int i, String str) {
            if (ADPFeedAd.this.n.size() <= 0) {
                ADPFeedAd aDPFeedAd = ADPFeedAd.this;
                aDPFeedAd.a("kuaishou", new AdpError(i + "", str));
                return;
            }
            ADPFeedAd.this.d();
        }

        public void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
            if (ADPFeedAd.this.g != null) {
                if (list != null && !list.isEmpty()) {
                    ADPFeedAd aDPFeedAd = ADPFeedAd.this;
                    aDPFeedAd.b(aDPFeedAd.g, ADPFeedAd.this.h, "kuaishou", "6", ADPFeedAd.this.m);
                    list.get(0).setAdInteractionListener(new a());
                    View feedView = list.get(0).getFeedView(ADPFeedAd.this.g);
                    if (feedView != null && feedView.getParent() == null) {
                        this.f646a = new ADPFeedAdView((Context) ADPFeedAd.this.g, feedView);
                        if (ADPFeedAd.this.k != null) {
                            ADPFeedAd.this.k.onADReceive(this.f646a);
                        }
                    } else if (!list.isEmpty()) {
                    } else {
                        if (list.size() <= 0) {
                            ADPFeedAd.this.a("adsplus", new AdpError("-1", "ks ad is null"));
                        } else {
                            ADPFeedAd.this.d();
                        }
                    }
                } else if (list.size() <= 0) {
                    ADPFeedAd.this.a("adsplus", new AdpError("-1", "ks ad is null"));
                } else {
                    ADPFeedAd.this.d();
                }
            }
        }
    }

    public class e implements JADFeedListener {

        /* renamed from: a  reason: collision with root package name */
        ADPFeedAdView f648a = null;
        boolean b = false;

        public e() {
        }

        public void onClick() {
            if (ADPFeedAd.this.k != null) {
                ADPFeedAd.this.k.onADClicked(this.f648a);
            }
            ADPFeedAd aDPFeedAd = ADPFeedAd.this;
            aDPFeedAd.a(aDPFeedAd.g, ADPFeedAd.this.h, BuildConfig.FLAVOR, "6", ADPFeedAd.this.m);
        }

        public void onClose() {
            if (ADPFeedAd.this.k != null) {
                ADPFeedAd.this.k.onADClosed(this.f648a);
            }
        }

        public void onExposure() {
            if (ADPFeedAd.this.k != null) {
                ADPFeedAd.this.k.onADPresent(this.f648a);
            }
            ADPFeedAd aDPFeedAd = ADPFeedAd.this;
            aDPFeedAd.e(aDPFeedAd.g, ADPFeedAd.this.h, BuildConfig.FLAVOR, "6", ADPFeedAd.this.m);
            if (!this.b) {
                a.a(ADPFeedAd.this.j, (Context) ADPFeedAd.this.g);
                this.b = true;
            }
        }

        public void onLoadFailure(int i, String str) {
            if (ADPFeedAd.this.n.size() <= 0) {
                ADPFeedAd aDPFeedAd = ADPFeedAd.this;
                aDPFeedAd.a(BuildConfig.FLAVOR, new AdpError(i + "", str));
                return;
            }
            ADPFeedAd.this.d();
        }

        public void onLoadSuccess() {
        }

        public void onRenderFailure(int i, String str) {
            ADPFeedAd.this.a(BuildConfig.FLAVOR, new AdpError(i + "", "jd:" + str));
        }

        public void onRenderSuccess(View view) {
            if (ADPFeedAd.this.g != null) {
                if (view != null) {
                    ADPFeedAd aDPFeedAd = ADPFeedAd.this;
                    aDPFeedAd.b(aDPFeedAd.g, ADPFeedAd.this.h, BuildConfig.FLAVOR, "6", ADPFeedAd.this.m);
                    this.f648a = new ADPFeedAdView((Context) ADPFeedAd.this.g, view);
                    if (ADPFeedAd.this.k != null) {
                        ADPFeedAd.this.k.onADReceive(this.f648a);
                    }
                } else if (ADPFeedAd.this.n.size() <= 0) {
                    ADPFeedAd.this.a("adsplus", new AdpError("-1", "jd ad is null"));
                } else {
                    ADPFeedAd.this.d();
                }
            }
        }
    }

    public class f implements TTAdDislike.DislikeInteractionCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ADPFeedAdView f649a;

        public f(ADPFeedAdView aDPFeedAdView) {
            this.f649a = aDPFeedAdView;
        }

        public void onCancel() {
        }

        public void onSelected(int i, String str, boolean z) {
            if (ADPFeedAd.this.k != null) {
                ADPFeedAd.this.k.onADClosed(this.f649a);
            }
        }

        public void onShow() {
        }
    }

    public class g implements TTAdNative.NativeExpressAdListener {

        public class a implements TTNativeExpressAd.ExpressAdInteractionListener {

            /* renamed from: a  reason: collision with root package name */
            boolean f651a = false;
            final /* synthetic */ ADPFeedAdView b;
            final /* synthetic */ TTNativeExpressAd c;

            public a(ADPFeedAdView aDPFeedAdView, TTNativeExpressAd tTNativeExpressAd) {
                this.b = aDPFeedAdView;
                this.c = tTNativeExpressAd;
            }

            public void onAdClicked(View view, int i) {
                if (ADPFeedAd.this.k != null) {
                    ADPFeedAd.this.k.onADClicked(this.b);
                }
                ADPFeedAd aDPFeedAd = ADPFeedAd.this;
                aDPFeedAd.a(aDPFeedAd.g, ADPFeedAd.this.h, "gromore", "6", ADPFeedAd.this.m);
            }

            public void onAdShow(View view, int i) {
                if (ADPFeedAd.this.k != null) {
                    ADPFeedAd.this.k.onADPresent(this.b);
                }
                ADPFeedAd aDPFeedAd = ADPFeedAd.this;
                aDPFeedAd.e(aDPFeedAd.g, ADPFeedAd.this.h, "gromore", "6", ADPFeedAd.this.m);
                if (!this.f651a) {
                    a.a(ADPFeedAd.this.j, (Context) ADPFeedAd.this.g);
                    this.f651a = true;
                }
            }

            public void onRenderFail(View view, String str, int i) {
                ADPFeedAd.this.a("gromore", new AdpError(i + "", "onRenderFail:" + str));
            }

            public void onRenderSuccess(View view, float f, float f2) {
                if (f2 < 180.0f || (!"imageLeft".equals(ADPFeedAd.this.j.getStyle()) && !"imageRight".equals(ADPFeedAd.this.j.getStyle()))) {
                    if (this.c != null) {
                        this.b.removeAllViews();
                        this.b.setView(this.c.getExpressAdView());
                    }
                } else if (ADPFeedAd.this.k != null) {
                    ADPFeedAd.this.a("gromore", new AdpError("-1", "ads onRenderFail:广告尺寸不符合要求，过滤该广告"));
                }
            }
        }

        public g() {
        }

        private TTNativeExpressAd.ExpressAdInteractionListener a(TTNativeExpressAd tTNativeExpressAd, ADPFeedAdView aDPFeedAdView) {
            return new a(aDPFeedAdView, tTNativeExpressAd);
        }

        public void onError(int i, String str) {
            if (ADPFeedAd.this.n.size() <= 0) {
                ADPFeedAd aDPFeedAd = ADPFeedAd.this;
                aDPFeedAd.a("gromore", new AdpError(i + "", str));
                return;
            }
            ADPFeedAd.this.d();
        }

        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            if (ADPFeedAd.this.g != null) {
                if (list == null || list.size() == 0) {
                    ADPFeedAd.this.a("gromore", new AdpError("-1", "not ad"));
                    return;
                }
                ADPFeedAdView aDPFeedAdView = new ADPFeedAdView((Context) ADPFeedAd.this.g, list.get(0));
                ADPFeedAd.this.a(list.get(0), aDPFeedAdView);
                list.get(0).setExpressInteractionListener(a(list.get(0), aDPFeedAdView));
                if (ADPFeedAd.this.k != null) {
                    ADPFeedAd.this.k.onADReceive(aDPFeedAdView);
                }
                ADPFeedAd aDPFeedAd = ADPFeedAd.this;
                aDPFeedAd.b(aDPFeedAd.g, ADPFeedAd.this.h, "gromore", "6", ADPFeedAd.this.m);
            }
        }
    }

    public class h implements f.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f652a;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                h hVar = h.this;
                ADPFeedAd.this.b(hVar.f652a);
            }
        }

        public h(String str) {
            this.f652a = str;
        }

        public void a(int i, String str) {
            if (ADPFeedAd.this.n.size() <= 0) {
                ADPFeedAd aDPFeedAd = ADPFeedAd.this;
                aDPFeedAd.a("gromore", new AdpError(i + "", str));
                return;
            }
            ADPFeedAd.this.d();
        }

        public void success() {
            ADPFeedAd.this.g.runOnUiThread(new a());
        }
    }

    public class i implements com.adp.sdk.listener.b {
        public i() {
        }

        public void a(ADPFeedAdView aDPFeedAdView) {
            if (ADPFeedAd.this.k != null) {
                ADPFeedAd.this.k.onADClosed(aDPFeedAdView);
            }
        }
    }

    public class j extends AdListener {

        /* renamed from: a  reason: collision with root package name */
        boolean f655a = false;
        final /* synthetic */ ADPFeedAdView b;

        public j(ADPFeedAdView aDPFeedAdView) {
            this.b = aDPFeedAdView;
        }

        public void onAdClicked() {
            if (ADPFeedAd.this.k != null) {
                ADPFeedAd.this.k.onADClicked(this.b);
            }
            ADPFeedAd aDPFeedAd = ADPFeedAd.this;
            aDPFeedAd.a(aDPFeedAd.g, ADPFeedAd.this.h, "huawei", "6", ADPFeedAd.this.m);
        }

        public void onAdClosed() {
        }

        public void onAdFailed(int i) {
            if (ADPFeedAd.this.n.size() <= 0) {
                ADPFeedAd.this.a("huawei", new AdpError(i + "", i + ">Huawei"));
                return;
            }
            ADPFeedAd.this.d();
        }

        public void onAdImpression() {
            if (!this.f655a) {
                if (ADPFeedAd.this.k != null) {
                    ADPFeedAd.this.k.onADPresent(this.b);
                }
                ADPFeedAd aDPFeedAd = ADPFeedAd.this;
                aDPFeedAd.e(aDPFeedAd.g, ADPFeedAd.this.h, "huawei", "6", ADPFeedAd.this.m);
                this.f655a = true;
                a.a(ADPFeedAd.this.j, (Context) ADPFeedAd.this.g);
            }
        }

        public void onAdLoaded() {
        }

        public void onAdOpened() {
        }
    }

    public class k implements NativeAd.NativeAdLoadedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ADPFeedAdView f656a;

        public k(ADPFeedAdView aDPFeedAdView) {
            this.f656a = aDPFeedAdView;
        }

        private boolean a(NativeAd nativeAd) {
            int creativeType = nativeAd.getCreativeType();
            if (creativeType == 2 || creativeType == 102 || creativeType == 3 || creativeType == 6 || creativeType == 103 || creativeType == 106 || creativeType == 7 || creativeType == 107 || creativeType == 8 || creativeType == 108) {
                return true;
            }
            return false;
        }

        public void onNativeAdLoaded(NativeAd nativeAd) {
            this.f656a.setNativeHuaweiAd(nativeAd);
            if (a(nativeAd)) {
                ADPFeedAd aDPFeedAd = ADPFeedAd.this;
                aDPFeedAd.b(aDPFeedAd.g, ADPFeedAd.this.h, "huawei", "6", ADPFeedAd.this.m);
                if (ADPFeedAd.this.k != null && ADPFeedAd.this.g != null) {
                    ADPFeedAd.this.k.onADReceive(this.f656a);
                }
            } else if (ADPFeedAd.this.n.size() <= 0) {
                ADPFeedAd.this.a("huawei", new AdpError("-1", "华为广告类型错误"));
            } else {
                ADPFeedAd.this.d();
            }
        }
    }

    private ADPFeedAd() {
    }

    private void load() {
        if (ADP.isInitSuccess()) {
            a();
            c();
            return;
        }
        a("adsplus", new AdpError("-1", "adp sdk is not initialized"));
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
        AdInfo adInfo = a.b;
        if (adInfo == null || adInfo.getAdUnits() == null || adInfo.getAdUnits().size() <= 0 || !"0".equals(adInfo.getStatus())) {
            a("adsplus", new AdpError("B002", this.g.getString(R.string.B002)));
            return;
        }
        for (AdItem next : adInfo.getAdUnits()) {
            if (ExploreConstants.SCENE_FEED.equals(next.getType()) && this.h.equals(next.getAdUnitId())) {
                this.j = next;
            }
        }
        AdItem adItem = this.j;
        if (adItem == null) {
            a("adsplus", new AdpError("B003", this.g.getString(R.string.B003)));
        } else if (!adItem.isEnable()) {
            a("adsplus", new AdpError("B004", this.g.getString(R.string.B004)));
        } else {
            String b2 = a.b(this.j, (Context) this.g);
            if (b2 != null) {
                a("adsplus", new AdpError("C001", b2));
            } else if (this.j.getAdSource() == null || this.j.getAdSource().isEmpty()) {
                a("adsplus", new AdpError("B003", this.g.getString(R.string.B003)));
            } else {
                try {
                    this.r = this.j.isOpenLogs();
                } catch (Exception unused) {
                }
                int parseInt = Integer.parseInt(new com.adp.sdk.utils.d(this.g).b("feedad_index", "0"));
                if (b.a(this.j, parseInt)) {
                    parseInt = 0;
                }
                SourceVO a2 = b.a(this.j, parseInt, this.g);
                this.m = a2;
                if (a2 == null) {
                    a("adsplus", new AdpError("B003", this.g.getString(R.string.B003)));
                    return;
                }
                this.n = b.a(this.j, a2);
                e();
                h((parseInt + 1) + "");
            }
        }
    }

    private void d(String str) {
        try {
            if (!j.a()) {
                j.a((Context) this.g);
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) this.g.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            if (this.o <= 0) {
                this.o = com.adp.sdk.utils.h.b(this.g, displayMetrics.widthPixels);
            }
            if (this.p <= 0) {
                this.p = (int) (((double) this.o) * 0.33d);
            }
            c(this.g, this.h, BuildConfig.FLAVOR, "6", this.m);
            new JADFeed(this.g, new JADSlot.Builder().setSlotID(str).setSize((float) this.o, (float) this.p).setCloseButtonHidden(false).build()).loadAd(new e());
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
        } else if ("kuaishou".equals(this.m.getSource())) {
            e(this.m.getId());
        } else if ("gromore".equals(this.m.getSource())) {
            a(this.m.getId());
        } else if ("bytedance".equals(this.m.getSource())) {
            a(this.m.getId());
        } else if ("octopus".equals(this.m.getSource())) {
            a(this.m.getId(), (oOoXoXO) null);
        } else if ("huawei".equals(this.m.getSource())) {
            c(this.m.getId());
        } else if (BuildConfig.FLAVOR.equals(this.m.getSource())) {
            d(this.m.getId());
        } else if (this.n.size() <= 0) {
            a("adsplus", new AdpError("-1", "no ad ads"));
        } else {
            d();
        }
    }

    /* access modifiers changed from: private */
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
        if (g.a()) {
            f(str);
        } else if (g.a(this.g, new b(str))) {
        } else {
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

    /* access modifiers changed from: private */
    public void b(String str) {
        int i2;
        int i3;
        try {
            this.i = str;
            if (this.l == null) {
                this.l = ADP.getTTAdManager().createAdNative(this.g);
            }
            int i4 = this.o;
            if (i4 <= 0) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) this.g.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                i2 = displayMetrics.widthPixels;
            } else {
                i2 = com.adp.sdk.utils.h.a(this.g, i4);
            }
            int i5 = this.p;
            if (i5 <= 0) {
                if (!"imageTop".equals(this.j.getStyle())) {
                    if (!"imageBottom".equals(this.j.getStyle())) {
                        i3 = com.adp.sdk.utils.h.a(this.g, 100);
                    }
                }
                i3 = com.adp.sdk.utils.h.a(this.g, 200);
            } else {
                i3 = com.adp.sdk.utils.h.a(this.g, i5);
            }
            AdSlot build = new AdSlot.Builder().setCodeId(str).setImageAcceptedSize(i2, i3).supportRenderControl().setExpressViewAcceptedSize((float) com.adp.sdk.utils.h.b(this.g, i2), 0.0f).setAdCount(1).setMediationAdSlot(new MediationAdSlot.Builder().setExtraObject(MediationConstant.KEY_GDT_VIDEO_OPTION, new VideoOption.Builder().setAutoPlayMuted(false).setAutoPlayPolicy(1).build()).setExtraObject(MediationConstant.KEY_BAIDU_REQUEST_PARAMETERS, new RequestParameters.Builder().downloadAppConfirmPolicy(2).build()).setExtraObject(MediationConstant.KEY_BAIDU_CACHE_VIDEO_ONLY_WIFI, Boolean.TRUE).setExtraObject(MediationConstant.KEY_GDT_DOWN_APP_CONFIG_POLICY, DownAPPConfirmPolicy.NOConfirm).build()).build();
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

    /* access modifiers changed from: private */
    public void a(String str, AdpError adpError) {
        ADPFeedAdListener aDPFeedAdListener = this.k;
        if (aDPFeedAdListener != null) {
            aDPFeedAdListener.onADError(adpError);
        }
        String str2 = str + xoXoI.f16453oxoX + adpError.getCode() + xoXoI.f16453oxoX + adpError.getMessage();
        if (this.r) {
            c.a().a((Context) this.g, this.h, str2, "6", this.m);
        }
    }

    public ADPFeedAd(Activity activity, String str, ADPFeedAdListener aDPFeedAdListener) {
        this.g = activity;
        this.h = str;
        this.k = aDPFeedAdListener;
    }

    private void a(String str, oOoXoXO oooxoxo) {
        try {
            if (com.adp.sdk.utils.b.a("com.octopus.ad.NativeAd")) {
                try {
                    if (!k.a()) {
                        k.a((Context) this.g);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                c(this.g, this.h, "octopus", "6", this.m);
                oOoXoXO oooxoxo2 = new oOoXoXO(this.g, str, new a(oooxoxo));
                oooxoxo2.Oo(true);
                oooxoxo2.x0xO0oo();
            } else if (this.n.size() <= 0) {
                a("adsplus", new AdpError("-1", "找不到合适的广告"));
            } else {
                d();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            if (this.n.size() <= 0) {
                a("adsplus", new AdpError("-1", "章鱼:exception"));
            } else {
                d();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:4|5) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        r11.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0073, code lost:
        if (r10.n.size() <= 0) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0075, code lost:
        a("adsplus", new com.adp.sdk.dto.AdpError("-1", "no ads"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x007f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0080, code lost:
        d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
        a("adsplus", new com.adp.sdk.dto.AdpError("-1", "adid NumberFormatException"));
        r2 = 0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e(java.lang.String r11) {
        /*
            r10 = this;
            java.lang.String r0 = "-1"
            java.lang.String r1 = "adsplus"
            long r2 = java.lang.Long.parseLong(r11)     // Catch:{ NumberFormatException -> 0x000b }
            goto L_0x0017
        L_0x0009:
            r11 = move-exception
            goto L_0x006a
        L_0x000b:
            com.adp.sdk.dto.AdpError r11 = new com.adp.sdk.dto.AdpError     // Catch:{ Exception -> 0x0009 }
            java.lang.String r2 = "adid NumberFormatException"
            r11.<init>(r0, r2)     // Catch:{ Exception -> 0x0009 }
            r10.a((java.lang.String) r1, (com.adp.sdk.dto.AdpError) r11)     // Catch:{ Exception -> 0x0009 }
            r2 = 0
        L_0x0017:
            int r11 = r10.o     // Catch:{ Exception -> 0x0009 }
            if (r11 > 0) goto L_0x0035
            android.util.DisplayMetrics r11 = new android.util.DisplayMetrics     // Catch:{ Exception -> 0x0009 }
            r11.<init>()     // Catch:{ Exception -> 0x0009 }
            android.app.Activity r4 = r10.g     // Catch:{ Exception -> 0x0009 }
            java.lang.String r5 = "window"
            java.lang.Object r4 = r4.getSystemService(r5)     // Catch:{ Exception -> 0x0009 }
            android.view.WindowManager r4 = (android.view.WindowManager) r4     // Catch:{ Exception -> 0x0009 }
            android.view.Display r4 = r4.getDefaultDisplay()     // Catch:{ Exception -> 0x0009 }
            r4.getMetrics(r11)     // Catch:{ Exception -> 0x0009 }
            int r11 = r11.widthPixels     // Catch:{ Exception -> 0x0009 }
            goto L_0x003b
        L_0x0035:
            android.app.Activity r4 = r10.g     // Catch:{ Exception -> 0x0009 }
            int r11 = com.adp.sdk.utils.h.a(r4, r11)     // Catch:{ Exception -> 0x0009 }
        L_0x003b:
            float r11 = (float) r11     // Catch:{ Exception -> 0x0009 }
            android.app.Activity r5 = r10.g     // Catch:{ Exception -> 0x0009 }
            java.lang.String r6 = r10.h     // Catch:{ Exception -> 0x0009 }
            java.lang.String r7 = "kuaishou"
            java.lang.String r8 = "6"
            com.adp.sdk.dto.SourceVO r9 = r10.m     // Catch:{ Exception -> 0x0009 }
            r4 = r10
            r4.c(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0009 }
            com.kwad.sdk.api.KsScene$Builder r4 = new com.kwad.sdk.api.KsScene$Builder     // Catch:{ Exception -> 0x0009 }
            r4.<init>(r2)     // Catch:{ Exception -> 0x0009 }
            int r11 = (int) r11     // Catch:{ Exception -> 0x0009 }
            com.kwad.sdk.api.KsScene$Builder r11 = r4.width(r11)     // Catch:{ Exception -> 0x0009 }
            r2 = 1
            com.kwad.sdk.api.KsScene$Builder r11 = r11.adNum(r2)     // Catch:{ Exception -> 0x0009 }
            com.kwad.sdk.api.KsScene r11 = r11.build()     // Catch:{ Exception -> 0x0009 }
            com.kwad.sdk.api.KsLoadManager r2 = com.kwad.sdk.api.KsAdSDK.getLoadManager()     // Catch:{ Exception -> 0x0009 }
            com.adp.sdk.ADPFeedAd$d r3 = new com.adp.sdk.ADPFeedAd$d     // Catch:{ Exception -> 0x0009 }
            r3.<init>()     // Catch:{ Exception -> 0x0009 }
            r2.loadConfigFeedAd(r11, r3)     // Catch:{ Exception -> 0x0009 }
            goto L_0x0083
        L_0x006a:
            r11.printStackTrace()
            java.util.ArrayList<com.adp.sdk.dto.SourceVO> r11 = r10.n
            int r11 = r11.size()
            if (r11 > 0) goto L_0x0080
            com.adp.sdk.dto.AdpError r11 = new com.adp.sdk.dto.AdpError
            java.lang.String r2 = "no ads"
            r11.<init>(r0, r2)
            r10.a((java.lang.String) r1, (com.adp.sdk.dto.AdpError) r11)
            return
        L_0x0080:
            r10.d()
        L_0x0083:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adp.sdk.ADPFeedAd.e(java.lang.String):void");
    }

    /* access modifiers changed from: private */
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

    /* access modifiers changed from: private */
    public void a(TTNativeExpressAd tTNativeExpressAd, ADPFeedAdView aDPFeedAdView) {
        tTNativeExpressAd.setDislikeCallback(this.g, new f(aDPFeedAdView));
    }

    private void a(String str) {
        Activity activity = this.g;
        if (activity == null || activity.isFinishing() || !ADP.isInitSuccess()) {
            a("adsplus", new AdpError("-1", "ad is not init"));
        } else if (!f.a()) {
            f.a(this.g, new h(str));
        } else {
            b(str);
        }
    }

    private void c(String str) {
        if (!h.a()) {
            h.a((Context) this.g);
        }
        this.i = str;
        c(this.g, this.h, "huawei", "6", this.m);
        NativeAdLoader.Builder builder = new NativeAdLoader.Builder(this.g, this.i);
        ADPFeedAdView aDPFeedAdView = new ADPFeedAdView((Context) this.g, (NativeAd) null, (com.adp.sdk.listener.b) new i());
        builder.setNativeAdLoadedListener(new k(aDPFeedAdView)).setAdListener(new j(aDPFeedAdView));
        builder.setNativeAdOptions(new NativeAdConfiguration.Builder().setChoicesPosition(2).setVideoConfiguration(new VideoConfiguration.Builder().setStartMuted(true).build()).setRequestMultiImages(true).setRequestCustomDislikeThisAd(true).build()).build().loadAd(h.a(5000));
    }

    private VideoOption b() {
        VideoOption.Builder builder = new VideoOption.Builder();
        builder.setAutoPlayPolicy(1);
        builder.setAutoPlayMuted(this.s);
        builder.setDetailPageMuted(false);
        return builder.build();
    }
}
