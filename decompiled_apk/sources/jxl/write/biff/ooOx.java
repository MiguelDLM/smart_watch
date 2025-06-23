package jxl.write.biff;

import jxl.biff.formula.FormulaException;

/* loaded from: classes6.dex */
public class ooOx extends oOoXoXO implements OoIXo.IIX0o {

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28925x0xO0oo = XxIIOXIXx.X0o0xo.Oxx0IOOO(ooOx.class);

    /* renamed from: oO, reason: collision with root package name */
    public jxl.biff.formula.xoXoI f28926oO;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public OoIXo.IIX0o f28927x0XOIxOo;

    public ooOx(OoIXo.IIX0o iIX0o) {
        super(OoIXo.xII.f2523xXxxox0I, iIX0o);
        this.f28927x0XOIxOo = iIX0o;
    }

    @Override // xIoXXXIXo.I0Io
    public String IIX0o() {
        return this.f28927x0XOIxOo.IIX0o();
    }

    public boolean IIxOXoOo0(jxl.biff.formula.OxxIIOOXO oxxIIOOXO, OoIXo.x0o x0oVar, xIoXXXIXo.O0xOxO o0xOxO) {
        try {
            if (this.f28926oO == null) {
                byte[] X0o0xo2 = this.f28927x0XOIxOo.X0o0xo();
                int length = X0o0xo2.length - 16;
                byte[] bArr = new byte[length];
                System.arraycopy(X0o0xo2, 16, bArr, 0, length);
                jxl.biff.formula.xoXoI xoxoi = new jxl.biff.formula.xoXoI(bArr, this, oxxIIOOXO, x0oVar, o0xOxO);
                this.f28926oO = xoxoi;
                xoxoi.Oxx0IOOO();
            }
            return this.f28926oO.XO();
        } catch (FormulaException e) {
            f28925x0xO0oo.ooOOo0oXI("cannot import formula:  " + e.getMessage());
            return false;
        }
    }

    @Override // jxl.write.biff.oOoXoXO
    public void Ioxxx(xIoXXXIXo.IIXOooo iIXOooo, int i, int i2) {
        try {
            boolean z = false;
            if (this.f28926oO == null) {
                byte[] X0o0xo2 = this.f28927x0XOIxOo.X0o0xo();
                int length = X0o0xo2.length - 16;
                byte[] bArr = new byte[length];
                System.arraycopy(X0o0xo2, 16, bArr, 0, length);
                jxl.biff.formula.xoXoI xoxoi = new jxl.biff.formula.xoXoI(bArr, this, I0oOIX().IIxOXoOo0(), I0oOIX().IIxOXoOo0(), I0oOIX().I0());
                this.f28926oO = xoxoi;
                xoxoi.Oxx0IOOO();
            }
            jxl.biff.formula.xoXoI xoxoi2 = this.f28926oO;
            if (iIXOooo == I0oOIX()) {
                z = true;
            }
            xoxoi2.II0XooXoX(i, i2, z);
        } catch (FormulaException e) {
            f28925x0xO0oo.ooOOo0oXI("cannot insert row within formula:  " + e.getMessage());
        }
    }

    public final byte[] O00XxXI() {
        return super.xo0x();
    }

