package com.google.android.gms.internal.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.data.BleDevice;

/* loaded from: classes9.dex */
final class zzda extends zzk {
    final /* synthetic */ BleDevice zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzda(zzdf zzdfVar, GoogleApiClient googleApiClient, BleDevice bleDevice) {
        super(googleApiClient);
        this.zza = bleDevice;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        zzfb zzfbVar = new zzfb(this);
        zzcd zzcdVar = (zzcd) ((zzm) anyClient).getService();
        BleDevice bleDevice = this.zza;
        zzcdVar.zzd(new com.google.android.gms.fitness.request.zzf(bleDevice.getAddress(), bleDevice, (zzcw) zzfbVar));
    }
}
