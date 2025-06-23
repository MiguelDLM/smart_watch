package com.kwad.sdk.core.b.a;

import com.kwad.sdk.crash.online.monitor.block.BlockEvent;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class kd implements com.kwad.sdk.core.d<BlockEvent.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(BlockEvent.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(BlockEvent.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(BlockEvent.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aHN = jSONObject.optLong("endTimestamp");
        aVar.repeatCount = jSONObject.optInt("repeatCount", new Integer("1").intValue());
        aVar.aHO = jSONObject.optBoolean("runIdle");
        aVar.aHP = jSONObject.optString("stackTraceDetail");
        if (JSONObject.NULL.toString().equals(aVar.aHP)) {
            aVar.aHP = "";
        }
        aVar.aHQ = jSONObject.optLong("startTimestamp");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(BlockEvent.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = aVar.aHN;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "endTimestamp", j);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "repeatCount", aVar.repeatCount);
        boolean z = aVar.aHO;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "runIdle", z);
        }
        String str = aVar.aHP;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "stackTraceDetail", aVar.aHP);
        }
        long j2 = aVar.aHQ;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "startTimestamp", j2);
        }
        return jSONObject;
    }
}
