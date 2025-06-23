package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.accounttransfer.DeviceMetaData;
import com.google.android.gms.common.api.Status;

/* loaded from: classes9.dex */
public abstract class zzas extends zzb implements zzat {
    public zzas() {
        super("com.google.android.gms.auth.api.accounttransfer.internal.IAccountTransferCallbacks");
    }

    @Override // com.google.android.gms.internal.auth.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                Status status = (Status) zzc.zza(parcel, Status.CREATOR);
                zzc.zzb(parcel);
                zzh(status);
                return true;
            case 2:
                Status status2 = (Status) zzc.zza(parcel, Status.CREATOR);
                com.google.android.gms.auth.api.accounttransfer.zzw zzwVar = (com.google.android.gms.auth.api.accounttransfer.zzw) zzc.zza(parcel, com.google.android.gms.auth.api.accounttransfer.zzw.CREATOR);
                zzc.zzb(parcel);
                zzf(status2, zzwVar);
                return true;
            case 3:
                Status status3 = (Status) zzc.zza(parcel, Status.CREATOR);
                com.google.android.gms.auth.api.accounttransfer.zzo zzoVar = (com.google.android.gms.auth.api.accounttransfer.zzo) zzc.zza(parcel, com.google.android.gms.auth.api.accounttransfer.zzo.CREATOR);
                zzc.zzb(parcel);
                zzg(status3, zzoVar);
                return true;
            case 4:
                zze();
                return true;
            case 5:
                Status status4 = (Status) zzc.zza(parcel, Status.CREATOR);
                zzc.zzb(parcel);
                zzd(status4);
                return true;
            case 6:
                byte[] createByteArray = parcel.createByteArray();
                zzc.zzb(parcel);
                zzb(createByteArray);
                return true;
            case 7:
                DeviceMetaData deviceMetaData = (DeviceMetaData) zzc.zza(parcel, DeviceMetaData.CREATOR);
                zzc.zzb(parcel);
                zzc(deviceMetaData);
                return true;
            default:
                return false;
        }
    }
}
