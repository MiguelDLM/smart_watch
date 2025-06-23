package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@kotlin.oxxXoxO(version = "1.1")
@kotlin.jvm.internal.XX({"SMAP\nAbstractMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractMap.kt\nkotlin/collections/AbstractMap\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,153:1\n1747#2,3:154\n1726#2,3:157\n288#2,2:160\n*S KotlinDebug\n*F\n+ 1 AbstractMap.kt\nkotlin/collections/AbstractMap\n*L\n28#1:154,3\n60#1:157,3\n141#1:160,2\n*E\n"})
/* loaded from: classes6.dex */
public abstract class AbstractMap<K, V> implements Map<K, V>, OI0IXox.oIX0oI {

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f29082IXxxXO = new oIX0oI(null);

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public volatile Collection<? extends V> f29083Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public volatile Set<? extends K> f29084XO;

    /* loaded from: classes6.dex */
    public static final class I0Io extends AbstractCollection<V> {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ AbstractMap<K, V> f29085XO;

        /* loaded from: classes6.dex */
        public static final class oIX0oI implements Iterator<V>, OI0IXox.oIX0oI {

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ Iterator<Map.Entry<K, V>> f29086XO;

            /* JADX WARN: Multi-variable type inference failed */
            public oIX0oI(Iterator<? extends Map.Entry<? extends K, ? extends V>> it) {
                this.f29086XO = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f29086XO.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                return this.f29086XO.next().getValue();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public I0Io(AbstractMap<K, ? extends V> abstractMap) {
            this.f29085XO = abstractMap;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.f29085XO.containsValue(obj);
        }

        @Override // kotlin.collections.AbstractCollection
        public int getSize() {
            return this.f29085XO.size();
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
        @OXOo.OOXIXo
        public Iterator<V> iterator() {
            return new oIX0oI(this.f29085XO.entrySet().iterator());
        }
    }

    /* loaded from: classes6.dex */
    public static final class II0xO0 extends Oxx0IOOO<K> {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ AbstractMap<K, V> f29087Oo;

        /* loaded from: classes6.dex */
        public static final class oIX0oI implements Iterator<K>, OI0IXox.oIX0oI {

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ Iterator<Map.Entry<K, V>> f29088XO;

            /* JADX WARN: Multi-variable type inference failed */
            public oIX0oI(Iterator<? extends Map.Entry<? extends K, ? extends V>> it) {
                this.f29088XO = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f29088XO.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                return this.f29088XO.next().getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public II0xO0(AbstractMap<K, ? extends V> abstractMap) {
            this.f29087Oo = abstractMap;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.f29087Oo.containsKey(obj);
        }

        @Override // kotlin.collections.AbstractCollection
        public int getSize() {
            return this.f29087Oo.size();
        }

        @Override // kotlin.collections.Oxx0IOOO, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
        @OXOo.OOXIXo
        public Iterator<K> iterator() {
            return new oIX0oI(this.f29087Oo.entrySet().iterator());
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nAbstractMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractMap.kt\nkotlin/collections/AbstractMap$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,153:1\n1#2:154\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @OXOo.OOXIXo
        public final String I0Io(@OXOo.OOXIXo Map.Entry<?, ?> e) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(e, "e");
            StringBuilder sb = new StringBuilder();
            sb.append(e.getKey());
            sb.append('=');
            sb.append(e.getValue());
            return sb.toString();
        }

        public final int II0xO0(@OXOo.OOXIXo Map.Entry<?, ?> e) {
            int i;
            kotlin.jvm.internal.IIX0o.x0xO0oo(e, "e");
            Object key = e.getKey();
            int i2 = 0;
            if (key != null) {
                i = key.hashCode();
            } else {
                i = 0;
            }
            Object value = e.getValue();
            if (value != null) {
                i2 = value.hashCode();
            }
            return i ^ i2;
        }

        public final boolean oIX0oI(@OXOo.OOXIXo Map.Entry<?, ?> e, @OXOo.oOoXoXO Object obj) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(e, "e");
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(e.getKey(), entry.getKey()) || !kotlin.jvm.internal.IIX0o.Oxx0IOOO(e.getValue(), entry.getValue())) {
                return false;
            }
            return true;
        }

        public oIX0oI() {
        }
    }

    public final Map.Entry<K, V> II0XooXoX(K k) {
        Object obj;
        Iterator<T> it = entrySet().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(((Map.Entry) obj).getKey(), k)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (Map.Entry) obj;
    }

    public final boolean II0xO0(@OXOo.oOoXoXO Map.Entry<?, ?> entry) {
        if (entry == null) {
            return false;
        }
        Object key = entry.getKey();
        Object value = entry.getValue();
        kotlin.jvm.internal.IIX0o.x0XOIxOo(this, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
        V v = get(key);
        if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(value, v)) {
            return false;
        }
        if (v == null) {
            kotlin.jvm.internal.IIX0o.x0XOIxOo(this, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.containsKey, *>");
            if (!containsKey(key)) {
                return false;
            }
            return true;
        }
        return true;
    }

    @OXOo.OOXIXo
    public Collection<V> Oxx0IOOO() {
        if (this.f29083Oo == null) {
            this.f29083Oo = new I0Io(this);
        }
        Collection<? extends V> collection = this.f29083Oo;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(collection);
        return collection;
    }

    @OXOo.OOXIXo
    public Set<K> X0o0xo() {
        if (this.f29084XO == null) {
            this.f29084XO = new II0xO0(this);
        }
        Set<? extends K> set = this.f29084XO;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(set);
        return set;
    }

    public int XO() {
        return entrySet().size();
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        if (II0XooXoX(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        Set<Map.Entry<K, V>> entrySet = entrySet();
        if ((entrySet instanceof Collection) && entrySet.isEmpty()) {
            return false;
        }
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(((Map.Entry) it.next()).getValue(), obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return oxoX();
    }

    @Override // java.util.Map
    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        Set<Map.Entry<K, V>> entrySet = map.entrySet();
        if ((entrySet instanceof Collection) && entrySet.isEmpty()) {
            return true;
        }
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            if (!II0xO0((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @OXOo.oOoXoXO
    public V get(Object obj) {
        Map.Entry<K, V> II0XooXoX2 = II0XooXoX(obj);
        if (II0XooXoX2 != null) {
            return II0XooXoX2.getValue();
        }
        return null;
    }

    @Override // java.util.Map
    public int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return X0o0xo();
    }

    public abstract Set oxoX();

    @Override // java.util.Map
    public V put(K k, V v) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return XO();
    }

    @OXOo.OOXIXo
    public String toString() {
        return CollectionsKt___CollectionsKt.OoIXo(entrySet(), ", ", "{", org.apache.commons.text.ooOOo0oXI.f33074oOoXoXO, 0, null, new Oox.oOoXoXO<Map.Entry<? extends K, ? extends V>, CharSequence>(this) { // from class: kotlin.collections.AbstractMap$toString$1
            final /* synthetic */ AbstractMap<K, V> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // Oox.oOoXoXO
            @OXOo.OOXIXo
            public final CharSequence invoke(@OXOo.OOXIXo Map.Entry<? extends K, ? extends V> it) {
                String xoIox2;
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                xoIox2 = this.this$0.xoIox(it);
                return xoIox2;
            }
        }, 24, null);
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return Oxx0IOOO();
    }

    public final String xoIox(Map.Entry<? extends K, ? extends V> entry) {
        return xxIXOIIO(entry.getKey()) + '=' + xxIXOIIO(entry.getValue());
    }

    public final String xxIXOIIO(Object obj) {
        if (obj == this) {
            return "(this Map)";
        }
        return String.valueOf(obj);
    }
}
