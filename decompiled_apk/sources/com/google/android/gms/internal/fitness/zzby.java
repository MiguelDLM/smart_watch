package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataTypeResult;

/* loaded from: classes9.dex */
public abstract class zzby extends zzb implements zzbz {
    public zzby() {
        super("com.google.android.gms.fitness.internal.IDataTypeCallback");
    }

    public static zzbz zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IDataTypeCallback");
        if (queryLocalInterface instanceof zzbz) {
            return (zzbz) queryLocalInterface;
        }
        return new zzbx(iBinder);
    }

    @Override // com.google.android.gms.internal.fitness.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            DataTypeResult dataTypeResult = (DataTypeResult) zzc.zza(parcel, DataTypeResult.CREATOR);
            zzc.zzb(parcel);
            zzd(dataTypeResult);
            return true;
        }
        return false;
    }
}
