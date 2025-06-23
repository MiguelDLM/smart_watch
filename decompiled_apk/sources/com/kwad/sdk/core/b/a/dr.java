package com.kwad.sdk.core.b.a;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.kwad.components.ad.feed.monitor.FeedErrorInfo;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class dr implements com.kwad.sdk.core.d<FeedErrorInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(FeedErrorInfo feedErrorInfo, JSONObject jSONObject) {
        a2(feedErrorInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(FeedErrorInfo feedErrorInfo, JSONObject jSONObject) {
        return b2(feedErrorInfo, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(FeedErrorInfo feedErrorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        feedErrorInfo.materialType = jSONObject.optLong("material_type");
        feedErrorInfo.width = jSONObject.optLong(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        feedErrorInfo.feedType = jSONObject.optLong("feed_type");
        feedErrorInfo.errorType = jSONObject.optLong("error_type");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(FeedErrorInfo feedErrorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = feedErrorInfo.materialType;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "material_type", j);
        }
        long j2 = feedErrorInfo.width;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, j2);
        }
        long j3 = feedErrorInfo.feedType;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "feed_type", j3);
        }
        long j4 = feedErrorInfo.errorType;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "error_type", j4);
        }
        return jSONObject;
    }
}
