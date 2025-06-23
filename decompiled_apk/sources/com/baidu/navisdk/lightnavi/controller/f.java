package com.baidu.navisdk.lightnavi.controller;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.framework.message.bean.o;
import com.baidu.navisdk.lightnavi.asr.a;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.LightNaviStatItem;
import com.google.android.exoplayer2.ExoPlayer;

/* loaded from: classes7.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private Context f6879a;
    private Activity b;
    private com.baidu.navisdk.util.worker.f c;
    private com.baidu.navisdk.util.worker.f d;
    private com.baidu.navisdk.util.worker.f e;
    private com.baidu.navisdk.util.worker.f f;
    private e g;
    private k h;
    private j i;
    private g j;
    private h k;
    private com.baidu.navisdk.module.lightnav.listener.a l;
    private boolean m;
    private boolean n;
    private boolean o;
    private int p;
    private boolean q;
    private Long r;
    private boolean s;
    private com.baidu.navisdk.lightnavi.asr.c t;
    private boolean u;

    /* loaded from: classes7.dex */
    public class a implements com.baidu.navisdk.lightnavi.listener.a {
        public a() {
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void a(int i, int i2) {
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void b(int i) {
            com.baidu.navisdk.ugc.replenishdetails.d.o().a();
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void c(Message message) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.LIGHT;
            if (gVar.d()) {
                StringBuilder sb = new StringBuilder();
                sb.append(" light onUgcEvent: ");
                sb.append(message == null ? "null" : message.toString());
                gVar.e("LightNaviControlCenter", sb.toString());
            }
            com.baidu.navisdk.ugc.replenishdetails.d.o().a(message);
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void d() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.LIGHT;
            if (gVar.d()) {
                gVar.e("LightNaviControlCenter", "onCalRouteFail isYaw = " + f.this.m);
            }
            f.this.q = false;
            f.e(f.this, false);
            throw null;
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void e() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.LIGHT;
            if (gVar.d()) {
                gVar.e("LightNaviControlCenter", "onCalRouteSuccess isYaw = " + f.this.m + " , mCalType = " + f.this.p);
            }
            f.this.q = false;
            f.e(f.this, true);
            throw null;
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void f(Message message) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.LIGHT;
            if (gVar.d()) {
                gVar.e("LightNaviControlCenter", "onSimpleMapHide  msg.what = " + message.what + ",msg.arg2 = " + message.arg2 + " ,msg.arg1 = " + message.arg1);
            }
            f.this.h.c();
            throw null;
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void g(Message message) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.LIGHT;
            if (gVar.d()) {
                gVar.e("LightNaviControlCenter", "onIPORoadConditionUpdate  msg > = " + message.arg2 + "," + message.arg1);
            }
            f.this.h.e();
            throw null;
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void h(Message message) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.LIGHT;
            if (gVar.d()) {
                gVar.e("LightNaviControlCenter", "onIPOLockScreen  msg > = " + message.arg2 + "," + message.arg1);
            }
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void i(Message message) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.LIGHT;
            if (gVar.d()) {
                gVar.e("LightNaviControlCenter", "onOtherRoute  msg > = " + message.arg2 + "," + message.arg1);
            }
            int i = message.arg1;
            f.this.q = false;
            f.e(f.this, true);
            throw null;
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void j(Message message) {
            if (f.this.j == null) {
                return;
            }
            f.this.j.a(message);
            throw null;
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void k(Message message) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.LIGHT;
            if (gVar.d()) {
                gVar.e("LightNaviControlCenter", "isYellowBarHide  msg > " + message.arg2 + "dist=" + message.arg1);
            }
            f.this.c(10);
            f.a(f.this, message.arg1, message.arg2);
            throw null;
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void l(Message message) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.LIGHT;
            if (gVar.d()) {
                gVar.e("LightNaviControlCenter", "avoidTrafficJam  msg > = " + message.arg2 + "," + message.arg1);
            }
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void m(Message message) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.LIGHT;
            if (gVar.d()) {
                gVar.e("LightNaviControlCenter", "onIPORoadConditionHide  msg > = " + message.arg2 + "," + message.arg1);
            }
            f.this.h.a(1);
            throw null;
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void n(Message message) {
            if (f.this.j == null) {
                return;
            }
            f.this.j.a(message, true);
            throw null;
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void o(Message message) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.LIGHT;
            if (gVar.d()) {
                gVar.e("LightNaviControlCenter", "onOverSpeedHide  msg.what = " + message.what + ",msg.arg2 = " + message.arg2 + " ,msg.arg1 = " + message.arg1);
            }
            f.this.h.b();
            throw null;
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void p(Message message) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.LIGHT;
            if (gVar.d()) {
                gVar.e("LightNaviControlCenter", "onIPOAddressScreen  msg > = " + message.arg2 + "," + message.arg1);
            }
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void q(Message message) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.LIGHT;
            if (gVar.d()) {
                gVar.e("LightNaviControlCenter", "onRemainInfoUpdate  msg > = " + message.arg2 + "," + message.arg1);
            }
            f.d(f.this);
            throw null;
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void r(Message message) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.LIGHT;
            if (gVar.d()) {
                gVar.e("LightNaviControlCenter", "onOverSpeedUpdate  msg.what = " + message.what + ",msg.arg2 = " + message.arg2 + " ,msg.arg1 = " + message.arg1);
            }
            f.this.h.a(true, message);
            throw null;
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void s(Message message) {
            String str;
            if (!f.this.a()) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.LIGHT;
                if (gVar.d()) {
                    gVar.e("LightNaviControlCenter", "onUpdateLimitInfo,plate empty or not enable limit");
                    return;
                }
                return;
            }
            Bundle bundle = new Bundle();
            BNRouteGuider.getInstance().getRouteInfoInUniform(19, bundle);
            if (f.this.h == null) {
                String str2 = "";
                if (!bundle.containsKey("interveneId")) {
                    str = "";
                } else {
                    str = bundle.getString("interveneId", "");
                }
                if (bundle.containsKey("limitInfo")) {
                    str2 = bundle.getString("limitInfo", "");
                }
                com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.LIGHT;
                if (gVar2.d()) {
                    gVar2.e("LightNaviControlCenter", "onUpdateLimitInfo，interveneId:" + str + " ,limitInfo:" + str2);
                }
                f.this.a(str);
                f.this.a(4);
                return;
            }
            f.this.h.a(bundle);
            throw null;
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void z(Message message) {
            if (f.this.j == null) {
                return;
            }
            f.this.j.b(true);
            throw null;
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void a(int i, boolean z, boolean z2) {
            if (f.this.j == null) {
                return;
            }
            f.this.j.a(i, z, z2);
            throw null;
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void b() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.LIGHT;
            if (gVar.d()) {
                gVar.e("LightNaviControlCenter", "onSyncOperation() ");
            }
            if (com.baidu.navisdk.lightnavi.asr.busi.a.b()) {
                com.baidu.navisdk.lightnavi.asr.busi.a.a(false);
                com.baidu.navisdk.lightnavi.asr.busi.a.a();
            }
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void a(int i) {
            if (i.a() == 2) {
                i = 0;
            }
            f.this.j.b(i);
            throw null;
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void c(int i) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.LIGHT;
            if (gVar.d()) {
                gVar.e("LightNaviControlCenter", " lonMainAuxiliaryBridgeSwitchComplete,source: " + i);
            }
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void d(Message message) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.LIGHT;
            if (gVar.d()) {
                gVar.e("LightNaviControlCenter", "onYawingRerouting  msg > = " + message.arg2 + "," + message.arg1);
            }
            f.this.q = true;
            f.this.m = true;
            f.this.n = false;
            f.this.b(2);
            com.baidu.navisdk.util.statistic.userop.b.r().a("4.h", message.arg1 == 12 ? "2" : "1", null, null);
            f.this.a(1, true, 2);
            com.baidu.navisdk.asr.d.B().c();
            f.this.t.a(false);
            com.baidu.navisdk.lightnavi.asr.a.a().a(a.EnumC0203a.INVALID);
            f.this.h.d();
            throw null;
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void e(Message message) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.LIGHT;
            if (gVar.d()) {
                gVar.e("LightNaviControlCenter", "onYawingRerouteSuccess  msg > = " + message.arg2 + "," + message.arg1);
            }
            f.this.q = false;
            f.this.m = false;
            f.this.n = false;
            com.baidu.navisdk.util.statistic.userop.b.r().a("4.h.1", "1", null, null);
            LightNaviStatItem.s().n();
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void a(Message message) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.LIGHT;
            if (gVar.d()) {
                gVar.e("LightNaviControlCenter", "onArriveDest  time = " + message.arg2 + "dist=" + message.arg1);
            }
            f.this.o = true;
            if (com.baidu.navisdk.lightnavi.controller.a.getInstance().d() != null) {
                com.baidu.navisdk.lightnavi.controller.a.getInstance().d().onArriveDest();
            }
            com.baidu.navisdk.naviresult.a.d().a().b(true);
            TipTool.onCreateToastDialog(f.this.f6879a, JarUtils.getResources().getString(R.string.nsdk_light_navi_will_quit));
            com.baidu.navisdk.util.worker.c.a().a(f.this.c, new com.baidu.navisdk.util.worker.e(9, 0), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void c() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.LIGHT;
            if (gVar.d()) {
                gVar.e("LightNaviControlCenter", "onCalStart() mCalType is " + f.this.p);
            }
            int i = f.this.p;
            if (i == 0 || i == 1 || i == 7) {
                f.j(f.this);
                throw null;
            }
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void b(Message message) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.LIGHT;
            if (gVar.d()) {
                gVar.e("LightNaviControlCenter", "onUpdateSimpleGuide  msg.arg2 >  " + message.arg2 + "msg.arg1=" + message.arg1);
            }
            f.this.h.a(message, f.this.g());
            throw null;
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void b(boolean z) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.LIGHT;
            if (gVar.d()) {
                gVar.e("LightNaviControlCenter", "onGpsStatusChange  gpsFixed = " + z);
            }
            f.this.h.a(true, z);
            throw null;
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void a() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.LIGHT;
            if (gVar.d()) {
                gVar.e("LightNaviControlCenter", "zoomToFullView");
            }
            com.baidu.navisdk.lightnavi.utils.c.a(false, 0);
        }

        @Override // com.baidu.navisdk.lightnavi.listener.a
        public void a(boolean z) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.LIGHT;
            if (gVar.d()) {
                gVar.e("LightNaviControlCenter", "showSafetyGuide  show = " + z);
            }
            if (f.this.i == null) {
                if (z) {
                    com.baidu.navisdk.framework.b.a();
                }
                if (f.this.t != null) {
                    f.this.t.c(!z);
                    return;
                }
                return;
            }
            f.this.i.a(z);
            throw null;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements a.InterfaceC0201a {
        public b() {
        }

        @Override // com.baidu.navisdk.framework.message.a.InterfaceC0201a
        public void onEvent(Object obj) {
            if (obj instanceof o) {
                f.this.d(((o) obj).f6832a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements com.baidu.navisdk.lightnavi.listener.b {
        public c() {
        }

        @Override // com.baidu.navisdk.lightnavi.listener.b
        public void a(String str) {
            if (f.this.l != null) {
                f.this.l.a(str);
            } else {
                com.baidu.navisdk.framework.b.h(str);
            }
        }

        @Override // com.baidu.navisdk.lightnavi.listener.b
        public void onArriveDest() {
            if (f.this.l != null) {
                f.this.l.onArriveDest();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public static final f f6883a = new f(null);
    }

    public /* synthetic */ f(a aVar) {
        this();
    }

    public static /* synthetic */ void d(f fVar) {
        fVar.o();
        throw null;
    }

    public static /* synthetic */ void j(f fVar) {
        fVar.m();
        throw null;
    }

    private void l() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.LIGHT;
        if (gVar.d()) {
            gVar.e("LightNaviControlCenter", "cancelStateChangeTask");
        }
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.e, false);
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.f, false);
    }

    private void m() {
        this.t.a(false);
        this.q = true;
        a(1, true, 3);
        this.h.a();
        throw null;
    }

    public static f n() {
        return d.f6883a;
    }

    private void o() {
        b(false);
        throw null;
    }

    private f() {
        this.r = -1L;
        this.s = true;
        new a();
        new com.baidu.navisdk.lightnavi.asr.b();
        new b();
        new c();
    }

    public static /* synthetic */ void e(f fVar, boolean z) {
        fVar.a(z);
        throw null;
    }

    public boolean f() {
        return this.n;
    }

    public boolean g() {
        return this.m;
    }

    public void h() {
        this.k.a();
        throw null;
    }

    public void i() {
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.e, false);
    }

    public void j() {
        if (this.u) {
            l();
            k();
        }
    }

    public void k() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.LIGHT;
        if (gVar.d()) {
            gVar.e("LightNaviControlCenter", "startStateChangeTask");
        }
        if (i.a() == 2) {
            com.baidu.navisdk.util.worker.c.a().a(this.f, new com.baidu.navisdk.util.worker.e(9, 0), 30000L);
        } else {
            com.baidu.navisdk.util.worker.c.a().a(this.e, new com.baidu.navisdk.util.worker.e(9, 0), 10000L);
        }
    }

    public Context c() {
        Context context = this.f6879a;
        if (context != null) {
            return context;
        }
        com.baidu.navisdk.module.lightnav.listener.a aVar = this.l;
        if (aVar == null || aVar.a() == null) {
            return null;
        }
        return this.l.a();
    }

    public int d() {
        return i.a();
    }

    public boolean e() {
        return this.q;
    }

    private void d(int i, int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.LIGHT;
        if (gVar.d()) {
            gVar.e("LightNaviControlCenter", "updateRouteHideInfo");
        }
        this.g.a(i2);
        throw null;
    }

    private void e(int i) {
        int i2 = 0;
        if (i != 0) {
            if (i == 1) {
                i2 = 2;
            } else if (i == 2) {
                i2 = 1;
            } else if (i == 3) {
                i2 = 3;
            }
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.n.1", "2", i2 + "", null);
    }

    public Activity b() {
        Activity activity = this.b;
        if (activity != null) {
            return activity;
        }
        com.baidu.navisdk.module.lightnav.listener.a aVar = this.l;
        if (aVar == null || aVar.a() == null) {
            return null;
        }
        return (Activity) this.l.a();
    }

    public static /* synthetic */ void a(f fVar, int i, int i2) {
        fVar.d(i, i2);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.LIGHT;
        if (gVar.d()) {
            gVar.e("LightNaviControlCenter", "doAfterRouteChange ");
        }
        com.baidu.navisdk.lightnavi.utils.c.a(false, 0);
        a(1, false, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.LIGHT;
        if (gVar.d()) {
            gVar.e("LightNaviControlCenter", "requestAndShowMapLimitZone:" + str);
        }
        if (this.l == null || !a() || TextUtils.isEmpty(str)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("interveneId", str);
        this.l.a(8, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.LIGHT;
        if (gVar.d()) {
            gVar.e("LightNaviControlCenter", "networkChange " + i);
        }
        e(i);
    }

    public void b(int i) {
        this.p = i;
    }

    private void b(boolean z) {
        Bundle bundle = new Bundle();
        com.baidu.navisdk.lightnavi.controller.a.a(bundle);
        a(com.baidu.navisdk.lightnavi.model.a.a(bundle));
        throw null;
    }

    public void c(int i, int i2) {
        this.j.a(i);
        throw null;
    }

    public void b(int i, int i2) {
        BNMapController.getInstance().setDragMapStatus(true);
        this.j.a(i);
        throw null;
    }

    private void a(com.baidu.navisdk.lightnavi.model.a aVar) {
        String a2 = com.baidu.navisdk.lightnavi.utils.a.a(aVar.e());
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.LIGHT;
        if (gVar.d()) {
            gVar.e("LightNaviControlCenter", "updateWillArriveInfo  willArrive = " + a2);
        }
        this.i.a(a2);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, int i2) {
        a(i, z, i2, (Bundle) null);
    }

    public void a(int i, boolean z, int i2, Bundle bundle) {
        i.a(i, z, i2, bundle);
    }

    public void a(int i) {
        boolean isLightSavePowerEnabled = BNSettingManager.isLightSavePowerEnabled();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.LIGHT;
        if (gVar.d()) {
            gVar.e("LightNaviControlCenter", "onGuideStart isCurEnableSavePow = " + isLightSavePowerEnabled);
        }
        if (isLightSavePowerEnabled) {
            if (i != 2 && i != 3 && i != 4) {
                com.baidu.navisdk.module.powersavemode.f.o().e();
                return;
            }
            com.baidu.navisdk.module.powersavemode.f.o().g();
            com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.d, false);
            com.baidu.navisdk.util.worker.c.a().a(this.d, new com.baidu.navisdk.util.worker.e(9, 0), (i == 2 || i == 3) ? 5000 : 20000);
        }
    }

    private void a(boolean z) {
        this.t.a(true);
        this.j.a(z);
        throw null;
    }

    public boolean a() {
        boolean z = com.baidu.navisdk.module.routepreference.d.j().h() && !TextUtils.isEmpty(com.baidu.navisdk.h.a());
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.LIGHT;
        if (gVar.d()) {
            gVar.e("LightNaviControlCenter", "canShowLimitInfo:" + z);
        }
        return z;
    }

    public void a(int i, int i2) {
        BNMapController.getInstance().setDragMapStatus(false);
        com.baidu.navisdk.lightnavi.utils.c.a(0);
        this.j.a(i);
        throw null;
    }

    public void a(int i, int i2, Bundle bundle) {
        BNMapController.getInstance().setDragMapStatus(true);
        this.j.a(i, bundle);
        throw null;
    }
}
