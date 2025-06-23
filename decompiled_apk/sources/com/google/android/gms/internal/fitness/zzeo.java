package com.google.android.gms.internal.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.data.Session;

/* loaded from: classes9.dex */
final class zzeo extends zzbl {
    final /* synthetic */ Session zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzeo(zzey zzeyVar, GoogleApiClient googleApiClient, Session session) {
        super(googleApiClient);
        this.zza = session;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzck) ((zzbn) anyClient).getService()).zzg(new com.google.android.gms.fitness.request.zzau(this.zza, (zzcw) new zzfb(this)));
    }
}
