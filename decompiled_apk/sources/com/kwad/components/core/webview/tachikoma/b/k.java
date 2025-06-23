package com.kwad.components.core.webview.tachikoma.b;

import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class k extends com.kwad.sdk.core.response.a.a {
    public int aaW;
    public int aaX = -1;
    public int aaY;

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.t.putValue(jSONObject, "insertScreenAdShowStrategy", this.aaW);
        com.kwad.sdk.utils.t.putValue(jSONObject, "isAutoShow", this.aaY);
        int i = this.aaX;
        if (i != -1) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "triggerType", i);
        }
        return jSONObject;
    }
}
