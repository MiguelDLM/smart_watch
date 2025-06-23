package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.RemoteException;

/* loaded from: classes9.dex */
public final class zzx extends com.google.android.gms.internal.common.zza implements ICancelToken {
    public zzx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICancelToken");
    }

    @Override // com.google.android.gms.common.internal.ICancelToken
    public final void cancel() throws RemoteException {
        zzD(2, zza());
    }
}
