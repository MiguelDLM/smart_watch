package com.kwad.sdk.m.b.a;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.t;
import java.util.List;
import org.json.JSONObject;

@KsJson
/* loaded from: classes11.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public int aBY;
    public List<a> aOQ;

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        for (a aVar : this.aOQ) {
            t.putValue(jSONObject, aVar.key, aVar.value);
        }
        t.putValue(jSONObject, "func_ratio_count", this.aBY);
        JSONObject jSONObject2 = new JSONObject();
        t.putValue(jSONObject2, "ranger", jSONObject);
        return jSONObject2;
    }
}
