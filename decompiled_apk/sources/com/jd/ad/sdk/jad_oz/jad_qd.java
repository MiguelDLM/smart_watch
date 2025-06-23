package com.jd.ad.sdk.jad_oz;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.jd.ad.sdk.jad_it.jad_dq;
import com.jd.ad.sdk.jad_oz.jad_na;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes10.dex */
public class jad_qd<Model, Data> implements jad_na<Model, Data> {
    public final List<jad_na<Model, Data>> jad_an;
    public final Pools.Pool<List<Throwable>> jad_bo;

    /* loaded from: classes10.dex */
    public static class jad_an<Data> implements com.jd.ad.sdk.jad_it.jad_dq<Data>, jad_dq.jad_an<Data> {
        public final List<com.jd.ad.sdk.jad_it.jad_dq<Data>> jad_an;
        public final Pools.Pool<List<Throwable>> jad_bo;
        public int jad_cp;
        public com.jd.ad.sdk.jad_ep.jad_jt jad_dq;
        public jad_dq.jad_an<? super Data> jad_er;

        @Nullable
        public List<Throwable> jad_fs;
        public boolean jad_jt;

        public jad_an(@NonNull List<com.jd.ad.sdk.jad_it.jad_dq<Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            this.jad_bo = pool;
            com.jd.ad.sdk.jad_gp.jad_kx.jad_an(list);
            this.jad_an = list;
            this.jad_cp = 0;
        }

        @Override // com.jd.ad.sdk.jad_it.jad_dq
        @NonNull
        public Class<Data> jad_an() {
            return this.jad_an.get(0).jad_an();
        }

        @Override // com.jd.ad.sdk.jad_it.jad_dq
        public void jad_bo() {
            List<Throwable> list = this.jad_fs;
            if (list != null) {
                this.jad_bo.release(list);
            }
            this.jad_fs = null;
            Iterator<com.jd.ad.sdk.jad_it.jad_dq<Data>> it = this.jad_an.iterator();
            while (it.hasNext()) {
                it.next().jad_bo();
            }
        }

        @Override // com.jd.ad.sdk.jad_it.jad_dq
        public void jad_cp() {
            this.jad_jt = true;
            Iterator<com.jd.ad.sdk.jad_it.jad_dq<Data>> it = this.jad_an.iterator();
            while (it.hasNext()) {
                it.next().jad_cp();
            }
        }

        @Override // com.jd.ad.sdk.jad_it.jad_dq
        @NonNull
        public com.jd.ad.sdk.jad_hs.jad_an jad_dq() {
            return this.jad_an.get(0).jad_dq();
        }

        public final void jad_er() {
            if (this.jad_jt) {
                return;
            }
            if (this.jad_cp < this.jad_an.size() - 1) {
                this.jad_cp++;
                jad_an(this.jad_dq, this.jad_er);
            } else {
                com.jd.ad.sdk.jad_gp.jad_kx.jad_an(this.jad_fs);
                this.jad_er.jad_an((Exception) new com.jd.ad.sdk.jad_kv.jad_sf("Fetch failed", new ArrayList(this.jad_fs)));
            }
        }

        @Override // com.jd.ad.sdk.jad_it.jad_dq
        public void jad_an(@NonNull com.jd.ad.sdk.jad_ep.jad_jt jad_jtVar, @NonNull jad_dq.jad_an<? super Data> jad_anVar) {
            this.jad_dq = jad_jtVar;
            this.jad_er = jad_anVar;
            this.jad_fs = this.jad_bo.acquire();
            this.jad_an.get(this.jad_cp).jad_an(jad_jtVar, this);
            if (this.jad_jt) {
                jad_cp();
            }
        }

        @Override // com.jd.ad.sdk.jad_it.jad_dq.jad_an
        public void jad_an(@NonNull Exception exc) {
            ((List) com.jd.ad.sdk.jad_gp.jad_kx.jad_an(this.jad_fs)).add(exc);
            jad_er();
        }

        @Override // com.jd.ad.sdk.jad_it.jad_dq.jad_an
        public void jad_an(@Nullable Data data) {
            if (data != null) {
                this.jad_er.jad_an((jad_dq.jad_an<? super Data>) data);
            } else {
                jad_er();
            }
        }
    }

    public jad_qd(@NonNull List<jad_na<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
        this.jad_an = list;
        this.jad_bo = pool;
    }

    @Override // com.jd.ad.sdk.jad_oz.jad_na
    public boolean jad_an(@NonNull Model model) {
        Iterator<jad_na<Model, Data>> it = this.jad_an.iterator();
        while (it.hasNext()) {
            if (it.next().jad_an(model)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder jad_an2 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("MultiModelLoader{modelLoaders=");
        jad_an2.append(Arrays.toString(this.jad_an.toArray()));
        jad_an2.append('}');
        return jad_an2.toString();
    }

    @Override // com.jd.ad.sdk.jad_oz.jad_na
    public jad_na.jad_an<Data> jad_an(@NonNull Model model, int i, int i2, @NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar) {
        jad_na.jad_an<Data> jad_an2;
        int size = this.jad_an.size();
        ArrayList arrayList = new ArrayList(size);
        com.jd.ad.sdk.jad_hs.jad_hu jad_huVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            jad_na<Model, Data> jad_naVar = this.jad_an.get(i3);
            if (jad_naVar.jad_an(model) && (jad_an2 = jad_naVar.jad_an(model, i, i2, jad_jwVar)) != null) {
                jad_huVar = jad_an2.jad_an;
                arrayList.add(jad_an2.jad_cp);
            }
        }
        if (arrayList.isEmpty() || jad_huVar == null) {
            return null;
        }
        return new jad_na.jad_an<>(jad_huVar, Collections.emptyList(), new jad_an(arrayList, this.jad_bo));
    }
}
