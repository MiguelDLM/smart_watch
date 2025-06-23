package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;

/* loaded from: classes11.dex */
public final class au implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c WI;

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.WI = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerDeeplinkListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.WI = null;
    }

    public final void onFailed() {
        com.kwad.sdk.core.webview.c.c cVar = this.WI;
        if (cVar != null) {
            cVar.onError(-1, "deep link error");
        }
    }

    public final void onSuccess() {
        com.kwad.sdk.core.webview.c.c cVar = this.WI;
        if (cVar != null) {
            cVar.a(null);
        }
    }
}
