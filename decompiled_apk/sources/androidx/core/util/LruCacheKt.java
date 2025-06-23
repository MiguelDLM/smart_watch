package androidx.core.util;

import Oox.Oxx0xo;
import Oox.oOoXoXO;
import Oox.x0xO0oo;
import android.util.LruCache;
import kotlin.oXIO0o0XI;

/* loaded from: classes.dex */
public final class LruCacheKt {
    @OXOo.OOXIXo
    public static final <K, V> LruCache<K, V> lruCache(int i, @OXOo.OOXIXo x0xO0oo<? super K, ? super V, Integer> x0xo0oo, @OXOo.OOXIXo oOoXoXO<? super K, ? extends V> oooxoxo, @OXOo.OOXIXo Oxx0xo<? super Boolean, ? super K, ? super V, ? super V, oXIO0o0XI> oxx0xo) {
        return new LruCacheKt$lruCache$4(i, x0xo0oo, oooxoxo, oxx0xo);
    }

    public static /* synthetic */ LruCache lruCache$default(int i, x0xO0oo x0xo0oo, oOoXoXO oooxoxo, Oxx0xo oxx0xo, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            x0xo0oo = new x0xO0oo<Object, Object, Integer>() { // from class: androidx.core.util.LruCacheKt$lruCache$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.x0xO0oo
                @OXOo.OOXIXo
                public final Integer invoke(@OXOo.OOXIXo Object obj2, @OXOo.OOXIXo Object obj3) {
                    return 1;
                }
            };
        }
        if ((i2 & 4) != 0) {
            oooxoxo = new oOoXoXO<Object, Object>() { // from class: androidx.core.util.LruCacheKt$lruCache$2
                @Override // Oox.oOoXoXO
                @OXOo.oOoXoXO
                public final Object invoke(@OXOo.OOXIXo Object obj2) {
                    return null;
                }
            };
        }
        if ((i2 & 8) != 0) {
            oxx0xo = new Oxx0xo<Boolean, Object, Object, Object, oXIO0o0XI>() { // from class: androidx.core.util.LruCacheKt$lruCache$3
                public final void invoke(boolean z, @OXOo.OOXIXo Object obj2, @OXOo.OOXIXo Object obj3, @OXOo.oOoXoXO Object obj4) {
                }

                @Override // Oox.Oxx0xo
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool, Object obj2, Object obj3, Object obj4) {
                    invoke(bool.booleanValue(), obj2, obj3, obj4);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        return new LruCacheKt$lruCache$4(i, x0xo0oo, oooxoxo, oxx0xo);
    }
}
