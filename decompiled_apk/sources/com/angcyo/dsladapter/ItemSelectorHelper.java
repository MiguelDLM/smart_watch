package com.angcyo.dsladapter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nItemSelectorHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ItemSelectorHelper.kt\ncom/angcyo/dsladapter/ItemSelectorHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,632:1\n1855#2,2:633\n1855#2,2:635\n1855#2,2:637\n1855#2,2:639\n1855#2,2:641\n1864#2,3:643\n1855#2,2:646\n857#2,2:648\n1864#2,3:650\n*S KotlinDebug\n*F\n+ 1 ItemSelectorHelper.kt\ncom/angcyo/dsladapter/ItemSelectorHelper\n*L\n76#1:633,2\n124#1:635,2\n235#1:637,2\n241#1:639,2\n270#1:641,2\n330#1:643,3\n340#1:646,2\n363#1:648,2\n373#1:650,3\n*E\n"})
/* loaded from: classes7.dex */
public final class ItemSelectorHelper {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f5245II0XooXoX = 1;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f5246OOXIXo = 1;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f5247Oxx0IOOO = 0;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f5248XO = new oIX0oI(null);

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f5249oOoXoXO = 2;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f5250xoIox = 0;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f5251xxIXOIIO = 2;

    /* renamed from: I0Io, reason: collision with root package name */
    public int f5252I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.oOoXoXO
    public List<? extends DslAdapterItem> f5253II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final CopyOnWriteArrayList<Xx000oIo> f5254X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final DslAdapter f5255oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Xx000oIo f5256oxoX;

    /* loaded from: classes7.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    public ItemSelectorHelper(@OXOo.OOXIXo DslAdapter dslAdapter) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "dslAdapter");
        this.f5255oIX0oI = dslAdapter;
        this.f5254X0o0xo = new CopyOnWriteArrayList<>();
    }

    public static /* synthetic */ void IIX0o(ItemSelectorHelper itemSelectorHelper, List list, IO io2, int i, Object obj) {
        IO io3;
        if ((i & 2) != 0) {
            io3 = new IO(null, 0, false, false, false, null, false, false, false, null, 1023, null);
        } else {
            io3 = io2;
        }
        itemSelectorHelper.XI0IXoo(list, io3);
    }

    public static /* synthetic */ List Oo(ItemSelectorHelper itemSelectorHelper, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return itemSelectorHelper.x0xO0oo(z);
    }

    public static /* synthetic */ void Oxx0xo() {
    }

