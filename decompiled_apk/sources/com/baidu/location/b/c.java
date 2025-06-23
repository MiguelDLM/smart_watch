package com.baidu.location.b;

import XIXIX.OOXIXo;
import android.content.Intent;
import android.location.Location;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.LruCache;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.baidu.location.PoiRegion;
import com.facebook.appevents.UserDataStore;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class c {
    public static long c = 0;
    public static int d = -1;

    /* renamed from: a, reason: collision with root package name */
    public boolean f5632a;
    boolean b;
    int e;
    private ArrayList<a> f;
    private boolean g;
    private BDLocation h;
    private BDLocation i;
    private Object j;
    private long k;
    private LruCache<String, JSONObject> l;
    private String m;
    private String n;
    private String o;
    private final String[] p;
    private BDLocation q;
    private boolean r;
    private boolean s;
    private RunnableC0126c t;

    /* loaded from: classes7.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public String f5633a;
        public Messenger b;
        public LocationClientOption c = new LocationClientOption();
        public int d = 0;

        public a(Message message) {
            this.f5633a = null;
            this.b = null;
            this.b = message.replyTo;
            this.f5633a = message.getData().getString("packName");
            this.c.prodName = message.getData().getString("prodName");
            com.baidu.location.e.b.a().a(this.c.prodName, this.f5633a);
            this.c.coorType = message.getData().getString("coorType");
            this.c.addrType = message.getData().getString("addrType");
            this.c.enableSimulateGps = message.getData().getBoolean("enableSimulateGps", false);
            com.baidu.location.e.o.l = com.baidu.location.e.o.l || this.c.enableSimulateGps;
            if (!com.baidu.location.e.o.e.equals(TtmlNode.COMBINE_ALL)) {
                com.baidu.location.e.o.e = this.c.addrType;
            }
            this.c.openGps = message.getData().getBoolean("openGPS");
            this.c.scanSpan = message.getData().getInt("scanSpan");
            this.c.timeOut = message.getData().getInt("timeOut");
            this.c.priority = message.getData().getInt("priority");
            this.c.location_change_notify = message.getData().getBoolean("location_change_notify");
            this.c.mIsNeedDeviceDirect = message.getData().getBoolean("needDirect", false);
            this.c.isNeedAltitude = message.getData().getBoolean("isneedaltitude", false);
            this.c.isNeedNewVersionRgc = message.getData().getBoolean("isneednewrgc", false);
            com.baidu.location.e.o.h = com.baidu.location.e.o.h || this.c.isNeedNewVersionRgc;
            com.baidu.location.e.o.g = com.baidu.location.e.o.g || message.getData().getBoolean("isneedaptag", false);
            com.baidu.location.e.o.i = com.baidu.location.e.o.i || message.getData().getBoolean("isneedaptagd", false);
            com.baidu.location.e.o.R = message.getData().getFloat("autoNotifyLocSensitivity", 0.5f);
            int i = message.getData().getInt("wfnum", com.baidu.location.e.o.ay);
            float f = message.getData().getFloat("wfsm", com.baidu.location.e.o.aA);
            int i2 = message.getData().getInt("gnmcon", com.baidu.location.e.o.aC);
            double d = message.getData().getDouble("gnmcrm", com.baidu.location.e.o.aB);
            int i3 = message.getData().getInt("iupl", 1);
            com.baidu.location.e.o.aQ = message.getData().getInt(UserDataStore.CITY, 10);
            com.baidu.location.e.o.aR = message.getData().getInt("suci", 3);
            com.baidu.location.e.o.aT = message.getData().getDoubleArray("cgs");
            com.baidu.location.e.o.aU = message.getData().getInt("ums", 1);
            com.baidu.location.e.o.aS = message.getData().getInt("smn", 40);
            if (i3 <= 0) {
                com.baidu.location.e.o.aP = 0;
            } else if (com.baidu.location.e.o.aP == -1) {
                com.baidu.location.e.o.aP = 1;
            }
            if (message.getData().getInt("opetco", 1) == 0) {
                com.baidu.location.e.o.aV = 0;
            }
            if (message.getData().getInt("lpcs", com.baidu.location.e.o.aW) == 0) {
                com.baidu.location.e.o.aW = 0;
            }
            if (i2 == 1) {
                com.baidu.location.e.o.aC = 1;
            }
            if (d > com.baidu.location.e.o.aB) {
                com.baidu.location.e.o.aB = d;
            }
            com.baidu.location.e.o.ax = com.baidu.location.e.o.ax || message.getData().getBoolean("ischeckper", false);
            boolean z = message.getData().getBoolean("isEnableBeidouMode", false);
            if (Build.VERSION.SDK_INT >= 28) {
                com.baidu.location.e.o.aX = com.baidu.location.e.o.aX || z;
            }
            if (i > com.baidu.location.e.o.ay) {
                com.baidu.location.e.o.ay = i;
            }
            if (f > com.baidu.location.e.o.aA) {
                com.baidu.location.e.o.aA = f;
            }
            int i4 = message.getData().getInt("wifitimeout", Integer.MAX_VALUE);
            if (i4 < com.baidu.location.e.o.af) {
                com.baidu.location.e.o.af = i4;
            }
            int i5 = message.getData().getInt("autoNotifyMaxInterval", 0);
            if (i5 >= com.baidu.location.e.o.W) {
                com.baidu.location.e.o.W = i5;
            }
            int i6 = message.getData().getInt("autoNotifyMinDistance", 0);
            if (i6 >= com.baidu.location.e.o.Y) {
                com.baidu.location.e.o.Y = i6;
            }
            int i7 = message.getData().getInt("autoNotifyMinTimeInterval", 0);
            if (i7 >= com.baidu.location.e.o.X) {
                com.baidu.location.e.o.X = i7;
            }
            LocationClientOption locationClientOption = this.c;
            if (locationClientOption.mIsNeedDeviceDirect || locationClientOption.isNeedAltitude) {
                af.a().a(this.c.mIsNeedDeviceDirect);
                af.a().b();
            }
            c.this.b = c.this.b || this.c.isNeedAltitude;
            if (message.getData().getInt("hpdts", com.baidu.location.e.o.aD) == 1) {
                com.baidu.location.e.o.aD = 1;
            } else {
                com.baidu.location.e.o.aD = 0;
            }
            if (message.getData().getInt("oldts", com.baidu.location.e.o.aE) == 1) {
                com.baidu.location.e.o.aE = 1;
            } else {
                com.baidu.location.e.o.aE = 0;
            }
            int i8 = message.getData().getInt("onic", com.baidu.location.e.o.aF);
            if (i8 == 0) {
                com.baidu.location.e.o.aF = i8;
            }
            int i9 = message.getData().getInt("nlcs", com.baidu.location.e.o.aG);
            if (i9 == 1) {
                com.baidu.location.e.o.aG = i9;
            }
            com.baidu.location.e.o.aH = message.getData().getFloat("ncsr", com.baidu.location.e.o.aH);
            com.baidu.location.e.o.aI = message.getData().getFloat("cscr", com.baidu.location.e.o.aI);
            com.baidu.location.e.o.aJ = message.getData().getInt("cls", com.baidu.location.e.o.aJ);
            int[] intArray = message.getData().getIntArray("ocs");
            com.baidu.location.e.o.aK = intArray;
            com.baidu.location.e.o.aL = com.baidu.location.e.o.a(intArray);
            com.baidu.location.e.o.aM = message.getData().getInt("topCellNumber");
            com.baidu.location.e.o.aN = message.getData().getInt("locStrLength");
            com.baidu.location.c.h.a().a((WifiInfo) null, message.getData().getString("connectBssid", null));
        }

        private double a(boolean z, BDLocation bDLocation, BDLocation bDLocation2) {
            double d;
            double latitude;
            double longitude;
            double latitude2;
            double longitude2;
            double a2;
            double[] dArr;
            if (z) {
                if (TextUtils.equals(bDLocation2.getCoorType(), bDLocation.getCoorType())) {
                    if (TextUtils.equals("bd09", bDLocation2.getCoorType())) {
                        double[] coorEncrypt = Jni.coorEncrypt(bDLocation2.getLongitude(), bDLocation2.getLatitude(), BDLocation.BDLOCATION_BD09_TO_GCJ02);
                        double[] coorEncrypt2 = Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), BDLocation.BDLOCATION_BD09_TO_GCJ02);
                        latitude = coorEncrypt[1];
                        longitude = coorEncrypt[0];
                        latitude2 = coorEncrypt2[1];
                        longitude2 = coorEncrypt2[0];
                        a2 = com.baidu.location.e.o.a(latitude, longitude, latitude2, longitude2);
                    }
                    a2 = com.baidu.location.e.o.a(bDLocation2.getLatitude(), bDLocation2.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude());
                } else {
                    if (TextUtils.equals("wgs84", bDLocation.getCoorType())) {
                        dArr = new double[]{bDLocation.getLongitude(), bDLocation.getLatitude()};
                    } else {
                        double[] coorEncrypt3 = TextUtils.equals("bd09", bDLocation.getCoorType()) ? Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), BDLocation.BDLOCATION_BD09_TO_GCJ02) : TextUtils.equals("bd09ll", bDLocation.getCoorType()) ? Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), BDLocation.BDLOCATION_BD09LL_TO_GCJ02) : new double[]{bDLocation.getLongitude(), bDLocation.getLatitude()};
                        dArr = Jni.coorEncrypt(coorEncrypt3[0], coorEncrypt3[1], "gcj2wgs");
                    }
                    bDLocation.setLatitude(dArr[1]);
                    d = dArr[0];
                    bDLocation.setLongitude(d);
                    bDLocation.setTime(com.baidu.location.e.o.a());
                    bDLocation.setCoorType("wgs84");
                    a2 = com.baidu.location.e.o.a(bDLocation2.getLatitude(), bDLocation2.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude());
                }
            } else if (TextUtils.equals(bDLocation2.getCoorType(), bDLocation.getCoorType())) {
                latitude = bDLocation2.getLatitude();
                longitude = bDLocation2.getLongitude();
                latitude2 = bDLocation.getLatitude();
                longitude2 = bDLocation.getLongitude();
                a2 = com.baidu.location.e.o.a(latitude, longitude, latitude2, longitude2);
            } else {
                double[] coorEncrypt4 = Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), "gcj2wgs");
                bDLocation.setLatitude(coorEncrypt4[1]);
                d = coorEncrypt4[0];
                bDLocation.setLongitude(d);
                bDLocation.setTime(com.baidu.location.e.o.a());
                bDLocation.setCoorType("wgs84");
                a2 = com.baidu.location.e.o.a(bDLocation2.getLatitude(), bDLocation2.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude());
            }
            bDLocation2.setDisToRealLocation(a2);
            if (bDLocation != null) {
                bDLocation2.setReallLocation(bDLocation);
            }
            return a2;
        }

        private BDLocation b() {
            BDLocation h = com.baidu.location.c.e.a().h();
            if (h == null) {
                return null;
            }
            double[] coorEncrypt = Jni.coorEncrypt(h.getLongitude(), h.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
            double[] coorEncrypt2 = Jni.coorEncrypt(coorEncrypt[0], coorEncrypt[1], this.c.coorType);
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLongitude(coorEncrypt2[0]);
            bDLocation.setLatitude(coorEncrypt2[1]);
            bDLocation.setTime(com.baidu.location.e.o.a());
            bDLocation.setLocType(61);
            bDLocation.setCoorType(this.c.coorType);
            return bDLocation;
        }

        private BDLocation c() {
            BDLocation h = com.baidu.location.c.e.a().h();
            if (h == null) {
                return null;
            }
            double[] coorEncrypt = Jni.coorEncrypt(h.getLongitude(), h.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLongitude(coorEncrypt[0]);
            bDLocation.setLatitude(coorEncrypt[1]);
            bDLocation.setTime(com.baidu.location.e.o.a());
            bDLocation.setLocType(61);
            bDLocation.setCoorType("gcj02");
            return bDLocation;
        }

        private int a(double d) {
            if (d >= OOXIXo.f3760XO && d <= 10.0d) {
                return 0;
            }
            if (d <= 10.0d || d > 100.0d) {
                return (d <= 100.0d || d > 200.0d) ? 3 : 2;
            }
            return 1;
        }

        public int a(int i, boolean z, BDLocation bDLocation) {
            double a2;
            if (i == 100) {
                if (z) {
                    BDLocation b = b();
                    if (b == null) {
                        return 3;
                    }
                    a(true, b, bDLocation);
                    return 3;
                }
                BDLocation c = c();
                if (c == null) {
                    return 3;
                }
                a(false, c, bDLocation);
                return 3;
            }
            if (i == 200 || i == 300) {
                return 1;
            }
            if (i != 400) {
                return i == 500 ? 1 : 0;
            }
            if (z) {
                BDLocation b2 = b();
                if (b2 == null) {
                    return -1;
                }
                a2 = a(true, b2, bDLocation);
            } else {
                BDLocation c2 = c();
                if (c2 == null) {
                    return -1;
                }
                a2 = a(false, c2, bDLocation);
            }
            return a(a2);
        }

        public void a() {
            if (this.c.location_change_notify) {
                a(com.baidu.location.e.o.b ? 54 : 55);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i) {
            Message obtain = Message.obtain((Handler) null, i);
            try {
                Messenger messenger = this.b;
                if (messenger != null) {
                    messenger.send(obtain);
                }
                this.d = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.d++;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, Bundle bundle) {
            Message obtain = Message.obtain((Handler) null, i);
            obtain.setData(bundle);
            try {
                Messenger messenger = this.b;
                if (messenger != null) {
                    messenger.send(obtain);
                }
                this.d = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.d++;
                }
                e.printStackTrace();
            }
        }

        private void a(int i, String str, BDLocation bDLocation) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(str, bDLocation);
            bundle.setClassLoader(BDLocation.class.getClassLoader());
            Message obtain = Message.obtain((Handler) null, i);
            obtain.setData(bundle);
            try {
                Messenger messenger = this.b;
                if (messenger != null) {
                    messenger.send(obtain);
                }
                this.d = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.d++;
                }
            }
        }

        public void a(BDLocation bDLocation) {
            a(bDLocation, 21);
        }

        public void a(BDLocation bDLocation, int i) {
            int a2;
            String str;
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            if (i == 21) {
                a(27, "locStr", bDLocation2);
            }
            String str2 = this.c.coorType;
            if (str2 != null && !str2.equals("gcj02")) {
                double longitude = bDLocation2.getLongitude();
                double latitude = bDLocation2.getLatitude();
                if (longitude != Double.MIN_VALUE && latitude != Double.MIN_VALUE) {
                    if ((bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("gcj02")) || bDLocation2.getCoorType() == null) {
                        double[] coorEncrypt = Jni.coorEncrypt(longitude, latitude, this.c.coorType);
                        bDLocation2.setLongitude(coorEncrypt[0]);
                        bDLocation2.setLatitude(coorEncrypt[1]);
                        str = this.c.coorType;
                    } else if (bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("wgs84") && !this.c.coorType.equals("bd09ll")) {
                        double[] coorEncrypt2 = Jni.coorEncrypt(longitude, latitude, "wgs842mc");
                        bDLocation2.setLongitude(coorEncrypt2[0]);
                        bDLocation2.setLatitude(coorEncrypt2[1]);
                        str = "wgs84mc";
                    }
                    bDLocation2.setCoorType(str);
                }
                if (!com.baidu.location.e.o.l && bDLocation2.getMockGpsStrategy() > 0) {
                    a2 = a(bDLocation2.getMockGpsStrategy(), true, bDLocation2);
                    bDLocation2.setMockGpsProbability(a2);
                }
            } else if (!com.baidu.location.e.o.l && bDLocation2.getMockGpsStrategy() > 0) {
                a2 = a(bDLocation2.getMockGpsStrategy(), false, bDLocation2);
                bDLocation2.setMockGpsProbability(a2);
            }
            a(i, "locStr", bDLocation2);
        }
    }

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static c f5634a = new c();
    }

    /* renamed from: com.baidu.location.b.c$c, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0126c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f5635a;
        private int b;
        private boolean c;

        @Override // java.lang.Runnable
        public void run() {
            if (this.c) {
                return;
            }
            this.b++;
            this.f5635a.s = false;
        }
    }

    private c() {
        this.f = null;
        this.g = false;
        this.f5632a = false;
        this.b = false;
        this.h = null;
        this.i = null;
        this.j = new Object();
        this.k = -1L;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = new String[]{"name", "mac", "onLng", "onLat", "onLocType", "onTime", "offLng", "offLat", "offLocType", "offTime"};
        this.e = 0;
        this.q = null;
        this.r = false;
        this.s = false;
        this.t = null;
        this.f = new ArrayList<>();
        this.l = new LruCache<>(3);
        this.n = ad.a().a("sp_loc_map_end_str", "");
        this.m = ad.a().a("sp_loc_navi_end_str", "");
        this.o = ad.a().a("sp_loc_last_navi_end_str", "");
        String a2 = ad.a().a("sp_bluetooth_info", "");
        if (a2 == null || "".equals(a2)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(a2);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                this.l.put(jSONObject.getString("mac"), jSONObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private a a(Messenger messenger) {
        if (this.f == null) {
            return null;
        }
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        synchronized (this.j) {
            try {
                Iterator<a> it = this.f.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next.b.equals(messenger)) {
                        return next;
                    }
                }
                return null;
            } finally {
            }
        }
    }

    private void f() {
        boolean z;
        boolean z2 = false;
        try {
            try {
                synchronized (this.j) {
                    try {
                        Iterator<a> it = this.f.iterator();
                        z = false;
                        while (it.hasNext()) {
                            LocationClientOption locationClientOption = it.next().c;
                            if (locationClientOption.openGps) {
                                z2 = true;
                            }
                            if (locationClientOption.location_change_notify) {
                                z = true;
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        z = false;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e) {
            e = e;
            z = false;
        }
        try {
            throw th;
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            com.baidu.location.e.o.f5746a = z;
            if (this.g != z2 || (!com.baidu.location.c.e.a().k() && this.g)) {
                this.g = z2;
                com.baidu.location.c.e.a().a(this.g);
            }
        }
    }

    private void g() {
        try {
            Iterator<a> it = this.f.iterator();
            while (it.hasNext()) {
                com.baidu.location.e.o.f = Math.min(com.baidu.location.e.o.f, it.next().c.priority);
            }
            if (com.baidu.location.f.isServing) {
                return;
            }
            com.baidu.location.e.o.f = 4;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b() {
        synchronized (this.j) {
            try {
                ArrayList<a> arrayList = this.f;
                if (arrayList != null) {
                    arrayList.clear();
                }
            } catch (Throwable unused) {
            }
        }
        this.h = null;
        e();
    }

    public String c() {
        StringBuilder sb;
        StringBuffer stringBuffer = new StringBuffer(256);
        if (this.f.isEmpty()) {
            return "&prod=" + com.baidu.location.e.b.f + ":" + com.baidu.location.e.b.e;
        }
        String stringBuffer2 = stringBuffer.toString();
        try {
            a aVar = this.f.get(0);
            String str = aVar.c.prodName;
            if (str != null) {
                stringBuffer.append(str);
            }
            if (aVar.f5633a != null) {
                stringBuffer.append(":");
                stringBuffer.append(aVar.f5633a);
                stringBuffer.append("|");
            }
            if (stringBuffer2 == null || stringBuffer2.equals("")) {
                sb = new StringBuilder();
                sb.append("&prod=");
                sb.append(com.baidu.location.e.b.f);
                sb.append(":");
                stringBuffer2 = com.baidu.location.e.b.e;
            } else {
                sb = new StringBuilder();
                sb.append("&prod=");
            }
            sb.append(stringBuffer2);
            return sb.toString();
        } catch (Exception unused) {
            return "&prod=" + com.baidu.location.e.b.f + ":" + com.baidu.location.e.b.e;
        }
    }

    public int d(Message message) {
        Messenger messenger;
        a a2;
        if (message == null || (messenger = message.replyTo) == null || (a2 = a(messenger)) == null || a2.c == null) {
            return 1;
        }
        return com.baidu.location.e.o.f;
    }

    public int e(Message message) {
        Messenger messenger;
        a a2;
        LocationClientOption locationClientOption;
        if (message == null || (messenger = message.replyTo) == null || (a2 = a(messenger)) == null || (locationClientOption = a2.c) == null) {
            return 1000;
        }
        return locationClientOption.scanSpan;
    }

    public static c a() {
        return b.f5634a;
    }

    private void e() {
        f();
        d();
        g();
    }

    public void b(Message message) {
        synchronized (this.j) {
            try {
                a a2 = a(message.replyTo);
                if (a2 != null) {
                    this.f.remove(a2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        af.a().c();
        e();
        if (this.r) {
            a("stop");
            this.e = 0;
        }
    }

    public void c(BDLocation bDLocation) {
        Address a2 = x.c().a(bDLocation);
        String f = x.c().f();
        List<Poi> g = x.c().g();
        PoiRegion h = x.c().h();
        if (a2 != null) {
            bDLocation.setAddr(a2);
        }
        if (f != null) {
            bDLocation.setLocationDescribe(f);
        }
        if (g != null) {
            bDLocation.setPoiList(g);
        }
        if (h != null) {
            bDLocation.setPoiRegion(h);
        }
        a(bDLocation);
        x.c().c(bDLocation);
    }

    public void d() {
        try {
            synchronized (this.j) {
                try {
                    Iterator<a> it = this.f.iterator();
                    while (it.hasNext()) {
                        it.next().a();
                    }
                } finally {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(Bundle bundle, int i) {
        synchronized (this.j) {
            Iterator<a> it = this.f.iterator();
            while (it.hasNext()) {
                try {
                    a next = it.next();
                    next.a(i, bundle);
                    if (next.d > 4) {
                        it.remove();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public void b(BDLocation bDLocation) {
        BDLocation bDLocation2;
        if (bDLocation == null || bDLocation.getLocType() != 161 || com.baidu.location.a.a.a().b()) {
            synchronized (this.j) {
                Iterator<a> it = this.f.iterator();
                while (it.hasNext()) {
                    try {
                        a next = it.next();
                        next.a(bDLocation);
                        if (next.d > 4) {
                            it.remove();
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        } else {
            if (this.i == null) {
                BDLocation bDLocation3 = new BDLocation();
                this.i = bDLocation3;
                bDLocation3.setLocType(505);
            }
            synchronized (this.j) {
                Iterator<a> it2 = this.f.iterator();
                while (it2.hasNext()) {
                    try {
                        a next2 = it2.next();
                        next2.a(this.i);
                        if (next2.d > 4) {
                            it2.remove();
                        }
                    } catch (Exception unused2) {
                    }
                }
            }
        }
        if (bDLocation != null && (bDLocation.getLocType() == 61 || bDLocation.getLocType() == 161 || bDLocation.getLocType() == 66)) {
            e.b().a(bDLocation.getLatitude(), bDLocation.getLongitude());
            e.b().a(bDLocation.getCityCode());
        }
        boolean z = x.j;
        if (z) {
            x.j = false;
        }
        if (com.baidu.location.e.o.W >= 10000) {
            if (bDLocation.getLocType() == 61 || bDLocation.getLocType() == 161 || bDLocation.getLocType() == 66) {
                BDLocation bDLocation4 = this.h;
                if (bDLocation4 != null) {
                    float[] fArr = new float[1];
                    Location.distanceBetween(bDLocation4.getLatitude(), this.h.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                    if (fArr[0] <= com.baidu.location.e.o.Y && !z) {
                        return;
                    }
                    this.h = null;
                    bDLocation2 = new BDLocation(bDLocation);
                } else {
                    bDLocation2 = new BDLocation(bDLocation);
                }
                this.h = bDLocation2;
            }
        }
    }

    public boolean c(Message message) {
        a a2 = a(message.replyTo);
        if (a2 == null) {
            return false;
        }
        LocationClientOption locationClientOption = a2.c;
        int i = locationClientOption.scanSpan;
        locationClientOption.scanSpan = message.getData().getInt("scanSpan", a2.c.scanSpan);
        if (a2.c.scanSpan < 1000) {
            af.a().c();
            this.f5632a = false;
        } else {
            this.f5632a = true;
        }
        LocationClientOption locationClientOption2 = a2.c;
        if (locationClientOption2.scanSpan > 999 && i < 1000) {
            if (locationClientOption2.mIsNeedDeviceDirect || locationClientOption2.isNeedAltitude) {
                af.a().a(a2.c.mIsNeedDeviceDirect);
                af.a().b();
            }
            this.b = this.b || a2.c.isNeedAltitude;
            r1 = true;
        }
        a2.c.openGps = message.getData().getBoolean("openGPS", a2.c.openGps);
        String string = message.getData().getString("coorType");
        LocationClientOption locationClientOption3 = a2.c;
        if (string == null || string.equals("")) {
            string = a2.c.coorType;
        }
        locationClientOption3.coorType = string;
        String string2 = message.getData().getString("addrType");
        LocationClientOption locationClientOption4 = a2.c;
        if (string2 == null || string2.equals("")) {
            string2 = a2.c.addrType;
        }
        locationClientOption4.addrType = string2;
        if (!com.baidu.location.e.o.e.equals(a2.c.addrType)) {
            x.c().k();
        }
        a2.c.timeOut = message.getData().getInt("timeOut", a2.c.timeOut);
        a2.c.location_change_notify = message.getData().getBoolean("location_change_notify", a2.c.location_change_notify);
        a2.c.priority = message.getData().getInt("priority", a2.c.priority);
        com.baidu.location.e.o.f = a2.c.priority;
        int i2 = message.getData().getInt("wifitimeout", Integer.MAX_VALUE);
        if (i2 < com.baidu.location.e.o.af) {
            com.baidu.location.e.o.af = i2;
        }
        e();
        return r1;
    }

    public void d(BDLocation bDLocation) {
        c(bDLocation);
    }

    public void a(Message message) {
        if (message == null || message.replyTo == null) {
            return;
        }
        c = System.currentTimeMillis();
        this.f5632a = true;
        com.baidu.location.c.h.a().i();
        a(new a(message));
        e();
        if (this.r) {
            a("start");
            this.e = 0;
        }
    }

    public void a(BDLocation bDLocation) {
        b(bDLocation);
    }

    private void a(a aVar) {
        if (aVar == null) {
            return;
        }
        synchronized (this.j) {
            try {
                if (a(aVar.b) != null) {
                    aVar.a(14);
                } else {
                    this.f.add(aVar);
                    aVar.a(13);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void a(String str) {
        Intent intent = new Intent("com.baidu.location.flp.log");
        intent.setPackage("com.baidu.baidulocationdemo");
        intent.putExtra("data", str);
        intent.putExtra("pack", com.baidu.location.e.b.e);
        intent.putExtra("tag", "state");
        com.baidu.location.f.getServiceContext().sendBroadcast(intent);
    }

    public void a(boolean z) {
        this.f5632a = z;
        d = z ? 1 : 0;
    }
}
