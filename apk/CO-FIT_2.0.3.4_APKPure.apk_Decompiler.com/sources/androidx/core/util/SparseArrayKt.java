package androidx.core.util;

import OXOo.OOXIXo;
import Oox.oIX0oI;
import Oox.x0xO0oo;
import android.util.SparseArray;
import java.util.Iterator;
import kotlin.collections.oOXoIIIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nSparseArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseArray.kt\nandroidx/core/util/SparseArrayKt\n*L\n1#1,94:1\n76#1,4:95\n*S KotlinDebug\n*F\n+ 1 SparseArray.kt\nandroidx/core/util/SparseArrayKt\n*L\n72#1:95,4\n*E\n"})
public final class SparseArrayKt {
    public static final <T> boolean contains(@OOXIXo SparseArray<T> sparseArray, int i) {
        if (sparseArray.indexOfKey(i) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean containsKey(@OOXIXo SparseArray<T> sparseArray, int i) {
        if (sparseArray.indexOfKey(i) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean containsValue(@OOXIXo SparseArray<T> sparseArray, T t) {
        if (sparseArray.indexOfValue(t) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> void forEach(@OOXIXo SparseArray<T> sparseArray, @OOXIXo x0xO0oo<? super Integer, ? super T, oXIO0o0XI> x0xo0oo) {
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            x0xo0oo.invoke(Integer.valueOf(sparseArray.keyAt(i)), sparseArray.valueAt(i));
        }
    }

    public static final <T> T getOrDefault(@OOXIXo SparseArray<T> sparseArray, int i, T t) {
        T t2 = sparseArray.get(i);
        if (t2 == null) {
            return t;
        }
        return t2;
    }

    public static final <T> T getOrElse(@OOXIXo SparseArray<T> sparseArray, int i, @OOXIXo oIX0oI<? extends T> oix0oi) {
        T t = sparseArray.get(i);
        if (t == null) {
            return oix0oi.invoke();
        }
        return t;
    }

    public static final <T> int getSize(@OOXIXo SparseArray<T> sparseArray) {
        return sparseArray.size();
    }

    public static final <T> boolean isEmpty(@OOXIXo SparseArray<T> sparseArray) {
        if (sparseArray.size() == 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean isNotEmpty(@OOXIXo SparseArray<T> sparseArray) {
        if (sparseArray.size() != 0) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public static final <T> oOXoIIIo keyIterator(@OOXIXo SparseArray<T> sparseArray) {
        return new SparseArrayKt$keyIterator$1(sparseArray);
    }

    @OOXIXo
    public static final <T> SparseArray<T> plus(@OOXIXo SparseArray<T> sparseArray, @OOXIXo SparseArray<T> sparseArray2) {
        SparseArray<T> sparseArray3 = new SparseArray<>(sparseArray.size() + sparseArray2.size());
        putAll(sparseArray3, sparseArray);
        putAll(sparseArray3, sparseArray2);
        return sparseArray3;
    }

    public static final <T> void putAll(@OOXIXo SparseArray<T> sparseArray, @OOXIXo SparseArray<T> sparseArray2) {
        int size = sparseArray2.size();
        for (int i = 0; i < size; i++) {
            sparseArray.put(sparseArray2.keyAt(i), sparseArray2.valueAt(i));
        }
    }

    public static final <T> boolean remove(@OOXIXo SparseArray<T> sparseArray, int i, T t) {
        int indexOfKey = sparseArray.indexOfKey(i);
        if (indexOfKey < 0 || !IIX0o.Oxx0IOOO(t, sparseArray.valueAt(indexOfKey))) {
            return false;
        }
        sparseArray.removeAt(indexOfKey);
        return true;
    }

    public static final <T> void set(@OOXIXo SparseArray<T> sparseArray, int i, T t) {
        sparseArray.put(i, t);
    }

    @OOXIXo
    public static final <T> Iterator<T> valueIterator(@OOXIXo SparseArray<T> sparseArray) {
        return new SparseArrayKt$valueIterator$1(sparseArray);
    }
}
