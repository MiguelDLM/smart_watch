package com.google.android.gms.internal.fido;

import android.app.PendingIntent;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* loaded from: classes9.dex */
public interface zzr extends IInterface {
    void zzb(Status status, PendingIntent pendingIntent) throws RemoteException;
}
