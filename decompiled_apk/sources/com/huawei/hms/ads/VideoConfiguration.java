package com.huawei.hms.ads;

import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.openalliance.ad.annotations.DataKeep;

@DataKeep
@AllApi
/* loaded from: classes10.dex */
public class VideoConfiguration {
    private int audioFocusType;
    private int autoPlayNetwork;
    private boolean clickToFullScreenRequested;
    private boolean customizeOperateRequested;
    private boolean isMute;

    @AllApi
    /* loaded from: classes10.dex */
    public static final class Builder {
        private boolean Code = false;
        private boolean V = false;
        private int I = 0;
        private boolean Z = true;
        private int B = 1;

        @AllApi
        public Builder() {
        }

        @AllApi
        public final VideoConfiguration build() {
            return new VideoConfiguration(this);
        }

        @AllApi
        public Builder setAudioFocusType(int i) {
            this.B = i;
            return this;
        }

        @AllApi
        public Builder setAutoPlayNetwork(int i) {
            this.I = i;
            return this;
        }

        @AllApi
        public Builder setClickToFullScreenRequested(boolean z) {
            this.V = z;
            return this;
        }

        @AllApi
        public Builder setCustomizeOperateRequested(boolean z) {
            this.Code = z;
            return this;
        }

        @AllApi
        public Builder setStartMuted(boolean z) {
            this.Z = z;
            return this;
        }
    }

    private VideoConfiguration(Builder builder) {
        this.customizeOperateRequested = false;
        this.clickToFullScreenRequested = false;
        this.autoPlayNetwork = 0;
        this.isMute = true;
        this.audioFocusType = 1;
        if (builder != null) {
            this.clickToFullScreenRequested = builder.V;
            this.customizeOperateRequested = builder.Code;
            this.audioFocusType = builder.B;
            this.autoPlayNetwork = builder.I;
            this.isMute = builder.Z;
        }
    }

    @AllApi
    public int getAudioFocusType() {
        return this.audioFocusType;
    }

    @AllApi
    public int getAutoPlayNetwork() {
        return this.autoPlayNetwork;
    }

    @AllApi
    public final boolean isClickToFullScreenRequested() {
        return this.clickToFullScreenRequested;
    }

    @AllApi
    public final boolean isCustomizeOperateRequested() {
        return this.customizeOperateRequested;
    }

    @AllApi
    public final boolean isStartMuted() {
        return this.isMute;
    }
}
