package com.baidu.mshield.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mshield.utility.g;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static a f6385a;
    public SharedPreferences b;
    public SharedPreferences.Editor c;
    public SharedPreferences d;
    public SharedPreferences.Editor e;
    public SharedPreferences f;
    public SharedPreferences.Editor g;
    public Context h;
    public int i;
    public String j = null;
    public Map<String, SharedPreferences> k = new HashMap();

    public a(Context context) {
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        this.h = context;
        this.i = com.baidu.mshield.utility.a.g(context);
        com.baidu.mshield.b.c.a.b("checking platformName:mshield_SOFIRE");
        a();
        if (this.i == 1) {
            sharedPreferences = context.getSharedPreferences("leroadmshieldcfg", 0);
        } else {
            sharedPreferences = null;
        }
        c cVar = new c(this.h, sharedPreferences, "leroadmshieldcfg", false, this.i);
        this.b = cVar;
        this.c = cVar.edit();
        if (this.i == 1 && TextUtils.isEmpty(this.j)) {
            sharedPreferences2 = context.getSharedPreferences("leroadcfg", 0);
        } else {
            sharedPreferences2 = null;
        }
        c cVar2 = new c(this.h, sharedPreferences2, "leroadcfg", true, this.i, this.j);
        this.d = cVar2;
        this.e = cVar2.edit();
        c cVar3 = new c(this.h, this.i == 1 ? context.getSharedPreferences("msre_po_rt", 0) : null, "msre_po_rt", false, this.i);
        this.f = cVar3;
        this.g = cVar3.edit();
    }

    public static synchronized a a(Context context) {
        synchronized (a.class) {
            if (context == null) {
                return f6385a;
            }
            if (f6385a == null) {
                f6385a = new a(context);
            }
            return f6385a;
        }
    }

    public int A() {
        return this.f.getInt("up_nu_co", 50);
    }

    public int B() {
        return this.f.getInt("re_net_one_lt", 5);
    }

    public int C() {
        return this.f.getInt("re_net_dy_lt", 50);
    }

    public String D() {
        return this.f.getString("re_net_ali2_version", "");
    }

    public long E() {
        return this.f.getLong("re_net_pu_de", 0L);
    }

    public long F() {
        return this.f.getLong("re_day_len", 0L);
    }

    public long G() {
        return this.f.getLong("re_day_b_t", 0L);
    }

    public String H() {
        return this.f.getString("re_a_lc", "");
    }

    public String I() {
        return this.f.getString("re_a_cv", "");
    }

    public int J() {
        return this.f.getInt("g_r_d_d_n", 0);
    }

    public String K() {
        return this.d.getString("xyusec", "");
    }

    public SharedPreferences b() {
        return this.b;
    }

    public SharedPreferences c() {
        return this.d;
    }

    public String d() {
        return this.b.getString("svi_n_wm", "");
    }

    public String e() {
        return this.b.getString("svi_wm", "");
    }

    public long f() {
        long j = this.b.getLong("pu_cl_fd", 0L);
        if (j != 0) {
            return j;
        }
        long currentTimeMillis = System.currentTimeMillis();
        g();
        return currentTimeMillis;
    }

    public void g() {
        this.c.putLong("pu_cl_fd", System.currentTimeMillis());
        this.c.commit();
    }

    public long h() {
        long j = this.b.getLong("se_ae_fd", 0L);
        if (j != 0) {
            return j;
        }
        long currentTimeMillis = System.currentTimeMillis();
        i();
        return currentTimeMillis;
    }

    public void i() {
        this.c.putLong("se_ae_fd", System.currentTimeMillis());
        this.c.commit();
    }

    public int j() {
        return this.b.getInt("wi_fa_pu_cl", 0);
    }

    public int k() {
        return this.b.getInt("mo_fa_pu_cl", 0);
    }

    public void l(int i) {
        this.g.putInt("up_nu_co", i);
        this.g.commit();
    }

    public void m(int i) {
        this.g.putInt("re_net_one_lt", i);
        this.g.commit();
    }

    public String n() {
        return this.d.getString("xygls", "");
    }

    public String o() {
        return this.d.getString("rpiiem", "");
    }

    public String p() {
        return this.d.getString("rpandid", "");
    }

    public String q() {
        return this.d.getString("rpmacadd", "");
    }

    public String r() {
        return this.d.getString("sgud", "");
    }

    public String s() {
        return this.d.getString("xytk", "");
    }

    public String t() {
        return this.d.getString("xytk_m", "");
    }

    public List<com.baidu.mshield.rp.a.a> u() {
        com.baidu.mshield.rp.a.a a2;
        String string = this.f.getString("re_con", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : string.split("\\|\\|")) {
            if (!TextUtils.isEmpty(str) && (a2 = com.baidu.mshield.rp.a.a.a(str)) != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    public int v() {
        if ("com.baidu.BaiduMap.meizu".equals(this.h.getPackageName())) {
            return this.f.getInt("re_net_hr", 24);
        }
        int i = this.f.getInt("re_net_hr", 3);
        try {
            String[] b = com.baidu.mshield.utility.a.b(this.h);
            if (b.length == 2 && !TextUtils.isEmpty(b[0]) && !TextUtils.isEmpty(b[1]) && "200080".equals(b[0])) {
                if ("com.baidu.BaiduMap".equals(this.h.getPackageName()) && i < 24) {
                    return 24;
                }
            }
        } catch (Throwable unused) {
        }
        return i;
    }

    public long w() {
        return this.f.getLong("re_last_ofline_time", 0L);
    }

    public int x() {
        return this.f.getInt("re_net_wt", 3);
    }

    public int y() {
        return this.f.getInt("re_net_over", 7);
    }

    public int z() {
        return this.f.getInt("up_nu_li", 100);
    }

    public SharedPreferences b(String str) {
        SharedPreferences sharedPreferences;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            synchronized (this.k) {
                try {
                    sharedPreferences = this.k.get(str);
                    if (sharedPreferences == null) {
                        c cVar = new c(this.h, this.i == 1 ? this.h.getSharedPreferences(str, 0) : null, str, false, this.i);
                        this.k.put(str, cVar);
                        sharedPreferences = cVar;
                    }
                } finally {
                }
            }
            return sharedPreferences;
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return null;
        }
    }

    public void c(int i) {
        this.c.putInt("wi_fa_pu_cl", i);
        this.c.commit();
    }

    public void d(String str) {
        this.e.putString("xygls", str);
        this.e.commit();
    }

    public void e(String str) {
        this.e.putString("rpiiem", str);
        this.e.commit();
    }

    public void j(int i) {
        this.g.putInt("re_net_over", i);
        this.g.commit();
    }

    public void k(int i) {
        this.g.putInt("up_nu_li", i);
        this.g.commit();
    }

    public void n(int i) {
        this.g.putInt("re_net_dy_lt", i);
        this.g.commit();
    }

    public void o(int i) {
        this.g.putInt("g_r_d_d_n", i);
        this.g.commit();
    }

    public void g(String str) {
        this.e.putString("rpmacadd", str);
        this.e.commit();
    }

    public void i(String str) {
        this.e.putString("xytk_m", str);
        this.e.apply();
    }

    public boolean l(String str) {
        return this.f.getBoolean("re_net_ins_" + str, false);
    }

    public String m(String str) {
        return this.f.getString("al_da" + str, "");
    }

    public void c(String str) {
        this.e.putString("xyus", str);
        this.e.commit();
    }

    public void d(int i) {
        this.c.putInt("mo_fa_pu_cl", i);
        this.c.commit();
    }

    public void e(int i) {
        this.c.putInt("mo_ae_fa_ct", i);
        this.c.commit();
    }

    public void f(int i) {
        this.g.putInt("re_net_ty", i);
        this.g.commit();
    }

    public void h(String str) {
        this.e.putString("sgud", str);
        this.e.commit();
    }

    public String j(String str) {
        return this.f.getString("re_net_ali2_" + str, "");
    }

    public void k(String str) {
        this.g.putString("re_net_ali2_version", str);
        this.g.commit();
    }

    public int l() {
        return this.b.getInt("mo_ae_fa_ct", 0);
    }

    public String m() {
        return this.d.getString("xyus", "");
    }

    public void n(String str) {
        this.g.putString("li_pk_s", str);
        this.g.commit();
    }

    public void o(String str) {
        this.e.putString("xyusec", str);
        this.e.commit();
    }

    public void a() {
        Bundle bundle = new Bundle();
        bundle.putString("operation", "querySharedHandler");
        Bundle a2 = g.a(this.h, "CallPreferences", bundle, false, "3.5.8.0", true);
        if (a2 != null) {
            this.j = a2.getString("handle_platform");
            com.baidu.mshield.b.c.a.b("get can handle shared platform:" + this.j);
        }
    }

    public void g(int i) {
        this.g.putInt("re_net_hr", i);
        this.g.commit();
    }

    public void i(int i) {
        this.g.putInt("re_net_wt", i);
        this.g.commit();
    }

    public void c(long j) {
        this.g.putLong("re_day_len", j);
        this.g.commit();
    }

    public void d(String str, String str2) {
        this.g.putString("in_da" + str, str2);
        this.g.commit();
    }

    public void f(String str) {
        this.e.putString("rpandid", str);
        this.e.commit();
    }

    public void h(int i) {
        this.g.putInt("re_net_hr_bc", i);
        this.g.commit();
    }

    public void c(String str, String str2) {
        this.g.putString("al_da" + str, str2);
        this.g.commit();
    }

    public void d(long j) {
        this.g.putLong("re_day_b_t", j);
        this.g.commit();
    }

    public void a(String str, String str2) {
        this.c.putString("svi_n_wm", str + HelpFormatter.DEFAULT_OPT_PREFIX + str2);
        this.c.commit();
    }

    public void a(long j) {
        this.g.putLong("re_last_ofline_time", j);
        this.g.commit();
    }

    public void b(int i) {
        this.c.putInt("mo_fa_pu_ap", i);
        this.c.commit();
    }

    public Bundle a(Bundle bundle) {
        String string;
        try {
            string = bundle.getString("operation");
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        if ("querySharedHandler".equals(string)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("handle_platform", "mshield");
            return bundle2;
        }
        String string2 = bundle.getString("pref_name");
        if (TextUtils.isEmpty(string2)) {
            return null;
        }
        String string3 = bundle.getString("key");
        if (TextUtils.isEmpty(string3)) {
            return null;
        }
        com.baidu.mshield.b.c.a.b("handleRemoteCall:" + string + "_" + string2 + "_" + string3);
        SharedPreferences a2 = a(string2);
        char c = 0;
        if (string.startsWith("get")) {
            String string4 = bundle.getString("defult_value");
            if (!"getString".equals(string) && TextUtils.isEmpty(string4)) {
                return null;
            }
            com.baidu.mshield.b.c.a.b("handleRemoteCall get:" + string + "_defValue=" + string4);
            if (a2 == null) {
                return null;
            }
            Bundle bundle3 = new Bundle();
            switch (string.hashCode()) {
                case -1249359687:
                    if (string.equals("getInt")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -75354382:
                    if (string.equals("getLong")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 804029191:
                    if (string.equals("getString")) {
                        break;
                    }
                    c = 65535;
                    break;
                case 1101572082:
                    if (string.equals("getBoolean")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 1953351846:
                    if (string.equals("getFloat")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0) {
                bundle3.putString("result", a2.getString(string3, string4));
            } else if (c == 1) {
                bundle3.putInt("result", a2.getInt(string3, Integer.parseInt(string4)));
            } else if (c == 2) {
                bundle3.putLong("result", a2.getLong(string3, Long.parseLong(string4)));
            } else if (c == 3) {
                bundle3.putFloat("result", a2.getFloat(string3, Float.parseFloat(string4)));
            } else if (c == 4) {
                bundle3.putBoolean("result", a2.getBoolean(string3, Boolean.parseBoolean(string4)));
            }
            return bundle3;
        }
        if (string.startsWith("put")) {
            SharedPreferences.Editor edit = a2.edit();
            com.baidu.mshield.b.c.a.b("handleRemoteCall put:" + string);
            switch (string.hashCode()) {
                case -976920992:
                    if (string.equals("putInt")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -462997504:
                    if (string.equals("putString")) {
                        break;
                    }
                    c = 65535;
                    break;
                case -219689429:
                    if (string.equals("putLong")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 478450201:
                    if (string.equals("putBoolean")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 1773932685:
                    if (string.equals("putFloat")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0) {
                edit.putString(string3, bundle.getString("value"));
            } else if (c == 1) {
                edit.putInt(string3, bundle.getInt("value"));
            } else if (c == 2) {
                edit.putLong(string3, bundle.getLong("value"));
            } else if (c == 3) {
                edit.putFloat(string3, bundle.getFloat("value"));
            } else if (c == 4) {
                edit.putBoolean(string3, bundle.getBoolean("value"));
            }
            edit.apply();
        }
        return null;
    }

    public void b(String str, String str2) {
        this.g.putString("re_net_ali2_" + str, str2);
        this.g.commit();
    }

    public void b(long j) {
        this.g.putLong("re_net_pu_de", j);
        this.g.commit();
    }

    public void a(int i) {
        this.c.putInt("wi_fa_pu_ap", i);
        this.c.commit();
    }

    public final SharedPreferences a(String str) {
        if (str.equals("leroadmshieldcfg")) {
            return this.b;
        }
        if (str.equals("leroadcfg")) {
            return this.d;
        }
        if (str.equals("msre_po_rt")) {
            return this.f;
        }
        return b(str);
    }

    public void a(com.baidu.mshield.rp.a.a aVar) {
        if (aVar == null) {
            return;
        }
        String string = this.f.getString("re_con", "");
        this.g.putString("re_con", string + "||" + com.baidu.mshield.rp.a.a.a(aVar));
        this.g.commit();
    }

    public void a(List<com.baidu.mshield.rp.a.a> list, com.baidu.mshield.rp.a.a aVar) {
        int indexOf;
        com.baidu.mshield.rp.a.a aVar2;
        if (aVar == null || list == null || (indexOf = list.indexOf(aVar)) == -1 || (aVar2 = list.get(indexOf)) == null) {
            return;
        }
        this.g.putString("re_con", this.f.getString("re_con", "").replace(com.baidu.mshield.rp.a.a.a(aVar2), com.baidu.mshield.rp.a.a.a(aVar)));
        this.g.commit();
    }

    public void a(String str, boolean z) {
        this.g.putBoolean("re_net_ins_" + str, z);
        this.g.commit();
    }
}
