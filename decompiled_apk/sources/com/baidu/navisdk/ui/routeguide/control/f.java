package com.baidu.navisdk.ui.routeguide.control;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.ProNaviStatItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.google.android.exoplayer2.ExoPlayer;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class f {
    private static volatile f d;

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.e f8540a;
    private boolean b = false;
    private final Handler c = new a("RGArriveDestParkController");

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.loop.a {
        public a(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            int i = message.what;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        f.this.a(message.arg1);
                        return;
                    }
                    return;
                } else {
                    com.baidu.navisdk.util.statistic.userop.b.r().b("3.y.2.4");
                    com.baidu.navisdk.ui.routeguide.b.V().Q();
                    return;
                }
            }
            TTSPlayerControl.playTTS(JarUtils.getResources().getString(R.string.nsdk_string_rg_arrive_find_park, Integer.valueOf(com.baidu.navisdk.ui.routeguide.model.a.c().f8926a.size())), 0);
        }
    }

    private f() {
    }

    public static f k() {
        if (d == null) {
            synchronized (f.class) {
                try {
                    if (d == null) {
                        d = new f();
                    }
                } finally {
                }
            }
        }
        return d;
    }

    private void l() {
        if (2 != com.baidu.navisdk.module.pronavi.a.j) {
            com.baidu.navisdk.comapi.commontool.c.c().a(com.baidu.navisdk.framework.a.c().a(), System.currentTimeMillis() / 1000);
            com.baidu.navisdk.comapi.commontool.c.c().a(com.baidu.navisdk.framework.a.c().a(), com.baidu.navisdk.comapi.commontool.c.c);
        }
    }

    private void m() {
        c();
        j();
        this.f8540a = null;
        this.c.removeMessages(0);
        this.c.removeMessages(1);
        this.c.removeMessages(2);
    }

    public void a() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArriveDestParkController - DestRemind", "enterParkState");
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
    }

    public void b(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArriveDestParkController - DestRemind", "onParkDataFail");
        }
        j();
        if (!com.baidu.navisdk.ui.routeguide.model.a.c().d) {
            if (gVar.d()) {
                gVar.e("RGArriveDestParkController - DestRemind", "onParkDataFail parkstate has exit");
                return;
            }
            return;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.y.2.1", "99", "" + i, null);
        ProNaviStatItem.O().m(99);
        x.b().X0();
        if (com.baidu.navisdk.ui.routeguide.b.V().j() != null) {
            com.baidu.navisdk.ui.routeguide.b.V().j().b().a(false);
        }
    }

    public void c() {
        if (!this.b) {
            return;
        }
        this.b = false;
        com.baidu.navisdk.poisearch.c.b();
        com.baidu.navisdk.poisearch.c.a();
        com.baidu.navisdk.ui.routeguide.model.a.c().a();
        BNMapController.getInstance().updateLayer(4);
        BNMapController.getInstance().clearLayer(4);
        BNMapController.getInstance().showLayer(4, false);
    }

    public void d() {
        m();
        com.baidu.navisdk.ui.routeguide.b.V().Q();
    }

    public void e() {
        m();
    }

    public void f() {
        boolean z;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArriveDestParkController - DestRemind", "onParkDataReady");
        }
        if (!com.baidu.navisdk.ui.routeguide.model.a.c().d) {
            if (gVar.d()) {
                gVar.e("RGArriveDestParkController - DestRemind", "onParkDataReady parkstate has exit");
                return;
            }
            return;
        }
        x.b().X0();
        int size = com.baidu.navisdk.ui.routeguide.model.a.c().f8926a.size();
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.y.2.1", "" + size, null, null);
        ProNaviStatItem.O().m(size);
        if (com.baidu.navisdk.ui.routeguide.b.V().j() != null) {
            g b = com.baidu.navisdk.ui.routeguide.b.V().j().b();
            if (size > 0) {
                z = true;
            } else {
                z = false;
            }
            b.a(z);
        }
    }

    public void g() {
        l();
        TTSPlayerControl.stopVoiceTTSOutput();
        com.baidu.navisdk.ui.routeguide.b.V().b(false);
        a0.I().t = false;
        if (com.baidu.navisdk.ui.routeguide.model.a.c().b < 0) {
            com.baidu.navisdk.ui.routeguide.model.a.c().b = 0;
        }
        ArrayList<com.baidu.navisdk.model.datastruct.r> arrayList = com.baidu.navisdk.ui.routeguide.model.a.c().f8926a;
        if (arrayList.size() != 0 && com.baidu.navisdk.ui.routeguide.model.a.c().b < arrayList.size()) {
            com.baidu.navisdk.model.datastruct.r rVar = arrayList.get(com.baidu.navisdk.ui.routeguide.model.a.c().b);
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MSG_EXIT_ARRIVE_DEST);
            l.l().a(rVar.j, rVar.c, rVar.m);
            i.g().b(1000);
            m();
            x.b().l3();
            if (com.baidu.navisdk.ui.routeguide.b.V().j() != null) {
                g b = com.baidu.navisdk.ui.routeguide.b.V().j().b();
                b.a().f();
                b.a().a((Bitmap) null);
                return;
            }
            return;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArriveDestParkController - DestRemind", "onReRoutePlanClick error outOfRange");
        }
        x.b().X0();
        com.baidu.navisdk.ui.routeguide.b.V().Q();
    }

    public void h() {
        this.c.sendEmptyMessageDelayed(0, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        i();
        a(false);
        this.c.sendMessageDelayed(this.c.obtainMessage(2, 0, 0), 1000L);
    }

    public void i() {
        this.c.sendEmptyMessageDelayed(1, 20000L);
    }

    public void j() {
        this.c.removeMessages(1);
    }

    public int b() {
        return JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_314dp);
    }

    public void a(boolean z) {
        int dip2px;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGArriveDestParkController - DestRemind", "showParkPopOnMap -> isArriveReminderCard=" + z);
        }
        this.b = true;
        GeoPoint geoPoint = ((com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel")).g().getGeoPoint();
        ArrayList<com.baidu.navisdk.model.datastruct.r> arrayList = com.baidu.navisdk.ui.routeguide.model.a.c().f8926a;
        int size = arrayList == null ? 0 : arrayList.size();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<GeoPoint> arrayList3 = new ArrayList<>();
        for (int i = 0; arrayList != null && i < size; i++) {
            com.baidu.navisdk.model.datastruct.r rVar = arrayList.get(i);
            if (rVar != null) {
                arrayList2.add(rVar.c);
                arrayList3.add(rVar.c);
                arrayList3.add(a(rVar.c, geoPoint));
            }
        }
        com.baidu.navisdk.poisearch.c.a((ArrayList<GeoPoint>) arrayList2, 9, 0, 0);
        BNMapController.getInstance().updateLayer(4);
        BNMapController.getInstance().showLayer(4, true);
        int dip2px2 = ScreenUtil.getInstance().dip2px(25);
        int dip2px3 = ScreenUtil.getInstance().dip2px(10);
        boolean z2 = x.b().d0() == 1;
        Rect rect = new Rect();
        com.baidu.navisdk.pronavi.util.a aVar = com.baidu.navisdk.pronavi.util.a.h;
        int d2 = aVar.d();
        int e = aVar.e();
        if (com.baidu.navisdk.ui.routeguide.b.V().E()) {
            if (z2) {
                dip2px = ScreenUtil.getInstance().dip2px(com.baidu.navisdk.module.pronavi.a.u);
            } else {
                dip2px = ScreenUtil.getInstance().dip2px(com.baidu.navisdk.module.pronavi.a.t);
            }
            d2 -= dip2px;
        }
        if (z2) {
            int a2 = com.baidu.navisdk.ui.routeguide.mapmode.subview.parkinglot.c.a(arrayList, true);
            if (z) {
                a2 = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_292dp);
            }
            rect.left = dip2px3;
            rect.top = d2 - dip2px2;
            rect.right = e - dip2px3;
            rect.bottom = a2 + dip2px3;
        } else {
            rect.left = dip2px3;
            rect.top = e - dip2px2;
            rect.right = (d2 - b()) - dip2px3;
            rect.bottom = dip2px3;
        }
        GeoPoint a3 = com.baidu.navisdk.util.logic.h.a();
        if (a3 != null && a3.isValid()) {
            arrayList3.add(a3);
            arrayList3.add(a(a3, geoPoint));
        }
        arrayList3.add(geoPoint);
        q.c().a(arrayList3, rect, z2);
    }

    private GeoPoint a(GeoPoint geoPoint, GeoPoint geoPoint2) {
        GeoPoint geoPoint3 = new GeoPoint();
        int longitudeE6 = (geoPoint2.getLongitudeE6() * 2) - geoPoint.getLongitudeE6();
        int latitudeE6 = (geoPoint2.getLatitudeE6() * 2) - geoPoint.getLatitudeE6();
        geoPoint3.setLongitudeE6(longitudeE6);
        geoPoint3.setLatitudeE6(latitudeE6);
        return geoPoint3;
    }

    public void a(int i) {
        ArrayList<com.baidu.navisdk.model.datastruct.r> arrayList;
        if (com.baidu.navisdk.ui.util.g.a(500L) || (arrayList = com.baidu.navisdk.ui.routeguide.model.a.c().f8926a) == null || arrayList.size() == 0 || i >= arrayList.size() || i < 0) {
            return;
        }
        com.baidu.navisdk.ui.routeguide.model.a.c().a(i);
        if (this.f8540a == null) {
            this.f8540a = new com.baidu.navisdk.ui.routeguide.mapmode.subview.e();
        }
        i.g().f();
        i.g().a(this.f8540a);
        BNMapController.getInstance().focusItem(4, i, true);
    }
}
