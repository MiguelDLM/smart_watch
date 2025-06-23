package com.kwad.sdk.core.b.a;

import com.kwad.sdk.n.k;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class jl implements com.kwad.sdk.core.d<k.a.C0872a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(k.a.C0872a c0872a, JSONObject jSONObject) {
        a2(c0872a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(k.a.C0872a c0872a, JSONObject jSONObject) {
        return b2(c0872a, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(k.a.C0872a c0872a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0872a.aUz = jSONObject.optString("s_cn");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(c0872a.aUz)) {
            c0872a.aUz = "";
        }
        c0872a.aUA = jSONObject.optString("s_mn");
        if (obj.toString().equals(c0872a.aUA)) {
            c0872a.aUA = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(k.a.C0872a c0872a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0872a.aUz;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "s_cn", c0872a.aUz);
        }
        String str2 = c0872a.aUA;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "s_mn", c0872a.aUA);
        }
        return jSONObject;
    }
}
