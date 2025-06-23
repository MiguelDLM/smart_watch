package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.a;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class ai implements com.kwad.sdk.core.d<a.C0809a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0809a c0809a, JSONObject jSONObject) {
        a2(c0809a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0809a c0809a, JSONObject jSONObject) {
        return b2(c0809a, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.C0809a c0809a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0809a.JK = jSONObject.optString("creativeId");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(c0809a.JK)) {
            c0809a.JK = "";
        }
        c0809a.WC = jSONObject.optString("targetMethod");
        if (obj.toString().equals(c0809a.WC)) {
            c0809a.WC = "";
        }
        c0809a.WD = jSONObject.optString("methodParams");
        if (obj.toString().equals(c0809a.WD)) {
            c0809a.WD = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0809a c0809a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0809a.JK;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", c0809a.JK);
        }
        String str2 = c0809a.WC;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "targetMethod", c0809a.WC);
        }
        String str3 = c0809a.WD;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "methodParams", c0809a.WD);
        }
        return jSONObject;
    }
}