    public byte[] OOXIxO0() {
        byte[] xo0x2 = super.xo0x();
        IOoo IIxOXoOo02 = I0oOIX().IIxOXoOo0();
        jxl.biff.formula.xoXoI xoxoi = new jxl.biff.formula.xoXoI(IIX0o(), IIxOXoOo02, IIxOXoOo02, IIxOXoOo02.Io());
        this.f28926oO = xoxoi;
        try {
            xoxoi.Oxx0IOOO();
        } catch (FormulaException e) {
            f28925x0xO0oo.ooOOo0oXI(e.getMessage());
            jxl.biff.formula.xoXoI xoxoi2 = new jxl.biff.formula.xoXoI("\"ERROR\"", IIxOXoOo02, IIxOXoOo02, IIxOXoOo02.Io());
            this.f28926oO = xoxoi2;
            try {
                xoxoi2.Oxx0IOOO();
            } catch (FormulaException unused) {
                XxIIOXIXx.oIX0oI.oIX0oI(false);
            }
        }
        byte[] oxoX2 = this.f28926oO.oxoX();
        int length = oxoX2.length + 16;
        byte[] bArr = new byte[length];
        OoIXo.oo0xXOI0I.XO(oxoX2.length, bArr, 14);
        System.arraycopy(oxoX2, 0, bArr, 16, oxoX2.length);
        bArr[8] = (byte) (bArr[8] | 2);
        byte[] bArr2 = new byte[xo0x2.length + length];
        System.arraycopy(xo0x2, 0, bArr2, 0, xo0x2.length);
        System.arraycopy(bArr, 0, bArr2, xo0x2.length, length);
        return bArr2;
    }

    public String Oxx0IOOO() throws FormulaException {
        return ((xIoXXXIXo.ooOOo0oXI) this.f28927x0XOIxOo).Oxx0IOOO();
    }

    @Override // OoIXo.IIX0o
    public byte[] X0o0xo() throws FormulaException {
        byte[] X0o0xo2 = this.f28927x0XOIxOo.X0o0xo();
        byte[] bArr = new byte[X0o0xo2.length];
        System.arraycopy(X0o0xo2, 0, bArr, 0, X0o0xo2.length);
        bArr[8] = (byte) (bArr[8] | 2);
        return bArr;
    }

    @Override // oIXoXx0.oI0IIXIo
    public oIXoXx0.oI0IIXIo XI0IXoo(int i, int i2) {
        return new oo0xXOI0I(i, i2, this);
    }

    public OoIXo.IIX0o XI0oooXX() {
        return this.f28927x0XOIxOo;
    }

    @Override // jxl.write.biff.oOoXoXO
    public void XX0xXo(OoIXo.xXxxox0I xxxxox0i, IoIOOxIIo ioIOOxIIo, XOxxooXI xOxxooXI) {
        super.XX0xXo(xxxxox0i, ioIOOxIIo, xOxxooXI);
        xOxxooXI.IIxOXoOo0().oo(this);
    }

    @Override // jxl.write.biff.oOoXoXO
    public void Xo0(xIoXXXIXo.IIXOooo iIXOooo, int i, int i2) {
        try {
            boolean z = false;
            if (this.f28926oO == null) {
                byte[] X0o0xo2 = this.f28927x0XOIxOo.X0o0xo();
                int length = X0o0xo2.length - 16;
                byte[] bArr = new byte[length];
                System.arraycopy(X0o0xo2, 16, bArr, 0, length);
                jxl.biff.formula.xoXoI xoxoi = new jxl.biff.formula.xoXoI(bArr, this, I0oOIX().IIxOXoOo0(), I0oOIX().IIxOXoOo0(), I0oOIX().I0());
                this.f28926oO = xoxoi;
                xoxoi.Oxx0IOOO();
            }
            jxl.biff.formula.xoXoI xoxoi2 = this.f28926oO;
            if (iIXOooo == I0oOIX()) {
                z = true;
            }
            xoxoi2.I0Io(i, i2, z);
        } catch (FormulaException e) {
            f28925x0xO0oo.ooOOo0oXI("cannot remove column within formula:  " + e.getMessage());
        }
    }

    @Override // xIoXXXIXo.I0Io
    public xIoXXXIXo.Oxx0IOOO getType() {
        return this.f28927x0XOIxOo.getType();
    }

