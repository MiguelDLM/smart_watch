package com.kwad.sdk.commercial.j;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;

@KsJson
/* loaded from: classes11.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String apL;
    public String apM;
    public int apT;
    public int apU;
    public int status;

    public static b BF() {
        return new b();
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: bE, reason: merged with bridge method [inline-methods] */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    public final b cV(String str) {
        this.apL = str;
        return this;
    }

    public final b cW(String str) {
        this.apM = str;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: cX, reason: merged with bridge method [inline-methods] */
    public final b setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }

    public final b cn(int i) {
        this.status = i;
        return this;
    }

    public final b co(int i) {
        this.apT = i;
        return this;
    }

    public final b cp(int i) {
        this.apU = i;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: cq, reason: merged with bridge method [inline-methods] */
    public final b setErrorCode(int i) {
        super.setErrorCode(i);
        return this;
    }
}
