package com.google.android.gms.internal.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.request.DataUpdateListenerRegistrationRequest;

/* loaded from: classes9.dex */
final class zzds extends zzah {
    final /* synthetic */ DataUpdateListenerRegistrationRequest zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzds(zzdz zzdzVar, GoogleApiClient googleApiClient, DataUpdateListenerRegistrationRequest dataUpdateListenerRegistrationRequest) {
        super(googleApiClient);
        this.zza = dataUpdateListenerRegistrationRequest;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzcg) ((zzaj) anyClient).getService()).zzh(new DataUpdateListenerRegistrationRequest(this.zza, new zzfb(this)));
    }
}
