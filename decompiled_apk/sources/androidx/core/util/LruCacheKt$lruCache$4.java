package androidx.core.util;

import Oox.Oxx0xo;
import Oox.oOoXoXO;
import Oox.x0xO0oo;
import android.util.LruCache;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

/* JADX INFO: Add missing generic type declarations: [V, K] */
@XX({"SMAP\nLruCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LruCache.kt\nandroidx/core/util/LruCacheKt$lruCache$4\n*L\n1#1,54:1\n*E\n"})
/* loaded from: classes.dex */
public final class LruCacheKt$lruCache$4<K, V> extends LruCache<K, V> {
    final /* synthetic */ oOoXoXO<K, V> $create;
    final /* synthetic */ Oxx0xo<Boolean, K, V, V, oXIO0o0XI> $onEntryRemoved;
    final /* synthetic */ x0xO0oo<K, V, Integer> $sizeOf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LruCacheKt$lruCache$4(int i, x0xO0oo<? super K, ? super V, Integer> x0xo0oo, oOoXoXO<? super K, ? extends V> oooxoxo, Oxx0xo<? super Boolean, ? super K, ? super V, ? super V, oXIO0o0XI> oxx0xo) {
        super(i);
        this.$sizeOf = x0xo0oo;
        this.$create = oooxoxo;
        this.$onEntryRemoved = oxx0xo;
    }

    @Override // android.util.LruCache
    @OXOo.oOoXoXO
    public V create(@OXOo.OOXIXo K k) {
        return this.$create.invoke(k);
    }

    @Override // android.util.LruCache
    public void entryRemoved(boolean z, @OXOo.OOXIXo K k, @OXOo.OOXIXo V v, @OXOo.oOoXoXO V v2) {
        this.$onEntryRemoved.invoke(Boolean.valueOf(z), k, v, v2);
    }

    @Override // android.util.LruCache
    public int sizeOf(@OXOo.OOXIXo K k, @OXOo.OOXIXo V v) {
        return this.$sizeOf.invoke(k, v).intValue();
    }
}
