package com.baidu.platform.comapi.wnplatform.c;

import XIXIX.OOXIXo;
import android.content.Context;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Message;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.map.MessageCenter;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes8.dex */
public class d extends com.baidu.platform.comapi.walknavi.a {
    private List<com.baidu.platform.comapi.wnplatform.c.a> f;
    private c j;
    private Handler k;
    private Context l;
    private long m;
    private static GeoPoint g = new GeoPoint(OOXIXo.f3760XO, OOXIXo.f3760XO);

    /* renamed from: a, reason: collision with root package name */
    public static int f9897a = 0;
    private WLocData b = null;
    private WLocData c = new WLocData();
    private LocationManager d = null;
    private ArrayList<b> e = new ArrayList<>();
    private boolean h = false;
    private boolean i = false;
    private long n = 0;
    private int o = 2;
    private int p = 0;
    private int q = 0;
    private long r = 0;
    private boolean s = false;
    private GpsStatus.Listener t = new e(this);
    private int u = 0;
    private boolean v = false;
    private Location w = null;
    private LocationListener x = new f(this);
    private LocationListener y = new g(this);

    /* loaded from: classes8.dex */
    public class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 4103) {
                if (d.this.f != null) {
                    for (com.baidu.platform.comapi.wnplatform.c.a aVar : d.this.f) {
                        if (aVar != null) {
                            aVar.a(message);
                        }
                    }
                }
                if (message.arg1 == 0) {
                    d.this.h = false;
                }
            }
        }

        public /* synthetic */ a(d dVar, e eVar) {
            this();
        }
    }

    private void f() {
        this.r = 0L;
        this.q = 0;
        this.p = 0;
        this.n = 0L;
        this.o = 2;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        a();
        if (this.k != null) {
            this.k = null;
        }
        this.l = null;
    }

    public boolean c() {
        LocationManager locationManager = this.d;
        if (locationManager == null) {
            return false;
        }
        try {
            return locationManager.isProviderEnabled("gps");
        } catch (Exception e) {
            com.baidu.platform.comapi.wnplatform.d.a.b(e.getMessage());
            return false;
        }
    }

    public synchronized void d() {
        try {
            LocationManager locationManager = this.d;
            if (locationManager != null) {
                locationManager.removeUpdates(this.x);
            }
        } catch (Exception unused) {
        }
        try {
            LocationManager locationManager2 = this.d;
            if (locationManager2 != null) {
                locationManager2.removeGpsStatusListener(this.t);
            }
        } catch (Exception e) {
            com.baidu.platform.comapi.wnplatform.d.a.b(e.getMessage());
        }
        this.h = false;
        this.x = null;
        this.t = null;
        this.d = null;
    }

    public boolean e() {
        return this.s;
    }

    public void b(com.baidu.platform.comapi.wnplatform.c.a aVar) {
        List<com.baidu.platform.comapi.wnplatform.c.a> list = this.f;
        if (list == null || aVar == null) {
            return;
        }
        list.remove(aVar);
    }

    private void c(Context context) {
        if (context == null) {
            return;
        }
        try {
            this.h = false;
            LocationManager locationManager = this.d;
            if (locationManager == null) {
                this.d = (LocationManager) context.getSystemService("location");
            } else {
                locationManager.removeUpdates(this.x);
            }
            this.d.requestLocationUpdates("gps", 0L, 0.0f, this.x);
            this.d.addGpsStatusListener(this.t);
            f();
        } catch (Exception unused) {
        }
    }

    public void b(b bVar) {
        this.e.remove(bVar);
    }

    public GeoPoint b() {
        return new GeoPoint(g.getLatitudeE6(), g.getLongitudeE6());
    }

    public synchronized void a(Context context) {
        try {
            this.l = context;
            if (this.d == null) {
                this.d = (LocationManager) context.getSystemService("location");
            }
            a aVar = new a(this, null);
            this.k = aVar;
            MessageCenter.registMessage(4103, aVar);
            this.m = System.currentTimeMillis();
            this.s = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void b(Context context) {
        c(context);
    }

    public void b(WLocData wLocData) {
        c cVar;
        this.i = true;
        com.baidu.platform.comapi.wnplatform.f.a().d();
        if (wLocData.accuracy < 80.0f) {
            try {
                WLocData m98clone = wLocData.m98clone();
                this.c = m98clone;
                a(m98clone, "sdk");
                if (wLocData.isIndoorMode) {
                    int i = f9897a + 1;
                    f9897a = i;
                    if (i <= 3 || (cVar = this.j) == null) {
                        return;
                    }
                    cVar.a();
                    return;
                }
                f9897a = 0;
            } catch (Exception unused) {
            }
        }
    }

    public synchronized void a() {
        try {
            MessageCenter.unregistMessage(4103, this.k);
            d();
            ArrayList<b> arrayList = this.e;
            if (arrayList != null) {
                arrayList.clear();
            }
            List<com.baidu.platform.comapi.wnplatform.c.a> list = this.f;
            if (list != null) {
                list.clear();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void a(b bVar) {
        this.e.add(bVar);
    }

    public void a(c cVar) {
        this.j = cVar;
        f9897a = 0;
    }

    public void a(com.baidu.platform.comapi.wnplatform.c.a aVar) {
        if (this.f == null) {
            this.f = new LinkedList();
        }
        this.f.add(aVar);
    }

    public LatLng a(WLocData wLocData) {
        if (wLocData == null) {
            return null;
        }
        int i = wLocData.coordType;
        if (i == 2) {
            return new LatLng(wLocData.latitude, wLocData.longitude);
        }
        if (i == 3) {
            return CoordUtil.Coordinate_encryptEx((float) wLocData.longitude, (float) wLocData.latitude, "gcj02");
        }
        if (i == 0) {
            return CoordUtil.Coordinate_encryptEx((float) wLocData.longitude, (float) wLocData.latitude, "wgs84");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Location location) {
        WLocData wLocData;
        if (location == null || (wLocData = this.c) == null) {
            return;
        }
        wLocData.latitude = location.getLatitude();
        this.c.longitude = location.getLongitude();
        this.c.speed = location.getSpeed();
        this.c.accuracy = Math.min(2000.0f, location.getAccuracy());
        this.c.direction = location.getBearing();
        this.c.altitude = location.getAltitude();
        this.c.coordType = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WLocData wLocData, String str) {
        GeoPoint geoPoint;
        ArrayList arrayList;
        if (wLocData == null) {
            return;
        }
        try {
            this.b = wLocData.m98clone();
            int i = wLocData.coordType;
            if (i == 0) {
                geoPoint = com.baidu.platform.comapi.wnplatform.p.b.a(wLocData.longitude, wLocData.latitude);
            } else if (i == 3) {
                geoPoint = new GeoPoint((int) (wLocData.latitude * 100000.0d), (int) (wLocData.longitude * 100000.0d));
            } else {
                geoPoint = i == 2 ? new GeoPoint(wLocData.latitude, wLocData.longitude) : null;
            }
            if (geoPoint != null) {
                g.setLongitudeE6(geoPoint.getLongitudeE6());
                g.setLatitudeE6(geoPoint.getLatitudeE6());
            }
            synchronized (this.e) {
                arrayList = new ArrayList(this.e);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar != null) {
                    bVar.a(this.b);
                }
            }
        } catch (Exception unused) {
        }
    }

    public boolean a(Location location, Location location2) {
        if (location2 == null) {
            return true;
        }
        long time = location.getTime() - location2.getTime();
        boolean z = time > 120000;
        boolean z2 = time < -120000;
        boolean z3 = time > 0;
        if (z) {
            return true;
        }
        if (z2) {
            return false;
        }
        int accuracy = (int) (location.getAccuracy() - location2.getAccuracy());
        boolean z4 = accuracy > 0;
        boolean z5 = accuracy < 0;
        boolean z6 = accuracy > 200;
        boolean a2 = a(location.getProvider(), location2.getProvider());
        if (z5) {
            return true;
        }
        if (!z3 || z4) {
            return z3 && !z6 && a2;
        }
        return true;
    }

    private boolean a(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }
}
