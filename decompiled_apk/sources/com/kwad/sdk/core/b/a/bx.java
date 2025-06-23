package com.kwad.sdk.core.b.a;

import XIXIX.OOXIXo;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class bx implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.d.b.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.d.b.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.d.b.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.webview.d.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.x = jSONObject.optDouble("x");
        bVar.y = jSONObject.optDouble("y");
        bVar.width = jSONObject.optInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        bVar.height = jSONObject.optInt("height");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.webview.d.b.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d = bVar.x;
        if (d != OOXIXo.f3760XO) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "x", d);
        }
        double d2 = bVar.y;
        if (d2 != OOXIXo.f3760XO) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "y", d2);
        }
        int i = bVar.width;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, i);
        }
        int i2 = bVar.height;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "height", i2);
        }
        return jSONObject;
    }
}