    public static /* synthetic */ void XIxXXX0x0(ItemSelectorHelper itemSelectorHelper, int i, IO io2, int i2, Object obj) {
        IO io3;
        if ((i2 & 2) != 0) {
            io3 = new IO(null, 0, false, false, false, null, false, false, false, null, 1023, null);
        } else {
            io3 = io2;
        }
        itemSelectorHelper.IIXOooo(i, io3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void XxX0x0xxx(ItemSelectorHelper itemSelectorHelper, DslAdapterItem dslAdapterItem, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 2) != 0) {
            oooxoxo = new Oox.oOoXoXO<IO, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.ItemSelectorHelper$selector$3
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo IO io2) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(io2, "$this$null");
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(IO io2) {
                    invoke2(io2);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        itemSelectorHelper.OxI(dslAdapterItem, oooxoxo);
    }

    public static /* synthetic */ List oO(ItemSelectorHelper itemSelectorHelper, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return itemSelectorHelper.x0XOIxOo(z);
    }

    public static /* synthetic */ boolean oxoX(ItemSelectorHelper itemSelectorHelper, DslAdapterItem dslAdapterItem, int i, Object obj) {
        if ((i & 1) != 0) {
            dslAdapterItem = null;
        }
        return itemSelectorHelper.I0Io(dslAdapterItem);
    }

    public static /* synthetic */ void xI(ItemSelectorHelper itemSelectorHelper, IO io2, int i, Object obj) {
        IO io3;
        if ((i & 1) != 0) {
            io3 = new IO(null, 0, false, false, false, null, false, false, false, null, 1023, null);
        } else {
            io3 = io2;
        }
        itemSelectorHelper.ooXIXxIX(io3);
    }

    public static /* synthetic */ void xXxxox0I(ItemSelectorHelper itemSelectorHelper, DslAdapterItem dslAdapterItem, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        itemSelectorHelper.O0xOxO(dslAdapterItem, z);
    }

    public static /* synthetic */ void xxX(ItemSelectorHelper itemSelectorHelper, X0.oOoXoXO oooxoxo, IO io2, int i, Object obj) {
        IO io3;
        if ((i & 2) != 0) {
            io3 = new IO(null, 0, false, false, false, null, false, false, false, null, 1023, null);
        } else {
            io3 = io2;
        }
        itemSelectorHelper.xoXoI(oooxoxo, io3);
    }

    public final boolean I0Io(@OXOo.oOoXoXO DslAdapterItem dslAdapterItem) {
        Boolean bool;
        if (dslAdapterItem != null) {
            List<? extends DslAdapterItem> list = this.f5253II0xO0;
            if (list != null) {
                bool = Boolean.valueOf(list.contains(dslAdapterItem));
            } else {
                bool = null;
            }
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        return false;
    }

    public final void II0XooXoX(@OXOo.OOXIXo IO selectorParams) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(selectorParams, "selectorParams");
        if (selectorParams.x0XOIxOo() == null) {
            return;
        }
        boolean X0o0xo2 = X0o0xo(selectorParams);
        if (!X0o0xo2 && I0Io(selectorParams.x0XOIxOo())) {
            return;
        }
        DslAdapterItem x0XOIxOo2 = selectorParams.x0XOIxOo();
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(x0XOIxOo2);
        x0XOIxOo2.setItemIsSelected(X0o0xo2);
        if (selectorParams.x0xO0oo()) {
            x0XOIxOo2._itemSelectorChange(selectorParams);
        }
        if (selectorParams.oO()) {
            this.f5255oIX0oI.notifyItemChanged(x0XOIxOo2, selectorParams.Oxx0xo(), selectorParams.IIXOooo());
        }
    }

    public final void II0xO0(@OXOo.OOXIXo Oox.oIX0oI<oXIO0o0XI> doIt) {
        String oIX0oI2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(doIt, "doIt");
        if (this.f5252I0Io != 0) {
            doIt.invoke();
            return;
        }
        L l = L.f5267oIX0oI;
        StringBuilder sb = new StringBuilder();
        sb.append("当前选择模式[");
        oIX0oI2 = ItemSelectorHelperKt.oIX0oI(this.f5252I0Io);
        sb.append(oIX0oI2);
        sb.append("]不支持操作.");
        l.oo0xXOI0I(sb.toString());
    }

    public final void IIXOooo(int i, @OXOo.OOXIXo IO selectorParams) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(selectorParams, "selectorParams");
        selectorParams.o00((DslAdapterItem) CollectionsKt___CollectionsKt.OIoxIx(this.f5255oIX0oI.getDataList(selectorParams.IIXOooo()), i));
        X0IIOO(selectorParams);
    }

    public final int IXxxXO() {
        return this.f5252I0Io;
    }

    public final void IoOoX(int i) {
        int i2 = this.f5252I0Io;
        this.f5252I0Io = i;
        if (i2 != i) {
            Iterator<T> it = this.f5254X0o0xo.iterator();
            while (it.hasNext()) {
                ((Xx000oIo) it.next()).oIX0oI(i2, i);
            }
            Xx000oIo xx000oIo = this.f5256oxoX;
            if (xx000oIo != null) {
                xx000oIo.oIX0oI(i2, i);
            }
        }
    }

    public final void O0xOxO(@OXOo.oOoXoXO DslAdapterItem dslAdapterItem, boolean z) {
        IO io2 = new IO(null, 0, false, false, false, null, false, false, false, null, 1023, null);
        io2.o00(dslAdapterItem);
        io2.xxX(ItemSelectorHelperKt.xoXoI(z));
        X0IIOO(io2);
    }

    @OXOo.oOoXoXO
    public final List<DslAdapterItem> OOXIXo() {
        return this.f5253II0xO0;
    }

    public final void OxI(@OXOo.oOoXoXO DslAdapterItem dslAdapterItem, @OXOo.OOXIXo Oox.oOoXoXO<? super IO, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        IO io2 = new IO(null, 0, false, false, false, null, false, false, false, null, 1023, null);
        io2.o00(dslAdapterItem);
        io2.xxX(0);
        action.invoke(io2);
        X0IIOO(io2);
    }

