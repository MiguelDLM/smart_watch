package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.SessionReadResult;

/* loaded from: classes9.dex */
public final class zzco extends zza implements zzcq {
    public zzco(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.internal.ISessionReadCallback");
    }

    @Override // com.google.android.gms.internal.fitness.zzcq
    public final void zzd(SessionReadResult sessionReadResult) throws RemoteException {
        throw null;
    }
}
