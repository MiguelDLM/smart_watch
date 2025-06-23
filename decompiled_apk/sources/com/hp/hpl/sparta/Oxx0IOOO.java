package com.hp.hpl.sparta;

import O0.OxxIIOOXO;
import O0.xxX;
import com.hp.hpl.sparta.xpath.XPathException;
import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* loaded from: classes10.dex */
public class Oxx0IOOO extends xxIXOIIO {

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final boolean f17140oOoXoXO = false;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public xxIXOIIO f17141II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public String f17142OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public xxIXOIIO f17143Oxx0IOOO;

    /* renamed from: xoIox, reason: collision with root package name */
    public Vector f17144xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public Hashtable f17145xxIXOIIO;

    public Oxx0IOOO(String str) {
        this.f17143Oxx0IOOO = null;
        this.f17141II0XooXoX = null;
        this.f17145xxIXOIIO = null;
        this.f17144xoIox = null;
        this.f17142OOXIXo = null;
        this.f17142OOXIXo = Sparta.oIX0oI(str);
    }

    private Oxx0xo xII(String str, boolean z) throws XPathException {
        String str2;
        xxX II0xO02 = xxX.II0xO0(str);
        if (II0xO02.II0XooXoX() != z) {
            if (z) {
                str2 = "evaluates to element not string";
            } else {
                str2 = "evaluates to string not element";
            }
            throw new XPathException(II0xO02, "\"" + II0xO02 + "\" evaluates to " + str2);
        }
        return new Oxx0xo(this, II0xO02);
    }

    public xxIXOIIO IIX0o() {
        return this.f17141II0XooXoX;
    }

    @Override // com.hp.hpl.sparta.xxIXOIIO
    public Enumeration IIXOooo(String str) throws ParseException {
        try {
            return xII(str, true).xoXoI();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", e);
        }
    }

    public void IO(String str) {
        this.f17142OOXIXo = Sparta.oIX0oI(str);
        xoIox();
    }

    @Override // com.hp.hpl.sparta.xxIXOIIO
    public void IXxxXO(Writer writer) throws IOException {
        writer.write("<" + this.f17142OOXIXo);
        Vector vector = this.f17144xoIox;
        if (vector != null) {
            Enumeration elements = vector.elements();
            while (elements.hasMoreElements()) {
                String str = (String) elements.nextElement();
                String str2 = (String) this.f17145xxIXOIIO.get(str);
                writer.write(" " + str + "=\"");
                xxIXOIIO.Oxx0IOOO(writer, str2);
                writer.write("\"");
            }
        }
        if (this.f17143Oxx0IOOO == null) {
            writer.write("/>");
            return;
        }
        writer.write(">");
        for (xxIXOIIO xxixoiio = this.f17143Oxx0IOOO; xxixoiio != null; xxixoiio = xxixoiio.I0Io()) {
            xxixoiio.IXxxXO(writer);
        }
        writer.write("</" + this.f17142OOXIXo + ">");
    }

    public void IoOoX(Oxx0IOOO oxx0IOOO, xxIXOIIO xxixoiio) throws DOMException {
        Xx000oIo(oxx0IOOO, xxixoiio);
        xoIox();
    }

    public boolean O0xOxO(xxIXOIIO xxixoiio) {
        if (xxixoiio == this) {
            return false;
        }
        Oxx0IOOO X0o0xo2 = X0o0xo();
        if (X0o0xo2 == null) {
            return true;
        }
        return X0o0xo2.O0xOxO(xxixoiio);
    }

    public void OxI(xxIXOIIO xxixoiio) {
        Oxx0IOOO X0o0xo2 = xxixoiio.X0o0xo();
        if (X0o0xo2 != null) {
            X0o0xo2.oo(xxixoiio);
        }
        xxixoiio.II0XooXoX(this.f17141II0XooXoX);
        if (this.f17143Oxx0IOOO == null) {
            this.f17143Oxx0IOOO = xxixoiio;
        }
        xxixoiio.oO(this);
        this.f17141II0XooXoX = xxixoiio;
        xxixoiio.x0XOIxOo(oxoX());
    }

    @Override // com.hp.hpl.sparta.xxIXOIIO
    public Oxx0IOOO Oxx0xo(String str) throws ParseException {
        try {
            return xII(str, false).OxxIIOOXO();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", e);
        }
    }

    @Override // com.hp.hpl.sparta.xxIXOIIO
    public String OxxIIOOXO(String str) throws ParseException {
        try {
            return xII(str, true).IIXOooo();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", e);
        }
    }

