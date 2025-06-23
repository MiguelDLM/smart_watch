package com.blankj.utilcode.util;

import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/* loaded from: classes8.dex */
public final class EncodeUtils {
    private EncodeUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static byte[] base64Decode(String str) {
        if (str != null && str.length() != 0) {
            return Base64.decode(str, 2);
        }
        return new byte[0];
    }

    public static byte[] base64Encode(String str) {
        return base64Encode(str.getBytes());
    }

    public static String base64Encode2String(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            return Base64.encodeToString(bArr, 2);
        }
        return "";
    }

    public static String binaryDecode(String str) {
        if (str != null && str.length() != 0) {
            String[] split = str.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String str2 : split) {
                sb.append((char) Integer.parseInt(str2, 2));
            }
            return sb.toString();
        }
        return "";
    }

    public static String binaryEncode(String str) {
        if (str != null && str.length() != 0) {
            StringBuilder sb = new StringBuilder();
            for (char c : str.toCharArray()) {
                sb.append(Integer.toBinaryString(c));
                sb.append(" ");
            }
            return sb.deleteCharAt(sb.length() - 1).toString();
        }
        return "";
    }

    public static CharSequence htmlDecode(String str) {
        Spanned fromHtml;
        if (str != null && str.length() != 0) {
            if (Build.VERSION.SDK_INT >= 24) {
                fromHtml = Html.fromHtml(str, 0);
                return fromHtml;
            }
            return Html.fromHtml(str);
        }
        return "";
    }

    public static String htmlEncode(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() != 0) {
            StringBuilder sb = new StringBuilder();
            int length = charSequence.length();
            for (int i = 0; i < length; i++) {
                char charAt = charSequence.charAt(i);
                if (charAt != '\"') {
                    if (charAt != '<') {
                        if (charAt != '>') {
                            if (charAt != '&') {
                                if (charAt != '\'') {
                                    sb.append(charAt);
                                } else {
                                    sb.append("&#39;");
                                }
                            } else {
                                sb.append("&amp;");
                            }
                        } else {
                            sb.append("&gt;");
                        }
                    } else {
                        sb.append("&lt;");
                    }
                } else {
                    sb.append("&quot;");
                }
            }
            return sb.toString();
        }
        return "";
    }

    public static String urlDecode(String str) {
        return urlDecode(str, "UTF-8");
    }

    public static String urlEncode(String str) {
        return urlEncode(str, "UTF-8");
    }

    public static byte[] base64Encode(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            return Base64.encode(bArr, 2);
        }
        return new byte[0];
    }

    public static String urlDecode(String str, String str2) {
        if (str != null && str.length() != 0) {
            try {
                return URLDecoder.decode(str.replaceAll("%(?![0-9a-fA-F]{2})", "%25").replaceAll("\\+", "%2B"), str2);
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
        return "";
    }

    public static String urlEncode(String str, String str2) {
        if (str != null && str.length() != 0) {
            try {
                return URLEncoder.encode(str, str2);
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
        return "";
    }

    public static byte[] base64Decode(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            return Base64.decode(bArr, 2);
        }
        return new byte[0];
    }
}
