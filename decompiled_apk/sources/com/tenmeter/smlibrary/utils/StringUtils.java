package com.tenmeter.smlibrary.utils;

import android.text.TextUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes13.dex */
public final class StringUtils {
    private StringUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String capitalizeFirstLetter(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char charAt = str.charAt(0);
        if (Character.isLetter(charAt) && !Character.isUpperCase(charAt)) {
            StringBuilder sb = new StringBuilder(str.length());
            sb.append(Character.toUpperCase(charAt));
            sb.append(str.substring(1));
            return sb.toString();
        }
        return str;
    }

    public static String cnToUnicode(String str) {
        String str2 = "";
        for (char c : str.toCharArray()) {
            str2 = str2 + "\\u" + Integer.toString(c, 16);
        }
        return str2;
    }

    public static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        int length;
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || (length = charSequence.length()) != charSequence2.length()) {
            return false;
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return charSequence.equals(charSequence2);
        }
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean equalsIgnoreCase(String str, String str2) {
        if (str == null) {
            if (str2 == null) {
                return true;
            }
            return false;
        }
        return str.equalsIgnoreCase(str2);
    }

    public static String formatPhoneNumber(String str) {
        String replace = str.replace(" ", "");
        return replace.substring(0, 3) + " " + replace.substring(3, 7) + " " + replace.substring(7);
    }

    public static String getHrefInnerHtml(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Matcher matcher = Pattern.compile(".*<[\\s]*a[\\s]*.*>(.+?)<[\\s]*/a[\\s]*>.*", 2).matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return str;
    }

    public static String getMacAdd(String str, int i) {
        return Long.toHexString(Long.parseLong(str, 16) + i).toUpperCase(Locale.getDefault());
    }

    public static String getMacMinus(String str, int i) {
        return Long.toHexString(Long.parseLong(str, 16) - i).toUpperCase(Locale.getDefault());
    }

    public static String halfWidthToFullWidth(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == ' ') {
                charArray[i] = 12288;
            } else if (c >= '!' && c <= '~') {
                charArray[i] = (char) (c + 65248);
            } else {
                charArray[i] = c;
            }
        }
        return new String(charArray);
    }

    public static String htmlEscapeCharsToString(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replaceAll("&quot;", "\"");
        }
        return str;
    }

    public static boolean isBlank(String str) {
        if (str != null && str.trim().length() != 0) {
            return false;
        }
        return true;
    }

    public static Boolean isEmail(String str) {
        if (TextUtils.isEmpty(str)) {
            return Boolean.FALSE;
        }
        Boolean bool = Boolean.FALSE;
        if (str.matches("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})$")) {
            return Boolean.TRUE;
        }
        return bool;
    }

    public static boolean isEmpty(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() != 0) {
            return false;
        }
        return true;
    }

    public static boolean isLetterDigit(String str) {
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                z = true;
            }
            if (Character.isLetter(str.charAt(i))) {
                z2 = true;
            }
        }
        if (!z || !z2 || !str.matches("^[a-zA-Z0-9]+$")) {
            return false;
        }
        return true;
    }

    public static boolean isNumerEX(String str) {
        Pattern compile = Pattern.compile("-?[0-9]+.?[0-9]+");
        Pattern compile2 = Pattern.compile("[0-9]*");
        if (!compile.matcher(str).matches() && !compile2.matcher(str).matches()) {
            return false;
        }
        return true;
    }

    public static boolean isSpace(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isTrimEmpty(String str) {
        if (str != null && str.trim().length() != 0) {
            return false;
        }
        return true;
    }

    public static int length(CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        return charSequence.length();
    }

    public static String lowerFirstLetter(String str) {
        if (!isEmpty(str) && Character.isUpperCase(str.charAt(0))) {
            return String.valueOf((char) (str.charAt(0) + TokenParser.SP)) + str.substring(1);
        }
        return str;
    }

    public static String null2Length0(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static String nullStrToEmpty(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        return obj.toString();
    }

    public static String replaceBlank(String str) {
        if (str == null) {
            return "";
        }
        return Pattern.compile("\t|\r|\n|\\s*").matcher(str).replaceAll("");
    }

    public static String reverse(String str) {
        int length = length(str);
        if (length <= 1) {
            return str;
        }
        int i = length >> 1;
        char[] charArray = str.toCharArray();
        for (int i2 = 0; i2 < i; i2++) {
            char c = charArray[i2];
            int i3 = (length - i2) - 1;
            charArray[i2] = charArray[i3];
            charArray[i3] = c;
        }
        return new String(charArray);
    }

    public static String splitIndex(String str, String str2) {
        return str.substring(str.lastIndexOf(str2), str.length());
    }

    public static String toDBC(String str) {
        if (isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            char c = charArray[i];
            if (c == 12288) {
                charArray[i] = TokenParser.SP;
            } else if (65281 <= c && c <= 65374) {
                charArray[i] = (char) (c - 65248);
            } else {
                charArray[i] = c;
            }
        }
        return new String(charArray);
    }

    public static String toSBC(String str) {
        if (isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            char c = charArray[i];
            if (c == ' ') {
                charArray[i] = 12288;
            } else if ('!' <= c && c <= '~') {
                charArray[i] = (char) (c + 65248);
            } else {
                charArray[i] = c;
            }
        }
        return new String(charArray);
    }

    public static String upperFirstLetter(String str) {
        if (!isEmpty(str) && Character.isLowerCase(str.charAt(0))) {
            return String.valueOf((char) (str.charAt(0) - ' ')) + str.substring(1);
        }
        return str;
    }

    public static String utf8Encode(String str) {
        if (TextUtils.isEmpty(str) || str.getBytes().length == str.length()) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UnsupportedEncodingException occurred. ", e);
        }
    }

    public static String utf8Encode(String str, String str2) {
        if (TextUtils.isEmpty(str) || str.getBytes().length == str.length()) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str2;
        }
    }
}
