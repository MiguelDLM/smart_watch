package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class hj implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.PatchAdInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo, JSONObject jSONObject) {
        a2(patchAdInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo, JSONObject jSONObject) {
        return b2(patchAdInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        patchAdInfo.weakStyleIcon = jSONObject.optString("weakStyleIcon");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(patchAdInfo.weakStyleIcon)) {
            patchAdInfo.weakStyleIcon = "";
        }
        patchAdInfo.weakStyleTitle = jSONObject.optString("weakStyleTitle");
        if (obj.toString().equals(patchAdInfo.weakStyleTitle)) {
            patchAdInfo.weakStyleTitle = "";
        }
        patchAdInfo.weakStyleDownloadingTitle = jSONObject.optString("weakStyleDownloadingTitle");
        if (obj.toString().equals(patchAdInfo.weakStyleDownloadingTitle)) {
            patchAdInfo.weakStyleDownloadingTitle = "";
        }
        patchAdInfo.weakStyleAdMark = jSONObject.optString("weakStyleAdMark");
        if (obj.toString().equals(patchAdInfo.weakStyleAdMark)) {
            patchAdInfo.weakStyleAdMark = "";
        }
        patchAdInfo.weakStyleAppearTime = jSONObject.optLong("weakStyleAppearTime");
        patchAdInfo.weakStyleEnableClose = jSONObject.optBoolean("weakStyleEnableClose", new Boolean("true").booleanValue());
        patchAdInfo.typePortrait = jSONObject.optInt("typePortrait");
        patchAdInfo.strongStyleCardUrl = jSONObject.optString("strongStyleCardUrl");
        if (obj.toString().equals(patchAdInfo.strongStyleCardUrl)) {
            patchAdInfo.strongStyleCardUrl = "";
        }
        patchAdInfo.strongStyleAppearTime = jSONObject.optLong("strongStyleAppearTime");
        patchAdInfo.strongStyleTitle = jSONObject.optString("strongStyleTitle");
        if (obj.toString().equals(patchAdInfo.strongStyleTitle)) {
            patchAdInfo.strongStyleTitle = "";
        }
        patchAdInfo.strongStyleSubTitle = jSONObject.optString("strongStyleSubTitle");
        if (obj.toString().equals(patchAdInfo.strongStyleSubTitle)) {
            patchAdInfo.strongStyleSubTitle = "";
        }
        patchAdInfo.strongStyleAdMark = jSONObject.optString("strongStyleAdMark");
        if (obj.toString().equals(patchAdInfo.strongStyleAdMark)) {
            patchAdInfo.strongStyleAdMark = "";
        }
        patchAdInfo.strongStyleEnableClose = jSONObject.optBoolean("strongStyleEnableClose", new Boolean("true").booleanValue());
        patchAdInfo.weakStyleShowTime = jSONObject.optLong("weakStyleShowTime");
        patchAdInfo.strongStyleShowTime = jSONObject.optLong("strongStyleShowTime");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = patchAdInfo.weakStyleIcon;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "weakStyleIcon", patchAdInfo.weakStyleIcon);
        }
        String str2 = patchAdInfo.weakStyleTitle;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "weakStyleTitle", patchAdInfo.weakStyleTitle);
        }
        String str3 = patchAdInfo.weakStyleDownloadingTitle;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "weakStyleDownloadingTitle", patchAdInfo.weakStyleDownloadingTitle);
        }
        String str4 = patchAdInfo.weakStyleAdMark;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "weakStyleAdMark", patchAdInfo.weakStyleAdMark);
        }
        long j = patchAdInfo.weakStyleAppearTime;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "weakStyleAppearTime", j);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "weakStyleEnableClose", patchAdInfo.weakStyleEnableClose);
        int i = patchAdInfo.typePortrait;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "typePortrait", i);
        }
        String str5 = patchAdInfo.strongStyleCardUrl;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "strongStyleCardUrl", patchAdInfo.strongStyleCardUrl);
        }
        long j2 = patchAdInfo.strongStyleAppearTime;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "strongStyleAppearTime", j2);
        }
        String str6 = patchAdInfo.strongStyleTitle;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "strongStyleTitle", patchAdInfo.strongStyleTitle);
        }
        String str7 = patchAdInfo.strongStyleSubTitle;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "strongStyleSubTitle", patchAdInfo.strongStyleSubTitle);
        }
        String str8 = patchAdInfo.strongStyleAdMark;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "strongStyleAdMark", patchAdInfo.strongStyleAdMark);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "strongStyleEnableClose", patchAdInfo.strongStyleEnableClose);
        long j3 = patchAdInfo.weakStyleShowTime;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "weakStyleShowTime", j3);
        }
        long j4 = patchAdInfo.strongStyleShowTime;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "strongStyleShowTime", j4);
        }
        return jSONObject;
    }
}
