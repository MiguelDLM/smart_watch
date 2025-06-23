package com.baidu.navisdk.model.datastruct.chargestation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.util.common.o;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.collections.OxI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class b implements Serializable {

    @OOXIXo
    public static final C0210b B = new C0210b(null);
    private boolean A;

    /* renamed from: a, reason: collision with root package name */
    @oOoXoXO
    private String f6906a;

    @oOoXoXO
    private String b;

    @oOoXoXO
    private String c;

    @oOoXoXO
    private String d;
    private int h;

    @oOoXoXO
    private com.baidu.navisdk.model.datastruct.b i;

    @oOoXoXO
    private com.baidu.nplatform.comapi.basestruct.c j;

    @oOoXoXO
    private GeoPoint k;
    private boolean m;
    private int n;

    @oOoXoXO
    private String r;
    private int u;
    private boolean v;
    private boolean w;
    private boolean y;

    @OOXIXo
    private final ArrayList<d> e = new ArrayList<>();

    @OOXIXo
    private final ArrayList<Object> f = new ArrayList<>();
    private int g = -2;
    private int l = -1;

    @OOXIXo
    private final ArrayList<String> o = new ArrayList<>();
    private int p = -1;

    @OOXIXo
    private final c q = new c();

    @OOXIXo
    private final e s = new e();

    @OOXIXo
    private a t = new a();
    private boolean x = true;
    private int z = -1;

    /* loaded from: classes7.dex */
    public static final class a implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        private int f6907a = -1;
        private int b = -1;

        /* renamed from: com.baidu.navisdk.model.datastruct.chargestation.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C0209a {
            private C0209a() {
            }

            public /* synthetic */ C0209a(IIXOooo iIXOooo) {
                this();
            }
        }

        static {
            new C0209a(null);
        }

        public final void a(int i) {
            this.f6907a = i;
        }

        @OOXIXo
        public String toString() {
            return "ApertureInfo(radius=" + this.f6907a + ", patternId=" + this.b + HexStringBuilder.COMMENT_END_CHAR;
        }
    }

    /* renamed from: com.baidu.navisdk.model.datastruct.chargestation.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0210b {
        private C0210b() {
        }

        @oOoXoXO
        public final b a(@oOoXoXO Bundle bundle) {
            boolean z;
            if (bundle != null) {
                b bVar = new b();
                bVar.c(bundle.getString("uid", ""));
                bVar.b(bundle.getString("next_cs_uid", ""));
                bVar.a(bundle.getString("name", ""));
                bVar.f(bundle.getInt("recommend_flag", -1));
                bVar.c(bundle.getInt("group_no", -2));
                boolean z2 = false;
                if (bundle.getInt("wayp_flag", 0) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                bVar.a(z);
                bVar.b(bundle.getInt("extend_flag", 0));
                String[] extendArray = bundle.getStringArray("extend_info");
                if (extendArray != null) {
                    ArrayList<String> f = bVar.f();
                    IIX0o.oO(extendArray, "extendArray");
                    OxI.xxIO(f, extendArray);
                }
                bVar.e(bundle.getInt("state_flag", 0));
                bVar.b(bundle.getBoolean("rp_state_show", false));
                bVar.c(bundle.getBoolean("navi_state_show", false));
                bVar.b().a(bundle.getInt("aperture_radius", -1));
                c d = bVar.d();
                d.i(bundle.getInt("icon_id", -1));
                d.a(bundle.getInt("detour_distance", -1));
                d.b(bundle.getInt("detour_time", -1));
                d.c(bundle.getInt("distance_from_me", -1));
                d.h(bundle.getInt("time_from_me", -1));
                d.e(bundle.getInt("fast_total", -1));
                d.d(bundle.getInt("fast_free", -1));
                d.g(bundle.getInt("slow_total", -1));
                d.f(bundle.getInt("slow_free", -1));
                d.b(bundle.getString("panel_label", ""));
                d.a(bundle.getString("panel_content", ""));
                e o = bVar.o();
                o.a(bundle.getInt("charge_power", -1));
                o.b(bundle.getInt("fast_charge_power", -1));
                o.c(bundle.getInt("slow_charge_power", -1));
                bVar.a(bundle.getInt(RouteGuideParams.RGKey.ExpandMap.AddDistance, -1));
                bVar.d(bundle.getInt("link_idx", -1));
                bVar.a(new com.baidu.nplatform.comapi.basestruct.c(bundle.getDouble("pointX", XIXIX.OOXIXo.f3760XO), bundle.getDouble("pointY", XIXIX.OOXIXo.f3760XO)));
                com.baidu.nplatform.comapi.basestruct.c m = bVar.m();
                if (m != null) {
                    Bundle b = o.b(m.c(), m.d());
                    bVar.a(new GeoPoint(b.getInt("LLx", Integer.MIN_VALUE), b.getInt("LLy", Integer.MIN_VALUE)));
                }
                if (bVar.n() == 1) {
                    z2 = true;
                }
                bVar.d(z2);
                return bVar;
            }
            return null;
        }

        public /* synthetic */ C0210b(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        private int f6908a = -1;
        private int b = -1;
        private int c = -1;
        private int d = -1;
        private int e = -1;
        private int f = -1;
        private int g = -1;
        private int h = -1;
        private int i = -1;

        @oOoXoXO
        private String j;

        @oOoXoXO
        private String k;

        /* loaded from: classes7.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(IIXOooo iIXOooo) {
                this();
            }
        }

        static {
            new a(null);
        }

        public final void a(int i) {
            this.b = i;
        }

        public final void b(int i) {
            this.d = i;
        }

        public final void c(int i) {
            this.c = i;
        }

        public final void d(int i) {
            this.g = i;
        }

        public final void e(int i) {
            this.f = i;
        }

        public final int f() {
            return this.i;
        }

        public final int g() {
            return this.h;
        }

        public final int h() {
            return this.e;
        }

        public final int i() {
            return this.f6908a;
        }

        @OOXIXo
        public String toString() {
            return "DynamicInfo(waterDropId=" + this.f6908a + ", detourDistance=" + this.b + ", distanceFromMe=" + this.c + ", detourTime=" + this.d + ", timeFromMe=" + this.e + ", fastTotal=" + this.f + ", fastFree=" + this.g + ", slowTotal=" + this.h + ", slowFree=" + this.i + ", panelContent=" + this.j + ", panelLabel=" + this.k + HexStringBuilder.COMMENT_END_CHAR;
        }

        public final int a() {
            return this.c;
        }

        public final int b() {
            return this.g;
        }

        public final int c() {
            return this.f;
        }

        @oOoXoXO
        public final String d() {
            return this.j;
        }

        @oOoXoXO
        public final String e() {
            return this.k;
        }

        public final void f(int i) {
            this.i = i;
        }

        public final void g(int i) {
            this.h = i;
        }

        public final void h(int i) {
            this.e = i;
        }

        public final void i(int i) {
            this.f6908a = i;
        }

        public final void a(@oOoXoXO String str) {
            this.j = str;
        }

        public final void b(@oOoXoXO String str) {
            this.k = str;
        }
    }

    /* loaded from: classes7.dex */
    public static final class d implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        @oOoXoXO
        private String f6909a;
        private int b;

        /* loaded from: classes7.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(IIXOooo iIXOooo) {
                this();
            }
        }

        static {
            new a(null);
        }

        public final int a() {
            return this.b;
        }

        @oOoXoXO
        public final String b() {
            return this.f6909a;
        }

        @OOXIXo
        public String toString() {
            return "Label(text=" + this.f6909a + ", hlStatus=" + this.b + HexStringBuilder.COMMENT_END_CHAR;
        }
    }

    /* loaded from: classes7.dex */
    public static final class e implements Serializable {

        @oOoXoXO
        private String l;

        @oOoXoXO
        private String m;

        /* renamed from: a, reason: collision with root package name */
        private int f6910a = -1;
        private int b = -1;
        private int c = -1;
        private int d = -1;
        private float e = -1.0f;
        private float f = -1.0f;
        private float g = -1.0f;
        private float h = -1.0f;
        private float i = -1.0f;
        private int j = -1;
        private int k = -1;
        private int n = -1;
        private int o = -1;

        /* loaded from: classes7.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(IIXOooo iIXOooo) {
                this();
            }
        }

        static {
            new a(null);
        }

        public final void a(int i) {
            this.b = i;
        }

        public final int b() {
            return this.b;
        }

        public final void c(int i) {
            this.d = i;
        }

        public final int d() {
            return this.c;
        }

        public final float e() {
            return this.i;
        }

        public final float f() {
            return this.g;
        }

        public final int g() {
            return this.d;
        }

        @OOXIXo
        public String toString() {
            return "StaticInfo(chargeTime=" + this.f6910a + ", chargePower=" + this.b + ", fastChargePower=" + this.c + ", slowChargePower=" + this.d + ", chargeFee=" + this.e + ", fastChargeFee=" + this.f + ", slowChargeFee=" + this.g + ", serviceFee=" + this.h + ", parkFee=" + this.i + ", openTimeStart=" + this.j + ", openTimeEnd=" + this.k + ", usageRate=" + this.l + ", usageNum=" + this.m + ", preDistance=" + this.n + ", passDistance=" + this.o + HexStringBuilder.COMMENT_END_CHAR;
        }

        public final float a() {
            return this.e;
        }

        public final void b(int i) {
            this.c = i;
        }

        public final float c() {
            return this.f;
        }
    }

    public final void a(@oOoXoXO String str) {
        this.b = str;
    }

    public final void b(int i) {
        this.n = i;
    }

    public final void c(@oOoXoXO String str) {
        this.f6906a = str;
    }

    public final void d(int i) {
        this.p = i;
    }

    public final int e() {
        return this.n;
    }

    public final void f(int i) {
        this.h = i;
    }

    @oOoXoXO
    public final GeoPoint g() {
        return this.k;
    }

    public final int h() {
        return this.g;
    }

    @OOXIXo
    public final ArrayList<d> i() {
        return this.e;
    }

    @oOoXoXO
    public final String j() {
        return this.b;
    }

    public final int k() {
        return this.u;
    }

    @oOoXoXO
    public final String l() {
        return this.r;
    }

    @oOoXoXO
    public final com.baidu.nplatform.comapi.basestruct.c m() {
        return this.j;
    }

    public final int n() {
        return this.h;
    }

    @OOXIXo
    public final e o() {
        return this.s;
    }

    @oOoXoXO
    public final String p() {
        return this.f6906a;
    }

    public final boolean q() {
        return this.m;
    }

    public final boolean r() {
        return this.v;
    }

    public final boolean s() {
        int i = this.n;
        if (i != 4 && i != 5) {
            return false;
        }
        return true;
    }

    public final boolean t() {
        return this.x;
    }

    @OOXIXo
    public String toString() {
        return "CsInfo(uid=" + this.f6906a + ", name=" + this.b + ", distance=" + this.c + ", time=" + this.d + ", labels=" + this.e + ", details=" + this.f + ", groupId=" + this.g + ", recommendFlag=" + this.h + ", mapGData=" + this.i + ", point=" + this.j + ", geoPoint=" + this.k + ", addDist=" + this.l + ", isApproach=" + this.m + ", extendFlag=" + this.n + ", extendInfo=" + this.o + ", linkIdx=" + this.p + ", dynamicInfo=" + this.q + ", nextUid=" + this.r + ", staticInfo=" + this.s + ", apertureInfo=" + this.t + ", navStateFlag=" + this.u + ", isB4NavStateShow=" + this.v + ", isNavStateShow=" + this.w + ", isRecGroup=" + this.x + ", isRecommend=" + this.y + HexStringBuilder.COMMENT_END_CHAR;
    }

    public final boolean u() {
        return this.A;
    }

    public final void a(@oOoXoXO com.baidu.nplatform.comapi.basestruct.c cVar) {
        this.j = cVar;
    }

    public final void b(@oOoXoXO String str) {
        this.r = str;
    }

    public final void c(int i) {
        this.g = i;
    }

    @OOXIXo
    public final c d() {
        return this.q;
    }

    public final void e(int i) {
        this.u = i;
    }

    @OOXIXo
    public final ArrayList<String> f() {
        return this.o;
    }

    public final void a(@oOoXoXO GeoPoint geoPoint) {
        this.k = geoPoint;
    }

    @OOXIXo
    public final a b() {
        return this.t;
    }

    public final void c(boolean z) {
        this.w = z;
    }

    public final void d(boolean z) {
        this.y = z;
    }

    public final int a() {
        return this.l;
    }

    public final void b(boolean z) {
        this.v = z;
    }

    public final int c() {
        return this.z;
    }

    public final void a(int i) {
        this.l = i;
    }

    public final void a(boolean z) {
        this.m = z;
    }
}
