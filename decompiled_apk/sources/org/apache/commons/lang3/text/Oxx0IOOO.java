package org.apache.commons.lang3.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.xXOx;

@Deprecated
/* loaded from: classes6.dex */
public class Oxx0IOOO {
    public static String I0Io(String str) {
        return oxoX(str, null);
    }

    public static boolean II0XooXoX(char c, char[] cArr) {
        if (cArr == null) {
            return Character.isWhitespace(c);
        }
        for (char c2 : cArr) {
            if (c == c2) {
                return true;
            }
        }
        return false;
    }

    public static String II0xO0(String str, char... cArr) {
        int length;
        if (cArr == null) {
            length = -1;
        } else {
            length = cArr.length;
        }
        if (!xXOx.XIXIX(str) && length != 0) {
            char[] charArray = str.toCharArray();
            boolean z = true;
            for (int i = 0; i < charArray.length; i++) {
                char c = charArray[i];
                if (II0XooXoX(c, cArr)) {
                    z = true;
                } else if (z) {
                    charArray[i] = Character.toTitleCase(c);
                    z = false;
                }
            }
            return new String(charArray);
        }
        return str;
    }

    public static String OOXIXo(String str, char... cArr) {
        int length;
        if (cArr == null) {
            length = -1;
        } else {
            length = cArr.length;
        }
        if (!xXOx.XIXIX(str) && length != 0) {
            char[] charArray = str.toCharArray();
            boolean z = true;
            for (int i = 0; i < charArray.length; i++) {
                char c = charArray[i];
                if (II0XooXoX(c, cArr)) {
                    z = true;
                } else if (z) {
                    charArray[i] = Character.toLowerCase(c);
                    z = false;
                }
            }
            return new String(charArray);
        }
        return str;
    }

    public static String Oxx0IOOO(String str, char... cArr) {
        if (xXOx.XIXIX(str)) {
            return str;
        }
        if (cArr != null && cArr.length == 0) {
            return "";
        }
        int length = str.length();
        char[] cArr2 = new char[(length / 2) + 1];
        int i = 0;
        boolean z = true;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (II0XooXoX(charAt, cArr)) {
                z = true;
            } else if (z) {
                cArr2[i] = charAt;
                i++;
                z = false;
            }
        }
        return new String(cArr2, 0, i);
    }

    public static boolean X0o0xo(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (xXOx.XIXIX(charSequence) || org.apache.commons.lang3.oxoX.XOxxooXI(charSequenceArr)) {
            return false;
        }
        for (CharSequence charSequence2 : charSequenceArr) {
            if (xXOx.xOOOX(charSequence2)) {
                return false;
            }
            if (!Pattern.compile(".*\\b" + ((Object) charSequence2) + "\\b.*").matcher(charSequence).matches()) {
                return false;
            }
        }
        return true;
    }

    public static String XO(String str) {
        return Oxx0IOOO(str, null);
    }

    public static String oIX0oI(String str) {
        return II0xO0(str, null);
    }

    public static String oOoXoXO(String str, int i) {
        return ooOOo0oXI(str, i, null, false);
    }

    public static String ooOOo0oXI(String str, int i, String str2, boolean z) {
        return x0XOIxOo(str, i, str2, z, " ");
    }

    public static String oxoX(String str, char... cArr) {
        int length;
        if (cArr == null) {
            length = -1;
        } else {
            length = cArr.length;
        }
        if (!xXOx.XIXIX(str) && length != 0) {
            return II0xO0(str.toLowerCase(), cArr);
        }
        return str;
    }

    public static String x0XOIxOo(String str, int i, String str2, boolean z, String str3) {
        int i2;
        if (str == null) {
            return null;
        }
        if (str2 == null) {
            str2 = System.lineSeparator();
        }
        if (i < 1) {
            i = 1;
        }
        if (xXOx.xOOOX(str3)) {
            str3 = " ";
        }
        Pattern compile = Pattern.compile(str3);
        int length = str.length();
        StringBuilder sb = new StringBuilder(length + 32);
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + i;
            Matcher matcher = compile.matcher(str.substring(i3, Math.min((int) Math.min(2147483647L, i4 + 1), length)));
            if (matcher.find()) {
                if (matcher.start() == 0) {
                    i3 += matcher.end();
                } else {
                    i2 = matcher.start() + i3;
                }
            } else {
                i2 = -1;
            }
            if (length - i3 <= i) {
                break;
            }
            while (matcher.find()) {
                i2 = matcher.start() + i3;
            }
            if (i2 >= i3) {
                sb.append((CharSequence) str, i3, i2);
                sb.append(str2);
            } else if (z) {
                sb.append((CharSequence) str, i3, i4);
                sb.append(str2);
                i3 = i4;
            } else {
                Matcher matcher2 = compile.matcher(str.substring(i4));
                if (matcher2.find()) {
                    i2 = matcher2.start() + i3 + i;
                }
                if (i2 >= 0) {
                    sb.append((CharSequence) str, i3, i2);
                    sb.append(str2);
                } else {
                    sb.append((CharSequence) str, i3, str.length());
                    i3 = length;
                }
            }
            i3 = i2 + 1;
        }
        sb.append((CharSequence) str, i3, str.length());
        return sb.toString();
    }

    public static String xoIox(String str) {
        return OOXIXo(str, null);
    }

    public static String xxIXOIIO(String str) {
        if (xXOx.XIXIX(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        boolean z = true;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (!Character.isUpperCase(c) && !Character.isTitleCase(c)) {
                if (Character.isLowerCase(c)) {
                    if (z) {
                        charArray[i] = Character.toTitleCase(c);
                    } else {
                        charArray[i] = Character.toUpperCase(c);
                    }
                } else {
                    z = Character.isWhitespace(c);
                }
            } else {
                charArray[i] = Character.toLowerCase(c);
            }
            z = false;
        }
        return new String(charArray);
    }
}
