package com.jd.ad.sdk.jad_wh;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes10.dex */
public class jad_fs {
    public final List<jad_an<?, ?>> jad_an = new ArrayList();

    /* loaded from: classes10.dex */
    public static final class jad_an<Z, R> {
        public final Class<Z> jad_an;
        public final Class<R> jad_bo;
        public final jad_er<Z, R> jad_cp;

        public jad_an(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull jad_er<Z, R> jad_erVar) {
            this.jad_an = cls;
            this.jad_bo = cls2;
            this.jad_cp = jad_erVar;
        }
    }

    @NonNull
    public synchronized <Z, R> List<Class<R>> jad_an(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (jad_an<?, ?> jad_anVar : this.jad_an) {
            if (jad_anVar.jad_an.isAssignableFrom(cls) && cls2.isAssignableFrom(jad_anVar.jad_bo) && !arrayList.contains(jad_anVar.jad_bo)) {
                arrayList.add(jad_anVar.jad_bo);
            }
        }
        return arrayList;
    }
}
