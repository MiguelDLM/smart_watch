package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class w implements com.kwad.sdk.core.webview.c.a {
    private List<AdTemplate> Xb;
    private com.kwad.sdk.core.webview.b cO;
    private b oE;

    @KsJson
    /* loaded from: classes11.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public long creativeId = -1;
        public int adStyle = -1;
    }

    /* loaded from: classes11.dex */
    public interface b {
        void N(AdTemplate adTemplate);
    }

    public w(List<AdTemplate> list) {
        this.Xb = list;
    }

    private List<AdTemplate> sR() {
        List<AdTemplate> list = this.Xb;
        if (list != null) {
            return list;
        }
        com.kwad.sdk.core.webview.b bVar = this.cO;
        if (bVar != null) {
            return bVar.Hw();
        }
        return null;
    }

    public final void a(b bVar) {
        this.oE = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "adImpression";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            AdTemplate a2 = com.kwad.sdk.core.response.b.e.a(sR(), aVar.creativeId, aVar.adStyle);
            b bVar = this.oE;
            if (bVar != null) {
                bVar.N(a2);
            }
        } catch (JSONException unused) {
        }
    }

    public w(com.kwad.sdk.core.webview.b bVar) {
        this.cO = bVar;
    }
}
