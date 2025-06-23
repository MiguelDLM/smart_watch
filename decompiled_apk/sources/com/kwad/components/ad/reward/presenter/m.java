package com.kwad.components.ad.reward.presenter;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: classes11.dex */
public final class m extends b {
    private long hj;

    @NonNull
    private com.kwad.components.ad.reward.e.b oJ;
    private com.kwad.components.core.video.l sv;
    private com.kwad.components.core.video.l sw = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.m.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            m mVar = m.this;
            com.kwad.components.ad.reward.g gVar = mVar.qp;
            if (gVar.oZ && gVar.pe) {
                mVar.oJ.onVideoSkipToEnd(m.this.hj);
            } else {
                gVar.px = true;
                mVar.oJ.onVideoPlayEnd();
            }
            AdInfo dS = com.kwad.sdk.core.response.b.e.dS(m.this.qp.mAdTemplate);
            if (!com.kwad.sdk.core.response.b.a.aN(dS) || com.kwad.sdk.core.response.b.a.aM(dS) != 1) {
                f.s(m.this.qp);
                com.kwad.components.ad.reward.g gVar2 = m.this.qp;
                if (gVar2.px) {
                    com.kwad.components.ad.reward.k.h(gVar2);
                }
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            m mVar = m.this;
            com.kwad.components.ad.reward.g gVar = mVar.qp;
            gVar.pw = j2;
            if (!gVar.pe) {
                mVar.hj = j2;
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            m.this.oJ.onVideoPlayStart();
            m.this.qp.px = false;
        }
    };
    private final com.kwad.components.core.video.l gO = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.m.2
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            m mVar = m.this;
            if (mVar.qp.pe) {
                mVar.oJ.onVideoSkipToEnd(m.this.hj);
            } else {
                mVar.oJ.onVideoPlayEnd();
            }
            AdInfo dS = com.kwad.sdk.core.response.b.e.dS(m.this.qp.mAdTemplate);
            if (!com.kwad.sdk.core.response.b.a.aN(dS) || com.kwad.sdk.core.response.b.a.aM(dS) != 1) {
                f.s(m.this.qp);
                com.kwad.components.ad.reward.g gVar = m.this.qp;
                if (gVar.px) {
                    com.kwad.components.ad.reward.k.h(gVar);
                }
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i, int i2) {
            m.this.oJ.onVideoPlayError(i, i2);
            m.this.hq();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            boolean z;
            m mVar = m.this;
            com.kwad.components.ad.reward.g gVar = mVar.qp;
            gVar.pw = j2;
            if (j - j2 < 800) {
                z = true;
            } else {
                z = false;
            }
            gVar.px = z;
            if (!gVar.pe) {
                mVar.hj = j2;
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            m.this.oJ.onVideoPlayStart();
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.components.ad.reward.g gVar = this.qp;
        gVar.pw = 0L;
        gVar.px = false;
        this.oJ = gVar.oJ;
        if (gVar.oK.jN()) {
            this.sv = this.sw;
        } else {
            this.sv = this.gO;
        }
        this.qp.oK.a(this.sv);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qp.oK.b(this.sv);
    }
}
