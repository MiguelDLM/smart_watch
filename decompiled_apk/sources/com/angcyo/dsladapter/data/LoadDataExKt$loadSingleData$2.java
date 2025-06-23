package com.angcyo.dsladapter.data;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import Oox.x0xO0oo;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nLoadDataEx.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LoadDataEx.kt\ncom/angcyo/dsladapter/data/LoadDataExKt$loadSingleData$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,153:1\n1855#2,2:154\n1864#2,3:156\n*S KotlinDebug\n*F\n+ 1 LoadDataEx.kt\ncom/angcyo/dsladapter/data/LoadDataExKt$loadSingleData$2\n*L\n33#1:154,2\n50#1:156,3\n*E\n"})
/* loaded from: classes7.dex */
public final class LoadDataExKt$loadSingleData$2 extends Lambda implements oOoXoXO<List<DslAdapterItem>, oXIO0o0XI> {
    final /* synthetic */ List<Object> $dataList;
    final /* synthetic */ x0xO0oo<Item, Object, Item> $initOrCreateDslItem;
    final /* synthetic */ int $page;
    final /* synthetic */ int $pageSize;
    final /* synthetic */ DslAdapter $this_loadSingleData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LoadDataExKt$loadSingleData$2(List<? extends Object> list, int i, x0xO0oo<? super Item, Object, ? extends Item> x0xo0oo, DslAdapter dslAdapter, int i2) {
        super(1);
        this.$dataList = list;
        this.$page = i;
        this.$initOrCreateDslItem = x0xo0oo;
        this.$this_loadSingleData = dslAdapter;
        this.$pageSize = i2;
    }

    @Override // Oox.oOoXoXO
    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(List<DslAdapterItem> list) {
        invoke2(list);
        return oXIO0o0XI.f29392oIX0oI;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@OOXIXo List<DslAdapterItem> it) {
        int max;
        int max2;
        IIX0o.x0xO0oo(it, "it");
        ArrayList arrayList = new ArrayList();
        for (DslAdapterItem dslAdapterItem : it) {
            IIX0o.OxI(3, "Item");
            if (!(dslAdapterItem instanceof DslAdapterItem)) {
                arrayList.add(dslAdapterItem);
            }
        }
        it.removeAll(arrayList);
        List<Object> list = this.$dataList;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        if (this.$page <= Page.Companion.oIX0oI()) {
            if (it.size() > list.size() && (max2 = Math.max(list.size(), 0)) <= (max = Math.max(CollectionsKt__CollectionsKt.oo0xXOI0I(it), 0))) {
                while (true) {
                    it.remove(max);
                    if (max == max2) {
                        break;
                    } else {
                        max--;
                    }
                }
            }
            x0xO0oo<Item, Object, Item> x0xo0oo = this.$initOrCreateDslItem;
            int i = 0;
            for (Object obj : it) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.XoX();
                }
                DslAdapterItem dslAdapterItem2 = (DslAdapterItem) obj;
                Object obj2 = list.get(i);
                dslAdapterItem2.setItemUpdateFlag(!IIX0o.Oxx0IOOO(dslAdapterItem2.getItemData(), obj2));
                dslAdapterItem2.setItemData(obj2);
                IIX0o.OxI(1, "Item");
                x0xo0oo.invoke(dslAdapterItem2, obj2);
                i = i2;
            }
            if (list.size() > it.size()) {
                int size = list.size();
                for (int size2 = it.size(); size2 < size; size2++) {
                    Object obj3 = list.get(size2);
                    DslAdapterItem dslAdapterItem3 = (DslAdapterItem) this.$initOrCreateDslItem.invoke(null, obj3);
                    dslAdapterItem3.setItemData(obj3);
                    it.add(dslAdapterItem3);
                }
            }
            if (it.isEmpty() && this.$this_loadSingleData.getHeaderItems().isEmpty() && this.$this_loadSingleData.getFooterItems().isEmpty()) {
                DslAdapter.setAdapterStatus$default(this.$this_loadSingleData, 1, null, 2, null);
                return;
            }
            DslAdapter.setAdapterStatus$default(this.$this_loadSingleData, 0, null, 2, null);
            if (this.$this_loadSingleData.getDslLoadMoreItem().getItemStateEnable()) {
                if (it.size() < this.$pageSize) {
                    DslAdapter.setLoadMore$default(this.$this_loadSingleData, 2, null, false, 6, null);
                    return;
                } else {
                    DslAdapter.setLoadMore$default(this.$this_loadSingleData, 0, null, false, 6, null);
                    return;
                }
            }
            return;
        }
        for (Object obj4 : list) {
            DslAdapterItem dslAdapterItem4 = (DslAdapterItem) this.$initOrCreateDslItem.invoke(null, obj4);
            dslAdapterItem4.setItemData(obj4);
            it.add(dslAdapterItem4);
        }
        DslAdapter.setAdapterStatus$default(this.$this_loadSingleData, 0, null, 2, null);
        if (this.$this_loadSingleData.getDslLoadMoreItem().getItemStateEnable()) {
            if (list.size() < this.$pageSize) {
                DslAdapter.setLoadMore$default(this.$this_loadSingleData, 2, null, false, 6, null);
            } else {
                DslAdapter.setLoadMore$default(this.$this_loadSingleData, 0, null, false, 6, null);
            }
        }
    }
}
