package com.kwad.sdk.commercial.model;

import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.t;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;
import java.io.Serializable;
import oOoIIO0.oIX0oI;
import org.json.JSONObject;

@KsJson
/* loaded from: classes11.dex */
public class WebViewCommercialMsg extends com.kwad.sdk.core.response.a.a implements b, Serializable {
    private static final long serialVersionUID = -1007322423487775751L;
    public BusinessType biz;
    public String category;
    public String eventId;
    public JSONObject extraParam;
    public a mBaseClMsgModel;
    public JSONObject msg;
    public String primaryKey;
    public double rate;
    public SubBusinessType subBiz;
    public String suffixRatio;
    public String tag;
    public com.kwai.adclient.kscommerciallogger.model.b type;

    public WebViewCommercialMsg(AdInfo adInfo) {
        if (adInfo != null) {
            this.mBaseClMsgModel = new a(adInfo);
        }
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        a aVar;
        super.afterParseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        if (jSONObject.has("sub_biz")) {
            try {
                this.subBiz = SubBusinessType.valueOf(jSONObject.optString("sub_biz"));
            } catch (Exception unused) {
                this.subBiz = SubBusinessType.OTHER;
            }
        }
        if (jSONObject.has("biz")) {
            try {
                this.biz = BusinessType.valueOf(jSONObject.optString("biz"));
            } catch (Exception unused2) {
                this.biz = BusinessType.OTHER;
            }
        }
        if (jSONObject.has("type")) {
            try {
                this.type = new com.kwai.adclient.kscommerciallogger.model.b(jSONObject.optString("type"));
            } catch (Exception unused3) {
                this.type = new com.kwai.adclient.kscommerciallogger.model.b(oIX0oI.f32055oI0IIXIo);
            }
        }
        JSONObject jSONObject2 = this.msg;
        if (jSONObject2 != null && (aVar = this.mBaseClMsgModel) != null) {
            t.a(jSONObject2, aVar.toJson(), false);
        }
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        t.putValue(jSONObject, "biz", this.biz.value);
        t.putValue(jSONObject, "subBiz", this.subBiz.value);
        t.putValue(jSONObject, "type", this.type.getValue());
    }
}
