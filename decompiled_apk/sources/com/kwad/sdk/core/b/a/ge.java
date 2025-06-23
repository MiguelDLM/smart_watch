package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import oo0oIXo.oIX0oI;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class ge implements com.kwad.sdk.core.d<AdInfo.AdMaterialInfo.MaterialFeature> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdMaterialInfo.MaterialFeature materialFeature, JSONObject jSONObject) {
        a2(materialFeature, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdMaterialInfo.MaterialFeature materialFeature, JSONObject jSONObject) {
        return b2(materialFeature, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdMaterialInfo.MaterialFeature materialFeature, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        materialFeature.featureType = jSONObject.optInt("featureType");
        materialFeature.materialUrl = jSONObject.optString("materialUrl");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(materialFeature.materialUrl)) {
            materialFeature.materialUrl = "";
        }
        materialFeature.photoId = jSONObject.optLong("photoId");
        materialFeature.coverUrl = jSONObject.optString("coverUrl");
        if (obj.toString().equals(materialFeature.coverUrl)) {
            materialFeature.coverUrl = "";
        }
        materialFeature.videoDuration = jSONObject.optInt(oIX0oI.f32259Oxx0IOOO);
        materialFeature.firstFrame = jSONObject.optString("firstFrame");
        if (obj.toString().equals(materialFeature.firstFrame)) {
            materialFeature.firstFrame = "";
        }
        materialFeature.blurBackgroundUrl = jSONObject.optString("blurBackgroundUrl");
        if (obj.toString().equals(materialFeature.blurBackgroundUrl)) {
            materialFeature.blurBackgroundUrl = "";
        }
        materialFeature.webpCoverUrl = jSONObject.optString("webpCoverUrl");
        if (obj.toString().equals(materialFeature.webpCoverUrl)) {
            materialFeature.webpCoverUrl = "";
        }
        materialFeature.videoWidth = jSONObject.optInt("videoWidth");
        materialFeature.videoHeight = jSONObject.optInt("videoHeight");
        materialFeature.likeCount = jSONObject.optLong("likeCount");
        materialFeature.commentCount = jSONObject.optLong("commentCount");
        materialFeature.source = jSONObject.optInt("source");
        materialFeature.ruleId = jSONObject.optString("ruleId");
        if (obj.toString().equals(materialFeature.ruleId)) {
            materialFeature.ruleId = "";
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdMaterialInfo.MaterialFeature materialFeature, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = materialFeature.featureType;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "featureType", i);
        }
        String str = materialFeature.materialUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "materialUrl", materialFeature.materialUrl);
        }
        long j = materialFeature.photoId;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "photoId", j);
        }
        String str2 = materialFeature.coverUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "coverUrl", materialFeature.coverUrl);
        }
        int i2 = materialFeature.videoDuration;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, oIX0oI.f32259Oxx0IOOO, i2);
        }
        String str3 = materialFeature.firstFrame;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "firstFrame", materialFeature.firstFrame);
        }
        String str4 = materialFeature.blurBackgroundUrl;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "blurBackgroundUrl", materialFeature.blurBackgroundUrl);
        }
        String str5 = materialFeature.webpCoverUrl;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "webpCoverUrl", materialFeature.webpCoverUrl);
        }
        int i3 = materialFeature.videoWidth;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "videoWidth", i3);
        }
        int i4 = materialFeature.videoHeight;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "videoHeight", i4);
        }
        long j2 = materialFeature.likeCount;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "likeCount", j2);
        }
        long j3 = materialFeature.commentCount;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "commentCount", j3);
        }
        int i5 = materialFeature.source;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "source", i5);
        }
        String str6 = materialFeature.ruleId;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ruleId", materialFeature.ruleId);
        }
        return jSONObject;
    }
}
