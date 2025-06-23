package com.univocity.parsers.common;

import com.univocity.parsers.common.input.EOFException;
import com.univocity.parsers.common.oxoX;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import oO0IXx.xxX;
import org.apache.commons.lang3.xXOx;

/* loaded from: classes13.dex */
public abstract class oIX0oI<T extends oxoX<?>> {

    /* renamed from: I0Io, reason: collision with root package name */
    public final long f27065I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public x0oox0.I0Io f27066II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final x0XOIxOo f27067II0xO0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public ooO0oXxI.I0Io f27068OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public xxX f27069Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final oOoXoXO f27070X0o0xo = new oOoXoXO();

    /* renamed from: XO, reason: collision with root package name */
    public oO f27071XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final T f27072oIX0oI;

    /* renamed from: oO, reason: collision with root package name */
    public final boolean f27073oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public final long f27074oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public final Map<Long, String> f27075ooOOo0oXI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final char f27076oxoX;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public String f27077x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public ooO0oXxI.II0xO0 f27078x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public final IXxxXO f27079xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public char f27080xxIXOIIO;

    public oIX0oI(T t) {
        Map<Long, String> emptyMap;
        t.II0xO0();
        this.f27072oIX0oI = t;
        this.f27067II0xO0 = new x0XOIxOo(t);
        this.f27069Oxx0IOOO = t.oOXoIIIo();
        this.f27065I0Io = t.oo0xXOI0I();
        this.f27076oxoX = t.xxIXOIIO().II0xO0();
        this.f27079xoIox = t.x0xO0oo();
        this.f27074oOoXoXO = t.oo();
        boolean X00IoxXI2 = t.X00IoxXI();
        this.f27073oO = X00IoxXI2;
        if (X00IoxXI2) {
            emptyMap = new TreeMap<>();
        } else {
            emptyMap = Collections.emptyMap();
        }
        this.f27075ooOOo0oXI = emptyMap;
    }

    public static String II0XooXoX(String str, boolean z) {
        if (z) {
            if (str.contains("\r\n")) {
                return str.replaceAll("\\r\\n", "[\\\\r\\\\n]\r\n\t");
            }
            if (str.contains("\n")) {
                return str.replaceAll("\\n", "[\\\\n]\n\t");
            }
            return str.replaceAll("\\r", "[\\\\r]\r\t");
        }
        return str.replaceAll("\\n", "\\\\n").replaceAll("\\r", "\\\\r");
    }

    public final void I0Io(File file, Charset charset) {
        Oxx0IOOO(I0Io.XO(file, charset));
    }

    public final void II0xO0(File file, String str) {
        Oxx0IOOO(I0Io.X0o0xo(file, str));
    }

    public final List<ooO0oXxI.II0xO0> IIX0o(File file, String str) {
        return IoOoX(I0Io.X0o0xo(file, str));
    }

    public final void IIXOooo(InputStream inputStream, String str) {
        o00(I0Io.II0XooXoX(inputStream, str));
    }

    public final ooO0oXxI.II0xO0 IO(String str) {
        String[] oOXoIIIo2 = oOXoIIIo(str);
        if (oOXoIIIo2 == null) {
            return null;
        }
        return this.f27068OOXIXo.II0xO0(oOXoIIIo2);
    }

    public final void IXxxXO(File file) {
        o00(I0Io.oxoX(file));
    }

    public final void Io() {
        try {
            this.f27071XO.stop();
            try {
                this.f27069Oxx0IOOO.XO(this.f27071XO);
            } finally {
            }
        } catch (Throwable th) {
            try {
                this.f27069Oxx0IOOO.XO(this.f27071XO);
                throw th;
            } finally {
            }
        }
    }

    public final List<ooO0oXxI.II0xO0> IoOoX(Reader reader) {
        ArrayList arrayList = new ArrayList(10000);
        Oxx0IOOO(reader);
        while (true) {
            ooO0oXxI.II0xO0 X00IoxXI2 = X00IoxXI();
            if (X00IoxXI2 != null) {
                arrayList.add(X00IoxXI2);
            } else {
                return arrayList;
            }
        }
    }

