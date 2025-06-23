package androidx.core.util;

import OXOo.OOXIXo;
import Oox.oIX0oI;
import Oox.x0xO0oo;
import android.util.SparseLongArray;
import kotlin.collections.Xx000oIo;
import kotlin.collections.oOXoIIIo;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nSparseLongArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseLongArray.kt\nandroidx/core/util/SparseLongArrayKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,93:1\n75#1,4:95\n1#2:94\n*S KotlinDebug\n*F\n+ 1 SparseLongArray.kt\nandroidx/core/util/SparseLongArrayKt\n*L\n71#1:95,4\n*E\n"})
public final class SparseLongArrayKt {
    public static final boolean contains(@OOXIXo SparseLongArray sparseLongArray, int i) {
        if (sparseLongArray.indexOfKey(i) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsKey(@OOXIXo SparseLongArray sparseLongArray, int i) {
        if (sparseLongArray.indexOfKey(i) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsValue(@OOXIXo SparseLongArray sparseLongArray, long j) {
        if (sparseLongArray.indexOfValue(j) >= 0) {
            return true;
        }
        return false;
    }

    public static final void forEach(@OOXIXo SparseLongArray sparseLongArray, @OOXIXo x0xO0oo<? super Integer, ? super Long, oXIO0o0XI> x0xo0oo) {
        int size = sparseLongArray.size();
        for (int i = 0; i < size; i++) {
            x0xo0oo.invoke(Integer.valueOf(sparseLongArray.keyAt(i)), Long.valueOf(sparseLongArray.valueAt(i)));
        }
    }

    public static final long getOrDefault(@OOXIXo SparseLongArray sparseLongArray, int i, long j) {
        return sparseLongArray.get(i, j);
    }

    public static final long getOrElse(@OOXIXo SparseLongArray sparseLongArray, int i, @OOXIXo oIX0oI<Long> oix0oi) {
        int indexOfKey = sparseLongArray.indexOfKey(i);
        if (indexOfKey >= 0) {
            return sparseLongArray.valueAt(indexOfKey);
        }
        return oix0oi.invoke().longValue();
    }

    public static final int getSize(@OOXIXo SparseLongArray sparseLongArray) {
        return sparseLongArray.size();
    }

    public static final boolean isEmpty(@OOXIXo SparseLongArray sparseLongArray) {
        if (sparseLongArray.size() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotEmpty(@OOXIXo SparseLongArray sparseLongArray) {
        if (sparseLongArray.size() != 0) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public static final oOXoIIIo keyIterator(@OOXIXo SparseLongArray sparseLongArray) {
        return new SparseLongArrayKt$keyIterator$1(sparseLongArray);
    }

    @OOXIXo
    public static final SparseLongArray plus(@OOXIXo SparseLongArray sparseLongArray, @OOXIXo SparseLongArray sparseLongArray2) {
        SparseLongArray sparseLongArray3 = new SparseLongArray(sparseLongArray.size() + sparseLongArray2.size());
        putAll(sparseLongArray3, sparseLongArray);
        putAll(sparseLongArray3, sparseLongArray2);
        return sparseLongArray3;
    }

    public static final void putAll(@OOXIXo SparseLongArray sparseLongArray, @OOXIXo SparseLongArray sparseLongArray2) {
        int size = sparseLongArray2.size();
        for (int i = 0; i < size; i++) {
            sparseLongArray.put(sparseLongArray2.keyAt(i), sparseLongArray2.valueAt(i));
        }
    }

    public static final boolean remove(@OOXIXo SparseLongArray sparseLongArray, int i, long j) {
        int indexOfKey = sparseLongArray.indexOfKey(i);
        if (indexOfKey < 0 || j != sparseLongArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseLongArray.removeAt(indexOfKey);
        return true;
    }

    public static final void set(@OOXIXo SparseLongArray sparseLongArray, int i, long j) {
        sparseLongArray.put(i, j);
    }

    @OOXIXo
    public static final Xx000oIo valueIterator(@OOXIXo SparseLongArray sparseLongArray) {
        return new SparseLongArrayKt$valueIterator$1(sparseLongArray);
    }
}
