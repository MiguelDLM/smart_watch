package com.baidu.location.c;

import android.annotation.TargetApi;
import android.content.Context;
import android.location.GnssMeasurementsEvent;
import android.location.GnssNavigationMessage;
import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.OnNmeaMessageListener;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.b.ah;
import com.baidu.location.b.am;
import com.baidu.location.b.an;
import com.baidu.location.b.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes7.dex */
public class e {
    private static int A = 0;
    private static int B = 0;
    private static int C = 0;
    private static long D = 0;
    private static String R = null;
    private static double T = 100.0d;
    private static float W = -1.0f;

    /* renamed from: a, reason: collision with root package name */
    public static int f5696a = 0;
    private static final Lock al = new ReentrantLock();
    public static String b = "";
    public static String c = "";
    private static e f = null;
    private static Location j = null;
    private static int k = -1;
    private static int u;
    private static int v;
    private static int w;
    private static int x;
    private static int y;
    private static int z;
    private BDLocation ar;
    private String av;
    private Context g;
    private Location i;
    private GpsStatus n;
    private c o;
    private boolean p;
    private boolean r;
    private LocationManager h = null;
    private f l = null;
    private h m = null;
    private d q = null;
    private GpsStatus.NmeaListener s = null;
    private OnNmeaMessageListener t = null;
    private long E = 0;
    private boolean F = false;
    private boolean G = false;
    private String H = null;
    private boolean I = false;
    private long J = 0;
    private long K = 0;
    private double L = -1.0d;
    private double M = XIXIX.OOXIXo.f3760XO;
    private double N = XIXIX.OOXIXo.f3760XO;
    private long O = 0;
    private long P = 0;
    private long Q = 0;
    private HandlerC0128e S = null;
    private long U = 0;
    private long V = 0;
    private a X = null;
    private b Y = null;
    public ArrayList<ArrayList<Float>> d = new ArrayList<>();
    private ArrayList<ArrayList<Float>> Z = new ArrayList<>();
    private ArrayList<ArrayList<Float>> aa = new ArrayList<>();
    private ArrayList<ArrayList<Float>> ab = new ArrayList<>();
    private ArrayList<ArrayList<Float>> ac = new ArrayList<>();
    private ArrayList<ArrayList<Float>> ad = new ArrayList<>();
    private ArrayList<ArrayList<Float>> ae = new ArrayList<>();
    private ArrayList<ArrayList<Float>> af = new ArrayList<>();
    private String ag = null;
    private long ah = 0;
    private ArrayList<Integer> ai = new ArrayList<>();
    private final LinkedHashMap<String, Float> aj = new LinkedHashMap<>();
    private long ak = 0;
    private String am = null;
    private String an = null;
    private long ao = 0;
    private long ap = -1;
    private long aq = -1;
    private boolean as = false;
    private boolean at = false;
    private long au = 0;
    private long aw = 0;
    private boolean ax = false;
    private boolean ay = false;
    private boolean az = false;
    private StringBuilder aA = new StringBuilder();
    private String aB = "";
    private long aC = -1;
    private long aD = 0;
    private long aE = 0;
    private boolean aF = false;
    public long e = 0;

    @TargetApi(24)
    /* loaded from: classes7.dex */
    public class a extends GnssMeasurementsEvent.Callback {

        /* renamed from: a, reason: collision with root package name */
        public int f5697a;

        @Override // android.location.GnssMeasurementsEvent.Callback
        public void onGnssMeasurementsReceived(GnssMeasurementsEvent gnssMeasurementsEvent) {
        }

        @Override // android.location.GnssMeasurementsEvent.Callback
        public void onStatusChanged(int i) {
            this.f5697a = i;
        }
    }

    @TargetApi(24)
    /* loaded from: classes7.dex */
    public class b extends GnssNavigationMessage.Callback {

        /* renamed from: a, reason: collision with root package name */
        public int f5698a;

        private b() {
            this.f5698a = 0;
        }

        @Override // android.location.GnssNavigationMessage.Callback
        public void onGnssNavigationMessageReceived(GnssNavigationMessage gnssNavigationMessage) {
            an.a().a(gnssNavigationMessage, e.this.Q != 0 ? e.this.Q : System.currentTimeMillis() / 1000);
        }

        @Override // android.location.GnssNavigationMessage.Callback
        public void onStatusChanged(int i) {
            this.f5698a = i;
        }

        public /* synthetic */ b(e eVar, com.baidu.location.c.f fVar) {
            this();
        }
    }

