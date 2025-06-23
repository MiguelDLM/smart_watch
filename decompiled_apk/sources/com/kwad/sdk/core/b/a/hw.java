package com.kwad.sdk.core.b.a;

import XIXIX.OOXIXo;
import com.kwad.sdk.m.c;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class hw implements com.kwad.sdk.core.d<com.kwad.sdk.m.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.m.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.m.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.m.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.funcSwitch = jSONObject.optLong("funcSwitch");
        cVar.aOr = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("urlList");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                cVar.aOr.add((String) optJSONArray.opt(i));
            }
        }
        cVar.aOs = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("actConfigList");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                c.a aVar = new c.a();
                aVar.parseJson(optJSONArray2.optJSONObject(i2));
                cVar.aOs.add(aVar);
            }
        }
        cVar.byteCount = jSONObject.optLong("byteCount");
        cVar.sampleRate = jSONObject.optDouble("sampleRate");
        cVar.aOt = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("anchorNodeList");
        if (optJSONArray3 != null) {
            for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                com.kwad.sdk.m.a.a aVar2 = new com.kwad.sdk.m.a.a();
                aVar2.parseJson(optJSONArray3.optJSONObject(i3));
                cVar.aOt.add(aVar2);
            }
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.m.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = cVar.funcSwitch;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "funcSwitch", j);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "urlList", cVar.aOr);
        com.kwad.sdk.utils.t.putValue(jSONObject, "actConfigList", cVar.aOs);
        long j2 = cVar.byteCount;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "byteCount", j2);
        }
        double d = cVar.sampleRate;
        if (d != OOXIXo.f3760XO) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sampleRate", d);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "anchorNodeList", cVar.aOt);
        return jSONObject;
    }
}
