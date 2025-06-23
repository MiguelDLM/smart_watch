package com.kwad.sdk.api.model;

import androidx.annotation.Keep;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Keep
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes11.dex */
public @interface InteractionType {
    public static final int DOWNLOAD = 1;
    public static final int H5 = 2;
    public static final int UNKNOWN = 0;
}
