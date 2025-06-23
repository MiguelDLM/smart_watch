package com.jd.ad.sdk.jad_wf;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* loaded from: classes10.dex */
public class jad_cp<T> {
    public final jad_bo<T> jad_an;

    @Nullable
    public T jad_bo;

    public jad_cp() {
        this.jad_an = new jad_bo<>();
        this.jad_bo = null;
    }

    @Nullable
    public T jad_an(jad_bo<T> jad_boVar) {
        return this.jad_bo;
    }

    public jad_cp(@Nullable T t) {
        this.jad_an = new jad_bo<>();
        this.jad_bo = t;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final T jad_an(float f, float f2, T t, T t2, float f3, float f4, float f5) {
        jad_bo<T> jad_boVar = this.jad_an;
        jad_boVar.jad_an = t;
        jad_boVar.jad_bo = t2;
        return jad_an(jad_boVar);
    }
}
