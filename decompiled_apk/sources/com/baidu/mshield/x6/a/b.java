package com.baidu.mshield.x6.a;

import OoOoXO0.xoXoI;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.mshield.x6.e.f;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f6427a = "kship";
    public static String b = "kshinp";
    public static String c = "krti";
    public static String d = "ksdci";
    public static String e = "kwfi";
    public static String f = "kbti";
    public static String g = "kssi";
    public static String h = "ktpti";
    public static String i = "kusbi";
    public static String j = "kdkdi";
    public static String k = "kcpui";
    public static String l = "ksci";
    public static String m = "kfstl";
    public static String n = "kvti";
    public static String o = "kvtij";
    public static String p = "kopgl";
    public static String q = "kpalwp";
    public static String r = "kstafac";
    public static String s = "ksglcid";
    public static String t = "kshwoaid";
    public static String u = "kxceck";
    public SharedPreferences v;
    public SharedPreferences.Editor w;

    @SuppressLint({"InlinedApi"})
    public b(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("msfffppcfg", 4);
            this.v = sharedPreferences;
            this.w = sharedPreferences.edit();
        } catch (Throwable th) {
            f.a(th);
        }
    }

    public String A() {
        return this.v.getString("g_bvr_m", "");
    }

    public String B() {
        return this.v.getString("g_rn_m", "");
    }

    public String C() {
        return this.v.getString("g_rv_m", "");
    }

    public String D() {
        return this.v.getString("s_to_re_d", "");
    }

    public int E() {
        return this.v.getInt("l_to_re_re", 0);
    }

    public String F() {
        return this.v.getString("h_ca_to_in", "");
    }

    public String G() {
        return this.v.getString("s_to_dy_d", "");
    }

    public int H() {
        return this.v.getInt("s_to_dy_op", 0);
    }

    public int I() {
        return this.v.getInt("s_to_re_li", 10);
    }

    public int J() {
        return this.v.getInt("s_to_re_co", 0);
    }

    public long K() {
        return this.v.getLong("s_to_re_ot", 0L);
    }

    public int L() {
        return this.v.getInt("s_c_f_o_ttc", 10);
    }

    public int M() {
        return this.v.getInt("s_c_f_o_qec", 0);
    }

    public String N() {
        try {
            String string = this.v.getString("tk_rm_py", "");
            if (TextUtils.isEmpty(string)) {
                return "";
            }
            return f.c(string);
        } catch (Throwable th) {
            f.a(th);
            return "";
        }
    }

    public void O() {
        y("tk_rm_py");
    }

    public boolean P() {
        return this.v.getBoolean("kicfr", false);
    }

    public String Q() {
        return this.v.getString("l_to_re_t_re", "");
    }

    public final void a() {
        try {
            this.w.commit();
        } catch (Throwable th) {
            f.a(th);
        }
    }

    public String b() {
        return this.v.getString("global_xid", "");
    }

    public String c() {
        return this.v.getString("global_o_xid", "");
    }

    public String d() {
        return this.v.getString("m_s_i_id", "");
    }

    public String e() {
        return this.v.getString("m_s_i_cc_id", "");
    }

    public void f(String str) {
        this.w.putString("g_l_b_x_v", str);
        a();
    }

    public void g(String str) {
        this.w.putString("g_b_z_o_c_t_d", str);
        a();
    }

    public void h(String str) {
        this.w.putString("g_b_o_b_s", str);
        a();
    }

    public int i() {
        return this.v.getInt("g_z_c_f_q", 60);
    }

    public void j(String str) {
        this.w.putString("pu_py_t", str);
        this.w.commit();
    }

    public void k(String str) {
        this.w.putString("re_stc_s_t", str);
        this.w.commit();
    }

    public String l() {
        return this.v.getString("re_stc_s_t", "");
    }

    public boolean m() {
        return this.v.getBoolean("i_ft_tm_z", true);
    }

    public void n(String str) {
        this.w.putString("g_e_s_m", str);
        this.w.commit();
    }

    public boolean o() {
        return this.v.getBoolean("s_ai_n_c_f", false);
    }

    public int p() {
        return this.v.getInt("s_pc_al_i", 360);
    }

    public int q() {
        return this.v.getInt("s_zid_lc_s", 1);
    }

    public long r() {
        return this.v.getLong("s_zid_lc_t", 0L);
    }

    public int s() {
        return this.v.getInt("s_zid_cf", 0);
    }

    public void t(String str) {
        this.w.putString("g_rv_m", str);
        a();
    }

    public void u(String str) {
        this.w.putString("s_to_re_d", str);
        a();
    }

    public void v(String str) {
        this.w.putString("h_ca_to_in", str);
        a();
    }

    public void w(String str) {
        this.w.putString("s_to_dy_d", str);
        a();
    }

    public String x() {
        return this.v.getString("g_mo_m", "");
    }

    public String y() {
        return this.v.getString("g_ma_m", "");
    }

    public String z() {
        return this.v.getString("g_bu_m", "");
    }

    public void b(int i2) {
        this.w.putInt("g_z_c_f_q", i2);
        a();
    }

    public void c(int i2) {
        this.w.putInt("k_em_t_a", i2);
        a();
    }

    public void d(String str) {
        this.w.putString("m_s_i_id", str);
        a();
    }

    public void e(int i2) {
        this.w.putInt("s_sd_al_i", i2);
        a();
    }

    public void i(String str) {
        this.w.putString("g_b_g_b_s", str);
        a();
    }

    public void l(String str) {
        this.w.putString("g_a_i_m", str);
        a();
    }

    public void m(String str) {
        this.w.putString("g_d_d_v", str);
        a();
    }

    public void o(String str) {
        this.w.putString("g_mo_m", str);
        a();
    }

    public void p(String str) {
        this.w.putString("g_ma_m", str);
        a();
    }

    public void q(String str) {
        this.w.putString("g_bu_m", str);
        a();
    }

    public void r(String str) {
        this.w.putString("g_bvr_m", str);
        a();
    }

    public void s(String str) {
        this.w.putString("g_rn_m", str);
        a();
    }

    public void x(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.w.putString("tk_rm_py", f.b(str));
            this.w.commit();
        } catch (Throwable th) {
            f.a(th);
        }
    }

    public void y(String str) {
        try {
            if (TextUtils.isEmpty(this.v.getString(str, ""))) {
                return;
            }
            this.w.remove(str);
            a();
        } catch (Throwable th) {
            f.a(th);
        }
    }

    public void a(int i2) {
        this.w.putInt("y_z_c_s", i2);
        a();
    }

    public boolean f() {
        return this.v.getBoolean("is_x_r_f_2_1_0", false);
    }

    public boolean g() {
        return this.v.getBoolean("s_s_c_f", false);
    }

    public boolean h() {
        return this.v.getBoolean("s_z_d_c_f", false);
    }

    public String j() {
        return this.v.getString("g_b_g_b_s", "");
    }

    public String k() {
        return this.v.getString("g_b_o_b_s", "");
    }

    public String n() {
        return this.v.getString("g_a_i_m", "");
    }

    public long t() {
        return this.v.getLong("l_bd_r_t", 0L);
    }

    public String u() {
        return this.v.getString("g_d_d_v", "");
    }

    public String v() {
        return this.v.getString("g_l_p_tar", "");
    }

    public String w() {
        return this.v.getString("g_e_s_m", "");
    }

    public void b(String str) {
        this.w.putString("global_xid", str);
        a();
    }

    public void c(String str) {
        this.w.putString("global_o_xid", str);
        a();
    }

    public void d(boolean z) {
        this.w.putBoolean("s_z_d_c_f", z);
        a();
    }

    public void e(String str) {
        this.w.putString("m_s_i_cc_id", str);
        a();
    }

    public void f(int i2) {
        this.w.putInt("s_pc_al_i", i2);
        a();
    }

    public void g(int i2) {
        this.w.putInt("s_zid_cf", i2);
        a();
    }

    public void h(int i2) {
        this.w.putInt("l_to_re_re", i2);
        a();
        a(System.currentTimeMillis(), i2 > 0 ? 1 : 0);
    }

    public void i(int i2) {
        this.w.putInt("s_to_dy_op", i2);
        a();
    }

    public void j(int i2) {
        this.w.putInt("s_to_re_li", i2);
        a();
    }

    public void k(int i2) {
        this.w.putInt("s_to_re_co", i2);
        a();
    }

    public void l(int i2) {
        this.w.putInt("s_c_f_o_ttc", i2);
        a();
    }

    public void m(int i2) {
        this.w.putInt("s_c_f_o_qec", i2);
        a();
    }

    public void a(String str, String str2) {
        this.w.putString(str, str2);
        a();
    }

    public void b(boolean z) {
        this.w.putBoolean("is_x_r_f_2_1_0", z);
        a();
    }

    public void c(boolean z) {
        this.w.putBoolean("s_s_c_f", z);
        a();
    }

    public void d(long j2) {
        this.w.putLong("s_to_re_ot", j2);
        a();
    }

    public void e(boolean z) {
        this.w.putBoolean("i_ft_tm_z", z);
        a();
    }

    public void f(boolean z) {
        this.w.putBoolean("s_ai_n_c_f", z);
        a();
    }

    public void g(boolean z) {
        this.w.putBoolean("kicfr", z);
        a();
    }

    public void a(boolean z) {
        this.w.putBoolean("is_sim_changed_today", z);
        a();
    }

    public void b(long j2) {
        this.w.putLong("l_bd_r_t", j2);
        a();
    }

    public void c(long j2) {
        this.w.putLong("g_u_tk_ti", j2);
        this.w.commit();
    }

    public void d(int i2) {
        this.w.putInt("s_nc_al_i", i2);
        a();
    }

    public String a(String str) {
        return this.v.getString(str, "");
    }

    public void a(long j2) {
        this.w.putLong("s_zid_lc_t", j2);
        a();
    }

    public void a(long j2, boolean z) {
        String str = z ? "1" : "0";
        try {
            this.w.putString("g_l_p_tar", j2 + xoXoI.f2670oxoX + str);
            a();
        } catch (Throwable th) {
            f.a(th);
        }
    }

    public void a(long j2, int i2) {
        try {
            this.w.putString("l_to_re_t_re", j2 + xoXoI.f2670oxoX + i2);
            a();
        } catch (Throwable th) {
            f.a(th);
        }
    }
}
