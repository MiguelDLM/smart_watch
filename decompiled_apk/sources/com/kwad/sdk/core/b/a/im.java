package com.kwad.sdk.core.b.a;

import com.kwad.sdk.i.a;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class im implements com.kwad.sdk.core.d<a.b> {
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
        bVar.aKN = jSONObject.optInt("enable_monitor");
        bVar.aKO = jSONObject.optString("c_sc_name");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.aKO)) {
            bVar.aKO = "";
        }
        bVar.aKP = jSONObject.optString("c_pcl_name");
        if (obj.toString().equals(bVar.aKP)) {
            bVar.aKP = "";
        }
        bVar.aKQ = jSONObject.optString("m_gam_name");
        if (obj.toString().equals(bVar.aKQ)) {
            bVar.aKQ = "";
        }
        bVar.aKR = jSONObject.optString("m_gsv_name");
        if (obj.toString().equals(bVar.aKR)) {
            bVar.aKR = "";
        }
        bVar.aKS = jSONObject.optString("m_gpv_name");
        if (obj.toString().equals(bVar.aKS)) {
            bVar.aKS = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = bVar.aKN;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "enable_monitor", i);
        }
        String str = bVar.aKO;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "c_sc_name", bVar.aKO);
        }
        String str2 = bVar.aKP;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "c_pcl_name", bVar.aKP);
        }
        String str3 = bVar.aKQ;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "m_gam_name", bVar.aKQ);
        }
        String str4 = bVar.aKR;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "m_gsv_name", bVar.aKR);
        }
        String str5 = bVar.aKS;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "m_gpv_name", bVar.aKS);
        }
        return jSONObject;
    }
}
