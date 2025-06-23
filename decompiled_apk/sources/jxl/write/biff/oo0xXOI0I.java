package jxl.write.biff;

import jxl.biff.formula.FormulaException;

/* loaded from: classes6.dex */
public class oo0xXOI0I extends oOoXoXO implements OoIXo.IIX0o {

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28919Oxx0xo = XxIIOXIXx.X0o0xo.Oxx0IOOO(oo0xXOI0I.class);

    /* renamed from: IXxxXO, reason: collision with root package name */
    public oOoXoXO f28920IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public byte[] f28921Oo;

    /* renamed from: oO, reason: collision with root package name */
    public jxl.biff.formula.xoXoI f28922oO;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public String f28923x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public String f28924x0xO0oo;

    public oo0xXOI0I(int i, int i2, String str) {
        super(OoIXo.xII.f2421IIX0o, i, i2);
        this.f28923x0XOIxOo = str;
        this.f28920IXxxXO = null;
    }

    @Override // xIoXXXIXo.I0Io
    public String IIX0o() {
        return this.f28924x0xO0oo;
    }

    @Override // jxl.write.biff.oOoXoXO
    public void Ioxxx(xIoXXXIXo.IIXOooo iIXOooo, int i, int i2) {
        boolean z;
        jxl.biff.formula.xoXoI xoxoi = this.f28922oO;
        if (iIXOooo == I0oOIX()) {
            z = true;
        } else {
            z = false;
        }
        xoxoi.II0XooXoX(i, i2, z);
        this.f28921Oo = this.f28922oO.oxoX();
    }

    public final void O00XxXI(xIoXXXIXo.O0xOxO o0xOxO, jxl.biff.formula.OxxIIOOXO oxxIIOOXO, OoIXo.x0o x0oVar) {
        if (this.f28920IXxxXO != null) {
            ox(o0xOxO, oxxIIOOXO, x0oVar);
            return;
        }
        jxl.biff.formula.xoXoI xoxoi = new jxl.biff.formula.xoXoI(this.f28923x0XOIxOo, oxxIIOOXO, x0oVar, o0xOxO);
        this.f28922oO = xoxoi;
        try {
            xoxoi.Oxx0IOOO();
            this.f28924x0xO0oo = this.f28922oO.X0o0xo();
            this.f28921Oo = this.f28922oO.oxoX();
        } catch (FormulaException e) {
            f28919Oxx0xo.ooOOo0oXI(e.getMessage() + " when parsing formula " + this.f28923x0XOIxOo + " in cell " + I0oOIX().getName() + "!" + xIoXXXIXo.XO.oIX0oI(oIX0oI(), II0xO0()));
            try {
                this.f28923x0XOIxOo = "ERROR(1)";
                jxl.biff.formula.xoXoI xoxoi2 = new jxl.biff.formula.xoXoI(this.f28923x0XOIxOo, oxxIIOOXO, x0oVar, o0xOxO);
                this.f28922oO = xoxoi2;
                xoxoi2.Oxx0IOOO();
                this.f28924x0xO0oo = this.f28922oO.X0o0xo();
                this.f28921Oo = this.f28922oO.oxoX();
            } catch (FormulaException e2) {
                f28919Oxx0xo.oxoX("", e2);
            }
        }
    }

    @Override // OoIXo.IIX0o
    public byte[] X0o0xo() {
        byte[] bArr = this.f28921Oo;
        byte[] bArr2 = new byte[bArr.length + 16];
        System.arraycopy(bArr, 0, bArr2, 16, bArr.length);
        bArr2[6] = 16;
        bArr2[7] = 64;
        bArr2[12] = -32;
        bArr2[13] = -4;
        bArr2[8] = (byte) (bArr2[8] | 2);
        OoIXo.oo0xXOI0I.XO(this.f28921Oo.length, bArr2, 14);
        return bArr2;
    }

    @Override // oIXoXx0.oI0IIXIo
    public oIXoXx0.oI0IIXIo XI0IXoo(int i, int i2) {
        XxIIOXIXx.oIX0oI.oIX0oI(false);
        return null;
    }

    @Override // jxl.write.biff.oOoXoXO
    public void XX0xXo(OoIXo.xXxxox0I xxxxox0i, IoIOOxIIo ioIOOxIIo, XOxxooXI xOxxooXI) {
        super.XX0xXo(xxxxox0i, ioIOOxIIo, xOxxooXI);
        O00XxXI(xOxxooXI.I0(), xOxxooXI.IIxOXoOo0(), xOxxooXI.IIxOXoOo0());
        xOxxooXI.IIxOXoOo0().oo(this);
    }

