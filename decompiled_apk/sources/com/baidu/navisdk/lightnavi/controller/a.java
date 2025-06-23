package com.baidu.navisdk.lightnavi.controller;

import android.os.Bundle;
import android.os.Message;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.routeplan.e;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.garmin.fit.OxXXx0X;

/* loaded from: classes7.dex */
public class a extends com.baidu.navisdk.comapi.base.a {
    private static final String g = "a";
    private static volatile a h;

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.lightnavi.listener.a f6874a;
    private l b;
    private com.baidu.navisdk.lightnavi.data.a c;
    private com.baidu.navisdk.util.worker.loop.b d = new HandlerC0204a("LNM");
    private com.baidu.navisdk.comapi.routeplan.v2.a e = new b();
    private com.baidu.navisdk.comapi.base.b f = new c(this);

    /* renamed from: com.baidu.navisdk.lightnavi.controller.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class HandlerC0204a extends com.baidu.navisdk.util.worker.loop.b {
        public HandlerC0204a(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.comapi.base.d
        public void careAbout() {
            observe(4437);
            observe(4612);
            observe(4613);
            observe(4211);
            observe(4212);
            observe(4107);
            observe(4098);
            observe(4172);
            observe(4216);
            observe(4100);
            observe(4422);
            observe(4113);
            observe(4104);
            observe(4105);
            observe(4106);
            observe(4404);
            observe(4152);
            observe(4153);
            observe(4116);
            observe(4171);
            observe(4423);
            observe(4424);
            observe(4219);
            observe(4418);
            observe(4213);
            observe(4214);
            observe(4417);
            observe(4405);
            observe(4429);
            observe(OxXXx0X.XoI0OoX);
            observe(4383);
            observe(4385);
            observe(4384);
            observe(OxXXx0X.Xx0OXIoI);
            observe(4420);
        }

        @Override // com.baidu.navisdk.util.worker.loop.b
        public void onMessage(Message message) {
            boolean z;
            if (LogUtil.LOGGABLE) {
                String str = a.g;
                StringBuilder sb = new StringBuilder();
                sb.append("msg.what =");
                sb.append(message.what);
                sb.append("-->");
                sb.append(message.what - 4096);
                sb.append("，msg.arg1 = ");
                sb.append(message.arg1);
                sb.append("，msg.arg2 = ");
                sb.append(message.arg2);
                LogUtil.e(str, sb.toString());
            }
            boolean z2 = false;
            switch (message.what) {
                case 4098:
                    int i = message.arg1;
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (i != 6) {
                                    if (i != 12) {
                                        return;
                                    }
                                } else {
                                    if (a.this.f6874a != null) {
                                        a.this.f6874a.a(message);
                                        return;
                                    }
                                    return;
                                }
                            } else {
                                if (LogUtil.LOGGABLE) {
                                    LogUtil.e(a.g, "雷达 偏航结束");
                                }
                                if (a.this.f6874a != null) {
                                    a.this.f6874a.e(message);
                                    return;
                                }
                                return;
                            }
                        }
                        if (LogUtil.LOGGABLE) {
                            if (i == 12) {
                                LogUtil.e(a.g, "雷达 静默偏航");
                            } else {
                                LogUtil.e(a.g, "雷达 偏航");
                            }
                        }
                        if (a.this.f6874a != null) {
                            a.this.f6874a.d(message);
                            return;
                        }
                        return;
                    }
                    if (a.this.f6874a != null) {
                        a.this.f6874a.a();
                        return;
                    }
                    return;
                case 4100:
                case 4113:
                    if (a.this.f6874a != null) {
                        a.this.f6874a.b(message);
                        return;
                    }
                    return;
                case 4107:
                    if (a.this.f6874a != null) {
                        a.this.f6874a.q(message);
                        return;
                    }
                    return;
                case 4116:
                    if (a.this.f6874a != null) {
                        com.baidu.navisdk.lightnavi.listener.a aVar = a.this.f6874a;
                        if (message.arg1 == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        aVar.b(z);
                    }
                    com.baidu.navisdk.lightnavi.data.a c = a.this.c();
                    if (message.arg1 == 1) {
                        z2 = true;
                    }
                    c.a(z2);
                    a.this.n();
                    return;
                case 4152:
                    if (a.this.f6874a != null) {
                        a.this.f6874a.b(false);
                    }
                    a.this.c().a(false);
                    return;
                case 4153:
                    if (a.this.f6874a != null) {
                        a.this.f6874a.b(true);
                    }
                    a.this.c().a(true);
                    return;
                case OxXXx0X.xOOxX /* 4169 */:
                    if (a.this.f6874a != null) {
                        a.this.f6874a.l(message);
                        return;
                    }
                    return;
                case 4171:
                    int i2 = message.arg1;
                    if (a.this.f6874a != null) {
                        com.baidu.navisdk.lightnavi.listener.a aVar2 = a.this.f6874a;
                        if (i2 > 0) {
                            z2 = true;
                        }
                        aVar2.b(z2);
                        return;
                    }
                    return;
                case 4172:
                    if (a.this.f6874a != null) {
                        a.this.f6874a.i(message);
                        return;
                    }
                    return;
                case 4211:
                    if (a.this.f6874a != null) {
                        a.this.f6874a.g(message);
                        return;
                    }
                    return;
                case 4212:
                    if (a.this.f6874a != null) {
                        a.this.f6874a.m(message);
                        return;
                    }
                    return;
                case 4213:
                    com.baidu.navisdk.util.logic.j.r().r = true;
                    com.baidu.navisdk.util.logic.k.getInstance().a(com.baidu.navisdk.framework.a.c().a());
                    return;
                case 4214:
                    com.baidu.navisdk.util.logic.j.r().r = false;
                    com.baidu.navisdk.util.logic.k.getInstance().a();
                    return;
                case 4219:
                    if (a.this.f6874a != null) {
                        a.this.f6874a.a(message.arg1);
                        return;
                    }
                    return;
                case 4383:
                    if (a.this.f6874a != null) {
                        a.this.f6874a.n(message);
                        return;
                    }
                    return;
                case 4384:
                    if (a.this.f6874a != null) {
                        a.this.f6874a.j(message);
                        return;
                    }
                    return;
                case 4385:
                    if (a.this.f6874a != null) {
                        a.this.f6874a.z(message);
                        return;
                    }
                    return;
                case 4402:
                    a.this.c().a(message.arg1);
                    return;
                case 4404:
                    if (a.this.f6874a != null) {
                        a.this.f6874a.k(message);
                        return;
                    }
                    return;
                case 4405:
                    a.this.c().c(message.arg1);
                    return;
                case 4413:
                    if (a.this.f6874a != null) {
                        a.this.f6874a.b(false);
                    }
                    a.this.c().a(false);
                    return;
                case 4417:
                    if (message.arg1 == 1) {
                        a.this.b(message.arg2);
                        return;
                    }
                    return;
                case 4418:
                    a.this.d(message.arg1);
                    return;
                case 4420:
                    if (a.this.f6874a != null) {
                        a.this.f6874a.c(message);
                        return;
                    }
                    return;
                case 4422:
                    if (a.this.f6874a != null) {
                        a.this.f6874a.f(message);
                        return;
                    }
                    return;
                case 4423:
                    if (a.this.f6874a != null) {
                        a.this.f6874a.r(message);
                        return;
                    }
                    return;
                case 4424:
                    if (a.this.f6874a != null) {
                        a.this.f6874a.o(message);
                        return;
                    }
                    return;
                case 4429:
                    com.baidu.navisdk.lightnavi.data.a c2 = a.this.c();
                    if (message.arg1 == 0) {
                        z2 = true;
                    }
                    c2.c(z2);
                    a.this.n();
                    return;
                case OxXXx0X.Xx0OXIoI /* 4432 */:
                    if (a.this.f6874a != null) {
                        a.this.f6874a.b(message.arg1);
                        return;
                    }
                    return;
                case OxXXx0X.XoI0OoX /* 4433 */:
                    if (a.this.f6874a != null) {
                        a.this.f6874a.s(message);
                        return;
                    }
                    return;
                case 4437:
                    if (a.this.f6874a != null) {
                        a.this.f6874a.a(message.arg1, message.arg2);
                        return;
                    }
                    return;
                case 4612:
                    if (a.this.f6874a != null) {
                        a.this.f6874a.h(message);
                        return;
                    }
                    return;
                case 4613:
                    if (a.this.f6874a != null) {
                        a.this.f6874a.p(message);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends com.baidu.navisdk.comapi.routeplan.v2.a {
        public b() {
        }

        @Override // com.baidu.navisdk.comapi.routeplan.v2.a
        public String getName() {
            return "Light-Naving-RP";
        }

        @Override // com.baidu.navisdk.comapi.routeplan.v2.a
        public boolean isPersist() {
            return true;
        }

        @Override // com.baidu.navisdk.comapi.routeplan.v2.a
        public boolean mustOnMainThread() {
            return true;
        }

        @Override // com.baidu.navisdk.comapi.routeplan.v2.a
        public void onRoutePlan(int i, int i2, com.baidu.navisdk.comapi.routeplan.v2.d dVar, Bundle bundle) {
            if (i != 1) {
                if (i != 5) {
                    if (i != 145) {
                        if (i != 97) {
                            if (i == 98) {
                                LogUtil.e(a.g, "IPO_NORMAL_FAILED");
                                if (a.this.f6874a != null) {
                                    a.this.f6874a.d();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        LogUtil.e(a.g, "onRoutePlan IPO_NORMAL_SUCCESS");
                        if (a.this.f6874a != null) {
                            a.this.f6874a.e();
                            return;
                        }
                        return;
                    }
                    LogUtil.e(a.g, "SYNC_OPERATION");
                    if (a.this.f6874a != null) {
                        a.this.f6874a.b();
                        return;
                    }
                    return;
                }
                LogUtil.e(a.g, "RP_NORMAL_CANCLE");
                return;
            }
            LogUtil.e(a.g, "RP_NORMAL_START");
            if (a.this.f6874a != null) {
                a.this.f6874a.c();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements com.baidu.navisdk.comapi.base.b {
        public c(a aVar) {
        }

        @Override // com.baidu.navisdk.comapi.base.b
        public void update(com.baidu.navisdk.comapi.base.c cVar, int i, int i2, Object obj) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(a.g, "bnObserver type:" + i + ",event:" + i2);
            }
            if (1 == i && LogUtil.LOGGABLE && obj != null && (obj instanceof e.c)) {
                String str = a.g;
                StringBuilder sb = new StringBuilder();
                sb.append("TYPE_ROUTE_PLAN mFailType:");
                e.c cVar2 = (e.c) obj;
                sb.append(cVar2.f6721a);
                sb.append(",mFailText:");
                sb.append(cVar2.b);
                LogUtil.e(str, sb.toString());
            }
        }
    }

    private a() {
        LogUtil.e(g, "--BNLightNaviManager");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        String str = g;
        LogUtil.e(str, "handleMainSlaveViaductResultMsg source:" + i);
        if (i == 3) {
            if (com.baidu.navisdk.naviresult.a.d().a().c() != 0 && com.baidu.navisdk.naviresult.a.d().a().c() != 1) {
                com.baidu.navisdk.naviresult.a.d().a().b(3);
            } else {
                com.baidu.navisdk.naviresult.a.d().a().b(1);
            }
        } else if (i == 4) {
            if (com.baidu.navisdk.naviresult.a.d().a().c() != 0 && com.baidu.navisdk.naviresult.a.d().a().c() != 1) {
                com.baidu.navisdk.naviresult.a.d().a().b(3);
            } else {
                com.baidu.navisdk.naviresult.a.d().a().b(1);
            }
        } else if (i == 5) {
            if (com.baidu.navisdk.naviresult.a.d().a().c() != 0 && com.baidu.navisdk.naviresult.a.d().a().c() != 2) {
                com.baidu.navisdk.naviresult.a.d().a().b(3);
            } else {
                com.baidu.navisdk.naviresult.a.d().a().b(2);
            }
        } else if (i == 6) {
            if (com.baidu.navisdk.naviresult.a.d().a().c() != 0 && com.baidu.navisdk.naviresult.a.d().a().c() != 2) {
                com.baidu.navisdk.naviresult.a.d().a().b(2);
            } else {
                com.baidu.navisdk.naviresult.a.d().a().b(2);
            }
        } else if (i == 7) {
            LogUtil.e(str, "handleMainSlaveViaductResultMsg UNKNOWN_ROUTE_PLAN_RESULT");
        }
        e(i);
    }

    public static a getInstance() {
        if (h == null) {
            synchronized (a.class) {
                try {
                    if (h == null) {
                        h = new a();
                    }
                } finally {
                }
            }
        }
        return h;
    }

    public void b(int i) {
        Bundle bundle = new Bundle();
        if (JNIGuidanceControl.getInstance().GetViaPoint(i, bundle)) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(g, "onArriveViaPoint: index --> " + i + ", bundle: " + bundle);
            }
            int i2 = (int) (bundle.getDouble("x") * 100000.0d);
            int i3 = (int) (bundle.getDouble("y") * 100000.0d);
            bundle.getInt(MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE);
            com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.a(new GeoPoint(i2, i3));
            return;
        }
        LogUtil.e(g, "onArriveViaPoint: Error --> GetViaPoint returns false");
    }

    public void c(boolean z) {
        com.baidu.navisdk.lightnavi.listener.a aVar = this.f6874a;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    public void e() {
        this.b = new l();
        this.c = new com.baidu.navisdk.lightnavi.data.a();
        com.baidu.navisdk.vi.b.a(this.d);
        BNRoutePlaner.getInstance().a(this.e, true);
        BNRoutePlaner.getInstance().addObserver(this.f);
    }

    public void f() {
        l lVar = this.b;
        if (lVar != null) {
            lVar.c();
        }
    }

    public boolean g() {
        return c().c();
    }

    public boolean h() {
        return c().d();
    }

    public synchronized boolean i() {
        l lVar = this.b;
        if (lVar == null) {
            return false;
        }
        return lVar.e();
    }

    public boolean j() {
        if (a() > b()) {
            return true;
        }
        return false;
    }

    public boolean k() {
        return c().e();
    }

    public boolean l() {
        if (h() && g()) {
            return true;
        }
        return false;
    }

    public void m() {
        LogUtil.e(g, "unInit");
        BNRoutePlaner.getInstance().b(this.e);
        com.baidu.navisdk.vi.b.b(this.d);
        BNRoutePlaner.getInstance().deleteObserver(this.f);
        com.baidu.navisdk.util.logic.k.getInstance().a();
        l lVar = this.b;
        if (lVar != null) {
            lVar.g();
        }
        this.b = null;
        this.c = null;
        h = null;
        this.f6874a = null;
    }

    public void n() {
        boolean z;
        if (this.f6874a != null) {
            if (k() && j() && l()) {
                z = true;
            } else {
                z = false;
            }
            this.f6874a.a(a(), z, k());
        }
    }

    public static void a(Bundle bundle) {
        JNIGuidanceControl.getInstance().getRemainRouteInfo(bundle);
    }

    public void c(int i) {
        l lVar = this.b;
        if (lVar != null) {
            lVar.a(i);
        }
    }

    public boolean a(int i) {
        return com.baidu.navisdk.lightnavi.controller.b.c().a(i) > 0;
    }

    public void a(boolean z) {
        c(z ? 2 : -1);
    }

    public com.baidu.navisdk.lightnavi.data.a c() {
        com.baidu.navisdk.lightnavi.data.a aVar = this.c;
        return aVar == null ? new com.baidu.navisdk.lightnavi.data.a() : aVar;
    }

    private void e(int i) {
        TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), com.baidu.navisdk.framework.a.c().a().getResources().getStringArray(R.array.main_aux_bridge_change_ret)[i - 3]);
        com.baidu.navisdk.lightnavi.listener.a aVar = this.f6874a;
        if (aVar != null) {
            aVar.c(i);
        }
    }

    public int a() {
        return c().a();
    }

    public void a(float f) {
        if (f >= 0.0f) {
            c().b((int) (f * 3.6d));
        }
    }

    public void a(com.baidu.navisdk.lightnavi.listener.a aVar) {
        this.f6874a = aVar;
    }

    public int b() {
        return c().b();
    }

    public void b(boolean z) {
        c().b(z);
    }

    public com.baidu.navisdk.lightnavi.listener.b d() {
        l lVar = this.b;
        if (lVar != null) {
            return lVar.b();
        }
        return null;
    }
}
