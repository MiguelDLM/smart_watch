package com.angcyo.dsladapter.data;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.IXxxXO;
import Oox.x0xO0oo;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.LibExKt;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.oI0IIXIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.XoX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nSingleDataUpdate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SingleDataUpdate.kt\ncom/angcyo/dsladapter/data/SingleDataUpdate\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,260:1\n1864#2,3:261\n1864#2,3:264\n1864#2,3:267\n1855#2:270\n350#2,7:271\n1856#2:278\n1855#2:279\n350#2,7:280\n1856#2:287\n*S KotlinDebug\n*F\n+ 1 SingleDataUpdate.kt\ncom/angcyo/dsladapter/data/SingleDataUpdate\n*L\n18#1:261,3\n42#1:264,3\n53#1:267,3\n166#1:270\n175#1:271,7\n166#1:278\n188#1:279\n197#1:280,7\n188#1:287\n*E\n"})
/* loaded from: classes7.dex */
public final class SingleDataUpdate {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public final List<oIX0oI> f5339II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public final DslAdapter f5340oIX0oI;

    public SingleDataUpdate(@OOXIXo DslAdapter adapter) {
        IIX0o.x0xO0oo(adapter, "adapter");
        this.f5340oIX0oI = adapter;
        this.f5339II0xO0 = new ArrayList();
    }

    public static /* synthetic */ void I0Io(SingleDataUpdate singleDataUpdate, DslAdapterItem dslAdapterItem, DslAdapterItem dslAdapterItem2, int i, Object obj) {
        if ((i & 2) != 0) {
            dslAdapterItem2 = null;
        }
        singleDataUpdate.oIX0oI(dslAdapterItem, dslAdapterItem2);
    }

    public static /* synthetic */ void oxoX(SingleDataUpdate singleDataUpdate, List list, DslAdapterItem dslAdapterItem, int i, Object obj) {
        if ((i & 2) != 0) {
            dslAdapterItem = null;
        }
        singleDataUpdate.II0xO0(list, dslAdapterItem);
    }

