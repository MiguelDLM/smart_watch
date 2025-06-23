package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;

/* loaded from: classes11.dex */
public class c implements com.kwad.sdk.core.webview.c.a {
    private a xe;

    /* loaded from: classes11.dex */
    public interface a {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        iY();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "callButtonImpressionWhenPlay";
    }

    public void iY() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.xe = null;
    }
}
