package com.adp.sdk;

import OoOoXO0.xoXoI;
import android.app.Activity;
import android.graphics.Point;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.adp.sdk.dto.AdInfo;
import com.adp.sdk.dto.AdItem;
import com.adp.sdk.dto.AdpError;
import com.adp.sdk.dto.SourceVO;
import com.adp.sdk.f;
import com.adp.sdk.g;
import com.adp.sdk.listener.ADPDownloadConfirmCallBack;
import com.adp.sdk.listener.ADPDownloadConfirmListener;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BannerAdSize;
import com.huawei.hms.ads.banner.BannerView;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ADPBannerAdLoader extends com.adp.sdk.e {
    private static UnifiedBannerView A;
    private Activity g;
    private ViewGroup h;
    private String i;
    private String j;
    private ADPBannerADListener k;
    private ADPDownloadConfirmListener l;
    private AdItem m;
    private Handler n;
    private TTAdNative o;
    private TTNativeExpressAd p;
    private int q;
    private int r;
    private SourceVO s;
    private boolean t;
    private boolean u;
    private Handler v;
    private ArrayList<SourceVO> w;
    private BannerView x;
    private boolean y;
    private Runnable z;

    /* loaded from: classes.dex */
    public interface ADPBannerADListener {
        void onADClicked();

        void onADClosed();

        void onADError(AdpError adpError);

        void onADPresent();

        void onADReceive();
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ADP.isInitSuccess()) {
                try {
                    ADPBannerAdLoader.this.d();
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
                ADPBannerAdLoader.this.n.removeCallbacks(ADPBannerAdLoader.this.z);
                ADPBannerAdLoader.this.z = null;
                return;
            }
            ADPBannerAdLoader.this.n.postDelayed(this, 500L);
        }
    }

    /* loaded from: classes.dex */
    public class b implements TTAdNative.NativeExpressAdListener {
        public b() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onError(int i, String str) {
            if (ADPBannerAdLoader.this.t) {
                return;
            }
            if (ADPBannerAdLoader.this.h != null) {
                ADPBannerAdLoader.this.h.removeAllViews();
            }
            if (ADPBannerAdLoader.this.w.size() > 0) {
                ADPBannerAdLoader.this.e();
                return;
            }
            ADPBannerAdLoader.this.a("adsplus", new AdpError(i + "", str));
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            if (list == null || list.size() == 0) {
                ADPBannerAdLoader.this.a("adsplus", new AdpError("-1", "no ads"));
                return;
            }
            if (ADPBannerAdLoader.this.g != null && !ADPBannerAdLoader.this.g.isFinishing()) {
                if (ADPBannerAdLoader.this.p != null) {
                    ADPBannerAdLoader.this.p.destroy();
                }
                ADPBannerAdLoader.this.p = list.get(0);
                if (ADPBannerAdLoader.this.k != null) {
                    ADPBannerAdLoader.this.k.onADReceive();
                }
                ADPBannerAdLoader aDPBannerAdLoader = ADPBannerAdLoader.this;
                aDPBannerAdLoader.b(aDPBannerAdLoader.g, ADPBannerAdLoader.this.i, "gromore", "4", ADPBannerAdLoader.this.s);
                ADPBannerAdLoader.this.t = true;
                ADPBannerAdLoader aDPBannerAdLoader2 = ADPBannerAdLoader.this;
                aDPBannerAdLoader2.a(aDPBannerAdLoader2.p);
                if (!com.adp.sdk.f.b()) {
                    if (ADPBannerAdLoader.this.r == 0) {
                        ADPBannerAdLoader.this.p.setSlideIntervalTime(30000);
                    } else {
                        ADPBannerAdLoader.this.p.setSlideIntervalTime(ADPBannerAdLoader.this.r * 1000);
                    }
                    ADPBannerAdLoader.this.p.render();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends AdListener {

        /* renamed from: a, reason: collision with root package name */
        boolean f4623a = false;

        public c() {
        }

        @Override // com.huawei.hms.ads.AdListener
        public void onAdClicked() {
            if (ADPBannerAdLoader.this.k != null) {
                ADPBannerAdLoader.this.k.onADClicked();
            }
            ADPBannerAdLoader aDPBannerAdLoader = ADPBannerAdLoader.this;
            aDPBannerAdLoader.a(aDPBannerAdLoader.g, ADPBannerAdLoader.this.i, "huawei", "4", ADPBannerAdLoader.this.s);
        }

        @Override // com.huawei.hms.ads.AdListener
        public void onAdClosed() {
            if (!this.f4623a && ADPBannerAdLoader.this.k != null) {
                ADPBannerAdLoader.this.k.onADClosed();
            }
            if (this.f4623a) {
                this.f4623a = false;
            }
        }

        @Override // com.huawei.hms.ads.AdListener
        public void onAdFailed(int i) {
            if (ADPBannerAdLoader.this.t) {
                return;
            }
            ADPBannerAdLoader.this.destroy();
            if (ADPBannerAdLoader.this.w.size() > 0) {
                ADPBannerAdLoader.this.e();
                return;
            }
            ADPBannerAdLoader.this.a("adsplus", new AdpError(i + "", i + ">HUAWEI"));
        }

        @Override // com.huawei.hms.ads.AdListener
        public void onAdLeave() {
            this.f4623a = true;
        }

        @Override // com.huawei.hms.ads.AdListener
        public void onAdLoaded() {
            ADPBannerAdLoader aDPBannerAdLoader = ADPBannerAdLoader.this;
            aDPBannerAdLoader.b(aDPBannerAdLoader.g, ADPBannerAdLoader.this.i, "huawei", "4", ADPBannerAdLoader.this.s);
            ADPBannerAdLoader.this.t = true;
            if (ADPBannerAdLoader.this.k != null) {
                ADPBannerAdLoader.this.k.onADReceive();
            }
        }

        @Override // com.huawei.hms.ads.AdListener
        public void onAdOpened() {
            ADPBannerAdLoader aDPBannerAdLoader = ADPBannerAdLoader.this;
            aDPBannerAdLoader.e(aDPBannerAdLoader.g, ADPBannerAdLoader.this.i, "huawei", "4", ADPBannerAdLoader.this.s);
            if (ADPBannerAdLoader.this.k != null) {
                ADPBannerAdLoader.this.k.onADPresent();
            }
            if (!ADPBannerAdLoader.this.y) {
                com.adp.sdk.a.a(ADPBannerAdLoader.this.m, ADPBannerAdLoader.this.g);
                ADPBannerAdLoader.this.y = true;
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements f.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4624a;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = d.this;
                ADPBannerAdLoader.this.b(dVar.f4624a);
            }
        }

        public d(String str) {
            this.f4624a = str;
        }

        @Override // com.adp.sdk.f.c
        public void a(int i, String str) {
            if (ADPBannerAdLoader.this.w.size() > 0) {
                ADPBannerAdLoader.this.e();
                return;
            }
            ADPBannerAdLoader.this.a("adsplus", new AdpError(i + "", str + ">csj"));
        }

        @Override // com.adp.sdk.f.c
        public void success() {
            ADPBannerAdLoader.this.g.runOnUiThread(new a());
        }
    }

    /* loaded from: classes.dex */
    public class e implements TTNativeExpressAd.ExpressAdInteractionListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TTNativeExpressAd f4626a;

        public e(TTNativeExpressAd tTNativeExpressAd) {
            this.f4626a = tTNativeExpressAd;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdClicked(View view, int i) {
            if (ADPBannerAdLoader.this.k != null) {
                ADPBannerAdLoader.this.k.onADClicked();
            }
            ADPBannerAdLoader aDPBannerAdLoader = ADPBannerAdLoader.this;
            aDPBannerAdLoader.a(aDPBannerAdLoader.g, ADPBannerAdLoader.this.i, "gromore", "4", ADPBannerAdLoader.this.s);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdShow(View view, int i) {
            if (!ADPBannerAdLoader.this.y) {
                com.adp.sdk.a.a(ADPBannerAdLoader.this.m, ADPBannerAdLoader.this.g);
                ADPBannerAdLoader.this.y = true;
            }
            ADPBannerAdLoader aDPBannerAdLoader = ADPBannerAdLoader.this;
            aDPBannerAdLoader.e(aDPBannerAdLoader.g, ADPBannerAdLoader.this.i, "gromore", "4", ADPBannerAdLoader.this.s);
            if (ADPBannerAdLoader.this.k != null) {
                ADPBannerAdLoader.this.k.onADPresent();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderFail(View view, String str, int i) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderSuccess(View view, float f, float f2) {
            View expressAdView;
            if (!com.adp.sdk.f.b() && (expressAdView = this.f4626a.getExpressAdView()) != null && ADPBannerAdLoader.this.h != null) {
                ADPBannerAdLoader.this.h.removeAllViews();
                try {
                    ADPBannerAdLoader.this.h.addView(expressAdView, ADPBannerAdLoader.this.c());
                } catch (Exception unused) {
                    ADPBannerAdLoader.this.h.addView(expressAdView);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements TTAdDislike.DislikeInteractionCallback {
        public f() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onCancel() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onSelected(int i, String str, boolean z) {
            if (ADPBannerAdLoader.this.h != null) {
                ADPBannerAdLoader.this.h.removeAllViews();
            }
            if (ADPBannerAdLoader.this.k != null) {
                ADPBannerAdLoader.this.k.onADClosed();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onShow() {
        }
    }

    /* loaded from: classes.dex */
    public class g implements g.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4628a;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g gVar = g.this;
                ADPBannerAdLoader.this.d(gVar.f4628a);
            }
        }

        public g(String str) {
            this.f4628a = str;
        }

        @Override // com.adp.sdk.g.b
        public void a() {
            ADPBannerAdLoader.this.a("adsplus", new AdpError("-1", "gdt error GDTAdSdk.start "));
        }

        @Override // com.adp.sdk.g.b
        public void success() {
            ADPBannerAdLoader.this.v.post(new a());
        }
    }

    /* loaded from: classes.dex */
    public class h implements UnifiedBannerADListener {

        /* loaded from: classes.dex */
        public class a implements DownloadConfirmListener {

            /* renamed from: com.adp.sdk.ADPBannerAdLoader$h$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C0084a implements ADPDownloadConfirmCallBack {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ DownloadConfirmCallBack f4632a;

                public C0084a(a aVar, DownloadConfirmCallBack downloadConfirmCallBack) {
                    this.f4632a = downloadConfirmCallBack;
                }

                @Override // com.adp.sdk.listener.ADPDownloadConfirmCallBack
                public void onCancel() {
                    DownloadConfirmCallBack downloadConfirmCallBack = this.f4632a;
                    if (downloadConfirmCallBack != null) {
                        downloadConfirmCallBack.onCancel();
                    }
                }

                @Override // com.adp.sdk.listener.ADPDownloadConfirmCallBack
                public void onConfirm() {
                    DownloadConfirmCallBack downloadConfirmCallBack = this.f4632a;
                    if (downloadConfirmCallBack != null) {
                        downloadConfirmCallBack.onConfirm();
                    }
                }
            }

            public a() {
            }

            @Override // com.qq.e.comm.compliance.DownloadConfirmListener
            public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
                ADPBannerAdLoader.this.l.onDownloadConfirm(activity, i, str, new C0084a(this, downloadConfirmCallBack));
            }
        }

        public h() {
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADClicked() {
            if (ADPBannerAdLoader.this.k != null) {
                ADPBannerAdLoader.this.k.onADClicked();
            }
            ADPBannerAdLoader aDPBannerAdLoader = ADPBannerAdLoader.this;
            aDPBannerAdLoader.a(aDPBannerAdLoader.g, ADPBannerAdLoader.this.i, "tencent", "4", ADPBannerAdLoader.this.s);
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADClosed() {
            if (ADPBannerAdLoader.this.k != null) {
                ADPBannerAdLoader.this.k.onADClosed();
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADExposure() {
            ADPBannerAdLoader aDPBannerAdLoader = ADPBannerAdLoader.this;
            aDPBannerAdLoader.e(aDPBannerAdLoader.g, ADPBannerAdLoader.this.i, "tencent", "4", ADPBannerAdLoader.this.s);
            if (ADPBannerAdLoader.this.k != null) {
                ADPBannerAdLoader.this.k.onADPresent();
            }
            if (!ADPBannerAdLoader.this.y) {
                com.adp.sdk.a.a(ADPBannerAdLoader.this.m, ADPBannerAdLoader.this.g);
                ADPBannerAdLoader.this.y = true;
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADLeftApplication() {
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADReceive() {
            ADPBannerAdLoader aDPBannerAdLoader = ADPBannerAdLoader.this;
            aDPBannerAdLoader.b(aDPBannerAdLoader.g, ADPBannerAdLoader.this.i, "tencent", "4", ADPBannerAdLoader.this.s);
            ADPBannerAdLoader.this.t = true;
            if (ADPBannerAdLoader.this.k != null) {
                ADPBannerAdLoader.this.k.onADReceive();
            }
            if (ADPBannerAdLoader.this.l != null && ADPBannerAdLoader.A != null) {
                try {
                    ADPBannerAdLoader.A.setDownloadConfirmListener(new a());
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onNoAD(AdError adError) {
            if (ADPBannerAdLoader.this.t) {
                return;
            }
            ADPBannerAdLoader.this.destroy();
            if (ADPBannerAdLoader.this.w.size() > 0) {
                ADPBannerAdLoader.this.e();
                return;
            }
            ADPBannerAdLoader.this.a("adsplus", new AdpError(adError.getErrorCode() + "", adError.getErrorMsg()));
        }
    }

    private ADPBannerAdLoader() {
        this.n = new Handler();
        this.q = 0;
        this.r = 30;
        this.t = false;
        this.u = true;
        this.v = new Handler();
        this.w = new ArrayList<>();
        this.y = false;
        this.z = new a();
    }

    public void destroy() {
        ViewGroup viewGroup = this.h;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        UnifiedBannerView unifiedBannerView = A;
        if (unifiedBannerView != null) {
            unifiedBannerView.destroy();
            A = null;
        }
        TTNativeExpressAd tTNativeExpressAd = this.p;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
            this.p = null;
        }
    }

    public void load() {
        Activity activity = this.g;
        if (activity != null && !activity.isFinishing()) {
            destroy();
            if (this.h == null) {
                a("adsplus", new AdpError("B006", this.g.getString(R.string.B006)));
                return;
            }
            if (this.i == null) {
                a("adsplus", new AdpError("B001", this.g.getString(R.string.B001)));
                return;
            }
            a();
            if (!ADP.isInitSuccess()) {
                this.n.removeCallbacks(this.z);
                this.n.postDelayed(this.z, 500L);
            } else {
                this.t = false;
                d();
            }
        }
    }

    public void setAdWidth(int i) {
        this.q = i;
    }

    public void setDownloadConfirmListener(ADPDownloadConfirmListener aDPDownloadConfirmListener) {
        this.l = aDPDownloadConfirmListener;
    }

    public void setRefreshTime(int i) {
        UnifiedBannerView unifiedBannerView = A;
        if (unifiedBannerView != null) {
            if (i == 0) {
                this.r = i;
                unifiedBannerView.setRefresh(i);
            } else if (i >= 30 && i <= 120) {
                this.r = i;
                unifiedBannerView.setRefresh(i);
            }
        }
    }

    private void c(String str) {
        if (!com.adp.sdk.h.a()) {
            com.adp.sdk.h.a(this.g);
        }
        c(this.g, this.i, "huawei", "4", this.s);
        this.h.removeAllViews();
        BannerView bannerView = this.x;
        if (bannerView != null) {
            bannerView.destroy();
        }
        this.x = new BannerView(this.g);
        this.x.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.x.setAdId(str);
        this.x.setBannerAdSize(BannerAdSize.BANNER_SIZE_320_50);
        this.x.setBannerRefresh(this.r);
        AdParam a2 = com.adp.sdk.h.a(5000);
        this.h.addView(this.x);
        this.x.setAdListener(new c());
        this.x.loadAd(a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        AdInfo adInfo = com.adp.sdk.a.b;
        if (adInfo != null && adInfo.getAdUnits() != null && adInfo.getAdUnits().size() > 0 && "0".equals(adInfo.getStatus())) {
            for (AdItem adItem : adInfo.getAdUnits()) {
                if ("Banner".equals(adItem.getType()) && this.i.equals(adItem.getAdUnitId())) {
                    this.m = adItem;
                }
            }
            AdItem adItem2 = this.m;
            if (adItem2 == null) {
                a("adsplus", new AdpError("B003", this.g.getString(R.string.B003)));
                return;
            }
            if (!adItem2.isEnable()) {
                a("adsplus", new AdpError("B004", this.g.getString(R.string.B004)));
                return;
            }
            String b2 = com.adp.sdk.a.b(this.m, this.g);
            if (b2 != null) {
                a("adsplus", new AdpError("C001", b2));
                return;
            }
            if (this.m.getAdSource() != null && !this.m.getAdSource().isEmpty()) {
                try {
                    this.u = this.m.isOpenLogs();
                } catch (Exception unused) {
                }
                int parseInt = Integer.parseInt(new com.adp.sdk.utils.d(this.g).b("bannerad_index", "0"));
                if (com.adp.sdk.b.a(this.m, parseInt)) {
                    parseInt = 0;
                }
                SourceVO a2 = com.adp.sdk.b.a(this.m, parseInt, this.g);
                this.s = a2;
                if (a2 == null) {
                    a("adsplus", new AdpError("B003", this.g.getString(R.string.B003)));
                    return;
                }
                this.w = com.adp.sdk.b.a(this.m, a2);
                f();
                f((parseInt + 1) + "");
                return;
            }
            a("adsplus", new AdpError("B003", this.g.getString(R.string.B003)));
            return;
        }
        a("adsplus", new AdpError("B002", this.g.getString(R.string.B002)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        int size = this.w.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            if ((this.s.getId() + "").equals(this.w.get(size).getId() + "")) {
                this.w.remove(size);
                break;
            }
            size--;
        }
        if (this.w.size() > 0) {
            this.s = this.w.get(0);
            this.w.remove(0);
            f();
        }
    }

    private void f() {
        if ("tencent".equals(this.s.getSource())) {
            e(this.s.getId());
            return;
        }
        if ("gromore".equals(this.s.getSource())) {
            a(this.s.getId());
            return;
        }
        if ("bytedance".equals(this.s.getSource())) {
            a(this.s.getId());
            return;
        }
        if ("huawei".equals(this.s.getSource())) {
            c(this.s.getId());
            return;
        }
        if (this.t) {
            return;
        }
        ViewGroup viewGroup = this.h;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        if (this.w.size() <= 0) {
            a("adsplus", new AdpError("-1", "no ad ads"));
        } else {
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        int b2;
        if (this.o == null) {
            this.o = ADP.getTTAdManager().createAdNative(this.g);
        }
        c(this.g, this.i, "gromore", "4", this.s);
        this.h.removeAllViews();
        int i = this.q;
        if (i > 0) {
            b2 = com.adp.sdk.utils.h.b(this.g, i);
        } else {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) this.g.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            b2 = com.adp.sdk.utils.h.b(this.g, displayMetrics.widthPixels);
        }
        this.o.loadBannerExpressAd(new AdSlot.Builder().setCodeId(str).setAdCount(1).setImageAcceptedSize(com.adp.sdk.utils.h.a(this.g, b2), com.adp.sdk.utils.h.a(this.g, 50)).setExpressViewAcceptedSize(b2, 50.0f).build(), new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, AdpError adpError) {
        ADPBannerADListener aDPBannerADListener = this.k;
        if (aDPBannerADListener != null) {
            aDPBannerADListener.onADError(adpError);
        }
        String str2 = str + xoXoI.f2670oxoX + adpError.getCode() + xoXoI.f2670oxoX + adpError.getMessage();
        if (this.u) {
            com.adp.sdk.c.a().a(this.g, this.i, str2, "4", this.s);
        }
    }

    private void e(String str) {
        if (com.adp.sdk.g.a()) {
            d(str);
        } else {
            if (com.adp.sdk.g.a(this.g, new g(str))) {
                return;
            }
            a("adsplus", new AdpError("-1", "ads gdt is erro"));
        }
    }

    public ADPBannerAdLoader(Activity activity, String str, ViewGroup viewGroup, ADPBannerADListener aDPBannerADListener) {
        this.n = new Handler();
        this.q = 0;
        this.r = 30;
        this.t = false;
        this.u = true;
        this.v = new Handler();
        this.w = new ArrayList<>();
        this.y = false;
        this.z = new a();
        this.g = activity;
        this.i = str;
        this.h = viewGroup;
        this.k = aDPBannerADListener;
    }

    private void a(String str) {
        this.j = str;
        Activity activity = this.g;
        if (activity != null && !activity.isFinishing() && ADP.isInitSuccess()) {
            if (!com.adp.sdk.f.a()) {
                com.adp.sdk.f.a(this.g, new d(str));
                return;
            } else {
                b(str);
                return;
            }
        }
        a("adsplus", new AdpError("-1", "ad is not init"));
    }

    private void f(String str) {
        Activity activity = this.g;
        if (activity != null) {
            new com.adp.sdk.utils.d(activity).a("bannerad_index", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TTNativeExpressAd tTNativeExpressAd) {
        View expressAdView;
        ViewGroup viewGroup;
        if (tTNativeExpressAd == null) {
            return;
        }
        tTNativeExpressAd.setExpressInteractionListener(new e(tTNativeExpressAd));
        b(tTNativeExpressAd);
        if (!com.adp.sdk.f.b() || (expressAdView = tTNativeExpressAd.getExpressAdView()) == null || (viewGroup = this.h) == null) {
            return;
        }
        viewGroup.removeAllViews();
        try {
            this.h.addView(expressAdView, c());
        } catch (Exception unused) {
            this.h.addView(expressAdView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams c() {
        Point point = new Point();
        this.g.getWindowManager().getDefaultDisplay().getSize(point);
        if (this.q == 0) {
            if (this.g.getRequestedOrientation() == 0) {
                int i = point.y;
                return new FrameLayout.LayoutParams(i, Math.round(i / 6.4f));
            }
            int i2 = point.x;
            return new FrameLayout.LayoutParams(i2, Math.round(i2 / 6.4f));
        }
        int i3 = this.q;
        return new FrameLayout.LayoutParams(i3, Math.round(i3 / 6.4f));
    }

    private void b(TTNativeExpressAd tTNativeExpressAd) {
        Activity activity = this.g;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        tTNativeExpressAd.setDislikeCallback(this.g, new f());
    }

    public ADPBannerAdLoader(Activity activity, String str, ViewGroup viewGroup, ADPBannerADListener aDPBannerADListener, int i) {
        this.n = new Handler();
        this.q = 0;
        this.r = 30;
        this.t = false;
        this.u = true;
        this.v = new Handler();
        this.w = new ArrayList<>();
        this.y = false;
        this.z = new a();
        this.g = activity;
        this.i = str;
        this.h = viewGroup;
        this.k = aDPBannerADListener;
        this.q = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        this.j = str;
        destroy();
        c(this.g, this.i, "tencent", "4", this.s);
        UnifiedBannerView unifiedBannerView = new UnifiedBannerView(this.g, this.j, new h());
        A = unifiedBannerView;
        unifiedBannerView.setRefresh(0);
        try {
            this.h.addView(A, c());
        } catch (Exception unused) {
            this.h.addView(A);
        }
        A.loadAD();
    }
}
