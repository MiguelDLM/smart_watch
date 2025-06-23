package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes9.dex */
public final class FeatureClickEvent {
    private final com.google.android.gms.internal.maps.zzm zza;

    public FeatureClickEvent(com.google.android.gms.internal.maps.zzm zzmVar) {
        this.zza = (com.google.android.gms.internal.maps.zzm) Preconditions.checkNotNull(zzmVar);
    }

    @NonNull
    public List<Feature> getFeatures() {
        try {
            List zze = this.zza.zze();
            ArrayList arrayList = new ArrayList(zze.size());
            Iterator it = zze.iterator();
            while (it.hasNext()) {
                Feature zza = Feature.zza(com.google.android.gms.internal.maps.zzo.zzb((IBinder) it.next()));
                if (zza != null) {
                    arrayList.add(zza);
                }
            }
            return arrayList;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @NonNull
    public LatLng getLatLng() {
        try {
            return this.zza.zzd();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
