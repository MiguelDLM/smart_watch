package com.google.android.gms.internal.fitness;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.service.FitnessSensorServiceRequest;

/* loaded from: classes9.dex */
public abstract class zzfk extends zzb implements zzfl {
    public zzfk() {
        super("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
    }

    @Override // com.google.android.gms.internal.fitness.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return false;
                }
                zzfi zzfiVar = (zzfi) zzc.zza(parcel, zzfi.CREATOR);
                zzcw zzc = zzcv.zzc(parcel.readStrongBinder());
                zzc.zzb(parcel);
                zzd(zzfiVar, zzc);
            } else {
                FitnessSensorServiceRequest fitnessSensorServiceRequest = (FitnessSensorServiceRequest) zzc.zza(parcel, FitnessSensorServiceRequest.CREATOR);
                zzcw zzc2 = zzcv.zzc(parcel.readStrongBinder());
                zzc.zzb(parcel);
                zzc(fitnessSensorServiceRequest, zzc2);
            }
        } else {
            zzfg zzfgVar = (zzfg) zzc.zza(parcel, zzfg.CREATOR);
            zzbw zzc3 = zzbv.zzc(parcel.readStrongBinder());
            zzc.zzb(parcel);
            zzb(zzfgVar, zzc3);
        }
        return true;
    }
}
