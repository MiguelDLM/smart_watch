package OoIXo;

/* loaded from: classes6.dex */
public final class oOoXoXO {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final char f2346I0Io = '!';

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final char f2347II0xO0 = '$';

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f2348oIX0oI = XxIIOXIXx.X0o0xo.Oxx0IOOO(oOoXoXO.class);

    public static void I0Io(int i, int i2, int i3, jxl.biff.formula.OxxIIOOXO oxxIIOOXO, StringBuffer stringBuffer) {
        stringBuffer.append(IO.II0XooXoX(oxxIIOOXO.oIX0oI(i), "'", "''"));
        stringBuffer.append(f2346I0Io);
        oxoX(i2, i3, stringBuffer);
    }

    public static String II0XooXoX(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        xxIXOIIO(i, stringBuffer);
        return stringBuffer.toString();
    }

    public static String II0xO0(int i, int i2, int i3, jxl.biff.formula.OxxIIOOXO oxxIIOOXO) {
        StringBuffer stringBuffer = new StringBuffer();
        I0Io(i, i2, i3, oxxIIOOXO, stringBuffer);
        return stringBuffer.toString();
    }

    public static int OOXIXo(String str) {
        try {
            return Integer.parseInt(str.substring(xoIox(str))) - 1;
        } catch (NumberFormatException e) {
            f2348oIX0oI.x0XOIxOo(e, e);
            return 65535;
        }
    }

    public static int Oxx0IOOO(String str) {
        int xoIox2 = xoIox(str);
        String upperCase = str.toUpperCase();
        int lastIndexOf = str.lastIndexOf(33);
        int i = lastIndexOf + 1;
        if (str.charAt(i) == '$') {
            i = lastIndexOf + 2;
        }
        if (str.charAt(xoIox2 - 1) == '$') {
            xoIox2--;
        }
        int i2 = 0;
        for (int i3 = i; i3 < xoIox2; i3++) {
            if (i3 != i) {
                i2 = (i2 + 1) * 26;
            }
            i2 += upperCase.charAt(i3) - 'A';
        }
        return i2;
    }

    public static void X0o0xo(int i, int i2, boolean z, int i3, boolean z2, jxl.biff.formula.OxxIIOOXO oxxIIOOXO, StringBuffer stringBuffer) {
        stringBuffer.append(oxxIIOOXO.oIX0oI(i));
        stringBuffer.append(f2346I0Io);
        XO(i2, z, i3, z2, stringBuffer);
    }

    public static void XO(int i, boolean z, int i2, boolean z2, StringBuffer stringBuffer) {
        if (z) {
            stringBuffer.append('$');
        }
        xxIXOIIO(i, stringBuffer);
        if (z2) {
            stringBuffer.append('$');
        }
        stringBuffer.append(Integer.toString(i2 + 1));
    }

    public static String oIX0oI(int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        oxoX(i, i2, stringBuffer);
        return stringBuffer.toString();
    }

    public static String oOoXoXO(String str) {
        int lastIndexOf = str.lastIndexOf(33);
        if (lastIndexOf == -1) {
            return "";
        }
        return str.substring(0, lastIndexOf);
    }

    public static boolean ooOOo0oXI(String str) {
        if (str.charAt(0) == '$') {
            return false;
        }
        return true;
    }

    public static void oxoX(int i, int i2, StringBuffer stringBuffer) {
        xxIXOIIO(i, stringBuffer);
        stringBuffer.append(Integer.toString(i2 + 1));
    }

    public static boolean x0XOIxOo(String str) {
        if (str.charAt(xoIox(str) - 1) != '$') {
            return true;
        }
        return false;
    }

    public static int xoIox(String str) {
        int lastIndexOf = str.lastIndexOf(33) + 1;
        boolean z = false;
        while (!z && lastIndexOf < str.length()) {
            char charAt = str.charAt(lastIndexOf);
            if (charAt >= '0' && charAt <= '9') {
                z = true;
            } else {
                lastIndexOf++;
            }
        }
        return lastIndexOf;
    }

    public static void xxIXOIIO(int i, StringBuffer stringBuffer) {
        int i2 = i % 26;
        StringBuffer stringBuffer2 = new StringBuffer();
        for (int i3 = i / 26; i3 != 0; i3 /= 26) {
            stringBuffer2.append((char) (i2 + 65));
            i2 = (i3 % 26) - 1;
        }
        stringBuffer2.append((char) (i2 + 65));
        for (int length = stringBuffer2.length() - 1; length >= 0; length--) {
            stringBuffer.append(stringBuffer2.charAt(length));
        }
    }
}
