package jxl.biff.formula;

/* loaded from: classes6.dex */
public class x0XOIxOo extends I0Io {

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f27987x0xO0oo = XxIIOXIXx.X0o0xo.Oxx0IOOO(x0XOIxOo.class);

    public x0XOIxOo() {
    }

    @Override // jxl.biff.formula.I0Io, jxl.biff.formula.OI0
    public void XO(StringBuffer stringBuffer) {
        OoIXo.oOoXoXO.xxIXOIIO(IXxxXO(), stringBuffer);
        stringBuffer.append(':');
        OoIXo.oOoXoXO.xxIXOIIO(oI0IIXIo(), stringBuffer);
    }

    public x0XOIxOo(String str) {
        int indexOf = str.indexOf(":");
        XxIIOXIXx.oIX0oI.oIX0oI(indexOf != -1);
        String substring = str.substring(0, indexOf);
        String substring2 = str.substring(indexOf + 1);
        IIXOooo(OoIXo.oOoXoXO.Oxx0IOOO(substring), OoIXo.oOoXoXO.Oxx0IOOO(substring2), 0, 65535, OoIXo.oOoXoXO.ooOOo0oXI(substring), OoIXo.oOoXoXO.ooOOo0oXI(substring2), false, false);
    }
}