    public final List<String[]> O0xOxO(File file, String str) {
        return XxX0x0xxx(I0Io.X0o0xo(file, str));
    }

    public final void OI0(String[] strArr) {
        try {
            this.f27069Oxx0IOOO.x0XOIxOo(strArr, this.f27071XO);
        } catch (DataProcessingException e) {
            e.setContext(this.f27071XO);
            if (!e.isFatal()) {
                this.f27079xoIox.oIX0oI(e, strArr, this.f27071XO);
                return;
            }
            throw e;
        } catch (Throwable th) {
            throw new DataProcessingException("Unexpected error processing input row " + Arrays.toString(strArr) + " using RowProcessor " + this.f27069Oxx0IOOO.getClass().getName() + '.', strArr, th);
        }
    }

    public x0oox0.XO OOXIXo() {
        return null;
    }

    public void Oo() {
    }

    public final List<String[]> OxI(File file) {
        return XxX0x0xxx(I0Io.oxoX(file));
    }

    public final void Oxx0IOOO(Reader reader) {
        this.f27067II0xO0.xoIox();
        if (reader instanceof oOoXoXO) {
            this.f27066II0XooXoX = new x0oox0.X0o0xo(this.f27072oIX0oI.xxIXOIIO().X0o0xo(), this.f27072oIX0oI.xxIXOIIO().Oxx0IOOO(), this.f27072oIX0oI.xI());
        } else {
            this.f27066II0XooXoX = this.f27072oIX0oI.XOxIOxOx();
        }
        this.f27066II0XooXoX.x0XOIxOo(true);
        xxIXOIIO xxixoiio = new xxIXOIIO(this);
        this.f27071XO = xxixoiio;
        xxixoiio.f27109I0Io = false;
        Object obj = this.f27069Oxx0IOOO;
        if (obj instanceof II0XooXoX) {
            II0XooXoX iI0XooXoX = (II0XooXoX) obj;
            iI0XooXoX.f27017XO = this.f27079xoIox;
            iI0XooXoX.f27015Oxx0IOOO = xxixoiio;
        }
        x0oox0.I0Io i0Io = this.f27066II0XooXoX;
        if (i0Io instanceof x0oox0.oIX0oI) {
            ((x0oox0.oIX0oI) i0Io).xoXoI(OOXIXo());
        }
        this.f27066II0XooXoX.Oo(reader);
        this.f27066II0XooXoX.oIX0oI(this.f27074oOoXoXO);
        this.f27068OOXIXo = new ooO0oXxI.I0Io(this.f27071XO);
        this.f27069Oxx0IOOO.oO(this.f27071XO);
        Oo();
    }

    public final void Oxx0xo(File file, String str) {
        o00(I0Io.X0o0xo(file, str));
    }

    public final void OxxIIOOXO(InputStream inputStream) {
        o00(I0Io.Oxx0IOOO(inputStream));
    }

    public final ooO0oXxI.II0xO0 X00IoxXI() {
        ooO0oXxI.II0xO0 iI0xO0 = this.f27078x0xO0oo;
        if (iI0xO0 != null) {
            this.f27078x0xO0oo = null;
            return iI0xO0;
        }
        String[] Xx000oIo2 = Xx000oIo();
        if (Xx000oIo2 == null) {
            return null;
        }
        return this.f27068OOXIXo.II0xO0(Xx000oIo2);
    }

    public final List<String[]> X0IIOO(File file, Charset charset) {
        return XxX0x0xxx(I0Io.XO(file, charset));
    }

    public final void X0o0xo(InputStream inputStream, String str) {
        Oxx0IOOO(I0Io.II0XooXoX(inputStream, str));
    }

    public final List<String[]> XI0IXoo(InputStream inputStream) {
        return XxX0x0xxx(I0Io.Oxx0IOOO(inputStream));
    }

    public final List<String[]> XIxXXX0x0(InputStream inputStream, String str) {
        return XxX0x0xxx(I0Io.II0XooXoX(inputStream, str));
    }

    public final void XO(InputStream inputStream, Charset charset) {
        Oxx0IOOO(I0Io.xxIXOIIO(inputStream, charset));
    }

