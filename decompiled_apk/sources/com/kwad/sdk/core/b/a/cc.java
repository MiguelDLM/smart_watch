package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.reward.h;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class cc implements com.kwad.sdk.core.d<h.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(h.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(h.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(h.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.style = jSONObject.optInt("style");
        cVar.title = jSONObject.optString("title");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(cVar.title)) {
            cVar.title = "";
        }
        cVar.pX = jSONObject.optString("closeBtnText");
        if (obj.toString().equals(cVar.pX)) {
            cVar.pX = "";
        }
        cVar.pY = jSONObject.optString("continueBtnText");
        if (obj.toString().equals(cVar.pY)) {
            cVar.pY = "";
        }
        cVar.pZ = jSONObject.optString("viewDetailText");
        if (obj.toString().equals(cVar.pZ)) {
            cVar.pZ = "";
        }
        cVar.qa = jSONObject.optString("unWatchedVideoTime");
        if (obj.toString().equals(cVar.qa)) {
            cVar.qa = "";
        }
        cVar.qb = jSONObject.optString("iconUrl");
        if (obj.toString().equals(cVar.qb)) {
            cVar.qb = "";
        }
        cVar.qc = jSONObject.optString("desc");
        if (obj.toString().equals(cVar.qc)) {
            cVar.qc = "";
        }
        cVar.qd = jSONObject.optString("descTxt");
        if (obj.toString().equals(cVar.qd)) {
            cVar.qd = "";
        }
        cVar.qe = jSONObject.optString("currentPlayTime");
        if (obj.toString().equals(cVar.qe)) {
            cVar.qe = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(h.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = cVar.style;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "style", i);
        }
        String str = cVar.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "title", cVar.title);
        }
        String str2 = cVar.pX;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "closeBtnText", cVar.pX);
        }
        String str3 = cVar.pY;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "continueBtnText", cVar.pY);
        }
        String str4 = cVar.pZ;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "viewDetailText", cVar.pZ);
        }
        String str5 = cVar.qa;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "unWatchedVideoTime", cVar.qa);
        }
        String str6 = cVar.qb;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "iconUrl", cVar.qb);
        }
        String str7 = cVar.qc;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "desc", cVar.qc);
        }
        String str8 = cVar.qd;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "descTxt", cVar.qd);
        }
        String str9 = cVar.qe;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentPlayTime", cVar.qe);
        }
        return jSONObject;
    }
}