    public void X00IoxXI(String str, String str2) {
        if (this.f17145xxIXOIIO == null) {
            this.f17145xxIXOIIO = new Hashtable();
            this.f17144xoIox = new Vector();
        }
        if (this.f17145xxIXOIIO.get(str) == null) {
            this.f17144xoIox.addElement(str);
        }
        this.f17145xxIXOIIO.put(str, str2);
        xoIox();
    }

    public final void X0IIOO() {
    }

    public Oxx0IOOO XI0IXoo(boolean z) {
        Oxx0IOOO oxx0IOOO = new Oxx0IOOO(this.f17142OOXIXo);
        Vector vector = this.f17144xoIox;
        if (vector != null) {
            Enumeration elements = vector.elements();
            while (elements.hasMoreElements()) {
                String str = (String) elements.nextElement();
                oxx0IOOO.X00IoxXI(str, (String) this.f17145xxIXOIIO.get(str));
            }
        }
        if (z) {
            for (xxIXOIIO xxixoiio = this.f17143Oxx0IOOO; xxixoiio != null; xxixoiio = xxixoiio.I0Io()) {
                oxx0IOOO.o00((xxIXOIIO) xxixoiio.clone());
            }
        }
        return oxx0IOOO;
    }

    public Oxx0IOOO XIxXXX0x0() {
        return XI0IXoo(false);
    }

    public final void Xx000oIo(xxIXOIIO xxixoiio, xxIXOIIO xxixoiio2) throws DOMException {
        for (xxIXOIIO xxixoiio3 = this.f17143Oxx0IOOO; xxixoiio3 != null; xxixoiio3 = xxixoiio3.I0Io()) {
            if (xxixoiio3 == xxixoiio2) {
                if (this.f17143Oxx0IOOO == xxixoiio2) {
                    this.f17143Oxx0IOOO = xxixoiio;
                }
                if (this.f17141II0XooXoX == xxixoiio2) {
                    this.f17141II0XooXoX = xxixoiio;
                }
                xxixoiio2.oOoXoXO(xxixoiio);
                xxixoiio.oO(this);
                xxixoiio2.oO(null);
                return;
            }
        }
        throw new DOMException((short) 8, "Cannot find " + xxixoiio2 + " in " + this);
    }

    public Enumeration XxX0x0xxx() {
        Vector vector = this.f17144xoIox;
        if (vector == null) {
            return X0o0xo.f17164x0XOIxOo;
        }
        return vector.elements();
    }

    @Override // com.hp.hpl.sparta.xxIXOIIO
    public Object clone() {
        return XI0IXoo(true);
    }

