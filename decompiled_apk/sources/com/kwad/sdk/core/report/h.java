package com.kwad.sdk.core.report;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;

@KsJson
/* loaded from: classes11.dex */
public class h extends com.kwad.sdk.core.response.a.a {
    public int ayS;
    public long creativeId;
    public long llsid;
    public int score;
    public String source = "union";

    public static h bY(AdTemplate adTemplate) {
        int i;
        h hVar = new h();
        hVar.creativeId = com.kwad.sdk.core.response.b.e.ec(adTemplate);
        hVar.llsid = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        int eg = com.kwad.sdk.core.response.b.e.eg(adTemplate);
        hVar.score = eg;
        if (eg > 0) {
            i = 1;
        } else {
            i = 0;
        }
        hVar.ayS = i;
        return hVar;
    }

    public final String Fv() {
        return toJson().toString();
    }
}
