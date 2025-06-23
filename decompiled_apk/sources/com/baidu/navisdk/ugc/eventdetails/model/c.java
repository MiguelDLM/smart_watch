package com.baidu.navisdk.ugc.eventdetails.model;

import android.text.TextUtils;
import androidx.annotation.DrawableRes;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ugc.eventdetails.model.e;
import com.garmin.fit.O0Xx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class c {
    private String L;
    public com.baidu.navisdk.ugc.quickinput.tags.b M;
    public com.baidu.navisdk.ugc.quickinput.tags.b N;
    public String O;
    public e.b P;
    public com.baidu.navisdk.ugc.eventdetails.model.e Q;
    public int R;
    public String[] U;
    public String V;
    public ArrayList<g> W;
    public long X;
    public String Y;
    public String Z;
    public String a0;
    public String b0;
    public String c0;
    public e.b x;

    /* renamed from: a, reason: collision with root package name */
    private C0375c f8068a = null;
    private int b = 0;
    private String c = null;
    private String d = null;
    private String e = null;
    private String f = null;
    private String g = null;
    private String h = null;
    private String i = null;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private String m = null;
    private String n = null;
    private String o = null;
    private String p = null;
    private String q = null;
    private String[] r = null;
    private String s = null;
    private int t = 0;
    private e u = null;
    private d[] v = null;
    private long w = 0;
    private b y = null;
    private long z = 0;
    private long A = 0;
    private String B = null;
    private String C = null;
    private String D = null;
    private String E = null;
    private ArrayList<String> F = null;
    private String G = null;
    private String H = null;
    private String I = null;
    public String J = null;
    public String K = null;
    public int S = 1;
    public int T = 0;
    public int d0 = -1;

    /* loaded from: classes8.dex */
    public class a implements Comparator<g> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(g gVar, g gVar2) {
            long c;
            long j;
            long j2 = Long.MAX_VALUE;
            if (gVar == null) {
                c = Long.MAX_VALUE;
            } else {
                c = gVar.c();
            }
            if (gVar2 != null) {
                j2 = gVar2.c();
            }
            long j3 = c - j2;
            if (j3 > 2147483647L) {
                j = j3 - 2147483647L;
            } else if (j3 < O0Xx.f12378xXxxox0I) {
                j = j3 + 2147483647L;
            } else {
                return (int) j3;
            }
            return (int) j;
        }
    }

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private JSONObject f8069a = null;

        public void a(JSONObject jSONObject) {
            this.f8069a = jSONObject;
        }

        public JSONObject a() {
            return this.f8069a;
        }
    }

    /* renamed from: com.baidu.navisdk.ugc.eventdetails.model.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0375c {

        /* renamed from: a, reason: collision with root package name */
        private JSONObject f8070a = null;
        private boolean b = false;
        private boolean c = false;
        private String d = null;
        private int e = 0;

        public void a(JSONObject jSONObject) {
            this.f8070a = jSONObject;
        }

        public JSONObject b() {
            return this.f8070a;
        }

        public String c() {
            return this.d;
        }

        public int d() {
            return this.e;
        }

        public boolean e() {
            return this.c;
        }

        public void a(boolean z) {
            this.b = z;
        }

        public void b(boolean z) {
            this.c = z;
        }

        public void a(int i) {
            this.e = i;
        }

        public boolean a() {
            return this.b;
        }

        public void a(String str) {
            this.d = str;
        }
    }

    /* loaded from: classes8.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public String f8072a;
        public String b;
        public String c;
        public String d;

        public String a() {
            StringBuilder sb = new StringBuilder(7);
            if (!TextUtils.isEmpty(this.f8072a)) {
                sb.append(this.f8072a);
            }
            if (!TextUtils.isEmpty(this.b)) {
                sb.append("\n");
                sb.append(this.b);
            }
            if (!TextUtils.isEmpty(this.c)) {
                sb.append("\n");
                sb.append(this.c);
            }
            if (!TextUtils.isEmpty(this.d)) {
                sb.append("\n");
                sb.append(this.d);
            }
            return sb.toString().trim();
        }

        public String toString() {
            return "SubContent{startDay='" + this.f8072a + "', endDay='" + this.b + "', weekDays='" + this.c + "', interval='" + this.d + "'}";
        }
    }

    private static Comparator<? super g> W() {
        return new a();
    }

    public String A() {
        return this.e;
    }

    public d[] B() {
        return this.v;
    }

    public e C() {
        return this.u;
    }

    public String D() {
        return this.L;
    }

    public String E() {
        return this.o;
    }

    public ArrayList<e.a> F() {
        com.baidu.navisdk.ugc.eventdetails.model.e eVar = this.Q;
        if (eVar == null) {
            return null;
        }
        return eVar.i;
    }

    public String G() {
        com.baidu.navisdk.ugc.eventdetails.model.e eVar = this.Q;
        if (eVar != null) {
            return eVar.f;
        }
        return null;
    }

    public ArrayList<String> H() {
        return this.F;
    }

    public int I() {
        return this.j;
    }

    public int J() {
        return this.k;
    }

    public String K() {
        return this.D;
    }

    public String L() {
        e.b bVar = this.P;
        if (bVar != null) {
            return bVar.c();
        }
        return null;
    }

    public int M() {
        return this.l;
    }

    public String N() {
        return this.c;
    }

    public String O() {
        return this.d;
    }

    public int P() {
        return this.b;
    }

    public boolean Q() {
        if (TextUtils.isEmpty(this.p) && TextUtils.isEmpty(this.E) && !U()) {
            return false;
        }
        return true;
    }

    public boolean R() {
        d[] dVarArr = this.v;
        if (dVarArr != null && dVarArr.length > 0) {
            for (d dVar : dVarArr) {
                if (dVar != null && !dVar.c()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean S() {
        com.baidu.navisdk.ugc.quickinput.tags.b bVar;
        com.baidu.navisdk.ugc.quickinput.tags.b bVar2 = this.N;
        if ((bVar2 != null && bVar2.a()) || ((bVar = this.M) != null && bVar.a())) {
            return true;
        }
        return false;
    }

    public boolean T() {
        if (this.S == 1) {
            return true;
        }
        return false;
    }

    public boolean U() {
        e.b bVar = this.P;
        if (bVar != null && bVar.d()) {
            return true;
        }
        return false;
    }

    public boolean V() {
        if (this.A == 0) {
            return true;
        }
        return false;
    }

    public void a() {
        this.f8068a = null;
        this.b = 0;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.O = null;
        this.z = 0L;
        this.y = null;
        this.A = 0L;
        this.E = null;
        this.G = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.t = 0;
        this.v = null;
        this.u = null;
        this.w = 0L;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.P = null;
        com.baidu.navisdk.ugc.eventdetails.model.e eVar = this.Q;
        if (eVar != null) {
            eVar.a();
            this.Q = null;
        }
        this.R = 0;
        this.x = null;
        this.M = null;
        this.N = null;
        this.S = 1;
        this.T = 0;
        this.U = null;
        this.V = null;
        this.X = 0L;
        this.Y = null;
        this.Z = null;
        this.a0 = null;
        this.b0 = null;
        this.c0 = null;
        this.d0 = -1;
    }

    public void b(long j) {
        this.z = j;
    }

    public ArrayList<e.a> c() {
        com.baidu.navisdk.ugc.eventdetails.model.e eVar = this.Q;
        if (eVar == null) {
            return null;
        }
        return eVar.j;
    }

    public void d(String str) {
        this.p = str;
    }

    public void e(int i) {
        this.l = i;
    }

    public String f() {
        return this.p;
    }

    public int g() {
        com.baidu.navisdk.ugc.eventdetails.model.e eVar = this.Q;
        if (eVar == null) {
            return 0;
        }
        ArrayList<e.a> arrayList = eVar.j;
        int size = arrayList != null ? arrayList.size() : 0;
        ArrayList<e.a> arrayList2 = this.Q.i;
        if (arrayList2 != null) {
            size += arrayList2.size();
        }
        ArrayList<e.a> arrayList3 = this.Q.h;
        return arrayList3 != null ? size + arrayList3.size() : size;
    }

    public void h(String str) {
        this.B = str;
    }

    public void i(String str) {
        this.E = str;
    }

    public void j(String str) {
        this.C = str;
    }

    public long k() {
        return this.z;
    }

    public String l() {
        return this.g;
    }

    public ArrayList<e.a> m() {
        com.baidu.navisdk.ugc.eventdetails.model.e eVar = this.Q;
        if (eVar == null) {
            return null;
        }
        return eVar.h;
    }

    public void n(String str) {
        this.e = str;
    }

    public String o() {
        return this.G;
    }

    public void p(String str) {
        this.o = str;
    }

    public void q(String str) {
        this.i = str;
    }

    public void r(String str) {
        this.D = str;
    }

    public void s(String str) {
        this.c = str;
    }

    public void t(String str) {
        this.d = str;
    }

    public String toString() {
        return "BNRCEventDetailsModel{mOutlineDataBuild=" + this.f8068a + ", eType=" + this.b + ", eIcon='" + this.c + "', eTitle='" + this.d + "', showTime='" + this.e + "', eventPosition='" + this.f + "', eventPic='" + this.g + "', misc='" + this.h + "', user='" + this.i + "', useful=" + this.j + ", useless=" + this.k + ", voted=" + this.l + ", userReport='" + this.m + "', awayFrom='" + this.n + "', timeInterval='" + this.o + "', content='" + this.p + "', roadName='" + this.q + "', label=" + Arrays.toString(this.r) + ", supplement='" + this.s + "', commentsCount=" + this.t + ", subContent=" + this.u + ", sources=" + Arrays.toString(this.v) + ", detailId=" + this.w + ", videoInfoOnLine=" + this.x + ", mCommentsDataBuild=" + this.y + ", eventIdPlainText=" + this.z + ", lastCommentId=" + this.A + ", name='" + this.B + "', point='" + this.C + "', userPoint='" + this.D + "', picPath='" + this.E + "', uploadingPicPathList=" + this.F + ", input='" + this.G + "', rcInfo='" + this.H + "', etaInfo='" + this.I + "', congestionTime='" + this.J + "', hasJamedTime='" + this.K + "', sugWord='" + this.L + "', laneTagData=" + this.M + ", detailTagData=" + this.N + ", realisticImgUrl='" + this.O + "', videoInfo=" + this.P + ", commentsData=" + this.Q + ", newCommentNum=" + this.R + ", showType=" + this.S + ", subType=" + this.T + ", detailPics=" + Arrays.toString(this.U) + ", poiName='" + this.V + "', mDetailImgAndVideoList=" + this.W + ", roomId=" + this.X + ", roomGuide='" + this.Y + "', liveUrl='" + this.Z + "', liveInfo='" + this.a0 + "', labelLane='" + this.b0 + "', labelDetail='" + this.c0 + "', platform='" + this.d0 + "'}";
    }

    public String u() {
        return this.E;
    }

    public String v() {
        return this.C;
    }

    public String w() {
        return this.H;
    }

    public String x() {
        return this.O;
    }

    public String y() {
        return this.q;
    }

    public String z() {
        String str;
        if (!TextUtils.isEmpty(this.q)) {
            str = this.q;
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(this.n)) {
            if (TextUtils.isEmpty(str)) {
                return this.n;
            }
            return str + " · " + this.n;
        }
        return str;
    }

    public static c u(String str) {
        c cVar = new c();
        try {
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (a(new JSONObject(str), false, cVar, null)) {
            return cVar;
        }
        return null;
    }

    private static String[] v(String str) {
        if (str == null || str.length() <= 2) {
            return null;
        }
        String[] split = str.substring(1, str.length() - 1).split(",");
        if (split.length >= 1) {
            split[0] = split[0].replace("\"", "");
        }
        if (split.length >= 2) {
            split[1] = split[1].replace("\"", "");
        }
        if (TextUtils.isEmpty(split[0]) && TextUtils.isEmpty(split[1])) {
            return null;
        }
        return (split.length <= 1 || TextUtils.isEmpty(split[1])) ? new String[]{split[0]} : split;
    }

    public void b(String str) {
        if (str == null) {
            return;
        }
        this.F.remove(str);
    }

    public void c(String str) {
        this.n = str;
    }

    public void d(int i) {
        this.k = i;
    }

    public b e() {
        return this.y;
    }

    public void f(int i) {
        this.b = i;
    }

    public long h() {
        return this.w;
    }

    public ArrayList<g> i() {
        return this.W;
    }

    public String j() {
        return this.I;
    }

    public void k(String str) {
        this.H = str;
    }

    public void l(String str) {
        this.O = str;
    }

    public void m(String str) {
        this.q = str;
    }

    public String n() {
        com.baidu.navisdk.ugc.eventdetails.model.e eVar = this.Q;
        if (eVar != null) {
            return eVar.g;
        }
        return null;
    }

    public void o(String str) {
        this.s = str;
    }

    public String[] p() {
        return this.r;
    }

    public long q() {
        return this.A;
    }

    public g r() {
        ArrayList<g> arrayList = this.W;
        if (arrayList == null) {
            return null;
        }
        Iterator<g> it = arrayList.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next.d() == 1) {
                return next;
            }
        }
        return null;
    }

    public String s() {
        return this.B;
    }

    public C0375c t() {
        return this.f8068a;
    }

    /* loaded from: classes8.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public String f8071a;
        public int b = 0;
        public String c;

        public void a(d dVar) {
            if (dVar == null) {
                return;
            }
            this.b = dVar.b;
            this.c = dVar.c;
            this.f8071a = dVar.f8071a;
        }

        @DrawableRes
        public int b() {
            int i = this.b;
            if (i != 1) {
                if (i != 2) {
                    return 0;
                }
                return R.drawable.nsdk_ugc_detail_user_level_2;
            }
            return R.drawable.nsdk_ugc_detail_user_level_1;
        }

        public boolean c() {
            return TextUtils.isEmpty(this.f8071a);
        }

        public String toString() {
            return "Source{name='" + this.f8071a + "', level=" + this.b + ", supplement='" + this.c + "'}";
        }

        public void a() {
            this.b = 0;
            this.c = null;
            this.f8071a = null;
        }
    }

    public void b(int i) {
        this.t = i;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_EventDetails", "setCommentsCount: " + i);
        }
    }

    public void c(int i) {
        this.j = i;
    }

    public int d() {
        return this.t;
    }

    public void e(String str) {
        this.I = str;
    }

    public void f(String str) {
        this.g = str;
    }

    public String b() {
        com.baidu.navisdk.ugc.eventdetails.model.e eVar = this.Q;
        if (eVar == null || eVar.e <= 0) {
            return "0";
        }
        return this.Q.e + "";
    }

    public void b(int i, String str) {
        if (i != -1 && !TextUtils.isEmpty(str)) {
            if (this.M == null) {
                this.M = new com.baidu.navisdk.ugc.quickinput.tags.b();
            }
            com.baidu.navisdk.ugc.quickinput.tags.b bVar = this.M;
            bVar.f8231a = str;
            bVar.b = i;
            return;
        }
        this.M = null;
    }

    public void g(String str) {
        this.G = str;
    }

    public boolean a(JSONObject jSONObject, boolean z) {
        ArrayList<e.a> arrayList;
        if (jSONObject == null) {
            return false;
        }
        if (this.Q == null) {
            this.Q = new com.baidu.navisdk.ugc.eventdetails.model.e();
        }
        boolean a2 = this.Q.a(jSONObject, z);
        if (a2 && (arrayList = this.Q.j) != null && arrayList.size() > 0) {
            e.a aVar = this.Q.j.get(r0.size() - 1);
            if (aVar != null) {
                this.A = aVar.i;
            }
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d()) {
                StringBuilder sb = new StringBuilder();
                sb.append("parseAddComments: last --> ");
                sb.append(aVar != null ? aVar.toString() : "null");
                gVar.e("UgcModule_EventDetails", sb.toString());
            }
        }
        if (a2) {
            this.t = this.Q.f8074a;
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.UGC;
        if (gVar2.d()) {
            gVar2.e("UgcModule_EventDetails", "parseAddComments result:  " + a2 + ", commentsCount: " + this.t);
        }
        return a2;
    }

    public void a(e.a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.Q == null) {
            this.Q = new com.baidu.navisdk.ugc.eventdetails.model.e();
        }
        com.baidu.navisdk.ugc.eventdetails.model.e eVar = this.Q;
        if (eVar.j == null) {
            eVar.j = new ArrayList<>(8);
        }
        this.Q.j.add(0, aVar);
    }

    public void a(String[] strArr) {
        this.r = strArr;
    }

    public void a(C0375c c0375c) {
        this.f8068a = c0375c;
    }

    public void a(b bVar) {
        this.y = bVar;
    }

    public void a(String str) {
        if (this.F == null) {
            this.F = new ArrayList<>();
        }
        this.F.add(str);
    }

    public void a(e eVar) {
        this.u = eVar;
    }

    public void a(d[] dVarArr) {
        this.v = dVarArr;
    }

    public void a(long j) {
        this.w = j;
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                this.L = String.format("|%s", str);
                return;
            } else {
                this.L = String.format("%s|%s", str2, str);
                return;
            }
        }
        this.L = null;
    }

    public void a(String str, String str2, int i) {
        if (this.P == null) {
            this.P = new e.b();
        }
        e.b bVar = this.P;
        bVar.e = bVar.b;
        bVar.d = bVar.f8076a;
        bVar.f8076a = str;
        bVar.b = str2;
        bVar.c = i;
    }

    public void a(int i, String str) {
        if (i != -1 && !TextUtils.isEmpty(str)) {
            if (this.N == null) {
                this.N = new com.baidu.navisdk.ugc.quickinput.tags.b();
            }
            com.baidu.navisdk.ugc.quickinput.tags.b bVar = this.N;
            bVar.f8231a = str;
            bVar.b = i;
            return;
        }
        this.N = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x03a1 A[Catch: JSONException -> 0x00a3, TryCatch #0 {JSONException -> 0x00a3, blocks: (B:171:0x00a6, B:173:0x00b6, B:14:0x00c1, B:16:0x00cc, B:17:0x00d3, B:20:0x00e2, B:23:0x0104, B:26:0x0148, B:28:0x014e, B:29:0x0155, B:31:0x015b, B:32:0x0162, B:34:0x0168, B:35:0x016f, B:38:0x0179, B:40:0x017f, B:42:0x0185, B:44:0x018e, B:46:0x019d, B:47:0x01a8, B:49:0x01ae, B:50:0x01ba, B:52:0x01c0, B:54:0x01c6, B:59:0x01cf, B:60:0x01d2, B:62:0x01d8, B:63:0x01df, B:65:0x01e5, B:67:0x01eb, B:69:0x01f6, B:70:0x01fc, B:72:0x0204, B:73:0x020a, B:75:0x0212, B:76:0x0218, B:78:0x0220, B:79:0x0226, B:80:0x0229, B:82:0x0231, B:83:0x0238, B:85:0x0241, B:87:0x0245, B:88:0x024c, B:90:0x0255, B:91:0x0274, B:94:0x0282, B:96:0x0288, B:97:0x028b, B:99:0x029c, B:101:0x02a4, B:103:0x02aa, B:104:0x02b3, B:106:0x02b9, B:108:0x02c4, B:110:0x02ce, B:112:0x02d6, B:113:0x02de, B:115:0x02e8, B:116:0x02ed, B:119:0x02f7, B:123:0x039b, B:125:0x03a1, B:127:0x03a9, B:128:0x03c1, B:129:0x03c7, B:131:0x03cf, B:133:0x03d7, B:134:0x03ef, B:135:0x03f5, B:138:0x0302, B:140:0x030f, B:142:0x0315, B:145:0x031c, B:147:0x0322, B:149:0x0348, B:151:0x034e, B:153:0x0354, B:156:0x035b, B:158:0x0361, B:160:0x0388, B:162:0x0390, B:165:0x0145, B:166:0x0100, B:167:0x00de, B:176:0x007d, B:178:0x0088, B:169:0x0065, B:25:0x0111), top: B:11:0x0063, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x03cf A[Catch: JSONException -> 0x00a3, TryCatch #0 {JSONException -> 0x00a3, blocks: (B:171:0x00a6, B:173:0x00b6, B:14:0x00c1, B:16:0x00cc, B:17:0x00d3, B:20:0x00e2, B:23:0x0104, B:26:0x0148, B:28:0x014e, B:29:0x0155, B:31:0x015b, B:32:0x0162, B:34:0x0168, B:35:0x016f, B:38:0x0179, B:40:0x017f, B:42:0x0185, B:44:0x018e, B:46:0x019d, B:47:0x01a8, B:49:0x01ae, B:50:0x01ba, B:52:0x01c0, B:54:0x01c6, B:59:0x01cf, B:60:0x01d2, B:62:0x01d8, B:63:0x01df, B:65:0x01e5, B:67:0x01eb, B:69:0x01f6, B:70:0x01fc, B:72:0x0204, B:73:0x020a, B:75:0x0212, B:76:0x0218, B:78:0x0220, B:79:0x0226, B:80:0x0229, B:82:0x0231, B:83:0x0238, B:85:0x0241, B:87:0x0245, B:88:0x024c, B:90:0x0255, B:91:0x0274, B:94:0x0282, B:96:0x0288, B:97:0x028b, B:99:0x029c, B:101:0x02a4, B:103:0x02aa, B:104:0x02b3, B:106:0x02b9, B:108:0x02c4, B:110:0x02ce, B:112:0x02d6, B:113:0x02de, B:115:0x02e8, B:116:0x02ed, B:119:0x02f7, B:123:0x039b, B:125:0x03a1, B:127:0x03a9, B:128:0x03c1, B:129:0x03c7, B:131:0x03cf, B:133:0x03d7, B:134:0x03ef, B:135:0x03f5, B:138:0x0302, B:140:0x030f, B:142:0x0315, B:145:0x031c, B:147:0x0322, B:149:0x0348, B:151:0x034e, B:153:0x0354, B:156:0x035b, B:158:0x0361, B:160:0x0388, B:162:0x0390, B:165:0x0145, B:166:0x0100, B:167:0x00de, B:176:0x007d, B:178:0x0088, B:169:0x0065, B:25:0x0111), top: B:11:0x0063, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(org.json.JSONObject r25, boolean r26, com.baidu.navisdk.ugc.eventdetails.model.c r27, com.baidu.navisdk.ugc.eventdetails.model.a r28) {
        /*
            Method dump skipped, instructions count: 1076
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ugc.eventdetails.model.c.a(org.json.JSONObject, boolean, com.baidu.navisdk.ugc.eventdetails.model.c, com.baidu.navisdk.ugc.eventdetails.model.a):boolean");
    }

    public String a(int i) {
        String str = null;
        if (!TextUtils.isEmpty(this.b0)) {
            if (!TextUtils.isEmpty(this.c0)) {
                return this.b0 + this.c0;
            }
            if (i != 110) {
                if (i != 3101) {
                    switch (i) {
                        case 102:
                            str = "事故";
                            break;
                        case 103:
                            str = "管制";
                            break;
                    }
                }
                str = "拥堵";
            } else {
                str = "施工";
            }
            return this.b0 + str;
        }
        if (TextUtils.isEmpty(this.c0)) {
            return null;
        }
        return this.c0;
    }
}
