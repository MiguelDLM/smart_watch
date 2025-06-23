package com.hp.hpl.sparta;

import XXO0.oIX0oI;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.huawei.openalliance.ad.constant.x;
import java.io.IOException;
import java.io.Reader;
import java.util.Hashtable;
import kotlin.text.XIxXXX0x0;
import org.apache.log4j.helpers.oI0IIXIo;

/* loaded from: classes10.dex */
public class oOoXoXO implements oO {

    /* renamed from: IIX0o, reason: collision with root package name */
    public static final char[] f17180IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final boolean f17181IIXOooo = false;

    /* renamed from: IO, reason: collision with root package name */
    public static final char[] f17182IO;

    /* renamed from: IoOoX, reason: collision with root package name */
    public static final char[] f17183IoOoX;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final char[] f17184O0xOxO;

    /* renamed from: OI0, reason: collision with root package name */
    public static final int f17185OI0 = 100;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final boolean f17187OxxIIOOXO = true;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public static final char[] f17188X00IoxXI;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final char[] f17189X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static final char[] f17190XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static final char[] f17191XIxXXX0x0;

    /* renamed from: XOxIOxOx, reason: collision with root package name */
    public static final int f17192XOxIOxOx = 255;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public static final char[] f17193Xx000oIo;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public static final char[] f17194XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    public static final int f17195o00 = 128;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public static final char[] f17196oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public static final char[] f17197oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public static final char[] f17198oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public static final char[] f17199ooXIXxIX;

    /* renamed from: x0o, reason: collision with root package name */
    public static final char[] f17200x0o;

    /* renamed from: xI, reason: collision with root package name */
    public static final char[] f17201xI;

    /* renamed from: xII, reason: collision with root package name */
    public static final char[] f17202xII;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public static final char[] f17203xXxxox0I;

    /* renamed from: xxX, reason: collision with root package name */
    public static final char[] f17205xxX;

    /* renamed from: I0Io, reason: collision with root package name */
    public String f17206I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public final x0XOIxOo f17207II0XooXoX;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f17208IXxxXO;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public boolean f17209OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    public final char[] f17210Oo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public final Hashtable f17211Oxx0IOOO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public final II0xO0 f17212Oxx0xo;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final Reader f17213X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final Hashtable f17214XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public final ooOOo0oXI f17215oI0IIXIo;

    /* renamed from: oO, reason: collision with root package name */
    public int f17216oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public final int f17217oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public final char[] f17218ooOOo0oXI;

    /* renamed from: oxoX, reason: collision with root package name */
    public String f17219oxoX;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public int f17220x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public boolean f17221x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f17222xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public final String f17223xxIXOIIO;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final char[] f17204xoXoI = {'.', '-', '_', ':'};

    /* renamed from: OxI, reason: collision with root package name */
    public static final boolean[] f17186OxI = new boolean[128];

    static {
        for (char c = 0; c < 128; c = (char) (c + 1)) {
            f17186OxI[c] = O0xOxO(c);
        }
        f17184O0xOxO = "<!--".toCharArray();
        f17189X0IIOO = "-->".toCharArray();
        f17190XI0IXoo = "<?".toCharArray();
        f17191XIxXXX0x0 = "?>".toCharArray();
        f17205xxX = "<!DOCTYPE".toCharArray();
        f17194XxX0x0xxx = "<?xml".toCharArray();
        f17203xXxxox0I = "encoding".toCharArray();
        f17180IIX0o = "version".toCharArray();
        f17199ooXIXxIX = new char[]{'_', '.', ':', '-'};
        f17201xI = "<!".toCharArray();
        f17198oo0xXOI0I = "&#".toCharArray();
        f17197oo = "<!ENTITY".toCharArray();
        f17183IoOoX = "NDATA".toCharArray();
        f17196oOXoIIIo = "SYSTEM".toCharArray();
        f17193Xx000oIo = "PUBLIC".toCharArray();
        f17188X00IoxXI = oI0IIXIo.f33271oIX0oI.toCharArray();
        f17182IO = oI0IIXIo.f33269II0xO0.toCharArray();
        f17202xII = "/>".toCharArray();
        f17200x0o = "</".toCharArray();
    }

    public oOoXoXO(String str, char[] cArr, x0XOIxOo x0xoixoo, String str2, ooOOo0oXI ooooo0oxi) throws ParseException, EncodingMismatchException, IOException {
        this(str, null, cArr, x0xoixoo, str2, ooooo0oxi);
    }