    public boolean equals(Object obj) {
        int size;
        int size2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Oxx0IOOO)) {
            return false;
        }
        Oxx0IOOO oxx0IOOO = (Oxx0IOOO) obj;
        if (!this.f17142OOXIXo.equals(oxx0IOOO.f17142OOXIXo)) {
            return false;
        }
        Hashtable hashtable = this.f17145xxIXOIIO;
        if (hashtable == null) {
            size = 0;
        } else {
            size = hashtable.size();
        }
        Hashtable hashtable2 = oxx0IOOO.f17145xxIXOIIO;
        if (hashtable2 == null) {
            size2 = 0;
        } else {
            size2 = hashtable2.size();
        }
        if (size != size2) {
            return false;
        }
        Hashtable hashtable3 = this.f17145xxIXOIIO;
        if (hashtable3 != null) {
            Enumeration keys = hashtable3.keys();
            while (keys.hasMoreElements()) {
                String str = (String) keys.nextElement();
                if (!((String) this.f17145xxIXOIIO.get(str)).equals((String) oxx0IOOO.f17145xxIXOIIO.get(str))) {
                    return false;
                }
            }
        }
        xxIXOIIO xxixoiio = this.f17143Oxx0IOOO;
        xxIXOIIO xxixoiio2 = oxx0IOOO.f17143Oxx0IOOO;
        while (xxixoiio != null) {
            if (!xxixoiio.equals(xxixoiio2)) {
                return false;
            }
            xxixoiio = xxixoiio.I0Io();
            xxixoiio2 = xxixoiio2.I0Io();
        }
        return true;
    }

    public void o00(xxIXOIIO xxixoiio) {
        if (!O0xOxO(xxixoiio)) {
            xxixoiio = (Oxx0IOOO) xxixoiio.clone();
        }
        OxI(xxixoiio);
        xoIox();
    }

    @Override // com.hp.hpl.sparta.xxIXOIIO
    public Enumeration oI0IIXIo(String str) throws ParseException {
        try {
            return xII(str, false).xoXoI();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", e);
        }
    }

    @Override // com.hp.hpl.sparta.xxIXOIIO
    public int oIX0oI() {
        int hashCode = this.f17142OOXIXo.hashCode();
        Hashtable hashtable = this.f17145xxIXOIIO;
        if (hashtable != null) {
            Enumeration keys = hashtable.keys();
            while (keys.hasMoreElements()) {
                String str = (String) keys.nextElement();
                hashCode = (((hashCode * 31) + str.hashCode()) * 31) + ((String) this.f17145xxIXOIIO.get(str)).hashCode();
            }
        }
        for (xxIXOIIO xxixoiio = this.f17143Oxx0IOOO; xxixoiio != null; xxixoiio = xxixoiio.I0Io()) {
            hashCode = (hashCode * 31) + xxixoiio.hashCode();
        }
        return hashCode;
    }

    public void oOXoIIIo(IXxxXO iXxxXO, xxIXOIIO xxixoiio) throws DOMException {
        Xx000oIo(iXxxXO, xxixoiio);
        xoIox();
    }

    public final boolean oo(xxIXOIIO xxixoiio) {
        for (xxIXOIIO xxixoiio2 = this.f17143Oxx0IOOO; xxixoiio2 != null; xxixoiio2 = xxixoiio2.I0Io()) {
            if (xxixoiio2.equals(xxixoiio)) {
                if (this.f17143Oxx0IOOO == xxixoiio2) {
                    this.f17143Oxx0IOOO = xxixoiio2.I0Io();
                }
                if (this.f17141II0XooXoX == xxixoiio2) {
                    this.f17141II0XooXoX = xxixoiio2.XO();
                }
                xxixoiio2.OOXIXo();
                xxixoiio2.oO(null);
                xxixoiio2.x0XOIxOo(null);
                return true;
            }
        }
        return false;
    }

    public void oo0xXOI0I(xxIXOIIO xxixoiio) throws DOMException {
        if (oo(xxixoiio)) {
            xoIox();
            return;
        }
        throw new DOMException((short) 8, "Cannot find " + xxixoiio + " in " + this);
    }

    public String ooXIXxIX() {
        return this.f17142OOXIXo;
    }

    public boolean x0o(String str) throws ParseException {
        Oxx0IOOO Oxx0xo2;
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
            int i2 = i - 1;
            OxxIIOOXO[] oxxIIOOXOArr = new OxxIIOOXO[i2];
            Enumeration XO3 = II0xO02.XO();
            for (int i3 = 0; i3 < i2; i3++) {
                oxxIIOOXOArr[i3] = (OxxIIOOXO) XO3.nextElement();
            }
            OxxIIOOXO oxxIIOOXO = (OxxIIOOXO) XO3.nextElement();
            if (i2 == 0) {
                Oxx0xo2 = this;
            } else {
                String xxx2 = xxX.I0Io(II0xO02.Oxx0IOOO(), oxxIIOOXOArr).toString();
                x0o(xxx2.toString());
                Oxx0xo2 = Oxx0xo(xxx2);
            }
            Oxx0xo2.OxI(xxIXOIIO(Oxx0xo2, oxxIIOOXO, str));
            return true;
        } catch (XPathException e) {
            throw new ParseException(str, e);
        }
    }

    @Override // com.hp.hpl.sparta.xxIXOIIO
    public void x0xO0oo(Writer writer) throws IOException {
        for (xxIXOIIO xxixoiio = this.f17143Oxx0IOOO; xxixoiio != null; xxixoiio = xxixoiio.I0Io()) {
            xxixoiio.x0xO0oo(writer);
        }
    }

    public void xI(String str) {
        Hashtable hashtable = this.f17145xxIXOIIO;
        if (hashtable == null) {
            return;
        }
        hashtable.remove(str);
        this.f17144xoIox.removeElement(str);
        xoIox();
    }

    public xxIXOIIO xXxxox0I() {
        return this.f17143Oxx0IOOO;
    }

    public String xxX(String str) {
        Hashtable hashtable = this.f17145xxIXOIIO;
        if (hashtable == null) {
            return null;
        }
        return (String) hashtable.get(str);
    }

    public Oxx0IOOO() {
        this.f17143Oxx0IOOO = null;
        this.f17141II0XooXoX = null;
        this.f17145xxIXOIIO = null;
        this.f17144xoIox = null;
        this.f17142OOXIXo = null;
    }
}
