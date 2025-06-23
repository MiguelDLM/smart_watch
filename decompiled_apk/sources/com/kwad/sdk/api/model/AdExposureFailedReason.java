package com.kwad.sdk.api.model;

import androidx.annotation.Keep;

@Keep
/* loaded from: classes11.dex */
public class AdExposureFailedReason {
    public String adnName;
    public int adnType;
    public int winEcpm;

    public AdExposureFailedReason setAdnName(String str) {
        this.adnName = str;
        return this;
    }

    public AdExposureFailedReason setAdnType(int i) {
        this.adnType = i;
        return this;
    }

    public AdExposureFailedReason setWinEcpm(int i) {
        this.winEcpm = i;
        return this;
    }
}
