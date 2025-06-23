package com.baidu.navisdk.skyeye;

import android.app.Activity;
import com.baidu.navisdk.ui.widget.BNUserKeyLogDialog;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.o0;
import com.baidu.navisdk.util.worker.f;

/* loaded from: classes7.dex */
public class a {
    private static volatile a j;

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.skyeye.c f7993a;
    private final com.baidu.navisdk.skyeye.log.c c;
    private BNUserKeyLogDialog d;
    private com.baidu.navisdk.skyeye.view.a b = null;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private final f h = new c("execute-mNavInitMonitor", null);
    private final f i = new d("execute-mNavRoutePlanMonitor", null);

    /* renamed from: com.baidu.navisdk.skyeye.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0364a extends com.baidu.navisdk.util.worker.lite.b {
        public C0364a(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            a.this.a(com.baidu.navisdk.module.cloudconfig.f.c().c.c0);
        }
    }

    /* loaded from: classes7.dex */
    public class b extends f<String, String> {
        public b(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            if (!a.this.f7993a.d) {
                try {
                    a.this.f7993a.a(a.this.c.b());
                    com.baidu.navisdk.util.statistic.userop.b.r().d("7.2.3", a.this.f7993a.e + "");
                } catch (Exception e) {
                    a.this.f7993a.d = false;
                    g gVar = g.EYE_SPY;
                    if (gVar.c()) {
                        gVar.c("uploadLogFile err :" + e);
                    }
                }
                return null;
            }
            g gVar2 = g.EYE_SPY;
            if (gVar2.d()) {
                gVar2.e(com.baidu.navisdk.util.worker.g.TAG, "uploadLog isUploading return:");
            }
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends f<String, String> {
        public c(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            g.EYE_SPY.a("mNavInitMonitor run");
            a.this.a(4, 255, "导航初始化1分钟超时");
            com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) a.this.h, false);
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public class d extends f<String, String> {
        public d(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            g.ROUTE_PLAN.a("mNavRoutePlanMonitor run");
            a.this.a(16, 255, "算路时间超过1分钟");
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public class e extends com.baidu.navisdk.util.worker.lite.b {
        public e(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            g.ROUTE_PLAN.a("mIntelliDriveMonitor run");
            a.this.a(256, 255, "驾车页智能出行卡片loading超过10秒!");
        }
    }

    private a() {
        this.f7993a = null;
        new e("BNUserKeyLogController::mIntelliDriveMonitor");
        this.f7993a = new com.baidu.navisdk.skyeye.c();
        this.c = new com.baidu.navisdk.skyeye.log.c(com.baidu.navisdk.framework.a.c().a());
    }

    public static a n() {
        if (j == null) {
            synchronized (a.class) {
                try {
                    if (j == null) {
                        j = new a();
                    }
                } finally {
                }
            }
        }
        return j;
    }

    private void o() {
        o0.b().a(3001, null);
    }

    public com.baidu.navisdk.skyeye.c d() {
        return this.f7993a;
    }

    public void e() {
        this.e = false;
        com.baidu.navisdk.skyeye.view.a aVar = this.b;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void f() {
        this.c.a();
    }

    public boolean g() {
        com.baidu.navisdk.skyeye.log.a b2 = this.c.b();
        if (b2 == null || !this.c.e || (b2.h & 1) == 0) {
            return false;
        }
        return true;
    }

    public void h() {
        this.d = null;
    }

    public void i() {
        BNUserKeyLogDialog bNUserKeyLogDialog = this.d;
        if (bNUserKeyLogDialog != null && bNUserKeyLogDialog.isShowing()) {
            return;
        }
        a();
        n().f7993a.h = null;
        n().f7993a.c = false;
        k();
    }

    public void j() {
        this.e = true;
        if (!this.f) {
            g.EYE_SPY.e("BNUserKeyLogController", "showButton return isCloudEnd not");
            return;
        }
        if (!this.f7993a.e()) {
            g.EYE_SPY.e("BNUserKeyLogController", "showButton return isInTestPlaner false");
            return;
        }
        if (!com.baidu.navisdk.framework.b.f("android.settings.action.MANAGE_OVERLAY_PERMISSION")) {
            if (!this.g) {
                this.g = true;
                o();
                return;
            } else {
                g.EYE_SPY.e("BNUserKeyLogController", "showButton return hasRequestPermission");
                return;
            }
        }
        if (this.b == null) {
            this.b = new com.baidu.navisdk.skyeye.view.a();
        }
        this.b.c();
    }

    public void k() {
        Activity b2 = com.baidu.navisdk.framework.a.c().b();
        if (b2 == null) {
            g.EYE_SPY.e("BNUserKeyLogController", "showUserKeyLogDialog-> activity == null");
            return;
        }
        if (this.d == null) {
            this.d = new BNUserKeyLogDialog(b2);
        }
        if (!this.d.isShowing() && !b2.isFinishing()) {
            this.d.show();
        }
    }

    public void l() {
        g.EYE_SPY.a("BNUserKeyLogController", "startInitMonitor");
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.h, false);
        com.baidu.navisdk.util.worker.c.a().a(this.h, new com.baidu.navisdk.util.worker.e(2, 0), 60000L);
    }

    public void m() {
        g.ROUTE_PLAN.a("startRoutePlanMonitor");
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.i, false);
        com.baidu.navisdk.util.worker.c.a().a(this.i, new com.baidu.navisdk.util.worker.e(2, 0), 7000L);
    }

    public void b() {
        this.f = true;
        this.f7993a.d();
        if (this.e) {
            j();
        }
        com.baidu.navisdk.util.worker.lite.a.a((com.baidu.navisdk.util.worker.lite.b) new C0364a("onCloudOrPushCallBack"), 10001);
    }

    public void c() {
        g.ROUTE_PLAN.a("endRoutePlanMonitor :");
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.i, false);
    }

    public void a(g gVar, String str) {
        com.baidu.navisdk.util.statistic.userop.b.r().d("7.2.2", gVar.name());
        gVar.d(str);
        this.c.b(gVar.name());
    }

    public void a(boolean z) {
        if (z) {
            this.f7993a.a();
            j();
        } else {
            this.f7993a.f();
            e();
        }
    }

    public void b(boolean z) {
        g.EYE_SPY.a("endInitMonitor :" + z);
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.h, false);
        if (z) {
            return;
        }
        a(8, 255, "导航初始化失败");
    }

    public boolean a(int i, int i2, String str) {
        g gVar = g.EYE_SPY;
        gVar.a("uploadLog uploadSource:" + i + " logType:" + i2);
        if (this.f7993a.d) {
            gVar.a("BNUserKeyLogController", "uploadLog isUploading return:");
            return false;
        }
        com.baidu.navisdk.skyeye.c cVar = this.f7993a;
        cVar.e = i;
        cVar.f = i2;
        cVar.g = str;
        com.baidu.navisdk.util.worker.c.a().c(new b("CarNavi-UserKeyLog", null), new com.baidu.navisdk.util.worker.e(201, 0));
        return true;
    }

    public void a() {
        this.f7993a.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        this.c.a(str);
    }
}
