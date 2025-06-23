package com.kwad.sdk.core.b.a;

import com.kwad.sdk.m.a.a;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class az implements com.kwad.sdk.core.d<com.kwad.sdk.m.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.m.a.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.m.a.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.m.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aOA = jSONObject.optString("nodeClassName");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.aOA)) {
            aVar.aOA = "";
        }
        aVar.aOB = jSONObject.optString("childFieldName");
        if (obj.toString().equals(aVar.aOB)) {
            aVar.aOB = "";
        }
        aVar.aOC = jSONObject.optBoolean("childFieldIsStatic");
        aVar.aOD = jSONObject.optString("reportKey");
        if (obj.toString().equals(aVar.aOD)) {
            aVar.aOD = "";
        }
        a.b bVar = new a.b();
        aVar.aOE = bVar;
        bVar.parseJson(jSONObject.optJSONObject("childMethod"));
        com.kwad.sdk.m.a.a aVar2 = new com.kwad.sdk.m.a.a();
        aVar.aOF = aVar2;
        aVar2.parseJson(jSONObject.optJSONObject("deepNode"));
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.m.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.aOA;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "nodeClassName", aVar.aOA);
        }
        String str2 = aVar.aOB;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "childFieldName", aVar.aOB);
        }
        boolean z = aVar.aOC;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "childFieldIsStatic", z);
        }
        String str3 = aVar.aOD;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "reportKey", aVar.aOD);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "childMethod", aVar.aOE);
        com.kwad.sdk.utils.t.a(jSONObject, "deepNode", aVar.aOF);
        return jSONObject;
    }
}
