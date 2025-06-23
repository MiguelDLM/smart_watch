package com.hp.hpl.sparta;

import O0.OxI;
import O0.OxxIIOOXO;
import O0.XI0IXoo;
import O0.o00;
import O0.xoXoI;
import O0.xxX;
import com.hp.hpl.sparta.xpath.XPathException;
import com.huawei.openalliance.ad.constant.x;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Vector;

/* loaded from: classes10.dex */
public abstract class xxIXOIIO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public X0o0xo f17241oIX0oI = null;

    /* renamed from: II0xO0, reason: collision with root package name */
    public Oxx0IOOO f17238II0xO0 = null;

    /* renamed from: I0Io, reason: collision with root package name */
    public xxIXOIIO f17237I0Io = null;

    /* renamed from: oxoX, reason: collision with root package name */
    public xxIXOIIO f17242oxoX = null;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public Object f17239X0o0xo = null;

    /* renamed from: XO, reason: collision with root package name */
    public int f17240XO = 0;

    public static void Oxx0IOOO(Writer writer, String str) throws IOException {
        String str2;
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt >= 128) {
                str2 = "&#" + ((int) charAt) + x.aL;
            } else if (charAt != '\"') {
                if (charAt != '<') {
                    if (charAt != '>') {
                        if (charAt != '&') {
                            if (charAt != '\'') {
                                str2 = null;
                            } else {
                                str2 = "&#39;";
                            }
                        } else {
                            str2 = "&amp;";
                        }
                    } else {
                        str2 = "&gt;";
                    }
                } else {
                    str2 = "&lt;";
                }
            } else {
                str2 = "&quot;";
            }
            if (str2 != null) {
                writer.write(str, i, i2 - i);
                writer.write(str2);
                i = i2 + 1;
            }
        }
        if (i < length) {
            writer.write(str, i, length - i);
        }
    }

    public xxIXOIIO I0Io() {
        return this.f17242oxoX;
    }

    public void II0XooXoX(xxIXOIIO xxixoiio) {
        this.f17237I0Io = xxixoiio;
        if (xxixoiio != null) {
            xxixoiio.f17242oxoX = this;
        }
    }

    public Object II0xO0() {
        return this.f17239X0o0xo;
    }

    public abstract Enumeration IIXOooo(String str) throws ParseException;

    public abstract void IXxxXO(Writer writer) throws IOException;

    public void OOXIXo() {
        xxIXOIIO xxixoiio = this.f17237I0Io;
        if (xxixoiio != null) {
            xxixoiio.f17242oxoX = this.f17242oxoX;
        }
        xxIXOIIO xxixoiio2 = this.f17242oxoX;
        if (xxixoiio2 != null) {
            xxixoiio2.f17237I0Io = xxixoiio;
        }
        this.f17242oxoX = null;
        this.f17237I0Io = null;
    }

    public String Oo() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream);
        IXxxXO(outputStreamWriter);
        outputStreamWriter.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    public abstract Oxx0IOOO Oxx0xo(String str) throws ParseException;

    public abstract String OxxIIOOXO(String str) throws ParseException;

    public Oxx0IOOO X0o0xo() {
        return this.f17238II0xO0;
    }

    public xxIXOIIO XO() {
        return this.f17237I0Io;
    }

    public abstract Object clone();

    public int hashCode() {
        if (this.f17240XO == 0) {
            this.f17240XO = oIX0oI();
        }
        return this.f17240XO;
    }

    public abstract Enumeration oI0IIXIo(String str) throws ParseException;

    public abstract int oIX0oI();

    public void oO(Oxx0IOOO oxx0IOOO) {
        this.f17238II0xO0 = oxx0IOOO;
    }

    public void oOoXoXO(xxIXOIIO xxixoiio) {
        xxIXOIIO xxixoiio2 = this.f17237I0Io;
        if (xxixoiio2 != null) {
            xxixoiio2.f17242oxoX = xxixoiio;
        }
        xxIXOIIO xxixoiio3 = this.f17242oxoX;
        if (xxixoiio3 != null) {
            xxixoiio3.f17237I0Io = xxixoiio;
        }
        xxixoiio.f17242oxoX = xxixoiio3;
        xxixoiio.f17237I0Io = this.f17237I0Io;
        this.f17242oxoX = null;
        this.f17237I0Io = null;
    }

    public void ooOOo0oXI(Object obj) {
        this.f17239X0o0xo = obj;
    }

    public X0o0xo oxoX() {
        return this.f17241oIX0oI;
    }

    public String toString() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream);
            x0xO0oo(outputStreamWriter);
            outputStreamWriter.flush();
            return new String(byteArrayOutputStream.toByteArray());
        } catch (IOException unused) {
            return super.toString();
        }
    }

    public void x0XOIxOo(X0o0xo x0o0xo) {
        this.f17241oIX0oI = x0o0xo;
    }

    public abstract void x0xO0oo(Writer writer) throws IOException;

    public void xoIox() {
        this.f17240XO = 0;
        X0o0xo x0o0xo = this.f17241oIX0oI;
        if (x0o0xo != null) {
            x0o0xo.xoIox();
        }
    }

    public boolean xoXoI(String str, String str2) throws ParseException {
        try {
            int lastIndexOf = str.lastIndexOf(47);
            int i = lastIndexOf + 1;
            if (!str.substring(i).equals("text()") && str.charAt(i) != '@') {
                throw new ParseException("Last step of Xpath expression \"" + str + "\" is not \"text()\" and does not start with a '@'. It starts with a '" + str.charAt(i) + "'");
            }
            boolean z = false;
            String substring = str.substring(0, lastIndexOf);
            if (str.charAt(i) == '@') {
                String substring2 = str.substring(lastIndexOf + 2);
                if (substring2.length() != 0) {
                    Enumeration oI0IIXIo2 = oI0IIXIo(substring);
                    while (oI0IIXIo2.hasMoreElements()) {
                        Oxx0IOOO oxx0IOOO = (Oxx0IOOO) oI0IIXIo2.nextElement();
                        if (!str2.equals(oxx0IOOO.xxX(substring2))) {
                            oxx0IOOO.X00IoxXI(substring2, str2);
                            z = true;
                        }
                    }
                    return z;
                }
                throw new ParseException("Xpath expression \"" + str + "\" specifies zero-length attribute name\"");
            }
            Enumeration oI0IIXIo3 = oI0IIXIo(substring);
            boolean hasMoreElements = oI0IIXIo3.hasMoreElements();
            while (oI0IIXIo3.hasMoreElements()) {
                Oxx0IOOO oxx0IOOO2 = (Oxx0IOOO) oI0IIXIo3.nextElement();
                Vector vector = new Vector();
                for (xxIXOIIO xXxxox0I2 = oxx0IOOO2.xXxxox0I(); xXxxox0I2 != null; xXxxox0I2 = xXxxox0I2.I0Io()) {
                    if (xXxxox0I2 instanceof IXxxXO) {
                        vector.addElement((IXxxXO) xXxxox0I2);
                    }
                }
                if (vector.size() == 0) {
                    IXxxXO iXxxXO = new IXxxXO(str2);
                    if (iXxxXO.X0IIOO().length() > 0) {
                        oxx0IOOO2.o00(iXxxXO);
                        hasMoreElements = true;
                    }
                } else {
                    IXxxXO iXxxXO2 = (IXxxXO) vector.elementAt(0);
                    if (!iXxxXO2.X0IIOO().equals(str2)) {
                        vector.removeElementAt(0);
                        iXxxXO2.XI0IXoo(str2);
                        hasMoreElements = true;
                    }
                    int i2 = 0;
                    while (i2 < vector.size()) {
                        oxx0IOOO2.oo0xXOI0I((IXxxXO) vector.elementAt(i2));
                        i2++;
                        hasMoreElements = true;
                    }
                }
            }
            return hasMoreElements;
        } catch (DOMException e) {
            throw new Error("Assertion failed " + e);
        } catch (IndexOutOfBoundsException unused) {
            throw new ParseException("Xpath expression \"" + str + "\" is not in the form \"xpathExpression/@attributeName\"");
        }
    }

    public Oxx0IOOO xxIXOIIO(Oxx0IOOO oxx0IOOO, OxxIIOOXO oxxIIOOXO, String str) throws ParseException, XPathException {
        O0.oO oIX0oI2 = oxxIIOOXO.oIX0oI();
        if (oIX0oI2 instanceof O0.ooOOo0oXI) {
            String I0Io2 = ((O0.ooOOo0oXI) oIX0oI2).I0Io();
            Oxx0IOOO oxx0IOOO2 = new Oxx0IOOO(I0Io2);
            oxxIIOOXO.II0xO0().oIX0oI(new oIX0oI(oxx0IOOO2, oxx0IOOO, str, I0Io2));
            return oxx0IOOO2;
        }
        throw new ParseException("\"" + oIX0oI2 + "\" in \"" + str + "\" is not an element test");
    }

    /* loaded from: classes10.dex */
    public class oIX0oI implements O0.oOoXoXO {

        /* renamed from: I0Io, reason: collision with root package name */
        public final /* synthetic */ String f17243I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ Oxx0IOOO f17244II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ Oxx0IOOO f17246oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public final /* synthetic */ String f17247oxoX;

        public oIX0oI(Oxx0IOOO oxx0IOOO, Oxx0IOOO oxx0IOOO2, String str, String str2) {
            this.f17246oIX0oI = oxx0IOOO;
            this.f17244II0xO0 = oxx0IOOO2;
            this.f17243I0Io = str;
            this.f17247oxoX = str2;
        }

        @Override // O0.oOoXoXO
        public void II0XooXoX(O0.Oxx0IOOO oxx0IOOO) throws XPathException {
            this.f17246oIX0oI.X00IoxXI(oxx0IOOO.II0xO0(), Long.toString(Long.MIN_VALUE));
        }

        @Override // O0.oOoXoXO
        public void OOXIXo(OxI oxI) throws XPathException {
            this.f17246oIX0oI.o00(new IXxxXO("not " + oxI.II0xO0()));
        }

        @Override // O0.oOoXoXO
        public void X0o0xo(xoXoI xoxoi) throws XPathException {
            this.f17246oIX0oI.o00(new IXxxXO(xoxoi.II0xO0()));
        }

        @Override // O0.oOoXoXO
        public void oO(O0.XO xo2) throws XPathException {
            this.f17246oIX0oI.X00IoxXI(xo2.II0xO0(), Long.toString(Long.MAX_VALUE));
        }

        @Override // O0.oOoXoXO
        public void oOoXoXO(O0.oxoX oxox) throws XPathException {
            this.f17246oIX0oI.X00IoxXI(oxox.II0xO0(), "something");
        }

        @Override // O0.oOoXoXO
        public void ooOOo0oXI(O0.Oxx0xo oxx0xo) throws XPathException {
            int II0xO02 = oxx0xo.II0xO0();
            if (this.f17244II0xO0 == null && II0xO02 != 1) {
                throw new XPathException(xxX.II0xO0(this.f17243I0Io), "Position of root node must be 1");
            }
            for (int i = 1; i < II0xO02; i++) {
                this.f17244II0xO0.o00(new Oxx0IOOO(this.f17247oxoX));
            }
        }

        @Override // O0.oOoXoXO
        public void x0xO0oo(O0.I0Io i0Io) throws XPathException {
            this.f17246oIX0oI.X00IoxXI(i0Io.II0xO0(), i0Io.I0Io());
        }

        @Override // O0.oOoXoXO
        public void xoIox(o00 o00Var) throws XPathException {
            this.f17246oIX0oI.o00(new IXxxXO("something"));
        }

        @Override // O0.oOoXoXO
        public void xxIXOIIO(O0.II0XooXoX iI0XooXoX) throws XPathException {
            this.f17246oIX0oI.X00IoxXI(iI0XooXoX.II0xO0(), "not " + iI0XooXoX.I0Io());
        }

        @Override // O0.oOoXoXO
        public void Oxx0IOOO(XI0IXoo xI0IXoo) {
        }
    }
}
