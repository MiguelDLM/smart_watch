package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.fitness.result.DataSourcesResult;

/* loaded from: classes9.dex */
public final class zzf extends zzbv {
    private final BaseImplementation.ResultHolder zza;

    public zzf(BaseImplementation.ResultHolder resultHolder) {
        this.zza = resultHolder;
    }

    @Override // com.google.android.gms.internal.fitness.zzbw
    public final void zzb(DataSourcesResult dataSourcesResult) {
        this.zza.setResult(dataSourcesResult);
    }
}
