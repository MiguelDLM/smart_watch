package com.bytedance.sdk.openadsdk.mediation;

/* loaded from: classes8.dex */
public interface IMediationDrawAdTokenCallback {
    void onAdTokenLoaded(String str, IMediationDrawTokenInfo iMediationDrawTokenInfo);

    void onAdTokenLoadedFail(int i, String str);
}
