package com.kwad.sdk.core.adlog.b;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;

@KsJson
/* loaded from: classes11.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public int apT;
    public String aqA;
    public int aqJ;
    public int aqK;
    public long aqL;
    public int aqz;
    public int retryCount;
    public int status;

    public static b BX() {
        return new b();
    }

    public final b al(long j) {
        this.aqL = j;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: bU, reason: merged with bridge method [inline-methods] */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    public final b cs(int i) {
        this.status = i;
        return this;
    }

    public final b ct(int i) {
        this.apT = i;
        return this;
    }

    public final b cu(int i) {
        this.retryCount = i;
        return this;
    }

    public final b cv(int i) {
        this.aqz = i;
        return this;
    }

    public final b cw(int i) {
        this.aqJ = i;
        return this;
    }

    public final b cx(int i) {
        this.aqK = i;
        return this;
    }

    public final b di(String str) {
        this.aqA = str;
        return this;
    }
}
