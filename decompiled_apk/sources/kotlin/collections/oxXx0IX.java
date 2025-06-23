package kotlin.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

@kotlin.jvm.internal.XX({"SMAP\nMapWithDefault.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapWithDefault.kt\nkotlin/collections/MutableMapWithDefaultImpl\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,104:1\n341#2,6:105\n*S KotlinDebug\n*F\n+ 1 MapWithDefault.kt\nkotlin/collections/MutableMapWithDefaultImpl\n*L\n101#1:105,6\n*E\n"})
/* loaded from: classes6.dex */
public final class oxXx0IX<K, V> implements XoX<K, V> {

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Oox.oOoXoXO<K, V> f29164Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Map<K, V> f29165XO;

    /* JADX WARN: Multi-variable type inference failed */
    public oxXx0IX(@OXOo.OOXIXo Map<K, V> map, @OXOo.OOXIXo Oox.oOoXoXO<? super K, ? extends V> oooxoxo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "map");
        kotlin.jvm.internal.IIX0o.x0xO0oo(oooxoxo, "default");
        this.f29165XO = map;
        this.f29164Oo = oooxoxo;
    }

    @Override // kotlin.collections.IO
    public V I0Io(K k) {
        Map<K, V> map = getMap();
        V v = map.get(k);
        if (v == null && !map.containsKey(k)) {
            return this.f29164Oo.invoke(k);
        }
        return v;
    }

    @OXOo.OOXIXo
    public Set<K> II0xO0() {
        return getMap().keySet();
    }

    @OXOo.OOXIXo
    public Collection<V> X0o0xo() {
        return getMap().values();
    }

    @Override // java.util.Map
    public void clear() {
        getMap().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return getMap().containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return getMap().containsValue(obj);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return oIX0oI();
    }

    @Override // java.util.Map
    public boolean equals(@OXOo.oOoXoXO Object obj) {
        return getMap().equals(obj);
    }

    @Override // java.util.Map
    @OXOo.oOoXoXO
    public V get(Object obj) {
        return getMap().get(obj);
    }

    @Override // kotlin.collections.XoX, kotlin.collections.IO
    @OXOo.OOXIXo
    public Map<K, V> getMap() {
        return this.f29165XO;
    }

    @Override // java.util.Map
    public int hashCode() {
        return getMap().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return getMap().isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return II0xO0();
    }

    @OXOo.OOXIXo
    public Set<Map.Entry<K, V>> oIX0oI() {
        return getMap().entrySet();
    }

    public int oxoX() {
        return getMap().size();
    }

    @Override // java.util.Map
    @OXOo.oOoXoXO
    public V put(K k, V v) {
        return getMap().put(k, v);
    }

    @Override // java.util.Map
    public void putAll(@OXOo.OOXIXo Map<? extends K, ? extends V> from) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(from, "from");
        getMap().putAll(from);
    }

    @Override // java.util.Map
    @OXOo.oOoXoXO
    public V remove(Object obj) {
        return getMap().remove(obj);
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return oxoX();
    }

    @OXOo.OOXIXo
    public String toString() {
        return getMap().toString();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return X0o0xo();
    }
}