    public static /* synthetic */ void x0XOIxOo(SingleDataUpdate singleDataUpdate, Class cls, DslAdapterItem dslAdapterItem, List list, IXxxXO iXxxXO, int i, Object obj) {
        if ((i & 8) != 0) {
            iXxxXO = new IXxxXO<Object, Object, Integer, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.data.SingleDataUpdate$updateListAt$1
                public final void invoke(@OOXIXo Object obj2, @oOoXoXO Object obj3, int i2) {
                    IIX0o.x0xO0oo(obj2, "$this$null");
                }

                @Override // Oox.IXxxXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Object obj2, Object obj3, Integer num) {
                    invoke((DslAdapterItem) obj2, obj3, num.intValue());
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        singleDataUpdate.ooOOo0oXI(cls, dslAdapterItem, list, iXxxXO);
    }

    @OOXIXo
    public final List<oIX0oI> II0XooXoX() {
        return this.f5339II0xO0;
    }

    public final void II0xO0(@OOXIXo List<? extends DslAdapterItem> itemList, @oOoXoXO DslAdapterItem dslAdapterItem) {
        IIX0o.x0xO0oo(itemList, "itemList");
        if (!itemList.isEmpty()) {
            this.f5339II0xO0.add(new oIX0oI(1, null, dslAdapterItem, null, itemList, 8, null));
        }
    }

    public final void OOXIXo(@OOXIXo x0xO0oo<? super Integer, ? super DslAdapterItem, Boolean> predicate) {
        IIX0o.x0xO0oo(predicate, "predicate");
        int i = 0;
        for (Object obj : this.f5340oIX0oI.getAdapterItems()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            DslAdapterItem dslAdapterItem = (DslAdapterItem) obj;
            if (predicate.invoke(Integer.valueOf(i), dslAdapterItem).booleanValue()) {
                this.f5339II0xO0.add(new oIX0oI(4, dslAdapterItem, null, null, null, 28, null));
            }
            i = i2;
        }
    }

    @OOXIXo
    public final DslAdapter Oxx0IOOO() {
        return this.f5340oIX0oI;
    }

    public final void X0o0xo(@OOXIXo x0xO0oo<? super Integer, ? super DslAdapterItem, Boolean> predicate, @OOXIXo DslAdapterItem item) {
        IIX0o.x0xO0oo(predicate, "predicate");
        IIX0o.x0xO0oo(item, "item");
        int i = 0;
        for (Object obj : this.f5340oIX0oI.getAdapterItems()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            DslAdapterItem dslAdapterItem = (DslAdapterItem) obj;
            if (predicate.invoke(Integer.valueOf(i), dslAdapterItem).booleanValue()) {
                this.f5339II0xO0.add(new oIX0oI(1, null, dslAdapterItem, null, oI0IIXIo.OOXIXo(item), 8, null));
            }
            i = i2;
        }
    }

    public final void XO() {
        DslAdapterItem oOoXoXO2;
        if (this.f5339II0xO0.isEmpty()) {
            return;
        }
        Iterator<T> it = this.f5339II0xO0.iterator();
        while (true) {
            int i = 0;
            if (!it.hasNext()) {
                break;
            }
            oIX0oI oix0oi = (oIX0oI) it.next();
            List<DslAdapterItem> adapterItems = this.f5340oIX0oI.getAdapterItems();
            if (oix0oi.OOXIXo() == 1) {
                DslAdapterItem II0XooXoX2 = oix0oi.II0XooXoX();
                if (II0XooXoX2 == null) {
                    List<DslAdapterItem> xxIXOIIO2 = oix0oi.xxIXOIIO();
                    if (xxIXOIIO2 == null) {
                        xxIXOIIO2 = CollectionsKt__CollectionsKt.ooXIXxIX();
                    }
                    adapterItems.addAll(xxIXOIIO2);
                } else {
                    Iterator<DslAdapterItem> it2 = adapterItems.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (IIX0o.Oxx0IOOO(it2.next(), II0XooXoX2)) {
                                break;
                            } else {
                                i++;
                            }
                        } else {
                            i = -1;
                            break;
                        }
                    }
                    if (i != -1) {
                        int i2 = i + 1;
                        List<DslAdapterItem> xxIXOIIO3 = oix0oi.xxIXOIIO();
                        if (xxIXOIIO3 == null) {
                            xxIXOIIO3 = CollectionsKt__CollectionsKt.ooXIXxIX();
                        }
                        adapterItems.addAll(i2, xxIXOIIO3);
                    }
                }
            }
        }
        List<DslAdapterItem> adapterItems2 = this.f5340oIX0oI.getAdapterItems();
        for (oIX0oI oix0oi2 : this.f5339II0xO0) {
            int OOXIXo2 = oix0oi2.OOXIXo();
            if (OOXIXo2 != 2) {
                if (OOXIXo2 != 4) {
                    if (OOXIXo2 == 8) {
                        Iterator<DslAdapterItem> it3 = adapterItems2.iterator();
                        int i3 = 0;
                        while (true) {
                            if (it3.hasNext()) {
                                if (IIX0o.Oxx0IOOO(it3.next(), oix0oi2.xoIox())) {
                                    break;
                                } else {
                                    i3++;
                                }
                            } else {
                                i3 = -1;
                                break;
                            }
                        }
                        if (i3 != -1 && (oOoXoXO2 = oix0oi2.oOoXoXO()) != null) {
                            adapterItems2.set(i3, oOoXoXO2);
                        }
                    }
                } else {
                    DslAdapterItem xoIox2 = oix0oi2.xoIox();
                    if (xoIox2 != null) {
                        xoIox2.setItemUpdateFlag(true);
                    }
                }
            } else {
                XoX.oIX0oI(adapterItems2).remove(oix0oi2.xoIox());
            }
        }
        DslAdapter.updateItemDepend$default(this.f5340oIX0oI, null, 1, null);
    }

    public final void oIX0oI(@OOXIXo DslAdapterItem item, @oOoXoXO DslAdapterItem dslAdapterItem) {
        IIX0o.x0xO0oo(item, "item");
        this.f5339II0xO0.add(new oIX0oI(1, null, dslAdapterItem, null, oI0IIXIo.OOXIXo(item), 8, null));
    }

    public final /* synthetic */ <Item extends DslAdapterItem> void oOoXoXO(final x0xO0oo<? super Item, ? super Integer, oXIO0o0XI> init) {
        IIX0o.x0xO0oo(init, "init");
        IIX0o.xoXoI();
        OOXIXo(new x0xO0oo<Integer, DslAdapterItem, Boolean>() { // from class: com.angcyo.dsladapter.data.SingleDataUpdate$updateItem$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ Boolean invoke(Integer num, DslAdapterItem dslAdapterItem) {
                return invoke(num.intValue(), dslAdapterItem);
            }

            @OOXIXo
            public final Boolean invoke(int i, @OOXIXo DslAdapterItem dslAdapterItem) {
                boolean z;
                IIX0o.x0xO0oo(dslAdapterItem, "dslAdapterItem");
                IIX0o.OxI(3, "Item");
                if (dslAdapterItem instanceof DslAdapterItem) {
                    init.invoke(dslAdapterItem, Integer.valueOf(i));
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        });
    }

    public final <Item extends DslAdapterItem> void ooOOo0oXI(@OOXIXo Class<Item> itemClass, @oOoXoXO DslAdapterItem dslAdapterItem, @oOoXoXO List<? extends Object> list, @OOXIXo final IXxxXO<? super Item, Object, ? super Integer, oXIO0o0XI> initItem) {
        final Object obj;
        IIX0o.x0xO0oo(itemClass, "itemClass");
        IIX0o.x0xO0oo(initItem, "initItem");
        ArrayList arrayList = new ArrayList();
        if (dslAdapterItem != null) {
            boolean z = false;
            for (DslAdapterItem dslAdapterItem2 : this.f5340oIX0oI.getAdapterItems()) {
                if (IIX0o.Oxx0IOOO(dslAdapterItem2, dslAdapterItem)) {
                    z = true;
                } else if (!z) {
                    continue;
                } else if (!IIX0o.Oxx0IOOO(LibExKt.x0xO0oo(dslAdapterItem2), LibExKt.x0xO0oo(itemClass))) {
                    break;
                } else {
                    arrayList.add(dslAdapterItem2);
                }
            }
        }
        int Ox0O2 = LibExKt.Ox0O(list);
        ArrayList arrayList2 = new ArrayList();
        DslAdapterItem dslAdapterItem3 = dslAdapterItem;
        for (final int i = 0; i < Ox0O2; i++) {
            if (list != null) {
                obj = CollectionsKt___CollectionsKt.OIoxIx(list, i);
            } else {
                obj = null;
            }
            DslAdapterItem dslAdapterItem4 = (DslAdapterItem) CollectionsKt___CollectionsKt.OIoxIx(arrayList, i);
            DslAdapterItem x0xO0oo2 = UpdateDataConfigKt.x0xO0oo(itemClass, dslAdapterItem4, new Oox.oOoXoXO<Item, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.data.SingleDataUpdate$updateListAt$newItem$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Object obj2) {
                    invoke((DslAdapterItem) obj2);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* JADX WARN: Incorrect types in method signature: (TItem;)V */
                public final void invoke(@OOXIXo DslAdapterItem updateOrCreateItemByClass) {
                    IIX0o.x0xO0oo(updateOrCreateItemByClass, "$this$updateOrCreateItemByClass");
                    initItem.invoke(updateOrCreateItemByClass, obj, Integer.valueOf(i));
                }
            });
            if (dslAdapterItem4 == null) {
                if (x0xO0oo2 != null) {
                    arrayList2.add(x0xO0oo2);
                }
            } else {
                if (x0xO0oo2 == null) {
                    this.f5339II0xO0.add(new oIX0oI(2, dslAdapterItem4, null, null, null, 28, null));
                } else if (!IIX0o.Oxx0IOOO(dslAdapterItem4, x0xO0oo2)) {
                    this.f5339II0xO0.add(new oIX0oI(8, dslAdapterItem4, x0xO0oo2, null, null, 24, null));
                } else if (IIX0o.Oxx0IOOO(dslAdapterItem4, x0xO0oo2)) {
                    this.f5339II0xO0.add(new oIX0oI(4, dslAdapterItem4, null, null, null, 28, null));
                }
                dslAdapterItem3 = dslAdapterItem4;
            }
        }
        int size = arrayList.size();
        while (Ox0O2 < size) {
            this.f5339II0xO0.add(new oIX0oI(2, (DslAdapterItem) arrayList.get(Ox0O2), null, null, null, 28, null));
            Ox0O2++;
        }
        if (!arrayList2.isEmpty()) {
            this.f5339II0xO0.add(new oIX0oI(1, null, dslAdapterItem3, null, arrayList2, 8, null));
        }
    }

    public final /* synthetic */ <Item extends DslAdapterItem> void xoIox() {
        IIX0o.xoXoI();
        OOXIXo(new x0xO0oo<Integer, DslAdapterItem, Boolean>() { // from class: com.angcyo.dsladapter.data.SingleDataUpdate$removeItem$1
            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ Boolean invoke(Integer num, DslAdapterItem dslAdapterItem) {
                return invoke(num.intValue(), dslAdapterItem);
            }

            @OOXIXo
            public final Boolean invoke(int i, @OOXIXo DslAdapterItem dslAdapterItem) {
                IIX0o.x0xO0oo(dslAdapterItem, "dslAdapterItem");
                IIX0o.OxI(3, "Item");
                return Boolean.valueOf(dslAdapterItem instanceof DslAdapterItem);
            }
        });
    }

    public final void xxIXOIIO(@OOXIXo x0xO0oo<? super Integer, ? super DslAdapterItem, Boolean> predicate) {
        IIX0o.x0xO0oo(predicate, "predicate");
        int i = 0;
        for (Object obj : this.f5340oIX0oI.getAdapterItems()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            DslAdapterItem dslAdapterItem = (DslAdapterItem) obj;
            if (predicate.invoke(Integer.valueOf(i), dslAdapterItem).booleanValue()) {
                this.f5339II0xO0.add(new oIX0oI(2, dslAdapterItem, null, null, null, 28, null));
            }
            i = i2;
        }
    }

    /* loaded from: classes7.dex */
    public static final class oIX0oI {

        /* renamed from: II0XooXoX, reason: collision with root package name */
        public static final int f5341II0XooXoX = 1;

        /* renamed from: OOXIXo, reason: collision with root package name */
        public static final int f5342OOXIXo = 8;

        /* renamed from: Oxx0IOOO, reason: collision with root package name */
        public static final int f5343Oxx0IOOO = 0;

        /* renamed from: XO, reason: collision with root package name */
        @OOXIXo
        public static final C0109oIX0oI f5344XO = new C0109oIX0oI(null);

        /* renamed from: xoIox, reason: collision with root package name */
        public static final int f5345xoIox = 4;

        /* renamed from: xxIXOIIO, reason: collision with root package name */
        public static final int f5346xxIXOIIO = 2;

        /* renamed from: I0Io, reason: collision with root package name */
        @oOoXoXO
        public final DslAdapterItem f5347I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        @oOoXoXO
        public final DslAdapterItem f5348II0xO0;

        /* renamed from: X0o0xo, reason: collision with root package name */
        @oOoXoXO
        public final List<DslAdapterItem> f5349X0o0xo;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final int f5350oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        @oOoXoXO
        public final DslAdapterItem f5351oxoX;

        /* renamed from: com.angcyo.dsladapter.data.SingleDataUpdate$oIX0oI$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C0109oIX0oI {
            public /* synthetic */ C0109oIX0oI(IIXOooo iIXOooo) {
                this();
            }

            public C0109oIX0oI() {
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public oIX0oI(int i, @oOoXoXO DslAdapterItem dslAdapterItem, @oOoXoXO DslAdapterItem dslAdapterItem2, @oOoXoXO DslAdapterItem dslAdapterItem3, @oOoXoXO List<? extends DslAdapterItem> list) {
            this.f5350oIX0oI = i;
            this.f5348II0xO0 = dslAdapterItem;
            this.f5347I0Io = dslAdapterItem2;
            this.f5351oxoX = dslAdapterItem3;
            this.f5349X0o0xo = list;
        }

        public static /* synthetic */ oIX0oI Oxx0IOOO(oIX0oI oix0oi, int i, DslAdapterItem dslAdapterItem, DslAdapterItem dslAdapterItem2, DslAdapterItem dslAdapterItem3, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = oix0oi.f5350oIX0oI;
            }
            if ((i2 & 2) != 0) {
                dslAdapterItem = oix0oi.f5348II0xO0;
            }
            DslAdapterItem dslAdapterItem4 = dslAdapterItem;
            if ((i2 & 4) != 0) {
                dslAdapterItem2 = oix0oi.f5347I0Io;
            }
            DslAdapterItem dslAdapterItem5 = dslAdapterItem2;
            if ((i2 & 8) != 0) {
                dslAdapterItem3 = oix0oi.f5351oxoX;
            }
            DslAdapterItem dslAdapterItem6 = dslAdapterItem3;
            if ((i2 & 16) != 0) {
                list = oix0oi.f5349X0o0xo;
            }
            return oix0oi.XO(i, dslAdapterItem4, dslAdapterItem5, dslAdapterItem6, list);
        }

        @oOoXoXO
        public final DslAdapterItem I0Io() {
            return this.f5347I0Io;
        }

        @oOoXoXO
        public final DslAdapterItem II0XooXoX() {
            return this.f5347I0Io;
        }

        @oOoXoXO
        public final DslAdapterItem II0xO0() {
            return this.f5348II0xO0;
        }

        public final int OOXIXo() {
            return this.f5350oIX0oI;
        }

        @oOoXoXO
        public final List<DslAdapterItem> X0o0xo() {
            return this.f5349X0o0xo;
        }

        @OOXIXo
        public final oIX0oI XO(int i, @oOoXoXO DslAdapterItem dslAdapterItem, @oOoXoXO DslAdapterItem dslAdapterItem2, @oOoXoXO DslAdapterItem dslAdapterItem3, @oOoXoXO List<? extends DslAdapterItem> list) {
            return new oIX0oI(i, dslAdapterItem, dslAdapterItem2, dslAdapterItem3, list);
        }

        public boolean equals(@oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof oIX0oI)) {
                return false;
            }
            oIX0oI oix0oi = (oIX0oI) obj;
            return this.f5350oIX0oI == oix0oi.f5350oIX0oI && IIX0o.Oxx0IOOO(this.f5348II0xO0, oix0oi.f5348II0xO0) && IIX0o.Oxx0IOOO(this.f5347I0Io, oix0oi.f5347I0Io) && IIX0o.Oxx0IOOO(this.f5351oxoX, oix0oi.f5351oxoX) && IIX0o.Oxx0IOOO(this.f5349X0o0xo, oix0oi.f5349X0o0xo);
        }

        public int hashCode() {
            int i = this.f5350oIX0oI * 31;
            DslAdapterItem dslAdapterItem = this.f5348II0xO0;
            int hashCode = (i + (dslAdapterItem == null ? 0 : dslAdapterItem.hashCode())) * 31;
            DslAdapterItem dslAdapterItem2 = this.f5347I0Io;
            int hashCode2 = (hashCode + (dslAdapterItem2 == null ? 0 : dslAdapterItem2.hashCode())) * 31;
            DslAdapterItem dslAdapterItem3 = this.f5351oxoX;
            int hashCode3 = (hashCode2 + (dslAdapterItem3 == null ? 0 : dslAdapterItem3.hashCode())) * 31;
            List<DslAdapterItem> list = this.f5349X0o0xo;
            return hashCode3 + (list != null ? list.hashCode() : 0);
        }

        public final int oIX0oI() {
            return this.f5350oIX0oI;
        }

        @oOoXoXO
        public final DslAdapterItem oOoXoXO() {
            return this.f5351oxoX;
        }

        @oOoXoXO
        public final DslAdapterItem oxoX() {
            return this.f5351oxoX;
        }

        @OOXIXo
        public String toString() {
            return "Op(op=" + this.f5350oIX0oI + ", item=" + this.f5348II0xO0 + ", addAnchorItem=" + this.f5347I0Io + ", replaceItem=" + this.f5351oxoX + ", addItemList=" + this.f5349X0o0xo + HexStringBuilder.COMMENT_END_CHAR;
        }

        @oOoXoXO
        public final DslAdapterItem xoIox() {
            return this.f5348II0xO0;
        }

        @oOoXoXO
        public final List<DslAdapterItem> xxIXOIIO() {
            return this.f5349X0o0xo;
        }

        public /* synthetic */ oIX0oI(int i, DslAdapterItem dslAdapterItem, DslAdapterItem dslAdapterItem2, DslAdapterItem dslAdapterItem3, List list, int i2, IIXOooo iIXOooo) {
            this(i, dslAdapterItem, (i2 & 4) != 0 ? null : dslAdapterItem2, (i2 & 8) != 0 ? null : dslAdapterItem3, (i2 & 16) != 0 ? null : list);
        }
    }
}
