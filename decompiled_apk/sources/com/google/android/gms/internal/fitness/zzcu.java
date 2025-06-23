package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* loaded from: classes9.dex */
public final class zzcu extends zza implements zzcw {
    public zzcu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IStatusCallback");
    }

    @Override // com.google.android.gms.internal.fitness.zzcw
    public final void zzb(Status status) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, status);
        zzl(1, zza);
    }
}
