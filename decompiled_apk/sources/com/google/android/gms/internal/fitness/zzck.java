package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;

/* loaded from: classes9.dex */
public final class zzck extends zza implements IInterface {
    public zzck(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
    }

    public final void zzd(SessionInsertRequest sessionInsertRequest) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, sessionInsertRequest);
        zzk(3, zza);
    }

    public final void zze(SessionReadRequest sessionReadRequest) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, sessionReadRequest);
        zzk(4, zza);
    }

    public final void zzf(com.google.android.gms.fitness.request.zzas zzasVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, zzasVar);
        zzk(5, zza);
    }

    public final void zzg(com.google.android.gms.fitness.request.zzau zzauVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, zzauVar);
        zzk(1, zza);
    }

    public final void zzh(com.google.android.gms.fitness.request.zzaw zzawVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, zzawVar);
        zzk(2, zza);
    }

    public final void zzi(com.google.android.gms.fitness.request.zzay zzayVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, zzayVar);
        zzk(6, zza);
    }
}
