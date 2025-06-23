package x0XOIxOo;

import java.util.List;

/* loaded from: classes.dex */
public class I0Io extends XO<Float> {
    public I0Io(List<xoXoI.oIX0oI<Float>> list) {
        super(list);
    }

    @Override // x0XOIxOo.oIX0oI
    /* renamed from: IXxxXO, reason: merged with bridge method [inline-methods] */
    public Float xxIXOIIO(xoXoI.oIX0oI<Float> oix0oi, float f) {
        return Float.valueOf(Oo(oix0oi, f));
    }

    public float Oo(xoXoI.oIX0oI<Float> oix0oi, float f) {
        Float f2;
        if (oix0oi.f35166II0xO0 != null && oix0oi.f35164I0Io != null) {
            xoXoI.xoIox<A> xoiox = this.f33971X0o0xo;
            if (xoiox != 0 && (f2 = (Float) xoiox.II0xO0(oix0oi.f35168Oxx0IOOO, oix0oi.f35165II0XooXoX.floatValue(), oix0oi.f35166II0xO0, oix0oi.f35164I0Io, f, X0o0xo(), XO())) != null) {
                return f2.floatValue();
            }
            return IIXOooo.xxIXOIIO.OOXIXo(oix0oi.XO(), oix0oi.I0Io(), f);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    public float x0xO0oo() {
        return Oo(II0xO0(), oxoX());
    }
}
