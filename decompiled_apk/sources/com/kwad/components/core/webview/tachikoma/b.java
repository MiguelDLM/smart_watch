package com.kwad.components.core.webview.tachikoma;

import androidx.annotation.NonNull;

/* loaded from: classes11.dex */
public final class b implements com.kwad.sdk.core.webview.c.a {
    private a Zb;

    /* loaded from: classes11.dex */
    public interface a {
        void dM();
    }

    public b(a aVar) {
        this.Zb = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = this.Zb;
        if (aVar != null) {
            aVar.dM();
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "cardImpression";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
