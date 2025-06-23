package XIXIX;

import XIXIX.II0XooXoX;
import java.util.List;

/* loaded from: classes9.dex */
public class XO extends II0XooXoX.oIX0oI {

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static II0XooXoX<XO> f3773oI0IIXIo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public double f3774IXxxXO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public double f3775Oxx0xo;

    static {
        II0XooXoX<XO> oIX0oI2 = II0XooXoX.oIX0oI(64, new XO(OOXIXo.f3760XO, OOXIXo.f3760XO));
        f3773oI0IIXIo = oIX0oI2;
        oIX0oI2.oOoXoXO(0.5f);
    }

    public XO(double d, double d2) {
        this.f3774IXxxXO = d;
        this.f3775Oxx0xo = d2;
    }

    public static void I0Io(XO xo2) {
        f3773oI0IIXIo.Oxx0IOOO(xo2);
    }

    public static XO II0xO0(double d, double d2) {
        XO II0xO02 = f3773oI0IIXIo.II0xO0();
        II0xO02.f3774IXxxXO = d;
        II0xO02.f3775Oxx0xo = d2;
        return II0xO02;
    }

    public static void oxoX(List<XO> list) {
        f3773oI0IIXIo.II0XooXoX(list);
    }

    @Override // XIXIX.II0XooXoX.oIX0oI
    public II0XooXoX.oIX0oI oIX0oI() {
        return new XO(OOXIXo.f3760XO, OOXIXo.f3760XO);
    }

    public String toString() {
        return "MPPointD, x: " + this.f3774IXxxXO + ", y: " + this.f3775Oxx0xo;
    }
}
