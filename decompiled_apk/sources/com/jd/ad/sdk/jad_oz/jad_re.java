package com.jd.ad.sdk.jad_oz;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.jd.ad.sdk.jad_ep.jad_hu;
import com.jd.ad.sdk.jad_oz.jad_na;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes10.dex */
public class jad_re {
    public static final jad_cp jad_er = new jad_cp();
    public static final jad_na<Object, Object> jad_fs = new jad_an();
    public final List<jad_bo<?, ?>> jad_an;
    public final jad_cp jad_bo;
    public final Set<jad_bo<?, ?>> jad_cp;
    public final Pools.Pool<List<Throwable>> jad_dq;

    /* loaded from: classes10.dex */
    public static class jad_an implements jad_na<Object, Object> {
        @Override // com.jd.ad.sdk.jad_oz.jad_na
        @Nullable
        public jad_na.jad_an<Object> jad_an(@NonNull Object obj, int i, int i2, @NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar) {
            return null;
        }

        @Override // com.jd.ad.sdk.jad_oz.jad_na
        public boolean jad_an(@NonNull Object obj) {
            return false;
        }
    }

    /* loaded from: classes10.dex */
    public static class jad_bo<Model, Data> {
        public final Class<Model> jad_an;
        public final Class<Data> jad_bo;
        public final jad_ob<? extends Model, ? extends Data> jad_cp;

        public jad_bo(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull jad_ob<? extends Model, ? extends Data> jad_obVar) {
            this.jad_an = cls;
            this.jad_bo = cls2;
            this.jad_cp = jad_obVar;
        }
    }

    /* loaded from: classes10.dex */
    public static class jad_cp {
    }

    public jad_re(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(pool, jad_er);
    }

    @NonNull
    public final <Model, Data> jad_na<Model, Data> jad_an(@NonNull jad_bo<?, ?> jad_boVar) {
        return (jad_na) com.jd.ad.sdk.jad_gp.jad_kx.jad_an(jad_boVar.jad_cp.jad_an(this));
    }

    @VisibleForTesting
    public jad_re(@NonNull Pools.Pool<List<Throwable>> pool, @NonNull jad_cp jad_cpVar) {
        this.jad_an = new ArrayList();
        this.jad_cp = new HashSet();
        this.jad_dq = pool;
        this.jad_bo = jad_cpVar;
    }

    @NonNull
    public synchronized <Model, Data> jad_na<Model, Data> jad_an(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (jad_bo<?, ?> jad_boVar : this.jad_an) {
                if (this.jad_cp.contains(jad_boVar)) {
                    z = true;
                } else if (jad_boVar.jad_an.isAssignableFrom(cls) && jad_boVar.jad_bo.isAssignableFrom(cls2)) {
                    this.jad_cp.add(jad_boVar);
                    arrayList.add(jad_an(jad_boVar));
                    this.jad_cp.remove(jad_boVar);
                }
            }
            if (arrayList.size() > 1) {
                jad_cp jad_cpVar = this.jad_bo;
                Pools.Pool<List<Throwable>> pool = this.jad_dq;
                jad_cpVar.getClass();
                return new jad_qd(arrayList, pool);
            }
            if (arrayList.size() == 1) {
                return (jad_na) arrayList.get(0);
            }
            if (!z) {
                throw new jad_hu.jad_cp((Class<?>) cls, (Class<?>) cls2);
            }
            return (jad_na<Model, Data>) jad_fs;
        } catch (Throwable th) {
            this.jad_cp.clear();
            throw th;
        }
    }
}
