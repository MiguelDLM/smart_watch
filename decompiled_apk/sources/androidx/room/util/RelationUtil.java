package androidx.room.util;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import XO0OX.xxIXOIIO;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

@xxIXOIIO(name = "RelationUtil")
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class RelationUtil {
    public static final <K, V> void recursiveFetchArrayMap(@OOXIXo ArrayMap<K, V> map, boolean z, @OOXIXo oOoXoXO<? super ArrayMap<K, V>, oXIO0o0XI> fetchBlock) {
        int i;
        IIX0o.x0xO0oo(map, "map");
        IIX0o.x0xO0oo(fetchBlock, "fetchBlock");
        ArrayMap arrayMap = new ArrayMap(999);
        int size = map.size();
        int i2 = 0;
        loop0: while (true) {
            i = 0;
            while (i2 < size) {
                if (z) {
                    arrayMap.put(map.keyAt(i2), map.valueAt(i2));
                } else {
                    arrayMap.put(map.keyAt(i2), null);
                }
                i2++;
                i++;
                if (i == 999) {
                    fetchBlock.invoke(arrayMap);
                    if (!z) {
                        map.putAll((Map) arrayMap);
                    }
                    arrayMap.clear();
                }
            }
            break loop0;
        }
        if (i > 0) {
            fetchBlock.invoke(arrayMap);
            if (!z) {
                map.putAll((Map) arrayMap);
            }
        }
    }

    public static final <K, V> void recursiveFetchHashMap(@OOXIXo HashMap<K, V> map, boolean z, @OOXIXo oOoXoXO<? super HashMap<K, V>, oXIO0o0XI> fetchBlock) {
        int i;
        IIX0o.x0xO0oo(map, "map");
        IIX0o.x0xO0oo(fetchBlock, "fetchBlock");
        HashMap hashMap = new HashMap(999);
        loop0: while (true) {
            i = 0;
            for (K key : map.keySet()) {
                if (z) {
                    IIX0o.oO(key, "key");
                    hashMap.put(key, map.get(key));
                } else {
                    IIX0o.oO(key, "key");
                    hashMap.put(key, null);
                }
                i++;
                if (i == 999) {
                    fetchBlock.invoke(hashMap);
                    if (!z) {
                        map.putAll(hashMap);
                    }
                    hashMap.clear();
                }
            }
            break loop0;
        }
        if (i > 0) {
            fetchBlock.invoke(hashMap);
            if (!z) {
                map.putAll(hashMap);
            }
        }
    }

    public static final <V> void recursiveFetchLongSparseArray(@OOXIXo LongSparseArray<V> map, boolean z, @OOXIXo oOoXoXO<? super LongSparseArray<V>, oXIO0o0XI> fetchBlock) {
        int i;
        IIX0o.x0xO0oo(map, "map");
        IIX0o.x0xO0oo(fetchBlock, "fetchBlock");
        LongSparseArray<? extends V> longSparseArray = new LongSparseArray<>(999);
        int size = map.size();
        int i2 = 0;
        loop0: while (true) {
            i = 0;
            while (i2 < size) {
                if (z) {
                    longSparseArray.put(map.keyAt(i2), map.valueAt(i2));
                } else {
                    longSparseArray.put(map.keyAt(i2), null);
                }
                i2++;
                i++;
                if (i == 999) {
                    fetchBlock.invoke(longSparseArray);
                    if (!z) {
                        map.putAll(longSparseArray);
                    }
                    longSparseArray.clear();
                }
            }
            break loop0;
        }
        if (i > 0) {
            fetchBlock.invoke(longSparseArray);
            if (!z) {
                map.putAll(longSparseArray);
            }
        }
    }
}
