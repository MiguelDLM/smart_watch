package com.bytedance.android.livehostapi.platform;

/* loaded from: classes8.dex */
public interface TokenRefreshCallback {
    void onFailed(Throwable th);

    void onSuccess(TokenInfo tokenInfo);
}
