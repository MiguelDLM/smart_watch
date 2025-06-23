package com.kwad.components.ad.reward.presenter.h;

import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.k.a.d;
import com.kwad.components.ad.reward.m.e;
import com.kwad.components.ad.reward.presenter.f.g;
import com.kwad.components.ad.reward.presenter.i;
import com.kwad.components.core.l.a.b;
import com.kwad.components.core.proxy.c;
import com.kwad.components.core.video.l;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.b.v;
import com.kwad.components.core.webview.tachikoma.f;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.r;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.bj;
import com.kwad.sdk.utils.bo;

/* loaded from: classes11.dex */
public final class a extends g implements j {
    private AdInfo mAdInfo;
    private boolean tK;
    private boolean tL;
    private boolean wY;
    private f wZ;
    private d wl;
    private long xa;
    private g.b tM = new g.b() { // from class: com.kwad.components.ad.reward.presenter.h.a.1
        @Override // com.kwad.components.ad.reward.g.b
        public final boolean interceptPlayCardResume() {
            if (a.this.wE != null && a.this.wE.getVisibility() == 0) {
                return true;
            }
            return false;
        }
    };
    private final com.kwad.components.core.l.a.a so = new b() { // from class: com.kwad.components.ad.reward.presenter.h.a.2
        @Override // com.kwad.components.core.l.a.b, com.kwad.components.core.l.a.a
        public final void c(c cVar) {
            a.this.wY = false;
            if (a.this.wZ == null) {
                return;
            }
            v vVar = new v();
            if (com.kwad.components.core.q.a.rj().rp()) {
                com.kwad.components.core.q.a.rj().aM(false);
                if (com.kwad.sdk.core.response.b.a.aM(a.this.mAdInfo) == 0) {
                    vVar.abg = 1;
                    a.this.wZ.b(vVar);
                    return;
                } else if (com.kwad.components.core.q.a.rj().rl()) {
                    vVar.abg = 1;
                    a.this.wZ.b(vVar);
                    return;
                } else {
                    vVar.abg = 0;
                    a.this.wZ.b(vVar);
                    return;
                }
            }
            if (com.kwad.components.core.q.a.rj().rn() && com.kwad.sdk.core.response.b.a.aM(a.this.mAdInfo) == 1) {
                if (com.kwad.components.core.q.a.rj().ro() == 1) {
                    if (al.an(a.this.getContext(), com.kwad.sdk.core.response.b.a.ax(a.this.mAdInfo))) {
                        vVar.abg = 2;
                        com.kwad.components.core.q.a.rj().aI(2);
                        a.this.wZ.b(vVar);
                        return;
                    } else {
                        vVar.abg = 0;
                        a.this.wZ.b(vVar);
                        return;
                    }
                }
                if (com.kwad.components.core.q.a.rj().ro() == 3) {
                    vVar.abg = 1;
                    com.kwad.components.core.q.a.rj().aI(0);
                    a.this.wZ.b(vVar);
                }
            }
        }

        @Override // com.kwad.components.core.l.a.b, com.kwad.components.core.l.a.a
        public final void d(c cVar) {
            super.d(cVar);
            a.this.wY = true;
        }
    };
    private final l gO = new l() { // from class: com.kwad.components.ad.reward.presenter.h.a.3
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            long a2 = com.kwad.components.ad.reward.g.a(j, a.this.mAdInfo);
            long aL = com.kwad.sdk.core.response.b.a.aL(a.this.mAdInfo) * 1000;
            if (j2 <= a.this.xa || a2 - j2 <= aL || a.this.tK) {
                return;
            }
            if (com.kwad.sdk.core.response.b.a.aM(a.this.mAdInfo) == 1) {
                if (al.an(a.this.getContext(), com.kwad.sdk.core.response.b.a.ax(a.this.mAdInfo))) {
                    return;
                }
            } else if (a.this.qp.fP) {
                return;
            }
            a.b(a.this, true);
            a.this.wl.a(a.this.qp.getActivity(), a.this.qp.mAdResultData, a.this);
            a.this.jf();
        }
    };

    private void hx() {
        boolean x = i.x(this.qp);
        com.kwad.sdk.core.e.c.d("jky", "onPlayCompleted: " + x);
        if (x) {
            bo.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.h.a.6
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.qp.oJ != null) {
                        a.this.qp.oJ.onRewardVerify();
                    }
                    a.this.qp.oK.pause();
                    a.this.qp.fC();
                }
            }, 200L);
            return;
        }
        com.kwad.components.ad.reward.e.b bVar = this.qp.oJ;
        if (bVar != null) {
            bVar.onRewardVerify();
        }
        this.qp.oK.pause();
        this.qp.fC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jf() {
        this.wE.setVisibility(0);
        e eVar = this.qp.oK;
        if (eVar != null) {
            eVar.pause();
        }
        this.tL = true;
    }

    private f jg() {
        return new f() { // from class: com.kwad.components.ad.reward.presenter.h.a.5
            @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(aw awVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        getContext();
        if (!aj.ML()) {
            return;
        }
        this.wY = false;
        com.kwad.sdk.core.e.c.d("TkRewardVideoTaskPresenter", "onBind: ");
        if (this.wl == null) {
            this.wl = new d(this.qp, -1L, getContext(), new DialogInterface.OnDismissListener() { // from class: com.kwad.components.ad.reward.presenter.h.a.4
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.wZ == null) {
                        return;
                    }
                    v vVar = new v();
                    if (com.kwad.components.core.q.a.rj().rp()) {
                        com.kwad.components.core.q.a.rj().aM(false);
                        if (com.kwad.sdk.core.response.b.a.aM(a.this.mAdInfo) == 0) {
                            vVar.abg = 1;
                            a.this.wZ.b(vVar);
                            return;
                        } else if (com.kwad.components.core.q.a.rj().rl()) {
                            vVar.abg = 1;
                            a.this.wZ.b(vVar);
                            return;
                        } else {
                            vVar.abg = 0;
                            a.this.wZ.b(vVar);
                            return;
                        }
                    }
                    if (com.kwad.components.core.q.a.rj().rn() && com.kwad.sdk.core.response.b.a.aM(a.this.mAdInfo) == 1) {
                        if (com.kwad.components.core.q.a.rj().ro() == 1) {
                            if (!al.an(a.this.getContext(), com.kwad.sdk.core.response.b.a.ax(a.this.mAdInfo))) {
                                vVar.abg = 0;
                                a.this.wZ.b(vVar);
                                return;
                            }
                            return;
                        }
                        if (com.kwad.components.core.q.a.rj().ro() == 3) {
                            vVar.abg = 1;
                            com.kwad.components.core.q.a.rj().aI(0);
                            a.this.wZ.b(vVar);
                        }
                    }
                }
            });
        }
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dS(this.qp.mAdTemplate);
        this.xa = com.kwad.sdk.core.response.b.a.aK(r0) * 1000;
        e eVar = this.qp.oK;
        if (eVar != null) {
            eVar.a(this.gO);
        }
        this.qp.a(this.tM);
        this.qp.MU.add(this.so);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void bG() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_reward_task_card";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.ds(this.qp.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final com.kwad.sdk.widget.e getTouchCoordsView() {
        return this.qp.mRootContainer;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.g
    public final int hN() {
        return R.id.ksad_js_task;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        e eVar = this.qp.oK;
        if (eVar != null) {
            eVar.b(this.gO);
        }
        this.qp.b(this.tM);
        this.qp.MU.remove(this.so);
        d dVar = this.wl;
        if (dVar != null) {
            dVar.jq();
            this.wl = null;
        }
        this.wE.setVisibility(8);
        com.kwad.components.core.q.a.rj().clear();
        this.tK = false;
        this.tL = false;
        this.wY = false;
    }

    public static /* synthetic */ boolean b(a aVar, boolean z) {
        aVar.tK = true;
        return true;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void b(ac.a aVar) {
        float aW = com.kwad.sdk.c.a.a.aW(getContext());
        aVar.width = (int) ((bj.getScreenWidth(getContext()) / aW) + 0.5f);
        aVar.height = (int) ((bj.getScreenHeight(getContext()) / aW) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(m mVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        com.kwad.sdk.core.e.c.d("TkRewardVideoTaskPresenter", "onTkLoadFailed: ");
        this.wE.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(r rVar, com.kwad.sdk.core.webview.b bVar) {
        f jg = jg();
        this.wZ = jg;
        rVar.c(jg);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        this.qp.oJ.bJ();
        com.kwad.sdk.core.e.c.d("jky", "onAdClicked convertPageType: " + aVar.aFZ);
        if (com.kwad.sdk.core.response.b.a.aN(this.mAdInfo)) {
            com.kwad.components.core.q.a.rj().aH(aVar.aFZ);
            if (aVar.aFZ == -1) {
                com.kwad.components.core.q.a.rj().aM(false);
                com.kwad.components.core.q.a.rj().aI(0);
            } else {
                if (com.kwad.sdk.core.response.b.a.aE(this.mAdInfo)) {
                    if (com.kwad.components.core.q.a.rj().ro() == 2) {
                        com.kwad.components.core.q.a.rj().aI(3);
                        return;
                    } else {
                        com.kwad.components.core.q.a.rj().aI(1);
                        return;
                    }
                }
                com.kwad.components.core.q.a.rj().aM(true);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        boolean z = false;
        this.qp.pc = webCloseStatus != null && webCloseStatus.interactSuccess;
        int rk = com.kwad.components.core.q.a.rj().rk();
        com.kwad.components.ad.reward.g gVar = this.qp;
        e eVar = gVar.oK;
        if (eVar != null) {
            if (gVar.pc) {
                eVar.jK();
                if (rk == 1) {
                    hx();
                    z = true;
                }
            }
            if (this.tL && !this.wY && !z) {
                this.qp.oK.resume();
            }
        }
        this.wE.setVisibility(8);
    }
}
