package com.kwad.components.offline.api.core.adlive.request;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.utils.JsonHelper;
import com.kwad.components.offline.api.core.utils.LiveRequestDataUtils;
import com.kwad.sdk.api.KsScene;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class KSAdLiveEndRequest implements IOfflineCompoRequest {
    private final IAdLiveEndRequest mAdLiveEndRequest;
    private final Map<String, String> mHeader = new HashMap();

    public KSAdLiveEndRequest(IAdLiveEndRequest iAdLiveEndRequest) {
        this.mAdLiveEndRequest = iAdLiveEndRequest;
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
    public boolean encryptDisable() {
        return false;
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
    public JSONObject getBody() {
        return JsonHelper.parseMap2JSON(this.mAdLiveEndRequest.getBodyMap());
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
    public Map<String, String> getBodyMap() {
        return this.mAdLiveEndRequest.getBodyMap();
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
    public Map<String, String> getHeader() {
        IAdLiveEndRequest iAdLiveEndRequest = this.mAdLiveEndRequest;
        if (iAdLiveEndRequest != null && iAdLiveEndRequest.getHeader() != null && this.mAdLiveEndRequest.getHeader().size() > 0) {
            for (String str : this.mAdLiveEndRequest.getHeader().keySet()) {
                if (!TextUtils.isEmpty(this.mAdLiveEndRequest.getHeader().get(str))) {
                    this.mHeader.put(str, this.mAdLiveEndRequest.getHeader().get(str));
                }
            }
            return this.mHeader;
        }
        return this.mHeader;
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
    public String getMethod() {
        return "POST";
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
    public String getRequestHost() {
        return null;
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
    @Nullable
    public KsScene getScene() {
        return null;
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequest
    public String getUrl() {
        return LiveRequestDataUtils.appendUrl(this.mAdLiveEndRequest.getUrl(), this.mAdLiveEndRequest.getUrlParam());
    }
}
