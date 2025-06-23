package com.google.android.gms.internal.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.data.Subscription;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class zzee extends zzav {
    final /* synthetic */ Subscription zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzee(zzej zzejVar, GoogleApiClient googleApiClient, Subscription subscription) {
        super(googleApiClient);
        this.zza = subscription;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzci) ((zzax) anyClient).getService()).zze(new com.google.android.gms.fitness.request.zzbe(this.zza, false, (zzcw) new zzfb(this)));
    }
}
