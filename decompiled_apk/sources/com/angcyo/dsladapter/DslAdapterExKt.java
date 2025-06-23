package com.angcyo.dsladapter;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.LayoutRes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Xo0;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nDslAdapterEx.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DslAdapterEx.kt\ncom/angcyo/dsladapter/DslAdapterExKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,877:1\n77#1:881\n118#1,11:882\n154#1,11:893\n766#2:878\n857#2,2:879\n766#2:904\n857#2,2:905\n1855#2,2:907\n766#2:909\n857#2,2:910\n1855#2,2:912\n1855#2,2:914\n1855#2,2:916\n857#2,2:918\n1855#2:922\n1855#2,2:923\n1856#2:925\n1864#2,3:926\n1855#2,2:929\n13579#3,2:920\n*S KotlinDebug\n*F\n+ 1 DslAdapterEx.kt\ncom/angcyo/dsladapter/DslAdapterExKt\n*L\n106#1:881\n140#1:882,11\n176#1:893,11\n90#1:878\n90#1:879,2\n233#1:904\n233#1:905,2\n234#1:907,2\n233#1:909\n233#1:910,2\n234#1:912,2\n248#1:914,2\n265#1:916,2\n280#1:918,2\n361#1:922\n362#1:923,2\n361#1:925\n542#1:926,3\n738#1:929,2\n301#1:920,2\n*E\n"})
/* loaded from: classes7.dex */
public final class DslAdapterExKt {
    public static /* synthetic */ void I0(DslAdapter dslAdapter, boolean z, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        IIxOXoOo0(dslAdapter, z, oooxoxo);
    }

    @OXOo.OOXIXo
    public static final com.angcyo.dsladapter.filter.xxIXOIIO I0Io(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.OOXIXo com.angcyo.dsladapter.filter.xxIXOIIO interceptor) {
        List<com.angcyo.dsladapter.filter.xxIXOIIO> oO2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(interceptor, "interceptor");
        DslDataFilter dslDataFilter = dslAdapter.getDslDataFilter();
        if (dslDataFilter != null && (oO2 = dslDataFilter.oO()) != null) {
            oO2.add(interceptor);
        }
        return interceptor;
    }

    @OXOo.OOXIXo
    public static final Pair<List<DslAdapterItem>, Integer> I0X0x0oIo(@OXOo.OOXIXo DslAdapter dslAdapter, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        int size = dslAdapter.getHeaderItems().size();
        int size2 = dslAdapter.getDataItems().size();
        if (i >= 0 && i < dslAdapter.getHeaderItems().size()) {
            return Xo0.oIX0oI(dslAdapter.getHeaderItems(), Integer.valueOf(i));
        }
        int size3 = dslAdapter.getDataItems().size();
        int i2 = i - size;
        if (i2 >= 0 && i2 < size3) {
            return Xo0.oIX0oI(dslAdapter.getDataItems(), Integer.valueOf(i2));
        }
        int size4 = dslAdapter.getFooterItems().size();
        int i3 = i2 - size2;
        if (i3 >= 0 && i3 < size4) {
            return Xo0.oIX0oI(dslAdapter.getFooterItems(), Integer.valueOf(i3));
        }
        return Xo0.oIX0oI(null, -1);
    }

    public static /* synthetic */ List I0oOIX(DslAdapter dslAdapter, boolean z, boolean z2, Oox.oOoXoXO predicate, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        List<DslAdapterItem> dataList = dslAdapter.getDataList(z2);
        ArrayList arrayList = new ArrayList();
        for (DslAdapterItem dslAdapterItem : dataList) {
            if (((Boolean) predicate.invoke(dslAdapterItem)).booleanValue()) {
                dslAdapterItem.setItemHidden(z);
                arrayList.add(dslAdapterItem);
            }
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <T extends DslAdapterItem> List<T> I0oOoX(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.OOXIXo T item, boolean z, boolean z2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        List<DslAdapterItem> dataList = dslAdapter.getDataList(z);
        ArrayList arrayList = new ArrayList();
        if (z2) {
            loop0: while (true) {
                boolean z3 = false;
                for (DslAdapterItem dslAdapterItem : dataList) {
                    if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(LibExKt.x0xO0oo(dslAdapterItem), LibExKt.x0xO0oo(item))) {
                        kotlin.jvm.internal.IIX0o.x0XOIxOo(dslAdapterItem, "null cannot be cast to non-null type T of com.angcyo.dsladapter.DslAdapterExKt.findSameClassItem");
                        arrayList.add(dslAdapterItem);
                    } else {
                        if (z3) {
                            break loop0;
                        }
                        arrayList.clear();
                    }
                    if (z3 || kotlin.jvm.internal.IIX0o.Oxx0IOOO(dslAdapterItem, item)) {
                        z3 = true;
                    }
                }
            }
        } else {
            for (DslAdapterItem dslAdapterItem2 : dataList) {
                if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(LibExKt.x0xO0oo(dslAdapterItem2), LibExKt.x0xO0oo(item))) {
                    kotlin.jvm.internal.IIX0o.x0XOIxOo(dslAdapterItem2, "null cannot be cast to non-null type T of com.angcyo.dsladapter.DslAdapterExKt.findSameClassItem");
                    arrayList.add(dslAdapterItem2);
                }
            }
        }
        return arrayList;
    }

    public static /* synthetic */ void I0xX0(DslAdapter dslAdapter, XxX0x0xxx xxX0x0xxx, int i, Object obj) {
        if ((i & 1) != 0) {
            xxX0x0xxx = OO0x0xX(dslAdapter);
        }
        XXXI(dslAdapter, xxX0x0xxx);
    }

