package com.jd.ad.sdk.jad_ox;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import com.jd.ad.sdk.jad_js.jad_zm;
import org.apache.commons.text.ooOOo0oXI;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes10.dex */
public class jad_iv<T> {

    @Nullable
    public T jad_an;

    @Nullable
    public T jad_bo;

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        F f = pair.first;
        Object obj2 = this.jad_an;
        if (f != obj2 && (f == 0 || !f.equals(obj2))) {
            return false;
        }
        S s = pair.second;
        Object obj3 = this.jad_bo;
        if (s != obj3 && (s == 0 || !s.equals(obj3))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        T t = this.jad_an;
        int hashCode = t == null ? 0 : t.hashCode();
        T t2 = this.jad_bo;
        return hashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder jad_an = jad_zm.jad_an("Pair{");
        jad_an.append(this.jad_an);
        jad_an.append(" ");
        jad_an.append(this.jad_bo);
        jad_an.append(ooOOo0oXI.f33074oOoXoXO);
        return jad_an.toString();
    }
}
