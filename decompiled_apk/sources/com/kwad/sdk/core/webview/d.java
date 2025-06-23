package com.kwad.sdk.core.webview;

import com.kwad.sdk.core.webview.a.c;

/* loaded from: classes11.dex */
public final class d {
    private long aFi;
    private boolean aFj;

    public static void d(c.a aVar) {
        if (aVar != null) {
            com.kwad.sdk.core.adlog.c.b(aVar.getAdTemplate(), aVar.ok());
        }
    }

    public final void a(c.a aVar) {
        if (aVar != null) {
            com.kwad.sdk.core.adlog.c.a(aVar.getAdTemplate(), aVar.ok());
        }
        if (aVar != null) {
            this.aFi = System.currentTimeMillis();
        }
    }

    public final void b(c.a aVar) {
        if (aVar != null) {
            com.kwad.sdk.core.adlog.c.k(aVar.getAdTemplate(), System.currentTimeMillis() - this.aFi);
        }
    }

    public final void c(c.a aVar) {
        if (aVar != null && !this.aFj) {
            this.aFj = true;
            long j = 0;
            if (this.aFi > 0) {
                j = System.currentTimeMillis() - this.aFi;
                this.aFi = -1L;
            }
            com.kwad.sdk.core.adlog.c.a(aVar.getAdTemplate(), aVar.ok(), j);
        }
    }
}
