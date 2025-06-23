package com.kwad.sdk.api.model;

import androidx.annotation.Keep;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Keep
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes11.dex */
public @interface RewardTaskType {
    public static final int LOOK_LANDING_PAGE = 1;
    public static final int LOOK_VIDEO = 0;
    public static final int USE_APP = 2;
}
