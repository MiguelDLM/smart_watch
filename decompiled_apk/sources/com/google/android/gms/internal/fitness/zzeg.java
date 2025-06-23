package com.google.android.gms.internal.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.data.DataSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class zzeg extends zzav {
    final /* synthetic */ DataSource zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzeg(zzej zzejVar, GoogleApiClient googleApiClient, DataSource dataSource) {
        super(googleApiClient);
        this.zza = dataSource;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzci) ((zzax) anyClient).getService()).zzf(new com.google.android.gms.fitness.request.zzbi(null, this.zza, new zzfb(this)));
    }
}
