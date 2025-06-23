package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataReadResult;

/* loaded from: classes9.dex */
public abstract class zzbs extends zzb implements zzbt {
    public zzbs() {
        super("com.google.android.gms.fitness.internal.IDataReadCallback");
    }

    public static zzbt zzc(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IDataReadCallback");
        if (queryLocalInterface instanceof zzbt) {
            return (zzbt) queryLocalInterface;
        }
        return new zzbr(iBinder);
    }

    @Override // com.google.android.gms.internal.fitness.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            DataReadResult dataReadResult = (DataReadResult) zzc.zza(parcel, DataReadResult.CREATOR);
            zzc.zzb(parcel);
            zzb(dataReadResult);
            return true;
        }
        return false;
    }
}
