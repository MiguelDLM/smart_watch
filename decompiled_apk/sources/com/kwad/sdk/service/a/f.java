package com.kwad.sdk.service.a;

import android.content.Context;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public interface f {
    void a(String str, Map<String, String> map, String str2);

    boolean aG(AdTemplate adTemplate);

    String am(String str);

    String getApiVersion();

    int getApiVersionCode();

    String getAppId();

    String getAppName();

    Context getContext();

    String getSDKVersion();

    boolean pj();

    com.kwad.sdk.core.response.b.g uh();

    boolean yV();

    boolean yW();

    boolean yX();

    boolean yY();

    String yZ();

    com.kwad.sdk.core.b za();

    List<AdTemplate> zb();

    String zc();

    JSONObject zd();

    JSONObject ze();

    Map<String, String> zf();
}
