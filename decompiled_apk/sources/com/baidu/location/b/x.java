package com.baidu.location.b;

import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Poi;
import com.baidu.location.PoiRegion;
import com.baidu.location.b.s;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class x extends s {
    public static String h = "0";
    public static boolean j = false;
    private static x k;
    private long B;
    private double F;
    private double G;
    public s.c g;
    private boolean l = true;
    private String m = null;
    private BDLocation n = null;
    private BDLocation o = null;
    private Location p = null;
    private com.baidu.location.c.p q = null;
    private com.baidu.location.c.a r = null;
    private HashSet<String> s = null;
    private com.baidu.location.c.p t = null;
    private com.baidu.location.c.a u = null;
    private boolean v = true;
    private volatile boolean w = false;
    private boolean x = false;
    private long y = 0;
    private long z = 0;
    private Address A = null;
    private String C = null;
    private List<Poi> D = null;
    private PoiRegion E = null;
    private boolean H = false;
    private long I = 0;
    private long J = 0;
    private a K = null;
    private boolean L = false;
    private boolean M = false;
    private boolean N = true;
    public final Handler i = new s.b();
    private boolean O = false;
    private boolean P = false;
    private b Q = null;
    private boolean R = false;
    private int S = 0;
    private long T = 0;
    private boolean U = false;
    private String V = null;
    private boolean W = false;
    private boolean X = false;
    private boolean Y = false;
    private long Z = 0;
    private Address aa = null;
    private boolean ab = true;

    /* loaded from: classes7.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ x f5672a;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f5672a.L) {
                this.f5672a.L = false;
                boolean unused = this.f5672a.M;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (x.this.R) {
                x.this.R = false;
            }
            if (x.this.x) {
                x.this.x = false;
                x.this.h(null);
            }
        }

        public /* synthetic */ b(x xVar, y yVar) {
            this();
        }
    }

    private x() {
        this.g = null;
        this.g = new s.c();
        this.e = new s.a();
    }

    public static synchronized x c() {
        x xVar;
        synchronized (x.class) {
            try {
                if (k == null) {
                    k = new x();
                }
                xVar = k;
            } catch (Throwable th) {
                throw th;
            }
        }
        return xVar;
    }

    private void l() {
        try {
            String str = null;
            String a2 = ad.a().a("FirstLocAddr", (String) null);
            if (a2 != null) {
                String[] split = new String(Base64.decode(a2.getBytes(), 0)).split("_");
                if (split.length == 2) {
                    this.Z = Long.parseLong(split[0]);
                    str = split[1];
                }
                if (str != null) {
                    String[] split2 = str.split(com.huawei.openalliance.ad.constant.x.aL);
                    if (split2.length == 10) {
                        this.aa = new Address.Builder().country(split2[0]).countryCode(split2[1]).province(split2[2]).city(split2[3]).cityCode(split2[4]).district(split2[5]).street(split2[6]).streetNumber(split2[7]).adcode(split2[8]).town(split2[9]).build();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private String[] m() {
        boolean z;
        String[] strArr = {"", "Location failed beacuse we can not get any loc information!"};
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("&apl=");
        int a2 = com.baidu.location.e.o.a(com.baidu.location.f.getServiceContext());
        if (a2 == 1) {
            strArr[1] = "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!";
        }
        stringBuffer.append(a2);
        String d = com.baidu.location.e.o.d(com.baidu.location.f.getServiceContext());
        if (d.contains("per=0|0|")) {
            strArr[1] = "Location failed beacuse we can not get any loc information without any location permission!";
        }
        stringBuffer.append(d);
        if (Build.VERSION.SDK_INT >= 23) {
            stringBuffer.append("&loc=");
            int b2 = com.baidu.location.e.o.b(com.baidu.location.f.getServiceContext());
            if (b2 == 0) {
                strArr[1] = "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!";
                z = true;
            } else {
                z = false;
            }
            stringBuffer.append(b2);
        } else {
            z = false;
        }
        stringBuffer.append("&lmd=");
        int b3 = com.baidu.location.e.o.b(com.baidu.location.f.getServiceContext());
        if (b3 >= 0) {
            stringBuffer.append(b3);
        }
        String h2 = com.baidu.location.c.h.a().h();
        String n = com.baidu.location.c.h.a().n();
        stringBuffer.append(n);
        stringBuffer.append(h2);
        stringBuffer.append(com.baidu.location.e.o.e(com.baidu.location.f.getServiceContext()));
        if (a2 == 1) {
            i.a().a(62, 7, "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!");
        } else if (d.contains("per=0|0|")) {
            i.a().a(62, 4, "Location failed beacuse we can not get any loc information without any location permission!");
        } else if (z) {
            i.a().a(62, 5, "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!");
        } else if (h2 != null && n != null && h2.equals("&sim=1") && !n.equals("&wifio=1")) {
            i.a().a(62, 6, "Location failed beacuse we can not get any loc information , you can insert a sim card or open wifi and try again!");
        } else if (!com.baidu.location.e.o.l()) {
            i.a().a(62, 9, "Location failed beacuse we can not get any loc information!");
        }
        strArr[0] = stringBuffer.toString();
        return strArr;
    }

    private void n() {
        this.w = false;
        this.M = false;
        this.N = false;
        this.H = false;
        o();
        if (this.ab) {
            this.ab = false;
        }
    }

    private void o() {
        if (this.n == null || !com.baidu.location.c.h.a().l()) {
            return;
        }
        an.a().d();
    }

    public Address a(BDLocation bDLocation) {
        Address build;
        if (com.baidu.location.e.o.e.equals(TtmlNode.COMBINE_ALL) || com.baidu.location.e.o.g || com.baidu.location.e.o.i) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.G, this.F, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            float f = fArr[0];
            if (f >= 100.0d) {
                if (this.A == null) {
                    if (System.currentTimeMillis() - this.Z < 3000) {
                        build = this.aa;
                    }
                    build = null;
                } else {
                    if (f < 1000.0d) {
                        build = new Address.Builder().country(this.A.country).countryCode(this.A.countryCode).province(this.A.province).city(this.A.city).cityCode(this.A.cityCode).district(this.A.district).adcode(this.A.adcode).town(this.A.town).build();
                    }
                    build = null;
                }
                this.C = null;
                this.D = null;
                this.E = null;
                this.H = true;
                this.i.post(new y(this));
                return build;
            }
            Address address = this.A;
            if (address != null) {
                return address;
            }
        }
        return null;
    }

    public void b(Message message) {
        if (this.O) {
            c(message);
        }
    }

    public void d() {
        this.v = true;
        this.w = false;
        this.O = true;
        l();
    }

    public void e() {
        this.w = false;
        this.x = false;
        this.M = false;
        this.N = true;
        k();
        this.O = false;
    }

    public String f() {
        return this.C;
    }

    public List<Poi> g() {
        return this.D;
    }

    public PoiRegion h() {
        return this.E;
    }

    public void i() {
        if (this.x) {
            h(null);
            this.x = false;
        }
    }

    public boolean j() {
        return this.Y;
    }

    public void k() {
        this.n = null;
    }

    private void c(Message message) {
        if (!com.baidu.location.e.o.c(com.baidu.location.f.getServiceContext())) {
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLocType(62);
            c.a().a(bDLocation);
            return;
        }
        if (com.baidu.location.e.o.b()) {
            Log.d("baidu_location_service", "isInforbiddenTime on request location ...");
        }
        if (message.getData().getBoolean("isWaitingLocTag", false)) {
            j = true;
        }
        com.baidu.location.c.c.a().b();
        int d = c.a().d(message);
        if (d == 1) {
            d(message);
            return;
        }
        if (d == 2) {
            if (com.baidu.location.c.e.a().j()) {
                e(message);
            }
        } else {
            if (d != 3 && d != 4) {
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(d)));
            }
            g(message);
        }
    }

    private void d(Message message) {
        if (com.baidu.location.c.e.a().j()) {
            e(message);
            af.a().c();
        } else {
            g(message);
            af.a().b();
        }
    }

    private void e(Message message) {
        BDLocation bDLocation = new BDLocation(com.baidu.location.c.e.a().f());
        Location g = com.baidu.location.c.e.a().g();
        if (g != null && BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU.equals(g.getProvider())) {
            bDLocation.setGnssProvider(BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU);
        }
        if (g != null) {
            bDLocation.setExtrainfo(g.getExtras());
        }
        if (com.baidu.location.e.o.e.equals(TtmlNode.COMBINE_ALL) || com.baidu.location.e.o.g || com.baidu.location.e.o.i) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.G, this.F, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                Address address = this.A;
                if (address != null) {
                    bDLocation.setAddr(address);
                }
                String str = this.C;
                if (str != null) {
                    bDLocation.setLocationDescribe(str);
                }
                List<Poi> list = this.D;
                if (list != null) {
                    bDLocation.setPoiList(list);
                }
                PoiRegion poiRegion = this.E;
                if (poiRegion != null) {
                    bDLocation.setPoiRegion(poiRegion);
                }
            } else {
                this.H = true;
                g(null);
            }
        }
        this.n = bDLocation;
        this.o = null;
        d(bDLocation);
    }

    private void f(Message message) {
        b bVar;
        if (!com.baidu.location.c.h.a().k()) {
            h(message);
            return;
        }
        this.x = true;
        if (this.Q == null) {
            this.Q = new b(this, null);
        }
        if (this.R && (bVar = this.Q) != null) {
            this.i.removeCallbacks(bVar);
        }
        this.i.postDelayed(this.Q, 3500L);
        this.R = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Message message) {
        this.S = 0;
        if (!this.v) {
            f(message);
            this.J = SystemClock.uptimeMillis();
            return;
        }
        this.S = 1;
        this.J = SystemClock.uptimeMillis();
        if (com.baidu.location.c.h.a().b(com.baidu.location.e.o.af)) {
            f(message);
        } else {
            h(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00cc, code lost:
    
        if (r11 <= 0) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h(android.os.Message r19) {
        /*
            Method dump skipped, instructions count: 691
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.x.h(android.os.Message):void");
    }

    @Override // com.baidu.location.b.s
    public void a() {
        a aVar = this.K;
        if (aVar != null && this.L) {
            this.L = false;
            this.i.removeCallbacks(aVar);
        }
        if (com.baidu.location.c.e.a().j()) {
            BDLocation bDLocation = new BDLocation(com.baidu.location.c.e.a().f());
            Location g = com.baidu.location.c.e.a().g();
            if (g != null && BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU.equals(g.getProvider())) {
                bDLocation.setGnssProvider(BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU);
            }
            if (g != null) {
                bDLocation.setExtrainfo(g.getExtras());
            }
            if (com.baidu.location.e.o.e.equals(TtmlNode.COMBINE_ALL) || com.baidu.location.e.o.g || com.baidu.location.e.o.i) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.G, this.F, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    Address address = this.A;
                    if (address != null) {
                        bDLocation.setAddr(address);
                    }
                    String str = this.C;
                    if (str != null) {
                        bDLocation.setLocationDescribe(str);
                    }
                    List<Poi> list = this.D;
                    if (list != null) {
                        bDLocation.setPoiList(list);
                    }
                    PoiRegion poiRegion = this.E;
                    if (poiRegion != null) {
                        bDLocation.setPoiRegion(poiRegion);
                    }
                }
            }
            c.a().a(bDLocation);
        } else {
            if (this.M) {
                n();
                return;
            }
            if (this.l || this.n == null) {
                BDLocation bDLocation2 = new BDLocation();
                bDLocation2.setLocType(63);
                this.n = null;
                c.a().a(bDLocation2);
            } else {
                c.a().a(this.n);
            }
            this.o = null;
        }
        n();
    }

    public void b(BDLocation bDLocation) {
        i a2;
        int i;
        String str;
        String n;
        BDLocation bDLocation2;
        String str2;
        new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            Address address = bDLocation.getAddress();
            this.A = address;
            if (address != null && (str2 = address.cityCode) != null) {
                h = str2;
                this.B = System.currentTimeMillis();
            }
            this.F = bDLocation.getLongitude();
            this.G = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.C = bDLocation.getLocationDescribe();
            this.F = bDLocation.getLongitude();
            this.G = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.D = bDLocation.getPoiList();
            this.F = bDLocation.getLongitude();
            this.G = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiRegion() != null) {
            this.E = bDLocation.getPoiRegion();
            this.F = bDLocation.getLongitude();
            this.G = bDLocation.getLatitude();
        }
        boolean z = false;
        if (com.baidu.location.c.e.a().j()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.c.e.a().f());
            Location g = com.baidu.location.c.e.a().g();
            if (g != null && BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU.equals(g.getProvider())) {
                bDLocation3.setGnssProvider(BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU);
            }
            if (g != null) {
                bDLocation3.setExtrainfo(g.getExtras());
            }
            if (com.baidu.location.e.o.e.equals(TtmlNode.COMBINE_ALL) || com.baidu.location.e.o.g || com.baidu.location.e.o.i) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.G, this.F, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    Address address2 = this.A;
                    if (address2 != null) {
                        bDLocation3.setAddr(address2);
                    }
                    String str3 = this.C;
                    if (str3 != null) {
                        bDLocation3.setLocationDescribe(str3);
                    }
                    List<Poi> list = this.D;
                    if (list != null) {
                        bDLocation3.setPoiList(list);
                    }
                    PoiRegion poiRegion = this.E;
                    if (poiRegion != null) {
                        bDLocation3.setPoiRegion(poiRegion);
                    }
                }
            }
            d(bDLocation3);
            n();
            return;
        }
        if (this.M) {
            float[] fArr2 = new float[2];
            BDLocation bDLocation4 = this.n;
            if (bDLocation4 != null) {
                Location.distanceBetween(bDLocation4.getLatitude(), this.n.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] <= 10.0f) {
                if (bDLocation.getUserIndoorState() > -1) {
                    this.n = bDLocation;
                    c.a().a(bDLocation);
                }
                n();
                return;
            }
            this.n = bDLocation;
            if (!this.N) {
                this.N = false;
                c.a().a(bDLocation);
            }
            n();
            return;
        }
        if (bDLocation.getLocType() == 167) {
            i.a().a(167, 8, "NetWork location failed because baidu location service can not caculate the location!");
        } else if (bDLocation.getLocType() == 161) {
            int b2 = com.baidu.location.e.o.b(com.baidu.location.f.getServiceContext());
            if (b2 == 0 || b2 == 2) {
                i.a().a(161, 1, "NetWork location successful, open gps will be better!");
            } else if (bDLocation.getRadius() >= 100.0f && bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("cl") && (n = com.baidu.location.c.h.a().n()) != null && !n.equals("&wifio=1")) {
                i.a().a(161, 2, "NetWork location successful, open wifi will be better!");
            }
        } else {
            int i2 = 160;
            if (bDLocation.getLocType() == 160) {
                a2 = i.a();
                i = 10;
                str = "Coarse location successful, open Accurately locate permission will be better!";
            } else if (com.baidu.location.e.o.l()) {
                i2 = 62;
                if (bDLocation.getLocType() == 62) {
                    a2 = i.a();
                    i = 11;
                    str = "Coarse location failed because we can not get any loc result";
                }
            }
            a2.a(i2, i, str);
        }
        this.o = null;
        if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && (bDLocation2 = this.n) != null && bDLocation2.getLocType() == 161 && "wf".equals(this.n.getNetworkLocationType()) && System.currentTimeMillis() - this.z < 30000) {
            this.o = bDLocation;
            z = true;
        }
        c a3 = c.a();
        if (z) {
            a3.a(this.n);
        } else {
            a3.a(bDLocation);
            this.z = System.currentTimeMillis();
        }
        if (!com.baidu.location.e.o.a(bDLocation)) {
            this.n = null;
        } else if (!z) {
            this.n = bDLocation;
        }
        int a4 = com.baidu.location.e.o.a(s.d, "ssid\":\"", "\"");
        if (a4 == Integer.MIN_VALUE || this.q == null) {
            this.m = null;
        } else {
            this.m = com.baidu.location.c.h.a().a(a4, this.q);
        }
        com.baidu.location.c.h.a().l();
        n();
    }

    private void d(BDLocation bDLocation) {
        if (com.baidu.location.e.o.l || bDLocation.getMockGpsStrategy() <= 0) {
            c.a().a(bDLocation);
        } else {
            c.a().c(bDLocation);
        }
    }

    private void e(BDLocation bDLocation) {
        this.Y = bDLocation != null && bDLocation.isInIndoorPark();
    }

    @Override // com.baidu.location.b.s
    public void a(Message message) {
        a aVar = this.K;
        if (aVar != null && this.L) {
            this.L = false;
            this.i.removeCallbacks(aVar);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        int i = message.arg1;
        if (bDLocation != null && bDLocation.getLocType() == 161) {
            b(bDLocation.getTraffic());
            e(bDLocation);
            if (i == 1) {
                h.a().a(bDLocation, "gcj02", null);
            }
        }
        if (bDLocation != null && bDLocation.getLocType() == 167 && this.P) {
            bDLocation.setLocType(62);
        }
        if (!this.U && bDLocation != null && bDLocation.getLocType() == 161) {
            String cityCode = bDLocation.getCityCode();
            if (!TextUtils.isEmpty(cityCode)) {
                ad.a().b("mapcity", cityCode);
                e.b().a(cityCode);
                this.U = true;
            }
        }
        b(bDLocation);
    }

    public void c(BDLocation bDLocation) {
        this.n = new BDLocation(bDLocation);
    }

    private void b(String str) {
        this.X = str != null && "subway".equals(str.toLowerCase());
    }

    private boolean a(com.baidu.location.c.a aVar, com.baidu.location.c.a aVar2) {
        if (aVar2 == aVar) {
            return false;
        }
        if (aVar2 == null || aVar == null) {
            return true;
        }
        return !aVar.a(aVar2);
    }

    private boolean a(com.baidu.location.c.a aVar, HashSet<String> hashSet) {
        com.baidu.location.c.a f = com.baidu.location.c.h.a().f();
        this.b = f;
        boolean a2 = a(aVar, f);
        if (com.baidu.location.e.o.aG == 0) {
            return a2;
        }
        boolean z = a2 || com.baidu.location.c.h.a().a(aVar, this.b);
        HashSet<String> c = com.baidu.location.c.h.a().c(this.b);
        this.c = c;
        return z || a(hashSet, c);
    }

    private boolean a(com.baidu.location.c.p pVar) {
        com.baidu.location.c.p r = com.baidu.location.c.h.a().r();
        this.f5659a = r;
        if (pVar == r) {
            return false;
        }
        if (r == null || pVar == null) {
            return true;
        }
        return !com.baidu.location.c.h.a().a(this.f5659a, pVar, com.baidu.location.e.o.aA);
    }

    private boolean a(HashSet<String> hashSet, HashSet<String> hashSet2) {
        if ((hashSet == null || hashSet.isEmpty()) && (hashSet2 == null || hashSet2.isEmpty())) {
            return false;
        }
        if (hashSet == null || hashSet.isEmpty() || hashSet2 == null || hashSet2.isEmpty()) {
            return true;
        }
        int size = hashSet.size();
        Iterator<String> it = hashSet.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (hashSet2.contains(it.next())) {
                i++;
            }
        }
        return ((float) i) < ((float) size) * com.baidu.location.e.o.aH;
    }
}
