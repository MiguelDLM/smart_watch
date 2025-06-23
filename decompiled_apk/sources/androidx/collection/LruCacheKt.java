package androidx.collection;

import OXOo.OOXIXo;
import Oox.Oxx0xo;
import Oox.oOoXoXO;
import Oox.x0xO0oo;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes.dex */
public final class LruCacheKt {
    @OOXIXo
    public static final <K, V> LruCache<K, V> lruCache(int i, @OOXIXo x0xO0oo<? super K, ? super V, Integer> sizeOf, @OOXIXo oOoXoXO<? super K, ? extends V> create, @OOXIXo Oxx0xo<? super Boolean, ? super K, ? super V, ? super V, oXIO0o0XI> onEntryRemoved) {
        IIX0o.x0xO0oo(sizeOf, "sizeOf");
        IIX0o.x0xO0oo(create, "create");
        IIX0o.x0xO0oo(onEntryRemoved, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(i, sizeOf, create, onEntryRemoved);
    }

    public static /* synthetic */ LruCache lruCache$default(int i, x0xO0oo sizeOf, oOoXoXO create, Oxx0xo onEntryRemoved, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            sizeOf = new x0xO0oo<Object, Object, Integer>() { // from class: androidx.collection.LruCacheKt$lruCache$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.x0xO0oo
                @OOXIXo
                public final Integer invoke(@OOXIXo Object obj2, @OOXIXo Object obj3) {
                    IIX0o.x0xO0oo(obj2, "<anonymous parameter 0>");
                    IIX0o.x0xO0oo(obj3, "<anonymous parameter 1>");
                    return 1;
                }
            };
        }
        if ((i2 & 4) != 0) {
            create = new oOoXoXO<Object, Object>() { // from class: androidx.collection.LruCacheKt$lruCache$2
                @Override // Oox.oOoXoXO
                @OXOo.oOoXoXO
                public final Object invoke(@OOXIXo Object it) {
                    IIX0o.x0xO0oo(it, "it");
                    return null;
                }
            };
        }
        if ((i2 & 8) != 0) {
            onEntryRemoved = new Oxx0xo<Boolean, Object, Object, Object, oXIO0o0XI>() { // from class: androidx.collection.LruCacheKt$lruCache$3
                public final void invoke(boolean z, @OOXIXo Object obj2, @OOXIXo Object obj3, @OXOo.oOoXoXO Object obj4) {
                    IIX0o.x0xO0oo(obj2, "<anonymous parameter 1>");
                    IIX0o.x0xO0oo(obj3, "<anonymous parameter 2>");
                }

                @Override // Oox.Oxx0xo
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool, Object obj2, Object obj3, Object obj4) {
                    invoke(bool.booleanValue(), obj2, obj3, obj4);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        IIX0o.x0xO0oo(sizeOf, "sizeOf");
        IIX0o.x0xO0oo(create, "create");
        IIX0o.x0xO0oo(onEntryRemoved, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(i, sizeOf, create, onEntryRemoved);
    }
}
