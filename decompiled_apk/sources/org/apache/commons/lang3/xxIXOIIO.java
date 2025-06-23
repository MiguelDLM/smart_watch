package org.apache.commons.lang3;

/* loaded from: classes6.dex */
public class xxIXOIIO {
    public static boolean I0Io(String[] strArr) {
        if (strArr != null) {
            for (String str : strArr) {
                if (xXOx.xOoOIoI(str)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public static int II0xO0(String str, String... strArr) {
        if (xXOx.XIXIX(str) || I0Io(strArr)) {
            return 0;
        }
        CharSet charSet = CharSet.getInstance(strArr);
        int i = 0;
        for (char c : str.toCharArray()) {
            if (charSet.contains(c)) {
                i++;
            }
        }
        return i;
    }

    public static String Oxx0IOOO(String str, String... strArr) {
        if (!xXOx.XIXIX(str) && !I0Io(strArr)) {
            CharSet charSet = CharSet.getInstance(strArr);
            StringBuilder sb = new StringBuilder(str.length());
            char[] charArray = str.toCharArray();
            int length = charArray.length;
            char c = charArray[0];
            sb.append(c);
            Character ch = null;
            Character ch2 = null;
            for (int i = 1; i < length; i++) {
                char c2 = charArray[i];
                if (c2 == c) {
                    if (ch == null || c2 != ch.charValue()) {
                        if (ch2 == null || c2 != ch2.charValue()) {
                            if (charSet.contains(c2)) {
                                ch = Character.valueOf(c2);
                            } else {
                                ch2 = Character.valueOf(c2);
                            }
                        }
                    }
                }
                sb.append(c2);
                c = c2;
            }
            return sb.toString();
        }
        return str;
    }

    public static String X0o0xo(String str, String... strArr) {
        if (str == null) {
            return null;
        }
        if (!str.isEmpty() && !I0Io(strArr)) {
            return XO(str, strArr, true);
        }
        return "";
    }

    public static String XO(String str, String[] strArr, boolean z) {
        CharSet charSet = CharSet.getInstance(strArr);
        StringBuilder sb = new StringBuilder(str.length());
        for (char c : str.toCharArray()) {
            if (charSet.contains(c) == z) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static boolean oIX0oI(String str, String... strArr) {
        if (!xXOx.XIXIX(str) && !I0Io(strArr)) {
            CharSet charSet = CharSet.getInstance(strArr);
            for (char c : str.toCharArray()) {
                if (charSet.contains(c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String oxoX(String str, String... strArr) {
        if (!xXOx.XIXIX(str) && !I0Io(strArr)) {
            return XO(str, strArr, false);
        }
        return str;
    }
}
