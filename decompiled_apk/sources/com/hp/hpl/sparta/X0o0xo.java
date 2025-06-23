package com.hp.hpl.sparta;

import O0.OxxIIOOXO;
import O0.xxX;
import com.hp.hpl.sparta.Sparta;
import com.hp.hpl.sparta.xpath.XPathException;
import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* loaded from: classes10.dex */
public class X0o0xo extends xxIXOIIO {

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final boolean f17162oOoXoXO = false;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final Integer f17163ooOOo0oXI = new Integer(1);

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final Enumeration f17164x0XOIxOo = new II0XooXoX();

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public String f17165II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public final Hashtable f17166OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public Oxx0IOOO f17167Oxx0IOOO;

    /* renamed from: xoIox, reason: collision with root package name */
    public Vector f17168xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public Sparta.I0Io f17169xxIXOIIO;

    /* loaded from: classes10.dex */
    public interface II0xO0 {
        void oIX0oI(X0o0xo x0o0xo);
    }

    /* loaded from: classes10.dex */
    public class oIX0oI implements II0xO0 {

        /* renamed from: I0Io, reason: collision with root package name */
        public final String f17170I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final xxX f17171II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public transient Sparta.I0Io f17172oIX0oI = null;

        public oIX0oI(xxX xxx2) throws XPathException {
            this.f17170I0Io = xxx2.oxoX();
            this.f17171II0xO0 = xxx2;
            X0o0xo.this.o00(this);
        }

        public final void I0Io() throws ParseException {
            try {
                this.f17172oIX0oI = Sparta.II0xO0();
                Enumeration xoXoI2 = X0o0xo.this.XxX0x0xxx(this.f17171II0xO0, false).xoXoI();
                while (xoXoI2.hasMoreElements()) {
                    Oxx0IOOO oxx0IOOO = (Oxx0IOOO) xoXoI2.nextElement();
                    String xxX2 = oxx0IOOO.xxX(this.f17170I0Io);
                    Vector vector = (Vector) this.f17172oIX0oI.get(xxX2);
                    if (vector == null) {
                        vector = new Vector(1);
                        this.f17172oIX0oI.put(xxX2, vector);
                    }
                    vector.addElement(oxx0IOOO);
                }
            } catch (XPathException e) {
                throw new ParseException("XPath problem", e);
            }
        }

        public synchronized Enumeration II0xO0(String str) throws ParseException {
            Enumeration elements;
            try {
                if (this.f17172oIX0oI == null) {
                    I0Io();
                }
                Vector vector = (Vector) this.f17172oIX0oI.get(str);
                if (vector == null) {
                    elements = X0o0xo.f17164x0XOIxOo;
                } else {
                    elements = vector.elements();
                }
            } catch (Throwable th) {
                throw th;
            }
            return elements;
        }

        @Override // com.hp.hpl.sparta.X0o0xo.II0xO0
        public synchronized void oIX0oI(X0o0xo x0o0xo) {
            this.f17172oIX0oI = null;
        }

        public synchronized int oxoX() throws ParseException {
            try {
                if (this.f17172oIX0oI == null) {
                    I0Io();
                }
            } catch (Throwable th) {
                throw th;
            }
            return this.f17172oIX0oI.size();
        }
    }

    public X0o0xo(String str) {
        this.f17167Oxx0IOOO = null;
        this.f17169xxIXOIIO = Sparta.II0xO0();
        this.f17168xoIox = new Vector();
        this.f17166OOXIXo = null;
        this.f17165II0XooXoX = str;
    }

    public boolean IIX0o(String str) throws ParseException {
        try {
            if (Oxx0xo(str) != null) {
                return false;
            }
            xxX II0xO02 = xxX.II0xO0(str);
            Enumeration XO2 = II0xO02.XO();
            int i = 0;
            while (XO2.hasMoreElements()) {
                XO2.nextElement();
                i++;
            }
            Enumeration XO3 = II0xO02.XO();
            OxxIIOOXO oxxIIOOXO = (OxxIIOOXO) XO3.nextElement();
            int i2 = i - 1;
            OxxIIOOXO[] oxxIIOOXOArr = new OxxIIOOXO[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                oxxIIOOXOArr[i3] = (OxxIIOOXO) XO3.nextElement();
            }
            if (this.f17167Oxx0IOOO == null) {
                XIxXXX0x0(xxIXOIIO(null, oxxIIOOXO, str));
            } else {
                if (Oxx0xo("/" + oxxIIOOXO) == null) {
                    throw new ParseException("Existing root element <" + this.f17167Oxx0IOOO.ooXIXxIX() + "...> does not match first step \"" + oxxIIOOXO + "\" of \"" + str);
                }
            }
            if (i2 == 0) {
                return true;
            }
            return this.f17167Oxx0IOOO.x0o(xxX.I0Io(false, oxxIIOOXOArr).toString());
        } catch (XPathException e) {
            throw new ParseException(str, e);
        }
    }

    @Override // com.hp.hpl.sparta.xxIXOIIO
    public Enumeration IIXOooo(String str) throws ParseException {
        try {
            return xXxxox0I(str, true).xoXoI();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", e);
        }
    }

