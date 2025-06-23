package androidx.core.util;

import OXOo.OOXIXo;
import Oox.oIX0oI;
import Oox.x0xO0oo;
import android.util.SparseIntArray;
import kotlin.collections.oOXoIIIo;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nSparseIntArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseIntArray.kt\nandroidx/core/util/SparseIntArrayKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,93:1\n75#1,4:95\n1#2:94\n*S KotlinDebug\n*F\n+ 1 SparseIntArray.kt\nandroidx/core/util/SparseIntArrayKt\n*L\n71#1:95,4\n*E\n"})
public final class SparseIntArrayKt {
    public static final boolean contains(@OOXIXo SparseIntArray sparseIntArray, int i) {
        if (sparseIntArray.indexOfKey(i) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsKey(@OOXIXo SparseIntArray sparseIntArray, int i) {
        if (sparseIntArray.indexOfKey(i) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsValue(@OOXIXo SparseIntArray sparseIntArray, int i) {
        if (sparseIntArray.indexOfValue(i) >= 0) {
            return true;
        }
        return false;
    }

    public static final void forEach(@OOXIXo SparseIntArray sparseIntArray, @OOXIXo x0xO0oo<? super Integer, ? super Integer, oXIO0o0XI> x0xo0oo) {
        int size = sparseIntArray.size();
        for (int i = 0; i < size; i++) {
            x0xo0oo.invoke(Integer.valueOf(sparseIntArray.keyAt(i)), Integer.valueOf(sparseIntArray.valueAt(i)));
        }
    }

    public static final int getOrDefault(@OOXIXo SparseIntArray sparseIntArray, int i, int i2) {
        return sparseIntArray.get(i, i2);
    }

    public static final int getOrElse(@OOXIXo SparseIntArray sparseIntArray, int i, @OOXIXo oIX0oI<Integer> oix0oi) {
        int indexOfKey = sparseIntArray.indexOfKey(i);
        if (indexOfKey >= 0) {
            return sparseIntArray.valueAt(indexOfKey);
        }
        return oix0oi.invoke().intValue();
    }

    public static final int getSize(@OOXIXo SparseIntArray sparseIntArray) {
        return sparseIntArray.size();
    }

    public static final boolean isEmpty(@OOXIXo SparseIntArray sparseIntArray) {
        if (sparseIntArray.size() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotEmpty(@OOXIXo SparseIntArray sparseIntArray) {
        if (sparseIntArray.size() != 0) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public static final oOXoIIIo keyIterator(@OOXIXo SparseIntArray sparseIntArray) {
        return new SparseIntArrayKt$keyIterator$1(sparseIntArray);
    }

    @OOXIXo
    public static final SparseIntArray plus(@OOXIXo SparseIntArray sparseIntArray, @OOXIXo SparseIntArray sparseIntArray2) {
        SparseIntArray sparseIntArray3 = new SparseIntArray(sparseIntArray.size() + sparseIntArray2.size());
        putAll(sparseIntArray3, sparseIntArray);
        putAll(sparseIntArray3, sparseIntArray2);
        return sparseIntArray3;
    }

    public static final void putAll(@OOXIXo SparseIntArray sparseIntArray, @OOXIXo SparseIntArray sparseIntArray2) {
        int size = sparseIntArray2.size();
        for (int i = 0; i < size; i++) {
            sparseIntArray.put(sparseIntArray2.keyAt(i), sparseIntArray2.valueAt(i));
        }
    }

    public static final boolean remove(@OOXIXo SparseIntArray sparseIntArray, int i, int i2) {
        int indexOfKey = sparseIntArray.indexOfKey(i);
        if (indexOfKey < 0 || i2 != sparseIntArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseIntArray.removeAt(indexOfKey);
        return true;
    }

    public static final void set(@OOXIXo SparseIntArray sparseIntArray, int i, int i2) {
        sparseIntArray.put(i, i2);
    }

    @OOXIXo
    public static final oOXoIIIo valueIterator(@OOXIXo SparseIntArray sparseIntArray) {
        return new SparseIntArrayKt$valueIterator$1(sparseIntArray);
    }
}
