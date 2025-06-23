package androidx.collection;

import OXOo.oOoXoXO;
import XO0OX.XO;
import XO0OX.xoIox;
import XO0OX.xxIXOIIO;
import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import kotlin.OOXIXo;
import kotlin.collections.ooOOo0oXI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nSparseArrayCompat.jvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseArrayCompat.jvm.kt\nandroidx/collection/SparseArrayCompat\n+ 2 SparseArrayCompat.kt\nandroidx/collection/SparseArrayCompatKt\n*L\n1#1,273:1\n275#2,9:274\n288#2,5:283\n296#2,5:288\n304#2,8:293\n320#2,9:301\n353#2,40:310\n396#2,2:350\n353#2,47:352\n403#2,3:399\n353#2,40:402\n407#2:442\n412#2,4:443\n419#2:447\n423#2,4:448\n431#2,8:452\n443#2,5:460\n451#2,4:465\n459#2,9:469\n472#2:478\n477#2:479\n459#2,9:480\n482#2,8:489\n493#2,17:497\n513#2,21:514\n*S KotlinDebug\n*F\n+ 1 SparseArrayCompat.jvm.kt\nandroidx/collection/SparseArrayCompat\n*L\n130#1:274,9\n135#1:283,5\n144#1:288,5\n152#1:293,8\n163#1:301,9\n169#1:310,40\n176#1:350,2\n176#1:352,47\n186#1:399,3\n186#1:402,40\n186#1:442\n191#1:443,4\n205#1:447\n212#1:448,4\n218#1:452,8\n224#1:460,5\n234#1:465,4\n246#1:469,9\n249#1:478\n252#1:479\n252#1:480,9\n257#1:489,8\n263#1:497,17\n271#1:514,21\n*E\n"})
public class SparseArrayCompat<E> implements Cloneable {
    @XO
    public /* synthetic */ boolean garbage;
    @XO
    public /* synthetic */ int[] keys;
    @XO
    public /* synthetic */ int size;
    @XO
    public /* synthetic */ Object[] values;

    @xoIox
    public SparseArrayCompat() {
        this(0, 1, (IIXOooo) null);
    }

