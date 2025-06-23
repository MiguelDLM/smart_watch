package com.google.android.gms.internal.fido;

import com.baidu.platform.comapi.map.MapBundleKey;

/* loaded from: classes9.dex */
public final class zzam {
    public static int zza(int i, int i2, String str) {
        String zza;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i >= 0) {
            if (i2 < 0) {
                throw new IllegalArgumentException("negative size: " + i2);
            }
            zza = zzan.zza("%s (%s) must be less than size (%s)", MapBundleKey.MapObjKey.OBJ_SL_INDEX, Integer.valueOf(i), Integer.valueOf(i2));
        } else {
            zza = zzan.zza("%s (%s) must not be negative", MapBundleKey.MapObjKey.OBJ_SL_INDEX, Integer.valueOf(i));
        }
        throw new IndexOutOfBoundsException(zza);
    }

    public static int zzb(int i, int i2, String str) {
        if (i >= 0 && i <= i2) {
            return i;
        }
        throw new IndexOutOfBoundsException(zzf(i, i2, MapBundleKey.MapObjKey.OBJ_SL_INDEX));
    }

    public static void zzc(boolean z) {
        if (z) {
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void zzd(boolean z, String str, char c) {
        if (z) {
        } else {
            throw new IllegalArgumentException(zzan.zza(str, Character.valueOf(c)));
        }
    }

    public static void zze(int i, int i2, int i3) {
        String zzf;
        if (i >= 0 && i2 >= i && i2 <= i3) {
            return;
        }
        if (i >= 0 && i <= i3) {
            if (i2 >= 0 && i2 <= i3) {
                zzf = zzan.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            } else {
                zzf = zzf(i2, i3, "end index");
            }
        } else {
            zzf = zzf(i, i3, "start index");
        }
        throw new IndexOutOfBoundsException(zzf);
    }

    private static String zzf(int i, int i2, String str) {
        if (i < 0) {
            return zzan.zza("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return zzan.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException("negative size: " + i2);
    }
}
