package x0XOIxOo;

import java.util.List;

/* loaded from: classes.dex */
public class OOXIXo extends XO<xoXoI.OOXIXo> {

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public final xoXoI.OOXIXo f33963xxIXOIIO;

    public OOXIXo(List<xoXoI.oIX0oI<xoXoI.OOXIXo>> list) {
        super(list);
        this.f33963xxIXOIIO = new xoXoI.OOXIXo();
    }

    @Override // x0XOIxOo.oIX0oI
    /* renamed from: x0xO0oo, reason: merged with bridge method [inline-methods] */
    public xoXoI.OOXIXo xxIXOIIO(xoXoI.oIX0oI<xoXoI.OOXIXo> oix0oi, float f) {
        xoXoI.OOXIXo oOXIXo;
        xoXoI.OOXIXo oOXIXo2;
        xoXoI.OOXIXo oOXIXo3 = oix0oi.f35166II0xO0;
        if (oOXIXo3 != null && (oOXIXo = oix0oi.f35164I0Io) != null) {
            xoXoI.OOXIXo oOXIXo4 = oOXIXo3;
            xoXoI.OOXIXo oOXIXo5 = oOXIXo;
            xoXoI.xoIox<A> xoiox = this.f33971X0o0xo;
            if (xoiox != 0 && (oOXIXo2 = (xoXoI.OOXIXo) xoiox.II0xO0(oix0oi.f35168Oxx0IOOO, oix0oi.f35165II0XooXoX.floatValue(), oOXIXo4, oOXIXo5, f, X0o0xo(), XO())) != null) {
                return oOXIXo2;
            }
            this.f33963xxIXOIIO.oxoX(IIXOooo.xxIXOIIO.OOXIXo(oOXIXo4.II0xO0(), oOXIXo5.II0xO0(), f), IIXOooo.xxIXOIIO.OOXIXo(oOXIXo4.I0Io(), oOXIXo5.I0Io(), f));
            return this.f33963xxIXOIIO;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