    public static final boolean IIXOooo(char c, char[] cArr) {
        for (char c2 : cArr) {
            if (c == c2) {
                return true;
            }
        }
        return false;
    }

    public static boolean O0xOxO(char c) {
        if (!Character.isDigit(c) && !xoXoI(c) && !IIXOooo(c, f17204xoXoI) && !oI0IIXIo(c)) {
            return false;
        }
        return true;
    }

    public static boolean oI0IIXIo(char c) {
        if (c == 183 || c == 903 || c == 1600 || c == 3654 || c == 3782 || c == 12293 || c == 720 || c == 721 || c == 12445 || c == 12446) {
            return true;
        }
        switch (c) {
            case 12337:
            case 12338:
            case 12339:
            case 12340:
            case 12341:
                return true;
            default:
                switch (c) {
                    case 12540:
                    case 12541:
                    case 12542:
                        return true;
                    default:
                        return false;
                }
        }
    }

    public static boolean xoXoI(char c) {
        if ("abcdefghijklmnopqrstuvwxyz".indexOf(Character.toLowerCase(c)) != -1) {
            return true;
        }
        return false;
    }

    public final int I0Io() throws IOException {
        if (this.f17221x0xO0oo) {
            return -1;
        }
        int i = this.f17216oO;
        char[] cArr = this.f17218ooOOo0oXI;
        if (i == cArr.length) {
            this.f17216oO = 0;
            this.f17220x0XOIxOo = 0;
        }
        Reader reader = this.f17213X0o0xo;
        int i2 = this.f17216oO;
        int read = reader.read(cArr, i2, cArr.length - i2);
        if (read <= 0) {
            this.f17221x0xO0oo = true;
            return -1;
        }
        this.f17216oO += read;
        return read;
    }

