package org.apache.commons.lang3;

/* loaded from: classes6.dex */
public class xoIox {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final char f32980I0Io = '\n';

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final char f32982X0o0xo = 0;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final char f32984oxoX = '\r';

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String[] f32983oIX0oI = new String[128];

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final char[] f32981II0xO0 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    static {
        char c = 0;
        while (true) {
            String[] strArr = f32983oIX0oI;
            if (c < strArr.length) {
                strArr[c] = String.valueOf(c);
                c = (char) (c + 1);
            } else {
                return;
            }
        }
    }

    public static boolean I0Io(char c) {
        if (!X0o0xo(c) && !oxoX(c)) {
            return false;
        }
        return true;
    }

    public static boolean II0XooXoX(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean II0xO0(char c) {
        return c < 128;
    }

    public static String IIXOooo(char c) {
        StringBuilder sb = new StringBuilder();
        sb.append("\\u");
        char[] cArr = f32981II0xO0;
        sb.append(cArr[(c >> '\f') & 15]);
        sb.append(cArr[(c >> '\b') & 15]);
        sb.append(cArr[(c >> 4) & 15]);
        sb.append(cArr[c & 15]);
        return sb.toString();
    }

    public static int IXxxXO(Character ch) {
        xoIxX.xo0x(ch, "The character must not be null", new Object[0]);
        return x0xO0oo(ch.charValue());
    }

    public static char OOXIXo(Character ch, char c) {
        if (ch == null) {
            return c;
        }
        return ch.charValue();
    }

    public static int Oo(char c, int i) {
        if (!II0XooXoX(c)) {
            return i;
        }
        return c - '0';
    }

    public static boolean Oxx0IOOO(char c) {
        return c < ' ' || c == 127;
    }

    public static int Oxx0xo(Character ch, int i) {
        if (ch == null) {
            return i;
        }
        return Oo(ch.charValue(), i);
    }

    public static String OxxIIOOXO(Character ch) {
        if (ch == null) {
            return null;
        }
        return oI0IIXIo(ch.charValue());
    }

    public static boolean X0o0xo(char c) {
        return c >= 'A' && c <= 'Z';
    }

    public static boolean XO(char c) {
        if (!I0Io(c) && !II0XooXoX(c)) {
            return false;
        }
        return true;
    }

    public static String oI0IIXIo(char c) {
        if (c < 128) {
            return f32983oIX0oI[c];
        }
        return new String(new char[]{c});
    }

    public static int oIX0oI(char c, char c2) {
        return c - c2;
    }

    public static Character oO(String str) {
        if (xXOx.XIXIX(str)) {
            return null;
        }
        return Character.valueOf(str.charAt(0));
    }

    public static char oOoXoXO(String str) {
        xoIxX.x0o(str, "The String must not be empty", new Object[0]);
        return str.charAt(0);
    }

    public static char ooOOo0oXI(String str, char c) {
        if (xXOx.XIXIX(str)) {
            return c;
        }
        return str.charAt(0);
    }

    public static boolean oxoX(char c) {
        return c >= 'a' && c <= 'z';
    }

    @Deprecated
    public static Character x0XOIxOo(char c) {
        return Character.valueOf(c);
    }

    public static int x0xO0oo(char c) {
        if (II0XooXoX(c)) {
            return c - '0';
        }
        throw new IllegalArgumentException("The character " + c + " is not in the range '0' - '9'");
    }

    public static char xoIox(Character ch) {
        xoIxX.xo0x(ch, "The Character must not be null", new Object[0]);
        return ch.charValue();
    }

    public static String xoXoI(Character ch) {
        if (ch == null) {
            return null;
        }
        return IIXOooo(ch.charValue());
    }

    public static boolean xxIXOIIO(char c) {
        return c >= ' ' && c < 127;
    }
}
