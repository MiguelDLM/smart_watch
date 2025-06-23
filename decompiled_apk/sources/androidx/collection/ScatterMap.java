package androidx.collection;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.x0xO0oo;
import XO0OX.XO;
import XO0OX.xoIox;
import androidx.collection.internal.ContainerHelpersKt;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.o0;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nScatterMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScatterMap.kt\nandroidx/collection/ScatterMap\n+ 2 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n*L\n1#1,1850:1\n633#1:1851\n634#1:1855\n636#1,2:1857\n638#1,4:1860\n642#1:1867\n643#1:1871\n644#1:1873\n645#1,4:1876\n651#1:1881\n652#1,8:1883\n633#1:1891\n634#1:1895\n636#1,2:1897\n638#1,4:1900\n642#1:1907\n643#1:1911\n644#1:1913\n645#1,4:1916\n651#1:1921\n652#1,8:1923\n363#1,6:1933\n373#1,3:1940\n376#1,9:1944\n363#1,6:1953\n373#1,3:1960\n376#1,9:1964\n363#1,6:1973\n373#1,3:1980\n376#1,9:1984\n391#1,4:1993\n363#1,6:1997\n373#1,3:2004\n376#1,2:2008\n396#1,2:2010\n379#1,6:2012\n398#1:2018\n391#1,4:2019\n363#1,6:2023\n373#1,3:2030\n376#1,2:2034\n396#1,2:2036\n379#1,6:2038\n398#1:2044\n391#1,4:2045\n363#1,6:2049\n373#1,3:2056\n376#1,2:2060\n396#1,2:2062\n379#1,6:2064\n398#1:2070\n633#1:2071\n634#1:2075\n636#1,2:2077\n638#1,4:2080\n642#1:2087\n643#1:2091\n644#1:2093\n645#1,4:2096\n651#1:2101\n652#1,8:2103\n633#1:2111\n634#1:2115\n636#1,2:2117\n638#1,4:2120\n642#1:2127\n643#1:2131\n644#1:2133\n645#1,4:2136\n651#1:2141\n652#1,8:2143\n418#1,3:2151\n363#1,6:2154\n373#1,3:2161\n376#1,2:2165\n422#1,2:2167\n379#1,6:2169\n424#1:2175\n391#1,4:2176\n363#1,6:2180\n373#1,3:2187\n376#1,2:2191\n396#1,2:2193\n379#1,6:2195\n398#1:2201\n391#1,4:2202\n363#1,6:2206\n373#1,3:2213\n376#1,2:2217\n396#1,2:2219\n379#1,6:2221\n398#1:2227\n391#1,4:2228\n363#1,6:2232\n373#1,3:2239\n376#1,2:2243\n396#1,2:2245\n379#1,6:2247\n398#1:2253\n391#1,4:2254\n363#1,6:2258\n373#1,3:2265\n376#1,2:2269\n396#1,2:2271\n379#1,6:2273\n398#1:2279\n1605#2,3:1852\n1619#2:1856\n1615#2:1859\n1795#2,3:1864\n1809#2,3:1868\n1733#2:1872\n1721#2:1874\n1715#2:1875\n1728#2:1880\n1818#2:1882\n1605#2,3:1892\n1619#2:1896\n1615#2:1899\n1795#2,3:1904\n1809#2,3:1908\n1733#2:1912\n1721#2:1914\n1715#2:1915\n1728#2:1920\n1818#2:1922\n1826#2:1931\n1688#2:1932\n1826#2:1939\n1688#2:1943\n1826#2:1959\n1688#2:1963\n1826#2:1979\n1688#2:1983\n1826#2:2003\n1688#2:2007\n1826#2:2029\n1688#2:2033\n1826#2:2055\n1688#2:2059\n1605#2,3:2072\n1619#2:2076\n1615#2:2079\n1795#2,3:2084\n1809#2,3:2088\n1733#2:2092\n1721#2:2094\n1715#2:2095\n1728#2:2100\n1818#2:2102\n1605#2,3:2112\n1619#2:2116\n1615#2:2119\n1795#2,3:2124\n1809#2,3:2128\n1733#2:2132\n1721#2:2134\n1715#2:2135\n1728#2:2140\n1818#2:2142\n1826#2:2160\n1688#2:2164\n1826#2:2186\n1688#2:2190\n1826#2:2212\n1688#2:2216\n1826#2:2238\n1688#2:2242\n1826#2:2264\n1688#2:2268\n1661#2:2280\n1605#2,3:2281\n1619#2:2284\n1615#2:2285\n1795#2,3:2286\n1809#2,3:2289\n1733#2:2292\n1721#2:2293\n1715#2:2294\n1728#2:2295\n1818#2:2296\n*S KotlinDebug\n*F\n+ 1 ScatterMap.kt\nandroidx/collection/ScatterMap\n*L\n330#1:1851\n330#1:1855\n330#1:1857,2\n330#1:1860,4\n330#1:1867\n330#1:1871\n330#1:1873\n330#1:1876,4\n330#1:1881\n330#1:1883,8\n340#1:1891\n340#1:1895\n340#1:1897,2\n340#1:1900,4\n340#1:1907\n340#1:1911\n340#1:1913\n340#1:1916,4\n340#1:1921\n340#1:1923,8\n394#1:1933,6\n394#1:1940,3\n394#1:1944,9\n407#1:1953,6\n407#1:1960,3\n407#1:1964,9\n420#1:1973,6\n420#1:1980,3\n420#1:1984,9\n430#1:1993,4\n430#1:1997,6\n430#1:2004,3\n430#1:2008,2\n430#1:2010,2\n430#1:2012,6\n430#1:2018\n440#1:2019,4\n440#1:2023,6\n440#1:2030,3\n440#1:2034,2\n440#1:2036,2\n440#1:2038,6\n440#1:2044\n456#1:2045,4\n456#1:2049,6\n456#1:2056,3\n456#1:2060,2\n456#1:2062,2\n456#1:2064,6\n456#1:2070\n466#1:2071\n466#1:2075\n466#1:2077,2\n466#1:2080,4\n466#1:2087\n466#1:2091\n466#1:2093\n466#1:2096,4\n466#1:2101\n466#1:2103,8\n472#1:2111\n472#1:2115\n472#1:2117,2\n472#1:2120,4\n472#1:2127\n472#1:2131\n472#1:2133\n472#1:2136,4\n472#1:2141\n472#1:2143,8\n479#1:2151,3\n479#1:2154,6\n479#1:2161,3\n479#1:2165,2\n479#1:2167,2\n479#1:2169,6\n479#1:2175\n506#1:2176,4\n506#1:2180,6\n506#1:2187,3\n506#1:2191,2\n506#1:2193,2\n506#1:2195,6\n506#1:2201\n533#1:2202,4\n533#1:2206,6\n533#1:2213,3\n533#1:2217,2\n533#1:2219,2\n533#1:2221,6\n533#1:2227\n562#1:2228,4\n562#1:2232,6\n562#1:2239,3\n562#1:2243,2\n562#1:2245,2\n562#1:2247,6\n562#1:2253\n588#1:2254,4\n588#1:2258,6\n588#1:2265,3\n588#1:2269,2\n588#1:2271,2\n588#1:2273,6\n588#1:2279\n330#1:1852,3\n330#1:1856\n330#1:1859\n330#1:1864,3\n330#1:1868,3\n330#1:1872\n330#1:1874\n330#1:1875\n330#1:1880\n330#1:1882\n340#1:1892,3\n340#1:1896\n340#1:1899\n340#1:1904,3\n340#1:1908,3\n340#1:1912\n340#1:1914\n340#1:1915\n340#1:1920\n340#1:1922\n368#1:1931\n375#1:1932\n394#1:1939\n394#1:1943\n407#1:1959\n407#1:1963\n420#1:1979\n420#1:1983\n430#1:2003\n430#1:2007\n440#1:2029\n440#1:2033\n456#1:2055\n456#1:2059\n466#1:2072,3\n466#1:2076\n466#1:2079\n466#1:2084,3\n466#1:2088,3\n466#1:2092\n466#1:2094\n466#1:2095\n466#1:2100\n466#1:2102\n472#1:2112,3\n472#1:2116\n472#1:2119\n472#1:2124,3\n472#1:2128,3\n472#1:2132\n472#1:2134\n472#1:2135\n472#1:2140\n472#1:2142\n479#1:2160\n479#1:2164\n506#1:2186\n506#1:2190\n533#1:2212\n533#1:2216\n562#1:2238\n562#1:2242\n588#1:2264\n588#1:2268\n605#1:2280\n633#1:2281,3\n634#1:2284\n637#1:2285\n641#1:2286,3\n642#1:2289,3\n643#1:2292\n644#1:2293\n644#1:2294\n648#1:2295\n651#1:2296\n*E\n"})
/* loaded from: classes.dex */
public abstract class ScatterMap<K, V> {

