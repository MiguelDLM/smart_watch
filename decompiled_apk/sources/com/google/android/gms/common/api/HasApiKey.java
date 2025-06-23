package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.internal.ApiKey;

/* loaded from: classes9.dex */
public interface HasApiKey<O extends Api.ApiOptions> {
    @NonNull
    @KeepForSdk
    ApiKey<O> getApiKey();
}
