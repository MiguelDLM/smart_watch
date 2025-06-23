package com.kwad.components.ad.feed.monitor;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;
import org.json.JSONObject;

@KsJson
/* loaded from: classes11.dex */
public class FeedWebViewInfo extends com.kwad.sdk.commercial.c.a implements Serializable {
    private static final long serialVersionUID = -4316140680874648788L;
    public int timeType;
    public String event = "";
    public String url = "";
    public String sceneId = "";
    public long durationMs = -1;

    @Override // com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        if (this.durationMs == -1) {
            jSONObject.remove("duration_ms");
        }
    }

    public FeedWebViewInfo setDurationMs(long j) {
        this.durationMs = j;
        return this;
    }

    public FeedWebViewInfo setEvent(String str) {
        this.event = str;
        return this;
    }

    public FeedWebViewInfo setSceneId(String str) {
        this.sceneId = str;
        return this;
    }

    public FeedWebViewInfo setTimeType(int i) {
        this.timeType = i;
        return this;
    }

    public FeedWebViewInfo setUrl(String str) {
        this.url = str;
        return this;
    }
}
