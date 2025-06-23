package com.baidu.navisdk.util.common;

import OoOoXO0.xoXoI;
import android.text.Html;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.Locale;

/* loaded from: classes8.dex */
public class l0 {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f9238a = {"m", "km", "米", "公里"};
    private static final String[] b = {"m", IAdInterListener.AdReqParam.HEIGHT, "d", "分钟", "小时", "天"};

    /* loaded from: classes8.dex */
    public enum a {
        EN(0),
        ZH(1);


        /* renamed from: a, reason: collision with root package name */
        private int f9239a;

        a(int i) {
            this.f9239a = i;
        }

        public int a() {
            return this.f9239a;
        }
    }

    public static void a(int i, a aVar, StringBuilder sb) {
        int a2 = aVar.a();
        if (a2 != 0) {
            a2++;
        }
        if (i < 1000) {
            if (sb != null) {
                sb.append(i);
                sb.append(f9238a[a2]);
                return;
            }
            return;
        }
        if (sb != null) {
            int i2 = i / 1000;
            if (i2 >= 100) {
                sb.append(i2);
                sb.append(f9238a[a2 + 1]);
            } else {
                sb.append(new DecimalFormat("#.#").format(i / 1000.0d));
                sb.append(f9238a[a2 + 1]);
            }
        }
    }

    public static String b(int i, a aVar) {
        StringBuilder sb = new StringBuilder();
        a(i, aVar, sb);
        return sb.toString();
    }

    public static String c(int i) {
        int a2 = a.ZH.a();
        if (a2 != 0) {
            a2++;
        }
        if (i >= 1000) {
            int i2 = i / 1000;
            if (i2 >= 100) {
                return i2 + f9238a[a2 + 1];
            }
            return new DecimalFormat(i % 1000 < 100 ? xoXoI.f2670oxoX : "#.#").format(i / 1000.0d) + f9238a[a2 + 1];
        }
        return i + f9238a[a2];
    }

    public static String d(String str) {
        if (str == null) {
            return null;
        }
        return Html.fromHtml(Html.fromHtml(str.toLowerCase(Locale.getDefault()).replace("\\t", "&#x0009;").replace("\\r", "&#x000d;").replace("\\n", "&#x000a;")).toString()).toString().toUpperCase();
    }

    public static String e(int i) {
        switch (i % 10) {
            case 0:
                return "零";
            case 1:
                return "一";
            case 2:
                return "二";
            case 3:
                return "三";
            case 4:
                return "四";
            case 5:
                return "五";
            case 6:
                return "六";
            case 7:
                return "七";
            case 8:
                return "八";
            case 9:
                return "九";
            default:
                return "";
        }
    }

    public static double b(double d, double d2, double d3, double d4) {
        double d5 = d3 - d;
        double d6 = d4 - d2;
        return Math.sqrt((d5 * d5) + (d6 * d6));
    }

    public static String b(long j) {
        String str;
        if (j < 60) {
            return "<1分钟";
        }
        long j2 = j / 3600;
        long j3 = (j % 3600) / 60;
        if (j % 60 >= 30) {
            j3++;
        }
        if (j3 > 59) {
            j2++;
            j3 = 0;
        }
        String str2 = "";
        if (j2 < 1) {
            str = "";
        } else {
            str = j2 + "小时";
        }
        if (j3 >= 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(j3);
            sb.append(j2 < 1 ? "分钟" : "分");
            str2 = sb.toString();
        }
        return str + str2;
    }

    public static String a(int i, StringBuilder sb) {
        char c;
        if (i >= 1000) {
            if (sb != null) {
                int i2 = i / 1000;
                if (i2 >= 100) {
                    sb.append(i2);
                } else {
                    sb.append(new DecimalFormat("#.#").format(i / 1000.0d));
                }
            }
            c = 1;
        } else {
            if (sb != null) {
                sb.append(i);
            }
            c = 0;
        }
        return f9238a[c];
    }

    public static boolean c(String str) {
        return str == null || str.length() == 0;
    }

    public static String d(int i) {
        String[] strArr = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        String[] strArr2 = {"", "十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千"};
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (i > 0) {
            sb.insert(0, strArr[i % 10] + strArr2[i2]);
            i /= 10;
            i2++;
        }
        return sb.toString().replaceAll("零[千百十]", "零").replaceAll("零+万", "万").replaceAll("零+亿", "亿").replaceAll("亿万", "亿零").replaceAll("零+", "零").replaceAll("零$", "");
    }

