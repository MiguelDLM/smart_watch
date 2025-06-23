package com.kwad.components.ad.reward.presenter.f;

import com.kwad.components.ad.reward.g;
import com.kwad.components.core.webview.jshandler.aw;

/* loaded from: classes11.dex */
public final class e implements g.a {
    private aw wA;
    private boolean wB;
    private boolean wC;

    private void iZ() {
        aw awVar = this.wA;
        if (awVar != null && this.wC) {
            if (!this.wB) {
                awVar.sV();
                this.wA.sW();
                this.wB = true;
                return;
            }
            awVar.sZ();
        }
    }

    public final void b(aw awVar) {
        this.wA = awVar;
    }

    public final void bF() {
        iZ();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void fV() {
        this.wC = true;
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void fW() {
        this.wC = true;
        iZ();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void fX() {
        this.wC = false;
        aw awVar = this.wA;
        if (awVar != null) {
            awVar.ta();
        }
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void fY() {
        this.wC = false;
    }

    public final void ja() {
        aw awVar = this.wA;
        if (awVar != null) {
            awVar.sX();
            this.wA.sY();
        }
    }

    public final void y(com.kwad.components.ad.reward.g gVar) {
        gVar.a(this);
    }

    public final void z(com.kwad.components.ad.reward.g gVar) {
        aw awVar = this.wA;
        if (awVar != null) {
            awVar.sX();
            this.wA.sY();
        }
        gVar.b(this);
    }
}
