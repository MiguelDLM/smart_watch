package com.kwad.sdk.api.model;

import androidx.annotation.Keep;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Keep
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes11.dex */
public @interface ThirdAge {
    public static final int AGE_BELOW_FIFTY = 4;
    public static final int AGE_BELOW_THIRTY = 2;
    public static final int AGE_MIDDLE = 3;
    public static final int AGE_UNKNOW = 0;
    public static final int AGE_UP_FIFTY = 5;
    public static final int AGE_YOUNG = 1;
}
