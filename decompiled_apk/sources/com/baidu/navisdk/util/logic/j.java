package com.baidu.navisdk.util.logic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.debug.commonui.c;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes8.dex */
public class j extends com.baidu.navisdk.util.logic.f {
    private static j I;
    private Object E;
    private final LocationListener G;
    private final Runnable H;
    private GpsStatus f;
    private LocationManager g = null;
    private int h = 0;
    private int i = 0;
    private volatile boolean j = false;
    private volatile boolean k = false;
    private boolean l = true;
    private boolean m = false;
    private long n = 0;
    private int o = 0;
    private boolean p = false;
    private List<Long> q = new ArrayList(3);
    public boolean r = false;
    private int s = 0;
    private int t = 0;
    private long u = 0;
    private long v = 0;
    private int w = 2;
    private int x = 0;
    private int y = 0;
    private int z = 0;
    private volatile boolean A = false;
    public boolean B = true;
    private final com.baidu.navisdk.framework.lifecycle.b<Boolean> C = new com.baidu.navisdk.framework.lifecycle.b<>(Boolean.FALSE);
    private l D = null;
    private final GpsStatus.Listener F = new a();

    /* loaded from: classes8.dex */
    public class a implements GpsStatus.Listener {
        public a() {
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int i) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
            if (gVar.d()) {
                gVar.e("onGpsStatusChanged event= " + i);
            }
            j.this.w = i;
            if (j.this.w == 4) {
                j.this.v = SystemClock.elapsedRealtime();
            }
            if (i == 1) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.w.3", "1", null, null);
            } else if (i == 2) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.w.3", "2", null, null);
            } else if (i == 3) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.w.3", "3", null, null);
            } else if (i == 4 && j.this.A) {
                j.this.p();
            }
            HashMap t = j.this.t();
            if (t == null) {
                if (gVar.d()) {
                    gVar.e("onGpsStatusChanged return for satellitesMap is null.");
                    return;
                }
                return;
            }
            int intValue = ((Integer) t.get("fixedSatellitesNum")).intValue();
            int intValue2 = ((Integer) t.get("searchedSatellitesNum")).intValue();
            if (intValue != j.this.i) {
                j.this.i = intValue;
                if (gVar.a()) {
                    gVar.a("Gps e=" + i + ",fixedNum=" + j.this.i + ",sNum=" + intValue2);
                }
                j jVar = j.this;
                jVar.a(jVar.i);
            }
            if (intValue2 != j.this.h) {
                j.this.h = intValue2;
                if (gVar.d()) {
                    gVar.e(" SearchedSatellitesNum=" + j.this.h);
                }
                j jVar2 = j.this;
                jVar2.a(jVar2.h);
            }
            j jVar3 = j.this;
            if (jVar3.r) {
                jVar3.x();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends GnssStatus.Callback {
        public b() {
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int i) {
            super.onFirstFix(i);
            j.this.w = 3;
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.w.3", "3", null, null);
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(@NonNull GnssStatus gnssStatus) {
            int intValue;
            super.onSatelliteStatusChanged(gnssStatus);
            j.this.w = 4;
            l lVar = new l(gnssStatus);
            j.this.D = lVar;
            j.this.v = SystemClock.elapsedRealtime();
            if (j.this.A) {
                j.this.p();
            }
            HashMap a2 = j.this.a(lVar);
            Integer num = (Integer) a2.get("fixedSatellitesNum");
            Integer num2 = (Integer) a2.get("searchedSatellitesNum");
            int i = 0;
            if (num == null) {
                intValue = 0;
            } else {
                intValue = num.intValue();
            }
            if (num2 != null) {
                i = num2.intValue();
            }
            if (intValue != j.this.i) {
                j.this.i = intValue;
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
                if (gVar.a()) {
                    gVar.a("onSatelliteStatusChanged --> Gps fixedNum=" + j.this.i + ",sNum=" + i);
                }
                j jVar = j.this;
                jVar.a(jVar.i);
            }
            if (i != j.this.h) {
                j.this.h = i;
                com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.GPS;
                if (gVar2.d()) {
                    gVar2.e(" SearchedSatellitesNum=" + j.this.h);
                }
                j jVar2 = j.this;
                jVar2.a(jVar2.h);
            }
            j jVar3 = j.this;
            if (jVar3.r) {
                jVar3.b(lVar);
            }
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            super.onStarted();
            j.this.w = 1;
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.w.3", "1", null, null);
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            super.onStopped();
            j.this.w = 2;
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.w.3", "2", null, null);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements com.baidu.navisdk.debug.commonui.a {
        public c() {
        }

        @Override // com.baidu.navisdk.debug.commonui.a
        public String a() {
            return null;
        }

        @Override // com.baidu.navisdk.debug.commonui.a
        public List<c.e> b() {
            String str;
            String str2;
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            if (j.this.p) {
                str = "开 | ";
            } else {
                str = "关 | ";
            }
            sb.append(str);
            sb.append(j.this.s());
            arrayList.add(new c.e("定位开关|状态", sb.toString()));
            arrayList.add(new c.e("卫星定位状态", j.this.j()));
            arrayList.add(new c.e("卫星搜索|可用", String.valueOf(j.this.h) + " | " + String.valueOf(j.this.i)));
            StringBuilder sb2 = new StringBuilder();
            String str3 = "0";
            if (j.this.g == null) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            sb2.append(str2);
            sb2.append(" | ");
            if (j.this.k) {
                str3 = "1";
            }
            sb2.append(str3);
            arrayList.add(new c.e("定位器|启动监听", sb2.toString()));
            return arrayList;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements GpsStatus.Listener {
        public d(j jVar) {
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int i) {
        }
    }

    /* loaded from: classes8.dex */
    public class e implements LocationListener {
        public e() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location == null || com.baidu.navisdk.util.logic.d.e().b()) {
                return;
            }
            j.this.a(location, g.SOURCE_RAW_GPS);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
            if (gVar.d()) {
                gVar.e("onProviderDisabled: " + str);
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.w.4", "1", null, null);
            j.this.p = false;
            j.this.j = false;
            j.this.a(false, false);
            if (j.this.l && gVar.a()) {
                gVar.a("onProviderDisabled() provider=" + str);
            }
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
            if (gVar.d()) {
                gVar.e("onProviderEnabled: " + str);
            }
            j.this.p = true;
            j.this.j = false;
            j.this.a(true, false);
            if (j.this.l && gVar.a()) {
                gVar.a("onProviderEnabled() provider=" + str);
            }
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
            int i2;
            boolean z = false;
            if (bundle != null) {
                i2 = bundle.getInt("satellites");
            } else {
                i2 = 0;
            }
            j.this.o = i;
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
            if (gVar.d()) {
                gVar.e("onStatusChanged: " + str + ", status " + i + ", satellites " + i2);
            }
            if (i != 1 && i != 2) {
                if (j.this.l && gVar.a()) {
                    gVar.a("onStatusChanged provider=" + str + "status=" + i + ", satellites=" + i2);
                }
            } else {
                z = true;
            }
            if (TipTool.sShowDebugToast) {
                TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "Sys GPSStatusChanged, avail " + z + ", sat " + i2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.E();
        }
    }

    /* loaded from: classes8.dex */
    public enum g {
        SOURCE_RAW_GPS(0),
        SOURCE_HD_LOCATION(1),
        SOURCE_HD_WGS84(2),
        SOURCE_LOC_SDK_HD(3);

        g(int i) {
        }
    }

    private j() {
        this.E = null;
        if (Build.VERSION.SDK_INT >= 31) {
            this.E = new b();
        }
        new d(this);
        this.G = new e();
        this.H = new f();
    }

    private void A() {
        boolean z;
        com.baidu.navisdk.framework.interfaces.pronavi.i i = x.i();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("resetcja() mReAddGpsLocation ");
            if (i != null && i.e()) {
                z = true;
            } else {
                z = false;
            }
            sb.append(z);
            gVar.e(sb.toString());
        }
        if (i != null && i.e()) {
            i.d(false);
            return;
        }
        this.u = 0L;
        this.t = 0;
        this.s = 0;
        this.v = 0L;
        this.w = 2;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.o = 0;
        com.baidu.navisdk.util.logic.e.c().b();
    }

    private synchronized boolean B() {
        boolean z;
        try {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
            if (gVar.a()) {
                StringBuilder sb = new StringBuilder();
                sb.append("startLocate manager=null?");
                if (this.g == null) {
                    z = true;
                } else {
                    z = false;
                }
                sb.append(z);
                sb.append(", isStart=");
                sb.append(this.k);
                gVar.a(sb.toString());
            }
            if (this.k) {
                return true;
            }
            if (this.g == null) {
                b(com.baidu.navisdk.framework.a.c().a());
            }
            if (this.g != null && !this.k) {
                this.l = true;
                try {
                    this.g.requestLocationUpdates("gps", 0L, 0.0f, this.G, m.d().a().getLooper());
                    if (Build.VERSION.SDK_INT >= 31) {
                        if (oIX0oI.oIX0oI(this.E)) {
                            this.g.registerGnssStatusCallback(II0xO0.oIX0oI(this.E), (Handler) null);
                        }
                    } else {
                        this.g.addGpsStatusListener(this.F);
                    }
                    A();
                    this.k = true;
                    C();
                    if (gVar.a()) {
                        gVar.a("startLocate() ok");
                    }
                    if (TipTool.sShowDebugToast) {
                        TipTool.onCreateDebugToast(com.baidu.navisdk.framework.a.c().a(), "SysLoc: startLocate");
                    }
                    return true;
                } catch (Exception e2) {
                    com.baidu.navisdk.util.statistic.userop.b.r().a("7.2", "5", null, null);
                    com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.GPS;
                    if (gVar2.a()) {
                        gVar2.a("startLocate-5 catch Exception = " + e2.getCause());
                        gVar2.a("startLocate-5 catch Exception = " + e2.getMessage());
                    }
                    return false;
                }
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("7.2", "6", null, null);
            if (gVar.a()) {
                gVar.a("startLocate()-6 error for null. mIsStarted=" + this.k);
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    private void C() {
        if (com.baidu.navisdk.util.common.n.d().a() != null) {
            com.baidu.navisdk.util.common.n.d().a().postDelayed(this.H, 30000L);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
            if (gVar.d()) {
                gVar.e("Location", "startLostLocationMonitor.");
            }
        }
    }

    private synchronized boolean D() {
        try {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
            if (gVar.c()) {
                gVar.c("stopLocate");
            }
            this.l = true;
            try {
                if (this.g != null && this.k) {
                    this.k = false;
                    LocationListener locationListener = this.G;
                    if (locationListener != null) {
                        this.g.removeUpdates(locationListener);
                    }
                    if (Build.VERSION.SDK_INT >= 31) {
                        if (oIX0oI.oIX0oI(this.E)) {
                            this.g.unregisterGnssStatusCallback(II0xO0.oIX0oI(this.E));
                        }
                    } else {
                        this.g.removeGpsStatusListener(this.F);
                    }
                    q();
                    if (gVar.d()) {
                        gVar.e("stopLocate() ok");
                    }
                    return true;
                }
                if (gVar.c()) {
                    gVar.c("stopLocate() error for null. mIsStarted=" + this.k);
                }
                return false;
            } catch (Exception e2) {
                com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.GPS;
                if (gVar2.b()) {
                    gVar2.a("", e2);
                }
                if (gVar2.c()) {
                    gVar2.c("stopLocate() error for ex=" + e2.getMessage());
                }
                return false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
        if (gVar.d()) {
            gVar.e("Location", "uploadLostLocationMonitor.");
        }
        if (l()) {
            Bundle bundle = new Bundle();
            this.g.sendExtraCommand("gps", "get_gps_data", bundle);
            int i = bundle.getInt("satellite_used ", -1);
            int i2 = bundle.getInt("report_number_5s", -1);
            int i3 = bundle.getInt("position_ok_number_5s", -1);
            if (gVar.a()) {
                gVar.a("from oppo satelliteUsed=" + i + ",reportNumberIn5s" + i2 + ", positionOkNumberIn5s" + i3);
            }
        }
        com.baidu.navisdk.skyeye.a.n().a(32, 2, "卫星信号丢星自动上传");
    }

    private void q() {
        if (com.baidu.navisdk.util.common.n.d().a() != null) {
            com.baidu.navisdk.util.common.n.d().a().removeCallbacks(this.H);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
            if (gVar.d()) {
                gVar.e("Location", "cancelLostLocationMonitor.");
            }
        }
    }

    public static synchronized j r() {
        j jVar;
        synchronized (j.class) {
            try {
                if (I == null) {
                    I = new j();
                }
                jVar = I;
            } catch (Throwable th) {
                throw th;
            }
        }
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String s() {
        int i = this.o;
        if (i != 1) {
            if (i != 2) {
                return "out";
            }
            return "ok";
        }
        return "tmp";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public HashMap<String, Integer> t() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        try {
            LocationManager locationManager = this.g;
            if (locationManager != null) {
                GpsStatus gpsStatus = this.f;
                if (gpsStatus == null) {
                    this.f = locationManager.getGpsStatus(null);
                } else {
                    locationManager.getGpsStatus(gpsStatus);
                }
                boolean equals = Boolean.TRUE.equals(this.C.getValue());
                int i = 0;
                int i2 = 0;
                for (GpsSatellite gpsSatellite : this.f.getSatellites()) {
                    if (gpsSatellite.usedInFix()) {
                        i2++;
                    }
                    i++;
                    if (!equals) {
                        int prn = gpsSatellite.getPrn();
                        if (prn >= 201 && prn <= 261) {
                            o();
                            equals = true;
                        }
                        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
                        if (gVar.d()) {
                            gVar.e("hasBDSatellite =" + this.C.getValue() + ",prn =" + prn);
                        }
                    }
                }
                hashMap.put("fixedSatellitesNum", Integer.valueOf(i2));
                hashMap.put("searchedSatellitesNum", Integer.valueOf(i));
                return hashMap;
            }
        } catch (Exception e2) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.GPS;
            if (gVar2.a()) {
                gVar2.a("BNSysLocationManager getSatellitesMap() ex=" + e2.getCause());
                gVar2.a("BNSysLocationManager getSatellitesMap() ex=" + e2.getMessage());
            }
        }
        com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.GPS;
        if (gVar3.d()) {
            gVar3.e("getSatellitesMap() return null.");
        }
        return null;
    }

    private boolean u() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
        if (gVar.d()) {
            gVar.e("Location", "iscjaByLocationAndSatellieteStatus() gpsC=" + this.t + ", totalC=" + this.s);
        }
        int i = this.s;
        if (i <= 0) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("7.3", "3", "" + this.t, "" + this.s);
            return true;
        }
        double d2 = this.t / i;
        if (gVar.d()) {
            gVar.e("Location", "iscjaByLocationAndSatellieteStatus() percent :" + d2);
        }
        if (d2 >= com.baidu.navisdk.module.cloudconfig.f.c().c.E) {
            return false;
        }
        if (gVar.a()) {
            gVar.a("Location", "iscjaByLocationAndSatellieteStatus() true gpsC=" + this.t + ", totalC=" + this.s);
            gVar.a("Location", "standar percent =" + com.baidu.navisdk.module.cloudconfig.f.c().c.E + ", current=" + d2);
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("7.3", "3", "" + this.t, "" + this.s);
        return true;
    }

    private void v() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.l) {
            this.l = false;
            com.baidu.navisdk.util.statistic.userop.b.r().b("8.3.7");
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
            if (gVar.d()) {
                gVar.e("Location", "locationStatCheck() first location");
            }
            q();
        } else if (currentTimeMillis - this.n > 3000) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("8.3.8", String.valueOf((int) ((currentTimeMillis - this.n) / 1000)), null, null);
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.GPS;
            if (gVar2.d()) {
                gVar2.e("Location", "locationStatCheck() location-" + ((int) ((currentTimeMillis - this.n) / 1000)));
            }
        }
        this.n = currentTimeMillis;
    }

    private void w() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (SystemClock.elapsedRealtime() - this.u > 10000) {
                if (SystemClock.elapsedRealtime() - this.v < com.baidu.navisdk.module.cloudconfig.f.c().c.F) {
                    this.t++;
                }
                this.s++;
                this.u = SystemClock.elapsedRealtime();
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
                if (gVar.d()) {
                    gVar.e("cja() gpsC=" + this.t + ", totalC=" + this.s);
                }
                int i = this.o;
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            this.x++;
                        }
                    } else {
                        this.y++;
                    }
                } else {
                    this.z++;
                }
                if (gVar.d()) {
                    gVar.e("Location", "cja() ac=" + this.x + ", tc=" + this.y + ", uc=" + this.z);
                }
            }
            com.baidu.navisdk.util.logic.e.c().a(this.g, this.D);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public void x() {
        LocationManager locationManager;
        try {
            Context a2 = com.baidu.navisdk.framework.a.c().a();
            if (a2 != null && (locationManager = (LocationManager) a2.getSystemService("location")) != null) {
                ArrayList<Bundle> arrayList = new ArrayList<>();
                int i = 0;
                int i2 = 0;
                for (GpsSatellite gpsSatellite : locationManager.getGpsStatus(null).getSatellites()) {
                    if (gpsSatellite.usedInFix()) {
                        i++;
                    }
                    i2++;
                    Bundle bundle = new Bundle();
                    bundle.putInt("nStarId", gpsSatellite.getPrn());
                    bundle.putFloat("fUpAngle", gpsSatellite.getElevation());
                    bundle.putFloat("fAngle", gpsSatellite.getAzimuth());
                    bundle.putFloat("fSNR", gpsSatellite.getSnr());
                    bundle.putBoolean("bIsUsed", gpsSatellite.usedInFix());
                    bundle.putBoolean("bIsHaveAlmanac", gpsSatellite.hasAlmanac());
                    bundle.putBoolean("bIsHaveEphemeris", gpsSatellite.hasEphemeris());
                    arrayList.add(bundle);
                    com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
                    if (gVar.d()) {
                        gVar.e("SensorFinger", "starID=" + gpsSatellite.getPrn());
                    }
                    if (i2 == 60) {
                        break;
                    }
                }
                BNRouteGuider.getInstance().triggerGPSStarInfoChange(i2, i, arrayList);
            }
        } catch (Exception e2) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.GPS;
            if (gVar2.c()) {
                gVar2.c("recordSensorFingerStarInfos Exception" + e2.getCause());
                gVar2.c("recordSensorFingerStarInfos Exception" + e2.getMessage());
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    private void y() {
        if (com.baidu.navisdk.framework.a.c().a() != null && this.g != null) {
            ArrayList<Bundle> arrayList = new ArrayList<>();
            int i = 0;
            int i2 = 0;
            for (GpsSatellite gpsSatellite : this.g.getGpsStatus(null).getSatellites()) {
                if (gpsSatellite.usedInFix()) {
                    i++;
                }
                i2++;
                Bundle bundle = new Bundle();
                bundle.putInt("nStarId", gpsSatellite.getPrn());
                bundle.putFloat("fUpAngle", gpsSatellite.getElevation());
                bundle.putFloat("fAngle", gpsSatellite.getAzimuth());
                bundle.putFloat("fSNR", gpsSatellite.getSnr());
                bundle.putBoolean("bIsUsed", gpsSatellite.usedInFix());
                bundle.putBoolean("bIsHaveAlmanac", gpsSatellite.hasAlmanac());
                bundle.putBoolean("bIsHaveEphemeris", gpsSatellite.hasEphemeris());
                arrayList.add(bundle);
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
                if (gVar.d()) {
                    gVar.e("recordViaductStartNodeStarInfos:", "nStarId=" + gpsSatellite.getPrn());
                    gVar.e("recordViaductStartNodeStarInfos:", "fUpAngle=" + gpsSatellite.getElevation());
                    gVar.e("recordViaductStartNodeStarInfos:", "fAngle=" + gpsSatellite.getAzimuth());
                    gVar.e("recordViaductStartNodeStarInfos:", "fSNR=" + gpsSatellite.getSnr());
                    gVar.e("recordViaductStartNodeStarInfos:", "bIsUsed=" + gpsSatellite.usedInFix());
                    gVar.e("recordViaductStartNodeStarInfos:", "bIsHaveAlmanac=" + gpsSatellite.hasAlmanac());
                    gVar.e("recordViaductStartNodeStarInfos:", "bIsHaveEphemeris=" + gpsSatellite.hasEphemeris());
                }
                if (i2 == 60) {
                    break;
                }
            }
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.GPS;
            if (gVar2.d()) {
                gVar2.e("recordViaductStartNodeStarInfos:", "searchedSatellitesNum=" + i2);
                gVar2.e("recordViaductStartNodeStarInfos:", "fixedSatellitesNum=" + i);
            }
            BNRouteGuider.getInstance().triggerGPSStarInfoChange(i2, i, arrayList);
        }
    }

    private void z() {
        l lVar = this.D;
        ArrayList<Bundle> arrayList = new ArrayList<>();
        int a2 = lVar.a();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < a2; i3++) {
            if (lVar.h(i3)) {
                i++;
            }
            i2++;
            Bundle bundle = new Bundle();
            bundle.putInt("nConstellationType", lVar.d(i3));
            bundle.putFloat("fUpAngle", lVar.e(i3));
            bundle.putFloat("fAngle", lVar.b(i3));
            bundle.putFloat("fSNR", lVar.c(i3));
            bundle.putBoolean("bIsUsed", lVar.h(i3));
            bundle.putBoolean("bIsHaveAlmanac", lVar.f(i3));
            bundle.putBoolean("bIsHaveEphemeris", lVar.g(i3));
            arrayList.add(bundle);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
            if (gVar.d()) {
                gVar.e("recordViaductStartNodeStarInfos:", "nConstellationType=" + lVar.d(i3));
                gVar.e("recordViaductStartNodeStarInfos:", "fUpAngle=" + lVar.e(i3));
                gVar.e("recordViaductStartNodeStarInfos:", "fAngle=" + lVar.b(i3));
                gVar.e("recordViaductStartNodeStarInfos:", "fSNR=" + lVar.c(i3));
                gVar.e("recordViaductStartNodeStarInfos:", "bIsUsed=" + lVar.h(i3));
                gVar.e("recordViaductStartNodeStarInfos:", "bIsHaveAlmanac=" + lVar.f(i3));
                gVar.e("recordViaductStartNodeStarInfos:", "bIsHaveEphemeris=" + lVar.g(i3));
            }
            if (i2 == 60) {
                break;
            }
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.GPS;
        if (gVar2.d()) {
            gVar2.e("recordViaductStartNodeStarInfos:", "searchedSatellitesNum=" + i2);
            gVar2.e("recordViaductStartNodeStarInfos:", "fixedSatellitesNum=" + i);
        }
        BNRouteGuider.getInstance().triggerGPSStarInfoChange(i2, i, arrayList);
    }

    public boolean m() {
        if (this.j && a() != null) {
            return true;
        }
        return false;
    }

    public void n() {
        if (Build.VERSION.SDK_INT >= 23 && this.g == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
            if (gVar.e()) {
                gVar.g("restartLocateModule");
            }
            b(com.baidu.navisdk.framework.a.c().a());
        }
    }

    public void o() {
        this.C.setValue(Boolean.TRUE);
        if (!BNSettingManager.supportBD()) {
            BNSettingManager.setSupportBD(true);
        }
    }

    public void p() {
        try {
            if (Build.VERSION.SDK_INT >= 31) {
                z();
            } else {
                y();
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.baidu.navisdk.util.logic.f
    public boolean f() {
        if (RouteGuideParams.getRouteGuideMode() == 2) {
            if (this.j) {
                return System.currentTimeMillis() - r().e() < 3000;
            }
            return this.j;
        }
        return this.j;
    }

    @Override // com.baidu.navisdk.util.logic.f
    public boolean g() {
        try {
            LocationManager locationManager = this.g;
            if (locationManager != null) {
                return locationManager.isProviderEnabled("gps");
            }
        } catch (Exception e2) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
            if (gVar.c()) {
                gVar.c("Location", e2.toString());
            }
        }
        return false;
    }

    @Override // com.baidu.navisdk.util.logic.f
    public boolean h() {
        if (this.s >= com.baidu.navisdk.module.cloudconfig.f.c().c.G) {
            return u() || com.baidu.navisdk.util.logic.e.c().a();
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
        if (gVar.d()) {
            gVar.e("Location", "isMock false totalCount " + this.s + " < " + com.baidu.navisdk.module.cloudconfig.f.c().c.G);
        }
        return false;
    }

    @Override // com.baidu.navisdk.util.logic.f
    public synchronized void i() {
        try {
            if (BNSettingManager.isGpsNeverClose()) {
                return;
            }
            super.i();
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
            if (gVar.c()) {
                gVar.c("Location", "stopNaviLocate");
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("8.3.5", D() ? "1" : "0", null, null);
            if (BNSettingManager.isShowJavaLog()) {
                SDKDebugFileUtil.end(null, SDKDebugFileUtil.SYSLOC_FILENAME);
                SDKDebugFileUtil.end(null, SDKDebugFileUtil.NAVING_SYSLOC_FILENAME);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public String j() {
        int i = this.w;
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "搜星中" : "卫星变化" : "首次定位" : "停止定位" : "开始定位";
    }

    public LiveData<Boolean> k() {
        return this.C;
    }

    public boolean l() {
        return this.m;
    }

    public void b(Context context) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
        if (gVar.a()) {
            gVar.a("init");
        }
        com.baidu.navisdk.util.logic.d.e().a();
        if (this.g == null && context != null) {
            try {
                this.g = (LocationManager) context.getSystemService("location");
            } catch (Exception e2) {
                com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.GPS;
                if (gVar2.a()) {
                    gVar2.a("init fail :" + e2.getCause());
                    gVar2.a("init fail :" + e2.toString());
                }
                com.baidu.navisdk.util.statistic.userop.b.r().a("7.2", "7", null, null);
            }
        }
        if (this.g == null) {
            this.B = false;
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.GPS;
            if (gVar3.a()) {
                gVar3.a("local init failed");
            }
        }
        this.m = com.baidu.navisdk.framework.b.U() || com.baidu.navisdk.util.common.g.b0;
    }

    @Override // com.baidu.navisdk.util.logic.f
    public synchronized boolean a(Context context) {
        boolean B;
        try {
            super.a(context);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
            if (gVar.c()) {
                gVar.c("Location", "startNaviLocate");
            }
            B = B();
            com.baidu.navisdk.util.statistic.userop.b.r().a("8.3.4", B ? "1" : "0", null, null);
        } catch (Throwable th) {
            throw th;
        }
        return B;
    }

    public void a(ViewGroup viewGroup) {
        if (BNSettingManager.isGPSDebug()) {
            com.baidu.navisdk.debug.commonui.b.b().a("debug_module_location", new c(), viewGroup);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (this.j && i == 0) {
            this.j = false;
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
            if (gVar.d()) {
                gVar.e("notifyGpsStatusWithSatellitesChanged: mGpsAvailable=" + this.j);
            }
            a(true, false);
            return;
        }
        if (this.j || i <= 0) {
            return;
        }
        this.j = true;
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.GPS;
        if (gVar2.d()) {
            gVar2.e("notifyGpsStatusWithSatellitesChanged: mGpsAvailable=" + this.j);
        }
        a(true, true);
        this.q.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(l lVar) {
        int a2 = lVar.a();
        ArrayList<Bundle> arrayList = new ArrayList<>();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < a2; i3++) {
            if (lVar.h(i3)) {
                i++;
            }
            i2++;
            Bundle bundle = new Bundle();
            bundle.putInt("nConstellationType", lVar.d(i3));
            bundle.putFloat("fUpAngle", lVar.e(i3));
            bundle.putFloat("fAngle", lVar.b(i3));
            bundle.putFloat("fSNR", lVar.c(i3));
            bundle.putBoolean("bIsUsed", lVar.h(i3));
            bundle.putBoolean("bIsHaveAlmanac", lVar.f(i3));
            bundle.putBoolean("bIsHaveEphemeris", lVar.g(i3));
            arrayList.add(bundle);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
            if (gVar.d()) {
                gVar.e("SensorFinger", "constellationType=" + lVar.a(lVar.d(i3)));
            }
            if (i2 == 60) {
                break;
            }
        }
        BNRouteGuider.getInstance().triggerGPSStarInfoChange(i2, i, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, Integer> a(l lVar) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        int a2 = lVar.a();
        boolean equals = Boolean.TRUE.equals(this.C.getValue());
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < a2; i3++) {
            if (lVar.h(i3)) {
                i2++;
            }
            i++;
            if (!equals) {
                int d2 = lVar.d(i3);
                if (lVar.d(i3) == 5) {
                    o();
                    equals = true;
                }
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
                if (gVar.d()) {
                    gVar.e("getSatellitesMap --> hasBDSatellite =" + this.C.getValue() + ",type =" + lVar.a(d2));
                }
            }
        }
        hashMap.put("fixedSatellitesNum", Integer.valueOf(i2));
        hashMap.put("searchedSatellitesNum", Integer.valueOf(i));
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0132 A[Catch: all -> 0x00b4, TryCatch #0 {all -> 0x00b4, blocks: (B:18:0x0073, B:20:0x0084, B:23:0x0089, B:25:0x008f, B:27:0x00fa, B:29:0x0132, B:32:0x013d, B:34:0x0146, B:36:0x014a, B:37:0x016f, B:39:0x017d, B:41:0x0181, B:43:0x0187, B:45:0x018d, B:48:0x01a4, B:49:0x01ab, B:51:0x01b1, B:53:0x01b5, B:55:0x01b9, B:56:0x01c6, B:59:0x01d6, B:63:0x0267, B:65:0x0277, B:66:0x027a, B:68:0x0286, B:70:0x028c, B:74:0x01c1, B:77:0x014f, B:79:0x0153, B:80:0x0159, B:82:0x0163, B:84:0x0167, B:86:0x016d, B:88:0x00b7, B:90:0x00c6, B:91:0x00d4), top: B:17:0x0073 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x013d A[Catch: all -> 0x00b4, TryCatch #0 {all -> 0x00b4, blocks: (B:18:0x0073, B:20:0x0084, B:23:0x0089, B:25:0x008f, B:27:0x00fa, B:29:0x0132, B:32:0x013d, B:34:0x0146, B:36:0x014a, B:37:0x016f, B:39:0x017d, B:41:0x0181, B:43:0x0187, B:45:0x018d, B:48:0x01a4, B:49:0x01ab, B:51:0x01b1, B:53:0x01b5, B:55:0x01b9, B:56:0x01c6, B:59:0x01d6, B:63:0x0267, B:65:0x0277, B:66:0x027a, B:68:0x0286, B:70:0x028c, B:74:0x01c1, B:77:0x014f, B:79:0x0153, B:80:0x0159, B:82:0x0163, B:84:0x0167, B:86:0x016d, B:88:0x00b7, B:90:0x00c6, B:91:0x00d4), top: B:17:0x0073 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01d6 A[Catch: all -> 0x00b4, TRY_ENTER, TryCatch #0 {all -> 0x00b4, blocks: (B:18:0x0073, B:20:0x0084, B:23:0x0089, B:25:0x008f, B:27:0x00fa, B:29:0x0132, B:32:0x013d, B:34:0x0146, B:36:0x014a, B:37:0x016f, B:39:0x017d, B:41:0x0181, B:43:0x0187, B:45:0x018d, B:48:0x01a4, B:49:0x01ab, B:51:0x01b1, B:53:0x01b5, B:55:0x01b9, B:56:0x01c6, B:59:0x01d6, B:63:0x0267, B:65:0x0277, B:66:0x027a, B:68:0x0286, B:70:0x028c, B:74:0x01c1, B:77:0x014f, B:79:0x0153, B:80:0x0159, B:82:0x0163, B:84:0x0167, B:86:0x016d, B:88:0x00b7, B:90:0x00c6, B:91:0x00d4), top: B:17:0x0073 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0277 A[Catch: all -> 0x00b4, TryCatch #0 {all -> 0x00b4, blocks: (B:18:0x0073, B:20:0x0084, B:23:0x0089, B:25:0x008f, B:27:0x00fa, B:29:0x0132, B:32:0x013d, B:34:0x0146, B:36:0x014a, B:37:0x016f, B:39:0x017d, B:41:0x0181, B:43:0x0187, B:45:0x018d, B:48:0x01a4, B:49:0x01ab, B:51:0x01b1, B:53:0x01b5, B:55:0x01b9, B:56:0x01c6, B:59:0x01d6, B:63:0x0267, B:65:0x0277, B:66:0x027a, B:68:0x0286, B:70:0x028c, B:74:0x01c1, B:77:0x014f, B:79:0x0153, B:80:0x0159, B:82:0x0163, B:84:0x0167, B:86:0x016d, B:88:0x00b7, B:90:0x00c6, B:91:0x00d4), top: B:17:0x0073 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0286 A[Catch: all -> 0x00b4, TRY_LEAVE, TryCatch #0 {all -> 0x00b4, blocks: (B:18:0x0073, B:20:0x0084, B:23:0x0089, B:25:0x008f, B:27:0x00fa, B:29:0x0132, B:32:0x013d, B:34:0x0146, B:36:0x014a, B:37:0x016f, B:39:0x017d, B:41:0x0181, B:43:0x0187, B:45:0x018d, B:48:0x01a4, B:49:0x01ab, B:51:0x01b1, B:53:0x01b5, B:55:0x01b9, B:56:0x01c6, B:59:0x01d6, B:63:0x0267, B:65:0x0277, B:66:0x027a, B:68:0x0286, B:70:0x028c, B:74:0x01c1, B:77:0x014f, B:79:0x0153, B:80:0x0159, B:82:0x0163, B:84:0x0167, B:86:0x016d, B:88:0x00b7, B:90:0x00c6, B:91:0x00d4), top: B:17:0x0073 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x014f A[Catch: all -> 0x00b4, TryCatch #0 {all -> 0x00b4, blocks: (B:18:0x0073, B:20:0x0084, B:23:0x0089, B:25:0x008f, B:27:0x00fa, B:29:0x0132, B:32:0x013d, B:34:0x0146, B:36:0x014a, B:37:0x016f, B:39:0x017d, B:41:0x0181, B:43:0x0187, B:45:0x018d, B:48:0x01a4, B:49:0x01ab, B:51:0x01b1, B:53:0x01b5, B:55:0x01b9, B:56:0x01c6, B:59:0x01d6, B:63:0x0267, B:65:0x0277, B:66:0x027a, B:68:0x0286, B:70:0x028c, B:74:0x01c1, B:77:0x014f, B:79:0x0153, B:80:0x0159, B:82:0x0163, B:84:0x0167, B:86:0x016d, B:88:0x00b7, B:90:0x00c6, B:91:0x00d4), top: B:17:0x0073 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0139  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(android.location.Location r22, com.baidu.navisdk.util.logic.j.g r23) {
        /*
            Method dump skipped, instructions count: 789
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.util.logic.j.a(android.location.Location, com.baidu.navisdk.util.logic.j$g):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean a(android.location.Location r10) {
        /*
            r9 = this;
            r0 = 1
            if (r10 != 0) goto L4
            return r0
        L4:
            com.baidu.navisdk.util.common.g r10 = com.baidu.navisdk.util.common.g.GPS
            boolean r1 = r10.d()
            java.lang.String r2 = "Location"
            if (r1 == 0) goto L13
            java.lang.String r1 = "handleLocationWhenGpsLost"
            r10.e(r2, r1)
        L13:
            long r3 = java.lang.System.currentTimeMillis()
            java.util.List<java.lang.Long> r10 = r9.q     // Catch: java.lang.Exception -> L31
            boolean r10 = r10.isEmpty()     // Catch: java.lang.Exception -> L31
            if (r10 != 0) goto L52
            java.util.List<java.lang.Long> r10 = r9.q     // Catch: java.lang.Exception -> L31
            int r1 = r10.size()     // Catch: java.lang.Exception -> L31
            int r1 = r1 - r0
            java.lang.Object r10 = r10.get(r1)     // Catch: java.lang.Exception -> L31
            java.lang.Long r10 = (java.lang.Long) r10     // Catch: java.lang.Exception -> L31
            long r5 = r10.longValue()     // Catch: java.lang.Exception -> L31
            goto L53
        L31:
            r10 = move-exception
            com.baidu.navisdk.util.common.g r1 = com.baidu.navisdk.util.common.g.GPS
            boolean r5 = r1.c()
            if (r5 == 0) goto L52
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "handleLocationWhenGpsLost e:"
            r5.append(r6)
            java.lang.String r10 = r10.toString()
            r5.append(r10)
            java.lang.String r10 = r5.toString()
            r1.c(r2, r10)
        L52:
            r5 = r3
        L53:
            long r5 = r3 - r5
            r7 = 1500(0x5dc, double:7.41E-321)
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r10 > 0) goto La6
            java.util.List<java.lang.Long> r10 = r9.q
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r10.add(r1)
            com.baidu.navisdk.util.common.g r10 = com.baidu.navisdk.util.common.g.GPS
            boolean r1 = r10.d()
            if (r1 == 0) goto L86
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "GpsLost: add new location, size "
            r1.append(r3)
            java.util.List<java.lang.Long> r3 = r9.q
            int r3 = r3.size()
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r10.e(r2, r1)
        L86:
            java.util.List<java.lang.Long> r1 = r9.q
            int r1 = r1.size()
            r3 = 3
            if (r1 < r3) goto Lb8
            r9.j = r0
            r9.a(r0, r0)
            boolean r0 = r10.d()
            if (r0 == 0) goto L9f
            java.lang.String r0 = "GpsLost: unavailable ----> available"
            r10.e(r2, r0)
        L9f:
            java.util.List<java.lang.Long> r10 = r9.q
            r10.clear()
            r10 = 0
            return r10
        La6:
            java.util.List<java.lang.Long> r10 = r9.q
            r10.clear()
            com.baidu.navisdk.util.common.g r10 = com.baidu.navisdk.util.common.g.GPS
            boolean r1 = r10.d()
            if (r1 == 0) goto Lb8
            java.lang.String r1 = "GpsLost: > interval, clear all"
            r10.e(r2, r1)
        Lb8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.util.logic.j.a(android.location.Location):boolean");
    }

    public boolean a(String str, String str2, Bundle bundle) {
        LocationManager locationManager = this.g;
        if (locationManager == null) {
            return false;
        }
        try {
            locationManager.sendExtraCommand(str, str2, bundle);
            return true;
        } catch (Throwable th) {
            if (!com.baidu.navisdk.util.common.g.GPS.c()) {
                return true;
            }
            com.baidu.navisdk.util.common.g.GPS.c(th.toString());
            return true;
        }
    }
}
