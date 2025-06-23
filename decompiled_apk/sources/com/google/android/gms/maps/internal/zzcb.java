package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes9.dex */
public final class zzcb {
    private zzcb() {
    }

    @Nullable
    public static Parcelable zza(@Nullable Bundle bundle, String str) {
        ClassLoader zzd = zzd();
        bundle.setClassLoader(zzd);
        Bundle bundle2 = bundle.getBundle("map_state");
        if (bundle2 == null) {
            return null;
        }
        bundle2.setClassLoader(zzd);
        return bundle2.getParcelable(str);
    }

    public static void zzb(@Nullable Bundle bundle, @Nullable Bundle bundle2) {
        if (bundle != null && bundle2 != null) {
            Parcelable zza = zza(bundle, "MapOptions");
            if (zza != null) {
                zzc(bundle2, "MapOptions", zza);
            }
            Parcelable zza2 = zza(bundle, "StreetViewPanoramaOptions");
            if (zza2 != null) {
                zzc(bundle2, "StreetViewPanoramaOptions", zza2);
            }
            Parcelable zza3 = zza(bundle, PixelReadParams.DEFAULT_FILTER_ID);
            if (zza3 != null) {
                zzc(bundle2, PixelReadParams.DEFAULT_FILTER_ID, zza3);
            }
            if (bundle.containsKey(RequestParameters.POSITION)) {
                bundle2.putString(RequestParameters.POSITION, bundle.getString(RequestParameters.POSITION));
            }
            if (bundle.containsKey("com.google.android.wearable.compat.extra.LOWBIT_AMBIENT")) {
                bundle2.putBoolean("com.google.android.wearable.compat.extra.LOWBIT_AMBIENT", bundle.getBoolean("com.google.android.wearable.compat.extra.LOWBIT_AMBIENT", false));
            }
        }
    }

    public static void zzc(Bundle bundle, String str, @Nullable Parcelable parcelable) {
        ClassLoader zzd = zzd();
        bundle.setClassLoader(zzd);
        Bundle bundle2 = bundle.getBundle("map_state");
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        bundle2.setClassLoader(zzd);
        bundle2.putParcelable(str, parcelable);
        bundle.putBundle("map_state", bundle2);
    }

    private static ClassLoader zzd() {
        return (ClassLoader) Preconditions.checkNotNull(zzcb.class.getClassLoader());
    }
}
