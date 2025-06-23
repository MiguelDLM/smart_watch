package com.kwad.sdk.core.b.a;

import XIXIX.OOXIXo;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.kwad.sdk.core.response.model.PhotoInfo;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class kn implements com.kwad.sdk.core.d<PhotoInfo.VideoInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
        a2(videoInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
        return b2(videoInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        videoInfo.videoUrl = jSONObject.optString("videoUrl");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(videoInfo.videoUrl)) {
            videoInfo.videoUrl = "";
        }
        videoInfo.manifest = jSONObject.optString("manifest");
        if (obj.toString().equals(videoInfo.manifest)) {
            videoInfo.manifest = "";
        }
        videoInfo.firstFrame = jSONObject.optString("firstFrame");
        if (obj.toString().equals(videoInfo.firstFrame)) {
            videoInfo.firstFrame = "";
        }
        videoInfo.duration = jSONObject.optLong("duration");
        videoInfo.size = jSONObject.optInt(MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE);
        videoInfo.width = jSONObject.optInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        videoInfo.height = jSONObject.optInt("height");
        videoInfo.leftRatio = jSONObject.optDouble("leftRatio");
        videoInfo.topRatio = jSONObject.optDouble("topRatio");
        videoInfo.widthRatio = jSONObject.optDouble("widthRatio", new Double("1.0f").doubleValue());
        videoInfo.heightRatio = jSONObject.optDouble("heightRatio", new Double("1.0f").doubleValue());
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(PhotoInfo.VideoInfo videoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = videoInfo.videoUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "videoUrl", videoInfo.videoUrl);
        }
        String str2 = videoInfo.manifest;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "manifest", videoInfo.manifest);
        }
        String str3 = videoInfo.firstFrame;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "firstFrame", videoInfo.firstFrame);
        }
        long j = videoInfo.duration;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "duration", j);
        }
        int i = videoInfo.size;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE, i);
        }
        int i2 = videoInfo.width;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, i2);
        }
        int i3 = videoInfo.height;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "height", i3);
        }
        double d = videoInfo.leftRatio;
        if (d != OOXIXo.f3760XO) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "leftRatio", d);
        }
        double d2 = videoInfo.topRatio;
        if (d2 != OOXIXo.f3760XO) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "topRatio", d2);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "widthRatio", videoInfo.widthRatio);
        com.kwad.sdk.utils.t.putValue(jSONObject, "heightRatio", videoInfo.heightRatio);
        return jSONObject;
    }
}
