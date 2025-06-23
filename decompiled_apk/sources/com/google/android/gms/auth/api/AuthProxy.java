package com.google.android.gms.auth.api;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyClient;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.auth.zzbo;
import com.google.android.gms.internal.auth.zzbt;

@ShowFirstParty
@KeepForSdk
/* loaded from: classes9.dex */
public final class AuthProxy {

    @NonNull
    @ShowFirstParty
    @KeepForSdk
    public static final Api<AuthProxyOptions> API;

    @NonNull
    @ShowFirstParty
    @KeepForSdk
    public static final ProxyApi ProxyApi;

    @NonNull
    public static final Api.ClientKey zza;
    private static final Api.AbstractClientBuilder zzb;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zza = clientKey;
        zza zzaVar = new zza();
        zzb = zzaVar;
        API = new Api<>("Auth.PROXY_API", zzaVar, clientKey);
        ProxyApi = new zzbt();
    }

    @NonNull
    @KeepForSdk
    public static ProxyClient getClient(@NonNull Activity activity, @Nullable AuthProxyOptions authProxyOptions) {
        return new zzbo(activity, authProxyOptions);
    }

    @NonNull
    @KeepForSdk
    public static ProxyClient getClient(@NonNull Context context, @Nullable AuthProxyOptions authProxyOptions) {
        return new zzbo(context, authProxyOptions);
    }
}
