package androidx.collection;

import OXOo.OOXIXo;
import kotlin.Pair;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class ArrayMapKt {
    @OOXIXo
    public static final <K, V> ArrayMap<K, V> arrayMapOf() {
        return new ArrayMap<>();
    }

    @OOXIXo
    public static final <K, V> ArrayMap<K, V> arrayMapOf(@OOXIXo Pair<? extends K, ? extends V>... pairs) {
        IIX0o.x0xO0oo(pairs, "pairs");
        ArrayMap<K, V> arrayMap = new ArrayMap<>(pairs.length);
        for (Pair<? extends K, ? extends V> pair : pairs) {
            arrayMap.put(pair.getFirst(), pair.getSecond());
        }
        return arrayMap;
    }
}
