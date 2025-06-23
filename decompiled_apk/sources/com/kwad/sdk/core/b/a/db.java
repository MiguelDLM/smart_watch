package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.a.a;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class db implements com.kwad.sdk.core.d<a.C0808a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0808a c0808a, JSONObject jSONObject) {
        a2(c0808a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0808a c0808a, JSONObject jSONObject) {
        return b2(c0808a, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.C0808a c0808a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0808a.url = jSONObject.optString("url");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(c0808a.url)) {
            c0808a.url = "";
        }
        c0808a.packageName = jSONObject.optString("packageName");
        if (obj.toString().equals(c0808a.packageName)) {
            c0808a.packageName = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0808a c0808a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0808a.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", c0808a.url);
        }
        String str2 = c0808a.packageName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "packageName", c0808a.packageName);
        }
        return jSONObject;
    }
}
