package com.kwad.sdk.core.b.a;

import com.kwad.sdk.m.a.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class hi implements com.kwad.sdk.core.d<a.C0870a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0870a c0870a, JSONObject jSONObject) {
        a2(c0870a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0870a c0870a, JSONObject jSONObject) {
        return b2(c0870a, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.C0870a c0870a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0870a.aOG = jSONObject.optString("typeStr");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(c0870a.aOG)) {
            c0870a.aOG = "";
        }
        c0870a.aOH = jSONObject.optString("valueStr");
        if (obj.toString().equals(c0870a.aOH)) {
            c0870a.aOH = "";
        }
        c0870a.aOI = jSONObject.optString("listValueType");
        if (obj.toString().equals(c0870a.aOI)) {
            c0870a.aOI = "";
        }
        c0870a.aOJ = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("valueStrList");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                c0870a.aOJ.add((String) optJSONArray.opt(i));
            }
        }
        c0870a.fieldName = jSONObject.optString("fieldName");
        Object obj2 = JSONObject.NULL;
        if (obj2.toString().equals(c0870a.fieldName)) {
            c0870a.fieldName = "";
        }
        c0870a.className = jSONObject.optString("className");
        if (obj2.toString().equals(c0870a.className)) {
            c0870a.className = "";
        }
        c0870a.aOK = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("childParamList");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                a.C0870a c0870a2 = new a.C0870a();
                c0870a2.parseJson(optJSONArray2.optJSONObject(i2));
                c0870a.aOK.add(c0870a2);
            }
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0870a c0870a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0870a.aOG;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "typeStr", c0870a.aOG);
        }
        String str2 = c0870a.aOH;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "valueStr", c0870a.aOH);
        }
        String str3 = c0870a.aOI;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "listValueType", c0870a.aOI);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "valueStrList", c0870a.aOJ);
        String str4 = c0870a.fieldName;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "fieldName", c0870a.fieldName);
        }
        String str5 = c0870a.className;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "className", c0870a.className);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "childParamList", c0870a.aOK);
        return jSONObject;
    }
}
