package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes9.dex */
public abstract class zzaa extends zzb implements zzab {
    public static zzab zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
        if (queryLocalInterface instanceof zzab) {
            return (zzab) queryLocalInterface;
        }
        return new zzz(iBinder);
    }
}
