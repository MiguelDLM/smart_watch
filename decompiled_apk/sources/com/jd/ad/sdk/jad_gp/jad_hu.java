package com.jd.ad.sdk.jad_gp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes10.dex */
public class jad_hu<T, Y> {
    public final Map<T, jad_an<Y>> jad_an = new LinkedHashMap(100, 0.75f, true);
    public long jad_bo;
    public long jad_cp;

    /* loaded from: classes10.dex */
    public static final class jad_an<Y> {
        public final Y jad_an;
        public final int jad_bo;

        public jad_an(Y y, int i) {
            this.jad_an = y;
            this.jad_bo = i;
        }
    }

    public jad_hu(long j) {
        this.jad_bo = j;
    }

    @Nullable
    public synchronized Y jad_an(@NonNull T t) {
        jad_an<Y> jad_anVar;
        jad_anVar = this.jad_an.get(t);
        return jad_anVar != null ? jad_anVar.jad_an : null;
    }

    public int jad_bo(@Nullable Y y) {
        return 1;
    }

    public synchronized void jad_an(long j) {
        while (this.jad_cp > j) {
            Iterator<Map.Entry<T, jad_an<Y>>> it = this.jad_an.entrySet().iterator();
            Map.Entry<T, jad_an<Y>> next = it.next();
            jad_an<Y> value = next.getValue();
            this.jad_cp -= value.jad_bo;
            T key = next.getKey();
            it.remove();
            jad_an(key, value.jad_an);
        }
    }

    @Nullable
    public synchronized Y jad_bo(@NonNull T t, @Nullable Y y) {
        int jad_bo = jad_bo(y);
        long j = jad_bo;
        if (j >= this.jad_bo) {
            jad_an(t, y);
            return null;
        }
        if (y != null) {
            this.jad_cp += j;
        }
        jad_an<Y> put = this.jad_an.put(t, y == null ? null : new jad_an<>(y, jad_bo));
        if (put != null) {
            this.jad_cp -= put.jad_bo;
            if (!put.jad_an.equals(y)) {
                jad_an(t, put.jad_an);
            }
        }
        jad_an(this.jad_bo);
        return put != null ? put.jad_an : null;
    }

    public void jad_an(@NonNull T t, @Nullable Y y) {
    }
}
