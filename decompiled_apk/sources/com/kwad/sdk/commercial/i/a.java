package com.kwad.sdk.commercial.i;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;

@KsJson
/* loaded from: classes11.dex */
public class a extends com.kwad.sdk.commercial.c.a {
    public String apD;
    public String apL;
    public String apM;
    public String apN;

    public static a BB() {
        return new a();
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: bD, reason: merged with bridge method [inline-methods] */
    public final a setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    public final a cN(String str) {
        this.apN = str;
        return this;
    }

    public final a cO(String str) {
        this.apD = str;
        return this;
    }

    public final a cP(String str) {
        this.apL = str;
        return this;
    }

    public final a cQ(String str) {
        this.apM = str;
        return this;
    }
}
