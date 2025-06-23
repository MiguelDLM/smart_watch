package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.data.BleDevice;

/* loaded from: classes9.dex */
public abstract class zzaa extends com.google.android.gms.internal.fitness.zzb implements zzab {
    public zzaa() {
        super("com.google.android.gms.fitness.request.IBleScanCallback");
    }

    @Override // com.google.android.gms.internal.fitness.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            if (i != 2) {
                return false;
            }
            zzc();
        } else {
            BleDevice bleDevice = (BleDevice) com.google.android.gms.internal.fitness.zzc.zza(parcel, BleDevice.CREATOR);
            com.google.android.gms.internal.fitness.zzc.zzb(parcel);
            zzb(bleDevice);
        }
        return true;
    }
}
