package com.huawei.hms.ads;

import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.openalliance.ad.annotations.DataKeep;

@DataKeep
@AllApi
/* loaded from: classes10.dex */
public class InformationController {
    private Boolean isUseAndroidId;
    private Boolean isUseBluetooth;
    private Boolean isUseWifi;

    @AllApi
    /* loaded from: classes10.dex */
    public static final class Builder {
        private Boolean Code = null;
        private Boolean V = null;
        private Boolean I = null;

        @AllApi
        public InformationController build() {
            return new InformationController(this);
        }

        @AllApi
        public Builder setUseAndroidId(Boolean bool) {
            this.I = bool;
            return this;
        }

        @AllApi
        public Builder setUseBluetooth(Boolean bool) {
            this.V = bool;
            return this;
        }

        @AllApi
        public Builder setUseWifi(Boolean bool) {
            this.Code = bool;
            return this;
        }
    }

    private InformationController(Builder builder) {
        this.isUseWifi = builder.Code;
        this.isUseBluetooth = builder.V;
        this.isUseAndroidId = builder.I;
    }

    public Boolean Code() {
        return this.isUseWifi;
    }

    public Boolean I() {
        return this.isUseAndroidId;
    }

    public Boolean V() {
        return this.isUseBluetooth;
    }
}
