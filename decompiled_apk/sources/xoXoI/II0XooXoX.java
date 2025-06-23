package xoXoI;

/* loaded from: classes.dex */
public class II0XooXoX extends xoIox<Integer> {
    /* JADX WARN: Multi-variable type inference failed */
    public Integer X0o0xo(II0xO0<Integer> iI0xO0) {
        T t = this.f35180I0Io;
        if (t != 0) {
            return (Integer) t;
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }

    @Override // xoXoI.xoIox
    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public Integer oIX0oI(II0xO0<Integer> iI0xO0) {
        return Integer.valueOf(IIXOooo.xxIXOIIO.oOoXoXO(iI0xO0.Oxx0IOOO().intValue(), iI0xO0.II0xO0().intValue(), iI0xO0.I0Io()) + X0o0xo(iI0xO0).intValue());
    }
}