    public final void I0X0x0oIo() throws ParseException, IOException {
        if (ooOOo0oXI()) {
            xII();
        } else if (XI0IXoo()) {
            O0Xx();
        } else {
            if (xxX()) {
                xoIxX();
                return;
            }
            throw new ParseException(this, "expecting comment or processing instruction or space");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x004a, code lost:
    
        r4.f17215oI0IIXIo.characters(r4.f17210Oo, 0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0051, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void I0oOIX() throws com.hp.hpl.sparta.ParseException, java.io.IOException {
        /*
            r4 = this;
            r0 = 0
        L1:
            r1 = 0
        L2:
            r2 = 60
            boolean r2 = r4.xoIox(r2)
            if (r2 != 0) goto L48
            r2 = 38
            boolean r2 = r4.xoIox(r2)
            if (r2 != 0) goto L48
            char[] r2 = com.hp.hpl.sparta.oOoXoXO.f17182IO
            boolean r2 = r4.XxX0x0xxx(r2)
            if (r2 != 0) goto L48
            char[] r2 = r4.f17210Oo
            char r3 = r4.IoOoX()
            r2[r1] = r3
            char[] r2 = r4.f17210Oo
            char r2 = r2[r1]
            r3 = 13
            if (r2 != r3) goto L3a
            char r2 = r4.ooXIXxIX()
            r3 = 10
            if (r2 != r3) goto L3a
            char[] r2 = r4.f17210Oo
            char r3 = r4.IoOoX()
            r2[r1] = r3
        L3a:
            int r1 = r1 + 1
            r2 = 255(0xff, float:3.57E-43)
            if (r1 != r2) goto L2
            com.hp.hpl.sparta.ooOOo0oXI r1 = r4.f17215oI0IIXIo
            char[] r3 = r4.f17210Oo
            r1.characters(r3, r0, r2)
            goto L1
        L48:
            if (r1 <= 0) goto L51
            com.hp.hpl.sparta.ooOOo0oXI r2 = r4.f17215oI0IIXIo
            char[] r3 = r4.f17210Oo
            r2.characters(r3, r0, r1)
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hp.hpl.sparta.oOoXoXO.I0oOIX():void");
    }

    public final String I0oOoX() throws ParseException, IOException {
        x0xO(f17203xXxxox0I);
        xo0x();
        char oOXoIIIo2 = oOXoIIIo('\'', '\"');
        StringBuffer stringBuffer = new StringBuffer();
        while (!xoIox(oOXoIIIo2)) {
            stringBuffer.append(IoOoX());
        }
        X00IoxXI(oOXoIIIo2);
        return stringBuffer.toString();
    }

    public x0XOIxOo II0XooXoX() {
        return this.f17207II0XooXoX;
    }

    @Override // com.hp.hpl.sparta.oO
    public int II0xO0() {
        return this.f17208IXxxXO;
    }

    public final boolean IIX0o() throws ParseException, IOException {
        return XxX0x0xxx(f17194XxX0x0xxx);
    }

    public final char IO() throws ParseException, IOException {
        int i;
        String str;
        x0xO(f17198oo0xXOI0I);
        if (xoIox('x')) {
            IoOoX();
            i = 16;
        } else {
            i = 10;
        }
        int i2 = 0;
        while (!xoIox(';')) {
            int i3 = i2 + 1;
            this.f17210Oo[i2] = IoOoX();
            if (i3 >= 255) {
                this.f17207II0XooXoX.II0xO0("Tmp buffer overflow on readCharRef", this.f17206I0Io, II0xO0());
                return TokenParser.SP;
            }
            i2 = i3;
        }
        X00IoxXI(';');
        String str2 = new String(this.f17210Oo, 0, i2);
        try {
            return (char) Integer.parseInt(str2, i);
        } catch (NumberFormatException unused) {
            x0XOIxOo x0xoixoo = this.f17207II0XooXoX;
            StringBuilder sb = new StringBuilder();
            sb.append("\"");
            sb.append(str2);
            sb.append("\" is not a valid ");
            if (i == 16) {
                str = "hexadecimal";
            } else {
                str = "decimal";
            }
            sb.append(str);
            sb.append(" number");
            x0xoixoo.II0xO0(sb.toString(), this.f17206I0Io, II0xO0());
            return TokenParser.SP;
        }
    }

    public final boolean IXxxXO() throws ParseException, IOException {
        return XxX0x0xxx(f17197oo);
    }

    public final void Io(Oxx0IOOO oxx0IOOO) throws ParseException, IOException {
        x0xO(f17200x0o);
        String oX2 = oX();
        if (!oX2.equals(oxx0IOOO.ooXIXxIX())) {
            this.f17207II0XooXoX.II0xO0("end tag (" + oX2 + ") does not match begin tag (" + oxx0IOOO.ooXIXxIX() + oIX0oI.I0Io.f4095I0Io, this.f17206I0Io, II0xO0());
        }
        if (xxX()) {
            xoIxX();
        }
        X00IoxXI(XIxXXX0x0.f29545XO);
    }

    public final char IoOoX() throws ParseException, IOException {
        if (this.f17220x0XOIxOo >= this.f17216oO && I0Io() == -1) {
            throw new ParseException(this, "unexpected end of expression.");
        }
        char[] cArr = this.f17218ooOOo0oXI;
        int i = this.f17220x0XOIxOo;
        char c = cArr[i];
        if (c == '\n') {
            this.f17208IXxxXO++;
        }
        this.f17220x0XOIxOo = i + 1;
        return c;
    }

    public final char[] IoOoo() throws ParseException, IOException {
        if (XxX0x0xxx(f17198oo0xXOI0I)) {
            return new char[]{IO()};
        }
        return XoX().toCharArray();
    }

    public final void Ioxxx() throws ParseException, IOException {
        IoOoX();
        while (xXxxox0I()) {
            IoOoX();
        }
    }

    public final void O0Xx() throws ParseException, IOException {
        x0xO(f17190XI0IXoo);
        while (true) {
            char[] cArr = f17191XIxXXX0x0;
            if (!XxX0x0xxx(cArr)) {
                IoOoX();
            } else {
                x0xO(cArr);
                return;
            }
        }
    }

    public final void OI0() throws ParseException, IOException {
        x0xO(f17205xxX);
        xoIxX();
        this.f17219oxoX = oX();
        if (xxX()) {
            xoIxX();
            if (!xoIox(XIxXXX0x0.f29545XO) && !xoIox('[')) {
                this.f17209OOXIXo = true;
                xXOx();
                if (xxX()) {
                    xoIxX();
                }
            }
        }
        if (xoIox('[')) {
            IoOoX();
            while (!xoIox(']')) {
                if (x0XOIxOo()) {
                    XOxIOxOx();
                } else {
                    XX0();
                }
            }
            X00IoxXI(']');
            if (xxX()) {
                xoIxX();
            }
        }
        X00IoxXI(XIxXXX0x0.f29545XO);
    }

    public final void OO() throws ParseException, IOException {
        OO0x0xX();
    }

    public final void OO0x0xX() throws ParseException, IOException {
        char IoOoX2 = IoOoX();
        while (ooXIXxIX() != IoOoX2) {
            IoOoX();
        }
        X00IoxXI(IoOoX2);
    }

    public final boolean OOXIXo(char c, char c2) throws ParseException, IOException {
        if (this.f17220x0XOIxOo >= this.f17216oO && I0Io() == -1) {
            return false;
        }
        char c3 = this.f17218ooOOo0oXI[this.f17220x0XOIxOo];
        if (c3 != c && c3 != c2) {
            return false;
        }
        return true;
    }

    public final boolean Oo() throws ParseException, IOException {
        return XxX0x0xxx(f17203xXxxox0I);
    }

    public final boolean OxI() throws ParseException, IOException {
        char ooXIXxIX2 = ooXIXxIX();
        if (ooXIXxIX2 < 128) {
            return f17186OxI[ooXIXxIX2];
        }
        return O0xOxO(ooXIXxIX2);
    }

    public int Oxx0IOOO() {
        return this.f17222xoIox;
    }

    public final boolean Oxx0xo() throws ParseException, IOException {
        return OOXIXo('\'', '\"');
    }

    public final boolean OxxIIOOXO() throws ParseException, IOException {
        if (!XxX0x0xxx(f17196oOXoIIIo) && !XxX0x0xxx(f17193Xx000oIo)) {
            return false;
        }
        return true;
    }

    public final void X00IoxXI(char c) throws ParseException, IOException {
        char IoOoX2 = IoOoX();
        if (IoOoX2 == c) {
        } else {
            throw new ParseException(this, IoOoX2, c);
        }
    }

    public final boolean X0IIOO() throws ParseException, IOException {
        return xoIox(org.apache.log4j.helpers.x0XOIxOo.f33309xxIXOIIO);
    }

    public final int X0o0xo(int i) throws IOException {
        int i2;
        int i3;
        if (this.f17221x0xO0oo) {
            return -1;
        }
        int i4 = 0;
        if (this.f17218ooOOo0oXI.length - this.f17220x0XOIxOo < i) {
            int i5 = 0;
            while (true) {
                i2 = this.f17220x0XOIxOo;
                int i6 = i2 + i5;
                i3 = this.f17216oO;
                if (i6 >= i3) {
                    break;
                }
                char[] cArr = this.f17218ooOOo0oXI;
                cArr[i5] = cArr[i2 + i5];
                i5++;
            }
            int i7 = i3 - i2;
            this.f17216oO = i7;
            this.f17220x0XOIxOo = 0;
            i4 = i7;
        }
        int I0Io2 = I0Io();
        if (I0Io2 == -1) {
            if (i4 == 0) {
                return -1;
            }
            return i4;
        }
        return i4 + I0Io2;
    }

    public final boolean XI0IXoo() throws ParseException, IOException {
        return XxX0x0xxx(f17190XI0IXoo);
    }

    public final void XIo0oOXIx() throws ParseException, IOException {
        xoIxX();
        x0xO(f17180IIX0o);
        xo0x();
        char oOXoIIIo2 = oOXoIIIo('\'', '\"');
        Ioxxx();
        X00IoxXI(oOXoIIIo2);
    }

    public final boolean XIxXXX0x0() throws ParseException, IOException {
        return xoIox(XIxXXX0x0.f29558oxoX);
    }

    public final String XO() {
        return "";
    }

    public final void XOxIOxOx() throws ParseException, IOException {
        if (X0IIOO()) {
            XoI0Ixx0();
        } else {
            xoIxX();
        }
    }

    public final boolean XX(Oxx0IOOO oxx0IOOO) throws ParseException, IOException {
        X00IoxXI(XIxXXX0x0.f29542X0o0xo);
        oxx0IOOO.IO(oX());
        while (xxX()) {
            xoIxX();
            if (!OOXIXo(IOUtils.DIR_SEPARATOR_UNIX, XIxXXX0x0.f29545XO)) {
                oo0xXOI0I(oxx0IOOO);
            }
        }
        if (xxX()) {
            xoIxX();
        }
        boolean xoIox2 = xoIox(XIxXXX0x0.f29545XO);
        if (xoIox2) {
            X00IoxXI(XIxXXX0x0.f29545XO);
        } else {
            x0xO(f17202xII);
        }
        return xoIox2;
    }

    public final void XX0() throws ParseException, IOException {
        if (XI0IXoo()) {
            O0Xx();
            return;
        }
        if (ooOOo0oXI()) {
            xII();
            return;
        }
        if (IXxxXO()) {
            oxxXoxO();
            return;
        }
        if (XxX0x0xxx(f17201xI)) {
            while (!xoIox(XIxXXX0x0.f29545XO)) {
                if (OOXIXo('\'', '\"')) {
                    char IoOoX2 = IoOoX();
                    while (!xoIox(IoOoX2)) {
                        IoOoX();
                    }
                    X00IoxXI(IoOoX2);
                } else {
                    IoOoX();
                }
            }
            X00IoxXI(XIxXXX0x0.f29545XO);
            return;
        }
        throw new ParseException(this, "expecting processing instruction, comment, or \"<!\"");
    }

    public final char Xo0() throws ParseException, IOException {
        char IoOoX2 = IoOoX();
        if (!xoXoI(IoOoX2) && IoOoX2 != '_' && IoOoX2 != ':') {
            throw new ParseException(this, IoOoX2, "letter, underscore, colon");
        }
        return IoOoX2;
    }

    public final String XoI0Ixx0() throws ParseException, IOException {
        X00IoxXI(org.apache.log4j.helpers.x0XOIxOo.f33309xxIXOIIO);
        String oX2 = oX();
        String str = (String) this.f17211Oxx0IOOO.get(oX2);
        if (str == null) {
            this.f17207II0XooXoX.II0xO0("No declaration of %" + oX2 + x.aL, this.f17206I0Io, II0xO0());
            str = "";
        }
        X00IoxXI(';');
        return str;
    }

    public final String XoX() throws ParseException, IOException {
        X00IoxXI(XIxXXX0x0.f29558oxoX);
        String oX2 = oX();
        String str = (String) this.f17214XO.get(oX2);
        if (str == null) {
            if (this.f17209OOXIXo) {
                this.f17207II0XooXoX.II0xO0("&" + oX2 + "; not found -- possibly defined in external DTD)", this.f17206I0Io, II0xO0());
            } else {
                this.f17207II0XooXoX.II0xO0("No declaration of &" + oX2 + x.aL, this.f17206I0Io, II0xO0());
            }
            str = "";
        }
        X00IoxXI(';');
        return str;
    }

    public final char Xx000oIo(char c, char c2, char c3, char c4) throws ParseException, IOException {
        char IoOoX2 = IoOoX();
        if (IoOoX2 != c && IoOoX2 != c2 && IoOoX2 != c3 && IoOoX2 != c4) {
            throw new ParseException(this, IoOoX2, new char[]{c, c2, c3, c4});
        }
        return IoOoX2;
    }

    public final boolean XxX0x0xxx(char[] cArr) throws ParseException, IOException {
        int length = cArr.length;
        if (this.f17216oO - this.f17220x0XOIxOo < length && X0o0xo(length) <= 0) {
            this.f17222xoIox = -1;
            return false;
        }
        char[] cArr2 = this.f17218ooOOo0oXI;
        int i = this.f17216oO;
        this.f17222xoIox = cArr2[i - 1];
        if (i - this.f17220x0XOIxOo < length) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (this.f17218ooOOo0oXI[this.f17220x0XOIxOo + i2] != cArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final Oxx0IOOO o0() throws ParseException, IOException {
        Oxx0IOOO oxx0IOOO = new Oxx0IOOO();
        boolean XX2 = XX(oxx0IOOO);
        this.f17215oI0IIXIo.Oxx0IOOO(oxx0IOOO);
        if (XX2) {
            x0o();
            Io(oxx0IOOO);
        }
        this.f17215oI0IIXIo.I0Io(oxx0IOOO);
        return oxx0IOOO;
    }

    public final boolean o00() throws ParseException, IOException {
        if (!ooOOo0oXI() && !XI0IXoo() && !xxX()) {
            return false;
        }
        return true;
    }

    @Override // com.hp.hpl.sparta.oO
    public String oIX0oI() {
        return this.f17206I0Io;
    }

    public final boolean oO() throws ParseException, IOException {
        return XxX0x0xxx(f17205xxX);
    }

    public final char oOXoIIIo(char c, char c2) throws ParseException, IOException {
        char IoOoX2 = IoOoX();
        if (IoOoX2 != c && IoOoX2 != c2) {
            throw new ParseException(this, IoOoX2, new char[]{c, c2});
        }
        return IoOoX2;
    }

    public final boolean oOoXoXO(char c, char c2, char c3, char c4) throws ParseException, IOException {
        if (this.f17220x0XOIxOo >= this.f17216oO && I0Io() == -1) {
            return false;
        }
        char c5 = this.f17218ooOOo0oXI[this.f17220x0XOIxOo];
        if (c5 != c && c5 != c2 && c5 != c3 && c5 != c4) {
            return false;
        }
        return true;
    }

    public final String oX() throws ParseException, IOException {
        this.f17210Oo[0] = Xo0();
        StringBuffer stringBuffer = null;
        int i = 1;
        while (OxI()) {
            if (i >= 255) {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer(i);
                    stringBuffer.append(this.f17210Oo, 0, i);
                } else {
                    stringBuffer.append(this.f17210Oo, 0, i);
                }
                i = 0;
            }
            this.f17210Oo[i] = IoOoX();
            i++;
        }
        if (stringBuffer == null) {
            return Sparta.oIX0oI(new String(this.f17210Oo, 0, i));
        }
        stringBuffer.append(this.f17210Oo, 0, i);
        return stringBuffer.toString();
    }

    public final void oo() throws ParseException, IOException {
        char[] cArr;
        x0xO(f17188X00IoxXI);
        StringBuffer stringBuffer = null;
        int i = 0;
        while (true) {
            cArr = f17182IO;
            if (XxX0x0xxx(cArr)) {
                break;
            }
            if (i >= 255) {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer(i);
                    stringBuffer.append(this.f17210Oo, 0, i);
                } else {
                    stringBuffer.append(this.f17210Oo, 0, i);
                }
                i = 0;
            }
            this.f17210Oo[i] = IoOoX();
            i++;
        }
        x0xO(cArr);
        if (stringBuffer != null) {
            stringBuffer.append(this.f17210Oo, 0, i);
            char[] charArray = stringBuffer.toString().toCharArray();
            this.f17215oI0IIXIo.characters(charArray, 0, charArray.length);
            return;
        }
        this.f17215oI0IIXIo.characters(this.f17210Oo, 0, i);
    }

    public final void oo0xXOI0I(Oxx0IOOO oxx0IOOO) throws ParseException, IOException {
        String oX2 = oX();
        xo0x();
        String xI2 = xI();
        if (oxx0IOOO.xxX(oX2) != null) {
            this.f17207II0XooXoX.II0xO0("Element " + this + " contains attribute " + oX2 + "more than once", this.f17206I0Io, II0xO0());
        }
        oxx0IOOO.X00IoxXI(oX2, xI2);
    }

    public final boolean ooOOo0oXI() throws ParseException, IOException {
        return XxX0x0xxx(f17184O0xOxO);
    }

    public final char ooXIXxIX() throws ParseException, IOException {
        if (this.f17220x0XOIxOo >= this.f17216oO && I0Io() == -1) {
            throw new ParseException(this, "unexpected end of expression.");
        }
        return this.f17218ooOOo0oXI[this.f17220x0XOIxOo];
    }

    public final String oxXx0IX() throws ParseException, IOException {
        char oOXoIIIo2 = oOXoIIIo('\'', '\"');
        StringBuffer stringBuffer = new StringBuffer();
        while (!xoIox(oOXoIIIo2)) {
            if (X0IIOO()) {
                stringBuffer.append(XoI0Ixx0());
            } else if (XIxXXX0x0()) {
                stringBuffer.append(IoOoo());
            } else {
                stringBuffer.append(IoOoX());
            }
        }
        X00IoxXI(oOXoIIIo2);
        return stringBuffer.toString();
    }

    public final void oxxXoxO() throws ParseException, IOException {
        String xXOx2;
        String xXOx3;
        x0xO(f17197oo);
        xoIxX();
        if (xoIox(org.apache.log4j.helpers.x0XOIxOo.f33309xxIXOIIO)) {
            X00IoxXI(org.apache.log4j.helpers.x0XOIxOo.f33309xxIXOIIO);
            xoIxX();
            String oX2 = oX();
            xoIxX();
            if (Oxx0xo()) {
                xXOx3 = oxXx0IX();
            } else {
                xXOx3 = xXOx();
            }
            this.f17211Oxx0IOOO.put(oX2, xXOx3);
        } else {
            String oX3 = oX();
            xoIxX();
            if (Oxx0xo()) {
                xXOx2 = oxXx0IX();
            } else if (OxxIIOOXO()) {
                xXOx2 = xXOx();
                if (xxX()) {
                    xoIxX();
                }
                char[] cArr = f17183IoOoX;
                if (XxX0x0xxx(cArr)) {
                    x0xO(cArr);
                    xoIxX();
                    oX();
                }
            } else {
                throw new ParseException(this, "expecting double-quote, \"PUBLIC\" or \"SYSTEM\" while reading entity declaration");
            }
            this.f17214XO.put(oX3, xXOx2);
        }
        if (xxX()) {
            xoIxX();
        }
        X00IoxXI(XIxXXX0x0.f29545XO);
    }

    @Override // com.hp.hpl.sparta.oO
    public String toString() {
        return this.f17206I0Io;
    }

    public final boolean x0XOIxOo() throws ParseException, IOException {
        if (!X0IIOO() && !xxX()) {
            return false;
        }
        return true;
    }

    public final void x0o() throws ParseException, IOException {
        I0oOIX();
        boolean z = true;
        while (z) {
            if (!x0xO0oo()) {
                if (XIxXXX0x0()) {
                    char[] IoOoo2 = IoOoo();
                    this.f17215oI0IIXIo.characters(IoOoo2, 0, IoOoo2.length);
                } else if (xxIXOIIO()) {
                    oo();
                } else if (XI0IXoo()) {
                    O0Xx();
                } else if (ooOOo0oXI()) {
                    xII();
                } else if (xoIox(XIxXXX0x0.f29542X0o0xo)) {
                    o0();
                }
                I0oOIX();
            }
            z = false;
            I0oOIX();
        }
    }

    public final void x0xO(char[] cArr) throws ParseException, IOException {
        int length = cArr.length;
        if (this.f17216oO - this.f17220x0XOIxOo < length && X0o0xo(length) <= 0) {
            this.f17222xoIox = -1;
            throw new ParseException(this, "end of XML file", cArr);
        }
        char[] cArr2 = this.f17218ooOOo0oXI;
        int i = this.f17216oO;
        this.f17222xoIox = cArr2[i - 1];
        if (i - this.f17220x0XOIxOo >= length) {
            for (int i2 = 0; i2 < length; i2++) {
                if (this.f17218ooOOo0oXI[this.f17220x0XOIxOo + i2] != cArr[i2]) {
                    throw new ParseException(this, new String(this.f17218ooOOo0oXI, this.f17220x0XOIxOo, length), cArr);
                }
            }
            this.f17220x0XOIxOo += length;
            return;
        }
        throw new ParseException(this, "end of XML file", cArr);
    }

    public final boolean x0xO0oo() throws ParseException, IOException {
        return XxX0x0xxx(f17200x0o);
    }

    public final String xI() throws ParseException, IOException {
        char oOXoIIIo2 = oOXoIIIo('\'', '\"');
        StringBuffer stringBuffer = new StringBuffer();
        while (!xoIox(oOXoIIIo2)) {
            if (XIxXXX0x0()) {
                stringBuffer.append(IoOoo());
            } else {
                stringBuffer.append(IoOoX());
            }
        }
        X00IoxXI(oOXoIIIo2);
        return stringBuffer.toString();
    }

    public final void xII() throws ParseException, IOException {
        x0xO(f17184O0xOxO);
        while (true) {
            char[] cArr = f17189X0IIOO;
            if (!XxX0x0xxx(cArr)) {
                IoOoX();
            } else {
                x0xO(cArr);
                return;
            }
        }
    }

    public final String xXOx() throws ParseException, IOException {
        char[] cArr = f17196oOXoIIIo;
        if (XxX0x0xxx(cArr)) {
            x0xO(cArr);
        } else {
            char[] cArr2 = f17193Xx000oIo;
            if (XxX0x0xxx(cArr2)) {
                x0xO(cArr2);
                xoIxX();
                OO();
            } else {
                throw new ParseException(this, "expecting \"SYSTEM\" or \"PUBLIC\" while reading external ID");
            }
        }
        xoIxX();
        OO0x0xX();
        return "(WARNING: external ID not read)";
    }

    public final boolean xXxxox0I() throws ParseException, IOException {
        char ooXIXxIX2 = ooXIXxIX();
        if (!Character.isDigit(ooXIXxIX2) && (('a' > ooXIXxIX2 || ooXIXxIX2 > 'z') && (('Z' > ooXIXxIX2 || ooXIXxIX2 > 'Z') && !IIXOooo(ooXIXxIX2, f17199ooXIXxIX)))) {
            return false;
        }
        return true;
    }

    public final void xo0x() throws ParseException, IOException {
        if (xxX()) {
            xoIxX();
        }
        X00IoxXI('=');
        if (xxX()) {
            xoIxX();
        }
    }

    public final boolean xoIox(char c) throws ParseException, IOException {
        if (this.f17220x0XOIxOo >= this.f17216oO && I0Io() == -1) {
            throw new ParseException(this, "unexpected end of expression.");
        }
        if (this.f17218ooOOo0oXI[this.f17220x0XOIxOo] == c) {
            return true;
        }
        return false;
    }

    public final void xoIxX() throws ParseException, IOException {
        Xx000oIo(TokenParser.SP, '\t', '\r', '\n');
        while (oOoXoXO(TokenParser.SP, '\t', '\r', '\n')) {
            IoOoX();
        }
    }

    public final void xoxXI() throws ParseException, EncodingMismatchException, IOException {
        if (IIX0o()) {
            xxIO();
        }
        while (o00()) {
            I0X0x0oIo();
        }
        if (oO()) {
            OI0();
            while (o00()) {
                I0X0x0oIo();
            }
        }
    }

    public final void xxIO() throws ParseException, EncodingMismatchException, IOException {
        x0xO(f17194XxX0x0xxx);
        XIo0oOXIx();
        if (xxX()) {
            xoIxX();
        }
        if (Oo()) {
            String I0oOoX2 = I0oOoX();
            if (this.f17223xxIXOIIO != null && !I0oOoX2.toLowerCase().equals(this.f17223xxIXOIIO)) {
                throw new EncodingMismatchException(this.f17206I0Io, I0oOoX2, this.f17223xxIXOIIO);
            }
        }
        while (true) {
            char[] cArr = f17191XIxXXX0x0;
            if (!XxX0x0xxx(cArr)) {
                IoOoX();
            } else {
                x0xO(cArr);
                return;
            }
        }
    }

    public final boolean xxIXOIIO() throws ParseException, IOException {
        return XxX0x0xxx(f17188X00IoxXI);
    }

    public final boolean xxX() throws ParseException, IOException {
        return oOoXoXO(TokenParser.SP, '\t', '\r', '\n');
    }

    public oOoXoXO(String str, Reader reader, x0XOIxOo x0xoixoo, String str2, ooOOo0oXI ooooo0oxi) throws ParseException, EncodingMismatchException, IOException {
        this(str, reader, null, x0xoixoo, str2, ooooo0oxi);
    }

    public oOoXoXO(String str, Reader reader, char[] cArr, x0XOIxOo x0xoixoo, String str2, ooOOo0oXI ooooo0oxi) throws ParseException, EncodingMismatchException, IOException {
        this.f17219oxoX = null;
        Hashtable hashtable = new Hashtable();
        this.f17214XO = hashtable;
        this.f17211Oxx0IOOO = new Hashtable();
        this.f17222xoIox = -2;
        this.f17209OOXIXo = false;
        this.f17217oOoXoXO = 1024;
        this.f17220x0XOIxOo = 0;
        this.f17216oO = 0;
        this.f17221x0xO0oo = false;
        this.f17210Oo = new char[255];
        this.f17208IXxxXO = 1;
        this.f17212Oxx0xo = null;
        x0xoixoo = x0xoixoo == null ? oO.f17179oIX0oI : x0xoixoo;
        this.f17207II0XooXoX = x0xoixoo;
        this.f17223xxIXOIIO = str2 == null ? null : str2.toLowerCase();
        hashtable.put("lt", "<");
        hashtable.put("gt", ">");
        hashtable.put("amp", "&");
        hashtable.put("apos", "'");
        hashtable.put("quot", "\"");
        if (cArr != null) {
            this.f17218ooOOo0oXI = cArr;
            this.f17220x0XOIxOo = 0;
            this.f17216oO = cArr.length;
            this.f17221x0xO0oo = true;
            this.f17213X0o0xo = null;
        } else {
            this.f17213X0o0xo = reader;
            this.f17218ooOOo0oXI = new char[1024];
            I0Io();
        }
        this.f17206I0Io = str;
        this.f17215oI0IIXIo = ooooo0oxi;
        ooooo0oxi.X0o0xo(this);
        xoxXI();
        ooooo0oxi.startDocument();
        Oxx0IOOO o02 = o0();
        String str3 = this.f17219oxoX;
        if (str3 != null && !str3.equals(o02.ooXIXxIX())) {
            x0xoixoo.II0xO0("DOCTYPE name \"" + this.f17219oxoX + "\" not same as tag name, \"" + o02.ooXIXxIX() + "\" of root element", this.f17206I0Io, II0xO0());
        }
        while (o00()) {
            I0X0x0oIo();
        }
        Reader reader2 = this.f17213X0o0xo;
        if (reader2 != null) {
            reader2.close();
        }
        this.f17215oI0IIXIo.endDocument();
    }
}
