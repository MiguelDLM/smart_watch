package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
/* loaded from: classes9.dex */
public final class zza {
    private long zza = Long.MIN_VALUE;

    public final zza zza(long j) {
        boolean z;
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "intervalMillis can't be negative.");
        this.zza = j;
        return this;
    }

    public final zzb zzb() {
        boolean z;
        if (this.zza != Long.MIN_VALUE) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Must set intervalMillis.");
        return new zzb(this.zza, true, null, null, null, false, null, 0L, null);
    }
}
