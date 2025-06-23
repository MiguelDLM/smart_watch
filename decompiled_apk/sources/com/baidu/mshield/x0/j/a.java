package com.baidu.mshield.x0.j;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.mshield.x0.b.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f6422a;
    public SharedPreferences.Editor b;
    public SharedPreferences c;
    public SharedPreferences d;
    public SharedPreferences.Editor e;

    public a(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("msgzpfc", 4);
            this.f6422a = sharedPreferences;
            this.b = sharedPreferences.edit();
            this.c = context.getSharedPreferences("msre_po_rt", 4);
            SharedPreferences sharedPreferences2 = context.getSharedPreferences("msfffppcfg", 4);
            this.d = sharedPreferences2;
            this.e = sharedPreferences2.edit();
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public int a() {
        return this.f6422a.getInt("pl_p_p_itl", 180);
    }

    public long b() {
        return this.f6422a.getLong("pl_l_p_p_t", 0L);
    }

    public String c(String str) {
        return this.f6422a.getString("re_net_ali4_" + str, "");
    }

    public void d(long j) {
        this.e.putLong("g_u_tk_ti", j);
        this.e.apply();
    }

    public String e() {
        return this.c.getString("re_a_lc", "");
    }

    public String f() {
        return this.c.getString("re_a_cv", "");
    }

    public String g() {
        return this.f6422a.getString("xgz_wl_sha1", "");
    }

    public boolean h() {
        if (this.f6422a.getInt("cloud_sw", 0) != 1) {
            return false;
        }
        return true;
    }

    public long i() {
        return this.f6422a.getLong("s_al_tri_t", 0L);
    }

    public long j() {
        return this.d.getLong("g_u_tk_ti", 0L);
    }

    public int k() {
        return this.f6422a.getInt("apd_inte", 24);
    }

    public long l() {
        return this.f6422a.getLong("l_apd_ti", 0L);
    }

    public int m() {
        return this.f6422a.getInt("ice_inv_int", 60);
    }

    public long n() {
        return this.f6422a.getLong("la_ice_in_t", 0L);
    }

    public int o() {
        JSONObject optJSONObject;
        try {
            String a2 = a("plc03");
            if (!TextUtils.isEmpty(a2) && (optJSONObject = new JSONObject(a2).optJSONObject("5")) != null) {
                return optJSONObject.optInt("1", 1);
            }
        } catch (Throwable th) {
            d.a(th);
        }
        return 1;
    }

    public int p() {
        JSONObject optJSONObject;
        try {
            String a2 = a("plc62");
            if (!TextUtils.isEmpty(a2) && (optJSONObject = new JSONObject(a2).optJSONObject("3")) != null) {
                return optJSONObject.optInt("2", 1);
            }
        } catch (Throwable th) {
            d.a(th);
        }
        return 1;
    }

    public String a(String str) {
        return this.f6422a.getString(str, "");
    }

    public void b(int i) {
        this.b.putInt("pl_p_p_itl", i);
        this.b.commit();
    }

    public List<b> c() {
        String string = this.c.getString("re_con", "");
        com.baidu.mshield.b.c.a.b("re_con==" + string);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            for (String str : string.split("\\|\\|")) {
                if (!TextUtils.isEmpty(str)) {
                    b a2 = b.a(str);
                    if (a2 == null) {
                        com.baidu.mshield.b.c.a.b("re_con==empty");
                    } else {
                        com.baidu.mshield.b.c.a.b("re_con==" + a2.toString());
                        arrayList.add(a2);
                    }
                }
            }
        } catch (Throwable th) {
            d.a(th);
        }
        return arrayList;
    }

    public void e(String str) {
        this.b.putString("se-s-v", str);
        this.b.commit();
    }

    public void f(long j) {
        this.b.putLong("la_ice_in_t", j);
        this.b.commit();
    }

    public void g(int i) {
        this.b.putInt("ice_inv_int", i);
        this.b.commit();
    }

    public void a(int i) {
        this.b.putInt("rst", i);
        this.b.commit();
    }

    public String d() {
        return this.c.getString("li_pk_s", "");
    }

    public void b(String str, String str2) {
        this.b.putString(str, str2);
        this.b.commit();
    }

    public void d(int i) {
        this.b.putInt("wm_d_c_s", i);
        this.b.commit();
    }

    public void e(int i) {
        this.b.putInt("wm_in_ma_cco", i);
        this.b.commit();
    }

    public void f(int i) {
        this.b.putInt("apd_inte", i);
        this.b.commit();
    }

    public void g(String str) {
        this.b.putString("apd_taid", str);
        this.b.commit();
    }

    public void a(String str, String str2) {
        this.b.putString(str, str2);
        this.b.commit();
    }

    public String b(String str) {
        return this.f6422a.getString(str, "");
    }

    public String d(String str) {
        return this.c.getString("al_da" + str, "");
    }

    public void e(long j) {
        this.b.putLong("l_apd_ti", j);
        this.b.commit();
    }

    public void f(String str) {
        this.b.putString("a_de_ti_in_tm", str);
        this.b.commit();
    }

    public void a(long j) {
        this.b.putLong("pl_l_p_p_t", j);
        this.b.commit();
    }

    public void b(long j) {
        this.b.putLong("po_fe_su_la_tm", j);
        this.b.commit();
    }

    public void a(boolean z) {
        this.b.putBoolean("s_ph_pl", z);
        this.b.putLong("s_p_p_t", System.currentTimeMillis());
        this.b.commit();
    }

    public void c(int i) {
        this.b.putInt("cloud_sw", i);
        this.b.commit();
    }

    public void c(String str, String str2) {
        this.b.putString("re_net_ali4_" + str, str2);
        this.b.commit();
    }

    public void c(long j) {
        this.b.putLong("s_al_tri_t", j);
        this.b.commit();
    }
}
