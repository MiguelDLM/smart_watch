package com.kwad.components.ad.reward.k.a;

import com.kwad.components.ad.reward.g;

/* loaded from: classes11.dex */
public final class a extends com.kwad.components.core.webview.tachikoma.c.b {
    private g xr;

    public a(g gVar) {
        this.xr = gVar;
    }

    public final void b(com.kwad.components.ad.reward.c.b bVar) {
        com.kwad.components.ad.reward.c.a.gM().a(this.mAdTemplate, bVar);
    }

    public final g jj() {
        return this.xr;
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.b, com.kwad.sdk.mvp.a
    public final void release() {
        super.release();
        this.xr = null;
    }
}
