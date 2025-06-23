package x0xO0oo;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import org.apache.commons.text.ooOOo0oXI;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class II0XooXoX<T> {

    /* renamed from: II0xO0, reason: collision with root package name */
    @Nullable
    public T f34078II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @Nullable
    public T f34079oIX0oI;

    public static boolean oIX0oI(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    public void II0xO0(T t, T t2) {
        this.f34079oIX0oI = t;
        this.f34078II0xO0 = t2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (!oIX0oI(pair.first, this.f34079oIX0oI) || !oIX0oI(pair.second, this.f34078II0xO0)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        T t = this.f34079oIX0oI;
        int i = 0;
        if (t == null) {
            hashCode = 0;
        } else {
            hashCode = t.hashCode();
        }
        T t2 = this.f34078II0xO0;
        if (t2 != null) {
            i = t2.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f34079oIX0oI) + " " + String.valueOf(this.f34078II0xO0) + ooOOo0oXI.f33074oOoXoXO;
    }
}