    @Override // com.hp.hpl.sparta.xxIXOIIO
    public void IXxxXO(Writer writer) throws IOException {
        writer.write("<?xml version=\"1.0\" ?>\n");
        this.f17167Oxx0IOOO.IXxxXO(writer);
    }

    public Oxx0IOOO O0xOxO() {
        return this.f17167Oxx0IOOO;
    }

    public void OxI(II0xO0 iI0xO0) {
        this.f17168xoIox.removeElement(iI0xO0);
    }

    @Override // com.hp.hpl.sparta.xxIXOIIO
    public Oxx0IOOO Oxx0xo(String str) throws ParseException {
        try {
            if (str.charAt(0) != '/') {
                str = "/" + str;
            }
            xxX II0xO02 = xxX.II0xO0(str);
            XI0IXoo(II0xO02);
            return XxX0x0xxx(II0xO02, false).OxxIIOOXO();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", e);
        }
    }

    @Override // com.hp.hpl.sparta.xxIXOIIO
    public String OxxIIOOXO(String str) throws ParseException {
        try {
            return xXxxox0I(str, true).IIXOooo();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", e);
        }
    }

    public String X0IIOO() {
        return this.f17165II0XooXoX;
    }

    public void XIxXXX0x0(Oxx0IOOO oxx0IOOO) {
        this.f17167Oxx0IOOO = oxx0IOOO;
        oxx0IOOO.x0XOIxOo(this);
        xoIox();
    }

    public Oxx0xo XxX0x0xxx(xxX xxx2, boolean z) throws XPathException {
        String str;
        if (xxx2.II0XooXoX() != z) {
            if (z) {
                str = "evaluates to element not string";
            } else {
                str = "evaluates to string not element";
            }
            throw new XPathException(xxx2, "\"" + xxx2 + "\" evaluates to " + str);
        }
        return new Oxx0xo(this, xxx2);
    }

    @Override // com.hp.hpl.sparta.xxIXOIIO
    public Object clone() {
        X0o0xo x0o0xo = new X0o0xo(this.f17165II0XooXoX);
        x0o0xo.f17167Oxx0IOOO = (Oxx0IOOO) this.f17167Oxx0IOOO.clone();
        return x0o0xo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof X0o0xo)) {
            return false;
        }
        return this.f17167Oxx0IOOO.equals(((X0o0xo) obj).f17167Oxx0IOOO);
    }

    public void o00(II0xO0 iI0xO0) {
        this.f17168xoIox.addElement(iI0xO0);
    }

    @Override // com.hp.hpl.sparta.xxIXOIIO
    public Enumeration oI0IIXIo(String str) throws ParseException {
        try {
            if (str.charAt(0) != '/') {
                str = "/" + str;
            }
            xxX II0xO02 = xxX.II0xO0(str);
            XI0IXoo(II0xO02);
            return XxX0x0xxx(II0xO02, false).xoXoI();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", e);
        }
    }

    @Override // com.hp.hpl.sparta.xxIXOIIO
    public int oIX0oI() {
        return this.f17167Oxx0IOOO.hashCode();
    }

    public oIX0oI ooXIXxIX(String str) throws ParseException {
        try {
            oIX0oI oix0oi = (oIX0oI) this.f17169xxIXOIIO.get(str);
            if (oix0oi == null) {
                oIX0oI oix0oi2 = new oIX0oI(xxX.II0xO0(str));
                this.f17169xxIXOIIO.put(str, oix0oi2);
                return oix0oi2;
            }
            return oix0oi;
        } catch (XPathException e) {
            throw new ParseException("XPath problem", e);
        }
    }

    @Override // com.hp.hpl.sparta.xxIXOIIO
    public String toString() {
        return this.f17165II0XooXoX;
    }

    @Override // com.hp.hpl.sparta.xxIXOIIO
    public void x0xO0oo(Writer writer) throws IOException {
        this.f17167Oxx0IOOO.x0xO0oo(writer);
    }

    public boolean xI(String str) {
        if (this.f17169xxIXOIIO.get(str) != null) {
            return true;
        }
        return false;
    }

    public final Oxx0xo xXxxox0I(String str, boolean z) throws XPathException {
        if (str.charAt(0) != '/') {
            str = "/" + str;
        }
        return XxX0x0xxx(xxX.II0xO0(str), z);
    }

    @Override // com.hp.hpl.sparta.xxIXOIIO
    public void xoIox() {
        Enumeration elements = this.f17168xoIox.elements();
        while (elements.hasMoreElements()) {
            ((II0xO0) elements.nextElement()).oIX0oI(this);
        }
    }

    public void xxX(String str) {
        this.f17165II0XooXoX = str;
        xoIox();
    }

    public X0o0xo() {
        this.f17167Oxx0IOOO = null;
        this.f17169xxIXOIIO = Sparta.II0xO0();
        this.f17168xoIox = new Vector();
        this.f17166OOXIXo = null;
        this.f17165II0XooXoX = "MEMORY";
    }

    public void XI0IXoo(xxX xxx2) throws XPathException {
    }
}
