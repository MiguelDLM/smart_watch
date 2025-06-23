package com.baidu.mshield.x0.b;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.UUID;

/* loaded from: classes7.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public static String f6409a = "";

    public static String a(Context context) {
        if (TextUtils.isEmpty(f6409a)) {
            f6409a = new i().f(context);
        }
        return f6409a;
    }

    public String b(Context context) {
        String b = g.b(context);
        if (TextUtils.isEmpty("") && TextUtils.isEmpty(b)) {
            return "1|" + com.baidu.mshield.b.f.e.a(UUID.randomUUID().toString());
        }
        return "0|" + com.baidu.mshield.b.f.e.a("" + b);
    }

    public String c(Context context) {
        try {
            com.baidu.mshield.x0.j.c cVar = new com.baidu.mshield.x0.j.c(context);
            String f = cVar.f();
            if (!TextUtils.isEmpty(f)) {
                return f;
            }
            String e = cVar.e();
            if (TextUtils.isEmpty(e)) {
                return "";
            }
            cVar.e(e);
            return e;
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }

    public String d(Context context) {
        try {
            return a(context, "com.q.zi.i");
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }

    public String e(Context context) {
        try {
        } catch (Throwable th) {
            d.a(th);
        }
        if (!b(context, com.kuaishou.weapon.p0.g.i)) {
            return "";
        }
        if (!com.baidu.sec.privacy.d.c.a(context)) {
            com.baidu.mshield.b.c.a.a("getNewUidBySdCard isCanRequestNetBackground=false");
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory());
        String str = File.separator;
        sb.append(str);
        sb.append(".zp");
        sb.append(str);
        sb.append(".icosc");
        File a2 = com.baidu.mshield.b.e.a.a(context, sb.toString());
        if (a2.exists()) {
            return a(a2);
        }
        return "";
    }

    public final String f(Context context) {
        boolean z;
        boolean z2;
        String c = c(context);
        boolean z3 = false;
        if (TextUtils.isEmpty(c)) {
            c = d(context);
            z2 = true;
            if (TextUtils.isEmpty(c)) {
                c = e(context);
                if (TextUtils.isEmpty(c)) {
                    c = b(context);
                    z = true;
                } else {
                    z = false;
                }
                z3 = true;
                if (!z3 || TextUtils.isEmpty(c(context))) {
                    new com.baidu.mshield.x0.j.c(context).d(c);
                }
                if (!z2 || TextUtils.isEmpty(d(context))) {
                    a(context, "com.q.zi.i", c);
                }
                if (b(context, com.kuaishou.weapon.p0.g.j) && (z || TextUtils.isEmpty(e(context)))) {
                    c(context, c);
                }
                return c;
            }
            z = false;
            z3 = true;
        } else {
            z = false;
        }
        z2 = false;
        if (!z3) {
        }
        new com.baidu.mshield.x0.j.c(context).d(c);
        if (!z2) {
        }
        a(context, "com.q.zi.i", c);
        if (b(context, com.kuaishou.weapon.p0.g.j)) {
            c(context, c);
        }
        return c;
    }

    public final String a(Context context, String str) {
        try {
            return com.baidu.mshield.b.e.a.d(context, str);
        } catch (Throwable th) {
            d.a(th);
            return null;
        }
    }

    public final boolean b(Context context, String str) {
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        } catch (Throwable th) {
            d.a(th);
            return false;
        }
    }

    public final String a(File file) {
        FileReader fileReader;
        try {
            fileReader = new FileReader(file);
        } catch (Throwable th) {
            th = th;
            fileReader = null;
        }
        try {
            char[] cArr = new char[8192];
            CharArrayWriter charArrayWriter = new CharArrayWriter();
            while (true) {
                int read = fileReader.read(cArr);
                if (read <= 0) {
                    break;
                }
                charArrayWriter.write(cArr, 0, read);
            }
            String charArrayWriter2 = charArrayWriter.toString();
            try {
                fileReader.close();
            } catch (Throwable th2) {
                d.a(th2);
            }
            return charArrayWriter2;
        } catch (Throwable th3) {
            th = th3;
            try {
                d.a(th);
                return null;
            } finally {
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable th4) {
                        d.a(th4);
                    }
                }
            }
        }
    }

    public final void c(Context context, String str) {
        Throwable th;
        FileWriter fileWriter;
        try {
            try {
            } catch (Throwable th2) {
                d.a(th2);
                return;
            }
        } catch (Throwable th3) {
            th = th3;
            fileWriter = null;
        }
        if (Build.VERSION.SDK_INT > 28) {
            return;
        }
        if (!com.baidu.mshield.b.e.a.c(context)) {
            com.baidu.mshield.b.c.a.a("tryPutExternalStorageValue isCanRequestNetBackground=false");
            return;
        }
        File a2 = com.baidu.mshield.b.e.a.a(context, Environment.getExternalStorageDirectory() + File.separator + ".zp");
        File file = new File(a2, ".icosc");
        if (a2.exists()) {
            if (!a2.isDirectory()) {
                a2.delete();
                a2.mkdirs();
            }
        } else {
            a2.mkdirs();
        }
        fileWriter = new FileWriter(file, false);
        try {
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
        } catch (Throwable th4) {
            th = th4;
            try {
                d.a(th);
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (Throwable th5) {
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (Throwable th6) {
                        d.a(th6);
                    }
                }
                throw th5;
            }
        }
    }

    public final boolean a(Context context, String str, String str2) {
        try {
            com.baidu.mshield.b.e.a.a(context, str, str2);
            return true;
        } catch (Throwable th) {
            d.a(th);
            return false;
        }
    }
}
