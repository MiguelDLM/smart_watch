package com.jd.ad.sdk.jad_lw;

import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_lw.jad_mz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes10.dex */
public class jad_hu<K extends jad_mz, V> {
    public final jad_an<K, V> jad_an = new jad_an<>();
    public final Map<K, jad_an<K, V>> jad_bo = new HashMap();

    /* loaded from: classes10.dex */
    public static class jad_an<K, V> {
        public final K jad_an;
        public List<V> jad_bo;
        public jad_an<K, V> jad_cp;
        public jad_an<K, V> jad_dq;

        public jad_an() {
            this(null);
        }

        @Nullable
        public V jad_an() {
            int i;
            List<V> list = this.jad_bo;
            if (list != null) {
                i = list.size();
            } else {
                i = 0;
            }
            if (i > 0) {
                return this.jad_bo.remove(i - 1);
            }
            return null;
        }

        public jad_an(K k) {
            this.jad_dq = this;
            this.jad_cp = this;
            this.jad_an = k;
        }
    }

    @Nullable
    public V jad_an(K k) {
        jad_an<K, V> jad_anVar = this.jad_bo.get(k);
        if (jad_anVar == null) {
            jad_anVar = new jad_an<>(k);
            this.jad_bo.put(k, jad_anVar);
        } else {
            k.jad_an();
        }
        jad_an<K, V> jad_anVar2 = jad_anVar.jad_dq;
        jad_anVar2.jad_cp = jad_anVar.jad_cp;
        jad_anVar.jad_cp.jad_dq = jad_anVar2;
        jad_an<K, V> jad_anVar3 = this.jad_an;
        jad_anVar.jad_dq = jad_anVar3;
        jad_an<K, V> jad_anVar4 = jad_anVar3.jad_cp;
        jad_anVar.jad_cp = jad_anVar4;
        jad_anVar4.jad_dq = jad_anVar;
        jad_anVar.jad_dq.jad_cp = jad_anVar;
        return jad_anVar.jad_an();
    }

    public String toString() {
        int i;
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        jad_an jad_anVar = this.jad_an.jad_cp;
        boolean z = false;
        while (!jad_anVar.equals(this.jad_an)) {
            sb.append('{');
            sb.append(jad_anVar.jad_an);
            sb.append(':');
            List<V> list = jad_anVar.jad_bo;
            if (list != null) {
                i = list.size();
            } else {
                i = 0;
            }
            sb.append(i);
            sb.append("}, ");
            jad_anVar = jad_anVar.jad_cp;
            z = true;
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }

    public void jad_an(K k, V v) {
        jad_an<K, V> jad_anVar = this.jad_bo.get(k);
        if (jad_anVar == null) {
            jad_anVar = new jad_an<>(k);
            jad_an<K, V> jad_anVar2 = jad_anVar.jad_dq;
            jad_anVar2.jad_cp = jad_anVar.jad_cp;
            jad_anVar.jad_cp.jad_dq = jad_anVar2;
            jad_an<K, V> jad_anVar3 = this.jad_an;
            jad_anVar.jad_dq = jad_anVar3.jad_dq;
            jad_anVar.jad_cp = jad_anVar3;
            jad_anVar3.jad_dq = jad_anVar;
            jad_anVar.jad_dq.jad_cp = jad_anVar;
            this.jad_bo.put(k, jad_anVar);
        } else {
            k.jad_an();
        }
        if (jad_anVar.jad_bo == null) {
            jad_anVar.jad_bo = new ArrayList();
        }
        jad_anVar.jad_bo.add(v);
    }

    @Nullable
    public V jad_an() {
        for (jad_an jad_anVar = this.jad_an.jad_dq; !jad_anVar.equals(this.jad_an); jad_anVar = jad_anVar.jad_dq) {
            V v = (V) jad_anVar.jad_an();
            if (v != null) {
                return v;
            }
            jad_an<K, V> jad_anVar2 = jad_anVar.jad_dq;
            jad_anVar2.jad_cp = jad_anVar.jad_cp;
            jad_anVar.jad_cp.jad_dq = jad_anVar2;
            this.jad_bo.remove(jad_anVar.jad_an);
            ((jad_mz) jad_anVar.jad_an).jad_an();
        }
        return null;
    }
}
