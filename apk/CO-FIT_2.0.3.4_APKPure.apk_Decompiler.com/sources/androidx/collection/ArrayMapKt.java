package androidx.collection;

import OXOo.OOXIXo;
import kotlin.Pair;
import kotlin.jvm.internal.IIX0o;

public final class ArrayMapKt {
    @OOXIXo
    public static final <K, V> ArrayMap<K, V> arrayMapOf() {
        return new ArrayMap<>();
    }

    @OOXIXo
    public static final <K, V> ArrayMap<K, V> arrayMapOf(@OOXIXo Pair<? extends K, ? extends V>... pairArr) {
        IIX0o.x0xO0oo(pairArr, "pairs");
        ArrayMap<K, V> arrayMap = new ArrayMap<>(pairArr.length);
        for (Pair<? extends K, ? extends V> pair : pairArr) {
            arrayMap.put(pair.getFirst(), pair.getSecond());
        }
        return arrayMap;
    }
}