    @Override // jxl.write.biff.oOoXoXO
    public void Xo0(xIoXXXIXo.IIXOooo iIXOooo, int i, int i2) {
        boolean z;
        jxl.biff.formula.xoXoI xoxoi = this.f28922oO;
        if (iIXOooo == I0oOIX()) {
            z = true;
        } else {
            z = false;
        }
        xoxoi.I0Io(i, i2, z);
        this.f28921Oo = this.f28922oO.oxoX();
    }

    @Override // xIoXXXIXo.I0Io
    public xIoXXXIXo.Oxx0IOOO getType() {
        return xIoXXXIXo.Oxx0IOOO.f34238XO;
    }

    @Override // jxl.write.biff.oOoXoXO
    public void oX(xIoXXXIXo.IIXOooo iIXOooo, int i, int i2) {
        boolean z;
        jxl.biff.formula.xoXoI xoxoi = this.f28922oO;
        if (iIXOooo == I0oOIX()) {
            z = true;
        } else {
            z = false;
        }
        xoxoi.II0xO0(i, i2, z);
        this.f28921Oo = this.f28922oO.oxoX();
    }

    public final void ox(xIoXXXIXo.O0xOxO o0xOxO, jxl.biff.formula.OxxIIOOXO oxxIIOOXO, OoIXo.x0o x0oVar) {
        try {
            try {
                jxl.biff.formula.xoXoI xoxoi = new jxl.biff.formula.xoXoI(this.f28921Oo, this, oxxIIOOXO, x0oVar, o0xOxO);
                this.f28922oO = xoxoi;
                xoxoi.Oxx0IOOO();
                this.f28922oO.oIX0oI(oIX0oI() - this.f28920IXxxXO.oIX0oI(), II0xO0() - this.f28920IXxxXO.II0xO0());
                this.f28924x0xO0oo = this.f28922oO.X0o0xo();
                this.f28921Oo = this.f28922oO.oxoX();
            } catch (FormulaException e) {
                f28919Oxx0xo.oxoX("", e);
            }
        } catch (FormulaException unused) {
            this.f28923x0XOIxOo = "ERROR(1)";
            jxl.biff.formula.xoXoI xoxoi2 = new jxl.biff.formula.xoXoI(this.f28923x0XOIxOo, oxxIIOOXO, x0oVar, o0xOxO);
            this.f28922oO = xoxoi2;
            xoxoi2.Oxx0IOOO();
            this.f28924x0xO0oo = this.f28922oO.X0o0xo();
            this.f28921Oo = this.f28922oO.oxoX();
        }
    }

    @Override // jxl.write.biff.oOoXoXO, OoIXo.OI0
    public byte[] xo0x() {
        byte[] xo0x2 = super.xo0x();
        byte[] X0o0xo2 = X0o0xo();
        byte[] bArr = new byte[X0o0xo2.length + xo0x2.length];
        System.arraycopy(xo0x2, 0, bArr, 0, xo0x2.length);
        System.arraycopy(X0o0xo2, 0, bArr, xo0x2.length, X0o0xo2.length);
        return bArr;
    }

    @Override // jxl.write.biff.oOoXoXO
    public void xxIO(xIoXXXIXo.IIXOooo iIXOooo, int i, int i2) {
        boolean z;
        jxl.biff.formula.xoXoI xoxoi = this.f28922oO;
        if (iIXOooo == I0oOIX()) {
            z = true;
        } else {
            z = false;
        }
        xoxoi.xxIXOIIO(i, i2, z);
        this.f28921Oo = this.f28922oO.oxoX();
    }

    public oo0xXOI0I(int i, int i2, String str, oI0X0.X0o0xo x0o0xo) {
        super(OoIXo.xII.f2523xXxxox0I, i, i2, x0o0xo);
        this.f28923x0XOIxOo = str;
        this.f28920IXxxXO = null;
    }

    public oo0xXOI0I(int i, int i2, oo0xXOI0I oo0xxoi0i) {
        super(OoIXo.xII.f2523xXxxox0I, i, i2, oo0xxoi0i);
        this.f28920IXxxXO = oo0xxoi0i;
        byte[] bArr = new byte[oo0xxoi0i.f28921Oo.length];
        this.f28921Oo = bArr;
        System.arraycopy(oo0xxoi0i.f28921Oo, 0, bArr, 0, bArr.length);
    }

    public oo0xXOI0I(int i, int i2, ooOx ooox) {
        super(OoIXo.xII.f2523xXxxox0I, i, i2, ooox);
        try {
            this.f28920IXxxXO = ooox;
            this.f28921Oo = ooox.ox();
        } catch (FormulaException e) {
            f28919Oxx0xo.oxoX("", e);
        }
    }
}
