package com.baidu.location.c;

import android.location.Location;
import android.os.Build;
import com.baidu.location.b.z;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public b f5692a = null;
    public Location b = null;
    public Location c = null;
    public long d = 0;
    public long e = 0;
    private Timer f = null;
    private TimerTask g = null;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static c f5693a = new c();
    }

    /* loaded from: classes7.dex */
    public class b implements z.c {
        private b() {
        }

        @Override // com.baidu.location.b.z.c
        public void a(Location location) {
            if (location == null) {
                return;
            }
            c cVar = c.this;
            cVar.b = location;
            cVar.e = System.currentTimeMillis();
        }

        public /* synthetic */ b(c cVar, d dVar) {
            this();
        }
    }

    public static c a() {
        return a.f5693a;
    }

    private synchronized void e() {
        try {
            TimerTask timerTask = this.g;
            if (timerTask != null) {
                timerTask.cancel();
                this.g = null;
            }
            Timer timer = this.f;
            if (timer != null) {
                timer.cancel();
                this.f.purge();
                this.f = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public String b(Location location) {
        if (location != null) {
            return String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_n=%d&ll_t=%d&ll_r=%d", Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Float.valueOf((float) (location.getSpeed() * 3.6d)), Float.valueOf(location.getBearing()), 0, Long.valueOf(location.getTime() / 1000), Integer.valueOf((int) (location.hasAccuracy() ? location.getAccuracy() : -1.0f)));
        }
        return null;
    }

    public synchronized void c() {
        try {
            if (this.f5692a != null) {
                z.a().b(this.f5692a);
                this.f5692a = null;
            }
            e();
        } catch (Throwable th) {
            throw th;
        }
    }

    public Location d() {
        return System.currentTimeMillis() - this.d < 30000 ? this.c : System.currentTimeMillis() - this.e < 30000 ? this.b : null;
    }

    public void a(Location location) {
        this.c = location;
        this.d = System.currentTimeMillis();
    }

    public void b() {
        if (Build.VERSION.SDK_INT >= 31 && com.baidu.location.e.o.aF != 0) {
            if (!com.baidu.location.e.o.l()) {
                c();
                return;
            }
            e();
            if (this.f == null && this.g == null) {
                this.f = new Timer();
                d dVar = new d(this);
                this.g = dVar;
                this.f.schedule(dVar, 60000L);
            }
            if (this.f5692a == null) {
                this.f5692a = new b(this, null);
                z.a().a(this.f5692a);
            }
        }
    }

    public boolean a(Location location, Location location2) {
        float[] fArr;
        if (location2 == null) {
            return false;
        }
        if (location == null) {
            return true;
        }
        try {
            fArr = new float[2];
            Location.distanceBetween(location.getLatitude(), location.getLongitude(), location2.getLatitude(), location2.getLongitude(), fArr);
        } catch (Exception unused) {
        }
        return fArr[0] >= 100.0f;
    }
}
