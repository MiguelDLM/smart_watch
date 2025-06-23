package com.google.android.gms.internal.maps;

import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class zzbo extends zzbi {
    static final zzbi zza = new zzbo(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    public zzbo(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzba.zza(i, this.zzc, MapBundleKey.MapObjKey.OBJ_SL_INDEX);
        Object obj = this.zzb[i];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.maps.zzbi, com.google.android.gms.internal.maps.zzbf
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.maps.zzbf
    public final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.maps.zzbf
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.maps.zzbf
    public final Object[] zze() {
        return this.zzb;
    }
}
