package com.angcyo.dsladapter.data;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.IXxxXO;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.LibExKt;
import com.angcyo.dsladapter.XxX0x0xxx;
import com.angcyo.dsladapter.data.Page;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes7.dex */
public final class UpdateDataConfig {

    /* renamed from: I0Io, reason: collision with root package name */
    public int f5352I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OOXIXo
    public IXxxXO<? super DslAdapterItem, Object, ? super Integer, ? extends DslAdapterItem> f5353II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f5354II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @OOXIXo
    public Oox.oIX0oI<Integer> f5355Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f5356X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    @OOXIXo
    public XxX0x0xxx f5357XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f5358oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @oOoXoXO
    public List<? extends Object> f5359oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    @OOXIXo
    public Oox.oOoXoXO<? super DslAdapter, oXIO0o0XI> f5360xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OOXIXo
    public Oox.oOoXoXO<? super DslAdapter, oXIO0o0XI> f5361xxIXOIIO;

    public UpdateDataConfig() {
        Page.oIX0oI oix0oi = Page.Companion;
        this.f5358oIX0oI = oix0oi.oIX0oI();
        this.f5354II0xO0 = oix0oi.oIX0oI();
        this.f5352I0Io = oix0oi.oxoX();
        XxX0x0xxx xxX0x0xxx = new XxX0x0xxx(null, false, false, false, false, false, null, null, 0L, 0L, null, 2047, null);
        xxX0x0xxx.XxX0x0xxx(CollectionsKt__CollectionsKt.X00IoxXI(1, 2));
        this.f5357XO = xxX0x0xxx;
        this.f5355Oxx0IOOO = new Oox.oIX0oI<Integer>() { // from class: com.angcyo.dsladapter.data.UpdateDataConfig$updateSize$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OOXIXo
            public final Integer invoke() {
                List<Object> Oxx0IOOO2;
                int i = 0;
                if (!LibExKt.O0Xx(UpdateDataConfig.this.Oxx0IOOO()) && (Oxx0IOOO2 = UpdateDataConfig.this.Oxx0IOOO()) != null) {
                    i = Oxx0IOOO2.size();
                }
                int X0o0xo2 = UpdateDataConfig.this.X0o0xo();
                if (i <= X0o0xo2) {
                    i = Math.min(X0o0xo2, i);
                }
                return Integer.valueOf(i);
            }
        };
        this.f5353II0XooXoX = new IXxxXO<DslAdapterItem, Object, Integer, DslAdapterItem>() { // from class: com.angcyo.dsladapter.data.UpdateDataConfig$updateOrCreateItem$1
            @oOoXoXO
            public final DslAdapterItem invoke(@oOoXoXO DslAdapterItem dslAdapterItem, @oOoXoXO Object obj, int i) {
                return dslAdapterItem;
            }

            @Override // Oox.IXxxXO
            public /* bridge */ /* synthetic */ DslAdapterItem invoke(DslAdapterItem dslAdapterItem, Object obj, Integer num) {
                return invoke(dslAdapterItem, obj, num.intValue());
            }
        };
        this.f5361xxIXOIIO = new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.data.UpdateDataConfig$adapterUpdateResult$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter) {
                invoke2(dslAdapter);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OOXIXo DslAdapter dslAdapter) {
                IIX0o.x0xO0oo(dslAdapter, "dslAdapter");
                if (dslAdapter.getDataItems().isEmpty() && dslAdapter.getHeaderItems().isEmpty() && dslAdapter.getFooterItems().isEmpty()) {
                    DslAdapter.setAdapterStatus$default(dslAdapter, 1, null, 2, null);
                } else {
                    DslAdapter.setAdapterStatus$default(dslAdapter, 0, null, 2, null);
                }
                UpdateDataConfig.this.oIX0oI().invoke(dslAdapter);
            }
        };
        this.f5360xoIox = new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.data.UpdateDataConfig$adapterCheckLoadMore$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter) {
                invoke2(dslAdapter);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OOXIXo DslAdapter dslAdapter) {
                IIX0o.x0xO0oo(dslAdapter, "dslAdapter");
                LoadDataExKt.X0o0xo(dslAdapter, UpdateDataConfig.this.xxIXOIIO(), UpdateDataConfig.this.xoIox().invoke().intValue(), UpdateDataConfig.this.X0o0xo(), UpdateDataConfig.this.I0Io());
            }
        };
    }

    public final boolean I0Io() {
        return this.f5356X0o0xo;
    }

    @OOXIXo
    public final IXxxXO<DslAdapterItem, Object, Integer, DslAdapterItem> II0XooXoX() {
        return this.f5353II0XooXoX;
    }

    @OOXIXo
    public final Oox.oOoXoXO<DslAdapter, oXIO0o0XI> II0xO0() {
        return this.f5361xxIXOIIO;
    }

    public final void IXxxXO(@OOXIXo IXxxXO<? super DslAdapterItem, Object, ? super Integer, ? extends DslAdapterItem> iXxxXO) {
        IIX0o.x0xO0oo(iXxxXO, "<set-?>");
        this.f5353II0XooXoX = iXxxXO;
    }

    public final void OOXIXo(@OOXIXo Oox.oOoXoXO<? super DslAdapter, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "<set-?>");
        this.f5360xoIox = oooxoxo;
    }

    public final void Oo(@oOoXoXO List<? extends Object> list) {
        this.f5359oxoX = list;
    }

    @oOoXoXO
    public final List<Object> Oxx0IOOO() {
        return this.f5359oxoX;
    }

    public final void Oxx0xo(int i) {
        this.f5354II0xO0 = i;
    }

    public final int X0o0xo() {
        return this.f5352I0Io;
    }

    public final int XO() {
        return this.f5358oIX0oI;
    }

    public final void oI0IIXIo(@OOXIXo Oox.oIX0oI<Integer> oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<set-?>");
        this.f5355Oxx0IOOO = oix0oi;
    }

    @OOXIXo
    public final Oox.oOoXoXO<DslAdapter, oXIO0o0XI> oIX0oI() {
        return this.f5360xoIox;
    }

    public final void oO(int i) {
        this.f5352I0Io = i;
    }

    public final void oOoXoXO(@OOXIXo Oox.oOoXoXO<? super DslAdapter, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "<set-?>");
        this.f5361xxIXOIIO = oooxoxo;
    }

    public final void ooOOo0oXI(boolean z) {
        this.f5356X0o0xo = z;
    }

    @OOXIXo
    public final XxX0x0xxx oxoX() {
        return this.f5357XO;
    }

    public final void x0XOIxOo(@OOXIXo XxX0x0xxx xxX0x0xxx) {
        IIX0o.x0xO0oo(xxX0x0xxx, "<set-?>");
        this.f5357XO = xxX0x0xxx;
    }

    public final void x0xO0oo(int i) {
        this.f5358oIX0oI = i;
    }

    @OOXIXo
    public final Oox.oIX0oI<Integer> xoIox() {
        return this.f5355Oxx0IOOO;
    }

    public final int xxIXOIIO() {
        return this.f5354II0xO0;
    }
}