    @XO
    public int _capacity;

    @XO
    public int _size;

    @OOXIXo
    @XO
    public Object[] keys;

    @OOXIXo
    @XO
    public long[] metadata;

    @OOXIXo
    @XO
    public Object[] values;

    /* loaded from: classes.dex */
    public class MapWrapper implements Map<K, V>, OI0IXox.oIX0oI {
        public MapWrapper() {
        }

        @Override // java.util.Map
        public void clear() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public V compute(K k, BiFunction<? super K, ? super V, ? extends V> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public V computeIfAbsent(K k, Function<? super K, ? extends V> function) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public V computeIfPresent(K k, BiFunction<? super K, ? super V, ? extends V> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            return ScatterMap.this.containsKey(obj);
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            return ScatterMap.this.containsValue(obj);
        }

        @Override // java.util.Map
        public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
            return getEntries();
        }

        @Override // java.util.Map
        @oOoXoXO
        public V get(Object obj) {
            return ScatterMap.this.get(obj);
        }

        @OOXIXo
        public Set<Map.Entry<K, V>> getEntries() {
            return new ScatterMap$MapWrapper$entries$1(ScatterMap.this);
        }

        @OOXIXo
        public Set<K> getKeys() {
            return new ScatterMap$MapWrapper$keys$1(ScatterMap.this);
        }

