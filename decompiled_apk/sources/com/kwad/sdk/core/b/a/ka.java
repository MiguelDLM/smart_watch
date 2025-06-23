package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class ka implements com.kwad.sdk.core.d<com.kwad.sdk.core.threads.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aBP = jSONObject.optString("pool_name");
        if (JSONObject.NULL.toString().equals(bVar.aBP)) {
            bVar.aBP = "";
        }
        bVar.aBQ = jSONObject.optInt("core_pool_size");
        bVar.aBR = jSONObject.optInt("max_pool_size");
        bVar.aBS = jSONObject.optInt("current_pool_size");
        bVar.aBT = jSONObject.optInt("active_count");
        bVar.aBU = jSONObject.optLong("task_wait_avg_ms");
        bVar.aBV = jSONObject.optLong("task_succ_count");
        bVar.interval = jSONObject.optLong("interval_ms");
        bVar.aBW = jSONObject.optInt("queue_size");
        bVar.aBX = jSONObject.optLong("pass_timestamp");
        bVar.aBY = jSONObject.optInt("func_ratio_count");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.aBP;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pool_name", bVar.aBP);
        }
        int i = bVar.aBQ;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "core_pool_size", i);
        }
        int i2 = bVar.aBR;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "max_pool_size", i2);
        }
        int i3 = bVar.aBS;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "current_pool_size", i3);
        }
        int i4 = bVar.aBT;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "active_count", i4);
        }
        long j = bVar.aBU;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "task_wait_avg_ms", j);
        }
        long j2 = bVar.aBV;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "task_succ_count", j2);
        }
        long j3 = bVar.interval;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "interval_ms", j3);
        }
        int i5 = bVar.aBW;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "queue_size", i5);
        }
        long j4 = bVar.aBX;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pass_timestamp", j4);
        }
        int i6 = bVar.aBY;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "func_ratio_count", i6);
        }
        return jSONObject;
    }
}
