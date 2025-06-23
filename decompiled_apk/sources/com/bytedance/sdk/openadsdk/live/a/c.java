package com.bytedance.sdk.openadsdk.live.a;

import android.app.Activity;
import com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth;
import com.bytedance.android.livehostapi.platform.TokenInfo;
import com.bytedance.android.livehostapi.platform.TokenRefreshCallback;
import com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth;
import com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback;
import com.bytedance.sdk.openadsdk.live.TTLiveToken;
import java.util.Map;

/* loaded from: classes8.dex */
public class c implements IHostTokenInjectionAuth {

    /* renamed from: a, reason: collision with root package name */
    private ITTLiveTokenInjectionAuth f10791a;

    public c(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
        this.f10791a = iTTLiveTokenInjectionAuth;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth
    public TokenInfo getTokenInfo() {
        ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth = this.f10791a;
        if (iTTLiveTokenInjectionAuth == null) {
            return null;
        }
        TTLiveToken tokenInfo = iTTLiveTokenInjectionAuth.getTokenInfo();
        if (tokenInfo == null) {
            return new TokenInfo("", "", "", 0L);
        }
        return new TokenInfo(tokenInfo.name, tokenInfo.openId, tokenInfo.accessToken, tokenInfo.expireAt);
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth
    public boolean isLogin() {
        ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth = this.f10791a;
        if (iTTLiveTokenInjectionAuth != null && iTTLiveTokenInjectionAuth.isLogin()) {
            return true;
        }
        return false;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth
    public void onTokenInvalid(TokenInfo tokenInfo, final TokenRefreshCallback tokenRefreshCallback, Activity activity, Map<String, String> map) {
        TTLiveToken tTLiveToken;
        if (this.f10791a == null) {
            return;
        }
        if (tokenInfo == null) {
            tTLiveToken = null;
        } else {
            tTLiveToken = new TTLiveToken("Venv Test", tokenInfo.getAccessToken(), tokenInfo.getOpenId(), tokenInfo.getExpireAt(), tokenInfo.getName());
        }
        this.f10791a.onTokenInvalid(tTLiveToken, new TTLiveAuthCallback() { // from class: com.bytedance.sdk.openadsdk.live.a.c.1
            @Override // com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback
            public void onAuth(TTLiveToken tTLiveToken2) {
                tokenRefreshCallback.onSuccess(new TokenInfo(tTLiveToken2.name, tTLiveToken2.openId, tTLiveToken2.accessToken, tTLiveToken2.expireAt));
            }

            @Override // com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback
            public void onFailed(Throwable th) {
                tokenRefreshCallback.onFailed(th);
            }
        }, activity, map);
    }
}
