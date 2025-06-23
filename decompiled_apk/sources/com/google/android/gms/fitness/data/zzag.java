package com.google.android.gms.fitness.data;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
/* loaded from: classes9.dex */
public final class zzag {
    private DataSource zza;
    private DataType zzb;
    private int zzc = 0;

    public final zzag zza(DataSource dataSource) {
        this.zza = dataSource;
        return this;
    }

    public final zzag zzb(DataType dataType) {
        this.zzb = dataType;
        return this;
    }

    @ShowFirstParty
    public final zzag zzc(int i) {
        this.zzc = 1;
        return this;
    }

    public final Subscription zzd() {
        boolean z;
        DataSource dataSource;
        boolean z2 = false;
        if (this.zza != null || this.zzb != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Must call setDataSource() or setDataType()");
        DataType dataType = this.zzb;
        if (dataType == null || (dataSource = this.zza) == null || dataType.equals(dataSource.getDataType())) {
            z2 = true;
        }
        Preconditions.checkState(z2, "Specified data type is incompatible with specified data source");
        return new Subscription(this.zza, this.zzb, -1L, 2, this.zzc);
    }
}