    public static String b(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static double a(double d, double d2, double d3, double d4) {
        double d5 = d - d3;
        double d6 = d2 - d4;
        double cos = d5 * Math.cos(((d2 + d4) / 2.0d) * 1.7453292519943294E-7d);
        return Math.sqrt(((cos * cos) + (d6 * d6)) * 1.1119104d);
    }

    public static String b(int i) {
        if (i <= 0) {
            return "未知";
        }
        if (i < 1000) {
            return d(i) + "米";
        }
        int i2 = (i % 1000) / 100;
        int i3 = i / 1000;
        if (i2 == 0) {
            return d(i3) + "公里";
        }
        return d(i3) + "点" + e(i2) + "公里";
    }

    public static String a(long j) {
        String str;
        if (j < 60) {
            return "小于1分钟";
        }
        long j2 = j / 3600;
        long j3 = (j % 3600) / 60;
        if (j % 60 >= 30) {
            j3++;
        }
        if (j3 > 59) {
            j2++;
            j3 = 0;
        }
        String str2 = "";
        if (j2 < 1) {
            str = "";
        } else {
            str = j2 + "小时";
        }
        if (j3 >= 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(j3);
            sb.append(j2 < 1 ? "分钟" : "分");
            str2 = sb.toString();
        }
        return str + str2;
    }

    public static void a(int i, int i2, StringBuilder sb) {
        if (sb != null) {
            if (i < 60) {
                sb.append("少于1分钟");
                return;
            }
            int i3 = (i / 3600) % 24;
            int i4 = (i / 60) % 60;
            if (i < 3600) {
                sb.append(i4);
                sb.append(b[i2 + 1]);
                return;
            }
            if (i < 86400) {
                sb.append(i3);
                sb.append(b[i2 + 2]);
                if (i4 > 0) {
                    sb.append(i4);
                    sb.append("分");
                    return;
                }
                return;
            }
            sb.append(i / 86400);
            String[] strArr = b;
            sb.append(strArr[i2 + 3]);
            if (i3 > 0) {
                sb.append(i3);
                sb.append(strArr[i2 + 2]);
            }
        }
    }

    public static String a(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        a(i, i2, sb);
        return sb.toString();
    }

    public static String[] a(int i, a aVar) {
        String[] strArr = new String[2];
        int a2 = aVar.a();
        if (a2 != 0) {
            a2++;
        }
        if (i >= 1000) {
            if (i % 1000 == 0) {
                strArr[0] = new DecimalFormat(xoXoI.f2670oxoX).format(i / 1000.0d);
                strArr[1] = f9238a[a2 + 1];
            } else {
                strArr[0] = new DecimalFormat("#.#").format(i / 1000.0d);
                strArr[1] = f9238a[a2 + 1];
            }
        } else {
            strArr[0] = i + "";
            strArr[1] = f9238a[a2];
        }
        return strArr;
    }

    public static String a(int i) {
        int i2 = i % 100;
        if (i2 < 10) {
            return e(i2);
        }
        if (i2 == 10) {
            return "十";
        }
        StringBuilder sb = new StringBuilder();
        if (i2 >= 20) {
            sb.append(e(i2 / 10));
        }
        sb.append("十");
        int i3 = i2 % 10;
        if (i3 != 0) {
            sb.append(e(i3));
        }
        return sb.toString();
    }

    public static int a(String str) {
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            int i3 = i + 1;
            i2 = str.substring(i, i3).matches("[一-龥]") ? i2 + 2 : i2 + 1;
            i = i3;
        }
        return i2;
    }

    public static String a(byte[] bArr, String str) {
        if (bArr != null) {
            if (str != null && str.length() != 0) {
                try {
                    return new String(bArr, 0, bArr.length, str);
                } catch (UnsupportedEncodingException unused) {
                    return new String(bArr, 0, bArr.length);
                }
            }
            throw new IllegalArgumentException("charset may not be null or empty");
        }
        throw new IllegalArgumentException("Parameter may not be null");
    }

    public static boolean a(String[] strArr, String str) {
        if (strArr != null && strArr.length != 0 && !TextUtils.isEmpty(str)) {
            for (String str2 : strArr) {
                if (str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String a(String str, String str2, int i, String str3) {
        int indexOf;
        if (TextUtils.isEmpty(str) || !str.contains(str2) || (indexOf = str.indexOf(str2)) <= i || indexOf >= str.length()) {
            return str;
        }
        return str.replace(str.substring(0, indexOf), str.substring(0, i) + str3);
    }
}
