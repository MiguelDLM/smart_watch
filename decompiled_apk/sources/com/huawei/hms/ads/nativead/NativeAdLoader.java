package com.huawei.hms.ads.nativead;

import android.content.Context;
import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.i;
import com.huawei.hms.ads.nativead.NativeAd;
import com.huawei.hms.ads.p;

@GlobalApi
/* loaded from: classes10.dex */
public class NativeAdLoader {
    private p Code;

    @GlobalApi
    /* loaded from: classes10.dex */
    public static class Builder {
        private p Code;

        @GlobalApi
        public Builder(Context context, String str) {
            this.Code = new i(context, str);
        }

        @GlobalApi
        public NativeAdLoader build() {
            return new NativeAdLoader(this);
        }

        @GlobalApi
        public Builder setAdListener(AdListener adListener) {
            this.Code.Code(adListener);
            return this;
        }

        @GlobalApi
        public Builder setAdsReturnedFromThread(boolean z) {
            this.Code.Code(z);
            return this;
        }

        @GlobalApi
        public Builder setNativeAdLoadedListener(NativeAd.NativeAdLoadedListener nativeAdLoadedListener) {
            this.Code.Code(nativeAdLoadedListener);
            return this;
        }

        @GlobalApi
        public Builder setNativeAdOptions(NativeAdConfiguration nativeAdConfiguration) {
            this.Code.Code(nativeAdConfiguration);
            return this;
        }
    }

    private NativeAdLoader(Builder builder) {
        this.Code = builder.Code;
    }

    @GlobalApi
    public boolean isLoading() {
        return this.Code.Code();
    }

    @GlobalApi
    public void loadAd(AdParam adParam) {
        this.Code.Code(adParam);
    }

    @GlobalApi
    public void loadAds(AdParam adParam, int i) {
        this.Code.Code(adParam, i);
    }
}
