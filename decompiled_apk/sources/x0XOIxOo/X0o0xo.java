package x0XOIxOo;

import java.util.List;

/* loaded from: classes.dex */
public class X0o0xo extends XO<Integer> {
    public X0o0xo(List<xoXoI.oIX0oI<Integer>> list) {
        super(list);
    }

    @Override // x0XOIxOo.oIX0oI
    /* renamed from: IXxxXO, reason: merged with bridge method [inline-methods] */
    public Integer xxIXOIIO(xoXoI.oIX0oI<Integer> oix0oi, float f) {
        return Integer.valueOf(Oo(oix0oi, f));
    }

    public int Oo(xoXoI.oIX0oI<Integer> oix0oi, float f) {
        Integer num;
        if (oix0oi.f35166II0xO0 != null && oix0oi.f35164I0Io != null) {
            xoXoI.xoIox<A> xoiox = this.f33971X0o0xo;
            if (xoiox != 0 && (num = (Integer) xoiox.II0xO0(oix0oi.f35168Oxx0IOOO, oix0oi.f35165II0XooXoX.floatValue(), oix0oi.f35166II0xO0, oix0oi.f35164I0Io, f, X0o0xo(), XO())) != null) {
                return num.intValue();
            }
            return IIXOooo.xxIXOIIO.oOoXoXO(oix0oi.Oxx0IOOO(), oix0oi.oxoX(), f);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    public int x0xO0oo() {
        return Oo(II0xO0(), oxoX());
    }
}
