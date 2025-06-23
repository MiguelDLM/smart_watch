package com.baidu.ar;

import android.content.Context;
import java.io.File;

/* loaded from: classes7.dex */
public final class ke {
    public static String mPackageName;

    public static String ch(String str) {
        return str + "/ar/dumix_res.json";
    }

    public static String f(Context context, String str) {
        String g = g(context, str);
        if (g == null) {
            return null;
        }
        return g + File.separator + "temp";
    }

    public static String g(Context context, String str) {
        String o = km.o(context);
        if (o == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(o);
        String str2 = File.separator;
        sb.append(str2);
        sb.append("sticker");
        sb.append(str2);
        sb.append("bar_");
        sb.append(str);
        return sb.toString();
    }

    public static String getPackageName() {
        return mPackageName;
    }

    public static String h(Context context, String str) {
        String g = g(context, str);
        if (g == null) {
            return null;
        }
        return g + File.separator + "ar";
    }

    public static void setPackageName(String str) {
        if (mPackageName == null) {
            mPackageName = str;
        }
    }
}
