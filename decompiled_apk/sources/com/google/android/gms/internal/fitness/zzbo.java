package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DailyTotalResult;

/* loaded from: classes9.dex */
public final class zzbo extends zza implements zzbq {
    public zzbo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IDailyTotalCallback");
    }

    @Override // com.google.android.gms.internal.fitness.zzbq
    public final void zzd(DailyTotalResult dailyTotalResult) throws RemoteException {
        throw null;
    }
}
