package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.FeatureStyle;

/* loaded from: classes9.dex */
public abstract class zzaq extends zzb implements zzar {
    public zzaq() {
        super("com.google.android.gms.maps.model.internal.IStyleFactory");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzp zznVar;
        if (i == 1) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zznVar = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IFeatureDelegate");
                if (queryLocalInterface instanceof zzp) {
                    zznVar = (zzp) queryLocalInterface;
                } else {
                    zznVar = new zzn(readStrongBinder);
                }
            }
            zzc.zzd(parcel);
            FeatureStyle zzb = zzb(zznVar);
            parcel2.writeNoException();
            zzc.zzf(parcel2, zzb);
            return true;
        }
        return false;
    }
}
