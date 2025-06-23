package com.google.android.gms.fitness.data;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes9.dex */
public final class zzt extends com.google.android.gms.internal.fitness.zza implements zzv {
    public zzt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.data.IDataSourceListener");
    }

    @Override // com.google.android.gms.fitness.data.zzv
    public final void zzd(DataPoint dataPoint) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.fitness.zzc.zzc(zza, dataPoint);
        zzl(1, zza);
    }
}
