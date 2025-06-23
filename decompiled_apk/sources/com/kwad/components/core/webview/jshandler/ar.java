package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;

/* loaded from: classes11.dex */
public final class ar implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c WI;
    private a Yx = new a();

    @KsJson
    /* loaded from: classes11.dex */
    public class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public int id;
        public int status;

        public a() {
        }
    }

    private void r(int i, int i2) {
        com.kwad.sdk.core.webview.c.c cVar = this.WI;
        if (cVar != null) {
            a aVar = this.Yx;
            aVar.id = i;
            aVar.status = 2;
            cVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.WI = cVar;
    }

    public final void aP(int i) {
        r(1, 2);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerAnimationListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.WI = null;
    }
}
