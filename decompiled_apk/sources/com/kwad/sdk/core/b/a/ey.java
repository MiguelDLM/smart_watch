package com.kwad.sdk.core.b.a;

import XIXIX.OOXIXo;
import com.kwad.sdk.core.imageloader.ImageLoaderInfo;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class ey implements com.kwad.sdk.core.d<ImageLoaderInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ImageLoaderInfo imageLoaderInfo, JSONObject jSONObject) {
        a2(imageLoaderInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ImageLoaderInfo imageLoaderInfo, JSONObject jSONObject) {
        return b2(imageLoaderInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(ImageLoaderInfo imageLoaderInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        imageLoaderInfo.totalCount = jSONObject.optInt("total_count");
        imageLoaderInfo.failedCount = jSONObject.optInt("failed_count");
        imageLoaderInfo.successCount = jSONObject.optInt("success_count");
        imageLoaderInfo.duration = jSONObject.optDouble("duration");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(ImageLoaderInfo imageLoaderInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = imageLoaderInfo.totalCount;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "total_count", i);
        }
        int i2 = imageLoaderInfo.failedCount;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "failed_count", i2);
        }
        int i3 = imageLoaderInfo.successCount;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "success_count", i3);
        }
        double d = imageLoaderInfo.duration;
        if (d != OOXIXo.f3760XO) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "duration", d);
        }
        return jSONObject;
    }
}
