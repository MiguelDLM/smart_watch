package androidx.core.util;

import Oox.x0xO0oo;
import android.util.SparseBooleanArray;
import kotlin.collections.oO;
import kotlin.collections.oOXoIIIo;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nSparseBooleanArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseBooleanArray.kt\nandroidx/core/util/SparseBooleanArrayKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,95:1\n77#1,4:97\n1#2:96\n*S KotlinDebug\n*F\n+ 1 SparseBooleanArray.kt\nandroidx/core/util/SparseBooleanArrayKt\n*L\n73#1:97,4\n*E\n"})
/* loaded from: classes.dex */
public final class SparseBooleanArrayKt {
    public static final boolean contains(@OXOo.OOXIXo SparseBooleanArray sparseBooleanArray, int i) {
        if (sparseBooleanArray.indexOfKey(i) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsKey(@OXOo.OOXIXo SparseBooleanArray sparseBooleanArray, int i) {
        if (sparseBooleanArray.indexOfKey(i) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean containsValue(@OXOo.OOXIXo SparseBooleanArray sparseBooleanArray, boolean z) {
        if (sparseBooleanArray.indexOfValue(z) >= 0) {
            return true;
        }
        return false;
    }

    public static final void forEach(@OXOo.OOXIXo SparseBooleanArray sparseBooleanArray, @OXOo.OOXIXo x0xO0oo<? super Integer, ? super Boolean, oXIO0o0XI> x0xo0oo) {
        int size = sparseBooleanArray.size();
        for (int i = 0; i < size; i++) {
            x0xo0oo.invoke(Integer.valueOf(sparseBooleanArray.keyAt(i)), Boolean.valueOf(sparseBooleanArray.valueAt(i)));
        }
    }

    public static final boolean getOrDefault(@OXOo.OOXIXo SparseBooleanArray sparseBooleanArray, int i, boolean z) {
        return sparseBooleanArray.get(i, z);
    }

    public static final boolean getOrElse(@OXOo.OOXIXo SparseBooleanArray sparseBooleanArray, int i, @OXOo.OOXIXo Oox.oIX0oI<Boolean> oix0oi) {
        int indexOfKey = sparseBooleanArray.indexOfKey(i);
        if (indexOfKey >= 0) {
            return sparseBooleanArray.valueAt(indexOfKey);
        }
        return oix0oi.invoke().booleanValue();
    }

    public static final int getSize(@OXOo.OOXIXo SparseBooleanArray sparseBooleanArray) {
        return sparseBooleanArray.size();
    }

    public static final boolean isEmpty(@OXOo.OOXIXo SparseBooleanArray sparseBooleanArray) {
        if (sparseBooleanArray.size() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotEmpty(@OXOo.OOXIXo SparseBooleanArray sparseBooleanArray) {
        if (sparseBooleanArray.size() != 0) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    public static final oOXoIIIo keyIterator(@OXOo.OOXIXo final SparseBooleanArray sparseBooleanArray) {
        return new oOXoIIIo() { // from class: androidx.core.util.SparseBooleanArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.index < sparseBooleanArray.size()) {
                    return true;
                }
                return false;
            }

            @Override // kotlin.collections.oOXoIIIo
            public int nextInt() {
                SparseBooleanArray sparseBooleanArray2 = sparseBooleanArray;
                int i = this.index;
                this.index = i + 1;
                return sparseBooleanArray2.keyAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }

    @OXOo.OOXIXo
    public static final SparseBooleanArray plus(@OXOo.OOXIXo SparseBooleanArray sparseBooleanArray, @OXOo.OOXIXo SparseBooleanArray sparseBooleanArray2) {
        SparseBooleanArray sparseBooleanArray3 = new SparseBooleanArray(sparseBooleanArray.size() + sparseBooleanArray2.size());
        putAll(sparseBooleanArray3, sparseBooleanArray);
        putAll(sparseBooleanArray3, sparseBooleanArray2);
        return sparseBooleanArray3;
    }

    public static final void putAll(@OXOo.OOXIXo SparseBooleanArray sparseBooleanArray, @OXOo.OOXIXo SparseBooleanArray sparseBooleanArray2) {
        int size = sparseBooleanArray2.size();
        for (int i = 0; i < size; i++) {
            sparseBooleanArray.put(sparseBooleanArray2.keyAt(i), sparseBooleanArray2.valueAt(i));
        }
    }

    public static final boolean remove(@OXOo.OOXIXo SparseBooleanArray sparseBooleanArray, int i, boolean z) {
        int indexOfKey = sparseBooleanArray.indexOfKey(i);
        if (indexOfKey >= 0 && z == sparseBooleanArray.valueAt(indexOfKey)) {
            sparseBooleanArray.delete(i);
            return true;
        }
        return false;
    }

    public static final void set(@OXOo.OOXIXo SparseBooleanArray sparseBooleanArray, int i, boolean z) {
        sparseBooleanArray.put(i, z);
    }

    @OXOo.OOXIXo
    public static final oO valueIterator(@OXOo.OOXIXo final SparseBooleanArray sparseBooleanArray) {
        return new oO() { // from class: androidx.core.util.SparseBooleanArrayKt$valueIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.index < sparseBooleanArray.size()) {
                    return true;
                }
                return false;
            }

            @Override // kotlin.collections.oO
            public boolean nextBoolean() {
                SparseBooleanArray sparseBooleanArray2 = sparseBooleanArray;
                int i = this.index;
                this.index = i + 1;
                return sparseBooleanArray2.valueAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }
}
