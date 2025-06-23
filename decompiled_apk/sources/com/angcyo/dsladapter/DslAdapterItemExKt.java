package com.angcyo.dsladapter;

import androidx.annotation.LayoutRes;
import androidx.core.math.MathUtils;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.angcyo.dsladapter.data.Page;
import com.angcyo.dsladapter.data.UpdateDataConfig;
import com.angcyo.dsladapter.data.UpdateDataConfigKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.XoX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nDslAdapterItemEx.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DslAdapterItemEx.kt\ncom/angcyo/dsladapter/DslAdapterItemExKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,716:1\n1864#2,3:717\n766#2:720\n857#2,2:721\n1#3:723\n*S KotlinDebug\n*F\n+ 1 DslAdapterItemEx.kt\ncom/angcyo/dsladapter/DslAdapterItemExKt\n*L\n67#1:717,3\n342#1:720\n342#1:721,2\n*E\n"})
/* loaded from: classes7.dex */
public final class DslAdapterItemExKt {
    @OXOo.OOXIXo
    public static final List<DslAdapterItem> I0(@OXOo.OOXIXo List<? extends Object> list, @OXOo.OOXIXo final Class<? extends DslAdapterItem> dslItem, @LayoutRes final int i, @OXOo.OOXIXo final Oox.oOoXoXO<? super DslAdapterItem, oXIO0o0XI> config) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslItem, "dslItem");
        kotlin.jvm.internal.IIX0o.x0xO0oo(config, "config");
        return xoO0xx0(list, null, new Oox.x0xO0oo<Integer, Object, DslAdapterItem>() { // from class: com.angcyo.dsladapter.DslAdapterItemExKt$toDslItemList$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ DslAdapterItem invoke(Integer num, Object obj) {
                return invoke(num.intValue(), obj);
            }

            @OXOo.OOXIXo
            public final DslAdapterItem invoke(int i2, @OXOo.OOXIXo Object item) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
                DslAdapterItem newInstance = dslItem.newInstance();
                int i3 = i;
                Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI> oooxoxo = config;
                DslAdapterItem invoke$lambda$0 = newInstance;
                if (i3 != -1) {
                    invoke$lambda$0.setItemLayoutId(i3);
                }
                kotlin.jvm.internal.IIX0o.oO(invoke$lambda$0, "invoke$lambda$0");
                oooxoxo.invoke(invoke$lambda$0);
                kotlin.jvm.internal.IIX0o.oO(newInstance, "dslItem.newInstance().ap…       config()\n        }");
                return invoke$lambda$0;
            }
        }, null, 5, null);
    }

    @OXOo.oOoXoXO
    public static final DslAdapterItem I0Io(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo DslAdapter adapter, boolean z, final int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(adapter, "adapter");
        return oxoX(dslAdapterItem, adapter, z, new Oox.x0xO0oo<DslAdapterItem, Integer, Boolean>() { // from class: com.angcyo.dsladapter.DslAdapterItemExKt$afterItem$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ Boolean invoke(DslAdapterItem dslAdapterItem2, Integer num) {
                return invoke(dslAdapterItem2, num.intValue());
            }

            @OXOo.OOXIXo
            public final Boolean invoke(@OXOo.OOXIXo DslAdapterItem item, int i2) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
                return Boolean.valueOf(i == i2);
            }
        });
    }

    public static /* synthetic */ void I0X0x0oIo(DslAdapter dslAdapter, String str, DslAdapterItem dslAdapterItem, int i, Object obj) {
        if ((i & 2) != 0) {
            dslAdapterItem = null;
        }
        XX0(dslAdapter, str, dslAdapterItem);
    }

    @OXOo.OOXIXo
    public static final List<DslAdapterItem> I0oOIX(@OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapter, oXIO0o0XI> render) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(render, "render");
        DslAdapter dslAdapter = new DslAdapter(null, 1, null);
        dslAdapter.setDslDataFilter(null);
        render.invoke(dslAdapter);
        return dslAdapter.getAdapterItems();
    }

    public static final void I0oOoX(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        oxxXoxO(dslAdapterItem, i, i);
    }

    @OXOo.oOoXoXO
    public static final DslAdapterItem II0XooXoX(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo DslAdapter adapter, boolean z, @OXOo.OOXIXo Oox.x0xO0oo<? super DslAdapterItem, ? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(adapter, "adapter");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        List<DslAdapterItem> dataList = adapter.getDataList(z);
        boolean z2 = false;
        int i = -1;
        for (int oo0xXOI0I2 = CollectionsKt__CollectionsKt.oo0xXOI0I(dataList); -1 < oo0xXOI0I2; oo0xXOI0I2--) {
            DslAdapterItem dslAdapterItem2 = dataList.get(oo0xXOI0I2);
            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(dslAdapterItem, dslAdapterItem2)) {
                z2 = true;
                i = oo0xXOI0I2;
            } else if (z2 && predicate.invoke(dslAdapterItem2, Integer.valueOf(i - oo0xXOI0I2)).booleanValue()) {
                return dslAdapterItem2;
            }
        }
        return null;
    }

    public static /* synthetic */ void II0xO0(DslAdapter dslAdapter, List itemList, String str, int i, Oox.oOoXoXO updateOrCreateItem, int i2, Object obj) {
        DslAdapterItem dslAdapterItem;
        if ((i2 & 4) != 0) {
            i = 0;
        }
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemList, "itemList");
        kotlin.jvm.internal.IIX0o.x0xO0oo(updateOrCreateItem, "updateOrCreateItem");
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
        DslAdapterItem dslAdapterItem2 = (DslAdapterItem) updateOrCreateItem.invoke(dslAdapterItem);
        if (dslAdapterItem2 != null) {
            dslAdapterItem2.setItemTag(str);
        }
        if (x0o2 == null && dslAdapterItem2 == null) {
            return;
        }
        List list = itemList;
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

    public static final /* synthetic */ <Item extends DslAdapterItem> void IIX0(DslAdapter dslAdapter, String str, int i, Oox.oOoXoXO<? super Item, ? extends Item> updateOrCreateItem) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(updateOrCreateItem, "updateOrCreateItem");
        kotlin.jvm.internal.IIX0o.xoXoI();
        DslAdapter.changeDataItems$default(dslAdapter, false, null, new DslAdapterItemExKt$updateOrInsertItem$1(dslAdapter, str, i, updateOrCreateItem), 3, null);
    }

    public static final boolean IIX0o(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.oOoXoXO DslAdapter dslAdapter, boolean z) {
        List<DslAdapterItem> list;
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        if (dslAdapter == null) {
            dslAdapter = dslAdapterItem.getItemDslAdapter();
        }
        if (dslAdapter != null) {
            list = dslAdapter.getDataList(z);
        } else {
            list = null;
        }
        if (list == null || list.indexOf(dslAdapterItem) != CollectionsKt__CollectionsKt.oo0xXOI0I(list)) {
            return false;
        }
        return true;
    }

    public static final void IIXOooo(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, int i, int i2, int i3) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        dslAdapterItem.setItemLeftOffset(i);
        dslAdapterItem.setItemRightOffset(0);
        dslAdapterItem.setItemTopInsert(i2);
        dslAdapterItem.setItemBottomInsert(0);
        dslAdapterItem.setOnlyDrawOffsetArea(true);
        dslAdapterItem.setItemDecorationColor(i3);
    }

    @OXOo.OOXIXo
    public static final List<DslAdapterItem> IIxOXoOo0(@OXOo.OOXIXo List<? extends Object> list, @OXOo.OOXIXo Oox.IXxxXO<? super List<DslAdapterItem>, ? super Integer, Object, oXIO0o0XI> itemBefore, @OXOo.OOXIXo final Oox.x0xO0oo<? super Integer, Object, ? extends DslAdapterItem> itemFactory, @OXOo.OOXIXo Oox.IXxxXO<? super List<DslAdapterItem>, ? super Integer, Object, oXIO0o0XI> itemAfter) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemBefore, "itemBefore");
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemFactory, "itemFactory");
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemAfter, "itemAfter");
        return ox(list, itemBefore, new Oox.x0xO0oo<Integer, Object, DslAdapterItem>() { // from class: com.angcyo.dsladapter.DslAdapterItemExKt$toDslItemList$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ DslAdapterItem invoke(Integer num, Object obj) {
                return invoke(num.intValue(), obj);
            }

            @OXOo.OOXIXo
            public final DslAdapterItem invoke(int i, @OXOo.OOXIXo Object any) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(any, "any");
                DslAdapterItem invoke = itemFactory.invoke(Integer.valueOf(i), any);
                invoke.setItemData(any);
                return invoke;
            }
        }, itemAfter);
    }

    public static /* synthetic */ void IO(DslAdapterItem dslAdapterItem, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        X00IoxXI(dslAdapterItem, i, i2);
    }

    public static /* synthetic */ void IXxxXO(DslAdapterItem dslAdapterItem, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = -1;
        }
        Oo(dslAdapterItem, i, i2, i3);
    }

    public static final void Io(@OXOo.OOXIXo DslAdapterItem dslAdapterItem) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        dslAdapterItem.setItemLeftOffset(0);
        dslAdapterItem.setItemTopOffset(0);
        dslAdapterItem.setItemRightOffset(0);
        dslAdapterItem.setItemBottomOffset(0);
        dslAdapterItem.setItemLeftInsert(0);
        dslAdapterItem.setItemTopInsert(0);
        dslAdapterItem.setItemRightInsert(0);
        dslAdapterItem.setItemBottomInsert(0);
        dslAdapterItem.setOnlyDrawOffsetArea(false);
        dslAdapterItem.setItemDecorationColor(0);
    }

    public static /* synthetic */ int IoOoX(DslAdapterItem dslAdapterItem, DslAdapter dslAdapter, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            dslAdapter = null;
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return oo(dslAdapterItem, dslAdapter, z);
    }

    public static /* synthetic */ boolean IoOoo(DslAdapterItem dslAdapterItem, DslAdapterItem dslAdapterItem2, DslAdapter dslAdapter, int i, Object obj) {
        if ((i & 2) != 0) {
            dslAdapter = null;
        }
        return OO(dslAdapterItem, dslAdapterItem2, dslAdapter);
    }

    public static /* synthetic */ void Ioxxx(DslAdapterItem dslAdapterItem, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        XIo0oOXIx(dslAdapterItem, i, i2, i3);
    }

    public static /* synthetic */ void O00XxXI(DslAdapterItem dslAdapterItem, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        o0xxxXXxX(dslAdapterItem, i, i2, i3);
    }

    public static /* synthetic */ void O0X(DslAdapter dslAdapter, String str, int i, Oox.oOoXoXO updateOrCreateItem, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(updateOrCreateItem, "updateOrCreateItem");
        kotlin.jvm.internal.IIX0o.xoXoI();
        DslAdapter.changeHeaderItems$default(dslAdapter, false, null, new DslAdapterItemExKt$updateOrInsertHeaderItem$1(dslAdapter, str, i, updateOrCreateItem), 3, null);
    }

    public static /* synthetic */ void O0Xx(DslAdapter dslAdapter, String str, DslAdapterItem dslAdapterItem, int i, Object obj) {
        if ((i & 2) != 0) {
            dslAdapterItem = null;
        }
        XoI0Ixx0(dslAdapter, str, dslAdapterItem);
    }

    @OXOo.oOoXoXO
    public static final String O0xOxO(@OXOo.OOXIXo DslAdapterItem dslAdapterItem) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        return (String) CollectionsKt___CollectionsKt.XxXX(dslAdapterItem.getItemGroups());
    }

    public static /* synthetic */ void OI0(DslAdapterItem dslAdapterItem, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = i;
        }
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        XOxIOxOx(dslAdapterItem, i, i2, i3);
    }

    public static final boolean OO(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.oOoXoXO DslAdapterItem dslAdapterItem2, @OXOo.oOoXoXO DslAdapter dslAdapter) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        if (dslAdapter == null) {
            dslAdapter = dslAdapterItem.getItemDslAdapter();
        }
        boolean z = false;
        if (dslAdapter != null) {
            boolean IIxOXoOo02 = LibExKt.IIxOXoOo0(dslAdapter.getHeaderItems(), dslAdapterItem, dslAdapterItem2);
            boolean IIxOXoOo03 = LibExKt.IIxOXoOo0(dslAdapter.getDataItems(), dslAdapterItem, dslAdapterItem2);
            boolean IIxOXoOo04 = LibExKt.IIxOXoOo0(dslAdapter.getFooterItems(), dslAdapterItem, dslAdapterItem2);
            if (IIxOXoOo02 || IIxOXoOo03 || IIxOXoOo04) {
                z = true;
            }
            if (z) {
                dslAdapter._updateAdapterItems();
                dslAdapter.notifyDataChanged();
            }
        }
        return z;
    }

    public static final void OO0x0xX(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.oOoXoXO String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        if (str == null) {
            dslAdapterItem.setItemGroups(CollectionsKt__CollectionsKt.ooXIXxIX());
            return;
        }
        if (!dslAdapterItem.getItemGroups().contains(str)) {
            List<String> itemGroups = dslAdapterItem.getItemGroups();
            if (XoX.xXxxox0I(itemGroups)) {
                itemGroups.add(str);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(itemGroups);
            arrayList.add(str);
            dslAdapterItem.setItemGroups(arrayList);
        }
    }

    public static final void OOXIXo(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, int i, int i2, int i3, int i4) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        dslAdapterItem.setItemLeftOffset(i2);
        dslAdapterItem.setItemRightOffset(i3);
        dslAdapterItem.setItemTopInsert(0);
        dslAdapterItem.setItemBottomInsert(i);
        dslAdapterItem.setOnlyDrawOffsetArea(false);
        dslAdapterItem.setItemDecorationColor(i4);
    }

    @OXOo.OOXIXo
    public static final List<DslAdapterItem> OOXIxO0(@OXOo.OOXIXo List<? extends Object> list, @LayoutRes int i, @OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapterItem, oXIO0o0XI> config) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(config, "config");
        return I0(list, DslAdapterItem.class, i, config);
    }

    public static /* synthetic */ List OX00O0xII(List list, Class cls, int i, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        if ((i2 & 4) != 0) {
            oooxoxo = new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterItemExKt$toDslItemList$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo DslAdapterItem dslAdapterItem) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "$this$null");
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                    invoke2(dslAdapterItem);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        return I0(list, cls, i, oooxoxo);
    }

    public static final void Oo(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, int i, int i2, int i3) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        dslAdapterItem.setItemLeftOffset(i);
        dslAdapterItem.setItemRightOffset(i);
        dslAdapterItem.setItemTopInsert(i2);
        dslAdapterItem.setItemBottomInsert(0);
        dslAdapterItem.setOnlyDrawOffsetArea(true);
        dslAdapterItem.setItemDecorationColor(i3);
    }

    public static final void Ox0O(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo Oox.oOoXoXO<? super UpdateDataConfig, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        UpdateDataConfig updateDataConfig = new UpdateDataConfig();
        updateDataConfig.Oxx0xo(Page.Companion.oIX0oI());
        updateDataConfig.oO(Integer.MAX_VALUE);
        updateDataConfig.oOoXoXO(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterItemExKt$updateSubItem$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo DslAdapter it) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter) {
                invoke2(dslAdapter);
                return oXIO0o0XI.f29392oIX0oI;
            }
        });
        updateDataConfig.OOXIXo(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterItemExKt$updateSubItem$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo DslAdapter it) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter) {
                invoke2(dslAdapter);
                return oXIO0o0XI.f29392oIX0oI;
            }
        });
        action.invoke(updateDataConfig);
        List<DslAdapterItem> oOoXoXO2 = UpdateDataConfigKt.oOoXoXO(updateDataConfig, dslAdapterItem.getItemSubList());
        dslAdapterItem.getItemSubList().clear();
        dslAdapterItem.getItemSubList().addAll(oOoXoXO2);
        dslAdapterItem.updateItemDepend(updateDataConfig.oxoX());
    }

    public static final void OxI(@OXOo.OOXIXo DslAdapterItem dslAdapterItem) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        dslAdapterItem.setItemSpanCount(-1);
    }

    @OXOo.oOoXoXO
    public static final DslAdapterItem Oxx0IOOO(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo DslAdapter adapter, boolean z, final int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(adapter, "adapter");
        return II0XooXoX(dslAdapterItem, adapter, z, new Oox.x0xO0oo<DslAdapterItem, Integer, Boolean>() { // from class: com.angcyo.dsladapter.DslAdapterItemExKt$beforeItem$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ Boolean invoke(DslAdapterItem dslAdapterItem2, Integer num) {
                return invoke(dslAdapterItem2, num.intValue());
            }

            @OXOo.OOXIXo
            public final Boolean invoke(@OXOo.OOXIXo DslAdapterItem item, int i2) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
                return Boolean.valueOf(i == i2);
            }
        });
    }

    public static final void Oxx0xo(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, int i, int i2, int i3, int i4) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        dslAdapterItem.setItemTopOffset(i2);
        dslAdapterItem.setItemBottomOffset(i3);
        dslAdapterItem.setItemRightInsert(i);
        dslAdapterItem.setItemLeftInsert(0);
        dslAdapterItem.setOnlyDrawOffsetArea(false);
        dslAdapterItem.setItemDecorationColor(i4);
    }

    public static final void OxxIIOOXO(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, int i, int i2, int i3, int i4) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        dslAdapterItem.setItemLeftOffset(i2);
        dslAdapterItem.setItemRightOffset(i3);
        dslAdapterItem.setItemTopInsert(i);
        dslAdapterItem.setItemBottomInsert(0);
        dslAdapterItem.setOnlyDrawOffsetArea(false);
        dslAdapterItem.setItemDecorationColor(i4);
    }

    public static final void X00IoxXI(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        dslAdapterItem.setItemLeftInsert(i);
        dslAdapterItem.setItemRightInsert(i);
        dslAdapterItem.setItemTopInsert(i);
        dslAdapterItem.setItemBottomInsert(i);
        dslAdapterItem.setItemLeftOffset(0);
        dslAdapterItem.setItemRightOffset(0);
        dslAdapterItem.setItemTopOffset(0);
        dslAdapterItem.setItemBottomOffset(0);
        dslAdapterItem.setOnlyDrawOffsetArea(false);
        dslAdapterItem.setItemDecorationColor(i2);
    }

    public static final boolean X0IIOO(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo String... group) {
        String str;
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(group, "group");
        int length = group.length;
        int i = 0;
        while (true) {
            if (i < length) {
                str = group[i];
                if (dslAdapterItem.getItemGroups().contains(str)) {
                    break;
                }
                i++;
            } else {
                str = null;
                break;
            }
        }
        if (str == null) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ DslAdapterItem X0o0xo(DslAdapterItem dslAdapterItem, DslAdapter dslAdapter, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        if ((i2 & 4) != 0) {
            i = 1;
        }
        return I0Io(dslAdapterItem, dslAdapter, z, i);
    }

    public static final boolean XI0IXoo(@OXOo.OOXIXo DslAdapterItem dslAdapterItem) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        if (!xxX(dslAdapterItem) && dslAdapterItem.getItemSpanCount() != -1) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ List XI0oooXX(List list, Oox.IXxxXO iXxxXO, Oox.x0xO0oo x0xo0oo, Oox.IXxxXO iXxxXO2, int i, Object obj) {
        if ((i & 1) != 0) {
            iXxxXO = new Oox.IXxxXO<List<Object>, Integer, Object, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterItemExKt$toAnyList$1
                public final void invoke(@OXOo.OOXIXo List<Object> list2, int i2, @OXOo.OOXIXo Object obj2) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(list2, "<anonymous parameter 0>");
                    kotlin.jvm.internal.IIX0o.x0xO0oo(obj2, "<anonymous parameter 2>");
                }

                @Override // Oox.IXxxXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(List<Object> list2, Integer num, Object obj2) {
                    invoke(list2, num.intValue(), obj2);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        if ((i & 4) != 0) {
            iXxxXO2 = new Oox.IXxxXO<List<Object>, Integer, Object, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterItemExKt$toAnyList$2
                public final void invoke(@OXOo.OOXIXo List<Object> list2, int i2, @OXOo.OOXIXo Object obj2) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(list2, "<anonymous parameter 0>");
                    kotlin.jvm.internal.IIX0o.x0xO0oo(obj2, "<anonymous parameter 2>");
                }

                @Override // Oox.IXxxXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(List<Object> list2, Integer num, Object obj2) {
                    invoke(list2, num.intValue(), obj2);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        return ox(list, iXxxXO, x0xo0oo, iXxxXO2);
    }

    public static final /* synthetic */ <Item extends DslAdapterItem> void XIXIX(DslAdapter dslAdapter, String str, int i, Oox.oOoXoXO<? super Item, ? extends Item> updateOrCreateItem) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(updateOrCreateItem, "updateOrCreateItem");
        kotlin.jvm.internal.IIX0o.xoXoI();
        DslAdapter.changeFooterItems$default(dslAdapter, false, null, new DslAdapterItemExKt$updateOrInsertFooterItem$1(dslAdapter, str, i, updateOrCreateItem), 3, null);
    }

    public static final void XIo0oOXIx(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, int i, int i2, int i3) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        dslAdapterItem.setItemLeftInsert(i);
        dslAdapterItem.setItemBottomOffset(i3);
        dslAdapterItem.setItemTopOffset(i2);
    }

    public static final boolean XIxXXX0x0(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.oOoXoXO DslAdapterItem dslAdapterItem2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        if (dslAdapterItem2 == null) {
            return false;
        }
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(dslAdapterItem, dslAdapterItem2)) {
            return true;
        }
        return dslAdapterItem.isItemInGroups().invoke(dslAdapterItem2).booleanValue();
    }

    public static /* synthetic */ DslAdapterItem XO(DslAdapterItem dslAdapterItem, DslAdapter dslAdapter, boolean z, Oox.x0xO0oo x0xo0oo, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return oxoX(dslAdapterItem, dslAdapter, z, x0xo0oo);
    }

    public static final void XOxIOxOx(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, int i, int i2, int i3) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        dslAdapterItem.setItemLeftOffset(0);
        dslAdapterItem.setItemRightOffset(0);
        dslAdapterItem.setItemTopInsert(i);
        dslAdapterItem.setItemBottomInsert(i2);
        dslAdapterItem.setOnlyDrawOffsetArea(false);
        dslAdapterItem.setItemDecorationColor(i3);
    }

    public static final void XX(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        dslAdapterItem.setItemPaddingLeft(i);
        dslAdapterItem.setItemPaddingTop(i);
        dslAdapterItem.setItemPaddingRight(i);
        dslAdapterItem.setItemPaddingBottom(i);
    }

    public static final void XX0(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO final DslAdapterItem dslAdapterItem) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        if (dslAdapterItem == null) {
            dslAdapterItem = DslAdapterExKt.x0o(dslAdapter, str, false);
        }
        if (dslAdapterItem == null) {
            L.f5267oIX0oI.oo0xXOI0I("移除的目标不存在");
        } else {
            DslAdapter.changeHeaderItems$default(dslAdapter, false, null, new Oox.oOoXoXO<List<DslAdapterItem>, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterItemExKt$removeHeaderItem$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(List<DslAdapterItem> list) {
                    invoke2(list);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo List<DslAdapterItem> it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    it.remove(DslAdapterItem.this);
                }
            }, 3, null);
        }
    }

    public static /* synthetic */ void XX0xXo(DslAdapterItem dslAdapterItem, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        xxIO(dslAdapterItem, i, i2, i3);
    }

    public static /* synthetic */ boolean Xo0(DslAdapterItem dslAdapterItem, DslAdapter dslAdapter, int i, Object obj) {
        if ((i & 1) != 0) {
            dslAdapter = null;
        }
        return oX(dslAdapterItem, dslAdapter);
    }

    public static final void XoI0Ixx0(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO final DslAdapterItem dslAdapterItem) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        if (dslAdapterItem == null) {
            dslAdapterItem = DslAdapterExKt.x0o(dslAdapter, str, false);
        }
        if (dslAdapterItem == null) {
            L.f5267oIX0oI.oo0xXOI0I("移除的目标不存在");
        } else {
            DslAdapter.changeDataItems$default(dslAdapter, false, null, new Oox.oOoXoXO<List<DslAdapterItem>, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterItemExKt$removeItem$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(List<DslAdapterItem> list) {
                    invoke2(list);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo List<DslAdapterItem> it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    it.remove(DslAdapterItem.this);
                }
            }, 3, null);
        }
    }

    public static final void XoX(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        oxXx0IX(dslAdapterItem, i, i);
    }

    public static /* synthetic */ DslViewHolder Xx000oIo(DslAdapterItem dslAdapterItem, RecyclerView recyclerView, int i, Object obj) {
        if ((i & 1) != 0) {
            DslAdapter itemDslAdapter = dslAdapterItem.getItemDslAdapter();
            if (itemDslAdapter != null) {
                recyclerView = itemDslAdapter.get_recyclerView();
            } else {
                recyclerView = null;
            }
        }
        return oOXoIIIo(dslAdapterItem, recyclerView);
    }

    public static final boolean XxX0x0xxx(@OXOo.OOXIXo DslAdapterItem dslAdapterItem) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        if (dslAdapterItem.getLifecycle().getCurrentState() == Lifecycle.State.RESUMED) {
            return true;
        }
        return false;
    }

    public static final void o0(@OXOo.OOXIXo DslAdapterItem dslAdapterItem) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        Io(dslAdapterItem);
    }

    public static /* synthetic */ RecyclerView.ViewHolder o00(DslAdapterItem dslAdapterItem, RecyclerView recyclerView, int i, Object obj) {
        if ((i & 1) != 0) {
            DslAdapter itemDslAdapter = dslAdapterItem.getItemDslAdapter();
            if (itemDslAdapter != null) {
                recyclerView = itemDslAdapter.get_recyclerView();
            } else {
                recyclerView = null;
            }
        }
        return xoXoI(dslAdapterItem, recyclerView);
    }

    public static final void o0xxxXXxX(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, int i, int i2, int i3) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        dslAdapterItem.setItemTopInsert(i);
        dslAdapterItem.setItemRightOffset(i3);
        dslAdapterItem.setItemLeftOffset(i2);
    }

    public static /* synthetic */ void oI0IIXIo(DslAdapterItem dslAdapterItem, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i4 = -1;
        }
        Oxx0xo(dslAdapterItem, i, i2, i3, i4);
    }

    public static final /* synthetic */ <Item extends DslAdapterItem> void oIX0oI(DslAdapter dslAdapter, List<DslAdapterItem> itemList, String str, int i, Oox.oOoXoXO<? super Item, ? extends Item> updateOrCreateItem) {
        DslAdapterItem dslAdapterItem;
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemList, "itemList");
        kotlin.jvm.internal.IIX0o.x0xO0oo(updateOrCreateItem, "updateOrCreateItem");
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
        Item invoke = updateOrCreateItem.invoke(dslAdapterItem);
        if (invoke != null) {
            invoke.setItemTag(str);
        }
        if (x0o2 == null && invoke == null) {
            return;
        }
        List<DslAdapterItem> list = itemList;
        if (invoke == null) {
            if (x0o2 != null) {
                list.remove(x0o2);
            }
        } else {
            if (x0o2 == null) {
                list.add(MathUtils.clamp(i, 0, list.size()), invoke);
                return;
            }
            x0o2.setItemChanging(true);
            int indexOf = list.indexOf(x0o2);
            if (indexOf != -1) {
                list.set(indexOf, invoke);
            }
        }
    }

    public static final void oO(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, int i, int i2, int i3) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        dslAdapterItem.setItemLeftOffset(i);
        dslAdapterItem.setItemRightOffset(i);
        dslAdapterItem.setItemTopInsert(0);
        dslAdapterItem.setItemBottomInsert(i2);
        dslAdapterItem.setOnlyDrawOffsetArea(true);
        dslAdapterItem.setItemDecorationColor(i3);
    }

    @OXOo.oOoXoXO
    public static final DslViewHolder oOXoIIIo(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.oOoXoXO RecyclerView recyclerView) {
        RecyclerView.ViewHolder viewHolder;
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        int IoOoX2 = IoOoX(dslAdapterItem, null, false, 3, null);
        if (IoOoX2 == -1) {
            return null;
        }
        if (recyclerView != null) {
            viewHolder = recyclerView.findViewHolderForAdapterPosition(IoOoX2);
        } else {
            viewHolder = null;
        }
        if (!(viewHolder instanceof DslViewHolder)) {
            return null;
        }
        return (DslViewHolder) viewHolder;
    }

    public static final /* synthetic */ <Item extends DslAdapterItem> void oOo(DslAdapter dslAdapter, String str, int i, Oox.oOoXoXO<? super Item, ? extends Item> updateOrCreateItem) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(updateOrCreateItem, "updateOrCreateItem");
        kotlin.jvm.internal.IIX0o.xoXoI();
        DslAdapter.changeHeaderItems$default(dslAdapter, false, null, new DslAdapterItemExKt$updateOrInsertHeaderItem$1(dslAdapter, str, i, updateOrCreateItem), 3, null);
    }

    public static final void oOoXoXO(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, int i, int i2, int i3, int i4) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        dslAdapterItem.setItemLeftOffset(i2);
        dslAdapterItem.setItemRightOffset(i3);
        dslAdapterItem.setItemTopInsert(0);
        dslAdapterItem.setItemBottomInsert(i);
        dslAdapterItem.setOnlyDrawOffsetArea(true);
        dslAdapterItem.setItemDecorationColor(i4);
    }

    public static final boolean oX(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.oOoXoXO DslAdapter dslAdapter) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        if (dslAdapter == null) {
            dslAdapter = dslAdapterItem.getItemDslAdapter();
        }
        boolean z = false;
        if (dslAdapter != null) {
            boolean remove = dslAdapter.getHeaderItems().remove(dslAdapterItem);
            boolean remove2 = dslAdapter.getDataItems().remove(dslAdapterItem);
            boolean remove3 = dslAdapter.getFooterItems().remove(dslAdapterItem);
            if (remove || remove2 || remove3) {
                z = true;
            }
            if (z) {
                dslAdapter._updateAdapterItems();
                DslAdapterItem.updateItemDepend$default(dslAdapterItem, null, 1, null);
            }
        }
        return z;
    }

    public static /* synthetic */ void oXIO0o0XI(DslAdapter dslAdapter, String str, int i, Oox.oOoXoXO updateOrCreateItem, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(updateOrCreateItem, "updateOrCreateItem");
        kotlin.jvm.internal.IIX0o.xoXoI();
        DslAdapter.changeFooterItems$default(dslAdapter, false, null, new DslAdapterItemExKt$updateOrInsertFooterItem$1(dslAdapter, str, i, updateOrCreateItem), 3, null);
    }

    public static final int oo(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.oOoXoXO DslAdapter dslAdapter, boolean z) {
        List<DslAdapterItem> dataList;
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        if (dslAdapter == null) {
            dslAdapter = dslAdapterItem.getItemDslAdapter();
        }
        if (dslAdapter != null && (dataList = dslAdapter.getDataList(z)) != null) {
            return dataList.indexOf(dslAdapterItem);
        }
        return -1;
    }

    public static /* synthetic */ int oo0xXOI0I(DslAdapterItem dslAdapterItem, DslAdapter dslAdapter, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            dslAdapter = null;
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return xI(dslAdapterItem, dslAdapter, z);
    }

    public static final void ooOOo0oXI(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, int i, int i2, int i3, int i4) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        dslAdapterItem.setItemTopOffset(i2);
        dslAdapterItem.setItemBottomOffset(i3);
        dslAdapterItem.setItemRightInsert(0);
        dslAdapterItem.setItemLeftInsert(i);
        dslAdapterItem.setOnlyDrawOffsetArea(false);
        dslAdapterItem.setItemDecorationColor(i4);
    }

    public static /* synthetic */ List ooOx(List list, int i, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        if ((i2 & 2) != 0) {
            oooxoxo = new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterItemExKt$toDslItemList$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo DslAdapterItem dslAdapterItem) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "$this$null");
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                    invoke2(dslAdapterItem);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        return OOXIxO0(list, i, oooxoxo);
    }

    public static /* synthetic */ boolean ooXIXxIX(DslAdapterItem dslAdapterItem, DslAdapter dslAdapter, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            dslAdapter = null;
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return IIX0o(dslAdapterItem, dslAdapter, z);
    }

    @OXOo.OOXIXo
    public static final <T> List<T> ox(@OXOo.OOXIXo List<? extends Object> list, @OXOo.OOXIXo Oox.IXxxXO<? super List<T>, ? super Integer, Object, oXIO0o0XI> itemBefore, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, Object, ? extends T> itemFactory, @OXOo.OOXIXo Oox.IXxxXO<? super List<T>, ? super Integer, Object, oXIO0o0XI> itemAfter) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemBefore, "itemBefore");
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemFactory, "itemFactory");
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemAfter, "itemAfter");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (T t : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            itemBefore.invoke(arrayList, Integer.valueOf(i), t);
            arrayList.add(itemFactory.invoke(Integer.valueOf(i), t));
            itemAfter.invoke(arrayList, Integer.valueOf(i), t);
            i = i2;
        }
        return arrayList;
    }

    public static final void oxXx0IX(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        dslAdapterItem.setItemPaddingTop(i);
        dslAdapterItem.setItemPaddingBottom(i2);
    }

    @OXOo.oOoXoXO
    public static final DslAdapterItem oxoX(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo DslAdapter adapter, boolean z, @OXOo.OOXIXo Oox.x0xO0oo<? super DslAdapterItem, ? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(adapter, "adapter");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        boolean z2 = false;
        int i = 0;
        int i2 = -1;
        for (DslAdapterItem dslAdapterItem2 : adapter.getDataList(z)) {
            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(dslAdapterItem, dslAdapterItem2)) {
                z2 = true;
                i2 = i;
            } else if (z2 && predicate.invoke(dslAdapterItem2, Integer.valueOf(i - i2)).booleanValue()) {
                return dslAdapterItem2;
            }
            i++;
        }
        return null;
    }

    public static final void oxxXoxO(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        dslAdapterItem.setItemPaddingLeft(i);
        dslAdapterItem.setItemPaddingRight(i2);
    }

    public static /* synthetic */ void x0XOIxOo(DslAdapterItem dslAdapterItem, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i4 = -1;
        }
        ooOOo0oXI(dslAdapterItem, i, i2, i3, i4);
    }

    public static /* synthetic */ void x0o(DslAdapterItem dslAdapterItem, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = i;
        }
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        xII(dslAdapterItem, i, i2, i3);
    }

    public static /* synthetic */ void x0xO(DslAdapterItem dslAdapterItem, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        xoIxX(dslAdapterItem, i, i2, i3);
    }

    public static /* synthetic */ void x0xO0oo(DslAdapterItem dslAdapterItem, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = -1;
        }
        oO(dslAdapterItem, i, i2, i3);
    }

    public static final int xI(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.oOoXoXO DslAdapter dslAdapter, boolean z) {
        DslAdapter dslAdapter2;
        List<DslAdapterItem> dataList;
        DslAdapter dslAdapter3;
        List<DslAdapterItem> dataItems;
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        if (dslAdapter == null) {
            dslAdapter2 = dslAdapterItem.getItemDslAdapter();
        } else {
            dslAdapter2 = dslAdapter;
        }
        if (dslAdapter2 != null && (dataList = dslAdapter2.getDataList(z)) != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : dataList) {
                DslAdapterItem dslAdapterItem2 = (DslAdapterItem) obj;
                if (dslAdapter == null) {
                    dslAdapter3 = dslAdapterItem.getItemDslAdapter();
                } else {
                    dslAdapter3 = dslAdapter;
                }
                if (dslAdapter3 != null && (dataItems = dslAdapter3.getDataItems()) != null && dataItems.contains(dslAdapterItem2)) {
                    arrayList.add(obj);
                }
            }
            return arrayList.indexOf(dslAdapterItem);
        }
        return -1;
    }

    public static final void xII(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, int i, int i2, int i3) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        dslAdapterItem.setItemTopOffset(0);
        dslAdapterItem.setItemBottomOffset(0);
        dslAdapterItem.setItemLeftInsert(i);
        dslAdapterItem.setItemRightInsert(i2);
        dslAdapterItem.setOnlyDrawOffsetArea(false);
        dslAdapterItem.setItemDecorationColor(i3);
    }

    public static /* synthetic */ void xOOOX(DslAdapterItem dslAdapterItem, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        xX0IIXIx0(dslAdapterItem, z, z2);
    }

    public static /* synthetic */ void xOoOIoI(DslAdapter dslAdapter, String str, int i, Oox.oOoXoXO updateOrCreateItem, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(updateOrCreateItem, "updateOrCreateItem");
        kotlin.jvm.internal.IIX0o.xoXoI();
        DslAdapter.changeDataItems$default(dslAdapter, false, null, new DslAdapterItemExKt$updateOrInsertItem$1(dslAdapter, str, i, updateOrCreateItem), 3, null);
    }

    public static final void xX0IIXIx0(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, boolean z, boolean z2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        if (dslAdapterItem.getItemIsSelected() == z) {
            return;
        }
        dslAdapterItem.setItemIsSelected(z);
        if (z2) {
            DslAdapterItem.updateAdapterItem$default(dslAdapterItem, null, false, 3, null);
        }
    }

    public static /* synthetic */ void xXOx(DslAdapter dslAdapter, String str, DslAdapterItem dslAdapterItem, int i, Object obj) {
        if ((i & 2) != 0) {
            dslAdapterItem = null;
        }
        xo0x(dslAdapter, str, dslAdapterItem);
    }

    public static final boolean xXxxox0I(@OXOo.OOXIXo DslAdapterItem dslAdapterItem) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        if (dslAdapterItem.getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) {
            return true;
        }
        return false;
    }

    public static final void xo0x(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO final DslAdapterItem dslAdapterItem) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        if (dslAdapterItem == null) {
            dslAdapterItem = DslAdapterExKt.x0o(dslAdapter, str, false);
        }
        if (dslAdapterItem == null) {
            L.f5267oIX0oI.oo0xXOI0I("移除的目标不存在");
        } else {
            DslAdapter.changeFooterItems$default(dslAdapter, false, null, new Oox.oOoXoXO<List<DslAdapterItem>, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterItemExKt$removeFooterItem$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(List<DslAdapterItem> list) {
                    invoke2(list);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo List<DslAdapterItem> it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    it.remove(DslAdapterItem.this);
                }
            }, 3, null);
        }
    }

    public static /* synthetic */ DslAdapterItem xoIox(DslAdapterItem dslAdapterItem, DslAdapter dslAdapter, boolean z, Oox.x0xO0oo x0xo0oo, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return II0XooXoX(dslAdapterItem, dslAdapter, z, x0xo0oo);
    }

    public static final void xoIxX(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, int i, int i2, int i3) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        dslAdapterItem.setItemBottomInsert(i);
        dslAdapterItem.setItemRightOffset(i3);
        dslAdapterItem.setItemLeftOffset(i2);
    }

    public static /* synthetic */ List xoO0xx0(List list, Oox.IXxxXO iXxxXO, Oox.x0xO0oo x0xo0oo, Oox.IXxxXO iXxxXO2, int i, Object obj) {
        if ((i & 1) != 0) {
            iXxxXO = new Oox.IXxxXO<List<DslAdapterItem>, Integer, Object, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterItemExKt$toDslItemList$4
                public final void invoke(@OXOo.OOXIXo List<DslAdapterItem> list2, int i2, @OXOo.OOXIXo Object obj2) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(list2, "<anonymous parameter 0>");
                    kotlin.jvm.internal.IIX0o.x0xO0oo(obj2, "<anonymous parameter 2>");
                }

                @Override // Oox.IXxxXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(List<DslAdapterItem> list2, Integer num, Object obj2) {
                    invoke(list2, num.intValue(), obj2);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        if ((i & 4) != 0) {
            iXxxXO2 = new Oox.IXxxXO<List<DslAdapterItem>, Integer, Object, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterItemExKt$toDslItemList$5
                public final void invoke(@OXOo.OOXIXo List<DslAdapterItem> list2, int i2, @OXOo.OOXIXo Object obj2) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(list2, "<anonymous parameter 0>");
                    kotlin.jvm.internal.IIX0o.x0xO0oo(obj2, "<anonymous parameter 2>");
                }

                @Override // Oox.IXxxXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(List<DslAdapterItem> list2, Integer num, Object obj2) {
                    invoke(list2, num.intValue(), obj2);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        return IIxOXoOo0(list, iXxxXO, x0xo0oo, iXxxXO2);
    }

    @OXOo.oOoXoXO
    public static final RecyclerView.ViewHolder xoXoI(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.oOoXoXO RecyclerView recyclerView) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        return oOXoIIIo(dslAdapterItem, recyclerView);
    }

    public static final void xoxXI(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapter, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        DslAdapter dslAdapter = new DslAdapter(null, 1, null);
        action.invoke(dslAdapter);
        dslAdapterItem.getItemSubList().addAll(dslAdapter.getAdapterItems());
    }

    public static final void xxIO(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, int i, int i2, int i3) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        dslAdapterItem.setItemRightInsert(i);
        dslAdapterItem.setItemBottomOffset(i3);
        dslAdapterItem.setItemTopOffset(i2);
    }

    public static /* synthetic */ DslAdapterItem xxIXOIIO(DslAdapterItem dslAdapterItem, DslAdapter dslAdapter, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        if ((i2 & 4) != 0) {
            i = 1;
        }
        return Oxx0IOOO(dslAdapterItem, dslAdapter, z, i);
    }

    public static final boolean xxX(@OXOo.OOXIXo DslAdapterItem dslAdapterItem) {
        RecyclerView.LayoutManager layoutManager;
        RecyclerView recyclerView;
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        DslAdapter itemDslAdapter = dslAdapterItem.getItemDslAdapter();
        if (itemDslAdapter != null && (recyclerView = itemDslAdapter.get_recyclerView()) != null) {
            layoutManager = recyclerView.getLayoutManager();
        } else {
            layoutManager = null;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            return true;
        }
        return false;
    }
}
