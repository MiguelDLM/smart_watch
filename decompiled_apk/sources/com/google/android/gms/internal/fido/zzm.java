package com.google.android.gms.internal.fido;

import android.app.PendingIntent;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;

/* loaded from: classes9.dex */
public interface zzm extends IInterface {
    void zzb(Status status, @Nullable PendingIntent pendingIntent) throws RemoteException;
}
