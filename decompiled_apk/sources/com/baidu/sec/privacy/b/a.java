package com.baidu.sec.privacy.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static JSONObject f10008a = null;
    public static boolean b = true;
    public static SharedPreferences c = null;
    public static SharedPreferences.Editor d = null;
    public static String e = "sofire";
    public static HashSet<Integer> f = new HashSet<>();
    public static HashSet<Integer> g = new HashSet<>();
    public static boolean h = true;
    public static SharedPreferences.OnSharedPreferenceChangeListener i = new b();

    public static void a(String str) {
        try {
            SharedPreferences sharedPreferences = com.baidu.sec.privacy.a.b.b().getSharedPreferences("prv_config", 0);
            c = sharedPreferences;
            d = sharedPreferences.edit();
            e = str;
            b(d.a(str, i));
        } catch (Throwable th) {
            com.baidu.sec.privacy.d.c.a(th);
        }
    }

    public static void b(String str) {
        try {
            f10008a = null;
            f.clear();
            g.clear();
            h = true;
            try {
                f10008a = new JSONObject(str);
            } catch (Throwable unused) {
                f10008a = new JSONObject();
            }
            a();
        } catch (Throwable th) {
            com.baidu.sec.privacy.d.c.a(th);
        }
    }

    public static boolean c(String str) {
        return c.contains(str);
    }

    public static boolean c() {
        return h;
    }

    public static boolean a(int i2) {
        try {
            if (d.a(e)) {
                return !f.contains(Integer.valueOf(i2));
            }
            return false;
        } catch (Throwable th) {
            com.baidu.sec.privacy.d.c.a(th);
            return false;
        }
    }

    public static boolean b() {
        return b;
    }

    public static void a() {
        if (f10008a.optInt("0", 1) == 1) {
            b = true;
        } else {
            b = false;
        }
        JSONArray optJSONArray = f10008a.optJSONArray("1");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    f.add(Integer.valueOf(optJSONArray.getInt(i2)));
                } catch (JSONException unused) {
                }
            }
        }
        JSONArray optJSONArray2 = f10008a.optJSONArray("3");
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i3 = 0; i3 < length2; i3++) {
                try {
                    g.add(Integer.valueOf(optJSONArray2.getInt(i3)));
                } catch (JSONException unused2) {
                }
            }
        }
        if (f10008a.optInt("4", 1) == 1) {
            h = true;
        } else {
            h = false;
        }
    }

    public static boolean b(int i2) {
        try {
            return g.contains(Integer.valueOf(i2));
        } catch (Throwable th) {
            com.baidu.sec.privacy.d.c.a(th);
            return false;
        }
    }

    public static void b(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            d.putString(str, com.baidu.sec.privacy.d.a.a(str2.getBytes()));
            d.putLong(str + "la_in", System.currentTimeMillis());
            d.commit();
        } catch (Throwable th) {
            com.baidu.sec.privacy.d.c.a(th);
        }
    }

    public static void b(String str, int i2) {
        try {
            d.putInt(str, i2);
            d.putLong(str + "la_in", System.currentTimeMillis());
            d.commit();
        } catch (Throwable th) {
            com.baidu.sec.privacy.d.c.a(th);
        }
    }

    public static String a(String str, String str2) {
        try {
            String string = c.getString(str, str2);
            if (TextUtils.isEmpty(string)) {
                return str2;
            }
            try {
                return com.baidu.sec.privacy.d.a.a(string);
            } catch (Exception unused) {
                return str2;
            }
        } catch (Throwable th) {
            com.baidu.sec.privacy.d.c.a(th);
            return str2;
        }
    }

    public static long a(String str, long j) {
        return c.getLong(str, j);
    }

    public static int a(String str, int i2) {
        return c.getInt(str, i2);
    }
}
