package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes9.dex */
public final class zzci extends zza implements IInterface {
    public zzci(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
    }

    public final void zzd(com.google.android.gms.fitness.request.zzae zzaeVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, zzaeVar);
        zzk(3, zza);
    }

    public final void zze(com.google.android.gms.fitness.request.zzbe zzbeVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, zzbeVar);
        zzk(1, zza);
    }

    public final void zzf(com.google.android.gms.fitness.request.zzbi zzbiVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, zzbiVar);
        zzk(2, zza);
    }
}
