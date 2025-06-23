package jxl.biff.formula;

import jxl.biff.NameRangeException;

/* loaded from: classes6.dex */
public class IoOoX extends IO implements o0 {

    /* renamed from: xoIox, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f27685xoIox = XxIIOXIXx.X0o0xo.Oxx0IOOO(IoOoX.class);

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public String f27686II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public OoIXo.x0o f27687Oxx0IOOO;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f27688xxIXOIIO;

    public IoOoX(OoIXo.x0o x0oVar) {
        this.f27687Oxx0IOOO = x0oVar;
        XxIIOXIXx.oIX0oI.oIX0oI(x0oVar != null);
    }

    @Override // jxl.biff.formula.OI0
    public void Oxx0IOOO() {
        ooOOo0oXI();
    }

    @Override // jxl.biff.formula.OI0
    public void XO(StringBuffer stringBuffer) {
        stringBuffer.append(this.f27686II0XooXoX);
    }

    @Override // jxl.biff.formula.OI0
    public byte[] oxoX() {
        byte[] bArr = new byte[5];
        xoxXI xoxxi = xoxXI.f28045x0xO0oo;
        bArr[0] = xoxxi.X0o0xo();
        if (X0o0xo() == XOxIOxOx.f27730II0xO0) {
            bArr[0] = xoxxi.I0Io();
        }
        OoIXo.oo0xXOI0I.XO(this.f27688xxIXOIIO, bArr, 1);
        return bArr;
    }

    @Override // jxl.biff.formula.o0
    public int read(byte[] bArr, int i) throws FormulaException {
        try {
            int I0Io2 = OoIXo.oo0xXOI0I.I0Io(bArr[i], bArr[i + 1]);
            this.f27688xxIXOIIO = I0Io2;
            this.f27686II0XooXoX = this.f27687Oxx0IOOO.oxoX(I0Io2 - 1);
            return 4;
        } catch (NameRangeException unused) {
            throw new FormulaException(FormulaException.CELL_NAME_NOT_FOUND, "");
        }
    }

    public IoOoX(String str, OoIXo.x0o x0oVar) throws FormulaException {
        this.f27686II0XooXoX = str;
        this.f27687Oxx0IOOO = x0oVar;
        int xxIXOIIO2 = x0oVar.xxIXOIIO(str);
        this.f27688xxIXOIIO = xxIXOIIO2;
        if (xxIXOIIO2 >= 0) {
            this.f27688xxIXOIIO = xxIXOIIO2 + 1;
            return;
        }
        throw new FormulaException(FormulaException.CELL_NAME_NOT_FOUND, this.f27686II0XooXoX);
    }
}