    @Override // jxl.write.biff.oOoXoXO
    public void oX(xIoXXXIXo.IIXOooo iIXOooo, int i, int i2) {
        try {
            boolean z = false;
            if (this.f28926oO == null) {
                byte[] X0o0xo2 = this.f28927x0XOIxOo.X0o0xo();
                int length = X0o0xo2.length - 16;
                byte[] bArr = new byte[length];
                System.arraycopy(X0o0xo2, 16, bArr, 0, length);
                jxl.biff.formula.xoXoI xoxoi = new jxl.biff.formula.xoXoI(bArr, this, I0oOIX().IIxOXoOo0(), I0oOIX().IIxOXoOo0(), I0oOIX().I0());
                this.f28926oO = xoxoi;
                xoxoi.Oxx0IOOO();
            }
            jxl.biff.formula.xoXoI xoxoi2 = this.f28926oO;
            if (iIXOooo == I0oOIX()) {
                z = true;
            }
            xoxoi2.II0xO0(i, i2, z);
        } catch (FormulaException e) {
            f28925x0xO0oo.ooOOo0oXI("cannot insert column within formula:  " + e.getMessage());
        }
    }

    public byte[] ox() throws FormulaException {
        jxl.biff.formula.xoXoI xoxoi = this.f28926oO;
        if (xoxoi != null) {
            return xoxoi.oxoX();
        }
        byte[] X0o0xo2 = X0o0xo();
        int length = X0o0xo2.length - 16;
        byte[] bArr = new byte[length];
        System.arraycopy(X0o0xo2, 16, bArr, 0, length);
        return bArr;
    }

    @Override // jxl.write.biff.oOoXoXO, OoIXo.OI0
    public byte[] xo0x() {
        byte[] bArr;
        byte[] xo0x2 = super.xo0x();
        try {
            jxl.biff.formula.xoXoI xoxoi = this.f28926oO;
            if (xoxoi == null) {
                bArr = this.f28927x0XOIxOo.X0o0xo();
            } else {
                byte[] oxoX2 = xoxoi.oxoX();
                byte[] bArr2 = new byte[oxoX2.length + 16];
                OoIXo.oo0xXOI0I.XO(oxoX2.length, bArr2, 14);
                System.arraycopy(oxoX2, 0, bArr2, 16, oxoX2.length);
                bArr = bArr2;
            }
            bArr[8] = (byte) (bArr[8] | 2);
            byte[] bArr3 = new byte[xo0x2.length + bArr.length];
            System.arraycopy(xo0x2, 0, bArr3, 0, xo0x2.length);
            System.arraycopy(bArr, 0, bArr3, xo0x2.length, bArr.length);
            return bArr3;
        } catch (FormulaException e) {
            f28925x0xO0oo.ooOOo0oXI(xIoXXXIXo.XO.oIX0oI(oIX0oI(), II0xO0()) + " " + e.getMessage());
            return OOXIxO0();
        }
    }

    @Override // jxl.write.biff.oOoXoXO
    public void xxIO(xIoXXXIXo.IIXOooo iIXOooo, int i, int i2) {
        try {
            boolean z = false;
            if (this.f28926oO == null) {
                byte[] X0o0xo2 = this.f28927x0XOIxOo.X0o0xo();
                int length = X0o0xo2.length - 16;
                byte[] bArr = new byte[length];
                System.arraycopy(X0o0xo2, 16, bArr, 0, length);
                jxl.biff.formula.xoXoI xoxoi = new jxl.biff.formula.xoXoI(bArr, this, I0oOIX().IIxOXoOo0(), I0oOIX().IIxOXoOo0(), I0oOIX().I0());
                this.f28926oO = xoxoi;
                xoxoi.Oxx0IOOO();
            }
            jxl.biff.formula.xoXoI xoxoi2 = this.f28926oO;
            if (iIXOooo == I0oOIX()) {
                z = true;
            }
            xoxoi2.xxIXOIIO(i, i2, z);
        } catch (FormulaException e) {
            f28925x0xO0oo.ooOOo0oXI("cannot remove row within formula:  " + e.getMessage());
        }
    }
}
