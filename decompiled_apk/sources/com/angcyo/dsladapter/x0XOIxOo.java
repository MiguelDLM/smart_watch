package com.angcyo.dsladapter;

import com.angcyo.dsladapter.Xx000oIo;
import java.util.List;
import kotlin.oXIO0o0XI;

/* loaded from: classes7.dex */
public final class x0XOIxOo implements Xx000oIo {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Oox.Oxx0xo<? super List<DslAdapterItem>, ? super List<Integer>, ? super Boolean, ? super IO, oXIO0o0XI> f5447II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Oox.x0xO0oo<? super Integer, ? super Integer, oXIO0o0XI> f5448oIX0oI;

    @OXOo.oOoXoXO
    public final Oox.Oxx0xo<List<DslAdapterItem>, List<Integer>, Boolean, IO, oXIO0o0XI> I0Io() {
        return this.f5447II0xO0;
    }

    @Override // com.angcyo.dsladapter.Xx000oIo
    public void II0xO0(@OXOo.OOXIXo List<DslAdapterItem> selectorItems, @OXOo.OOXIXo List<Integer> selectorIndexList, boolean z, @OXOo.OOXIXo IO selectorParams) {
        oXIO0o0XI oxio0o0xi;
        kotlin.jvm.internal.IIX0o.x0xO0oo(selectorItems, "selectorItems");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selectorIndexList, "selectorIndexList");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selectorParams, "selectorParams");
        Oox.Oxx0xo<? super List<DslAdapterItem>, ? super List<Integer>, ? super Boolean, ? super IO, oXIO0o0XI> oxx0xo = this.f5447II0xO0;
        if (oxx0xo != null) {
            oxx0xo.invoke(selectorItems, selectorIndexList, Boolean.valueOf(z), selectorParams);
            oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        } else {
            oxio0o0xi = null;
        }
        if (oxio0o0xi == null) {
            Xx000oIo.oIX0oI.oIX0oI(this, selectorItems, selectorIndexList, z, selectorParams);
        }
    }

    public final void X0o0xo(@OXOo.oOoXoXO Oox.Oxx0xo<? super List<DslAdapterItem>, ? super List<Integer>, ? super Boolean, ? super IO, oXIO0o0XI> oxx0xo) {
        this.f5447II0xO0 = oxx0xo;
    }

    public final void XO(@OXOo.oOoXoXO Oox.x0xO0oo<? super Integer, ? super Integer, oXIO0o0XI> x0xo0oo) {
        this.f5448oIX0oI = x0xo0oo;
    }

    @Override // com.angcyo.dsladapter.Xx000oIo
    public void oIX0oI(int i, int i2) {
        oXIO0o0XI oxio0o0xi;
        Oox.x0xO0oo<? super Integer, ? super Integer, oXIO0o0XI> x0xo0oo = this.f5448oIX0oI;
        if (x0xo0oo != null) {
            x0xo0oo.invoke(Integer.valueOf(i), Integer.valueOf(i2));
            oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        } else {
            oxio0o0xi = null;
        }
        if (oxio0o0xi == null) {
            Xx000oIo.oIX0oI.II0xO0(this, i, i2);
        }
    }

    @OXOo.oOoXoXO
    public final Oox.x0xO0oo<Integer, Integer, oXIO0o0XI> oxoX() {
        return this.f5448oIX0oI;
    }
}
