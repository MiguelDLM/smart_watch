package com.kwad.sdk.core.b.a;

import com.kwad.sdk.i.a;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class il implements com.kwad.sdk.core.d<a.C0867a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0867a c0867a, JSONObject jSONObject) {
        a2(c0867a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0867a c0867a, JSONObject jSONObject) {
        return b2(c0867a, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.C0867a c0867a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0867a.aKM = jSONObject.optInt("ds");
        c0867a.sdkVersion = jSONObject.optString("sv");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(c0867a.sdkVersion)) {
            c0867a.sdkVersion = "";
        }
        c0867a.aGE = jSONObject.optString("spv");
        if (obj.toString().equals(c0867a.aGE)) {
            c0867a.aGE = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0867a c0867a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c0867a.aKM;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ds", i);
        }
        String str = c0867a.sdkVersion;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sv", c0867a.sdkVersion);
        }
        String str2 = c0867a.aGE;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "spv", c0867a.aGE);
        }
        return jSONObject;
    }
}
