package com.baidu.mshield.x6.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.mshield.ac.F;
import com.baidu.mshield.x6.e.f;

/* loaded from: classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f6428a;
    public SharedPreferences.Editor b;

    public c(Context context) {
        try {
            SharedPreferences platformSharedSharedPreferences = F.getInstance().getPlatformSharedSharedPreferences(context);
            this.f6428a = platformSharedSharedPreferences;
            this.b = platformSharedSharedPreferences.edit();
        } catch (Throwable th) {
            f.a(th);
        }
    }

    public String a() {
        return this.f6428a.getString("xytk_m", "");
    }

    public String b() {
        return this.f6428a.getString("xytk", "");
    }

    public String c() {
        return this.f6428a.getString("xytk2", "");
    }

    public String d() {
        return this.f6428a.getString("xytkrt", "");
    }

    public String e() {
        return this.f6428a.getString("xytkrt2", "");
    }

    public String f() {
        return this.f6428a.getString("wmcudd", "");
    }

    public void a(String str) {
        this.b.putString("xytk", str);
        this.b.commit();
    }

    public void b(String str) {
        this.b.putString("xytk2", str);
        this.b.commit();
    }

    public void c(String str) {
        this.b.putString("xytkrt", str);
        this.b.commit();
    }

    public void d(String str) {
        this.b.putString("xytkrt2", str);
        this.b.commit();
    }
}
