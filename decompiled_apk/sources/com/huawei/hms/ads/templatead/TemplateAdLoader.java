package com.huawei.hms.ads.templatead;

import android.content.Context;
import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.i;
import com.huawei.hms.ads.nativead.NativeAdConfiguration;
import com.huawei.hms.ads.p;

@AllApi
/* loaded from: classes10.dex */
public class TemplateAdLoader {
    private p Code;

    @AllApi
    /* loaded from: classes10.dex */
    public static class Builder {
        private p Code;

        @GlobalApi
        public Builder(Context context, String str) {
            this.Code = new i(context, str);
        }

        @GlobalApi
        public TemplateAdLoader build() {
            return new TemplateAdLoader(this);
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
        public Builder setNativeAdOptions(NativeAdConfiguration nativeAdConfiguration) {
            this.Code.Code(nativeAdConfiguration);
            return this;
        }

        @GlobalApi
        public Builder setTemplateAdListener(TemplateAdListener templateAdListener) {
            return this;
        }
    }

    private TemplateAdLoader(Builder builder) {
        this.Code = builder.Code;
    }

    @AllApi
    public void loadNativeAd(AdParam adParam) {
        this.Code.Code(adParam);
    }
}
