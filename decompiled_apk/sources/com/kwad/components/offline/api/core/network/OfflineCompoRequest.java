package com.kwad.components.offline.api.core.network;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.offline.api.core.model.IOfflineCompoJsonParse;
import com.kwad.components.offline.api.core.utils.JsonHelper;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.h;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public abstract class OfflineCompoRequest implements IOfflineCompoRequest {
    private final Map<String, String> mHeader = new HashMap();
    protected final JSONObject mBodyParams = new JSONObject();
    private d mHostRequest = new d() { // from class: com.kwad.components.offline.api.core.network.OfflineCompoRequest.1
        @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
        @Nullable
        public SceneImpl getScene() {
            return null;
        }

        @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
        public String getUrl() {
            return OfflineCompoRequest.this.getUrl();
        }
    };

    public void addHeader(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.mHeader.put(str, str2);
        }
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
    public boolean encryptDisable() {
        return this.mHostRequest.encryptDisable();
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
    public JSONObject getBody() {
        JsonHelper.merge(this.mHostRequest.mBodyParams, this.mBodyParams);
        return this.mHostRequest.getBody();
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
    public Map<String, String> getBodyMap() {
        return null;
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
    public Map<String, String> getHeader() {
        this.mHostRequest.getHeader().putAll(this.mHeader);
        return this.mHostRequest.getHeader();
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
    public String getMethod() {
        return "POST";
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
    public String getRequestHost() {
        return h.yA();
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
    @Nullable
    public final KsScene getScene() {
        return null;
    }

    public void putBody(String str, String str2) {
        JsonHelper.putValue(this.mBodyParams, str, str2);
    }

    public void putBody(String str, double d) {
        JsonHelper.putValue(this.mBodyParams, str, d);
    }

    public void putBody(String str, int i) {
        JsonHelper.putValue(this.mBodyParams, str, i);
    }

    public void putBody(String str, float f) {
        JsonHelper.putValue(this.mBodyParams, str, f);
    }

    public void putBody(String str, byte b) {
        JsonHelper.putValue(this.mBodyParams, str, b);
    }

    public void putBody(String str, long j) {
        JsonHelper.putValue(this.mBodyParams, str, j);
    }

    public void putBody(String str, boolean z) {
        JsonHelper.putValue(this.mBodyParams, str, z);
    }

    public void putBody(String str, JSONObject jSONObject) {
        JsonHelper.putValue(this.mBodyParams, str, jSONObject);
    }

    public void putBody(String str, JSONArray jSONArray) {
        JsonHelper.putValue(this.mBodyParams, str, jSONArray);
    }

    public void putBody(String str, IOfflineCompoJsonParse iOfflineCompoJsonParse) {
        JsonHelper.putValue(this.mBodyParams, str, iOfflineCompoJsonParse);
    }

    public void putBody(String str, List<? extends IOfflineCompoJsonParse> list) {
        JsonHelper.putValue(this.mBodyParams, str, list);
    }

    public void putBody(JSONObject jSONObject) {
        JsonHelper.merge(this.mBodyParams, jSONObject);
    }
}
