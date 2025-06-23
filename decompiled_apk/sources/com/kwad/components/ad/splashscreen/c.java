package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.components.ad.splashscreen.presenter.j;
import com.kwad.components.ad.splashscreen.presenter.k;
import com.kwad.components.ad.splashscreen.presenter.o;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.l;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bn;

/* loaded from: classes11.dex */
public final class c extends com.kwad.components.core.l.c<h> implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener {
    private KsSplashScreenAd.SplashScreenAdInteractionListener Cf;
    private com.kwad.components.ad.splashscreen.e.d Cg;
    private com.kwad.sdk.core.h.b bT;
    private AdInfo mAdInfo;
    private AdResultData mAdResultData;
    private SceneImpl mAdScene;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private DetailVideoView mDetailVideoView;
    private boolean mPageDismissCalled;
    private AdBaseFrameLayout mRootContainer;
    private KsVideoPlayConfig mVideoPlayConfig;

    private c(Context context, AdResultData adResultData) {
        super(context);
        this.mAdResultData = adResultData;
        AdTemplate n = com.kwad.sdk.core.response.b.c.n(adResultData);
        this.mAdTemplate = n;
        this.mAdScene = n.mAdScene;
        pi();
    }

    private static StyleTemplate S(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k = com.kwad.sdk.core.response.b.b.k(adTemplate, com.kwad.sdk.core.response.b.b.dt(adTemplate));
        StyleTemplate styleTemplate = new StyleTemplate();
        if (k != null) {
            styleTemplate.templateId = k.templateId;
            styleTemplate.templateMd5 = k.templateMd5;
            styleTemplate.templateUrl = k.templateUrl;
            styleTemplate.templateVersionCode = (int) k.templateVersionCode;
        }
        return styleTemplate;
    }

    private static Presenter T(AdTemplate adTemplate) {
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(adTemplate);
        Presenter presenter = new Presenter();
        a(presenter, dS);
        if (h.U(adTemplate)) {
            presenter.a(new com.kwad.components.ad.splashscreen.presenter.playcard.a());
        } else {
            presenter.a(new j());
        }
        return presenter;
    }

    private int getSplashLayoutId() {
        return R.layout.ksad_splash_screen_layout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.l.c
    /* renamed from: kr, reason: merged with bridge method [inline-methods] */
    public h ku() {
        com.kwad.components.ad.splashscreen.e.d dVar = new com.kwad.components.ad.splashscreen.e.d(this.lD, com.kwad.sdk.core.response.b.a.cB(this.mAdInfo));
        this.Cg = dVar;
        dVar.a(this.bT);
        this.Cg.ua();
        if (this.mVideoPlayConfig == null) {
            KsVideoPlayConfig.Builder builder = new KsVideoPlayConfig.Builder();
            boolean z = true;
            if (this.mAdInfo.adSplashInfo.mute == 1) {
                z = false;
            }
            this.mVideoPlayConfig = builder.videoSoundEnable(z).build();
        }
        h hVar = new h();
        hVar.d(this.mAdResultData);
        hVar.setSplashScreenAdListener(this.Cf);
        hVar.mRootContainer = this.mRootContainer;
        hVar.mAdScene = this.mAdScene;
        hVar.mVideoPlayConfig = this.mVideoPlayConfig;
        hVar.Ct = this.Cg;
        hVar.mApkDownloadHelper = this.mApkDownloadHelper;
        hVar.Cs = S(this.mAdTemplate);
        hVar.mTimerHelper = new bn();
        if (com.kwad.sdk.core.response.b.a.bb(this.mAdInfo)) {
            com.kwad.components.ad.splashscreen.d.a aVar = new com.kwad.components.ad.splashscreen.d.a(this.mAdTemplate, this.mDetailVideoView, this.mVideoPlayConfig);
            hVar.Cr = aVar;
            hVar.Ct.a(aVar);
        }
        hVar.Ct.a(a(hVar));
        return hVar;
    }

    private void kt() {
        com.kwad.sdk.a.a.c.Au().Ax();
        if (this.mPageDismissCalled) {
            return;
        }
        this.mPageDismissCalled = true;
    }

    public static boolean n(@NonNull AdInfo adInfo) {
        AdInfo.AdSplashInfo adSplashInfo = adInfo.adSplashInfo;
        if (adSplashInfo != null && adSplashInfo.fullScreenClickSwitch == 1) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.components.core.l.c, com.kwad.sdk.widget.KSFrameLayout
    public final void ac() {
        super.ac();
        post(new az() { // from class: com.kwad.components.ad.splashscreen.c.3
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                AdTemplate adTemplate = c.this.mAdTemplate;
                AdInfo unused = c.this.mAdInfo;
                if (!h.U(adTemplate) && ((h) c.this.MW).Cr != null) {
                    ((h) c.this.MW).Cr.mh();
                }
            }
        });
    }

    @Override // com.kwad.components.core.l.c, com.kwad.sdk.widget.KSFrameLayout
    public final void ad() {
        super.ad();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.setOnDismissListener(null);
            this.mApkDownloadHelper.setOnShowListener(null);
        }
        this.Cg.ub();
        kt();
    }

