package jxl.biff.formula;

/* loaded from: classes6.dex */
public class ooOOo0oXI extends II0xO0 {

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f27984oI0IIXIo = XxIIOXIXx.X0o0xo.Oxx0IOOO(ooOOo0oXI.class);

    /* renamed from: IXxxXO, reason: collision with root package name */
    public OxxIIOOXO f27985IXxxXO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f27986Oxx0xo;

    public ooOOo0oXI(OxxIIOOXO oxxIIOOXO) {
        super(oxxIIOOXO);
        this.f27985IXxxXO = oxxIIOOXO;
    }

    @Override // jxl.biff.formula.II0xO0, jxl.biff.formula.OI0
    public void XO(StringBuffer stringBuffer) {
        stringBuffer.append('\'');
        stringBuffer.append(this.f27985IXxxXO.oIX0oI(this.f27986Oxx0xo));
        stringBuffer.append('\'');
        stringBuffer.append(OoIXo.oOoXoXO.f2346I0Io);
        OoIXo.oOoXoXO.xxIXOIIO(IXxxXO(), stringBuffer);
        stringBuffer.append(':');
        OoIXo.oOoXoXO.xxIXOIIO(oI0IIXIo(), stringBuffer);
    }

    public ooOOo0oXI(String str, OxxIIOOXO oxxIIOOXO) throws FormulaException {
        super(oxxIIOOXO);
        this.f27985IXxxXO = oxxIIOOXO;
        int lastIndexOf = str.lastIndexOf(":");
        XxIIOXIXx.oIX0oI.oIX0oI(lastIndexOf != -1);
        str.substring(0, lastIndexOf);
        String substring = str.substring(lastIndexOf + 1);
        int indexOf = str.indexOf(33);
        int Oxx0IOOO2 = OoIXo.oOoXoXO.Oxx0IOOO(str.substring(indexOf + 1, lastIndexOf));
        String substring2 = str.substring(0, indexOf);
        substring2.lastIndexOf(93);
        if (substring2.charAt(0) == '\'' && substring2.charAt(substring2.length() - 1) == '\'') {
            substring2 = substring2.substring(1, substring2.length() - 1);
        }
        int XO2 = oxxIIOOXO.XO(substring2);
        this.f27986Oxx0xo = XO2;
        if (XO2 >= 0) {
            IIXOooo(this.f27986Oxx0xo, Oxx0IOOO2, OoIXo.oOoXoXO.Oxx0IOOO(substring), 0, 65535, true, true, true, true);
            return;
        }
        throw new FormulaException(FormulaException.SHEET_REF_NOT_FOUND, substring2);
    }
}
