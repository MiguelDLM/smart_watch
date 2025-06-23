package com.huawei.hms.ads.reward;

import com.huawei.hms.ads.annotation.AllApi;

@AllApi
/* loaded from: classes10.dex */
public class RewardVerifyConfig {
    private String Code;
    private String V;

    @AllApi
    /* loaded from: classes10.dex */
    public static final class Builder {
        private String Code;
        private String V;

        @AllApi
        public RewardVerifyConfig build() {
            return new RewardVerifyConfig(this);
        }

        @AllApi
        public Builder setData(String str) {
            this.Code = str;
            return this;
        }

        @AllApi
        public Builder setUserId(String str) {
            this.V = str;
            return this;
        }
    }

    @AllApi
    private RewardVerifyConfig() {
    }

    @AllApi
    public String getData() {
        return this.Code;
    }

    @AllApi
    public String getUserId() {
        return this.V;
    }

    @AllApi
    private RewardVerifyConfig(Builder builder) {
        if (builder != null) {
            this.Code = builder.Code;
            this.V = builder.V;
        }
    }
}
