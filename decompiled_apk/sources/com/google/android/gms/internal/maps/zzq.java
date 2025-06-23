package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes9.dex */
public final class zzq extends zza implements zzs {
    public zzq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IFeatureLayerDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzs
    public final String zzd() throws RemoteException {
        Parcel zzJ = zzJ(6, zza());
        String readString = zzJ.readString();
        zzJ.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.maps.zzs
    public final String zze() throws RemoteException {
        Parcel zzJ = zzJ(1, zza());
        String readString = zzJ.readString();
        zzJ.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.maps.zzs
    public final void zzf(zzaj zzajVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzg(zza, zzajVar);
        zzc(4, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzs
    public final void zzg(zzaj zzajVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzg(zza, zzajVar);
        zzc(5, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzs
    public final void zzh(zzar zzarVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzg(zza, zzarVar);
        zzc(3, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzs
    public final boolean zzi() throws RemoteException {
        Parcel zzJ = zzJ(2, zza());
        boolean zzh = zzc.zzh(zzJ);
        zzJ.recycle();
        return zzh;
    }
}
