package androidx.collection;

import OXOo.OOXIXo;
import Oox.oIX0oI;
import Oox.x0xO0oo;
import java.util.Iterator;
import kotlin.collections.oOXoIIIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

public final class SparseArrayKt {
    public static final <T> boolean contains(@OOXIXo SparseArrayCompat<T> sparseArrayCompat, int i) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        return sparseArrayCompat.containsKey(i);
    }

    public static final <T> void forEach(@OOXIXo SparseArrayCompat<T> sparseArrayCompat, @OOXIXo x0xO0oo<? super Integer, ? super T, oXIO0o0XI> x0xo0oo) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        IIX0o.x0xO0oo(x0xo0oo, "action");
        int size = sparseArrayCompat.size();
        for (int i = 0; i < size; i++) {
            x0xo0oo.invoke(Integer.valueOf(sparseArrayCompat.keyAt(i)), sparseArrayCompat.valueAt(i));
        }
    }

    public static final <T> T getOrDefault(@OOXIXo SparseArrayCompat<T> sparseArrayCompat, int i, T t) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        return sparseArrayCompat.get(i, t);
    }

    public static final <T> T getOrElse(@OOXIXo SparseArrayCompat<T> sparseArrayCompat, int i, @OOXIXo oIX0oI<? extends T> oix0oi) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        IIX0o.x0xO0oo(oix0oi, "defaultValue");
        T t = sparseArrayCompat.get(i);
        if (t == null) {
            return oix0oi.invoke();
        }
        return t;
    }

    public static final <T> int getSize(@OOXIXo SparseArrayCompat<T> sparseArrayCompat) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        return sparseArrayCompat.size();
    }

    public static final <T> boolean isNotEmpty(@OOXIXo SparseArrayCompat<T> sparseArrayCompat) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        return !sparseArrayCompat.isEmpty();
    }

    @OOXIXo
    public static final <T> oOXoIIIo keyIterator(@OOXIXo SparseArrayCompat<T> sparseArrayCompat) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        return new SparseArrayKt$keyIterator$1(sparseArrayCompat);
    }

    @OOXIXo
    public static final <T> SparseArrayCompat<T> plus(@OOXIXo SparseArrayCompat<T> sparseArrayCompat, @OOXIXo SparseArrayCompat<T> sparseArrayCompat2) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        IIX0o.x0xO0oo(sparseArrayCompat2, "other");
        SparseArrayCompat<T> sparseArrayCompat3 = new SparseArrayCompat<>(sparseArrayCompat.size() + sparseArrayCompat2.size());
        sparseArrayCompat3.putAll(sparseArrayCompat);
        sparseArrayCompat3.putAll(sparseArrayCompat2);
        return sparseArrayCompat3;
    }

    public static final <T> void set(@OOXIXo SparseArrayCompat<T> sparseArrayCompat, int i, T t) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        sparseArrayCompat.put(i, t);
    }

    @OOXIXo
    public static final <T> Iterator<T> valueIterator(@OOXIXo SparseArrayCompat<T> sparseArrayCompat) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        return new SparseArrayKt$valueIterator$1(sparseArrayCompat);
    }
}
