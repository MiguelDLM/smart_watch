package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.commercial.model.WebViewCommercialMsg;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class z implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.b WQ;

    public z() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        AdTemplate adTemplate;
        try {
            com.kwad.sdk.core.e.c.d("CommercialLogHandler", "handleJsCall : " + str);
            com.kwad.sdk.core.webview.b bVar = this.WQ;
            WebViewCommercialMsg webViewCommercialMsg = new WebViewCommercialMsg((bVar == null || (adTemplate = bVar.getAdTemplate()) == null) ? null : com.kwad.sdk.core.response.b.e.dS(adTemplate));
            webViewCommercialMsg.parseJson(new JSONObject(str));
            a(webViewCommercialMsg);
            cVar.a(null);
        } catch (JSONException e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
            cVar.onError(-1, e.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "commercialLog";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public z(com.kwad.sdk.core.webview.b bVar) {
        this.WQ = bVar;
    }

    private static void a(@NonNull WebViewCommercialMsg webViewCommercialMsg) {
        com.kwad.sdk.core.e.c.d("CommercialLogHandler", "handleH5Log actionType actionType" + webViewCommercialMsg.category);
        com.kwad.sdk.commercial.b.a(webViewCommercialMsg.category, webViewCommercialMsg);
    }
}
