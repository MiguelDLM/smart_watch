package com.google.android.gms.fitness.request;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.fitness.data.BleDevice;

/* loaded from: classes9.dex */
public final class zze extends zzaa {
    private final ListenerHolder zza;

    @Override // com.google.android.gms.fitness.request.zzab
    public final void zzb(BleDevice bleDevice) {
        this.zza.notifyListener(new zza(this, bleDevice));
    }

    @Override // com.google.android.gms.fitness.request.zzab
    public final void zzc() {
        this.zza.notifyListener(new zzb(this));
    }

    public final void zzd() {
        this.zza.clear();
    }
}
