package com.google.android.gms.maps.model;

import android.os.RemoteException;
import androidx.annotation.NonNull;

/* loaded from: classes9.dex */
public final class PlaceFeature extends Feature {
    private final com.google.android.gms.internal.maps.zzp zza;

    public PlaceFeature(com.google.android.gms.internal.maps.zzp zzpVar) {
        super(zzpVar);
        this.zza = zzpVar;
    }

    @NonNull
    public String getPlaceId() {
        try {
            return this.zza.zzg();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
