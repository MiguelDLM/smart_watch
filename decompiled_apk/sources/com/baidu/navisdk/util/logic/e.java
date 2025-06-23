package com.baidu.navisdk.util.logic;

import android.annotation.SuppressLint;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.LocationManager;
import android.os.Build;
import android.os.SystemClock;
import com.baidu.navisdk.util.common.LogUtil;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes8.dex */
public class e {
    private static final String g = "e";
    private static e h;

    /* renamed from: a, reason: collision with root package name */
    private final DecimalFormat f9324a = new DecimalFormat(".00");
    private long b = 0;
    private GpsStatus c = null;
    private final Set<String> d = new HashSet();
    private int e = 0;
    private int f = 0;

    private e() {
    }

    public static e c() {
        if (h == null) {
            synchronized (e.class) {
                try {
                    if (h == null) {
                        h = new e();
                    }
                } finally {
                }
            }
        }
        return h;
    }

    public void a(LocationManager locationManager, l lVar) {
        if (locationManager != null && SystemClock.elapsedRealtime() - this.b > 5000) {
            this.b = SystemClock.elapsedRealtime();
            LogUtil.e(g, "judgeSatellite");
            if (Build.VERSION.SDK_INT >= 31) {
                a(lVar);
            } else {
                a(locationManager);
            }
        }
    }

    public void b() {
        this.b = 0L;
        this.c = null;
        this.d.clear();
        this.e = 0;
        this.f = 0;
    }

    @SuppressLint({"MissingPermission"})
    private void a(LocationManager locationManager) {
        int i;
        try {
            GpsStatus gpsStatus = this.c;
            if (gpsStatus == null) {
                this.c = locationManager.getGpsStatus(null);
            } else {
                locationManager.getGpsStatus(gpsStatus);
            }
            GpsStatus gpsStatus2 = this.c;
            if (gpsStatus2 != null) {
                HashSet hashSet = new HashSet();
                char c = 0;
                if (this.d.size() == 0) {
                    i = 0;
                    c = 1;
                } else {
                    i = 0;
                }
                int i2 = 0;
                for (GpsSatellite gpsSatellite : gpsStatus2.getSatellites()) {
                    if (gpsSatellite.usedInFix()) {
                        i++;
                        String str = ((int) gpsSatellite.getAzimuth()) + HelpFormatter.DEFAULT_OPT_PREFIX + ((int) gpsSatellite.getElevation()) + HelpFormatter.DEFAULT_OPT_PREFIX + gpsSatellite.getPrn() + HelpFormatter.DEFAULT_OPT_PREFIX + this.f9324a.format(gpsSatellite.getSnr()) + HelpFormatter.DEFAULT_OPT_PREFIX + gpsSatellite.hasAlmanac() + HelpFormatter.DEFAULT_OPT_PREFIX + gpsSatellite.hasEphemeris();
                        hashSet.add(str);
                        if (this.d.size() > 0) {
                            if (this.d.contains(str)) {
                                this.d.remove(str);
                                LogUtil.e(g, "jsate, compare, last set contains : " + str);
                            } else {
                                LogUtil.e(g, "jsate, compare, last set do not contains : " + str);
                            }
                        } else {
                            LogUtil.e(g, "jsate, compare, last set is null.");
                        }
                    }
                    i2++;
                }
                if (c == 0 && this.d.size() == 0) {
                    c = 2;
                }
                if (c == 2) {
                    this.f++;
                    LogUtil.e(g, "jsate, compare, is same!!!!");
                } else {
                    LogUtil.e(g, "jsate, compare, is not same.");
                }
                this.e++;
                this.d.clear();
                this.d.addAll(hashSet);
                if (LogUtil.LOGGABLE) {
                    LogUtil.e(g, "jsate, totalCount=" + this.e + ", sameCount=" + this.f + ", fixedS=" + i + ", searchS=" + i2);
                }
            }
        } catch (Exception unused) {
        }
    }

    private void a(l lVar) {
        if (lVar == null) {
            return;
        }
        int a2 = lVar.a();
        HashSet hashSet = new HashSet();
        char c = this.d.size() == 0 ? (char) 1 : (char) 0;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < a2; i3++) {
            if (lVar.h(i3)) {
                i++;
                String str = ((int) lVar.b(i3)) + HelpFormatter.DEFAULT_OPT_PREFIX + ((int) lVar.e(i3)) + HelpFormatter.DEFAULT_OPT_PREFIX + lVar.d(i3) + HelpFormatter.DEFAULT_OPT_PREFIX + this.f9324a.format(lVar.c(i3)) + HelpFormatter.DEFAULT_OPT_PREFIX + lVar.f(i3) + HelpFormatter.DEFAULT_OPT_PREFIX + lVar.g(i3);
                hashSet.add(str);
                if (this.d.size() > 0) {
                    if (this.d.contains(str)) {
                        this.d.remove(str);
                        LogUtil.e(g, "jsate, compare, last set contains : " + str);
                    } else {
                        LogUtil.e(g, "jsate, compare, last set do not contains : " + str);
                    }
                } else {
                    LogUtil.e(g, "jsate, compare, last set is null.");
                }
            }
            i2++;
        }
        if (c == 0 && this.d.size() == 0) {
            c = 2;
        }
        if (c == 2) {
            this.f++;
            LogUtil.e(g, "jsate, compare, is same!!!!");
        } else {
            LogUtil.e(g, "jsate, compare, is not same.");
        }
        this.e++;
        this.d.clear();
        this.d.addAll(hashSet);
        if (LogUtil.LOGGABLE) {
            LogUtil.e(g, "jsate, totalCount=" + this.e + ", sameCount=" + this.f + ", fixedS=" + i + ", searchS=" + i2);
        }
    }

    public boolean a() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(g, "ism, totalCount=" + this.e + ", sameCount=" + this.f + ", r=" + ((this.f * 1.0d) / this.e));
        }
        int i = this.e;
        if (i > 10 && (this.f * 1.0d) / i > 0.3d) {
            LogUtil.e(g, "ism, true");
            com.baidu.navisdk.util.statistic.userop.b.r().a("7.3", "5", null, null);
            return true;
        }
        LogUtil.e(g, "ism, false");
        return false;
    }
}
