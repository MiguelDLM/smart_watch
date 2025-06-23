package com.baidu.navisdk.ui.routeguide.subview.hud;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.asr.c;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.routeguide.model.l;
import com.baidu.navisdk.ui.routeguide.model.m;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class a extends com.baidu.navisdk.ui.routeguide.subview.b {

    /* renamed from: a, reason: collision with root package name */
    private b f9091a;

    /* renamed from: com.baidu.navisdk.ui.routeguide.subview.hud.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class DialogInterfaceOnDismissListenerC0475a implements DialogInterface.OnDismissListener {
        public DialogInterfaceOnDismissListenerC0475a(a aVar) {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            BNMapController.getInstance().onResume();
        }
    }

    public a(Activity activity, View view, boolean z) {
        this.f9091a = null;
        this.f9091a = new b(activity, R.style.HudDialog, z);
        f();
        this.f9091a.setOnDismissListener(new DialogInterfaceOnDismissListenerC0475a(this));
    }

    public void a(boolean z) {
        this.f9091a.d(z);
    }

    public void b() {
        b bVar = this.f9091a;
        if (bVar != null) {
            bVar.a();
            if (l.f().d()) {
                d();
            } else {
                f();
            }
        }
    }

    public void c() {
        com.baidu.navisdk.comapi.statistics.b.f().a(com.baidu.navisdk.framework.a.c().a(), "410283", "410283");
        this.f9091a.show();
        f();
        LogUtil.e(RGFSMTable.FsmState.HUD, "mHudDialog isShowing: " + this.f9091a.isShowing());
        BNMapController.getInstance().onPause();
        c.n().a();
    }

    public void d() {
        try {
            int i = com.baidu.navisdk.module.pronavi.a.j;
            if (i == 1 || i == 5) {
                this.f9091a.f(false);
            }
            if (l.f().d()) {
                LogUtil.e(RGFSMTable.FsmState.HUD, "showSuitableView-> isYaw()");
                this.f9091a.g(true);
                return;
            }
            this.f9091a.g(false);
            if (l.g()) {
                if (l.f().b()) {
                    b(false);
                    c(false);
                    this.f9091a.b(true);
                    this.f9091a.e(true);
                    return;
                }
                b(false);
                c(false);
                this.f9091a.b(true);
                this.f9091a.e(false);
                return;
            }
            if (l.f().c()) {
                b(true);
                c(false);
                this.f9091a.b(false);
            } else {
                b(false);
                c(true);
                this.f9091a.b(false);
            }
        } catch (Exception unused) {
        }
    }

    public void e() {
        this.f9091a.b();
    }

    public void f() {
        Bundle h;
        Bundle b;
        if (l.g()) {
            h = m.y().n();
        } else {
            h = a0.I().h();
        }
        if (h != null) {
            if (l.g()) {
                b = l.f().a(h);
            } else {
                b = l.f().b(h);
            }
            c(b);
            e();
            g();
            d();
        }
    }

    public void g() {
        this.f9091a.c();
    }

    public void a() {
        b bVar = this.f9091a;
        if (bVar == null || !bVar.isShowing()) {
            return;
        }
        try {
            this.f9091a.dismiss();
            BNMapController.getInstance().onResume();
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("mHudDialog dismiss", e);
            }
        }
        c.n().k();
    }

    public void b(Bundle bundle) {
        int i = bundle.getInt(RouteGuideParams.RGKey.HUDInfo.ExitDirection);
        if (m.y().b(i)) {
            this.f9091a.a(i);
        }
        int i2 = bundle.getInt(RouteGuideParams.RGKey.HUDInfo.EixtRemainDistance);
        if (i2 >= 0) {
            this.f9091a.f(a0.I().a(i2));
        }
        String string = bundle.getString(RouteGuideParams.RGKey.HUDInfo.ExitICode);
        if (!l0.c(string)) {
            l.f().a(true);
            this.f9091a.d(string);
        } else {
            l.f().a(false);
        }
        String string2 = bundle.getString(RouteGuideParams.RGKey.HUDInfo.ExitDirectionName);
        if (!l0.c(string2)) {
            String[] split = string2.split(",");
            StringBuffer stringBuffer = new StringBuffer();
            for (String str : split) {
                stringBuffer.append(" ");
                stringBuffer.append(str);
            }
            this.f9091a.e(stringBuffer.toString());
            return;
        }
        String string3 = bundle.getString(RouteGuideParams.RGKey.HUDInfo.ExitNextRoad);
        if (!l0.c(string3)) {
            this.f9091a.e(string3);
            return;
        }
        String string4 = a0.I().h().getString("road_name");
        if (l0.c(string4)) {
            return;
        }
        this.f9091a.e(string4);
    }

    public void c(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        a(bundle);
    }

    public void a(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (bundle.getInt(RouteGuideParams.RGKey.HUDInfo.UpdateType, -1) == 2) {
            b(bundle);
            return;
        }
        int i = bundle.getInt(RouteGuideParams.RGKey.HUDInfo.ResId, -1);
        if (-1 != i) {
            LogUtil.e(RGFSMTable.FsmState.HUD, "setTurnIcon ===> " + i);
            this.f9091a.b(i);
        }
        String a2 = a0.I().a(bundle.getInt(RouteGuideParams.RGKey.HUDInfo.RemainDist, -1));
        if (a2 == null) {
            Bundle bundle2 = new Bundle();
            BNRouteGuider.getInstance().getSimpleMapInfo(bundle2);
            if (TextUtils.isEmpty(a2) && bundle2.containsKey(RouteGuideParams.RGKey.SimpleGuideInfo.RemainDist)) {
                int i2 = bundle2.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.RemainDist);
                StringBuilder sb = new StringBuilder();
                l0.a(i2, l0.a.ZH, sb);
                a2 = sb.toString();
            }
        }
        if (a2 != null) {
            LogUtil.e(RGFSMTable.FsmState.HUD, "setRemainDistance ===> " + a2);
            this.f9091a.g(a2);
        }
        String string = bundle.getString(RouteGuideParams.RGKey.HUDInfo.NextRoad);
        if (string == null || string.length() == 0) {
            string = JarUtils.getResources().getString(R.string.nsdk_string_navi_no_name_road);
        }
        LogUtil.e(RGFSMTable.FsmState.HUD, "setDirectRoadName ===> " + string);
        this.f9091a.h(string);
        String string2 = bundle.getString(RouteGuideParams.RGKey.HUDInfo.Direction);
        if (string2 != null) {
            LogUtil.e(RGFSMTable.FsmState.HUD, "setDirection ===> " + string2);
            this.f9091a.c(string2);
        }
        boolean z = bundle.getBoolean(RouteGuideParams.RGKey.HUDInfo.Straight);
        l.f().c(z);
        if (z) {
            if (a2 != null) {
                this.f9091a.a(a2);
            }
            String string3 = bundle.getString(RouteGuideParams.RGKey.HUDInfo.CurrentRoad);
            if (string3 != null) {
                this.f9091a.b(string3);
            }
        }
        d();
    }

    public void c(boolean z) {
        this.f9091a.c(z);
    }

    public void b(boolean z) {
        this.f9091a.a(z);
    }
}
