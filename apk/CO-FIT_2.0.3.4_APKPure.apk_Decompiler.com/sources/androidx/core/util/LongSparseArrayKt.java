package androidx.core.util;

import OXOo.OOXIXo;
import Oox.oIX0oI;
import Oox.x0xO0oo;
import android.util.LongSparseArray;
import java.util.Iterator;
import kotlin.collections.Xx000oIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nLongSparseArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LongSparseArray.kt\nandroidx/core/util/LongSparseArrayKt\n*L\n1#1,99:1\n77#1,4:100\n*S KotlinDebug\n*F\n+ 1 LongSparseArray.kt\nandroidx/core/util/LongSparseArrayKt\n*L\n73#1:100,4\n*E\n"})
public final class LongSparseArrayKt {
    public static final <T> boolean contains(@OOXIXo LongSparseArray<T> longSparseArray, long j) {
        if (longSparseArray.indexOfKey(j) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean containsKey(@OOXIXo LongSparseArray<T> longSparseArray, long j) {
        if (longSparseArray.indexOfKey(j) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean containsValue(@OOXIXo LongSparseArray<T> longSparseArray, T t) {
        if (longSparseArray.indexOfValue(t) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> void forEach(@OOXIXo LongSparseArray<T> longSparseArray, @OOXIXo x0xO0oo<? super Long, ? super T, oXIO0o0XI> x0xo0oo) {
        int size = longSparseArray.size();
        for (int i = 0; i < size; i++) {
            x0xo0oo.invoke(Long.valueOf(longSparseArray.keyAt(i)), longSparseArray.valueAt(i));
        }
    }

    public static final <T> T getOrDefault(@OOXIXo LongSparseArray<T> longSparseArray, long j, T t) {
        T t2 = longSparseArray.get(j);
        if (t2 == null) {
            return t;
        }
        return t2;
    }

    public static final <T> T getOrElse(@OOXIXo LongSparseArray<T> longSparseArray, long j, @OOXIXo oIX0oI<? extends T> oix0oi) {
        T t = longSparseArray.get(j);
        if (t == null) {
            return oix0oi.invoke();
        }
        return t;
    }

    public static final <T> int getSize(@OOXIXo LongSparseArray<T> longSparseArray) {
        return longSparseArray.size();
    }

    public static final <T> boolean isEmpty(@OOXIXo LongSparseArray<T> longSparseArray) {
        if (longSparseArray.size() == 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean isNotEmpty(@OOXIXo LongSparseArray<T> longSparseArray) {
        if (longSparseArray.size() != 0) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public static final <T> Xx000oIo keyIterator(@OOXIXo LongSparseArray<T> longSparseArray) {
        return new LongSparseArrayKt$keyIterator$1(longSparseArray);
    }

    @OOXIXo
    public static final <T> LongSparseArray<T> plus(@OOXIXo LongSparseArray<T> longSparseArray, @OOXIXo LongSparseArray<T> longSparseArray2) {
        LongSparseArray<T> longSparseArray3 = new LongSparseArray<>(longSparseArray.size() + longSparseArray2.size());
        putAll(longSparseArray3, longSparseArray);
        putAll(longSparseArray3, longSparseArray2);
        return longSparseArray3;
    }

    public static final <T> void putAll(@OOXIXo LongSparseArray<T> longSparseArray, @OOXIXo LongSparseArray<T> longSparseArray2) {
        int size = longSparseArray2.size();
        for (int i = 0; i < size; i++) {
            longSparseArray.put(longSparseArray2.keyAt(i), longSparseArray2.valueAt(i));
        }
    }

    public static final <T> boolean remove(@OOXIXo LongSparseArray<T> longSparseArray, long j, T t) {
        int indexOfKey = longSparseArray.indexOfKey(j);
        if (indexOfKey < 0 || !IIX0o.Oxx0IOOO(t, longSparseArray.valueAt(indexOfKey))) {
            return false;
        }
        longSparseArray.removeAt(indexOfKey);
        return true;
    }

    public static final <T> void set(@OOXIXo LongSparseArray<T> longSparseArray, long j, T t) {
        longSparseArray.put(j, t);
    }

    @OOXIXo
    public static final <T> Iterator<T> valueIterator(@OOXIXo LongSparseArray<T> longSparseArray) {
        return new LongSparseArrayKt$valueIterator$1(longSparseArray);
    }
}
