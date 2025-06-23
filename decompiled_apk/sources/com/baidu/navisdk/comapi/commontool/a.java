package com.baidu.navisdk.comapi.commontool;

import com.baidu.navisdk.comapi.commontool.sunrisedown.a;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.setting.SettingParams;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.x;
import com.baidu.navisdk.util.worker.e;
import com.baidu.navisdk.util.worker.f;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes7.dex */
public class a extends com.baidu.navisdk.comapi.base.c {
    private static Timer c;
    private static a d;

    /* renamed from: a, reason: collision with root package name */
    private Object f6701a = new Object();
    private boolean b;

    /* renamed from: com.baidu.navisdk.comapi.commontool.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0179a extends TimerTask {
        public C0179a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            LogUtil.e("TIMER", "Timer task get time to set navi mode");
            a.this.e();
        }
    }

    /* loaded from: classes7.dex */
    public class b extends f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6703a;
        final /* synthetic */ int b;
        final /* synthetic */ Object c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, int i, int i2, Object obj) {
            super(str, str2);
            this.f6703a = i;
            this.b = i2;
            this.c = obj;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            a.this.notifyObservers(this.f6703a, this.b, this.c);
            return null;
        }
    }

    private a() {
    }

    private boolean b() {
        return this.b;
    }

    private void c() {
        if (c == null) {
            try {
                Timer timer = new Timer(getClass().getSimpleName() + "_daynight", true);
                c = timer;
                timer.schedule(new C0179a(), 0L, 600000L);
                this.b = true;
            } catch (Throwable unused) {
                c = null;
            }
        }
    }

    private void d() {
        Timer timer = c;
        if (timer == null) {
            return;
        }
        timer.cancel();
        c = null;
        this.b = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        int i;
        int i2;
        a.c a2 = com.baidu.navisdk.comapi.commontool.sunrisedown.a.a().a(39.92d, 116.46d);
        GeoPoint e = com.baidu.navisdk.model.a.g().e();
        if (com.baidu.navisdk.module.international.a.a() == 1) {
            if (e != null) {
                a2 = com.baidu.navisdk.comapi.commontool.sunrisedown.a.a().a(e.getLatitudeE6() / 100000, e.getLongitudeE6() / 100000);
                com.baidu.navisdk.comapi.commontool.sunrisedown.a.a().a(a2);
            }
        } else if (e != null && e.getLatitudeE6() > 0 && e.getLongitudeE6() > 0) {
            a2 = com.baidu.navisdk.comapi.commontool.sunrisedown.a.a().a(e.getLatitudeE6() / 100000, e.getLongitudeE6() / 100000);
        }
        long currentTimeMillis = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, a2.a());
        calendar.set(12, a2.b());
        long timeInMillis = calendar.getTimeInMillis();
        calendar.set(11, a2.c());
        calendar.set(12, a2.d());
        if (currentTimeMillis > calendar.getTimeInMillis() && currentTimeMillis < timeInMillis) {
            if (x.t()) {
                i2 = 4;
            } else {
                i2 = 2;
            }
            LogUtil.e("BNAutoDayNightHelper", "自动切换 -> style = " + i2);
            a(1, i2, null);
            return;
        }
        if (x.t()) {
            i = 5;
        } else {
            i = 3;
        }
        LogUtil.e("BNAutoDayNightHelper", "自动切换 -> style = " + i);
        a(1, i, null);
    }

    public static a getInstance() {
        if (d == null) {
            d = new a();
        }
        return d;
    }

    public boolean a() {
        a.c a2 = com.baidu.navisdk.comapi.commontool.sunrisedown.a.a().a(39.92d, 116.46d);
        GeoPoint e = com.baidu.navisdk.model.a.g().e();
        if (com.baidu.navisdk.module.international.a.a() == 1) {
            if (e != null) {
                a2 = com.baidu.navisdk.comapi.commontool.sunrisedown.a.a().a(e.getLatitudeE6() / 100000, e.getLongitudeE6() / 100000);
                com.baidu.navisdk.comapi.commontool.sunrisedown.a.a().a(a2);
            }
        } else if (e != null && e.getLatitudeE6() > 0 && e.getLongitudeE6() > 0) {
            a2 = com.baidu.navisdk.comapi.commontool.sunrisedown.a.a().a(e.getLatitudeE6() / 100000, e.getLongitudeE6() / 100000);
        }
        long currentTimeMillis = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, a2.a());
        calendar.set(12, a2.b());
        long timeInMillis = calendar.getTimeInMillis();
        calendar.set(11, a2.c());
        calendar.set(12, a2.d());
        return currentTimeMillis > calendar.getTimeInMillis() && currentTimeMillis < timeInMillis;
    }

    public void b(int i) {
        if (i != BNSettingManager.getDefaultDayAndNightModeFromCloud()) {
            BNSettingManager.removeKey(SettingParams.Key.NAVI_MODE_DAY_AND_NIGHT);
            com.baidu.navisdk.module.motorbike.preferences.a.u0().c(SettingParams.Key.NAVI_MODE_DAY_AND_NIGHT);
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().c(SettingParams.Key.NAVI_MODE_DAY_AND_NIGHT);
            BNSettingManager.setDefaultDayAndNightModeFromCloud(i);
        }
        int i2 = 1;
        if (i != 1) {
            if (i == 2) {
                i2 = 2;
            } else if (i == 3) {
                i2 = 3;
            }
        }
        if (!BNSettingManager.containsKey(SettingParams.Key.NAVI_MODE_DAY_AND_NIGHT)) {
            BNSettingManager.setNaviDayAndNightMode(i2);
        }
        if (!com.baidu.navisdk.module.motorbike.preferences.a.u0().a(SettingParams.Key.NAVI_MODE_DAY_AND_NIGHT)) {
            com.baidu.navisdk.module.motorbike.preferences.a.u0().k(i2);
        }
        if (com.baidu.navisdk.module.trucknavi.preferences.a.r0().a(SettingParams.Key.NAVI_MODE_DAY_AND_NIGHT)) {
            return;
        }
        com.baidu.navisdk.module.trucknavi.preferences.a.r0().k(i2);
    }

    public void c(int i) {
        int i2;
        if (a(i)) {
            i2 = x.t() ? 4 : 2;
        } else {
            i2 = x.t() ? 5 : 3;
        }
        a(1, i2, null);
    }

    @Deprecated
    public boolean a(int i) {
        if (i == 2 || i == 4) {
            if (b()) {
                d();
            }
            return true;
        }
        if (i == 3 || i == 5) {
            if (!b()) {
                return false;
            }
            d();
            return false;
        }
        if (i != 1) {
            return true;
        }
        if (!b()) {
            c();
        }
        return a();
    }

    private void a(int i, int i2, Object obj) {
        synchronized (this.f6701a) {
            this.f6701a.notifyAll();
            com.baidu.navisdk.util.worker.c.a().a((f) new b("notifyDayNightObservers-" + getClass().getSimpleName(), null, i, i2, obj), new e(99, 0));
        }
    }
}