    public final void XOxIOxOx() {
        this.f27067II0xO0.II0XooXoX();
        this.f27068OOXIXo = new ooO0oXxI.I0Io(this.f27071XO);
    }

    public final String[] Xx000oIo() {
        ooO0oXxI.II0xO0 iI0xO0 = this.f27078x0xO0oo;
        if (iI0xO0 != null) {
            String[] OOXIxO02 = iI0xO0.OOXIxO0();
            this.f27078x0xO0oo = null;
            return OOXIxO02;
        }
        while (!this.f27071XO.isStopped()) {
            try {
                char Oxx0IOOO2 = this.f27066II0XooXoX.Oxx0IOOO();
                this.f27080xxIXOIIO = Oxx0IOOO2;
                if (Oxx0IOOO2 == this.f27076oxoX) {
                    x0o();
                } else {
                    xII();
                    String[] OOXIXo2 = this.f27067II0xO0.OOXIXo();
                    if (OOXIXo2 != null) {
                        if (this.f27065I0Io >= 0 && this.f27071XO.xoIox() >= this.f27065I0Io) {
                            this.f27071XO.stop();
                            if (this.f27065I0Io == 0) {
                                Io();
                                return null;
                            }
                        }
                        OI0(OOXIXo2);
                        return OOXIXo2;
                    }
                }
            } catch (EOFException unused) {
                String[] oO2 = oO();
                Io();
                return oO2;
            } catch (NullPointerException e) {
                if (this.f27071XO != null) {
                    if (this.f27066II0XooXoX != null) {
                        Io();
                    }
                    throw new IllegalStateException("Error parsing next record.", e);
                }
                throw new IllegalStateException("Cannot parse without invoking method beginParsing(Reader) first");
            } catch (Throwable th) {
                try {
                    o0(x0xO0oo(th));
                    return null;
                } catch (Throwable th2) {
                    o0(th);
                    throw th2;
                }
            }
        }
        Io();
        return null;
    }

    public final List<String[]> XxX0x0xxx(Reader reader) {
        ArrayList arrayList = new ArrayList(10000);
        Oxx0IOOO(reader);
        while (true) {
            String[] Xx000oIo2 = Xx000oIo();
            if (Xx000oIo2 != null) {
                arrayList.add(Xx000oIo2);
            } else {
                return arrayList;
            }
        }
    }

    public final void o0(Throwable th) {
        if (th != null) {
            try {
                Io();
            } catch (Throwable unused) {
            }
            if (!(th instanceof DataProcessingException)) {
                if (!(th instanceof RuntimeException)) {
                    if (th instanceof Error) {
                        throw ((Error) th);
                    }
                    throw new IllegalStateException(th.getMessage(), th);
                }
                throw ((RuntimeException) th);
            }
            DataProcessingException dataProcessingException = (DataProcessingException) th;
            dataProcessingException.setContext(this.f27071XO);
            throw dataProcessingException;
        }
        Io();
    }

    public final void o00(Reader reader) {
        Oxx0IOOO(reader);
        while (!this.f27071XO.isStopped()) {
            try {
                try {
                    char Oxx0IOOO2 = this.f27066II0XooXoX.Oxx0IOOO();
                    this.f27080xxIXOIIO = Oxx0IOOO2;
                    if (Oxx0IOOO2 == this.f27076oxoX) {
                        x0o();
                    } else {
                        xII();
                        String[] OOXIXo2 = this.f27067II0xO0.OOXIXo();
                        if (OOXIXo2 == null) {
                            continue;
                        } else {
                            if (this.f27065I0Io >= 0 && this.f27071XO.xoIox() >= this.f27065I0Io) {
                                this.f27071XO.stop();
                                if (this.f27065I0Io == 0) {
                                    return;
                                }
                            }
                            OI0(OOXIXo2);
                        }
                    }
                } finally {
                    Io();
                }
            } catch (EOFException unused) {
                oO();
                return;
            } catch (Throwable th) {
                try {
                    o0(x0xO0oo(th));
                    return;
                } catch (Throwable th2) {
                    o0(th);
                    throw th2;
                }
            }
        }
    }

