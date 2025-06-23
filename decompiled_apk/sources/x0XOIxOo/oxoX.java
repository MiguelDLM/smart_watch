package x0XOIxOo;

import java.util.List;

/* loaded from: classes.dex */
public class oxoX extends XO<IXxxXO.I0Io> {

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public final IXxxXO.I0Io f34003xxIXOIIO;

    public oxoX(List<xoXoI.oIX0oI<IXxxXO.I0Io>> list) {
        super(list);
        IXxxXO.I0Io i0Io = list.get(0).f35166II0xO0;
        int I0Io2 = i0Io != null ? i0Io.I0Io() : 0;
        this.f34003xxIXOIIO = new IXxxXO.I0Io(new float[I0Io2], new int[I0Io2]);
    }

    @Override // x0XOIxOo.oIX0oI
    /* renamed from: x0xO0oo, reason: merged with bridge method [inline-methods] */
    public IXxxXO.I0Io xxIXOIIO(xoXoI.oIX0oI<IXxxXO.I0Io> oix0oi, float f) {
        this.f34003xxIXOIIO.oxoX(oix0oi.f35166II0xO0, oix0oi.f35164I0Io, f);
        return this.f34003xxIXOIIO;
    }
}
