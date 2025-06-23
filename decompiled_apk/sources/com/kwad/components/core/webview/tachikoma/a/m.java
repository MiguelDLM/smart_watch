package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;

/* loaded from: classes11.dex */
public final class m extends w {
    @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        super.a(str, cVar);
    }

    public final void aT(int i) {
        com.kwad.components.core.webview.tachikoma.b.u uVar = new com.kwad.components.core.webview.tachikoma.b.u();
        uVar.nF = i;
        super.b(uVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerSplashProgressListener";
    }
}
