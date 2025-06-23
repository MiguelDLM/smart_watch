package com.kwad.sdk.api.model;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@KsAdSdkApi
@Keep
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes11.dex */
public @interface KsNativeConvertType {
    public static final int CONVERT = 1;
    public static final int SHOW_DOWNLOAD_TIPS_DIALOG = 2;
}
