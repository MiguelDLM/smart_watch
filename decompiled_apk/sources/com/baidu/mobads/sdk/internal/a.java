package com.baidu.mobads.sdk.internal;

import O0OOX0IIx.I0Io;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f6210a = "none";
    public static final String b = "text";
    public static final String c = "static_image";
    public static final String d = "gif";
    public static final String e = "rich_media";
    public static final String f = "html";
    public static final String g = "hybrid";
    public static final String h = "video";
    private static final long i = 1750000;
    private String A;
    private String B;
    private String C;
    private int D;
    private String E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private String L;
    private List<String> N;
    private JSONObject O;
    private long P;
    private long Q;
    private String R;
    private String S;
    private String T;
    private String U;
    private String V;
    private String W;
    private String X;
    private JSONObject Y;
    private int Z;
    private int aa;
    private int ab;
    private List<String> ac;
    private String ae;
    private String af;
    private JSONObject ag;
    private JSONObject ah;
    private String j;
    private String k;
    private String l;
    private String m;
    private int n;
    private int o;
    private String p;
    private long q;
    private int r;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;
    private int s = 1;
    private String M = "none";
    private int ad = 0;

    public static boolean a(int i2) {
        return (i2 < 28 || 31 == i2 || 32 == i2 || 38 == i2 || 39 == i2 || 40 == i2 || 42 < i2) ? false : true;
    }

    public String A() {
        return this.z;
    }

    public String B() {
        return this.y;
    }

    public String C() {
        return this.A;
    }

    public String D() {
        return this.B;
    }

    public String E() {
        return this.C;
    }

    public long F() {
        return this.Q;
    }

    public List<String> G() {
        return this.N;
    }

    public String H() {
        return this.R;
    }

    public JSONObject I() {
        return this.O;
    }

    public String J() {
        return this.U;
    }

    public String K() {
        return this.V;
    }

    public String L() {
        return this.W;
    }

    public String M() {
        String str = this.X;
        if (str != null && str.length() > 4) {
            return "";
        }
        return this.X;
    }

    public int N() {
        return this.ab;
    }

    public List<String> O() {
        return this.ac;
    }

    public JSONObject P() {
        return this.Y;
    }

    public int Q() {
        return this.Z;
    }

    public int R() {
        return this.aa;
    }

    public int S() {
        return this.ad;
    }

    public JSONObject T() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uniqueId", this.R);
            jSONObject.put("tit", this.j);
            jSONObject.put("desc", this.k);
            jSONObject.put("pk", this.v);
            jSONObject.put("appname", this.p);
            jSONObject.put(I0Io.f1285X0o0xo, this.D);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String U() {
        return this.ae;
    }

    public String V() {
        if (!TextUtils.isEmpty(this.af)) {
            try {
                long parseLong = Long.parseLong(this.af);
                int length = this.af.length();
                if (parseLong > 100000 && length > 5) {
                    return this.af.substring(length - 4, length);
                }
                return "";
            } catch (Throwable th) {
                az.b(th);
                return "";
            }
        }
        return "";
    }

    public String b() {
        return this.k;
    }

    public String c() {
        return this.l;
    }

    public String d() {
        return this.m;
    }

    public int e() {
        return this.n;
    }

    public int f() {
        return this.o;
    }

    public String g() {
        return this.p;
    }

    public String h() {
        return this.S;
    }

    public String i() {
        return this.T;
    }

    public long j() {
        return this.q;
    }

    public int k() {
        return this.r;
    }

    public int l() {
        return this.s;
    }

    public String m() {
        return this.v;
    }

    public String n() {
        return this.w;
    }

    public String o() {
        return this.x;
    }

    public int p() {
        return this.D;
    }

    public String q() {
        return this.E;
    }

    public int r() {
        return this.F;
    }

    public int s() {
        return this.G;
    }

    public int t() {
        return this.H;
    }

    public int u() {
        return this.I;
    }

    public int v() {
        return this.J;
    }

    public int w() {
        return this.K;
    }

    public String x() {
        return this.M;
    }

    public long y() {
        return this.P;
    }

    public String z() {
        if (!TextUtils.isEmpty(this.u)) {
            return this.u;
        }
        return this.t;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0153 A[Catch: all -> 0x00bd, JSONException -> 0x00c0, TryCatch #4 {JSONException -> 0x00c0, all -> 0x00bd, blocks: (B:5:0x0082, B:8:0x0094, B:10:0x00a5, B:11:0x00c3, B:13:0x00cf, B:15:0x00da, B:17:0x00e0, B:18:0x00e2, B:20:0x00e8, B:22:0x00ee, B:24:0x00f6, B:28:0x00ff, B:30:0x0109, B:32:0x0126, B:36:0x012c, B:37:0x0132, B:39:0x013a, B:41:0x0140, B:43:0x014a, B:45:0x0153, B:47:0x0161, B:49:0x0168, B:50:0x0170, B:52:0x0176), top: B:4:0x0082 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.baidu.mobads.sdk.internal.a a(org.json.JSONObject r17) {
        /*
            Method dump skipped, instructions count: 856
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.a.a(org.json.JSONObject):com.baidu.mobads.sdk.internal.a");
    }

    public String a(String str) {
        if (this.ag == null) {
            return null;
        }
        JSONObject jSONObject = this.ah;
        JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("apo") : null;
        String optString = this.ag.optString(str);
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        if (TextUtils.equals(optString, "fallback") && optJSONObject != null) {
            return optJSONObject.optString("fallback");
        }
        if (TextUtils.equals(optString, "page") && optJSONObject != null) {
            return optJSONObject.optString("page");
        }
        JSONObject jSONObject2 = this.ah;
        if (jSONObject2 != null) {
            return jSONObject2.optString(optString);
        }
        return null;
    }

    public static List<a> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    arrayList.add(a(jSONArray.getJSONObject(i2)));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    private static int a(JSONObject jSONObject, int i2, int i3) {
        String[] split;
        int i4 = 0;
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("st_op");
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("tp_id");
                    if (!TextUtils.isEmpty(optString) && optString.startsWith("opt_style_") && (split = optString.substring(10).split("_")) != null && split.length > 0) {
                        i4 = Integer.parseInt(split[0]);
                    }
                }
            } catch (Throwable th) {
                bv.a().d(th.getMessage());
            }
        }
        if (a(i4)) {
            i2 = i4;
        } else if (!a(i2)) {
            i2 = i3;
        }
        if (i2 == 42) {
            return 41;
        }
        return i2;
    }

    public String a() {
        return this.j;
    }
}
