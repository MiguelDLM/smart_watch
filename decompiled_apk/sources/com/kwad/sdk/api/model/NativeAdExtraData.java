package com.kwad.sdk.api.model;

import androidx.annotation.Keep;

@Keep
/* loaded from: classes11.dex */
public class NativeAdExtraData {
    private boolean enableShake;
    private int showLiveStatus;
    private int showLiveStyle;

    public int getShowLiveStatus() {
        return this.showLiveStatus;
    }

    public int getShowLiveStyle() {
        return this.showLiveStyle;
    }

    public boolean isEnableShake() {
        return this.enableShake;
    }

    public NativeAdExtraData setEnableShake(boolean z) {
        this.enableShake = z;
        return this;
    }

    public NativeAdExtraData setShowLiveStatus(int i) {
        this.showLiveStatus = i;
        return this;
    }

    public NativeAdExtraData setShowLiveStyle(int i) {
        this.showLiveStyle = i;
        return this;
    }
}
