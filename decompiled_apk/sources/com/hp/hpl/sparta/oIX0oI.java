package com.hp.hpl.sparta;

/* loaded from: classes10.dex */
public class oIX0oI implements XO, ooOOo0oXI {

    /* renamed from: I0Io, reason: collision with root package name */
    public final x0XOIxOo f17174I0Io;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final X0o0xo f17175X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public oO f17176XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public Oxx0IOOO f17177oxoX;

    public oIX0oI() {
        this(null);
    }

    @Override // com.hp.hpl.sparta.ooOOo0oXI
    public void I0Io(Oxx0IOOO oxx0IOOO) {
        this.f17177oxoX = this.f17177oxoX.X0o0xo();
    }

    @Override // com.hp.hpl.sparta.oO
    public int II0xO0() {
        oO oOVar = this.f17176XO;
        if (oOVar != null) {
            return oOVar.II0xO0();
        }
        return -1;
    }

    @Override // com.hp.hpl.sparta.ooOOo0oXI
    public void Oxx0IOOO(Oxx0IOOO oxx0IOOO) {
        Oxx0IOOO oxx0IOOO2 = this.f17177oxoX;
        if (oxx0IOOO2 == null) {
            this.f17175X0o0xo.XIxXXX0x0(oxx0IOOO);
        } else {
            oxx0IOOO2.o00(oxx0IOOO);
        }
        this.f17177oxoX = oxx0IOOO;
    }

    @Override // com.hp.hpl.sparta.ooOOo0oXI
    public void X0o0xo(oO oOVar) {
        this.f17176XO = oOVar;
        this.f17175X0o0xo.xxX(oOVar.toString());
    }

    @Override // com.hp.hpl.sparta.ooOOo0oXI
    public oO XO() {
        return this.f17176XO;
    }

    @Override // com.hp.hpl.sparta.ooOOo0oXI
    public void characters(char[] cArr, int i, int i2) {
        Oxx0IOOO oxx0IOOO = this.f17177oxoX;
        if (oxx0IOOO.IIX0o() instanceof IXxxXO) {
            ((IXxxXO) oxx0IOOO.IIX0o()).O0xOxO(cArr, i, i2);
        } else {
            oxx0IOOO.OxI(new IXxxXO(new String(cArr, i, i2)));
        }
    }

    @Override // com.hp.hpl.sparta.ooOOo0oXI
    public void endDocument() {
    }

    @Override // com.hp.hpl.sparta.oO
    public String oIX0oI() {
        oO oOVar = this.f17176XO;
        if (oOVar != null) {
            return oOVar.oIX0oI();
        }
        return null;
    }

    @Override // com.hp.hpl.sparta.XO
    public X0o0xo oxoX() {
        return this.f17175X0o0xo;
    }

    @Override // com.hp.hpl.sparta.ooOOo0oXI
    public void startDocument() {
    }

    @Override // com.hp.hpl.sparta.oO
    public String toString() {
        if (this.f17176XO != null) {
            return "BuildDoc: " + this.f17176XO.toString();
        }
        return null;
    }

    public oIX0oI(x0XOIxOo x0xoixoo) {
        this.f17177oxoX = null;
        this.f17175X0o0xo = new X0o0xo();
        this.f17176XO = null;
        this.f17174I0Io = x0xoixoo == null ? oO.f17179oIX0oI : x0xoixoo;
    }
}
