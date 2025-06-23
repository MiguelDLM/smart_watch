package com.kwad.sdk.core.network;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bk;
import com.kwad.sdk.utils.t;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public abstract class b implements f {
    private final Map<String, String> mHeader = new HashMap();
    public final JSONObject mBodyParams = new JSONObject();

    public b() {
        try {
            onCreate();
            buildBaseHeader();
            buildBaseBody();
            if (encryptDisable()) {
                addHeader("x-ksad-ignore-decrypt", "true");
            }
            addHeader("cookie", com.kwad.sdk.core.response.b.f.FS().FT());
            com.kwad.sdk.core.a.d.g(getHeader());
            addHeader("User-Agent", p.getUserAgent());
            addHeader("BrowserUa", p.Ez());
            addHeader("SystemUa", p.Ey());
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
    }

    public void addHeader(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.mHeader.put(str, str2);
        }
    }

    public abstract void buildBaseBody();

    public abstract void buildBaseHeader();

    public boolean enableCrashReport() {
        return true;
    }

    public boolean encryptDisable() {
        return com.kwad.sdk.components.f.encryptDisable();
    }

    @Override // com.kwad.sdk.core.network.f
    public JSONObject getBody() {
        if (encryptDisable()) {
            return this.mBodyParams;
        }
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        t.putValue(jSONObject, "version", fVar.getSDKVersion());
        if (!TextUtils.isEmpty(bk.getAppId())) {
            t.putValue(jSONObject, com.huawei.openalliance.ad.uriaction.i.Code, bk.getAppId());
        } else {
            t.putValue(jSONObject, com.huawei.openalliance.ad.uriaction.i.Code, fVar.getAppId());
        }
        t.putValue(jSONObject, "message", com.kwad.sdk.core.a.d.am(getBodyParamsString()));
        com.kwad.sdk.core.a.d.a(getUrl(), getHeader(), jSONObject.toString());
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.network.f
    public Map<String, String> getBodyMap() {
        return null;
    }

    public JSONObject getBodyParams() {
        return this.mBodyParams;
    }

    public String getBodyParamsString() {
        return this.mBodyParams.toString();
    }

    @Override // com.kwad.sdk.core.network.f
    public Map<String, String> getHeader() {
        return this.mHeader;
    }

    public String getRequestHost() {
        return com.kwad.sdk.h.yA();
    }

    @Override // com.kwad.sdk.core.network.f
    @Nullable
    public SceneImpl getScene() {
        return null;
    }

    @Override // com.kwad.sdk.core.network.f
    public abstract String getUrl();

    public void onCreate() {
    }

    public void putBody(String str, String str2) {
        t.putValue(this.mBodyParams, str, str2);
    }

    public void reportSdkCaughtException(Throwable th) {
        if (enableCrashReport()) {
            ServiceProvider.reportSdkCaughtException(th);
        } else {
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
    }

    public void putBody(String str, double d) {
        t.putValue(this.mBodyParams, str, d);
    }

    public void putBody(String str, int i) {
        t.putValue(this.mBodyParams, str, i);
    }

    public void putBody(String str, float f) {
        t.putValue(this.mBodyParams, str, f);
    }

    public void putBody(String str, byte b) {
        t.putValue(this.mBodyParams, str, b);
    }

    public void putBody(String str, long j) {
        t.putValue(this.mBodyParams, str, j);
    }

    public void putBody(String str, boolean z) {
        t.putValue(this.mBodyParams, str, z);
    }

    public void putBody(String str, JSONObject jSONObject) {
        t.putValue(this.mBodyParams, str, jSONObject);
    }

    public void putBody(String str, JSONArray jSONArray) {
        t.putValue(this.mBodyParams, str, jSONArray);
    }

    public void putBody(String str, com.kwad.sdk.core.b bVar) {
        t.a(this.mBodyParams, str, bVar);
    }

    public void putBody(String str, List<? extends com.kwad.sdk.core.b> list) {
        t.putValue(this.mBodyParams, str, list);
    }
}
