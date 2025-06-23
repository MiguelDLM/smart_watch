package com.kwad.sdk.core.adlog.b;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;

@KsJson
/* loaded from: classes11.dex */
public class d extends com.kwad.sdk.commercial.c.a {
    public String apM;
    public int apT;
    public int aqM;
    public int retryCount;
    public int status;

    public static d BY() {
        return new d();
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: bV, reason: merged with bridge method [inline-methods] */
    public final d setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    public final d cA(int i) {
        this.aqM = 1;
        return this;
    }

    public final d cB(int i) {
        this.retryCount = i;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: cC, reason: merged with bridge method [inline-methods] */
    public final d setErrorCode(int i) {
        super.setErrorCode(i);
        return this;
    }

    public final d cy(int i) {
        this.status = i;
        return this;
    }

    public final d cz(int i) {
        this.apT = i;
        return this;
    }

    public final d dj(String str) {
        this.apM = str;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: dk, reason: merged with bridge method [inline-methods] */
    public final d setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }
}