    public final void Oxx0IOOO(@OXOo.OOXIXo IO selectorParams) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(selectorParams, "selectorParams");
        boolean X0o0xo2 = X0o0xo(selectorParams);
        DslAdapterItem x0XOIxOo2 = selectorParams.x0XOIxOo();
        if (x0XOIxOo2 != null && x0XOIxOo2.getItemIsSelected() == X0o0xo2) {
            return;
        }
        if (x0XOIxOo2 != null && I0Io(x0XOIxOo2)) {
            II0XooXoX(selectorParams);
        } else {
            List<DslAdapterItem> x0xO0oo2 = x0xO0oo(selectorParams.IIXOooo());
            int i = this.f5252I0Io;
            if (i == 1) {
                Iterator<T> it = this.f5255oIX0oI.getDataList(selectorParams.IIXOooo()).iterator();
                while (it.hasNext()) {
                    oIX0oI((DslAdapterItem) it.next(), x0XOIxOo2);
                }
                if (!x0xO0oo2.isEmpty()) {
                    for (DslAdapterItem dslAdapterItem : x0xO0oo2) {
                        if (x0XOIxOo2 == null || !kotlin.jvm.internal.IIX0o.Oxx0IOOO(dslAdapterItem, x0XOIxOo2)) {
                            if (dslAdapterItem.isItemCanSelected().invoke(Boolean.valueOf(dslAdapterItem.getItemIsSelected()), Boolean.FALSE).booleanValue()) {
                                II0XooXoX(new IO(dslAdapterItem, 2, true, false, false, null, false, false, false, null, 1016, null));
                            }
                        }
                    }
                }
                II0XooXoX(selectorParams);
            } else if (i == 2) {
                II0XooXoX(selectorParams);
            }
        }
        if (selectorParams.Oo()) {
            XO(selectorParams);
        }
    }

    public final void OxxIIOOXO(@OXOo.OOXIXo Xx000oIo listener) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(listener, "listener");
        this.f5254X0o0xo.remove(listener);
    }

    public final void X0IIOO(@OXOo.OOXIXo final IO selectorParams) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(selectorParams, "selectorParams");
        II0xO0(new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.angcyo.dsladapter.ItemSelectorHelper$selector$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                invoke2();
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                DslAdapterItem x0XOIxOo2 = IO.this.x0XOIxOo();
                boolean X0o0xo2 = this.X0o0xo(IO.this);
                if (x0XOIxOo2 == null) {
                    this.Oxx0IOOO(IO.this);
                    return;
                }
                if (this.I0Io(x0XOIxOo2)) {
                    ItemSelectorHelper itemSelectorHelper = this;
                    IO io2 = IO.this;
                    io2.xxX(1);
                    itemSelectorHelper.Oxx0IOOO(io2);
                    return;
                }
                if (x0XOIxOo2.isItemCanSelected().invoke(Boolean.valueOf(x0XOIxOo2.getItemIsSelected()), Boolean.valueOf(X0o0xo2)).booleanValue()) {
                    this.Oxx0IOOO(IO.this);
                }
            }
        });
    }

    public final boolean X0o0xo(@OXOo.OOXIXo IO selectorParams) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(selectorParams, "selectorParams");
        if (selectorParams.x0XOIxOo() == null) {
            return false;
        }
        if (selectorParams.oI0IIXIo() != 1) {
            if (selectorParams.oI0IIXIo() != 0) {
                return false;
            }
            DslAdapterItem x0XOIxOo2 = selectorParams.x0XOIxOo();
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(x0XOIxOo2);
            if (x0XOIxOo2.getItemIsSelected()) {
                return false;
            }
        }
        return true;
    }

    public final void XI0IXoo(@OXOo.OOXIXo List<? extends DslAdapterItem> itemList, @OXOo.OOXIXo IO selectorParams) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemList, "itemList");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selectorParams, "selectorParams");
        Iterator<T> it = itemList.iterator();
        while (it.hasNext()) {
            X0IIOO(new IO((DslAdapterItem) it.next(), selectorParams.oI0IIXIo(), false, false, false, null, false, false, false, null, 1016, null));
        }
        if (selectorParams.Oo()) {
            if (!itemList.isEmpty() || selectorParams.IXxxXO()) {
                XO(selectorParams);
            }
        }
    }

    public final void XO(@OXOo.OOXIXo IO selectorParams) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(selectorParams, "selectorParams");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<DslAdapterItem> dataList = this.f5255oIX0oI.getDataList(selectorParams.IIXOooo());
        boolean z = false;
        int i = 0;
        for (Object obj : dataList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            DslAdapterItem dslAdapterItem = (DslAdapterItem) obj;
            if (dslAdapterItem.getItemIsSelected()) {
                arrayList2.add(Integer.valueOf(i));
                arrayList.add(dslAdapterItem);
            }
            i = i2;
        }
        if (dataList.size() > 0 && dataList.size() == arrayList.size()) {
            z = true;
        }
        Iterator<T> it = this.f5254X0o0xo.iterator();
        while (it.hasNext()) {
            ((Xx000oIo) it.next()).II0xO0(arrayList, arrayList2, z, selectorParams);
        }
        Xx000oIo xx000oIo = this.f5256oxoX;
        if (xx000oIo != null) {
            xx000oIo.II0xO0(arrayList, arrayList2, z, selectorParams);
        }
    }

    public final void o00(@OXOo.oOoXoXO DslAdapterItem dslAdapterItem) {
        boolean z = false;
        if (dslAdapterItem != null && dslAdapterItem.getItemIsSelected()) {
            z = true;
        }
        O0xOxO(dslAdapterItem, !z);
    }

    @OXOo.OOXIXo
    public final Xx000oIo oI0IIXIo(@OXOo.OOXIXo Oox.oOoXoXO<? super x0XOIxOo, oXIO0o0XI> config) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(config, "config");
        x0XOIxOo x0xoixoo = new x0XOIxOo();
        config.invoke(x0xoixoo);
        xxIXOIIO(x0xoixoo);
        return x0xoixoo;
    }

    public final void oIX0oI(@OXOo.OOXIXo DslAdapterItem item, @OXOo.oOoXoXO DslAdapterItem dslAdapterItem) {
        Iterator it;
        DslAdapterItem dslAdapterItem2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        Iterator it2 = item.getItemSubList().iterator();
        while (it2.hasNext()) {
            DslAdapterItem dslAdapterItem3 = (DslAdapterItem) it2.next();
            if (dslAdapterItem3.getItemIsSelected() && !kotlin.jvm.internal.IIX0o.Oxx0IOOO(dslAdapterItem3, dslAdapterItem) && dslAdapterItem3.isItemCanSelected().invoke(Boolean.valueOf(dslAdapterItem3.getItemIsSelected()), Boolean.FALSE).booleanValue()) {
                it = it2;
                dslAdapterItem2 = dslAdapterItem3;
                II0XooXoX(new IO(dslAdapterItem, 2, true, false, false, null, false, false, false, null, 1016, null));
            } else {
                it = it2;
                dslAdapterItem2 = dslAdapterItem3;
            }
            oIX0oI(dslAdapterItem2, dslAdapterItem);
            it2 = it;
        }
    }

    @OXOo.oOoXoXO
    public final Xx000oIo oOoXoXO() {
        return this.f5256oxoX;
    }

    public final void oo(@OXOo.oOoXoXO Xx000oIo xx000oIo) {
        this.f5256oxoX = xx000oIo;
    }

    public final void oo0xXOI0I(@OXOo.oOoXoXO List<? extends DslAdapterItem> list) {
        this.f5253II0xO0 = list;
        if (list != null) {
            XI0IXoo(list, new IO((DslAdapterItem) CollectionsKt___CollectionsKt.xX0ox(list), 1, true, true, true, null, false, false, false, null, 992, null));
        }
    }

    @OXOo.OOXIXo
    public final CopyOnWriteArrayList<Xx000oIo> ooOOo0oXI() {
        return this.f5254X0o0xo;
    }

    public final void ooXIXxIX(@OXOo.OOXIXo IO selectorParams) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(selectorParams, "selectorParams");
        XI0IXoo(this.f5255oIX0oI.getDataList(selectorParams.IIXOooo()), selectorParams);
    }

    @OXOo.OOXIXo
    public final List<Integer> x0XOIxOo(boolean z) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : this.f5255oIX0oI.getDataList(z)) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            if (((DslAdapterItem) obj).getItemIsSelected()) {
                arrayList.add(Integer.valueOf(i));
            }
            i = i2;
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public final List<DslAdapterItem> x0xO0oo(boolean z) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.f5255oIX0oI.getDataList(z)) {
            if (((DslAdapterItem) obj).getItemIsSelected()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public final DslAdapter xoIox() {
        return this.f5255oIX0oI;
    }

    public final void xoXoI(@OXOo.OOXIXo X0.oOoXoXO indexRange, @OXOo.OOXIXo IO selectorParams) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(indexRange, "indexRange");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selectorParams, "selectorParams");
        List<DslAdapterItem> dataList = this.f5255oIX0oI.getDataList(selectorParams.IIXOooo());
        ArrayList arrayList = new ArrayList();
        X0.oOoXoXO oooxoxo = new X0.oOoXoXO(Math.min(indexRange.oxoX(), indexRange.X0o0xo()), Math.max(indexRange.oxoX(), indexRange.X0o0xo()));
        int oxoX2 = oooxoxo.oxoX();
        int X0o0xo2 = oooxoxo.X0o0xo();
        if (oxoX2 <= X0o0xo2) {
            while (true) {
                if (oxoX2 >= 0 && oxoX2 < dataList.size()) {
                    arrayList.add(dataList.get(oxoX2));
                }
                if (oxoX2 == X0o0xo2) {
                    break;
                } else {
                    oxoX2++;
                }
            }
        }
        XI0IXoo(arrayList, selectorParams);
    }

    public final void xxIXOIIO(@OXOo.OOXIXo Xx000oIo listener) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(listener, "listener");
        this.f5254X0o0xo.add(listener);
    }
}
