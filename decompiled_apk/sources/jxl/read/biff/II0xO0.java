package jxl.read.biff;

import jxl.biff.formula.FormulaException;

/* loaded from: classes6.dex */
public abstract class II0xO0 extends oOoXoXO implements OoIXo.IIX0o {

    /* renamed from: oO, reason: collision with root package name */
    public jxl.biff.formula.OxxIIOOXO f28156oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public String f28157oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public int f28158ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public byte[] f28159x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public OoIXo.x0o f28160x0xO0oo;

    public II0xO0(xoxXI xoxxi, OoIXo.xXxxox0I xxxxox0i, jxl.biff.formula.OxxIIOOXO oxxIIOOXO, OoIXo.x0o x0oVar, I0 i0, int i) {
        super(xoxxi, xxxxox0i, i0);
        this.f28156oO = oxxIIOOXO;
        this.f28160x0xO0oo = x0oVar;
        this.f28158ooOOo0oXI = i;
    }

    public final int I0X0x0oIo() {
        return this.f28158ooOOo0oXI;
    }

    public String Oxx0IOOO() throws FormulaException {
        if (this.f28157oOoXoXO == null) {
            jxl.biff.formula.xoXoI xoxoi = new jxl.biff.formula.xoXoI(this.f28159x0XOIxOo, this, this.f28156oO, this.f28160x0xO0oo, xo0x().I0().XX());
            xoxoi.Oxx0IOOO();
            this.f28157oOoXoXO = xoxoi.X0o0xo();
        }
        return this.f28157oOoXoXO;
    }

    public final jxl.biff.formula.OxxIIOOXO XX0() {
        return this.f28156oO;
    }

    public final byte[] Xo0() {
        return this.f28159x0XOIxOo;
    }

    public void XoI0Ixx0(byte[] bArr) {
        this.f28159x0XOIxOo = bArr;
    }

    public final OoIXo.x0o oX() {
        return this.f28160x0xO0oo;
    }

    @Override // OoIXo.Xx000oIo
    public xoxXI oxXx0IX() {
        return super.oxXx0IX();
    }
}
