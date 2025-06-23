package androidx.core.util;

import androidx.annotation.NonNull;
import org.apache.commons.text.ooOOo0oXI;

public class Pair<F, S> {
    public final F first;
    public final S second;

    public Pair(F f, S s) {
        this.first = f;
        this.second = s;
    }

    @NonNull
    public static <A, B> Pair<A, B> create(A a2, B b) {
        return new Pair<>(a2, b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (!ObjectsCompat.equals(pair.first, this.first) || !ObjectsCompat.equals(pair.second, this.second)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i;
        F f = this.first;
        int i2 = 0;
        if (f == null) {
            i = 0;
        } else {
            i = f.hashCode();
        }
        S s = this.second;
        if (s != null) {
            i2 = s.hashCode();
        }
        return i ^ i2;
    }

    @NonNull
    public String toString() {
        return "Pair{" + this.first + " " + this.second + ooOOo0oXI.f22054oOoXoXO;
    }
}
