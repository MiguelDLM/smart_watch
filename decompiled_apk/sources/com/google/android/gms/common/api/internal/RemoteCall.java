package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes9.dex */
public interface RemoteCall<T, U> {
    @KeepForSdk
    void accept(@NonNull T t, @NonNull U u) throws RemoteException;
}