    public static /* synthetic */ List II0XooXoX(DslAdapter dslAdapter, boolean z, Oox.x0xO0oo x0xo0oo, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            x0xo0oo = new Oox.x0xO0oo<Integer, DslAdapterItem, Boolean>() { // from class: com.angcyo.dsladapter.DslAdapterExKt$allSelectedItem$1
                @Override // Oox.x0xO0oo
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num, DslAdapterItem dslAdapterItem) {
                    return invoke(num.intValue(), dslAdapterItem);
                }

                @OXOo.OOXIXo
                public final Boolean invoke(int i2, @OXOo.OOXIXo DslAdapterItem item) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
                    return Boolean.valueOf(item.getItemIsSelected());
                }
            };
        }
        return Oxx0IOOO(dslAdapter, z, x0xo0oo);
    }

    @OXOo.oOoXoXO
    public static final Integer II0xO0(@OXOo.OOXIXo DslAdapter dslAdapter) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        if (dslAdapter.getDslAdapterStatusItem().getItemEnable() && dslAdapter.getDslAdapterStatusItem().getItemStateEnable()) {
            return Integer.valueOf(dslAdapter.getDslAdapterStatusItem().getItemState());
        }
        return null;
    }

    public static final void IIX0(@OXOo.OOXIXo DslAdapter dslAdapter, boolean z, boolean z2, boolean z3, @OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapterItem, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (DslAdapterItem dslAdapterItem : dslAdapter.getDataList(z3)) {
            if (predicate.invoke(dslAdapterItem).booleanValue() && dslAdapterItem.getItemIsSelected() != z) {
                dslAdapterItem.setItemIsSelected(z);
                if (z2) {
                    DslAdapterItem.updateAdapterItem$default(dslAdapterItem, null, z3, 1, null);
                }
            }
        }
    }

    public static final /* synthetic */ <Item extends DslAdapterItem> Item IIX0o(DslAdapter dslAdapter, String str, boolean z, Oox.oOoXoXO<? super DslAdapterItem, Boolean> predicate, Oox.oOoXoXO<? super Item, oXIO0o0XI> dsl) {
        Object obj;
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        kotlin.jvm.internal.IIX0o.x0xO0oo(dsl, "dsl");
        Iterator<T> it = dslAdapter.getDataList(z).iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (predicate.invoke(obj).booleanValue()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        kotlin.jvm.internal.IIX0o.OxI(2, "Item");
        Item item = (Item) obj;
        if (item == null) {
            return null;
        }
        dsl.invoke(item);
        return item;
    }

    @OXOo.OOXIXo
    public static final List<DslAdapterItem> IIXOooo(@OXOo.OOXIXo DslAdapter dslAdapter, boolean z, boolean z2, @OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapterItem, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        List<DslAdapterItem> dataList = dslAdapter.getDataList(z2);
        ArrayList arrayList = new ArrayList();
        for (DslAdapterItem dslAdapterItem : dataList) {
            if (predicate.invoke(dslAdapterItem).booleanValue()) {
                dslAdapterItem.setItemEnable(z);
                arrayList.add(dslAdapterItem);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void IIxOXoOo0(@OXOo.OOXIXo DslAdapter dslAdapter, boolean z, @OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapterItem, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        final ArrayList arrayList = new ArrayList();
        for (Object obj : dslAdapter.getDataList(z)) {
            if (predicate.invoke(obj).booleanValue()) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            DslAdapter.render$default(dslAdapter, false, null, new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterExKt$removeItem$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter2) {
                    invoke2(dslAdapter2);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo DslAdapter render) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(render, "$this$render");
                    render.removeItemFromAll(arrayList);
                }
            }, 3, null);
        }
    }

    public static /* synthetic */ List IO(DslAdapter dslAdapter, List list, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return Xx000oIo(dslAdapter, list, z);
    }

    @OXOo.OOXIXo
    public static final List<DslAdapterItem> IO0XoXxO(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.OOXIXo String... itemTags) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemTags, "itemTags");
        return X0xxXX0(dslAdapter, 1, true, (String[]) Arrays.copyOf(itemTags, itemTags.length));
    }

    public static /* synthetic */ DslAdapterItem IOoo(DslAdapter dslAdapter, kotlin.reflect.oxoX oxox, Object obj, boolean z, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = 1;
        }
        if ((i & 4) != 0) {
            z = true;
        }
        return XI(dslAdapter, oxox, obj, z);
    }

    public static /* synthetic */ void IXO(List list, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = 1;
        }
        oOoIIO0(list, obj);
    }

    public static /* synthetic */ DslAdapterItem IXxxXO(DslAdapter dslAdapter, DslAdapterItem dslAdapterItem, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 2) != 0) {
            oooxoxo = new Oox.oOoXoXO<Object, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterExKt$dslItem$2
                public final void invoke(@OXOo.OOXIXo Object obj2) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(obj2, "$this$null");
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Object obj2) {
                    invoke(obj2);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        return x0xO0oo(dslAdapter, dslAdapterItem, oooxoxo);
    }

    public static /* synthetic */ DslAdapterItem Io(DslAdapter dslAdapter, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return x0o(dslAdapter, str, z);
    }

    public static /* synthetic */ void IoIOOxIIo(DslAdapter dslAdapter, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        xI0oxI00(dslAdapter, th);
    }

    public static /* synthetic */ DslAdapterItem IoOoX(DslAdapter dslAdapter, kotlin.reflect.oxoX oxox, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return ooXIXxIX(dslAdapter, oxox, z);
    }

    public static final boolean IoOoo(@OXOo.OOXIXo DslAdapter dslAdapter) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        if (dslAdapter.getDslAdapterStatusItem().getItemState() == 2) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    public static final <Item extends DslAdapterItem> List<Item> IoXIXo(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.OOXIXo kotlin.reflect.oxoX<Item> itemClass, @OXOo.oOoXoXO Object obj, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemClass, "itemClass");
        ArrayList arrayList = new ArrayList();
        for (DslAdapterItem dslAdapterItem : dslAdapter.getDataList(z)) {
            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(LibExKt.x0xO0oo(dslAdapterItem), LibExKt.x0xO0oo(XO0OX.II0xO0.X0o0xo(itemClass)))) {
                kotlin.jvm.internal.IIX0o.x0XOIxOo(dslAdapterItem, "null cannot be cast to non-null type Item of com.angcyo.dsladapter.DslAdapterExKt.updateAllItem$lambda$8");
                arrayList.add(dslAdapterItem);
                dslAdapterItem.updateAdapterItem(obj, z);
            }
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final List<Integer> Ioxxx() {
        return o0xxxXXxX(1, 2);
    }

    public static /* synthetic */ void Ix00oIoI(DslAdapter dslAdapter, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        oI(dslAdapter, th);
    }

    public static final void IxIX0I(@OXOo.OOXIXo DslAdapter dslAdapter) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        dslAdapter.updateAdapterStatus(0);
    }

    public static /* synthetic */ void O0(DslAdapter dslAdapter, int i, Oox.oOoXoXO oooxoxo, Oox.Oxx0xo oxx0xo, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            oooxoxo = new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterExKt$singleItem$1
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
        Ox0O(dslAdapter, i, oooxoxo, oxx0xo);
    }

    public static final boolean O00XxXI(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.OOXIXo com.angcyo.dsladapter.filter.xxIXOIIO interceptor) {
        List<com.angcyo.dsladapter.filter.xxIXOIIO> oO2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(interceptor, "interceptor");
        DslDataFilter dslDataFilter = dslAdapter.getDslDataFilter();
        if (dslDataFilter != null && (oO2 = dslDataFilter.oO()) != null) {
            return oO2.remove(interceptor);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <Item extends DslAdapterItem> List<Item> O0IxXx(DslAdapter dslAdapter, Object obj, boolean z, Oox.oOoXoXO<? super DslAdapterItem, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        List<DslAdapterItem> dataList = dslAdapter.getDataList(z);
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : dataList) {
            if (predicate.invoke(obj2).booleanValue()) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            DslAdapterItem.updateAdapterItem$default((DslAdapterItem) it.next(), obj, false, 2, null);
        }
        return arrayList;
    }

    public static /* synthetic */ void O0X(DslAdapter dslAdapter, int i, int i2, List list, Oox.oOoXoXO oooxoxo, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            list = dslAdapter.getDataItems();
        }
        if ((i3 & 8) != 0) {
            oooxoxo = new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterExKt$renderLineItem$1
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
        oOo(dslAdapter, i, i2, list, oooxoxo);
    }

    @OXOo.OOXIXo
    public static final List<DslAdapterItem> O0Xx(@OXOo.OOXIXo DslAdapter dslAdapter, boolean z, boolean z2, @OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapterItem, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        List<DslAdapterItem> dataList = dslAdapter.getDataList(z2);
        ArrayList arrayList = new ArrayList();
        for (DslAdapterItem dslAdapterItem : dataList) {
            if (predicate.invoke(dslAdapterItem).booleanValue()) {
                dslAdapterItem.setItemHidden(z);
                arrayList.add(dslAdapterItem);
            }
        }
        return arrayList;
    }

    public static final void O0xOxO(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.oOoXoXO Throwable th) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        dslAdapter.setAdapterStatus(3, th);
    }

    public static /* synthetic */ DslAdapterItem OI0(DslAdapter dslAdapter, String str, Class cls, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return xII(dslAdapter, str, cls, z);
    }

    public static final void OIOoIIOIx(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.oOoXoXO Object obj, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        dslAdapter.setLoadMore(2, obj, z);
    }

    public static /* synthetic */ List OO(DslAdapter dslAdapter, boolean z, List tags, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(tags, "tags");
        List<DslAdapterItem> dataList = dslAdapter.getDataList(z2);
        ArrayList arrayList = new ArrayList();
        for (DslAdapterItem dslAdapterItem : dataList) {
            if (CollectionsKt___CollectionsKt.X00xOoXI(tags, dslAdapterItem.getItemTag())) {
                dslAdapterItem.setItemHidden(z);
                arrayList.add(dslAdapterItem);
            }
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final XxX0x0xxx OO0x0xX(@OXOo.OOXIXo DslAdapter dslAdapter) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        XxX0x0xxx defaultFilterParams = dslAdapter.getDefaultFilterParams();
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(defaultFilterParams);
        defaultFilterParams.XI0IXoo(true);
        defaultFilterParams.OxI(false);
        return defaultFilterParams;
    }

    public static final void OOXIXo(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.OOXIXo XxX0x0xxx filterParams) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(filterParams, "filterParams");
        dslAdapter.updateItemDepend(filterParams);
    }

    public static /* synthetic */ void OOXIxO0(com.angcyo.dsladapter.filter.xxIXOIIO xxixoiio, DslAdapter dslAdapter, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        XI0oooXX(xxixoiio, dslAdapter, z);
    }

    public static /* synthetic */ void OX00O0xII(DslAdapter dslAdapter, int i, int i2, List list, Oox.oOoXoXO oooxoxo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = LibExKt.Xx000oIo(dslAdapter) * 120;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            list = dslAdapter.getDataItems();
        }
        if ((i3 & 8) != 0) {
            oooxoxo = new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterExKt$renderEmptyItem$1
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
        ooOx(dslAdapter, i, i2, list, oooxoxo);
    }

    public static /* synthetic */ DslAdapterItem Oo(DslAdapter dslAdapter, int i, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            oooxoxo = new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterExKt$dslItem$1
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
        return oO(dslAdapter, i, oooxoxo);
    }

    public static /* synthetic */ void OoO(DslAdapter dslAdapter, Throwable th, Object obj, boolean z, int i, Object obj2) {
        if ((i & 1) != 0) {
            th = null;
        }
        if ((i & 2) != 0) {
            obj = null;
        }
        if ((i & 4) != 0) {
            z = true;
        }
        XIXIxO(dslAdapter, th, obj, z);
    }

    public static final void Ox0O(@OXOo.OOXIXo DslAdapter dslAdapter, @LayoutRes int i, @OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapterItem, oXIO0o0XI> init, @OXOo.OOXIXo Oox.Oxx0xo<? super DslViewHolder, ? super Integer, ? super DslAdapterItem, ? super List<? extends Object>, oXIO0o0XI> bind) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(init, "init");
        kotlin.jvm.internal.IIX0o.x0xO0oo(bind, "bind");
        DslAdapterItem dslAdapterItem = new DslAdapterItem();
        dslAdapterItem.setItemLayoutId(i);
        dslAdapterItem.setItemBindOverride(bind);
        init.invoke(dslAdapterItem);
        dslAdapter.addLastItem(dslAdapterItem);
    }

    public static /* synthetic */ List OxI(DslAdapter dslAdapter, boolean z, List tags, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(tags, "tags");
        List<DslAdapterItem> dataList = dslAdapter.getDataList(z2);
        ArrayList arrayList = new ArrayList();
        for (DslAdapterItem dslAdapterItem : dataList) {
            if (CollectionsKt___CollectionsKt.X00xOoXI(tags, dslAdapterItem.getItemTag())) {
                dslAdapterItem.setItemEnable(z);
                arrayList.add(dslAdapterItem);
            }
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final List<DslAdapterItem> Oxx0IOOO(@OXOo.OOXIXo DslAdapter dslAdapter, boolean z, @OXOo.OOXIXo final Oox.x0xO0oo<? super Integer, ? super DslAdapterItem, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        final ArrayList arrayList = new ArrayList();
        Oxx0xo(dslAdapter, z, new Oox.x0xO0oo<Integer, DslAdapterItem, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterExKt$allSelectedItem$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Integer num, DslAdapterItem dslAdapterItem) {
                invoke(num.intValue(), dslAdapterItem);
                return oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(int i, @OXOo.OOXIXo DslAdapterItem dslAdapterItem) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "dslAdapterItem");
                if (predicate.invoke(Integer.valueOf(i), dslAdapterItem).booleanValue()) {
                    arrayList.add(dslAdapterItem);
                }
            }
        });
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void Oxx0xo(@OXOo.OOXIXo DslAdapter dslAdapter, boolean z, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super DslAdapterItem, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        int i = 0;
        for (Object obj : dslAdapter.getDataList(z)) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            action.invoke(Integer.valueOf(i), obj);
            i = i2;
        }
    }

    public static final void OxxIIOOXO(@OXOo.OOXIXo DslAdapter dslAdapter) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        DslAdapter.setAdapterStatus$default(dslAdapter, 1, null, 2, null);
    }

    @OXOo.OOXIXo
    public static final List<DslAdapterItem> X00IoxXI(@OXOo.OOXIXo List<? extends DslAdapterItem> list, @OXOo.OOXIXo List<String> groups) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(groups, "groups");
        ArrayList arrayList = new ArrayList();
        for (String str : groups) {
            for (DslAdapterItem dslAdapterItem : list) {
                if (dslAdapterItem.getItemGroups().contains(str)) {
                    arrayList.add(dslAdapterItem);
                }
            }
        }
        return arrayList;
    }

    public static /* synthetic */ void X0IIOO(DslAdapter dslAdapter, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        O0xOxO(dslAdapter, th);
    }

    public static final void X0o0xo(@OXOo.OOXIXo com.angcyo.dsladapter.filter.xxIXOIIO xxixoiio, @OXOo.OOXIXo DslAdapter adapter, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(xxixoiio, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(adapter, "adapter");
        I0Io(adapter, xxixoiio);
        if (z) {
            DslAdapter.updateItemDepend$default(adapter, null, 1, null);
        }
    }

    @OXOo.oOoXoXO
    public static final DslAdapterItem X0xII0I(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.oOoXoXO Object obj, boolean z, @OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapterItem, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        DslAdapterItem xI2 = xI(dslAdapter, z, predicate);
        if (xI2 != null) {
            xI2.updateAdapterItem(obj, z);
            return xI2;
        }
        return null;
    }

    @OXOo.OOXIXo
    public static final List<DslAdapterItem> X0xxXX0(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.oOoXoXO final Object obj, boolean z, @OXOo.OOXIXo String... itemTags) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemTags, "itemTags");
        ArrayList arrayList = new ArrayList();
        for (String str : itemTags) {
            final DslAdapterItem x0o2 = x0o(dslAdapter, str, z);
            if (x0o2 != null) {
                arrayList.add(x0o2);
                if (LibExKt.I0oOIX()) {
                    DslAdapterItem.updateAdapterItem$default(x0o2, obj, false, 2, null);
                } else {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.angcyo.dsladapter.II0xO0
                        @Override // java.lang.Runnable
                        public final void run() {
                            DslAdapterExKt.XOxxooXI(DslAdapterItem.this, obj);
                        }
                    });
                }
            }
        }
        return arrayList;
    }

    @OXOo.oOoXoXO
    public static final <Item extends DslAdapterItem> Item XI(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.OOXIXo kotlin.reflect.oxoX<Item> itemClass, @OXOo.oOoXoXO Object obj, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemClass, "itemClass");
        Item item = (Item) ooXIXxIX(dslAdapter, itemClass, z);
        if (item != null) {
            item.updateAdapterItem(obj, z);
            return item;
        }
        return null;
    }

    public static final /* synthetic */ <Item extends DslAdapterItem> Item XI0IXoo(DslAdapter dslAdapter, String str, boolean z, Oox.oOoXoXO<? super DslAdapterItem, Boolean> predicate) {
        Object obj;
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        Iterator<T> it = dslAdapter.getDataList(z).iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (predicate.invoke(obj).booleanValue()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        kotlin.jvm.internal.IIX0o.OxI(2, "Item");
        return (Item) obj;
    }

    public static final void XI0oooXX(@OXOo.OOXIXo com.angcyo.dsladapter.filter.xxIXOIIO xxixoiio, @OXOo.OOXIXo DslAdapter adapter, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(xxixoiio, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(adapter, "adapter");
        O00XxXI(adapter, xxixoiio);
        if (z) {
            DslAdapter.updateItemDepend$default(adapter, null, 1, null);
        }
    }

    public static final <T> void XIXIX(@OXOo.OOXIXo DslAdapter dslAdapter, T t, @OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapterItem, oXIO0o0XI> init) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(init, "init");
        DslAdapterItem dslAdapterItem = new DslAdapterItem();
        dslAdapterItem.setItemData(t);
        init.invoke(dslAdapterItem);
        dslAdapter.addLastItem(dslAdapterItem);
    }

    public static final void XIXIxO(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.oOoXoXO Throwable th, @OXOo.oOoXoXO Object obj, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        dslAdapter.getDslLoadMoreItem().setItemErrorThrowable(th);
        dslAdapter.setLoadMore(10, obj, z);
    }

    public static final void XIo0oOXIx(@OXOo.OOXIXo DslAdapter dslAdapter) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        DslAdapter.setAdapterStatus$default(dslAdapter, 2, null, 2, null);
    }

    public static /* synthetic */ DslAdapterItem XIxXXX0x0(DslAdapter dslAdapter, final String str, boolean z, Oox.oOoXoXO predicate, int i, Object obj) {
        Object obj2 = null;
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            kotlin.jvm.internal.IIX0o.xoXoI();
            predicate = new Oox.oOoXoXO<DslAdapterItem, Boolean>() { // from class: com.angcyo.dsladapter.DslAdapterExKt$find$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                @OXOo.OOXIXo
                public final Boolean invoke(@OXOo.OOXIXo DslAdapterItem it) {
                    boolean z2;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    if (str != null) {
                        z2 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(it.getItemTag(), str);
                    } else {
                        kotlin.jvm.internal.IIX0o.OxI(3, "Item");
                        z2 = it instanceof DslAdapterItem;
                    }
                    return Boolean.valueOf(z2);
                }
            };
        }
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        Iterator<T> it = dslAdapter.getDataList(z).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((Boolean) predicate.invoke(next)).booleanValue()) {
                obj2 = next;
                break;
            }
        }
        kotlin.jvm.internal.IIX0o.OxI(2, "Item");
        return (DslAdapterItem) obj2;
    }

    public static /* synthetic */ void XO(com.angcyo.dsladapter.filter.xxIXOIIO xxixoiio, DslAdapter dslAdapter, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        X0o0xo(xxixoiio, dslAdapter, z);
    }

    @OXOo.oOoXoXO
    public static final DslAdapterItem XOxIOxOx(@OXOo.OOXIXo List<? extends DslAdapterItem> list, @OXOo.oOoXoXO String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        Object obj = null;
        if (str == null) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(((DslAdapterItem) next).getItemTag(), str)) {
                obj = next;
                break;
            }
        }
        return (DslAdapterItem) obj;
    }

    public static final void XOxxooXI(DslAdapterItem item, Object obj) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "$item");
        DslAdapterItem.updateAdapterItem$default(item, obj, false, 2, null);
    }

    public static /* synthetic */ List XX(DslAdapter dslAdapter, boolean z, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return o0(dslAdapter, z, oooxoxo);
    }

    @OXOo.OOXIXo
    public static final Pair<List<DslAdapterItem>, Integer> XX0(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.oOoXoXO DslAdapterItem dslAdapterItem) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        if (dslAdapterItem == null) {
            return Xo0.oIX0oI(null, -1);
        }
        if (dslAdapter.getHeaderItems().contains(dslAdapterItem)) {
            return Xo0.oIX0oI(dslAdapter.getHeaderItems(), Integer.valueOf(dslAdapter.getHeaderItems().indexOf(dslAdapterItem)));
        }
        if (dslAdapter.getDataItems().contains(dslAdapterItem)) {
            return Xo0.oIX0oI(dslAdapter.getDataItems(), Integer.valueOf(dslAdapter.getDataItems().indexOf(dslAdapterItem)));
        }
        if (dslAdapter.getFooterItems().contains(dslAdapterItem)) {
            return Xo0.oIX0oI(dslAdapter.getFooterItems(), Integer.valueOf(dslAdapter.getFooterItems().indexOf(dslAdapterItem)));
        }
        return Xo0.oIX0oI(null, -1);
    }

    public static final void XX0xXo(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.OOXIXo final Oox.x0xO0oo<? super DslViewHolder, ? super Boolean, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        dslAdapter.getDslAdapterStatusItem().setOnRefresh(new Oox.oOoXoXO<DslViewHolder, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterExKt$onRefreshOrLoadMore$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder) {
                invoke2(dslViewHolder);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo DslViewHolder it) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                action.invoke(it, Boolean.FALSE);
            }
        });
        dslAdapter.getDslLoadMoreItem().setOnLoadMore(new Oox.oOoXoXO<DslViewHolder, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterExKt$onRefreshOrLoadMore$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder) {
                invoke2(dslViewHolder);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo DslViewHolder it) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                action.invoke(it, Boolean.TRUE);
            }
        });
    }

    public static final void XXXI(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.OOXIXo XxX0x0xxx filterParams) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(filterParams, "filterParams");
        dslAdapter.updateItemDepend(filterParams);
    }

    public static final void XXoOx0(@OXOo.OOXIXo DslAdapter dslAdapter) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        dslAdapter.updateAdapterStatus(2);
    }

    public static /* synthetic */ boolean Xo0(DslAdapter dslAdapter, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return oX(dslAdapter, z);
    }

    public static final boolean XoI0Ixx0(@OXOo.OOXIXo Iterable<?> iterable, @OXOo.OOXIXo Oox.oOoXoXO<Object, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        boolean z = false;
        for (Object obj : iterable) {
            if (obj instanceof Iterable) {
                z = XoI0Ixx0((Iterable) obj, predicate);
            } else {
                z = predicate.invoke(obj).booleanValue();
            }
            if (z) {
                break;
            }
        }
        return z;
    }

    public static final /* synthetic */ <ItemData> List<ItemData> XoX(DslAdapter dslAdapter, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        ArrayList arrayList = new ArrayList();
        for (DslAdapterItem dslAdapterItem : dslAdapter.getDataList(z)) {
            Object itemData = dslAdapterItem.getItemData();
            kotlin.jvm.internal.IIX0o.OxI(3, "ItemData");
            if (itemData instanceof Object) {
                Object itemData2 = dslAdapterItem.getItemData();
                kotlin.jvm.internal.IIX0o.OxI(1, "ItemData");
                arrayList.add(itemData2);
            }
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final List<DslAdapterItem> Xx000oIo(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.OOXIXo List<String> groups, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(groups, "groups");
        return X00IoxXI(dslAdapter.getDataList(z), groups);
    }

    public static /* synthetic */ List XxX0x0xxx(DslAdapter dslAdapter, boolean z, Oox.oOoXoXO predicate, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            kotlin.jvm.internal.IIX0o.xoXoI();
            predicate = new Oox.oOoXoXO<DslAdapterItem, Boolean>() { // from class: com.angcyo.dsladapter.DslAdapterExKt$findAllItem$1
                @Override // Oox.oOoXoXO
                @OXOo.OOXIXo
                public final Boolean invoke(@OXOo.OOXIXo DslAdapterItem it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    kotlin.jvm.internal.IIX0o.OxI(3, "Item");
                    return Boolean.valueOf(it instanceof DslAdapterItem);
                }
            };
        }
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        List<DslAdapterItem> dataList = dslAdapter.getDataList(z);
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : dataList) {
            if (((Boolean) predicate.invoke(obj2)).booleanValue()) {
                arrayList.add(obj2);
            }
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final List<DslAdapterItem> o0(@OXOo.OOXIXo DslAdapter dslAdapter, boolean z, @OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapterItem, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        List<DslAdapterItem> dataList = dslAdapter.getDataList(z);
        ArrayList arrayList = new ArrayList();
        for (DslAdapterItem dslAdapterItem : dataList) {
            if (predicate.invoke(dslAdapterItem).booleanValue()) {
                arrayList.add(dslAdapterItem);
            }
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final List<DslAdapterItem> o00(@OXOo.OOXIXo DslAdapter dslAdapter, boolean z, @OXOo.OOXIXo List<String> tags, boolean z2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(tags, "tags");
        List<DslAdapterItem> dataList = dslAdapter.getDataList(z2);
        ArrayList arrayList = new ArrayList();
        for (DslAdapterItem dslAdapterItem : dataList) {
            if (CollectionsKt___CollectionsKt.X00xOoXI(tags, dslAdapterItem.getItemTag())) {
                dslAdapterItem.setItemEnable(z);
                arrayList.add(dslAdapterItem);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ void o0oIxOo(DslAdapter dslAdapter, Object obj, boolean z, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        if ((i & 2) != 0) {
            z = true;
        }
        oxIIX0o(dslAdapter, obj, z);
    }

    @OXOo.OOXIXo
    public static final List<Integer> o0xxxXXxX(@OXOo.OOXIXo int... payload) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(payload, "payload");
        if (payload.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(1);
        }
        return ArraysKt___ArraysKt.XXX0(payload);
    }

    public static final void oI(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.oOoXoXO Throwable th) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        if (th == null) {
            if (dslAdapter.getAdapterItems().isEmpty()) {
                xx0X0(dslAdapter);
                return;
            } else {
                IxIX0I(dslAdapter);
                return;
            }
        }
        xI0oxI00(dslAdapter, th);
    }

    public static /* synthetic */ void oI0IIXIo(DslAdapter dslAdapter, boolean z, Oox.x0xO0oo x0xo0oo, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        Oxx0xo(dslAdapter, z, x0xo0oo);
    }

    public static final /* synthetic */ <Item extends DslAdapterItem> Item oIIxXoo(DslAdapter dslAdapter, Object obj, boolean z, Oox.oOoXoXO<? super DslAdapterItem, Boolean> predicate) {
        Object obj2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        Iterator<T> it = dslAdapter.getDataList(z).iterator();
        while (true) {
            if (it.hasNext()) {
                obj2 = it.next();
                if (predicate.invoke(obj2).booleanValue()) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        kotlin.jvm.internal.IIX0o.OxI(2, "Item");
        Item item = (Item) obj2;
        if (item == null) {
            return null;
        }
        DslAdapterItem.updateAdapterItem$default(item, obj, false, 2, null);
        return item;
    }

    @OXOo.OOXIXo
    public static final DslAdapterItem oO(@OXOo.OOXIXo DslAdapter dslAdapter, @LayoutRes int i, @OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapterItem, oXIO0o0XI> config) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(config, "config");
        DslAdapterItem dslAdapterItem = new DslAdapterItem();
        dslAdapterItem.setItemLayoutId(i);
        dslAdapter.addLastItem(dslAdapterItem);
        config.invoke(dslAdapterItem);
        return dslAdapterItem;
    }

    public static /* synthetic */ DslAdapterItem oOXoIIIo(DslAdapter dslAdapter, boolean z, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return xI(dslAdapter, z, oooxoxo);
    }

    public static final void oOo(@OXOo.OOXIXo DslAdapter dslAdapter, int i, int i2, @OXOo.OOXIXo List<DslAdapterItem> list, @OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapterItem, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        xoO0xx0(dslAdapter, i, new ColorDrawable(i2), list, action);
    }

    public static final void oOoIIO0(@OXOo.OOXIXo List<? extends DslAdapterItem> list, @OXOo.oOoXoXO Object obj) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        for (DslAdapterItem dslAdapterItem : list) {
            dslAdapterItem.diffResult(null, null);
            DslAdapterItem.updateAdapterItem$default(dslAdapterItem, obj, false, 2, null);
        }
    }

    public static /* synthetic */ void oOoXoXO(DslAdapter dslAdapter, XxX0x0xxx xxX0x0xxx, int i, Object obj) {
        DslAdapter dslAdapter2;
        XxX0x0xxx xxX0x0xxx2;
        if ((i & 1) != 0) {
            xxX0x0xxx2 = new XxX0x0xxx(null, false, false, false, false, false, null, null, 0L, 300L, null, 1535, null);
            dslAdapter2 = dslAdapter;
        } else {
            dslAdapter2 = dslAdapter;
            xxX0x0xxx2 = xxX0x0xxx;
        }
        OOXIXo(dslAdapter2, xxX0x0xxx2);
    }

    public static final boolean oX(@OXOo.OOXIXo DslAdapter dslAdapter, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        Iterator<DslAdapterItem> it = dslAdapter.getDataList(z).iterator();
        while (it.hasNext()) {
            if (it.next().getItemChanged()) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ void oXIO0o0XI(DslAdapter dslAdapter, int i, Oox.x0xO0oo x0xo0oo, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        xOOOX(dslAdapter, i, x0xo0oo);
    }

    public static /* synthetic */ DslAdapterItem oXX0IoI(DslAdapter dslAdapter, Object obj, boolean z, Oox.oOoXoXO predicate, int i, Object obj2) {
        Object obj3;
        if ((i & 1) != 0) {
            obj = 1;
        }
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            kotlin.jvm.internal.IIX0o.xoXoI();
            predicate = new Oox.oOoXoXO<DslAdapterItem, Boolean>() { // from class: com.angcyo.dsladapter.DslAdapterExKt$updateItemWith$1
                @Override // Oox.oOoXoXO
                @OXOo.OOXIXo
                public final Boolean invoke(@OXOo.OOXIXo DslAdapterItem it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    kotlin.jvm.internal.IIX0o.OxI(3, "Item");
                    return Boolean.valueOf(it instanceof DslAdapterItem);
                }
            };
        }
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        Iterator<T> it = dslAdapter.getDataList(z).iterator();
        while (true) {
            if (it.hasNext()) {
                obj3 = it.next();
                if (((Boolean) predicate.invoke(obj3)).booleanValue()) {
                    break;
                }
            } else {
                obj3 = null;
                break;
            }
        }
        kotlin.jvm.internal.IIX0o.OxI(2, "Item");
        DslAdapterItem dslAdapterItem = (DslAdapterItem) obj3;
        if (dslAdapterItem == null) {
            return null;
        }
        DslAdapterItem.updateAdapterItem$default(dslAdapterItem, obj, false, 2, null);
        return dslAdapterItem;
    }

    public static /* synthetic */ DslAdapterItem oXxOI0oIx(DslAdapter dslAdapter, Object obj, boolean z, Oox.oOoXoXO oooxoxo, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = 1;
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return X0xII0I(dslAdapter, obj, z, oooxoxo);
    }

    public static /* synthetic */ DslAdapterItem oo(DslAdapter dslAdapter, final String str, boolean z, Oox.oOoXoXO predicate, Oox.oOoXoXO dsl, int i, Object obj) {
        Object obj2;
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            kotlin.jvm.internal.IIX0o.xoXoI();
            predicate = new Oox.oOoXoXO<DslAdapterItem, Boolean>() { // from class: com.angcyo.dsladapter.DslAdapterExKt$findItem$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                @OXOo.OOXIXo
                public final Boolean invoke(@OXOo.OOXIXo DslAdapterItem it) {
                    boolean z2;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    if (str != null) {
                        z2 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(it.getItemTag(), str);
                    } else {
                        kotlin.jvm.internal.IIX0o.OxI(3, "Item");
                        z2 = it instanceof DslAdapterItem;
                    }
                    return Boolean.valueOf(z2);
                }
            };
        }
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        kotlin.jvm.internal.IIX0o.x0xO0oo(dsl, "dsl");
        Iterator<T> it = dslAdapter.getDataList(z).iterator();
        while (true) {
            if (it.hasNext()) {
                obj2 = it.next();
                if (((Boolean) predicate.invoke(obj2)).booleanValue()) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        kotlin.jvm.internal.IIX0o.OxI(2, "Item");
        DslAdapterItem dslAdapterItem = (DslAdapterItem) obj2;
        if (dslAdapterItem == null) {
            return null;
        }
        dsl.invoke(dslAdapterItem);
        return dslAdapterItem;
    }

    public static /* synthetic */ DslAdapterItem oo0xXOI0I(DslAdapter dslAdapter, Class cls, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return xXxxox0I(dslAdapter, cls, z);
    }

    @OXOo.OOXIXo
    public static final <T extends DslAdapterItem> T ooOOo0oXI(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.OOXIXo T dslItem, @OXOo.OOXIXo Oox.oOoXoXO<? super T, oXIO0o0XI> config) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslItem, "dslItem");
        kotlin.jvm.internal.IIX0o.x0xO0oo(config, "config");
        dslAdapter.addLastItem(dslItem);
        config.invoke(dslItem);
        return dslItem;
    }

    public static final void ooOx(@OXOo.OOXIXo DslAdapter dslAdapter, int i, int i2, @OXOo.OOXIXo List<DslAdapterItem> list, @OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapterItem, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        xoO0xx0(dslAdapter, i, new ColorDrawable(i2), list, action);
    }

    @OXOo.oOoXoXO
    public static final <Item extends DslAdapterItem> Item ooXIXxIX(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.OOXIXo final kotlin.reflect.oxoX<Item> itemClass, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemClass, "itemClass");
        Item item = (Item) xI(dslAdapter, z, new Oox.oOoXoXO<DslAdapterItem, Boolean>() { // from class: com.angcyo.dsladapter.DslAdapterExKt$findItem$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            @OXOo.OOXIXo
            public final Boolean invoke(@OXOo.OOXIXo DslAdapterItem it) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                return Boolean.valueOf(kotlin.jvm.internal.IIX0o.Oxx0IOOO(LibExKt.x0xO0oo(it), LibExKt.x0xO0oo(XO0OX.II0xO0.X0o0xo(itemClass))));
            }
        });
        if (!(item instanceof DslAdapterItem)) {
            return null;
        }
        return item;
    }

    public static final boolean ox(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.OOXIXo com.angcyo.dsladapter.filter.xxIXOIIO interceptor) {
        List<com.angcyo.dsladapter.filter.xxIXOIIO> x0xO0oo2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(interceptor, "interceptor");
        DslDataFilter dslDataFilter = dslAdapter.getDslDataFilter();
        if (dslDataFilter != null && (x0xO0oo2 = dslDataFilter.x0xO0oo()) != null) {
            return x0xO0oo2.remove(interceptor);
        }
        return false;
    }

    public static final void oxIIX0o(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.oOoXoXO Object obj, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        dslAdapter.setLoadMore(0, obj, z);
    }

    public static /* synthetic */ List oxXx0IX(DslAdapter dslAdapter, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        ArrayList arrayList = new ArrayList();
        for (DslAdapterItem dslAdapterItem : dslAdapter.getDataList(z)) {
            Object itemData = dslAdapterItem.getItemData();
            kotlin.jvm.internal.IIX0o.OxI(3, "ItemData");
            if (itemData instanceof Object) {
                Object itemData2 = dslAdapterItem.getItemData();
                kotlin.jvm.internal.IIX0o.OxI(1, "ItemData");
                arrayList.add(itemData2);
            }
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final com.angcyo.dsladapter.filter.xxIXOIIO oxoX(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.OOXIXo com.angcyo.dsladapter.filter.xxIXOIIO interceptor) {
        List<com.angcyo.dsladapter.filter.xxIXOIIO> x0xO0oo2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(interceptor, "interceptor");
        DslDataFilter dslDataFilter = dslAdapter.getDslDataFilter();
        if (dslDataFilter != null && (x0xO0oo2 = dslDataFilter.x0xO0oo()) != null) {
            x0xO0oo2.add(interceptor);
        }
        return interceptor;
    }

    public static /* synthetic */ List oxxXoxO(DslAdapter dslAdapter, DslAdapterItem dslAdapterItem, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        return I0oOoX(dslAdapter, dslAdapterItem, z, z2);
    }

    public static /* synthetic */ List x0(DslAdapter dslAdapter, Object obj, boolean z, Oox.oOoXoXO oooxoxo, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = 1;
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return x0OxxIOxX(dslAdapter, obj, z, oooxoxo);
    }

    public static /* synthetic */ void x0OIX00oO(DslAdapter dslAdapter, Object obj, boolean z, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        if ((i & 2) != 0) {
            z = true;
        }
        OIOoIIOIx(dslAdapter, obj, z);
    }

    @OXOo.OOXIXo
    public static final List<DslAdapterItem> x0OxxIOxX(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.oOoXoXO Object obj, boolean z, @OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapterItem, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (DslAdapterItem dslAdapterItem : dslAdapter.getDataList(z)) {
            if (predicate.invoke(dslAdapterItem).booleanValue()) {
                arrayList.add(dslAdapterItem);
                dslAdapterItem.updateAdapterItem(obj, z);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ DslAdapterItem x0XOIxOo(DslAdapter dslAdapter, DslAdapterItem dslAdapterItem, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 2) != 0) {
            oooxoxo = new Oox.oOoXoXO<Object, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterExKt$dslCustomItem$1
                public final void invoke(@OXOo.OOXIXo Object obj2) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(obj2, "$this$null");
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Object obj2) {
                    invoke(obj2);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        return ooOOo0oXI(dslAdapter, dslAdapterItem, oooxoxo);
    }

    @OXOo.oOoXoXO
    public static final DslAdapterItem x0o(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.oOoXoXO final String str, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        if (str == null) {
            return null;
        }
        return xI(dslAdapter, z, new Oox.oOoXoXO<DslAdapterItem, Boolean>() { // from class: com.angcyo.dsladapter.DslAdapterExKt$findItemByTag$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            @OXOo.OOXIXo
            public final Boolean invoke(@OXOo.OOXIXo DslAdapterItem it) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                return Boolean.valueOf(kotlin.jvm.internal.IIX0o.Oxx0IOOO(it.getItemTag(), str));
            }
        });
    }

    public static final boolean x0xO(@OXOo.OOXIXo Iterable<?> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        return xoIox(iterable, 1);
    }

    @OXOo.OOXIXo
    public static final <T extends DslAdapterItem> T x0xO0oo(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.OOXIXo T dslItem, @OXOo.OOXIXo Oox.oOoXoXO<? super T, oXIO0o0XI> config) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslItem, "dslItem");
        kotlin.jvm.internal.IIX0o.x0xO0oo(config, "config");
        ooOOo0oXI(dslAdapter, dslItem, config);
        return dslItem;
    }

    @OXOo.oOoXoXO
    public static final DslAdapterItem xI(@OXOo.OOXIXo DslAdapter dslAdapter, boolean z, @OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapterItem, Boolean> predicate) {
        Object obj;
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        Iterator<T> it = dslAdapter.getDataList(z).iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (predicate.invoke(obj).booleanValue()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (DslAdapterItem) obj;
    }

    public static final void xI0oxI00(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.oOoXoXO Throwable th) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        dslAdapter.getDslAdapterStatusItem().setItemErrorThrowable(th);
        dslAdapter.updateAdapterStatus(3);
    }

    @OXOo.oOoXoXO
    public static final <T extends DslAdapterItem> T xII(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.oOoXoXO final String str, @OXOo.OOXIXo final Class<T> clazz, boolean z) {
        T t;
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(clazz, "clazz");
        if (str == null || (t = (T) xI(dslAdapter, z, new Oox.oOoXoXO<DslAdapterItem, Boolean>() { // from class: com.angcyo.dsladapter.DslAdapterExKt$findItemByTag$item$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            @OXOo.OOXIXo
            public final Boolean invoke(@OXOo.OOXIXo DslAdapterItem it) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                return Boolean.valueOf(it.getClass().isAssignableFrom(clazz) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(it.getItemTag(), str));
            }
        })) == null) {
            return null;
        }
        return t;
    }

    public static final void xOOOX(@OXOo.OOXIXo DslAdapter dslAdapter, int i, @OXOo.OOXIXo Oox.x0xO0oo<? super DslAdapterItem, ? super Integer, oXIO0o0XI> init) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(init, "init");
        for (int i2 = 0; i2 < i; i2++) {
            DslAdapterItem dslAdapterItem = new DslAdapterItem();
            init.invoke(dslAdapterItem, Integer.valueOf(i2));
            dslAdapter.addLastItem(dslAdapterItem);
        }
    }

    public static /* synthetic */ void xOoOIoI(DslAdapter dslAdapter, boolean z, boolean z2, boolean z3, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            z3 = true;
        }
        IIX0(dslAdapter, z, z2, z3, oooxoxo);
    }

    public static /* synthetic */ void xX0IIXIx0(DslAdapter dslAdapter, int i, Drawable drawable, List list, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = LibExKt.Xx000oIo(dslAdapter) * 120;
        }
        if ((i2 & 4) != 0) {
            list = dslAdapter.getDataItems();
        }
        if ((i2 & 8) != 0) {
            oooxoxo = new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterExKt$renderEmptyItem$2
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
        xoO0xx0(dslAdapter, i, drawable, list, oooxoxo);
    }

    @OXOo.oOoXoXO
    public static final List<DslAdapterItem> xXOx(@OXOo.OOXIXo DslAdapter dslAdapter, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        if (i >= 0 && i < dslAdapter.getHeaderItems().size()) {
            return dslAdapter.getHeaderItems();
        }
        int size = dslAdapter.getDataItems().size();
        int size2 = i - dslAdapter.getHeaderItems().size();
        if (size2 >= 0 && size2 < size) {
            return dslAdapter.getDataItems();
        }
        int size3 = dslAdapter.getFooterItems().size();
        int size4 = (i - dslAdapter.getHeaderItems().size()) - dslAdapter.getDataItems().size();
        if (size4 >= 0 && size4 < size3) {
            return dslAdapter.getFooterItems();
        }
        return null;
    }

    public static /* synthetic */ List xXoOI00O(DslAdapter dslAdapter, kotlin.reflect.oxoX oxox, Object obj, boolean z, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = 1;
        }
        if ((i & 4) != 0) {
            z = true;
        }
        return IoXIXo(dslAdapter, oxox, obj, z);
    }

    @OXOo.oOoXoXO
    public static final <Item extends DslAdapterItem> Item xXxxox0I(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.OOXIXo final Class<Item> itemClass, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemClass, "itemClass");
        Item item = (Item) xI(dslAdapter, z, new Oox.oOoXoXO<DslAdapterItem, Boolean>() { // from class: com.angcyo.dsladapter.DslAdapterExKt$findItem$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            @OXOo.OOXIXo
            public final Boolean invoke(@OXOo.OOXIXo DslAdapterItem it) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                return Boolean.valueOf(kotlin.jvm.internal.IIX0o.Oxx0IOOO(LibExKt.x0xO0oo(it), LibExKt.x0xO0oo(itemClass)));
            }
        });
        if (!(item instanceof DslAdapterItem)) {
            return null;
        }
        return item;
    }

    @OXOo.oOoXoXO
    public static final List<DslAdapterItem> xo0x(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.oOoXoXO DslAdapterItem dslAdapterItem) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        if (dslAdapterItem == null) {
            return null;
        }
        if (dslAdapter.getHeaderItems().contains(dslAdapterItem)) {
            return dslAdapter.getHeaderItems();
        }
        if (dslAdapter.getDataItems().contains(dslAdapterItem)) {
            return dslAdapter.getDataItems();
        }
        if (!dslAdapter.getFooterItems().contains(dslAdapterItem)) {
            return null;
        }
        return dslAdapter.getFooterItems();
    }

    public static final boolean xoIox(@OXOo.OOXIXo Iterable<?> iterable, @OXOo.OOXIXo final Object any) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(any, "any");
        return XoI0Ixx0(iterable, new Oox.oOoXoXO<Object, Boolean>() { // from class: com.angcyo.dsladapter.DslAdapterExKt$containsPayload$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oOoXoXO
            @OXOo.OOXIXo
            public final Boolean invoke(@OXOo.oOoXoXO Object obj) {
                return Boolean.valueOf(kotlin.jvm.internal.IIX0o.Oxx0IOOO(obj, any));
            }
        });
    }

    public static final boolean xoIxX(@OXOo.OOXIXo Iterable<?> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        if (CollectionsKt___CollectionsKt.OOxOI(iterable) > 0 && !xoIox(iterable, 2)) {
            return false;
        }
        return true;
    }

    public static final void xoO0xx0(@OXOo.OOXIXo DslAdapter dslAdapter, final int i, @OXOo.oOoXoXO final Drawable drawable, @OXOo.OOXIXo List<DslAdapterItem> list, @OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapterItem, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        DslAdapterItem dslAdapterItem = new DslAdapterItem();
        dslAdapterItem.setItemLayoutId(R.layout.base_empty_item);
        dslAdapterItem.setItemBindOverride(new Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapterExKt$renderEmptyItem$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // Oox.Oxx0xo
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem2, List<? extends Object> list2) {
                invoke(dslViewHolder, num.intValue(), dslAdapterItem2, list2);
                return oXIO0o0XI.f29392oIX0oI;
            }

            public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i2, @OXOo.OOXIXo DslAdapterItem dslAdapterItem2, @OXOo.OOXIXo List<? extends Object> list2) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
                kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem2, "<anonymous parameter 2>");
                kotlin.jvm.internal.IIX0o.x0xO0oo(list2, "<anonymous parameter 3>");
                View view = itemHolder.itemView;
                kotlin.jvm.internal.IIX0o.oO(view, "itemHolder.itemView");
                LibExKt.xX0IIXIx0(view, drawable);
                View view2 = itemHolder.itemView;
                kotlin.jvm.internal.IIX0o.oO(view2, "itemHolder.itemView");
                LibExKt.IIX0(view2, -1, i);
            }
        });
        action.invoke(dslAdapterItem);
        DslAdapter.addLastItem$default(dslAdapter, list, dslAdapterItem, null, 4, null);
    }

    public static /* synthetic */ List xoXoI(DslAdapter dslAdapter, boolean z, boolean z2, Oox.oOoXoXO predicate, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        List<DslAdapterItem> dataList = dslAdapter.getDataList(z2);
        ArrayList arrayList = new ArrayList();
        for (DslAdapterItem dslAdapterItem : dataList) {
            if (((Boolean) predicate.invoke(dslAdapterItem)).booleanValue()) {
                dslAdapterItem.setItemEnable(z);
                arrayList.add(dslAdapterItem);
            }
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final List<DslAdapterItem> xoxXI(@OXOo.OOXIXo DslAdapter dslAdapter, boolean z, @OXOo.OOXIXo List<String> tags, boolean z2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(tags, "tags");
        List<DslAdapterItem> dataList = dslAdapter.getDataList(z2);
        ArrayList arrayList = new ArrayList();
        for (DslAdapterItem dslAdapterItem : dataList) {
            if (CollectionsKt___CollectionsKt.X00xOoXI(tags, dslAdapterItem.getItemTag())) {
                dslAdapterItem.setItemHidden(z);
                arrayList.add(dslAdapterItem);
            }
        }
        return arrayList;
    }

    public static final void xx0X0(@OXOo.OOXIXo DslAdapter dslAdapter) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        dslAdapter.updateAdapterStatus(1);
    }

    public static final void xxIO(@OXOo.OOXIXo DslAdapter dslAdapter) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        DslAdapter.setAdapterStatus$default(dslAdapter, 0, null, 2, null);
    }

    @OXOo.OOXIXo
    public static final DslAdapterItem xxIXOIIO(@OXOo.OOXIXo DslAdapter dslAdapter, @LayoutRes int i, @OXOo.OOXIXo Oox.Oxx0xo<? super DslViewHolder, ? super Integer, ? super DslAdapterItem, ? super List<? extends Object>, oXIO0o0XI> bindAction) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(bindAction, "bindAction");
        DslAdapterItem dslAdapterItem = new DslAdapterItem();
        dslAdapterItem.setItemLayoutId(i);
        dslAdapter.addLastItem(dslAdapterItem);
        dslAdapterItem.setItemBindOverride(bindAction);
        return dslAdapterItem;
    }

    public static /* synthetic */ List xxOXOOoIX(DslAdapter dslAdapter, Object obj, boolean z, Oox.oOoXoXO predicate, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = 1;
        }
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            kotlin.jvm.internal.IIX0o.xoXoI();
            predicate = new Oox.oOoXoXO<DslAdapterItem, Boolean>() { // from class: com.angcyo.dsladapter.DslAdapterExKt$updateAllItem$1
                @Override // Oox.oOoXoXO
                @OXOo.OOXIXo
                public final Boolean invoke(@OXOo.OOXIXo DslAdapterItem it) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    kotlin.jvm.internal.IIX0o.OxI(3, "Item");
                    return Boolean.valueOf(it instanceof DslAdapterItem);
                }
            };
        }
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        List<DslAdapterItem> dataList = dslAdapter.getDataList(z);
        ArrayList arrayList = new ArrayList();
        for (Object obj3 : dataList) {
            if (((Boolean) predicate.invoke(obj3)).booleanValue()) {
                arrayList.add(obj3);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            DslAdapterItem.updateAdapterItem$default((DslAdapterItem) it.next(), obj, false, 2, null);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <Item extends DslAdapterItem> List<Item> xxX(DslAdapter dslAdapter, boolean z, Oox.oOoXoXO<? super DslAdapterItem, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        List<DslAdapterItem> dataList = dslAdapter.getDataList(z);
        ArrayList arrayList = new ArrayList();
        for (Object obj : dataList) {
            if (predicate.invoke(obj).booleanValue()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
