package androidx.core.util;

import Oox.x0xO0oo;
import android.util.SparseLongArray;
import kotlin.collections.Xx000oIo;
import kotlin.collections.oOXoIIIo;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nSparseLongArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseLongArray.kt\nandroidx/core/util/SparseLongArrayKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,93:1\n75#1,4:95\n1#2:94\n*S KotlinDebug\n*F\n+ 1 SparseLongArray.kt\nandroidx/core/util/SparseLongArrayKt\n*L\n71#1:95,4\n*E\n"})
/* loaded from: classes.dex */
public final class SparseLongArrayKt {
    public static final boolean contains(@OXOo.OOXIXo SparseLongArray sparseLongArray, int i) {
        if (sparseLongArray.indexOfKey(i) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsKey(@OXOo.OOXIXo SparseLongArray sparseLongArray, int i) {
        if (sparseLongArray.indexOfKey(i) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsValue(@OXOo.OOXIXo SparseLongArray sparseLongArray, long j) {
        if (sparseLongArray.indexOfValue(j) >= 0) {
            return true;
        }
        return false;
    }

    public static final void forEach(@OXOo.OOXIXo SparseLongArray sparseLongArray, @OXOo.OOXIXo x0xO0oo<? super Integer, ? super Long, oXIO0o0XI> x0xo0oo) {
        int size = sparseLongArray.size();
        for (int i = 0; i < size; i++) {
            x0xo0oo.invoke(Integer.valueOf(sparseLongArray.keyAt(i)), Long.valueOf(sparseLongArray.valueAt(i)));
        }
    }

    public static final long getOrDefault(@OXOo.OOXIXo SparseLongArray sparseLongArray, int i, long j) {
        return sparseLongArray.get(i, j);
    }

    public static final long getOrElse(@OXOo.OOXIXo SparseLongArray sparseLongArray, int i, @OXOo.OOXIXo Oox.oIX0oI<Long> oix0oi) {
        int indexOfKey = sparseLongArray.indexOfKey(i);
        if (indexOfKey >= 0) {
            return sparseLongArray.valueAt(indexOfKey);
        }
        return oix0oi.invoke().longValue();
    }

    public static final int getSize(@OXOo.OOXIXo SparseLongArray sparseLongArray) {
        return sparseLongArray.size();
    }

    public static final boolean isEmpty(@OXOo.OOXIXo SparseLongArray sparseLongArray) {
        if (sparseLongArray.size() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotEmpty(@OXOo.OOXIXo SparseLongArray sparseLongArray) {
        if (sparseLongArray.size() != 0) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    public static final oOXoIIIo keyIterator(@OXOo.OOXIXo final SparseLongArray sparseLongArray) {
        return new oOXoIIIo() { // from class: androidx.core.util.SparseLongArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.index < sparseLongArray.size()) {
                    return true;
                }
                return false;
            }

            @Override // kotlin.collections.oOXoIIIo
            public int nextInt() {
                SparseLongArray sparseLongArray2 = sparseLongArray;
                int i = this.index;
                this.index = i + 1;
                return sparseLongArray2.keyAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }

    @OXOo.OOXIXo
    public static final SparseLongArray plus(@OXOo.OOXIXo SparseLongArray sparseLongArray, @OXOo.OOXIXo SparseLongArray sparseLongArray2) {
        SparseLongArray sparseLongArray3 = new SparseLongArray(sparseLongArray.size() + sparseLongArray2.size());
        putAll(sparseLongArray3, sparseLongArray);
        putAll(sparseLongArray3, sparseLongArray2);
        return sparseLongArray3;
    }

    public static final void putAll(@OXOo.OOXIXo SparseLongArray sparseLongArray, @OXOo.OOXIXo SparseLongArray sparseLongArray2) {
        int size = sparseLongArray2.size();
        for (int i = 0; i < size; i++) {
            sparseLongArray.put(sparseLongArray2.keyAt(i), sparseLongArray2.valueAt(i));
        }
    }

    public static final boolean remove(@OXOo.OOXIXo SparseLongArray sparseLongArray, int i, long j) {
        int indexOfKey = sparseLongArray.indexOfKey(i);
        if (indexOfKey >= 0 && j == sparseLongArray.valueAt(indexOfKey)) {
            sparseLongArray.removeAt(indexOfKey);
            return true;
        }
        return false;
    }

    public static final void set(@OXOo.OOXIXo SparseLongArray sparseLongArray, int i, long j) {
        sparseLongArray.put(i, j);
    }

    @OXOo.OOXIXo
    public static final Xx000oIo valueIterator(@OXOo.OOXIXo final SparseLongArray sparseLongArray) {
        return new Xx000oIo() { // from class: androidx.core.util.SparseLongArrayKt$valueIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.index < sparseLongArray.size()) {
                    return true;
                }
                return false;
            }

            @Override // kotlin.collections.Xx000oIo
            public long nextLong() {
                SparseLongArray sparseLongArray2 = sparseLongArray;
                int i = this.index;
                this.index = i + 1;
                return sparseLongArray2.valueAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }
}
