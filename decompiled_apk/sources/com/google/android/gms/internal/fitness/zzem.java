package com.google.android.gms.internal.fitness;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class zzem extends zzbd {
    final /* synthetic */ com.google.android.gms.fitness.data.zzv zza;
    final /* synthetic */ PendingIntent zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzem(zzen zzenVar, GoogleApiClient googleApiClient, com.google.android.gms.fitness.data.zzv zzvVar, PendingIntent pendingIntent) {
        super(googleApiClient);
        this.zza = zzvVar;
        this.zzb = pendingIntent;
    }

    @Override // com.google.android.gms.internal.fitness.zzbd, com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzcj) ((zzbf) anyClient).getService()).zzf(new com.google.android.gms.fitness.request.zzao(this.zza, this.zzb, new zzfb(this)));
    }
}
