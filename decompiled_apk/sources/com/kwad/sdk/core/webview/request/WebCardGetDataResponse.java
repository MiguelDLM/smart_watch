package com.kwad.sdk.core.webview.request;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class WebCardGetDataResponse extends BaseResultData implements com.kwad.sdk.core.b, Serializable {
    private static final String TAG = "WebCardGetDataResponse";
    private static final long serialVersionUID = 2407409365862659643L;
    public JSONObject data;
    public JSONArray impAdInfo;

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            String optString = jSONObject.optString("impAdInfo");
            if (!bh.isNullString(optString)) {
                String responseData = d.getResponseData(optString);
                if (!bh.isNullString(responseData)) {
                    this.impAdInfo = new JSONArray(responseData);
                    return;
                }
                return;
            }
            String optString2 = jSONObject.optString("data");
            if (!bh.isNullString(optString2)) {
                this.data = new JSONObject(d.getResponseData(optString2));
            }
        } catch (Exception e) {
            c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        JSONObject jSONObject = this.data;
        if (jSONObject != null) {
            t.putValue(json, "data", jSONObject);
        }
        JSONArray jSONArray = this.impAdInfo;
        if (jSONArray != null) {
            t.putValue(json, "impAdInfo", jSONArray);
        }
        return json;
    }
}
