package com.hp.hpl.sparta;

import O0.O0xOxO;
import O0.OxI;
import O0.OxxIIOOXO;
import O0.X0IIOO;
import O0.XI0IXoo;
import O0.XIxXXX0x0;
import O0.o00;
import O0.xoXoI;
import O0.xxX;
import com.hp.hpl.sparta.xpath.XPathException;
import java.util.Enumeration;
import java.util.Vector;

/* loaded from: classes10.dex */
public class Oxx0xo implements XIxXXX0x0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public Enumeration f17148I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public xxX f17149II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public Vector f17150II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public boolean f17151Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final II0xO0 f17152X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public xxIXOIIO f17153XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final xoIox f17154oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public Object f17155oxoX;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final Boolean f17147xxIXOIIO = new Boolean(true);

    /* renamed from: xoIox, reason: collision with root package name */
    public static final Boolean f17146xoIox = new Boolean(false);

    /* loaded from: classes10.dex */
    public static class II0xO0 {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public oIX0oI f17156oIX0oI;

        /* loaded from: classes10.dex */
        public static class oIX0oI {

            /* renamed from: II0xO0, reason: collision with root package name */
            public final oIX0oI f17157II0xO0;

            /* renamed from: oIX0oI, reason: collision with root package name */
            public final Boolean f17158oIX0oI;

            public oIX0oI(Boolean bool, oIX0oI oix0oi) {
                this.f17158oIX0oI = bool;
                this.f17157II0xO0 = oix0oi;
            }
        }

        public II0xO0() {
            this.f17156oIX0oI = null;
        }

        public void II0xO0(Boolean bool) {
            this.f17156oIX0oI = new oIX0oI(bool, this.f17156oIX0oI);
        }

        public Boolean oIX0oI() {
            oIX0oI oix0oi = this.f17156oIX0oI;
            Boolean bool = oix0oi.f17158oIX0oI;
            this.f17156oIX0oI = oix0oi.f17157II0xO0;
            return bool;
        }
    }

    public Oxx0xo(xxX xxx2, xxIXOIIO xxixoiio) throws XPathException {
        this.f17154oIX0oI = new xoIox();
        this.f17150II0xO0 = new Vector();
        this.f17148I0Io = null;
        this.f17155oxoX = null;
        this.f17152X0o0xo = new II0xO0();
        this.f17149II0XooXoX = xxx2;
        this.f17153XO = xxixoiio;
        Vector vector = new Vector(1);
        this.f17150II0xO0 = vector;
        vector.addElement(this.f17153XO);
        Enumeration XO2 = xxx2.XO();
        while (XO2.hasMoreElements()) {
            OxxIIOOXO oxxIIOOXO = (OxxIIOOXO) XO2.nextElement();
            this.f17151Oxx0IOOO = oxxIIOOXO.I0Io();
            this.f17148I0Io = null;
            oxxIIOOXO.oIX0oI().oIX0oI(this);
            this.f17148I0Io = this.f17154oIX0oI.oxoX();
            this.f17150II0xO0.removeAllElements();
            O0.OOXIXo II0xO02 = oxxIIOOXO.II0xO0();
            while (this.f17148I0Io.hasMoreElements()) {
                this.f17155oxoX = this.f17148I0Io.nextElement();
                II0xO02.oIX0oI(this);
                if (this.f17152X0o0xo.oIX0oI().booleanValue()) {
                    this.f17150II0xO0.addElement(this.f17155oxoX);
                }
            }
        }
    }

    @Override // O0.x0xO0oo
    public void I0Io(O0.ooOOo0oXI ooooo0oxi) {
        String I0Io2 = ooooo0oxi.I0Io();
        Vector vector = this.f17150II0xO0;
        int size = vector.size();
        this.f17154oIX0oI.XO();
        for (int i = 0; i < size; i++) {
            Object elementAt = vector.elementAt(i);
            if (elementAt instanceof Oxx0IOOO) {
                oI0IIXIo((Oxx0IOOO) elementAt, I0Io2);
            } else if (elementAt instanceof X0o0xo) {
                Oxx0xo((X0o0xo) elementAt, I0Io2);
            }
        }
    }

    @Override // O0.oOoXoXO
    public void II0XooXoX(O0.Oxx0IOOO oxx0IOOO) throws XPathException {
        boolean z;
        Boolean bool;
        if (this.f17155oxoX instanceof Oxx0IOOO) {
            if (Long.parseLong(((Oxx0IOOO) r0).xxX(oxx0IOOO.II0xO0())) < oxx0IOOO.I0Io()) {
                z = true;
            } else {
                z = false;
            }
            II0xO0 iI0xO0 = this.f17152X0o0xo;
            if (z) {
                bool = f17147xxIXOIIO;
            } else {
                bool = f17146xoIox;
            }
            iI0xO0.II0xO0(bool);
            return;
        }
        throw new XPathException(this.f17149II0XooXoX, "Cannot test attribute of document");
    }

    @Override // O0.x0xO0oo
    public void II0xO0(O0.oIX0oI oix0oi) {
        Vector vector = this.f17150II0xO0;
        this.f17154oIX0oI.XO();
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            Object nextElement = elements.nextElement();
            if (nextElement instanceof Oxx0IOOO) {
                IXxxXO((Oxx0IOOO) nextElement);
            } else if (nextElement instanceof X0o0xo) {
                Oo((X0o0xo) nextElement);
            }
        }
    }

    public String IIXOooo() {
        if (this.f17150II0xO0.size() == 0) {
            return null;
        }
        return this.f17150II0xO0.elementAt(0).toString();
    }

    public final void IXxxXO(Oxx0IOOO oxx0IOOO) {
        int i = 0;
        for (xxIXOIIO xXxxox0I2 = oxx0IOOO.xXxxox0I(); xXxxox0I2 != null; xXxxox0I2 = xXxxox0I2.I0Io()) {
            if (xXxxox0I2 instanceof Oxx0IOOO) {
                i++;
                this.f17154oIX0oI.oIX0oI(xXxxox0I2, i);
                if (this.f17151Oxx0IOOO) {
                    IXxxXO((Oxx0IOOO) xXxxox0I2);
                }
            }
        }
    }

    @Override // O0.oOoXoXO
    public void OOXIXo(OxI oxI) throws XPathException {
        Object obj = this.f17155oxoX;
        if (obj instanceof Oxx0IOOO) {
            for (xxIXOIIO xXxxox0I2 = ((Oxx0IOOO) obj).xXxxox0I(); xXxxox0I2 != null; xXxxox0I2 = xXxxox0I2.I0Io()) {
                if ((xXxxox0I2 instanceof IXxxXO) && !((IXxxXO) xXxxox0I2).X0IIOO().equals(oxI.II0xO0())) {
                    this.f17152X0o0xo.II0xO0(f17147xxIXOIIO);
                    return;
                }
            }
            this.f17152X0o0xo.II0xO0(f17146xoIox);
            return;
        }
        throw new XPathException(this.f17149II0XooXoX, "Cannot test attribute of document");
    }

    public final void Oo(X0o0xo x0o0xo) {
        Oxx0IOOO O0xOxO2 = x0o0xo.O0xOxO();
        this.f17154oIX0oI.oIX0oI(O0xOxO2, 1);
        if (this.f17151Oxx0IOOO) {
            IXxxXO(O0xOxO2);
        }
    }

    @Override // O0.oOoXoXO
    public void Oxx0IOOO(XI0IXoo xI0IXoo) {
        this.f17152X0o0xo.II0xO0(f17147xxIXOIIO);
    }

    public final void Oxx0xo(X0o0xo x0o0xo, String str) {
        Oxx0IOOO O0xOxO2 = x0o0xo.O0xOxO();
        if (O0xOxO2 == null) {
            return;
        }
        if (O0xOxO2.ooXIXxIX() == str) {
            this.f17154oIX0oI.oIX0oI(O0xOxO2, 1);
        }
        if (this.f17151Oxx0IOOO) {
            oI0IIXIo(O0xOxO2, str);
        }
    }

    public Oxx0IOOO OxxIIOOXO() {
        if (this.f17150II0xO0.size() == 0) {
            return null;
        }
        return (Oxx0IOOO) this.f17150II0xO0.elementAt(0);
    }

    @Override // O0.oOoXoXO
    public void X0o0xo(xoXoI xoxoi) throws XPathException {
        Object obj = this.f17155oxoX;
        if (obj instanceof Oxx0IOOO) {
            for (xxIXOIIO xXxxox0I2 = ((Oxx0IOOO) obj).xXxxox0I(); xXxxox0I2 != null; xXxxox0I2 = xXxxox0I2.I0Io()) {
                if ((xXxxox0I2 instanceof IXxxXO) && ((IXxxXO) xXxxox0I2).X0IIOO().equals(xoxoi.II0xO0())) {
                    this.f17152X0o0xo.II0xO0(f17147xxIXOIIO);
                    return;
                }
            }
            this.f17152X0o0xo.II0xO0(f17146xoIox);
            return;
        }
        throw new XPathException(this.f17149II0XooXoX, "Cannot test attribute of document");
    }

    @Override // O0.x0xO0oo
    public void XO(O0.xoIox xoiox) {
        String xxX2;
        Vector vector = this.f17150II0xO0;
        this.f17154oIX0oI.XO();
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            xxIXOIIO xxixoiio = (xxIXOIIO) elements.nextElement();
            if ((xxixoiio instanceof Oxx0IOOO) && (xxX2 = ((Oxx0IOOO) xxixoiio).xxX(xoiox.I0Io())) != null) {
                this.f17154oIX0oI.II0xO0(xxX2);
            }
        }
    }

    public final void oI0IIXIo(Oxx0IOOO oxx0IOOO, String str) {
        int i = 0;
        for (xxIXOIIO xXxxox0I2 = oxx0IOOO.xXxxox0I(); xXxxox0I2 != null; xXxxox0I2 = xXxxox0I2.I0Io()) {
            if (xXxxox0I2 instanceof Oxx0IOOO) {
                Oxx0IOOO oxx0IOOO2 = (Oxx0IOOO) xXxxox0I2;
                if (oxx0IOOO2.ooXIXxIX() == str) {
                    i++;
                    this.f17154oIX0oI.oIX0oI(oxx0IOOO2, i);
                }
                if (this.f17151Oxx0IOOO) {
                    oI0IIXIo(oxx0IOOO2, str);
                }
            }
        }
    }

    @Override // O0.x0xO0oo
    public void oIX0oI(O0.IXxxXO iXxxXO) throws XPathException {
        this.f17154oIX0oI.XO();
        Oxx0IOOO X0o0xo2 = this.f17153XO.X0o0xo();
        if (X0o0xo2 != null) {
            this.f17154oIX0oI.oIX0oI(X0o0xo2, 1);
            return;
        }
        throw new XPathException(this.f17149II0XooXoX, "Illegal attempt to apply \"..\" to node with no parent.");
    }

    @Override // O0.oOoXoXO
    public void oO(O0.XO xo2) throws XPathException {
        boolean z;
        Boolean bool;
        if (this.f17155oxoX instanceof Oxx0IOOO) {
            if (Long.parseLong(((Oxx0IOOO) r0).xxX(xo2.II0xO0())) > xo2.I0Io()) {
                z = true;
            } else {
                z = false;
            }
            II0xO0 iI0xO0 = this.f17152X0o0xo;
            if (z) {
                bool = f17147xxIXOIIO;
            } else {
                bool = f17146xoIox;
            }
            iI0xO0.II0xO0(bool);
            return;
        }
        throw new XPathException(this.f17149II0XooXoX, "Cannot test attribute of document");
    }

    @Override // O0.oOoXoXO
    public void oOoXoXO(O0.oxoX oxox) throws XPathException {
        boolean z;
        Boolean bool;
        Object obj = this.f17155oxoX;
        if (obj instanceof Oxx0IOOO) {
            String xxX2 = ((Oxx0IOOO) obj).xxX(oxox.II0xO0());
            if (xxX2 != null && xxX2.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            II0xO0 iI0xO0 = this.f17152X0o0xo;
            if (z) {
                bool = f17147xxIXOIIO;
            } else {
                bool = f17146xoIox;
            }
            iI0xO0.II0xO0(bool);
            return;
        }
        throw new XPathException(this.f17149II0XooXoX, "Cannot test attribute of document");
    }

    @Override // O0.oOoXoXO
    public void ooOOo0oXI(O0.Oxx0xo oxx0xo) throws XPathException {
        boolean z;
        Boolean bool;
        Object obj = this.f17155oxoX;
        if (obj instanceof Oxx0IOOO) {
            if (this.f17154oIX0oI.X0o0xo((Oxx0IOOO) obj) == oxx0xo.II0xO0()) {
                z = true;
            } else {
                z = false;
            }
            II0xO0 iI0xO0 = this.f17152X0o0xo;
            if (z) {
                bool = f17147xxIXOIIO;
            } else {
                bool = f17146xoIox;
            }
            iI0xO0.II0xO0(bool);
            return;
        }
        throw new XPathException(this.f17149II0XooXoX, "Cannot test position of document");
    }

    @Override // O0.x0xO0oo
    public void oxoX(O0xOxO o0xOxO) {
        Vector vector = this.f17150II0xO0;
        this.f17154oIX0oI.XO();
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            Object nextElement = elements.nextElement();
            if (nextElement instanceof Oxx0IOOO) {
                for (xxIXOIIO xXxxox0I2 = ((Oxx0IOOO) nextElement).xXxxox0I(); xXxxox0I2 != null; xXxxox0I2 = xXxxox0I2.I0Io()) {
                    if (xXxxox0I2 instanceof IXxxXO) {
                        this.f17154oIX0oI.II0xO0(((IXxxXO) xXxxox0I2).X0IIOO());
                    }
                }
            }
        }
    }

    @Override // O0.x0xO0oo
    public void x0XOIxOo(X0IIOO x0iioo) {
        this.f17154oIX0oI.XO();
        this.f17154oIX0oI.oIX0oI(this.f17153XO, 1);
    }

    @Override // O0.oOoXoXO
    public void x0xO0oo(O0.I0Io i0Io) throws XPathException {
        Boolean bool;
        Object obj = this.f17155oxoX;
        if (obj instanceof Oxx0IOOO) {
            boolean equals = i0Io.I0Io().equals(((Oxx0IOOO) obj).xxX(i0Io.II0xO0()));
            II0xO0 iI0xO0 = this.f17152X0o0xo;
            if (equals) {
                bool = f17147xxIXOIIO;
            } else {
                bool = f17146xoIox;
            }
            iI0xO0.II0xO0(bool);
            return;
        }
        throw new XPathException(this.f17149II0XooXoX, "Cannot test attribute of document");
    }

    @Override // O0.oOoXoXO
    public void xoIox(o00 o00Var) throws XPathException {
        Object obj = this.f17155oxoX;
        if (obj instanceof Oxx0IOOO) {
            for (xxIXOIIO xXxxox0I2 = ((Oxx0IOOO) obj).xXxxox0I(); xXxxox0I2 != null; xXxxox0I2 = xXxxox0I2.I0Io()) {
                if (xXxxox0I2 instanceof IXxxXO) {
                    this.f17152X0o0xo.II0xO0(f17147xxIXOIIO);
                    return;
                }
            }
            this.f17152X0o0xo.II0xO0(f17146xoIox);
            return;
        }
        throw new XPathException(this.f17149II0XooXoX, "Cannot test attribute of document");
    }

    public Enumeration xoXoI() {
        return this.f17150II0xO0.elements();
    }

    @Override // O0.oOoXoXO
    public void xxIXOIIO(O0.II0XooXoX iI0XooXoX) throws XPathException {
        Boolean bool;
        Object obj = this.f17155oxoX;
        if (obj instanceof Oxx0IOOO) {
            boolean equals = iI0XooXoX.I0Io().equals(((Oxx0IOOO) obj).xxX(iI0XooXoX.II0xO0()));
            II0xO0 iI0xO0 = this.f17152X0o0xo;
            if (!equals) {
                bool = f17147xxIXOIIO;
            } else {
                bool = f17146xoIox;
            }
            iI0xO0.II0xO0(bool);
            return;
        }
        throw new XPathException(this.f17149II0XooXoX, "Cannot test attribute of document");
    }

    public Oxx0xo(Oxx0IOOO oxx0IOOO, xxX xxx2) throws XPathException {
        this(xxx2, oxx0IOOO);
        if (xxx2.Oxx0IOOO()) {
            throw new XPathException(xxx2, "Cannot use element as context node for absolute xpath");
        }
    }

    public Oxx0xo(X0o0xo x0o0xo, xxX xxx2) throws XPathException {
        this(xxx2, x0o0xo);
    }
}