    public void append(int i, E e) {
        int i2 = this.size;
        if (i2 == 0 || i > this.keys[i2 - 1]) {
            if (this.garbage && i2 >= this.keys.length) {
                SparseArrayCompatKt.gc(this);
            }
            int i3 = this.size;
            if (i3 >= this.keys.length) {
                int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i3 + 1);
                int[] copyOf = Arrays.copyOf(this.keys, idealIntArraySize);
                IIX0o.oO(copyOf, "copyOf(this, newSize)");
                this.keys = copyOf;
                Object[] copyOf2 = Arrays.copyOf(this.values, idealIntArraySize);
                IIX0o.oO(copyOf2, "copyOf(this, newSize)");
                this.values = copyOf2;
            }
            this.keys[i3] = i;
            this.values[i3] = e;
            this.size = i3 + 1;
            return;
        }
        put(i, e);
    }

    public void clear() {
        int i = this.size;
        Object[] objArr = this.values;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.size = 0;
        this.garbage = false;
    }

    public boolean containsKey(int i) {
        if (indexOfKey(i) >= 0) {
            return true;
        }
        return false;
    }

    public boolean containsValue(E e) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        int i = this.size;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                i2 = -1;
                break;
            } else if (this.values[i2] == e) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 >= 0) {
            return true;
        }
        return false;
    }

    @OOXIXo(message = "Alias for remove(int).", replaceWith = @kotlin.XX(expression = "remove(key)", imports = {}))
    public void delete(int i) {
        remove(i);
    }

    @oOoXoXO
    public E get(int i) {
        return SparseArrayCompatKt.commonGet(this, i);
    }

    @xxIXOIIO(name = "getIsEmpty")
    public final boolean getIsEmpty() {
        return isEmpty();
    }

    public int indexOfKey(int i) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        return ContainerHelpersKt.binarySearch(this.keys, this.size, i);
    }

    public int indexOfValue(E e) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.values[i2] == e) {
                return i2;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public int keyAt(int i) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        return this.keys[i];
    }

    public void put(int i, E e) {
        int binarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, i);
        if (binarySearch >= 0) {
            this.values[binarySearch] = e;
            return;
        }
        int i2 = ~binarySearch;
        if (i2 >= this.size || this.values[i2] != SparseArrayCompatKt.DELETED) {
            if (this.garbage && this.size >= this.keys.length) {
                SparseArrayCompatKt.gc(this);
                i2 = ~ContainerHelpersKt.binarySearch(this.keys, this.size, i);
            }
            int i3 = this.size;
            if (i3 >= this.keys.length) {
                int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i3 + 1);
                int[] copyOf = Arrays.copyOf(this.keys, idealIntArraySize);
                IIX0o.oO(copyOf, "copyOf(this, newSize)");
                this.keys = copyOf;
                Object[] copyOf2 = Arrays.copyOf(this.values, idealIntArraySize);
                IIX0o.oO(copyOf2, "copyOf(this, newSize)");
                this.values = copyOf2;
            }
            int i4 = this.size;
            if (i4 - i2 != 0) {
                int[] iArr = this.keys;
                int i5 = i2 + 1;
                ooOOo0oXI.IIxOXoOo0(iArr, iArr, i5, i2, i4);
                Object[] objArr = this.values;
                ooOOo0oXI.ooOx(objArr, objArr, i5, i2, this.size);
            }
            this.keys[i2] = i;
            this.values[i2] = e;
            this.size++;
            return;
        }
        this.keys[i2] = i;
        this.values[i2] = e;
    }

    public void putAll(@OXOo.OOXIXo SparseArrayCompat<? extends E> sparseArrayCompat) {
        IIX0o.x0xO0oo(sparseArrayCompat, "other");
        int size2 = sparseArrayCompat.size();
        for (int i = 0; i < size2; i++) {
            int keyAt = sparseArrayCompat.keyAt(i);
            Object valueAt = sparseArrayCompat.valueAt(i);
            int binarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, keyAt);
            if (binarySearch >= 0) {
                this.values[binarySearch] = valueAt;
            } else {
                int i2 = ~binarySearch;
                if (i2 >= this.size || this.values[i2] != SparseArrayCompatKt.DELETED) {
                    if (this.garbage && this.size >= this.keys.length) {
                        SparseArrayCompatKt.gc(this);
                        i2 = ~ContainerHelpersKt.binarySearch(this.keys, this.size, keyAt);
                    }
                    int i3 = this.size;
                    if (i3 >= this.keys.length) {
                        int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i3 + 1);
                        int[] copyOf = Arrays.copyOf(this.keys, idealIntArraySize);
                        IIX0o.oO(copyOf, "copyOf(this, newSize)");
                        this.keys = copyOf;
                        Object[] copyOf2 = Arrays.copyOf(this.values, idealIntArraySize);
                        IIX0o.oO(copyOf2, "copyOf(this, newSize)");
                        this.values = copyOf2;
                    }
                    int i4 = this.size;
                    if (i4 - i2 != 0) {
                        int[] iArr = this.keys;
                        int i5 = i2 + 1;
                        ooOOo0oXI.IIxOXoOo0(iArr, iArr, i5, i2, i4);
                        Object[] objArr = this.values;
                        ooOOo0oXI.ooOx(objArr, objArr, i5, i2, this.size);
                    }
                    this.keys[i2] = keyAt;
                    this.values[i2] = valueAt;
                    this.size++;
                } else {
                    this.keys[i2] = keyAt;
                    this.values[i2] = valueAt;
                }
            }
        }
    }

    @oOoXoXO
    public E putIfAbsent(int i, E e) {
        E commonGet = SparseArrayCompatKt.commonGet(this, i);
        if (commonGet == null) {
            int binarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, i);
            if (binarySearch >= 0) {
                this.values[binarySearch] = e;
            } else {
                int i2 = ~binarySearch;
                if (i2 >= this.size || this.values[i2] != SparseArrayCompatKt.DELETED) {
                    if (this.garbage && this.size >= this.keys.length) {
                        SparseArrayCompatKt.gc(this);
                        i2 = ~ContainerHelpersKt.binarySearch(this.keys, this.size, i);
                    }
                    int i3 = this.size;
                    if (i3 >= this.keys.length) {
                        int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i3 + 1);
                        int[] copyOf = Arrays.copyOf(this.keys, idealIntArraySize);
                        IIX0o.oO(copyOf, "copyOf(this, newSize)");
                        this.keys = copyOf;
                        Object[] copyOf2 = Arrays.copyOf(this.values, idealIntArraySize);
                        IIX0o.oO(copyOf2, "copyOf(this, newSize)");
                        this.values = copyOf2;
                    }
                    int i4 = this.size;
                    if (i4 - i2 != 0) {
                        int[] iArr = this.keys;
                        int i5 = i2 + 1;
                        ooOOo0oXI.IIxOXoOo0(iArr, iArr, i5, i2, i4);
                        Object[] objArr = this.values;
                        ooOOo0oXI.ooOx(objArr, objArr, i5, i2, this.size);
                    }
                    this.keys[i2] = i;
                    this.values[i2] = e;
                    this.size++;
                } else {
                    this.keys[i2] = i;
                    this.values[i2] = e;
                }
            }
        }
        return commonGet;
    }

    public void remove(int i) {
        SparseArrayCompatKt.commonRemove(this, i);
    }

    public void removeAt(int i) {
        if (this.values[i] != SparseArrayCompatKt.DELETED) {
            this.values[i] = SparseArrayCompatKt.DELETED;
            this.garbage = true;
        }
    }

    public void removeAtRange(int i, int i2) {
        int min = Math.min(i2, i + i2);
        while (i < min) {
            removeAt(i);
            i++;
        }
    }

    @oOoXoXO
    public E replace(int i, E e) {
        int indexOfKey = indexOfKey(i);
        if (indexOfKey < 0) {
            return null;
        }
        E[] eArr = this.values;
        E e2 = eArr[indexOfKey];
        eArr[indexOfKey] = e;
        return e2;
    }

    public void setValueAt(int i, E e) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        this.values[i] = e;
    }

    public int size() {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        return this.size;
    }

    @OXOo.OOXIXo
    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.size * 28);
        sb.append('{');
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(keyAt(i2));
            sb.append('=');
            Object valueAt = valueAt(i2);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "buffer.toString()");
        return sb2;
    }

    public E valueAt(int i) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        return this.values[i];
    }

    @xoIox
    public SparseArrayCompat(int i) {
        if (i == 0) {
            this.keys = ContainerHelpersKt.EMPTY_INTS;
            this.values = ContainerHelpersKt.EMPTY_OBJECTS;
            return;
        }
        int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i);
        this.keys = new int[idealIntArraySize];
        this.values = new Object[idealIntArraySize];
    }

    @OXOo.OOXIXo
    public SparseArrayCompat<E> clone() {
        Object clone = super.clone();
        IIX0o.x0XOIxOo(clone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat) clone;
        sparseArrayCompat.keys = (int[]) this.keys.clone();
        sparseArrayCompat.values = (Object[]) this.values.clone();
        return sparseArrayCompat;
    }

    public E get(int i, E e) {
        return SparseArrayCompatKt.commonGet(this, i, e);
    }

    public boolean remove(int i, @oOoXoXO Object obj) {
        int indexOfKey = indexOfKey(i);
        if (indexOfKey < 0 || !IIX0o.Oxx0IOOO(obj, valueAt(indexOfKey))) {
            return false;
        }
        removeAt(indexOfKey);
        return true;
    }

    public boolean replace(int i, E e, E e2) {
        int indexOfKey = indexOfKey(i);
        if (indexOfKey < 0 || !IIX0o.Oxx0IOOO(this.values[indexOfKey], e)) {
            return false;
        }
        this.values[indexOfKey] = e2;
        return true;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SparseArrayCompat(int i, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 10 : i);
    }
}
