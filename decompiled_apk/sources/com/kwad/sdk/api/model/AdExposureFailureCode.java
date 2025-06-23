package com.kwad.sdk.api.model;

import androidx.annotation.Keep;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Keep
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes11.dex */
public @interface AdExposureFailureCode {
    public static final int BID_FAILED = 2;
    public static final int CACHE_INVALID = 3;
    public static final int EXPOSURE_PRIORITY_REDUCED = 4;
    public static final int MEDIA_SIDE_PRICE_FILTER = 1;
    public static final int OTHER = 0;
}
