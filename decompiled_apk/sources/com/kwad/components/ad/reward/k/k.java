package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class k implements com.kwad.sdk.core.webview.c.a {
    private a xm;

    /* loaded from: classes11.dex */
    public interface a {
        void d(com.kwad.components.core.webview.tachikoma.b.q qVar);
    }

    public final void a(a aVar) {
        this.xm = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "showPlayEnd";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.xm = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (this.xm != null) {
            com.kwad.components.core.webview.tachikoma.b.q qVar = new com.kwad.components.core.webview.tachikoma.b.q();
            try {
                qVar.parseJson(new JSONObject(str));
                this.xm.d(qVar);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
