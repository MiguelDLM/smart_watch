package com.tenmeter.smlibrary.utils;

import android.text.Editable;
import android.text.TextUtils;
import com.baidu.mapsdkplatform.comapi.f;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* loaded from: classes13.dex */
public class StringUtil {
    public static DecimalFormat format = new DecimalFormat("0.00");
    public static DecimalFormat formatZero = new DecimalFormat("###########.######");
    public static StringBuffer sb = new StringBuffer();

    public static void charsetLength(Editable editable, int i) {
        int length = editable.toString().getBytes(Charset.defaultCharset()).length;
        if (length > i) {
            editable.delete(i - 1, length);
        }
    }

    public static String convertTo(String str) {
        String str2 = "";
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt >= '!' && charAt <= '~') {
                str2 = str2 + String.valueOf(charAt);
            } else {
                str2 = str2 + getPYChar(String.valueOf(charAt));
            }
        }
        return str2;
    }

    public static int counterChars(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt > 0 && charAt < 127) {
                i++;
            } else {
                i += 2;
            }
        }
        return i;
    }

    public static void decimal(Editable editable, int i, int i2) {
        Pattern compile = Pattern.compile("^[0-9]{0," + i + "}+(\\.[0-9]{0," + i2 + "})?$");
        String obj = editable.toString();
        if (TextUtils.isEmpty(obj)) {
            return;
        }
        if (editable.length() > 1 && editable.charAt(0) == '0' && editable.charAt(1) != '.') {
            editable.delete(0, 1);
            return;
        }
        if (FileUtils.FILE_EXTENSION_SEPARATOR.equals(obj)) {
            editable.insert(0, "0");
        } else {
            if (compile == null || compile.matcher(obj).matches() || editable.length() <= 0) {
                return;
            }
            editable.delete(editable.length() - 1, editable.length());
        }
    }

    public static final String filterUCS4(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i = 0;
        if (str.codePointCount(0, str.length()) == str.length()) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        while (i < str.length()) {
            int codePointAt = str.codePointAt(i);
            i += Character.charCount(codePointAt);
            if (!Character.isSupplementaryCodePoint(codePointAt)) {
                sb2.appendCodePoint(codePointAt);
            }
        }
        return sb2.toString();
    }

    public static String formatBalance(double d) {
        return new DecimalFormat("0.00").format(d);
    }

    public static String formatDoubToString(Double d) {
        return format.format(d);
    }

    public static String formatDoubZeroToString(Double d) {
        return formatZero.format(d);
    }

    public static String formatFloatToString(Float f) {
        return formatZero.format(f);
    }

    public static String get32UUID() {
        return UUID.randomUUID().toString().replaceAll(HelpFormatter.DEFAULT_OPT_PREFIX, "");
    }

    public static String get36UUID() {
        return UUID.randomUUID().toString();
    }

    public static String getPYChar(String str) {
        byte[] bytes = String.valueOf(str).getBytes();
        int i = (((short) (bytes[0] + 256)) * 256) + ((short) (bytes[1] + 256));
        if (i < 45217) {
            return "*";
        }
        if (i < 45253) {
            return "a";
        }
        if (i < 45761) {
            return "b";
        }
        if (i < 46318) {
            return "c";
        }
        if (i < 46826) {
            return "d";
        }
        if (i < 47010) {
            return e.TAG;
        }
        if (i < 47297) {
            return f.f6163a;
        }
        if (i < 47614) {
            return "g";
        }
        if (i < 48119) {
            return IAdInterListener.AdReqParam.HEIGHT;
        }
        if (i < 49062) {
            return "j";
        }
        if (i < 49324) {
            return t.f18411a;
        }
        if (i < 49896) {
            return "l";
        }
        if (i < 50371) {
            return "m";
        }
        if (i < 50614) {
            return "n";
        }
        if (i < 50622) {
            return "o";
        }
        if (i < 50906) {
            return "p";
        }
        if (i < 51387) {
            return "q";
        }
        if (i < 51446) {
            return "r";
        }
        if (i < 52218) {
            return "s";
        }
        if (i < 52698) {
            return "t";
        }
        if (i < 52980) {
            return IAdInterListener.AdReqParam.WIDTH;
        }
        if (i < 53689) {
            return "x";
        }
        if (i < 54481) {
            return "y";
        }
        if (i >= 55290) {
            return "*";
        }
        return "z";
    }

    public static String getPercentString(float f) {
        return String.format(Locale.US, "%d%%", Integer.valueOf((int) (f * 100.0f)));
    }

    public static boolean isChinese(char c) {
        return c >= 19968 && c <= 40869;
    }

    public static boolean isEmpty(String str) {
        return TextUtils.isEmpty(str);
    }

    public static String makeMd5(String str) {
        return MD5.getStringMD5(str);
    }

    public static String removeBlanks(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        for (int length = sb2.length() - 1; length >= 0; length--) {
            if (' ' == sb2.charAt(length) || '\n' == sb2.charAt(length) || '\t' == sb2.charAt(length) || '\r' == sb2.charAt(length)) {
                sb2.deleteCharAt(length);
            }
        }
        return sb2.toString();
    }

    public static String stringFilter(String str) throws PatternSyntaxException {
        return Pattern.compile("[^a-zA-Z0-9一-龥]").matcher(str).replaceAll("").trim();
    }

    public static String stringFilterDigitAndLetter(String str) throws PatternSyntaxException {
        return Pattern.compile("[^a-zA-Z0-9]").matcher(str).replaceAll("").trim();
    }

    public static String stringToUtf8(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean vd(String str) {
        if (str == null) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (isChinese(c)) {
                return true;
            }
        }
        return false;
    }

    public static Editable decimal(String str, int i, int i2) {
        Editable newEditable = Editable.Factory.getInstance().newEditable(str);
        decimal(newEditable, i, i2);
        return newEditable;
    }
}
