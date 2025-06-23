package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.components.c;
import com.kwad.sdk.components.g;
import com.kwad.sdk.core.a.e;
import com.kwad.sdk.core.response.b.f;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public abstract class BaseResultData implements com.kwad.sdk.core.b, Serializable {
    private static final int CODE_RESULT_OK = 1;
    private static final long serialVersionUID = -8657363515914699792L;
    public String cookie;
    public String errorMsg;
    public String extra;
    public boolean hasAd;
    public long llsid;
    public int result;
    public String testErrorMsg;

    public JSONObject baseToJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "llsid", this.llsid);
        t.putValue(jSONObject, "extra", this.extra);
        t.putValue(jSONObject, "result", this.result);
        t.putValue(jSONObject, "hasAd", this.hasAd);
        t.putValue(jSONObject, MediationConstant.KEY_ERROR_MSG, this.errorMsg);
        t.putValue(jSONObject, "testErrorMsg", this.testErrorMsg);
        t.putValue(jSONObject, "cookie", this.cookie);
        return jSONObject;
    }

    public boolean hasData() {
        return this.hasAd;
    }

    public boolean isDataEmpty() {
        return false;
    }

    public boolean isResultOk() {
        if (this.result == 1) {
            return true;
        }
        return false;
    }

    public boolean notifyFailOnResultError() {
        return true;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.llsid = jSONObject.optLong("llsid");
        this.result = jSONObject.optInt("result");
        this.hasAd = jSONObject.optBoolean("hasAd");
        this.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
        this.testErrorMsg = jSONObject.optString("testErrorMsg");
        String optString = jSONObject.optString("extra");
        if (!bh.isNullString(optString)) {
            this.extra = ((e) c.f(e.class)).getResponseData(optString);
        }
        g gVar = (g) c.f(g.class);
        if (gVar != null) {
            gVar.al(jSONObject.optString("egid"));
            gVar.x(jSONObject.optLong("gidExpireTimeMs"));
        }
        String optString2 = jSONObject.optString("cookie");
        this.cookie = optString2;
        if (!TextUtils.isEmpty(optString2)) {
            f.FS().eA(this.cookie);
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        return baseToJson();
    }
}
