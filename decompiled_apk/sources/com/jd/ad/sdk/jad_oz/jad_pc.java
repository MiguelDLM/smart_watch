package com.jd.ad.sdk.jad_oz;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes10.dex */
public class jad_pc {
    public final jad_re jad_an;
    public final jad_an jad_bo;

    /* loaded from: classes10.dex */
    public static class jad_an {
        public final Map<Class<?>, C0709jad_an<?>> jad_an = new HashMap();

        /* renamed from: com.jd.ad.sdk.jad_oz.jad_pc$jad_an$jad_an, reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static class C0709jad_an<Model> {
            public final List<jad_na<Model, ?>> jad_an;

            public C0709jad_an(List<jad_na<Model, ?>> list) {
                this.jad_an = list;
            }
        }
    }

    public jad_pc(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(new jad_re(pool));
    }

    public jad_pc(@NonNull jad_re jad_reVar) {
        this.jad_bo = new jad_an();
        this.jad_an = jad_reVar;
    }
}
