package com.kwad.components.ad.reward.presenter.f;

import XIXIX.OOXIXo;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.RewardRenderResult;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.k.d;
import com.kwad.components.ad.reward.k.e;
import com.kwad.components.ad.reward.k.h;
import com.kwad.components.ad.reward.k.i;
import com.kwad.components.ad.reward.k.j;
import com.kwad.components.ad.reward.k.k;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.af;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.be;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.h;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.a.y;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.q;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.r;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;
import com.kwad.sdk.utils.h;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public abstract class d extends com.kwad.components.ad.reward.presenter.b implements DialogInterface.OnDismissListener, com.kwad.components.ad.reward.k.a.e, y.a {
    protected com.kwad.components.ad.reward.k.a.d wl;
    private p wm;
    private o wn;
    private i wo;
    private j wp;
    private com.kwad.components.core.webview.tachikoma.b.y wq;
    private boolean wr;
    private com.kwad.components.core.webview.tachikoma.a.h ws;

    @Nullable
    protected e wt;
    private be.b wu = new be.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.1
        @Override // com.kwad.components.core.webview.jshandler.be.b
        public final void Q(int i) {
            com.kwad.sdk.core.adlog.c.b f = new com.kwad.sdk.core.adlog.c.b().cK(i).f(d.this.qp.mRootContainer.getTouchCoords());
            com.kwad.components.core.e.d.a.a(new a.C0788a(d.this.getContext()).ar(d.this.qp.mAdTemplate).b(d.this.qp.mApkDownloadHelper).ao(false));
            com.kwad.components.ad.reward.j.b.a(d.this.qp.mAdTemplate, d.this.iW(), (String) null, f, (JSONObject) null);
        }
    };
    private final h.a hq = new h.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.5
        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeOccupied() {
            if (d.this.wn != null && !com.kwad.components.ad.reward.a.b.gt()) {
                m mVar = new m();
                mVar.aba = true;
                d.this.wn.c(mVar);
            }
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeReleased() {
        }
    };
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.f.d.6
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (d.this.wo != null) {
                com.kwad.components.core.webview.tachikoma.b.h hVar = new com.kwad.components.core.webview.tachikoma.b.h();
                hVar.aaV = 1;
                d.this.wo.a(hVar);
            }
        }
    };
    private final com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.7
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            if (d.this.wp != null) {
                bo.runOnUiThreadDelay(new az() { // from class: com.kwad.components.ad.reward.presenter.f.d.7.1
                    @Override // com.kwad.sdk.utils.az
                    public final void doTask() {
                        com.kwad.components.core.webview.tachikoma.b.o oVar = new com.kwad.components.core.webview.tachikoma.b.o();
                        oVar.scene = 1;
                        d.this.wp.a(oVar);
                        if (d.this.ws != null) {
                            d.this.ws.aV(d.this.qp.pB);
                        }
                    }
                }, 0L);
            }
        }
    };
    private final com.kwad.components.core.video.l gO = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.f.d.8
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            d.this.hx();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i, int i2) {
            d.this.iU();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            d.this.a(j, j2);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            d.this.g(OOXIXo.f3760XO);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPreparing() {
            d.this.g(OOXIXo.f3760XO);
        }
    };

    public d() {
        if (iN()) {
            this.wt = new e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hx() {
        if (this.qp.pe) {
            iU();
        } else {
            iT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iO() {
        com.kwad.components.ad.reward.g gVar = this.qp;
        com.kwad.sdk.core.adlog.c.b(gVar.mAdTemplate, 17, gVar.mReportExtData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iP() {
        this.qp.y(iW());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iQ() {
        com.kwad.components.ad.reward.j.b.a(this.qp.mAdTemplate, iW(), "endTopBar", new com.kwad.sdk.core.adlog.c.b().cK(39).f(this.qp.mRootContainer.getTouchCoords()), this.qp.mReportExtData);
        this.qp.oJ.bJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iR() {
        com.kwad.components.ad.reward.j.b.a(this.qp.mAdTemplate, iW(), (String) null, new com.kwad.sdk.core.adlog.c.b().cK(40).f(this.qp.mRootContainer.getTouchCoords()), this.qp.mReportExtData);
        this.qp.oJ.bJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iS() {
        com.kwad.components.ad.reward.j.b.a(this.qp.mAdTemplate, iW(), (String) null, new com.kwad.sdk.core.adlog.c.b().cK(41).f(this.qp.mRootContainer.getTouchCoords()), this.qp.mReportExtData);
        this.qp.oJ.bJ();
    }

    private void iT() {
        com.kwad.components.core.webview.tachikoma.b.y yVar = this.wq;
        yVar.abf = true;
        yVar.abj = false;
        yVar.nF = com.kwad.sdk.core.response.b.a.L(com.kwad.sdk.core.response.b.e.dS(this.qp.mAdTemplate));
        iV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iU() {
        com.kwad.components.core.webview.tachikoma.b.y yVar = this.wq;
        yVar.abj = true;
        yVar.abf = false;
        iV();
    }

    private void iV() {
        com.kwad.components.core.webview.tachikoma.b.y yVar;
        p pVar = this.wm;
        if (pVar != null && (yVar = this.wq) != null) {
            pVar.a(yVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String iW() {
        com.kwad.components.ad.reward.k.a.d dVar = this.wl;
        if (dVar == null) {
            return null;
        }
        return dVar.getTkTemplateId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerify() {
        this.qp.oJ.onRewardVerify();
    }

    public void a(WebCloseStatus webCloseStatus) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public void aj() {
        super.aj();
        this.wr = true;
        this.qp.a(this);
        if (this.wl == null) {
            this.wl = new com.kwad.components.ad.reward.k.a.d(this.qp, -1L, getContext());
        }
        if (this.wq == null) {
            this.wq = new com.kwad.components.core.webview.tachikoma.b.y();
        }
        this.wl.a(this.qp.getActivity(), this.qp.mAdResultData, this);
        e eVar = this.wt;
        if (eVar != null) {
            eVar.y(this.qp);
        }
    }

    public void bF() {
        e eVar = this.wt;
        if (eVar != null) {
            eVar.bF();
        }
    }

    public void bG() {
    }

    public com.kwad.sdk.widget.e getTouchCoordsView() {
        return this.qp.mRootContainer;
    }

    public boolean iN() {
        return false;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        com.kwad.components.ad.reward.k.a.d dVar = this.wl;
        if (dVar != null && dVar.jo() != null) {
            this.wl.jo().gR();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        if (!this.wr) {
            return;
        }
        e eVar = this.wt;
        if (eVar != null) {
            eVar.z(this.qp);
        }
        this.qp.b(this);
        com.kwad.components.ad.reward.k.a.d dVar = this.wl;
        if (dVar != null) {
            dVar.jq();
        }
        com.kwad.components.ad.reward.m.e eVar2 = this.qp.oK;
        if (eVar2 != null) {
            eVar2.b(this.gO);
            this.qp.oK.b(this.hq);
        }
        com.kwad.components.ad.reward.b.fc().b(this.mRewardVerifyListener);
        this.qp.c(this.mPlayEndPageListener);
    }

    private void d(long j, long j2) {
        long min = Math.min(com.kwad.sdk.core.response.b.a.af(this.qp.mAdTemplate.adInfoList.get(0)), j);
        if (j2 < min - 800) {
            this.qp.pt = (int) ((((float) (min - j2)) / 1000.0f) + 0.5f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(double d) {
        com.kwad.components.core.webview.tachikoma.b.y yVar = this.wq;
        yVar.abj = false;
        yVar.abf = false;
        yVar.nF = (int) ((d / 1000.0d) + 0.5d);
        iV();
    }

    public void a(r rVar, com.kwad.sdk.core.webview.b bVar) {
        k kVar = new k();
        kVar.a(new k.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.9
            @Override // com.kwad.components.ad.reward.k.k.a
            public final void d(q qVar) {
                com.kwad.components.ad.reward.c.ff().c(qVar);
            }
        });
        rVar.c(kVar);
        long j = this.qp.pv;
        rVar.c(new com.kwad.components.ad.reward.k.g(j > 0 ? ((int) j) / 1000 : 0));
        i iVar = new i();
        this.wo = iVar;
        rVar.c(iVar);
        j jVar = new j();
        this.wp = jVar;
        rVar.c(jVar);
        com.kwad.components.ad.reward.b.fc().a(this.mRewardVerifyListener);
        this.qp.b(this.mPlayEndPageListener);
        rVar.c(new ai(new ai.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.10
            @Override // com.kwad.components.core.webview.jshandler.ai.b
            public final void a(ai.a aVar) {
                d.this.getTKContainer().setVisibility(8);
            }
        }));
        com.kwad.components.ad.reward.k.d dVar = new com.kwad.components.ad.reward.k.d();
        dVar.a(new d.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.11
            @Override // com.kwad.components.ad.reward.k.d.a
            public final void a(final com.kwad.components.core.webview.tachikoma.b.p pVar) {
                com.kwad.components.core.e.d.a.a(new a.C0788a(d.this.getContext()).ar(d.this.qp.mAdTemplate).b(d.this.qp.mApkDownloadHelper).an(1).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.11.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        if (pVar.abc) {
                            d.this.iQ();
                        } else {
                            d.this.iR();
                        }
                    }
                }));
            }
        });
        rVar.c(dVar);
        com.kwad.components.ad.reward.k.e eVar = new com.kwad.components.ad.reward.k.e();
        eVar.a(new e.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.12
            @Override // com.kwad.components.ad.reward.k.e.a
            public final void iX() {
                com.kwad.components.core.e.d.a.a(new a.C0788a(d.this.getContext()).ar(d.this.qp.mAdTemplate).b(d.this.qp.mApkDownloadHelper).an(2).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.12.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        d.this.iS();
                    }
                }));
            }
        });
        rVar.c(eVar);
        rVar.c(new com.kwad.components.ad.reward.k.h(new h.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.13
            @Override // com.kwad.components.ad.reward.k.h.a
            public final void R(int i) {
                if (com.kwad.components.ad.reward.g.G(d.this.qp.mAdTemplate)) {
                    if (com.kwad.components.ad.reward.g.E(d.this.qp.mAdTemplate) && d.this.qp.pr != null) {
                        if (!d.this.qp.pr.jC()) {
                            d.this.qp.pr.jB();
                        }
                    } else if (com.kwad.components.ad.reward.g.F(d.this.qp.mAdTemplate) && d.this.qp.ps != null && !d.this.qp.ps.jC()) {
                        d.this.qp.ps.jB();
                    }
                }
                if (d.this.qp.fK() != RewardRenderResult.DEFAULT) {
                    d.this.qp.ph = i;
                }
                d.this.notifyRewardVerify();
            }
        }));
        rVar.c(new com.kwad.components.ad.reward.k.c() { // from class: com.kwad.components.ad.reward.presenter.f.d.14
            @Override // com.kwad.components.ad.reward.k.c
            public final void iY() {
                super.iY();
                d.this.iP();
            }
        });
        rVar.c(new com.kwad.components.ad.reward.k.f() { // from class: com.kwad.components.ad.reward.presenter.f.d.15
            @Override // com.kwad.components.ad.reward.k.f
            public final void U(boolean z) {
                super.U(z);
                com.kwad.components.ad.reward.presenter.f.t(d.this.qp);
            }
        });
        rVar.c(new com.kwad.components.ad.reward.k.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.16
            @Override // com.kwad.components.ad.reward.k.b
            public final void iY() {
                super.iY();
                d.this.iO();
            }
        });
        rVar.c(new com.kwad.components.core.webview.tachikoma.a.q() { // from class: com.kwad.components.ad.reward.presenter.f.d.2
            @Override // com.kwad.components.core.webview.tachikoma.a.q, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.s.j.e(d.this.getContext(), d.this.qp.mAdTemplate);
            }
        });
        rVar.c(new com.kwad.components.ad.reward.i.b(getContext(), this.qp.mAdTemplate, PlayableSource.ACTIONBAR_CLICK));
        com.kwad.components.core.webview.tachikoma.a.h hVar = new com.kwad.components.core.webview.tachikoma.a.h();
        this.ws = hVar;
        hVar.a(new h.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.3
            @Override // com.kwad.components.core.webview.tachikoma.a.h.a
            public final void a(com.kwad.components.core.webview.tachikoma.a.h hVar2) {
                hVar2.aV(d.this.qp.pB);
            }
        });
        rVar.c(this.ws);
        rVar.c(new af());
        rVar.c(new be(bVar, this.qp.mApkDownloadHelper, this.wu));
        rVar.c(new y(this));
    }

    public void a(p pVar) {
        this.wm = pVar;
        com.kwad.components.ad.reward.m.e eVar = this.qp.oK;
        if (eVar != null) {
            eVar.a(this.gO);
        }
    }

    public void a(t tVar) {
        com.kwad.components.ad.reward.presenter.f.a(this.qp, false);
    }

    public void a(TKRenderFailReason tKRenderFailReason) {
        e eVar = this.wt;
        if (eVar != null) {
            eVar.ja();
        }
    }

    public void a(aw awVar) {
        e eVar = this.wt;
        if (eVar != null) {
            eVar.b(awVar);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0809a c0809a) {
        char c;
        com.kwad.components.ad.reward.g gVar = this.qp;
        if (gVar == null || gVar.oJ == null) {
            return;
        }
        try {
            a.c cVar = new a.c();
            cVar.parseJson(new JSONObject(c0809a.WD));
            String str = c0809a.WC;
            switch (str.hashCode()) {
                case -1552949011:
                    if (str.equals("rewardVerifyCallback")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case -1228923142:
                    if (str.equals("adCloseCallback")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -402746255:
                    if (str.equals("videoPlayEndCallback")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 601135198:
                    if (str.equals("videoPlayErrorCallback")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 1620545720:
                    if (str.equals("videoPlayStartCallback")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1852274314:
                    if (str.equals("adClickCallback")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 1917267918:
                    if (str.equals("adSkipWithPlayTimeCallback")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    this.qp.oJ.bJ();
                    return;
                case 1:
                    this.qp.oJ.onVideoPlayStart();
                    return;
                case 2:
                    this.qp.oJ.onVideoPlayError(cVar.errorCode, cVar.WE);
                    return;
                case 3:
                    this.qp.oJ.onVideoPlayEnd();
                    return;
                case 4:
                    this.qp.oJ.onVideoSkipToEnd(cVar.WF);
                    return;
                case 5:
                    this.qp.oJ.h(cVar.WG);
                    return;
                case 6:
                    this.qp.oJ.onRewardVerify();
                    return;
                default:
                    return;
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.e("TKBasePresenter", "onOutCallback Error: " + th.getMessage());
        }
    }

    public void a(m mVar) {
        com.kwad.components.ad.reward.m.e eVar = this.qp.oK;
        if (eVar != null) {
            eVar.setAudioEnabled(!mVar.aba, true);
        }
    }

    public void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        this.qp.oJ.bJ();
    }

    public final void a(com.kwad.components.ad.reward.c.b bVar) {
        com.kwad.components.ad.reward.g gVar = this.qp;
        if (gVar != null) {
            gVar.b(bVar);
        }
    }

    public void a(o oVar) {
        this.wn = oVar;
        com.kwad.components.ad.reward.m.e eVar = this.qp.oK;
        if (eVar != null) {
            eVar.a(this.hq);
        }
        bo.runOnUiThread(new az() { // from class: com.kwad.components.ad.reward.presenter.f.d.4
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                boolean z;
                if (!com.kwad.components.core.s.a.as(d.this.getContext()).rA() && d.this.qp.mVideoPlayConfig.isVideoSoundEnable()) {
                    z = false;
                } else {
                    z = true;
                }
                m mVar = new m();
                mVar.aba = z;
                d.this.wn.c(mVar);
                if (d.this.qp.oK != null) {
                    d.this.qp.oK.setAudioEnabled(!z, false);
                }
            }
        });
    }

    public final void a(long j, long j2) {
        d(j, j2);
        g(j2);
    }

    @Override // com.kwad.components.core.webview.tachikoma.a.y.a
    public final void a(TKAdLiveShopItemInfo tKAdLiveShopItemInfo) {
        this.qp.mAdTemplate.tkLiveShopItemInfo = tKAdLiveShopItemInfo;
    }
}
