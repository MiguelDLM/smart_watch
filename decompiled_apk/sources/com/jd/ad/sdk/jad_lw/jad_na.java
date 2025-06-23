package com.jd.ad.sdk.jad_lw;

import XXO0.oIX0oI;
import android.graphics.Bitmap;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

@RequiresApi(19)
/* loaded from: classes10.dex */
public class jad_na implements jad_ly {
    public static final Bitmap.Config[] jad_dq;
    public static final Bitmap.Config[] jad_er;
    public static final Bitmap.Config[] jad_fs;
    public static final Bitmap.Config[] jad_hu;
    public static final Bitmap.Config[] jad_jt;
    public final jad_cp jad_an = new jad_cp();
    public final jad_hu<jad_bo, Bitmap> jad_bo = new jad_hu<>();
    public final Map<Bitmap.Config, NavigableMap<Integer, Integer>> jad_cp = new HashMap();

    /* loaded from: classes10.dex */
    public static /* synthetic */ class jad_an {
        public static final /* synthetic */ int[] jad_an;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            jad_an = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                jad_an[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                jad_an[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                jad_an[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @VisibleForTesting
    /* loaded from: classes10.dex */
    public static final class jad_bo implements jad_mz {
        public final jad_cp jad_an;
        public int jad_bo;
        public Bitmap.Config jad_cp;

        public jad_bo(jad_cp jad_cpVar) {
            this.jad_an = jad_cpVar;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof jad_bo)) {
                return false;
            }
            jad_bo jad_boVar = (jad_bo) obj;
            return this.jad_bo == jad_boVar.jad_bo && com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_cp, jad_boVar.jad_cp);
        }

        public int hashCode() {
            int i = this.jad_bo * 31;
            Bitmap.Config config = this.jad_cp;
            return i + (config != null ? config.hashCode() : 0);
        }

        @Override // com.jd.ad.sdk.jad_lw.jad_mz
        public void jad_an() {
            jad_cp jad_cpVar = this.jad_an;
            if (jad_cpVar.jad_an.size() < 20) {
                jad_cpVar.jad_an.offer(this);
            }
        }

        public String toString() {
            return jad_na.jad_an(this.jad_bo, this.jad_cp);
        }
    }

    @VisibleForTesting
    /* loaded from: classes10.dex */
    public static class jad_cp extends jad_dq<jad_bo> {
        @Override // com.jd.ad.sdk.jad_lw.jad_dq
        public jad_bo jad_an() {
            return new jad_bo(this);
        }

        public jad_bo jad_an(int i, Bitmap.Config config) {
            jad_bo jad_bo = jad_bo();
            jad_bo.jad_bo = i;
            jad_bo.jad_cp = config;
            return jad_bo;
        }
    }

    static {
        Bitmap.Config config;
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            int length = configArr.length - 1;
            config = Bitmap.Config.RGBA_F16;
            configArr[length] = config;
        }
        jad_dq = configArr;
        jad_er = configArr;
        jad_fs = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        jad_jt = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        jad_hu = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    @Override // com.jd.ad.sdk.jad_lw.jad_ly
    @Nullable
    public Bitmap jad_an() {
        Bitmap jad_an2 = this.jad_bo.jad_an();
        if (jad_an2 != null) {
            jad_an(Integer.valueOf(com.jd.ad.sdk.jad_gp.jad_ly.jad_an(jad_an2)), jad_an2);
        }
        return jad_an2;
    }

    @Override // com.jd.ad.sdk.jad_lw.jad_ly
    public String jad_bo(Bitmap bitmap) {
        return jad_an(com.jd.ad.sdk.jad_gp.jad_ly.jad_an(bitmap), bitmap.getConfig());
    }

    @Override // com.jd.ad.sdk.jad_lw.jad_ly
    public int jad_cp(Bitmap bitmap) {
        return com.jd.ad.sdk.jad_gp.jad_ly.jad_an(bitmap);
    }

    public String toString() {
        StringBuilder jad_an2 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("SizeConfigStrategy{groupedMap=");
        jad_an2.append(this.jad_bo);
        jad_an2.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.jad_cp.entrySet()) {
            jad_an2.append(entry.getKey());
            jad_an2.append('[');
            jad_an2.append(entry.getValue());
            jad_an2.append("], ");
        }
        if (!this.jad_cp.isEmpty()) {
            jad_an2.replace(jad_an2.length() - 2, jad_an2.length(), "");
        }
        jad_an2.append(")}");
        return jad_an2.toString();
    }

