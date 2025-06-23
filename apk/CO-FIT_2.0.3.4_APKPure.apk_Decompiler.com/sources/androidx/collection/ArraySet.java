package androidx.collection;

import OI0IXox.II0XooXoX;
import OI0IXox.II0xO0;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import androidx.collection.internal.ContainerHelpersKt;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.ooOOo0oXI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nArraySet.jvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArraySet.jvm.kt\nandroidx/collection/ArraySet\n+ 2 ArraySet.kt\nandroidx/collection/ArraySetKt\n*L\n1#1,300:1\n304#2,10:301\n317#2,14:311\n334#2:325\n339#2:326\n345#2:327\n350#2:328\n355#2,61:329\n420#2,17:390\n440#2,6:407\n450#2,60:413\n518#2,9:473\n531#2,22:482\n557#2,7:504\n568#2,19:511\n591#2,6:530\n601#2,6:536\n611#2,5:542\n620#2,8:547\n*S KotlinDebug\n*F\n+ 1 ArraySet.jvm.kt\nandroidx/collection/ArraySet\n*L\n98#1:301,10\n108#1:311,14\n118#1:325\n128#1:326\n138#1:327\n145#1:328\n157#1:329,61\n167#1:390,17\n177#1:407,6\n188#1:413,60\n197#1:473,9\n224#1:482,22\n231#1:504,7\n240#1:511,19\n267#1:530,6\n276#1:536,6\n286#1:542,5\n297#1:547,8\n*E\n"})
public final class ArraySet<E> implements Collection<E>, Set<E>, II0xO0, II0XooXoX {
    private int _size;
    @OOXIXo
    private Object[] array;
    @OOXIXo
    private int[] hashes;

    public final class ElementIterator extends IndexBasedArrayIterator<E> {
        public ElementIterator() {
            super(ArraySet.this.get_size$collection());
        }

        public E elementAt(int i) {
            return ArraySet.this.valueAt(i);
        }

        public void removeAt(int i) {
            ArraySet.this.removeAt(i);
        }
    }

    @xoIox
    public ArraySet() {
        this(0, 1, (IIXOooo) null);
    }

