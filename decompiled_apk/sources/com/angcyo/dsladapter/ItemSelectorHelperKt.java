package com.angcyo.dsladapter;

import androidx.recyclerview.widget.RecyclerView;
import com.angcyo.dsladapter.Xx000oIo;
import java.util.List;
import kotlin.oXIO0o0XI;

/* loaded from: classes7.dex */
public final class ItemSelectorHelperKt {

    /* loaded from: classes7.dex */
    public static final class oIX0oI implements Xx000oIo {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ Oox.Oxx0xo<List<DslAdapterItem>, List<Integer>, Boolean, IO, oXIO0o0XI> f5257oIX0oI;

        /* JADX WARN: Multi-variable type inference failed */
        public oIX0oI(Oox.Oxx0xo<? super List<DslAdapterItem>, ? super List<Integer>, ? super Boolean, ? super IO, oXIO0o0XI> oxx0xo) {
            this.f5257oIX0oI = oxx0xo;
        }

        @Override // com.angcyo.dsladapter.Xx000oIo
        public void II0xO0(@OXOo.OOXIXo List<DslAdapterItem> selectorItems, @OXOo.OOXIXo List<Integer> selectorIndexList, boolean z, @OXOo.OOXIXo IO selectorParams) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(selectorItems, "selectorItems");
            kotlin.jvm.internal.IIX0o.x0xO0oo(selectorIndexList, "selectorIndexList");
            kotlin.jvm.internal.IIX0o.x0xO0oo(selectorParams, "selectorParams");
            this.f5257oIX0oI.invoke(selectorItems, selectorIndexList, Boolean.valueOf(z), selectorParams);
        }

