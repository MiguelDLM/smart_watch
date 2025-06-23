package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes9.dex */
public abstract class zzao extends zzb implements zzap {
    public static zzap zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
        if (queryLocalInterface instanceof zzap) {
            return (zzap) queryLocalInterface;
        }
        return new zzan(iBinder);
    }
}
