package OoIXo;

import jxl.biff.formula.FormulaException;
import jxl.read.biff.xoxXI;

/* loaded from: classes6.dex */
public class xoXoI extends OI0 {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f2546OOXIXo = XxIIOXIXx.X0o0xo.Oxx0IOOO(xoXoI.class);

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public jxl.biff.formula.OxxIIOOXO f2547II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public x0o f2548Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public byte[] f2549X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public Oxx0xo f2550XO;

    /* renamed from: xoIox, reason: collision with root package name */
    public OxxIIOOXO f2551xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public xIoXXXIXo.O0xOxO f2552xxIXOIIO;

    public xoXoI(xoxXI xoxxi, jxl.biff.formula.OxxIIOOXO oxxIIOOXO, x0o x0oVar, xIoXXXIXo.O0xOxO o0xOxO) {
        super(xoxxi);
        this.f2549X0o0xo = xoxxi.I0Io();
        this.f2547II0XooXoX = oxxIIOOXO;
        this.f2548Oxx0IOOO = x0oVar;
        this.f2552xxIXOIIO = o0xOxO;
    }

    private void XoI0Ixx0() {
        if (this.f2550XO == null) {
            this.f2550XO = new Oxx0xo(this.f2549X0o0xo, this.f2547II0XooXoX, this.f2548Oxx0IOOO, this.f2552xxIXOIIO);
        }
    }

    public int I0X0x0oIo() {
        if (this.f2550XO == null) {
            XoI0Ixx0();
        }
        return this.f2550XO.X0o0xo();
    }

    public void I0oOIX(int i) {
        if (this.f2550XO == null) {
            XoI0Ixx0();
        }
        this.f2550XO.OOXIXo(i);
    }

    public void IoOoo(OxxIIOOXO oxxIIOOXO) {
        this.f2551xoIox = oxxIIOOXO;
    }

    public void O0Xx(int i) {
        if (this.f2550XO == null) {
            XoI0Ixx0();
        }
        this.f2550XO.xoIox(i);
    }

    public void OO(int i) {
        if (this.f2550XO == null) {
            XoI0Ixx0();
        }
        this.f2550XO.ooOOo0oXI(i);
    }

    public int Oxx0xo() {
        if (this.f2550XO == null) {
            XoI0Ixx0();
        }
        return this.f2550XO.II0XooXoX();
    }

    public Oxx0xo XX0() {
        return this.f2550XO;
    }

    public String Xo0() {
        try {
            if (this.f2550XO == null) {
                XoI0Ixx0();
            }
            return this.f2550XO.xxIXOIIO();
        } catch (FormulaException e) {
            f2546OOXIXo.ooOOo0oXI("Cannot read drop down range " + e.getMessage());
            return "";
        }
    }

    public int Xx000oIo() {
        if (this.f2550XO == null) {
            XoI0Ixx0();
        }
        return this.f2550XO.Oxx0IOOO();
    }

    public int oX() {
        if (this.f2550XO == null) {
            XoI0Ixx0();
        }
        return this.f2550XO.XO();
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        Oxx0xo oxx0xo = this.f2550XO;
        if (oxx0xo == null) {
            return this.f2549X0o0xo;
        }
        return oxx0xo.oxoX();
    }

    public void xoxXI(int i) {
        if (this.f2550XO == null) {
            XoI0Ixx0();
        }
        this.f2550XO.oOoXoXO(i);
    }

    public xoXoI(xoXoI xoxoi) {
        super(xII.f2522xXoOI00O);
        this.f2549X0o0xo = xoxoi.xo0x();
    }

    public xoXoI(xoXoI xoxoi, jxl.biff.formula.OxxIIOOXO oxxIIOOXO, x0o x0oVar, xIoXXXIXo.O0xOxO o0xOxO) {
        super(xII.f2522xXoOI00O);
        this.f2548Oxx0IOOO = x0oVar;
        this.f2547II0XooXoX = oxxIIOOXO;
        this.f2552xxIXOIIO = o0xOxO;
        XxIIOXIXx.oIX0oI.oIX0oI(x0oVar != null);
        XxIIOXIXx.oIX0oI.oIX0oI(oxxIIOOXO != null);
        byte[] bArr = new byte[xoxoi.f2549X0o0xo.length];
        this.f2549X0o0xo = bArr;
        System.arraycopy(xoxoi.f2549X0o0xo, 0, bArr, 0, bArr.length);
    }

    public xoXoI(Oxx0xo oxx0xo) {
        super(xII.f2522xXoOI00O);
        this.f2550XO = oxx0xo;
    }
}
