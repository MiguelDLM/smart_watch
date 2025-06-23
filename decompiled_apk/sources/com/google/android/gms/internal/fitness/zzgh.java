package com.google.android.gms.internal.fitness;

import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.Objects;

/* loaded from: classes9.dex */
final class zzgh extends zzfw {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    public zzgh(Object[] objArr, int i, int i2) {
        this.zza = objArr;
        this.zzb = i;
        this.zzc = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzfo.zza(i, this.zzc, MapBundleKey.MapObjKey.OBJ_SL_INDEX);
        Object obj = this.zza[i + i + this.zzb];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }
}
