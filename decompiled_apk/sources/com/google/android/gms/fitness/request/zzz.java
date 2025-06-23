package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.fitness.data.BleDevice;

/* loaded from: classes9.dex */
public final class zzz extends com.google.android.gms.internal.fitness.zza implements zzab {
    public zzz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fitness.request.IBleScanCallback");
    }

    @Override // com.google.android.gms.fitness.request.zzab
    public final void zzb(BleDevice bleDevice) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.fitness.request.zzab
    public final void zzc() throws RemoteException {
        throw null;
    }
}
