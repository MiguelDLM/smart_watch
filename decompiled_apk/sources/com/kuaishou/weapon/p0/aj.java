package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class aj {
    private static final String[] b = {"/data/local/", "/data/local/bin/", "/data/local/xbin/", "/sbin/", "/su/bin/", "/system/bin/", "/system/bin/.ext/", "/system/bin/failsafe/", "/system/sd/xbin/", "/system/usr/we-need-root/", "/system/xbin/", "/cache/", "/data/", "/dev/"};

    /* renamed from: a, reason: collision with root package name */
    private Context f18305a;

    public aj(Context context) {
        this.f18305a = context;
    }

    public static boolean b() {
        String a2;
        try {
            a2 = bh.a("ro.build.display.id");
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        if (!a2.contains("flyme")) {
            if (!a2.toLowerCase().contains("flyme")) {
                return false;
            }
            return true;
        }
        return true;
    }

    public int a() {
        try {
            for (String str : a(bi.z)) {
                if (new File(str, bi.y).exists()) {
                    return 1;
                }
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public String c() {
        try {
            if (Build.VERSION.SDK_INT > 29) {
                return null;
            }
            return aa.a().b("su -v").replace("\n", "");
        } catch (Exception unused) {
            return null;
        }
    }

    public int d() {
        String a2 = aa.a().a("ro.secure");
        if (a2 != null && "0".equals(a2)) {
            return 0;
        }
        return 1;
    }

    public int e() {
        String a2 = aa.a().a("ro.debuggable");
        if (a2 != null && "0".equals(a2)) {
            return 0;
        }
        return 1;
    }

    public int f() {
        String a2 = aa.a().a("ro.adb.secure");
        if (a2 != null && "0".equals(a2)) {
            return 0;
        }
        return 1;
    }

    public JSONObject g() {
        try {
            JSONObject jSONObject = new JSONObject();
            String a2 = a(" which su ");
            if (!TextUtils.isEmpty(a2) && a2.length() > 2) {
                jSONObject.put("0", 1);
                jSONObject.put("0-p", a2);
            } else {
                jSONObject.put("0", 0);
            }
            String a3 = a(" id ");
            if (!TextUtils.isEmpty(a3)) {
                if (a3.toLowerCase().contains("uid=0")) {
                    jSONObject.put("1", 1);
                } else {
                    jSONObject.put("1", 0);
                }
            }
            String a4 = a(" busybox df ");
            if (!TextUtils.isEmpty(a4) && !a4.contains("not found")) {
                if (a4.length() > 30) {
                    jSONObject.put("2", 1);
                } else {
                    jSONObject.put("2", 0);
                }
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public int h() {
        if (new File("/system/app/Superuser.apk").exists()) {
            return 1;
        }
        return 0;
    }

    public String i() {
        for (String str : b) {
            if (new File(str, "magisk").exists()) {
                return str + "magisk";
            }
        }
        return "";
    }

    public String j() {
        for (String str : b) {
            if (new File(str, bi.y).exists()) {
                return str + bi.y;
            }
        }
        return "";
    }

    public String k() {
        try {
            throw new Exception("");
        } catch (Exception e) {
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                if (stackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit") || stackTraceElement.getMethodName().equals("invoked") || stackTraceElement.getMethodName().equals("main") || stackTraceElement.getMethodName().equals("handleHookedMethod")) {
                    return stackTraceElement.getClassName();
                }
            }
            return "";
        }
    }

    private String[] a(String[] strArr) {
        String str;
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        try {
            str = System.getenv("PATH");
        } catch (Exception unused) {
        }
        if (str != null && !"".equals(str)) {
            String[] split = str.split(":");
            int length = split.length;
            for (int i = 0; i < length; i++) {
                String str2 = split[i];
                if (!str2.endsWith("/")) {
                    str2 = str2 + IOUtils.DIR_SEPARATOR_UNIX;
                }
                if (!arrayList.contains(str2)) {
                    arrayList.add(str2);
                }
            }
            return (String[]) arrayList.toArray(new String[0]);
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public String a(String str) {
        try {
            return aa.a().b(str).replace("\n", "");
        } catch (Exception unused) {
            return "";
        }
    }
}
