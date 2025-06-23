package com.google.android.gms.maps.model;

import androidx.annotation.NonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes9.dex */
public @interface FeatureType {

    @NonNull
    public static final String ADMINISTRATIVE_AREA_LEVEL_1 = "ADMINISTRATIVE_AREA_LEVEL_1";

    @NonNull
    public static final String ADMINISTRATIVE_AREA_LEVEL_2 = "ADMINISTRATIVE_AREA_LEVEL_2";

    @NonNull
    public static final String COUNTRY = "COUNTRY";

    @NonNull
    public static final String DATASET = "DATASET";

    @NonNull
    public static final String FEATURE_TYPE_UNSPECIFIED = "FEATURE_TYPE_UNSPECIFIED";

    @NonNull
    public static final String LOCALITY = "LOCALITY";

    @NonNull
    public static final String POSTAL_CODE = "POSTAL_CODE";

    @NonNull
    public static final String SCHOOL_DISTRICT = "SCHOOL_DISTRICT";
}
