package androidx.collection.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes.dex */
public final class LruHashMap<K, V> {

    @OOXIXo
    private final LinkedHashMap<K, V> map;

    public LruHashMap() {
        this(0, 0.0f, 3, null);
    }

    @oOoXoXO
    public final V get(@OOXIXo K key) {
        IIX0o.x0xO0oo(key, "key");
        return this.map.get(key);
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
    public final V put(@OOXIXo K key, @OOXIXo V value) {
        IIX0o.x0xO0oo(key, "key");
        IIX0o.x0xO0oo(value, "value");
        return this.map.put(key, value);
    }

    @oOoXoXO
    public final V remove(@OOXIXo K key) {
        IIX0o.x0xO0oo(key, "key");
        return this.map.remove(key);
    }

    public LruHashMap(int i, float f) {
        this.map = new LinkedHashMap<>(i, f, true);
    }

    public /* synthetic */ LruHashMap(int i, float f, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 16 : i, (i2 & 2) != 0 ? 0.75f : f);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LruHashMap(@OOXIXo LruHashMap<? extends K, V> original) {
        this(0, 0.0f, 3, null);
        IIX0o.x0xO0oo(original, "original");
        for (Map.Entry<? extends K, V> entry : original.getEntries()) {
            put(entry.getKey(), entry.getValue());
        }
    }
}
