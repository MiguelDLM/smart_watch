package com.google.android.gms.internal.maps;

import com.baidu.platform.comapi.map.MapBundleKey;

/* loaded from: classes9.dex */
public final class zzba {
    public static int zza(int i, int i2, String str) {
        String zza;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i >= 0) {
            if (i2 < 0) {
                throw new IllegalArgumentException("negative size: " + i2);
            }
            zza = zzbb.zza("%s (%s) must be less than size (%s)", MapBundleKey.MapObjKey.OBJ_SL_INDEX, Integer.valueOf(i), Integer.valueOf(i2));
        } else {
            zza = zzbb.zza("%s (%s) must not be negative", MapBundleKey.MapObjKey.OBJ_SL_INDEX, Integer.valueOf(i));
        }
        throw new IndexOutOfBoundsException(zza);
    }

    public static int zzb(int i, int i2, String str) {
        if (i >= 0 && i <= i2) {
            return i;
        }
        throw new IndexOutOfBoundsException(zzd(i, i2, MapBundleKey.MapObjKey.OBJ_SL_INDEX));
    }

    public static void zzc(int i, int i2, int i3) {
        String zzd;
        if (i >= 0 && i2 >= i && i2 <= i3) {
            return;
        }
        if (i >= 0 && i <= i3) {
            if (i2 >= 0 && i2 <= i3) {
                zzd = zzbb.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            } else {
                zzd = zzd(i2, i3, "end index");
            }
        } else {
            zzd = zzd(i, i3, "start index");
        }
        throw new IndexOutOfBoundsException(zzd);
    }

    private static String zzd(int i, int i2, String str) {
        if (i < 0) {
            return zzbb.zza("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return zzbb.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException("negative size: " + i2);
    }
}
