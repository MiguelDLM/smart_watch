package com.adp.sdk;

import OoOoXO0.xoXoI;
import XIXIX.OOXIXo;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.adp.sdk.dto.AdInfo;
import com.adp.sdk.dto.AdItem;
import com.adp.sdk.dto.AdpError;
import com.adp.sdk.dto.SourceVO;
import com.adp.sdk.f;
import com.adp.sdk.g;
import com.adp.sdk.l;
import com.adp.sdk.listener.ADPDownloadConfirmCallBack;
import com.adp.sdk.listener.ADPDownloadConfirmListener;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd;
import com.alimm.tanx.core.ad.bean.TanxBiddingInfo;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.alimm.tanx.core.ad.listener.ITanxAdLoader;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.ui.TanxSdk;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashInteractionListener;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.garmin.fit.OxXXx0X;
import com.huawei.hms.ads.splash.SplashAdDisplayListener;
import com.huawei.hms.ads.splash.SplashView;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.multi.BuildConfig;
import com.jd.ad.sdk.splash.JADSplash;
import com.jd.ad.sdk.splash.JADSplashListener;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.List;
import oOoIIO0.OxxIIOOXO;
import oOoIIO0.oI0IIXIo;
import oOoIIO0.oIX0oI;
import oOoIIO0.x0XOIxOo;

public class ADPSplashAdLoader extends e {
    /* access modifiers changed from: private */
    public static JADSplash e0;
    /* access modifiers changed from: private */
    public boolean A = false;
    private TTAdNative B;
    private AdSlot C = null;
    /* access modifiers changed from: private */
    public View D = null;
    /* access modifiers changed from: private */
    public int E = 0;
    private View F;
    /* access modifiers changed from: private */
    public boolean G = false;
    /* access modifiers changed from: private */
    public ITanxSplashExpressAd H;
    /* access modifiers changed from: private */
    public Handler I = new Handler();
    private boolean J = false;
    /* access modifiers changed from: private */
    public boolean K = false;
    /* access modifiers changed from: private */
    public boolean L;
    /* access modifiers changed from: private */
    public boolean M = true;
    /* access modifiers changed from: private */
    public String N;
    private View O = null;
    private boolean P = false;
    /* access modifiers changed from: private */
    public SourceVO Q;
    /* access modifiers changed from: private */
    public boolean R = false;
    /* access modifiers changed from: private */
    public ArrayList<SourceVO> S = new ArrayList<>();
    /* access modifiers changed from: private */
    public oI0IIXIo T;
    /* access modifiers changed from: private */
    public boolean U = false;
    /* access modifiers changed from: private */
    public boolean V = false;
    private String W = "-1";
    /* access modifiers changed from: private */
    public double X = OOXIXo.f29376XO;
    private Dialog Y;
    /* access modifiers changed from: private */
    public int Z = 0;
    /* access modifiers changed from: private */
    public int a0 = 0;
    /* access modifiers changed from: private */
    public CSJSplashAd b0;
    /* access modifiers changed from: private */
    public final Runnable c0 = new k();
    /* access modifiers changed from: private */
    public final Runnable d0 = new h();
    /* access modifiers changed from: private */
    public int g = 0;
    /* access modifiers changed from: private */
    public Activity h;
    private ViewGroup i;
    /* access modifiers changed from: private */
    public String j;
    /* access modifiers changed from: private */
    public ADPSplashADListener k;
    /* access modifiers changed from: private */
    public ADPDownloadConfirmListener l;
    /* access modifiers changed from: private */
    public boolean m = false;
    private int n;
    private int o;
    /* access modifiers changed from: private */
    public SplashAD p;
    /* access modifiers changed from: private */
    public SplashAd q;
    /* access modifiers changed from: private */
    public AdItem r;
    /* access modifiers changed from: private */
    public ViewGroup s;
    private ImageView t;
    /* access modifiers changed from: private */
    public Handler u = new Handler();
    /* access modifiers changed from: private */
    public Handler v = new Handler();
    /* access modifiers changed from: private */
    public long w = 0;
    /* access modifiers changed from: private */
    public boolean x = false;
    /* access modifiers changed from: private */
    public boolean y = false;
    /* access modifiers changed from: private */
    public boolean z = false;

    public interface ADPSplashADListener {
        void onADClicked();

        void onADDismissed();

        void onADError(AdpError adpError);

        void onADPresent();

        void onADReceive(long j);

        void onADTick(long j);
    }

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f683a;
        final /* synthetic */ boolean b;

        public a(String str, boolean z) {
            this.f683a = str;
            this.b = z;
        }

