package org.apache.commons.text;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.xXOx;
import org.apache.commons.lang3.xoIxX;

/* loaded from: classes6.dex */
public class x0xO0oo {
    public static String I0Io(String str, char... cArr) {
        int codePointAt;
        if (xXOx.XIXIX(str)) {
            return str;
        }
        Set<Integer> Oxx0IOOO2 = Oxx0IOOO(cArr);
        int length = str.length();
        int[] iArr = new int[length];
        int i = 0;
        int i2 = 0;
        while (true) {
            boolean z = true;
            while (i < length) {
                codePointAt = str.codePointAt(i);
                if (Oxx0IOOO2.contains(Integer.valueOf(codePointAt))) {
                    break;
                }
                if (z) {
                    int titleCase = Character.toTitleCase(codePointAt);
                    iArr[i2] = titleCase;
                    i += Character.charCount(titleCase);
                    i2++;
                    z = false;
                } else {
                    iArr[i2] = codePointAt;
                    i += Character.charCount(codePointAt);
                    i2++;
                }
            }
            return new String(iArr, 0, i2);
            iArr[i2] = codePointAt;
            i += Character.charCount(codePointAt);
            i2++;
        }
    }

    public static String II0XooXoX(String str) {
        return xxIXOIIO(str, null);
    }

    public static String II0xO0(String str) {
        return I0Io(str, null);
    }

    @Deprecated
    public static boolean OOXIXo(int i, char[] cArr) {
        if (cArr == null) {
            return Character.isWhitespace(i);
        }
        for (int i2 = 0; i2 < cArr.length; i2++) {
            if (Character.codePointAt(cArr, i2) == i) {
                return true;
            }
        }
        return false;
    }

    public static String Oo(String str, int i, String str2, boolean z, String str3) {
        int i2;
        int i3;
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
        int i4 = 0;
        loop0: while (true) {
            i2 = -1;
            while (i4 < length) {
                Matcher matcher = compile.matcher(str.substring(i4, Math.min((int) Math.min(2147483647L, i4 + i + 1), length)));
                if (matcher.find()) {
                    if (matcher.start() == 0) {
                        i2 = matcher.end() - matcher.start();
                        if (i2 != 0) {
                            i4 += matcher.end();
                        } else {
                            i4++;
                        }
                    }
                    i3 = matcher.start() + i4;
                } else {
                    i3 = -1;
                }
                if (length - i4 <= i) {
                    break loop0;
                }
                while (matcher.find()) {
                    i3 = matcher.start() + i4;
                }
                if (i3 >= i4) {
                    sb.append((CharSequence) str, i4, i3);
                    sb.append(str2);
                } else if (z) {
                    if (i2 == 0) {
                        i4--;
                    }
                    int i5 = i + i4;
                    sb.append((CharSequence) str, i4, i5);
                    sb.append(str2);
                    i4 = i5;
                } else {
                    Matcher matcher2 = compile.matcher(str.substring(i4 + i));
                    if (matcher2.find()) {
                        i2 = matcher2.end() - matcher2.start();
                        i3 = matcher2.start() + i4 + i;
                    }
                    if (i3 >= 0) {
                        if (i2 == 0 && i4 != 0) {
                            i4--;
                        }
                        sb.append((CharSequence) str, i4, i3);
                        sb.append(str2);
                    } else {
                        if (i2 == 0 && i4 != 0) {
                            i4--;
                        }
                        sb.append((CharSequence) str, i4, str.length());
                        i4 = length;
                    }
                }
                i4 = i3 + 1;
            }
            break loop0;
        }
        if (i2 == 0 && i4 < length) {
            i4--;
        }
        sb.append((CharSequence) str, i4, str.length());
        return sb.toString();
    }

    public static Set<Integer> Oxx0IOOO(char[] cArr) {
        HashSet hashSet = new HashSet();
        if (cArr != null && cArr.length != 0) {
            for (int i = 0; i < cArr.length; i++) {
                hashSet.add(Integer.valueOf(Character.codePointAt(cArr, i)));
            }
            return hashSet;
        }
        if (cArr == null) {
            hashSet.add(Integer.valueOf(Character.codePointAt(new char[]{TokenParser.SP}, 0)));
        }
        return hashSet;
    }

    public static String X0o0xo(String str, char... cArr) {
        if (xXOx.XIXIX(str)) {
            return str;
        }
        return I0Io(str.toLowerCase(), cArr);
    }

