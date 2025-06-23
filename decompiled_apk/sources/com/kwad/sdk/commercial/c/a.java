package com.kwad.sdk.commercial.c;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

@KsJson
/* loaded from: classes11.dex */
public abstract class a extends com.kwad.sdk.core.response.a.a {
    public int adOperationType;
    public int campaignType;
    public long creativeId;
    public int errorCode;
    public String errorMsg;
    public int industryFirstLevelId;
    public long llsid;
    public int ocpcActionType;
    public long posId;
    public String templateId;
    public String templateVersion;
    public int tkPublishType;
    public int webUriSourceType;

    public a setAdTemplate(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return this;
        }
        this.creativeId = e.ec(adTemplate);
        this.llsid = e.dP(adTemplate);
        this.posId = e.dL(adTemplate);
        AdInfo dS = e.dS(adTemplate);
        this.campaignType = com.kwad.sdk.core.response.b.a.dh(dS);
        this.ocpcActionType = com.kwad.sdk.core.response.b.a.di(dS);
        this.industryFirstLevelId = com.kwad.sdk.core.response.b.a.dj(dS);
        this.adOperationType = com.kwad.sdk.core.response.b.a.aP(dS);
        this.webUriSourceType = com.kwad.sdk.core.response.b.a.dk(dS);
        AdMatrixInfo.MatrixTemplate aU = d.aU(adTemplate);
        if (aU != null) {
            this.templateId = aU.templateId;
            this.templateVersion = aU.templateVersion;
            this.tkPublishType = aU.publishType;
        }
        return this;
    }

    public a setErrorCode(int i) {
        this.errorCode = i;
        return this;
    }

    public a setErrorMsg(String str) {
        this.errorMsg = str;
        return this;
    }

    public a setLlsid(long j) {
        this.llsid = j;
        return this;
    }

    public a setPosId(long j) {
        this.posId = j;
        return this;
    }
}
