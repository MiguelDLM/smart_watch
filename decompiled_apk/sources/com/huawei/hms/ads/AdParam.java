package com.huawei.hms.ads;

import android.location.Location;
import android.os.Bundle;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.data.SearchInfo;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllApi
/* loaded from: classes10.dex */
public class AdParam {
    private q Code;

    @AllApi
    /* loaded from: classes10.dex */
    public static final class Builder {
        private q Code = new j();

        @AllApi
        public Builder addBiddingParamMap(String str, BiddingParam biddingParam) {
            this.Code.Code(str, biddingParam);
            return this;
        }

        @AllApi
        @Deprecated
        public final Builder addKeyword(String str) {
            return this;
        }

        @AllApi
        public final AdParam build() {
            return new AdParam(this);
        }

        @AllApi
        public final Builder setAdContentClassification(String str) {
            this.Code.S(str);
            return this;
        }

        @AllApi
        public final Builder setAppCountry(String str) {
            this.Code.C(str);
            return this;
        }

        @AllApi
        public final Builder setAppInfo(App app) {
            this.Code.Code(app);
            return this;
        }

        @AllApi
        public final Builder setAppLang(String str) {
            this.Code.B(str);
            return this;
        }

        @AllApi
        public final Builder setBelongCountryCode(String str) {
            this.Code.F(str);
            return this;
        }

        @AllApi
        public Builder setBiddingParamMap(Map<String, BiddingParam> map) {
            this.Code.V(map);
            return this;
        }

        @AllApi
        public final Builder setConsent(String str) {
            this.Code.L(str);
            return this;
        }

        @AllApi
        public final Builder setContentBundle(String str) {
            this.Code.a(str);
            return this;
        }

        @AllApi
        public final Builder setDetailedCreativeTypeList(List<Integer> list) {
            this.Code.Code(list);
            return this;
        }

        @AllApi
        public final Builder setExtras(Map<String, Bundle> map) {
            this.Code.Code(map);
            return this;
        }

        @AllApi
        public final Builder setGender(int i) {
            this.Code.Code(i);
            return this;
        }

        @AllApi
        public final Builder setHwNonPersonalizedAd(Integer num) {
            this.Code.Z(num);
            return this;
        }

        @AllApi
        public final Builder setIsQueryUseEnabled(Integer num) {
            this.Code.I(num);
            return this;
        }

        @AllApi
        public final Builder setLocation(Location location) {
            this.Code.Code(location);
            return this;
        }

        @AllApi
        public final Builder setNonPersonalizedAd(Integer num) {
            this.Code.V(num);
            return this;
        }

        @AllApi
        public final Builder setRequestLocation(boolean z) {
            this.Code.V(z);
            return this;
        }

        @AllApi
        public final Builder setRequestOrigin(String str) {
            this.Code.Z(str);
            return this;
        }

        @AllApi
        public final Builder setSearchInfo(SearchInfo searchInfo) {
            this.Code.Code(searchInfo);
            return this;
        }

        @AllApi
        public final Builder setSearchTerm(String str) {
            this.Code.D(str);
            return this;
        }

        @AllApi
        public final Builder setSupportFa(Integer num) {
            this.Code.S(num);
            return this;
        }

        @AllApi
        public final Builder setSupportTemplate(boolean z) {
            this.Code.I(z);
            return this;
        }

        @AllApi
        public Builder setTMax(Integer num) {
            this.Code.F(num);
            return this;
        }

        @AllApi
        public final Builder setTagForChildProtection(Integer num) {
            this.Code.Code(num);
            return this;
        }

        @AllApi
        public final Builder setTagForUnderAgeOfPromise(Integer num) {
            this.Code.C(num);
            return this;
        }

        @AllApi
        public final Builder setTargetingContentUrl(String str) {
            this.Code.I(str);
            return this;
        }

        @AllApi
        public final Builder setThirdNonPersonalizedAd(Integer num) {
            this.Code.B(num);
            return this;
        }
    }

    @AllApi
    /* loaded from: classes10.dex */
    public interface ErrorCode {
        public static final int AD_LOADING = 4;
        public static final int BANNER_AD_CANCEL = 7;
        public static final int BANNER_AD_EXPIRE = 6;
        public static final int HMS_NOT_SUPPORT_SET_APP = 8;
        public static final int INNER = 0;
        public static final int INVALID_REQUEST = 1;
        public static final int LOW_API = 5;
        public static final int NETWORK_ERROR = 2;
        public static final int NO_AD = 3;
    }

    private AdParam(Builder builder) {
        this.Code = builder.Code;
    }

    public List<Integer> B() {
        return this.Code.L();
    }

    public final String C() {
        return this.Code.a();
    }

    public final Location Code() {
        return this.Code.B();
    }

    public String I() {
        return this.Code.V();
    }

    public boolean S() {
        return this.Code.b();
    }

    public RequestOptions V() {
        return this.Code.C();
    }

    public String Z() {
        return this.Code.F();
    }

    @AllApi
    public final int getGender() {
        return this.Code.I();
    }

    @AllApi
    public final Set<String> getKeywords() {
        return this.Code.Z();
    }

    @AllApi
    public String getTargetingContentUrl() {
        return this.Code.Code();
    }

    public BiddingParam Code(String str) {
        return this.Code.b(str);
    }
}
