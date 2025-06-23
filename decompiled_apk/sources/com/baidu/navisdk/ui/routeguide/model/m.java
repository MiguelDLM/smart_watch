package com.baidu.navisdk.ui.routeguide.model;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.util.common.l0;

/* loaded from: classes8.dex */
public class m {
    private static m w;

    /* renamed from: a, reason: collision with root package name */
    private boolean f8951a = false;
    private String b = null;
    private String c = null;
    private String d = null;
    private String[] e = null;
    private String f = null;
    private int g = -1;
    private int h = -1;
    private int i = -1;
    private String j = null;
    private int k = -1;
    private String l = null;
    private int m = -1;
    private String n = "";
    private int o = -1;
    private Bundle p = new Bundle();
    private boolean q = true;
    private String r = null;
    private boolean s = false;
    private boolean t = true;
    private int u = 0;
    private int v;

    private m() {
    }

    public static m y() {
        if (w == null) {
            w = new m();
        }
        return w;
    }

    private void z() {
        int i;
        if (!this.s) {
            if (this.v <= 0 && (i = this.g) >= 20000) {
                this.v = i;
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e(RGFSMTable.FsmState.Highway, "满足20公里，开始计算行驶路程");
                }
            }
            int i2 = this.v;
            if (i2 != 0) {
                if (i2 - this.g >= 2000) {
                    this.s = true;
                    com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar2.d()) {
                        gVar2.e(RGFSMTable.FsmState.Highway, "满足条件，mini面板允许显示");
                    }
                }
                com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar3.d()) {
                    gVar3.e(RGFSMTable.FsmState.Highway, "已经行走" + (this.v - this.g) + "米");
                }
            }
        }
        if (this.v != 0 && this.g < 18000) {
            this.v = 0;
            com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar4.d()) {
                gVar4.e(RGFSMTable.FsmState.Highway, "离下一机动点路程小于18km mDriveDistance = 0");
            }
        }
    }

    public void a(Bundle bundle) {
        if (bundle == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHighwayModel", "updateData=null");
                return;
            }
            return;
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e("RGHighwayModel", "updateData=" + bundle);
        }
        this.c = bundle.getString(RouteGuideParams.RGKey.HighWayInfo.ExitIC);
        this.d = bundle.getString(RouteGuideParams.RGKey.HighWayInfo.ExitICCode);
        if (gVar2.d()) {
            gVar2.e("tanglianghui", "updateData: exitCode = " + this.d);
        }
        String str = this.d;
        if (str != null && str.trim().length() == 0) {
            this.d = null;
        }
        Bundle bundle2 = this.p;
        String str2 = this.d;
        if (str2 == null) {
            str2 = "";
        }
        bundle2.putString(RouteGuideParams.RGKey.HighWayInfo.ExitICCode, str2);
        String string = bundle.getString(RouteGuideParams.RGKey.HighWayInfo.ExitDirectionName, "");
        if (string != null && string.trim().length() > 0) {
            this.e = string.trim().split(",");
        } else {
            this.e = null;
        }
        this.p.putString(RouteGuideParams.RGKey.HighWayInfo.ExitDirectionName, string);
        String string2 = bundle.getString(RouteGuideParams.RGKey.HighWayInfo.ExitNextRoadName, "");
        this.f = string2;
        this.p.putString(RouteGuideParams.RGKey.HighWayInfo.ExitNextRoadName, string2);
        int i = bundle.getInt(RouteGuideParams.RGKey.HighWayInfo.ExitRemainDist, -1);
        this.g = i;
        if (i >= 0) {
            this.p.putInt(RouteGuideParams.RGKey.HighWayInfo.ExitRemainDist, i);
        }
        this.h = bundle.getInt(RouteGuideParams.RGKey.HighWayInfo.HIGHWAY_EXIT_GP_ADD_DIST, -1);
        if (gVar2.d()) {
            gVar2.e("RGHighwayModel", "updateData: " + this.h);
        }
        int i2 = this.h;
        if (i2 >= 0) {
            this.p.putInt(RouteGuideParams.RGKey.HighWayInfo.HIGHWAY_EXIT_GP_ADD_DIST, i2);
        } else {
            this.h = this.g + BNRouteGuider.getInstance().getAddDist();
        }
        bundle.getInt(RouteGuideParams.RGKey.HighWayInfo.ExitTotalDist, -1);
        this.i = bundle.getInt(RouteGuideParams.RGKey.HighWayInfo.ExitDirection, -1);
        bundle.getString(RouteGuideParams.RGKey.HighWayInfo.NextExitIC);
        String string3 = bundle.getString(RouteGuideParams.RGKey.HighWayInfo.NextExitDirectionName);
        if (string3 != null && string3.trim().length() > 0) {
            string3.trim().split(",");
        }
        bundle.getInt(RouteGuideParams.RGKey.HighWayInfo.NextExitRemainDist, -1);
        this.j = null;
        if (bundle.containsKey(RouteGuideParams.RGKey.HighWayInfo.ServiceName)) {
            this.j = bundle.getString(RouteGuideParams.RGKey.HighWayInfo.ServiceName);
        }
        this.k = bundle.getInt(RouteGuideParams.RGKey.HighWayInfo.ServiceRemainDist, -1);
        this.l = null;
        if (bundle.containsKey(RouteGuideParams.RGKey.HighWayInfo.NextServiceName)) {
            this.l = bundle.getString(RouteGuideParams.RGKey.HighWayInfo.NextServiceName);
        }
        this.m = bundle.getInt(RouteGuideParams.RGKey.HighWayInfo.NextServiceRemainDist, -1);
        com.baidu.navisdk.framework.interfaces.k k = com.baidu.navisdk.framework.interfaces.c.p().k();
        if (k != null) {
            k.a(this.j, this.k, this.l, this.m);
        }
        this.n = null;
        if (bundle.containsKey(RouteGuideParams.RGKey.HighWayInfo.NextGateName)) {
            this.n = bundle.getString(RouteGuideParams.RGKey.HighWayInfo.NextGateName);
        }
        this.o = bundle.getInt(RouteGuideParams.RGKey.HighWayInfo.NextGateRemainDist, -1);
        bundle.getInt(RouteGuideParams.RGKey.HighWayInfo.NextGateTotalDist, -1);
        boolean z = bundle.getInt(RouteGuideParams.RGKey.HighWayInfo.HideInfo, 1) != 1;
        this.q = z;
        this.p.putBoolean(RouteGuideParams.RGKey.HighWayInfo.HideInfo, z);
        this.r = bundle.getString(RouteGuideParams.RGKey.HighWayInfo.CurRoadName);
        if (com.baidu.navisdk.ui.routeguide.utils.b.x() && com.baidu.navisdk.function.b.FUNC_SUPPORT_HIGHWAY_MINI_PANEL.a()) {
            z();
        } else {
            x();
        }
        if (gVar2.d()) {
            gVar2.e("tanglianghui", "updateData: exitIcCode = " + this.p.getString(RouteGuideParams.RGKey.HighWayInfo.ExitICCode));
        }
    }

    public boolean b(int i) {
        return i == 1 || i == 8 || i == 2;
    }

    public int c() {
        return this.u;
    }

    public void d(int i) {
    }

    public String[] e() {
        String[] strArr = this.e;
        if (strArr != null && strArr.length > 0) {
            return strArr;
        }
        if (!TextUtils.isEmpty(this.f)) {
            return new String[]{this.f};
        }
        return null;
    }

    public int f() {
        return this.h;
    }

    public String g() {
        return this.c;
    }

    public int h() {
        return this.g;
    }

    public int i() {
        return this.i;
    }

    public String j() {
        if (this.g >= 0) {
            StringBuilder sb = new StringBuilder();
            l0.a(this.g, l0.a.ZH, sb);
            return b(sb.toString());
        }
        return "";
    }

    public String k() {
        return this.n;
    }

    public int l() {
        return this.o;
    }

    public boolean m() {
        return this.s;
    }

    public Bundle n() {
        return this.p;
    }

    public String o() {
        return this.l;
    }

    public int p() {
        return this.m;
    }

    public String q() {
        return this.j;
    }

    public int r() {
        return this.k;
    }

    public boolean s() {
        String str = this.d;
        if (str != null && str.length() > 0) {
            return true;
        }
        return false;
    }

    public boolean t() {
        return this.t;
    }

    public boolean u() {
        return this.f8951a;
    }

    public boolean v() {
        return this.q;
    }

    public void w() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHighwayModel", "reset");
        }
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = null;
        this.k = -1;
        this.l = null;
        this.m = -1;
        this.n = "";
        this.o = -1;
        this.f8951a = false;
        x();
    }

    public void x() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGHighwayModel", "resetMiniPanelData");
        }
        this.v = 0;
        this.s = false;
        this.t = true;
        this.u = 0;
    }

    public void b(boolean z) {
        this.f8951a = z;
        if (z) {
            return;
        }
        x();
    }

    public void c(int i) {
        this.u = i;
    }

    public String d() {
        String str = this.d;
        return str == null ? "" : str;
    }

    public void b(Bundle bundle) {
        if (bundle == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGHighwayModel", "updateEntryData=null");
            }
            this.b = null;
            return;
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e("RGHighwayModel", "updateEntryData=" + bundle.toString());
        }
        this.b = bundle.getString("highway_in_roadname");
        bundle.getInt("highway_in_remain_dist");
    }

    private String b(String str) {
        if (l0.c(str)) {
            return str;
        }
        if (str.endsWith(".0公里")) {
            return str.replace(".0公里", "公里");
        }
        return str.endsWith(".0km") ? str.replace(".0km", "km") : str;
    }

    public String b() {
        return this.r;
    }

    public void a(boolean z) {
        this.t = z;
    }

    public Drawable a(int i, boolean z) {
        if (i == 1) {
            return com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_drawable_rg_highway_straight_arrow);
        }
        if (i == 2) {
            return com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_drawable_rg_highway_right_arrow);
        }
        if (i != 8) {
            return null;
        }
        return com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_drawable_rg_highway_left_arrow);
    }

    public String a() {
        String[] e = y().e();
        if (e != null) {
            if (e.length < 1 || TextUtils.isEmpty(e[0])) {
                return null;
            }
            int length = e.length;
            StringBuilder sb = new StringBuilder(e[0]);
            for (int i = 1; i < length; i++) {
                sb.append(" ");
                sb.append(e[i]);
            }
            return sb.toString();
        }
        return null;
    }

    public String a(int i) {
        if (i == 0) {
            return this.b;
        }
        if (i == 1) {
            return this.n;
        }
        if (i == 2) {
            return this.j;
        }
        if (i == 3) {
            return this.l;
        }
        if (i != 4) {
            return null;
        }
        String[] e = e();
        if (e != null && e.length != 0) {
            String str = e()[0];
            for (int i2 = 1; i2 < e().length; i2++) {
                str = str + " " + e()[i2];
            }
            return str;
        }
        return this.f;
    }

    public void a(String str) {
        this.r = str;
    }
}
