package com.kwad.components.ad.feed.monitor;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;

@KsJson
/* loaded from: classes11.dex */
public class FeedErrorInfo extends com.kwad.sdk.commercial.c.a implements Serializable {
    private static final long serialVersionUID = 5562303989639679849L;
    public long errorType;
    public long feedType;
    public long materialType;
    public long width;

    public FeedErrorInfo setErrorType(int i) {
        this.errorType = i;
        return this;
    }

    public FeedErrorInfo setFeedType(int i) {
        this.feedType = i;
        return this;
    }

    public FeedErrorInfo setMaterialType(long j) {
        this.materialType = j;
        return this;
    }

    public FeedErrorInfo setWidth(long j) {
        this.width = j;
        return this;
    }
}
