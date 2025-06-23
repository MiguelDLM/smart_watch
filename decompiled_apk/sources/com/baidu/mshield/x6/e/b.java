package com.baidu.mshield.x6.e;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/* loaded from: classes7.dex */
public class b {
    public static String a(Context context) {
        String b;
        String c;
        try {
            if (com.baidu.mshield.x6.b.b.a()) {
                b = new com.baidu.mshield.x6.a.b(context).c();
            } else {
                b = new com.baidu.mshield.x6.a.b(context).b();
            }
            if (TextUtils.isEmpty(b)) {
                if (com.baidu.mshield.x6.b.b.a()) {
                    b = d(context, "x_o_b_d");
                } else {
                    b = d(context, "x_b_d");
                }
            }
            if (!TextUtils.isEmpty(b)) {
                return b;
            }
            if (com.baidu.mshield.x6.b.b.a()) {
                c = c(context, ".x_o_b_d");
            } else {
                c = c(context, ".x_b_d");
            }
            return c;
        } catch (Throwable th) {
            f.a(th);
            return "";
        }
    }

    public static void b(Context context) {
        try {
            com.baidu.mshield.x6.a.b bVar = new com.baidu.mshield.x6.a.b(context);
            String a2 = a(context);
            if (!TextUtils.isEmpty(a2) && !bVar.f()) {
                if (!a(a2)) {
                    return;
                }
                a(context, 1);
                a(context, 2);
                a(context, 3);
            }
            bVar.b(true);
        } catch (Throwable th) {
            f.a(th);
        }
    }

