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

@XX({"SMAP\nLoadDataEx.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LoadDataEx.kt\ncom/angcyo/dsladapter/data/LoadDataExKt$loadSingleData$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 LoadDataEx.kt\ncom/angcyo/dsladapter/data/LoadDataExKt\n*L\n1#1,153:1\n1855#2,2:154\n1864#2,2:156\n1866#2:161\n114#3,3:158\n*S KotlinDebug\n*F\n+ 1 LoadDataEx.kt\ncom/angcyo/dsladapter/data/LoadDataExKt$loadSingleData$2\n*L\n33#1:154,2\n50#1:156,2\n50#1:161\n*E\n"})
/* loaded from: classes7.dex */
public final class LoadDataExKt$loadSingleData2$$inlined$loadSingleData$1 extends Lambda implements oOoXoXO<List<DslAdapterItem>, oXIO0o0XI> {
    final /* synthetic */ List $dataList;
    final /* synthetic */ x0xO0oo $initItem$inlined;
    final /* synthetic */ int $page;
    final /* synthetic */ int $pageSize;
    final /* synthetic */ DslAdapter $this_loadSingleData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadDataExKt$loadSingleData2$$inlined$loadSingleData$1(List list, int i, DslAdapter dslAdapter, int i2, x0xO0oo x0xo0oo) {
        super(1);
        this.$dataList = list;
        this.$page = i;
        this.$this_loadSingleData = dslAdapter;
        this.$pageSize = i2;
        this.$initItem$inlined = x0xo0oo;
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
        List list = this.$dataList;
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
            int i = 0;
            for (Object obj : it) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.XoX();
                }
                DslAdapterItem loadSingleData2$lambda$3$lambda$2 = (DslAdapterItem) obj;
                Object obj2 = list.get(i);
                loadSingleData2$lambda$3$lambda$2.setItemUpdateFlag(!IIX0o.Oxx0IOOO(loadSingleData2$lambda$3$lambda$2.getItemData(), obj2));
                loadSingleData2$lambda$3$lambda$2.setItemData(obj2);
                IIX0o.OxI(1, "Item");
                x0xO0oo x0xo0oo = this.$initItem$inlined;
                IIX0o.oO(loadSingleData2$lambda$3$lambda$2, "loadSingleData2$lambda$3$lambda$2");
                x0xo0oo.invoke(loadSingleData2$lambda$3$lambda$2, obj2);
                IIX0o.oO(loadSingleData2$lambda$3$lambda$2, "oldItem ?: Item::class.j… initItem(data)\n        }");
                i = i2;
            }
            if (list.size() > it.size()) {
                int size = list.size();
                for (int size2 = it.size(); size2 < size; size2++) {
                    Object obj3 = list.get(size2);
                    IIX0o.OxI(4, "Item");
                    DslAdapterItem loadSingleData2$lambda$3$lambda$22 = (DslAdapterItem) DslAdapterItem.class.newInstance();
                    x0xO0oo x0xo0oo2 = this.$initItem$inlined;
                    IIX0o.oO(loadSingleData2$lambda$3$lambda$22, "loadSingleData2$lambda$3$lambda$2");
                    x0xo0oo2.invoke(loadSingleData2$lambda$3$lambda$22, obj3);
                    IIX0o.oO(loadSingleData2$lambda$3$lambda$22, "oldItem ?: Item::class.j… initItem(data)\n        }");
                    loadSingleData2$lambda$3$lambda$22.setItemData(obj3);
                    it.add(loadSingleData2$lambda$3$lambda$22);
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
            IIX0o.OxI(4, "Item");
            DslAdapterItem loadSingleData2$lambda$3$lambda$23 = (DslAdapterItem) DslAdapterItem.class.newInstance();
            x0xO0oo x0xo0oo3 = this.$initItem$inlined;
            IIX0o.oO(loadSingleData2$lambda$3$lambda$23, "loadSingleData2$lambda$3$lambda$2");
            x0xo0oo3.invoke(loadSingleData2$lambda$3$lambda$23, obj4);
            IIX0o.oO(loadSingleData2$lambda$3$lambda$23, "oldItem ?: Item::class.j… initItem(data)\n        }");
            loadSingleData2$lambda$3$lambda$23.setItemData(obj4);
            it.add(loadSingleData2$lambda$3$lambda$23);
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
