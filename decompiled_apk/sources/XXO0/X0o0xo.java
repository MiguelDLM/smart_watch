package XXO0;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/* loaded from: classes6.dex */
public class X0o0xo {
    public static String I0Io(char c, x0xOIoO.II0xO0 iI0xO0) throws BadHanyuPinyinOutputFormatCombination {
        String[] oxoX2 = oxoX(c, iI0xO0);
        if (oxoX2 != null && oxoX2.length > 0) {
            return oxoX2[0];
        }
        return null;
    }

    public static String[] II0XooXoX(char c) {
        return X0o0xo(c);
    }

    public static String[] II0xO0(char c, II0XooXoX iI0XooXoX) {
        String[] X0o0xo2 = X0o0xo(c);
        if (X0o0xo2 != null) {
            String[] strArr = new String[X0o0xo2.length];
            for (int i = 0; i < X0o0xo2.length; i++) {
                strArr[i] = Oxx0IOOO.oIX0oI(X0o0xo2[i], II0XooXoX.f4084II0xO0, iI0XooXoX);
            }
            return strArr;
        }
        return null;
    }

    public static String[] OOXIXo(char c) {
        return II0xO0(c, II0XooXoX.f4087XO);
    }

    public static String Oxx0IOOO(String str, x0xOIoO.II0xO0 iI0xO0, String str2) throws BadHanyuPinyinOutputFormatCombination {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            String I0Io2 = I0Io(str.charAt(i), iI0xO0);
            if (I0Io2 != null) {
                stringBuffer.append(I0Io2);
                if (i != str.length() - 1) {
                    stringBuffer.append(str2);
                }
            } else {
                stringBuffer.append(str.charAt(i));
            }
        }
        return stringBuffer.toString();
    }

    public static String[] X0o0xo(char c) {
        return oIX0oI.I0Io().II0xO0(c);
    }

    public static String[] XO(char c) {
        return oIX0oI(c);
    }

    public static String[] oIX0oI(char c) {
        String[] X0o0xo2 = X0o0xo(c);
        if (X0o0xo2 != null) {
            String[] strArr = new String[X0o0xo2.length];
            for (int i = 0; i < X0o0xo2.length; i++) {
                strArr[i] = I0Io.oIX0oI(X0o0xo2[i]);
            }
            return strArr;
        }
        return null;
    }

    public static String[] oOoXoXO(char c) {
        return II0xO0(c, II0XooXoX.f4083I0Io);
    }

    public static String[] ooOOo0oXI(char c) {
        return II0xO0(c, II0XooXoX.f4086X0o0xo);
    }

    public static String[] oxoX(char c, x0xOIoO.II0xO0 iI0xO0) throws BadHanyuPinyinOutputFormatCombination {
        String[] X0o0xo2 = X0o0xo(c);
        if (X0o0xo2 != null) {
            for (int i = 0; i < X0o0xo2.length; i++) {
                X0o0xo2[i] = oxoX.II0xO0(X0o0xo2[i], iI0xO0);
            }
            return X0o0xo2;
        }
        return null;
    }

    public static String[] xoIox(char c) {
        return II0xO0(c, II0XooXoX.f4088oxoX);
    }

    public static String[] xxIXOIIO(char c, x0xOIoO.II0xO0 iI0xO0) throws BadHanyuPinyinOutputFormatCombination {
        return oxoX(c, iI0xO0);
    }
}
