package kotlin.collections.builders;

import OI0IXox.Oxx0IOOO;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.collections.oOXoIIIo;
import kotlin.collections.ooOOo0oXI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nMapBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapBuilder.kt\nkotlin/collections/builders/MapBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,727:1\n1#2:728\n*E\n"})
/* loaded from: classes6.dex */
public final class MapBuilder<K, V> implements Map<K, V>, Serializable, Oxx0IOOO {

    @OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);

    @OOXIXo
    private static final MapBuilder Empty;
    private static final int INITIAL_CAPACITY = 8;
    private static final int INITIAL_MAX_PROBE_DISTANCE = 2;
    private static final int MAGIC = -1640531527;
    private static final int TOMBSTONE = -1;

    @oOoXoXO
    private kotlin.collections.builders.I0Io<K, V> entriesView;

    @OOXIXo
    private int[] hashArray;
    private int hashShift;
    private boolean isReadOnly;

    @OOXIXo
    private K[] keysArray;

    @oOoXoXO
    private kotlin.collections.builders.oxoX<K> keysView;
    private int length;
    private int maxProbeDistance;
    private int modCount;

    @OOXIXo
    private int[] presenceArray;
    private int size;

    @oOoXoXO
    private V[] valuesArray;

    @oOoXoXO
    private kotlin.collections.builders.X0o0xo<V> valuesView;

    /* loaded from: classes6.dex */
    public static final class I0Io<K, V> implements Map.Entry<K, V>, Oxx0IOOO.oIX0oI {

        /* renamed from: Oo, reason: collision with root package name */
        public final int f29144Oo;

        /* renamed from: XO, reason: collision with root package name */
        @OOXIXo
        public final MapBuilder<K, V> f29145XO;

        public I0Io(@OOXIXo MapBuilder<K, V> map, int i) {
            IIX0o.x0xO0oo(map, "map");
            this.f29145XO = map;
            this.f29144Oo = i;
        }

        @Override // java.util.Map.Entry
        public boolean equals(@oOoXoXO Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (IIX0o.Oxx0IOOO(entry.getKey(), getKey()) && IIX0o.Oxx0IOOO(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) ((MapBuilder) this.f29145XO).keysArray[this.f29144Oo];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object[] objArr = ((MapBuilder) this.f29145XO).valuesArray;
            IIX0o.ooOOo0oXI(objArr);
            return (V) objArr[this.f29144Oo];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int i;
            K key = getKey();
            int i2 = 0;
            if (key != null) {
                i = key.hashCode();
            } else {
                i = 0;
            }
            V value = getValue();
            if (value != null) {
                i2 = value.hashCode();
            }
            return i ^ i2;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            this.f29145XO.checkIsMutable$kotlin_stdlib();
            Object[] allocateValuesArray = this.f29145XO.allocateValuesArray();
            int i = this.f29144Oo;
            V v2 = (V) allocateValuesArray[i];
            allocateValuesArray[i] = v;
            return v2;
        }

        @OOXIXo
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }

    /* loaded from: classes6.dex */
    public static final class II0xO0<K, V> extends oxoX<K, V> implements Iterator<Map.Entry<K, V>>, OI0IXox.oxoX {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public II0xO0(@OOXIXo MapBuilder<K, V> map) {
            super(map);
            IIX0o.x0xO0oo(map, "map");
        }

        public final int OOXIXo() {
            int i;
            if (II0xO0() < ((MapBuilder) X0o0xo()).length) {
                int II0xO02 = II0xO0();
                Oxx0IOOO(II0xO02 + 1);
                II0XooXoX(II0xO02);
                Object obj = ((MapBuilder) X0o0xo()).keysArray[oxoX()];
                int i2 = 0;
                if (obj != null) {
                    i = obj.hashCode();
                } else {
                    i = 0;
                }
                Object[] objArr = ((MapBuilder) X0o0xo()).valuesArray;
                IIX0o.ooOOo0oXI(objArr);
                Object obj2 = objArr[oxoX()];
                if (obj2 != null) {
                    i2 = obj2.hashCode();
                }
                int i3 = i ^ i2;
                XO();
                return i3;
            }
            throw new NoSuchElementException();
        }

        public final void xoIox(@OOXIXo StringBuilder sb) {
            IIX0o.x0xO0oo(sb, "sb");
            if (II0xO0() < ((MapBuilder) X0o0xo()).length) {
                int II0xO02 = II0xO0();
                Oxx0IOOO(II0xO02 + 1);
                II0XooXoX(II0xO02);
                Object obj = ((MapBuilder) X0o0xo()).keysArray[oxoX()];
                if (obj == X0o0xo()) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj);
                }
                sb.append('=');
                Object[] objArr = ((MapBuilder) X0o0xo()).valuesArray;
                IIX0o.ooOOo0oXI(objArr);
                Object obj2 = objArr[oxoX()];
                if (obj2 == X0o0xo()) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj2);
                }
                XO();
                return;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        @OOXIXo
        /* renamed from: xxIXOIIO, reason: merged with bridge method [inline-methods] */
        public I0Io<K, V> next() {
            oIX0oI();
            if (II0xO0() < ((MapBuilder) X0o0xo()).length) {
                int II0xO02 = II0xO0();
                Oxx0IOOO(II0xO02 + 1);
                II0XooXoX(II0xO02);
                I0Io<K, V> i0Io = new I0Io<>(X0o0xo(), oxoX());
                XO();
                return i0Io;
            }
            throw new NoSuchElementException();
        }
    }

    /* loaded from: classes6.dex */
    public static final class X0o0xo<K, V> extends oxoX<K, V> implements Iterator<K>, OI0IXox.oxoX {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public X0o0xo(@OOXIXo MapBuilder<K, V> map) {
            super(map);
            IIX0o.x0xO0oo(map, "map");
        }

        @Override // java.util.Iterator
        public K next() {
            oIX0oI();
            if (II0xO0() < ((MapBuilder) X0o0xo()).length) {
                int II0xO02 = II0xO0();
                Oxx0IOOO(II0xO02 + 1);
                II0XooXoX(II0xO02);
                K k = (K) ((MapBuilder) X0o0xo()).keysArray[oxoX()];
                XO();
                return k;
            }
            throw new NoSuchElementException();
        }
    }

    /* loaded from: classes6.dex */
    public static final class XO<K, V> extends oxoX<K, V> implements Iterator<V>, OI0IXox.oxoX {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public XO(@OOXIXo MapBuilder<K, V> map) {
            super(map);
            IIX0o.x0xO0oo(map, "map");
        }

        @Override // java.util.Iterator
        public V next() {
            oIX0oI();
            if (II0xO0() < ((MapBuilder) X0o0xo()).length) {
                int II0xO02 = II0xO0();
                Oxx0IOOO(II0xO02 + 1);
                II0XooXoX(II0xO02);
                Object[] objArr = ((MapBuilder) X0o0xo()).valuesArray;
                IIX0o.ooOOo0oXI(objArr);
                V v = (V) objArr[oxoX()];
                XO();
                return v;
            }
            throw new NoSuchElementException();
        }
    }

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public final int I0Io(int i) {
            return Integer.highestOneBit(X0.IIXOooo.OxxIIOOXO(i, 1) * 3);
        }

        @OOXIXo
        public final MapBuilder X0o0xo() {
            return MapBuilder.Empty;
        }

        public final int oxoX(int i) {
            return Integer.numberOfLeadingZeros(i) + 1;
        }

        public oIX0oI() {
        }
    }

    @XX({"SMAP\nMapBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapBuilder.kt\nkotlin/collections/builders/MapBuilder$Itr\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,727:1\n1#2:728\n*E\n"})
    /* loaded from: classes6.dex */
    public static class oxoX<K, V> {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public int f29146IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public int f29147Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public int f29148Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        @OOXIXo
        public final MapBuilder<K, V> f29149XO;

        public oxoX(@OOXIXo MapBuilder<K, V> map) {
            IIX0o.x0xO0oo(map, "map");
            this.f29149XO = map;
            this.f29146IXxxXO = -1;
            this.f29148Oxx0xo = ((MapBuilder) map).modCount;
            XO();
        }

        public final void II0XooXoX(int i) {
            this.f29146IXxxXO = i;
        }

        public final int II0xO0() {
            return this.f29147Oo;
        }

        public final void Oxx0IOOO(int i) {
            this.f29147Oo = i;
        }

        @OOXIXo
        public final MapBuilder<K, V> X0o0xo() {
            return this.f29149XO;
        }

        public final void XO() {
            while (this.f29147Oo < ((MapBuilder) this.f29149XO).length) {
                int[] iArr = ((MapBuilder) this.f29149XO).presenceArray;
                int i = this.f29147Oo;
                if (iArr[i] < 0) {
                    this.f29147Oo = i + 1;
                } else {
                    return;
                }
            }
        }

        public final boolean hasNext() {
            if (this.f29147Oo < ((MapBuilder) this.f29149XO).length) {
                return true;
            }
            return false;
        }

        public final void oIX0oI() {
            if (((MapBuilder) this.f29149XO).modCount == this.f29148Oxx0xo) {
            } else {
                throw new ConcurrentModificationException();
            }
        }

        public final int oxoX() {
            return this.f29146IXxxXO;
        }

        public final void remove() {
            oIX0oI();
            if (this.f29146IXxxXO != -1) {
                this.f29149XO.checkIsMutable$kotlin_stdlib();
                this.f29149XO.removeKeyAt(this.f29146IXxxXO);
                this.f29146IXxxXO = -1;
                this.f29148Oxx0xo = ((MapBuilder) this.f29149XO).modCount;
                return;
            }
            throw new IllegalStateException("Call next() before removing element from the iterator.");
        }
    }

    static {
        MapBuilder mapBuilder = new MapBuilder(0);
        mapBuilder.isReadOnly = true;
        Empty = mapBuilder;
    }

    private MapBuilder(K[] kArr, V[] vArr, int[] iArr, int[] iArr2, int i, int i2) {
        this.keysArray = kArr;
        this.valuesArray = vArr;
        this.presenceArray = iArr;
        this.hashArray = iArr2;
        this.maxProbeDistance = i;
        this.length = i2;
        this.hashShift = Companion.oxoX(getHashSize());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V[] allocateValuesArray() {
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            return vArr;
        }
        V[] vArr2 = (V[]) kotlin.collections.builders.II0xO0.oxoX(getCapacity$kotlin_stdlib());
        this.valuesArray = vArr2;
        return vArr2;
    }

    private final void compact() {
        int i;
        V[] vArr = this.valuesArray;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = this.length;
            if (i2 >= i) {
                break;
            }
            if (this.presenceArray[i2] >= 0) {
                K[] kArr = this.keysArray;
                kArr[i3] = kArr[i2];
                if (vArr != null) {
                    vArr[i3] = vArr[i2];
                }
                i3++;
            }
            i2++;
        }
        kotlin.collections.builders.II0xO0.Oxx0IOOO(this.keysArray, i3, i);
        if (vArr != null) {
            kotlin.collections.builders.II0xO0.Oxx0IOOO(vArr, i3, this.length);
        }
        this.length = i3;
    }

    private final boolean contentEquals(Map<?, ?> map) {
        if (size() == map.size() && containsAllEntries$kotlin_stdlib(map.entrySet())) {
            return true;
        }
        return false;
    }

    private final void ensureCapacity(int i) {
        V[] vArr;
        if (i >= 0) {
            if (i > getCapacity$kotlin_stdlib()) {
                int X0o0xo2 = kotlin.collections.II0xO0.Companion.X0o0xo(getCapacity$kotlin_stdlib(), i);
                this.keysArray = (K[]) kotlin.collections.builders.II0xO0.X0o0xo(this.keysArray, X0o0xo2);
                V[] vArr2 = this.valuesArray;
                if (vArr2 != null) {
                    vArr = (V[]) kotlin.collections.builders.II0xO0.X0o0xo(vArr2, X0o0xo2);
                } else {
                    vArr = null;
                }
                this.valuesArray = vArr;
                int[] copyOf = Arrays.copyOf(this.presenceArray, X0o0xo2);
                IIX0o.oO(copyOf, "copyOf(...)");
                this.presenceArray = copyOf;
                int I0Io2 = Companion.I0Io(X0o0xo2);
                if (I0Io2 > getHashSize()) {
                    rehash(I0Io2);
                    return;
                }
                return;
            }
            return;
        }
        throw new OutOfMemoryError();
    }

    private final void ensureExtraCapacity(int i) {
        if (shouldCompact(i)) {
            rehash(getHashSize());
        } else {
            ensureCapacity(this.length + i);
        }
    }

    private final int findKey(K k) {
        int hash = hash(k);
        int i = this.maxProbeDistance;
        while (true) {
            int i2 = this.hashArray[hash];
            if (i2 == 0) {
                return -1;
            }
            if (i2 > 0) {
                int i3 = i2 - 1;
                if (IIX0o.Oxx0IOOO(this.keysArray[i3], k)) {
                    return i3;
                }
            }
            i--;
            if (i < 0) {
                return -1;
            }
            int i4 = hash - 1;
            if (hash == 0) {
                hash = getHashSize() - 1;
            } else {
                hash = i4;
            }
        }
    }

    private final int findValue(V v) {
        int i = this.length;
        while (true) {
            i--;
            if (i < 0) {
                return -1;
            }
            if (this.presenceArray[i] >= 0) {
                V[] vArr = this.valuesArray;
                IIX0o.ooOOo0oXI(vArr);
                if (IIX0o.Oxx0IOOO(vArr[i], v)) {
                    return i;
                }
            }
        }
    }

    private final int getHashSize() {
        return this.hashArray.length;
    }

    private final int hash(K k) {
        int i;
        if (k != null) {
            i = k.hashCode();
        } else {
            i = 0;
        }
        return (i * (-1640531527)) >>> this.hashShift;
    }

    private final boolean putAllEntries(Collection<? extends Map.Entry<? extends K, ? extends V>> collection) {
        boolean z = false;
        if (collection.isEmpty()) {
            return false;
        }
        ensureExtraCapacity(collection.size());
        Iterator<? extends Map.Entry<? extends K, ? extends V>> it = collection.iterator();
        while (it.hasNext()) {
            if (putEntry(it.next())) {
                z = true;
            }
        }
        return z;
    }

    private final boolean putEntry(Map.Entry<? extends K, ? extends V> entry) {
        int addKey$kotlin_stdlib = addKey$kotlin_stdlib(entry.getKey());
        V[] allocateValuesArray = allocateValuesArray();
        if (addKey$kotlin_stdlib >= 0) {
            allocateValuesArray[addKey$kotlin_stdlib] = entry.getValue();
            return true;
        }
        int i = (-addKey$kotlin_stdlib) - 1;
        if (!IIX0o.Oxx0IOOO(entry.getValue(), allocateValuesArray[i])) {
            allocateValuesArray[i] = entry.getValue();
            return true;
        }
        return false;
    }

    private final boolean putRehash(int i) {
        int hash = hash(this.keysArray[i]);
        int i2 = this.maxProbeDistance;
        while (true) {
            int[] iArr = this.hashArray;
            if (iArr[hash] == 0) {
                iArr[hash] = i + 1;
                this.presenceArray[i] = hash;
                return true;
            }
            i2--;
            if (i2 < 0) {
                return false;
            }
            int i3 = hash - 1;
            if (hash == 0) {
                hash = getHashSize() - 1;
            } else {
                hash = i3;
            }
        }
    }

    private final void registerModification() {
        this.modCount++;
    }

    private final void rehash(int i) {
        registerModification();
        if (this.length > size()) {
            compact();
        }
        int i2 = 0;
        if (i != getHashSize()) {
            this.hashArray = new int[i];
            this.hashShift = Companion.oxoX(i);
        } else {
            ooOOo0oXI.oX0I0O(this.hashArray, 0, 0, getHashSize());
        }
        while (i2 < this.length) {
            int i3 = i2 + 1;
            if (putRehash(i2)) {
                i2 = i3;
            } else {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
        }
    }

    private final void removeHashAt(int i) {
        int XI0IXoo2 = X0.IIXOooo.XI0IXoo(this.maxProbeDistance * 2, getHashSize() / 2);
        int i2 = 0;
        int i3 = i;
        do {
            int i4 = i - 1;
            if (i == 0) {
                i = getHashSize() - 1;
            } else {
                i = i4;
            }
            i2++;
            if (i2 > this.maxProbeDistance) {
                this.hashArray[i3] = 0;
                return;
            }
            int[] iArr = this.hashArray;
            int i5 = iArr[i];
            if (i5 == 0) {
                iArr[i3] = 0;
                return;
            }
            if (i5 < 0) {
                iArr[i3] = -1;
            } else {
                int i6 = i5 - 1;
                if (((hash(this.keysArray[i6]) - i) & (getHashSize() - 1)) >= i2) {
                    this.hashArray[i3] = i5;
                    this.presenceArray[i6] = i3;
                }
                XI0IXoo2--;
            }
            i3 = i;
            i2 = 0;
            XI0IXoo2--;
        } while (XI0IXoo2 >= 0);
        this.hashArray[i3] = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeKeyAt(int i) {
        kotlin.collections.builders.II0xO0.XO(this.keysArray, i);
        removeHashAt(this.presenceArray[i]);
        this.presenceArray[i] = -1;
        this.size = size() - 1;
        registerModification();
    }

    private final boolean shouldCompact(int i) {
        int capacity$kotlin_stdlib = getCapacity$kotlin_stdlib();
        int i2 = this.length;
        int i3 = capacity$kotlin_stdlib - i2;
        int size = i2 - size();
        if (i3 < i && i3 + size >= i && size >= getCapacity$kotlin_stdlib() / 4) {
            return true;
        }
        return false;
    }

    private final Object writeReplace() {
        if (this.isReadOnly) {
            return new SerializedMap(this);
        }
        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }

    public final int addKey$kotlin_stdlib(K k) {
        checkIsMutable$kotlin_stdlib();
        while (true) {
            int hash = hash(k);
            int XI0IXoo2 = X0.IIXOooo.XI0IXoo(this.maxProbeDistance * 2, getHashSize() / 2);
            int i = 0;
            while (true) {
                int i2 = this.hashArray[hash];
                if (i2 <= 0) {
                    if (this.length >= getCapacity$kotlin_stdlib()) {
                        ensureExtraCapacity(1);
                    } else {
                        int i3 = this.length;
                        int i4 = i3 + 1;
                        this.length = i4;
                        this.keysArray[i3] = k;
                        this.presenceArray[i3] = hash;
                        this.hashArray[hash] = i4;
                        this.size = size() + 1;
                        registerModification();
                        if (i > this.maxProbeDistance) {
                            this.maxProbeDistance = i;
                        }
                        return i3;
                    }
                } else {
                    if (IIX0o.Oxx0IOOO(this.keysArray[i2 - 1], k)) {
                        return -i2;
                    }
                    i++;
                    if (i > XI0IXoo2) {
                        rehash(getHashSize() * 2);
                        break;
                    }
                    int i5 = hash - 1;
                    if (hash == 0) {
                        hash = getHashSize() - 1;
                    } else {
                        hash = i5;
                    }
                }
            }
        }
    }

    @OOXIXo
    public final Map<K, V> build() {
        checkIsMutable$kotlin_stdlib();
        this.isReadOnly = true;
        if (size() > 0) {
            return this;
        }
        MapBuilder mapBuilder = Empty;
        IIX0o.x0XOIxOo(mapBuilder, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return mapBuilder;
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (!this.isReadOnly) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public void clear() {
        checkIsMutable$kotlin_stdlib();
        oOXoIIIo it = new X0.oOoXoXO(0, this.length - 1).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            int[] iArr = this.presenceArray;
            int i = iArr[nextInt];
            if (i >= 0) {
                this.hashArray[i] = 0;
                iArr[nextInt] = -1;
            }
        }
        kotlin.collections.builders.II0xO0.Oxx0IOOO(this.keysArray, 0, this.length);
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            kotlin.collections.builders.II0xO0.Oxx0IOOO(vArr, 0, this.length);
        }
        this.size = 0;
        this.length = 0;
        registerModification();
    }

    public final boolean containsAllEntries$kotlin_stdlib(@OOXIXo Collection<?> m) {
        IIX0o.x0xO0oo(m, "m");
        for (Object obj : m) {
            if (obj != null) {
                try {
                    if (!containsEntry$kotlin_stdlib((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean containsEntry$kotlin_stdlib(@OOXIXo Map.Entry<? extends K, ? extends V> entry) {
        IIX0o.x0xO0oo(entry, "entry");
        int findKey = findKey(entry.getKey());
        if (findKey < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        IIX0o.ooOOo0oXI(vArr);
        return IIX0o.Oxx0IOOO(vArr[findKey], entry.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        if (findKey(obj) >= 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        if (findValue(obj) >= 0) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public final II0xO0<K, V> entriesIterator$kotlin_stdlib() {
        return new II0xO0<>(this);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(@oOoXoXO Object obj) {
        if (obj != this && (!(obj instanceof Map) || !contentEquals((Map) obj))) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @oOoXoXO
    public V get(Object obj) {
        int findKey = findKey(obj);
        if (findKey < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        IIX0o.ooOOo0oXI(vArr);
        return vArr[findKey];
    }

    public final int getCapacity$kotlin_stdlib() {
        return this.keysArray.length;
    }

    @OOXIXo
    public Set<Map.Entry<K, V>> getEntries() {
        kotlin.collections.builders.I0Io<K, V> i0Io = this.entriesView;
        if (i0Io == null) {
            kotlin.collections.builders.I0Io<K, V> i0Io2 = new kotlin.collections.builders.I0Io<>(this);
            this.entriesView = i0Io2;
            return i0Io2;
        }
        return i0Io;
    }

    @OOXIXo
    public Set<K> getKeys() {
        kotlin.collections.builders.oxoX<K> oxox = this.keysView;
        if (oxox == null) {
            kotlin.collections.builders.oxoX<K> oxox2 = new kotlin.collections.builders.oxoX<>(this);
            this.keysView = oxox2;
            return oxox2;
        }
        return oxox;
    }

    public int getSize() {
        return this.size;
    }

    @OOXIXo
    public Collection<V> getValues() {
        kotlin.collections.builders.X0o0xo<V> x0o0xo = this.valuesView;
        if (x0o0xo == null) {
            kotlin.collections.builders.X0o0xo<V> x0o0xo2 = new kotlin.collections.builders.X0o0xo<>(this);
            this.valuesView = x0o0xo2;
            return x0o0xo2;
        }
        return x0o0xo;
    }

    @Override // java.util.Map
    public int hashCode() {
        II0xO0<K, V> entriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i = 0;
        while (entriesIterator$kotlin_stdlib.hasNext()) {
            i += entriesIterator$kotlin_stdlib.OOXIXo();
        }
        return i;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public final boolean isReadOnly$kotlin_stdlib() {
        return this.isReadOnly;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @OOXIXo
    public final X0o0xo<K, V> keysIterator$kotlin_stdlib() {
        return new X0o0xo<>(this);
    }

    @Override // java.util.Map
    @oOoXoXO
    public V put(K k, V v) {
        checkIsMutable$kotlin_stdlib();
        int addKey$kotlin_stdlib = addKey$kotlin_stdlib(k);
        V[] allocateValuesArray = allocateValuesArray();
        if (addKey$kotlin_stdlib < 0) {
            int i = (-addKey$kotlin_stdlib) - 1;
            V v2 = allocateValuesArray[i];
            allocateValuesArray[i] = v;
            return v2;
        }
        allocateValuesArray[addKey$kotlin_stdlib] = v;
        return null;
    }

    @Override // java.util.Map
    public void putAll(@OOXIXo Map<? extends K, ? extends V> from) {
        IIX0o.x0xO0oo(from, "from");
        checkIsMutable$kotlin_stdlib();
        putAllEntries(from.entrySet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @oOoXoXO
    public V remove(Object obj) {
        int removeKey$kotlin_stdlib = removeKey$kotlin_stdlib(obj);
        if (removeKey$kotlin_stdlib < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        IIX0o.ooOOo0oXI(vArr);
        V v = vArr[removeKey$kotlin_stdlib];
        kotlin.collections.builders.II0xO0.XO(vArr, removeKey$kotlin_stdlib);
        return v;
    }

    public final boolean removeEntry$kotlin_stdlib(@OOXIXo Map.Entry<? extends K, ? extends V> entry) {
        IIX0o.x0xO0oo(entry, "entry");
        checkIsMutable$kotlin_stdlib();
        int findKey = findKey(entry.getKey());
        if (findKey < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        IIX0o.ooOOo0oXI(vArr);
        if (!IIX0o.Oxx0IOOO(vArr[findKey], entry.getValue())) {
            return false;
        }
        removeKeyAt(findKey);
        return true;
    }

    public final int removeKey$kotlin_stdlib(K k) {
        checkIsMutable$kotlin_stdlib();
        int findKey = findKey(k);
        if (findKey < 0) {
            return -1;
        }
        removeKeyAt(findKey);
        return findKey;
    }

    public final boolean removeValue$kotlin_stdlib(V v) {
        checkIsMutable$kotlin_stdlib();
        int findValue = findValue(v);
        if (findValue < 0) {
            return false;
        }
        removeKeyAt(findValue);
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @OOXIXo
    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append("{");
        II0xO0<K, V> entriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i = 0;
        while (entriesIterator$kotlin_stdlib.hasNext()) {
            if (i > 0) {
                sb.append(", ");
            }
            entriesIterator$kotlin_stdlib.xoIox(sb);
            i++;
        }
        sb.append(org.apache.commons.text.ooOOo0oXI.f33074oOoXoXO);
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "toString(...)");
        return sb2;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    @OOXIXo
    public final XO<K, V> valuesIterator$kotlin_stdlib() {
        return new XO<>(this);
    }

    public MapBuilder() {
        this(8);
    }

    public MapBuilder(int i) {
        this(kotlin.collections.builders.II0xO0.oxoX(i), null, new int[i], new int[Companion.I0Io(i)], 2, 0);
    }
}
