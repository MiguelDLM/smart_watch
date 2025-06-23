package com.google.android.gms.internal.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.data.DataType;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class zzef extends zzav {
    final /* synthetic */ DataType zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzef(zzej zzejVar, GoogleApiClient googleApiClient, DataType dataType) {
        super(googleApiClient);
        this.zza = dataType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzci) ((zzax) anyClient).getService()).zzf(new com.google.android.gms.fitness.request.zzbi(this.zza, null, new zzfb(this)));
    }
}
