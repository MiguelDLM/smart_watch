package com.kwad.sdk.api.model;

import androidx.annotation.Keep;

@Keep
/* loaded from: classes11.dex */
public class SplashAdExtraData {
    private boolean isDisableRotate;
    private boolean isDisableShake;
    private boolean isDisableSlide;

    public boolean getDisableRotateStatus() {
        return this.isDisableRotate;
    }

    public boolean getDisableShakeStatus() {
        return this.isDisableShake;
    }

    public boolean getDisableSlideStatus() {
        return this.isDisableSlide;
    }

    public void setDisableRotateStatus(boolean z) {
        this.isDisableRotate = z;
    }

    public void setDisableShakeStatus(boolean z) {
        this.isDisableShake = z;
    }

    public void setDisableSlideStatus(boolean z) {
        this.isDisableSlide = z;
    }
}
