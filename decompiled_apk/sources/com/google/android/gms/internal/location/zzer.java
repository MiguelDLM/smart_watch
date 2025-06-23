package com.google.android.gms.internal.location;

import com.baidu.platform.comapi.map.MapBundleKey;
import javax.annotation.CheckForNull;

/* loaded from: classes9.dex */
public final class zzer {
    public static void zza(boolean z) {
        if (z) {
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void zzb(boolean z, @CheckForNull Object obj) {
        if (z) {
        } else {
            throw new IllegalArgumentException((String) obj);
        }
    }

    public static int zzc(int i, int i2, String str) {
        String zza;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i >= 0) {
            if (i2 < 0) {
                StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 15);
                sb.append("negative size: ");
                sb.append(i2);
                throw new IllegalArgumentException(sb.toString());
            }
            zza = zzes.zza("%s (%s) must be less than size (%s)", MapBundleKey.MapObjKey.OBJ_SL_INDEX, Integer.valueOf(i), Integer.valueOf(i2));
        } else {
            zza = zzes.zza("%s (%s) must not be negative", MapBundleKey.MapObjKey.OBJ_SL_INDEX, Integer.valueOf(i));
        }
        throw new IndexOutOfBoundsException(zza);
    }

    public static int zzd(int i, int i2, String str) {
        if (i >= 0 && i <= i2) {
            return i;
        }
        throw new IndexOutOfBoundsException(zzf(i, i2, MapBundleKey.MapObjKey.OBJ_SL_INDEX));
    }

    public static void zze(int i, int i2, int i3) {
        String zzf;
        if (i >= 0 && i2 >= i && i2 <= i3) {
            return;
        }
        if (i >= 0 && i <= i3) {
            if (i2 >= 0 && i2 <= i3) {
                zzf = zzes.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
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
            return zzes.zza("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return zzes.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 15);
        sb.append("negative size: ");
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }
}
