package androidx.collection;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import XO0OX.xxIXOIIO;
import androidx.collection.internal.ContainerHelpersKt;
import com.iflytek.sparkchain.plugins.map.tools.MapPlugin;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.collections.ooOOo0oXI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nSimpleArrayMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SimpleArrayMap.kt\nandroidx/collection/SimpleArrayMap\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,769:1\n297#1,5:770\n297#1,5:775\n1#2:780\n*S KotlinDebug\n*F\n+ 1 SimpleArrayMap.kt\nandroidx/collection/SimpleArrayMap\n*L\n276#1:770,5\n291#1:775,5\n*E\n"})
public class SimpleArrayMap<K, V> {
    @OOXIXo
    private Object[] array;
    @OOXIXo
    private int[] hashes;
    private int size;

    @xoIox
    public SimpleArrayMap() {
        this(0, 1, (IIXOooo) null);
    }

    private final <T extends V> T getOrDefaultInternal(Object obj, T t) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return this.array[(indexOfKey << 1) + 1];
        }
        return t;
    }

    private final int indexOf(K k, int i) {
        int i2 = this.size;
        if (i2 == 0) {
            return -1;
        }
        int binarySearch = ContainerHelpersKt.binarySearch(this.hashes, i2, i);
        if (binarySearch < 0 || IIX0o.Oxx0IOOO(k, this.array[binarySearch << 1])) {
            return binarySearch;
        }
        int i3 = binarySearch + 1;
        while (i3 < i2 && this.hashes[i3] == i) {
            if (IIX0o.Oxx0IOOO(k, this.array[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        int i4 = binarySearch - 1;
        while (i4 >= 0 && this.hashes[i4] == i) {
            if (IIX0o.Oxx0IOOO(k, this.array[i4 << 1])) {
                return i4;
            }
            i4--;
        }
        return ~i3;
    }

    private final int indexOfNull() {
        int i = this.size;
        if (i == 0) {
            return -1;
        }
        int binarySearch = ContainerHelpersKt.binarySearch(this.hashes, i, 0);
        if (binarySearch < 0 || this.array[binarySearch << 1] == null) {
            return binarySearch;
        }
        int i2 = binarySearch + 1;
        while (i2 < i && this.hashes[i2] == 0) {
            if (this.array[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        int i3 = binarySearch - 1;
        while (i3 >= 0 && this.hashes[i3] == 0) {
            if (this.array[i3 << 1] == null) {
                return i3;
            }
            i3--;
        }
        return ~i2;
    }

    @xxIXOIIO(name = "__restricted$indexOfValue")
    public final int __restricted$indexOfValue(V v) {
        int i = this.size * 2;
        Object[] objArr = this.array;
        if (v == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (IIX0o.Oxx0IOOO(v, objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public void clear() {
        if (this.size > 0) {
            this.hashes = ContainerHelpersKt.EMPTY_INTS;
            this.array = ContainerHelpersKt.EMPTY_OBJECTS;
            this.size = 0;
        }
        if (this.size > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(K k) {
        if (indexOfKey(k) >= 0) {
            return true;
        }
        return false;
    }

    public boolean containsValue(V v) {
        if (__restricted$indexOfValue(v) >= 0) {
            return true;
        }
        return false;
    }

    public void ensureCapacity(int i) {
        int i2 = this.size;
        int[] iArr = this.hashes;
        if (iArr.length < i) {
            int[] copyOf = Arrays.copyOf(iArr, i);
            IIX0o.oO(copyOf, "copyOf(this, newSize)");
            this.hashes = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.array, i * 2);
            IIX0o.oO(copyOf2, "copyOf(this, newSize)");
            this.array = copyOf2;
        }
        if (this.size != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof SimpleArrayMap) {
                if (size() != ((SimpleArrayMap) obj).size()) {
                    return false;
                }
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
                int i = this.size;
                for (int i2 = 0; i2 < i; i2++) {
                    Object keyAt = keyAt(i2);
                    Object valueAt = valueAt(i2);
                    Object obj2 = simpleArrayMap.get(keyAt);
                    if (valueAt == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(keyAt)) {
                            return false;
                        }
                    } else if (!IIX0o.Oxx0IOOO(valueAt, obj2)) {
                        return false;
                    }
                }
                return true;
            } else if (!(obj instanceof Map) || size() != ((Map) obj).size()) {
                return false;
            } else {
                int i3 = this.size;
                for (int i4 = 0; i4 < i3; i4++) {
                    Object keyAt2 = keyAt(i4);
                    Object valueAt2 = valueAt(i4);
                    Object obj3 = ((Map) obj).get(keyAt2);
                    if (valueAt2 == null) {
                        if (obj3 != null || !((Map) obj).containsKey(keyAt2)) {
                            return false;
                        }
                    } else if (!IIX0o.Oxx0IOOO(valueAt2, obj3)) {
                        return false;
                    }
                }
                return true;
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    @oOoXoXO
    public V get(K k) {
        int indexOfKey = indexOfKey(k);
        if (indexOfKey >= 0) {
            return this.array[(indexOfKey << 1) + 1];
        }
        return null;
    }

    public V getOrDefault(@oOoXoXO Object obj, V v) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return this.array[(indexOfKey << 1) + 1];
        }
        return v;
    }

    public int hashCode() {
        int i;
        int[] iArr = this.hashes;
        Object[] objArr = this.array;
        int i2 = this.size;
        int i3 = 1;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            Object obj = objArr[i3];
            int i6 = iArr[i4];
            if (obj != null) {
                i = obj.hashCode();
            } else {
                i = 0;
            }
            i5 += i ^ i6;
            i4++;
            i3 += 2;
        }
        return i5;
    }

    public int indexOfKey(K k) {
        if (k == null) {
            return indexOfNull();
        }
        return indexOf(k, k.hashCode());
    }

    public boolean isEmpty() {
        if (this.size <= 0) {
            return true;
        }
        return false;
    }

    public K keyAt(int i) {
        if (i >= 0 && i < this.size) {
            return this.array[i << 1];
        }
        throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i).toString());
    }

    @oOoXoXO
    public V put(K k, V v) {
        int i;
        int i2;
        int i3 = this.size;
        if (k != null) {
            i = k.hashCode();
        } else {
            i = 0;
        }
        if (k != null) {
            i2 = indexOf(k, i);
        } else {
            i2 = indexOfNull();
        }
        if (i2 >= 0) {
            int i4 = (i2 << 1) + 1;
            V[] vArr = this.array;
            V v2 = vArr[i4];
            vArr[i4] = v;
            return v2;
        }
        int i5 = ~i2;
        int[] iArr = this.hashes;
        if (i3 >= iArr.length) {
            int i6 = 8;
            if (i3 >= 8) {
                i6 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i6 = 4;
            }
            int[] copyOf = Arrays.copyOf(iArr, i6);
            IIX0o.oO(copyOf, "copyOf(this, newSize)");
            this.hashes = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.array, i6 << 1);
            IIX0o.oO(copyOf2, "copyOf(this, newSize)");
            this.array = copyOf2;
            if (i3 != this.size) {
                throw new ConcurrentModificationException();
            }
        }
        if (i5 < i3) {
            int[] iArr2 = this.hashes;
            int i7 = i5 + 1;
            ooOOo0oXI.IIxOXoOo0(iArr2, iArr2, i7, i5, i3);
            Object[] objArr = this.array;
            ooOOo0oXI.ooOx(objArr, objArr, i7 << 1, i5 << 1, this.size << 1);
        }
        int i8 = this.size;
        if (i3 == i8) {
            int[] iArr3 = this.hashes;
            if (i5 < iArr3.length) {
                iArr3[i5] = i;
                Object[] objArr2 = this.array;
                int i9 = i5 << 1;
                objArr2[i9] = k;
                objArr2[i9 + 1] = v;
                this.size = i8 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public void putAll(@OOXIXo SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        IIX0o.x0xO0oo(simpleArrayMap, MapPlugin.MapSearchTool);
        int i = simpleArrayMap.size;
        ensureCapacity(this.size + i);
        if (this.size != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                put(simpleArrayMap.keyAt(i2), simpleArrayMap.valueAt(i2));
            }
        } else if (i > 0) {
            ooOOo0oXI.IIxOXoOo0(simpleArrayMap.hashes, this.hashes, 0, 0, i);
            ooOOo0oXI.ooOx(simpleArrayMap.array, this.array, 0, 0, i << 1);
            this.size = i;
        }
    }

    @oOoXoXO
    public V putIfAbsent(K k, V v) {
        V v2 = get(k);
        if (v2 == null) {
            return put(k, v);
        }
        return v2;
    }

    @oOoXoXO
    public V remove(K k) {
        int indexOfKey = indexOfKey(k);
        if (indexOfKey >= 0) {
            return removeAt(indexOfKey);
        }
        return null;
    }

    public V removeAt(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this.size)) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i).toString());
        }
        V[] vArr = this.array;
        int i3 = i << 1;
        V v = vArr[i3 + 1];
        if (i2 <= 1) {
            clear();
        } else {
            int i4 = i2 - 1;
            int[] iArr = this.hashes;
            int i5 = 8;
            if (iArr.length <= 8 || i2 >= iArr.length / 3) {
                if (i < i4) {
                    int i6 = i + 1;
                    ooOOo0oXI.IIxOXoOo0(iArr, iArr, i, i6, i2);
                    Object[] objArr = this.array;
                    ooOOo0oXI.ooOx(objArr, objArr, i3, i6 << 1, i2 << 1);
                }
                Object[] objArr2 = this.array;
                int i7 = i4 << 1;
                objArr2[i7] = null;
                objArr2[i7 + 1] = null;
            } else {
                if (i2 > 8) {
                    i5 = i2 + (i2 >> 1);
                }
                int[] copyOf = Arrays.copyOf(iArr, i5);
                IIX0o.oO(copyOf, "copyOf(this, newSize)");
                this.hashes = copyOf;
                Object[] copyOf2 = Arrays.copyOf(this.array, i5 << 1);
                IIX0o.oO(copyOf2, "copyOf(this, newSize)");
                this.array = copyOf2;
                if (i2 == this.size) {
                    if (i > 0) {
                        ooOOo0oXI.IIxOXoOo0(iArr, this.hashes, 0, 0, i);
                        ooOOo0oXI.ooOx(vArr, this.array, 0, 0, i3);
                    }
                    if (i < i4) {
                        int i8 = i + 1;
                        ooOOo0oXI.IIxOXoOo0(iArr, this.hashes, i, i8, i2);
                        ooOOo0oXI.ooOx(vArr, this.array, i3, i8 << 1, i2 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            }
            if (i2 == this.size) {
                this.size = i4;
            } else {
                throw new ConcurrentModificationException();
            }
        }
        return v;
    }

    @oOoXoXO
    public V replace(K k, V v) {
        int indexOfKey = indexOfKey(k);
        if (indexOfKey >= 0) {
            return setValueAt(indexOfKey, v);
        }
        return null;
    }

    public V setValueAt(int i, V v) {
        if (i < 0 || i >= this.size) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i).toString());
        }
        int i2 = (i << 1) + 1;
        V[] vArr = this.array;
        V v2 = vArr[i2];
        vArr[i2] = v;
        return v2;
    }

    public int size() {
        return this.size;
    }

    @OOXIXo
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.size * 28);
        sb.append('{');
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object keyAt = keyAt(i2);
            if (keyAt != sb) {
                sb.append(keyAt);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object valueAt = valueAt(i2);
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

    public V valueAt(int i) {
        if (i >= 0 && i < this.size) {
            return this.array[(i << 1) + 1];
        }
        throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i).toString());
    }

    @xoIox
    public SimpleArrayMap(int i) {
        int[] iArr;
        Object[] objArr;
        if (i == 0) {
            iArr = ContainerHelpersKt.EMPTY_INTS;
        } else {
            iArr = new int[i];
        }
        this.hashes = iArr;
        if (i == 0) {
            objArr = ContainerHelpersKt.EMPTY_OBJECTS;
        } else {
            objArr = new Object[(i << 1)];
        }
        this.array = objArr;
    }

    public boolean remove(K k, V v) {
        int indexOfKey = indexOfKey(k);
        if (indexOfKey < 0 || !IIX0o.Oxx0IOOO(v, valueAt(indexOfKey))) {
            return false;
        }
        removeAt(indexOfKey);
        return true;
    }

    public boolean replace(K k, V v, V v2) {
        int indexOfKey = indexOfKey(k);
        if (indexOfKey < 0 || !IIX0o.Oxx0IOOO(v, valueAt(indexOfKey))) {
            return false;
        }
        setValueAt(indexOfKey, v2);
        return true;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SimpleArrayMap(int i, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public SimpleArrayMap(@oOoXoXO SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this(0, 1, (IIXOooo) null);
        if (simpleArrayMap != null) {
            putAll(simpleArrayMap);
        }
    }
}
