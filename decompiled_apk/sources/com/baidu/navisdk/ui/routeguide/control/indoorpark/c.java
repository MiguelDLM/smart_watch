package com.baidu.navisdk.ui.routeguide.control.indoorpark;

import XIXIX.OOXIXo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.ui.routeguide.control.indoorpark.BluetoothListenerReceiver;
import com.baidu.navisdk.ui.routeguide.control.s;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.i0;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.indoorpark.a;
import com.baidu.navisdk.ui.routeguide.model.o;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.sma.smartv3.ble.ProductManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class c extends com.baidu.navisdk.ui.routeguide.control.indoorpark.a {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.indoorpark.b f8550a;
    private boolean d;
    private boolean e;
    private boolean g;
    private boolean h;
    private int i;
    private boolean j;
    private boolean k;
    private boolean l;
    private RoutePlanNode n;
    private boolean f = false;
    private int m = 0;
    private boolean o = false;
    private boolean p = false;
    private int q = 0;
    private boolean r = false;
    private final BluetoothListenerReceiver.a s = new d();
    final com.baidu.navisdk.util.worker.f<String, String> t = new e("mAutoRecorverFullViewTask", null);
    private final a.c u = new f();
    private final com.baidu.navisdk.util.worker.lite.b v = new g("mFixBuildingIdTask");
    private final com.baidu.navisdk.util.worker.f<String, String> w = new j("mCheckBluetoothRunnable", null);
    private final com.baidu.navisdk.comapi.base.d x = new b("mRoutePlanResultHandler");
    private o b = new o();
    private final com.baidu.navisdk.ui.routeguide.control.indoorpark.b c = new com.baidu.navisdk.ui.routeguide.control.indoorpark.b();

    /* loaded from: classes8.dex */
    public class b extends com.baidu.navisdk.util.worker.loop.b {
        public b(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.comapi.base.d
        public void careAbout() {
            observe(4099);
        }

        @Override // com.baidu.navisdk.util.worker.loop.b
        public void onMessage(Message message) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGIndoorParkC", "mRoutePlanResultHandler message's what is" + message.what + ", arg1=" + message.arg1 + ", arg2=" + message.arg2);
            }
            if (message.what == 4099) {
                int i = message.arg1;
                if (i == 0) {
                    Bundle bundle = new Bundle();
                    BNRoutePlaner.getInstance().a(new ArrayList<>(), bundle);
                    if (bundle.containsKey("unRoutePlanID")) {
                        if (c.this.i == bundle.getInt("unRoutePlanID")) {
                            c.this.c(1);
                            if (!c.this.k) {
                                c.this.K();
                            }
                            if (c.this.b.s()) {
                                c.this.h(false);
                            }
                            com.baidu.navisdk.ui.routeguide.control.e eVar = com.baidu.navisdk.ui.routeguide.control.e.o;
                            RoutePlanNode c = eVar.c();
                            if (gVar.d()) {
                                gVar.e("RGIndoorParkC", "OriginalEndNode=" + c + ", beforeEndNode=" + c.this.n);
                            }
                            if (c == null && c.this.n != null) {
                                eVar.b(c.this.n);
                            }
                        }
                    }
                } else if (i == 579) {
                    c.this.c.a("室内算路异常");
                    com.baidu.navisdk.util.statistic.userop.b.r().a("3.y.7.1", "5", null, null);
                }
            }
            c.this.c.a();
            com.baidu.navisdk.vi.b.b(c.this.x);
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.control.indoorpark.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0440c implements i0.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8553a;
        final /* synthetic */ String b;
        final /* synthetic */ double c;
        final /* synthetic */ double d;

        public C0440c(String str, String str2, double d, double d2) {
            this.f8553a = str;
            this.b = str2;
            this.c = d;
            this.d = d2;
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void b() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGIndoorParkC", "onClickIndoorParkSpace-onCancelBtnClick->");
            }
            c.this.c.a();
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void c() {
            int i;
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGIndoorParkC", "onClickIndoorParkSpace-onConfirmBtnClick->name:" + this.f8553a + ",uid:" + this.b + ",latitude:" + this.c + ",mArriveOutdoorDest=" + c.this.l);
            }
            o.a g = c.this.b.g();
            if (g == null) {
                g = new o.a();
            }
            g.b(this.f8553a);
            Bundle b = com.baidu.navisdk.util.common.o.b((int) this.d, (int) this.c);
            int i2 = b.getInt("LLx");
            int i3 = b.getInt("LLy");
            g.c(this.b);
            g.a(i2);
            g.b(i3);
            if (c.this.l) {
                i = 29;
            } else {
                i = 57;
            }
            if (c.this.a(g, i)) {
                c.this.M();
            }
            TTSPlayerControl.stopVoiceTTSOutput();
            com.baidu.navisdk.ui.routeguide.b.V().b(false);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements BluetoothListenerReceiver.a {
        public d() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.control.indoorpark.BluetoothListenerReceiver.a
        public void a(boolean z) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGIndoorParkC", "BluetoothListener->enable=" + z);
            }
            if (z) {
                c.this.H();
            } else {
                c.this.O();
            }
            x.b().z(z);
            if (z && c.this.q > 0) {
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().x(c.this.q);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends com.baidu.navisdk.util.worker.f<String, String> {
        public e(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            BNRouteGuider.getInstance().setBrowseStatus(false);
            c.this.g(true);
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class f implements a.c {
        public f() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.indoorpark.a.c
        public void a(String str) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGIndoorParkC", "FloorClickListener-> floorId=" + str);
            }
            s.T().p();
            c.this.c.a();
            c.this.c.a(str, c.this.b.k());
        }
    }

    /* loaded from: classes8.dex */
    public class g extends com.baidu.navisdk.util.worker.lite.b {
        public g(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            c.this.b.f(c.this.C());
            c.this.Q();
        }
    }

    /* loaded from: classes8.dex */
    public class h implements i0.f {
        public h() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void b() {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.v.a", "3", "2", null);
            c.this.a(false);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void c() {
            c.this.P();
        }
    }

    /* loaded from: classes8.dex */
    public class i implements i0.f {
        public i() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void a() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGIndoorParkC", "showArriveStallNotification-> AutoHide!");
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.v.a", "2", "2", null);
            c.this.a(true);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void b() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGIndoorParkC", "showArriveStallNotification-> 更多车位!");
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.y.7", null, "1", null);
            c.this.b(false);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void c() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGIndoorParkC", "showArriveStallNotification-> quitNavi!");
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.y.7", null, "2", null);
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.v.a", "2", "2", null);
            c.this.a(true);
        }
    }

    /* loaded from: classes8.dex */
    public class j extends com.baidu.navisdk.util.worker.f<String, String> {
        public j(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            boolean c = c.this.c.c();
            if (!c) {
                c.this.O();
            }
            x.b().z(c);
            if (!c || c.this.q <= 0) {
                return null;
            }
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().x(c.this.q);
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public static class l {

        /* renamed from: a, reason: collision with root package name */
        private static final c f8562a = new c();
    }

    private void B() {
        BNMapController.getInstance().setPreFinishStatus(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String C() {
        String str;
        com.baidu.navisdk.model.datastruct.g a2 = com.baidu.navisdk.util.logic.c.k().a(3, 10000);
        if (a2 != null) {
            str = a2.q;
        } else {
            str = null;
        }
        String b2 = com.baidu.baidunavis.maplayer.e.k().b();
        if (TextUtils.equals(((com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel")).o().mName, "我的位置")) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        } else if (TextUtils.isEmpty(b2)) {
            return str;
        }
        return b2;
    }

    private Context D() {
        return com.baidu.navisdk.ui.routeguide.b.V().c();
    }

    private int E() {
        if ((this.b.s() && this.b.u()) || this.b.w()) {
            return 4;
        }
        return 3;
    }

    public static c F() {
        return l.f8562a;
    }

    private boolean G() {
        if (!this.b.u() && !this.b.r()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        s.T().e(129);
    }

    private boolean I() {
        return this.b.v();
    }

    private void J() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGIndoorParkC", "quitIndoorParkNavi-> ");
        }
        h();
        com.baidu.navisdk.ui.routeguide.asr.c.n().b(8, true);
        L();
        x.b().l();
        x.b().C4();
        com.baidu.navisdk.ui.routeguide.b.V().l().v();
        com.baidu.navisdk.comapi.commontool.a.getInstance().c(BNCommSettingManager.getInstance().getNaviDayAndNightMode());
        F().g();
        com.baidu.navisdk.ui.routeguide.b.V().l().i();
        if (com.baidu.navisdk.module.newguide.a.e().d()) {
            com.baidu.navisdk.module.newguide.controllers.c.c();
        }
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().A();
        t();
        com.baidu.navisdk.module.vdr.a.d(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        String str;
        String str2;
        if (this.b.b() == 2) {
            if (!TextUtils.isEmpty(this.b.q())) {
                str = this.b.q();
            } else {
                str = "自动为您推荐可用车位";
            }
            if (this.j) {
                str2 = "预定车位已被占用，为您推荐其它可用车位";
            } else {
                str2 = str;
            }
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGIndoorParkC", "recalcResponse isIndoorParkStall = " + this.j + ", ttsText = " + str);
            }
            TTSPlayerControl.playTTS(str2, 1);
        }
    }

    private void L() {
        BNMapController.getInstance().setPreFinishStatus(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        if (2 != com.baidu.navisdk.module.pronavi.a.j) {
            com.baidu.navisdk.comapi.commontool.c.c().a(com.baidu.navisdk.framework.a.c().a(), System.currentTimeMillis() / 1000);
            com.baidu.navisdk.comapi.commontool.c.c().a(com.baidu.navisdk.framework.a.c().a(), com.baidu.navisdk.comapi.commontool.c.c);
        }
    }

    private void N() {
        String str;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGIndoorParkC", "showArriveStallNotification->");
        }
        s.T().p();
        com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        if (fVar != null && fVar.g() != null) {
            str = fVar.g().mName;
        } else {
            str = "";
        }
        if (this.b.g() != null) {
            str = this.b.g().a();
        }
        this.c.a(str, G(), new i()).y();
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.y.7", "1", null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGIndoorParkC", "showOpenBluetoothNotification->");
        }
        this.c.a(new h()).y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGIndoorParkC", "startBluetoothSetting->");
        }
        com.baidu.navisdk.framework.a.c().b().startActivityForResult(new Intent("android.settings.BLUETOOTH_SETTINGS"), 4108);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.indoorpark.b bVar;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGIndoorParkC", "switchCurFloor isStartMode: " + this.b.y() + ", " + this.b.i());
        }
        if (!this.b.y() && this.b.u()) {
            return;
        }
        String d2 = d(this.b.f());
        if (g(d2) && (bVar = this.f8550a) != null) {
            bVar.b(d2);
        }
        this.b.b(d2);
    }

    private void R() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGIndoorParkC", "updateStallName->");
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.indoorpark.b bVar = this.f8550a;
        if (bVar != null) {
            bVar.w();
        }
    }

    public void A() {
        String str;
        if (this.b.c() != null) {
            str = this.b.c().mName;
        } else if (this.b.g() != null) {
            str = this.b.g().a();
        } else {
            str = null;
        }
        o oVar = this.b;
        oVar.a(this.c.a(false, oVar.o(), this.b.p(), str));
    }

    public boolean p() {
        if (!this.b.v() && (this.d || !this.b.t())) {
            return false;
        }
        return true;
    }

    public void q() {
        this.b.z();
        c(0);
        RoutePlanNode g2 = ((com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel")).g();
        int parkType = g2.getParkType();
        String uid = g2.getUID();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGIndoorParkC", "onArriveOutdoorDestNear-> IndoorParkType=" + parkType + ", uid=" + uid);
        }
        if (com.baidu.navisdk.util.common.h.b(parkType)) {
            this.b.a(4);
            f(uid);
        } else if (com.baidu.navisdk.util.common.h.a(parkType)) {
            this.b.a(4);
            e(uid);
        }
    }

    public void r() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGIndoorParkC", "onArriveStallDest-> ");
        }
        this.k = true;
        if (this.b.t()) {
            String b2 = this.c.b();
            if (!TextUtils.isEmpty(b2) && this.b.j().contains(b2)) {
                this.b.b(b2);
            }
        }
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.w, true);
        BNRoutePlaner.getInstance().o();
        x.b().m1();
        BNRouteGuider.getInstance().stopRouteGuide();
        com.baidu.navisdk.ui.routeguide.asr.c.n().l();
        B();
        N();
        BNRoutePlaner.getInstance().p(10);
    }

    public void s() {
        a(500L);
    }

    public void t() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGIndoorParkC", "onIndoorNaviDestroy-> isIndoorParkState=" + this.e);
        }
        if (k()) {
            this.c.a();
            g();
        }
        this.c.a(D());
        this.b = new o();
        this.f8550a = null;
        this.d = false;
        this.e = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.o = false;
        this.p = false;
        this.q = 0;
        com.baidu.navisdk.util.worker.lite.a.a(this.v);
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.t, true);
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.w, true);
        com.baidu.navisdk.vi.b.b(this.x);
    }

    public void u() {
        this.c.a("室内导航异常!");
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.y.7.1", "1", null, null);
        a(false);
    }

    public void v() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGIndoorParkC", "onYawing-> ");
        }
        this.g = true;
        com.baidu.navisdk.ui.routeguide.mapmode.subview.indoorpark.b bVar = this.f8550a;
        if (bVar != null) {
            bVar.D();
            this.f8550a.b0();
        }
    }

    public void w() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGIndoorParkC", "onYawingComplete-> ");
        }
        this.g = false;
        com.baidu.navisdk.ui.routeguide.mapmode.subview.indoorpark.b bVar = this.f8550a;
        if (bVar != null) {
            bVar.W();
            if (!this.h) {
                this.f8550a.R();
            }
        }
    }

    public void x() {
        this.r = false;
    }

    public void y() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGIndoorParkC", "showIParkNaviMapClass: ");
        }
        if (this.c != null) {
            this.m = E();
            this.c.a(true, E());
        }
    }

    public void z() {
        this.c.a(true);
    }

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.http.center.f {
        public a() {
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str, Throwable th) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGIndoorParkC", "requestIndoorParkInfo->onFailure ,statusCode + " + i + "responseString=" + str + "," + th);
            }
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGIndoorParkC", "requestIndoorParkInfo-> onSuccess! responseString = " + str);
            }
            c.this.a(str, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGIndoorParkC", "onNaviBegin-> isIndoorParkNavi=" + z);
        }
        if (z) {
            if (this.b.y()) {
                com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
                String str = fVar.o().mBuildingID;
                this.b.f(str);
                if (str == null) {
                    com.baidu.navisdk.util.worker.lite.a.a(this.v, 3000L);
                }
                String b2 = this.c.b();
                if (TextUtils.isEmpty(b2)) {
                    b2 = fVar.o().mFloorId;
                }
                if (gVar.d()) {
                    gVar.e("RGIndoorParkC", "onNaviBegin-> setCurFloor=" + b2);
                }
                this.b.b(b2);
            }
            s.T().a(false, false, false);
            if (!this.b.a()) {
                if (gVar.d()) {
                    gVar.e("RGIndoorParkC", "onNaviBegin-> quitNavi!");
                }
                this.b.a(false);
                this.c.a("没有bid或楼层list");
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.v.a", "2", "2", null);
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.y.7.1", "2", null, null);
                a(false);
                return;
            }
            this.b.a(false);
            this.l = false;
            b(true);
            if (this.r) {
                return;
            }
            TTSPlayerControl.playTTS("阿波罗为您带来内部路导航新体验", 1);
            this.r = true;
            return;
        }
        if (k()) {
            com.baidu.navisdk.util.worker.lite.a.a(this.v);
            J();
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.EXIT_INDOOR_PARK);
            x.b().l3();
            com.baidu.baidunavis.maplayer.e.k().b(false);
        }
        this.b.a(((com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel")).g());
    }

    public void b(int i2) {
        this.q = i2;
    }

    public void c(boolean z) {
        this.f = z;
    }

    public void d() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.e()) {
            gVar.g("RGIndoorParkC", "enterIndoorBrowseState");
        }
        this.h = true;
        com.baidu.navisdk.ui.routeguide.mapmode.subview.indoorpark.b bVar = this.f8550a;
        if (bVar != null) {
            bVar.b0();
        }
    }

    public void e(boolean z) {
        this.p = z;
    }

    public void f(boolean z) {
        this.o = z;
    }

    public void g() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGIndoorParkC", "hideIParkNaviMapClass: ");
        }
        com.baidu.navisdk.ui.routeguide.control.indoorpark.b bVar = this.c;
        if (bVar != null) {
            int i2 = this.m;
            if (i2 == 3 || i2 == 4) {
                bVar.a(false, i2);
                this.m = 0;
            }
        }
    }

    public boolean i() {
        return this.f;
    }

    public boolean j() {
        return this.d;
    }

    public boolean k() {
        return this.e;
    }

    public boolean l() {
        return this.b.v();
    }

    public boolean m() {
        return this.b.w();
    }

    public boolean n() {
        return this.p;
    }

    public boolean o() {
        return this.o;
    }

    /* loaded from: classes8.dex */
    public class k extends com.baidu.navisdk.util.http.center.f {
        public k() {
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str, Throwable th) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGIndoorParkC", "requestStallInfo->onFailure ,statusCode + " + i + "responseString=" + str + "," + th);
            }
            LogUtil.out("RGIndoorParkC", "requestStallInfo->onFailure ,statusCode + " + i + "responseString=" + str + "," + th);
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGIndoorParkC", "requestStallInfo-> onSuccess! responseString = " + str);
            }
            LogUtil.out("RGIndoorParkC", "requestStallInfo-> onSuccess! responseString = " + str);
            c.this.a(str, true);
        }
    }

    private void b(RoutePlanNode routePlanNode) {
        com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        if (routePlanNode == null) {
            routePlanNode = fVar.g();
        }
        if (routePlanNode != null) {
            com.baidu.navisdk.ui.routeguide.control.i.g().f();
            com.baidu.navisdk.ui.routeguide.control.i.g().a(new com.baidu.navisdk.ui.routeguide.mapmode.subview.parkinglot.d(routePlanNode.getName(), F().a()));
            if (com.baidu.navisdk.util.common.h.b(routePlanNode.getParkType())) {
                TTSPlayerControl.playTTS("预订车位已被占用，点击更多车位，查看空闲车位", 1);
                return;
            } else {
                if (com.baidu.navisdk.util.common.h.a(routePlanNode.getParkType())) {
                    TTSPlayerControl.playTTS("点击更多车位，查看空闲车位", 1);
                    return;
                }
                return;
            }
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGIndoorParkC", "showMoreStallCard-> endNode == null !!");
        }
    }

    public boolean c(String str) {
        this.b.b(str);
        return g(str);
    }

    public void e() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.e()) {
            gVar.g("RGIndoorParkC", "enterIndoorNormalState");
        }
        this.h = false;
        com.baidu.navisdk.ui.routeguide.mapmode.subview.indoorpark.b bVar = this.f8550a;
        if (bVar == null || this.g) {
            return;
        }
        bVar.R();
    }

    public boolean f() {
        this.l = true;
        this.b.z();
        int b2 = this.b.b();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGIndoorParkC", "handleAction-> action = " + b2);
        }
        if (b2 == 0) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.y.7.1", "8", null, null);
            a(false);
            return true;
        }
        if (b2 == 1) {
            if (!this.b.a()) {
                if (gVar.d()) {
                    gVar.e("RGIndoorParkC", "handleAction-ACTION_SHOW_MORE_STALL_CARD FloorList:" + this.b.j().size() + ", MainBid:" + this.b.k());
                }
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.v.a", "3", "2", null);
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.y.7.1", "2", null, null);
                a(false);
                this.c.a("没有bid或楼层list");
                return true;
            }
            a((RoutePlanNode) null);
            return true;
        }
        if (b2 != 2) {
            if (b2 == 3) {
                this.c.a("引擎错误上抛end2");
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.y.7.1", "7", null, null);
                a(false);
                return true;
            }
            if (b2 != 4) {
                if (b2 != 5) {
                    return false;
                }
                this.c.a("车位服务控制功能下线");
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.y.7.1", "6", null, null);
                return false;
            }
            this.c.a("车位服务未响应");
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.v.a", "3", "2", null);
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.y.7.1", "3", null, null);
            a(false);
            return true;
        }
        if (!this.b.a()) {
            if (gVar.d()) {
                gVar.e("RGIndoorParkC", "handleAction-ACTION_CALC_ROUTE FloorList:" + this.b.j().size() + ", MainBid:" + this.b.k());
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.v.a", "3", "2", null);
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.y.7.1", "2", null, null);
            a(false);
            this.c.a("没有bid或楼层list");
            return true;
        }
        this.c.a("到达室外终点时算路未成功");
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.y.7.1", "4", null, null);
        a(this.b.c());
        return true;
    }

    public void a(String str, String str2, double d2, double d3, int i2) {
        Context c;
        if (j()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGIndoorParkC", "onClickIndoorParkSpace->isIndoorParkNavi ! return");
                return;
            }
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.control.d.e.d()) {
            LogUtil.e("RGIndoorParkC", "onClickIndoorParkSpace->isAceParkNavi ! return");
            return;
        }
        s.T().p();
        if (i2 == 5) {
            this.c.a(d3, d2);
            this.c.a(str, new C0440c(str, str2, d2, d3)).y();
        } else {
            if (i2 == 6) {
                Context c2 = com.baidu.navisdk.ui.routeguide.b.V().c();
                if (c2 != null) {
                    TipTool.onCreateToastDialog(c2, "当前车位被占用");
                    return;
                }
                return;
            }
            if (i2 != 7 || (c = com.baidu.navisdk.ui.routeguide.b.V().c()) == null) {
                return;
            }
            TipTool.onCreateToastDialog(c, "当前车位不可用");
        }
    }

    public void c(int i2) {
        JNIGuidanceControl.getInstance().setIndoorParkStatus(i2);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGIndoorParkC", "setIndoorParkStatusToEngine-> stallTallType = " + i2);
        }
    }

    public void d(boolean z) {
        this.b.a(z);
    }

    private String d(String str) {
        if (!this.b.y() || TextUtils.isEmpty(str)) {
            return (TextUtils.isEmpty(str) || !this.b.j().contains(str)) ? !this.b.j().isEmpty() ? this.b.j().get(0) : ProductManager.f20659xxOXOOoIX : str;
        }
        return str;
    }

    private void e(String str) {
        HashMap<String, String> a2 = a(str, 1, 0);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGIndoorParkC", "requestIndoorParkInfo->params:" + a2);
        }
        RoutePlanNode routePlanNode = new RoutePlanNode();
        routePlanNode.setUID(str);
        com.baidu.navisdk.ui.routeguide.control.e eVar = com.baidu.navisdk.ui.routeguide.control.e.o;
        eVar.a(routePlanNode);
        eVar.b(true);
        com.baidu.navisdk.util.http.center.b.a().a(com.baidu.navisdk.util.http.b.d().b("IndoorParkService") + "/parking/api/navi/rpbyparkbid", a2, new a(), null);
    }

    private boolean g(String str) {
        String k2 = this.b.k();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.INDOOR_PARK;
        if (gVar.e()) {
            gVar.g("RGIndoorParkC", "switchIndoorMapFloor-> floor=" + str + ", mainBid=" + k2);
        }
        if (TextUtils.isEmpty(k2)) {
            k2 = C();
            gVar.a("RGIndoorParkC", "fixBuildingId " + k2);
        }
        if (TextUtils.isEmpty(k2)) {
            return false;
        }
        this.c.a(str, k2);
        this.b.b(str);
        return true;
    }

    @Override // com.baidu.navisdk.ui.routeguide.control.indoorpark.a
    public void c() {
        if (i()) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.3.1", "1", null, null);
            c(false);
            com.baidu.navisdk.ui.routeguide.b.V().r().m();
            com.baidu.navisdk.ui.routeguide.mapmode.subview.indoorpark.b bVar = this.f8550a;
            if (bVar != null) {
                bVar.t(false);
                return;
            }
            return;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.3.1", "2", null, null);
        c(true);
        com.baidu.navisdk.ui.routeguide.b.V().r().c(true);
        com.baidu.navisdk.ui.routeguide.mapmode.subview.indoorpark.b bVar2 = this.f8550a;
        if (bVar2 != null) {
            bVar2.t(true);
        }
    }

    public void b(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGIndoorParkC", "enterIndoorParkState->isIndoorParkNavi = " + z + ", isIndoorParkNaviMode = " + this.b.v() + ", mIndoorParkView:" + this.f8550a);
        }
        if (RouteGuideFSM.getInstance().getTopState().equals(RGFSMTable.FsmState.Voice)) {
            com.baidu.navisdk.asr.d.B().b();
        }
        this.g = false;
        this.h = false;
        this.f = false;
        RouteGuideFSM.getInstance().setFullViewByUser(false);
        this.e = true;
        this.d = z;
        RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.ENTRY_INDOOR_PARK);
        if (this.f8550a == null) {
            this.f8550a = x.b().a(this);
        }
        if (z) {
            com.baidu.navisdk.util.statistic.userop.b.r().b("3.1.4");
            this.f8550a.M();
            if (I()) {
                a(1000L);
                this.c.a(D(), this.s);
            }
            L();
            this.b.v();
        } else {
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.ENTRY_INDOOR_PARK_CHOOSE);
            x.b().c();
            this.c.a(D());
            this.f8550a.K();
            this.f8550a.a(this.u);
        }
        Q();
        this.f8550a.t(com.baidu.navisdk.ui.routeguide.model.g.h().a());
    }

    public void g(boolean z) {
        this.c.b(z);
    }

    private void a(RoutePlanNode routePlanNode) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("enterArriveDestState-> endNode=");
            sb.append(routePlanNode != null ? routePlanNode.toString() : null);
            gVar.e("RGIndoorParkC", sb.toString());
        }
        BNRoutePlaner.getInstance().o();
        x.b().m1();
        BNRouteGuider.getInstance().stopRouteGuide();
        com.baidu.navisdk.ui.routeguide.asr.c.n().l();
        com.baidu.navisdk.module.powersavemode.f.o().h();
        if (RouteGuideFSM.getInstance().getTopState().equals(RGFSMTable.FsmState.Voice)) {
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.VOICE_STATE_EXIT);
        }
        RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MSG_ENTER_ARRIVE_DEST);
        x.b().l3();
        com.baidu.navisdk.ugc.interaction.c.a().a(2);
        BNRoutePlaner.getInstance().p(10);
        b(routePlanNode);
    }

    public void a(o oVar) {
        if (oVar != null) {
            if (this.b == null) {
                this.b = new o();
            }
            this.b.d(oVar.o());
            this.b.e(oVar.p());
            this.b.c(oVar.h());
            if (oVar.g() != null) {
                this.b.a(oVar.g());
                R();
            }
        }
    }

    public void h() {
        this.c.a(false);
    }

    public void a(String str) {
        this.b.d(str);
    }

    public void a(int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGIndoorParkC", "onNaviModeSwitch new: " + i2 + ", last:" + this.b.l());
        }
        this.b.c(i2);
        h(this.b.x());
    }

    private void f(String str) {
        HashMap<String, String> a2 = a(str, 2, 0);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGIndoorParkC", "requestStallInfo->params:" + a2);
        }
        com.baidu.navisdk.util.http.center.b.a().a(com.baidu.navisdk.util.http.b.d().b("IndoorParkService") + "/parking/api/navi/rpbyparkingspace", a2, new k(), null);
    }

    private void a(long j2) {
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.w, false);
        com.baidu.navisdk.util.worker.c.a().a(this.w, new com.baidu.navisdk.util.worker.e(2, 0), j2);
    }

    public void b(String str) {
        this.b.e(str);
    }

    @Override // com.baidu.navisdk.ui.routeguide.control.indoorpark.a
    public boolean b() {
        return this.b.t() && this.b.r();
    }

    private HashMap<String, String> a(String str, int i2, int i3) {
        HashMap<String, String> a2 = com.baidu.navisdk.util.http.a.a();
        a2.put("uid", str);
        a2.put("end_uid", str);
        com.baidu.navisdk.model.datastruct.g c = com.baidu.navisdk.util.logic.a.j().c();
        if (c != null) {
            Bundle b2 = com.baidu.navisdk.util.common.o.b(c.b, c.f6926a);
            double d2 = b2.getDouble("MCx_D", OOXIXo.f3760XO);
            double d3 = b2.getDouble("MCy_D", OOXIXo.f3760XO);
            String plainString = new BigDecimal(Double.toString(d2)).toPlainString();
            String plainString2 = new BigDecimal(Double.toString(d3)).toPlainString();
            a2.put("start_x", plainString);
            a2.put("start_y", plainString2);
            if (i3 == 1 && !TextUtils.isEmpty(c.p)) {
                a2.put("start_floor", "" + c.p);
            }
        }
        RoutePlanNode g2 = ((com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel")).g();
        if (g2 != null) {
            Bundle c2 = com.baidu.navisdk.util.common.o.c(g2.getLongitudeE6(), g2.getLatitudeE6());
            double d4 = c2.getDouble("MCx_D", OOXIXo.f3760XO);
            double d5 = c2.getDouble("MCy_D", OOXIXo.f3760XO);
            String plainString3 = new BigDecimal(Double.toString(d4)).toPlainString();
            String plainString4 = new BigDecimal(Double.toString(d5)).toPlainString();
            a2.put("end_x", plainString3);
            a2.put("end_y", plainString4);
            if (!TextUtils.isEmpty(g2.mFloorId)) {
                a2.put("end_floor", g2.mFloorId);
            }
            Bundle bundle = new Bundle();
            BNRouteGuider.getInstance().getRouteInfoInUniform(38, bundle);
            Bundle b3 = com.baidu.navisdk.util.common.o.b(bundle.getDouble("x", OOXIXo.f3760XO), bundle.getDouble("y", OOXIXo.f3760XO));
            double d6 = b3.getDouble("MCx_D", OOXIXo.f3760XO);
            double d7 = b3.getDouble("MCy_D", OOXIXo.f3760XO);
            String plainString5 = new BigDecimal(Double.toString(d6)).toPlainString();
            String plainString6 = new BigDecimal(Double.toString(d7)).toPlainString();
            a2.put("guide_x", plainString5);
            a2.put("guide_y", plainString6);
        }
        if (i3 == 0) {
            a2.put("req_distanc", "200");
        } else {
            a2.put("req_distanc", "100");
        }
        a2.put("req_indoor", "" + i3);
        if (g2 != null && i3 == 0 && TextUtils.equals(this.b.m(), g2.mUID)) {
            try {
                a2.put("indoorpark_ext", this.b.n());
            } catch (Exception e2) {
                com.baidu.navisdk.util.common.g.PRO_NAV.c("put indoorpark_ext err:" + e2.getLocalizedMessage());
            }
        }
        Bundle bundle2 = new Bundle();
        boolean indoorCrossFloorYawInfo = JNIGuidanceControl.getInstance().getIndoorCrossFloorYawInfo(bundle2);
        if (!indoorCrossFloorYawInfo) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGIndoorParkC", "getReqParams->getIndoorCrossFloorYawInfo false");
            }
        }
        if (indoorCrossFloorYawInfo) {
            String string = bundle2.getString("sessionId");
            if (!TextUtils.isEmpty(string)) {
                a2.put("session_id", string);
            }
        }
        String b4 = com.baidu.navisdk.ui.routeguide.control.e.o.b();
        if (!TextUtils.isEmpty(b4)) {
            a2.put("indoorpark_ext", b4);
        }
        if (!com.baidu.navisdk.j.d()) {
            com.baidu.navisdk.framework.interfaces.k k2 = com.baidu.navisdk.framework.interfaces.c.p().k();
            if (k2 != null && !TextUtils.isEmpty(k2.R())) {
                a2.put("cloud_token", k2.R());
            }
            a2.put("cloud_sdk_service", "lbs_navsdk_mini");
            a2.put(TypedValues.TransitionType.S_FROM, "lbs_navsdk_mini");
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z) {
        JSONObject jSONObject;
        String a2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGIndoorParkC", "handleIndoorParkInfoResponse-> isIndoorStall = " + z);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (jSONObject2.getInt("errno") != 0 || (jSONObject = jSONObject2.getJSONObject("data")) == null) {
                return;
            }
            a(jSONObject, z);
            if (this.b.c() != null) {
                a2 = this.b.c().mName;
            } else {
                a2 = this.b.g() != null ? this.b.g().a() : null;
            }
            o oVar = this.b;
            oVar.a(this.c.a(z, oVar.o(), this.b.p(), a2));
        } catch (Exception e2) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                e2.printStackTrace();
                gVar2.e("RGIndoorParkC", "handleIndoorParkInfoResponse-> exception! e = " + e2);
            }
        }
    }

    private void a(JSONObject jSONObject, boolean z) throws Exception {
        int i2 = jSONObject.getInt("type");
        this.b.f(i2);
        this.b.a(jSONObject);
        com.baidu.navisdk.ui.routeguide.control.e eVar = com.baidu.navisdk.ui.routeguide.control.e.o;
        eVar.b(jSONObject.toString());
        if (!this.b.a() && i2 != 4) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGIndoorParkC", "parseStallData-> allowEnterIndoorPark return false!!!!");
                return;
            }
            return;
        }
        if (i2 == 1) {
            if (z) {
                this.b.a(3);
                c(1);
            }
        } else if (i2 == 2) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGIndoorParkC", "parseStallData-> TYPE_STALL_RECOMMEND，oldStall=" + this.b.toString());
            }
            if (this.b.g() == null) {
                if (gVar2.d()) {
                    gVar2.e("RGIndoorParkC", "parseStallData-> curStall == null!! return");
                    return;
                }
                return;
            } else {
                this.j = z;
                a(this.b.g(), 2);
                this.b.a(2);
            }
        } else if (i2 == 3) {
            this.b.a(1);
        } else if (i2 == 4) {
            this.b.a(5);
        }
        eVar.c((RoutePlanNode) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(o.a aVar, int i2) {
        if (aVar == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGIndoorParkC", "changeIndoorParkStall-> stall = null!!!");
            }
            return false;
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e("RGIndoorParkC", "changeIndoorParkStall-> stall = " + aVar.toString() + ", entry =" + i2);
        }
        GeoPoint geoPoint = new GeoPoint();
        geoPoint.setLatitudeE6(aVar.d());
        geoPoint.setLongitudeE6(aVar.c());
        if (!geoPoint.isValid()) {
            if (gVar2.d()) {
                gVar2.e("RGIndoorParkC", "changeIndoorParkStall-> !gp.isValid , carGeoPt = " + geoPoint.toString());
            }
            return false;
        }
        com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        RoutePlanNode mo81clone = fVar.g() != null ? fVar.g().mo81clone() : null;
        RoutePlanNode routePlanNode = new RoutePlanNode(geoPoint, 8, aVar.a(), (String) null, aVar.b());
        routePlanNode.mNodeType = 0;
        if (!com.baidu.navisdk.ui.routeguide.b.V().l().a(routePlanNode, i2)) {
            return false;
        }
        this.b.a(mo81clone);
        this.n = mo81clone;
        this.i = BNRoutePlaner.getInstance().v();
        com.baidu.navisdk.vi.b.a(this.x);
        return true;
    }

    @Override // com.baidu.navisdk.ui.routeguide.control.indoorpark.a
    public o a() {
        return this.b;
    }
}
