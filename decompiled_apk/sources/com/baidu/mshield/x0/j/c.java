package com.baidu.mshield.x0.j;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.ac.F;
import com.baidu.mshield.x0.b.d;

/* loaded from: classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f6424a;
    public SharedPreferences.Editor b;
    public SharedPreferences c;
    public SharedPreferences.Editor d;

    public c(Context context) {
        try {
            SharedPreferences platformSharedSharedPreferences = F.getInstance().getPlatformSharedSharedPreferences(context);
            this.f6424a = platformSharedSharedPreferences;
            this.b = platformSharedSharedPreferences.edit();
            SharedPreferences platformPrivateSharedPreferences = F.getInstance().getPlatformPrivateSharedPreferences(context);
            this.c = platformPrivateSharedPreferences;
            this.d = platformPrivateSharedPreferences.edit();
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public String a() {
        return this.f6424a.getString("xytk", "");
    }

    public void b(String str) {
        this.b.putString("xytk2", str);
        this.b.apply();
    }

    public String c() {
        return this.f6424a.getString("s_h_d_id", "");
    }

    public void d(String str) {
        this.b.putString("rpnewuid", str);
        this.b.commit();
    }

    public String e() {
        return this.f6424a.getString("rpnewuid", "");
    }

    public String f() {
        String string = this.f6424a.getString("rpnewuidn", "");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        try {
            return new String(com.baidu.mshield.b.f.a.b(Base64.decode(string, 10), com.baidu.mshield.b.f.a.a(24)), "UTF-8");
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }

    public void a(String str) {
        this.b.putString("xytk", str);
        this.b.apply();
    }

    public void c(String str) {
        this.b.putString("sgud", str);
        this.b.commit();
    }

    public void e(String str) {
        if (TextUtils.isEmpty(str)) {
            this.b.putString("rpnewuidn", "");
            this.b.commit();
            return;
        }
        try {
            this.b.putString("rpnewuidn", new String(Base64.encode(com.baidu.mshield.b.f.a.a(str.getBytes("UTF-8"), com.baidu.mshield.b.f.a.a(24)), 10), "UTF-8"));
            this.b.commit();
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public String b() {
        return this.f6424a.getString("xytk2", "");
    }

    public String d() {
        return this.f6424a.getString("sgud", "");
    }

    public void f(String str) {
        this.d.putString("p_s_p_c", str);
        this.d.commit();
    }
}
