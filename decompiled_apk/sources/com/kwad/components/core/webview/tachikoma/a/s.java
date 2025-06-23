package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class s implements com.kwad.sdk.core.webview.c.a {
    private a aaC;

    /* loaded from: classes11.dex */
    public interface a {
        void a(com.kwad.components.core.webview.tachikoma.b.s sVar);
    }

    public final void a(a aVar) {
        this.aaC = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "showToast";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.aaC = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (this.aaC != null) {
            com.kwad.components.core.webview.tachikoma.b.s sVar = new com.kwad.components.core.webview.tachikoma.b.s();
            try {
                sVar.parseJson(new JSONObject(str));
                this.aaC.a(sVar);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