    public boolean add(E e) {
        int i;
        int i2;
        E e2 = e;
        int i3 = get_size$collection();
        boolean z = false;
        if (e2 == null) {
            i2 = ArraySetKt.indexOfNull(this);
            i = 0;
        } else {
            int hashCode = e.hashCode();
            i = hashCode;
            i2 = ArraySetKt.indexOf(this, e2, hashCode);
        }
        if (i2 >= 0) {
            return false;
        }
        int i4 = ~i2;
        if (i3 >= getHashes$collection().length) {
            int i5 = 8;
            if (i3 >= 8) {
                i5 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i5 = 4;
            }
            int[] hashes$collection = getHashes$collection();
            Object[] array$collection = getArray$collection();
            ArraySetKt.allocArrays(this, i5);
            if (i3 == get_size$collection()) {
                if (getHashes$collection().length == 0) {
                    z = true;
                }
                if (!z) {
                    ooOOo0oXI.oOo(hashes$collection, getHashes$collection(), 0, 0, hashes$collection.length, 6, (Object) null);
                    ooOOo0oXI.IIX0(array$collection, getArray$collection(), 0, 0, array$collection.length, 6, (Object) null);
                }
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i4 < i3) {
            int i6 = i4 + 1;
            ooOOo0oXI.IIxOXoOo0(getHashes$collection(), getHashes$collection(), i6, i4, i3);
            ooOOo0oXI.ooOx(getArray$collection(), getArray$collection(), i6, i4, i3);
        }
        if (i3 != get_size$collection() || i4 >= getHashes$collection().length) {
            throw new ConcurrentModificationException();
        }
        getHashes$collection()[i4] = i;
        getArray$collection()[i4] = e2;
        set_size$collection(get_size$collection() + 1);
        return true;
    }

    public final void addAll(@OOXIXo ArraySet<? extends E> arraySet) {
        IIX0o.x0xO0oo(arraySet, "array");
        int i = arraySet.get_size$collection();
        ensureCapacity(get_size$collection() + i);
        if (get_size$collection() != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                add(arraySet.valueAt(i2));
            }
        } else if (i > 0) {
            int i3 = i;
            ooOOo0oXI.oOo(arraySet.getHashes$collection(), getHashes$collection(), 0, 0, i3, 6, (Object) null);
            ooOOo0oXI.IIX0(arraySet.getArray$collection(), getArray$collection(), 0, 0, i3, 6, (Object) null);
            if (get_size$collection() == 0) {
                set_size$collection(i);
                return;
            }
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        if (get_size$collection() != 0) {
            setHashes$collection(ContainerHelpersKt.EMPTY_INTS);
            setArray$collection(ContainerHelpersKt.EMPTY_OBJECTS);
            set_size$collection(0);
        }
        if (get_size$collection() != 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean contains(Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    public boolean containsAll(@OOXIXo Collection<? extends Object> collection) {
        IIX0o.x0xO0oo(collection, "elements");
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public final void ensureCapacity(int i) {
        int i2 = get_size$collection();
        if (getHashes$collection().length < i) {
            int[] hashes$collection = getHashes$collection();
            Object[] array$collection = getArray$collection();
            ArraySetKt.allocArrays(this, i);
            if (get_size$collection() > 0) {
                ooOOo0oXI.oOo(hashes$collection, getHashes$collection(), 0, 0, get_size$collection(), 6, (Object) null);
                ooOOo0oXI.IIX0(array$collection, getArray$collection(), 0, 0, get_size$collection(), 6, (Object) null);
            }
        }
        if (get_size$collection() != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof Set) && size() == ((Set) obj).size()) {
            try {
                int i = get_size$collection();
                int i2 = 0;
                while (i2 < i) {
                    if (((Set) obj).contains(valueAt(i2))) {
                        i2++;
                    }
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @OOXIXo
    public final Object[] getArray$collection() {
        return this.array;
    }

    @OOXIXo
    public final int[] getHashes$collection() {
        return this.hashes;
    }

    public int getSize() {
        return this._size;
    }

    public final int get_size$collection() {
        return this._size;
    }

    public int hashCode() {
        int[] hashes$collection = getHashes$collection();
        int i = get_size$collection();
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += hashes$collection[i3];
        }
        return i2;
    }

    public final int indexOf(@oOoXoXO Object obj) {
        if (obj == null) {
            return ArraySetKt.indexOfNull(this);
        }
        return ArraySetKt.indexOf(this, obj, obj.hashCode());
    }

    public boolean isEmpty() {
        if (get_size$collection() <= 0) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    public final boolean removeAll(@OOXIXo ArraySet<? extends E> arraySet) {
        IIX0o.x0xO0oo(arraySet, "array");
        int i = arraySet.get_size$collection();
        int i2 = get_size$collection();
        for (int i3 = 0; i3 < i; i3++) {
            remove(arraySet.valueAt(i3));
        }
        if (i2 != get_size$collection()) {
            return true;
        }
        return false;
    }

    public final E removeAt(int i) {
        int i2 = get_size$collection();
        E e = getArray$collection()[i];
        if (i2 <= 1) {
            clear();
        } else {
            int i3 = i2 - 1;
            int i4 = 8;
            if (getHashes$collection().length <= 8 || get_size$collection() >= getHashes$collection().length / 3) {
                if (i < i3) {
                    int i5 = i + 1;
                    ooOOo0oXI.IIxOXoOo0(getHashes$collection(), getHashes$collection(), i, i5, i2);
                    ooOOo0oXI.ooOx(getArray$collection(), getArray$collection(), i, i5, i2);
                }
                getArray$collection()[i3] = null;
            } else {
                if (get_size$collection() > 8) {
                    i4 = get_size$collection() + (get_size$collection() >> 1);
                }
                int[] hashes$collection = getHashes$collection();
                Object[] array$collection = getArray$collection();
                ArraySetKt.allocArrays(this, i4);
                if (i > 0) {
                    int i6 = i;
                    ooOOo0oXI.oOo(hashes$collection, getHashes$collection(), 0, 0, i6, 6, (Object) null);
                    ooOOo0oXI.IIX0(array$collection, getArray$collection(), 0, 0, i6, 6, (Object) null);
                }
                if (i < i3) {
                    int i7 = i + 1;
                    ooOOo0oXI.IIxOXoOo0(hashes$collection, getHashes$collection(), i, i7, i2);
                    ooOOo0oXI.ooOx(array$collection, getArray$collection(), i, i7, i2);
                }
            }
            if (i2 == get_size$collection()) {
                set_size$collection(i3);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        return e;
    }

    public boolean retainAll(@OOXIXo Collection<? extends Object> collection) {
        IIX0o.x0xO0oo(collection, "elements");
        boolean z = false;
        for (int i = get_size$collection() - 1; -1 < i; i--) {
            if (!CollectionsKt___CollectionsKt.X00xOoXI(collection, getArray$collection()[i])) {
                removeAt(i);
                z = true;
            }
        }
        return z;
    }

    public final void setArray$collection(@OOXIXo Object[] objArr) {
        IIX0o.x0xO0oo(objArr, "<set-?>");
        this.array = objArr;
    }

    public final void setHashes$collection(@OOXIXo int[] iArr) {
        IIX0o.x0xO0oo(iArr, "<set-?>");
        this.hashes = iArr;
    }

    public final void set_size$collection(int i) {
        this._size = i;
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    @OOXIXo
    public final Object[] toArray() {
        return ooOOo0oXI.IO0XoXxO(this.array, 0, this._size);
    }

    @OOXIXo
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(get_size$collection() * 14);
        sb.append('{');
        int i = get_size$collection();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object valueAt = valueAt(i2);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public final E valueAt(int i) {
        return getArray$collection()[i];
    }

    @xoIox
    public ArraySet(int i) {
        this.hashes = ContainerHelpersKt.EMPTY_INTS;
        this.array = ContainerHelpersKt.EMPTY_OBJECTS;
        if (i > 0) {
            ArraySetKt.allocArrays(this, i);
        }
    }

    @OOXIXo
    public final <T> T[] toArray(@OOXIXo T[] tArr) {
        IIX0o.x0xO0oo(tArr, "array");
        T[] resizeForToArray = ArraySetJvmUtil.resizeForToArray(tArr, this._size);
        ooOOo0oXI.ooOx(this.array, resizeForToArray, 0, 0, this._size);
        IIX0o.oO(resizeForToArray, "result");
        return resizeForToArray;
    }

    public boolean removeAll(@OOXIXo Collection<? extends Object> collection) {
        IIX0o.x0xO0oo(collection, "elements");
        boolean z = false;
        for (Object remove : collection) {
            z |= remove(remove);
        }
        return z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ArraySet(int i, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public ArraySet(@oOoXoXO ArraySet<? extends E> arraySet) {
        this(0);
        if (arraySet != null) {
            addAll(arraySet);
        }
    }

    public ArraySet(@oOoXoXO Collection<? extends E> collection) {
        this(0);
        if (collection != null) {
            addAll(collection);
        }
    }

    public boolean addAll(@OOXIXo Collection<? extends E> collection) {
        IIX0o.x0xO0oo(collection, "elements");
        ensureCapacity(get_size$collection() + collection.size());
        boolean z = false;
        for (Object add : collection) {
            z |= add(add);
        }
        return z;
    }

    public ArraySet(@oOoXoXO E[] eArr) {
        this(0);
        if (eArr != null) {
            Iterator oIX0oI2 = kotlin.jvm.internal.II0XooXoX.oIX0oI(eArr);
            while (oIX0oI2.hasNext()) {
                add(oIX0oI2.next());
            }
        }
    }
}