        public int getSize() {
            return ScatterMap.this._size;
        }

        @OOXIXo
        public Collection<V> getValues() {
            return new ScatterMap$MapWrapper$values$1(ScatterMap.this);
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return ScatterMap.this.isEmpty();
        }

        @Override // java.util.Map
        public final /* bridge */ Set<K> keySet() {
            return getKeys();
        }

        @Override // java.util.Map
        public V merge(K k, V v, BiFunction<? super V, ? super V, ? extends V> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public V put(K k, V v) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public V putIfAbsent(K k, V v) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public V remove(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public V replace(K k, V v) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.Map
        public final /* bridge */ Collection<V> values() {
            return getValues();
        }

        @Override // java.util.Map
        public boolean remove(Object obj, Object obj2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public boolean replace(K k, V v, V v2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public /* synthetic */ ScatterMap(IIXOooo iIXOooo) {
        this();
    }

    @o0
    public static /* synthetic */ void getKeys$annotations() {
    }

    @o0
    public static /* synthetic */ void getMetadata$annotations() {
    }

    @o0
    public static /* synthetic */ void getValues$annotations() {
    }

    public static /* synthetic */ String joinToString$default(ScatterMap scatterMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, x0xO0oo x0xo0oo, int i2, Object obj) {
        CharSequence charSequence5;
        int i3;
        if (obj == null) {
            if ((i2 & 1) != 0) {
                charSequence = ", ";
            }
            CharSequence charSequence6 = "";
            if ((i2 & 2) != 0) {
                charSequence5 = "";
            } else {
                charSequence5 = charSequence2;
            }
            if ((i2 & 4) == 0) {
                charSequence6 = charSequence3;
            }
            if ((i2 & 8) != 0) {
                i3 = -1;
            } else {
                i3 = i;
            }
            if ((i2 & 16) != 0) {
                charSequence4 = "...";
            }
            CharSequence charSequence7 = charSequence4;
            if ((i2 & 32) != 0) {
                x0xo0oo = null;
            }
            return scatterMap.joinToString(charSequence, charSequence5, charSequence6, i3, charSequence7, x0xo0oo);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final boolean all(@OOXIXo x0xO0oo<? super K, ? super V, Boolean> predicate) {
        IIX0o.x0xO0oo(predicate, "predicate");
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            if (!predicate.invoke(objArr[i4], objArr2[i4]).booleanValue()) {
                                return false;
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return true;
                    }
                }
                if (i != length) {
                    i++;
                } else {
                    return true;
                }
            }
        } else {
            return true;
        }
    }

    public final boolean any() {
        return this._size != 0;
    }

    @OOXIXo
    public final String asDebugString$collection() {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        sb.append("metadata=[");
        int capacity = getCapacity();
        for (int i = 0; i < capacity; i++) {
            long j = (this.metadata[i >> 3] >> ((i & 7) << 3)) & 255;
            if (j == 128) {
                sb.append("Empty");
            } else if (j == 254) {
                sb.append("Deleted");
            } else {
                sb.append(j);
            }
            sb.append(", ");
        }
        sb.append("], ");
        sb.append("keys=[");
        int length = this.keys.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(this.keys[i2]);
            sb.append(", ");
        }
        sb.append("], ");
        sb.append("values=[");
        int length2 = this.values.length;
        for (int i3 = 0; i3 < length2; i3++) {
            sb.append(this.values[i3]);
            sb.append(", ");
        }
        sb.append("]");
        sb.append('}');
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @OOXIXo
    public final Map<K, V> asMap() {
        return new MapWrapper();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0070, code lost:
    
        if (((r7 & ((~r7) << 6)) & (-9187201950435737472L)) == 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0072, code lost:
    
        r11 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean contains(K r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = 0
            if (r1 == 0) goto Lc
            int r3 = r18.hashCode()
            goto Ld
        Lc:
            r3 = 0
        Ld:
            r4 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r3 = r3 * r4
            int r4 = r3 << 16
            r3 = r3 ^ r4
            r4 = r3 & 127(0x7f, float:1.78E-43)
            int r5 = r0._capacity
            int r3 = r3 >>> 7
            r3 = r3 & r5
            r6 = 0
        L1d:
            long[] r7 = r0.metadata
            int r8 = r3 >> 3
            r9 = r3 & 7
            int r9 = r9 << 3
            r10 = r7[r8]
            long r10 = r10 >>> r9
            r12 = 1
            int r8 = r8 + r12
            r13 = r7[r8]
            int r7 = 64 - r9
            long r7 = r13 << r7
            long r13 = (long) r9
            long r13 = -r13
            r9 = 63
            long r13 = r13 >> r9
            long r7 = r7 & r13
            long r7 = r7 | r10
            long r9 = (long) r4
            r13 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r9 = r9 * r13
            long r9 = r9 ^ r7
            long r13 = r9 - r13
            long r9 = ~r9
            long r9 = r9 & r13
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r13
        L4a:
            r15 = 0
            int r11 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r11 == 0) goto L69
            int r11 = java.lang.Long.numberOfTrailingZeros(r9)
            int r11 = r11 >> 3
            int r11 = r11 + r3
            r11 = r11 & r5
            java.lang.Object[] r15 = r0.keys
            r15 = r15[r11]
            boolean r15 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r15, r1)
            if (r15 == 0) goto L63
            goto L73
        L63:
            r15 = 1
            long r15 = r9 - r15
            long r9 = r9 & r15
            goto L4a
        L69:
            long r9 = ~r7
            r11 = 6
            long r9 = r9 << r11
            long r7 = r7 & r9
            long r7 = r7 & r13
            int r9 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r9 == 0) goto L77
            r11 = -1
        L73:
            if (r11 < 0) goto L76
            r2 = 1
        L76:
            return r2
        L77:
            int r6 = r6 + 8
            int r3 = r3 + r6
            r3 = r3 & r5
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ScatterMap.contains(java.lang.Object):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0070, code lost:
    
        if (((r7 & ((~r7) << 6)) & (-9187201950435737472L)) == 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0072, code lost:
    
        r11 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean containsKey(K r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = 0
            if (r1 == 0) goto Lc
            int r3 = r18.hashCode()
            goto Ld
        Lc:
            r3 = 0
        Ld:
            r4 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r3 = r3 * r4
            int r4 = r3 << 16
            r3 = r3 ^ r4
            r4 = r3 & 127(0x7f, float:1.78E-43)
            int r5 = r0._capacity
            int r3 = r3 >>> 7
            r3 = r3 & r5
            r6 = 0
        L1d:
            long[] r7 = r0.metadata
            int r8 = r3 >> 3
            r9 = r3 & 7
            int r9 = r9 << 3
            r10 = r7[r8]
            long r10 = r10 >>> r9
            r12 = 1
            int r8 = r8 + r12
            r13 = r7[r8]
            int r7 = 64 - r9
            long r7 = r13 << r7
            long r13 = (long) r9
            long r13 = -r13
            r9 = 63
            long r13 = r13 >> r9
            long r7 = r7 & r13
            long r7 = r7 | r10
            long r9 = (long) r4
            r13 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r9 = r9 * r13
            long r9 = r9 ^ r7
            long r13 = r9 - r13
            long r9 = ~r9
            long r9 = r9 & r13
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r13
        L4a:
            r15 = 0
            int r11 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r11 == 0) goto L69
            int r11 = java.lang.Long.numberOfTrailingZeros(r9)
            int r11 = r11 >> 3
            int r11 = r11 + r3
            r11 = r11 & r5
            java.lang.Object[] r15 = r0.keys
            r15 = r15[r11]
            boolean r15 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r15, r1)
            if (r15 == 0) goto L63
            goto L73
        L63:
            r15 = 1
            long r15 = r9 - r15
            long r9 = r9 & r15
            goto L4a
        L69:
            long r9 = ~r7
            r11 = 6
            long r9 = r9 << r11
            long r7 = r7 & r9
            long r7 = r7 & r13
            int r9 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r9 == 0) goto L77
            r11 = -1
        L73:
            if (r11 < 0) goto L76
            r2 = 1
        L76:
            return r2
        L77:
            int r6 = r6 + 8
            int r3 = r3 + r6
            r3 = r3 & r5
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ScatterMap.containsKey(java.lang.Object):boolean");
    }

    public final boolean containsValue(V v) {
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128 && IIX0o.Oxx0IOOO(v, objArr[(i << 3) + i3])) {
                            return true;
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return false;
    }

    public final int count() {
        return getSize();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean equals(@oOoXoXO Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ScatterMap)) {
            return false;
        }
        ScatterMap scatterMap = (ScatterMap) obj;
        if (scatterMap.getSize() != getSize()) {
            return false;
        }
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            loop0: while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            Object obj2 = objArr[i4];
                            Object obj3 = objArr2[i4];
                            if (obj3 == null) {
                                if (scatterMap.get(obj2) != null || !scatterMap.containsKey(obj2)) {
                                    break loop0;
                                }
                            } else if (!IIX0o.Oxx0IOOO(obj3, scatterMap.get(obj2))) {
                                return false;
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
            return false;
        }
        return true;
    }