    @TargetApi(24)
    /* loaded from: classes7.dex */
    public class c extends GnssStatus.Callback {
        private c() {
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int i) {
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            int satelliteCount;
            int constellationType;
            float azimuthDegrees;
            float elevationDegrees;
            float cn0DbHz;
            boolean usedInFix;
            int svid;
            ArrayList arrayList;
            if (e.this.h == null || gnssStatus == null) {
                return;
            }
            e.this.V = System.currentTimeMillis();
            satelliteCount = gnssStatus.getSatelliteCount();
            e.this.ac.clear();
            e.this.ad.clear();
            e.this.ae.clear();
            e.this.af.clear();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < satelliteCount; i4++) {
                i++;
                ArrayList arrayList2 = new ArrayList();
                constellationType = gnssStatus.getConstellationType(i4);
                azimuthDegrees = gnssStatus.getAzimuthDegrees(i4);
                arrayList2.add(Float.valueOf(azimuthDegrees));
                elevationDegrees = gnssStatus.getElevationDegrees(i4);
                arrayList2.add(Float.valueOf(elevationDegrees));
                cn0DbHz = gnssStatus.getCn0DbHz(i4);
                arrayList2.add(Float.valueOf(cn0DbHz));
                usedInFix = gnssStatus.usedInFix(i4);
                if (usedInFix) {
                    i2++;
                    arrayList2.add(Float.valueOf(1.0f));
                    if (constellationType == 1) {
                        i3++;
                    }
                } else {
                    arrayList2.add(Float.valueOf(0.0f));
                }
                svid = gnssStatus.getSvid(i4);
                arrayList2.add(Float.valueOf(svid));
                if (constellationType == 1) {
                    arrayList2.add(Float.valueOf(1.0f));
                    arrayList = e.this.ac;
                } else {
                    if (constellationType == 5) {
                        arrayList2.add(Float.valueOf(2.0f));
                        e.this.ad.add(arrayList2);
                        e.this.aD = System.currentTimeMillis();
                    } else if (constellationType == 3) {
                        arrayList2.add(Float.valueOf(3.0f));
                        arrayList = e.this.ae;
                    } else if (constellationType == 6) {
                        arrayList2.add(Float.valueOf(4.0f));
                        arrayList = e.this.af;
                    }
                }
                arrayList.add(arrayList2);
            }
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(e.this.ac);
            arrayList3.addAll(e.this.ad);
            arrayList3.addAll(e.this.ae);
            arrayList3.addAll(e.this.af);
            e.this.b((ArrayList<ArrayList<Float>>) arrayList3);
            e eVar = e.this;
            eVar.Z = eVar.a(true, false, false, false, true, -1.0f);
            e eVar2 = e.this;
            e.b = eVar2.a((ArrayList<ArrayList<Float>>) eVar2.Z);
            e eVar3 = e.this;
            eVar3.aa = eVar3.a(true, true, true, true, true, -1.0f);
            e eVar4 = e.this;
            eVar4.ab = eVar4.a(true, true, true, true, false, -1.0f);
            e eVar5 = e.this;
            e.c = eVar5.a((ArrayList<ArrayList<Float>>) eVar5.ab);
            if (com.baidu.location.b.e.b().bU == 1) {
                com.baidu.location.b.m.a().a(e.this.ab);
            }
            e.f5696a = i2;
            int unused = e.u = i3;
            int unused2 = e.C = i;
            long unused3 = e.D = System.currentTimeMillis();
            e eVar6 = e.this;
            int unused4 = e.v = eVar6.a((ArrayList<ArrayList<Float>>) eVar6.ae, true, -1.0f).size();
            e eVar7 = e.this;
            int unused5 = e.w = eVar7.a((ArrayList<ArrayList<Float>>) eVar7.af, true, -1.0f).size();
            e eVar8 = e.this;
            int unused6 = e.x = eVar8.a((ArrayList<ArrayList<Float>>) eVar8.ad, true, -1.0f).size();
            e eVar9 = e.this;
            int unused7 = e.y = eVar9.a((ArrayList<ArrayList<Float>>) eVar9.ac, false, -1.0f).size();
            e eVar10 = e.this;
            int unused8 = e.z = eVar10.a((ArrayList<ArrayList<Float>>) eVar10.ae, false, -1.0f).size();
            e eVar11 = e.this;
            int unused9 = e.A = eVar11.a((ArrayList<ArrayList<Float>>) eVar11.af, false, -1.0f).size();
            e eVar12 = e.this;
            int unused10 = e.B = eVar12.a((ArrayList<ArrayList<Float>>) eVar12.ad, false, -1.0f).size();
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            e.this.e((Location) null);
            e.this.b(false);
            e.f5696a = 0;
            int unused = e.u = 0;
            int unused2 = e.v = 0;
            int unused3 = e.w = 0;
            int unused4 = e.x = 0;
            int unused5 = e.y = 0;
            int unused6 = e.z = 0;
            int unused7 = e.A = 0;
            int unused8 = e.B = 0;
            int unused9 = e.C = 0;
            int unused10 = e.k = -1;
            Location unused11 = e.j = null;
        }