    public final void oI0IIXIo(File file, Charset charset) {
        o00(I0Io.XO(file, charset));
    }

    public final void oIX0oI(File file) {
        Oxx0IOOO(I0Io.oxoX(file));
    }

    public final String[] oO() {
        String[] strArr;
        x0XOIxOo x0xoixoo = this.f27067II0xO0;
        if (x0xoixoo.f27101oIX0oI != 0) {
            if (x0xoixoo.f27098Oxx0IOOO.length() > 0) {
                this.f27067II0xO0.oOoXoXO();
            } else {
                this.f27067II0xO0.II0xO0();
            }
            strArr = this.f27067II0xO0.OOXIXo();
        } else if (x0xoixoo.f27098Oxx0IOOO.length() > 0) {
            this.f27067II0xO0.oOoXoXO();
            strArr = this.f27067II0xO0.OOXIXo();
        } else {
            strArr = null;
        }
        if (strArr != null) {
            OI0(strArr);
        }
        return strArr;
    }

    public final String[] oOXoIIIo(String str) {
        String[] OOXIXo2;
        if (str == null || str.isEmpty()) {
            return null;
        }
        this.f27070X0o0xo.oIX0oI(str);
        oO oOVar = this.f27071XO;
        if (oOVar != null && !oOVar.isStopped()) {
            ((x0oox0.X0o0xo) this.f27066II0XooXoX).o00();
        } else {
            Oxx0IOOO(this.f27070X0o0xo);
        }
        do {
            try {
                if (this.f27071XO.isStopped()) {
                    return null;
                }
                char Oxx0IOOO2 = this.f27066II0XooXoX.Oxx0IOOO();
                this.f27080xxIXOIIO = Oxx0IOOO2;
                if (Oxx0IOOO2 == this.f27076oxoX) {
                    x0o();
                    return null;
                }
                xII();
                OOXIXo2 = this.f27067II0xO0.OOXIXo();
            } catch (EOFException unused) {
                return oO();
            } catch (NullPointerException e) {
                if (this.f27066II0XooXoX != null) {
                    o0(null);
                }
                throw new IllegalStateException("Error parsing next record.", e);
            } catch (Throwable th) {
                try {
                    o0(x0xO0oo(th));
                    return null;
                } catch (Throwable th2) {
                    o0(th);
                    throw th2;
                }
            }
        } while (OOXIXo2 == null);
        OI0(OOXIXo2);
        return OOXIXo2;
    }

    public final String oOoXoXO() {
        return this.f27077x0XOIxOo;
    }

    public final List<ooO0oXxI.II0xO0> oo(InputStream inputStream, Charset charset) {
        return IoOoX(I0Io.xxIXOIIO(inputStream, charset));
    }

    public final List<ooO0oXxI.II0xO0> oo0xXOI0I(InputStream inputStream, String str) {
        return IoOoX(I0Io.II0XooXoX(inputStream, str));
    }

    public final String[] ooOOo0oXI() {
        return this.f27067II0xO0.f27103ooOOo0oXI;
    }

    public final List<ooO0oXxI.II0xO0> ooXIXxIX(File file, Charset charset) {
        return IoOoX(I0Io.XO(file, charset));
    }

    public final void oxoX(InputStream inputStream) {
        Oxx0IOOO(I0Io.Oxx0IOOO(inputStream));
    }

    public final ooO0oXxI.X0o0xo x0XOIxOo() {
        if (this.f27068OOXIXo != null) {
            if (this.f27071XO.xoIox() == 0 && this.f27071XO.X0o0xo() == null && this.f27072oIX0oI.IO() && !this.f27071XO.isStopped()) {
                this.f27078x0xO0oo = X00IoxXI();
            }
            return this.f27068OOXIXo.oIX0oI();
        }
        throw new IllegalStateException("No record metadata available. The parsing process has not been started yet.");
    }