    public final int findKeyIndex$collection(K k) {
        int i;
        int i2 = 0;
        if (k != null) {
            i = k.hashCode();
        } else {
            i = 0;
        }
        int i3 = i * ScatterMapKt.MurmurHashC1;
        int i4 = i3 ^ (i3 << 16);
        int i5 = i4 & 127;
        int i6 = this._capacity;
        int i7 = i4 >>> 7;
        while (true) {
            int i8 = i7 & i6;
            long[] jArr = this.metadata;
            int i9 = i8 >> 3;
            int i10 = (i8 & 7) << 3;
            long j = ((jArr[i9 + 1] << (64 - i10)) & ((-i10) >> 63)) | (jArr[i9] >>> i10);
            long j2 = (i5 * ScatterMapKt.BitmaskLsb) ^ j;
            for (long j3 = (~j2) & (j2 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j3 != 0; j3 &= j3 - 1) {
                int numberOfTrailingZeros = ((Long.numberOfTrailingZeros(j3) >> 3) + i8) & i6;
                if (IIX0o.Oxx0IOOO(this.keys[numberOfTrailingZeros], k)) {
                    return numberOfTrailingZeros;
                }
            }
            if ((j & ((~j) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i2 += 8;
            i7 = i8 + i2;
        }
    }

    public final void forEach(@OOXIXo x0xO0oo<? super K, ? super V, oXIO0o0XI> block) {
        IIX0o.x0xO0oo(block, "block");
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            block.invoke(objArr[i4], objArr2[i4]);
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i != length) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    @o0
    public final void forEachIndexed(@OOXIXo Oox.oOoXoXO<? super Integer, oXIO0o0XI> block) {
        IIX0o.x0xO0oo(block, "block");
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            block.invoke(Integer.valueOf((i << 3) + i3));
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i != length) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public final void forEachKey(@OOXIXo Oox.oOoXoXO<? super K, oXIO0o0XI> block) {
        IIX0o.x0xO0oo(block, "block");
        Object[] objArr = this.keys;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            block.invoke(objArr[(i << 3) + i3]);
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i != length) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public final void forEachValue(@OOXIXo Oox.oOoXoXO<? super V, oXIO0o0XI> block) {
        IIX0o.x0xO0oo(block, "block");
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            block.invoke(objArr[(i << 3) + i3]);
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i != length) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006b, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006d, code lost:
    
        r10 = -1;
     */
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final V get(K r14) {
        /*
            r13 = this;
            r0 = 0
            if (r14 == 0) goto L8
            int r1 = r14.hashCode()
            goto L9
        L8:
            r1 = 0
        L9:
            r2 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r1 = r1 * r2
            int r2 = r1 << 16
            r1 = r1 ^ r2
            r2 = r1 & 127(0x7f, float:1.78E-43)
            int r3 = r13._capacity
            int r1 = r1 >>> 7
        L17:
            r1 = r1 & r3
            long[] r4 = r13.metadata
            int r5 = r1 >> 3
            r6 = r1 & 7
            int r6 = r6 << 3
            r7 = r4[r5]
            long r7 = r7 >>> r6
            int r5 = r5 + 1
            r9 = r4[r5]
            int r4 = 64 - r6
            long r4 = r9 << r4
            long r9 = (long) r6
            long r9 = -r9
            r6 = 63
            long r9 = r9 >> r6
            long r4 = r4 & r9
            long r4 = r4 | r7
            long r6 = (long) r2
            r8 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r6 = r6 * r8
            long r6 = r6 ^ r4
            long r8 = r6 - r8
            long r6 = ~r6
            long r6 = r6 & r8
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
        L45:
            r10 = 0
            int r12 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r12 == 0) goto L64
            int r10 = java.lang.Long.numberOfTrailingZeros(r6)
            int r10 = r10 >> 3
            int r10 = r10 + r1
            r10 = r10 & r3
            java.lang.Object[] r11 = r13.keys
            r11 = r11[r10]
            boolean r11 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r11, r14)
            if (r11 == 0) goto L5e
            goto L6e
        L5e:
            r10 = 1
            long r10 = r6 - r10
            long r6 = r6 & r10
            goto L45
        L64:
            long r6 = ~r4
            r12 = 6
            long r6 = r6 << r12
            long r4 = r4 & r6
            long r4 = r4 & r8
            int r6 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r6 == 0) goto L77
            r10 = -1
        L6e:
            if (r10 < 0) goto L75
            java.lang.Object[] r14 = r13.values
            r14 = r14[r10]
            goto L76
        L75:
            r14 = 0
        L76:
            return r14
        L77:
            int r0 = r0 + 8
            int r1 = r1 + r0
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ScatterMap.get(java.lang.Object):java.lang.Object");
    }

    public final int getCapacity() {
        return this._capacity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006b, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006d, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final V getOrDefault(K r14, V r15) {
        /*
            r13 = this;
            r0 = 0
            if (r14 == 0) goto L8
            int r1 = r14.hashCode()
            goto L9
        L8:
            r1 = 0
        L9:
            r2 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r1 = r1 * r2
            int r2 = r1 << 16
            r1 = r1 ^ r2
            r2 = r1 & 127(0x7f, float:1.78E-43)
            int r3 = r13._capacity
            int r1 = r1 >>> 7
        L17:
            r1 = r1 & r3
            long[] r4 = r13.metadata
            int r5 = r1 >> 3
            r6 = r1 & 7
            int r6 = r6 << 3
            r7 = r4[r5]
            long r7 = r7 >>> r6
            int r5 = r5 + 1
            r9 = r4[r5]
            int r4 = 64 - r6
            long r4 = r9 << r4
            long r9 = (long) r6
            long r9 = -r9
            r6 = 63
            long r9 = r9 >> r6
            long r4 = r4 & r9
            long r4 = r4 | r7
            long r6 = (long) r2
            r8 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r6 = r6 * r8
            long r6 = r6 ^ r4
            long r8 = r6 - r8
            long r6 = ~r6
            long r6 = r6 & r8
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
        L45:
            r10 = 0
            int r12 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r12 == 0) goto L64
            int r10 = java.lang.Long.numberOfTrailingZeros(r6)
            int r10 = r10 >> 3
            int r10 = r10 + r1
            r10 = r10 & r3
            java.lang.Object[] r11 = r13.keys
            r11 = r11[r10]
            boolean r11 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r11, r14)
            if (r11 == 0) goto L5e
            goto L6e
        L5e:
            r10 = 1
            long r10 = r6 - r10
            long r6 = r6 & r10
            goto L45
        L64:
            long r6 = ~r4
            r12 = 6
            long r6 = r6 << r12
            long r4 = r4 & r6
            long r4 = r4 & r8
            int r6 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r6 == 0) goto L76
            r10 = -1
        L6e:
            if (r10 < 0) goto L75
            java.lang.Object[] r14 = r13.values
            r14 = r14[r10]
            return r14
        L75:
            return r15
        L76:
            int r0 = r0 + 8
            int r1 = r1 + r0
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ScatterMap.getOrDefault(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public final V getOrElse(K k, @OOXIXo Oox.oIX0oI<? extends V> defaultValue) {
        IIX0o.x0xO0oo(defaultValue, "defaultValue");
        V v = get(k);
        if (v == null) {
            return defaultValue.invoke();
        }
        return v;
    }

    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        int i;
        int i2;
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        int i3 = 0;
        if (length >= 0) {
            int i4 = 0;
            int i5 = 0;
            while (true) {
                long j = jArr[i4];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i4 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j) < 128) {
                            int i8 = (i4 << 3) + i7;
                            Object obj = objArr[i8];
                            Object obj2 = objArr2[i8];
                            if (obj != null) {
                                i = obj.hashCode();
                            } else {
                                i = 0;
                            }
                            if (obj2 != null) {
                                i2 = obj2.hashCode();
                            } else {
                                i2 = 0;
                            }
                            i5 += i2 ^ i;
                        }
                        j >>= 8;
                    }
                    if (i6 != 8) {
                        return i5;
                    }
                }
                if (i4 != length) {
                    i4++;
                } else {
                    i3 = i5;
                    break;
                }
            }
        }
        return i3;
    }

    public final boolean isEmpty() {
        if (this._size == 0) {
            return true;
        }
        return false;
    }

    public final boolean isNotEmpty() {
        if (this._size != 0) {
            return true;
        }
        return false;
    }

    @OOXIXo
    @xoIox
    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, null, 63, null);
    }

    public final boolean none() {
        if (this._size == 0) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            int i2 = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = (i << 3) + i4;
                            Object obj = objArr[i5];
                            Object obj2 = objArr2[i5];
                            if (obj == this) {
                                obj = "(this)";
                            }
                            sb.append(obj);
                            sb.append("=");
                            if (obj2 == this) {
                                obj2 = "(this)";
                            }
                            sb.append(obj2);
                            i2++;
                            if (i2 < this._size) {
                                sb.append(',');
                                sb.append(TokenParser.SP);
                            }
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        break;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "s.append('}').toString()");
        return sb2;
    }

    private ScatterMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        Object[] objArr = ContainerHelpersKt.EMPTY_OBJECTS;
        this.keys = objArr;
        this.values = objArr;
    }

    public final boolean any(@OOXIXo x0xO0oo<? super K, ? super V, Boolean> predicate) {
        IIX0o.x0xO0oo(predicate, "predicate");
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            if (predicate.invoke(objArr[i4], objArr2[i4]).booleanValue()) {
                                return true;
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return false;
    }

    public final int count(@OOXIXo x0xO0oo<? super K, ? super V, Boolean> predicate) {
        IIX0o.x0xO0oo(predicate, "predicate");
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        int i = 0;
        if (length >= 0) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i5 = 0; i5 < i4; i5++) {
                        if ((255 & j) < 128) {
                            int i6 = (i2 << 3) + i5;
                            if (predicate.invoke(objArr[i6], objArr2[i6]).booleanValue()) {
                                i3++;
                            }
                        }
                        j >>= 8;
                    }
                    if (i4 != 8) {
                        return i3;
                    }
                }
                if (i2 == length) {
                    i = i3;
                    break;
                }
                i2++;
            }
        }
        return i;
    }

    @OOXIXo
    @xoIox
    public final String joinToString(@OOXIXo CharSequence separator) {
        IIX0o.x0xO0oo(separator, "separator");
        return joinToString$default(this, separator, null, null, 0, null, null, 62, null);
    }

    @OOXIXo
    @xoIox
    public final String joinToString(@OOXIXo CharSequence separator, @OOXIXo CharSequence prefix) {
        IIX0o.x0xO0oo(separator, "separator");
        IIX0o.x0xO0oo(prefix, "prefix");
        return joinToString$default(this, separator, prefix, null, 0, null, null, 60, null);
    }

    @OOXIXo
    @xoIox
    public final String joinToString(@OOXIXo CharSequence separator, @OOXIXo CharSequence prefix, @OOXIXo CharSequence postfix) {
        IIX0o.x0xO0oo(separator, "separator");
        IIX0o.x0xO0oo(prefix, "prefix");
        IIX0o.x0xO0oo(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, 0, null, null, 56, null);
    }

    @OOXIXo
    @xoIox
    public final String joinToString(@OOXIXo CharSequence separator, @OOXIXo CharSequence prefix, @OOXIXo CharSequence postfix, int i) {
        IIX0o.x0xO0oo(separator, "separator");
        IIX0o.x0xO0oo(prefix, "prefix");
        IIX0o.x0xO0oo(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, i, null, null, 48, null);
    }

    @OOXIXo
    @xoIox
    public final String joinToString(@OOXIXo CharSequence separator, @OOXIXo CharSequence prefix, @OOXIXo CharSequence postfix, int i, @OOXIXo CharSequence truncated) {
        IIX0o.x0xO0oo(separator, "separator");
        IIX0o.x0xO0oo(prefix, "prefix");
        IIX0o.x0xO0oo(postfix, "postfix");
        IIX0o.x0xO0oo(truncated, "truncated");
        return joinToString$default(this, separator, prefix, postfix, i, truncated, null, 32, null);
    }

    @OOXIXo
    @xoIox
    public final String joinToString(@OOXIXo CharSequence separator, @OOXIXo CharSequence prefix, @OOXIXo CharSequence postfix, int i, @OOXIXo CharSequence truncated, @oOoXoXO x0xO0oo<? super K, ? super V, ? extends CharSequence> x0xo0oo) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        IIX0o.x0xO0oo(separator, "separator");
        IIX0o.x0xO0oo(prefix, "prefix");
        IIX0o.x0xO0oo(postfix, "postfix");
        IIX0o.x0xO0oo(truncated, "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        Object[] objArr5 = this.keys;
        Object[] objArr6 = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            int i3 = 0;
            loop0: while (true) {
                long j = jArr[i2];
                int i4 = i2;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8 - ((~(i4 - length)) >>> 31);
                    int i6 = 0;
                    while (i6 < i5) {
                        if ((j & 255) < 128) {
                            int i7 = (i4 << 3) + i6;
                            Object obj = objArr5[i7];
                            objArr3 = objArr5;
                            Object obj2 = objArr6[i7];
                            objArr4 = objArr6;
                            if (i3 == i) {
                                sb.append(truncated);
                                break loop0;
                            }
                            if (i3 != 0) {
                                sb.append(separator);
                            }
                            if (x0xo0oo == null) {
                                sb.append(obj);
                                sb.append('=');
                                sb.append(obj2);
                            } else {
                                sb.append(x0xo0oo.invoke(obj, obj2));
                            }
                            i3++;
                        } else {
                            objArr3 = objArr5;
                            objArr4 = objArr6;
                        }
                        j >>= 8;
                        i6++;
                        objArr6 = objArr4;
                        objArr5 = objArr3;
                    }
                    objArr = objArr5;
                    objArr2 = objArr6;
                    if (i5 != 8) {
                        break;
                    }
                } else {
                    objArr = objArr5;
                    objArr2 = objArr6;
                }
                if (i4 == length) {
                    break;
                }
                i2 = i4 + 1;
                objArr6 = objArr2;
                objArr5 = objArr;
            }
        }
        sb.append(postfix);
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
