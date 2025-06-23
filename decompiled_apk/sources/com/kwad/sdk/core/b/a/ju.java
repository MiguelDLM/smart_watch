package com.kwad.sdk.core.b.a;

import com.kwad.sdk.m.a.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class ju implements com.kwad.sdk.core.d<a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.name = jSONObject.optString("name");
        if (JSONObject.NULL.toString().equals(bVar.name)) {
            bVar.name = "";
        }
        bVar.aON = jSONObject.optBoolean("isStatic");
        bVar.aOO = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("paramList");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                a.C0870a c0870a = new a.C0870a();
                c0870a.parseJson(optJSONArray.optJSONObject(i));
                bVar.aOO.add(c0870a);
            }
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.name;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "name", bVar.name);
        }
        boolean z = bVar.aON;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isStatic", z);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "paramList", bVar.aOO);
        return jSONObject;
    }
}
