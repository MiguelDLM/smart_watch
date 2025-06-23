package com.bytedance.sdk.openadsdk.mediation.init;

import androidx.annotation.Nullable;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public interface IMediationConfig {
    @Nullable
    JSONObject getCustomLocalConfig();

    boolean getHttps();

    @Nullable
    Map<String, Object> getLocalExtra();

    @Nullable
    MediationConfigUserInfoForSegment getMediationConfigUserInfoForSegment();

    @Nullable
    String getOpensdkVer();

    @Nullable
    String getPublisherDid();

    boolean isOpenAdnTest();

    boolean isSupportH265();

    boolean isSupportSplashZoomout();

    boolean isWxInstalled();

    @Nullable
    String wxAppId();
}
