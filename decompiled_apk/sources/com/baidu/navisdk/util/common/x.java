package com.baidu.navisdk.util.common;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;

/* loaded from: classes8.dex */
public class x {
    public static void a(int i, boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("NaviUtils", "setXDWakeupEnable: " + z);
        }
        com.baidu.navisdk.framework.interfaces.pronavi.b h = com.baidu.navisdk.framework.interfaces.c.p().h();
        com.baidu.navisdk.framework.interfaces.pronavi.i C = h != null ? h.C() : null;
        if (C != null) {
            C.a(i, z);
        }
    }

    public static String b() {
        String str;
        com.baidu.navisdk.framework.interfaces.pronavi.i i = i();
        if (i != null) {
            str = i.h();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_sg_cur_road_word);
        }
        return str;
    }

    public static com.baidu.navisdk.framework.interfaces.diyspeak.b c() {
        com.baidu.navisdk.framework.interfaces.diyspeak.a g = com.baidu.navisdk.framework.interfaces.c.p().g();
        if (g != null) {
            return g.C();
        }
        return null;
    }

    public static int d() {
        com.baidu.navisdk.framework.interfaces.pronavi.i iVar;
        com.baidu.navisdk.framework.interfaces.pronavi.b h = com.baidu.navisdk.framework.interfaces.c.p().h();
        if (h != null) {
            iVar = h.C();
        } else {
            iVar = null;
        }
        if (iVar != null) {
            return iVar.x();
        }
        return 0;
    }

    public static int e() {
        com.baidu.navisdk.framework.interfaces.pronavi.i iVar;
        com.baidu.navisdk.framework.interfaces.pronavi.b h = com.baidu.navisdk.framework.interfaces.c.p().h();
        if (h != null) {
            iVar = h.C();
        } else {
            iVar = null;
        }
        if (iVar != null) {
            return iVar.t();
        }
        return 0;
    }

    @Nullable
    public static ViewGroup f() {
        com.baidu.navisdk.framework.interfaces.pronavi.n b0;
        com.baidu.navisdk.framework.interfaces.pronavi.b h = com.baidu.navisdk.framework.interfaces.c.p().h();
        if (h == null || (b0 = h.b0()) == null) {
            return null;
        }
        return b0.i();
    }

    public static int g() {
        com.baidu.navisdk.framework.interfaces.diyspeak.b c = c();
        if (c != null) {
            return c.c();
        }
        return -1;
    }

    public static boolean h() {
        com.baidu.navisdk.framework.interfaces.pronavi.i iVar;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("NaviUtils", "getWakeUpEnable: ");
        }
        com.baidu.navisdk.framework.interfaces.pronavi.b h = com.baidu.navisdk.framework.interfaces.c.p().h();
        if (h != null) {
            iVar = h.C();
        } else {
            iVar = null;
        }
        if (iVar != null) {
            return iVar.j();
        }
        return true;
    }

    @Nullable
    public static com.baidu.navisdk.framework.interfaces.pronavi.i i() {
        com.baidu.navisdk.framework.interfaces.pronavi.b h = com.baidu.navisdk.framework.interfaces.c.p().h();
        if (h != null) {
            return h.C();
        }
        return null;
    }

    @Nullable
    public static Activity j() {
        com.baidu.navisdk.framework.interfaces.pronavi.i iVar;
        com.baidu.navisdk.framework.interfaces.pronavi.b h = com.baidu.navisdk.framework.interfaces.c.p().h();
        if (h != null) {
            iVar = h.C();
        } else {
            iVar = null;
        }
        if (iVar == null) {
            return null;
        }
        return iVar.b();
    }

    @Nullable
    public static Bundle k() {
        com.baidu.navisdk.framework.interfaces.pronavi.i iVar;
        com.baidu.navisdk.framework.interfaces.pronavi.b h = com.baidu.navisdk.framework.interfaces.c.p().h();
        if (h != null) {
            iVar = h.C();
        } else {
            iVar = null;
        }
        if (iVar == null) {
            return null;
        }
        return iVar.r();
    }

    public static int l() {
        com.baidu.navisdk.framework.interfaces.pronavi.i iVar;
        com.baidu.navisdk.framework.interfaces.pronavi.b h = com.baidu.navisdk.framework.interfaces.c.p().h();
        if (h != null) {
            iVar = h.C();
        } else {
            iVar = null;
        }
        if (iVar != null) {
            return iVar.f();
        }
        return 1;
    }

    @Nullable
    public static Bundle m() {
        com.baidu.navisdk.framework.interfaces.pronavi.i iVar;
        com.baidu.navisdk.framework.interfaces.pronavi.b h = com.baidu.navisdk.framework.interfaces.c.p().h();
        if (h != null) {
            iVar = h.C();
        } else {
            iVar = null;
        }
        if (iVar == null) {
            return null;
        }
        return iVar.s();
    }

    @Nullable
    public static com.baidu.navisdk.framework.interfaces.pronavi.n n() {
        com.baidu.navisdk.framework.interfaces.pronavi.b h = com.baidu.navisdk.framework.interfaces.c.p().h();
        if (h != null) {
            return h.b0();
        }
        return null;
    }

    @Nullable
    public static com.baidu.navisdk.framework.interfaces.pronavi.k o() {
        com.baidu.navisdk.framework.interfaces.pronavi.i iVar;
        com.baidu.navisdk.framework.interfaces.pronavi.b h = com.baidu.navisdk.framework.interfaces.c.p().h();
        if (h != null) {
            iVar = h.C();
        } else {
            iVar = null;
        }
        if (iVar == null) {
            return null;
        }
        return iVar.A();
    }

    @Nullable
    public static com.baidu.navisdk.framework.interfaces.pronavi.m p() {
        com.baidu.navisdk.framework.interfaces.pronavi.i iVar;
        com.baidu.navisdk.framework.interfaces.pronavi.b h = com.baidu.navisdk.framework.interfaces.c.p().h();
        if (h != null) {
            iVar = h.C();
        } else {
            iVar = null;
        }
        if (iVar == null) {
            return null;
        }
        return iVar.z();
    }

    public static boolean q() {
        com.baidu.navisdk.framework.interfaces.pronavi.i i = i();
        if (i != null && i.m()) {
            return true;
        }
        return false;
    }

    public static boolean r() {
        com.baidu.navisdk.framework.interfaces.pronavi.i iVar;
        com.baidu.navisdk.framework.interfaces.pronavi.b h = com.baidu.navisdk.framework.interfaces.c.p().h();
        if (h != null) {
            iVar = h.C();
        } else {
            iVar = null;
        }
        if (iVar != null) {
            return iVar.p();
        }
        return false;
    }

    public static boolean s() {
        if (2 == com.baidu.navisdk.module.pronavi.a.j) {
            return true;
        }
        return false;
    }

    public static boolean t() {
        com.baidu.navisdk.framework.interfaces.pronavi.b h = com.baidu.navisdk.framework.interfaces.c.p().h();
        if (h != null && h.x0()) {
            return true;
        }
        return false;
    }

    public static boolean u() {
        com.baidu.navisdk.framework.interfaces.pronavi.b h = com.baidu.navisdk.framework.interfaces.c.p().h();
        if (h != null && h.y0()) {
            return true;
        }
        return false;
    }

    public static boolean v() {
        com.baidu.navisdk.framework.interfaces.pronavi.i iVar;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("NaviUtils", "closeWakeupTemporary: ");
        }
        com.baidu.navisdk.framework.interfaces.pronavi.b h = com.baidu.navisdk.framework.interfaces.c.p().h();
        if (h != null) {
            iVar = h.C();
        } else {
            iVar = null;
        }
        if (iVar != null) {
            return iVar.C();
        }
        return false;
    }

    public static boolean w() {
        com.baidu.navisdk.framework.interfaces.pronavi.i i = i();
        if (i != null && i.B()) {
            return true;
        }
        return false;
    }

    public static boolean x() {
        com.baidu.navisdk.framework.interfaces.pronavi.i iVar;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("NaviUtils", "isWakeEnable: ");
        }
        com.baidu.navisdk.framework.interfaces.pronavi.b h = com.baidu.navisdk.framework.interfaces.c.p().h();
        if (h != null) {
            iVar = h.C();
        } else {
            iVar = null;
        }
        if (iVar != null) {
            return iVar.a();
        }
        return true;
    }

    public static void a(boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("NaviUtils", "setXDControlEnableByPowerSave: " + z);
        }
        com.baidu.navisdk.framework.interfaces.pronavi.b h = com.baidu.navisdk.framework.interfaces.c.p().h();
        com.baidu.navisdk.framework.interfaces.pronavi.i C = h != null ? h.C() : null;
        if (C != null) {
            C.b(z);
        }
    }

    public static void a() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("NaviUtils", "closeWakeupTemporary: ");
        }
        com.baidu.navisdk.framework.interfaces.pronavi.b h = com.baidu.navisdk.framework.interfaces.c.p().h();
        com.baidu.navisdk.framework.interfaces.pronavi.i C = h != null ? h.C() : null;
        if (C != null) {
            C.u();
        }
    }
}
