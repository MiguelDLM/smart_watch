package com.baidu.navisdk.ui.routeguide.control;

import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.g0;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.i0;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.module.pronavi.model.b f8601a;
    private c c;
    private boolean b = false;
    private final g0.e d = new a();

    /* loaded from: classes8.dex */
    public class b implements i0.f {
        public b() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void a() {
            u.this.a(true);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void b() {
            u.this.a(false);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void c() {
            u.this.b = false;
            u.this.f();
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a();

        void b();

        void c();
    }

    private void d() {
        x.b().t1();
        x.b().u1();
        x.b().Z0();
        x.b().o3();
        x.b().b3();
        x.b().a1();
    }

    private boolean e() {
        this.b = true;
        d();
        String str = this.f8601a.c;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        Spanned fromHtml = Html.fromHtml(str);
        String str3 = this.f8601a.d;
        if (str3 != null) {
            str2 = str3;
        }
        i0 a2 = x.b().k(103).D(100).v(30000).b(str2).g(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_faster_route_btn_ok)).f(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_faster_route_btn_cancle)).A(true).a(new b()).a(this.d).z(2).a(fromHtml);
        if (!TextUtils.isEmpty(fromHtml) || !TextUtils.isEmpty(str2)) {
            a2.d(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_route_recommend));
        }
        return a2.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.baidu.navisdk.ui.routeguide.b.V().a(this.f8601a.b);
        b(3);
        if (this.f8601a.f7462a != null) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.16.2", "1", String.valueOf(this.f8601a.f7462a.c), String.valueOf(this.f8601a.f7462a.b));
        }
    }

    /* loaded from: classes8.dex */
    public class a extends g0.f {

        /* renamed from: com.baidu.navisdk.ui.routeguide.control.u$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0442a extends com.baidu.navisdk.util.worker.lite.b {
            public C0442a(a aVar, String str) {
                super(str);
            }

            @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
            public void run() {
                s.T().D();
            }
        }

        public a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void a() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGRoadConditionAvoidJam", "RGMMNotificationBaseView.NotificationDisplayListener - onShowWithAnim");
            }
            if (u.this.c != null) {
                u.this.c.a();
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void b() {
            if (u.this.c != null) {
                u.this.c.b();
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void c() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void d() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGRoadConditionAvoidJam", "RGMMNotificationBaseView.NotificationDisplayListener - onShowWithOutAnim");
            }
            if (u.this.c != null) {
                u.this.c.a();
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void b(boolean z) {
            if (u.this.b) {
                u.this.a(-1, false);
                com.baidu.navisdk.util.worker.lite.a.c(new C0442a(this, "RGRoadConditionAvoidJam"));
            }
            u.this.c = null;
        }
    }

    private void c() {
        s.T().a(JarUtils.getResources().getString(R.string.nsdk_rg_avoid_jam_data_exception_tip), false);
        a(false, 0);
    }

    private void b(com.baidu.navisdk.module.pronavi.model.c cVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGRoadConditionAvoidJam", "obtainDataFromEngine: " + cVar);
        }
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(cVar.f7463a)) {
            bundle.putString("eventId", cVar.f7463a);
        }
        bundle.putInt("sceneType", 1);
        if (!TextUtils.isEmpty(cVar.j)) {
            bundle.putString("routeMd5", cVar.j);
        }
        bundle.putInt("triggerSource", 0);
        bundle.putBoolean("onRoute", true);
        bundle.putInt("jamVer", cVar.i);
        bundle.putInt("jamIdx", cVar.h);
        if (gVar.e()) {
            gVar.g("RGRoadConditionAvoidJam", "obtainDataFromEngine getRouteInfoInUniform: " + bundle);
        }
        BNRouteGuider.getInstance().getRouteInfoInUniform(16, 1, bundle);
        if (gVar.e()) {
            gVar.g("RGRoadConditionAvoidJam", "obtainDataFromEngine bundle: " + bundle);
        }
        int i = bundle.getInt("auxRouteIdx", -1);
        String string = bundle.getString("avoidPanelContent", null);
        String string2 = bundle.getString("avoidPanelSubContent", null);
        com.baidu.navisdk.module.pronavi.model.b bVar = new com.baidu.navisdk.module.pronavi.model.b(cVar);
        this.f8601a = bVar;
        bVar.b = i;
        bVar.d = string2;
        bVar.c = string;
        if (gVar.d()) {
            gVar.e("RGRoadConditionAvoidJam", "obtainDataFromEngine: " + this.f8601a);
        }
    }

    private void c(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGRoadConditionAvoidJam", "notifyMap: " + z);
        }
        if (z) {
            int selectRouteIdx = JNIGuidanceControl.getInstance().getSelectRouteIdx();
            BNMapController bNMapController = BNMapController.getInstance();
            com.baidu.navisdk.module.pronavi.model.c cVar = this.f8601a.f7462a;
            if (!bNMapController.setMapFuncInfoPartRouteZoom(true, cVar.i, selectRouteIdx, cVar.h)) {
                com.baidu.navisdk.ui.routeguide.b.V().r().c(false);
            }
            BNMapController.getInstance().setHighLightAvoidTrafficRoute(this.f8601a.b);
            BNMapController.getInstance().setLabelBreathing(this.f8601a.b, true);
            return;
        }
        BNMapController.getInstance().recoveryHighLightRoute();
        BNMapController.getInstance().setMapFuncInfoPartRouteZoom(false, -1, -1, -1);
        BNMapController.getInstance().setLabelBreathing(this.f8601a.b, false);
    }

    public void a(c cVar) {
        this.c = cVar;
    }

    public boolean a(com.baidu.navisdk.module.pronavi.model.c cVar) {
        this.f8601a = null;
        b(cVar);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGRoadConditionAvoidJam", "showAvoidJamPanel: " + this.f8601a);
        }
        com.baidu.navisdk.module.pronavi.model.b bVar = this.f8601a;
        if (bVar != null && bVar.a()) {
            a(true, 1);
            e();
            b(true);
            c(true);
            return true;
        }
        c();
        return false;
    }

    private void a(boolean z, int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGRoadConditionAvoidJam", "notifyRouteEngine: " + z + "," + i);
        }
        if (z && this.f8601a != null) {
            BNRoutePlaner.getInstance().r(this.f8601a.b);
        }
        JNIGuidanceControl.getInstance().setShowRouteChoose(i, 9, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.c();
        }
        this.b = false;
        if (z) {
            s.T().e(103);
        }
        b(false);
        c(false);
        a(false, i);
    }

    private void b(boolean z) {
        if (z) {
            if (RGFSMTable.FsmState.BrowseMap.equals(RouteGuideFSM.getInstance().getTopState())) {
                RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.BROWSER_STATE_EXIT);
                return;
            }
            return;
        }
        com.baidu.navisdk.ui.routeguide.b.V().r().n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGRoadConditionAvoidJam", "cancel: " + z);
        }
        this.b = false;
        b(z ? 2 : 4);
        s.T().D();
        TTSPlayerControl.playTTS(com.baidu.navisdk.ui.util.b.h(R.string.asr_rg_switch_route_cancel), 1);
        if (this.f8601a.f7462a != null) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.16.2", z ? "3" : "2", String.valueOf(this.f8601a.f7462a.c), String.valueOf(this.f8601a.f7462a.b));
        }
    }

    private void b(int i) {
        a(i, true);
    }

    public boolean b() {
        return this.b;
    }

    public void a() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGRoadConditionAvoidJam", "hideAvoidJamPanel: " + this.b);
        }
        if (this.b) {
            b(-1);
        }
    }

    public void a(int i) {
        com.baidu.navisdk.module.pronavi.model.b bVar;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGRoadConditionAvoidJam", "handleAvoidJamRouteDisappear: " + i);
        }
        if (!this.b || (bVar = this.f8601a) == null || (i & ((int) Math.pow(2.0d, bVar.b))) == 0) {
            return;
        }
        b(-1);
    }
}
