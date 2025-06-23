package com.jd.ad.sdk.mdt.service;

import androidx.annotation.NonNull;
import com.jd.ad.sdk.dl.model.JADSlot;

/* loaded from: classes10.dex */
public interface JADInitService {
    void createDefaultAdInstance(@NonNull JADSlot jADSlot);

    @NonNull
    String getAdUrl(@NonNull String str);

    int getDs(@NonNull String str);

    float getFeedShakeAngleValue();

    float getFeedShakeSensitivityValue();

    float getFeedShakeTimeValue();

    int getR(@NonNull String str);

    int getSSP();

    int getSen(@NonNull String str);

    float getShakeAngleValue();

    float getShakeSensitivityValue();

    float getShakeTimeValue();

    float getSwipeLength();
}
