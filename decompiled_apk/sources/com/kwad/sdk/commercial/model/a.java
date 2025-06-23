package com.kwad.sdk.commercial.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class a implements b {
    public int adOperationType;
    public int campaignType;
    public int industryFirstLevelId;
    public int ocpcActionType;
    public int webUriSourceType;

    public a(AdInfo adInfo) {
        if (adInfo != null) {
            this.campaignType = com.kwad.sdk.core.response.b.a.dh(adInfo);
            this.ocpcActionType = com.kwad.sdk.core.response.b.a.di(adInfo);
            this.industryFirstLevelId = com.kwad.sdk.core.response.b.a.dj(adInfo);
            this.adOperationType = com.kwad.sdk.core.response.b.a.aP(adInfo);
            this.webUriSourceType = com.kwad.sdk.core.response.b.a.dk(adInfo);
        }
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "campaign_type", this.campaignType);
        t.putValue(jSONObject, "ocpc_action_type", this.ocpcActionType);
        t.putValue(jSONObject, "industry_first_level_id", this.industryFirstLevelId);
        t.putValue(jSONObject, "ad_operation_type", this.adOperationType);
        t.putValue(jSONObject, "web_uri_source_type", this.webUriSourceType);
        return jSONObject;
    }
}
