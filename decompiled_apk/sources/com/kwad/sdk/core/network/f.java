package com.kwad.sdk.core.network;

import androidx.annotation.Nullable;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public interface f {
    JSONObject getBody();

    Map<String, String> getBodyMap();

    Map<String, String> getHeader();

    @Nullable
    SceneImpl getScene();

    String getUrl();
}
