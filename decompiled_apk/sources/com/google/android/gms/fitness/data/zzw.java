package com.google.android.gms.fitness.data;

import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@VisibleForTesting
/* loaded from: classes9.dex */
public final class zzw {
    private long zza = 0;
    private long zzb = 0;
    private final List zzc = new ArrayList();
    private int zzd = 0;

    public final zzw zza(LocalDataSet localDataSet) {
        this.zzc.add(localDataSet);
        return this;
    }

    public final zzw zzb(int i) {
        this.zzd = i;
        return this;
    }

    public final zzw zzc(long j, long j2, TimeUnit timeUnit) {
        this.zza = timeUnit.toMillis(j);
        this.zzb = timeUnit.toMillis(j2);
        return this;
    }

    public final LocalBucket zzd() {
        return new LocalBucket(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