        public /* synthetic */ c(e eVar, com.baidu.location.c.f fVar) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public class d implements GpsStatus.Listener {
        private long b;

        private d() {
            this.b = 0L;
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int i) {
            long currentTimeMillis;
            ArrayList arrayList;
            if (e.this.h == null) {
                return;
            }
            int i2 = 0;
            if (i == 2) {
                e.this.e((Location) null);
                e.this.b(false);
                e.f5696a = 0;
                int unused = e.u = 0;
                int unused2 = e.v = 0;
                int unused3 = e.w = 0;
                int unused4 = e.x = 0;
                return;
            }
            if (i == 4 && e.this.G) {
                try {
                    if (e.this.n == null) {
                        e eVar = e.this;
                        eVar.n = eVar.h.getGpsStatus(null);
                    } else {
                        e.this.h.getGpsStatus(e.this.n);
                    }
                    e.this.V = System.currentTimeMillis();
                    e.this.ac.clear();
                    e.this.ad.clear();
                    e.this.ae.clear();
                    e.this.af.clear();
                    int i3 = 0;
                    for (GpsSatellite gpsSatellite : e.this.n.getSatellites()) {
                        ArrayList arrayList2 = new ArrayList();
                        int prn = gpsSatellite.getPrn();
                        arrayList2.add(Float.valueOf(gpsSatellite.getAzimuth()));
                        arrayList2.add(Float.valueOf(gpsSatellite.getElevation()));
                        arrayList2.add(Float.valueOf(gpsSatellite.getSnr()));
                        if (gpsSatellite.usedInFix()) {
                            i2++;
                            arrayList2.add(Float.valueOf(1.0f));
                            if (prn >= 1 && prn <= 32) {
                                i3++;
                            }
                        } else {
                            arrayList2.add(Float.valueOf(0.0f));
                        }
                        arrayList2.add(Float.valueOf(prn));
                        if (prn >= 1 && prn <= 32) {
                            arrayList2.add(Float.valueOf(1.0f));
                            arrayList = e.this.ac;
                        } else if (prn >= 201 && prn <= 261) {
                            arrayList2.add(Float.valueOf(2.0f));
                            arrayList = e.this.ad;
                        } else if (prn >= 65 && prn <= 96) {
                            arrayList2.add(Float.valueOf(3.0f));
                            arrayList = e.this.ae;
                        } else if (prn >= 301 && prn <= 336) {
                            arrayList2.add(Float.valueOf(4.0f));
                            arrayList = e.this.af;
                        }
                        arrayList.add(arrayList2);
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.addAll(e.this.ac);
                    arrayList3.addAll(e.this.ad);
                    arrayList3.addAll(e.this.ae);
                    arrayList3.addAll(e.this.af);
                    e.this.b((ArrayList<ArrayList<Float>>) arrayList3);
                    e eVar2 = e.this;
                    eVar2.Z = eVar2.a(true, false, false, false, true, -1.0f);
                    e eVar3 = e.this;
                    e.b = eVar3.a((ArrayList<ArrayList<Float>>) eVar3.Z);
                    e eVar4 = e.this;
                    eVar4.aa = eVar4.a(true, true, true, true, true, -1.0f);
                    e eVar5 = e.this;
                    eVar5.ab = eVar5.a(true, true, true, true, false, -1.0f);
                    e eVar6 = e.this;
                    e.c = eVar6.a((ArrayList<ArrayList<Float>>) eVar6.ab);
                    if (com.baidu.location.b.e.b().bU == 1) {
                        com.baidu.location.b.m.a().a(e.this.ab);
                    }
                    if (i3 > 0) {
                        int unused5 = e.u = i3;
                    }
                    if (i2 <= 0) {
                        if (System.currentTimeMillis() - this.b > 100) {
                            currentTimeMillis = System.currentTimeMillis();
                        }
                        long unused6 = e.D = System.currentTimeMillis();
                    }
                    currentTimeMillis = System.currentTimeMillis();
                    this.b = currentTimeMillis;
                    e.f5696a = i2;
                    long unused62 = e.D = System.currentTimeMillis();
                } catch (Exception unused7) {
                }
            }
        }

        public /* synthetic */ d(e eVar, com.baidu.location.c.f fVar) {
            this();
        }
    }

    /* renamed from: com.baidu.location.c.e$e, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class HandlerC0128e extends Handler {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<e> f5701a;
        e b;

        public HandlerC0128e(e eVar) {
            this.f5701a = new WeakReference<>(eVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Location location;
            String str;
            if (com.baidu.location.f.isServing) {
                e eVar = this.f5701a.get();
                this.b = eVar;
                if (eVar == null) {
                    return;
                }
                int i = message.what;
                if (i == 1) {
                    Location location2 = (Location) message.obj;
                    this.b.a(location2, com.baidu.location.b.e.b().bU == 1 ? com.baidu.location.b.m.a().a(location2) : -1);
                    return;
                }
                if (i == 3) {
                    location = (Location) message.obj;
                    str = "&og=1";
                } else {
                    if (i != 4) {
                        if (i != 5) {
                            return;
                        }
                        eVar.a((String) message.obj);
                        return;
                    }
                    location = (Location) message.obj;
                    str = "&og=2";
                }
                eVar.a(str, location);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements LocationListener {
        private f() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location == null && com.baidu.location.e.o.f == 4) {
                return;
            }
            if (com.baidu.location.e.o.l()) {
                com.baidu.location.c.c.a().a(location);
                return;
            }
            if (!com.baidu.location.e.o.a(location) && Math.abs(location.getLatitude()) <= 360.0d && Math.abs(location.getLongitude()) <= 360.0d) {
                e.this.Q = location.getTime() / 1000;
                e.this.ap = System.currentTimeMillis();
                if (e.this.P != 0) {
                    e.this.O = System.currentTimeMillis() - e.this.P;
                }
                e.this.P = System.currentTimeMillis();
                int i = e.f5696a;
                if (i == 0) {
                    try {
                        i = location.getExtras().getInt("satellites");
                    } catch (Exception unused) {
                    }
                }
                if (i == 0 || x.c().j()) {
                    System.currentTimeMillis();
                    long unused2 = e.this.V;
                }
                e.this.b(true);
                e.this.e(location);
                e.this.F = false;
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            e.this.e((Location) null);
            e.this.b(false);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
            if (i == 0) {
                e.this.e((Location) null);
            } else if (i != 1) {
                if (i != 2) {
                    return;
                }
                e.this.F = false;
                return;
            } else {
                e.this.E = System.currentTimeMillis();
                e.this.F = true;
            }
            e.this.b(false);
        }

        public /* synthetic */ f(e eVar, com.baidu.location.c.f fVar) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public class g implements GpsStatus.NmeaListener {
        private g() {
        }

        @Override // android.location.GpsStatus.NmeaListener
        public void onNmeaReceived(long j, String str) {
            if (e.this.S != null) {
                e.this.S.sendMessage(e.this.S.obtainMessage(5, str));
            }
        }

        public /* synthetic */ g(e eVar, com.baidu.location.c.f fVar) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public class h implements LocationListener {
        private long b;

        private h() {
            this.b = 0L;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (!(e.this.G && com.baidu.location.e.o.f == 4) && location != null && TextUtils.equals(location.getProvider(), "gps") && System.currentTimeMillis() - this.b >= 10000 && Math.abs(location.getLatitude()) <= 360.0d && Math.abs(location.getLongitude()) <= 360.0d && am.a(location, false)) {
                this.b = System.currentTimeMillis();
                if (e.this.S != null) {
                    e.this.e = System.currentTimeMillis();
                    e.this.S.sendMessage(e.this.S.obtainMessage(4, location));
                }
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }

        public /* synthetic */ h(e eVar, com.baidu.location.c.f fVar) {
            this();
        }
    }

    private e() {
        this.p = false;
        this.r = false;
        this.av = null;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                Class.forName("android.location.GnssStatus");
                this.p = true;
            } catch (ClassNotFoundException unused) {
                this.p = false;
            }
        }
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                this.av = Build.MANUFACTURER;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.r = false;
    }

    public static String l() {
        long currentTimeMillis = System.currentTimeMillis() - D;
        if (currentTimeMillis < 0 || currentTimeMillis >= 3000) {
            return null;
        }
        return String.format(Locale.US, "&gsvn=%d&gsfn=%d", Integer.valueOf(C), Integer.valueOf(f5696a));
    }

    private int f(Location location) {
        if (location == null) {
            return 0;
        }
        if (location.isFromMockProvider()) {
            return 100;
        }
        if (Math.abs(this.ap - this.aq) >= 3000) {
            this.aq = -1L;
            this.at = false;
            this.as = false;
            this.ar = null;
        } else if (this.ar == null) {
            if (!this.as) {
                return 200;
            }
            if (this.at) {
                return 300;
            }
        } else if (!this.at && this.as) {
            return 400;
        }
        if (this.ap > 0) {
            if (this.aq == -1) {
                return 500;
            }
        }
        return 0;
    }

    public BDLocation h() {
        if (this.ar != null && Math.abs(System.currentTimeMillis() - this.aq) <= 3000) {
            return this.ar;
        }
        return null;
    }

    public synchronized String m() {
        String str;
        str = "-2";
        try {
            if (Math.abs(System.currentTimeMillis() - this.ah) < 3000) {
                String str2 = this.ag;
                str = str2 == null ? "0" : str2;
            } else {
                str = "-1";
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "&gnsf=" + str;
    }

    public static String b(Location location) {
        String a2 = a(location);
        if (a2 == null) {
            return a2;
        }
        return a2 + "&g_tp=0";
    }

    public Location g() {
        if (this.i != null && Math.abs(System.currentTimeMillis() - this.i.getTime()) <= 60000) {
            return this.i;
        }
        return null;
    }

    public boolean i() {
        try {
            System.currentTimeMillis();
            if (f5696a == 0) {
                try {
                    this.i.getExtras().getInt("satellites");
                } catch (Exception unused) {
                }
            }
            Location location = this.i;
            if (location != null && location.getLatitude() != XIXIX.OOXIXo.f3760XO) {
                if (this.i.getLongitude() != XIXIX.OOXIXo.f3760XO) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused2) {
            Location location2 = this.i;
            return (location2 == null || location2.getLatitude() == XIXIX.OOXIXo.f3760XO || this.i.getLongitude() == XIXIX.OOXIXo.f3760XO) ? false : true;
        }
    }

    public boolean j() {
        if (!i() || com.baidu.location.e.o.l() || System.currentTimeMillis() - this.J > 10000) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.F || currentTimeMillis - this.E >= 3000) {
            return this.I;
        }
        return true;
    }

    public boolean k() {
        return this.aF;
    }

    public static String c(Location location) {
        String a2 = a(location);
        if (a2 == null) {
            return a2;
        }
        return a2 + R;
    }

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            try {
                if (f == null) {
                    f = new e();
                }
                eVar = f;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    public synchronized void b() {
        if (com.baidu.location.f.isServing) {
            Context serviceContext = com.baidu.location.f.getServiceContext();
            this.g = serviceContext;
            try {
                this.h = (LocationManager) serviceContext.getSystemService("location");
            } catch (Exception unused) {
            }
            this.S = new HandlerC0128e(this);
        }
    }

    public synchronized void e() {
        d();
        if (this.h == null) {
            return;
        }
        try {
            HandlerC0128e handlerC0128e = this.S;
            if (handlerC0128e != null) {
                handlerC0128e.removeCallbacksAndMessages(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.h = null;
        if (com.baidu.location.b.e.b().bU == 1 && com.baidu.location.b.m.a().b()) {
            com.baidu.location.b.m.a().c();
        }
    }

    public String f() {
        boolean z2;
        if (this.i == null) {
            return null;
        }
        String str = "{\"result\":{\"time\":\"" + com.baidu.location.e.o.a() + "\",\"error\":\"61\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%d\",\"d\":\"%f\",\"s\":\"%f\",\"n\":\"%d\"";
        int accuracy = (int) (this.i.hasAccuracy() ? this.i.getAccuracy() : 10.0f);
        float speed = (float) (this.i.getSpeed() * 3.6d);
        if (!this.i.hasSpeed()) {
            speed = -1.0f;
        }
        double[] dArr = new double[2];
        if (com.baidu.location.e.f.a().a(this.i.getLongitude(), this.i.getLatitude())) {
            dArr = Jni.coorEncrypt(this.i.getLongitude(), this.i.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
            if (dArr[0] <= XIXIX.OOXIXo.f3760XO && dArr[1] <= XIXIX.OOXIXo.f3760XO) {
                dArr[0] = this.i.getLongitude();
                dArr[1] = this.i.getLatitude();
            }
            z2 = true;
        } else {
            dArr[0] = this.i.getLongitude();
            double latitude = this.i.getLatitude();
            dArr[1] = latitude;
            if (dArr[0] <= XIXIX.OOXIXo.f3760XO && latitude <= XIXIX.OOXIXo.f3760XO) {
                dArr[0] = this.i.getLongitude();
                dArr[1] = this.i.getLatitude();
            }
            z2 = false;
        }
        Locale locale = Locale.CHINA;
        String format = String.format(locale, str, Double.valueOf(dArr[0]), Double.valueOf(dArr[1]), Integer.valueOf(accuracy), Float.valueOf(this.i.getBearing()), Float.valueOf(speed), Integer.valueOf(f5696a));
        if (!z2) {
            format = format + ",\"in_cn\":\"0\"";
        }
        if (!com.baidu.location.e.o.l) {
            format = format + String.format(locale, ",\"is_mock\":%d", Integer.valueOf(f(this.i)));
        }
        if (this.i.hasAltitude()) {
            return format + String.format(locale, ",\"h\":%.2f}}", Double.valueOf(this.i.getAltitude()));
        }
        return format + "}}";
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x01c2 -> B:27:0x01c6). Please report as a decompilation issue!!! */
    public static String a(Location location) {
        String str;
        if (location == null) {
            return null;
        }
        float speed = (float) (location.getSpeed() * 3.6d);
        if (!location.hasSpeed()) {
            speed = -1.0f;
        }
        int accuracy = (int) (location.hasAccuracy() ? location.getAccuracy() : -1.0f);
        double altitude = location.hasAltitude() ? location.getAltitude() : 555.0d;
        float bearing = location.hasBearing() ? location.getBearing() : -1.0f;
        float f2 = W;
        Locale locale = Locale.CHINA;
        Double valueOf = Double.valueOf(location.getLongitude());
        Double valueOf2 = Double.valueOf(location.getLatitude());
        Float valueOf3 = Float.valueOf(speed);
        Float valueOf4 = Float.valueOf(bearing);
        Integer valueOf5 = Integer.valueOf(accuracy);
        Integer valueOf6 = Integer.valueOf(f5696a);
        Double valueOf7 = Double.valueOf(altitude);
        Long valueOf8 = Long.valueOf(location.getTime() / 1000);
        Integer valueOf9 = Integer.valueOf(f5696a);
        Integer valueOf10 = Integer.valueOf(u);
        Integer valueOf11 = Integer.valueOf(v);
        Integer valueOf12 = Integer.valueOf(w);
        Integer valueOf13 = Integer.valueOf(x);
        Integer valueOf14 = Integer.valueOf(C);
        Integer valueOf15 = Integer.valueOf(y);
        Integer valueOf16 = Integer.valueOf(z);
        Integer valueOf17 = Integer.valueOf(A);
        Integer valueOf18 = Integer.valueOf(B);
        Double valueOf19 = Double.valueOf(T);
        String format = f2 < -0.01f ? String.format(locale, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d&ll_sn=%d|%d|%d|%d|%d&ll_asn=%d|%d|%d|%d|%d&ll_snr=%.1f", valueOf, valueOf2, valueOf3, valueOf4, valueOf5, valueOf6, valueOf7, valueOf8, valueOf9, valueOf10, valueOf11, valueOf12, valueOf13, valueOf14, valueOf15, valueOf16, valueOf17, valueOf18, valueOf19) : String.format(locale, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d&ll_sn=%d|%d|%d|%d|%d&ll_asn=%d|%d|%d|%d|%d&ll_snr=%.1f&ll_bp=%.2f", valueOf, valueOf2, valueOf3, valueOf4, valueOf5, valueOf6, valueOf7, valueOf8, valueOf9, valueOf10, valueOf11, valueOf12, valueOf13, valueOf14, valueOf15, valueOf16, valueOf17, valueOf18, valueOf19, Float.valueOf(W));
        try {
            if (k != 2 || j == null) {
                str = format + "&ll_fake=" + k;
            } else {
                str = format + String.format(Locale.CHINA, "&ll_fake=%d|%.5f|%.5f|%d", Integer.valueOf(k), Double.valueOf(j.getLongitude()), Double.valueOf(j.getLatitude()), Long.valueOf(j.getTime() / 1000));
            }
        } catch (Exception e) {
            e.printStackTrace();
            str = format;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ArrayList<ArrayList<Float>> arrayList) {
        String str;
        if (arrayList == null || arrayList.size() <= 0) {
            str = null;
        } else {
            StringBuilder sb = new StringBuilder(100);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(this.ac);
            sb.append(com.baidu.location.e.d.g(arrayList2));
            sb.append("|");
            sb.append(com.baidu.location.e.d.f(arrayList2));
            sb.append("|");
            sb.append(com.baidu.location.e.d.a(arrayList2));
            sb.append("|");
            sb.append(com.baidu.location.e.d.h(arrayList2));
            sb.append("|");
            sb.append(com.baidu.location.e.d.b(arrayList2));
            sb.append("|");
            sb.append(com.baidu.location.e.d.c(arrayList2));
            sb.append("|");
            sb.append(com.baidu.location.e.d.e(arrayList2));
            sb.append("|");
            sb.append(com.baidu.location.e.d.d(arrayList2));
            str = sb.toString();
        }
        this.ag = str;
        this.ah = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Location location) {
        if (this.S == null || System.currentTimeMillis() - this.aw <= 3000) {
            return;
        }
        this.S.sendMessage(this.S.obtainMessage(1, location));
    }

    public void c() {
        if (this.G) {
            return;
        }
        com.baidu.location.c.f fVar = null;
        try {
            if (!this.p) {
                d dVar = new d(this, fVar);
                this.q = dVar;
                this.h.addGpsStatusListener(dVar);
            } else if (com.baidu.location.e.o.a(this.g, com.kuaishou.weapon.p0.g.g) == 1) {
                c cVar = new c(this, fVar);
                this.o = cVar;
                this.h.registerGnssStatusCallback(cVar);
            }
            h hVar = new h(this, fVar);
            this.m = hVar;
            this.h.requestLocationUpdates("passive", 9000L, 0.0f, hVar);
        } catch (Exception unused) {
        }
        try {
            this.l = new f(this, fVar);
            try {
                this.h.sendExtraCommand("gps", "force_xtra_injection", new Bundle());
            } catch (Exception unused2) {
            }
            if (com.baidu.location.e.o.a(this.g, com.kuaishou.weapon.p0.g.g) == 1) {
                this.h.requestLocationUpdates("gps", 1000L, 0.0f, this.l);
                this.aF = true;
            }
            if (this.p && this.Y == null && com.baidu.location.e.o.aC == 1 && new Random().nextDouble() < com.baidu.location.e.o.aB) {
                this.Y = new b(this, fVar);
            }
            b bVar = this.Y;
            if (bVar != null) {
                this.h.registerGnssNavigationMessageCallback(bVar);
            }
            this.U = System.currentTimeMillis();
            if (!com.baidu.location.e.o.l && com.baidu.location.e.o.aW == 1) {
                if (Build.VERSION.SDK_INT >= 24) {
                    com.baidu.location.c.f fVar2 = new com.baidu.location.c.f(this);
                    this.t = fVar2;
                    this.h.addNmeaListener(fVar2);
                } else {
                    this.s = new g(this, fVar);
                    Class.forName("android.location.LocationManager").getMethod("addNmeaListener", GpsStatus.NmeaListener.class).invoke(this.h, this.s);
                }
            }
            this.G = true;
        } catch (Exception unused3) {
        }
    }

    public void d() {
        c cVar;
        if (this.G) {
            LocationManager locationManager = this.h;
            if (locationManager != null) {
                try {
                    d dVar = this.q;
                    if (dVar != null) {
                        locationManager.removeGpsStatusListener(dVar);
                        this.q = null;
                    }
                    if (this.p && (cVar = this.o) != null) {
                        this.h.unregisterGnssStatusCallback(cVar);
                        this.o = null;
                    }
                    h hVar = this.m;
                    if (hVar != null) {
                        this.h.removeUpdates(hVar);
                        this.m = null;
                    }
                } catch (Exception unused) {
                }
                try {
                    f fVar = this.l;
                    if (fVar != null) {
                        this.h.removeUpdates(fVar);
                        this.aF = false;
                    }
                    OnNmeaMessageListener onNmeaMessageListener = this.t;
                    if (onNmeaMessageListener != null) {
                        this.h.removeNmeaListener(onNmeaMessageListener);
                    }
                    if (this.s != null) {
                        Class.forName("android.location.LocationManager").getMethod("removeNmeaListener", GpsStatus.NmeaListener.class).invoke(this.h, this.s);
                    }
                    b bVar = this.Y;
                    if (bVar != null) {
                        this.h.unregisterGnssNavigationMessageCallback(bVar);
                    }
                    a(0);
                } catch (Exception unused2) {
                }
            }
            com.baidu.location.e.o.d = 0;
            com.baidu.location.e.o.u = 0;
            this.l = null;
            this.G = false;
            b(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(ArrayList<ArrayList<Float>> arrayList) {
        StringBuilder sb = new StringBuilder();
        if (arrayList.size() == 0) {
            return sb.toString();
        }
        Iterator<ArrayList<Float>> it = arrayList.iterator();
        boolean z2 = true;
        while (it.hasNext()) {
            ArrayList<Float> next = it.next();
            if (next.size() == 6) {
                if (z2) {
                    z2 = false;
                } else {
                    sb.append("|");
                }
                sb.append(String.format("%.1f;", next.get(0)));
                sb.append(String.format("%.1f;", next.get(1)));
                sb.append(String.format("%.1f;", next.get(2)));
                sb.append(String.format("%.0f;", next.get(3)));
                sb.append(String.format("%.0f;", next.get(4)));
                sb.append(String.format("%.0f", next.get(5)));
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z2) {
        this.I = z2;
        W = -1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<ArrayList<Float>> a(ArrayList<ArrayList<Float>> arrayList, boolean z2, float f2) {
        ArrayList<ArrayList<Float>> arrayList2 = new ArrayList<>();
        if (arrayList.size() <= 40 && arrayList.size() != 0) {
            Iterator<ArrayList<Float>> it = arrayList.iterator();
            while (it.hasNext()) {
                ArrayList<Float> next = it.next();
                if (next.size() == 6) {
                    float floatValue = next.get(3).floatValue();
                    float floatValue2 = next.get(2).floatValue();
                    if (!z2 || floatValue >= 1.0f) {
                        if (f2 <= 0.0f || floatValue2 >= f2) {
                            arrayList2.add(next);
                        }
                    }
                }
            }
        }
        return arrayList2;
    }

    private boolean b(String str) {
        int i;
        if (str.indexOf("*") != -1 && str.indexOf("$") != -1 && str.indexOf("$") <= str.indexOf("*") && str.length() >= str.indexOf("*")) {
            byte[] bytes = str.substring(0, str.indexOf("*")).getBytes();
            int i2 = bytes[1];
            for (int i3 = 2; i3 < bytes.length; i3++) {
                i2 ^= bytes[i3];
            }
            String format = String.format("%02x", Integer.valueOf(i2));
            int indexOf = str.indexOf("*");
            if (indexOf != -1 && str.length() >= (i = indexOf + 3) && format.equalsIgnoreCase(str.substring(indexOf + 1, i))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<ArrayList<Float>> a(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, float f2) {
        ArrayList<ArrayList<Float>> arrayList = new ArrayList<>();
        if (z2) {
            arrayList.addAll(a(this.ac, z6, f2));
        }
        if (z3) {
            arrayList.addAll(a(this.ad, z6, f2));
        }
        if (z4) {
            arrayList.addAll(a(this.ae, z6, f2));
        }
        if (z5) {
            arrayList.addAll(a(this.af, z6, f2));
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x000f, code lost:
    
        if (r3 == 1) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(int r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 != 0) goto L8
            r2.az = r0
        L5:
            r2.ay = r0
            goto L12
        L8:
            r1 = 2
            if (r3 != r1) goto Le
            r2.az = r0
            goto L12
        Le:
            r1 = 1
            if (r3 != r1) goto L12
            goto L5
        L12:
            boolean r3 = r2.ay
            if (r3 != 0) goto L34
            boolean r3 = r2.az
            if (r3 == 0) goto L1b
            goto L34
        L1b:
            boolean r3 = r2.p
            if (r3 == 0) goto L34
            com.baidu.location.c.e$a r3 = r2.X
            if (r3 == 0) goto L34
            android.location.LocationManager r1 = r2.h
            if (r1 == 0) goto L34
            com.baidu.location.c.oIX0oI.oIX0oI(r1, r3)     // Catch: java.lang.Exception -> L2b
            goto L2f
        L2b:
            r3 = move-exception
            r3.printStackTrace()
        L2f:
            r3 = 0
            r2.X = r3
            r2.ax = r0
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.e.a(int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Location location, int i) {
        if (location == null) {
            this.i = null;
            return;
        }
        if (f5696a == 0) {
            try {
                location.getExtras().getInt("satellites");
            } catch (Exception unused) {
            }
        }
        if (this.r && com.baidu.location.e.o.a(location.getSpeed(), 0.0f) && !com.baidu.location.e.o.a(this.M, XIXIX.OOXIXo.f3760XO) && System.currentTimeMillis() - this.N < 2000.0d) {
            location.setSpeed((float) this.M);
        }
        Location location2 = new Location(location);
        this.J = System.currentTimeMillis();
        this.i = location;
        int i2 = f5696a;
        long currentTimeMillis = System.currentTimeMillis();
        this.i.setTime(currentTimeMillis);
        float speed = (float) (this.i.getSpeed() * 3.6d);
        if (!this.i.hasSpeed()) {
            speed = -1.0f;
        }
        if (i2 == 0) {
            try {
                i2 = this.i.getExtras().getInt("satellites");
            } catch (Exception unused2) {
            }
        }
        this.H = String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_n=%d&ll_t=%d", Double.valueOf(this.i.getLongitude()), Double.valueOf(this.i.getLatitude()), Float.valueOf(speed), Float.valueOf(this.i.getBearing()), Integer.valueOf(i2), Long.valueOf(currentTimeMillis));
        if (this.i != null) {
            BDLocation bDLocation = new BDLocation(f());
            com.baidu.location.b.h.a().a(bDLocation, "gcj02", this.i);
            Bundle extras = location.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            extras.putInt("sat_num", i2);
            if (Math.abs(System.currentTimeMillis() - this.aD) >= 3000) {
                extras.putBoolean("is_support_beidou", false);
            } else {
                extras.putBoolean("is_support_beidou", true);
            }
            bDLocation.setExtrainfo(extras);
            Location location3 = this.i;
            if (location3 != null && BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU.equals(location3.getProvider())) {
                bDLocation.setGnssProvider(BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU);
            }
            a(bDLocation);
            if (f5696a > 2 && am.a(this.i, true) && "gps".equals(this.i.getProvider())) {
                boolean j2 = com.baidu.location.c.h.a().j();
                com.baidu.location.c.a f2 = com.baidu.location.c.h.a().f();
                if (f2 != null) {
                    ah.a(new com.baidu.location.c.a(f2));
                }
                ah.a(System.currentTimeMillis());
                ah.a(new Location(this.i));
                ah.a(com.baidu.location.b.c.a().c());
                ah.b(com.baidu.location.b.h.a().c());
                if (!j2) {
                    an.a().b();
                }
            }
        }
        if ("gps".equals(location2.getProvider())) {
            an.a().a(location2, f5696a);
        }
    }

    public void a(BDLocation bDLocation) {
        if (com.baidu.location.e.o.l || f(this.i) <= 0) {
            com.baidu.location.b.c.a().d(bDLocation);
        } else {
            com.baidu.location.b.c.a().c(bDLocation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (TextUtils.isEmpty(str) || !b(str)) {
            return;
        }
        if (str.startsWith("$GPGGA,")) {
            a(str, 2, 4, 6);
        } else if (str.startsWith("$GPRMC,")) {
            a(str, 3, 5, 2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00e9, code lost:
    
        if (android.text.TextUtils.equals(r0[r14], "A") != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00eb, code lost:
    
        r10.as = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00f8, code lost:
    
        if (android.text.TextUtils.equals(r0[r14], "0") != false) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(java.lang.String r11, int r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.e.a(java.lang.String, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Location location) {
        if (location == null) {
            return;
        }
        String str2 = str + com.baidu.location.b.c.a().c();
        boolean j2 = com.baidu.location.c.h.a().j();
        com.baidu.location.c.a f2 = com.baidu.location.c.h.a().f();
        if (f2 != null) {
            ah.a(new com.baidu.location.c.a(f2));
        }
        ah.a(System.currentTimeMillis());
        ah.a(new Location(location));
        ah.a(str2);
        ah.b(com.baidu.location.b.h.a().c());
        if (j2) {
            return;
        }
        am.a(ah.c(), (p) null, ah.d(), str2, ah.e());
    }

    public void a(boolean z2) {
        if (z2) {
            c();
        } else {
            d();
        }
    }

    public static boolean a(Location location, Location location2, boolean z2) {
        if (location == location2) {
            return false;
        }
        if (location == null || location2 == null) {
            return true;
        }
        float speed = location2.getSpeed();
        if (z2 && ((com.baidu.location.e.o.u == 3 || !com.baidu.location.e.f.a().a(location2.getLongitude(), location2.getLatitude())) && speed < 5.0f)) {
            return true;
        }
        float distanceTo = location2.distanceTo(location);
        return speed > com.baidu.location.e.o.K ? distanceTo > com.baidu.location.e.o.M : speed > com.baidu.location.e.o.J ? distanceTo > com.baidu.location.e.o.L : distanceTo > 5.0f;
    }
}