    @Override // com.kwad.components.core.l.c
    public final int getLayoutId() {
        return getSplashLayoutId();
    }

    @Override // com.kwad.components.core.l.c
    public final void initData() {
        boolean z;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dS(this.mAdTemplate);
        KsVideoPlayConfig.Builder builder = new KsVideoPlayConfig.Builder();
        int i = 1;
        if (this.mAdInfo.adSplashInfo.mute != 1) {
            z = true;
        } else {
            z = false;
        }
        KsVideoPlayConfig build = builder.videoSoundEnable(z).build();
        this.mVideoPlayConfig = build;
        AdTemplate adTemplate = this.mAdTemplate;
        if (build.isVideoSoundEnable()) {
            i = 2;
        }
        adTemplate.mInitVoiceStatus = i;
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        this.mApkDownloadHelper = cVar;
        cVar.setOnDismissListener(this);
        this.mApkDownloadHelper.setOnShowListener(this);
    }

    @Override // com.kwad.components.core.l.c
    public final boolean kq() {
        return true;
    }

    @Override // com.kwad.components.core.l.c
    public final void ks() {
        this.mRootContainer = (AdBaseFrameLayout) this.lD.findViewById(R.id.ksad_splash_root_container);
        DetailVideoView detailVideoView = (DetailVideoView) this.lD.findViewById(R.id.ksad_splash_video_player);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.setAd(true);
        this.mDetailVideoView.setVisibility(8);
        this.mRootContainer.findViewById(R.id.splash_play_card_view).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.c.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (!com.kwad.sdk.c.a.a.Bc() && c.n(c.this.mAdInfo) && c.this.MW != null) {
                    ((h) c.this.MW).c(1, view.getContext(), 53, 2);
                }
            }
        });
    }

    @Override // com.kwad.components.core.l.c
    @NonNull
    public final Presenter onCreatePresenter() {
        getContext();
        return T(this.mAdTemplate);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        boolean z;
        if (dialogInterface instanceof com.kwad.components.core.e.c.b) {
            z = ((com.kwad.components.core.e.c.b) dialogInterface).nS();
        } else {
            z = false;
        }
        try {
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Cf;
            if (splashScreenAdInteractionListener != null) {
                if (z) {
                    splashScreenAdInteractionListener.onDownloadTipsDialogDismiss();
                } else {
                    splashScreenAdInteractionListener.onDownloadTipsDialogCancel();
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        try {
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Cf;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onDownloadTipsDialogShow();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
    }

    @Override // android.view.View
    public final void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    public final void setPageExitListener(com.kwad.sdk.core.h.b bVar) {
        this.bT = bVar;
    }

    public final void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.Cf = splashScreenAdInteractionListener;
        T t = this.MW;
        if (t != 0) {
            ((h) t).setSplashScreenAdListener(splashScreenAdInteractionListener);
        }
    }

    public static c a(Context context, @NonNull AdResultData adResultData, boolean z, com.kwad.sdk.core.h.b bVar, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        c cVar;
        AdTemplate n = com.kwad.sdk.core.response.b.c.n(adResultData);
        c cVar2 = null;
        try {
            n.showStartTime = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.b.kW();
            com.kwad.components.ad.splashscreen.monitor.b.ab(n);
            com.kwad.components.ad.splashscreen.monitor.b.kW();
            com.kwad.components.ad.splashscreen.monitor.b.a(n, l.zJ().Ah(), z);
            cVar = new c(com.kwad.sdk.n.l.wrapContextIfNeed(context), adResultData);
        } catch (Throwable th) {
            th = th;
        }
        try {
            cVar.setPageExitListener(bVar);
            cVar.setSplashScreenAdListener(splashScreenAdInteractionListener);
            return cVar;
        } catch (Throwable th2) {
            th = th2;
            cVar2 = cVar;
            com.kwad.components.ad.splashscreen.monitor.b.kW();
            com.kwad.components.ad.splashscreen.monitor.b.a(n, th.toString(), z);
            if (l.zJ().yV()) {
                com.kwad.components.core.d.a.reportSdkCaughtException(th);
                return cVar2;
            }
            throw th;
        }
    }

    private com.kwad.sdk.core.h.c a(final h hVar) {
        return new com.kwad.sdk.core.h.c() { // from class: com.kwad.components.ad.splashscreen.c.1
            @Override // com.kwad.sdk.core.h.c
            public final void aM() {
                bn bnVar = hVar.mTimerHelper;
                if (bnVar != null) {
                    bnVar.Oa();
                }
            }

            @Override // com.kwad.sdk.core.h.c
            public final void aN() {
                bn bnVar = hVar.mTimerHelper;
                if (bnVar != null) {
                    bnVar.Ob();
                }
            }
        };
    }

    private static void a(Presenter presenter, AdInfo adInfo) {
        presenter.a(new k());
        presenter.a(new o());
        if (h.r(adInfo)) {
            presenter.a(new com.kwad.components.ad.splashscreen.presenter.endcard.f());
        }
    }
}
