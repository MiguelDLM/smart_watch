package androidx.collection;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.collection.internal.ContainerHelpersKt;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.ooOOo0oXI;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class ArraySetKt {
    public static final int ARRAY_SET_BASE_SIZE = 4;

    public static final <E> void addAllInternal(@OOXIXo ArraySet<E> arraySet, @OOXIXo ArraySet<? extends E> array) {
        IIX0o.x0xO0oo(arraySet, "<this>");
        IIX0o.x0xO0oo(array, "array");
        int i = array.get_size$collection();
        arraySet.ensureCapacity(arraySet.get_size$collection() + i);
        if (arraySet.get_size$collection() != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                arraySet.add(array.valueAt(i2));
            }
            return;
        }
        if (i > 0) {
            ooOOo0oXI.oOo(array.getHashes$collection(), arraySet.getHashes$collection(), 0, 0, i, 6, null);
            ooOOo0oXI.IIX0(array.getArray$collection(), arraySet.getArray$collection(), 0, 0, i, 6, null);
            if (arraySet.get_size$collection() == 0) {
                arraySet.set_size$collection(i);
                return;
            }
            throw new ConcurrentModificationException();
        }
    }

    public static final <E> boolean addInternal(@OOXIXo ArraySet<E> arraySet, E e) {
        int i;
        int indexOf;
        IIX0o.x0xO0oo(arraySet, "<this>");
        int i2 = arraySet.get_size$collection();
        boolean z = false;
        if (e == null) {
            indexOf = indexOfNull(arraySet);
            i = 0;
        } else {
            int hashCode = e.hashCode();
            i = hashCode;
            indexOf = indexOf(arraySet, e, hashCode);
        }
        if (indexOf >= 0) {
            return false;
        }
        int i3 = ~indexOf;
        if (i2 >= arraySet.getHashes$collection().length) {
            int i4 = 8;
            if (i2 >= 8) {
                i4 = (i2 >> 1) + i2;
            } else if (i2 < 4) {
                i4 = 4;
            }
            int[] hashes$collection = arraySet.getHashes$collection();
            Object[] array$collection = arraySet.getArray$collection();
            allocArrays(arraySet, i4);
            if (i2 == arraySet.get_size$collection()) {
                if (arraySet.getHashes$collection().length == 0) {
                    z = true;
                }
                if (!z) {
                    ooOOo0oXI.oOo(hashes$collection, arraySet.getHashes$collection(), 0, 0, hashes$collection.length, 6, null);
                    ooOOo0oXI.IIX0(array$collection, arraySet.getArray$collection(), 0, 0, array$collection.length, 6, null);
                }
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i3 < i2) {
            int i5 = i3 + 1;
            ooOOo0oXI.IIxOXoOo0(arraySet.getHashes$collection(), arraySet.getHashes$collection(), i5, i3, i2);
            ooOOo0oXI.ooOx(arraySet.getArray$collection(), arraySet.getArray$collection(), i5, i3, i2);
        }
        if (i2 == arraySet.get_size$collection() && i3 < arraySet.getHashes$collection().length) {
            arraySet.getHashes$collection()[i3] = i;
            arraySet.getArray$collection()[i3] = e;
            arraySet.set_size$collection(arraySet.get_size$collection() + 1);
            return true;
        }
        throw new ConcurrentModificationException();
    }

    public static final <E> void allocArrays(@OOXIXo ArraySet<E> arraySet, int i) {
        IIX0o.x0xO0oo(arraySet, "<this>");
        arraySet.setHashes$collection(new int[i]);
        arraySet.setArray$collection(new Object[i]);
    }

    @OOXIXo
    public static final <T> ArraySet<T> arraySetOf() {
        return new ArraySet<>(0, 1, null);
    }

    public static final <E> int binarySearchInternal(@OOXIXo ArraySet<E> arraySet, int i) {
        IIX0o.x0xO0oo(arraySet, "<this>");
        try {
            return ContainerHelpersKt.binarySearch(arraySet.getHashes$collection(), arraySet.get_size$collection(), i);
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static final <E> void clearInternal(@OOXIXo ArraySet<E> arraySet) {
        IIX0o.x0xO0oo(arraySet, "<this>");
        if (arraySet.get_size$collection() != 0) {
            arraySet.setHashes$collection(ContainerHelpersKt.EMPTY_INTS);
            arraySet.setArray$collection(ContainerHelpersKt.EMPTY_OBJECTS);
            arraySet.set_size$collection(0);
        }
        if (arraySet.get_size$collection() == 0) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    public static final <E> boolean containsAllInternal(@OOXIXo ArraySet<E> arraySet, @OOXIXo Collection<? extends E> elements) {
        IIX0o.x0xO0oo(arraySet, "<this>");
        IIX0o.x0xO0oo(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            if (!arraySet.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static final <E> boolean containsInternal(@OOXIXo ArraySet<E> arraySet, E e) {
        IIX0o.x0xO0oo(arraySet, "<this>");
        if (arraySet.indexOf(e) >= 0) {
            return true;
        }
        return false;
    }

    public static final <E> void ensureCapacityInternal(@OOXIXo ArraySet<E> arraySet, int i) {
        IIX0o.x0xO0oo(arraySet, "<this>");
        int i2 = arraySet.get_size$collection();
        if (arraySet.getHashes$collection().length < i) {
            int[] hashes$collection = arraySet.getHashes$collection();
            Object[] array$collection = arraySet.getArray$collection();
            allocArrays(arraySet, i);
            if (arraySet.get_size$collection() > 0) {
                ooOOo0oXI.oOo(hashes$collection, arraySet.getHashes$collection(), 0, 0, arraySet.get_size$collection(), 6, null);
                ooOOo0oXI.IIX0(array$collection, arraySet.getArray$collection(), 0, 0, arraySet.get_size$collection(), 6, null);
            }
        }
        if (arraySet.get_size$collection() == i2) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    public static final <E> boolean equalsInternal(@OOXIXo ArraySet<E> arraySet, @oOoXoXO Object obj) {
        IIX0o.x0xO0oo(arraySet, "<this>");
        if (arraySet == obj) {
            return true;
        }
        if (!(obj instanceof Set) || arraySet.size() != ((Set) obj).size()) {
            return false;
        }
        try {
            int i = arraySet.get_size$collection();
            for (int i2 = 0; i2 < i; i2++) {
                if (!((Set) obj).contains(arraySet.valueAt(i2))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static final <E> int hashCodeInternal(@OOXIXo ArraySet<E> arraySet) {
        IIX0o.x0xO0oo(arraySet, "<this>");
        int[] hashes$collection = arraySet.getHashes$collection();
        int i = arraySet.get_size$collection();
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += hashes$collection[i3];
        }
        return i2;
    }

    public static final <E> int indexOf(@OOXIXo ArraySet<E> arraySet, @oOoXoXO Object obj, int i) {
        IIX0o.x0xO0oo(arraySet, "<this>");
        int i2 = arraySet.get_size$collection();
        if (i2 == 0) {
            return -1;
        }
        int binarySearchInternal = binarySearchInternal(arraySet, i);
        if (binarySearchInternal < 0) {
            return binarySearchInternal;
        }
        if (IIX0o.Oxx0IOOO(obj, arraySet.getArray$collection()[binarySearchInternal])) {
            return binarySearchInternal;
        }
        int i3 = binarySearchInternal + 1;
        while (i3 < i2 && arraySet.getHashes$collection()[i3] == i) {
            if (IIX0o.Oxx0IOOO(obj, arraySet.getArray$collection()[i3])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = binarySearchInternal - 1; i4 >= 0 && arraySet.getHashes$collection()[i4] == i; i4--) {
            if (IIX0o.Oxx0IOOO(obj, arraySet.getArray$collection()[i4])) {
                return i4;
            }
        }
        return ~i3;
    }

    public static final <E> int indexOfInternal(@OOXIXo ArraySet<E> arraySet, @oOoXoXO Object obj) {
        IIX0o.x0xO0oo(arraySet, "<this>");
        if (obj == null) {
            return indexOfNull(arraySet);
        }
        return indexOf(arraySet, obj, obj.hashCode());
    }

    public static final <E> int indexOfNull(@OOXIXo ArraySet<E> arraySet) {
        IIX0o.x0xO0oo(arraySet, "<this>");
        return indexOf(arraySet, null, 0);
    }

    public static final <E> boolean isEmptyInternal(@OOXIXo ArraySet<E> arraySet) {
        IIX0o.x0xO0oo(arraySet, "<this>");
        if (arraySet.get_size$collection() <= 0) {
            return true;
        }
        return false;
    }

    public static final <E> boolean removeAllInternal(@OOXIXo ArraySet<E> arraySet, @OOXIXo ArraySet<? extends E> array) {
        IIX0o.x0xO0oo(arraySet, "<this>");
        IIX0o.x0xO0oo(array, "array");
        int i = array.get_size$collection();
        int i2 = arraySet.get_size$collection();
        for (int i3 = 0; i3 < i; i3++) {
            arraySet.remove(array.valueAt(i3));
        }
        return i2 != arraySet.get_size$collection();
    }

    public static final <E> E removeAtInternal(@OOXIXo ArraySet<E> arraySet, int i) {
        IIX0o.x0xO0oo(arraySet, "<this>");
        int i2 = arraySet.get_size$collection();
        E e = (E) arraySet.getArray$collection()[i];
        if (i2 <= 1) {
            arraySet.clear();
        } else {
            int i3 = i2 - 1;
            int i4 = 8;
            if (arraySet.getHashes$collection().length > 8 && arraySet.get_size$collection() < arraySet.getHashes$collection().length / 3) {
                if (arraySet.get_size$collection() > 8) {
                    i4 = arraySet.get_size$collection() + (arraySet.get_size$collection() >> 1);
                }
                int[] hashes$collection = arraySet.getHashes$collection();
                Object[] array$collection = arraySet.getArray$collection();
                allocArrays(arraySet, i4);
                if (i > 0) {
                    ooOOo0oXI.oOo(hashes$collection, arraySet.getHashes$collection(), 0, 0, i, 6, null);
                    ooOOo0oXI.IIX0(array$collection, arraySet.getArray$collection(), 0, 0, i, 6, null);
                }
                if (i < i3) {
                    int i5 = i + 1;
                    ooOOo0oXI.IIxOXoOo0(hashes$collection, arraySet.getHashes$collection(), i, i5, i2);
                    ooOOo0oXI.ooOx(array$collection, arraySet.getArray$collection(), i, i5, i2);
                }
            } else {
                if (i < i3) {
                    int i6 = i + 1;
                    ooOOo0oXI.IIxOXoOo0(arraySet.getHashes$collection(), arraySet.getHashes$collection(), i, i6, i2);
                    ooOOo0oXI.ooOx(arraySet.getArray$collection(), arraySet.getArray$collection(), i, i6, i2);
                }
                arraySet.getArray$collection()[i3] = null;
            }
            if (i2 == arraySet.get_size$collection()) {
                arraySet.set_size$collection(i3);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        return e;
    }

    public static final <E> boolean removeInternal(@OOXIXo ArraySet<E> arraySet, E e) {
        IIX0o.x0xO0oo(arraySet, "<this>");
        int indexOf = arraySet.indexOf(e);
        if (indexOf >= 0) {
            arraySet.removeAt(indexOf);
            return true;
        }
        return false;
    }

    public static final <E> boolean retainAllInternal(@OOXIXo ArraySet<E> arraySet, @OOXIXo Collection<? extends E> elements) {
        IIX0o.x0xO0oo(arraySet, "<this>");
        IIX0o.x0xO0oo(elements, "elements");
        boolean z = false;
        for (int i = arraySet.get_size$collection() - 1; -1 < i; i--) {
            if (!CollectionsKt___CollectionsKt.X00xOoXI(elements, arraySet.getArray$collection()[i])) {
                arraySet.removeAt(i);
                z = true;
            }
        }
        return z;
    }

    @OOXIXo
    public static final <E> String toStringInternal(@OOXIXo ArraySet<E> arraySet) {
        IIX0o.x0xO0oo(arraySet, "<this>");
        if (arraySet.isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(arraySet.get_size$collection() * 14);
        sb.append('{');
        int i = arraySet.get_size$collection();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            E valueAt = arraySet.valueAt(i2);
            if (valueAt != arraySet) {
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

    public static final <E> E valueAtInternal(@OOXIXo ArraySet<E> arraySet, int i) {
        IIX0o.x0xO0oo(arraySet, "<this>");
        return (E) arraySet.getArray$collection()[i];
    }

    @OOXIXo
    public static final <T> ArraySet<T> arraySetOf(@OOXIXo T... values) {
        IIX0o.x0xO0oo(values, "values");
        ArraySet<T> arraySet = new ArraySet<>(values.length);
        for (T t : values) {
            arraySet.add(t);
        }
        return arraySet;
    }

    public static final <E> boolean removeAllInternal(@OOXIXo ArraySet<E> arraySet, @OOXIXo Collection<? extends E> elements) {
        IIX0o.x0xO0oo(arraySet, "<this>");
        IIX0o.x0xO0oo(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= arraySet.remove(it.next());
        }
        return z;
    }

    public static final <E> boolean addAllInternal(@OOXIXo ArraySet<E> arraySet, @OOXIXo Collection<? extends E> elements) {
        IIX0o.x0xO0oo(arraySet, "<this>");
        IIX0o.x0xO0oo(elements, "elements");
        arraySet.ensureCapacity(arraySet.get_size$collection() + elements.size());
        Iterator<? extends E> it = elements.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= arraySet.add(it.next());
        }
        return z;
    }
}
