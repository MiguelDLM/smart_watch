package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.SessionStopResult;

/* loaded from: classes9.dex */
public abstract class zzcs extends zzb implements zzct {
    public zzcs() {
        super("com.google.android.gms.fitness.internal.ISessionStopCallback");
    }

    public static zzct zzb(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.ISessionStopCallback");
        if (queryLocalInterface instanceof zzct) {
            return (zzct) queryLocalInterface;
        }
        return new zzcr(iBinder);
    }

    @Override // com.google.android.gms.internal.fitness.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            SessionStopResult sessionStopResult = (SessionStopResult) zzc.zza(parcel, SessionStopResult.CREATOR);
            zzc.zzb(parcel);
            zzd(sessionStopResult);
            return true;
        }
        return false;
    }
}
