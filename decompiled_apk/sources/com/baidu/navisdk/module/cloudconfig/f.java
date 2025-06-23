package com.baidu.navisdk.module.cloudconfig;

import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class f {
    private static volatile f V;
    public o0 F;
    public n0 b;
    public j c;
    public u j;
    private z k;
    private com.baidu.navisdk.module.voice.a t;

    /* renamed from: a, reason: collision with root package name */
    public a0 f7101a = null;
    public e d = null;
    public w0 e = null;
    public o f = null;
    public m g = null;
    public d h = null;
    public y i = new y();
    public k0 l = null;
    public k0 m = null;
    public k0 n = null;
    public boolean o = false;
    public final h0 r = new h0();
    public w u = new w();
    public com.baidu.navisdk.module.cloudconfig.c v = new com.baidu.navisdk.module.cloudconfig.c();
    public C0238f x = new C0238f();
    public b0 y = new b0();
    public s z = new s();
    public i0 A = new i0();
    public l0 B = new l0();
    public final e0 D = new e0();
    public final f0 E = new f0();
    public final r G = new r();
    public final l H = new l();
    public final v I = new v();
    public final v0 J = new v0();
    public final i K = new i();
    public final n L = new n();
    public final m0 M = new m0();
    public final g0 N = new g0();
    public final a O = new a();
    public final d0 P = new d0();
    public final x0 Q = new x0();
    public final com.baidu.navisdk.module.cloudconfig.config.a R = new com.baidu.navisdk.module.cloudconfig.config.a();
    public final com.baidu.navisdk.module.cloudconfig.config.b S = new com.baidu.navisdk.module.cloudconfig.config.b();
    public final HashMap<Integer, u0> T = new HashMap<>();
    public final j0 U = new j0();
    public final t p = new t();
    public final c0 q = new c0();
    public final q0 s = new q0();
    public final s0 w = new s0();
    public c C = new c();

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final HashMap<String, b> f7102a = new HashMap<>();
    }

    /* loaded from: classes7.dex */
    public static class a0 {

        /* renamed from: a, reason: collision with root package name */
        private boolean f7103a;
        private int[] b;
        private int c;
        private int d;

        public a0(boolean z, int[] iArr, int i, int i2) {
            this.b = iArr;
            this.f7103a = z;
            this.c = i;
            this.d = i2;
        }

        public int a() {
            return this.c;
        }

        public int b() {
            return this.d;
        }

        public int[] c() {
            return this.b;
        }

        public boolean d() {
            return this.f7103a;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f7104a;
        public String b;
        public String c;
        public int d;
        public boolean e = false;

        public boolean a() {
            if (!TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.c)) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes7.dex */
    public static class b0 {

        /* renamed from: a, reason: collision with root package name */
        public boolean f7105a = false;
        public ArrayList<String> b;

        public b0() {
            ArrayList<String> arrayList = new ArrayList<>();
            this.b = arrayList;
            arrayList.add("语音通话中");
            this.b.add("视频通话中");
        }
    }

    /* loaded from: classes7.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String[] f7106a;
        public String[] b;
        public String[] c;
    }

    /* loaded from: classes7.dex */
    public static class c0 {

        /* renamed from: a, reason: collision with root package name */
        public boolean f7107a = false;
        public String b = "29";
        public boolean c = false;
        public String d = "29";
        public boolean e = true;
        public boolean f = true;
        public boolean g = true;
    }

    /* loaded from: classes7.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private int f7108a;
        private int b;
        private int c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;
        private int j;

        public void a(int i) {
            this.b = i;
        }

        public void b(int i) {
            this.c = i;
        }

        public void c(int i) {
            this.d = i;
        }

        public void d(int i) {
            this.g = i;
        }

        public void e(int i) {
            this.h = i;
        }

        public void f(int i) {
            this.i = i;
        }

        public void g(int i) {
            this.j = i;
        }

        public void h(int i) {
            this.f7108a = i;
        }

        public void i(int i) {
            this.e = i;
        }

        public void j(int i) {
            this.f = i;
        }

        public String toString() {
            return "BNRRLocationRefreshConfig{time=" + this.f7108a + ", distance=" + this.b + ", gps2gps_0=" + this.c + ", gps2gps_1=" + this.d + ", wifi2gps_0=" + this.e + ", wifi2gps_1=" + this.f + ", station2gps_0=" + this.g + ", station2gps_1=" + this.h + ", station2wifi_0=" + this.i + ", station2wifi_1=" + this.j + '}';
        }
    }

    /* loaded from: classes7.dex */
    public static class d0 {

        /* renamed from: a, reason: collision with root package name */
        public boolean f7109a = false;
        public boolean b = false;
    }

    /* loaded from: classes7.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public boolean f7110a;
        public int[] b;
        public int[] c;

        public e(int i, JSONArray jSONArray, JSONArray jSONArray2) throws Exception {
            this.f7110a = true;
            this.b = null;
            this.c = null;
            if (com.baidu.navisdk.j.c()) {
                this.f7110a = false;
            } else {
                this.f7110a = i == 1;
            }
            this.b = a(jSONArray);
            this.c = a(jSONArray2);
        }

        private int[] a(JSONArray jSONArray) throws Exception {
            int[] iArr = new int[3];
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            if (jSONArray == null) {
                return iArr;
            }
            for (int i = 0; i < 3; i++) {
                try {
                    iArr[i] = (int) (jSONArray.getDouble(i) * 255.0d);
                } catch (Exception e) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.printException("BrightnessConfig", e);
                    }
                    throw e;
                }
            }
            return iArr;
        }
    }

    /* loaded from: classes7.dex */
    public static class e0 {

        /* renamed from: a, reason: collision with root package name */
        public boolean f7111a;
        public String b;
    }

    /* renamed from: com.baidu.navisdk.module.cloudconfig.f$f, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0238f {

        /* renamed from: a, reason: collision with root package name */
        public int f7112a;
    }

    /* loaded from: classes7.dex */
    public static class f0 {

        /* renamed from: a, reason: collision with root package name */
        public int f7113a;
        public int b;
        public String c;
        public String d;
    }

    /* loaded from: classes7.dex */
    public static class g {
        public g(String str, String str2, int i, String str3) {
        }
    }

    /* loaded from: classes7.dex */
    public static class g0 {

        /* renamed from: a, reason: collision with root package name */
        public int f7114a;
        public int b;
        public String c;
    }

    /* loaded from: classes7.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public boolean f7115a;
        public String b;
        public String c;

        public void a(boolean z, String str, String str2) {
            this.f7115a = z;
            this.b = str;
            this.c = str2;
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_RESULT;
            if (gVar.d()) {
                gVar.e("ChallengeModeH5Item", "update:" + this);
            }
        }

        public String toString() {
            return "{\"enable\":" + this.f7115a + ",\"url\":\"" + this.b + "\",\"debugUrl\":\"" + this.c + "\"}";
        }
    }

    /* loaded from: classes7.dex */
    public static class h0 {

        /* renamed from: a, reason: collision with root package name */
        public boolean f7116a = true;
        public boolean b = true;
    }

    /* loaded from: classes7.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        public String f7117a;
        public Map<String, List<String>> b;
        public Map<Pair<Integer, Integer>, Integer> c;
        public int d;
        List<p> e = new CopyOnWriteArrayList();

        public i() {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            this.c = linkedHashMap;
            linkedHashMap.put(new Pair(1, 3), 2);
            this.c.put(new Pair<>(4, 20), 6);
            this.c.put(new Pair<>(21, 49), 5);
            this.c.put(new Pair<>(50, 999999), 4);
            this.b = new LinkedHashMap();
            ArrayList arrayList = new ArrayList();
            arrayList.add("哪个车道");
            arrayList.add("严不严重");
            arrayList.add("拍一张看看");
            arrayList.add("交警在处理吗");
            arrayList.add("堵了多长了");
            arrayList.add("还要堵多久");
            arrayList.add("谁知道最新情况");
            arrayList.add("为什么堵住了");
            arrayList.add("封路了吗");
            arrayList.add("施工多久");
            arrayList.add("还能走吗");
            this.b.put("求助", arrayList);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add("车流量大");
            arrayList2.add("发生事故");
            arrayList2.add("马上通了");
            arrayList2.add("左侧车道");
            arrayList2.add("中间车道");
            arrayList2.add("右侧车道");
            arrayList2.add("不可通行");
            arrayList2.add("交通管制");
            arrayList2.add("道路施工");
            arrayList2.add("剐蹭了");
            arrayList2.add("追尾了");
            arrayList2.add("封路了");
            this.b.put("说说", arrayList2);
        }
    }

    /* loaded from: classes7.dex */
    public static class i0 {

        /* renamed from: a, reason: collision with root package name */
        public boolean f7118a = true;
    }

    /* loaded from: classes7.dex */
    public static class j {
        public boolean U;
        public int X;

        /* renamed from: a, reason: collision with root package name */
        public String f7119a;
        public int a0;
        public boolean b;
        public boolean c;
        public int d;
        public boolean d0;
        public int e;
        public boolean e0;
        public boolean f;
        public boolean g;
        public String g0;
        public boolean h;
        public boolean i0;
        public boolean j;
        public String m;
        public String n;
        public boolean n0;
        public String o;
        public String p;
        public boolean q;
        public String r;
        public String s;
        public String t;
        public String u;
        public int w;
        public boolean z;
        public boolean i = true;
        public String k = null;
        public boolean l = true;
        public int v = 0;
        public boolean x = false;
        public int y = -1;
        public boolean A = false;
        public boolean B = false;
        public boolean C = false;
        public boolean D = true;
        public double E = 0.8d;
        public int F = 3000;
        public int G = 6;
        public boolean H = true;
        public String I = null;
        public boolean J = false;
        public boolean K = false;
        public boolean L = true;
        public boolean M = true;
        public boolean N = true;
        public int O = 1;
        public boolean P = false;
        public boolean Q = false;
        public boolean R = false;
        public boolean S = true;
        public boolean T = true;
        public String V = null;
        public int W = -1;
        public int Y = 0;
        public int Z = 0;
        public JSONObject b0 = null;
        public String c0 = null;
        public boolean f0 = false;
        public boolean h0 = false;
        public boolean j0 = true;
        public boolean k0 = true;
        public boolean l0 = false;
        public int m0 = 60;

        /* renamed from: o0, reason: collision with root package name */
        public boolean f7120o0 = false;
        public int p0 = 120;
        public boolean q0 = false;
    }

    /* loaded from: classes7.dex */
    public static class j0 {

        /* renamed from: a, reason: collision with root package name */
        public boolean f7121a = true;
        public boolean b = false;
        public boolean c = true;
        public String d = "https://lbsnavi.cdn.bcebos.com/base/online/20220322151141/nhd_car.zip";
    }

    /* loaded from: classes7.dex */
    public static class k {

        /* renamed from: a, reason: collision with root package name */
        public static String f7122a = "";
        public static String b = "";
        public static String c = "";
        public static boolean d = true;
        public static boolean e = true;
        public static String f = com.baidu.navisdk.util.http.b.d().b("commuteResultH5Page");
    }

    /* loaded from: classes7.dex */
    public static class k0 {

        /* renamed from: a, reason: collision with root package name */
        public long f7123a;
        public JSONObject b;
        public boolean c;

        public String toString() {
            return "OperateBtnConfig{updateTime=" + this.f7123a + ", data=" + this.b + ", isUpdated=" + this.c + '}';
        }
    }

    /* loaded from: classes7.dex */
    public static class l {

        /* renamed from: a, reason: collision with root package name */
        public String f7124a;
        public String b;
        public String c;
        public String d;
        public String e;
    }

    /* loaded from: classes7.dex */
    public static class l0 {

        /* renamed from: a, reason: collision with root package name */
        boolean f7125a = true;
        List<String> b = new ArrayList();
        List<String> c = new ArrayList();
        List<String> d = new ArrayList();
        int e = 26;
        int f = -1;
        String g = "10";
        String h = "11";
        int i = 1;

        private boolean b() {
            String d = com.baidu.navisdk.util.common.q.d();
            if (!TextUtils.isEmpty(d)) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.MAP;
                if (gVar.d()) {
                    gVar.e("kpkkikkpk", "emui version = " + d);
                }
                if (d.startsWith("EmotionUI_")) {
                    d = d.replace("EmotionUI_", "");
                }
                if (com.baidu.navisdk.j.a(d, this.g) >= 0 && com.baidu.navisdk.j.a(d, this.h) < 0) {
                    if (gVar.d()) {
                        gVar.e("kpkkikkpk", "emui match");
                        return true;
                    }
                    return true;
                }
                return false;
            }
            return false;
        }

        private boolean c() {
            if (!this.f7125a) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.MAP;
                if (gVar.d()) {
                    gVar.e("kpkkikkpk", "cloud open no");
                }
                return false;
            }
            int i = Build.VERSION.SDK_INT;
            if (i < this.e) {
                com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.MAP;
                if (gVar2.d()) {
                    gVar2.e("kpkkikkpk", "cloud api no");
                }
                return false;
            }
            int i2 = this.f;
            if (i2 != -1 && i > i2) {
                com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.MAP;
                if (gVar3.d()) {
                    gVar3.e("kpkkikkpk", "cloud api no");
                }
                return false;
            }
            if (this.b.contains(Build.MODEL)) {
                com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.MAP;
                if (gVar4.d()) {
                    gVar4.e("kpkkikkpk", "model no");
                }
                return false;
            }
            if (this.c.contains(Build.BRAND)) {
                com.baidu.navisdk.util.common.g gVar5 = com.baidu.navisdk.util.common.g.MAP;
                if (gVar5.d()) {
                    gVar5.e("kpkkikkpk", "brand no");
                }
                return false;
            }
            if (this.i == 2 && b()) {
                return false;
            }
            return true;
        }

        private boolean d() {
            if (this.i == 1 && b()) {
                return true;
            }
            return this.d.contains(Build.MODEL);
        }

        public void a() {
            com.baidu.navisdk.module.cloudconfig.a.b().c("pip_open", c());
            com.baidu.navisdk.module.cloudconfig.a.b().c("pip_need_adjust", d());
        }
    }

    /* loaded from: classes7.dex */
    public static class m {
        public void a(boolean z) {
        }
    }

    /* loaded from: classes7.dex */
    public static class m0 {

        /* renamed from: a, reason: collision with root package name */
        public String f7126a;
        public String b;
    }

    /* loaded from: classes7.dex */
    public static class n {

        /* renamed from: a, reason: collision with root package name */
        public final HashMap<String, String> f7127a = new HashMap<>();
    }

    /* loaded from: classes7.dex */
    public static class n0 {
        public n0(String str, long j) {
        }
    }

    /* loaded from: classes7.dex */
    public static class o {

        /* renamed from: a, reason: collision with root package name */
        public boolean f7128a = false;
        public boolean b = false;
        public JSONArray c = null;
    }

    /* loaded from: classes7.dex */
    public static class o0 {

        /* renamed from: a, reason: collision with root package name */
        public boolean f7129a = false;
        public String b = "路线互助";
        public String c = "";
    }

    /* loaded from: classes7.dex */
    public static class p {
    }

    /* loaded from: classes7.dex */
    public static class p0 {

        /* renamed from: a, reason: collision with root package name */
        public static boolean f7130a = true;
        public static String b;
        public static String c;
    }

    /* loaded from: classes7.dex */
    public static class q {

        /* renamed from: a, reason: collision with root package name */
        private static boolean f7131a = true;
        private static String b;

        public static void a(boolean z) {
            f7131a = z;
        }

        public static boolean b() {
            return f7131a;
        }

        public static void a(String str) {
            b = str;
        }

        public static String a() {
            return TextUtils.isEmpty(b) ? "心中有数" : b;
        }
    }

    /* loaded from: classes7.dex */
    public static class q0 {

        /* renamed from: a, reason: collision with root package name */
        public String f7132a = "点击车标即可切换3D车标";
        public int b = 3;
        public int c = 24;
        public boolean d = true;
    }

    /* loaded from: classes7.dex */
    public static class r {

        /* renamed from: a, reason: collision with root package name */
        public String f7133a;
        public ArrayList<String> b = new ArrayList<>();
    }

    /* loaded from: classes7.dex */
    public static class r0 {

        /* renamed from: a, reason: collision with root package name */
        public static int f7134a = 50;
        public static String b;
    }

    /* loaded from: classes7.dex */
    public static class s {

        /* renamed from: a, reason: collision with root package name */
        public boolean f7135a;
    }

    /* loaded from: classes7.dex */
    public static class s0 {
        public boolean h;
        public String i;
        public boolean j;

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList<g> f7136a = new ArrayList<>();
        public final h b = new h();
        public final h c = new h();
        public final h d = new h();
        public final h e = new h();
        public final x f = new x();
        public final x g = new x();
        public boolean k = false;
        public String l = "";
    }

    /* loaded from: classes7.dex */
    public static class t {

        /* renamed from: a, reason: collision with root package name */
        public boolean f7137a = false;
        public boolean b = true;
        public boolean c;
        public boolean d;
    }

    /* loaded from: classes7.dex */
    public static class t0 {

        /* renamed from: a, reason: collision with root package name */
        public String f7138a;
    }

    /* loaded from: classes7.dex */
    public static class u {
        public void a(JSONObject jSONObject) {
        }
    }

    /* loaded from: classes7.dex */
    public static class u0 {

        /* renamed from: a, reason: collision with root package name */
        public List<t0> f7139a;
    }

    /* loaded from: classes7.dex */
    public static class v {

        /* renamed from: a, reason: collision with root package name */
        public int f7140a = 2;
        public boolean b = true;
        public boolean c = false;
        public boolean d = true;
        public boolean e = true;
        public final SparseArray<String> f;

        public v() {
            SparseArray<String> sparseArray = new SparseArray<>(16);
            this.f = sparseArray;
            sparseArray.append(5, "https://lbsnavi.cdn.bcebos.com/base/online/20220322151141/nhd_car.zip");
            sparseArray.append(6, "https://lbsnavi.cdn.bcebos.com/base/online/20210322111759/guide2103.zip");
            sparseArray.append(9, "https://lbsnavi.cdn.bcebos.com/base/online/20210512181603/camera.zip");
            sparseArray.append(13, "https://lbsnavi.cdn.bcebos.com/base/online/20210817170651/warningSign.zip");
            sparseArray.append(10, "https://lbsnavi.cdn.bcebos.com/base/online/20210817170516/accident.zip");
            sparseArray.append(11, "https://lbsnavi.cdn.bcebos.com/base/online/20210817170552/construction.zip");
            sparseArray.append(12, "https://lbsnavi.cdn.bcebos.com/base/online/20210817170619/trafficControl.zip");
            sparseArray.append(14, "https://lbsnavi.cdn.bcebos.com/base/online/20220902145648/fhd_guide_arrow.zip");
        }
    }

    /* loaded from: classes7.dex */
    public static class v0 {

        /* renamed from: a, reason: collision with root package name */
        public String f7141a;
        public Map<String, List<String>> b;
        public Map<Pair<Integer, Integer>, Integer> c;
        public int d = 60;
        List<p> e = new CopyOnWriteArrayList();

        public v0() {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            this.c = linkedHashMap;
            linkedHashMap.put(new Pair(1, 3), 2);
            this.c.put(new Pair<>(4, 20), 6);
            this.c.put(new Pair<>(21, 49), 5);
            this.c.put(new Pair<>(50, 999999), 4);
            this.b = new LinkedHashMap();
            ArrayList arrayList = new ArrayList();
            arrayList.add("哪个车道");
            arrayList.add("严不严重");
            arrayList.add("拍一张看看");
            arrayList.add("交警在处理吗");
            arrayList.add("堵了多长了");
            arrayList.add("还要堵多久");
            arrayList.add("谁知道最新情况");
            arrayList.add("为什么堵住了");
            arrayList.add("封路了吗");
            arrayList.add("施工多久");
            arrayList.add("还能走吗");
            this.b.put("求助", arrayList);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add("车流量大");
            arrayList2.add("发生事故");
            arrayList2.add("马上通了");
            arrayList2.add("左侧车道");
            arrayList2.add("中间车道");
            arrayList2.add("右侧车道");
            arrayList2.add("不可通行");
            arrayList2.add("交通管制");
            arrayList2.add("道路施工");
            arrayList2.add("剐蹭了");
            arrayList2.add("追尾了");
            arrayList2.add("封路了");
            this.b.put("说说", arrayList2);
        }

        public boolean a() {
            return com.baidu.navisdk.module.cloudconfig.a.b().a("ugc_chat_enable", true);
        }
    }

    /* loaded from: classes7.dex */
    public static class w extends com.baidu.navisdk.module.cloudconfig.c {
    }

    /* loaded from: classes7.dex */
    public static class w0 {

        /* renamed from: a, reason: collision with root package name */
        public boolean f7142a = true;
        public boolean b = true;
        public boolean c = false;
        public int d = 3;
        public float e = 30.0f;
        public float f = 15.0f;
        public float g = 0.0015f;
        public float h = 0.0015f;
        public String[] i = null;
    }

    /* loaded from: classes7.dex */
    public static class x {
        public void a(String str, String str2) {
        }
    }

    /* loaded from: classes7.dex */
    public static class x0 {

        /* renamed from: a, reason: collision with root package name */
        public boolean f7143a = true;
        public float b = 0.8f;
    }

    /* loaded from: classes7.dex */
    public static class y {

        /* renamed from: a, reason: collision with root package name */
        public int f7144a;
        public int b;
        public int c;
        public int d;
    }

    /* loaded from: classes7.dex */
    public static class z {
        public static boolean j = false;

        /* renamed from: a, reason: collision with root package name */
        a f7145a;
        HashMap<String, a> b;
        double c;
        boolean d;
        boolean e;
        boolean f;
        boolean g;
        boolean h;
        String i;

        /* loaded from: classes7.dex */
        public static class a {
        }

        public void a(String str, a aVar) {
            if (this.b == null) {
                this.b = new HashMap<>();
            }
            this.b.put(str, aVar);
        }
    }

    private f() {
        this.c = null;
        this.F = null;
        this.c = new j();
        this.F = new o0();
    }

    public static f c() {
        if (V == null) {
            synchronized (f.class) {
                try {
                    if (V == null) {
                        V = new f();
                    }
                } finally {
                }
            }
        }
        return V;
    }

    public z a() {
        if (this.k == null) {
            this.k = new z();
        }
        return this.k;
    }

    public com.baidu.navisdk.module.voice.a b() {
        return this.t;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.getInt("open") == 1) {
                    String string = jSONObject.getString("url");
                    String string2 = jSONObject.getString(com.huawei.openalliance.ad.constant.x.cD);
                    String string3 = jSONObject.getString("title");
                    String string4 = jSONObject.getString("subtitle");
                    String string5 = jSONObject.getString("vid");
                    String string6 = jSONObject.getString("name");
                    int i2 = jSONObject.getInt("show_sec");
                    int i3 = jSONObject.getInt("threshold");
                    String string7 = jSONObject.getString("recommend_download_list");
                    String string8 = jSONObject.getString("recommend_use_list");
                    com.baidu.navisdk.module.voice.a aVar = new com.baidu.navisdk.module.voice.a();
                    this.t = aVar;
                    aVar.c(string);
                    this.t.d(string2);
                    this.t.e(string3);
                    this.t.g(string4);
                    this.t.h(string5);
                    this.t.f(string6);
                    this.t.a(i2);
                    this.t.b(i3);
                    this.t.a(string7);
                    this.t.b(string8);
                } else {
                    this.t = null;
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
