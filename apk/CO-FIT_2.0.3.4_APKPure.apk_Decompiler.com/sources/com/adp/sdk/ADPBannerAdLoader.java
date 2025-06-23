package com.adp.sdk;

import OoOoXO0.xoXoI;
import android.app.Activity;
import android.content.Context;
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

public class ADPBannerAdLoader extends e {
    /* access modifiers changed from: private */
    public static UnifiedBannerView A;
    /* access modifiers changed from: private */
    public Activity g;
    /* access modifiers changed from: private */
    public ViewGroup h;
    /* access modifiers changed from: private */
    public String i;
    private String j;
    /* access modifiers changed from: private */
    public ADPBannerADListener k;
    /* access modifiers changed from: private */
    public ADPDownloadConfirmListener l;
    /* access modifiers changed from: private */
    public AdItem m;
    /* access modifiers changed from: private */
    public Handler n = new Handler();
    private TTAdNative o;
    /* access modifiers changed from: private */
    public TTNativeExpressAd p;
    private int q = 0;
    /* access modifiers changed from: private */
    public int r = 30;
    /* access modifiers changed from: private */
    public SourceVO s;
    /* access modifiers changed from: private */
    public boolean t = false;
    private boolean u = true;
    /* access modifiers changed from: private */
    public Handler v = new Handler();
    /* access modifiers changed from: private */
    public ArrayList<SourceVO> w = new ArrayList<>();
    private BannerView x;
    /* access modifiers changed from: private */
    public boolean y = false;
    /* access modifiers changed from: private */
    public Runnable z = new a();

    public interface ADPBannerADListener {
        void onADClicked();

        void onADClosed();

        void onADError(AdpError adpError);

        void onADPresent();

