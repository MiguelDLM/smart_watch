package com.google.android.gms.internal.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes9.dex */
final class zzcy extends zzk {
    final /* synthetic */ com.google.android.gms.fitness.request.zzab zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcy(zzdf zzdfVar, GoogleApiClient googleApiClient, com.google.android.gms.fitness.request.zzab zzabVar) {
        super(googleApiClient);
        this.zza = zzabVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzcd) ((zzm) anyClient).getService()).zzg(new com.google.android.gms.fitness.request.zzbc(this.zza, new zzfb(this)));
    }
}
