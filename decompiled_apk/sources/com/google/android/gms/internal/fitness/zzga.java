package com.google.android.gms.internal.fitness;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* loaded from: classes9.dex */
public abstract class zzga extends zzft implements Set {

    @CheckForNull
    private transient zzfw zza;

    public static int zzf(int i) {
        int max = Math.max(i, 2);
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1);
            do {
                highestOneBit += highestOneBit;
            } while (highestOneBit * 0.7d < max);
            return highestOneBit;
        }
        if (max < 1073741824) {
            return 1073741824;
        }
        throw new IllegalArgumentException("collection too large");
    }

    public static zzga zzi(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return zzk(5, obj, obj2, obj3, obj4, obj5);
    }

    private static zzga zzk(int i, Object... objArr) {
        if (i != 0) {
            if (i != 1) {
                int zzf = zzf(i);
                Object[] objArr2 = new Object[zzf];
                int i2 = zzf - 1;
                int i3 = 0;
                int i4 = 0;
                for (int i5 = 0; i5 < i; i5++) {
                    Object obj = objArr[i5];
                    zzgc.zza(obj, i5);
                    int hashCode = obj.hashCode();
                    int zza = zzfs.zza(hashCode);
                    while (true) {
                        int i6 = zza & i2;
                        Object obj2 = objArr2[i6];
                        if (obj2 == null) {
                            objArr[i4] = obj;
                            objArr2[i6] = obj;
                            i3 += hashCode;
                            i4++;
                            break;
                        }
                        if (!obj2.equals(obj)) {
                            zza++;
                        }
                    }
                }
                Arrays.fill(objArr, i4, i, (Object) null);
                if (i4 == 1) {
                    Object obj3 = objArr[0];
                    Objects.requireNonNull(obj3);
                    return new zzgl(obj3);
                }
                if (zzf(i4) >= zzf / 2) {
                    if (i4 < 3) {
                        objArr = Arrays.copyOf(objArr, i4);
                    }
                    return new zzgj(objArr, i3, objArr2, i2, i4);
                }
                return zzk(i4, objArr);
            }
            Object obj4 = objArr[0];
            Objects.requireNonNull(obj4);
            return new zzgl(obj4);
        }
        return zzgj.zza;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzga) && zzj() && ((zzga) obj).zzj() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    if (containsAll(set)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return zzgk.zza(this);
    }

    @Override // com.google.android.gms.internal.fitness.zzft, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zzd */
    public abstract zzgm iterator();

    public final zzfw zzg() {
        zzfw zzfwVar = this.zza;
        if (zzfwVar == null) {
            zzfw zzh = zzh();
            this.zza = zzh;
            return zzh;
        }
        return zzfwVar;
    }

    public zzfw zzh() {
        Object[] array = toArray();
        int i = zzfw.zzd;
        return zzfw.zzg(array, array.length);
    }

    public boolean zzj() {
        return false;
    }
}
