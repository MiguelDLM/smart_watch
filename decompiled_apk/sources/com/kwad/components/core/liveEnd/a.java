package com.kwad.components.core.liveEnd;

import android.text.TextUtils;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.sdk.core.network.b;
import com.kwad.sdk.utils.as;
import java.util.Map;

/* loaded from: classes11.dex */
public final class a extends b {
    private IAdLiveEndRequest ga;

    public a(IAdLiveEndRequest iAdLiveEndRequest) {
        this.ga = iAdLiveEndRequest;
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final Map<String, String> getBodyMap() {
        return this.ga.getBodyMap();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final Map<String, String> getHeader() {
        IAdLiveEndRequest iAdLiveEndRequest = this.ga;
        if (iAdLiveEndRequest != null && iAdLiveEndRequest.getHeader() != null && this.ga.getHeader().size() > 0) {
            for (String str : this.ga.getHeader().keySet()) {
                if (!TextUtils.isEmpty(this.ga.getHeader().get(str))) {
                    addHeader(str, this.ga.getHeader().get(str));
                }
            }
            return super.getHeader();
        }
        return super.getHeader();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return as.appendUrl(this.ga.getUrl(), this.ga.getUrlParam());
    }
}
