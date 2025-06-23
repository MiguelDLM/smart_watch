package com.kwad.sdk.core.b.a;

import com.baidu.platform.comapi.map.MapBundleKey;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class fw implements com.kwad.sdk.core.d<com.kwad.components.core.page.b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.page.b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.page.b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.page.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.adStyle = jSONObject.optInt(MapBundleKey.MapObjKey.OBJ_AD_STYLE);
        aVar.OY = jSONObject.optInt("neo_tk_render_type");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.page.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.adStyle;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, MapBundleKey.MapObjKey.OBJ_AD_STYLE, i);
        }
        int i2 = aVar.OY;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "neo_tk_render_type", i2);
        }
        return jSONObject;
    }
}
