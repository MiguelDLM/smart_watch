package com.google.android.gms.fitness.request;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.fitness.data.DataPoint;

/* loaded from: classes9.dex */
public final class zzaj extends com.google.android.gms.fitness.data.zzu {
    private final ListenerHolder zza;

    public final void zzc() {
        this.zza.clear();
    }

    @Override // com.google.android.gms.fitness.data.zzv
    public final void zzd(DataPoint dataPoint) {
        this.zza.notifyListener(new zzag(this, dataPoint));
    }
}
