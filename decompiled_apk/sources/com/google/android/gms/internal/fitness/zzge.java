package com.google.android.gms.internal.fitness;

import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.AbstractMap;
import java.util.Objects;

/* loaded from: classes9.dex */
final class zzge extends zzfw {
    final /* synthetic */ zzgf zza;

    public zzge(zzgf zzgfVar) {
        this.zza = zzgfVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        int i2;
        Object[] objArr;
        Object[] objArr2;
        i2 = this.zza.zzc;
        zzfo.zza(i, i2, MapBundleKey.MapObjKey.OBJ_SL_INDEX);
        objArr = this.zza.zzb;
        int i3 = i + i;
        Object obj = objArr[i3];
        Objects.requireNonNull(obj);
        objArr2 = this.zza.zzb;
        Object obj2 = objArr2[i3 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        int i;
        i = this.zza.zzc;
        return i;
    }
}
