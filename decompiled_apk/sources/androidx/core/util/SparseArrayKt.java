package androidx.core.util;

import Oox.x0xO0oo;
import android.util.SparseArray;
import java.util.Iterator;
import kotlin.collections.oOXoIIIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nSparseArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseArray.kt\nandroidx/core/util/SparseArrayKt\n*L\n1#1,94:1\n76#1,4:95\n*S KotlinDebug\n*F\n+ 1 SparseArray.kt\nandroidx/core/util/SparseArrayKt\n*L\n72#1:95,4\n*E\n"})
/* loaded from: classes.dex */
public final class SparseArrayKt {
    public static final <T> boolean contains(@OXOo.OOXIXo SparseArray<T> sparseArray, int i) {
        if (sparseArray.indexOfKey(i) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean containsKey(@OXOo.OOXIXo SparseArray<T> sparseArray, int i) {
        if (sparseArray.indexOfKey(i) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean containsValue(@OXOo.OOXIXo SparseArray<T> sparseArray, T t) {
        if (sparseArray.indexOfValue(t) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> void forEach(@OXOo.OOXIXo SparseArray<T> sparseArray, @OXOo.OOXIXo x0xO0oo<? super Integer, ? super T, oXIO0o0XI> x0xo0oo) {
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            x0xo0oo.invoke(Integer.valueOf(sparseArray.keyAt(i)), sparseArray.valueAt(i));
        }
    }

    public static final <T> T getOrDefault(@OXOo.OOXIXo SparseArray<T> sparseArray, int i, T t) {
        T t2 = sparseArray.get(i);
        if (t2 != null) {
            return t2;
        }
        return t;
    }

    public static final <T> T getOrElse(@OXOo.OOXIXo SparseArray<T> sparseArray, int i, @OXOo.OOXIXo Oox.oIX0oI<? extends T> oix0oi) {
        T t = sparseArray.get(i);
        if (t == null) {
            return oix0oi.invoke();
        }
        return t;
    }

    public static final <T> int getSize(@OXOo.OOXIXo SparseArray<T> sparseArray) {
        return sparseArray.size();
    }

    public static final <T> boolean isEmpty(@OXOo.OOXIXo SparseArray<T> sparseArray) {
        if (sparseArray.size() == 0) {
            return true;
        }
        return false;
    }

    public static final <T> boolean isNotEmpty(@OXOo.OOXIXo SparseArray<T> sparseArray) {
        if (sparseArray.size() != 0) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    public static final <T> oOXoIIIo keyIterator(@OXOo.OOXIXo final SparseArray<T> sparseArray) {
        return new oOXoIIIo() { // from class: androidx.core.util.SparseArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.index < sparseArray.size()) {
                    return true;
                }
                return false;
            }

            @Override // kotlin.collections.oOXoIIIo
            public int nextInt() {
                SparseArray<T> sparseArray2 = sparseArray;
                int i = this.index;
                this.index = i + 1;
                return sparseArray2.keyAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }

    @OXOo.OOXIXo
    public static final <T> SparseArray<T> plus(@OXOo.OOXIXo SparseArray<T> sparseArray, @OXOo.OOXIXo SparseArray<T> sparseArray2) {
        SparseArray<T> sparseArray3 = new SparseArray<>(sparseArray.size() + sparseArray2.size());
        putAll(sparseArray3, sparseArray);
        putAll(sparseArray3, sparseArray2);
        return sparseArray3;
    }

    public static final <T> void putAll(@OXOo.OOXIXo SparseArray<T> sparseArray, @OXOo.OOXIXo SparseArray<T> sparseArray2) {
        int size = sparseArray2.size();
        for (int i = 0; i < size; i++) {
            sparseArray.put(sparseArray2.keyAt(i), sparseArray2.valueAt(i));
        }
    }

    public static final <T> boolean remove(@OXOo.OOXIXo SparseArray<T> sparseArray, int i, T t) {
        int indexOfKey = sparseArray.indexOfKey(i);
        if (indexOfKey >= 0 && IIX0o.Oxx0IOOO(t, sparseArray.valueAt(indexOfKey))) {
            sparseArray.removeAt(indexOfKey);
            return true;
        }
        return false;
    }

    public static final <T> void set(@OXOo.OOXIXo SparseArray<T> sparseArray, int i, T t) {
        sparseArray.put(i, t);
    }

    @OXOo.OOXIXo
    public static final <T> Iterator<T> valueIterator(@OXOo.OOXIXo SparseArray<T> sparseArray) {
        return new SparseArrayKt$valueIterator$1(sparseArray);
    }
}
