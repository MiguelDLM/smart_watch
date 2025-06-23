package com.kwad.components.ad.splashscreen;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.exoplayer2.C;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.s.m;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;

/* loaded from: classes11.dex */
public final class b {
    private static final Handler fS = new Handler(Looper.getMainLooper());

    /* loaded from: classes11.dex */
    public static class a {
        private volatile boolean Cb;

        private a() {
            this.Cb = false;
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b$b, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0765b {
        private volatile boolean Cc;

        private C0765b() {
            this.Cc = false;
        }

        public static /* synthetic */ boolean a(C0765b c0765b, boolean z) {
            c0765b.Cc = true;
            return true;
        }

        public /* synthetic */ C0765b(byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(C0765b c0765b, AdTemplate adTemplate, long j, long j2, Runnable runnable) {
        if (c0765b.Cc) {
            com.kwad.components.ad.splashscreen.monitor.b.kW();
            com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 7, j, j2);
            com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
            return true;
        }
        fS.removeCallbacks(runnable);
        return false;
    }

    public static void loadSplashScreenAd(@NonNull KsScene ksScene, @NonNull final KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        final SceneImpl covert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.d.d.b(covert);
        com.kwad.components.ad.splashscreen.monitor.b.kW();
        com.kwad.components.ad.splashscreen.monitor.b.p(covert.getPosId());
        boolean a2 = m.rI().a(covert, "loadSplashScreenAd");
        covert.setAdStyle(4);
        covert.setAdNum(1);
        com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenAd ");
        byte b = 0;
        final a aVar = new a(b);
        aVar.Cb = false;
        final long elapsedRealtime2 = SystemClock.elapsedRealtime();
        final ImpInfo impInfo = new ImpInfo(covert);
        final C0765b c0765b = new C0765b(b);
        com.kwad.components.core.o.a.qI().qK();
        Handler handler = fS;
        handler.postDelayed(new az() { // from class: com.kwad.components.ad.splashscreen.b.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                b.a(ImpInfo.this);
            }
        }, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
        final az azVar = new az() { // from class: com.kwad.components.ad.splashscreen.b.2
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                C0765b.a(C0765b.this, true);
                com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd mTimeOutRunnable timeOut");
                KsLoadManager.SplashScreenAdListener splashScreenAdListener2 = splashScreenAdListener;
                com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.awM;
                splashScreenAdListener2.onError(eVar.errorCode, eVar.msg);
                com.kwad.components.ad.splashscreen.monitor.b.kW();
                com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.awM;
                com.kwad.components.ad.splashscreen.monitor.b.c(false, eVar2.errorCode, eVar2.msg, covert.getPosId());
                com.kwad.components.core.o.a.qI().aD(4);
            }
        };
        int a3 = com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.CO);
        if (a3 < 0) {
            a3 = 5000;
        }
        handler.postDelayed(azVar, a3);
        final long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime;
        com.kwad.components.ad.splashscreen.monitor.b.kW();
        com.kwad.components.ad.splashscreen.monitor.b.f(covert.getPosId(), elapsedRealtime3);
        KsAdLoadManager.M();
        KsAdLoadManager.a(new a.C0806a().e(impInfo).aI(true).aJ(a2).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.splashscreen.b.3
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(final int i, final String str, boolean z) {
                if (!C0765b.this.Cc) {
                    b.fS.removeCallbacks(azVar);
                    if (!aVar.Cb && i != com.kwad.sdk.core.network.e.awK.errorCode) {
                        com.kwad.components.ad.splashscreen.monitor.b.kW();
                        com.kwad.components.ad.splashscreen.monitor.b.b(z, i, str, covert.getPosId());
                        com.kwad.components.ad.splashscreen.monitor.b.kW();
                        com.kwad.components.ad.splashscreen.monitor.b.c(z, i, str, covert.getPosId());
                    }
                    bo.runOnUiThread(new az() { // from class: com.kwad.components.ad.splashscreen.b.3.1
                        @Override // com.kwad.sdk.utils.az
                        public final void doTask() {
                            com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                            splashScreenAdListener.onError(i, str);
                            if (i == com.kwad.sdk.core.network.e.awN.errorCode) {
                                com.kwad.components.core.o.a.qI().aD(0);
                            } else {
                                com.kwad.components.core.o.a.qI().aD(3);
                            }
                        }
                    });
                    return;
                }
                com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd onError isTimeOut return " + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r2v8, types: [com.kwad.sdk.api.KsSplashScreenAd, com.kwad.components.ad.splashscreen.KsSplashScreenAdControl] */
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(@NonNull final AdResultData adResultData, boolean z) {
                boolean z2;
                bo.runOnUiThread(new az() { // from class: com.kwad.components.ad.splashscreen.b.3.2
                    @Override // com.kwad.sdk.utils.az
                    public final void doTask() {
                        try {
                            splashScreenAdListener.onRequestResult(adResultData.getAdTemplateList().size());
                            com.kwad.components.ad.splashscreen.monitor.a.kU().o(covert.getPosId());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                        }
                    }
                });
                try {
                    if (b.a(adResultData, aVar, this, z, covert.posId)) {
                        return;
                    }
                    AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
                    adTemplate.loadDataTime = SystemClock.elapsedRealtime() - elapsedRealtime2;
                    adTemplate.notNetworkRequest = z;
                    com.kwad.components.ad.splashscreen.monitor.b.kW();
                    com.kwad.components.ad.splashscreen.monitor.b.d(adTemplate, elapsedRealtime3);
                    com.kwad.sdk.commercial.d.d.a(covert, 1);
                    long elapsedRealtime4 = SystemClock.elapsedRealtime();
                    ?? ksSplashScreenAdControl = new KsSplashScreenAdControl(covert, adResultData);
                    if (com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.CS)) {
                        try {
                            SplashPreloadManager.kz();
                            if (SplashPreloadManager.f(adResultData)) {
                                if (b.a(C0765b.this, adTemplate, elapsedRealtime4, elapsedRealtime3, azVar)) {
                                    return;
                                }
                                b.a(splashScreenAdListener, ksSplashScreenAdControl, adTemplate);
                                if (SplashPreloadManager.kz().e(adResultData)) {
                                    com.kwad.components.ad.splashscreen.monitor.b.kW();
                                    com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 2, elapsedRealtime4, elapsedRealtime3);
                                    com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd cache returned");
                                    com.kwad.components.core.o.a.qI().aD(1);
                                    return;
                                }
                                if (SplashPreloadManager.kz().b(adResultData, true) > 0) {
                                    com.kwad.components.ad.splashscreen.monitor.b.kW();
                                    com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 3, elapsedRealtime4, elapsedRealtime3);
                                    com.kwad.components.core.o.a.qI().aD(2);
                                    return;
                                } else {
                                    com.kwad.components.ad.splashscreen.monitor.b.kW();
                                    com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 4, elapsedRealtime4, elapsedRealtime3);
                                    return;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            z2 = z;
                            ServiceProvider.reportSdkCaughtException(th);
                            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.awP;
                            a(eVar.errorCode, eVar.msg, z2);
                        }
                    }
                    SplashPreloadManager.kz();
                    if (!SplashPreloadManager.f(adResultData)) {
                        SplashPreloadManager.kz();
                        if (!SplashPreloadManager.g(adResultData)) {
                            if (b.a(C0765b.this, adTemplate, elapsedRealtime4, elapsedRealtime3, azVar)) {
                                return;
                            }
                            b.a(splashScreenAdListener, ksSplashScreenAdControl, adTemplate);
                            com.kwad.components.ad.splashscreen.monitor.b.kW();
                            com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 8, elapsedRealtime4, elapsedRealtime3);
                            com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd live no cache returned");
                            com.kwad.components.core.o.a.qI().aD(5);
                            return;
                        }
                    }
                    boolean e = SplashPreloadManager.kz().e(adResultData);
                    com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd onSuccess " + e);
                    if (e) {
                        if (b.a(C0765b.this, adTemplate, elapsedRealtime4, elapsedRealtime3, azVar)) {
                            return;
                        }
                        b.a(splashScreenAdListener, ksSplashScreenAdControl, adTemplate);
                        com.kwad.components.ad.splashscreen.monitor.b.kW();
                        com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 2, elapsedRealtime4, elapsedRealtime3);
                        com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd cache returned");
                        com.kwad.components.core.o.a.qI().aD(1);
                        return;
                    }
                    SplashPreloadManager.kz();
                    try {
                        if (!SplashPreloadManager.f(adResultData)) {
                            if (!C0765b.this.Cc) {
                                b.fS.removeCallbacks(azVar);
                                com.kwad.components.ad.splashscreen.monitor.b.kW();
                                com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 5, elapsedRealtime4, elapsedRealtime3);
                                aVar.Cb = true;
                                a(com.kwad.sdk.core.network.e.awL.errorCode, "请求成功，但缓存未命中", z);
                                com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd no cache returned");
                                com.kwad.components.core.o.a.qI().aD(3);
                                return;
                            }
                            com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
                            return;
                        }
                        com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd image returned");
                        int b2 = SplashPreloadManager.kz().b(adResultData, true);
                        if (b.a(C0765b.this, adTemplate, elapsedRealtime4, elapsedRealtime3, azVar)) {
                            return;
                        }
                        if (b2 > 0) {
                            b.a(splashScreenAdListener, ksSplashScreenAdControl, adTemplate);
                            com.kwad.components.ad.splashscreen.monitor.b.kW();
                            com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 3, elapsedRealtime4, elapsedRealtime3);
                            com.kwad.components.core.o.a.qI().aD(2);
                            return;
                        }
                        com.kwad.components.ad.splashscreen.monitor.b.kW();
                        com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 4, elapsedRealtime4, elapsedRealtime3);
                        aVar.Cb = true;
                        com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.awN;
                        a(eVar2.errorCode, eVar2.msg, z);
                    } catch (Throwable th2) {
                        th = th2;
                        z2 = ksSplashScreenAdControl;
                        ServiceProvider.reportSdkCaughtException(th);
                        com.kwad.sdk.core.network.e eVar3 = com.kwad.sdk.core.network.e.awP;
                        a(eVar3.errorCode, eVar3.msg, z2);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    z2 = z;
                }
            }
        }).ra());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final KsLoadManager.SplashScreenAdListener splashScreenAdListener, final KsSplashScreenAd ksSplashScreenAd, final AdTemplate adTemplate) {
        bo.runOnUiThread(new az() { // from class: com.kwad.components.ad.splashscreen.b.4
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                try {
                    KsAdLoadManager.M().a((KsAdLoadManager) KsSplashScreenAd.this);
                    splashScreenAdListener.onSplashScreenAdLoad(KsSplashScreenAd.this);
                    com.kwad.components.ad.splashscreen.monitor.a.kU().X(adTemplate);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTrace(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(AdResultData adResultData, a aVar, com.kwad.components.core.request.d dVar, boolean z, long j) {
        if (adResultData.getAdTemplateList().size() != 0) {
            return false;
        }
        com.kwad.components.ad.splashscreen.monitor.b.kW();
        com.kwad.components.ad.splashscreen.monitor.b.c(z, com.kwad.sdk.core.network.e.awK.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.awK.msg : adResultData.testErrorMsg, j);
        aVar.Cb = true;
        dVar.a(com.kwad.sdk.core.network.e.awK.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.awK.msg : adResultData.testErrorMsg, z);
        com.kwad.components.core.o.a.qI().aD(3);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(ImpInfo impInfo) {
        final SceneImpl sceneImpl = impInfo.adScene;
        if (TextUtils.isEmpty(sceneImpl.getBidResponse()) && TextUtils.isEmpty(sceneImpl.getBidResponseV2())) {
            com.kwad.components.core.o.a.qI().qL();
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.b.kW();
            com.kwad.components.ad.splashscreen.monitor.b.q(sceneImpl.posId);
            sceneImpl.setAdStyle(4);
            sceneImpl.setAdNum(5);
            ImpInfo impInfo2 = new ImpInfo(sceneImpl);
            com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache ");
            KsAdLoadManager.M();
            KsAdLoadManager.a(new a.C0806a().e(impInfo2).aJ(false).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.splashscreen.b.5
                @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
                public final void a(@NonNull AdResultData adResultData) {
                    try {
                        if (adResultData.getAdTemplateList().size() > 0) {
                            com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache onSuccess:" + adResultData.getAdTemplateList().size() + " saved " + SplashPreloadManager.kz().b(adResultData, false));
                            com.kwad.components.ad.splashscreen.monitor.b.kW();
                            com.kwad.components.ad.splashscreen.monitor.b.a(adResultData.getAdTemplateList(), SystemClock.elapsedRealtime() - elapsedRealtime, SceneImpl.this.getPosId());
                            com.kwad.components.core.o.a.qI().aE(adResultData.getAdTemplateList().size());
                        }
                    } catch (Throwable th) {
                        ServiceProvider.reportSdkCaughtException(th);
                    }
                }

                @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
                public final void onError(int i, String str) {
                    com.kwad.components.ad.splashscreen.monitor.b.kW();
                    com.kwad.components.ad.splashscreen.monitor.b.b(i, str, SceneImpl.this.getPosId());
                    com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                }
            }).ra());
        }
    }
}
