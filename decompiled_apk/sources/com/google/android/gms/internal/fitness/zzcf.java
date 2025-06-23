package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.GoalsReadRequest;

/* loaded from: classes9.dex */
public final class zzcf extends zza implements IInterface {
    public zzcf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IGoogleFitGoalsApi");
    }

    public final void zzd(GoalsReadRequest goalsReadRequest) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, goalsReadRequest);
        zzk(1, zza);
    }
}