    public static boolean XO(CharSequence charSequence, CharSequence... charSequenceArr) {
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

    public static String oIX0oI(String str, int i, int i2, String str2) {
        boolean z;
        boolean z2 = true;
        if (i2 >= -1) {
            z = true;
        } else {
            z = false;
        }
        xoIxX.XI0IXoo(z, "upper value cannot be less than -1", new Object[0]);
        if (i2 < i && i2 != -1) {
            z2 = false;
        }
        xoIxX.XI0IXoo(z2, "upper value is less than lower value", new Object[0]);
        if (xXOx.XIXIX(str)) {
            return str;
        }
        if (i > str.length()) {
            i = str.length();
        }
        if (i2 == -1 || i2 > str.length()) {
            i2 = str.length();
        }
        StringBuilder sb = new StringBuilder();
        int xoxXI2 = xXOx.xoxXI(str, " ", i);
        if (xoxXI2 == -1) {
            sb.append((CharSequence) str, 0, i2);
            if (i2 != str.length()) {
                sb.append(xXOx.oo0xXOI0I(str2));
            }
        } else if (xoxXI2 > i2) {
            sb.append((CharSequence) str, 0, i2);
            sb.append(xXOx.oo0xXOI0I(str2));
        } else {
            sb.append((CharSequence) str, 0, xoxXI2);
            sb.append(xXOx.oo0xXOI0I(str2));
        }
        return sb.toString();
    }

    public static String oO(String str, int i) {
        return x0xO0oo(str, i, null, false);
    }

    public static String oOoXoXO(String str) {
        if (xXOx.XIXIX(str)) {
            return str;
        }
        int length = str.length();
        int[] iArr = new int[length];
        boolean z = true;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (!Character.isUpperCase(codePointAt) && !Character.isTitleCase(codePointAt)) {
                if (Character.isLowerCase(codePointAt)) {
                    if (z) {
                        codePointAt = Character.toTitleCase(codePointAt);
                    } else {
                        codePointAt = Character.toUpperCase(codePointAt);
                    }
                } else {
                    z = Character.isWhitespace(codePointAt);
                }
                iArr[i2] = codePointAt;
                i += Character.charCount(codePointAt);
                i2++;
            } else {
                codePointAt = Character.toLowerCase(codePointAt);
            }
            z = false;
            iArr[i2] = codePointAt;
            i += Character.charCount(codePointAt);
            i2++;
        }
        return new String(iArr, 0, i2);
    }

    public static String ooOOo0oXI(String str) {
        return x0XOIxOo(str, null);
    }

    public static String oxoX(String str) {
        return X0o0xo(str, null);
    }

    public static String x0XOIxOo(String str, char... cArr) {
        int codePointAt;
        if (xXOx.XIXIX(str)) {
            return str;
        }
        Set<Integer> Oxx0IOOO2 = Oxx0IOOO(cArr);
        int length = str.length();
        int[] iArr = new int[length];
        int i = 0;
        int i2 = 0;
        while (true) {
            boolean z = true;
            while (i < length) {
                codePointAt = str.codePointAt(i);
                if (Oxx0IOOO2.contains(Integer.valueOf(codePointAt))) {
                    break;
                }
                if (z) {
                    int lowerCase = Character.toLowerCase(codePointAt);
                    iArr[i2] = lowerCase;
                    i += Character.charCount(lowerCase);
                    i2++;
                    z = false;
                } else {
                    iArr[i2] = codePointAt;
                    i += Character.charCount(codePointAt);
                    i2++;
                }
            }
            return new String(iArr, 0, i2);
            iArr[i2] = codePointAt;
            i += Character.charCount(codePointAt);
            i2++;
        }
    }

    public static String x0xO0oo(String str, int i, String str2, boolean z) {
        return Oo(str, i, str2, z, " ");
    }

    @Deprecated
    public static boolean xoIox(char c, char[] cArr) {
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

    public static String xxIXOIIO(String str, char... cArr) {
        if (xXOx.XIXIX(str)) {
            return str;
        }
        if (cArr != null && cArr.length == 0) {
            return "";
        }
        Set<Integer> Oxx0IOOO2 = Oxx0IOOO(cArr);
        int length = str.length();
        int[] iArr = new int[(length / 2) + 1];
        int i = 0;
        int i2 = 0;
        boolean z = true;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (!Oxx0IOOO2.contains(Integer.valueOf(codePointAt)) && (cArr != null || !Character.isWhitespace(codePointAt))) {
                if (z) {
                    iArr[i2] = codePointAt;
                    i2++;
                    z = false;
                }
            } else {
                z = true;
            }
            i += Character.charCount(codePointAt);
        }
        return new String(iArr, 0, i2);
    }
}
