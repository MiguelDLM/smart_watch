package androidx.collection;

import OXOo.OOXIXo;
import Oox.x0xO0oo;
import java.util.Iterator;
import kotlin.DeprecationLevel;
import kotlin.collections.oOXoIIIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes.dex */
public final class SparseArrayKt {
    public static final <T> boolean contains(@OOXIXo SparseArrayCompat<T> sparseArrayCompat, int i) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        return sparseArrayCompat.containsKey(i);
    }

    public static final <T> void forEach(@OOXIXo SparseArrayCompat<T> sparseArrayCompat, @OOXIXo x0xO0oo<? super Integer, ? super T, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        IIX0o.x0xO0oo(action, "action");
        int size = sparseArrayCompat.size();
        for (int i = 0; i < size; i++) {
            action.invoke(Integer.valueOf(sparseArrayCompat.keyAt(i)), sparseArrayCompat.valueAt(i));
        }
    }

    public static final <T> T getOrDefault(@OOXIXo SparseArrayCompat<T> sparseArrayCompat, int i, T t) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        return sparseArrayCompat.get(i, t);
    }

    public static final <T> T getOrElse(@OOXIXo SparseArrayCompat<T> sparseArrayCompat, int i, @OOXIXo Oox.oIX0oI<? extends T> defaultValue) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        IIX0o.x0xO0oo(defaultValue, "defaultValue");
        T t = sparseArrayCompat.get(i);
        if (t == null) {
            return defaultValue.invoke();
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
    public static final <T> oOXoIIIo keyIterator(@OOXIXo final SparseArrayCompat<T> sparseArrayCompat) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        return new oOXoIIIo() { // from class: androidx.collection.SparseArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.index < sparseArrayCompat.size()) {
                    return true;
                }
                return false;
            }

            @Override // kotlin.collections.oOXoIIIo
            public int nextInt() {
                SparseArrayCompat<T> sparseArrayCompat2 = sparseArrayCompat;
                int i = this.index;
                this.index = i + 1;
                return sparseArrayCompat2.keyAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }

    @OOXIXo
    public static final <T> SparseArrayCompat<T> plus(@OOXIXo SparseArrayCompat<T> sparseArrayCompat, @OOXIXo SparseArrayCompat<T> other) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        IIX0o.x0xO0oo(other, "other");
        SparseArrayCompat<T> sparseArrayCompat2 = new SparseArrayCompat<>(sparseArrayCompat.size() + other.size());
        sparseArrayCompat2.putAll(sparseArrayCompat);
        sparseArrayCompat2.putAll(other);
        return sparseArrayCompat2;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.HIDDEN, message = "Replaced with member function. Remove extension import!")
    public static final /* synthetic */ boolean remove(SparseArrayCompat sparseArrayCompat, int i, Object obj) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        return sparseArrayCompat.remove(i, obj);
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
