package com.kwad.components.ad.reward.presenter;

import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;

/* loaded from: classes11.dex */
public final class r extends b implements com.kwad.components.ad.reward.e.g, com.kwad.components.ad.reward.e.j, aq.b {
    private com.kwad.components.core.webview.tachikoma.e.e gX;
    private float sD;
    private boolean sS;

    @Nullable
    private a sT;

    @Nullable
    private q sU;

    @Nullable
    private o sV;
    private p sW;
    private int sX;
    private boolean sY;
    private boolean sZ;
    private boolean ta;

    /* loaded from: classes11.dex */
    public class a extends com.kwad.components.core.video.l {
        private long tc;
        private long videoDuration;

        private a() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            this.tc = j2;
            this.videoDuration = j;
            if (!r.this.qp.fy()) {
                r.this.a(j, j2, false);
            }
        }

        public /* synthetic */ a(r rVar, byte b) {
            this();
        }
    }

    public r(AdTemplate adTemplate, boolean z, boolean z2) {
        this.sX = 0;
        this.sY = false;
        this.sZ = z;
        this.ta = z2;
        if (com.kwad.sdk.core.response.b.a.bI(com.kwad.sdk.core.response.b.e.dS(adTemplate))) {
            p pVar = new p();
            this.sW = pVar;
            a(pVar);
        }
    }

    private com.kwad.components.core.webview.tachikoma.e.e bV() {
        if (this.gX == null) {
            this.gX = new com.kwad.components.core.webview.tachikoma.e.e() { // from class: com.kwad.components.ad.reward.presenter.r.2
                @Override // com.kwad.components.core.webview.tachikoma.e.b
                public final void q(String str) {
                    r.this.hF();
                }
            };
        }
        return this.gX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hF() {
        if (this.ta) {
            q qVar = new q(this);
            this.sU = qVar;
            a((Presenter) qVar, true);
        }
        if (this.sZ) {
            o oVar = new o(this);
            this.sV = oVar;
            a((Presenter) oVar, true);
        }
    }

    private boolean hG() {
        return this.sS;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(this.qp.mAdTemplate);
        if (com.kwad.sdk.core.response.b.a.bI(dS)) {
            if (!this.qp.pa) {
                bo.runOnUiThreadDelay(new az() { // from class: com.kwad.components.ad.reward.presenter.r.1
                    @Override // com.kwad.sdk.utils.az
                    public final void doTask() {
                        r.this.hF();
                    }
                }, 100L);
            } else {
                com.kwad.components.core.webview.tachikoma.d.b.tG().a(bV());
            }
        } else if (!com.kwad.sdk.core.response.b.a.bL(dS)) {
            com.kwad.components.core.o.a.qI().aw(this.qp.mAdTemplate);
        }
        this.qp.b(this);
        com.kwad.components.core.playable.a aVar = this.qp.oM;
        if (aVar != null) {
            aVar.a(this);
        }
        boolean gx = com.kwad.components.ad.reward.a.b.gx();
        this.sD = com.kwad.components.ad.reward.a.b.gw();
        if (gx) {
            a aVar2 = new a(this, (byte) 0);
            this.sT = aVar2;
            com.kwad.components.ad.reward.m.e eVar = this.qp.oK;
            if (eVar != null) {
                eVar.a(aVar2);
            }
        }
        com.kwad.components.ad.reward.a.eY().a(this);
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void bL() {
        RewardActionBarControl.ShowActionBarResult ih = this.qp.oN.ih();
        if (ih != null) {
            ih.equals(RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_PLAYABLE_PORTRAIT);
        }
        if (this.sW != null && !this.qp.fI()) {
            if (hG()) {
                this.sW.e(PlayableSource.PLAY_FINISHED_NORMAL);
            } else {
                this.sW.hA();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void bY() {
        this.qp.z(false);
        a aVar = this.sT;
        if (aVar != null && this.sX == 2) {
            a(aVar.videoDuration, this.sT.tc, true);
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void bZ() {
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    public final boolean onBackPressed() {
        boolean fM = this.qp.fM();
        if (!this.qp.fy() || fM) {
            return false;
        }
        com.kwad.components.ad.reward.a.eY().eZ();
        this.qp.z(false);
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        com.kwad.components.ad.reward.m.e eVar;
        super.onUnbind();
        this.qp.c(this);
        com.kwad.components.core.playable.a aVar = this.qp.oM;
        if (aVar != null) {
            aVar.b(this);
        }
        a aVar2 = this.sT;
        if (aVar2 != null && (eVar = this.qp.oK) != null) {
            eVar.b(aVar2);
        }
        com.kwad.components.ad.reward.a.eY().b(this);
        com.kwad.components.core.webview.tachikoma.d.b.tG().b(this.gX);
    }

    @Override // com.kwad.components.core.webview.jshandler.aq.b
    public final void a(aq.a aVar) {
        a aVar2;
        boolean isSuccess = aVar.isSuccess();
        this.sS = isSuccess;
        if (!isSuccess || (aVar2 = this.sT) == null) {
            return;
        }
        a(aVar2.videoDuration, this.sT.tc, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2, boolean z) {
        q qVar;
        if (!hG() || j2 < 10000 || ((float) j2) < ((float) j) * this.sD) {
            return;
        }
        if (com.kwad.components.ad.reward.a.b.gy()) {
            if (this.sY || (qVar = this.sU) == null) {
                return;
            }
            qVar.hB();
            this.sX = 1;
            this.sY = true;
            return;
        }
        o oVar = this.sV;
        if (oVar != null) {
            oVar.H(true ^ z);
            this.sX = 2;
        }
    }

    public r(AdTemplate adTemplate) {
        this(adTemplate, true, true);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.e.n nVar) {
        o oVar;
        q qVar;
        this.qp.z(true);
        int i = this.sX;
        if (i == 1 && (qVar = this.sU) != null) {
            qVar.hC();
        } else {
            if (i != 2 || (oVar = this.sV) == null) {
                return;
            }
            oVar.hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(com.kwad.components.ad.reward.e.g gVar) {
        return getPriority() - gVar.getPriority();
    }
}
