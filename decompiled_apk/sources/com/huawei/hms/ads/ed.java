package com.huawei.hms.ads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.openalliance.ad.beans.server.AppConfigRsp;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class ed {
    private static final int B = 30;
    private static final String Code = "SpHandler";
    private static ed F = null;
    private static final int I = 200;
    private static final byte[] L = new byte[0];
    private static final int V = 60;
    private static final int Z = 0;
    private static final int d = 85;
    private static final int e = 119;
    private static final int f = 5;
    private static final int g = 60;
    private static final int h = 10080;
    private final SharedPreferences C;
    private Map<String, String> D;
    private SharedPreferences S;

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f17285a = new byte[0];
    private String b;
    private Context c;

    private ed(Context context) {
        this.D = new HashMap();
        Context L2 = com.huawei.openalliance.ad.utils.n.L(context.getApplicationContext());
        this.c = L2;
        this.C = L2.getSharedPreferences(com.huawei.openalliance.ad.constant.w.Code, 0);
        try {
            this.S = context.getSharedPreferences(com.huawei.openalliance.ad.constant.w.Code, 0);
        } catch (Throwable unused) {
            this.S = null;
            fb.I(Code, "create sp error.");
        }
        ap();
        this.b = new com.huawei.openalliance.ad.utils.l(this.c).Code();
        this.D = (Map) com.huawei.openalliance.ad.utils.aa.V(ar(), Map.class, new Class[0]);
    }

    public static ed Code(Context context) {
        return I(context);
    }

    private void ap() {
        if (aq()) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = this.S;
            if (sharedPreferences == null) {
                if (fb.Code()) {
                    fb.Code(Code, "there is no old config file");
                    return;
                }
                return;
            }
            Map<String, ?> all = sharedPreferences.getAll();
            if (all != null && !all.isEmpty()) {
                Set<Map.Entry<String, ?>> entrySet = all.entrySet();
                if (entrySet != null && !entrySet.isEmpty()) {
                    SharedPreferences.Editor edit = this.C.edit();
                    Iterator<Map.Entry<String, ?>> it = entrySet.iterator();
                    while (it.hasNext()) {
                        Code(it.next(), edit);
                    }
                    edit.commit();
                }
                B(true);
                return;
            }
            if (fb.Code()) {
                fb.Code(Code, "there is no old config file");
            }
        } catch (Throwable th) {
            fb.I(Code, "restore config error:" + th.getClass().getSimpleName());
        }
    }

    private boolean aq() {
        boolean z;
        synchronized (this.f17285a) {
            z = this.C.getBoolean(com.huawei.openalliance.ad.constant.w.aj, false);
        }
        return z;
    }

    private String ar() {
        String string;
        synchronized (this.f17285a) {
            string = this.C.getString(com.huawei.openalliance.ad.constant.w.al, "");
        }
        return string;
    }

    private String as() {
        String string;
        synchronized (this.f17285a) {
            string = this.C.getString(com.huawei.openalliance.ad.constant.w.m, "");
        }
        return string;
    }

    private int at() {
        int i;
        synchronized (this.f17285a) {
            i = this.C.getInt(com.huawei.openalliance.ad.constant.w.ae, 2);
        }
        return i;
    }

    public int A() {
        int intValue;
        synchronized (this.f17285a) {
            try {
                Map<String, String> map = this.D;
                Integer F2 = map != null ? com.huawei.openalliance.ad.utils.ay.F(map.get(com.huawei.openalliance.ad.constant.w.E)) : null;
                intValue = (F2 != null && F2.intValue() > 0) ? F2.intValue() : 100;
            } finally {
            }
        }
        return intValue;
    }

    public void B(int i) {
        synchronized (this.f17285a) {
            if (i > 0) {
                try {
                    this.C.edit().putInt(com.huawei.openalliance.ad.constant.w.ac, i).commit();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public long C() {
        long j;
        synchronized (this.f17285a) {
            j = this.C.getLong(com.huawei.openalliance.ad.constant.w.V, 1800000L);
        }
        return j;
    }

    public int D() {
        int i;
        synchronized (this.f17285a) {
            i = this.C.getInt(com.huawei.openalliance.ad.constant.w.D, 0);
        }
        return i;
    }

    public String E() {
        String V2;
        synchronized (this.f17285a) {
            try {
                Map<String, String> map = this.D;
                V2 = map != null ? com.huawei.openalliance.ad.utils.ay.V(map.get(com.huawei.openalliance.ad.constant.w.G)) : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return V2;
    }

    public int F() {
        int i;
        synchronized (this.f17285a) {
            i = this.C.getInt("splash_skip_area", 0);
        }
        return i;
    }

    public int G() {
        int intValue;
        synchronized (this.f17285a) {
            try {
                Map<String, String> map = this.D;
                Integer F2 = map != null ? com.huawei.openalliance.ad.utils.ay.F(map.get(com.huawei.openalliance.ad.constant.w.H)) : null;
                intValue = (F2 != null && F2.intValue() > 0) ? F2.intValue() : 15;
            } finally {
            }
        }
        return intValue;
    }

    public int H() {
        int intValue;
        synchronized (this.f17285a) {
            try {
                Map<String, String> map = this.D;
                Integer F2 = map != null ? com.huawei.openalliance.ad.utils.ay.F(map.get(com.huawei.openalliance.ad.constant.w.J)) : null;
                intValue = (F2 != null && F2.intValue() > 0) ? F2.intValue() : 5;
            } finally {
            }
        }
        return intValue;
    }

    public int I() {
        int i;
        synchronized (this.f17285a) {
            i = this.C.getInt(com.huawei.openalliance.ad.constant.w.C, at());
        }
        return i;
    }

    public int J() {
        int intValue;
        synchronized (this.f17285a) {
            try {
                Map<String, String> map = this.D;
                Integer F2 = map != null ? com.huawei.openalliance.ad.utils.ay.F(map.get(com.huawei.openalliance.ad.constant.w.K)) : null;
                intValue = (F2 != null && F2.intValue() > 0) ? F2.intValue() : 56;
            } finally {
            }
        }
        return intValue;
    }

    public int K() {
        int intValue;
        synchronized (this.f17285a) {
            try {
                Map<String, String> map = this.D;
                Integer F2 = map != null ? com.huawei.openalliance.ad.utils.ay.F(map.get(com.huawei.openalliance.ad.constant.w.N)) : null;
                intValue = (F2 != null && F2.intValue() > 0) ? F2.intValue() : 16;
            } finally {
            }
        }
        return intValue;
    }

    public int L() {
        int i;
        synchronized (this.f17285a) {
            i = this.C.getInt(com.huawei.openalliance.ad.constant.w.L, 2000);
        }
        return i;
    }

    public int M() {
        int intValue;
        synchronized (this.f17285a) {
            try {
                Map<String, String> map = this.D;
                Integer F2 = map != null ? com.huawei.openalliance.ad.utils.ay.F(map.get(com.huawei.openalliance.ad.constant.w.O)) : null;
                intValue = (F2 != null && F2.intValue() > 0) ? F2.intValue() : 36;
            } finally {
            }
        }
        return intValue;
    }

    public int N() {
        int intValue;
        synchronized (this.f17285a) {
            synchronized (this.f17285a) {
                try {
                    Map<String, String> map = this.D;
                    Integer F2 = map != null ? com.huawei.openalliance.ad.utils.ay.F(map.get(com.huawei.openalliance.ad.constant.w.Q)) : null;
                    intValue = (F2 != null && F2.intValue() >= 0) ? F2.intValue() : 60;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return intValue;
    }

    public int O() {
        int intValue;
        synchronized (this.f17285a) {
            synchronized (this.f17285a) {
                try {
                    Map<String, String> map = this.D;
                    Integer F2 = map != null ? com.huawei.openalliance.ad.utils.ay.F(map.get(com.huawei.openalliance.ad.constant.w.T)) : null;
                    intValue = (F2 != null && F2.intValue() > 0) ? F2.intValue() : 200;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return intValue;
    }

    public Map<String, String> P() {
        Map<String, String> map;
        synchronized (this.f17285a) {
            synchronized (this.f17285a) {
                try {
                    Map<String, String> map2 = this.D;
                    map = map2 != null ? (Map) com.huawei.openalliance.ad.utils.aa.V(map2.get(com.huawei.openalliance.ad.constant.w.R), Map.class, new Class[0]) : null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return map;
    }

    public Long Q() {
        Long valueOf;
        synchronized (this.f17285a) {
            valueOf = Long.valueOf(this.C.getLong(com.huawei.openalliance.ad.constant.w.Y, 0L));
        }
        return valueOf;
    }

    public int R() {
        int i;
        synchronized (this.f17285a) {
            i = this.C.getInt(com.huawei.openalliance.ad.constant.w.aa, 0);
        }
        return i;
    }

    public long S() {
        long max;
        synchronized (this.f17285a) {
            max = Math.max(this.C.getLong(com.huawei.openalliance.ad.constant.w.I, 1800000L), 300000L);
        }
        return max;
    }

    public String T() {
        String string;
        synchronized (this.f17285a) {
            string = this.C.getString(com.huawei.openalliance.ad.constant.w.ab, null);
        }
        return string;
    }

    public int U() {
        int i;
        synchronized (this.f17285a) {
            i = this.C.getInt(com.huawei.openalliance.ad.constant.w.ac, 100);
        }
        return i;
    }

    public int V() {
        int i;
        synchronized (this.f17285a) {
            i = this.C.getInt(com.huawei.openalliance.ad.constant.w.B, 3000);
        }
        return i;
    }

    public String W() {
        String string;
        synchronized (this.f17285a) {
            string = this.C.getString(com.huawei.openalliance.ad.constant.w.ad, this.b);
        }
        return string;
    }

    public boolean X() {
        boolean z;
        synchronized (this.f17285a) {
            z = this.C.getBoolean("full_screen_notify", true);
        }
        return z;
    }

    public int Y() {
        int i;
        synchronized (this.f17285a) {
            i = this.C.getInt(com.huawei.openalliance.ad.constant.w.ag, 0);
        }
        return i;
    }

    public int Z() {
        int i;
        synchronized (this.f17285a) {
            try {
                int i2 = 0;
                i = this.C.getInt(com.huawei.openalliance.ad.constant.w.C, 0);
                if (i == 0) {
                    int at = at();
                    if (at != 1) {
                        i2 = at;
                    }
                    i = i2;
                }
            } finally {
            }
        }
        return i;
    }

    public int a() {
        int i;
        synchronized (this.f17285a) {
            try {
                int D = 1 == I() ? D() : 2000;
                if (com.huawei.openalliance.ad.utils.n.V(this.c)) {
                    D = L();
                }
                i = this.C.getInt(com.huawei.openalliance.ad.constant.w.F, D);
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    public int aa() {
        synchronized (this.f17285a) {
            try {
                if (!ck.Code(this.c).V()) {
                    return 0;
                }
                return this.C.getInt(com.huawei.openalliance.ad.constant.w.ao, 0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int ab() {
        int i;
        synchronized (this.f17285a) {
            i = this.C.getInt(com.huawei.openalliance.ad.constant.w.ah, 0) * 1000;
        }
        return i;
    }

    public boolean ac() {
        boolean z;
        synchronized (this.f17285a) {
            z = this.C.getBoolean(com.huawei.openalliance.ad.constant.w.ai, false);
        }
        return z;
    }

    public int ad() {
        synchronized (this.f17285a) {
            try {
                Integer F2 = !com.huawei.openalliance.ad.utils.ai.Code(this.D) ? com.huawei.openalliance.ad.utils.ay.F(this.D.get("preRequest")) : null;
                if (F2 == null) {
                    return 0;
                }
                return F2.intValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean ae() {
        boolean z;
        synchronized (this.f17285a) {
            try {
                Map<String, String> map = this.D;
                Integer F2 = map != null ? com.huawei.openalliance.ad.utils.ay.F(map.get(com.huawei.openalliance.ad.constant.w.U)) : null;
                if (F2 != null) {
                    z = true;
                    if (F2.intValue() == 1) {
                    }
                }
                z = false;
            } finally {
            }
        }
        return z;
    }

    public long af() {
        long j;
        synchronized (this.f17285a) {
            j = this.C.getLong(com.huawei.openalliance.ad.constant.w.f17383a, 0L);
        }
        return j;
    }

    public int ag() {
        int i;
        synchronized (this.f17285a) {
            i = this.C.getInt(com.huawei.openalliance.ad.constant.w.aq, 30);
        }
        return i;
    }

    public String ah() {
        String string;
        synchronized (this.f17285a) {
            string = this.C.getString(com.huawei.openalliance.ad.constant.w.ap, "");
        }
        return string;
    }

    public Set<String> ai() {
        Set<String> stringSet;
        synchronized (this.f17285a) {
            stringSet = this.C.getStringSet(com.huawei.openalliance.ad.constant.w.ar, new HashSet());
        }
        return stringSet;
    }

    public boolean aj() {
        synchronized (this.f17285a) {
            try {
                if (!com.huawei.openalliance.ad.utils.n.V(this.c)) {
                    return false;
                }
                fb.Code(Code, "isSingleMediaPlayerInstance, is tv");
                Set<String> stringSet = this.C.getStringSet(com.huawei.openalliance.ad.constant.w.as, new HashSet());
                String Code2 = com.huawei.openalliance.ad.utils.n.Code();
                if (!com.huawei.openalliance.ad.utils.ad.Code(stringSet) && !TextUtils.isEmpty(Code2)) {
                    return com.huawei.openalliance.ad.utils.ay.Code(stringSet, Code2.toUpperCase(Locale.ENGLISH));
                }
                return true;
            } finally {
            }
        }
    }

    public int ak() {
        int i;
        synchronized (this.f17285a) {
            try {
                Map<String, String> map = this.D;
                i = 0;
                int Code2 = (map == null || TextUtils.isEmpty(map.get(com.huawei.openalliance.ad.constant.w.ak))) ? 0 : com.huawei.openalliance.ad.utils.ay.Code(this.D.get(com.huawei.openalliance.ad.constant.w.ak), 0);
                if (Code2 == 0 || Code2 == 1) {
                    i = Code2;
                }
            } finally {
            }
        }
        return i;
    }

    public String al() {
        String string;
        synchronized (this.f17285a) {
            string = this.C.getString("sha256", "");
        }
        return string;
    }

    public long am() {
        synchronized (this.f17285a) {
            try {
                Map<String, String> map = this.D;
                if (map == null) {
                    return 5000L;
                }
                String str = map.get(com.huawei.openalliance.ad.constant.w.au);
                if (TextUtils.isEmpty(str)) {
                    return 5000L;
                }
                long Code2 = com.huawei.openalliance.ad.utils.ay.Code(str, 5L);
                return Code2 >= 0 ? Code2 * 1000 : 5000L;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Map<String, String> an() {
        Map<String, String> map;
        synchronized (this.f17285a) {
            try {
                String packageName = this.c.getPackageName();
                Map<String, String> map2 = this.D;
                Map map3 = map2 != null ? (Map) com.huawei.openalliance.ad.utils.aa.V(map2.get(com.huawei.openalliance.ad.constant.w.av), Map.class, new Class[0]) : null;
                return (map3 == null || !map3.containsKey(packageName) || (map = (Map) com.huawei.openalliance.ad.utils.aa.V((String) map3.get(packageName), Map.class, new Class[0])) == null) ? new HashMap() : map;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public long ao() {
        long j;
        synchronized (this.f17285a) {
            j = this.C.getLong(com.huawei.openalliance.ad.constant.w.aA, 0L);
        }
        return j;
    }

    public long b() {
        long j;
        synchronized (this.f17285a) {
            j = this.C.getLong(com.huawei.openalliance.ad.constant.w.b, 300L);
        }
        return j;
    }

    public int c() {
        int i;
        synchronized (this.f17285a) {
            i = this.C.getInt(com.huawei.openalliance.ad.constant.w.c, 0);
        }
        return i;
    }

    public int d() {
        int i;
        synchronized (this.f17285a) {
            i = this.C.getInt(com.huawei.openalliance.ad.constant.w.d, 0);
        }
        return i;
    }

    public String e() {
        String string;
        synchronized (this.f17285a) {
            string = this.C.getString(com.huawei.openalliance.ad.constant.w.e, "");
        }
        return string;
    }

    public boolean f() {
        boolean z;
        synchronized (this.f17285a) {
            z = this.C.getBoolean(com.huawei.openalliance.ad.constant.w.i, false);
        }
        return z;
    }

    public boolean g() {
        boolean z;
        synchronized (this.f17285a) {
            z = this.C.getBoolean(com.huawei.openalliance.ad.constant.w.j, true);
        }
        return z;
    }

    public long h() {
        long j;
        synchronized (this.f17285a) {
            j = this.C.getLong(com.huawei.openalliance.ad.constant.w.k, 0L);
        }
        return j;
    }

    public int i() {
        int i;
        synchronized (this.f17285a) {
            i = this.C.getInt(com.huawei.openalliance.ad.constant.w.g, 360);
        }
        return i;
    }

    public long j() {
        long j;
        synchronized (this.f17285a) {
            j = this.C.getLong(com.huawei.openalliance.ad.constant.w.h, 0L);
        }
        return j;
    }

    public boolean k() {
        Integer Code2 = com.huawei.openalliance.ad.utils.az.Code(as(), 1);
        return Code2 != null && Code2.intValue() == 1;
    }

    public Set<String> l() {
        Set<String> stringSet;
        synchronized (this.f17285a) {
            stringSet = this.C.getStringSet(com.huawei.openalliance.ad.constant.w.n, com.huawei.openalliance.ad.constant.aa.Code);
        }
        return stringSet;
    }

    public int m() {
        int i;
        synchronized (this.f17285a) {
            i = this.C.getInt(com.huawei.openalliance.ad.constant.w.o, 0);
        }
        return i;
    }

    public long n() {
        long j;
        synchronized (this.f17285a) {
            j = this.C.getLong(com.huawei.openalliance.ad.constant.w.q, 30L);
        }
        return j;
    }

    public long o() {
        long j;
        synchronized (this.f17285a) {
            j = this.C.getInt(com.huawei.openalliance.ad.constant.w.s, 60);
        }
        return j;
    }

    public long p() {
        long j;
        synchronized (this.f17285a) {
            j = this.C.getLong(com.huawei.openalliance.ad.constant.w.r, 120L);
        }
        return j;
    }

    public int q() {
        int i;
        synchronized (this.f17285a) {
            i = this.C.getInt(com.huawei.openalliance.ad.constant.w.l, 52428800);
        }
        return i;
    }

    public String r() {
        String string;
        synchronized (this.f17285a) {
            string = this.C.getString(com.huawei.openalliance.ad.constant.w.t, null);
        }
        return string;
    }

    public float s() {
        float f2;
        synchronized (this.f17285a) {
            f2 = this.C.getFloat(com.huawei.openalliance.ad.constant.w.v, 0.05f);
        }
        return f2;
    }

    public int t() {
        try {
            return ((Integer) Class.forName("com.huawei.openalliance.ad.ppskit.utils.SdkSpFunctionWrapper").getMethod("getAdsCoreSelection", null).invoke(null, null)).intValue();
        } catch (Throwable unused) {
            fb.V(Code, "function wrapper not found");
            int i = 1;
            if (!ck.V(this.c) && ck.Code(this.c).V()) {
                return 1;
            }
            synchronized (this.f17285a) {
                try {
                    String Code2 = com.huawei.openalliance.ad.utils.bc.Code(this.c, com.huawei.openalliance.ad.constant.x.bL);
                    if (!TextUtils.isEmpty(Code2)) {
                        int i2 = com.huawei.openalliance.ad.constant.f.Z.equalsIgnoreCase(Code2) ? 1 : com.huawei.openalliance.ad.constant.f.B.equalsIgnoreCase(Code2) ? 0 : com.huawei.openalliance.ad.constant.f.C.equalsIgnoreCase(Code2) ? 2 : -1;
                        if (i2 != -1) {
                            return i2;
                        }
                    }
                    if (ck.V(this.c) && !ck.Code(this.c).V()) {
                        i = 0;
                    }
                    return this.C.getInt(com.huawei.openalliance.ad.constant.w.W, i);
                } finally {
                }
            }
        }
    }

    public String u() {
        String string;
        synchronized (this.f17285a) {
            string = this.C.getString(com.huawei.openalliance.ad.constant.w.X, "");
        }
        return string;
    }

    public int v() {
        int intValue;
        synchronized (this.f17285a) {
            synchronized (this.f17285a) {
                try {
                    Map<String, String> map = this.D;
                    Integer F2 = map != null ? com.huawei.openalliance.ad.utils.ay.F(map.get(com.huawei.openalliance.ad.constant.w.w)) : null;
                    intValue = (F2 != null && F2.intValue() > 0) ? F2.intValue() : 10;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return intValue;
    }

    public int w() {
        synchronized (this.f17285a) {
            try {
                Map<String, String> map = this.D;
                Integer F2 = map != null ? com.huawei.openalliance.ad.utils.ay.F(map.get(com.huawei.openalliance.ad.constant.w.x)) : null;
                if (F2 != null && F2.intValue() >= 0) {
                    if (F2.intValue() <= 4) {
                        return F2.intValue();
                    }
                    return 0;
                }
                return 0;
            } finally {
            }
        }
    }

    public String x() {
        String V2;
        synchronized (this.f17285a) {
            try {
                Map<String, String> map = this.D;
                V2 = map != null ? com.huawei.openalliance.ad.utils.ay.V(map.get(com.huawei.openalliance.ad.constant.w.y)) : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return V2;
    }

    public int y() {
        int intValue;
        synchronized (this.f17285a) {
            try {
                Map<String, String> map = this.D;
                Integer F2 = map != null ? com.huawei.openalliance.ad.utils.ay.F(map.get(com.huawei.openalliance.ad.constant.w.z)) : null;
                intValue = (F2 != null && F2.intValue() >= 0 && F2.intValue() <= 24) ? F2.intValue() : 3;
            } finally {
            }
        }
        return intValue;
    }

    public String z() {
        String V2;
        synchronized (this.f17285a) {
            try {
                Map<String, String> map = this.D;
                V2 = map != null ? com.huawei.openalliance.ad.utils.ay.V(map.get(com.huawei.openalliance.ad.constant.w.A)) : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return V2;
    }

    private static ed I(Context context) {
        ed edVar;
        synchronized (L) {
            try {
                if (F == null) {
                    F = new ed(context);
                }
                edVar = F;
            } catch (Throwable th) {
                throw th;
            }
        }
        return edVar;
    }

    public void B(String str) {
        synchronized (this.f17285a) {
            this.C.edit().putString(com.huawei.openalliance.ad.constant.w.ap, str).commit();
        }
    }

    public void C(int i) {
        synchronized (this.f17285a) {
            this.C.edit().putInt("splash_skip_area", i).commit();
        }
    }

    public String Code() {
        String string;
        synchronized (this.f17285a) {
            string = this.C.getString(com.huawei.openalliance.ad.constant.w.an, "");
        }
        return string;
    }

    public boolean D(String str) {
        boolean equals;
        synchronized (this.f17285a) {
            try {
                Map<String, String> map = this.D;
                equals = "1".equals(map != null ? map.get(com.huawei.openalliance.ad.constant.w.ax) : null);
            } catch (Throwable th) {
                throw th;
            }
        }
        return equals;
    }

    public String F(String str) {
        if (com.huawei.openalliance.ad.utils.ay.Code(str)) {
            return null;
        }
        synchronized (this.f17285a) {
            try {
                if (com.huawei.openalliance.ad.utils.ai.Code(this.D)) {
                    return null;
                }
                return this.D.get(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int L(String str) {
        int Code2;
        synchronized (this.f17285a) {
            try {
                Map<String, String> map = this.D;
                Code2 = (map != null ? com.huawei.openalliance.ad.utils.ay.Code(map.get(com.huawei.openalliance.ad.constant.w.ay), 60) : 60) * 60000;
            } catch (Throwable th) {
                throw th;
            }
        }
        return Code2;
    }

    public void S(int i) {
        synchronized (this.f17285a) {
            this.C.edit().putInt(com.huawei.openalliance.ad.constant.w.ae, i).commit();
        }
    }

    public int V(Context context) {
        int i;
        synchronized (this.f17285a) {
            try {
                boolean h2 = com.huawei.openalliance.ad.utils.w.h(context);
                i = h2 ? 98 : 64;
                int i2 = h2 ? 119 : 85;
                Map<String, String> map = this.D;
                Integer F2 = map != null ? com.huawei.openalliance.ad.utils.ay.F(map.get(com.huawei.openalliance.ad.constant.w.M)) : null;
                if (F2 != null && F2.intValue() > 0 && F2.intValue() <= i2) {
                    i = F2.intValue();
                }
            } finally {
            }
        }
        return i;
    }

    public void Z(int i) {
        synchronized (this.f17285a) {
            if (i > 0) {
                try {
                    this.C.edit().putInt(com.huawei.openalliance.ad.constant.w.aa, i).commit();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public int a(String str) {
        int i;
        synchronized (this.f17285a) {
            try {
                Map<String, String> map = this.D;
                int i2 = h;
                if (map != null) {
                    i2 = com.huawei.openalliance.ad.utils.ay.Code(map.get(com.huawei.openalliance.ad.constant.w.az), h);
                }
                i = i2 * 60000;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    private void B(boolean z) {
        synchronized (this.f17285a) {
            this.C.edit().putBoolean(com.huawei.openalliance.ad.constant.w.aj, z).commit();
        }
    }

    public void C(String str) {
        synchronized (this.f17285a) {
            this.C.edit().putString("sha256", str).commit();
        }
    }

    public void Code(int i) {
        synchronized (this.f17285a) {
            this.C.edit().putInt(com.huawei.openalliance.ad.constant.w.D, i).commit();
        }
    }

    public void F(int i) {
        synchronized (this.f17285a) {
            this.C.edit().putInt(com.huawei.openalliance.ad.constant.w.ag, i).commit();
        }
    }

    public void I(int i) {
        synchronized (this.f17285a) {
            SharedPreferences.Editor edit = this.C.edit();
            edit.putInt(com.huawei.openalliance.ad.constant.w.o, i);
            edit.commit();
        }
    }

    public boolean S(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Map<String, String> map = this.D;
        List list = (List) com.huawei.openalliance.ad.utils.aa.V(map != null ? map.get(com.huawei.openalliance.ad.constant.w.f) : null, List.class, String.class);
        return list == null ? com.huawei.openalliance.ad.constant.cy.V(str) : list.contains(str);
    }

    public void V(int i) {
        synchronized (this.f17285a) {
            this.C.edit().putInt(com.huawei.openalliance.ad.constant.w.L, i).commit();
        }
    }

    public void Z(long j) {
        if (j <= 0) {
            return;
        }
        synchronized (this.f17285a) {
            this.C.edit().putLong(com.huawei.openalliance.ad.constant.w.aA, j).commit();
        }
    }

    public boolean B() {
        synchronized (this.f17285a) {
            try {
                return this.C.getInt(com.huawei.openalliance.ad.constant.w.Z, 0) == 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void Code(long j) {
        synchronized (this.f17285a) {
            this.C.edit().putLong(com.huawei.openalliance.ad.constant.w.h, j).commit();
        }
    }

    public void I(long j) {
        synchronized (this.f17285a) {
            this.C.edit().putLong(com.huawei.openalliance.ad.constant.w.f17383a, j).commit();
        }
    }

    public void V(long j) {
        synchronized (this.f17285a) {
            if (j > 0) {
                try {
                    this.C.edit().putLong(com.huawei.openalliance.ad.constant.w.Y, j).commit();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void Z(String str) {
        synchronized (this.f17285a) {
            try {
                if (!com.huawei.openalliance.ad.utils.ay.Code(str)) {
                    this.C.edit().putString(com.huawei.openalliance.ad.constant.w.ad, str).commit();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void Code(SharedPreferences.Editor editor, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("trustAppList", jSONObject);
            Code(editor, com.huawei.openalliance.ad.constant.w.an, jSONObject2.toString());
        } catch (JSONException unused) {
            fb.Z(Code, "putTrustAppList JSONException");
        }
    }

    private void V(SharedPreferences.Editor editor, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            editor.putString(com.huawei.openalliance.ad.constant.w.al, jSONObject.toString());
            this.D = (Map) com.huawei.openalliance.ad.utils.aa.V(jSONObject.toString(), Map.class, new Class[0]);
        } catch (JSONException unused) {
            fb.Z(Code, "putConfigMap JSONException");
        }
    }

    public void I(String str) {
        synchronized (this.f17285a) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    this.C.edit().putString(com.huawei.openalliance.ad.constant.w.m, str).commit();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void Z(boolean z) {
        synchronized (this.f17285a) {
            this.C.edit().putBoolean(com.huawei.openalliance.ad.constant.w.ai, z).commit();
        }
    }

    private void Code(SharedPreferences.Editor editor, String str, Integer num) {
        if (num != null) {
            editor.putInt(str, num.intValue());
        }
    }

    public void I(boolean z) {
        synchronized (this.f17285a) {
            this.C.edit().putBoolean("full_screen_notify", z).commit();
        }
    }

    public void V(String str) {
        synchronized (this.f17285a) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    this.C.edit().putString(com.huawei.openalliance.ad.constant.w.ab, str).commit();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void Code(SharedPreferences.Editor editor, String str, Integer num, int i) {
        if (num != null) {
            editor.putInt(str, num.intValue());
        } else {
            editor.putInt(str, i);
        }
    }

    public void V(boolean z) {
        synchronized (this.f17285a) {
            this.C.edit().putBoolean(com.huawei.openalliance.ad.constant.w.j, z).commit();
        }
    }

    private void Code(SharedPreferences.Editor editor, String str, Long l) {
        if (l != null) {
            editor.putLong(str, l.longValue());
        }
    }

    private void Code(SharedPreferences.Editor editor, String str, String str2) {
        if (str2 != null) {
            editor.putString(str, str2);
        }
    }

    @SuppressLint({"ApplySharedPref"})
    public void Code(AppConfigRsp appConfigRsp) {
        synchronized (this.f17285a) {
            try {
                SharedPreferences.Editor edit = this.C.edit();
                edit.putLong(com.huawei.openalliance.ad.constant.w.V, appConfigRsp.e().longValue());
                edit.putLong(com.huawei.openalliance.ad.constant.w.I, appConfigRsp.g().longValue());
                edit.putInt(com.huawei.openalliance.ad.constant.w.Z, appConfigRsp.f());
                edit.putInt(com.huawei.openalliance.ad.constant.w.B, appConfigRsp.C());
                Code(edit, com.huawei.openalliance.ad.constant.w.C, appConfigRsp.S());
                edit.putInt("splash_skip_area", appConfigRsp.F());
                if (com.huawei.openalliance.ad.utils.n.V(this.c)) {
                    Code(edit, com.huawei.openalliance.ad.constant.w.F, appConfigRsp.B());
                } else {
                    Code(edit, com.huawei.openalliance.ad.constant.w.F, appConfigRsp.B(), 2000);
                }
                edit.putLong(com.huawei.openalliance.ad.constant.w.b, appConfigRsp.Z());
                edit.putInt(com.huawei.openalliance.ad.constant.w.c, appConfigRsp.I());
                Code(edit, com.huawei.openalliance.ad.constant.w.g, appConfigRsp.D());
                edit.putLong(com.huawei.openalliance.ad.constant.w.h, System.currentTimeMillis());
                edit.putString(com.huawei.openalliance.ad.constant.w.m, appConfigRsp.L());
                edit.putLong(com.huawei.openalliance.ad.constant.w.p, appConfigRsp.b());
                edit.putFloat(com.huawei.openalliance.ad.constant.w.v, (float) appConfigRsp.h());
                Code(edit, com.huawei.openalliance.ad.constant.w.q, appConfigRsp.c());
                Code(edit, com.huawei.openalliance.ad.constant.w.r, appConfigRsp.d());
                Code(edit, com.huawei.openalliance.ad.constant.w.W, appConfigRsp.i());
                edit.putString(com.huawei.openalliance.ad.constant.w.X, appConfigRsp.j());
                V(edit, appConfigRsp.k());
                Code(edit, com.huawei.openalliance.ad.constant.w.s, appConfigRsp.l());
                Code(edit, appConfigRsp.V());
                Code(edit, com.huawei.openalliance.ad.constant.w.ao, appConfigRsp.m());
                Code(edit, com.huawei.openalliance.ad.constant.w.ah, appConfigRsp.n());
                Code(edit, com.huawei.openalliance.ad.constant.w.aq, appConfigRsp.o());
                Code(appConfigRsp.p());
                Code(edit, "sha256", appConfigRsp.q());
                List<String> a2 = appConfigRsp.a();
                if (!com.huawei.openalliance.ad.utils.ad.Code(a2)) {
                    edit.putStringSet(com.huawei.openalliance.ad.constant.w.n, new HashSet(a2));
                }
                edit.commit();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void Code(String str) {
        synchronized (this.f17285a) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    this.C.edit().putString(com.huawei.openalliance.ad.constant.w.t, str).commit();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void Code(List<String> list) {
        synchronized (this.f17285a) {
            try {
                if (!com.huawei.openalliance.ad.utils.ad.Code(list)) {
                    this.C.edit().putStringSet(com.huawei.openalliance.ad.constant.w.as, com.huawei.openalliance.ad.utils.ad.Code(list, true)).commit();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void Code(Map.Entry<String, ?> entry, SharedPreferences.Editor editor) {
        if (entry == null || editor == null) {
            return;
        }
        Object value = entry.getValue();
        String key = entry.getKey();
        if (value instanceof Integer) {
            editor.putInt(key, ((Integer) value).intValue());
            return;
        }
        if (value instanceof Boolean) {
            editor.putBoolean(key, ((Boolean) value).booleanValue());
            return;
        }
        if (value instanceof Long) {
            editor.putLong(key, ((Long) value).longValue());
            return;
        }
        if (value instanceof Float) {
            editor.putFloat(key, ((Float) value).floatValue());
        } else if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Set) {
            editor.putStringSet(key, new HashSet((Set) value));
        }
    }

    public void Code(Set<String> set) {
        synchronized (this.f17285a) {
            try {
                SharedPreferences.Editor edit = this.C.edit();
                if (com.huawei.openalliance.ad.utils.ad.Code(set)) {
                    edit.putStringSet(com.huawei.openalliance.ad.constant.w.ar, null);
                } else {
                    edit.putStringSet(com.huawei.openalliance.ad.constant.w.ar, set);
                }
                edit.commit();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void Code(boolean z) {
        synchronized (this.f17285a) {
            this.C.edit().putBoolean(com.huawei.openalliance.ad.constant.w.i, z).commit();
        }
    }
}
