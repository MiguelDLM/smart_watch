package com.huawei.hms.ads.jsb;

import com.huawei.hms.ads.annotation.AllApi;

@AllApi
/* loaded from: classes10.dex */
public class JsbConfig {
    private boolean Code;
    private String I;
    private String V;
    private boolean Z;

    @AllApi
    /* loaded from: classes10.dex */
    public static final class Builder {
        private boolean Code = true;
        private String I;
        private String V;
        private boolean Z;

        @AllApi
        public final JsbConfig build() {
            return new JsbConfig(this);
        }

        @AllApi
        public final Builder enableLog(boolean z) {
            this.Z = z;
            return this;
        }

        @AllApi
        public final Builder enableUserInfo(boolean z) {
            this.Code = z;
            return this;
        }

        @AllApi
        public final Builder initGrs(String str) {
            this.V = str;
            return this;
        }

        @AllApi
        public final Builder initGrs(String str, String str2) {
            this.V = str;
            this.I = str2;
            return this;
        }
    }

    private JsbConfig(Builder builder) {
        this.Code = true;
        this.Code = builder.Code;
        this.V = builder.V;
        this.I = builder.I;
        this.Z = builder.Z;
    }

    public boolean Code() {
        return this.Code;
    }

    public String I() {
        return this.I;
    }

    public String V() {
        return this.V;
    }

    public boolean Z() {
        return this.Z;
    }
}
