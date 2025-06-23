package org.apache.commons.lang3;

import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public class xII {
    public static String I0Io(String str, String str2) {
        return II0XooXoX(str, str2, "");
    }

    public static String II0XooXoX(String str, String str2, String str3) {
        if (str != null && str2 != null && str3 != null) {
            return str.replaceFirst(str2, str3);
        }
        return str;
    }

    public static String II0xO0(String str, Pattern pattern) {
        return Oxx0IOOO(str, pattern, "");
    }

    public static String Oxx0IOOO(String str, Pattern pattern, String str2) {
        if (str != null && pattern != null && str2 != null) {
            return pattern.matcher(str).replaceAll(str2);
        }
        return str;
    }

    public static String X0o0xo(String str, String str2) {
        return xoIox(str, str2, "");
    }

    public static String XO(String str, String str2, String str3) {
        if (str != null && str2 != null && str3 != null) {
            return str.replaceAll(str2, str3);
        }
        return str;
    }

    public static String oIX0oI(String str, String str2) {
        return XO(str, str2, "");
    }

    public static String oxoX(String str, Pattern pattern) {
        return xxIXOIIO(str, pattern, "");
    }

    public static String xoIox(String str, String str2, String str3) {
        if (str != null && str2 != null && str3 != null) {
            return Pattern.compile(str2, 32).matcher(str).replaceAll(str3);
        }
        return str;
    }

    public static String xxIXOIIO(String str, Pattern pattern, String str2) {
        if (str != null && pattern != null && str2 != null) {
            return pattern.matcher(str).replaceFirst(str2);
        }
        return str;
    }
}
