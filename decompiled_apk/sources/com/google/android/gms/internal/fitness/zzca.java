package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.GoalsResult;

/* loaded from: classes9.dex */
public final class zzca extends zza implements zzcc {
    public zzca(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.IGoalsReadCallback");
    }

    @Override // com.google.android.gms.internal.fitness.zzcc
    public final void zzd(GoalsResult goalsResult) throws RemoteException {
        throw null;
    }
}
