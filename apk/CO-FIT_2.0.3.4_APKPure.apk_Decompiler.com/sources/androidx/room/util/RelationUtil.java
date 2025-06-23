package androidx.room.util;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import XO0OX.xxIXOIIO;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import com.iflytek.sparkchain.plugins.map.tools.MapPlugin;
import java.util.HashMap;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

@xxIXOIIO(name = "RelationUtil")
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class RelationUtil {
    public static final <K, V> void recursiveFetchArrayMap(@OOXIXo ArrayMap<K, V> arrayMap, boolean z, @OOXIXo oOoXoXO<? super ArrayMap<K, V>, oXIO0o0XI> oooxoxo) {
        int i;
        IIX0o.x0xO0oo(arrayMap, MapPlugin.MapSearchTool);
        IIX0o.x0xO0oo(oooxoxo, "fetchBlock");
        ArrayMap arrayMap2 = new ArrayMap(999);
        int size = arrayMap.size();
        int i2 = 0;
        loop0:
        while (true) {
            i = 0;
            while (i2 < size) {
                if (z) {
                    arrayMap2.put(arrayMap.keyAt(i2), arrayMap.valueAt(i2));
                } else {
                    arrayMap2.put(arrayMap.keyAt(i2), (Object) null);
                }
                i2++;
                i++;
                if (i == 999) {
                    oooxoxo.invoke(arrayMap2);
                    if (!z) {
                        arrayMap.putAll(arrayMap2);
                    }
                    arrayMap2.clear();
                }
            }
            break loop0;
        }
        if (i > 0) {
            oooxoxo.invoke(arrayMap2);
            if (!z) {
                arrayMap.putAll(arrayMap2);
            }
        }
    }

    public static final <K, V> void recursiveFetchHashMap(@OOXIXo HashMap<K, V> hashMap, boolean z, @OOXIXo oOoXoXO<? super HashMap<K, V>, oXIO0o0XI> oooxoxo) {
        int i;
        IIX0o.x0xO0oo(hashMap, MapPlugin.MapSearchTool);
        IIX0o.x0xO0oo(oooxoxo, "fetchBlock");
        HashMap hashMap2 = new HashMap(999);
        loop0:
        while (true) {
            i = 0;
            for (K next : hashMap.keySet()) {
                if (z) {
                    IIX0o.oO(next, "key");
                    hashMap2.put(next, hashMap.get(next));
                } else {
                    IIX0o.oO(next, "key");
                    hashMap2.put(next, (Object) null);
                }
                i++;
                if (i == 999) {
                    oooxoxo.invoke(hashMap2);
                    if (!z) {
                        hashMap.putAll(hashMap2);
                    }
                    hashMap2.clear();
                }
            }
            break loop0;
        }
        if (i > 0) {
            oooxoxo.invoke(hashMap2);
            if (!z) {
                hashMap.putAll(hashMap2);
            }
        }
    }

    public static final <V> void recursiveFetchLongSparseArray(@OOXIXo LongSparseArray<V> longSparseArray, boolean z, @OOXIXo oOoXoXO<? super LongSparseArray<V>, oXIO0o0XI> oooxoxo) {
        int i;
        IIX0o.x0xO0oo(longSparseArray, MapPlugin.MapSearchTool);
        IIX0o.x0xO0oo(oooxoxo, "fetchBlock");
        LongSparseArray longSparseArray2 = new LongSparseArray(999);
        int size = longSparseArray.size();
        int i2 = 0;
        loop0:
        while (true) {
            i = 0;
            while (i2 < size) {
                if (z) {
                    longSparseArray2.put(longSparseArray.keyAt(i2), longSparseArray.valueAt(i2));
                } else {
                    longSparseArray2.put(longSparseArray.keyAt(i2), null);
                }
                i2++;
                i++;
                if (i == 999) {
                    oooxoxo.invoke(longSparseArray2);
                    if (!z) {
                        longSparseArray.putAll(longSparseArray2);
                    }
                    longSparseArray2.clear();
                }
            }
            break loop0;
        }
        if (i > 0) {
            oooxoxo.invoke(longSparseArray2);
            if (!z) {
                longSparseArray.putAll(longSparseArray2);
            }
        }
    }
}
