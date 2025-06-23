package x0XOIxOo;

import java.util.List;

/* loaded from: classes.dex */
public class II0xO0 extends XO<Integer> {
    public II0xO0(List<xoXoI.oIX0oI<Integer>> list) {
        super(list);
    }

    @Override // x0XOIxOo.oIX0oI
    /* renamed from: IXxxXO, reason: merged with bridge method [inline-methods] */
    public Integer xxIXOIIO(xoXoI.oIX0oI<Integer> oix0oi, float f) {
        return Integer.valueOf(Oo(oix0oi, f));
    }

    public int Oo(xoXoI.oIX0oI<Integer> oix0oi, float f) {
        Integer num;
        Integer num2 = oix0oi.f35166II0xO0;
        if (num2 != null && oix0oi.f35164I0Io != null) {
            Integer num3 = num2;
            int intValue = num3.intValue();
            Integer num4 = oix0oi.f35164I0Io;
            int intValue2 = num4.intValue();
            xoXoI.xoIox<A> xoiox = this.f33971X0o0xo;
            if (xoiox != 0 && (num = (Integer) xoiox.II0xO0(oix0oi.f35168Oxx0IOOO, oix0oi.f35165II0XooXoX.floatValue(), num3, num4, f, X0o0xo(), XO())) != null) {
                return num.intValue();
            }
            return IIXOooo.oxoX.I0Io(IIXOooo.xxIXOIIO.I0Io(f, 0.0f, 1.0f), intValue, intValue2);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    public int x0xO0oo() {
        return Oo(II0xO0(), oxoX());
    }
}