    public static String c(Context context, String str) {
        try {
            if (!com.baidu.sec.privacy.d.c.a(context) || !k.a(context, new String[]{com.kuaishou.weapon.p0.g.i})) {
                return "";
            }
            File a2 = com.baidu.mshield.b.e.a.a(context, Environment.getExternalStorageDirectory() + File.separator + str);
            if (a2 == null || !a2.exists()) {
                return "";
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(a2));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    bufferedReader.close();
                    return sb.toString().trim();
                }
            }
        } catch (Throwable th) {
            f.a(th);
            return "";
        }
    }

    public static String d(Context context, String str) {
        try {
            return com.baidu.mshield.b.e.a.d(context, str);
        } catch (Throwable th) {
            f.a(th);
            return "";
        }
    }

    public static void e(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (com.baidu.mshield.x6.b.b.a()) {
                new com.baidu.mshield.x6.a.b(context).h(str);
                b(context, str, "g_m_o_bs");
                a(context, str, ".g_m_o_bs");
            } else {
                new com.baidu.mshield.x6.a.b(context).i(str);
                b(context, str, "g_m_b_s");
                a(context, str, ".g_m_b_s");
            }
        } catch (Throwable th) {
            f.a(th);
        }
    }

    public static void b(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            new com.baidu.mshield.x6.a.b(context).f(str);
            b(context, str, "g_b_d_v");
            a(context, str, ".g_b_d_v");
        } catch (Throwable th) {
            f.a(th);
        }
    }

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (com.baidu.mshield.x6.b.b.a()) {
                new com.baidu.mshield.x6.a.b(context).c(str);
                b(context, str, "x_o_b_d");
                a(context, str, ".x_o_b_d");
            } else {
                new com.baidu.mshield.x6.a.b(context).b(str);
                b(context, str, "x_b_d");
                a(context, str, ".x_b_d");
            }
        } catch (Throwable th) {
            f.a(th);
        }
    }

    public static String c(Context context) {
        String b;
        String d;
        String c;
        try {
            if (com.baidu.mshield.x6.b.b.a()) {
                b = new com.baidu.mshield.x6.a.b(context).c();
                d = d(context, "x_o_b_d");
                c = c(context, ".x_o_b_d");
            } else {
                b = new com.baidu.mshield.x6.a.b(context).b();
                d = d(context, "x_b_d");
                c = c(context, ".x_b_d");
            }
            boolean a2 = k.a(context, new String[]{com.kuaishou.weapon.p0.g.j});
            boolean a3 = k.a(context, new String[]{"android.permission.WRITE_SETTINGS"});
            return (a2 && a3) ? (TextUtils.isEmpty(b) && TextUtils.isEmpty(d) && TextUtils.isEmpty(c)) ? "1" : (TextUtils.isEmpty(b) || TextUtils.isEmpty(d) || TextUtils.isEmpty(c)) ? (!TextUtils.isEmpty(b) || TextUtils.isEmpty(d) || TextUtils.isEmpty(c)) ? "4" : "3" : "2" : (!a2 || a3) ? (a2 || !a3) ? !TextUtils.isEmpty(b) ? "2" : "4" : (TextUtils.isEmpty(b) && TextUtils.isEmpty(d)) ? "1" : (TextUtils.isEmpty(b) || TextUtils.isEmpty(d)) ? (!TextUtils.isEmpty(b) || TextUtils.isEmpty(d)) ? "4" : "3" : "2" : (TextUtils.isEmpty(b) && TextUtils.isEmpty(c)) ? "1" : (TextUtils.isEmpty(b) || TextUtils.isEmpty(c)) ? (!TextUtils.isEmpty(b) || TextUtils.isEmpty(c)) ? "4" : "3" : "2";
        } catch (Throwable th) {
            f.a(th);
            return "4";
        }
    }

    public static void b(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || !k.a(context, new String[]{"android.permission.WRITE_SETTINGS"})) {
            return;
        }
        try {
            com.baidu.mshield.b.e.a.a(context, str2, str);
        } catch (Throwable th) {
            f.a(th);
        }
    }

    public static void a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT <= 28 && com.baidu.sec.privacy.d.c.a(context) && k.a(context, new String[]{com.kuaishou.weapon.p0.g.j})) {
                com.baidu.mshield.b.c.a.a("write Ext id");
                File a2 = com.baidu.mshield.b.e.a.a(context, Environment.getExternalStorageDirectory() + File.separator + str2);
                new File(a2.getParent()).mkdirs();
                FileWriter fileWriter = new FileWriter(a2, false);
                fileWriter.write(str);
                fileWriter.flush();
                fileWriter.close();
            }
        } catch (Throwable th) {
            f.a(th);
        }
    }

    public static boolean a(String str) {
        try {
        } catch (Throwable th) {
            f.a(th);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.length() > 70;
    }

    public static void a(Context context, int i) {
        String str;
        String str2;
        try {
            com.baidu.mshield.x6.a.b bVar = new com.baidu.mshield.x6.a.b(context);
            if (i == 1) {
                if (com.baidu.mshield.x6.b.b.a()) {
                    bVar.c("");
                    str = "x_o_b_d";
                    str2 = ".x_o_b_d";
                } else {
                    bVar.b("");
                    str = "x_b_d";
                    str2 = ".x_b_d";
                }
            } else if (i == 2) {
                bVar.f("");
                str = "g_b_d_v";
                str2 = ".g_b_d_v";
            } else if (i == 3) {
                bVar.g("");
                str = "g_c_o_m";
                str2 = ".g_c_o_m";
            } else {
                str = "";
                str2 = str;
            }
            try {
                if (!TextUtils.isEmpty(str) && k.a(context, new String[]{"android.permission.WRITE_SETTINGS"})) {
                    com.baidu.mshield.b.e.a.a(context, str, "");
                }
            } catch (Throwable th) {
                f.a(th);
            }
            try {
                if (!TextUtils.isEmpty(str2) && com.baidu.sec.privacy.d.c.a(context) && k.a(context, new String[]{com.kuaishou.weapon.p0.g.j})) {
                    File a2 = com.baidu.mshield.b.e.a.a(context, Environment.getExternalStorageDirectory() + File.separator + str2);
                    if (a2 == null || !a2.exists()) {
                        return;
                    }
                    a2.delete();
                }
            } catch (Throwable th2) {
                f.a(th2);
            }
        } catch (Throwable th3) {
            f.a(th3);
        }
    }
}
