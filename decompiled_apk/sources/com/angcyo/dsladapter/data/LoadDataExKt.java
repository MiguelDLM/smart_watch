package com.angcyo.dsladapter.data;

import OXOo.OOXIXo;
import Oox.x0xO0oo;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.XxX0x0xxx;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nLoadDataEx.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LoadDataEx.kt\ncom/angcyo/dsladapter/data/LoadDataExKt\n*L\n1#1,153:1\n30#1:154\n95#1:155\n30#1:156\n95#1:157\n*S KotlinDebug\n*F\n+ 1 LoadDataEx.kt\ncom/angcyo/dsladapter/data/LoadDataExKt\n*L\n113#1:154\n113#1:155\n113#1:156\n113#1:157\n*E\n"})
/* loaded from: classes7.dex */
public final class LoadDataExKt {
    public static final /* synthetic */ <Item extends DslAdapterItem> void I0Io(DslAdapter dslAdapter, List<? extends Object> list, int i, int i2, XxX0x0xxx filterParams, x0xO0oo<? super Item, Object, oXIO0o0XI> initItem) {
        IIX0o.x0xO0oo(dslAdapter, "<this>");
        IIX0o.x0xO0oo(filterParams, "filterParams");
        IIX0o.x0xO0oo(initItem, "initItem");
        IIX0o.xoXoI();
        dslAdapter.changeDataItems(false, filterParams, new LoadDataExKt$loadSingleData2$$inlined$loadSingleData$1(list, i, dslAdapter, i2, initItem));
    }

    public static /* synthetic */ void II0xO0(DslAdapter dslAdapter, List list, int i, int i2, XxX0x0xxx filterParams, x0xO0oo initOrCreateDslItem, int i3, Object obj) {
        int i4;
        if ((i3 & 2) != 0) {
            i = Page.Companion.oIX0oI();
        }
        int i5 = i;
        if ((i3 & 4) != 0) {
            i4 = Integer.MAX_VALUE;
        } else {
            i4 = i2;
        }
        if ((i3 & 8) != 0) {
            filterParams = dslAdapter.getDefaultFilterParams();
            IIX0o.ooOOo0oXI(filterParams);
            filterParams.XxX0x0xxx(CollectionsKt__CollectionsKt.X00IoxXI(1, 2));
        }
        IIX0o.x0xO0oo(dslAdapter, "<this>");
        IIX0o.x0xO0oo(filterParams, "filterParams");
        IIX0o.x0xO0oo(initOrCreateDslItem, "initOrCreateDslItem");
        IIX0o.xoXoI();
        dslAdapter.changeDataItems(false, filterParams, new LoadDataExKt$loadSingleData$2(list, i5, initOrCreateDslItem, dslAdapter, i4));
    }

    public static final void X0o0xo(@OOXIXo DslAdapter dslAdapter, int i, int i2, int i3, boolean z) {
        IIX0o.x0xO0oo(dslAdapter, "<this>");
        if (i <= Page.Companion.oIX0oI()) {
            if (i2 < i3) {
                if (z) {
                    dslAdapter.setLoadMoreEnable(true);
                    DslAdapter.setLoadMore$default(dslAdapter, 2, null, false, 6, null);
                    return;
                } else {
                    dslAdapter.setLoadMoreEnable(false);
                    return;
                }
            }
            dslAdapter.setLoadMoreEnable(true);
            DslAdapter.setLoadMore$default(dslAdapter, 0, null, false, 6, null);
            return;
        }
        if (dslAdapter.getDslLoadMoreItem().getItemStateEnable()) {
            if (i2 < i3) {
                DslAdapter.setLoadMore$default(dslAdapter, 2, null, false, 6, null);
            } else {
                DslAdapter.setLoadMore$default(dslAdapter, 0, null, false, 2, null);
            }
        }
    }

    public static /* synthetic */ void XO(DslAdapter dslAdapter, int i, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = Page.Companion.oxoX();
        }
        if ((i4 & 8) != 0) {
            z = false;
        }
        X0o0xo(dslAdapter, i, i2, i3, z);
    }

    public static final /* synthetic */ <Item extends DslAdapterItem> void oIX0oI(DslAdapter dslAdapter, List<? extends Object> list, int i, int i2, XxX0x0xxx filterParams, x0xO0oo<? super Item, Object, ? extends Item> initOrCreateDslItem) {
        IIX0o.x0xO0oo(dslAdapter, "<this>");
        IIX0o.x0xO0oo(filterParams, "filterParams");
        IIX0o.x0xO0oo(initOrCreateDslItem, "initOrCreateDslItem");
        IIX0o.xoXoI();
        dslAdapter.changeDataItems(false, filterParams, new LoadDataExKt$loadSingleData$2(list, i, initOrCreateDslItem, dslAdapter, i2));
    }

    public static /* synthetic */ void oxoX(DslAdapter dslAdapter, List list, int i, int i2, XxX0x0xxx filterParams, x0xO0oo x0xo0oo, int i3, Object obj) {
        int i4;
        if ((i3 & 2) != 0) {
            i = Page.Companion.oIX0oI();
        }
        int i5 = i;
        if ((i3 & 4) != 0) {
            i4 = Integer.MAX_VALUE;
        } else {
            i4 = i2;
        }
        if ((i3 & 8) != 0) {
            filterParams = dslAdapter.getDefaultFilterParams();
            IIX0o.ooOOo0oXI(filterParams);
            filterParams.XxX0x0xxx(CollectionsKt__CollectionsKt.X00IoxXI(1, 2));
        }
        if ((i3 & 16) != 0) {
            IIX0o.xoXoI();
            x0xo0oo = LoadDataExKt$loadSingleData2$2.INSTANCE;
        }
        x0xO0oo initItem = x0xo0oo;
        IIX0o.x0xO0oo(dslAdapter, "<this>");
        IIX0o.x0xO0oo(filterParams, "filterParams");
        IIX0o.x0xO0oo(initItem, "initItem");
        IIX0o.xoXoI();
        dslAdapter.changeDataItems(false, filterParams, new LoadDataExKt$loadSingleData2$$inlined$loadSingleData$1(list, i5, dslAdapter, i4, initItem));
    }
}
