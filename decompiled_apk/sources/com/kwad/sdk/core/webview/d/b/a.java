package com.kwad.sdk.core.webview.d.b;

import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bh;
import org.json.JSONException;
import org.json.JSONObject;

@KsJson
/* loaded from: classes11.dex */
public final class a extends com.kwad.sdk.core.response.a.a {

    @Deprecated
    public boolean KS;
    public String Lt;

    @Deprecated
    public boolean Yl;
    public int Yn;
    public c Yo;
    public int aFZ;
    public int aGa;
    public AdTemplate adTemplate;
    public int kl;
    public boolean Lf = true;
    public long creativeId = -1;
    public int adStyle = -1;
    public boolean aGb = false;
    public boolean aGc = false;

    public final boolean HM() {
        if (1 == this.Yn) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        try {
            if (this.kl == 0 && this.aGa == 0) {
                if (jSONObject != null && jSONObject.has("logParam")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("logParam");
                    this.kl = optJSONObject.getInt("itemClickType");
                    this.aGa = optJSONObject.getInt("sceneType");
                    this.aGb = optJSONObject.optBoolean("isCallbackOnly");
                }
                String optString = jSONObject.optString("adTemplate");
                if (!bh.isNullString(optString)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(optString);
                        AdTemplate adTemplate = new AdTemplate();
                        this.adTemplate = adTemplate;
                        adTemplate.parseJson(jSONObject2);
                    } catch (JSONException e) {
                        ServiceProvider.reportSdkCaughtException(e);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }
}
