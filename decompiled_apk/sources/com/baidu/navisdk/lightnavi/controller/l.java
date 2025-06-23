package com.baidu.navisdk.lightnavi.controller;

import android.app.Activity;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.s;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.f0;
import com.baidu.navisdk.util.common.n;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.ProNaviStatItem;
import com.baidu.navisdk.util.statistic.m;

/* loaded from: classes7.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f6885a;
    public boolean b;
    private com.baidu.navisdk.model.datastruct.g c;
    private com.baidu.navisdk.util.logic.f d;
    private com.baidu.navisdk.util.worker.f<String, String> g;
    private ContentObserver e = null;
    private com.baidu.navisdk.lightnavi.listener.b f = null;
    private final com.baidu.navisdk.comapi.geolocate.a h = new b();
    com.baidu.navisdk.util.worker.loop.a i = new f(this, "LightRouteGuideScene");

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.util.worker.f<String, String> {
        public a(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            if (BNSettingManager.isShowJavaLog()) {
                TipTool.onCreateToastDialog(l.this.k(), "提示：丢星超过60秒重新添加系统Gps监听");
            }
            l.this.b = true;
            com.baidu.navisdk.util.statistic.userop.b.r().a("8.3.6", null, null, null);
            SDKDebugFileUtil.get(SDKDebugFileUtil.NAVING_FLPLOC_FILENAME).add("lost Satellites more than 60s ReAddGpsLocation");
            l.this.h();
            l.this.a();
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends com.baidu.navisdk.comapi.geolocate.a {

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public a(b bVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.baidu.navisdk.lightnavi.controller.a.getInstance().n();
            }
        }

        /* renamed from: com.baidu.navisdk.lightnavi.controller.l$b$b, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0205b implements Runnable {
            public RunnableC0205b(b bVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.baidu.navisdk.lightnavi.controller.a.getInstance().n();
            }
        }

        public b() {
        }

        @Override // com.baidu.navisdk.comapi.geolocate.a, com.baidu.navisdk.comapi.geolocate.b
        public void onGpsStatusChange(boolean z, boolean z2) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
            gVar.a("From app: onGpsStatusChange enabled=" + z + ", available=" + z2);
            if (gVar.b()) {
                TipTool.onCreateToastDialog(l.this.k(), "来自应用: onGpsStatusChange enabled=" + z + ", available=" + z2);
                SDKDebugFileUtil.get(SDKDebugFileUtil.SYSLOC_FILENAME).add("From app: onGpsStatusChange enabled=" + z + ", available=" + z2);
            }
            com.baidu.navisdk.lightnavi.controller.a.getInstance().b(z);
            l.this.i.post(new a(this));
        }

        @Override // com.baidu.navisdk.comapi.geolocate.b
        public void onLocationChange(com.baidu.navisdk.model.datastruct.g gVar) {
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x0170, code lost:
        
            if (r1 != 3) goto L39;
         */
        @Override // com.baidu.navisdk.comapi.geolocate.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onWGS84LocationChange(com.baidu.navisdk.model.datastruct.g r32, com.baidu.navisdk.model.datastruct.g r33) {
            /*
                Method dump skipped, instructions count: 529
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.lightnavi.controller.l.b.onWGS84LocationChange(com.baidu.navisdk.model.datastruct.g, com.baidu.navisdk.model.datastruct.g):void");
        }
    }

    /* loaded from: classes7.dex */
    public class c extends Handler {
        public c(l lVar) {
        }
    }

    /* loaded from: classes7.dex */
    public class d extends ContentObserver {
        public d(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            l.this.a(true);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public e(l lVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogUtil.e("LightRouteGuideScene", "--reset");
        }
    }

    /* loaded from: classes7.dex */
    public class f extends com.baidu.navisdk.util.worker.loop.a {
        public f(l lVar, String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            super.onMessage(message);
        }
    }

    private Activity j() {
        return com.baidu.navisdk.lightnavi.controller.f.n().b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context k() {
        return com.baidu.navisdk.lightnavi.controller.f.n().c();
    }

    public com.baidu.navisdk.lightnavi.listener.b b() {
        return this.f;
    }

    public void c() {
        this.f6885a = true;
        a("9");
        com.baidu.navisdk.module.pronavi.a.j = 6;
        BNRouteGuider.getInstance().setLocateMode(1);
        BNRoutePlaner.getInstance().j(com.baidu.navisdk.util.logic.g.j().b());
        if (!com.baidu.navisdk.util.logic.j.r().B) {
            com.baidu.navisdk.util.logic.j.r().n();
        }
        BNRouteGuider.getInstance().startRouteGuide(true, 99);
        com.baidu.navisdk.util.logic.g.j().a(k());
        a();
        s.c();
        com.baidu.navisdk.util.statistic.i.b = SystemClock.elapsedRealtime();
        n.d().b(200);
        if (!com.baidu.navisdk.lightnavi.controller.b.c().a()) {
            m.d().b(k());
        }
        com.baidu.navisdk.module.pronavi.model.h.c = false;
        com.baidu.navisdk.module.a.h().a().d = true;
        a(false);
        d();
    }

    public void d() {
        if (Build.VERSION.SDK_INT < 23 && k() != null) {
            if (this.e == null) {
                this.e = new d(new c(this));
            }
            if (k() != null && k().getContentResolver() != null) {
                k().getContentResolver().registerContentObserver(Settings.Secure.getUriFor("mock_location"), false, this.e);
            }
        }
    }

    public boolean e() {
        return this.f6885a;
    }

    public com.baidu.navisdk.util.worker.f<String, String> f() {
        if (this.g == null) {
            this.g = new a("ReAddGpsLocationTask", null);
        }
        return this.g;
    }

    public void g() {
        f0.d().a().post(new e(this));
        com.baidu.navisdk.util.worker.loop.a aVar = this.i;
        if (aVar != null) {
            aVar.removeCallbacksAndMessages(null);
        }
    }

    public void h() {
        com.baidu.navisdk.util.logic.f fVar = this.d;
        if (fVar != null) {
            fVar.b(this.h);
            this.d.i();
        }
    }

    public void i() {
        if (Build.VERSION.SDK_INT >= 23) {
            return;
        }
        Activity j = j();
        if (j == null) {
            j = com.baidu.navisdk.lightnavi.controller.f.n().b();
        }
        if (j != null && this.e != null && j.getContentResolver() != null) {
            j.getContentResolver().unregisterContentObserver(this.e);
        }
    }

    public void a(int i) {
        this.f6885a = false;
        com.baidu.navisdk.module.pronavi.a.j = 0;
        BNRouteGuider.getInstance().stopRouteGuide();
        n.d().b(201);
        ProNaviStatItem.O().l();
        if (i != 2) {
            com.baidu.navisdk.module.a.h().a(com.baidu.navisdk.lightnavi.controller.f.n().b(), 1, false);
            com.baidu.navisdk.module.a.h().n = false;
            BNSettingManager.setQuitForExceptionInNaviMode(false);
        }
        h();
        i();
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) f(), false);
        com.baidu.navisdk.framework.interfaces.k k = com.baidu.navisdk.framework.interfaces.c.p().k();
        if (k != null) {
            k.a();
        }
    }

    private void a(String str) {
        com.baidu.navisdk.lightnavi.listener.b bVar = this.f;
        if (bVar != null) {
            bVar.a(str);
        }
    }

    public void a() {
        if (5 == com.baidu.navisdk.module.pronavi.a.j) {
            this.d = com.baidu.navisdk.util.logic.a.j();
        }
        int i = com.baidu.navisdk.module.pronavi.a.j;
        if (1 == i || 6 == i) {
            this.d = com.baidu.navisdk.util.logic.c.k();
            com.baidu.navisdk.util.statistic.userop.b.r().a("8.3.3", "1", null, null);
        }
        if (this.d == null) {
            this.d = com.baidu.navisdk.util.logic.c.k();
            com.baidu.navisdk.util.statistic.userop.b.r().a("8.3.3", "1", null, null);
        }
        if (this.d != null) {
            com.baidu.navisdk.util.logic.g.j().a(this.d);
            if (!com.baidu.navisdk.util.logic.j.r().B) {
                com.baidu.navisdk.util.logic.j.r().n();
            }
            if (this.d.a(k())) {
                com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) f(), false);
            } else {
                com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) f(), false);
                com.baidu.navisdk.util.worker.c.a().a(f(), new com.baidu.navisdk.util.worker.e(2, 0), 5000L);
            }
            this.d.a(this.h);
        }
    }

    public void a(boolean z) {
        if (Build.VERSION.SDK_INT < 23 && k() != null) {
            int i = Settings.Secure.getInt(k().getContentResolver(), "mock_location", 0);
            if (i == 1 && com.baidu.navisdk.module.a.h().a() != null) {
                com.baidu.navisdk.module.a.h().a().d = false;
            }
            if (i != 1 || com.baidu.navisdk.module.pronavi.model.h.c) {
                return;
            }
            com.baidu.navisdk.module.pronavi.model.h.c = true;
            if (!z) {
                LogUtil.e("LightRouteGuideScene", "");
            } else {
                TipTool.onCreateToastDialog(k(), JarUtils.getResources().getString(R.string.nsdk_string_rg_mock_gps_open));
            }
        }
    }
}
