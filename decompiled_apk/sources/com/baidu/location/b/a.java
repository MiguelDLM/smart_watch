package com.baidu.location.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.facebook.appevents.UserDataStore;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class a {
    private static String z = "BDLocConfigManager";
    private SharedPreferences A;
    private long B;
    private String C;
    private C0125a D;
    private boolean E;
    private String F;
    private String G;
    private String H;
    private Context I;

    /* renamed from: a, reason: collision with root package name */
    public boolean f5607a;
    public int b;
    public double c;
    public int d;
    public int e;
    public double f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public double[] m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public float s;
    public float t;
    public int u;
    public int[] v;
    public int w;
    public int x;
    public int y;

    /* renamed from: com.baidu.location.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0125a extends com.baidu.location.e.g {

        /* renamed from: a, reason: collision with root package name */
        String f5608a = null;
        boolean b = false;

        public C0125a() {
            this.dB = new HashMap();
        }

        @Override // com.baidu.location.e.g
        public void a() {
            this.dz = 2;
            String encode = Jni.encode(this.f5608a);
            this.f5608a = null;
            this.dB.put("qt", "conf");
            this.dB.put("req", encode);
        }

        public void a(String str) {
            if (this.b) {
                return;
            }
            this.b = true;
            this.f5608a = str;
            b(com.baidu.location.e.e.d);
        }

        @Override // com.baidu.location.e.g
        public void a(boolean z) {
            if (z && this.dA != null) {
                try {
                    new JSONObject(this.dA);
                    if (a.this.A != null) {
                        SharedPreferences.Editor edit = a.this.A.edit();
                        edit.putString(a.z + "_newConfig", Base64.encodeToString(com.baidu.location.e.o.a(this.dA.getBytes()), 0));
                        edit.apply();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Map<String, Object> map = this.dB;
            if (map != null) {
                map.clear();
            }
            this.b = false;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final a f5609a = new a();
    }

    private a() {
        this.A = null;
        this.f5607a = false;
        this.b = 16;
        this.B = 300L;
        this.c = 0.75d;
        this.d = 0;
        this.e = 1;
        this.f = -0.10000000149011612d;
        this.g = 0;
        this.h = 1;
        this.i = 1;
        this.j = 10;
        this.k = 3;
        this.l = 40;
        this.n = 1;
        this.o = 0;
        this.p = 1;
        this.q = 1;
        this.r = 0;
        this.s = 0.2f;
        this.t = 0.8f;
        this.u = 0;
        this.v = null;
        this.w = 8;
        this.x = 4000;
        this.y = 1;
        this.C = null;
        this.D = null;
        this.E = false;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
    }

    private String c() {
        StringBuilder sb = new StringBuilder();
        sb.append("v9.523|");
        sb.append(this.G);
        sb.append("|");
        String str = Build.MODEL;
        sb.append(str);
        sb.append("&cu=");
        sb.append(this.G);
        sb.append("&mb=");
        sb.append(str);
        return sb.toString();
    }

    public static a a() {
        return b.f5609a;
    }

    public synchronized void a(double d, double d2, String str) {
        String encodeToString;
        SharedPreferences sharedPreferences;
        try {
            if (this.H == null && str != null) {
                try {
                    if (!str.equals("bd09")) {
                        if (str.equals("wgs84mc")) {
                        }
                        String format = String.format(Locale.US, "%.5f|%.5f", Double.valueOf(d2), Double.valueOf(d));
                        this.H = format;
                        encodeToString = Base64.encodeToString(format.getBytes("UTF-8"), 0);
                        if (encodeToString != null && (sharedPreferences = this.A) != null) {
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            edit.putString(z + "_loc", encodeToString);
                            edit.apply();
                        }
                    }
                    double[] coorEncrypt = Jni.coorEncrypt(d2, d, BDLocation.BDLOCATION_BD09_TO_GCJ02);
                    double d3 = coorEncrypt[1];
                    double d4 = coorEncrypt[0];
                    d = d3;
                    d2 = d4;
                    String format2 = String.format(Locale.US, "%.5f|%.5f", Double.valueOf(d2), Double.valueOf(d));
                    this.H = format2;
                    encodeToString = Base64.encodeToString(format2.getBytes("UTF-8"), 0);
                    if (encodeToString != null) {
                        SharedPreferences.Editor edit2 = sharedPreferences.edit();
                        edit2.putString(z + "_loc", encodeToString);
                        edit2.apply();
                    }
                } catch (Exception unused) {
                    this.H = null;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void a(Context context, LocationClientOption locationClientOption, String str) {
        try {
            if (!this.E && context != null) {
                this.E = true;
                this.I = context;
                if (locationClientOption == null) {
                    locationClientOption = new LocationClientOption();
                }
                this.F = context.getPackageName();
                try {
                    this.G = LBSAuthManager.getInstance(context).getCUID();
                } catch (Throwable unused) {
                    this.G = null;
                }
                if (this.A == null) {
                    this.A = context.getSharedPreferences(z + "BDLocConfig", 0);
                }
                SharedPreferences sharedPreferences = this.A;
                if (sharedPreferences != null) {
                    long j = sharedPreferences.getLong(z + "_lastCheckTime", 0L);
                    String string = this.A.getString(z + "_config", "");
                    String string2 = this.A.getString(z + "_newConfig", "");
                    if (!TextUtils.isEmpty(string2)) {
                        a(new String(com.baidu.location.e.o.b(Base64.decode(string2, 0))));
                    } else if (!TextUtils.isEmpty(string)) {
                        a(string);
                        SharedPreferences.Editor edit = this.A.edit();
                        edit.remove(z + "_config");
                        edit.apply();
                    }
                    if (Math.abs((System.currentTimeMillis() / 1000) - j) > this.B) {
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        SharedPreferences.Editor edit2 = this.A.edit();
                        edit2.putLong(z + "_lastCheckTime", currentTimeMillis);
                        edit2.apply();
                        a(locationClientOption);
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void a(LocationClientOption locationClientOption) {
        String str = "&ver=" + com.baidu.location.e.o.x + "&usr=" + c() + "&app=" + this.F + "&prod=" + locationClientOption.prodName + "&newwf=1";
        String str2 = Build.VERSION.RELEASE;
        if (str2 != null && str2.length() > 6) {
            str2 = str2.substring(0, 6);
        }
        String str3 = str + "&sv=" + str2;
        String b2 = com.baidu.location.e.o.b("ro.miui.ui.version.name");
        if (!TextUtils.isEmpty(b2)) {
            str3 = str3 + "&miui=" + b2;
        }
        String j = com.baidu.location.e.o.j();
        if (!TextUtils.isEmpty(j)) {
            str3 = str3 + "&mtk=" + j;
        }
        SharedPreferences a2 = ad.a(this.I);
        String string = a2 != null ? a2.getString("mapcity", null) : null;
        if (!TextUtils.isEmpty(string)) {
            str3 = str3 + "&city=" + string;
        }
        String string2 = this.A.getString(z + "_loc", null);
        if (!TextUtils.isEmpty(string2)) {
            try {
                str3 = str3 + "&loc=" + new String(Base64.decode(string2, 0), "UTF-8");
            } catch (Exception unused) {
            }
        }
        if (this.D == null) {
            this.D = new C0125a();
        }
        this.D.a(str3);
    }

    private void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("is_check_Per") && jSONObject.getInt("is_check_Per") > 0) {
                this.f5607a = true;
            }
            if (jSONObject.has("wfnum")) {
                this.b = jSONObject.getInt("wfnum");
            }
            if (jSONObject.has("freq")) {
                this.B = jSONObject.getLong("freq");
            }
            if (jSONObject.has("wfsm")) {
                this.c = jSONObject.getDouble("wfsm");
            }
            if (jSONObject.has("idmoc")) {
                this.d = jSONObject.getInt("idmoc");
            }
            if (jSONObject.has("gnmcrm")) {
                this.f = jSONObject.getDouble("gnmcrm");
            }
            if (jSONObject.has("gnmcon")) {
                this.g = jSONObject.getInt("gnmcon");
            }
            if (jSONObject.has("lpcs")) {
                this.e = jSONObject.getInt("lpcs");
            }
            if (jSONObject.has("iupl")) {
                this.h = jSONObject.getInt("iupl");
            }
            if (jSONObject.has("opetco")) {
                this.i = jSONObject.getInt("opetco");
            }
            if (jSONObject.has(UserDataStore.CITY)) {
                this.j = jSONObject.getInt(UserDataStore.CITY);
            }
            if (jSONObject.has("suci")) {
                this.k = jSONObject.getInt("suci");
            }
            if (jSONObject.has("smn")) {
                this.l = jSONObject.getInt("smn");
            }
            if (jSONObject.has("bcar")) {
                a(jSONObject);
            }
            if (jSONObject.has("ums")) {
                this.n = jSONObject.getInt("ums");
            }
            if (jSONObject.has("hpdts")) {
                this.o = jSONObject.getInt("hpdts");
            }
            if (jSONObject.has("oldts")) {
                this.p = jSONObject.getInt("oldts");
            }
            if (jSONObject.has("nlp_loc_coarse")) {
                this.q = jSONObject.optInt("nlp_loc_coarse");
            }
            if (jSONObject.has("new_loc_cache_switch")) {
                this.r = jSONObject.optInt("new_loc_cache_switch");
            }
            if (jSONObject.has("nc_same_rate")) {
                this.s = (float) jSONObject.optDouble("nc_same_rate", 0.8d);
            }
            if (jSONObject.has("cl_str_change_rate")) {
                this.t = (float) jSONObject.optDouble("cl_str_change_rate", 0.2d);
            }
            if (jSONObject.has("cl_list_switch")) {
                this.u = jSONObject.optInt("cl_list_switch", 0);
            }
            if (jSONObject.has("cl_str_switch")) {
                String[] split = jSONObject.optString("cl_str_switch", "").split(",");
                this.v = new int[split.length];
                int i = 0;
                for (String str2 : split) {
                    this.v[i] = 0;
                    if (str2.length() > 0) {
                        try {
                            this.v[i] = Integer.parseInt(str2);
                        } catch (Throwable unused) {
                        }
                    }
                    i++;
                }
            }
            if (jSONObject.has("cell_number")) {
                this.w = jSONObject.optInt("cell_number", 10);
            }
            if (jSONObject.has("loc_str_length")) {
                this.x = jSONObject.optInt("loc_str_length", 4000);
            }
            if (jSONObject.has("loc_to_foreground")) {
                this.y = jSONObject.optInt("loc_to_foreground", 1);
            }
            this.C = str;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(JSONObject jSONObject) {
        JSONArray jSONArray;
        if (jSONObject != null) {
            double[] dArr = this.m;
            if (dArr != null && dArr.length > 0) {
                this.m = null;
            }
            try {
                if (!jSONObject.has("bcar") || (jSONArray = jSONObject.getJSONArray("bcar")) == null || jSONArray.length() <= 0) {
                    return;
                }
                if (this.m == null) {
                    this.m = new double[jSONArray.length() * 4];
                }
                int i = 0;
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    this.m[i] = jSONArray.getJSONObject(i2).getDouble("x1");
                    this.m[i + 1] = jSONArray.getJSONObject(i2).getDouble("y1");
                    int i3 = i + 3;
                    this.m[i + 2] = jSONArray.getJSONObject(i2).getDouble("x2");
                    i += 4;
                    this.m[i3] = jSONArray.getJSONObject(i2).getDouble("y2");
                }
            } catch (Exception unused) {
            }
        }
    }
}
