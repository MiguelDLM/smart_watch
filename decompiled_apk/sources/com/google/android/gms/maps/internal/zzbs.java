package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes9.dex */
public abstract class zzbs extends com.google.android.gms.internal.maps.zzb implements zzbt {
    public zzbs() {
        super("com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        IStreetViewPanoramaDelegate zzbxVar;
        if (i == 1) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzbxVar = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                if (queryLocalInterface instanceof IStreetViewPanoramaDelegate) {
                    zzbxVar = (IStreetViewPanoramaDelegate) queryLocalInterface;
                } else {
                    zzbxVar = new zzbx(readStrongBinder);
                }
            }
            com.google.android.gms.internal.maps.zzc.zzd(parcel);
            zzb(zzbxVar);
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
