package com.baidu.navisdk.ui.routeguide.model;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.ProNaviStatItem;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class a0 {
    public static boolean B;
    private static a0 z;
    private int d;
    private String j;
    private String k;
    public HashMap<String, Integer> l;
    private Map<String, String> m;
    private int v;
    private final k w;
    private boolean x;
    public static Bundle A = new Bundle();
    public static boolean C = false;
    public static boolean D = false;
    public static boolean E = false;
    public static boolean F = false;
    public static int G = 0;

    /* renamed from: a, reason: collision with root package name */
    private int f8928a = -1;
    private final Bundle b = new Bundle();
    private boolean c = false;
    private boolean e = false;
    private String f = "";
    private boolean g = false;
    private boolean h = false;
    private int i = 0;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;
    private boolean r = false;
    public boolean s = false;
    public boolean t = false;
    public boolean u = false;
    private boolean y = false;

    private a0() {
        int length = RouteGuideParams.gTurnIconName.length;
        this.l = new HashMap<>(length, 1.0f);
        for (int i = 0; i < length; i++) {
            this.l.put(RouteGuideParams.gTurnIconName[i], Integer.valueOf(com.baidu.navisdk.module.pronavi.constant.b.f7453a[i]));
        }
        this.j = "";
        this.k = "";
        this.w = new k();
    }

    public static a0 I() {
        if (z == null) {
            z = new a0();
        }
        return z;
    }

    public boolean A() {
        return this.x;
    }

    public boolean B() {
        int i;
        Bundle bundle = this.b;
        if (bundle != null && bundle.containsKey(RouteGuideParams.RGKey.SimpleGuideInfo.RemainDist)) {
            i = this.b.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.RemainDist);
        } else {
            i = -1;
        }
        return this.w.a(i);
    }

    public boolean C() {
        return this.g;
    }

    public boolean D() {
        return this.o;
    }

    public void E() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "reset");
        }
        G();
        F();
        this.y = false;
        this.g = false;
        this.o = false;
        this.q = false;
        this.n = false;
        this.r = false;
        this.c = false;
        this.e = false;
        this.j = "";
        this.k = "";
        C = false;
        E = false;
        D = false;
        this.i = 0;
        this.h = false;
        this.t = false;
        this.u = false;
        this.f8928a = -1;
        k kVar = this.w;
        if (kVar != null) {
            kVar.f();
        }
        Bundle bundle = A;
        if (bundle != null) {
            bundle.clear();
        }
        Bundle bundle2 = this.b;
        if (bundle2 != null) {
            bundle2.clear();
        }
        G = 0;
        this.f = "";
        this.x = false;
        com.baidu.navisdk.ui.routeguide.repository.b a2 = com.baidu.navisdk.ui.routeguide.b.V().i().a();
        if (a2 != null) {
            a2.e();
        }
    }

    public void F() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "resetTrafficLightsCount: ");
        }
        com.baidu.navisdk.ui.routeguide.repository.b a2 = com.baidu.navisdk.ui.routeguide.b.V().i().a();
        if (a2 != null) {
            a2.h();
        }
    }

    public void G() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide VIA_ETA", "resetViaEtaData()");
        }
        com.baidu.navisdk.ui.routeguide.repository.b a2 = com.baidu.navisdk.ui.routeguide.b.V().i().a();
        if (a2 != null) {
            a2.f();
        }
    }

    public Bundle H() {
        boolean z2;
        boolean z3 = true;
        this.b.putInt("updatetype", 1);
        String string = A.getString("road_name");
        String string2 = A.getString("icon_name");
        int i = A.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.RemainDist);
        int i2 = A.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.StartDist);
        boolean z4 = A.getBoolean("remain_dist_hide", false);
        this.y = z4;
        this.b.putBoolean("remain_dist_hide", z4);
        if (A.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.Straight, 0) > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.g = z2;
        this.b.putBoolean(RouteGuideParams.RGKey.SimpleGuideInfo.Straight, z2);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("test", "nextRoad = " + string);
        }
        this.l.get(RouteGuideParams.gTurnIconName[0]).intValue();
        if (string2 != null && this.l.containsKey(string2)) {
            if (gVar.d()) {
                gVar.e("RouteGuide", "updateGuideInfo==   iconName=" + string2);
            }
            this.b.putInt("resid", this.l.get(string2).intValue());
            this.b.putString("icon_name", string2);
            g(string2);
        }
        if (string != null) {
            if (string.contains(",")) {
                string = string.replace(",", " ");
            }
            this.b.putString("road_name", string);
        }
        String string3 = A.getString(RouteGuideParams.RGKey.SimpleGuideInfo.CurRoadName);
        if (string3 != null) {
            this.b.putString(RouteGuideParams.RGKey.SimpleGuideInfo.CurRoadName, string3);
        }
        this.b.putInt(RouteGuideParams.RGKey.SimpleGuideInfo.RemainDist, i);
        this.b.putInt(RouteGuideParams.RGKey.SimpleGuideInfo.StartDist, i2);
        this.w.a(A, this.l);
        this.b.putInt(RouteGuideParams.RGKey.SimpleGuideInfo.NextTurnKind, this.w.c());
        this.i = 0;
        if (A.containsKey(RouteGuideParams.RGKey.SimpleGuideInfo.TurnKind)) {
            this.i = A.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.TurnKind);
        }
        this.b.putInt(RouteGuideParams.RGKey.SimpleGuideInfo.TurnKind, this.i);
        this.h = false;
        if (A.containsKey(RouteGuideParams.RGKey.SimpleGuideInfo.isRightRudder)) {
            if (A.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.isRightRudder) != 1) {
                z3 = false;
            }
            this.h = z3;
        }
        String string4 = A.getString(RouteGuideParams.RGKey.SimpleGuideInfo.IndoorParkFloor);
        if (!TextUtils.isEmpty(string4)) {
            this.b.putString(RouteGuideParams.RGKey.SimpleGuideInfo.IndoorParkFloor, string4);
        }
        if (gVar.d()) {
            gVar.e("RouteGuide", "RGSimpleGuideModel.updateNextGuideInfo() mNextTurnKind=" + this.w + "， mTurnKind=" + this.i + ", floor=" + string4);
        }
        return this.b;
    }

    public void a(int i, int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide VIA_ETA", "updateClosestViaRemainDistanceAndTime -> closestViaRemainDistance = " + i + ", closestViaRemainTime = " + i2);
        }
        com.baidu.navisdk.ui.routeguide.repository.b a2 = com.baidu.navisdk.ui.routeguide.b.V().i().a();
        if (a2 != null) {
            a2.a(i, i2);
        }
    }

    public void b(int i) {
        this.f8928a = i;
    }

    public void c(int i) {
    }

    public a0 d(boolean z2) {
        this.p = z2;
        return this;
    }

    public int e(String str) {
        int intValue = (str == null || !this.l.containsKey(str)) ? -1 : this.l.get(str).intValue();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "getTurnIconRes() in=" + str + ", id=" + intValue);
        }
        return intValue;
    }

    public Drawable f() {
        Drawable drawable;
        int intValue;
        Bundle bundle = new Bundle();
        JNIGuidanceControl.getInstance().getFirstRouteGuideInfo(bundle);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "getFuzzyNextTurn - bundle : " + bundle);
        }
        String string = bundle.getString("icon_name", "turn_back.png");
        if (string == null || !this.l.containsKey(string) || (intValue = this.l.get(string).intValue()) == -1) {
            drawable = null;
        } else if (com.baidu.navisdk.ui.routeguide.subview.util.b.a()) {
            drawable = JarUtils.getResources().getDrawable(intValue);
        } else {
            drawable = com.baidu.navisdk.ui.routeguide.subview.util.b.a(intValue);
        }
        I().e().a(drawable, bundle.getString(RouteGuideParams.RGKey.SimpleGuideInfo.NextNextRoadName));
        return drawable;
    }

    public String g() {
        Bundle bundle = new Bundle();
        JNIGuidanceControl.getInstance().getFirstRouteGuideInfo(bundle);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "getFuzzyTV - bundle : " + bundle);
        }
        return bundle.getString(RouteGuideParams.RGKey.SimpleGuideInfo.PlanarName);
    }

    public Bundle h() {
        return this.b;
    }

    public boolean i() {
        return this.w.e();
    }

    public int j() {
        if (!this.c) {
            return 0;
        }
        return this.d;
    }

    public Bundle k() {
        com.baidu.navisdk.ui.routeguide.repository.b a2 = com.baidu.navisdk.ui.routeguide.b.V().i().a();
        if (a2 != null) {
            return a2.c().a();
        }
        return new Bundle();
    }

    public int l() {
        com.baidu.navisdk.ui.routeguide.repository.b a2 = com.baidu.navisdk.ui.routeguide.b.V().i().a();
        if (a2 != null) {
            return a2.c().f8945a;
        }
        return 0;
    }

    public int m() {
        com.baidu.navisdk.ui.routeguide.repository.b a2 = com.baidu.navisdk.ui.routeguide.b.V().i().a();
        if (a2 != null) {
            return a2.c().b;
        }
        return 0;
    }

    public String n() {
        com.baidu.navisdk.module.newguide.viewmodels.a b = com.baidu.navisdk.ui.routeguide.b.V().i().b();
        if (b != null) {
            return b.e();
        }
        return "";
    }

    public String o() {
        if (TextUtils.isEmpty(this.k)) {
            return "";
        }
        if (this.m == null) {
            int min = Math.min(RouteGuideParams.gTurnIconName.length, RouteGuideParams.gVoiceTurnTypeDesc.length);
            this.m = new HashMap(min, 1.0f);
            for (int i = 0; i < min; i++) {
                this.m.put(RouteGuideParams.gTurnIconName[i], RouteGuideParams.gVoiceTurnTypeDesc[i]);
            }
        }
        String string = this.b.getString("icon_name");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        return this.m.get(string);
    }

    public boolean p() {
        com.baidu.navisdk.ui.routeguide.repository.b a2 = com.baidu.navisdk.ui.routeguide.b.V().i().a();
        if (a2 != null && a2.d()) {
            return true;
        }
        return false;
    }

    public boolean q() {
        if (com.baidu.navisdk.module.pronavi.a.j == 2) {
            return false;
        }
        return this.e;
    }

    public boolean r() {
        return this.q;
    }

    public boolean s() {
        if (this.v == 1) {
            return true;
        }
        return false;
    }

    public boolean t() {
        if (com.baidu.navisdk.module.pronavi.a.j == 2) {
            return true;
        }
        return this.c;
    }

    public boolean u() {
        if (this.f8928a == 0) {
            return true;
        }
        return false;
    }

    public boolean v() {
        return this.r;
    }

    public boolean w() {
        return this.n;
    }

    public boolean x() {
        return this.p;
    }

    public boolean y() {
        return this.y;
    }

    public boolean z() {
        return this.h;
    }

    public String b() {
        com.baidu.navisdk.module.newguide.viewmodels.a b = com.baidu.navisdk.ui.routeguide.b.V().i().b();
        return b != null ? b.c() : "";
    }

    public int c() {
        return this.f8928a;
    }

    public Drawable d(String str) {
        int intValue = this.l.get(RouteGuideParams.gTurnIconName[0]).intValue();
        if (str != null && this.l.containsKey(str)) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RouteGuide", "updateGuideInfo==   iconName=" + str);
            }
            intValue = this.l.get(str).intValue();
        }
        return JarUtils.getResources().getDrawable(intValue);
    }

    public void h(boolean z2) {
        this.c = z2;
    }

    public void i(boolean z2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "随后-updateNextTurnVisible mNextTurnVisible = " + z2);
        }
        this.w.a(z2);
    }

    public Bundle c(int i, int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "updateTotalRemainDistAndTime() nDist=" + i + ", nTime=" + i2);
        }
        ProNaviStatItem.O().a(i);
        com.baidu.navisdk.ui.routeguide.repository.b a2 = com.baidu.navisdk.ui.routeguide.b.V().i().a();
        if (a2 != null) {
            a2.b(i, i2);
            return a2.c().a();
        }
        return new Bundle();
    }

    public String b(String str) {
        String replaceAll = str.replaceAll("\\s+", "");
        if (replaceAll == null) {
            return null;
        }
        if (replaceAll.endsWith("米")) {
            return replaceAll.substring(0, replaceAll.length() - 1);
        }
        if (replaceAll.endsWith("公里")) {
            return replaceAll.substring(0, replaceAll.length() - 2);
        }
        return null;
    }

    public String a() {
        String[] split;
        com.baidu.navisdk.module.newguide.viewmodels.a b = com.baidu.navisdk.ui.routeguide.b.V().i().b();
        String c = b != null ? b.c() : null;
        if (c != null && c.length() > 0 && (split = c.substring(0, 5).split(":")) != null && split.length >= 2) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(l0.a(Integer.parseInt(split[0])));
                stringBuffer.append("点");
                stringBuffer.append(l0.a(Integer.parseInt(split[1])));
                stringBuffer.append("分到达");
                return stringBuffer.toString();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public k e() {
        return this.w;
    }

    public void e(boolean z2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "setIsShowExitMainRoadGuide: " + z2);
        }
        this.x = z2;
    }

    public void g(boolean z2) {
        this.e = z2;
    }

    private void g(String str) {
        this.j = this.k;
        this.k = str;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "mLastIconName = " + this.j + ", mCurIconName = " + this.k);
        }
    }

    public void d(int i) {
        this.d = i;
    }

    public boolean b(boolean z2) {
        if (this.r == z2) {
            return false;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "setIsNaviReady :" + z2);
        }
        this.r = z2;
        return true;
    }

    public String d() {
        String str = this.f;
        if (str != null && str.length() != 0) {
            return this.f;
        }
        return com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_sg_cur_road_word);
    }

    public String c(String str) {
        return JarUtils.getResources().getString(R.string.nsdk_string_rg_sg_go_nextroad, str);
    }

    public void c(boolean z2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "setIsPreYawing = " + z2);
        }
        this.n = z2;
    }

    public void b(int i, int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "updateRemainTrafficLights desCount: " + i + ", viaCount: " + i2);
        }
        com.baidu.navisdk.ui.routeguide.repository.b a2 = com.baidu.navisdk.ui.routeguide.b.V().i().a();
        if (a2 != null) {
            a2.b(i);
            a2.a(i2);
        }
    }

    public void f(String str) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "engine updateRoadName --> " + str);
        }
        this.f = str;
    }

    public void f(boolean z2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "setIsYawing :" + z2);
        }
        this.o = z2;
    }

    public Bundle a(String str, int i, String str2, int i2, int i3, int i4, String str3) {
        try {
            this.b.putInt("updatetype", 1);
            int i5 = com.baidu.navisdk.module.pronavi.constant.b.f7453a[1];
            if (str != null && this.l.containsKey(str)) {
                i5 = this.l.get(str).intValue();
            }
            this.b.putInt("resid", i5);
            this.b.putString("icon_name", str);
            this.b.putInt(RouteGuideParams.RGKey.SimpleGuideInfo.RemainDist, i);
            if (str2 == null) {
                this.b.putString("road_name", "");
            } else {
                this.b.putString("road_name", str2);
            }
            this.b.putInt(RouteGuideParams.RGKey.SimpleGuideInfo.TurnKind, i4);
            if (!TextUtils.isEmpty(str3)) {
                this.b.putString(RouteGuideParams.RGKey.SimpleGuideInfo.IndoorParkFloor, str3);
            }
            c(i2, i3);
            A.putAll(k());
            A.putAll(this.b);
        } catch (Exception e) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RouteGuide", "getDataFromRouteResult err:" + e.getMessage());
            }
        }
        return A;
    }

    public Bundle a(String str, int i, String str2) {
        try {
            this.b.putInt("updatetype", 1);
            int i2 = com.baidu.navisdk.module.pronavi.constant.b.f7453a[1];
            if (str != null && this.l.containsKey(str)) {
                i2 = this.l.get(str).intValue();
            }
            this.b.putInt("resid", i2);
            this.b.putString("icon_name", str);
            this.b.putInt(RouteGuideParams.RGKey.SimpleGuideInfo.RemainDist, i);
            if (str2 == null) {
                this.b.putString("road_name", "");
            } else {
                this.b.putString("road_name", str2);
            }
            A.putAll(this.b);
            com.baidu.navisdk.framework.interfaces.k k = com.baidu.navisdk.framework.interfaces.c.p().k();
            if (k != null) {
                k.j(this.g);
            }
        } catch (Exception e) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RouteGuide", "updateNextGuiInfoOnly err:" + e.getMessage());
            }
        }
        return this.b;
    }

    public String a(int i) {
        StringBuilder sb = new StringBuilder();
        l0.a(i, l0.a.ZH, sb);
        return JarUtils.getResources().getString(R.string.nsdk_string_rg_sg_after_meters, sb);
    }

    public String a(String str) {
        String replaceAll = str.replaceAll("\\s+", "");
        if (replaceAll == null) {
            return null;
        }
        if (replaceAll.endsWith("米")) {
            return "米";
        }
        if (replaceAll.endsWith("公里")) {
            return "公里";
        }
        return null;
    }

    public void a(boolean z2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "setIsFakeYawing :" + z2);
        }
        this.q = z2;
    }

    public void a(Bundle bundle) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "setFirstRGInfo=" + bundle.toString());
        }
        this.v = 0;
        int i = bundle.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.TotalTime, 0);
        int i2 = bundle.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.TotalDist, 0);
        int i3 = bundle.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.RemainDist, 0);
        int i4 = bundle.getInt("resid", 0);
        String string = bundle.getString("icon_name", "turn_back.png");
        String string2 = bundle.getString("road_name");
        this.v = bundle.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.MatchMode, 0);
        if (A.containsKey(RouteGuideParams.RGKey.SimpleGuideInfo.TurnKind)) {
            this.i = A.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.TurnKind);
        }
        String string3 = A.getString(RouteGuideParams.RGKey.SimpleGuideInfo.IndoorParkFloor);
        if ((i4 <= 0 || i <= 0) && !s()) {
            return;
        }
        a(string, i3, string2, i2, i, this.i, string3);
        this.t = true;
    }
}
