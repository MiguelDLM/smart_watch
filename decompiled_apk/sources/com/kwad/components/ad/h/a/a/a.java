package com.kwad.components.ad.h.a.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.webview.c.c;

/* loaded from: classes11.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {
    private c nt;

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull c cVar) {
        this.nt = cVar;
    }

    public final void eF() {
        c cVar = this.nt;
        if (cVar != null) {
            cVar.a(null);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerPlayStateResetListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.nt = null;
    }
}
