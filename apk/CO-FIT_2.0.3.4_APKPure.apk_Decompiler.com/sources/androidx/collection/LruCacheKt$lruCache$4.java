package androidx.collection;

import OXOo.OOXIXo;
import Oox.Oxx0xo;
import Oox.oOoXoXO;
import Oox.x0xO0oo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nLruCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LruCache.kt\nandroidx/collection/LruCacheKt$lruCache$4\n*L\n1#1,355:1\n*E\n"})
public final class LruCacheKt$lruCache$4 extends LruCache<K, V> {
    final /* synthetic */ oOoXoXO<K, V> $create;
    final /* synthetic */ Oxx0xo<Boolean, K, V, V, oXIO0o0XI> $onEntryRemoved;
    final /* synthetic */ x0xO0oo<K, V, Integer> $sizeOf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LruCacheKt$lruCache$4(int i, x0xO0oo<? super K, ? super V, Integer> x0xo0oo, oOoXoXO<? super K, ? extends V> oooxoxo, Oxx0xo<? super Boolean, ? super K, ? super V, ? super V, oXIO0o0XI> oxx0xo) {
        super(i);
        this.$sizeOf = x0xo0oo;
        this.$create = oooxoxo;
        this.$onEntryRemoved = oxx0xo;
    }

    @OXOo.oOoXoXO
    public V create(@OOXIXo K k) {
        IIX0o.x0xO0oo(k, "key");
        return this.$create.invoke(k);
    }

    public void entryRemoved(boolean z, @OOXIXo K k, @OOXIXo V v, @OXOo.oOoXoXO V v2) {
        IIX0o.x0xO0oo(k, "key");
        IIX0o.x0xO0oo(v, "oldValue");
        this.$onEntryRemoved.invoke(Boolean.valueOf(z), k, v, v2);
    }

    public int sizeOf(@OOXIXo K k, @OOXIXo V v) {
        IIX0o.x0xO0oo(k, "key");
        IIX0o.x0xO0oo(v, "value");
        return this.$sizeOf.invoke(k, v).intValue();
    }
}
