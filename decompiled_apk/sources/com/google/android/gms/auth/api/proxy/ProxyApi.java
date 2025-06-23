package com.google.android.gms.auth.api.proxy;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
@KeepForSdk
/* loaded from: classes9.dex */
public interface ProxyApi {

    @ShowFirstParty
    @KeepForSdk
    /* loaded from: classes9.dex */
    public interface ProxyResult extends Result {
        @NonNull
        @KeepForSdk
        ProxyResponse getResponse();
    }

    @ShowFirstParty
    @KeepForSdk
    /* loaded from: classes9.dex */
    public interface SpatulaHeaderResult extends Result {
        @NonNull
        @ShowFirstParty
        @KeepForSdk
        String getSpatulaHeader();
    }

    @NonNull
    @Deprecated
    @ShowFirstParty
    @KeepForSdk
    PendingResult<SpatulaHeaderResult> getSpatulaHeader(@NonNull GoogleApiClient googleApiClient);

    @NonNull
    @KeepForSdk
    @Deprecated
    PendingResult<ProxyResult> performProxyRequest(@NonNull GoogleApiClient googleApiClient, @NonNull ProxyRequest proxyRequest);
}
