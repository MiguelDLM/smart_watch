package com.kwad.components.ad.reward.presenter.c;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.model.EcOrderCardStyle;
import com.kwad.components.ad.reward.monitor.c;
import com.kwad.components.ad.reward.presenter.b;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.l;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import java.util.List;

/* loaded from: classes11.dex */
public final class a extends b {
    private List<Integer> cB;
    private AdInfo mAdInfo;
    private l sv;
    private final i tW = new i();
    private long pn = 0;
    private Handler fS = new Handler(Looper.getMainLooper());
    private boolean tX = true;
    private volatile boolean cC = false;
    private Runnable tY = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.c.a.1
        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.tW.sx()) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.tW.sz();
                int sA = a.this.tW.sy().sA();
                a.this.qp.a(elapsedRealtime, a.this.tW.sy().sB(), sA);
            } else if (a.this.tX) {
                a.this.qp.a(5000L, 5000L, 1);
            }
            com.kwad.components.core.o.a.qI().ax(a.this.mAdTemplate);
        }
    };
    private l sw = new l() { // from class: com.kwad.components.ad.reward.presenter.c.a.2
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            a.this.hx();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            a.this.tW.sw();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            a.this.c(j2);
            a.this.pn = j2;
            a.this.tW.sw();
            a.a(a.this, false);
            a.this.qp.pn = j2;
            if (!a.this.cC) {
                a.b(a.this, true);
                com.kwad.components.core.o.a.qI().b(a.this.mAdTemplate, System.currentTimeMillis(), 1);
                c.b(a.this.qp.oZ, a.this.mAdTemplate, a.this.qp.mPageEnterTime);
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            a.this.hR();
        }
    };
    private l gO = new l() { // from class: com.kwad.components.ad.reward.presenter.c.a.3
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            a.this.hx();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i, int i2) {
            super.onMediaPlayError(i, i2);
            c.a(a.this.qp.oZ, a.this.qp.mAdTemplate, a.this.qp.pw, i, i2);
            com.kwad.components.ad.reward.monitor.b.c(a.this.qp.oZ, a.this.mAdTemplate);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            a.this.tW.sw();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            a.this.c(j2);
            a.this.pn = j2;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            a.this.hR();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            a.this.tW.sw();
            a.a(a.this, false);
            if (!a.this.cC) {
                a.b(a.this, true);
                com.kwad.components.core.o.a.qI().b(a.this.mAdTemplate, System.currentTimeMillis(), 1);
                c.b(a.this.qp.oZ, a.this.mAdTemplate, a.this.qp.mPageEnterTime);
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.k
        public final void onVideoPlayBufferingPaused() {
            super.onVideoPlayBufferingPaused();
            a.this.tW.sv();
            a.this.fS.removeCallbacks(a.this.tY);
            a.this.fS.postDelayed(a.this.tY, 5000L);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.k
        public final void onVideoPlayBufferingPlaying() {
            super.onVideoPlayBufferingPlaying();
            a.this.tW.sv();
            a.this.fS.removeCallbacks(a.this.tY);
            a.this.fS.postDelayed(a.this.tY, 5000L);
        }
    };

    private void checkExposure() {
        AdInfo adInfo = this.mAdInfo;
        long j = adInfo.adRewardInfo.callBackStrategyInfo.impressionCheckMs;
        if (j > 0 && com.kwad.sdk.core.response.b.a.af(adInfo) > 5000) {
            this.fS.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.c.a.4
                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.components.ad.reward.l.a(1, a.this.qp);
                }
            }, j);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        AdInfo dS = e.dS(this.mAdTemplate);
        this.mAdInfo = dS;
        this.cB = com.kwad.sdk.core.response.b.a.bn(dS);
        if (this.qp.oK.jN()) {
            this.sv = this.sw;
        } else {
            this.sv = this.gO;
        }
        this.qp.oK.a(this.sv);
        this.fS.postDelayed(this.tY, 5000L);
    }

    public final void hR() {
        this.cC = false;
        EcOrderCardStyle createFromAdInfo = EcOrderCardStyle.createFromAdInfo(this.mAdInfo);
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        if (createFromAdInfo != null) {
            a.C0845a c0845a = new a.C0845a();
            c0845a.aqi = String.valueOf(createFromAdInfo.getValue());
            bVar.b(c0845a);
        }
        if (!this.mAdTemplate.mPvReported) {
            checkExposure();
        }
        com.kwad.components.ad.reward.j.b.a(true, this.mAdTemplate, null, bVar);
        com.kwad.sdk.core.adlog.c.f(this.mAdTemplate, this.qp.mReportExtData);
    }

    public final void hx() {
        g gVar = this.qp;
        if (!gVar.oZ || !gVar.pe) {
            com.kwad.sdk.core.adlog.c.g(this.mAdTemplate, gVar.mReportExtData);
        }
        this.tW.sw();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.fS.removeCallbacksAndMessages(null);
        this.qp.oK.b(this.sv);
        i.a sy = this.tW.sy();
        com.kwad.components.core.o.a.qI().a(this.qp.mAdTemplate, this.pn, sy.sB(), sy.sA());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.cB;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.cB) {
            if (ceil >= num.intValue()) {
                com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, ceil, this.qp.mReportExtData);
                this.cB.remove(num);
                return;
            }
        }
    }

    public static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.tX = false;
        return false;
    }

    public static /* synthetic */ boolean b(a aVar, boolean z) {
        aVar.cC = true;
        return true;
    }
}
