package com.baidu.navisdk.util.logic;

import android.content.Context;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.a0;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.google.android.exoplayer2.ExoPlayer;

/* loaded from: classes8.dex */
public class c extends f {
    private static c k;
    private Handler f;
    private final Runnable g = new a();
    private final e h = new b();
    private final com.baidu.navisdk.comapi.geolocate.b i = new C0501c();
    private final com.baidu.navisdk.comapi.geolocate.b j = new d();

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.baidu.navisdk.module.vdr.a.f7604a) {
                com.baidu.navisdk.util.common.g.GPS.a("mock vdr do not addLocSdk");
                return;
            }
            c cVar = c.this;
            if (cVar.c) {
                cVar.j();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends e {
        public b() {
            super(c.this, null);
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
            if (gVar.a()) {
                gVar.a("gps lost one min");
            }
            c cVar = c.this;
            cVar.a(cVar.h.f9321a);
            c.this.f.removeCallbacks(c.this.h);
            c.this.h.f9321a = false;
            c.this.f.postDelayed(c.this.h, 60000L);
        }
    }

    /* renamed from: com.baidu.navisdk.util.logic.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0501c implements com.baidu.navisdk.comapi.geolocate.b {
        public C0501c() {
        }

        @Override // com.baidu.navisdk.comapi.geolocate.b
        public void onGpsStatusChange(boolean z, boolean z2) {
            c.this.a(true, z, z2);
        }

        @Override // com.baidu.navisdk.comapi.geolocate.b
        public void onLocationChange(com.baidu.navisdk.model.datastruct.g gVar) {
            c.this.a(true, gVar);
        }

        @Override // com.baidu.navisdk.comapi.geolocate.b
        public void onWGS84LocationChange(com.baidu.navisdk.model.datastruct.g gVar, com.baidu.navisdk.model.datastruct.g gVar2) {
            c.this.a(true, gVar, gVar2);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements com.baidu.navisdk.comapi.geolocate.b {
        public d() {
        }

        @Override // com.baidu.navisdk.comapi.geolocate.b
        public void onGpsStatusChange(boolean z, boolean z2) {
            c.this.a(false, z, z2);
        }

        @Override // com.baidu.navisdk.comapi.geolocate.b
        public void onLocationChange(com.baidu.navisdk.model.datastruct.g gVar) {
            c.this.a(false, gVar);
        }

        @Override // com.baidu.navisdk.comapi.geolocate.b
        public void onWGS84LocationChange(com.baidu.navisdk.model.datastruct.g gVar, com.baidu.navisdk.model.datastruct.g gVar2) {
            c.this.a(false, gVar, gVar2);
        }
    }

    private c() {
        this.f = null;
        this.f = m.d().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Location", "addLocSdkLocation");
        }
        com.baidu.navisdk.util.logic.a.j().a(this.j);
        return true;
    }

    public static synchronized c k() {
        c cVar;
        synchronized (c.class) {
            try {
                if (k == null) {
                    k = new c();
                }
                cVar = k;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    private void l() {
        this.f.removeCallbacks(this.g);
        this.f.postDelayed(this.g, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    private void m() {
        if (!com.baidu.navisdk.module.cloudconfig.f.c().c.f0 && !j.r().l()) {
            return;
        }
        this.f.removeCallbacks(this.h);
        e eVar = this.h;
        eVar.f9321a = true;
        this.f.postDelayed(eVar, 5000L);
    }

    private boolean n() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Location", "removeLocSdk");
        }
        com.baidu.navisdk.util.logic.a.j().b(this.j);
        return true;
    }

    private void o() {
        this.f.removeCallbacks(this.g);
    }

    private void p() {
        this.f.removeCallbacks(this.h);
    }

    @Override // com.baidu.navisdk.util.logic.f
    public GeoPoint d() {
        return super.d();
    }

    @Override // com.baidu.navisdk.util.logic.f
    public boolean f() {
        return j.r().f();
    }

    @Override // com.baidu.navisdk.util.logic.f
    public boolean g() {
        return j.r().g();
    }

    @Override // com.baidu.navisdk.util.logic.f
    public boolean h() {
        return j.r().h();
    }

    @Override // com.baidu.navisdk.util.logic.f
    public synchronized void i() {
        super.i();
        j.r().i();
        o();
        p();
        n();
    }

    /* loaded from: classes8.dex */
    public abstract class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public boolean f9321a;

        private e(c cVar) {
            this.f9321a = false;
        }

        public /* synthetic */ e(c cVar, a aVar) {
            this(cVar);
        }
    }

    public boolean b(Context context) {
        boolean z = false;
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            boolean isProviderEnabled = locationManager != null ? locationManager.isProviderEnabled("gps") : false;
            if (isProviderEnabled) {
                try {
                    if (Build.VERSION.SDK_INT == 28) {
                        String str = Build.BRAND;
                        if (!str.equals("Xiaomi")) {
                            if (str.equals("HUAWEI")) {
                            }
                        }
                        int i = Settings.Secure.getInt(context.getContentResolver(), "location_mode", 0);
                        return i == 1 || i == 3;
                    }
                } catch (Exception e2) {
                    e = e2;
                    z = isProviderEnabled;
                    LogUtil.e("Location", e.toString());
                    return z;
                }
            }
            return isProviderEnabled;
        } catch (Exception e3) {
            e = e3;
        }
    }

    public boolean c(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        if (locationManager != null) {
            return locationManager.isProviderEnabled("network");
        }
        return false;
    }

    @Override // com.baidu.navisdk.util.logic.f
    public synchronized boolean a(Context context) {
        boolean a2;
        try {
            super.a(context);
            j.r().a(this.i);
            a2 = j.r().a(context);
            if (!com.baidu.navisdk.module.cloudconfig.f.c().c.K) {
                l();
            }
            m();
        } catch (Throwable th) {
            throw th;
        }
        return a2;
    }

    public com.baidu.navisdk.model.datastruct.g a(int i) {
        com.baidu.navisdk.model.datastruct.g a2 = a(1, i);
        return a2 == null ? a(3, i) : a2;
    }

    public com.baidu.navisdk.model.datastruct.g a(int i, int i2) {
        com.baidu.navisdk.model.datastruct.g c;
        com.baidu.navisdk.model.datastruct.g c2;
        long currentTimeMillis = System.currentTimeMillis();
        if (i == 1) {
            if (currentTimeMillis - j.r().e() <= i2 && (c = j.r().c()) != null && c.b()) {
                return c;
            }
            return null;
        }
        if (i != 3) {
            return super.a();
        }
        if (currentTimeMillis - com.baidu.navisdk.util.logic.a.j().e() <= i2 && (c2 = com.baidu.navisdk.util.logic.a.j().c()) != null && c2.b()) {
            return c2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, com.baidu.navisdk.model.datastruct.g gVar) {
        if (z) {
            n();
            l();
            m();
        }
        a(gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, com.baidu.navisdk.model.datastruct.g gVar, com.baidu.navisdk.model.datastruct.g gVar2) {
        a(gVar, gVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, boolean z2, boolean z3) {
        a(z2, z3);
    }

    public void a(boolean z) {
        boolean z2 = com.baidu.navisdk.module.cloudconfig.f.c().c.f0;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
        if (gVar.e()) {
            gVar.g("isStatOpen=" + z2 + ", isNeedStatic=" + z);
        }
        if (j.r().l()) {
            Bundle bundle = new Bundle();
            bundle.putString("cuid", a0.e());
            if (j.r().a("gps", "send_gps_timeout", bundle)) {
                int i = bundle.getInt("satellite_used ", -1);
                int i2 = bundle.getInt("report_number_5s", -1);
                int i3 = bundle.getInt("position_ok_number_5s", -1);
                if (gVar.a()) {
                    gVar.a("from oppo satelliteUsed=" + i + ",reportNumberIn5s" + i2 + ", positionOkNumberIn5s" + i3);
                }
                if (z && z2) {
                    com.baidu.navisdk.util.statistic.f.n().i(i);
                    com.baidu.navisdk.util.statistic.f.n().h(i3);
                    com.baidu.navisdk.util.statistic.f.n().e(i2);
                }
            }
        }
        if (z && z2) {
            Bundle bundle2 = new Bundle();
            JNIGuidanceControl.getInstance().getMatchResultForVDR(bundle2, true);
            com.baidu.navisdk.framework.interfaces.opendatasturct.a a2 = com.baidu.navisdk.framework.interfaces.opendatasturct.a.a(bundle2);
            com.baidu.navisdk.util.statistic.f.n().d(a2.f & 15);
            com.baidu.navisdk.util.statistic.f.n().g(a2.f & 1044480);
            com.baidu.navisdk.model.datastruct.g c = com.baidu.navisdk.util.logic.a.j().c();
            if (c != null) {
                com.baidu.navisdk.util.statistic.f.n().f(c.l);
            }
            com.baidu.navisdk.util.statistic.f.n().k();
        }
    }
}
