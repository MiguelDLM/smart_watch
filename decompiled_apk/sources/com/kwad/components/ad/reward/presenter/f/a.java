package com.kwad.components.ad.reward.presenter.f;

import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.v;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.b.x;
import com.kwad.sdk.components.r;

/* loaded from: classes11.dex */
public abstract class a extends d {
    private o we;

    @Override // com.kwad.components.ad.reward.presenter.f.d
    public final boolean iN() {
        return true;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
        this.we = oVar;
        oVar.a(new o.a() { // from class: com.kwad.components.ad.reward.presenter.f.a.1
            @Override // com.kwad.components.core.webview.tachikoma.a.o.a
            public final boolean isMuted() {
                boolean z;
                if (!com.kwad.sdk.core.config.d.gt() && com.kwad.components.core.s.a.as(a.this.getContext()).rA()) {
                    z = true;
                } else {
                    z = false;
                }
                if (a.this.qp.mVideoPlayConfig.isVideoSoundEnable() && !z) {
                    return false;
                }
                return true;
            }
        });
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void b(ac.a aVar) {
        float aW = com.kwad.sdk.c.a.a.aW(getContext());
        float screenHeight = com.kwad.sdk.c.a.a.getScreenHeight(getContext());
        aVar.width = (int) ((com.kwad.sdk.c.a.a.getScreenWidth(getContext()) / aW) + 0.5f);
        aVar.height = (int) ((screenHeight / aW) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public void a(r rVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(rVar, bVar);
        rVar.c(new v() { // from class: com.kwad.components.ad.reward.presenter.f.a.2
            @Override // com.kwad.components.core.webview.jshandler.v
            public final void a(x xVar) {
                super.a(xVar);
                a.this.qp.oJ.onVideoPlayStart();
                com.kwad.components.ad.reward.monitor.c.b(a.this.qp.oZ, a.this.qp.mAdTemplate, a.this.qp.mPageEnterTime);
            }

            @Override // com.kwad.components.core.webview.jshandler.v
            public final void b(x xVar) {
                super.b(xVar);
                long ty = xVar.ty();
                a.this.qp.oJ.onVideoPlayError(xVar.errorCode, (int) ty);
                com.kwad.components.ad.reward.monitor.c.a(a.this.qp.oZ, a.this.qp.mAdTemplate, a.this.qp.pw, xVar.errorCode, ty);
                com.kwad.components.ad.reward.monitor.b.c(a.this.qp.oZ, a.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.webview.jshandler.v
            public final void c(x xVar) {
                super.c(xVar);
                a.this.qp.oJ.onVideoPlayEnd();
                a.this.qp.mAdTemplate.setmCurPlayTime(-1L);
                com.kwad.components.ad.reward.presenter.f.s(a.this.qp);
                if (xVar.tw()) {
                    com.kwad.components.ad.reward.g unused = a.this.qp;
                    com.kwad.components.ad.reward.g.a(a.this.qp.oS, new com.kwad.sdk.f.a<com.kwad.components.ad.reward.k.a>() { // from class: com.kwad.components.ad.reward.presenter.f.a.2.1
                        /* JADX INFO: Access modifiers changed from: private */
                        @Override // com.kwad.sdk.f.a
                        /* renamed from: c, reason: merged with bridge method [inline-methods] */
                        public void accept(com.kwad.components.ad.reward.k.a aVar) {
                            com.kwad.components.ad.reward.g unused2 = a.this.qp;
                            aVar.iL();
                        }
                    });
                }
            }

            @Override // com.kwad.components.core.webview.jshandler.v
            public final void d(x xVar) {
                super.d(xVar);
                a.this.qp.mAdTemplate.setmCurPlayTime(xVar.nF);
            }
        });
    }
}
