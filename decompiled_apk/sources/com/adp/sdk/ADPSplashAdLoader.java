package com.adp.sdk;

import OoOoXO0.xoXoI;
import XIXIX.OOXIXo;
import android.app.Activity;
import android.app.Dialog;
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
import com.adp.sdk.ADPSplashAdLoader;
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
import oOoIIO0.x0XOIxOo;

/* loaded from: classes.dex */
public class ADPSplashAdLoader extends com.adp.sdk.e {
    private static JADSplash e0;
    private boolean A;
    private TTAdNative B;
    private AdSlot C;
    private View D;
    private int E;
    private View F;
    private boolean G;
    private ITanxSplashExpressAd H;
    private Handler I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private String N;
    private View O;
    private boolean P;
    private SourceVO Q;
    private boolean R;
    private ArrayList<SourceVO> S;
    private oI0IIXIo T;
    private boolean U;
    private boolean V;
    private String W;
    private double X;
    private Dialog Y;
    private int Z;
    private int a0;
    private CSJSplashAd b0;
    private final Runnable c0;
    private final Runnable d0;
    private int g;
    private Activity h;
    private ViewGroup i;
    private String j;
    private ADPSplashADListener k;
    private ADPDownloadConfirmListener l;
    private boolean m;
    private int n;
    private int o;
    private SplashAD p;
    private SplashAd q;
    private AdItem r;
    private ViewGroup s;
    private ImageView t;
    private Handler u;
    private Handler v;
    private long w;
    private boolean x;
    private boolean y;
    private boolean z;

    /* loaded from: classes.dex */
    public interface ADPSplashADListener {
        void onADClicked();

        void onADDismissed();

        void onADError(AdpError adpError);

        void onADPresent();

        void onADReceive(long j);

        void onADTick(long j);
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4677a;
        final /* synthetic */ boolean b;

        public a(String str, boolean z) {
            this.f4677a = str;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.b(this.f4677a, this.b, aDPSplashAdLoader.s.getWidth(), ADPSplashAdLoader.this.s.getHeight());
        }
    }

    /* loaded from: classes.dex */
    public class c implements JADSplashListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f4680a;

        public c(boolean z) {
            this.f4680a = z;
        }

        @Override // com.jd.ad.sdk.splash.JADSplashListener
        public void onClick() {
            ADPSplashAdLoader.this.z = true;
            ADPSplashAdLoader.this.L = true;
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.a(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, BuildConfig.FLAVOR, "1", ADPSplashAdLoader.this.Q);
            if (!ADPSplashAdLoader.this.K) {
                ADPSplashAdLoader.this.K = true;
                if (ADPSplashAdLoader.this.k != null && ADPSplashAdLoader.this.M) {
                    ADPSplashAdLoader.this.k.onADClicked();
                }
            }
        }

