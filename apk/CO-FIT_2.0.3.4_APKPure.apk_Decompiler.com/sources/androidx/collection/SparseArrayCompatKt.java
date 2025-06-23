package androidx.collection;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import kotlin.collections.ooOOo0oXI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nSparseArrayCompat.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseArrayCompat.kt\nandroidx/collection/SparseArrayCompatKt\n*L\n1#1,535:1\n244#1,6:536\n244#1,6:542\n353#1,40:548\n353#1,40:588\n459#1,9:628\n*S KotlinDebug\n*F\n+ 1 SparseArrayCompat.kt\nandroidx/collection/SparseArrayCompatKt\n*L\n255#1:536,6\n260#1:542,6\n397#1:548,40\n405#1:588,40\n477#1:628,9\n*E\n"})
public final class SparseArrayCompatKt {
    /* access modifiers changed from: private */
    @OOXIXo
    public static final Object DELETED = new Object();

    public static final <E> void commonAppend(@OOXIXo SparseArrayCompat<E> sparseArrayCompat, int i, E e) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        int i2 = sparseArrayCompat.size;
        if (i2 == 0 || i > sparseArrayCompat.keys[i2 - 1]) {
            if (sparseArrayCompat.garbage && i2 >= sparseArrayCompat.keys.length) {
                gc(sparseArrayCompat);
            }
            int i3 = sparseArrayCompat.size;
            if (i3 >= sparseArrayCompat.keys.length) {
                int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i3 + 1);
                int[] copyOf = Arrays.copyOf(sparseArrayCompat.keys, idealIntArraySize);
                IIX0o.oO(copyOf, "copyOf(this, newSize)");
                sparseArrayCompat.keys = copyOf;
                Object[] copyOf2 = Arrays.copyOf(sparseArrayCompat.values, idealIntArraySize);
                IIX0o.oO(copyOf2, "copyOf(this, newSize)");
                sparseArrayCompat.values = copyOf2;
            }
            sparseArrayCompat.keys[i3] = i;
            sparseArrayCompat.values[i3] = e;
            sparseArrayCompat.size = i3 + 1;
            return;
        }
        sparseArrayCompat.put(i, e);
    }

    public static final <E> void commonClear(@OOXIXo SparseArrayCompat<E> sparseArrayCompat) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        int i = sparseArrayCompat.size;
        Object[] objArr = sparseArrayCompat.values;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        sparseArrayCompat.size = 0;
        sparseArrayCompat.garbage = false;
    }

    public static final <E> boolean commonContainsKey(@OOXIXo SparseArrayCompat<E> sparseArrayCompat, int i) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.indexOfKey(i) >= 0) {
            return true;
        }
        return false;
    }

    public static final <E> boolean commonContainsValue(@OOXIXo SparseArrayCompat<E> sparseArrayCompat, E e) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        int i = sparseArrayCompat.size;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                i2 = -1;
                break;
            } else if (sparseArrayCompat.values[i2] == e) {
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

    @oOoXoXO
    public static final <E> E commonGet(@OOXIXo SparseArrayCompat<E> sparseArrayCompat, int i) {
        E e;
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        int binarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i);
        if (binarySearch < 0 || (e = sparseArrayCompat.values[binarySearch]) == DELETED) {
            return null;
        }
        return e;
    }

    public static final <E> int commonIndexOfKey(@OOXIXo SparseArrayCompat<E> sparseArrayCompat, int i) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        return ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i);
    }

    public static final <E> int commonIndexOfValue(@OOXIXo SparseArrayCompat<E> sparseArrayCompat, E e) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        int i = sparseArrayCompat.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (sparseArrayCompat.values[i2] == e) {
                return i2;
            }
        }
        return -1;
    }

    public static final <E> boolean commonIsEmpty(@OOXIXo SparseArrayCompat<E> sparseArrayCompat) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.size() == 0) {
            return true;
        }
        return false;
    }

    public static final <E> int commonKeyAt(@OOXIXo SparseArrayCompat<E> sparseArrayCompat, int i) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        return sparseArrayCompat.keys[i];
    }

    public static final <E> void commonPut(@OOXIXo SparseArrayCompat<E> sparseArrayCompat, int i, E e) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        int binarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i);
        if (binarySearch >= 0) {
            sparseArrayCompat.values[binarySearch] = e;
            return;
        }
        int i2 = ~binarySearch;
        if (i2 >= sparseArrayCompat.size || sparseArrayCompat.values[i2] != DELETED) {
            if (sparseArrayCompat.garbage && sparseArrayCompat.size >= sparseArrayCompat.keys.length) {
                gc(sparseArrayCompat);
                i2 = ~ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i);
            }
            int i3 = sparseArrayCompat.size;
            if (i3 >= sparseArrayCompat.keys.length) {
                int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i3 + 1);
                int[] copyOf = Arrays.copyOf(sparseArrayCompat.keys, idealIntArraySize);
                IIX0o.oO(copyOf, "copyOf(this, newSize)");
                sparseArrayCompat.keys = copyOf;
                Object[] copyOf2 = Arrays.copyOf(sparseArrayCompat.values, idealIntArraySize);
                IIX0o.oO(copyOf2, "copyOf(this, newSize)");
                sparseArrayCompat.values = copyOf2;
            }
            int i4 = sparseArrayCompat.size;
            if (i4 - i2 != 0) {
                int[] iArr = sparseArrayCompat.keys;
                int i5 = i2 + 1;
                ooOOo0oXI.IIxOXoOo0(iArr, iArr, i5, i2, i4);
                Object[] objArr = sparseArrayCompat.values;
                ooOOo0oXI.ooOx(objArr, objArr, i5, i2, sparseArrayCompat.size);
            }
            sparseArrayCompat.keys[i2] = i;
            sparseArrayCompat.values[i2] = e;
            sparseArrayCompat.size++;
            return;
        }
        sparseArrayCompat.keys[i2] = i;
        sparseArrayCompat.values[i2] = e;
    }

    public static final <E> void commonPutAll(@OOXIXo SparseArrayCompat<E> sparseArrayCompat, @OOXIXo SparseArrayCompat<? extends E> sparseArrayCompat2) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        IIX0o.x0xO0oo(sparseArrayCompat2, "other");
        int size = sparseArrayCompat2.size();
        for (int i = 0; i < size; i++) {
            int keyAt = sparseArrayCompat2.keyAt(i);
            Object valueAt = sparseArrayCompat2.valueAt(i);
            int binarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, keyAt);
            if (binarySearch >= 0) {
                sparseArrayCompat.values[binarySearch] = valueAt;
            } else {
                int i2 = ~binarySearch;
                if (i2 >= sparseArrayCompat.size || sparseArrayCompat.values[i2] != DELETED) {
                    if (sparseArrayCompat.garbage && sparseArrayCompat.size >= sparseArrayCompat.keys.length) {
                        gc(sparseArrayCompat);
                        i2 = ~ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, keyAt);
                    }
                    int i3 = sparseArrayCompat.size;
                    if (i3 >= sparseArrayCompat.keys.length) {
                        int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i3 + 1);
                        int[] copyOf = Arrays.copyOf(sparseArrayCompat.keys, idealIntArraySize);
                        IIX0o.oO(copyOf, "copyOf(this, newSize)");
                        sparseArrayCompat.keys = copyOf;
                        Object[] copyOf2 = Arrays.copyOf(sparseArrayCompat.values, idealIntArraySize);
                        IIX0o.oO(copyOf2, "copyOf(this, newSize)");
                        sparseArrayCompat.values = copyOf2;
                    }
                    int i4 = sparseArrayCompat.size;
                    if (i4 - i2 != 0) {
                        int[] iArr = sparseArrayCompat.keys;
                        int i5 = i2 + 1;
                        ooOOo0oXI.IIxOXoOo0(iArr, iArr, i5, i2, i4);
                        Object[] objArr = sparseArrayCompat.values;
                        ooOOo0oXI.ooOx(objArr, objArr, i5, i2, sparseArrayCompat.size);
                    }
                    sparseArrayCompat.keys[i2] = keyAt;
                    sparseArrayCompat.values[i2] = valueAt;
                    sparseArrayCompat.size++;
                } else {
                    sparseArrayCompat.keys[i2] = keyAt;
                    sparseArrayCompat.values[i2] = valueAt;
                }
            }
        }
    }

    @oOoXoXO
    public static final <E> E commonPutIfAbsent(@OOXIXo SparseArrayCompat<E> sparseArrayCompat, int i, E e) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        E commonGet = commonGet(sparseArrayCompat, i);
        if (commonGet == null) {
            int binarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i);
            if (binarySearch >= 0) {
                sparseArrayCompat.values[binarySearch] = e;
            } else {
                int i2 = ~binarySearch;
                if (i2 >= sparseArrayCompat.size || sparseArrayCompat.values[i2] != DELETED) {
                    if (sparseArrayCompat.garbage && sparseArrayCompat.size >= sparseArrayCompat.keys.length) {
                        gc(sparseArrayCompat);
                        i2 = ~ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i);
                    }
                    int i3 = sparseArrayCompat.size;
                    if (i3 >= sparseArrayCompat.keys.length) {
                        int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i3 + 1);
                        int[] copyOf = Arrays.copyOf(sparseArrayCompat.keys, idealIntArraySize);
                        IIX0o.oO(copyOf, "copyOf(this, newSize)");
                        sparseArrayCompat.keys = copyOf;
                        Object[] copyOf2 = Arrays.copyOf(sparseArrayCompat.values, idealIntArraySize);
                        IIX0o.oO(copyOf2, "copyOf(this, newSize)");
                        sparseArrayCompat.values = copyOf2;
                    }
                    int i4 = sparseArrayCompat.size;
                    if (i4 - i2 != 0) {
                        int[] iArr = sparseArrayCompat.keys;
                        int i5 = i2 + 1;
                        ooOOo0oXI.IIxOXoOo0(iArr, iArr, i5, i2, i4);
                        Object[] objArr = sparseArrayCompat.values;
                        ooOOo0oXI.ooOx(objArr, objArr, i5, i2, sparseArrayCompat.size);
                    }
                    sparseArrayCompat.keys[i2] = i;
                    sparseArrayCompat.values[i2] = e;
                    sparseArrayCompat.size++;
                } else {
                    sparseArrayCompat.keys[i2] = i;
                    sparseArrayCompat.values[i2] = e;
                }
            }
        }
        return commonGet;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
        r0 = r3.values;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> void commonRemove(@OXOo.OOXIXo androidx.collection.SparseArrayCompat<E> r3, int r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r0)
            int[] r0 = r3.keys
            int r1 = r3.size
            int r4 = androidx.collection.internal.ContainerHelpersKt.binarySearch((int[]) r0, (int) r1, (int) r4)
            if (r4 < 0) goto L_0x001c
            java.lang.Object[] r0 = r3.values
            r1 = r0[r4]
            java.lang.Object r2 = DELETED
            if (r1 == r2) goto L_0x001c
            r0[r4] = r2
            r4 = 1
            r3.garbage = r4
        L_0x001c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.SparseArrayCompatKt.commonRemove(androidx.collection.SparseArrayCompat, int):void");
    }

    public static final <E> void commonRemoveAt(@OOXIXo SparseArrayCompat<E> sparseArrayCompat, int i) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.values[i] != DELETED) {
            sparseArrayCompat.values[i] = DELETED;
            sparseArrayCompat.garbage = true;
        }
    }

    public static final <E> void commonRemoveAtRange(@OOXIXo SparseArrayCompat<E> sparseArrayCompat, int i, int i2) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        int min = Math.min(i2, i + i2);
        while (i < min) {
            sparseArrayCompat.removeAt(i);
            i++;
        }
    }

    @oOoXoXO
    public static final <E> E commonReplace(@OOXIXo SparseArrayCompat<E> sparseArrayCompat, int i, E e) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        int indexOfKey = sparseArrayCompat.indexOfKey(i);
        if (indexOfKey < 0) {
            return null;
        }
        E[] eArr = sparseArrayCompat.values;
        E e2 = eArr[indexOfKey];
        eArr[indexOfKey] = e;
        return e2;
    }

    public static final <E> void commonSetValueAt(@OOXIXo SparseArrayCompat<E> sparseArrayCompat, int i, E e) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        sparseArrayCompat.values[i] = e;
    }

    public static final <E> int commonSize(@OOXIXo SparseArrayCompat<E> sparseArrayCompat) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        return sparseArrayCompat.size;
    }

    @OOXIXo
    public static final <E> String commonToString(@OOXIXo SparseArrayCompat<E> sparseArrayCompat) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(sparseArrayCompat.size * 28);
        sb.append('{');
        int i = sparseArrayCompat.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(sparseArrayCompat.keyAt(i2));
            sb.append('=');
            E valueAt = sparseArrayCompat.valueAt(i2);
            if (valueAt != sparseArrayCompat) {
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

    public static final <E> E commonValueAt(@OOXIXo SparseArrayCompat<E> sparseArrayCompat, int i) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        return sparseArrayCompat.values[i];
    }

    /* access modifiers changed from: private */
    public static final <E> void gc(SparseArrayCompat<E> sparseArrayCompat) {
        int i = sparseArrayCompat.size;
        int[] iArr = sparseArrayCompat.keys;
        Object[] objArr = sparseArrayCompat.values;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != DELETED) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        sparseArrayCompat.garbage = false;
        sparseArrayCompat.size = i2;
    }

    private static final <E, T extends E> T internalGet(SparseArrayCompat<E> sparseArrayCompat, int i, T t) {
        T t2;
        int binarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i);
        if (binarySearch < 0 || (t2 = sparseArrayCompat.values[binarySearch]) == DELETED) {
            return t;
        }
        return t2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
        r2 = r2.values[r3];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E> E commonGet(@OXOo.OOXIXo androidx.collection.SparseArrayCompat<E> r2, int r3, E r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r0)
            int[] r0 = r2.keys
            int r1 = r2.size
            int r3 = androidx.collection.internal.ContainerHelpersKt.binarySearch((int[]) r0, (int) r1, (int) r3)
            if (r3 < 0) goto L_0x0019
            java.lang.Object[] r2 = r2.values
            r2 = r2[r3]
            java.lang.Object r3 = DELETED
            if (r2 != r3) goto L_0x0018
            goto L_0x0019
        L_0x0018:
            r4 = r2
        L_0x0019:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.SparseArrayCompatKt.commonGet(androidx.collection.SparseArrayCompat, int, java.lang.Object):java.lang.Object");
    }

    public static final <E> boolean commonReplace(@OOXIXo SparseArrayCompat<E> sparseArrayCompat, int i, E e, E e2) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        int indexOfKey = sparseArrayCompat.indexOfKey(i);
        if (indexOfKey < 0 || !IIX0o.Oxx0IOOO(sparseArrayCompat.values[indexOfKey], e)) {
            return false;
        }
        sparseArrayCompat.values[indexOfKey] = e2;
        return true;
    }

    public static final <E> boolean commonRemove(@OOXIXo SparseArrayCompat<E> sparseArrayCompat, int i, @oOoXoXO Object obj) {
        IIX0o.x0xO0oo(sparseArrayCompat, "<this>");
        int indexOfKey = sparseArrayCompat.indexOfKey(i);
        if (indexOfKey < 0 || !IIX0o.Oxx0IOOO(obj, sparseArrayCompat.valueAt(indexOfKey))) {
            return false;
        }
        sparseArrayCompat.removeAt(indexOfKey);
        return true;
    }
}
