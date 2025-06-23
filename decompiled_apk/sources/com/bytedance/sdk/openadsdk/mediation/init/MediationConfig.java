package com.bytedance.sdk.openadsdk.mediation.init;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class MediationConfig implements IMediationConfig {

    /* renamed from: a, reason: collision with root package name */
    private String f10871a;
    private boolean b;
    private MediationConfigUserInfoForSegment c;
    private Map<String, Object> d;
    private boolean e;
    private JSONObject f;
    private boolean g;
    private String h;
    private boolean i;
    private boolean j;
    private String k;

    /* loaded from: classes8.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private String f10872a;
        private boolean b;
        private MediationConfigUserInfoForSegment c;
        private Map<String, Object> d;
        private boolean e;
        private JSONObject f;
        private boolean g;
        private String h;
        private boolean i;
        private boolean j;
        private String k;

        public MediationConfig build() {
            MediationConfig mediationConfig = new MediationConfig();
            mediationConfig.f10871a = this.f10872a;
            mediationConfig.b = this.b;
            mediationConfig.c = this.c;
            mediationConfig.d = this.d;
            mediationConfig.e = this.e;
            mediationConfig.f = this.f;
            mediationConfig.g = this.g;
            mediationConfig.h = this.h;
            mediationConfig.i = this.i;
            mediationConfig.j = this.j;
            mediationConfig.k = this.k;
            return mediationConfig;
        }

        public Builder setCustomLocalConfig(JSONObject jSONObject) {
            this.f = jSONObject;
            return this;
        }

        public Builder setHttps(boolean z) {
            this.e = z;
            return this;
        }

        @Deprecated
        public Builder setLocalExtra(Map<String, Object> map) {
            this.d = map;
            return this;
        }

        public Builder setMediationConfigUserInfoForSegment(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
            this.c = mediationConfigUserInfoForSegment;
            return this;
        }

        public Builder setOpenAdnTest(boolean z) {
            this.b = z;
            return this;
        }

        public Builder setOpensdkVer(String str) {
            this.h = str;
            return this;
        }

        public Builder setPublisherDid(String str) {
            this.f10872a = str;
            return this;
        }

        public Builder setSupportH265(boolean z) {
            this.i = z;
            return this;
        }

        public Builder setSupportSplashZoomout(boolean z) {
            this.j = z;
            return this;
        }

        public Builder setWxAppId(String str) {
            this.k = str;
            return this;
        }

        public Builder setWxInstalled(boolean z) {
            this.g = z;
            return this;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public JSONObject getCustomLocalConfig() {
        return this.f;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean getHttps() {
        return this.e;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public Map<String, Object> getLocalExtra() {
        return this.d;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public MediationConfigUserInfoForSegment getMediationConfigUserInfoForSegment() {
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String getOpensdkVer() {
        return this.h;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String getPublisherDid() {
        return this.f10871a;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isOpenAdnTest() {
        return this.b;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isSupportH265() {
        return this.i;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isSupportSplashZoomout() {
        return this.j;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isWxInstalled() {
        return this.g;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String wxAppId() {
        return this.k;
    }

    private MediationConfig() {
    }
}
