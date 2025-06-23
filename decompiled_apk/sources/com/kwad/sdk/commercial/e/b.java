package com.kwad.sdk.commercial.e;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;

@KsJson
/* loaded from: classes11.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String apD;
    public String apE;

    public static b Bv() {
        return new b();
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: bC, reason: merged with bridge method [inline-methods] */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    public final b cG(String str) {
        this.apD = str;
        return this;
    }

    public final b cH(String str) {
        this.apE = str;
        return this;
    }
}
