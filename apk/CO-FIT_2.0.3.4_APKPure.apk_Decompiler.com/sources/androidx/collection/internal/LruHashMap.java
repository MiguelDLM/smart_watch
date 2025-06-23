package androidx.collection.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

public final class LruHashMap<K, V> {
    @OOXIXo
    private final LinkedHashMap<K, V> map;

    public LruHashMap() {
        this(0, 0.0f, 3, (IIXOooo) null);
    }

    @oOoXoXO
    public final V get(@OOXIXo K k) {
        IIX0o.x0xO0oo(k, "key");
        return this.map.get(k);
    }

    @OOXIXo
    public final Set<Map.Entry<K, V>> getEntries() {
        Set<Map.Entry<K, V>> entrySet = this.map.entrySet();
        IIX0o.oO(entrySet, "map.entries");
        return entrySet;
    }

    public final boolean isEmpty() {
        return this.map.isEmpty();
    }

    @oOoXoXO
    public final V put(@OOXIXo K k, @OOXIXo V v) {
        IIX0o.x0xO0oo(k, "key");
        IIX0o.x0xO0oo(v, "value");
        return this.map.put(k, v);
    }

    @oOoXoXO
    public final V remove(@OOXIXo K k) {
        IIX0o.x0xO0oo(k, "key");
        return this.map.remove(k);
    }

    public LruHashMap(int i, float f) {
        this.map = new LinkedHashMap<>(i, f, true);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LruHashMap(int i, float f, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 16 : i, (i2 & 2) != 0 ? 0.75f : f);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LruHashMap(@OOXIXo LruHashMap<? extends K, V> lruHashMap) {
        this(0, 0.0f, 3, (IIXOooo) null);
        IIX0o.x0xO0oo(lruHashMap, "original");
        for (Map.Entry next : lruHashMap.getEntries()) {
            put(next.getKey(), next.getValue());
        }
    }
}
