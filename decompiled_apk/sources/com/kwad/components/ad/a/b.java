package com.kwad.components.ad.a;

import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.h;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;

/* loaded from: classes11.dex */
public final class b extends com.kwad.sdk.core.network.b {
    public b(String str, List<String> list) {
        putBody("adxId", str);
        putBody("materialIds", new JSONArray((Collection) list));
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
        putBody("protocolVersion", "2.0");
        putBody("SDKVersion", BuildConfig.VERSION_NAME);
        putBody("SDKVersionCode", BuildConfig.VERSION_CODE);
        putBody("sdkApiVersion", ((f) ServiceProvider.get(f.class)).getApiVersion());
        putBody("sdkApiVersionCode", ((f) ServiceProvider.get(f.class)).getApiVersionCode());
        putBody("sdkType", 1);
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return h.yE();
    }
}
