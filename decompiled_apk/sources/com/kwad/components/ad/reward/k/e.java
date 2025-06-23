package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;

/* loaded from: classes11.dex */
public final class e implements com.kwad.sdk.core.webview.c.a {
    private a xg;

    /* loaded from: classes11.dex */
    public interface a {
        void iX();
    }

    public final void a(a aVar) {
        this.xg = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "clickGift";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.xg = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = this.xg;
        if (aVar != null) {
            aVar.iX();
        }
    }
}
