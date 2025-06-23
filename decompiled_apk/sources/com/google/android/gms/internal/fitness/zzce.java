package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;

/* loaded from: classes9.dex */
public final class zzce extends zza implements IInterface {
    public zzce(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
    }

    public final void zzd(DataTypeCreateRequest dataTypeCreateRequest) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, dataTypeCreateRequest);
        zzk(1, zza);
    }

    public final void zze(com.google.android.gms.fitness.request.zzv zzvVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, zzvVar);
        zzk(22, zza);
    }

    public final void zzf(com.google.android.gms.fitness.request.zzp zzpVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, zzpVar);
        zzk(2, zza);
    }
}