        @Override // com.angcyo.dsladapter.Xx000oIo
        public void oIX0oI(int i, int i2) {
            Xx000oIo.oIX0oI.II0xO0(this, i, i2);
        }
    }

    @OXOo.OOXIXo
    public static final List<Integer> I0Io(@OXOo.OOXIXo DslAdapter dslAdapter, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        return oI0IIXIo(dslAdapter).x0XOIxOo(z);
    }

    public static final void II0XooXoX(@OXOo.oOoXoXO DslAdapter dslAdapter) {
        ItemSelectorHelper itemSelectorHelper;
        if (dslAdapter != null) {
            itemSelectorHelper = dslAdapter.getItemSelectorHelper();
        } else {
            itemSelectorHelper = null;
        }
        if (itemSelectorHelper != null) {
            itemSelectorHelper.IoOoX(2);
        }
    }

    public static final void IIXOooo(@OXOo.oOoXoXO DslAdapter dslAdapter) {
        ItemSelectorHelper itemSelectorHelper;
        if (dslAdapter != null) {
            itemSelectorHelper = dslAdapter.getItemSelectorHelper();
        } else {
            itemSelectorHelper = null;
        }
        if (itemSelectorHelper != null) {
            itemSelectorHelper.IoOoX(1);
        }
    }

    public static /* synthetic */ void IXxxXO(DslAdapterItem dslAdapterItem, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            oooxoxo = new Oox.oOoXoXO<IO, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.ItemSelectorHelperKt$select$1
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
        oO(dslAdapterItem, oooxoxo);
    }

    public static final void OOXIXo(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.OOXIXo final Oox.Oxx0xo<? super List<DslAdapterItem>, ? super List<Integer>, ? super Boolean, ? super IO, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        oI0IIXIo(dslAdapter).oI0IIXIo(new Oox.oOoXoXO<x0XOIxOo, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.ItemSelectorHelperKt$observerSelectorChangeListener$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(x0XOIxOo x0xoixoo) {
                invoke2(x0xoixoo);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo x0XOIxOo observer) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(observer, "$this$observer");
                observer.X0o0xo(action);
            }
        });
    }

    public static /* synthetic */ void Oo(DslAdapter dslAdapter, DslAdapterItem dslAdapterItem, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        x0XOIxOo(dslAdapter, dslAdapterItem, z);
    }

    public static final void Oxx0IOOO(@OXOo.oOoXoXO RecyclerView recyclerView) {
        RecyclerView.Adapter adapter;
        DslAdapter dslAdapter = null;
        if (recyclerView != null) {
            adapter = recyclerView.getAdapter();
        } else {
            adapter = null;
        }
        if (adapter instanceof DslAdapter) {
            dslAdapter = (DslAdapter) adapter;
        }
        if (dslAdapter != null) {
            II0XooXoX(dslAdapter);
        }
    }

    public static final void Oxx0xo(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.OOXIXo DslAdapterItem dslItem) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslItem, "dslItem");
        oI0IIXIo(dslAdapter).X0IIOO(new IO(dslItem, 0, false, false, false, null, false, false, false, null, 1020, null));
    }

    public static final void OxxIIOOXO(@OXOo.oOoXoXO RecyclerView recyclerView) {
        RecyclerView.Adapter adapter;
        DslAdapter dslAdapter = null;
        if (recyclerView != null) {
            adapter = recyclerView.getAdapter();
        } else {
            adapter = null;
        }
        if (adapter instanceof DslAdapter) {
            dslAdapter = (DslAdapter) adapter;
        }
        if (dslAdapter != null) {
            IIXOooo(dslAdapter);
        }
    }

    @OXOo.OOXIXo
    public static final List<DslAdapterItem> X0o0xo(@OXOo.OOXIXo DslAdapter dslAdapter, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        return oI0IIXIo(dslAdapter).x0xO0oo(z);
    }

    public static /* synthetic */ List XO(DslAdapter dslAdapter, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return X0o0xo(dslAdapter, z);
    }

    @OXOo.OOXIXo
    public static final ItemSelectorHelper oI0IIXIo(@OXOo.OOXIXo DslAdapter dslAdapter) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        return dslAdapter.getItemSelectorHelper();
    }

    public static final String oIX0oI(int i) {
        if (i != 1) {
            if (i != 2) {
                return "MODEL_NORMAL";
            }
            return "MODEL_MULTI";
        }
        return "MODEL_SINGLE";
    }

    public static final void oO(@OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo Oox.oOoXoXO<? super IO, oXIO0o0XI> action) {
        ItemSelectorHelper oI0IIXIo2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        DslAdapter itemDslAdapter = dslAdapterItem.getItemDslAdapter();
        if (itemDslAdapter != null && (oI0IIXIo2 = oI0IIXIo(itemDslAdapter)) != null) {
            oI0IIXIo2.OxI(dslAdapterItem, action);
        }
    }

    public static final void oOoXoXO(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.OOXIXo Oox.Oxx0xo<? super List<DslAdapterItem>, ? super List<Integer>, ? super Boolean, ? super IO, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        oI0IIXIo(dslAdapter).oo(new oIX0oI(action));
    }

    @OXOo.oOoXoXO
    public static final DslAdapterItem ooOOo0oXI(@OXOo.OOXIXo DslAdapter dslAdapter, boolean z, @OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapterItem, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        DslAdapterItem xI2 = DslAdapterExKt.xI(dslAdapter, true, predicate);
        if (xI2 != null) {
            oI0IIXIo(dslAdapter).X0IIOO(new IO(xI2, xoXoI(z), false, false, false, null, false, false, false, null, 1020, null));
        } else {
            xI2 = null;
        }
        return (DslAdapterItem) LibExKt.XIxXXX0x0(xI2, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.angcyo.dsladapter.ItemSelectorHelperKt$select$3
            @Override // Oox.oIX0oI
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                invoke2();
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                L.f5267oIX0oI.oo0xXOI0I("未找到需要选择操作的[DslAdapterItem]");
            }
        });
    }

    public static /* synthetic */ List oxoX(DslAdapter dslAdapter, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return I0Io(dslAdapter, z);
    }

    public static final void x0XOIxOo(@OXOo.OOXIXo DslAdapter dslAdapter, @OXOo.OOXIXo DslAdapterItem dslItem, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslItem, "dslItem");
        oI0IIXIo(dslAdapter).X0IIOO(new IO(dslItem, xoXoI(z), false, false, false, null, false, false, false, null, 1020, null));
    }

    public static /* synthetic */ DslAdapterItem x0xO0oo(DslAdapter dslAdapter, boolean z, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return ooOOo0oXI(dslAdapter, z, oooxoxo);
    }

    public static final void xoIox(@OXOo.oOoXoXO DslAdapter dslAdapter) {
        ItemSelectorHelper itemSelectorHelper;
        if (dslAdapter != null) {
            itemSelectorHelper = dslAdapter.getItemSelectorHelper();
        } else {
            itemSelectorHelper = null;
        }
        if (itemSelectorHelper != null) {
            itemSelectorHelper.IoOoX(0);
        }
    }

    public static final int xoXoI(boolean z) {
        return z ? 1 : 2;
    }

    public static final void xxIXOIIO(@OXOo.oOoXoXO RecyclerView recyclerView) {
        RecyclerView.Adapter adapter;
        DslAdapter dslAdapter = null;
        if (recyclerView != null) {
            adapter = recyclerView.getAdapter();
        } else {
            adapter = null;
        }
        if (adapter instanceof DslAdapter) {
            dslAdapter = (DslAdapter) adapter;
        }
        if (dslAdapter != null) {
            xoIox(dslAdapter);
        }
    }
}
