package com.kwad.sdk.core.b.a;

import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.kwad.sdk.core.adlog.a;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class by implements com.kwad.sdk.core.d<a.C0845a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0845a c0845a, JSONObject jSONObject) {
        a2(c0845a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0845a c0845a, JSONObject jSONObject) {
        return b2(c0845a, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.C0845a c0845a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0845a.templateId = jSONObject.optString(ExposeManager.UtArgsNames.templateId);
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(c0845a.templateId)) {
            c0845a.templateId = "";
        }
        c0845a.aqi = jSONObject.optString("template_show_type");
        if (obj.toString().equals(c0845a.aqi)) {
            c0845a.aqi = "";
        }
        c0845a.aqj = jSONObject.optInt("award_task_name");
        c0845a.aqk = jSONObject.optInt("jumps_liveroom_type");
        c0845a.aql = jSONObject.optInt("universe_feature_freg");
        c0845a.aqm = jSONObject.optInt("replace_url_succ");
        c0845a.aqo = jSONObject.optInt("is_special_preload");
        c0845a.aqp = jSONObject.optInt("card_type");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0845a c0845a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0845a.templateId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, ExposeManager.UtArgsNames.templateId, c0845a.templateId);
        }
        String str2 = c0845a.aqi;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "template_show_type", c0845a.aqi);
        }
        int i = c0845a.aqj;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "award_task_name", i);
        }
        int i2 = c0845a.aqk;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "jumps_liveroom_type", i2);
        }
        int i3 = c0845a.aql;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "universe_feature_freg", i3);
        }
        int i4 = c0845a.aqm;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "replace_url_succ", i4);
        }
        int i5 = c0845a.aqo;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "is_special_preload", i5);
        }
        int i6 = c0845a.aqp;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "card_type", i6);
        }
        return jSONObject;
    }
}
