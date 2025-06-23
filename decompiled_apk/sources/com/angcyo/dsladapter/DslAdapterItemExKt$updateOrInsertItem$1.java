package com.angcyo.dsladapter;

import androidx.core.math.MathUtils;
import java.util.List;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nDslAdapterItemEx.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DslAdapterItemEx.kt\ncom/angcyo/dsladapter/DslAdapterItemExKt$updateOrInsertItem$1\n+ 2 DslAdapterItemEx.kt\ncom/angcyo/dsladapter/DslAdapterItemExKt\n*L\n1#1,716:1\n654#2,40:717\n*S KotlinDebug\n*F\n+ 1 DslAdapterItemEx.kt\ncom/angcyo/dsladapter/DslAdapterItemExKt$updateOrInsertItem$1\n*L\n620#1:717,40\n*E\n"})
/* loaded from: classes7.dex */
public final class DslAdapterItemExKt$updateOrInsertItem$1 extends Lambda implements Oox.oOoXoXO<List<DslAdapterItem>, oXIO0o0XI> {
    final /* synthetic */ int $insertIndex;
    final /* synthetic */ String $itemTag;
    final /* synthetic */ DslAdapter $this_updateOrInsertItem;
    final /* synthetic */ Oox.oOoXoXO<Item, Item> $updateOrCreateItem;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DslAdapterItemExKt$updateOrInsertItem$1(DslAdapter dslAdapter, String str, int i, Oox.oOoXoXO<? super Item, ? extends Item> oooxoxo) {
        super(1);
        this.$this_updateOrInsertItem = dslAdapter;
        this.$itemTag = str;
        this.$insertIndex = i;
        this.$updateOrCreateItem = oooxoxo;
    }

    @Override // Oox.oOoXoXO
    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(List<DslAdapterItem> list) {
        invoke2(list);
        return oXIO0o0XI.f29392oIX0oI;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@OXOo.OOXIXo List<DslAdapterItem> it) {
        DslAdapterItem dslAdapterItem;
        kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
        DslAdapter dslAdapter = this.$this_updateOrInsertItem;
        String str = this.$itemTag;
        int i = this.$insertIndex;
        Oox.oOoXoXO<Item, Item> oooxoxo = this.$updateOrCreateItem;
        DslAdapterItem x0o2 = DslAdapterExKt.x0o(dslAdapter, str, false);
        if (x0o2 != null) {
            kotlin.jvm.internal.IIX0o.OxI(3, "Item");
            dslAdapterItem = x0o2;
        } else {
            kotlin.jvm.internal.IIX0o.OxI(4, "Item");
            Object newInstance = DslAdapterItem.class.newInstance();
            kotlin.jvm.internal.IIX0o.oO(newInstance, "{\n        Item::class.java.newInstance()\n    }");
            dslAdapterItem = (DslAdapterItem) newInstance;
        }
        DslAdapterItem dslAdapterItem2 = (DslAdapterItem) oooxoxo.invoke(dslAdapterItem);
        if (dslAdapterItem2 != null) {
            dslAdapterItem2.setItemTag(str);
        }
        if (x0o2 == null && dslAdapterItem2 == null) {
            return;
        }
        List<DslAdapterItem> list = it;
        if (dslAdapterItem2 == null) {
            if (x0o2 != null) {
                list.remove(x0o2);
            }
        } else {
            if (x0o2 == null) {
                list.add(MathUtils.clamp(i, 0, list.size()), dslAdapterItem2);
                return;
            }
            x0o2.setItemChanging(true);
            int indexOf = list.indexOf(x0o2);
            if (indexOf != -1) {
                list.set(indexOf, dslAdapterItem2);
            }
        }
    }
}
