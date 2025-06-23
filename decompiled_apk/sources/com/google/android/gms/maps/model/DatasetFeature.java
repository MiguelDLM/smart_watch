package com.google.android.gms.maps.model;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.maps.zzbl;
import java.util.Map;

/* loaded from: classes9.dex */
public final class DatasetFeature extends Feature {
    private final com.google.android.gms.internal.maps.zzp zza;

    public DatasetFeature(com.google.android.gms.internal.maps.zzp zzpVar) {
        super(zzpVar);
        this.zza = zzpVar;
    }

    @NonNull
    public Map<String, String> getDatasetAttributes() {
        try {
            return zzbl.zzc(this.zza.zzh().entrySet());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @NonNull
    public String getDatasetId() {
        try {
            return this.zza.zze();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
