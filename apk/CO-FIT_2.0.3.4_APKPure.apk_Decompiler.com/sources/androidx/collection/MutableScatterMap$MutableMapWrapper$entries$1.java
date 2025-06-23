package androidx.collection;

import OI0IXox.II0XooXoX;
import OXOo.OOXIXo;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.OxxIIOOXO;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.XoX;

@XX({"SMAP\nScatterMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScatterMap.kt\nandroidx/collection/MutableScatterMap$MutableMapWrapper$entries$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ScatterMap.kt\nandroidx/collection/ScatterMap\n+ 4 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n*L\n1#1,1850:1\n1726#2,3:1851\n363#3,6:1854\n373#3,3:1861\n376#3,9:1865\n363#3,6:1874\n373#3,3:1881\n376#3,9:1885\n633#3:1894\n634#3:1898\n636#3,2:1900\n638#3,4:1903\n642#3:1910\n643#3:1914\n644#3:1916\n645#3,4:1919\n651#3:1924\n652#3,8:1926\n1826#4:1860\n1688#4:1864\n1826#4:1880\n1688#4:1884\n1605#4,3:1895\n1619#4:1899\n1615#4:1902\n1795#4,3:1907\n1809#4,3:1911\n1733#4:1915\n1721#4:1917\n1715#4:1918\n1728#4:1923\n1818#4:1925\n*S KotlinDebug\n*F\n+ 1 ScatterMap.kt\nandroidx/collection/MutableScatterMap$MutableMapWrapper$entries$1\n*L\n1358#1:1851,3\n1376#1:1854,6\n1376#1:1861,3\n1376#1:1865,9\n1398#1:1874,6\n1398#1:1881,3\n1398#1:1885,9\n1413#1:1894\n1413#1:1898\n1413#1:1900,2\n1413#1:1903,4\n1413#1:1910\n1413#1:1914\n1413#1:1916\n1413#1:1919,4\n1413#1:1924\n1413#1:1926,8\n1376#1:1860\n1376#1:1864\n1398#1:1880\n1398#1:1884\n1413#1:1895,3\n1413#1:1899\n1413#1:1902\n1413#1:1907,3\n1413#1:1911,3\n1413#1:1915\n1413#1:1917\n1413#1:1918\n1413#1:1923\n1413#1:1925\n*E\n"})
public final class MutableScatterMap$MutableMapWrapper$entries$1 implements Set<Map.Entry<K, V>>, II0XooXoX {
    final /* synthetic */ MutableScatterMap<K, V> this$0;

    public MutableScatterMap$MutableMapWrapper$entries$1(MutableScatterMap<K, V> mutableScatterMap) {
        this.this$0 = mutableScatterMap;
    }

