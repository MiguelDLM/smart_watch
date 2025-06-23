package androidx.core.util;

import Oox.x0xO0oo;
import android.util.SparseIntArray;
import kotlin.collections.oOXoIIIo;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nSparseIntArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseIntArray.kt\nandroidx/core/util/SparseIntArrayKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,93:1\n75#1,4:95\n1#2:94\n*S KotlinDebug\n*F\n+ 1 SparseIntArray.kt\nandroidx/core/util/SparseIntArrayKt\n*L\n71#1:95,4\n*E\n"})
/* loaded from: classes.dex */
public final class SparseIntArrayKt {
    public static final boolean contains(@OXOo.OOXIXo SparseIntArray sparseIntArray, int i) {
        if (sparseIntArray.indexOfKey(i) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsKey(@OXOo.OOXIXo SparseIntArray sparseIntArray, int i) {
        if (sparseIntArray.indexOfKey(i) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsValue(@OXOo.OOXIXo SparseIntArray sparseIntArray, int i) {
        if (sparseIntArray.indexOfValue(i) >= 0) {
            return true;
        }
        return false;
    }

    public static final void forEach(@OXOo.OOXIXo SparseIntArray sparseIntArray, @OXOo.OOXIXo x0xO0oo<? super Integer, ? super Integer, oXIO0o0XI> x0xo0oo) {
        int size = sparseIntArray.size();
        for (int i = 0; i < size; i++) {
            x0xo0oo.invoke(Integer.valueOf(sparseIntArray.keyAt(i)), Integer.valueOf(sparseIntArray.valueAt(i)));
        }
    }

    public static final int getOrDefault(@OXOo.OOXIXo SparseIntArray sparseIntArray, int i, int i2) {
        return sparseIntArray.get(i, i2);
    }

    public static final int getOrElse(@OXOo.OOXIXo SparseIntArray sparseIntArray, int i, @OXOo.OOXIXo Oox.oIX0oI<Integer> oix0oi) {
        int indexOfKey = sparseIntArray.indexOfKey(i);
        if (indexOfKey >= 0) {
            return sparseIntArray.valueAt(indexOfKey);
        }
        return oix0oi.invoke().intValue();
    }

    public static final int getSize(@OXOo.OOXIXo SparseIntArray sparseIntArray) {
        return sparseIntArray.size();
    }

    public static final boolean isEmpty(@OXOo.OOXIXo SparseIntArray sparseIntArray) {
        if (sparseIntArray.size() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotEmpty(@OXOo.OOXIXo SparseIntArray sparseIntArray) {
        if (sparseIntArray.size() != 0) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    public static final oOXoIIIo keyIterator(@OXOo.OOXIXo final SparseIntArray sparseIntArray) {
        return new oOXoIIIo() { // from class: androidx.core.util.SparseIntArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.index < sparseIntArray.size()) {
                    return true;
                }
                return false;
            }

            @Override // kotlin.collections.oOXoIIIo
            public int nextInt() {
                SparseIntArray sparseIntArray2 = sparseIntArray;
                int i = this.index;
                this.index = i + 1;
                return sparseIntArray2.keyAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }

    @OXOo.OOXIXo
    public static final SparseIntArray plus(@OXOo.OOXIXo SparseIntArray sparseIntArray, @OXOo.OOXIXo SparseIntArray sparseIntArray2) {
        SparseIntArray sparseIntArray3 = new SparseIntArray(sparseIntArray.size() + sparseIntArray2.size());
        putAll(sparseIntArray3, sparseIntArray);
        putAll(sparseIntArray3, sparseIntArray2);
        return sparseIntArray3;
    }

    public static final void putAll(@OXOo.OOXIXo SparseIntArray sparseIntArray, @OXOo.OOXIXo SparseIntArray sparseIntArray2) {
        int size = sparseIntArray2.size();
        for (int i = 0; i < size; i++) {
            sparseIntArray.put(sparseIntArray2.keyAt(i), sparseIntArray2.valueAt(i));
        }
    }

    public static final boolean remove(@OXOo.OOXIXo SparseIntArray sparseIntArray, int i, int i2) {
        int indexOfKey = sparseIntArray.indexOfKey(i);
        if (indexOfKey >= 0 && i2 == sparseIntArray.valueAt(indexOfKey)) {
            sparseIntArray.removeAt(indexOfKey);
            return true;
        }
        return false;
    }

    public static final void set(@OXOo.OOXIXo SparseIntArray sparseIntArray, int i, int i2) {
        sparseIntArray.put(i, i2);
    }

    @OXOo.OOXIXo
    public static final oOXoIIIo valueIterator(@OXOo.OOXIXo final SparseIntArray sparseIntArray) {
        return new oOXoIIIo() { // from class: androidx.core.util.SparseIntArrayKt$valueIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.index < sparseIntArray.size()) {
                    return true;
                }
                return false;
            }

            @Override // kotlin.collections.oOXoIIIo
            public int nextInt() {
                SparseIntArray sparseIntArray2 = sparseIntArray;
                int i = this.index;
                this.index = i + 1;
                return sparseIntArray2.valueAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }
}
