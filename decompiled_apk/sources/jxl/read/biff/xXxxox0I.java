package jxl.read.biff;

/* loaded from: classes6.dex */
public class xXxxox0I extends oOoXoXO {

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public oOoXoXO f28512oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public boolean f28513ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28511x0XOIxOo = XxIIOXIXx.X0o0xo.Oxx0IOOO(xXxxox0I.class);

    /* renamed from: oO, reason: collision with root package name */
    public static final II0xO0 f28510oO = new II0xO0();

    /* loaded from: classes6.dex */
    public static class II0xO0 {
        public II0xO0() {
        }
    }

    public xXxxox0I(xoxXI xoxxi, XIxXXX0x0 xIxXXX0x0, OoIXo.xXxxox0I xxxxox0i, jxl.biff.formula.OxxIIOOXO oxxIIOOXO, OoIXo.x0o x0oVar, I0 i0, xIoXXXIXo.O0xOxO o0xOxO) {
        super(xoxxi, xxxxox0i, i0);
        byte[] I0Io2 = oxXx0IX().I0Io();
        this.f28513ooOOo0oXI = false;
        if ((OoIXo.oo0xXOI0I.I0Io(I0Io2[14], I0Io2[15]) & 8) != 0) {
            this.f28513ooOOo0oXI = true;
            byte b = I0Io2[6];
            if (b == 0 && I0Io2[12] == -1 && I0Io2[13] == -1) {
                this.f28512oOoXoXO = new IIxOXoOo0(xoxxi, xIxXXX0x0, xxxxox0i, oxxIIOOXO, x0oVar, i0, o0xOxO);
                return;
            }
            if (b == 3 && I0Io2[12] == -1 && I0Io2[13] == -1) {
                this.f28512oOoXoXO = new IIxOXoOo0(xoxxi, xIxXXX0x0, xxxxox0i, oxxIIOOXO, x0oVar, i0, IIxOXoOo0.f28192Oxx0xo);
                return;
            }
            if (b == 2 && I0Io2[12] == -1 && I0Io2[13] == -1) {
                this.f28512oOoXoXO = new O00XxXI(xoxxi, xIxXXX0x0, I0Io2[8], xxxxox0i, oxxIIOOXO, x0oVar, i0);
                return;
            }
            if (b == 1 && I0Io2[12] == -1 && I0Io2[13] == -1) {
                this.f28512oOoXoXO = new XX0xXo(xoxxi, xIxXXX0x0, I0Io2[8] == 1, xxxxox0i, oxxIIOOXO, x0oVar, i0);
                return;
            }
            OOXIxO0 oOXIxO0 = new OOXIxO0(xoxxi, xIxXXX0x0, OoIXo.OxI.II0xO0(I0Io2, 6), xxxxox0i, oxxIIOOXO, x0oVar, i0);
            oOXIxO0.O0Xx(xxxxox0i.Oxx0IOOO(xXOx()));
            this.f28512oOoXoXO = oOXIxO0;
            return;
        }
        byte b2 = I0Io2[6];
        if (b2 == 0 && I0Io2[12] == -1 && I0Io2[13] == -1) {
            this.f28512oOoXoXO = new OX00O0xII(xoxxi, xIxXXX0x0, xxxxox0i, oxxIIOOXO, x0oVar, i0, o0xOxO);
            return;
        }
        if (b2 == 1 && I0Io2[12] == -1 && I0Io2[13] == -1) {
            this.f28512oOoXoXO = new X0o0xo(xoxxi, xxxxox0i, oxxIIOOXO, x0oVar, i0);
            return;
        }
        if (b2 == 2 && I0Io2[12] == -1 && I0Io2[13] == -1) {
            this.f28512oOoXoXO = new o00(xoxxi, xxxxox0i, oxxIIOOXO, x0oVar, i0);
        } else if (b2 == 3 && I0Io2[12] == -1 && I0Io2[13] == -1) {
            this.f28512oOoXoXO = new OX00O0xII(xoxxi, xxxxox0i, oxxIIOOXO, x0oVar, i0);
        } else {
            this.f28512oOoXoXO = new I0oOoX(xoxxi, xxxxox0i, oxxIIOOXO, x0oVar, i0);
        }
    }

    public final boolean I0X0x0oIo() {
        return this.f28513ooOOo0oXI;
    }

    @Override // xIoXXXIXo.I0Io
    public String IIX0o() {
        XxIIOXIXx.oIX0oI.oIX0oI(false);
        return "";
    }

    public final oOoXoXO XX0() {
        return this.f28512oOoXoXO;
    }

    @Override // xIoXXXIXo.I0Io
    public xIoXXXIXo.Oxx0IOOO getType() {
        XxIIOXIXx.oIX0oI.oIX0oI(false);
        return xIoXXXIXo.Oxx0IOOO.f34234II0xO0;
    }

    public xXxxox0I(xoxXI xoxxi, XIxXXX0x0 xIxXXX0x0, OoIXo.xXxxox0I xxxxox0i, jxl.biff.formula.OxxIIOOXO oxxIIOOXO, OoIXo.x0o x0oVar, II0xO0 iI0xO0, I0 i0, xIoXXXIXo.O0xOxO o0xOxO) {
        super(xoxxi, xxxxox0i, i0);
        byte[] I0Io2 = oxXx0IX().I0Io();
        this.f28513ooOOo0oXI = false;
        byte b = I0Io2[6];
        if (b == 0 && I0Io2[12] == -1 && I0Io2[13] == -1) {
            this.f28512oOoXoXO = new OX00O0xII(xoxxi, xIxXXX0x0, xxxxox0i, oxxIIOOXO, x0oVar, i0, o0xOxO);
            return;
        }
        if (b == 1 && I0Io2[12] == -1 && I0Io2[13] == -1) {
            this.f28512oOoXoXO = new X0o0xo(xoxxi, xxxxox0i, oxxIIOOXO, x0oVar, i0);
        } else if (b == 2 && I0Io2[12] == -1 && I0Io2[13] == -1) {
            this.f28512oOoXoXO = new o00(xoxxi, xxxxox0i, oxxIIOOXO, x0oVar, i0);
        } else {
            this.f28512oOoXoXO = new I0oOoX(xoxxi, xxxxox0i, oxxIIOOXO, x0oVar, i0);
        }
    }
}