    public boolean addAll(@OOXIXo Collection<? extends Map.Entry<K, V>> collection) {
        IIX0o.x0xO0oo(collection, "elements");
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.this$0.clear();
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!XoX.xI(obj)) {
            return false;
        }
        return contains((Map.Entry) obj);
    }

    public boolean containsAll(@OOXIXo Collection<? extends Object> collection) {
        IIX0o.x0xO0oo(collection, "elements");
        Iterable<Map.Entry> iterable = collection;
        MutableScatterMap<K, V> mutableScatterMap = this.this$0;
        if (((Collection) iterable).isEmpty()) {
            return true;
        }
        for (Map.Entry entry : iterable) {
            if (!IIX0o.Oxx0IOOO(mutableScatterMap.get(entry.getKey()), entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    public int getSize() {
        return this.this$0._size;
    }

    public boolean isEmpty() {
        return this.this$0.isEmpty();
    }

    @OOXIXo
    public Iterator<Map.Entry<K, V>> iterator() {
        return new MutableScatterMap$MutableMapWrapper$entries$1$iterator$1(this.this$0);
    }

    public final /* bridge */ boolean remove(Object obj) {
        if (!XoX.xI(obj)) {
            return false;
        }
        return remove((Map.Entry) obj);
    }

    public boolean removeAll(@OOXIXo Collection<? extends Object> collection) {
        boolean z;
        IIX0o.x0xO0oo(collection, "elements");
        MutableScatterMap<K, V> mutableScatterMap = this.this$0;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            boolean z2 = false;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            Iterator<? extends Object> it = collection.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                Map.Entry entry = (Map.Entry) it.next();
                                if (IIX0o.Oxx0IOOO(entry.getKey(), mutableScatterMap.keys[i4]) && IIX0o.Oxx0IOOO(entry.getValue(), mutableScatterMap.values[i4])) {
                                    mutableScatterMap.removeValueAt(i4);
                                    z2 = true;
                                    break;
                                }
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return z2;
                    }
                }
                if (i == length) {
                    z = z2;
                    break;
                }
                i++;
            }
        } else {
            z = false;
        }
        return z;
    }

    public boolean retainAll(@OOXIXo Collection<? extends Object> collection) {
        boolean z;
        IIX0o.x0xO0oo(collection, "elements");
        MutableScatterMap<K, V> mutableScatterMap = this.this$0;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            boolean z2 = false;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            Iterator<? extends Object> it = collection.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    mutableScatterMap.removeValueAt(i4);
                                    z2 = true;
                                    break;
                                }
                                Map.Entry entry = (Map.Entry) it.next();
                                if (IIX0o.Oxx0IOOO(entry.getKey(), mutableScatterMap.keys[i4]) && IIX0o.Oxx0IOOO(entry.getValue(), mutableScatterMap.values[i4])) {
                                    break;
                                }
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return z2;
                    }
                }
                if (i == length) {
                    z = z2;
                    break;
                }
                i++;
            }
        } else {
            z = false;
        }
        return z;
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public Object[] toArray() {
        return OxxIIOOXO.oIX0oI(this);
    }

    public boolean add(@OOXIXo Map.Entry<K, V> entry) {
        IIX0o.x0xO0oo(entry, "element");
        throw new UnsupportedOperationException();
    }

    public boolean contains(@OOXIXo Map.Entry<K, V> entry) {
        IIX0o.x0xO0oo(entry, "element");
        return IIX0o.Oxx0IOOO(this.this$0.get(entry.getKey()), entry.getValue());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x007b, code lost:
        if (((r9 & ((~r9) << 6)) & -9187201950435737472L) == 0) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x007d, code lost:
        r15 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean remove(@OXOo.OOXIXo java.util.Map.Entry<K, V> r20) {
        /*
            r19 = this;
            r0 = r19
            java.lang.String r1 = "element"
            r2 = r20
            kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r1)
            androidx.collection.MutableScatterMap<K, V> r1 = r0.this$0
            java.lang.Object r3 = r20.getKey()
            if (r3 == 0) goto L_0x0016
            int r5 = r3.hashCode()
            goto L_0x0017
        L_0x0016:
            r5 = 0
        L_0x0017:
            r6 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r5 = r5 * r6
            int r6 = r5 << 16
            r5 = r5 ^ r6
            r6 = r5 & 127(0x7f, float:1.78E-43)
            int r7 = r1._capacity
            int r5 = r5 >>> 7
            r5 = r5 & r7
            r8 = 0
        L_0x0027:
            long[] r9 = r1.metadata
            int r10 = r5 >> 3
            r11 = r5 & 7
            int r11 = r11 << 3
            r12 = r9[r10]
            long r12 = r12 >>> r11
            r14 = 1
            int r10 = r10 + r14
            r15 = r9[r10]
            int r9 = 64 - r11
            long r9 = r15 << r9
            long r14 = (long) r11
            long r14 = -r14
            r11 = 63
            long r14 = r14 >> r11
            long r9 = r9 & r14
            long r9 = r9 | r12
            long r11 = (long) r6
            r13 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r11 = r11 * r13
            long r11 = r11 ^ r9
            long r13 = r11 - r13
            long r11 = ~r11
            long r11 = r11 & r13
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r11 = r11 & r13
        L_0x0054:
            r17 = 0
            int r15 = (r11 > r17 ? 1 : (r11 == r17 ? 0 : -1))
            if (r15 == 0) goto L_0x0074
            int r15 = java.lang.Long.numberOfTrailingZeros(r11)
            int r15 = r15 >> 3
            int r15 = r15 + r5
            r15 = r15 & r7
            java.lang.Object[] r4 = r1.keys
            r4 = r4[r15]
            boolean r4 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r4, r3)
            if (r4 == 0) goto L_0x006d
            goto L_0x007e
        L_0x006d:
            r17 = 1
            long r17 = r11 - r17
            long r11 = r11 & r17
            goto L_0x0054
        L_0x0074:
            long r11 = ~r9
            r4 = 6
            long r11 = r11 << r4
            long r9 = r9 & r11
            long r9 = r9 & r13
            int r4 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r4 == 0) goto L_0x0099
            r15 = -1
        L_0x007e:
            if (r15 < 0) goto L_0x0097
            androidx.collection.MutableScatterMap<K, V> r1 = r0.this$0
            java.lang.Object[] r1 = r1.values
            r1 = r1[r15]
            java.lang.Object r2 = r20.getValue()
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r2)
            if (r1 == 0) goto L_0x0097
            androidx.collection.MutableScatterMap<K, V> r1 = r0.this$0
            r1.removeValueAt(r15)
            r1 = 1
            return r1
        L_0x0097:
            r4 = 0
            return r4
        L_0x0099:
            r4 = 0
            int r8 = r8 + 8
            int r5 = r5 + r8
            r5 = r5 & r7
            goto L_0x0027
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterMap$MutableMapWrapper$entries$1.remove(java.util.Map$Entry):boolean");
    }

    public <T> T[] toArray(T[] tArr) {
        IIX0o.x0xO0oo(tArr, "array");
        return OxxIIOOXO.II0xO0(this, tArr);
    }
}
