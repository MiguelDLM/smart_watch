package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.webview.tachikoma.a.w;

/* loaded from: classes11.dex */
public final class n extends w {

    @KsJson
    /* loaded from: classes11.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int status;
    }

    public final void Z(boolean z) {
        a aVar = new a();
        aVar.status = z ? 1 : 0;
        b(aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerNeoStatusListener";
    }
}
