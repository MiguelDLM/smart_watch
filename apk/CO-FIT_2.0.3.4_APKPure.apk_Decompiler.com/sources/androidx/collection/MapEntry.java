package androidx.collection;

import OI0IXox.oIX0oI;
import java.util.Map;

final class MapEntry<K, V> implements Map.Entry<K, V>, oIX0oI {
    private final K key;
    private final V value;

    public MapEntry(K k, V v) {
        this.key = k;
        this.value = v;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public V setValue(V v) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