        void onADReceive();
    }

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            if (ADP.isInitSuccess()) {
                try {
                    ADPBannerAdLoader.this.d();
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
                ADPBannerAdLoader.this.n.removeCallbacks(ADPBannerAdLoader.this.z);
                Runnable unused = ADPBannerAdLoader.this.z = null;
                return;
            }
            ADPBannerAdLoader.this.n.postDelayed(this, 500);
        }
    }

    public class b implements TTAdNative.NativeExpressAdListener {
        public b() {
        }

        public void onError(int i, String str) {
            if (!ADPBannerAdLoader.this.t) {
                if (ADPBannerAdLoader.this.h != null) {
                    ADPBannerAdLoader.this.h.removeAllViews();
                }
                if (ADPBannerAdLoader.this.w.size() <= 0) {
                    ADPBannerAdLoader aDPBannerAdLoader = ADPBannerAdLoader.this;
                    aDPBannerAdLoader.a("adsplus", new AdpError(i + "", str));
                    return;
                }
                ADPBannerAdLoader.this.e();
            }
        }

        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            if (list == null || list.size() == 0) {
                ADPBannerAdLoader.this.a("adsplus", new AdpError("-1", "no ads"));
            } else if (ADPBannerAdLoader.this.g != null && !ADPBannerAdLoader.this.g.isFinishing()) {
                if (ADPBannerAdLoader.this.p != null) {
                    ADPBannerAdLoader.this.p.destroy();
                }
                TTNativeExpressAd unused = ADPBannerAdLoader.this.p = list.get(0);
                if (ADPBannerAdLoader.this.k != null) {
                    ADPBannerAdLoader.this.k.onADReceive();
                }
                ADPBannerAdLoader aDPBannerAdLoader = ADPBannerAdLoader.this;
                aDPBannerAdLoader.b(aDPBannerAdLoader.g, ADPBannerAdLoader.this.i, "gromore", "4", ADPBannerAdLoader.this.s);
                boolean unused2 = ADPBannerAdLoader.this.t = true;
                ADPBannerAdLoader aDPBannerAdLoader2 = ADPBannerAdLoader.this;
                aDPBannerAdLoader2.a(aDPBannerAdLoader2.p);
                if (!f.b()) {
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

    public class c extends AdListener {

        /* renamed from: a  reason: collision with root package name */
        boolean f629a = false;

        public c() {
        }

        public void onAdClicked() {
            if (ADPBannerAdLoader.this.k != null) {
                ADPBannerAdLoader.this.k.onADClicked();
            }
            ADPBannerAdLoader aDPBannerAdLoader = ADPBannerAdLoader.this;
            aDPBannerAdLoader.a(aDPBannerAdLoader.g, ADPBannerAdLoader.this.i, "huawei", "4", ADPBannerAdLoader.this.s);
        }

        public void onAdClosed() {
            if (!this.f629a && ADPBannerAdLoader.this.k != null) {
                ADPBannerAdLoader.this.k.onADClosed();
            }
            if (this.f629a) {
                this.f629a = false;
            }
        }

        public void onAdFailed(int i) {
            if (!ADPBannerAdLoader.this.t) {
                ADPBannerAdLoader.this.destroy();
                if (ADPBannerAdLoader.this.w.size() <= 0) {
                    ADPBannerAdLoader.this.a("adsplus", new AdpError(i + "", i + ">HUAWEI"));
                    return;
                }
                ADPBannerAdLoader.this.e();
            }
        }

        public void onAdLeave() {
            this.f629a = true;
        }

        public void onAdLoaded() {
            ADPBannerAdLoader aDPBannerAdLoader = ADPBannerAdLoader.this;
            aDPBannerAdLoader.b(aDPBannerAdLoader.g, ADPBannerAdLoader.this.i, "huawei", "4", ADPBannerAdLoader.this.s);
            boolean unused = ADPBannerAdLoader.this.t = true;
            if (ADPBannerAdLoader.this.k != null) {
                ADPBannerAdLoader.this.k.onADReceive();
            }
        }

        public void onAdOpened() {
            ADPBannerAdLoader aDPBannerAdLoader = ADPBannerAdLoader.this;
            aDPBannerAdLoader.e(aDPBannerAdLoader.g, ADPBannerAdLoader.this.i, "huawei", "4", ADPBannerAdLoader.this.s);
            if (ADPBannerAdLoader.this.k != null) {
                ADPBannerAdLoader.this.k.onADPresent();
            }
            if (!ADPBannerAdLoader.this.y) {
                a.a(ADPBannerAdLoader.this.m, (Context) ADPBannerAdLoader.this.g);
                boolean unused = ADPBannerAdLoader.this.y = true;
            }
        }
    }

    public class d implements f.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f630a;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                d dVar = d.this;
                ADPBannerAdLoader.this.b(dVar.f630a);
            }
        }

        public d(String str) {
            this.f630a = str;
        }

        public void a(int i, String str) {
            if (ADPBannerAdLoader.this.w.size() <= 0) {
                ADPBannerAdLoader.this.a("adsplus", new AdpError(i + "", str + ">csj"));
                return;
            }
            ADPBannerAdLoader.this.e();
        }

        public void success() {
            ADPBannerAdLoader.this.g.runOnUiThread(new a());
        }
    }

    public class e implements TTNativeExpressAd.ExpressAdInteractionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TTNativeExpressAd f632a;

        public e(TTNativeExpressAd tTNativeExpressAd) {
            this.f632a = tTNativeExpressAd;
        }

        public void onAdClicked(View view, int i) {
            if (ADPBannerAdLoader.this.k != null) {
                ADPBannerAdLoader.this.k.onADClicked();
            }
            ADPBannerAdLoader aDPBannerAdLoader = ADPBannerAdLoader.this;
            aDPBannerAdLoader.a(aDPBannerAdLoader.g, ADPBannerAdLoader.this.i, "gromore", "4", ADPBannerAdLoader.this.s);
        }

        public void onAdShow(View view, int i) {
            if (!ADPBannerAdLoader.this.y) {
                a.a(ADPBannerAdLoader.this.m, (Context) ADPBannerAdLoader.this.g);
                boolean unused = ADPBannerAdLoader.this.y = true;
            }
            ADPBannerAdLoader aDPBannerAdLoader = ADPBannerAdLoader.this;
            aDPBannerAdLoader.e(aDPBannerAdLoader.g, ADPBannerAdLoader.this.i, "gromore", "4", ADPBannerAdLoader.this.s);
            if (ADPBannerAdLoader.this.k != null) {
                ADPBannerAdLoader.this.k.onADPresent();
            }
        }

        public void onRenderFail(View view, String str, int i) {
        }

        public void onRenderSuccess(View view, float f, float f2) {
            View expressAdView;
            if (!f.b() && (expressAdView = this.f632a.getExpressAdView()) != null && ADPBannerAdLoader.this.h != null) {
                ADPBannerAdLoader.this.h.removeAllViews();
                try {
                    ADPBannerAdLoader.this.h.addView(expressAdView, ADPBannerAdLoader.this.c());
                } catch (Exception unused) {
                    ADPBannerAdLoader.this.h.addView(expressAdView);
                }
            }
        }
    }

    public class f implements TTAdDislike.DislikeInteractionCallback {
        public f() {
        }

        public void onCancel() {
        }

        public void onSelected(int i, String str, boolean z) {
            if (ADPBannerAdLoader.this.h != null) {
                ADPBannerAdLoader.this.h.removeAllViews();
            }
            if (ADPBannerAdLoader.this.k != null) {
                ADPBannerAdLoader.this.k.onADClosed();
            }
        }

        public void onShow() {
        }
    }

    public class g implements g.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f634a;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                g gVar = g.this;
                ADPBannerAdLoader.this.d(gVar.f634a);
            }
        }

        public g(String str) {
            this.f634a = str;
        }

        public void a() {
            ADPBannerAdLoader.this.a("adsplus", new AdpError("-1", "gdt error GDTAdSdk.start "));
        }

        public void success() {
            ADPBannerAdLoader.this.v.post(new a());
        }
    }

    public class h implements UnifiedBannerADListener {

        public class a implements DownloadConfirmListener {

            /* renamed from: com.adp.sdk.ADPBannerAdLoader$h$a$a  reason: collision with other inner class name */
            public class C0004a implements ADPDownloadConfirmCallBack {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ DownloadConfirmCallBack f638a;

                public C0004a(a aVar, DownloadConfirmCallBack downloadConfirmCallBack) {
                    this.f638a = downloadConfirmCallBack;
                }

                public void onCancel() {
                    DownloadConfirmCallBack downloadConfirmCallBack = this.f638a;
                    if (downloadConfirmCallBack != null) {
                        downloadConfirmCallBack.onCancel();
                    }
                }

                public void onConfirm() {
                    DownloadConfirmCallBack downloadConfirmCallBack = this.f638a;
                    if (downloadConfirmCallBack != null) {
                        downloadConfirmCallBack.onConfirm();
                    }
                }
            }

            public a() {
            }

            public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
                ADPBannerAdLoader.this.l.onDownloadConfirm(activity, i, str, new C0004a(this, downloadConfirmCallBack));
            }
        }

        public h() {
        }

        public void onADClicked() {
            if (ADPBannerAdLoader.this.k != null) {
                ADPBannerAdLoader.this.k.onADClicked();
            }
            ADPBannerAdLoader aDPBannerAdLoader = ADPBannerAdLoader.this;
            aDPBannerAdLoader.a(aDPBannerAdLoader.g, ADPBannerAdLoader.this.i, "tencent", "4", ADPBannerAdLoader.this.s);
        }

        public void onADClosed() {
            if (ADPBannerAdLoader.this.k != null) {
                ADPBannerAdLoader.this.k.onADClosed();
            }
        }

        public void onADExposure() {
            ADPBannerAdLoader aDPBannerAdLoader = ADPBannerAdLoader.this;
            aDPBannerAdLoader.e(aDPBannerAdLoader.g, ADPBannerAdLoader.this.i, "tencent", "4", ADPBannerAdLoader.this.s);
            if (ADPBannerAdLoader.this.k != null) {
                ADPBannerAdLoader.this.k.onADPresent();
            }
            if (!ADPBannerAdLoader.this.y) {
                a.a(ADPBannerAdLoader.this.m, (Context) ADPBannerAdLoader.this.g);
                boolean unused = ADPBannerAdLoader.this.y = true;
            }
        }

        public void onADLeftApplication() {
        }

        public void onADReceive() {
            ADPBannerAdLoader aDPBannerAdLoader = ADPBannerAdLoader.this;
            aDPBannerAdLoader.b(aDPBannerAdLoader.g, ADPBannerAdLoader.this.i, "tencent", "4", ADPBannerAdLoader.this.s);
            boolean unused = ADPBannerAdLoader.this.t = true;
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

        public void onNoAD(AdError adError) {
            if (!ADPBannerAdLoader.this.t) {
                ADPBannerAdLoader.this.destroy();
                if (ADPBannerAdLoader.this.w.size() <= 0) {
                    ADPBannerAdLoader aDPBannerAdLoader = ADPBannerAdLoader.this;
                    aDPBannerAdLoader.a("adsplus", new AdpError(adError.getErrorCode() + "", adError.getErrorMsg()));
                    return;
                }
                ADPBannerAdLoader.this.e();
            }
        }
    }

    private ADPBannerAdLoader() {
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
            } else if (this.i == null) {
                a("adsplus", new AdpError("B001", this.g.getString(R.string.B001)));
            } else {
                a();
                if (!ADP.isInitSuccess()) {
                    this.n.removeCallbacks(this.z);
                    this.n.postDelayed(this.z, 500);
                    return;
                }
                this.t = false;
                d();
            }
        }
    }

    public void setAdWidth(int i2) {
        this.q = i2;
    }

    public void setDownloadConfirmListener(ADPDownloadConfirmListener aDPDownloadConfirmListener) {
        this.l = aDPDownloadConfirmListener;
    }

    public void setRefreshTime(int i2) {
        UnifiedBannerView unifiedBannerView = A;
        if (unifiedBannerView == null) {
            return;
        }
        if (i2 == 0) {
            this.r = i2;
            unifiedBannerView.setRefresh(i2);
        } else if (i2 >= 30 && i2 <= 120) {
            this.r = i2;
            unifiedBannerView.setRefresh(i2);
        }
    }

    private void c(String str) {
        if (!h.a()) {
            h.a((Context) this.g);
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
        this.x.setBannerRefresh((long) this.r);
        AdParam a2 = h.a(5000);
        this.h.addView(this.x);
        this.x.setAdListener(new c());
        this.x.loadAd(a2);
    }

    /* access modifiers changed from: private */
    public void d() {
        AdInfo adInfo = a.b;
        if (adInfo == null || adInfo.getAdUnits() == null || adInfo.getAdUnits().size() <= 0 || !"0".equals(adInfo.getStatus())) {
            a("adsplus", new AdpError("B002", this.g.getString(R.string.B002)));
            return;
        }
        for (AdItem next : adInfo.getAdUnits()) {
            if ("Banner".equals(next.getType()) && this.i.equals(next.getAdUnitId())) {
                this.m = next;
            }
        }
        AdItem adItem = this.m;
        if (adItem == null) {
            a("adsplus", new AdpError("B003", this.g.getString(R.string.B003)));
        } else if (!adItem.isEnable()) {
            a("adsplus", new AdpError("B004", this.g.getString(R.string.B004)));
        } else {
            String b2 = a.b(this.m, (Context) this.g);
            if (b2 != null) {
                a("adsplus", new AdpError("C001", b2));
            } else if (this.m.getAdSource() == null || this.m.getAdSource().isEmpty()) {
                a("adsplus", new AdpError("B003", this.g.getString(R.string.B003)));
            } else {
                try {
                    this.u = this.m.isOpenLogs();
                } catch (Exception unused) {
                }
                int parseInt = Integer.parseInt(new com.adp.sdk.utils.d(this.g).b("bannerad_index", "0"));
                if (b.a(this.m, parseInt)) {
                    parseInt = 0;
                }
                SourceVO a2 = b.a(this.m, parseInt, this.g);
                this.s = a2;
                if (a2 == null) {
                    a("adsplus", new AdpError("B003", this.g.getString(R.string.B003)));
                    return;
                }
                this.w = b.a(this.m, a2);
                f();
                f((parseInt + 1) + "");
            }
        }
    }

    /* access modifiers changed from: private */
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
        } else if ("gromore".equals(this.s.getSource())) {
            a(this.s.getId());
        } else if ("bytedance".equals(this.s.getSource())) {
            a(this.s.getId());
        } else if ("huawei".equals(this.s.getSource())) {
            c(this.s.getId());
        } else if (!this.t) {
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
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        int i2;
        if (this.o == null) {
            this.o = ADP.getTTAdManager().createAdNative(this.g);
        }
        c(this.g, this.i, "gromore", "4", this.s);
        this.h.removeAllViews();
        int i3 = this.q;
        if (i3 > 0) {
            i2 = com.adp.sdk.utils.h.b(this.g, i3);
        } else {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) this.g.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            i2 = com.adp.sdk.utils.h.b(this.g, displayMetrics.widthPixels);
        }
        this.o.loadBannerExpressAd(new AdSlot.Builder().setCodeId(str).setAdCount(1).setImageAcceptedSize(com.adp.sdk.utils.h.a(this.g, i2), com.adp.sdk.utils.h.a(this.g, 50)).setExpressViewAcceptedSize((float) i2, 50.0f).build(), new b());
    }

    /* access modifiers changed from: private */
    public void a(String str, AdpError adpError) {
        ADPBannerADListener aDPBannerADListener = this.k;
        if (aDPBannerADListener != null) {
            aDPBannerADListener.onADError(adpError);
        }
        String str2 = str + xoXoI.f16453oxoX + adpError.getCode() + xoXoI.f16453oxoX + adpError.getMessage();
        if (this.u) {
            c.a().a((Context) this.g, this.i, str2, "4", this.s);
        }
    }

    private void e(String str) {
        if (g.a()) {
            d(str);
        } else if (!g.a(this.g, new g(str))) {
            a("adsplus", new AdpError("-1", "ads gdt is erro"));
        }
    }

    public ADPBannerAdLoader(Activity activity, String str, ViewGroup viewGroup, ADPBannerADListener aDPBannerADListener) {
        this.g = activity;
        this.i = str;
        this.h = viewGroup;
        this.k = aDPBannerADListener;
    }

    private void a(String str) {
        this.j = str;
        Activity activity = this.g;
        if (activity == null || activity.isFinishing() || !ADP.isInitSuccess()) {
            a("adsplus", new AdpError("-1", "ad is not init"));
        } else if (!f.a()) {
            f.a(this.g, new d(str));
        } else {
            b(str);
        }
    }

    private void f(String str) {
        Activity activity = this.g;
        if (activity != null) {
            new com.adp.sdk.utils.d(activity).a("bannerad_index", str);
        }
    }

    /* access modifiers changed from: private */
    public void a(TTNativeExpressAd tTNativeExpressAd) {
        View expressAdView;
        ViewGroup viewGroup;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.setExpressInteractionListener((TTNativeExpressAd.ExpressAdInteractionListener) new e(tTNativeExpressAd));
            b(tTNativeExpressAd);
            if (f.b() && (expressAdView = tTNativeExpressAd.getExpressAdView()) != null && (viewGroup = this.h) != null) {
                viewGroup.removeAllViews();
                try {
                    this.h.addView(expressAdView, c());
                } catch (Exception unused) {
                    this.h.addView(expressAdView);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public FrameLayout.LayoutParams c() {
        Point point = new Point();
        this.g.getWindowManager().getDefaultDisplay().getSize(point);
        if (this.q != 0) {
            int i2 = this.q;
            return new FrameLayout.LayoutParams(i2, Math.round(((float) i2) / 6.4f));
        } else if (this.g.getRequestedOrientation() == 0) {
            int i3 = point.y;
            return new FrameLayout.LayoutParams(i3, Math.round(((float) i3) / 6.4f));
        } else {
            int i4 = point.x;
            return new FrameLayout.LayoutParams(i4, Math.round(((float) i4) / 6.4f));
        }
    }

    private void b(TTNativeExpressAd tTNativeExpressAd) {
        Activity activity = this.g;
        if (activity != null && !activity.isFinishing()) {
            tTNativeExpressAd.setDislikeCallback(this.g, new f());
        }
    }

    public ADPBannerAdLoader(Activity activity, String str, ViewGroup viewGroup, ADPBannerADListener aDPBannerADListener, int i2) {
        this.g = activity;
        this.i = str;
        this.h = viewGroup;
        this.k = aDPBannerADListener;
        this.q = i2;
    }

    /* access modifiers changed from: private */
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
