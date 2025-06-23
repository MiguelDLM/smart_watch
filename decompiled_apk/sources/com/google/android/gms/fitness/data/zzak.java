package com.google.android.gms.fitness.data;

import XIXIX.OOXIXo;
import androidx.annotation.Nullable;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.garmin.fit.xOxOoo;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@ShowFirstParty
/* loaded from: classes9.dex */
public final class zzak {
    public static final double zza;
    public static final double zzb;
    public static final double zzc;
    public static final Set zzd;
    private static final zzak zze;
    private final Map zzf;
    private final Map zzg;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        zza = 10.0d / timeUnit.toNanos(1L);
        zzb = 2000.0d / TimeUnit.HOURS.toNanos(1L);
        zzc = 100.0d / timeUnit.toNanos(1L);
        zzd = Collections.unmodifiableSet(new HashSet(Arrays.asList("altitude", "duration", "food_item", "meal_type", "repetitions", "resistance", "resistance_type")));
        zze = new zzak();
    }

    private zzak() {
        HashMap hashMap = new HashMap();
        hashMap.put("latitude", new zzaj(-90.0d, 90.0d, null));
        hashMap.put("longitude", new zzaj(-180.0d, 180.0d, null));
        hashMap.put("accuracy", new zzaj(OOXIXo.f3760XO, 10000.0d, null));
        hashMap.put("bpm", new zzaj(OOXIXo.f3760XO, 1000.0d, null));
        hashMap.put("altitude", new zzaj(-100000.0d, 100000.0d, null));
        hashMap.put("percentage", new zzaj(OOXIXo.f3760XO, 100.0d, null));
        hashMap.put("confidence", new zzaj(OOXIXo.f3760XO, 100.0d, null));
        hashMap.put("duration", new zzaj(OOXIXo.f3760XO, 9.223372036854776E18d, null));
        hashMap.put("height", new zzaj(OOXIXo.f3760XO, 3.0d, null));
        hashMap.put("weight", new zzaj(OOXIXo.f3760XO, 1000.0d, null));
        hashMap.put(RouteGuideParams.RGKey.AssistInfo.Speed, new zzaj(OOXIXo.f3760XO, 11000.0d, null));
        this.zzg = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("com.google.step_count.delta", zzd("steps", new zzaj(OOXIXo.f3760XO, zza, null)));
        hashMap2.put("com.google.calories.expended", zzd("calories", new zzaj(OOXIXo.f3760XO, zzb, null)));
        hashMap2.put("com.google.distance.delta", zzd(xOxOoo.f15470o00, new zzaj(OOXIXo.f3760XO, zzc, null)));
        this.zzf = Collections.unmodifiableMap(hashMap2);
    }

    public static zzak zzc() {
        return zze;
    }

    private static Map zzd(Object obj, Object obj2) {
        HashMap hashMap = new HashMap();
        hashMap.put(obj, obj2);
        return hashMap;
    }

    @Nullable
    public final zzaj zza(String str) {
        return (zzaj) this.zzg.get(str);
    }

    @Nullable
    public final zzaj zzb(String str, String str2) {
        Map map = (Map) this.zzf.get(str);
        if (map != null) {
            return (zzaj) map.get(str2);
        }
        return null;
    }
}
