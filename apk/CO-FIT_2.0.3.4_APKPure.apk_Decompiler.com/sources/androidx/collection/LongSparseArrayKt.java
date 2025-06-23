package androidx.collection;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import Oox.x0xO0oo;
import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.collections.Xx000oIo;
import kotlin.collections.ooOOo0oXI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nLongSparseArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LongSparseArray.kt\nandroidx/collection/LongSparseArrayKt\n*L\n1#1,606:1\n256#1,6:607\n256#1,6:613\n328#1,18:619\n328#1,18:637\n328#1,18:655\n328#1,18:673\n328#1,18:691\n328#1,18:709\n328#1,18:727\n328#1,18:745\n*S KotlinDebug\n*F\n+ 1 LongSparseArray.kt\nandroidx/collection/LongSparseArrayKt\n*L\n243#1:607,6\n248#1:613,6\n360#1:619,18\n410#1:637,18\n425#1:655,18\n437#1:673,18\n451#1:691,18\n459#1:709,18\n467#1:727,18\n505#1:745,18\n*E\n"})
public final class LongSparseArrayKt {
    /* access modifiers changed from: private */
    @OOXIXo
    public static final Object DELETED = new Object();

    public static final <E> void commonAppend(@OOXIXo LongSparseArray<E> longSparseArray, long j, E e) {
        IIX0o.x0xO0oo(longSparseArray, "<this>");
        int i = longSparseArray.size;
        if (i == 0 || j > longSparseArray.keys[i - 1]) {
            if (longSparseArray.garbage) {
                long[] jArr = longSparseArray.keys;
                if (i >= jArr.length) {
                    Object[] objArr = longSparseArray.values;
                    int i2 = 0;
                    for (int i3 = 0; i3 < i; i3++) {
                        Object obj = objArr[i3];
                        if (obj != DELETED) {
                            if (i3 != i2) {
                                jArr[i2] = jArr[i3];
                                objArr[i2] = obj;
                                objArr[i3] = null;
                            }
                            i2++;
                        }
                    }
                    longSparseArray.garbage = false;
                    longSparseArray.size = i2;
                }
            }
            int i4 = longSparseArray.size;
            if (i4 >= longSparseArray.keys.length) {
                int idealLongArraySize = ContainerHelpersKt.idealLongArraySize(i4 + 1);
                long[] copyOf = Arrays.copyOf(longSparseArray.keys, idealLongArraySize);
                IIX0o.oO(copyOf, "copyOf(this, newSize)");
                longSparseArray.keys = copyOf;
                Object[] copyOf2 = Arrays.copyOf(longSparseArray.values, idealLongArraySize);
                IIX0o.oO(copyOf2, "copyOf(this, newSize)");
                longSparseArray.values = copyOf2;
            }
            longSparseArray.keys[i4] = j;
            longSparseArray.values[i4] = e;
            longSparseArray.size = i4 + 1;
            return;
        }
        longSparseArray.put(j, e);
    }

    public static final <E> void commonClear(@OOXIXo LongSparseArray<E> longSparseArray) {
        IIX0o.x0xO0oo(longSparseArray, "<this>");
        int i = longSparseArray.size;
        Object[] objArr = longSparseArray.values;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        longSparseArray.size = 0;
        longSparseArray.garbage = false;
    }

    public static final <E> boolean commonContainsKey(@OOXIXo LongSparseArray<E> longSparseArray, long j) {
        IIX0o.x0xO0oo(longSparseArray, "<this>");
        if (longSparseArray.indexOfKey(j) >= 0) {
            return true;
        }
        return false;
    }

    public static final <E> boolean commonContainsValue(@OOXIXo LongSparseArray<E> longSparseArray, E e) {
        IIX0o.x0xO0oo(longSparseArray, "<this>");
        if (longSparseArray.indexOfValue(e) >= 0) {
            return true;
        }
        return false;
    }

