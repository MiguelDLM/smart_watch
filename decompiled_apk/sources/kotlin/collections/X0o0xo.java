package kotlin.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

@kotlin.oxxXoxO(version = "1.1")
/* loaded from: classes6.dex */
public abstract class X0o0xo<K, V> extends java.util.AbstractMap<K, V> implements Map<K, V>, OI0IXox.Oxx0IOOO {
    public /* bridge */ Set<Object> II0xO0() {
        return super.keySet();
    }

    public /* bridge */ Collection<Object> X0o0xo() {
        return super.values();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return oIX0oI();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return (Set<K>) II0xO0();
    }

    public abstract Set oIX0oI();

    public /* bridge */ int oxoX() {
        return super.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    @OXOo.oOoXoXO
    public abstract V put(K k, V v);

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return oxoX();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<V> values() {
        return (Collection<V>) X0o0xo();
    }
}
