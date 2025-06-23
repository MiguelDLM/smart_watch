package com.kwad.sdk.core.b.a;

import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.kwad.components.core.video.a.d;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class ko implements com.kwad.sdk.core.d<d.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(d.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(d.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(d.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.code = jSONObject.optInt("code");
        aVar.msg = jSONObject.optString("msg");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.msg)) {
            aVar.msg = "";
        }
        aVar.videoUrl = jSONObject.optString("video_url");
        if (obj.toString().equals(aVar.videoUrl)) {
            aVar.videoUrl = "";
        }
        aVar.llsid = jSONObject.optLong("llsid");
        aVar.creativeId = jSONObject.optLong(ExposeManager.UtArgsNames.creativeId);
        aVar.SK = jSONObject.optLong("ad_info_uid");
        aVar.Wa = jSONObject.optString("ad_info_user_name");
        if (obj.toString().equals(aVar.Wa)) {
            aVar.Wa = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(d.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.code;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "code", i);
        }
        String str = aVar.msg;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "msg", aVar.msg);
        }
        String str2 = aVar.videoUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "video_url", aVar.videoUrl);
        }
        long j = aVar.llsid;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "llsid", j);
        }
        long j2 = aVar.creativeId;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, ExposeManager.UtArgsNames.creativeId, j2);
        }
        long j3 = aVar.SK;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_info_uid", j3);
        }
        String str3 = aVar.Wa;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_info_user_name", aVar.Wa);
        }
        return jSONObject;
    }
}