    public static String jad_an(int i, Bitmap.Config config) {
        return "[" + i + "](" + config + oIX0oI.I0Io.f4095I0Io;
    }

    public final NavigableMap<Integer, Integer> jad_bo(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.jad_cp.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.jad_cp.put(config, treeMap);
        return treeMap;
    }

    @Override // com.jd.ad.sdk.jad_lw.jad_ly
    public void jad_an(Bitmap bitmap) {
        jad_bo jad_an2 = this.jad_an.jad_an(com.jd.ad.sdk.jad_gp.jad_ly.jad_an(bitmap), bitmap.getConfig());
        this.jad_bo.jad_an(jad_an2, bitmap);
        NavigableMap<Integer, Integer> jad_bo2 = jad_bo(bitmap.getConfig());
        Integer num = jad_bo2.get(Integer.valueOf(jad_an2.jad_bo));
        jad_bo2.put(Integer.valueOf(jad_an2.jad_bo), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.jd.ad.sdk.jad_lw.jad_ly
    public String jad_bo(int i, int i2, Bitmap.Config config) {
        return jad_an(com.jd.ad.sdk.jad_gp.jad_ly.jad_an(config) * i * i2, config);
    }

    public final void jad_an(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> jad_bo2 = jad_bo(bitmap.getConfig());
        Integer num2 = jad_bo2.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                jad_bo2.remove(num);
                return;
            } else {
                jad_bo2.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + jad_bo(bitmap) + ", this: " + this);
    }

    public static Bitmap.Config[] jad_an(Bitmap.Config config) {
        Bitmap.Config config2;
        if (Build.VERSION.SDK_INT >= 26) {
            config2 = Bitmap.Config.RGBA_F16;
            if (config2.equals(config)) {
                return jad_er;
            }
        }
        int i = jad_an.jad_an[config.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? new Bitmap.Config[]{config} : jad_hu : jad_jt : jad_fs : jad_dq;
    }

    @Override // com.jd.ad.sdk.jad_lw.jad_ly
    @Nullable
    public Bitmap jad_an(int i, int i2, Bitmap.Config config) {
        int jad_an2 = com.jd.ad.sdk.jad_gp.jad_ly.jad_an(config) * i * i2;
        jad_bo jad_bo2 = this.jad_an.jad_bo();
        jad_bo2.jad_bo = jad_an2;
        jad_bo2.jad_cp = config;
        Bitmap.Config[] jad_an3 = jad_an(config);
        int length = jad_an3.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            Bitmap.Config config2 = jad_an3[i3];
            Integer ceilingKey = jad_bo(config2).ceilingKey(Integer.valueOf(jad_an2));
            if (ceilingKey == null || ceilingKey.intValue() > jad_an2 * 8) {
                i3++;
            } else if (ceilingKey.intValue() != jad_an2 || (config2 != null ? !config2.equals(config) : config != null)) {
                jad_cp jad_cpVar = this.jad_an;
                if (jad_cpVar.jad_an.size() < 20) {
                    jad_cpVar.jad_an.offer(jad_bo2);
                }
                jad_bo2 = this.jad_an.jad_an(ceilingKey.intValue(), config2);
            }
        }
        Bitmap jad_an4 = this.jad_bo.jad_an(jad_bo2);
        if (jad_an4 != null) {
            jad_an(Integer.valueOf(jad_bo2.jad_bo), jad_an4);
            jad_an4.reconfigure(i, i2, config);
        }
        return jad_an4;
    }
}
