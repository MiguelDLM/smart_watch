package kotlin.collections;

import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX WARN: Incorrect field signature: TK; */
@kotlin.jvm.internal.XX({"SMAP\nCollections.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collections.kt\nkotlin/collections/CollectionsKt__CollectionsKt$binarySearchBy$1\n*L\n1#1,522:1\n*E\n"})
/* loaded from: classes6.dex */
public final class CollectionsKt__CollectionsKt$binarySearchBy$1<T> extends Lambda implements Oox.oOoXoXO<T, Integer> {
    final /* synthetic */ Comparable $key;
    final /* synthetic */ Oox.oOoXoXO<T, K> $selector;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Incorrect types in method signature: (LOox/oOoXoXO<-TT;+TK;>;TK;)V */
    public CollectionsKt__CollectionsKt$binarySearchBy$1(Oox.oOoXoXO oooxoxo, Comparable comparable) {
        super(1);
        this.$selector = oooxoxo;
        this.$key = comparable;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // Oox.oOoXoXO
    @OXOo.OOXIXo
    public final Integer invoke(T t) {
        return Integer.valueOf(xX0ox.Oxx0IOOO.oOoXoXO((Comparable) this.$selector.invoke(t), this.$key));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // Oox.oOoXoXO
    public /* bridge */ /* synthetic */ Integer invoke(Object obj) {
        return invoke((CollectionsKt__CollectionsKt$binarySearchBy$1<T>) obj);
    }
}
