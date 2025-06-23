package xOx;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import org.apache.commons.lang3.oxoX;
import org.apache.commons.lang3.xXOx;
import xOx.X0o0xo;

/* loaded from: classes6.dex */
public final class II0XooXoX {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final X0o0xo.I0Io f34484oIX0oI = new X0o0xo.I0Io(',');

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final X0o0xo.I0Io f34480II0xO0 = new X0o0xo.I0Io('\"');

    /* renamed from: I0Io, reason: collision with root package name */
    public static final II0XooXoX f34478I0Io = new II0XooXoX();

    /* renamed from: oxoX, reason: collision with root package name */
    public static final X0o0xo.C1161X0o0xo f34485oxoX = new X0o0xo.C1161X0o0xo();

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final X0o0xo.oxoX f34482X0o0xo = new X0o0xo.oxoX("'\"".toCharArray());

    /* renamed from: XO, reason: collision with root package name */
    public static final X0o0xo.I0Io f34483XO = new X0o0xo.I0Io('\'');

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final X0o0xo.I0Io f34481Oxx0IOOO = new X0o0xo.I0Io(TokenParser.SP);

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final X0o0xo.oxoX f34479II0XooXoX = new X0o0xo.oxoX(" \t\n\r\f".toCharArray());

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final X0o0xo.I0Io f34487xxIXOIIO = new X0o0xo.I0Io('\t');

    /* renamed from: xoIox, reason: collision with root package name */
    public static final X0o0xo.XO f34486xoIox = new X0o0xo.XO();

    public Oxx0IOOO I0Io(String str) {
        int OIx00oxx2 = xXOx.OIx00oxx(str);
        if (OIx00oxx2 == 0) {
            return f34485oxoX;
        }
        if (OIx00oxx2 == 1) {
            return new X0o0xo.I0Io(str.charAt(0));
        }
        return new X0o0xo.oxoX(str.toCharArray());
    }

    public Oxx0IOOO II0XooXoX() {
        return f34482X0o0xo;
    }

    public Oxx0IOOO II0xO0(char c) {
        return new X0o0xo.I0Io(c);
    }

    public Oxx0IOOO OOXIXo() {
        return f34479II0XooXoX;
    }

    public Oxx0IOOO Oxx0IOOO() {
        return f34485oxoX;
    }

    public Oxx0IOOO X0o0xo() {
        return f34484oIX0oI;
    }

    public Oxx0IOOO XO() {
        return f34480II0xO0;
    }

    public Oxx0IOOO oIX0oI(Oxx0IOOO... oxx0IOOOArr) {
        int XoI0Ixx02 = oxoX.XoI0Ixx0(oxx0IOOOArr);
        if (XoI0Ixx02 == 0) {
            return f34485oxoX;
        }
        if (XoI0Ixx02 == 1) {
            return oxx0IOOOArr[0];
        }
        return new X0o0xo.oIX0oI(oxx0IOOOArr);
    }

    public Oxx0IOOO oO() {
        return f34486xoIox;
    }

    public Oxx0IOOO oOoXoXO(String str) {
        if (xXOx.XIXIX(str)) {
            return f34485oxoX;
        }
        return ooOOo0oXI(str.toCharArray());
    }

    public Oxx0IOOO ooOOo0oXI(char... cArr) {
        Oxx0IOOO iI0xO0;
        int XoI0Ixx02 = oxoX.XoI0Ixx0(cArr);
        if (XoI0Ixx02 == 0) {
            return f34485oxoX;
        }
        if (XoI0Ixx02 == 1) {
            iI0xO0 = new X0o0xo.I0Io(cArr[0]);
        } else {
            iI0xO0 = new X0o0xo.II0xO0(cArr);
        }
        return iI0xO0;
    }

    public Oxx0IOOO oxoX(char... cArr) {
        int XoI0Ixx02 = oxoX.XoI0Ixx0(cArr);
        if (XoI0Ixx02 == 0) {
            return f34485oxoX;
        }
        if (XoI0Ixx02 == 1) {
            return new X0o0xo.I0Io(cArr[0]);
        }
        return new X0o0xo.oxoX(cArr);
    }

    public Oxx0IOOO x0XOIxOo() {
        return f34487xxIXOIIO;
    }

    public Oxx0IOOO xoIox() {
        return f34481Oxx0IOOO;
    }

    public Oxx0IOOO xxIXOIIO() {
        return f34483XO;
    }
}