        public void run() {
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.b(this.f683a, this.b, aDPSplashAdLoader.s.getWidth(), ADPSplashAdLoader.this.s.getHeight());
        }
    }

    public class c implements JADSplashListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f686a;

        public c(boolean z) {
            this.f686a = z;
        }

        public void onClick() {
            boolean unused = ADPSplashAdLoader.this.z = true;
            boolean unused2 = ADPSplashAdLoader.this.L = true;
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.a(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, BuildConfig.FLAVOR, "1", ADPSplashAdLoader.this.Q);
            if (!ADPSplashAdLoader.this.K) {
                boolean unused3 = ADPSplashAdLoader.this.K = true;
                if (ADPSplashAdLoader.this.k != null && ADPSplashAdLoader.this.M) {
                    ADPSplashAdLoader.this.k.onADClicked();
                }
            }
        }

        public void onClose() {
            if (ADPSplashAdLoader.e0 != null) {
                ADPSplashAdLoader.e0.destroy();
                JADSplash unused = ADPSplashAdLoader.e0 = null;
            }
            ADPSplashAdLoader.this.f();
            boolean unused2 = ADPSplashAdLoader.this.x = false;
            boolean unused3 = ADPSplashAdLoader.this.z = false;
            boolean unused4 = ADPSplashAdLoader.this.y = false;
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADDismissed();
            }
        }

        public void onExposure() {
            boolean unused = ADPSplashAdLoader.this.z = true;
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADPresent();
            }
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.e(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, BuildConfig.FLAVOR, "1", ADPSplashAdLoader.this.Q);
            a.a(ADPSplashAdLoader.this.r, (Context) ADPSplashAdLoader.this.h);
        }

        public void onLoadFailure(int i, String str) {
            ADPSplashAdLoader.this.f();
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.a(i + " >>" + str, BuildConfig.FLAVOR, this.f686a);
        }

        public void onLoadSuccess() {
        }

        public void onRenderFailure(int i, String str) {
            ADPSplashAdLoader.this.f();
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.a(i + " >>" + str, "gromore", this.f686a);
        }

        public void onRenderSuccess(View view) {
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.b(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, BuildConfig.FLAVOR, "1", ADPSplashAdLoader.this.Q);
            boolean unused = ADPSplashAdLoader.this.x = false;
            if (view == null) {
                ADPSplashAdLoader.this.a("  ad is null", BuildConfig.FLAVOR, this.f686a);
                return;
            }
            ADPSplashAdLoader.this.d();
            if (ADPSplashAdLoader.this.V || ADPSplashAdLoader.this.E < 2) {
                View unused2 = ADPSplashAdLoader.this.D = view;
                boolean unused3 = ADPSplashAdLoader.this.x = true;
                boolean unused4 = ADPSplashAdLoader.this.U = true;
                if (ADPSplashAdLoader.this.V || (!ADPSplashAdLoader.this.R && ADPSplashAdLoader.this.k != null)) {
                    ADPSplashAdLoader.this.k.onADReceive(-1);
                }
                boolean unused5 = ADPSplashAdLoader.this.z = true;
                if (ADPSplashAdLoader.this.j()) {
                    ADPSplashAdLoader aDPSplashAdLoader2 = ADPSplashAdLoader.this;
                    ViewGroup unused6 = aDPSplashAdLoader2.s = aDPSplashAdLoader2.a(aDPSplashAdLoader2.h, false);
                    ADPSplashAdLoader.this.s.removeAllViews();
                    ADPSplashAdLoader.this.s.addView(ADPSplashAdLoader.this.D);
                } else if (!this.f686a) {
                    ADPSplashAdLoader.this.s.removeAllViews();
                    ADPSplashAdLoader.this.s.addView(ADPSplashAdLoader.this.D);
                }
            } else {
                ADPSplashAdLoader.this.c(this.f686a);
            }
        }
    }

    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f687a;
        final /* synthetic */ boolean b;

        public d(String str, boolean z) {
            this.f687a = str;
            this.b = z;
        }

        public void run() {
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.a(this.f687a, this.b, aDPSplashAdLoader.s.getWidth(), ADPSplashAdLoader.this.s.getHeight(), false);
        }
    }

    public class e extends SplashAdDisplayListener {
        public e() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a() {
            ADPSplashAdLoader.this.e();
        }

        public void onAdClick() {
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.a(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "huawei", "1", ADPSplashAdLoader.this.Q);
            boolean unused = ADPSplashAdLoader.this.z = true;
            boolean unused2 = ADPSplashAdLoader.this.L = true;
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADClicked();
            }
            new Handler().postDelayed(new oIX0oI(this), 1500);
        }

        public void onAdShowed() {
            boolean unused = ADPSplashAdLoader.this.z = true;
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADPresent();
            }
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.e(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "huawei", "1", ADPSplashAdLoader.this.Q);
            a.a(ADPSplashAdLoader.this.r, (Context) ADPSplashAdLoader.this.h);
        }
    }

    public class f extends SplashView.SplashAdLoadListener {

        /* renamed from: a  reason: collision with root package name */
        boolean f689a = false;
        final /* synthetic */ boolean b;

        public f(boolean z) {
            this.b = z;
        }

        public void onAdDismissed() {
            if (!this.f689a) {
                ADPSplashAdLoader.this.e();
            }
        }

        public void onAdFailedToLoad(int i) {
            this.f689a = true;
            ADPSplashAdLoader.this.f();
            boolean unused = ADPSplashAdLoader.this.x = false;
            boolean unused2 = ADPSplashAdLoader.this.z = false;
            boolean unused3 = ADPSplashAdLoader.this.y = false;
            ADPSplashAdLoader.this.b("huawei", i + "", "" + i);
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            if (aDPSplashAdLoader.f && aDPSplashAdLoader.N != null && ADPSplashAdLoader.this.N.length() > 0) {
                c.a().a((Context) ADPSplashAdLoader.this.h, ADPSplashAdLoader.this.j, ADPSplashAdLoader.this.N, "1", ADPSplashAdLoader.this.Q);
            }
            if ((!ADPSplashAdLoader.this.i() || ADPSplashAdLoader.this.S.size() != 0) && (ADPSplashAdLoader.this.i() || (ADPSplashAdLoader.this.E < 2 && ADPSplashAdLoader.this.S.size() != 0))) {
                ADPSplashAdLoader.this.c(this.b);
                return;
            }
            ADPSplashAdLoader.this.a("huawei", new AdpError(i + "", i + ""));
        }

        public void onAdLoaded() {
            boolean unused = ADPSplashAdLoader.this.G = true;
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.b(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "huawei", "1", ADPSplashAdLoader.this.Q);
            boolean unused2 = ADPSplashAdLoader.this.U = true;
            boolean unused3 = ADPSplashAdLoader.this.x = true;
            ADPSplashAdLoader.this.d();
            if (ADPSplashAdLoader.this.V || (!ADPSplashAdLoader.this.R && ADPSplashAdLoader.this.k != null)) {
                ADPSplashAdLoader.this.k.onADReceive(5);
            }
            boolean unused4 = ADPSplashAdLoader.this.z = true;
        }
    }

    public class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f690a;
        final /* synthetic */ boolean b;

        public g(String str, boolean z) {
            this.f690a = str;
            this.b = z;
        }

        public void run() {
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.c(this.f690a, this.b, aDPSplashAdLoader.s.getWidth(), ADPSplashAdLoader.this.s.getHeight());
        }
    }

    public class h implements Runnable {
        public h() {
        }

        public void run() {
            if (ADPSplashAdLoader.this.X >= ((double) ADPSplashAdLoader.this.g)) {
                int unused = ADPSplashAdLoader.this.E = 2;
                if (!ADPSplashAdLoader.this.R && !ADPSplashAdLoader.this.U) {
                    ADPSplashAdLoader.this.a("adsplus", "-1", "sdk广告超时");
                }
                ADPSplashAdLoader.this.d();
                return;
            }
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            double unused2 = aDPSplashAdLoader.X = aDPSplashAdLoader.X + 200.0d;
            ADPSplashAdLoader.this.I.postDelayed(ADPSplashAdLoader.this.d0, 200);
        }
    }

    public class i implements g.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f692a;
        final /* synthetic */ boolean b;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                i iVar = i.this;
                ADPSplashAdLoader.this.i(iVar.f692a, iVar.b);
            }
        }

        public i(String str, boolean z) {
            this.f692a = str;
            this.b = z;
        }

        public void a() {
            ADPSplashAdLoader.this.a("adsplus", "-1", "gdt error GDTAdSdk.start ", this.b);
        }

        public void success() {
            ADPSplashAdLoader.this.v.post(new a());
        }
    }

    public class j implements SplashADListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f694a;

        public class a implements DownloadConfirmListener {

            /* renamed from: com.adp.sdk.ADPSplashAdLoader$j$a$a  reason: collision with other inner class name */
            public class C0011a implements ADPDownloadConfirmCallBack {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ DownloadConfirmCallBack f696a;

                public C0011a(a aVar, DownloadConfirmCallBack downloadConfirmCallBack) {
                    this.f696a = downloadConfirmCallBack;
                }

                public void onCancel() {
                    DownloadConfirmCallBack downloadConfirmCallBack = this.f696a;
                    if (downloadConfirmCallBack != null) {
                        downloadConfirmCallBack.onCancel();
                    }
                }

                public void onConfirm() {
                    DownloadConfirmCallBack downloadConfirmCallBack = this.f696a;
                    if (downloadConfirmCallBack != null) {
                        downloadConfirmCallBack.onConfirm();
                    }
                }
            }

            public a() {
            }

            public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
                ADPSplashAdLoader.this.l.onDownloadConfirm(activity, i, str, new C0011a(this, downloadConfirmCallBack));
            }
        }

        public j(boolean z) {
            this.f694a = z;
        }

        public void onADClicked() {
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.a(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "tencent", "1", ADPSplashAdLoader.this.Q);
            boolean unused = ADPSplashAdLoader.this.z = true;
            boolean unused2 = ADPSplashAdLoader.this.L = true;
            if (!ADPSplashAdLoader.this.K) {
                boolean unused3 = ADPSplashAdLoader.this.K = true;
                if (ADPSplashAdLoader.this.k != null && ADPSplashAdLoader.this.M) {
                    ADPSplashAdLoader.this.k.onADClicked();
                }
            }
            ADPSplashAdLoader.this.c("2");
        }

        public void onADDismissed() {
            ADPSplashAdLoader.this.f();
            boolean unused = ADPSplashAdLoader.this.x = false;
            boolean unused2 = ADPSplashAdLoader.this.z = false;
            boolean unused3 = ADPSplashAdLoader.this.y = false;
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADDismissed();
            }
        }

        public void onADExposure() {
            ADPSplashAdLoader.this.c("1");
            boolean unused = ADPSplashAdLoader.this.z = true;
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.e(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "tencent", "1", ADPSplashAdLoader.this.Q);
            a.a(ADPSplashAdLoader.this.r, (Context) ADPSplashAdLoader.this.h);
        }

        public void onADLoaded(long j) {
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.b(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "tencent", "1", ADPSplashAdLoader.this.Q);
            if (ADPSplashAdLoader.this.V || ADPSplashAdLoader.this.E < 2) {
                boolean unused = ADPSplashAdLoader.this.U = true;
                if (ADPSplashAdLoader.this.p != null) {
                    ADPSplashAdLoader.this.p.getECPMLevel();
                }
                ADPSplashAdLoader aDPSplashAdLoader2 = ADPSplashAdLoader.this;
                boolean z = aDPSplashAdLoader2.f;
                boolean unused2 = aDPSplashAdLoader2.x = true;
                ADPSplashAdLoader.this.d();
                if (ADPSplashAdLoader.this.V || (!ADPSplashAdLoader.this.R && ADPSplashAdLoader.this.k != null)) {
                    ADPSplashAdLoader.this.k.onADReceive(j);
                }
                if (!(ADPSplashAdLoader.this.l == null || ADPSplashAdLoader.this.p == null)) {
                    try {
                        ADPSplashAdLoader.this.p.setDownloadConfirmListener(new a());
                    } catch (Exception unused3) {
                    }
                }
                if (ADPSplashAdLoader.this.j()) {
                    ADPSplashAdLoader aDPSplashAdLoader3 = ADPSplashAdLoader.this;
                    ViewGroup unused4 = aDPSplashAdLoader3.s = aDPSplashAdLoader3.a(aDPSplashAdLoader3.h, true);
                    ADPSplashAdLoader.this.l();
                    boolean unused5 = ADPSplashAdLoader.this.z = true;
                } else if (!this.f694a) {
                    if (ADPSplashAdLoader.this.m) {
                        ADPSplashAdLoader.this.p.showFullScreenAd(ADPSplashAdLoader.this.s);
                    } else {
                        ADPSplashAdLoader.this.p.showAd(ADPSplashAdLoader.this.s);
                    }
                    boolean unused6 = ADPSplashAdLoader.this.z = true;
                }
            } else {
                ADPSplashAdLoader.this.c(this.f694a);
            }
        }

        public void onADPresent() {
            boolean unused = ADPSplashAdLoader.this.z = true;
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADPresent();
            }
        }

        public void onADTick(long j) {
            boolean unused = ADPSplashAdLoader.this.z = true;
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADTick(j);
            }
        }

        public void onNoAD(AdError adError) {
            ADPSplashAdLoader.this.f();
            boolean unused = ADPSplashAdLoader.this.x = false;
            boolean unused2 = ADPSplashAdLoader.this.z = false;
            boolean unused3 = ADPSplashAdLoader.this.y = false;
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.b("tencent", adError.getErrorCode() + "", adError.getErrorMsg());
            ADPSplashAdLoader aDPSplashAdLoader2 = ADPSplashAdLoader.this;
            if (aDPSplashAdLoader2.f && aDPSplashAdLoader2.N != null && ADPSplashAdLoader.this.N.length() > 0) {
                c.a().a((Context) ADPSplashAdLoader.this.h, ADPSplashAdLoader.this.j, ADPSplashAdLoader.this.N, "1", ADPSplashAdLoader.this.Q);
            }
            if ((!ADPSplashAdLoader.this.i() || ADPSplashAdLoader.this.S.size() != 0) && (ADPSplashAdLoader.this.i() || (ADPSplashAdLoader.this.E < 2 && ADPSplashAdLoader.this.S.size() != 0))) {
                ADPSplashAdLoader.this.c(this.f694a);
                return;
            }
            ADPSplashAdLoader aDPSplashAdLoader3 = ADPSplashAdLoader.this;
            aDPSplashAdLoader3.a("tencent", new AdpError(adError.getErrorCode() + "", adError.getErrorMsg()));
        }
    }

    public class k implements Runnable {
        public k() {
        }

        public void run() {
            if (ADPSplashAdLoader.this.h != null) {
                if (ADPSplashAdLoader.this.h.isFinishing()) {
                    ADPSplashAdLoader.this.u.removeCallbacks(ADPSplashAdLoader.this.c0);
                    return;
                } else if ((System.currentTimeMillis() - ADPSplashAdLoader.this.w) / 1000 >= 10) {
                    ADPSplashAdLoader.this.u.removeCallbacks(ADPSplashAdLoader.this.c0);
                    ADPSplashAdLoader.this.a("adsplus", new AdpError("-1", "time out"));
                    return;
                }
            }
            if (ADP.isInitSuccess()) {
                ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
                aDPSplashAdLoader.b(aDPSplashAdLoader.A);
                ADPSplashAdLoader.this.u.removeCallbacks(ADPSplashAdLoader.this.c0);
                return;
            }
            ADPSplashAdLoader.this.u.postDelayed(this, 120);
        }
    }

    public class l extends CountDownTimer {
        public l(long j, long j2) {
            super(j, j2);
        }

        public void onFinish() {
            if (!ADPSplashAdLoader.this.j()) {
                return;
            }
            if (ADPSplashAdLoader.this.m) {
                ADPSplashAdLoader.this.p.showFullScreenAd(ADPSplashAdLoader.this.s);
            } else {
                ADPSplashAdLoader.this.p.showAd(ADPSplashAdLoader.this.s);
            }
        }

        public void onTick(long j) {
        }
    }

    public class m implements KsLoadManager.SplashScreenAdListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f699a;

        public m(boolean z) {
            this.f699a = z;
        }

        public void onError(int i, String str) {
            ADPSplashAdLoader.this.f();
            boolean unused = ADPSplashAdLoader.this.x = false;
            boolean unused2 = ADPSplashAdLoader.this.z = false;
            boolean unused3 = ADPSplashAdLoader.this.y = false;
            if ((!ADPSplashAdLoader.this.i() || ADPSplashAdLoader.this.S.size() != 0) && (ADPSplashAdLoader.this.i() || (ADPSplashAdLoader.this.E < 2 && ADPSplashAdLoader.this.S.size() != 0))) {
                ADPSplashAdLoader.this.c(this.f699a);
                return;
            }
            if (ADPSplashAdLoader.this.f && str != null && str.length() > 0) {
                c.a().a((Context) ADPSplashAdLoader.this.h, ADPSplashAdLoader.this.j, str, "1", ADPSplashAdLoader.this.Q);
            }
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.a("kuaishou", new AdpError("-1", str + ""));
        }

        public void onRequestResult(int i) {
        }

        public void onSplashScreenAdLoad(@NonNull KsSplashScreenAd ksSplashScreenAd) {
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.b(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "kuaishou", "1", ADPSplashAdLoader.this.Q);
            if (ADPSplashAdLoader.this.V || ADPSplashAdLoader.this.E < 2) {
                boolean unused = ADPSplashAdLoader.this.U = true;
                boolean unused2 = ADPSplashAdLoader.this.x = true;
                ADPSplashAdLoader.this.d();
                ADPSplashAdLoader.this.a(ksSplashScreenAd, this.f699a);
                return;
            }
            ADPSplashAdLoader.this.c(this.f699a);
        }
    }

    public class n implements KsSplashScreenAd.SplashScreenAdInteractionListener {
        public n() {
        }

        public void onAdClicked() {
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.a(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "kuaishou", "1", ADPSplashAdLoader.this.Q);
        }

        public void onAdShowEnd() {
            ADPSplashAdLoader.this.f();
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADDismissed();
            }
        }

        public void onAdShowError(int i, String str) {
            ADPSplashAdLoader.this.f();
            ADPSplashAdLoader.this.a("kuaishou", new AdpError(i + "", "打开错误:" + str));
        }

        public void onAdShowStart() {
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.e(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "kuaishou", "1", ADPSplashAdLoader.this.Q);
            a.a(ADPSplashAdLoader.this.r, (Context) ADPSplashAdLoader.this.h);
        }

        public void onDownloadTipsDialogCancel() {
        }

        public void onDownloadTipsDialogDismiss() {
        }

        public void onDownloadTipsDialogShow() {
        }

        public void onSkippedAd() {
            ADPSplashAdLoader.this.f();
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADDismissed();
            }
        }
    }

    public class o implements OxxIIOOXO {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f701a;

        public o(boolean z) {
            this.f701a = z;
        }

        public void onAdCacheLoaded() {
        }

        public void onAdClicked() {
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.a(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "octopus", "1", ADPSplashAdLoader.this.Q);
            boolean unused = ADPSplashAdLoader.this.z = true;
            boolean unused2 = ADPSplashAdLoader.this.L = true;
            if (ADPSplashAdLoader.this.k != null && ADPSplashAdLoader.this.M) {
                ADPSplashAdLoader.this.k.onADClicked();
            }
        }

        public void onAdClosed() {
            ADPSplashAdLoader.this.f();
            boolean unused = ADPSplashAdLoader.this.x = false;
            boolean unused2 = ADPSplashAdLoader.this.z = false;
            boolean unused3 = ADPSplashAdLoader.this.y = false;
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADDismissed();
            }
        }

        public void onAdFailedToLoad(int i) {
            ADPSplashAdLoader.this.f();
            boolean unused = ADPSplashAdLoader.this.x = false;
            boolean unused2 = ADPSplashAdLoader.this.z = false;
            boolean unused3 = ADPSplashAdLoader.this.y = false;
            ADPSplashAdLoader.this.b("octopus", i + "", "otoccode：" + i);
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            if (aDPSplashAdLoader.f && aDPSplashAdLoader.N != null && ADPSplashAdLoader.this.N.length() > 0) {
                c.a().a((Context) ADPSplashAdLoader.this.h, ADPSplashAdLoader.this.j, ADPSplashAdLoader.this.N, "1", ADPSplashAdLoader.this.Q);
            }
            if ((!ADPSplashAdLoader.this.i() || ADPSplashAdLoader.this.S.size() != 0) && (ADPSplashAdLoader.this.i() || (ADPSplashAdLoader.this.E < 2 && ADPSplashAdLoader.this.S.size() != 0))) {
                ADPSplashAdLoader.this.c(this.f701a);
                return;
            }
            ADPSplashAdLoader.this.a("octopus", new AdpError(i + "", "otoccode：" + i));
        }

        public void onAdLoaded() {
            if (ADPSplashAdLoader.this.T == null) {
                ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
                aDPSplashAdLoader.b(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "octopus", "1", ADPSplashAdLoader.this.Q);
            } else {
                ADPSplashAdLoader aDPSplashAdLoader2 = ADPSplashAdLoader.this;
                Activity a2 = aDPSplashAdLoader2.h;
                String J = ADPSplashAdLoader.this.j;
                SourceVO K = ADPSplashAdLoader.this.Q;
                aDPSplashAdLoader2.a(a2, J, "octopus", "1", K, ADPSplashAdLoader.this.T.OOXIXo() + "");
            }
            if (ADPSplashAdLoader.this.V || ADPSplashAdLoader.this.E < 2) {
                try {
                    if (ADPSplashAdLoader.this.Q.getPrice() != null) {
                        int parseInt = Integer.parseInt(ADPSplashAdLoader.this.Q.getPrice());
                        if (parseInt > ADPSplashAdLoader.this.T.OOXIXo()) {
                            ADPSplashAdLoader.this.T.II0XooXoX(parseInt, oIX0oI.f6142II0xO0, oIX0oI.f6146Oxx0IOOO);
                            ADPSplashAdLoader.this.c(this.f701a);
                            return;
                        }
                        ADPSplashAdLoader.this.T.II0xO0(parseInt);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ADPSplashAdLoader.this.d();
                boolean unused = ADPSplashAdLoader.this.U = true;
                boolean unused2 = ADPSplashAdLoader.this.x = true;
                if ((!ADPSplashAdLoader.this.R && ADPSplashAdLoader.this.k != null) || (ADPSplashAdLoader.this.V && ADPSplashAdLoader.this.k != null)) {
                    ADPSplashAdLoader.this.k.onADReceive(-1);
                }
                boolean unused3 = ADPSplashAdLoader.this.z = false;
                if ((!this.f701a || ADPSplashAdLoader.this.V) && ADPSplashAdLoader.this.j()) {
                    ADPSplashAdLoader.this.c(this.f701a);
                    return;
                }
                return;
            }
            ADPSplashAdLoader.this.c(this.f701a);
        }

        public void onAdShown() {
            boolean unused = ADPSplashAdLoader.this.z = true;
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADPresent();
            }
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.e(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "octopus", "1", ADPSplashAdLoader.this.Q);
            a.a(ADPSplashAdLoader.this.r, (Context) ADPSplashAdLoader.this.h);
        }

        public void onAdTick(long j) {
        }
    }

    public class p implements Runnable {
        public p() {
        }

        public void run() {
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            int unused = aDPSplashAdLoader.Z = aDPSplashAdLoader.s.getWidth();
            ADPSplashAdLoader aDPSplashAdLoader2 = ADPSplashAdLoader.this;
            int unused2 = aDPSplashAdLoader2.a0 = aDPSplashAdLoader2.s.getHeight();
        }
    }

    public class q implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f703a;
        final /* synthetic */ boolean b;

        public q(String str, boolean z) {
            this.f703a = str;
            this.b = z;
        }

        public void run() {
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.a(this.f703a, this.b, aDPSplashAdLoader.s.getWidth(), ADPSplashAdLoader.this.s.getHeight());
        }
    }

    public class r implements SplashInteractionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f704a;

        public r(boolean z) {
            this.f704a = z;
        }

        public void onADLoaded() {
        }

        public void onAdCacheFailed() {
            ADPSplashAdLoader.this.a("onAdCacheFailed", "baidu", this.f704a);
            ADPSplashAdLoader.this.f();
        }

        public void onAdCacheSuccess() {
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.b(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "baidu", "1", ADPSplashAdLoader.this.Q);
            if (ADPSplashAdLoader.this.V || ADPSplashAdLoader.this.E < 2) {
                boolean unused = ADPSplashAdLoader.this.U = true;
                boolean unused2 = ADPSplashAdLoader.this.x = true;
                ADPSplashAdLoader.this.d();
                if (ADPSplashAdLoader.this.V || (!ADPSplashAdLoader.this.R && ADPSplashAdLoader.this.k != null)) {
                    ADPSplashAdLoader.this.k.onADReceive(0);
                }
                if (ADPSplashAdLoader.this.j()) {
                    ADPSplashAdLoader aDPSplashAdLoader2 = ADPSplashAdLoader.this;
                    ViewGroup unused3 = aDPSplashAdLoader2.s = aDPSplashAdLoader2.a(aDPSplashAdLoader2.h, false);
                    boolean unused4 = ADPSplashAdLoader.this.z = true;
                    ADPSplashAdLoader.this.q.show(ADPSplashAdLoader.this.s);
                } else if (!this.f704a) {
                    ADPSplashAdLoader.this.q.show(ADPSplashAdLoader.this.s);
                    boolean unused5 = ADPSplashAdLoader.this.z = true;
                }
            } else {
                ADPSplashAdLoader.this.c(this.f704a);
            }
        }

        public void onAdClick() {
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.a(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "baidu", "1", ADPSplashAdLoader.this.Q);
            boolean unused = ADPSplashAdLoader.this.z = true;
            boolean unused2 = ADPSplashAdLoader.this.L = true;
            if (!ADPSplashAdLoader.this.K) {
                boolean unused3 = ADPSplashAdLoader.this.K = true;
                if (ADPSplashAdLoader.this.k != null && ADPSplashAdLoader.this.M) {
                    ADPSplashAdLoader.this.k.onADClicked();
                }
            }
        }

        public void onAdDismissed() {
            boolean unused = ADPSplashAdLoader.this.x = false;
            boolean unused2 = ADPSplashAdLoader.this.z = false;
            boolean unused3 = ADPSplashAdLoader.this.y = false;
            ADPSplashAdLoader.this.f();
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADDismissed();
            }
        }

        public void onAdExposed() {
        }

        public void onAdFailed(String str) {
            ADPSplashAdLoader.this.a(str, "baidu", this.f704a);
            ADPSplashAdLoader.this.f();
        }

        public void onAdPresent() {
            boolean unused = ADPSplashAdLoader.this.z = true;
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADPresent();
            }
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.e(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "baidu", "1", ADPSplashAdLoader.this.Q);
            a.a(ADPSplashAdLoader.this.r, (Context) ADPSplashAdLoader.this.h);
        }

        public void onAdSkip() {
            boolean unused = ADPSplashAdLoader.this.x = false;
            boolean unused2 = ADPSplashAdLoader.this.z = false;
            boolean unused3 = ADPSplashAdLoader.this.y = false;
            ADPSplashAdLoader.this.f();
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADDismissed();
            }
        }

        public void onLpClosed() {
            boolean unused = ADPSplashAdLoader.this.x = false;
            boolean unused2 = ADPSplashAdLoader.this.z = false;
            boolean unused3 = ADPSplashAdLoader.this.y = false;
            ADPSplashAdLoader.this.f();
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADDismissed();
            }
        }
    }

    public class s implements l.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f705a;
        final /* synthetic */ boolean b;

        public s(String str, boolean z) {
            this.f705a = str;
            this.b = z;
        }

        public void a(int i, String str) {
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.a(i + " >> " + str, ExposeManager.UtArgsNames.nameSpace, this.b);
        }

        public void success() {
            ADPSplashAdLoader.this.h(this.f705a, this.b);
        }
    }

    public class t implements ITanxSplashExpressAd.OnSplashAdListener {
        public t() {
        }

        public void onAdClicked() {
            boolean unused = ADPSplashAdLoader.this.z = true;
            boolean unused2 = ADPSplashAdLoader.this.L = true;
            if (ADPSplashAdLoader.this.k != null && ADPSplashAdLoader.this.M) {
                ADPSplashAdLoader.this.k.onADClicked();
            }
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.a(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, ExposeManager.UtArgsNames.nameSpace, "1", ADPSplashAdLoader.this.Q);
        }

        public void onAdClosed() {
            boolean unused = ADPSplashAdLoader.this.x = false;
            boolean unused2 = ADPSplashAdLoader.this.z = false;
            boolean unused3 = ADPSplashAdLoader.this.y = false;
            ADPSplashAdLoader.this.f();
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADDismissed();
                ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
                if (aDPSplashAdLoader.f && aDPSplashAdLoader.N != null && ADPSplashAdLoader.this.N.length() > 0) {
                    c.a().a((Context) ADPSplashAdLoader.this.h, ADPSplashAdLoader.this.j, ADPSplashAdLoader.this.N, "1", ADPSplashAdLoader.this.Q);
                }
            }
        }

        public void onAdFinish() {
            boolean unused = ADPSplashAdLoader.this.x = false;
            boolean unused2 = ADPSplashAdLoader.this.z = false;
            boolean unused3 = ADPSplashAdLoader.this.y = false;
            ADPSplashAdLoader.this.f();
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADDismissed();
                ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
                if (aDPSplashAdLoader.f && aDPSplashAdLoader.N != null && ADPSplashAdLoader.this.N.length() > 0) {
                    c.a().a((Context) ADPSplashAdLoader.this.h, ADPSplashAdLoader.this.j, ADPSplashAdLoader.this.N, "1", ADPSplashAdLoader.this.Q);
                }
            }
        }

        public void onAdRender(ITanxSplashExpressAd iTanxSplashExpressAd) {
        }

        public void onAdShake() {
            boolean unused = ADPSplashAdLoader.this.z = true;
            boolean unused2 = ADPSplashAdLoader.this.L = true;
            if (ADPSplashAdLoader.this.k != null && ADPSplashAdLoader.this.M) {
                ADPSplashAdLoader.this.k.onADClicked();
            }
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.a(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, ExposeManager.UtArgsNames.nameSpace, "1", ADPSplashAdLoader.this.Q);
        }

        public void onAdShow() {
            boolean unused = ADPSplashAdLoader.this.z = true;
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADPresent();
            }
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.e(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, ExposeManager.UtArgsNames.nameSpace, "1", ADPSplashAdLoader.this.Q);
            a.a(ADPSplashAdLoader.this.r, (Context) ADPSplashAdLoader.this.h);
        }

        public void onShowError(TanxError tanxError) {
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.a(ExposeManager.UtArgsNames.nameSpace, new AdpError("-1", "ShowError tanx" + tanxError.getMessage() + tanxError.getCode()));
        }
    }

    public class u implements ITanxAdLoader.OnAdLoadListener<ITanxSplashExpressAd> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f707a;
        final /* synthetic */ ITanxAdLoader b;

        public class a implements ITanxRequestLoader.OnBiddingListener {
            public a(u uVar) {
            }

            public void onResult(List list) {
            }
        }

        public class b implements ITanxRequestLoader.OnBiddingListener {
            public b(u uVar) {
            }

            public void onResult(List list) {
            }
        }

        public u(boolean z, ITanxAdLoader iTanxAdLoader) {
            this.f707a = z;
            this.b = iTanxAdLoader;
        }

        public void onError(TanxError tanxError) {
            ADPSplashAdLoader.this.f();
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.a("error:" + tanxError.getCode() + tanxError.getMessage(), ExposeManager.UtArgsNames.nameSpace, this.f707a);
        }

        public void onLoaded(List<ITanxSplashExpressAd> list) {
            ADPSplashAdLoader.this.d();
            boolean unused = ADPSplashAdLoader.this.x = false;
            boolean unused2 = ADPSplashAdLoader.this.U = true;
            if (list == null || list.isEmpty()) {
                ADPSplashAdLoader.this.a("  ad is null", ExposeManager.UtArgsNames.nameSpace, this.f707a);
                return;
            }
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.b(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, ExposeManager.UtArgsNames.nameSpace, "1", ADPSplashAdLoader.this.Q);
            try {
                if (ADPSplashAdLoader.this.Q.getPrice() != null && ADPSplashAdLoader.this.Q.getPrice().length() > 0) {
                    int parseInt = Integer.parseInt(ADPSplashAdLoader.this.Q.getPrice());
                    TanxBiddingInfo biddingInfo = list.get(0).getBiddingInfo();
                    if (((long) parseInt) > biddingInfo.getAdPrice()) {
                        ADPSplashAdLoader.this.c(this.f707a);
                        biddingInfo.setBidResult(false);
                        this.b.biddingResult(list, new a(this));
                        return;
                    }
                    biddingInfo.setBidResult(true);
                    biddingInfo.setWinPrice((double) parseInt);
                    this.b.biddingResult(list, new b(this));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            ITanxSplashExpressAd unused3 = ADPSplashAdLoader.this.H = list.get(0);
            boolean unused4 = ADPSplashAdLoader.this.x = true;
            if ((!ADPSplashAdLoader.this.R && ADPSplashAdLoader.this.k != null) || (ADPSplashAdLoader.this.V && ADPSplashAdLoader.this.k != null)) {
                ADPSplashAdLoader.this.k.onADReceive(-1);
            }
            boolean unused5 = ADPSplashAdLoader.this.z = false;
            if ((!this.f707a || ADPSplashAdLoader.this.V) && ADPSplashAdLoader.this.j()) {
                ADPSplashAdLoader aDPSplashAdLoader2 = ADPSplashAdLoader.this;
                ViewGroup unused6 = aDPSplashAdLoader2.s = aDPSplashAdLoader2.a(aDPSplashAdLoader2.h, false);
                boolean unused7 = ADPSplashAdLoader.this.z = true;
                ADPSplashAdLoader aDPSplashAdLoader3 = ADPSplashAdLoader.this;
                aDPSplashAdLoader3.a(aDPSplashAdLoader3.H, this.f707a);
                View adView = ADPSplashAdLoader.this.H.getAdView(ADPSplashAdLoader.this.h);
                ADPSplashAdLoader.this.s.removeAllViews();
                ADPSplashAdLoader.this.s.addView(adView);
            }
        }

        public void onTimeOut() {
            ADPSplashAdLoader.this.f();
            ADPSplashAdLoader.this.a("time out t", ExposeManager.UtArgsNames.nameSpace, this.f707a);
        }
    }

    public class v implements f.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f708a;
        final /* synthetic */ boolean b;

        public v(String str, boolean z) {
            this.f708a = str;
            this.b = z;
        }

        public void a(int i, String str) {
            ADPSplashAdLoader.this.f();
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.a(i + " >>" + str, "gromore", this.b);
        }

        public void success() {
            ADPSplashAdLoader.this.c(this.f708a, this.b);
        }
    }

    private ADPSplashAdLoader() {
    }

    public void destroy() {
    }

    public boolean isAdValid() {
        return this.x;
    }

    @Deprecated
    public void load() {
        a();
        this.J = false;
        this.R = false;
        this.E = 0;
        this.X = OOXIXo.f29376XO;
        this.I.removeCallbacks(this.d0);
        this.I.postDelayed(this.d0, 200);
        this.S.clear();
        this.O = null;
        g();
        try {
            if (!this.J && c() && !this.y) {
                this.x = false;
                this.z = false;
                this.y = false;
                k();
                a("adsplus", "-1", "Display ad too frequently");
            } else if (!this.y) {
                this.A = false;
                a(false);
                this.y = true;
            }
        } catch (Exception e2) {
            a("adsplus", "-1", "ad exception" + e2.getMessage());
        }
    }

    public void loadAD() {
        a();
        this.R = false;
        this.E = 0;
        this.J = false;
        this.X = OOXIXo.f29376XO;
        this.I.removeCallbacks(this.d0);
        this.I.postDelayed(this.d0, 200);
        this.S.clear();
        this.O = null;
        g();
        try {
            if (!this.J && c() && !this.y) {
                this.x = false;
                this.z = false;
                this.y = false;
                k();
                a("adsplus", "-1", "频率太快，请稍后重试。");
            } else if (!this.y) {
                this.A = true;
                a(true);
                this.y = true;
            }
        } catch (Exception e2) {
            a("adsplus", "-1", "ad exception" + e2.getMessage());
        }
    }

    public void loadAndShow() {
        a();
        this.R = false;
        this.E = 0;
        this.X = OOXIXo.f29376XO;
        this.I.removeCallbacks(this.d0);
        this.I.postDelayed(this.d0, 200);
        this.S.clear();
        this.O = null;
        g();
        try {
            if (!this.J && c() && !this.y) {
                this.x = false;
                this.z = false;
                this.y = false;
                k();
                a("adsplus", "-1", "Display ad too frequently");
            } else if (!this.y) {
                this.A = false;
                a(false);
                this.y = true;
            }
        } catch (Exception e2) {
            a("adsplus", "-1", "ad exception" + e2.getMessage());
        }
    }

    public void setDownloadConfirmListener(ADPDownloadConfirmListener aDPDownloadConfirmListener) {
        this.l = aDPDownloadConfirmListener;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0108, code lost:
        if ("bytedance".equals(r8.Q.getSource()) != false) goto L_0x010a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void showAD() {
        /*
            r8 = this;
            java.lang.String r0 = "jingdong"
            java.lang.String r1 = "-1"
            java.lang.String r2 = "adsplus"
            boolean r3 = com.adp.sdk.ADP.DEBUGLOG     // Catch:{ Exception -> 0x004a }
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x004d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004a }
            r3.<init>()     // Catch:{ Exception -> 0x004a }
            java.lang.String r6 = "view:"
            r3.append(r6)     // Catch:{ Exception -> 0x004a }
            android.view.ViewGroup r6 = r8.s     // Catch:{ Exception -> 0x004a }
            if (r6 == 0) goto L_0x001d
            r6 = 1
            goto L_0x001e
        L_0x001d:
            r6 = 0
        L_0x001e:
            r3.append(r6)     // Catch:{ Exception -> 0x004a }
            java.lang.String r6 = "  loadBoolean:"
            r3.append(r6)     // Catch:{ Exception -> 0x004a }
            boolean r6 = r8.x     // Catch:{ Exception -> 0x004a }
            r3.append(r6)     // Catch:{ Exception -> 0x004a }
            java.lang.String r6 = "  showStatus:"
            r3.append(r6)     // Catch:{ Exception -> 0x004a }
            boolean r6 = r8.z     // Catch:{ Exception -> 0x004a }
            r6 = r6 ^ r5
            r3.append(r6)     // Catch:{ Exception -> 0x004a }
            java.lang.String r6 = "  "
            r3.append(r6)     // Catch:{ Exception -> 0x004a }
            boolean r6 = r8.h()     // Catch:{ Exception -> 0x004a }
            r3.append(r6)     // Catch:{ Exception -> 0x004a }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x004a }
            android.util.Log.i(r2, r3)     // Catch:{ Exception -> 0x004a }
            goto L_0x004d
        L_0x004a:
            r0 = move-exception
            goto L_0x0197
        L_0x004d:
            android.view.ViewGroup r3 = r8.s     // Catch:{ Exception -> 0x004a }
            java.lang.String r6 = "Ad not prepared"
            if (r3 == 0) goto L_0x0187
            boolean r3 = r8.x     // Catch:{ Exception -> 0x004a }
            if (r3 == 0) goto L_0x0187
            boolean r3 = r8.z     // Catch:{ Exception -> 0x004a }
            if (r3 != 0) goto L_0x0187
            boolean r3 = r8.h()     // Catch:{ Exception -> 0x004a }
            if (r3 == 0) goto L_0x0187
            java.lang.String r3 = "baidu"
            com.adp.sdk.dto.SourceVO r7 = r8.Q     // Catch:{ Exception -> 0x004a }
            java.lang.String r7 = r7.getSource()     // Catch:{ Exception -> 0x004a }
            boolean r3 = r3.equals(r7)     // Catch:{ Exception -> 0x004a }
            if (r3 == 0) goto L_0x007c
            com.baidu.mobads.sdk.api.SplashAd r3 = r8.q     // Catch:{ Exception -> 0x004a }
            if (r3 == 0) goto L_0x007c
            android.view.ViewGroup r0 = r8.s     // Catch:{ Exception -> 0x004a }
            r3.show(r0)     // Catch:{ Exception -> 0x004a }
            r8.z = r5     // Catch:{ Exception -> 0x004a }
            goto L_0x01b2
        L_0x007c:
            java.lang.String r3 = "tanx"
            com.adp.sdk.dto.SourceVO r7 = r8.Q     // Catch:{ Exception -> 0x004a }
            java.lang.String r7 = r7.getSource()     // Catch:{ Exception -> 0x004a }
            boolean r3 = r3.equals(r7)     // Catch:{ Exception -> 0x004a }
            if (r3 == 0) goto L_0x00a8
            com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd r3 = r8.H     // Catch:{ Exception -> 0x004a }
            if (r3 == 0) goto L_0x00a8
            r8.a((com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd) r3, (boolean) r4)     // Catch:{ Exception -> 0x004a }
            com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd r0 = r8.H     // Catch:{ Exception -> 0x004a }
            android.view.View r0 = r0.getAdView()     // Catch:{ Exception -> 0x004a }
            com.adp.sdk.utils.j.a(r0)     // Catch:{ Exception -> 0x004a }
            android.view.ViewGroup r3 = r8.s     // Catch:{ Exception -> 0x004a }
            r3.removeAllViews()     // Catch:{ Exception -> 0x004a }
            android.view.ViewGroup r3 = r8.s     // Catch:{ Exception -> 0x004a }
            r3.addView(r0)     // Catch:{ Exception -> 0x004a }
            r8.z = r5     // Catch:{ Exception -> 0x004a }
            goto L_0x01b2
        L_0x00a8:
            java.lang.String r3 = "tencent"
            com.adp.sdk.dto.SourceVO r4 = r8.Q     // Catch:{ Exception -> 0x004a }
            java.lang.String r4 = r4.getSource()     // Catch:{ Exception -> 0x004a }
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x004a }
            if (r3 == 0) goto L_0x00cd
            com.qq.e.ads.splash.SplashAD r3 = r8.p     // Catch:{ Exception -> 0x004a }
            if (r3 == 0) goto L_0x00cd
            boolean r0 = r8.m     // Catch:{ Exception -> 0x004a }
            if (r0 == 0) goto L_0x00c4
            android.view.ViewGroup r0 = r8.s     // Catch:{ Exception -> 0x004a }
            r3.showFullScreenAd(r0)     // Catch:{ Exception -> 0x004a }
            goto L_0x00c9
        L_0x00c4:
            android.view.ViewGroup r0 = r8.s     // Catch:{ Exception -> 0x004a }
            r3.showAd(r0)     // Catch:{ Exception -> 0x004a }
        L_0x00c9:
            r8.z = r5     // Catch:{ Exception -> 0x004a }
            goto L_0x01b2
        L_0x00cd:
            java.lang.String r3 = "octopus"
            com.adp.sdk.dto.SourceVO r4 = r8.Q     // Catch:{ Exception -> 0x004a }
            java.lang.String r4 = r4.getSource()     // Catch:{ Exception -> 0x004a }
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x004a }
            if (r3 == 0) goto L_0x00ee
            oOoIIO0.oI0IIXIo r3 = r8.T     // Catch:{ Exception -> 0x004a }
            if (r3 == 0) goto L_0x00ee
            boolean r3 = r3.x0XOIxOo()     // Catch:{ Exception -> 0x004a }
            if (r3 == 0) goto L_0x00ee
            oOoIIO0.oI0IIXIo r0 = r8.T     // Catch:{ Exception -> 0x004a }
            r0.OxxIIOOXO()     // Catch:{ Exception -> 0x004a }
            r8.z = r5     // Catch:{ Exception -> 0x004a }
            goto L_0x01b2
        L_0x00ee:
            java.lang.String r3 = "gromore"
            com.adp.sdk.dto.SourceVO r4 = r8.Q     // Catch:{ Exception -> 0x004a }
            java.lang.String r4 = r4.getSource()     // Catch:{ Exception -> 0x004a }
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x004a }
            if (r3 != 0) goto L_0x010a
            java.lang.String r3 = "bytedance"
            com.adp.sdk.dto.SourceVO r4 = r8.Q     // Catch:{ Exception -> 0x004a }
            java.lang.String r4 = r4.getSource()     // Catch:{ Exception -> 0x004a }
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x004a }
            if (r3 == 0) goto L_0x0123
        L_0x010a:
            com.bytedance.sdk.openadsdk.CSJSplashAd r3 = r8.b0     // Catch:{ Exception -> 0x004a }
            if (r3 == 0) goto L_0x0123
            android.view.View r0 = r3.getSplashView()     // Catch:{ Exception -> 0x004a }
            com.adp.sdk.utils.j.a(r0)     // Catch:{ Exception -> 0x004a }
            android.view.ViewGroup r3 = r8.s     // Catch:{ Exception -> 0x004a }
            r3.removeAllViews()     // Catch:{ Exception -> 0x004a }
            android.view.ViewGroup r3 = r8.s     // Catch:{ Exception -> 0x004a }
            r3.addView(r0)     // Catch:{ Exception -> 0x004a }
            r8.z = r5     // Catch:{ Exception -> 0x004a }
            goto L_0x01b2
        L_0x0123:
            java.lang.String r3 = "kuaishou"
            com.adp.sdk.dto.SourceVO r4 = r8.Q     // Catch:{ Exception -> 0x004a }
            java.lang.String r4 = r4.getSource()     // Catch:{ Exception -> 0x004a }
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x004a }
            if (r3 == 0) goto L_0x0133
            goto L_0x01b2
        L_0x0133:
            java.lang.String r3 = "huawei"
            com.adp.sdk.dto.SourceVO r4 = r8.Q     // Catch:{ Exception -> 0x004a }
            java.lang.String r4 = r4.getSource()     // Catch:{ Exception -> 0x004a }
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x004a }
            if (r3 == 0) goto L_0x0156
            boolean r3 = r8.G     // Catch:{ Exception -> 0x004a }
            if (r3 == 0) goto L_0x0156
            android.view.View r3 = r8.F     // Catch:{ Exception -> 0x004a }
            if (r3 == 0) goto L_0x0156
            android.view.ViewGroup r0 = r8.s     // Catch:{ Exception -> 0x004a }
            r0.removeAllViews()     // Catch:{ Exception -> 0x004a }
            android.view.ViewGroup r0 = r8.s     // Catch:{ Exception -> 0x004a }
            android.view.View r3 = r8.F     // Catch:{ Exception -> 0x004a }
            r0.addView(r3)     // Catch:{ Exception -> 0x004a }
            goto L_0x01b2
        L_0x0156:
            com.adp.sdk.dto.SourceVO r3 = r8.Q     // Catch:{ Exception -> 0x004a }
            java.lang.String r3 = r3.getSource()     // Catch:{ Exception -> 0x004a }
            boolean r3 = r0.equals(r3)     // Catch:{ Exception -> 0x004a }
            if (r3 == 0) goto L_0x0175
            android.view.View r3 = r8.D     // Catch:{ Exception -> 0x004a }
            if (r3 == 0) goto L_0x0175
            android.view.ViewGroup r0 = r8.s     // Catch:{ Exception -> 0x004a }
            r0.removeAllViews()     // Catch:{ Exception -> 0x004a }
            android.view.ViewGroup r0 = r8.s     // Catch:{ Exception -> 0x004a }
            android.view.View r3 = r8.D     // Catch:{ Exception -> 0x004a }
            r0.addView(r3)     // Catch:{ Exception -> 0x004a }
            r8.z = r5     // Catch:{ Exception -> 0x004a }
            goto L_0x01b2
        L_0x0175:
            boolean r3 = com.adp.sdk.ADP.DEBUGLOG     // Catch:{ Exception -> 0x004a }
            if (r3 == 0) goto L_0x017e
            java.lang.String r3 = "ad else"
            android.util.Log.i(r2, r3)     // Catch:{ Exception -> 0x004a }
        L_0x017e:
            com.adp.sdk.dto.AdpError r3 = new com.adp.sdk.dto.AdpError     // Catch:{ Exception -> 0x004a }
            r3.<init>(r1, r6)     // Catch:{ Exception -> 0x004a }
            r8.a((java.lang.String) r0, (com.adp.sdk.dto.AdpError) r3)     // Catch:{ Exception -> 0x004a }
            goto L_0x01b2
        L_0x0187:
            boolean r0 = com.adp.sdk.ADP.DEBUGLOG     // Catch:{ Exception -> 0x004a }
            if (r0 == 0) goto L_0x018e
            android.util.Log.i(r2, r6)     // Catch:{ Exception -> 0x004a }
        L_0x018e:
            com.adp.sdk.dto.AdpError r0 = new com.adp.sdk.dto.AdpError     // Catch:{ Exception -> 0x004a }
            r0.<init>(r1, r6)     // Catch:{ Exception -> 0x004a }
            r8.a((java.lang.String) r2, (com.adp.sdk.dto.AdpError) r0)     // Catch:{ Exception -> 0x004a }
            goto L_0x01b2
        L_0x0197:
            r0.printStackTrace()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "ad "
            r3.append(r4)
            java.lang.String r0 = r0.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r8.a((java.lang.String) r2, (java.lang.String) r1, (java.lang.String) r0)
        L_0x01b2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adp.sdk.ADPSplashAdLoader.showAD():void");
    }

    private void j(String str, boolean z2) {
        if (g.a()) {
            i(str, z2);
        } else if (!g.a(this.h, new i(str, z2))) {
            a("adsplus", "-1", "ads gdt is error", z2);
        }
    }

    private void k() {
        com.adp.sdk.utils.d dVar = new com.adp.sdk.utils.d(this.h);
        dVar.a("SPALSHTIME", System.currentTimeMillis() + "");
    }

    /* access modifiers changed from: private */
    public void l() {
        try {
            if (j()) {
                this.Y.show();
            }
            new l(200, 200).start();
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|(1:6)|7|9|10|(2:12|63)(4:14|15|16|(3:18|19|64)(4:24|25|26|(2:28|66)(4:29|30|31|(2:33|67)(4:34|35|36|(2:38|68)(4:39|40|41|(2:43|69)(4:44|45|46|(2:48|70)(4:49|50|51|(2:53|71)(4:54|55|56|(2:58|62)(2:59|72)))))))))) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000c */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0030 A[Catch:{ Exception -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0018 A[Catch:{ Exception -> 0x0022 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d(boolean r8) {
        /*
            r7 = this;
            java.lang.String r0 = "-1"
            java.lang.String r1 = "adsplus"
            com.adp.sdk.dto.SourceVO r2 = r7.Q     // Catch:{ Exception -> 0x000c }
            boolean r2 = r2.isShowAfterTimeOut()     // Catch:{ Exception -> 0x000c }
            r7.V = r2     // Catch:{ Exception -> 0x000c }
        L_0x000c:
            java.lang.String r2 = r7.W     // Catch:{ Exception -> 0x0022 }
            double r2 = java.lang.Double.parseDouble(r2)     // Catch:{ Exception -> 0x0022 }
            r4 = 4611686018427387904(0x4000000000000000, double:2.0)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x0022
            r4 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r2 = r2 * r4
            int r2 = (int) r2     // Catch:{ Exception -> 0x0022 }
            r7.g = r2     // Catch:{ Exception -> 0x0022 }
        L_0x0022:
            java.lang.String r2 = "tencent"
            com.adp.sdk.dto.SourceVO r3 = r7.Q     // Catch:{ Exception -> 0x003b }
            java.lang.String r3 = r3.getSource()     // Catch:{ Exception -> 0x003b }
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x003b }
            if (r2 == 0) goto L_0x003e
            com.adp.sdk.dto.SourceVO r2 = r7.Q     // Catch:{ Exception -> 0x003b }
            java.lang.String r2 = r2.getId()     // Catch:{ Exception -> 0x003b }
            r7.j(r2, r8)     // Catch:{ Exception -> 0x003b }
            goto L_0x0145
        L_0x003b:
            r2 = move-exception
            goto L_0x0114
        L_0x003e:
            java.lang.String r2 = "kuaishou"
            com.adp.sdk.dto.SourceVO r3 = r7.Q     // Catch:{ Exception -> 0x003b }
            java.lang.String r3 = r3.getSource()     // Catch:{ Exception -> 0x003b }
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x003b }
            if (r2 == 0) goto L_0x0062
            com.adp.sdk.dto.SourceVO r2 = r7.Q     // Catch:{ NumberFormatException -> 0x005b }
            java.lang.String r2 = r2.getId()     // Catch:{ NumberFormatException -> 0x005b }
            long r2 = java.lang.Long.parseLong(r2)     // Catch:{ NumberFormatException -> 0x005b }
            r7.a((long) r2, (boolean) r8)     // Catch:{ NumberFormatException -> 0x005b }
            goto L_0x0145
        L_0x005b:
            r2 = 0
            r7.a((long) r2, (boolean) r8)     // Catch:{ Exception -> 0x003b }
            goto L_0x0145
        L_0x0062:
            java.lang.String r2 = "tanx"
            com.adp.sdk.dto.SourceVO r3 = r7.Q     // Catch:{ Exception -> 0x003b }
            java.lang.String r3 = r3.getSource()     // Catch:{ Exception -> 0x003b }
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x003b }
            if (r2 == 0) goto L_0x007b
            com.adp.sdk.dto.SourceVO r2 = r7.Q     // Catch:{ Exception -> 0x003b }
            java.lang.String r2 = r2.getId()     // Catch:{ Exception -> 0x003b }
            r7.f((java.lang.String) r2, (boolean) r8)     // Catch:{ Exception -> 0x003b }
            goto L_0x0145
        L_0x007b:
            java.lang.String r2 = "gromore"
            com.adp.sdk.dto.SourceVO r3 = r7.Q     // Catch:{ Exception -> 0x003b }
            java.lang.String r3 = r3.getSource()     // Catch:{ Exception -> 0x003b }
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x003b }
            if (r2 == 0) goto L_0x0094
            com.adp.sdk.dto.SourceVO r2 = r7.Q     // Catch:{ Exception -> 0x003b }
            java.lang.String r2 = r2.getId()     // Catch:{ Exception -> 0x003b }
            r7.b((java.lang.String) r2, (boolean) r8)     // Catch:{ Exception -> 0x003b }
            goto L_0x0145
        L_0x0094:
            java.lang.String r2 = "bytedance"
            com.adp.sdk.dto.SourceVO r3 = r7.Q     // Catch:{ Exception -> 0x003b }
            java.lang.String r3 = r3.getSource()     // Catch:{ Exception -> 0x003b }
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x003b }
            if (r2 == 0) goto L_0x00ad
            com.adp.sdk.dto.SourceVO r2 = r7.Q     // Catch:{ Exception -> 0x003b }
            java.lang.String r2 = r2.getId()     // Catch:{ Exception -> 0x003b }
            r7.b((java.lang.String) r2, (boolean) r8)     // Catch:{ Exception -> 0x003b }
            goto L_0x0145
        L_0x00ad:
            java.lang.String r2 = "octopus"
            com.adp.sdk.dto.SourceVO r3 = r7.Q     // Catch:{ Exception -> 0x003b }
            java.lang.String r3 = r3.getSource()     // Catch:{ Exception -> 0x003b }
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x003b }
            if (r2 == 0) goto L_0x00c6
            com.adp.sdk.dto.SourceVO r2 = r7.Q     // Catch:{ Exception -> 0x003b }
            java.lang.String r2 = r2.getId()     // Catch:{ Exception -> 0x003b }
            r7.e((java.lang.String) r2, (boolean) r8)     // Catch:{ Exception -> 0x003b }
            goto L_0x0145
        L_0x00c6:
            java.lang.String r2 = "baidu"
            com.adp.sdk.dto.SourceVO r3 = r7.Q     // Catch:{ Exception -> 0x003b }
            java.lang.String r3 = r3.getSource()     // Catch:{ Exception -> 0x003b }
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x003b }
            if (r2 == 0) goto L_0x00de
            com.adp.sdk.dto.SourceVO r2 = r7.Q     // Catch:{ Exception -> 0x003b }
            java.lang.String r2 = r2.getId()     // Catch:{ Exception -> 0x003b }
            r7.a((java.lang.String) r2, (boolean) r8)     // Catch:{ Exception -> 0x003b }
            goto L_0x0145
        L_0x00de:
            java.lang.String r2 = "jingdong"
            com.adp.sdk.dto.SourceVO r3 = r7.Q     // Catch:{ Exception -> 0x003b }
            java.lang.String r3 = r3.getSource()     // Catch:{ Exception -> 0x003b }
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x003b }
            if (r2 == 0) goto L_0x00f6
            com.adp.sdk.dto.SourceVO r2 = r7.Q     // Catch:{ Exception -> 0x003b }
            java.lang.String r2 = r2.getId()     // Catch:{ Exception -> 0x003b }
            r7.d((java.lang.String) r2, (boolean) r8)     // Catch:{ Exception -> 0x003b }
            goto L_0x0145
        L_0x00f6:
            java.lang.String r2 = "huawei"
            com.adp.sdk.dto.SourceVO r3 = r7.Q     // Catch:{ Exception -> 0x003b }
            java.lang.String r3 = r3.getSource()     // Catch:{ Exception -> 0x003b }
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x003b }
            if (r2 == 0) goto L_0x010e
            com.adp.sdk.dto.SourceVO r2 = r7.Q     // Catch:{ Exception -> 0x003b }
            java.lang.String r2 = r2.getId()     // Catch:{ Exception -> 0x003b }
            r7.g((java.lang.String) r2, (boolean) r8)     // Catch:{ Exception -> 0x003b }
            goto L_0x0145
        L_0x010e:
            java.lang.String r2 = "no ad ads"
            r7.a((java.lang.String) r1, (java.lang.String) r0, (java.lang.String) r2, (boolean) r8)     // Catch:{ Exception -> 0x003b }
            goto L_0x0145
        L_0x0114:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "错误exception:"
            r3.append(r4)
            java.lang.String r4 = r2.getMessage()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            android.util.Log.e(r1, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "exception:"
            r3.append(r4)
            java.lang.String r2 = r2.getMessage()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r7.a((java.lang.String) r1, (java.lang.String) r0, (java.lang.String) r2, (boolean) r8)
        L_0x0145:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adp.sdk.ADPSplashAdLoader.d(boolean):void");
    }

    private void e(String str, boolean z2) {
        if (!com.adp.sdk.utils.b.a("com.octopus.ad.SplashAd")) {
            a("-1 找不到合适的广告", "octopus", z2);
            return;
        }
        try {
            if (!k.a()) {
                k.a((Context) this.h);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            c(this.h, this.j, "octopus", "1", this.Q);
            ViewGroup viewGroup = this.s;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
            k();
            this.K = false;
            o oVar = new o(z2);
            x0XOIxOo.IXxxXO(this.g);
            oI0IIXIo oi0iixio = new oI0IIXIo(this.h, str, this.s, oVar);
            this.T = oi0iixio;
            oi0iixio.Oo(true);
        } catch (Exception e3) {
            e3.printStackTrace();
            a("-1 >> 章鱼 init error", "octopus", z2);
        }
    }

    private void f(String str, boolean z2) {
        ImageView imageView = this.t;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        if (!l.b()) {
            a("-1 >> tanx init error", ExposeManager.UtArgsNames.nameSpace, z2);
            return;
        }
        this.K = false;
        if (!l.a()) {
            l.a(this.h.getApplication(), new s(str, z2));
        } else {
            h(str, z2);
        }
    }

    private void g() {
        AdInfo adInfo;
        this.M = true;
        try {
            String str = ADP.serviceId;
            if (!a(str) && (adInfo = a.b) != null && !a(adInfo.getChose())) {
                String[] split = a.b.getChose().split(",");
                String substring = str.substring(str.length() - 1, str.length());
                for (String equals : split) {
                    if (substring.equals(equals)) {
                        this.M = false;
                        return;
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void h(String str, boolean z2) {
        k();
        TanxAdSlot build = new TanxAdSlot.Builder().adCount(1).pid(str).build();
        c(this.h, this.j, ExposeManager.UtArgsNames.nameSpace, "1", this.Q);
        ITanxAdLoader createAdLoader = TanxSdk.getSDKManager().createAdLoader(this.h);
        createAdLoader.loadSplashAd(build, new u(z2, createAdLoader), (long) this.g);
    }

    /* access modifiers changed from: private */
    public boolean i() {
        int i2;
        ArrayList<SourceVO> arrayList = this.S;
        if (arrayList == null || arrayList.size() == 0 || (i2 = this.E) < 2) {
            return false;
        }
        if (i2 >= 2) {
            for (int size = this.S.size() - 1; size >= 0; size--) {
                if (!this.S.get(size).isShowAfterTimeOut()) {
                    this.S.remove(size);
                }
            }
        }
        if (this.S.size() > 0) {
            return this.S.get(0).isShowAfterTimeOut();
        }
        return false;
    }

    public class b implements TTAdNative.CSJSplashAdListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f684a = true;
        final /* synthetic */ boolean b;

        public class a implements CSJSplashAd.SplashAdListener {
            public a() {
            }

            public void onSplashAdClick(CSJSplashAd cSJSplashAd) {
                boolean unused = ADPSplashAdLoader.this.z = true;
                boolean unused2 = ADPSplashAdLoader.this.L = true;
                if (!ADPSplashAdLoader.this.K) {
                    boolean unused3 = ADPSplashAdLoader.this.K = true;
                    if (ADPSplashAdLoader.this.k != null && ADPSplashAdLoader.this.M) {
                        ADPSplashAdLoader.this.k.onADClicked();
                    }
                }
                ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
                aDPSplashAdLoader.a(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "gromore", "1", ADPSplashAdLoader.this.Q);
            }

            public void onSplashAdClose(CSJSplashAd cSJSplashAd, int i) {
                boolean unused = ADPSplashAdLoader.this.x = false;
                boolean unused2 = ADPSplashAdLoader.this.z = false;
                boolean unused3 = ADPSplashAdLoader.this.y = false;
                ADPSplashAdLoader.this.f();
                if (ADPSplashAdLoader.this.k != null) {
                    ADPSplashAdLoader.this.k.onADDismissed();
                    ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
                    if (aDPSplashAdLoader.f && aDPSplashAdLoader.N != null && ADPSplashAdLoader.this.N.length() > 0) {
                        c.a().a((Context) ADPSplashAdLoader.this.h, ADPSplashAdLoader.this.j, ADPSplashAdLoader.this.N, "1", ADPSplashAdLoader.this.Q);
                    }
                }
            }

            public void onSplashAdShow(CSJSplashAd cSJSplashAd) {
                boolean unused = ADPSplashAdLoader.this.z = true;
                if (ADPSplashAdLoader.this.k != null) {
                    ADPSplashAdLoader.this.k.onADPresent();
                }
                ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
                aDPSplashAdLoader.e(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "gromore", "1", ADPSplashAdLoader.this.Q);
                a.a(ADPSplashAdLoader.this.r, (Context) ADPSplashAdLoader.this.h);
            }
        }

        public b(boolean z) {
            this.b = z;
        }

        private synchronized void a(CSJAdError cSJAdError, int i) {
            if (this.f684a) {
                this.f684a = false;
                ADPSplashAdLoader.this.a(cSJAdError.getMsg(), "gromore", this.b);
                ADPSplashAdLoader.this.f();
            }
        }

        public void onSplashLoadFail(CSJAdError cSJAdError) {
            a(cSJAdError, 1);
        }

        public void onSplashLoadSuccess(CSJSplashAd cSJSplashAd) {
        }

        public void onSplashRenderFail(CSJSplashAd cSJSplashAd, CSJAdError cSJAdError) {
            a(cSJAdError, 2);
        }

        public void onSplashRenderSuccess(CSJSplashAd cSJSplashAd) {
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.b(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "gromore", "1", ADPSplashAdLoader.this.Q);
            if (ADPSplashAdLoader.this.V || ADPSplashAdLoader.this.E < 2) {
                ADPSplashAdLoader.this.d();
                boolean unused = ADPSplashAdLoader.this.x = false;
                boolean unused2 = ADPSplashAdLoader.this.U = true;
                if (cSJSplashAd == null) {
                    ADPSplashAdLoader.this.a("  ad is null", "gromore", this.b);
                    return;
                }
                boolean unused3 = ADPSplashAdLoader.this.x = true;
                CSJSplashAd unused4 = ADPSplashAdLoader.this.b0 = cSJSplashAd;
                if (!((ADPSplashAdLoader.this.b0 == null || ADPSplashAdLoader.this.R || ADPSplashAdLoader.this.k == null) && (ADPSplashAdLoader.this.b0 == null || !ADPSplashAdLoader.this.V || ADPSplashAdLoader.this.k == null))) {
                    ADPSplashAdLoader.this.k.onADReceive(-1);
                }
                a(cSJSplashAd);
                boolean unused5 = ADPSplashAdLoader.this.z = false;
                if ((!this.b || ADPSplashAdLoader.this.V) && ADPSplashAdLoader.this.j()) {
                    ADPSplashAdLoader aDPSplashAdLoader2 = ADPSplashAdLoader.this;
                    ViewGroup unused6 = aDPSplashAdLoader2.s = aDPSplashAdLoader2.a(aDPSplashAdLoader2.h, false);
                    boolean unused7 = ADPSplashAdLoader.this.z = true;
                    View splashView = ADPSplashAdLoader.this.b0.getSplashView();
                    com.adp.sdk.utils.j.a(splashView);
                    ADPSplashAdLoader.this.s.removeAllViews();
                    ADPSplashAdLoader.this.s.addView(splashView);
                    return;
                }
                return;
            }
            ADPSplashAdLoader.this.c(this.b);
        }

        private void a(CSJSplashAd cSJSplashAd) {
            cSJSplashAd.setSplashAdListener(new a());
        }
    }

    /* access modifiers changed from: private */
    public void c(boolean z2) {
        this.J = true;
        int size = this.S.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            if ((this.Q.getId() + "").equals(this.S.get(size).getId() + "")) {
                this.S.remove(size);
                break;
            }
            size--;
        }
        if (this.E >= 2) {
            for (int size2 = this.S.size() - 1; size2 >= 0; size2--) {
                if (!this.S.get(size2).isShowAfterTimeOut()) {
                    this.S.remove(size2);
                }
            }
        }
        if (this.S.size() > 0) {
            this.Q = this.S.get(0);
            this.S.remove(0);
            d(z2);
        }
    }

    /* access modifiers changed from: private */
    public boolean j() {
        Activity a2 = com.adp.sdk.utils.k.a.b().a();
        if (a2 == null || a2.isFinishing() || this.h == null || h() || !this.V) {
            return false;
        }
        if (!ADP.DEBUGLOG) {
            return true;
        }
        Log.i("adsplus", "time end open ad");
        return true;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00bd */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c7 A[Catch:{ Exception -> 0x00d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0115  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(boolean r8) {
        /*
            r7 = this;
            com.adp.sdk.dto.AdInfo r0 = com.adp.sdk.a.b
            java.util.List r1 = r0.getAdUnits()
            java.lang.String r2 = "adsplus"
            if (r1 == 0) goto L_0x0152
            java.util.List r1 = r0.getAdUnits()
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x0152
            java.lang.String r1 = r0.getStatus()
            java.lang.String r3 = "0"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0022
            goto L_0x0152
        L_0x0022:
            java.util.List r1 = r0.getAdUnits()
            java.util.Iterator r1 = r1.iterator()
        L_0x002a:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0051
            java.lang.Object r4 = r1.next()
            com.adp.sdk.dto.AdItem r4 = (com.adp.sdk.dto.AdItem) r4
            java.lang.String r5 = r4.getType()
            java.lang.String r6 = "Splash"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x002a
            java.lang.String r5 = r7.j
            java.lang.String r6 = r4.getAdUnitId()
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x002a
            r7.r = r4
            goto L_0x002a
        L_0x0051:
            com.adp.sdk.dto.AdItem r1 = r7.r
            java.lang.String r4 = "B003"
            if (r1 != 0) goto L_0x0068
            com.adp.sdk.dto.AdpError r8 = new com.adp.sdk.dto.AdpError
            android.app.Activity r0 = r7.h
            int r1 = com.adp.sdk.R.string.B003
            java.lang.String r0 = r0.getString(r1)
            r8.<init>(r4, r0)
            r7.a((java.lang.String) r2, (com.adp.sdk.dto.AdpError) r8)
            return
        L_0x0068:
            boolean r1 = r1.isEnable()
            if (r1 != 0) goto L_0x0081
            com.adp.sdk.dto.AdpError r8 = new com.adp.sdk.dto.AdpError
            android.app.Activity r0 = r7.h
            int r1 = com.adp.sdk.R.string.B004
            java.lang.String r0 = r0.getString(r1)
            java.lang.String r1 = "B004"
            r8.<init>(r1, r0)
            r7.a((java.lang.String) r2, (com.adp.sdk.dto.AdpError) r8)
            return
        L_0x0081:
            com.adp.sdk.dto.AdItem r1 = r7.r
            android.app.Activity r5 = r7.h
            java.lang.String r1 = com.adp.sdk.a.b((com.adp.sdk.dto.AdItem) r1, (android.content.Context) r5)
            if (r1 == 0) goto L_0x0096
            com.adp.sdk.dto.AdpError r8 = new com.adp.sdk.dto.AdpError
            java.lang.String r0 = "C001"
            r8.<init>(r0, r1)
            r7.a((java.lang.String) r2, (com.adp.sdk.dto.AdpError) r8)
            return
        L_0x0096:
            java.lang.String r1 = r0.getShowLogo()
            if (r1 == 0) goto L_0x009f
            r0.getShowLogo()
        L_0x009f:
            com.adp.sdk.dto.AdItem r0 = r7.r
            java.util.List r0 = r0.getAdSource()
            if (r0 == 0) goto L_0x0141
            com.adp.sdk.dto.AdItem r0 = r7.r
            java.util.List r0 = r0.getAdSource()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x00b5
            goto L_0x0141
        L_0x00b5:
            com.adp.sdk.dto.AdItem r0 = r7.r     // Catch:{ Exception -> 0x00bd }
            boolean r0 = r0.isOpenLogs()     // Catch:{ Exception -> 0x00bd }
            r7.f = r0     // Catch:{ Exception -> 0x00bd }
        L_0x00bd:
            com.adp.sdk.dto.AdItem r0 = r7.r     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r0 = r0.getTimeout()     // Catch:{ Exception -> 0x00d4 }
            r7.W = r0     // Catch:{ Exception -> 0x00d4 }
            if (r0 == 0) goto L_0x00d6
            int r0 = r0.length()     // Catch:{ Exception -> 0x00d4 }
            if (r0 != 0) goto L_0x00ce
            goto L_0x00d6
        L_0x00ce:
            java.lang.String r0 = r7.W     // Catch:{ Exception -> 0x00d4 }
            java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x00d4 }
            goto L_0x00da
        L_0x00d4:
            goto L_0x00da
        L_0x00d6:
            java.lang.String r0 = "-1"
            r7.W = r0     // Catch:{ Exception -> 0x00d4 }
        L_0x00da:
            com.adp.sdk.utils.d r0 = new com.adp.sdk.utils.d
            android.app.Activity r1 = r7.h
            android.content.Context r1 = r1.getApplicationContext()
            r0.<init>(r1)
            java.lang.String r1 = "splash_index"
            java.lang.String r0 = r0.b(r1, r3)
            int r0 = java.lang.Integer.parseInt(r0)
            com.adp.sdk.dto.AdItem r1 = r7.r
            boolean r1 = com.adp.sdk.b.a((com.adp.sdk.dto.AdItem) r1, (int) r0)
            if (r1 == 0) goto L_0x00f8
            r0 = 0
        L_0x00f8:
            com.adp.sdk.dto.AdItem r1 = r7.r
            android.app.Activity r3 = r7.h
            com.adp.sdk.dto.SourceVO r1 = com.adp.sdk.b.a(r1, r0, r3)
            r7.Q = r1
            if (r1 != 0) goto L_0x0115
            com.adp.sdk.dto.AdpError r8 = new com.adp.sdk.dto.AdpError
            android.app.Activity r0 = r7.h
            int r1 = com.adp.sdk.R.string.B003
            java.lang.String r0 = r0.getString(r1)
            r8.<init>(r4, r0)
            r7.a((java.lang.String) r2, (com.adp.sdk.dto.AdpError) r8)
            return
        L_0x0115:
            java.util.ArrayList<com.adp.sdk.dto.SourceVO> r1 = r7.S
            int r1 = r1.size()
            if (r1 > 0) goto L_0x0127
            com.adp.sdk.dto.AdItem r1 = r7.r
            com.adp.sdk.dto.SourceVO r2 = r7.Q
            java.util.ArrayList r1 = com.adp.sdk.b.a((com.adp.sdk.dto.AdItem) r1, (com.adp.sdk.dto.SourceVO) r2)
            r7.S = r1
        L_0x0127:
            r7.d((boolean) r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            int r0 = r0 + 1
            r8.append(r0)
            java.lang.String r0 = ""
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            r7.b((java.lang.String) r8)
            return
        L_0x0141:
            com.adp.sdk.dto.AdpError r8 = new com.adp.sdk.dto.AdpError
            android.app.Activity r0 = r7.h
            int r1 = com.adp.sdk.R.string.B003
            java.lang.String r0 = r0.getString(r1)
            r8.<init>(r4, r0)
            r7.a((java.lang.String) r2, (com.adp.sdk.dto.AdpError) r8)
            return
        L_0x0152:
            com.adp.sdk.dto.AdpError r8 = new com.adp.sdk.dto.AdpError
            android.app.Activity r0 = r7.h
            int r1 = com.adp.sdk.R.string.B002
            java.lang.String r0 = r0.getString(r1)
            java.lang.String r1 = "B002"
            r8.<init>(r1, r0)
            r7.a((java.lang.String) r2, (com.adp.sdk.dto.AdpError) r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adp.sdk.ADPSplashAdLoader.b(boolean):void");
    }

    /* access modifiers changed from: private */
    public void i(String str, boolean z2) {
        this.P = false;
        c(this.h, this.j, "tencent", "1", this.Q);
        ViewGroup viewGroup = this.s;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        this.K = false;
        this.p = new SplashAD(this.h.getApplication(), str, new j(z2), this.g);
        k();
        if (this.m) {
            this.p.fetchFullScreenAdOnly();
        } else {
            this.p.fetchAdOnly();
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        Activity a2 = com.adp.sdk.utils.k.a.b().a();
        if (this.Y != null && a2 != null && !a2.isFinishing()) {
            this.Y.dismiss();
        }
    }

    private void g(String str, boolean z2) {
        if (!h.a()) {
            h.a((Context) this.h.getApplication());
        }
        ImageView imageView = this.t;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.K = false;
        if (j()) {
            a(str, z2, this.Z, this.a0, true);
            return;
        }
        this.s.post(new d(str, z2));
    }

    private boolean h() {
        Activity a2 = com.adp.sdk.utils.k.a.b().a();
        if (this.h == null) {
            Log.i("adsplus", "context 为空");
        }
        if (a2 == null) {
            Log.i("adsplus", "adcontext 为空");
        }
        Activity activity = this.h;
        return (activity == null || a2 == null || !activity.getComponentName().getClassName().equals(a2.getComponentName().getClassName())) ? false : true;
    }

    /* access modifiers changed from: private */
    public void c(String str, boolean z2) {
        if (j()) {
            b(str, z2, this.Z, this.a0);
        } else {
            this.s.post(new a(str, z2));
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        f();
        this.x = false;
        this.z = false;
        this.y = false;
        ADPSplashADListener aDPSplashADListener = this.k;
        if (aDPSplashADListener != null) {
            aDPSplashADListener.onADDismissed();
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, AdpError adpError) {
        String str2;
        ADPSplashADListener aDPSplashADListener;
        if (!this.R && (aDPSplashADListener = this.k) != null) {
            aDPSplashADListener.onADError(adpError);
        }
        this.R = true;
        b(str, adpError.getCode() + "", adpError.getMessage());
        if (this.f && (str2 = this.N) != null && str2.length() > 0) {
            c.a().a((Context) this.h, this.j, this.N, str, "1", this.Q);
        }
    }

    /* access modifiers changed from: private */
    public void c(String str, boolean z2, int i2, int i3) {
        JADSlot build = new JADSlot.Builder().setSlotID(str).setSize((float) com.adp.sdk.utils.h.b(this.h.getApplication(), i2), (float) com.adp.sdk.utils.h.b(this.h.getApplication(), i3)).setTolerateTime((float) (this.g / 1000)).setSkipTime(5).setSkipButtonHidden(false).build();
        k();
        c(this.h, this.j, BuildConfig.FLAVOR, "1", this.Q);
        JADSplash jADSplash = new JADSplash(this.h.getApplication(), build);
        e0 = jADSplash;
        jADSplash.loadAd(new c(z2));
    }

    private void a(FrameLayout frameLayout) {
        ImageView imageView = (ImageView) frameLayout.findViewById(R.id.adp_splash_holder);
        if (this.m) {
            frameLayout.findViewById(R.id.adp_app_logo).setVisibility(8);
            imageView.setVisibility(8);
        } else {
            imageView.setImageResource(this.o);
            ((ImageView) frameLayout.findViewById(R.id.adp_app_logo)).setImageResource(this.n);
        }
        this.s = (ViewGroup) frameLayout.findViewById(R.id.adp_splash_container);
        ImageView imageView2 = (ImageView) frameLayout.findViewById(R.id.adp_logo_view);
        this.t = imageView2;
        imageView2.setVisibility(8);
    }

    private void d(String str, boolean z2) {
        if (!j.a()) {
            j.a((Context) this.h.getApplication());
        }
        ImageView imageView = this.t;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.K = false;
        if (j()) {
            c(str, z2, this.Z, this.a0);
        } else {
            this.s.post(new g(str, z2));
        }
    }

    public ADPSplashAdLoader(Activity activity, String str, ViewGroup viewGroup, int i2, boolean z2, int i3, int i4, ADPSplashADListener aDPSplashADListener) {
        this.h = activity;
        this.j = str;
        this.i = viewGroup;
        this.k = aDPSplashADListener;
        this.g = i2;
        this.m = z2;
        this.n = i3;
        this.o = i4;
        this.N = new com.adp.sdk.utils.d(activity).b("splasherrorlogs", "");
        if (this.g < 3000) {
            this.g = OxXXx0X.f31420OIII0O;
        }
        d.a(activity.getApplication(), (com.adp.sdk.listener.a) null);
    }

    private boolean c() {
        long parseLong = Long.parseLong(new com.adp.sdk.utils.d(this.h).b("SPALSHTIME", "0"));
        if (parseLong != 0 && (System.currentTimeMillis() - parseLong) / 1000 < 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void d() {
        Runnable runnable;
        Handler handler = this.I;
        if (handler != null && (runnable = this.d0) != null) {
            handler.removeCallbacks(runnable);
        }
    }

    private void a(boolean z2) {
        this.w = System.currentTimeMillis();
        if (this.s == null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.h).inflate(R.layout.adp_splash, (ViewGroup) null, false);
            a(frameLayout);
            ViewGroup viewGroup = this.i;
            if (viewGroup != null) {
                viewGroup.addView(frameLayout);
            }
            this.s.post(new p());
        }
        if (this.j == null) {
            a("adsplus", new AdpError("B001", this.h.getString(R.string.B001)));
        } else if (!ADP.isInitSuccess()) {
            this.A = z2;
            this.u.removeCallbacks(this.c0);
            this.u.postDelayed(this.c0, 100);
        } else {
            b(z2);
        }
    }

    /* access modifiers changed from: private */
    public void c(String str) {
        if (this.P) {
            com.adp.sdk.utils.d dVar = new com.adp.sdk.utils.d(this.h);
            String str2 = "";
            String b2 = dVar.b("time_day", str2);
            String a2 = com.adp.sdk.utils.c.a();
            if (b2.split("_").length != 3) {
                dVar.a("time_day", a2 + "_1_1");
                return;
            }
            String str3 = b2.split("_")[1];
            String str4 = b2.split("_")[2];
            AdItem adItem = this.r;
            if (!(adItem == null || adItem.getButton() == null)) {
                str2 = this.r.getButton().getType();
            }
            if ("1".equals(str) && "1".equals(str2) && "0".equals(str3)) {
                str3 = "1";
            }
            if ("2".equals(str) && "2".equals(str2) && "0".equals(str4)) {
                str4 = "1";
            }
            dVar.a("time_day", a2 + "_" + str3 + "_" + str4);
        }
    }

    private void b(String str, boolean z2) {
        ImageView imageView = this.t;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.K = false;
        if (!f.a()) {
            f.a(this.h, new v(str, z2));
        } else {
            c(str, z2);
        }
    }

    /* access modifiers changed from: private */
    public void b(String str, boolean z2, int i2, int i3) {
        if (this.B == null && f.a()) {
            this.B = ADP.getTTAdManager().createAdNative(this.h);
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.h.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        if (i2 == 0) {
            i2 = displayMetrics.widthPixels;
        }
        if (i3 == 0) {
            i3 = displayMetrics.heightPixels;
        }
        this.C = new AdSlot.Builder().setCodeId(str).setImageAcceptedSize(i2, i3).build();
        if (this.B == null) {
            a("  TTAdNative is not init", "gromore", z2);
            return;
        }
        k();
        c(this.h, this.j, "gromore", "1", this.Q);
        this.B.loadSplashAd(this.C, new b(z2), this.g);
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        this.x = false;
        this.z = false;
        this.y = false;
        a(str, new AdpError(str2 + "", str3));
    }

    private void a(String str, boolean z2) {
        ImageView imageView = this.t;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.K = false;
        if (j()) {
            a(str, z2, this.Z, this.a0);
        } else {
            this.s.post(new q(str, z2));
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, boolean z2, int i2, int i3) {
        if (!d.a()) {
            a("-1 >> baidu init error", "baidu", z2);
            return;
        }
        k();
        c(this.h, this.j, "baidu", "1", this.Q);
        RequestParameters.Builder width = new RequestParameters.Builder().setHeight(i3).setWidth(i2);
        RequestParameters.Builder addCustExt = width.addExtra("timeout", this.g + "").addExtra(SplashAd.KEY_FETCHAD, "false").addExtra(SplashAd.KEY_DISPLAY_DOWNLOADINFO, "true").addExtra(SplashAd.KEY_POPDIALOG_DOWNLOAD, "true").addCustExt(ArticleInfo.PAGE_TITLE, "标题");
        SplashAd splashAd = new SplashAd(this.h.getApplication(), str, addCustExt.build(), new r(z2));
        this.q = splashAd;
        splashAd.load();
    }

    /* access modifiers changed from: private */
    public void b(String str, String str2, String str3) {
        this.N = "";
        String str4 = str + xoXoI.f16453oxoX + str2 + xoXoI.f16453oxoX + str3;
        if (a(this.N)) {
            this.N = str4;
            return;
        }
        this.N += "##" + str4;
    }

    private void b(String str) {
        new com.adp.sdk.utils.d(this.h).a("splash_index", str);
    }

    /* access modifiers changed from: private */
    public void a(ITanxSplashExpressAd iTanxSplashExpressAd, boolean z2) {
        iTanxSplashExpressAd.setOnSplashAdListener(new t());
    }

    /* access modifiers changed from: private */
    public ViewGroup a(Activity activity, boolean z2) {
        Activity a2 = com.adp.sdk.utils.k.a.b().a();
        if (activity != null && activity.isFinishing() && a2 != null && !a2.isFinishing()) {
            try {
                FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(a2).inflate(R.layout.adp_splash, (ViewGroup) null, false);
                a(frameLayout);
                frameLayout.setBackgroundResource(R.color.colorWhite);
                ViewGroup viewGroup = (ViewGroup) frameLayout.findViewById(R.id.adp_splash_container);
                this.s = viewGroup;
                viewGroup.removeAllViews();
                Dialog dialog = new Dialog(a2, R.style.adp_PrivacyThemeDialog2);
                this.Y = dialog;
                dialog.setContentView(frameLayout);
                this.Y.setCancelable(false);
                if (!z2) {
                    this.Y.show();
                    this.z = true;
                }
            } catch (Exception unused) {
            }
        }
        return this.s;
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, boolean z2) {
        this.x = false;
        this.z = false;
        this.y = false;
        b(str2, "-1", str + "");
        if (this.f) {
            String str3 = a(ADP.oaid) ? "#oid无" : "#oid有";
            c a2 = c.a();
            Activity activity = this.h;
            String str4 = this.j;
            a2.a((Context) activity, str4, this.N + str3, str2, "1", this.Q);
        }
        if ((!i() || this.S.size() != 0) && (i() || (this.E < 2 && this.S.size() != 0))) {
            c(z2);
            return;
        }
        a(str2, new AdpError("-1", str + ""));
    }

    /* access modifiers changed from: private */
    public void a(String str, boolean z2, int i2, int i3, boolean z3) {
        Activity activity = this.h;
        if (activity == null || this.s == null) {
            a("adsplus", "-1", "context is null next ad", z2);
            return;
        }
        this.G = false;
        View inflate = activity.getLayoutInflater().inflate(R.layout.adp_splash_huawei, (ViewGroup) null);
        this.F = inflate;
        SplashView splashView = (SplashView) inflate.findViewById(R.id.adp_splash_ad_view);
        if (z3) {
            a("adsplus", "-1", "time out  continue next Ad", z2);
            return;
        }
        c(this.h, this.j, "huawei", "1", this.Q);
        splashView.setAdDisplayListener(new e());
        boolean equals = "portrait".equals(this.r.getOrientation());
        int i4 = this.o;
        if (i4 != 0) {
            splashView.setSloganResId(i4);
        }
        splashView.setAudioFocusType(1);
        splashView.load(str, equals ? 1 : 0, h.a(this.g), new f(z2));
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, String str3, boolean z2) {
        String str4;
        this.x = false;
        this.z = false;
        this.y = false;
        b(str, str2, str3);
        if (this.f && (str4 = this.N) != null && str4.length() > 0) {
            c.a().a((Context) this.h, this.j, this.N, "1", this.Q);
        }
        if ((!i() || this.S.size() != 0) && (i() || (this.E < 2 && this.S.size() != 0))) {
            c(z2);
        } else {
            a(str, new AdpError(str2, str3));
        }
    }

    private void a(long j2, boolean z2) {
        this.t.setVisibility(8);
        if (KsAdSDK.getLoadManager() == null) {
            this.x = false;
            this.z = false;
            this.y = false;
            if ((!i() || this.S.size() != 0) && (i() || (this.E < 2 && this.S.size() != 0))) {
                c(z2);
                return;
            }
            if (this.f) {
                c.a().a((Context) this.h, this.j, "ks init error", "1", this.Q);
            }
            a("kuaishou", new AdpError("-1", "ks init error"));
            return;
        }
        c(this.h, this.j, "kuaishou", "1", this.Q);
        KsAdSDK.getLoadManager().loadSplashScreenAd(new KsScene.Builder(j2).build(), new m(z2));
    }

    /* access modifiers changed from: private */
    public void a(KsSplashScreenAd ksSplashScreenAd, boolean z2) {
        if (ksSplashScreenAd == null) {
            a("kuaishou", new AdpError("-1", "快手的布局对象为空"));
            return;
        }
        Activity activity = this.h;
        if (activity.isFinishing()) {
            activity = com.adp.sdk.utils.k.a.b().a();
        }
        this.O = ksSplashScreenAd.getView(activity, new n());
        if (this.V || (!this.R && this.k != null)) {
            this.k.onADReceive(-1);
        }
        if (j()) {
            this.s = a(this.h, false);
            this.z = true;
        }
        this.s.removeAllViews();
        this.O.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.s.addView(this.O);
    }

    private boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }
}
