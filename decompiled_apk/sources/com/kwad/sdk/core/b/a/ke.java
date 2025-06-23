package com.kwad.sdk.core.b.a;

import com.kwad.sdk.commercial.j.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class ke implements com.kwad.sdk.core.d<a.C0843a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0843a c0843a, JSONObject jSONObject) {
        a2(c0843a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0843a c0843a, JSONObject jSONObject) {
        return b2(c0843a, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.C0843a c0843a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0843a.apS = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("blackList");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                c0843a.apS.add((String) optJSONArray.opt(i));
            }
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0843a c0843a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "blackList", c0843a.apS);
        return jSONObject;
    }
}
