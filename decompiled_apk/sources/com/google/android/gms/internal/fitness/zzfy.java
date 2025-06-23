package com.google.android.gms.internal.fitness;

import java.util.Arrays;

/* loaded from: classes9.dex */
public final class zzfy {
    Object[] zza = new Object[8];
    int zzb = 0;
    zzfx zzc;

    public final zzfy zza(Object obj, Object obj2) {
        int i = this.zzb + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i2 = i + i;
        if (i2 > length) {
            int i3 = length + (length >> 1) + 1;
            if (i3 < i2) {
                int highestOneBit = Integer.highestOneBit(i2 - 1);
                i3 = highestOneBit + highestOneBit;
            }
            if (i3 < 0) {
                i3 = Integer.MAX_VALUE;
            }
            this.zza = Arrays.copyOf(objArr, i3);
        }
        zzfr.zza(obj, obj2);
        Object[] objArr2 = this.zza;
        int i4 = this.zzb;
        int i5 = i4 + i4;
        objArr2[i5] = obj;
        objArr2[i5 + 1] = obj2;
        this.zzb = i4 + 1;
        return this;
    }

    public final zzfz zzb() {
        zzfx zzfxVar = this.zzc;
        if (zzfxVar == null) {
            zzgi zzf = zzgi.zzf(this.zzb, this.zza, this);
            zzfx zzfxVar2 = this.zzc;
            if (zzfxVar2 == null) {
                return zzf;
            }
            throw zzfxVar2.zza();
        }
        throw zzfxVar.zza();
    }
}
