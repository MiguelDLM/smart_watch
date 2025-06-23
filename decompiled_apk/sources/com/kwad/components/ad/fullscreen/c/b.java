package com.kwad.components.ad.fullscreen.c;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.RewardRenderResult;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.d;
import com.kwad.components.ad.reward.presenter.f.h;
import com.kwad.components.ad.reward.presenter.j;
import com.kwad.components.ad.reward.presenter.k;
import com.kwad.components.ad.reward.presenter.l;
import com.kwad.components.ad.reward.presenter.m;
import com.kwad.components.ad.reward.presenter.r;
import com.kwad.components.ad.reward.presenter.v;
import com.kwad.components.core.e.e.f;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.e.e;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.aj;

/* loaded from: classes11.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements g, f {
    private com.kwad.components.ad.fullscreen.b gR;
    private ViewGroup gS;
    private com.kwad.components.core.l.b gT;

    @Nullable
    private r gU;
    private FrameLayout gV;
    private com.kwad.components.ad.reward.presenter.f.b gW;
    private e gX;

    @Nullable
    private com.kwad.components.ad.reward.presenter.e.a gY;
    private com.kwad.components.ad.reward.presenter.f.f gZ;
    private boolean ha = false;

    public b(com.kwad.components.core.l.b bVar, ViewGroup viewGroup, com.kwad.components.ad.fullscreen.b bVar2, com.kwad.components.ad.reward.g gVar) {
        this.gT = bVar;
        this.gR = bVar2;
        this.gS = viewGroup;
        this.qp = gVar;
        bP();
    }

    private void bP() {
        if (this.gR == null) {
            return;
        }
        bU();
        AdInfo bH = this.gR.bH();
        boolean cX = com.kwad.sdk.core.response.b.a.cX(bH);
        boolean ec = com.kwad.sdk.core.response.b.b.ec(bH);
        if (cX) {
            this.qp.a(RewardRenderResult.LIVE_TK);
            com.kwad.components.core.webview.tachikoma.d.b.tG().a(bV());
            bR();
        } else if (ec) {
            com.kwad.components.core.webview.tachikoma.d.b.tG().a(bV());
            this.qp.a(RewardRenderResult.TK_IMAGE);
            bS();
        } else if (a(this.qp)) {
            this.qp.a(RewardRenderResult.FULLSCREEN_TK);
            bT();
            com.kwad.components.core.webview.tachikoma.d.b.tG().a(bV());
        } else {
            this.qp.a(RewardRenderResult.DEFAULT);
            bQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQ() {
        boolean z;
        com.kwad.components.core.webview.tachikoma.d.b.tG().b(this.gX);
        com.kwad.components.core.e.e.g.oQ().a(this);
        AdTemplate adTemplate = this.gR.getAdTemplate();
        AdInfo bH = this.gR.bH();
        if (this.gR.bI() && !aj.isOrientationPortrait()) {
            z = true;
        } else {
            z = false;
        }
        if (this.gR.gt) {
            a(this);
        }
        a(new v(), true);
        if (com.kwad.sdk.core.response.b.a.aO(bH)) {
            a(new d(), true);
        }
        a(new m(), true);
        a(new com.kwad.components.ad.reward.presenter.platdetail.c(), true);
        if (com.kwad.sdk.core.response.b.b.dn(bH)) {
            a(new h(), true);
        }
        if (!z) {
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.c(), true);
        }
        a(new com.kwad.components.ad.reward.presenter.c.a(), true);
        if (com.kwad.sdk.core.response.b.b.di(adTemplate)) {
            a(new com.kwad.components.ad.fullscreen.c.a.f(), true);
        }
        if (com.kwad.sdk.core.response.b.a.bc(bH)) {
            a(new com.kwad.components.ad.reward.presenter.platdetail.b(), true);
        }
        a(new l(), true);
        if (com.kwad.sdk.core.response.b.a.cM(bH)) {
            a(new com.kwad.components.ad.reward.presenter.b.c(), true);
            a(new com.kwad.components.ad.reward.presenter.b.b(), true);
            a(new k(), true);
            a(new com.kwad.components.ad.reward.presenter.b.a(), true);
        }
        r rVar = new r(adTemplate, false, false);
        this.gU = rVar;
        a((Presenter) rVar, true);
        a(new c(), true);
        a(new a(), true);
        a(new com.kwad.components.ad.reward.presenter.d.b(adTemplate, false), true);
        a(new com.kwad.components.ad.reward.presenter.e(bH, this.gS), true);
        a(new j(), true);
    }

    private void bR() {
        com.kwad.components.ad.fullscreen.c.c.c cVar = new com.kwad.components.ad.fullscreen.c.c.c();
        this.gW = cVar;
        a(cVar);
    }

    private void bS() {
        com.kwad.components.ad.fullscreen.c.c.a aVar = new com.kwad.components.ad.fullscreen.c.c.a();
        this.gZ = aVar;
        a(aVar);
    }

    private void bT() {
        a((Presenter) new com.kwad.components.ad.fullscreen.c.c.b(), true);
    }

    private void bU() {
        AdInfo bH = this.gR.bH();
        if (!this.gR.gt) {
            a(this);
        }
        if (com.kwad.sdk.core.response.b.b.dZ(bH) && aj.isOrientationPortrait()) {
            com.kwad.components.ad.reward.presenter.e.a aVar = new com.kwad.components.ad.reward.presenter.e.a();
            this.gY = aVar;
            a((Presenter) aVar, true);
        }
    }

    private e bV() {
        if (this.gX == null) {
            this.gX = new e() { // from class: com.kwad.components.ad.fullscreen.c.b.1
                @Override // com.kwad.components.core.webview.tachikoma.e.e
                public final void a(String str, long j, long j2, long j3) {
                    b.this.qp.jY = true;
                }

                @Override // com.kwad.components.core.webview.tachikoma.e.b
                public final void q(String str) {
                    if (!"tk_fullscreen".equals(str) && !"tk_live_video".equals(str)) {
                        if ("tk_image_video".equals(str)) {
                            b bVar = b.this;
                            bVar.a(bVar);
                            b.this.qp.a(RewardRenderResult.DEFAULT);
                            b.this.bQ();
                            return;
                        }
                        return;
                    }
                    b bVar2 = b.this;
                    bVar2.a(bVar2);
                    com.kwad.components.ad.reward.g.a(b.this.getContext(), b.this.qp, b.this.bW());
                    b.this.bQ();
                }
            };
        }
        return this.gX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout bW() {
        if (this.gV == null) {
            this.gV = (FrameLayout) this.gS.findViewById(R.id.ksad_reward_play_layout);
        }
        return this.gV;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.qp.b(this);
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void bL() {
        this.qp.C(true);
    }

    @Override // com.kwad.components.core.e.e.f
    public final void dismiss() {
        this.qp.D(false);
        this.qp.fv();
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    public final boolean onBackPressed() {
        r rVar = this.gU;
        if (rVar != null && rVar.onBackPressed()) {
            return true;
        }
        com.kwad.components.ad.reward.presenter.e.a aVar = this.gY;
        if (aVar != null && aVar.go() == BackPressHandleResult.HANDLED) {
            return true;
        }
        com.kwad.components.ad.reward.presenter.f.b bVar = this.gW;
        if (bVar != null && bVar.go() == BackPressHandleResult.HANDLED) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.gV = (FrameLayout) this.gS.findViewById(R.id.ksad_reward_play_layout);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qp.c(this);
        com.kwad.components.core.e.e.g.oQ().b(this);
        com.kwad.components.core.webview.tachikoma.d.b.tG().b(this.gX);
    }

    @Override // com.kwad.components.core.e.e.f
    public final void show() {
        this.qp.fw();
        this.qp.D(true);
    }

    private static boolean a(com.kwad.components.ad.reward.g gVar) {
        if (!com.kwad.sdk.core.config.d.CE()) {
            com.kwad.components.ad.reward.monitor.b.a(gVar.mAdTemplate, TKRenderFailReason.SWITCH_CLOSE);
            return false;
        }
        if (com.kwad.sdk.core.response.b.a.bc(com.kwad.sdk.core.response.b.e.dS(gVar.mAdTemplate))) {
            return false;
        }
        AdMatrixInfo.FullScreenInfo de = com.kwad.sdk.core.response.b.b.de(gVar.mAdTemplate);
        if (de != null && de.renderType == 1) {
            return true;
        }
        com.kwad.components.ad.reward.monitor.b.a(gVar.mAdTemplate, TKRenderFailReason.TK_FILE_LOAD_ERROR);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (this.ha) {
            return;
        }
        bVar.a((Presenter) new com.kwad.components.ad.reward.presenter.a(this.qp), true);
        this.ha = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(g gVar) {
        return getPriority() - gVar.getPriority();
    }
}