    public static final <E> void commonGc(@OOXIXo LongSparseArray<E> longSparseArray) {
        IIX0o.x0xO0oo(longSparseArray, "<this>");
        int i = longSparseArray.size;
        long[] jArr = longSparseArray.keys;
        Object[] objArr = longSparseArray.values;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != DELETED) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        longSparseArray.garbage = false;
        longSparseArray.size = i2;
    }

    @oOoXoXO
    public static final <E> E commonGet(@OOXIXo LongSparseArray<E> longSparseArray, long j) {
        IIX0o.x0xO0oo(longSparseArray, "<this>");
        int binarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j);
        if (binarySearch < 0 || longSparseArray.values[binarySearch] == DELETED) {
            return null;
        }
        return longSparseArray.values[binarySearch];
    }

    public static final <T extends E, E> T commonGetInternal(@OOXIXo LongSparseArray<E> longSparseArray, long j, T t) {
        IIX0o.x0xO0oo(longSparseArray, "<this>");
        int binarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j);
        if (binarySearch < 0 || longSparseArray.values[binarySearch] == DELETED) {
            return t;
        }
        return longSparseArray.values[binarySearch];
    }

    public static final <E> int commonIndexOfKey(@OOXIXo LongSparseArray<E> longSparseArray, long j) {
        IIX0o.x0xO0oo(longSparseArray, "<this>");
        if (longSparseArray.garbage) {
            int i = longSparseArray.size;
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                Object obj = objArr[i3];
                if (obj != DELETED) {
                    if (i3 != i2) {
                        jArr[i2] = jArr[i3];
                        objArr[i2] = obj;
                        objArr[i3] = null;
                    }
                    i2++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i2;
        }
        return ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j);
    }

    public static final <E> int commonIndexOfValue(@OOXIXo LongSparseArray<E> longSparseArray, E e) {
        IIX0o.x0xO0oo(longSparseArray, "<this>");
        if (longSparseArray.garbage) {
            int i = longSparseArray.size;
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                Object obj = objArr[i3];
                if (obj != DELETED) {
                    if (i3 != i2) {
                        jArr[i2] = jArr[i3];
                        objArr[i2] = obj;
                        objArr[i3] = null;
                    }
                    i2++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i2;
        }
        int i4 = longSparseArray.size;
        for (int i5 = 0; i5 < i4; i5++) {
            if (longSparseArray.values[i5] == e) {
                return i5;
            }
        }
        return -1;
    }

    public static final <E> boolean commonIsEmpty(@OOXIXo LongSparseArray<E> longSparseArray) {
        IIX0o.x0xO0oo(longSparseArray, "<this>");
        if (longSparseArray.size() == 0) {
            return true;
        }
        return false;
    }

    public static final <E> long commonKeyAt(@OOXIXo LongSparseArray<E> longSparseArray, int i) {
        int i2;
        IIX0o.x0xO0oo(longSparseArray, "<this>");
        if (i < 0 || i >= (i2 = longSparseArray.size)) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i).toString());
        }
        if (longSparseArray.garbage) {
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                Object obj = objArr[i4];
                if (obj != DELETED) {
                    if (i4 != i3) {
                        jArr[i3] = jArr[i4];
                        objArr[i3] = obj;
                        objArr[i4] = null;
                    }
                    i3++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i3;
        }
        return longSparseArray.keys[i];
    }

    public static final <E> void commonPut(@OOXIXo LongSparseArray<E> longSparseArray, long j, E e) {
        IIX0o.x0xO0oo(longSparseArray, "<this>");
        int binarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j);
        if (binarySearch >= 0) {
            longSparseArray.values[binarySearch] = e;
            return;
        }
        int i = ~binarySearch;
        if (i >= longSparseArray.size || longSparseArray.values[i] != DELETED) {
            if (longSparseArray.garbage) {
                int i2 = longSparseArray.size;
                long[] jArr = longSparseArray.keys;
                if (i2 >= jArr.length) {
                    Object[] objArr = longSparseArray.values;
                    int i3 = 0;
                    for (int i4 = 0; i4 < i2; i4++) {
                        Object obj = objArr[i4];
                        if (obj != DELETED) {
                            if (i4 != i3) {
                                jArr[i3] = jArr[i4];
                                objArr[i3] = obj;
                                objArr[i4] = null;
                            }
                            i3++;
                        }
                    }
                    longSparseArray.garbage = false;
                    longSparseArray.size = i3;
                    i = ~ContainerHelpersKt.binarySearch(longSparseArray.keys, i3, j);
                }
            }
            int i5 = longSparseArray.size;
            if (i5 >= longSparseArray.keys.length) {
                int idealLongArraySize = ContainerHelpersKt.idealLongArraySize(i5 + 1);
                long[] copyOf = Arrays.copyOf(longSparseArray.keys, idealLongArraySize);
                IIX0o.oO(copyOf, "copyOf(this, newSize)");
                longSparseArray.keys = copyOf;
                Object[] copyOf2 = Arrays.copyOf(longSparseArray.values, idealLongArraySize);
                IIX0o.oO(copyOf2, "copyOf(this, newSize)");
                longSparseArray.values = copyOf2;
            }
            int i6 = longSparseArray.size;
            if (i6 - i != 0) {
                long[] jArr2 = longSparseArray.keys;
                int i7 = i + 1;
                ooOOo0oXI.I0(jArr2, jArr2, i7, i, i6);
                Object[] objArr2 = longSparseArray.values;
                ooOOo0oXI.ooOx(objArr2, objArr2, i7, i, longSparseArray.size);
            }
            longSparseArray.keys[i] = j;
            longSparseArray.values[i] = e;
            longSparseArray.size++;
            return;
        }
        longSparseArray.keys[i] = j;
        longSparseArray.values[i] = e;
    }

    public static final <E> void commonPutAll(@OOXIXo LongSparseArray<E> longSparseArray, @OOXIXo LongSparseArray<? extends E> longSparseArray2) {
        IIX0o.x0xO0oo(longSparseArray, "<this>");
        IIX0o.x0xO0oo(longSparseArray2, "other");
        int size = longSparseArray2.size();
        for (int i = 0; i < size; i++) {
            longSparseArray.put(longSparseArray2.keyAt(i), longSparseArray2.valueAt(i));
        }
    }

    @oOoXoXO
    public static final <E> E commonPutIfAbsent(@OOXIXo LongSparseArray<E> longSparseArray, long j, E e) {
        IIX0o.x0xO0oo(longSparseArray, "<this>");
        E e2 = longSparseArray.get(j);
        if (e2 == null) {
            longSparseArray.put(j, e);
        }
        return e2;
    }

    public static final <E> void commonRemove(@OOXIXo LongSparseArray<E> longSparseArray, long j) {
        IIX0o.x0xO0oo(longSparseArray, "<this>");
        int binarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j);
        if (binarySearch >= 0 && longSparseArray.values[binarySearch] != DELETED) {
            longSparseArray.values[binarySearch] = DELETED;
            longSparseArray.garbage = true;
        }
    }

    public static final <E> void commonRemoveAt(@OOXIXo LongSparseArray<E> longSparseArray, int i) {
        IIX0o.x0xO0oo(longSparseArray, "<this>");
        if (longSparseArray.values[i] != DELETED) {
            longSparseArray.values[i] = DELETED;
            longSparseArray.garbage = true;
        }
    }

    @oOoXoXO
    public static final <E> E commonReplace(@OOXIXo LongSparseArray<E> longSparseArray, long j, E e) {
        IIX0o.x0xO0oo(longSparseArray, "<this>");
        int indexOfKey = longSparseArray.indexOfKey(j);
        if (indexOfKey < 0) {
            return null;
        }
        E[] eArr = longSparseArray.values;
        E e2 = eArr[indexOfKey];
        eArr[indexOfKey] = e;
        return e2;
    }

    public static final <E> void commonSetValueAt(@OOXIXo LongSparseArray<E> longSparseArray, int i, E e) {
        int i2;
        IIX0o.x0xO0oo(longSparseArray, "<this>");
        if (i < 0 || i >= (i2 = longSparseArray.size)) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i).toString());
        }
        if (longSparseArray.garbage) {
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                Object obj = objArr[i4];
                if (obj != DELETED) {
                    if (i4 != i3) {
                        jArr[i3] = jArr[i4];
                        objArr[i3] = obj;
                        objArr[i4] = null;
                    }
                    i3++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i3;
        }
        longSparseArray.values[i] = e;
    }

    public static final <E> int commonSize(@OOXIXo LongSparseArray<E> longSparseArray) {
        IIX0o.x0xO0oo(longSparseArray, "<this>");
        if (longSparseArray.garbage) {
            int i = longSparseArray.size;
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                Object obj = objArr[i3];
                if (obj != DELETED) {
                    if (i3 != i2) {
                        jArr[i2] = jArr[i3];
                        objArr[i2] = obj;
                        objArr[i3] = null;
                    }
                    i2++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i2;
        }
        return longSparseArray.size;
    }

    @OOXIXo
    public static final <E> String commonToString(@OOXIXo LongSparseArray<E> longSparseArray) {
        IIX0o.x0xO0oo(longSparseArray, "<this>");
        if (longSparseArray.size() <= 0) {
            return "{}";
        }
        E sb = new StringBuilder(longSparseArray.size * 28);
        sb.append('{');
        int i = longSparseArray.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(longSparseArray.keyAt(i2));
            sb.append('=');
            E valueAt = longSparseArray.valueAt(i2);
            if (valueAt != sb) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public static final <E> E commonValueAt(@OOXIXo LongSparseArray<E> longSparseArray, int i) {
        int i2;
        IIX0o.x0xO0oo(longSparseArray, "<this>");
        if (i < 0 || i >= (i2 = longSparseArray.size)) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i).toString());
        }
        if (longSparseArray.garbage) {
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                Object obj = objArr[i4];
                if (obj != DELETED) {
                    if (i4 != i3) {
                        jArr[i3] = jArr[i4];
                        objArr[i3] = obj;
                        objArr[i4] = null;
                    }
                    i3++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i3;
        }
        return longSparseArray.values[i];
    }

    public static final <T> boolean contains(@OOXIXo LongSparseArray<T> longSparseArray, long j) {
        IIX0o.x0xO0oo(longSparseArray, "<this>");
        return longSparseArray.containsKey(j);
    }

    public static final <T> void forEach(@OOXIXo LongSparseArray<T> longSparseArray, @OOXIXo x0xO0oo<? super Long, ? super T, oXIO0o0XI> x0xo0oo) {
        IIX0o.x0xO0oo(longSparseArray, "<this>");
        IIX0o.x0xO0oo(x0xo0oo, "action");
        int size = longSparseArray.size();
        for (int i = 0; i < size; i++) {
            x0xo0oo.invoke(Long.valueOf(longSparseArray.keyAt(i)), longSparseArray.valueAt(i));
        }
    }

    public static final <T> T getOrDefault(@OOXIXo LongSparseArray<T> longSparseArray, long j, T t) {
        IIX0o.x0xO0oo(longSparseArray, "<this>");
        return longSparseArray.get(j, t);
    }

    public static final <T> T getOrElse(@OOXIXo LongSparseArray<T> longSparseArray, long j, @OOXIXo oIX0oI<? extends T> oix0oi) {
        IIX0o.x0xO0oo(longSparseArray, "<this>");
        IIX0o.x0xO0oo(oix0oi, "defaultValue");
        T t = longSparseArray.get(j);
        if (t == null) {
            return oix0oi.invoke();
        }
        return t;
    }

    public static final <T> int getSize(@OOXIXo LongSparseArray<T> longSparseArray) {
        IIX0o.x0xO0oo(longSparseArray, "<this>");
        return longSparseArray.size();
    }

    public static /* synthetic */ void getSize$annotations(LongSparseArray longSparseArray) {
    }

    public static final <T> boolean isNotEmpty(@OOXIXo LongSparseArray<T> longSparseArray) {
        IIX0o.x0xO0oo(longSparseArray, "<this>");
        return !longSparseArray.isEmpty();
    }

    @OOXIXo
    public static final <T> Xx000oIo keyIterator(@OOXIXo LongSparseArray<T> longSparseArray) {
        IIX0o.x0xO0oo(longSparseArray, "<this>");
        return new LongSparseArrayKt$keyIterator$1(longSparseArray);
    }

    @OOXIXo
    public static final <T> LongSparseArray<T> plus(@OOXIXo LongSparseArray<T> longSparseArray, @OOXIXo LongSparseArray<T> longSparseArray2) {
        IIX0o.x0xO0oo(longSparseArray, "<this>");
        IIX0o.x0xO0oo(longSparseArray2, "other");
        LongSparseArray<T> longSparseArray3 = new LongSparseArray<>(longSparseArray.size() + longSparseArray2.size());
        longSparseArray3.putAll(longSparseArray);
        longSparseArray3.putAll(longSparseArray2);
        return longSparseArray3;
    }

    public static final <T> void set(@OOXIXo LongSparseArray<T> longSparseArray, long j, T t) {
        IIX0o.x0xO0oo(longSparseArray, "<this>");
        longSparseArray.put(j, t);
    }

    @OOXIXo
    public static final <T> Iterator<T> valueIterator(@OOXIXo LongSparseArray<T> longSparseArray) {
        IIX0o.x0xO0oo(longSparseArray, "<this>");
        return new LongSparseArrayKt$valueIterator$1(longSparseArray);
    }

    public static final <E> E commonGet(@OOXIXo LongSparseArray<E> longSparseArray, long j, E e) {
        IIX0o.x0xO0oo(longSparseArray, "<this>");
        int binarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j);
        return (binarySearch < 0 || longSparseArray.values[binarySearch] == DELETED) ? e : longSparseArray.values[binarySearch];
    }

    public static final <E> boolean commonReplace(@OOXIXo LongSparseArray<E> longSparseArray, long j, E e, E e2) {
        IIX0o.x0xO0oo(longSparseArray, "<this>");
        int indexOfKey = longSparseArray.indexOfKey(j);
        if (indexOfKey < 0 || !IIX0o.Oxx0IOOO(longSparseArray.values[indexOfKey], e)) {
            return false;
        }
        longSparseArray.values[indexOfKey] = e2;
        return true;
    }

    public static final <E> boolean commonRemove(@OOXIXo LongSparseArray<E> longSparseArray, long j, E e) {
        IIX0o.x0xO0oo(longSparseArray, "<this>");
        int indexOfKey = longSparseArray.indexOfKey(j);
        if (indexOfKey < 0 || !IIX0o.Oxx0IOOO(e, longSparseArray.valueAt(indexOfKey))) {
            return false;
        }
        longSparseArray.removeAt(indexOfKey);
        return true;
    }
}
