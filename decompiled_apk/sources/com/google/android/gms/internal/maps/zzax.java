package com.google.android.gms.internal.maps;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Tile;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public interface zzax extends IInterface {
    @Nullable
    Tile zzb(int i, int i2, int i3) throws RemoteException;
}
