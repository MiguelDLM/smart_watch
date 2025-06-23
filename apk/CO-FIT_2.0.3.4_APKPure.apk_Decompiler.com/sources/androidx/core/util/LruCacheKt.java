package androidx.core.util;

import OXOo.OOXIXo;
import Oox.Oxx0xo;
import Oox.oOoXoXO;
import Oox.x0xO0oo;
import android.util.LruCache;
import kotlin.oXIO0o0XI;

public final class LruCacheKt {
    @OOXIXo
    public static final <K, V> LruCache<K, V> lruCache(int i, @OOXIXo x0xO0oo<? super K, ? super V, Integer> x0xo0oo, @OOXIXo oOoXoXO<? super K, ? extends V> oooxoxo, @OOXIXo Oxx0xo<? super Boolean, ? super K, ? super V, ? super V, oXIO0o0XI> oxx0xo) {
        return new LruCacheKt$lruCache$4(i, x0xo0oo, oooxoxo, oxx0xo);
    }

    public static /* synthetic */ LruCache lruCache$default(int i, x0xO0oo x0xo0oo, oOoXoXO oooxoxo, Oxx0xo oxx0xo, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            x0xo0oo = LruCacheKt$lruCache$1.INSTANCE;
        }
        if ((i2 & 4) != 0) {
            oooxoxo = LruCacheKt$lruCache$2.INSTANCE;
        }
        if ((i2 & 8) != 0) {
            oxx0xo = LruCacheKt$lruCache$3.INSTANCE;
        }
        return new LruCacheKt$lruCache$4(i, x0xo0oo, oooxoxo, oxx0xo);
    }
}
