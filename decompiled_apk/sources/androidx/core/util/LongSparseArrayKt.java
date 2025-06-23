package androidx.core.util;

import Oox.x0xO0oo;
import android.util.LongSparseArray;
import java.util.Iterator;
import kotlin.collections.Xx000oIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nLongSparseArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LongSparseArray.kt\nandroidx/core/util/LongSparseArrayKt\n*L\n1#1,99:1\n77#1,4:100\n*S KotlinDebug\n*F\n+ 1 LongSparseArray.kt\nandroidx/core/util/LongSparseArrayKt\n*L\n73#1:100,4\n*E\n"})
/* loaded from: classes.dex */
public final class LongSparseArrayKt {
    public static final <T> boolean contains(@OXOo.OOXIXo LongSparseArray<T> longSparseArray, long j) {
        if (longSparseArray.indexOfKey(j) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean containsKey(@OXOo.OOXIXo LongSparseArray<T> longSparseArray, long j) {
        if (longSparseArray.indexOfKey(j) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean containsValue(@OXOo.OOXIXo LongSparseArray<T> longSparseArray, T t) {
        if (longSparseArray.indexOfValue(t) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> void forEach(@OXOo.OOXIXo LongSparseArray<T> longSparseArray, @OXOo.OOXIXo x0xO0oo<? super Long, ? super T, oXIO0o0XI> x0xo0oo) {
        int size = longSparseArray.size();
        for (int i = 0; i < size; i++) {
            x0xo0oo.invoke(Long.valueOf(longSparseArray.keyAt(i)), longSparseArray.valueAt(i));
        }
    }

    public static final <T> T getOrDefault(@OXOo.OOXIXo LongSparseArray<T> longSparseArray, long j, T t) {
        T t2 = longSparseArray.get(j);
        if (t2 != null) {
            return t2;
        }
        return t;
    }

    public static final <T> T getOrElse(@OXOo.OOXIXo LongSparseArray<T> longSparseArray, long j, @OXOo.OOXIXo Oox.oIX0oI<? extends T> oix0oi) {
        T t = longSparseArray.get(j);
        if (t == null) {
            return oix0oi.invoke();
        }
        return t;
    }

    public static final <T> int getSize(@OXOo.OOXIXo LongSparseArray<T> longSparseArray) {
        return longSparseArray.size();
    }

    public static final <T> boolean isEmpty(@OXOo.OOXIXo LongSparseArray<T> longSparseArray) {
        if (longSparseArray.size() == 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean isNotEmpty(@OXOo.OOXIXo LongSparseArray<T> longSparseArray) {
        if (longSparseArray.size() != 0) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    public static final <T> Xx000oIo keyIterator(@OXOo.OOXIXo final LongSparseArray<T> longSparseArray) {
        return new Xx000oIo() { // from class: androidx.core.util.LongSparseArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.index < longSparseArray.size()) {
                    return true;
                }
                return false;
            }

            @Override // kotlin.collections.Xx000oIo
            public long nextLong() {
                LongSparseArray<T> longSparseArray2 = longSparseArray;
                int i = this.index;
                this.index = i + 1;
                return longSparseArray2.keyAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }

    @OXOo.OOXIXo
    public static final <T> LongSparseArray<T> plus(@OXOo.OOXIXo LongSparseArray<T> longSparseArray, @OXOo.OOXIXo LongSparseArray<T> longSparseArray2) {
        LongSparseArray<T> longSparseArray3 = new LongSparseArray<>(longSparseArray.size() + longSparseArray2.size());
        putAll(longSparseArray3, longSparseArray);
        putAll(longSparseArray3, longSparseArray2);
        return longSparseArray3;
    }

    public static final <T> void putAll(@OXOo.OOXIXo LongSparseArray<T> longSparseArray, @OXOo.OOXIXo LongSparseArray<T> longSparseArray2) {
        int size = longSparseArray2.size();
        for (int i = 0; i < size; i++) {
            longSparseArray.put(longSparseArray2.keyAt(i), longSparseArray2.valueAt(i));
        }
    }

    public static final <T> boolean remove(@OXOo.OOXIXo LongSparseArray<T> longSparseArray, long j, T t) {
        int indexOfKey = longSparseArray.indexOfKey(j);
        if (indexOfKey >= 0 && IIX0o.Oxx0IOOO(t, longSparseArray.valueAt(indexOfKey))) {
            longSparseArray.removeAt(indexOfKey);
            return true;
        }
        return false;
    }

    public static final <T> void set(@OXOo.OOXIXo LongSparseArray<T> longSparseArray, long j, T t) {
        longSparseArray.put(j, t);
    }

    @OXOo.OOXIXo
    public static final <T> Iterator<T> valueIterator(@OXOo.OOXIXo LongSparseArray<T> longSparseArray) {
        return new LongSparseArrayKt$valueIterator$1(longSparseArray);
    }
}