        @Override // com.jd.ad.sdk.splash.JADSplashListener
        public void onClose() {
            if (ADPSplashAdLoader.e0 != null) {
                ADPSplashAdLoader.e0.destroy();
                JADSplash unused = ADPSplashAdLoader.e0 = null;
            }
            ADPSplashAdLoader.this.f();
            ADPSplashAdLoader.this.x = false;
            ADPSplashAdLoader.this.z = false;
            ADPSplashAdLoader.this.y = false;
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADDismissed();
            }
        }

        @Override // com.jd.ad.sdk.splash.JADSplashListener
        public void onExposure() {
            ADPSplashAdLoader.this.z = true;
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADPresent();
            }
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.e(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, BuildConfig.FLAVOR, "1", ADPSplashAdLoader.this.Q);
            com.adp.sdk.a.a(ADPSplashAdLoader.this.r, ADPSplashAdLoader.this.h);
        }

        @Override // com.jd.ad.sdk.splash.JADSplashListener
        public void onLoadFailure(int i, String str) {
            ADPSplashAdLoader.this.f();
            ADPSplashAdLoader.this.a(i + " >>" + str, BuildConfig.FLAVOR, this.f4680a);
        }

        @Override // com.jd.ad.sdk.splash.JADSplashListener
        public void onLoadSuccess() {
        }

        @Override // com.jd.ad.sdk.splash.JADSplashListener
        public void onRenderFailure(int i, String str) {
            ADPSplashAdLoader.this.f();
            ADPSplashAdLoader.this.a(i + " >>" + str, "gromore", this.f4680a);
        }

        @Override // com.jd.ad.sdk.splash.JADSplashListener
        public void onRenderSuccess(View view) {
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.b(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, BuildConfig.FLAVOR, "1", ADPSplashAdLoader.this.Q);
            ADPSplashAdLoader.this.x = false;
            if (view != null) {
                ADPSplashAdLoader.this.d();
                if (!ADPSplashAdLoader.this.V && ADPSplashAdLoader.this.E >= 2) {
                    ADPSplashAdLoader.this.c(this.f4680a);
                    return;
                }
                ADPSplashAdLoader.this.D = view;
                ADPSplashAdLoader.this.x = true;
                ADPSplashAdLoader.this.U = true;
                if (ADPSplashAdLoader.this.V || (!ADPSplashAdLoader.this.R && ADPSplashAdLoader.this.k != null)) {
                    ADPSplashAdLoader.this.k.onADReceive(-1L);
                }
                ADPSplashAdLoader.this.z = true;
                if (ADPSplashAdLoader.this.j()) {
                    ADPSplashAdLoader aDPSplashAdLoader2 = ADPSplashAdLoader.this;
                    aDPSplashAdLoader2.s = aDPSplashAdLoader2.a(aDPSplashAdLoader2.h, false);
                    ADPSplashAdLoader.this.s.removeAllViews();
                    ADPSplashAdLoader.this.s.addView(ADPSplashAdLoader.this.D);
                    return;
                }
                if (!this.f4680a) {
                    ADPSplashAdLoader.this.s.removeAllViews();
                    ADPSplashAdLoader.this.s.addView(ADPSplashAdLoader.this.D);
                    return;
                }
                return;
            }
            ADPSplashAdLoader.this.a("  ad is null", BuildConfig.FLAVOR, this.f4680a);
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4681a;
        final /* synthetic */ boolean b;

        public d(String str, boolean z) {
            this.f4681a = str;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.a(this.f4681a, this.b, aDPSplashAdLoader.s.getWidth(), ADPSplashAdLoader.this.s.getHeight(), false);
        }
    }

    /* loaded from: classes.dex */
    public class e extends SplashAdDisplayListener {
        public e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            ADPSplashAdLoader.this.e();
        }

        @Override // com.huawei.hms.ads.splash.SplashAdDisplayListener
        public void onAdClick() {
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.a(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "huawei", "1", ADPSplashAdLoader.this.Q);
            ADPSplashAdLoader.this.z = true;
            ADPSplashAdLoader.this.L = true;
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADClicked();
            }
            new Handler().postDelayed(new Runnable() { // from class: com.adp.sdk.oIX0oI
                @Override // java.lang.Runnable
                public final void run() {
                    ADPSplashAdLoader.e.this.a();
                }
            }, 1500L);
        }

        @Override // com.huawei.hms.ads.splash.SplashAdDisplayListener
        public void onAdShowed() {
            ADPSplashAdLoader.this.z = true;
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADPresent();
            }
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.e(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "huawei", "1", ADPSplashAdLoader.this.Q);
            com.adp.sdk.a.a(ADPSplashAdLoader.this.r, ADPSplashAdLoader.this.h);
        }
    }

    /* loaded from: classes.dex */
    public class f extends SplashView.SplashAdLoadListener {

        /* renamed from: a, reason: collision with root package name */
        boolean f4683a = false;
        final /* synthetic */ boolean b;

        public f(boolean z) {
            this.b = z;
        }

        @Override // com.huawei.hms.ads.splash.SplashView.SplashAdLoadListener
        public void onAdDismissed() {
            if (!this.f4683a) {
                ADPSplashAdLoader.this.e();
            }
        }

        @Override // com.huawei.hms.ads.splash.SplashView.SplashAdLoadListener
        public void onAdFailedToLoad(int i) {
            this.f4683a = true;
            ADPSplashAdLoader.this.f();
            ADPSplashAdLoader.this.x = false;
            ADPSplashAdLoader.this.z = false;
            ADPSplashAdLoader.this.y = false;
            ADPSplashAdLoader.this.b("huawei", i + "", "" + i);
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            if (aDPSplashAdLoader.f && aDPSplashAdLoader.N != null && ADPSplashAdLoader.this.N.length() > 0) {
                com.adp.sdk.c.a().a(ADPSplashAdLoader.this.h, ADPSplashAdLoader.this.j, ADPSplashAdLoader.this.N, "1", ADPSplashAdLoader.this.Q);
            }
            if ((!ADPSplashAdLoader.this.i() || ADPSplashAdLoader.this.S.size() != 0) && (ADPSplashAdLoader.this.i() || (ADPSplashAdLoader.this.E < 2 && ADPSplashAdLoader.this.S.size() != 0))) {
                ADPSplashAdLoader.this.c(this.b);
                return;
            }
            ADPSplashAdLoader.this.a("huawei", new AdpError(i + "", i + ""));
        }

        @Override // com.huawei.hms.ads.splash.SplashView.SplashAdLoadListener
        public void onAdLoaded() {
            ADPSplashAdLoader.this.G = true;
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.b(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "huawei", "1", ADPSplashAdLoader.this.Q);
            ADPSplashAdLoader.this.U = true;
            ADPSplashAdLoader.this.x = true;
            ADPSplashAdLoader.this.d();
            if (ADPSplashAdLoader.this.V || (!ADPSplashAdLoader.this.R && ADPSplashAdLoader.this.k != null)) {
                ADPSplashAdLoader.this.k.onADReceive(5L);
            }
            ADPSplashAdLoader.this.z = true;
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4684a;
        final /* synthetic */ boolean b;

        public g(String str, boolean z) {
            this.f4684a = str;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.c(this.f4684a, this.b, aDPSplashAdLoader.s.getWidth(), ADPSplashAdLoader.this.s.getHeight());
        }
    }

    /* loaded from: classes.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ADPSplashAdLoader.this.X >= ADPSplashAdLoader.this.g) {
                ADPSplashAdLoader.this.E = 2;
                if (!ADPSplashAdLoader.this.R && !ADPSplashAdLoader.this.U) {
                    ADPSplashAdLoader.this.a("adsplus", "-1", "sdk广告超时");
                }
                ADPSplashAdLoader.this.d();
                return;
            }
            ADPSplashAdLoader.this.X += 200.0d;
            ADPSplashAdLoader.this.I.postDelayed(ADPSplashAdLoader.this.d0, 200L);
        }
    }

    /* loaded from: classes.dex */
    public class i implements g.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4686a;
        final /* synthetic */ boolean b;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                i iVar = i.this;
                ADPSplashAdLoader.this.i(iVar.f4686a, iVar.b);
            }
        }

        public i(String str, boolean z) {
            this.f4686a = str;
            this.b = z;
        }

        @Override // com.adp.sdk.g.b
        public void a() {
            ADPSplashAdLoader.this.a("adsplus", "-1", "gdt error GDTAdSdk.start ", this.b);
        }

        @Override // com.adp.sdk.g.b
        public void success() {
            ADPSplashAdLoader.this.v.post(new a());
        }
    }

    /* loaded from: classes.dex */
    public class j implements SplashADListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f4688a;

        /* loaded from: classes.dex */
        public class a implements DownloadConfirmListener {

            /* renamed from: com.adp.sdk.ADPSplashAdLoader$j$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C0091a implements ADPDownloadConfirmCallBack {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ DownloadConfirmCallBack f4690a;

                public C0091a(a aVar, DownloadConfirmCallBack downloadConfirmCallBack) {
                    this.f4690a = downloadConfirmCallBack;
                }

                @Override // com.adp.sdk.listener.ADPDownloadConfirmCallBack
                public void onCancel() {
                    DownloadConfirmCallBack downloadConfirmCallBack = this.f4690a;
                    if (downloadConfirmCallBack != null) {
                        downloadConfirmCallBack.onCancel();
                    }
                }

                @Override // com.adp.sdk.listener.ADPDownloadConfirmCallBack
                public void onConfirm() {
                    DownloadConfirmCallBack downloadConfirmCallBack = this.f4690a;
                    if (downloadConfirmCallBack != null) {
                        downloadConfirmCallBack.onConfirm();
                    }
                }
            }

            public a() {
            }

            @Override // com.qq.e.comm.compliance.DownloadConfirmListener
            public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
                ADPSplashAdLoader.this.l.onDownloadConfirm(activity, i, str, new C0091a(this, downloadConfirmCallBack));
            }
        }

        public j(boolean z) {
            this.f4688a = z;
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADClicked() {
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.a(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "tencent", "1", ADPSplashAdLoader.this.Q);
            ADPSplashAdLoader.this.z = true;
            ADPSplashAdLoader.this.L = true;
            if (!ADPSplashAdLoader.this.K) {
                ADPSplashAdLoader.this.K = true;
                if (ADPSplashAdLoader.this.k != null && ADPSplashAdLoader.this.M) {
                    ADPSplashAdLoader.this.k.onADClicked();
                }
            }
            ADPSplashAdLoader.this.c("2");
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADDismissed() {
            ADPSplashAdLoader.this.f();
            ADPSplashAdLoader.this.x = false;
            ADPSplashAdLoader.this.z = false;
            ADPSplashAdLoader.this.y = false;
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADDismissed();
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADExposure() {
            ADPSplashAdLoader.this.c("1");
            ADPSplashAdLoader.this.z = true;
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.e(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "tencent", "1", ADPSplashAdLoader.this.Q);
            com.adp.sdk.a.a(ADPSplashAdLoader.this.r, ADPSplashAdLoader.this.h);
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADLoaded(long j) {
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.b(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "tencent", "1", ADPSplashAdLoader.this.Q);
            if (ADPSplashAdLoader.this.V || ADPSplashAdLoader.this.E < 2) {
                ADPSplashAdLoader.this.U = true;
                if (ADPSplashAdLoader.this.p != null) {
                    ADPSplashAdLoader.this.p.getECPMLevel();
                }
                ADPSplashAdLoader aDPSplashAdLoader2 = ADPSplashAdLoader.this;
                boolean z = aDPSplashAdLoader2.f;
                aDPSplashAdLoader2.x = true;
                ADPSplashAdLoader.this.d();
                if (ADPSplashAdLoader.this.V || (!ADPSplashAdLoader.this.R && ADPSplashAdLoader.this.k != null)) {
                    ADPSplashAdLoader.this.k.onADReceive(j);
                }
                if (ADPSplashAdLoader.this.l != null && ADPSplashAdLoader.this.p != null) {
                    try {
                        ADPSplashAdLoader.this.p.setDownloadConfirmListener(new a());
                    } catch (Exception unused) {
                    }
                }
                if (ADPSplashAdLoader.this.j()) {
                    ADPSplashAdLoader aDPSplashAdLoader3 = ADPSplashAdLoader.this;
                    aDPSplashAdLoader3.s = aDPSplashAdLoader3.a(aDPSplashAdLoader3.h, true);
                    ADPSplashAdLoader.this.l();
                    ADPSplashAdLoader.this.z = true;
                    return;
                }
                if (!this.f4688a) {
                    if (ADPSplashAdLoader.this.m) {
                        ADPSplashAdLoader.this.p.showFullScreenAd(ADPSplashAdLoader.this.s);
                    } else {
                        ADPSplashAdLoader.this.p.showAd(ADPSplashAdLoader.this.s);
                    }
                    ADPSplashAdLoader.this.z = true;
                    return;
                }
                return;
            }
            ADPSplashAdLoader.this.c(this.f4688a);
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADPresent() {
            ADPSplashAdLoader.this.z = true;
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADPresent();
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADTick(long j) {
            ADPSplashAdLoader.this.z = true;
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADTick(j);
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onNoAD(AdError adError) {
            ADPSplashAdLoader.this.f();
            ADPSplashAdLoader.this.x = false;
            ADPSplashAdLoader.this.z = false;
            ADPSplashAdLoader.this.y = false;
            ADPSplashAdLoader.this.b("tencent", adError.getErrorCode() + "", adError.getErrorMsg());
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            if (aDPSplashAdLoader.f && aDPSplashAdLoader.N != null && ADPSplashAdLoader.this.N.length() > 0) {
                com.adp.sdk.c.a().a(ADPSplashAdLoader.this.h, ADPSplashAdLoader.this.j, ADPSplashAdLoader.this.N, "1", ADPSplashAdLoader.this.Q);
            }
            if ((!ADPSplashAdLoader.this.i() || ADPSplashAdLoader.this.S.size() != 0) && (ADPSplashAdLoader.this.i() || (ADPSplashAdLoader.this.E < 2 && ADPSplashAdLoader.this.S.size() != 0))) {
                ADPSplashAdLoader.this.c(this.f4688a);
                return;
            }
            ADPSplashAdLoader.this.a("tencent", new AdpError(adError.getErrorCode() + "", adError.getErrorMsg()));
        }
    }

    /* loaded from: classes.dex */
    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
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
            ADPSplashAdLoader.this.u.postDelayed(this, 120L);
        }
    }

    /* loaded from: classes.dex */
    public class l extends CountDownTimer {
        public l(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (ADPSplashAdLoader.this.j()) {
                if (ADPSplashAdLoader.this.m) {
                    ADPSplashAdLoader.this.p.showFullScreenAd(ADPSplashAdLoader.this.s);
                } else {
                    ADPSplashAdLoader.this.p.showAd(ADPSplashAdLoader.this.s);
                }
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
        }
    }

    /* loaded from: classes.dex */
    public class m implements KsLoadManager.SplashScreenAdListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f4693a;

        public m(boolean z) {
            this.f4693a = z;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onError(int i, String str) {
            ADPSplashAdLoader.this.f();
            ADPSplashAdLoader.this.x = false;
            ADPSplashAdLoader.this.z = false;
            ADPSplashAdLoader.this.y = false;
            if ((!ADPSplashAdLoader.this.i() || ADPSplashAdLoader.this.S.size() != 0) && (ADPSplashAdLoader.this.i() || (ADPSplashAdLoader.this.E < 2 && ADPSplashAdLoader.this.S.size() != 0))) {
                ADPSplashAdLoader.this.c(this.f4693a);
                return;
            }
            if (ADPSplashAdLoader.this.f && str != null && str.length() > 0) {
                com.adp.sdk.c.a().a(ADPSplashAdLoader.this.h, ADPSplashAdLoader.this.j, str, "1", ADPSplashAdLoader.this.Q);
            }
            ADPSplashAdLoader.this.a("kuaishou", new AdpError("-1", str + ""));
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onRequestResult(int i) {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public void onSplashScreenAdLoad(@NonNull KsSplashScreenAd ksSplashScreenAd) {
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.b(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "kuaishou", "1", ADPSplashAdLoader.this.Q);
            if (ADPSplashAdLoader.this.V || ADPSplashAdLoader.this.E < 2) {
                ADPSplashAdLoader.this.U = true;
                ADPSplashAdLoader.this.x = true;
                ADPSplashAdLoader.this.d();
                ADPSplashAdLoader.this.a(ksSplashScreenAd, this.f4693a);
                return;
            }
            ADPSplashAdLoader.this.c(this.f4693a);
        }
    }

    /* loaded from: classes.dex */
    public class n implements KsSplashScreenAd.SplashScreenAdInteractionListener {
        public n() {
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdClicked() {
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.a(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "kuaishou", "1", ADPSplashAdLoader.this.Q);
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowEnd() {
            ADPSplashAdLoader.this.f();
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADDismissed();
            }
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowError(int i, String str) {
            ADPSplashAdLoader.this.f();
            ADPSplashAdLoader.this.a("kuaishou", new AdpError(i + "", "打开错误:" + str));
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowStart() {
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.e(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "kuaishou", "1", ADPSplashAdLoader.this.Q);
            com.adp.sdk.a.a(ADPSplashAdLoader.this.r, ADPSplashAdLoader.this.h);
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onDownloadTipsDialogCancel() {
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onDownloadTipsDialogDismiss() {
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onDownloadTipsDialogShow() {
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onSkippedAd() {
            ADPSplashAdLoader.this.f();
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADDismissed();
            }
        }
    }

    /* loaded from: classes.dex */
    public class o implements OxxIIOOXO {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f4695a;

        public o(boolean z) {
            this.f4695a = z;
        }

        @Override // oOoIIO0.OxxIIOOXO
        public void onAdCacheLoaded() {
        }

        @Override // oOoIIO0.OxxIIOOXO
        public void onAdClicked() {
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.a(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "octopus", "1", ADPSplashAdLoader.this.Q);
            ADPSplashAdLoader.this.z = true;
            ADPSplashAdLoader.this.L = true;
            if (ADPSplashAdLoader.this.k != null && ADPSplashAdLoader.this.M) {
                ADPSplashAdLoader.this.k.onADClicked();
            }
        }

        @Override // oOoIIO0.OxxIIOOXO
        public void onAdClosed() {
            ADPSplashAdLoader.this.f();
            ADPSplashAdLoader.this.x = false;
            ADPSplashAdLoader.this.z = false;
            ADPSplashAdLoader.this.y = false;
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADDismissed();
            }
        }

        @Override // oOoIIO0.OxxIIOOXO
        public void onAdFailedToLoad(int i) {
            ADPSplashAdLoader.this.f();
            ADPSplashAdLoader.this.x = false;
            ADPSplashAdLoader.this.z = false;
            ADPSplashAdLoader.this.y = false;
            ADPSplashAdLoader.this.b("octopus", i + "", "otoccode：" + i);
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            if (aDPSplashAdLoader.f && aDPSplashAdLoader.N != null && ADPSplashAdLoader.this.N.length() > 0) {
                com.adp.sdk.c.a().a(ADPSplashAdLoader.this.h, ADPSplashAdLoader.this.j, ADPSplashAdLoader.this.N, "1", ADPSplashAdLoader.this.Q);
            }
            if ((!ADPSplashAdLoader.this.i() || ADPSplashAdLoader.this.S.size() != 0) && (ADPSplashAdLoader.this.i() || (ADPSplashAdLoader.this.E < 2 && ADPSplashAdLoader.this.S.size() != 0))) {
                ADPSplashAdLoader.this.c(this.f4695a);
                return;
            }
            ADPSplashAdLoader.this.a("octopus", new AdpError(i + "", "otoccode：" + i));
        }

        @Override // oOoIIO0.OxxIIOOXO
        public void onAdLoaded() {
            if (ADPSplashAdLoader.this.T == null) {
                ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
                aDPSplashAdLoader.b(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "octopus", "1", ADPSplashAdLoader.this.Q);
            } else {
                ADPSplashAdLoader aDPSplashAdLoader2 = ADPSplashAdLoader.this;
                aDPSplashAdLoader2.a(aDPSplashAdLoader2.h, ADPSplashAdLoader.this.j, "octopus", "1", ADPSplashAdLoader.this.Q, ADPSplashAdLoader.this.T.OOXIXo() + "");
            }
            if (!ADPSplashAdLoader.this.V && ADPSplashAdLoader.this.E >= 2) {
                ADPSplashAdLoader.this.c(this.f4695a);
                return;
            }
            try {
                if (ADPSplashAdLoader.this.Q.getPrice() != null) {
                    int parseInt = Integer.parseInt(ADPSplashAdLoader.this.Q.getPrice());
                    if (parseInt > ADPSplashAdLoader.this.T.OOXIXo()) {
                        ADPSplashAdLoader.this.T.II0XooXoX(parseInt, oOoIIO0.oIX0oI.f32047II0xO0, oOoIIO0.oIX0oI.f32051Oxx0IOOO);
                        ADPSplashAdLoader.this.c(this.f4695a);
                        return;
                    }
                    ADPSplashAdLoader.this.T.II0xO0(parseInt);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            ADPSplashAdLoader.this.d();
            ADPSplashAdLoader.this.U = true;
            ADPSplashAdLoader.this.x = true;
            if ((!ADPSplashAdLoader.this.R && ADPSplashAdLoader.this.k != null) || (ADPSplashAdLoader.this.V && ADPSplashAdLoader.this.k != null)) {
                ADPSplashAdLoader.this.k.onADReceive(-1L);
            }
            ADPSplashAdLoader.this.z = false;
            if ((!this.f4695a || ADPSplashAdLoader.this.V) && ADPSplashAdLoader.this.j()) {
                ADPSplashAdLoader.this.c(this.f4695a);
            }
        }

        @Override // oOoIIO0.OxxIIOOXO
        public void onAdShown() {
            ADPSplashAdLoader.this.z = true;
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADPresent();
            }
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.e(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "octopus", "1", ADPSplashAdLoader.this.Q);
            com.adp.sdk.a.a(ADPSplashAdLoader.this.r, ADPSplashAdLoader.this.h);
        }

        @Override // oOoIIO0.OxxIIOOXO
        public void onAdTick(long j) {
        }
    }

    /* loaded from: classes.dex */
    public class p implements Runnable {
        public p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.Z = aDPSplashAdLoader.s.getWidth();
            ADPSplashAdLoader aDPSplashAdLoader2 = ADPSplashAdLoader.this;
            aDPSplashAdLoader2.a0 = aDPSplashAdLoader2.s.getHeight();
        }
    }

    /* loaded from: classes.dex */
    public class q implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4697a;
        final /* synthetic */ boolean b;

        public q(String str, boolean z) {
            this.f4697a = str;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.a(this.f4697a, this.b, aDPSplashAdLoader.s.getWidth(), ADPSplashAdLoader.this.s.getHeight());
        }
    }

    /* loaded from: classes.dex */
    public class r implements SplashInteractionListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f4698a;

        public r(boolean z) {
            this.f4698a = z;
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdCacheFailed() {
            ADPSplashAdLoader.this.a("onAdCacheFailed", "baidu", this.f4698a);
            ADPSplashAdLoader.this.f();
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdCacheSuccess() {
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.b(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "baidu", "1", ADPSplashAdLoader.this.Q);
            if (ADPSplashAdLoader.this.V || ADPSplashAdLoader.this.E < 2) {
                ADPSplashAdLoader.this.U = true;
                ADPSplashAdLoader.this.x = true;
                ADPSplashAdLoader.this.d();
                if (ADPSplashAdLoader.this.V || (!ADPSplashAdLoader.this.R && ADPSplashAdLoader.this.k != null)) {
                    ADPSplashAdLoader.this.k.onADReceive(0L);
                }
                if (ADPSplashAdLoader.this.j()) {
                    ADPSplashAdLoader aDPSplashAdLoader2 = ADPSplashAdLoader.this;
                    aDPSplashAdLoader2.s = aDPSplashAdLoader2.a(aDPSplashAdLoader2.h, false);
                    ADPSplashAdLoader.this.z = true;
                    ADPSplashAdLoader.this.q.show(ADPSplashAdLoader.this.s);
                    return;
                }
                if (!this.f4698a) {
                    ADPSplashAdLoader.this.q.show(ADPSplashAdLoader.this.s);
                    ADPSplashAdLoader.this.z = true;
                    return;
                }
                return;
            }
            ADPSplashAdLoader.this.c(this.f4698a);
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdClick() {
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.a(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "baidu", "1", ADPSplashAdLoader.this.Q);
            ADPSplashAdLoader.this.z = true;
            ADPSplashAdLoader.this.L = true;
            if (!ADPSplashAdLoader.this.K) {
                ADPSplashAdLoader.this.K = true;
                if (ADPSplashAdLoader.this.k != null && ADPSplashAdLoader.this.M) {
                    ADPSplashAdLoader.this.k.onADClicked();
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdDismissed() {
            ADPSplashAdLoader.this.x = false;
            ADPSplashAdLoader.this.z = false;
            ADPSplashAdLoader.this.y = false;
            ADPSplashAdLoader.this.f();
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADDismissed();
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdExposed() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdFailed(String str) {
            ADPSplashAdLoader.this.a(str, "baidu", this.f4698a);
            ADPSplashAdLoader.this.f();
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdPresent() {
            ADPSplashAdLoader.this.z = true;
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADPresent();
            }
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.e(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "baidu", "1", ADPSplashAdLoader.this.Q);
            com.adp.sdk.a.a(ADPSplashAdLoader.this.r, ADPSplashAdLoader.this.h);
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdSkip() {
            ADPSplashAdLoader.this.x = false;
            ADPSplashAdLoader.this.z = false;
            ADPSplashAdLoader.this.y = false;
            ADPSplashAdLoader.this.f();
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADDismissed();
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onLpClosed() {
            ADPSplashAdLoader.this.x = false;
            ADPSplashAdLoader.this.z = false;
            ADPSplashAdLoader.this.y = false;
            ADPSplashAdLoader.this.f();
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADDismissed();
            }
        }
    }

    /* loaded from: classes.dex */
    public class s implements l.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4699a;
        final /* synthetic */ boolean b;

        public s(String str, boolean z) {
            this.f4699a = str;
            this.b = z;
        }

        @Override // com.adp.sdk.l.b
        public void a(int i, String str) {
            ADPSplashAdLoader.this.a(i + " >> " + str, ExposeManager.UtArgsNames.nameSpace, this.b);
        }

        @Override // com.adp.sdk.l.b
        public void success() {
            ADPSplashAdLoader.this.h(this.f4699a, this.b);
        }
    }

    /* loaded from: classes.dex */
    public class t implements ITanxSplashExpressAd.OnSplashAdListener {
        public t() {
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd.OnSplashAdListener
        public void onAdClicked() {
            ADPSplashAdLoader.this.z = true;
            ADPSplashAdLoader.this.L = true;
            if (ADPSplashAdLoader.this.k != null && ADPSplashAdLoader.this.M) {
                ADPSplashAdLoader.this.k.onADClicked();
            }
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.a(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, ExposeManager.UtArgsNames.nameSpace, "1", ADPSplashAdLoader.this.Q);
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd.OnSplashAdListener
        public void onAdClosed() {
            ADPSplashAdLoader.this.x = false;
            ADPSplashAdLoader.this.z = false;
            ADPSplashAdLoader.this.y = false;
            ADPSplashAdLoader.this.f();
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADDismissed();
                ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
                if (aDPSplashAdLoader.f && aDPSplashAdLoader.N != null && ADPSplashAdLoader.this.N.length() > 0) {
                    com.adp.sdk.c.a().a(ADPSplashAdLoader.this.h, ADPSplashAdLoader.this.j, ADPSplashAdLoader.this.N, "1", ADPSplashAdLoader.this.Q);
                }
            }
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd.OnSplashAdListener
        public void onAdFinish() {
            ADPSplashAdLoader.this.x = false;
            ADPSplashAdLoader.this.z = false;
            ADPSplashAdLoader.this.y = false;
            ADPSplashAdLoader.this.f();
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADDismissed();
                ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
                if (aDPSplashAdLoader.f && aDPSplashAdLoader.N != null && ADPSplashAdLoader.this.N.length() > 0) {
                    com.adp.sdk.c.a().a(ADPSplashAdLoader.this.h, ADPSplashAdLoader.this.j, ADPSplashAdLoader.this.N, "1", ADPSplashAdLoader.this.Q);
                }
            }
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd.OnSplashAdListener
        public void onAdRender(ITanxSplashExpressAd iTanxSplashExpressAd) {
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd.OnSplashAdListener
        public void onAdShake() {
            ADPSplashAdLoader.this.z = true;
            ADPSplashAdLoader.this.L = true;
            if (ADPSplashAdLoader.this.k != null && ADPSplashAdLoader.this.M) {
                ADPSplashAdLoader.this.k.onADClicked();
            }
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.a(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, ExposeManager.UtArgsNames.nameSpace, "1", ADPSplashAdLoader.this.Q);
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd.OnSplashAdListener
        public void onAdShow() {
            ADPSplashAdLoader.this.z = true;
            if (ADPSplashAdLoader.this.k != null) {
                ADPSplashAdLoader.this.k.onADPresent();
            }
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.e(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, ExposeManager.UtArgsNames.nameSpace, "1", ADPSplashAdLoader.this.Q);
            com.adp.sdk.a.a(ADPSplashAdLoader.this.r, ADPSplashAdLoader.this.h);
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd.OnSplashAdListener
        public void onShowError(TanxError tanxError) {
            ADPSplashAdLoader.this.a(ExposeManager.UtArgsNames.nameSpace, new AdpError("-1", "ShowError tanx" + tanxError.getMessage() + tanxError.getCode()));
        }
    }

    /* loaded from: classes.dex */
    public class u implements ITanxAdLoader.OnAdLoadListener<ITanxSplashExpressAd> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f4701a;
        final /* synthetic */ ITanxAdLoader b;

        /* loaded from: classes.dex */
        public class a implements ITanxRequestLoader.OnBiddingListener {
            public a(u uVar) {
            }

            @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.OnBiddingListener
            public void onResult(List list) {
            }
        }

        /* loaded from: classes.dex */
        public class b implements ITanxRequestLoader.OnBiddingListener {
            public b(u uVar) {
            }

            @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.OnBiddingListener
            public void onResult(List list) {
            }
        }

        public u(boolean z, ITanxAdLoader iTanxAdLoader) {
            this.f4701a = z;
            this.b = iTanxAdLoader;
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.BaseAdLoadListener
        public void onError(TanxError tanxError) {
            ADPSplashAdLoader.this.f();
            ADPSplashAdLoader.this.a("error:" + tanxError.getCode() + tanxError.getMessage(), ExposeManager.UtArgsNames.nameSpace, this.f4701a);
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener
        public void onLoaded(List<ITanxSplashExpressAd> list) {
            ADPSplashAdLoader.this.d();
            ADPSplashAdLoader.this.x = false;
            ADPSplashAdLoader.this.U = true;
            if (list == null || list.isEmpty()) {
                ADPSplashAdLoader.this.a("  ad is null", ExposeManager.UtArgsNames.nameSpace, this.f4701a);
                return;
            }
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.b(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, ExposeManager.UtArgsNames.nameSpace, "1", ADPSplashAdLoader.this.Q);
            try {
                if (ADPSplashAdLoader.this.Q.getPrice() != null && ADPSplashAdLoader.this.Q.getPrice().length() > 0) {
                    int parseInt = Integer.parseInt(ADPSplashAdLoader.this.Q.getPrice());
                    TanxBiddingInfo biddingInfo = list.get(0).getBiddingInfo();
                    if (parseInt > biddingInfo.getAdPrice()) {
                        ADPSplashAdLoader.this.c(this.f4701a);
                        biddingInfo.setBidResult(false);
                        this.b.biddingResult(list, new a(this));
                        return;
                    } else {
                        biddingInfo.setBidResult(true);
                        biddingInfo.setWinPrice(parseInt);
                        this.b.biddingResult(list, new b(this));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            ADPSplashAdLoader.this.H = list.get(0);
            ADPSplashAdLoader.this.x = true;
            if ((!ADPSplashAdLoader.this.R && ADPSplashAdLoader.this.k != null) || (ADPSplashAdLoader.this.V && ADPSplashAdLoader.this.k != null)) {
                ADPSplashAdLoader.this.k.onADReceive(-1L);
            }
            ADPSplashAdLoader.this.z = false;
            if ((!this.f4701a || ADPSplashAdLoader.this.V) && ADPSplashAdLoader.this.j()) {
                ADPSplashAdLoader aDPSplashAdLoader2 = ADPSplashAdLoader.this;
                aDPSplashAdLoader2.s = aDPSplashAdLoader2.a(aDPSplashAdLoader2.h, false);
                ADPSplashAdLoader.this.z = true;
                ADPSplashAdLoader aDPSplashAdLoader3 = ADPSplashAdLoader.this;
                aDPSplashAdLoader3.a(aDPSplashAdLoader3.H, this.f4701a);
                View adView = ADPSplashAdLoader.this.H.getAdView(ADPSplashAdLoader.this.h);
                ADPSplashAdLoader.this.s.removeAllViews();
                ADPSplashAdLoader.this.s.addView(adView);
            }
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxAdLoader.BaseAdLoadListener
        public void onTimeOut() {
            ADPSplashAdLoader.this.f();
            ADPSplashAdLoader.this.a("time out t", ExposeManager.UtArgsNames.nameSpace, this.f4701a);
        }
    }

    /* loaded from: classes.dex */
    public class v implements f.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4702a;
        final /* synthetic */ boolean b;

        public v(String str, boolean z) {
            this.f4702a = str;
            this.b = z;
        }

        @Override // com.adp.sdk.f.c
        public void a(int i, String str) {
            ADPSplashAdLoader.this.f();
            ADPSplashAdLoader.this.a(i + " >>" + str, "gromore", this.b);
        }

        @Override // com.adp.sdk.f.c
        public void success() {
            ADPSplashAdLoader.this.c(this.f4702a, this.b);
        }
    }

    private ADPSplashAdLoader() {
        this.g = 0;
        this.m = false;
        this.u = new Handler();
        this.v = new Handler();
        this.w = 0L;
        this.x = false;
        this.y = false;
        this.z = false;
        this.A = false;
        this.C = null;
        this.D = null;
        this.E = 0;
        this.G = false;
        this.I = new Handler();
        this.J = false;
        this.K = false;
        this.M = true;
        this.O = null;
        this.P = false;
        this.R = false;
        this.S = new ArrayList<>();
        this.U = false;
        this.V = false;
        this.W = "-1";
        this.X = OOXIXo.f3760XO;
        this.Z = 0;
        this.a0 = 0;
        this.c0 = new k();
        this.d0 = new h();
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
        this.X = OOXIXo.f3760XO;
        this.I.removeCallbacks(this.d0);
        this.I.postDelayed(this.d0, 200L);
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
                return;
            }
            if (!this.y) {
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
        this.X = OOXIXo.f3760XO;
        this.I.removeCallbacks(this.d0);
        this.I.postDelayed(this.d0, 200L);
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
                return;
            }
            if (!this.y) {
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
        this.X = OOXIXo.f3760XO;
        this.I.removeCallbacks(this.d0);
        this.I.postDelayed(this.d0, 200L);
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
                return;
            }
            if (!this.y) {
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

    public void showAD() {
        CSJSplashAd cSJSplashAd;
        oI0IIXIo oi0iixio;
        SplashAD splashAD;
        ITanxSplashExpressAd iTanxSplashExpressAd;
        SplashAd splashAd;
        boolean z;
        try {
            if (ADP.DEBUGLOG) {
                StringBuilder sb = new StringBuilder();
                sb.append("view:");
                if (this.s != null) {
                    z = true;
                } else {
                    z = false;
                }
                sb.append(z);
                sb.append("  loadBoolean:");
                sb.append(this.x);
                sb.append("  showStatus:");
                sb.append(!this.z);
                sb.append("  ");
                sb.append(h());
                Log.i("adsplus", sb.toString());
            }
            if (this.s != null && this.x && !this.z && h()) {
                if ("baidu".equals(this.Q.getSource()) && (splashAd = this.q) != null) {
                    splashAd.show(this.s);
                    this.z = true;
                    return;
                }
                if (ExposeManager.UtArgsNames.nameSpace.equals(this.Q.getSource()) && (iTanxSplashExpressAd = this.H) != null) {
                    a(iTanxSplashExpressAd, false);
                    View adView = this.H.getAdView();
                    com.adp.sdk.utils.j.a(adView);
                    this.s.removeAllViews();
                    this.s.addView(adView);
                    this.z = true;
                    return;
                }
                if ("tencent".equals(this.Q.getSource()) && (splashAD = this.p) != null) {
                    if (this.m) {
                        splashAD.showFullScreenAd(this.s);
                    } else {
                        splashAD.showAd(this.s);
                    }
                    this.z = true;
                    return;
                }
                if ("octopus".equals(this.Q.getSource()) && (oi0iixio = this.T) != null && oi0iixio.x0XOIxOo()) {
                    this.T.OxxIIOOXO();
                    this.z = true;
                    return;
                }
                if (("gromore".equals(this.Q.getSource()) || "bytedance".equals(this.Q.getSource())) && (cSJSplashAd = this.b0) != null) {
                    View splashView = cSJSplashAd.getSplashView();
                    com.adp.sdk.utils.j.a(splashView);
                    this.s.removeAllViews();
                    this.s.addView(splashView);
                    this.z = true;
                    return;
                }
                if (!"kuaishou".equals(this.Q.getSource())) {
                    if ("huawei".equals(this.Q.getSource()) && this.G && this.F != null) {
                        this.s.removeAllViews();
                        this.s.addView(this.F);
                        return;
                    } else if (BuildConfig.FLAVOR.equals(this.Q.getSource()) && this.D != null) {
                        this.s.removeAllViews();
                        this.s.addView(this.D);
                        this.z = true;
                        return;
                    } else {
                        if (ADP.DEBUGLOG) {
                            Log.i("adsplus", "ad else");
                        }
                        a(BuildConfig.FLAVOR, new AdpError("-1", "Ad not prepared"));
                        return;
                    }
                }
                return;
            }
            if (ADP.DEBUGLOG) {
                Log.i("adsplus", "Ad not prepared");
            }
            a("adsplus", new AdpError("-1", "Ad not prepared"));
        } catch (Exception e2) {
            e2.printStackTrace();
            a("adsplus", "-1", "ad " + e2.getMessage());
        }
    }

    private void j(String str, boolean z) {
        if (com.adp.sdk.g.a()) {
            i(str, z);
        } else {
            if (com.adp.sdk.g.a(this.h, new i(str, z))) {
                return;
            }
            a("adsplus", "-1", "ads gdt is error", z);
        }
    }

    private void k() {
        new com.adp.sdk.utils.d(this.h).a("SPALSHTIME", System.currentTimeMillis() + "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            if (j()) {
                this.Y.show();
            }
            new l(200L, 200L).start();
        } catch (Exception unused) {
        }
    }

    private void d(boolean z) {
        try {
            this.V = this.Q.isShowAfterTimeOut();
        } catch (Exception unused) {
        }
        try {
            double parseDouble = Double.parseDouble(this.W);
            if (parseDouble > 2.0d) {
                this.g = (int) (parseDouble * 1000.0d);
            }
        } catch (Exception unused2) {
        }
        try {
            if ("tencent".equals(this.Q.getSource())) {
                j(this.Q.getId(), z);
            } else if ("kuaishou".equals(this.Q.getSource())) {
                try {
                    a(Long.parseLong(this.Q.getId()), z);
                } catch (NumberFormatException unused3) {
                    a(0L, z);
                }
            } else if (ExposeManager.UtArgsNames.nameSpace.equals(this.Q.getSource())) {
                f(this.Q.getId(), z);
            } else if ("gromore".equals(this.Q.getSource())) {
                b(this.Q.getId(), z);
            } else if ("bytedance".equals(this.Q.getSource())) {
                b(this.Q.getId(), z);
            } else if ("octopus".equals(this.Q.getSource())) {
                e(this.Q.getId(), z);
            } else if ("baidu".equals(this.Q.getSource())) {
                a(this.Q.getId(), z);
            } else if (BuildConfig.FLAVOR.equals(this.Q.getSource())) {
                d(this.Q.getId(), z);
            } else if ("huawei".equals(this.Q.getSource())) {
                g(this.Q.getId(), z);
            } else {
                a("adsplus", "-1", "no ad ads", z);
            }
        } catch (Exception e2) {
            Log.e("adsplus", "错误exception:" + e2.getMessage());
            a("adsplus", "-1", "exception:" + e2.getMessage(), z);
        }
    }

    private void e(String str, boolean z) {
        if (!com.adp.sdk.utils.b.a("com.octopus.ad.SplashAd")) {
            a("-1 找不到合适的广告", "octopus", z);
            return;
        }
        try {
            if (!com.adp.sdk.k.a()) {
                com.adp.sdk.k.a(this.h);
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
            o oVar = new o(z);
            x0XOIxOo.IXxxXO(this.g);
            oI0IIXIo oi0iixio = new oI0IIXIo(this.h, str, this.s, oVar);
            this.T = oi0iixio;
            oi0iixio.Oo(true);
        } catch (Exception e3) {
            e3.printStackTrace();
            a("-1 >> 章鱼 init error", "octopus", z);
        }
    }

    private void f(String str, boolean z) {
        ImageView imageView = this.t;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        if (!com.adp.sdk.l.b()) {
            a("-1 >> tanx init error", ExposeManager.UtArgsNames.nameSpace, z);
            return;
        }
        this.K = false;
        if (!com.adp.sdk.l.a()) {
            com.adp.sdk.l.a(this.h.getApplication(), new s(str, z));
        } else {
            h(str, z);
        }
    }

    private void g() {
        AdInfo adInfo;
        this.M = true;
        try {
            String str = ADP.serviceId;
            if (a(str) || (adInfo = com.adp.sdk.a.b) == null || a(adInfo.getChose())) {
                return;
            }
            String[] split = com.adp.sdk.a.b.getChose().split(",");
            String substring = str.substring(str.length() - 1, str.length());
            for (String str2 : split) {
                if (substring.equals(str2)) {
                    this.M = false;
                    return;
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, boolean z) {
        k();
        TanxAdSlot build = new TanxAdSlot.Builder().adCount(1).pid(str).build();
        c(this.h, this.j, ExposeManager.UtArgsNames.nameSpace, "1", this.Q);
        ITanxAdLoader createAdLoader = TanxSdk.getSDKManager().createAdLoader(this.h);
        createAdLoader.loadSplashAd(build, new u(z, createAdLoader), this.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    /* loaded from: classes.dex */
    public class b implements TTAdNative.CSJSplashAdListener {

        /* renamed from: a, reason: collision with root package name */
        private boolean f4678a = true;
        final /* synthetic */ boolean b;

        /* loaded from: classes.dex */
        public class a implements CSJSplashAd.SplashAdListener {
            public a() {
            }

            @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
            public void onSplashAdClick(CSJSplashAd cSJSplashAd) {
                ADPSplashAdLoader.this.z = true;
                ADPSplashAdLoader.this.L = true;
                if (!ADPSplashAdLoader.this.K) {
                    ADPSplashAdLoader.this.K = true;
                    if (ADPSplashAdLoader.this.k != null && ADPSplashAdLoader.this.M) {
                        ADPSplashAdLoader.this.k.onADClicked();
                    }
                }
                ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
                aDPSplashAdLoader.a(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "gromore", "1", ADPSplashAdLoader.this.Q);
            }

            @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
            public void onSplashAdClose(CSJSplashAd cSJSplashAd, int i) {
                ADPSplashAdLoader.this.x = false;
                ADPSplashAdLoader.this.z = false;
                ADPSplashAdLoader.this.y = false;
                ADPSplashAdLoader.this.f();
                if (ADPSplashAdLoader.this.k != null) {
                    ADPSplashAdLoader.this.k.onADDismissed();
                    ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
                    if (aDPSplashAdLoader.f && aDPSplashAdLoader.N != null && ADPSplashAdLoader.this.N.length() > 0) {
                        com.adp.sdk.c.a().a(ADPSplashAdLoader.this.h, ADPSplashAdLoader.this.j, ADPSplashAdLoader.this.N, "1", ADPSplashAdLoader.this.Q);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
            public void onSplashAdShow(CSJSplashAd cSJSplashAd) {
                ADPSplashAdLoader.this.z = true;
                if (ADPSplashAdLoader.this.k != null) {
                    ADPSplashAdLoader.this.k.onADPresent();
                }
                ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
                aDPSplashAdLoader.e(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "gromore", "1", ADPSplashAdLoader.this.Q);
                com.adp.sdk.a.a(ADPSplashAdLoader.this.r, ADPSplashAdLoader.this.h);
            }
        }

        public b(boolean z) {
            this.b = z;
        }

        private synchronized void a(CSJAdError cSJAdError, int i) {
            if (this.f4678a) {
                this.f4678a = false;
                ADPSplashAdLoader.this.a(cSJAdError.getMsg(), "gromore", this.b);
                ADPSplashAdLoader.this.f();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
        public void onSplashLoadFail(CSJAdError cSJAdError) {
            a(cSJAdError, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
        public void onSplashLoadSuccess(CSJSplashAd cSJSplashAd) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
        public void onSplashRenderFail(CSJSplashAd cSJSplashAd, CSJAdError cSJAdError) {
            a(cSJAdError, 2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
        public void onSplashRenderSuccess(CSJSplashAd cSJSplashAd) {
            ADPSplashAdLoader aDPSplashAdLoader = ADPSplashAdLoader.this;
            aDPSplashAdLoader.b(aDPSplashAdLoader.h, ADPSplashAdLoader.this.j, "gromore", "1", ADPSplashAdLoader.this.Q);
            if (ADPSplashAdLoader.this.V || ADPSplashAdLoader.this.E < 2) {
                ADPSplashAdLoader.this.d();
                ADPSplashAdLoader.this.x = false;
                ADPSplashAdLoader.this.U = true;
                if (cSJSplashAd != null) {
                    ADPSplashAdLoader.this.x = true;
                    ADPSplashAdLoader.this.b0 = cSJSplashAd;
                    if ((ADPSplashAdLoader.this.b0 != null && !ADPSplashAdLoader.this.R && ADPSplashAdLoader.this.k != null) || (ADPSplashAdLoader.this.b0 != null && ADPSplashAdLoader.this.V && ADPSplashAdLoader.this.k != null)) {
                        ADPSplashAdLoader.this.k.onADReceive(-1L);
                    }
                    a(cSJSplashAd);
                    ADPSplashAdLoader.this.z = false;
                    if ((!this.b || ADPSplashAdLoader.this.V) && ADPSplashAdLoader.this.j()) {
                        ADPSplashAdLoader aDPSplashAdLoader2 = ADPSplashAdLoader.this;
                        aDPSplashAdLoader2.s = aDPSplashAdLoader2.a(aDPSplashAdLoader2.h, false);
                        ADPSplashAdLoader.this.z = true;
                        View splashView = ADPSplashAdLoader.this.b0.getSplashView();
                        com.adp.sdk.utils.j.a(splashView);
                        ADPSplashAdLoader.this.s.removeAllViews();
                        ADPSplashAdLoader.this.s.addView(splashView);
                        return;
                    }
                    return;
                }
                ADPSplashAdLoader.this.a("  ad is null", "gromore", this.b);
                return;
            }
            ADPSplashAdLoader.this.c(this.b);
        }

        private void a(CSJSplashAd cSJSplashAd) {
            cSJSplashAd.setSplashAdListener(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
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
            d(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(boolean r8) {
        /*
            Method dump skipped, instructions count: 357
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adp.sdk.ADPSplashAdLoader.b(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, boolean z) {
        this.P = false;
        c(this.h, this.j, "tencent", "1", this.Q);
        ViewGroup viewGroup = this.s;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        this.K = false;
        this.p = new SplashAD(this.h.getApplication(), str, new j(z), this.g);
        k();
        if (this.m) {
            this.p.fetchFullScreenAdOnly();
        } else {
            this.p.fetchAdOnly();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Activity a2 = com.adp.sdk.utils.k.a.b().a();
        if (this.Y == null || a2 == null || a2.isFinishing()) {
            return;
        }
        this.Y.dismiss();
    }

    private void g(String str, boolean z) {
        if (!com.adp.sdk.h.a()) {
            com.adp.sdk.h.a(this.h.getApplication());
        }
        ImageView imageView = this.t;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.K = false;
        if (j()) {
            a(str, z, this.Z, this.a0, true);
        } else {
            this.s.post(new d(str, z));
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, boolean z) {
        if (j()) {
            b(str, z, this.Z, this.a0);
        } else {
            this.s.post(new a(str, z));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, AdpError adpError) {
        String str2;
        ADPSplashADListener aDPSplashADListener;
        if (!this.R && (aDPSplashADListener = this.k) != null) {
            aDPSplashADListener.onADError(adpError);
        }
        this.R = true;
        b(str, adpError.getCode() + "", adpError.getMessage());
        if (!this.f || (str2 = this.N) == null || str2.length() <= 0) {
            return;
        }
        com.adp.sdk.c.a().a(this.h, this.j, this.N, str, "1", this.Q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, boolean z, int i2, int i3) {
        JADSlot build = new JADSlot.Builder().setSlotID(str).setSize(com.adp.sdk.utils.h.b(this.h.getApplication(), i2), com.adp.sdk.utils.h.b(this.h.getApplication(), i3)).setTolerateTime(this.g / 1000).setSkipTime(5).setSkipButtonHidden(false).build();
        k();
        c(this.h, this.j, BuildConfig.FLAVOR, "1", this.Q);
        JADSplash jADSplash = new JADSplash(this.h.getApplication(), build);
        e0 = jADSplash;
        jADSplash.loadAd(new c(z));
    }

    private void a(FrameLayout frameLayout) {
        ImageView imageView = (ImageView) frameLayout.findViewById(R.id.adp_splash_holder);
        if (this.m) {
            frameLayout.findViewById(R.id.adp_app_logo).setVisibility(8);
            imageView.setVisibility(8);
        } else {
            ImageView imageView2 = (ImageView) frameLayout.findViewById(R.id.adp_app_logo);
            imageView.setImageResource(this.o);
            imageView2.setImageResource(this.n);
        }
        this.s = (ViewGroup) frameLayout.findViewById(R.id.adp_splash_container);
        ImageView imageView3 = (ImageView) frameLayout.findViewById(R.id.adp_logo_view);
        this.t = imageView3;
        imageView3.setVisibility(8);
    }

    private void d(String str, boolean z) {
        if (!com.adp.sdk.j.a()) {
            com.adp.sdk.j.a(this.h.getApplication());
        }
        ImageView imageView = this.t;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.K = false;
        if (j()) {
            c(str, z, this.Z, this.a0);
        } else {
            this.s.post(new g(str, z));
        }
    }

    public ADPSplashAdLoader(Activity activity, String str, ViewGroup viewGroup, int i2, boolean z, int i3, int i4, ADPSplashADListener aDPSplashADListener) {
        this.g = 0;
        this.m = false;
        this.u = new Handler();
        this.v = new Handler();
        this.w = 0L;
        this.x = false;
        this.y = false;
        this.z = false;
        this.A = false;
        this.C = null;
        this.D = null;
        this.E = 0;
        this.G = false;
        this.I = new Handler();
        this.J = false;
        this.K = false;
        this.M = true;
        this.O = null;
        this.P = false;
        this.R = false;
        this.S = new ArrayList<>();
        this.U = false;
        this.V = false;
        this.W = "-1";
        this.X = OOXIXo.f3760XO;
        this.Z = 0;
        this.a0 = 0;
        this.c0 = new k();
        this.d0 = new h();
        this.h = activity;
        this.j = str;
        this.i = viewGroup;
        this.k = aDPSplashADListener;
        this.g = i2;
        this.m = z;
        this.n = i3;
        this.o = i4;
        this.N = new com.adp.sdk.utils.d(activity).b("splasherrorlogs", "");
        if (this.g < 3000) {
            this.g = OxXXx0X.f13024OIII0O;
        }
        com.adp.sdk.d.a(activity.getApplication(), null);
    }

    private boolean c() {
        long parseLong = Long.parseLong(new com.adp.sdk.utils.d(this.h).b("SPALSHTIME", "0"));
        return parseLong != 0 && (System.currentTimeMillis() - parseLong) / 1000 < 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Runnable runnable;
        Handler handler = this.I;
        if (handler == null || (runnable = this.d0) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }

    private void a(boolean z) {
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
        } else {
            if (!ADP.isInitSuccess()) {
                this.A = z;
                this.u.removeCallbacks(this.c0);
                this.u.postDelayed(this.c0, 100L);
                return;
            }
            b(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (this.P) {
            com.adp.sdk.utils.d dVar = new com.adp.sdk.utils.d(this.h);
            String str2 = "";
            String b2 = dVar.b("time_day", "");
            String a2 = com.adp.sdk.utils.c.a();
            if (b2.split("_").length != 3) {
                dVar.a("time_day", a2 + "_1_1");
                return;
            }
            String str3 = b2.split("_")[1];
            String str4 = b2.split("_")[2];
            AdItem adItem = this.r;
            if (adItem != null && adItem.getButton() != null) {
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

    private void b(String str, boolean z) {
        ImageView imageView = this.t;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.K = false;
        if (!com.adp.sdk.f.a()) {
            com.adp.sdk.f.a(this.h, new v(str, z));
        } else {
            c(str, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, boolean z, int i2, int i3) {
        if (this.B == null && com.adp.sdk.f.a()) {
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
            a("  TTAdNative is not init", "gromore", z);
            return;
        }
        k();
        c(this.h, this.j, "gromore", "1", this.Q);
        this.B.loadSplashAd(this.C, new b(z), this.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        this.x = false;
        this.z = false;
        this.y = false;
        a(str, new AdpError(str2 + "", str3));
    }

    private void a(String str, boolean z) {
        ImageView imageView = this.t;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.K = false;
        if (j()) {
            a(str, z, this.Z, this.a0);
        } else {
            this.s.post(new q(str, z));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, int i2, int i3) {
        if (!com.adp.sdk.d.a()) {
            a("-1 >> baidu init error", "baidu", z);
            return;
        }
        k();
        c(this.h, this.j, "baidu", "1", this.Q);
        SplashAd splashAd = new SplashAd(this.h.getApplication(), str, new RequestParameters.Builder().setHeight(i3).setWidth(i2).addExtra("timeout", this.g + "").addExtra(SplashAd.KEY_FETCHAD, "false").addExtra(SplashAd.KEY_DISPLAY_DOWNLOADINFO, "true").addExtra(SplashAd.KEY_POPDIALOG_DOWNLOAD, "true").addCustExt(ArticleInfo.PAGE_TITLE, "标题").build(), new r(z));
        this.q = splashAd;
        splashAd.load();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, String str3) {
        this.N = "";
        String str4 = str + xoXoI.f2670oxoX + str2 + xoXoI.f2670oxoX + str3;
        if (a(this.N)) {
            this.N = str4;
            return;
        }
        this.N += "##" + str4;
    }

    private void b(String str) {
        new com.adp.sdk.utils.d(this.h).a("splash_index", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ITanxSplashExpressAd iTanxSplashExpressAd, boolean z) {
        iTanxSplashExpressAd.setOnSplashAdListener(new t());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ViewGroup a(Activity activity, boolean z) {
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
                if (!z) {
                    this.Y.show();
                    this.z = true;
                }
            } catch (Exception unused) {
            }
        }
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, boolean z) {
        this.x = false;
        this.z = false;
        this.y = false;
        b(str2, "-1", str + "");
        if (this.f) {
            String str3 = a(ADP.oaid) ? "#oid无" : "#oid有";
            com.adp.sdk.c.a().a(this.h, this.j, this.N + str3, str2, "1", this.Q);
        }
        if ((i() && this.S.size() == 0) || (!i() && (this.E >= 2 || this.S.size() == 0))) {
            a(str2, new AdpError("-1", str + ""));
            return;
        }
        c(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, int i2, int i3, boolean z2) {
        Activity activity = this.h;
        if (activity != null && this.s != null) {
            this.G = false;
            View inflate = activity.getLayoutInflater().inflate(R.layout.adp_splash_huawei, (ViewGroup) null);
            this.F = inflate;
            SplashView splashView = (SplashView) inflate.findViewById(R.id.adp_splash_ad_view);
            if (z2) {
                a("adsplus", "-1", "time out  continue next Ad", z);
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
            splashView.load(str, equals ? 1 : 0, com.adp.sdk.h.a(this.g), new f(z));
            return;
        }
        a("adsplus", "-1", "context is null next ad", z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, boolean z) {
        String str4;
        this.x = false;
        this.z = false;
        this.y = false;
        b(str, str2, str3);
        if (this.f && (str4 = this.N) != null && str4.length() > 0) {
            com.adp.sdk.c.a().a(this.h, this.j, this.N, "1", this.Q);
        }
        if ((i() && this.S.size() == 0) || (!i() && (this.E >= 2 || this.S.size() == 0))) {
            a(str, new AdpError(str2, str3));
        } else {
            c(z);
        }
    }

    private void a(long j2, boolean z) {
        this.t.setVisibility(8);
        if (KsAdSDK.getLoadManager() == null) {
            this.x = false;
            this.z = false;
            this.y = false;
            if ((i() && this.S.size() == 0) || (!i() && (this.E >= 2 || this.S.size() == 0))) {
                if (this.f) {
                    com.adp.sdk.c.a().a(this.h, this.j, "ks init error", "1", this.Q);
                }
                a("kuaishou", new AdpError("-1", "ks init error"));
                return;
            }
            c(z);
            return;
        }
        c(this.h, this.j, "kuaishou", "1", this.Q);
        KsAdSDK.getLoadManager().loadSplashScreenAd(new KsScene.Builder(j2).build(), new m(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(KsSplashScreenAd ksSplashScreenAd, boolean z) {
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
            this.k.onADReceive(-1L);
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
