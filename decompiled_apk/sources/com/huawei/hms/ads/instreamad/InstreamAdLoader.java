package com.huawei.hms.ads.instreamad;

import android.content.Context;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.y;
import com.huawei.hms.ads.z;

@GlobalApi
/* loaded from: classes10.dex */
public class InstreamAdLoader {
    private y Code;

    @GlobalApi
    /* loaded from: classes10.dex */
    public static class Builder {
        private y Code;

        @GlobalApi
        public Builder(Context context, String str) {
            this.Code = new z(context, str);
        }

        @GlobalApi
        public InstreamAdLoader build() {
            return new InstreamAdLoader(this);
        }

        @GlobalApi
        public Builder setInstreamAdLoadListener(InstreamAdLoadListener instreamAdLoadListener) {
            this.Code.Code(instreamAdLoadListener);
            return this;
        }

        @GlobalApi
        public Builder setMaxCount(int i) {
            this.Code.V(i);
            return this;
        }

        @GlobalApi
        public Builder setTotalDuration(int i) {
            this.Code.Code(i);
            return this;
        }
    }

    private InstreamAdLoader(Builder builder) {
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
}
