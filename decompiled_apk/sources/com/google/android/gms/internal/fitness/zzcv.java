package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* loaded from: classes9.dex */
public abstract class zzcv extends zzb implements zzcw {
    public zzcv() {
        super("com.google.android.gms.fitness.internal.IStatusCallback");
    }

    public static zzcw zzc(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IStatusCallback");
        if (queryLocalInterface instanceof zzcw) {
            return (zzcw) queryLocalInterface;
        }
        return new zzcu(iBinder);
    }

    @Override // com.google.android.gms.internal.fitness.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            Status status = (Status) zzc.zza(parcel, Status.CREATOR);
            zzc.zzb(parcel);
            zzb(status);
            return true;
        }
        return false;
    }
}
