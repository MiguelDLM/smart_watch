package com.kwad.components.offline.api.core.network.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.network.EmptyResultData;
import com.kwad.sdk.core.response.model.BaseResultData;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* loaded from: classes11.dex */
public abstract class CommonOfflineCompoResultData extends BaseOfflineCompoResultData {
    private static final int CODE_RESULT_OK = 1;
    private static final long serialVersionUID = 7464537023322307192L;
    public String cookie;
    public String errorMsg;
    public String extra;
    public boolean hasAd;
    public long llsid;
    private boolean mKeepOriginResponse;
    public JSONObject originResponseData;
    public int result;
    private boolean mNotifyFailOnResultError = true;
    private BaseResultData mBaseResultData = new EmptyResultData();

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
        return this.mNotifyFailOnResultError;
    }

    public void parseJson(@Nullable JSONObject jSONObject) {
        Object obj;
        String responseData;
        if (jSONObject == null) {
            return;
        }
        if (this.mBaseResultData == null) {
            this.mBaseResultData = new EmptyResultData();
        }
        this.mBaseResultData.parseJson(jSONObject);
        BaseResultData baseResultData = this.mBaseResultData;
        this.llsid = baseResultData.llsid;
        this.result = baseResultData.result;
        this.hasAd = baseResultData.hasAd;
        this.errorMsg = baseResultData.errorMsg;
        this.extra = baseResultData.extra;
        this.cookie = baseResultData.cookie;
        if (this.mKeepOriginResponse) {
            this.originResponseData = new JSONObject();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj2 = null;
                try {
                    obj = jSONObject.get(next);
                } catch (JSONException unused) {
                    obj = null;
                }
                if ((obj instanceof String) && (responseData = d.getResponseData((String) obj)) != null) {
                    try {
                        obj2 = new JSONTokener(responseData).nextValue();
                    } catch (JSONException unused2) {
                    }
                }
                if (obj2 != null) {
                    try {
                        this.originResponseData.put(next, obj2);
                    } catch (JSONException unused3) {
                    }
                } else {
                    this.originResponseData.put(next, obj);
                }
            }
        }
    }

    public void setKeepOriginResponse(boolean z) {
        this.mKeepOriginResponse = z;
    }

    public void setNotifyFailOnResultError(boolean z) {
        this.mNotifyFailOnResultError = z;
    }

    public JSONObject toJson() {
        BaseResultData baseResultData = this.mBaseResultData;
        if (baseResultData == null) {
            return new JSONObject();
        }
        return baseResultData.toJson();
    }
}
