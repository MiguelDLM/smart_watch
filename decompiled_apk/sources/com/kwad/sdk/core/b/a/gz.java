package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class gz implements com.kwad.sdk.core.d<com.kwad.components.core.n.c.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.n.c.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.n.c.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.n.c.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.Ot = jSONObject.optString("load_module");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.Ot)) {
            bVar.Ot = "";
        }
        bVar.Ou = jSONObject.optLong("load_status");
        bVar.Ov = jSONObject.optLong("load_duration_ms");
        bVar.Ow = jSONObject.optLong("thread_core_size", new Long("0").longValue());
        bVar.f18455Ox = jSONObject.optString("load_source");
        if (obj.toString().equals(bVar.f18455Ox)) {
            bVar.f18455Ox = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.n.c.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.Ot;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_module", bVar.Ot);
        }
        long j = bVar.Ou;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_status", j);
        }
        long j2 = bVar.Ov;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_duration_ms", j2);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "thread_core_size", bVar.Ow);
        String str2 = bVar.f18455Ox;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_source", bVar.f18455Ox);
        }
        return jSONObject;
    }
}
