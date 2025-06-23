package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.CSJConfig;
import com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;

/* loaded from: classes8.dex */
public final class TTAdConfig extends CSJConfig {

    /* renamed from: a, reason: collision with root package name */
    private ITTLiveTokenInjectionAuth f10648a;

    /* loaded from: classes8.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private ITTLiveTokenInjectionAuth f10649a;
        private CSJConfig.a b = new CSJConfig.a();

        public Builder addExtra(String str, Object obj) {
            this.b.a(str, obj);
            return this;
        }

        public Builder allowShowNotify(boolean z) {
            this.b.b(z);
            return this;
        }

        public Builder appId(String str) {
            this.b.a(str);
            return this;
        }

        public Builder appName(String str) {
            this.b.b(str);
            return this;
        }

        public TTAdConfig build() {
            TTAdConfig tTAdConfig = new TTAdConfig(this.b);
            tTAdConfig.setInjectionAuth(this.f10649a);
            return tTAdConfig;
        }

        public Builder customController(TTCustomController tTCustomController) {
            this.b.a(tTCustomController);
            return this;
        }

        public Builder data(String str) {
            this.b.d(str);
            return this;
        }

        public Builder debug(boolean z) {
            this.b.c(z);
            return this;
        }

        public Builder directDownloadNetworkType(int... iArr) {
            this.b.a(iArr);
            return this;
        }

        public Builder injectionAuth(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
            this.f10649a = iTTLiveTokenInjectionAuth;
            return this;
        }

        public Builder keywords(String str) {
            this.b.c(str);
            return this;
        }

        public Builder paid(boolean z) {
            this.b.a(z);
            return this;
        }

        public Builder setAgeGroup(int i) {
            this.b.d(i);
            return this;
        }

        public Builder setMediationConfig(IMediationConfig iMediationConfig) {
            this.b.a(iMediationConfig);
            return this;
        }

        public Builder setPluginUpdateConfig(int i) {
            this.b.c(i);
            return this;
        }

        public Builder supportMultiProcess(boolean z) {
            this.b.d(z);
            return this;
        }

        public Builder themeStatus(int i) {
            this.b.b(i);
            return this;
        }

        public Builder titleBarTheme(int i) {
            this.b.a(i);
            return this;
        }

        public Builder useMediation(boolean z) {
            this.b.e(z);
            return this;
        }
    }

    public ITTLiveTokenInjectionAuth getInjectionAuth() {
        return this.f10648a;
    }

    public void setInjectionAuth(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
        this.f10648a = iTTLiveTokenInjectionAuth;
    }

    private TTAdConfig(CSJConfig.a aVar) {
        super(aVar);
    }
}
