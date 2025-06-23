package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes9.dex */
public final class MapCapabilities {
    private final com.google.android.gms.internal.maps.zzae zza;

    public MapCapabilities(com.google.android.gms.internal.maps.zzae zzaeVar) {
        this.zza = (com.google.android.gms.internal.maps.zzae) Preconditions.checkNotNull(zzaeVar);
    }

    public boolean isAdvancedMarkersAvailable() {
        try {
            return this.zza.zzd();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isDataDrivenStylingAvailable() {
        try {
            return this.zza.zze();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
