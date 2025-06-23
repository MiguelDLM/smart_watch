package com.kwad.sdk.core.b.a;

import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.kwad.components.core.video.a.d;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class kp implements com.kwad.sdk.core.d<d.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(d.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(d.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.Wb = jSONObject.optLong("start_play_duration_ms");
        bVar.Wc = jSONObject.optLong("first_frame_duration_ms");
        bVar.Wd = jSONObject.optLong("block_total_duration_ms");
        bVar.videoDuration = jSONObject.optLong("video_duration_ms");
        bVar.VI = jSONObject.optInt("block_times");
        bVar.videoUrl = jSONObject.optString("video_url");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.videoUrl)) {
            bVar.videoUrl = "";
        }
        bVar.llsid = jSONObject.optLong("llsid");
        bVar.creativeId = jSONObject.optLong(ExposeManager.UtArgsNames.creativeId);
        bVar.SK = jSONObject.optLong("ad_info_uid");
        bVar.Wa = jSONObject.optString("ad_info_user_name");
        if (obj.toString().equals(bVar.Wa)) {
            bVar.Wa = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(d.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = bVar.Wb;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "start_play_duration_ms", j);
        }
        long j2 = bVar.Wc;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "first_frame_duration_ms", j2);
        }
        long j3 = bVar.Wd;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "block_total_duration_ms", j3);
        }
        long j4 = bVar.videoDuration;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "video_duration_ms", j4);
        }
        int i = bVar.VI;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "block_times", i);
        }
        String str = bVar.videoUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "video_url", bVar.videoUrl);
        }
        long j5 = bVar.llsid;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "llsid", j5);
        }
        long j6 = bVar.creativeId;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, ExposeManager.UtArgsNames.creativeId, j6);
        }
        long j7 = bVar.SK;
        if (j7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_info_uid", j7);
        }
        String str2 = bVar.Wa;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_info_user_name", bVar.Wa);
        }
        return jSONObject;
    }
}
