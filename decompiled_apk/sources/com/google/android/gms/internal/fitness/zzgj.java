package com.google.android.gms.internal.fitness;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* loaded from: classes9.dex */
final class zzgj extends zzga {
    static final zzgj zza;
    private static final Object[] zzd;
    final transient Object[] zzb;
    final transient Object[] zzc;
    private final transient int zze;
    private final transient int zzf;
    private final transient int zzg;

    static {
        Object[] objArr = new Object[0];
        zzd = objArr;
        zza = new zzgj(objArr, 0, objArr, 0, 0);
    }

    public zzgj(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.zzb = objArr;
        this.zze = i;
        this.zzc = objArr2;
        this.zzf = i2;
        this.zzg = i3;
    }

    @Override // com.google.android.gms.internal.fitness.zzft, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        if (obj != null) {
            Object[] objArr = this.zzc;
            if (objArr.length != 0) {
                int zza2 = zzfs.zza(obj.hashCode());
                while (true) {
                    int i = zza2 & this.zzf;
                    Object obj2 = objArr[i];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    zza2 = i + 1;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.fitness.zzga, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.fitness.zzga, com.google.android.gms.internal.fitness.zzft, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zzg().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.fitness.zzft
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzg);
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.fitness.zzft
    public final int zzb() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.fitness.zzft
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.fitness.zzga, com.google.android.gms.internal.fitness.zzft
    /* renamed from: zzd */
    public final zzgm iterator() {
        return zzg().listIterator(0);
    }

    @Override // com.google.android.gms.internal.fitness.zzft
    public final Object[] zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.fitness.zzga
    public final zzfw zzh() {
        return zzfw.zzg(this.zzb, this.zzg);
    }

    @Override // com.google.android.gms.internal.fitness.zzga
    public final boolean zzj() {
        return true;
    }
}
