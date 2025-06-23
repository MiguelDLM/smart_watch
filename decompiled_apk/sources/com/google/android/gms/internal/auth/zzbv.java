package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import javax.annotation.Nonnull;

/* loaded from: classes9.dex */
public final class zzbv implements ProxyApi.SpatulaHeaderResult {
    private final Status zza;
    private final String zzb;

    public zzbv(@Nonnull Status status) {
        this.zza = (Status) Preconditions.checkNotNull(status);
        this.zzb = "";
    }

    @Override // com.google.android.gms.auth.api.proxy.ProxyApi.SpatulaHeaderResult
    public final String getSpatulaHeader() {
        return this.zzb;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }

    public zzbv(@Nonnull String str) {
        this.zzb = (String) Preconditions.checkNotNull(str);
        this.zza = Status.RESULT_SUCCESS;
    }
}
