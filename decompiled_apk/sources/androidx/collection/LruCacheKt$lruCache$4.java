package androidx.collection;

import OXOo.OOXIXo;
import Oox.Oxx0xo;
import Oox.oOoXoXO;
import Oox.x0xO0oo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

/* JADX INFO: Add missing generic type declarations: [V, K] */
@XX({"SMAP\nLruCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LruCache.kt\nandroidx/collection/LruCacheKt$lruCache$4\n*L\n1#1,355:1\n*E\n"})
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

    @Override // androidx.collection.LruCache
    @OXOo.oOoXoXO
    public V create(@OOXIXo K key) {
        IIX0o.x0xO0oo(key, "key");
        return this.$create.invoke(key);
    }

    @Override // androidx.collection.LruCache
    public void entryRemoved(boolean z, @OOXIXo K key, @OOXIXo V oldValue, @OXOo.oOoXoXO V v) {
        IIX0o.x0xO0oo(key, "key");
        IIX0o.x0xO0oo(oldValue, "oldValue");
        this.$onEntryRemoved.invoke(Boolean.valueOf(z), key, oldValue, v);
    }

    @Override // androidx.collection.LruCache
    public int sizeOf(@OOXIXo K key, @OOXIXo V value) {
        IIX0o.x0xO0oo(key, "key");
        IIX0o.x0xO0oo(value, "value");
        return this.$sizeOf.invoke(key, value).intValue();
    }
}
