package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class v {
    public static JSONObject h = null;
    public static final String i = "1";
    public static final String j = "2";
    public static final String k = "3";
    public static final String l = "4";
    public static final String m = "5";
    public static final String n = "6";
    public static final String o = "7";

    /* renamed from: a, reason: collision with root package name */
    public int f18415a;
    public long b;
    public long c;
    public String d;
    public String e;
    public String f;
    public int g;
    private PackageInfo p;
    private ApplicationInfo q;
    private Context r;

    public v(PackageInfo packageInfo, Context context) {
        this.p = packageInfo;
        this.r = context;
    }

    public int a() {
        return this.f18415a;
    }

    public String b() {
        return this.e;
    }

    public String c() {
        return this.f;
    }

    public long d() {
        return this.b;
    }

    public String e() {
        return this.d;
    }

    public long f() {
        return this.c;
    }

    public int g() {
        return this.g;
    }

    public void h() {
        String str;
        ApplicationInfo applicationInfo;
        PackageInfo packageInfo = this.p;
        if (packageInfo == null && this.q == null) {
            return;
        }
        if (packageInfo == null) {
            try {
                if (this.q != null) {
                    this.p = this.r.getPackageManager().getPackageInfo(this.q.packageName, 0);
                }
            } catch (Exception unused) {
            }
        }
        PackageInfo packageInfo2 = this.p;
        if (packageInfo2 == null) {
            str = this.q.packageName;
        } else {
            str = packageInfo2.packageName;
        }
        a(str);
        PackageInfo packageInfo3 = this.p;
        if (packageInfo3 == null) {
            applicationInfo = this.q;
        } else {
            applicationInfo = packageInfo3.applicationInfo;
        }
        a(applicationInfo.flags & 1);
        b(j());
        PackageInfo packageInfo4 = this.p;
        if (packageInfo4 != null) {
            a(packageInfo4.firstInstallTime);
            b(this.p.lastUpdateTime);
            c(this.p.versionName);
            b(this.p.versionCode);
        }
    }

    public void i() {
        String str;
        ApplicationInfo applicationInfo;
        PackageInfo packageInfo = this.p;
        if (packageInfo == null && this.q == null) {
            return;
        }
        if (packageInfo == null) {
            try {
                if (this.q != null) {
                    this.p = this.r.getPackageManager().getPackageInfo(this.q.packageName, 0);
                }
            } catch (Exception unused) {
            }
        }
        PackageInfo packageInfo2 = this.p;
        if (packageInfo2 == null) {
            str = this.q.packageName;
        } else {
            str = packageInfo2.packageName;
        }
        a(str);
        PackageInfo packageInfo3 = this.p;
        if (packageInfo3 == null) {
            applicationInfo = this.q;
        } else {
            applicationInfo = packageInfo3.applicationInfo;
        }
        a(applicationInfo.flags & 1);
        PackageInfo packageInfo4 = this.p;
        if (packageInfo4 != null) {
            a(packageInfo4.firstInstallTime);
            b(this.p.lastUpdateTime);
            c(this.p.versionName);
            b(this.p.versionCode);
        }
    }

    public String j() {
        ApplicationInfo applicationInfo;
        try {
            PackageInfo packageInfo = this.p;
            if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null) {
                String charSequence = applicationInfo.loadLabel(this.r.getPackageManager()).toString();
                if (!TextUtils.isEmpty(charSequence)) {
                    return charSequence;
                }
            } else {
                ApplicationInfo applicationInfo2 = this.q;
                if (applicationInfo2 != null) {
                    String charSequence2 = applicationInfo2.loadLabel(this.r.getPackageManager()).toString();
                    if (!TextUtils.isEmpty(charSequence2)) {
                        return charSequence2;
                    }
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public JSONObject k() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("1", c());
            jSONObject.put("2", b());
            jSONObject.put("3", e());
            jSONObject.put("4", g());
            jSONObject.put("5", a());
            jSONObject.put("6", d());
            jSONObject.put("7", f());
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a(int i2) {
        this.f18415a = i2;
    }

    public void b(String str) {
        this.f = str;
    }

    public void c(String str) {
        this.d = str;
    }

    public void a(String str) {
        this.e = str;
    }

    public void b(long j2) {
        this.c = j2;
    }

    public v(ApplicationInfo applicationInfo, Context context) {
        this.q = applicationInfo;
        this.r = context;
    }

    public void a(long j2) {
        this.b = j2;
    }

    public void b(int i2) {
        this.g = i2;
    }
}
