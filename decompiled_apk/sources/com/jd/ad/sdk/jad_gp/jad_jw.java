package com.jd.ad.sdk.jad_gp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes10.dex */
public class jad_jw {
    public Class<?> jad_an;
    public Class<?> jad_bo;
    public Class<?> jad_cp;

    public jad_jw() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || jad_jw.class != obj.getClass()) {
            return false;
        }
        jad_jw jad_jwVar = (jad_jw) obj;
        return this.jad_an.equals(jad_jwVar.jad_an) && this.jad_bo.equals(jad_jwVar.jad_bo) && jad_ly.jad_an(this.jad_cp, jad_jwVar.jad_cp);
    }

    public int hashCode() {
        int hashCode = (this.jad_bo.hashCode() + (this.jad_an.hashCode() * 31)) * 31;
        Class<?> cls = this.jad_cp;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public void jad_an(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.jad_an = cls;
        this.jad_bo = cls2;
        this.jad_cp = cls3;
    }

    public String toString() {
        StringBuilder jad_an = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("MultiClassKey{first=");
        jad_an.append(this.jad_an);
        jad_an.append(", second=");
        jad_an.append(this.jad_bo);
        jad_an.append('}');
        return jad_an.toString();
    }

    public jad_jw(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        jad_an(cls, cls2, cls3);
    }
}
