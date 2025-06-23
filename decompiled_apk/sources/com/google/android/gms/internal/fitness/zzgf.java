package com.google.android.gms.internal.fitness;

import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* loaded from: classes9.dex */
final class zzgf extends zzga {
    private final transient zzfz zza;
    private final transient Object[] zzb;
    private final transient int zzc;

    public zzgf(zzfz zzfzVar, Object[] objArr, int i, int i2) {
        this.zza = zzfzVar;
        this.zzb = objArr;
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.fitness.zzft, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.zza.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.fitness.zzga, com.google.android.gms.internal.fitness.zzft, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zzg().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.fitness.zzft
    public final int zza(Object[] objArr, int i) {
        return zzg().zza(objArr, 0);
    }

    @Override // com.google.android.gms.internal.fitness.zzga, com.google.android.gms.internal.fitness.zzft
    /* renamed from: zzd */
    public final zzgm iterator() {
        return zzg().listIterator(0);
    }

    @Override // com.google.android.gms.internal.fitness.zzga
    public final zzfw zzh() {
        return new zzge(this);
    }
}
