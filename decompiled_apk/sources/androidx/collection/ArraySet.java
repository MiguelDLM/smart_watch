package androidx.collection;

import OI0IXox.II0XooXoX;
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
/* loaded from: classes.dex */
public final class ArraySet<E> implements Collection<E>, Set<E>, OI0IXox.II0xO0, II0XooXoX {
    private int _size;

    @OOXIXo
    private Object[] array;

    @OOXIXo
    private int[] hashes;

    /* loaded from: classes.dex */
    public final class ElementIterator extends IndexBasedArrayIterator<E> {
        public ElementIterator() {
            super(ArraySet.this.get_size$collection());
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        public E elementAt(int i) {
            return ArraySet.this.valueAt(i);
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        public void removeAt(int i) {
            ArraySet.this.removeAt(i);
        }
    }

    @xoIox
    public ArraySet() {
        this(0, 1, null);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e) {
        int i;
        int indexOf;
        int i2 = get_size$collection();
        boolean z = false;
        if (e == null) {
            indexOf = ArraySetKt.indexOfNull(this);
            i = 0;
        } else {
            int hashCode = e.hashCode();
            i = hashCode;
            indexOf = ArraySetKt.indexOf(this, e, hashCode);
        }
        if (indexOf >= 0) {
            return false;
        }
        int i3 = ~indexOf;
        if (i2 >= getHashes$collection().length) {
            int i4 = 8;
            if (i2 >= 8) {
                i4 = (i2 >> 1) + i2;
            } else if (i2 < 4) {
                i4 = 4;
            }
            int[] hashes$collection = getHashes$collection();
            Object[] array$collection = getArray$collection();
            ArraySetKt.allocArrays(this, i4);
            if (i2 == get_size$collection()) {
                if (getHashes$collection().length == 0) {
                    z = true;
                }
                if (!z) {
                    ooOOo0oXI.oOo(hashes$collection, getHashes$collection(), 0, 0, hashes$collection.length, 6, null);
                    ooOOo0oXI.IIX0(array$collection, getArray$collection(), 0, 0, array$collection.length, 6, null);
                }
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i3 < i2) {
            int i5 = i3 + 1;
            ooOOo0oXI.IIxOXoOo0(getHashes$collection(), getHashes$collection(), i5, i3, i2);
            ooOOo0oXI.ooOx(getArray$collection(), getArray$collection(), i5, i3, i2);
        }
        if (i2 == get_size$collection() && i3 < getHashes$collection().length) {
            getHashes$collection()[i3] = i;
            getArray$collection()[i3] = e;
            set_size$collection(get_size$collection() + 1);
            return true;
        }
        throw new ConcurrentModificationException();
    }

    public final void addAll(@OOXIXo ArraySet<? extends E> array) {
        IIX0o.x0xO0oo(array, "array");
        int i = array.get_size$collection();
        ensureCapacity(get_size$collection() + i);
        if (get_size$collection() != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                add(array.valueAt(i2));
            }
            return;
        }
        if (i > 0) {
            ooOOo0oXI.oOo(array.getHashes$collection(), getHashes$collection(), 0, 0, i, 6, null);
            ooOOo0oXI.IIX0(array.getArray$collection(), getArray$collection(), 0, 0, i, 6, null);
            if (get_size$collection() == 0) {
                set_size$collection(i);
                return;
            }
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        if (get_size$collection() != 0) {
            setHashes$collection(ContainerHelpersKt.EMPTY_INTS);
            setArray$collection(ContainerHelpersKt.EMPTY_OBJECTS);
            set_size$collection(0);
        }
        if (get_size$collection() == 0) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(@OOXIXo Collection<? extends Object> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        Iterator<? extends Object> it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
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
                ooOOo0oXI.oOo(hashes$collection, getHashes$collection(), 0, 0, get_size$collection(), 6, null);
                ooOOo0oXI.IIX0(array$collection, getArray$collection(), 0, 0, get_size$collection(), 6, null);
            }
        }
        if (get_size$collection() == i2) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof Set) && size() == ((Set) obj).size()) {
            try {
                int i = get_size$collection();
                for (int i2 = 0; i2 < i; i2++) {
                    if (((Set) obj).contains(valueAt(i2))) {
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

    @Override // java.util.Collection, java.util.Set
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

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        if (get_size$collection() <= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    @OOXIXo
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            removeAt(indexOf);
            return true;
        }
        return false;
    }

    public final boolean removeAll(@OOXIXo ArraySet<? extends E> array) {
        IIX0o.x0xO0oo(array, "array");
        int i = array.get_size$collection();
        int i2 = get_size$collection();
        for (int i3 = 0; i3 < i; i3++) {
            remove(array.valueAt(i3));
        }
        return i2 != get_size$collection();
    }

    public final E removeAt(int i) {
        int i2 = get_size$collection();
        E e = (E) getArray$collection()[i];
        if (i2 <= 1) {
            clear();
        } else {
            int i3 = i2 - 1;
            int i4 = 8;
            if (getHashes$collection().length > 8 && get_size$collection() < getHashes$collection().length / 3) {
                if (get_size$collection() > 8) {
                    i4 = get_size$collection() + (get_size$collection() >> 1);
                }
                int[] hashes$collection = getHashes$collection();
                Object[] array$collection = getArray$collection();
                ArraySetKt.allocArrays(this, i4);
                if (i > 0) {
                    ooOOo0oXI.oOo(hashes$collection, getHashes$collection(), 0, 0, i, 6, null);
                    ooOOo0oXI.IIX0(array$collection, getArray$collection(), 0, 0, i, 6, null);
                }
                if (i < i3) {
                    int i5 = i + 1;
                    ooOOo0oXI.IIxOXoOo0(hashes$collection, getHashes$collection(), i, i5, i2);
                    ooOOo0oXI.ooOx(array$collection, getArray$collection(), i, i5, i2);
                }
            } else {
                if (i < i3) {
                    int i6 = i + 1;
                    ooOOo0oXI.IIxOXoOo0(getHashes$collection(), getHashes$collection(), i, i6, i2);
                    ooOOo0oXI.ooOx(getArray$collection(), getArray$collection(), i, i6, i2);
                }
                getArray$collection()[i3] = null;
            }
            if (i2 == get_size$collection()) {
                set_size$collection(i3);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        return e;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(@OOXIXo Collection<? extends Object> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        boolean z = false;
        for (int i = get_size$collection() - 1; -1 < i; i--) {
            if (!CollectionsKt___CollectionsKt.X00xOoXI(elements, getArray$collection()[i])) {
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

    @Override // java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Collection, java.util.Set
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
            E valueAt = valueAt(i2);
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
        return (E) getArray$collection()[i];
    }

    @xoIox
    public ArraySet(int i) {
        this.hashes = ContainerHelpersKt.EMPTY_INTS;
        this.array = ContainerHelpersKt.EMPTY_OBJECTS;
        if (i > 0) {
            ArraySetKt.allocArrays(this, i);
        }
    }

    @Override // java.util.Collection, java.util.Set
    @OOXIXo
    public final <T> T[] toArray(@OOXIXo T[] array) {
        IIX0o.x0xO0oo(array, "array");
        T[] result = (T[]) ArraySetJvmUtil.resizeForToArray(array, this._size);
        ooOOo0oXI.ooOx(this.array, result, 0, 0, this._size);
        IIX0o.oO(result, "result");
        return result;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(@OOXIXo Collection<? extends Object> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        Iterator<? extends Object> it = elements.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    public /* synthetic */ ArraySet(int i, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public ArraySet(@oOoXoXO ArraySet<? extends E> arraySet) {
        this(0);
        if (arraySet != null) {
            addAll((ArraySet) arraySet);
        }
    }

    public ArraySet(@oOoXoXO Collection<? extends E> collection) {
        this(0);
        if (collection != null) {
            addAll(collection);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(@OOXIXo Collection<? extends E> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        ensureCapacity(get_size$collection() + elements.size());
        Iterator<? extends E> it = elements.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= add(it.next());
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
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
