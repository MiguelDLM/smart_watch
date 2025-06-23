package com.baidu.xclient.gdid;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static String f10234a = "sec_gd_config_mshield";
    public static volatile f b;
    public SharedPreferences c;
    public SharedPreferences.Editor d;

    public f() {
        SharedPreferences sharedPreferences = c.b.getSharedPreferences(f10234a, 0);
        this.c = sharedPreferences;
        this.d = sharedPreferences.edit();
    }

    public static f a() {
        if (b == null) {
            synchronized (f.class) {
                try {
                    if (b == null) {
                        b = new f();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public void A() {
        a("k_is_rp_mgc", !z());
    }

    public final int b(String str, int i) {
        return this.c.getInt(str, i);
    }

    public long c() {
        return b("k_pull_p_itl", com.baidu.xclient.gdid.c.a.b * 8);
    }

    public long d() {
        return b("k_last_re_fing_t", 0L);
    }

    public long e() {
        return b("k_re_fing_itl", com.baidu.xclient.gdid.c.a.c);
    }

    public String f() {
        return b("k_cu_p_ver_n", "");
    }

    public String g() {
        String b2 = b("k_ply_s_n", "");
        if (!TextUtils.isEmpty(b2)) {
            return new String(Base64.decode(b2, 1));
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.kwad.sdk.m.e.TAG, 1);
            jSONObject.put("l", 1);
            jSONObject.put("p", ".zqobbx.pa");
            jSONObject.put("i", 1);
            jSONObject.put("m", 0);
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, 1);
            jSONObject.put("s", 1);
            jSONObject.put("c", 0);
            jSONObject.put("y", 20);
            jSONObject.put("z", 20);
            jSONObject.put("x", 0);
            jSONObject.put(t.i, 0);
            jSONObject.put("g", 20);
            jSONObject.put("n", 0);
            jSONObject.put("t", 0);
            jSONObject.put("q", 0);
            jSONObject.put("9", "");
            jSONObject.put("10", "");
        } catch (Throwable th) {
            com.baidu.xclient.gdid.e.d.a(th);
        }
        return jSONObject.toString();
    }

    public long h() {
        return b("k_last_alm_t", 0L);
    }

    public long i() {
        return b("k_alm_itl", com.baidu.xclient.gdid.c.a.b);
    }

    public long j() {
        return b("k_last_pi_t", 0L);
    }

    public long k() {
        return b("K_pi_itl", com.baidu.xclient.gdid.c.a.b * 12);
    }

    public String l() {
        return b("k_ext_id4", "");
    }

    public String m() {
        return b("k_gu_all", "");
    }

    public String n() {
        return b("k_rep_al", "");
    }

    public String o() {
        return b("k_rep_f_if", "");
    }

    public String p() {
        return b("k_n_g_d", "");
    }

    public String q() {
        return b("k_ext_j", "");
    }

    public boolean r() {
        return u() == 3;
    }

    public boolean s() {
        int u = u();
        return u == 3 || u == 1;
    }

    public boolean t() {
        int u = u();
        return u == 3 || u == 2;
    }

    public int u() {
        return b("k_mdl_sw", 3);
    }

    public int v() {
        return b("k_app_l_idx", 0);
    }

    public int w() {
        return b("k_b_app_l_idx", 0);
    }

    public int x() {
        return b("k_f_p_idx", 0);
    }

    public int y() {
        return b("k_b_f_p_idx", 0);
    }

    public boolean z() {
        return b("k_is_rp_mgc", false);
    }

    public void a(int i) {
        a("k_mdl_sw", i);
    }

    public long b() {
        return b("k_last_pull_pl_t", 0L);
    }

    public void c(int i) {
        if (i <= 0) {
            return;
        }
        a("k_t_a_p", i);
    }

    public void d(int i) {
        if (i < 0) {
            return;
        }
        a("k_t_ca_p", i);
    }

    public void e(int i) {
        if (i < 0) {
            return;
        }
        a("l_td_t_s", i != 0);
    }

    public void f(int i) {
        if (i < 0) {
            return;
        }
        a("k_t_m_s_s", i != 0);
    }

    public void g(int i) {
        a("k_app_l_idx", i);
    }

    public void h(int i) {
        a("k_b_app_l_idx", i);
    }

    public void i(int i) {
        a("k_f_p_idx", i);
    }

    public void j(int i) {
        a("k_b_f_p_idx", i);
    }

    public void k(boolean z) {
        a("k_is_rp_lp", z);
    }

    public void l(boolean z) {
        a("k_is_rp_dnp", z);
    }

    public void a(long j) {
        a("k_last_pull_pl_t", j);
    }

    public final long b(String str, long j) {
        return this.c.getLong(str, j);
    }

    public void c(long j) {
        a("k_last_re_fing_t", j);
    }

    public void d(long j) {
        if (j <= 0) {
            return;
        }
        a("k_re_fing_itl", j);
    }

    public void e(long j) {
        a("k_last_alm_t", j);
    }

    public void f(long j) {
        if (j <= 0) {
            return;
        }
        a("k_alm_itl", j);
    }

    public void g(long j) {
        a("k_last_pi_t", j);
    }

    public void h(long j) {
        if (j <= 0) {
            return;
        }
        a("K_pi_itl", j);
    }

    public void i(boolean z) {
        a("k_is_rep_wf", z);
    }

    public void j(boolean z) {
        a("k_ig_u_a", z);
    }

    public void a(String str) {
        a("k_cu_p_ver_n", str);
    }

    public final String b(String str, String str2) {
        return this.c.getString(str, str2);
    }

    public void c(String str) {
        a("k_gu_all", str);
    }

    public void d(String str) {
        a("k_rep_al", str);
    }

    public void e(String str) {
        a("k_rep_f_if", str);
    }

    public void f(String str) {
        a("k_last_ds_d", str);
    }

    public void g(String str) {
        a("k_gd_p", str);
    }

    public void h(boolean z) {
        a("k_is_rep_o_i", z);
    }

    public final void a(String str, int i) {
        this.d.putInt(str, i);
        this.d.commit();
    }

    public void b(int i) {
        if (i <= 0) {
            return;
        }
        a("k_t_c_p", i);
    }

    public void c(boolean z) {
        a("k_is_rep_im_e", z);
    }

    public void d(boolean z) {
        a("k_is_rp_rg_crc", z);
    }

    public void e(boolean z) {
        a("k_is_rep_lc_4_p", z);
    }

    public void f(boolean z) {
        a("k_is_rep_ad", z);
    }

    public void g(boolean z) {
        a("k_is_rep_im_c", z);
    }

    public final void a(String str, long j) {
        this.d.putLong(str, j);
        this.d.commit();
    }

    public void b(long j) {
        if (j <= 0) {
            return;
        }
        a("k_pull_p_itl", j);
    }

    public final void a(String str, String str2) {
        this.d.putString(str, str2);
        this.d.commit();
    }

    public void b(String str) {
        a("k_ply_s_n", str);
    }

    public final void a(String str, boolean z) {
        this.d.putBoolean(str, z);
        this.d.commit();
    }

    public void b(boolean z) {
        a("k_is_rep_im_m", z);
    }

    public void a(boolean z) {
        a("k_is_rep_m", z);
    }

    public final boolean b(String str, boolean z) {
        return this.c.getBoolean(str, z);
    }
}