    public final void x0o() {
        if (this.f27073oO) {
            long I0Io2 = this.f27066II0XooXoX.I0Io();
            this.f27077x0XOIxOo = this.f27066II0XooXoX.xoIox();
            this.f27075ooOOo0oXI.put(Long.valueOf(I0Io2), this.f27077x0XOIxOo);
            return;
        }
        this.f27066II0XooXoX.oIX0oI(1L);
    }

    public final TextParsingException x0xO0oo(Throwable th) {
        if (!(th instanceof DataProcessingException)) {
            String str = th.getClass().getName() + " - " + th.getMessage();
            char[] oxoX2 = this.f27067II0xO0.f27098Oxx0IOOO.oxoX();
            if (oxoX2 != null) {
                int length = this.f27067II0xO0.f27098Oxx0IOOO.length();
                if (length > oxoX2.length) {
                    str = "Length of parsed input (" + length + ") exceeds the maximum number of characters defined in your parser settings (" + this.f27072oIX0oI.ooOOo0oXI() + "). ";
                    length = oxoX2.length;
                }
                String str2 = new String(oxoX2);
                if (str2.contains("\n") || str2.contains(xXOx.f32950X0o0xo)) {
                    String II0XooXoX2 = II0XooXoX(str2, true);
                    str = str + "\nIdentified line separator characters in the parsed content. This may be the cause of the error. The line separator in your parser settings is set to '" + II0XooXoX(this.f27072oIX0oI.xxIXOIIO().XO(), false) + "'. Parsed content:\n\t" + II0XooXoX2;
                }
                if (length > 1073741823) {
                    length = 1073741822;
                }
                StringBuilder sb = new StringBuilder(length);
                int i = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    char c = oxoX2[i2];
                    if (c == 0) {
                        sb.append('\\');
                        sb.append('0');
                        i++;
                    } else {
                        sb.append(c);
                    }
                }
                String sb2 = sb.toString();
                if (i > 0) {
                    str = str + "\nIdentified " + i + " null characters ('\u0000') on parsed content. This may indicate the data is corrupt or its encoding is invalid. Parsed content:\n\t" + sb2;
                }
            }
            if (th instanceof ArrayIndexOutOfBoundsException) {
                try {
                    int parseInt = Integer.parseInt(th.getMessage());
                    if (parseInt == this.f27072oIX0oI.ooOOo0oXI()) {
                        str = str + "\nHint: Number of characters processed may have exceeded limit of " + parseInt + " characters per column. Use settings.setMaxCharsPerColumn(int) to define the maximum number of characters a column can have";
                    }
                    if (parseInt == this.f27072oIX0oI.x0XOIxOo()) {
                        str = str + "\nHint: Number of columns processed may have exceeded limit of " + parseInt + " columns. Use settings.setMaxColumns(int) to define the maximum number of columns your input can have";
                    }
                    str = str + "\nEnsure your configuration is correct, with delimiters, quotes and escape sequences that match the input format you are trying to parse";
                } catch (Throwable unused) {
                }
            }
            try {
                if (!str.isEmpty()) {
                    str = str + "\n";
                }
                str = str + "Parser Configuration: " + this.f27072oIX0oI.toString();
            } catch (Exception unused2) {
            }
            return new TextParsingException(this.f27071XO, str, th);
        }
        DataProcessingException dataProcessingException = (DataProcessingException) th;
        dataProcessingException.setContext(this.f27071XO);
        throw dataProcessingException;
    }

    public final List<ooO0oXxI.II0xO0> xI(InputStream inputStream) {
        return IoOoX(I0Io.Oxx0IOOO(inputStream));
    }

    public abstract void xII();

    public final List<ooO0oXxI.II0xO0> xXxxox0I(File file) {
        return IoOoX(I0Io.oxoX(file));
    }

    public final oO xoIox() {
        return this.f27071XO;
    }

    public final void xoXoI(InputStream inputStream, Charset charset) {
        o00(I0Io.xxIXOIIO(inputStream, charset));
    }

    public final Map<Long, String> xxIXOIIO() {
        return this.f27075ooOOo0oXI;
    }

    public final List<String[]> xxX(InputStream inputStream, Charset charset) {
        return XxX0x0xxx(I0Io.xxIXOIIO(inputStream, charset));
    }
}
