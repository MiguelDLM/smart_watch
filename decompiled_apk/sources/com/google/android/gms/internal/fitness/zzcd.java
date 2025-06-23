package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.StartBleScanRequest;

/* loaded from: classes9.dex */
public final class zzcd extends zza implements IInterface {
    public zzcd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IGoogleFitBleApi");
    }

    public final void zzd(com.google.android.gms.fitness.request.zzf zzfVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, zzfVar);
        zzk(3, zza);
    }

    public final void zze(com.google.android.gms.fitness.request.zzac zzacVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, zzacVar);
        zzk(5, zza);
    }

    public final void zzf(StartBleScanRequest startBleScanRequest) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, startBleScanRequest);
        zzk(1, zza);
    }

    public final void zzg(com.google.android.gms.fitness.request.zzbc zzbcVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, zzbcVar);
        zzk(2, zza);
    }

    public final void zzh(com.google.android.gms.fitness.request.zzbg zzbgVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, zzbgVar);
        zzk(4, zza);
    }
}
