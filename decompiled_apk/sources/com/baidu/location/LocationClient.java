package com.baidu.location;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.location.LocationClientOption;
import com.baidu.location.b.j;
import com.baidu.location.b.v;
import com.baidu.location.e.o;
import com.huawei.openalliance.ad.constant.ah;
import com.iflytek.sparkchain.plugins.map.tools.MapPlugin;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes7.dex */
public final class LocationClient implements j.a {
    public static final int CONNECT_HOT_SPOT_FALSE = 0;
    public static final int CONNECT_HOT_SPOT_TRUE = 1;
    public static final int CONNECT_HOT_SPOT_UNKNOWN = -1;
    private static boolean H = false;
    public static final int LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_FINE_PERMISSION = 10;
    public static final int LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_GPS = 1;
    public static final int LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_WIFI = 2;
    public static final int LOC_DIAGNOSTIC_TYPE_COARSE_FAIL = 11;
    public static final int LOC_DIAGNOSTIC_TYPE_FAIL_UNKNOWN = 9;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CHECK_LOC_PERMISSION = 4;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CHECK_NET = 3;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CLOSE_FLYMODE = 7;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_INSERT_SIMCARD_OR_OPEN_WIFI = 6;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_OPEN_PHONE_LOC_SWITCH = 5;
    public static final int LOC_DIAGNOSTIC_TYPE_SERVER_FAIL = 8;
    private static String w;
    private Boolean A;
    private Boolean B;
    private boolean C;
    private j D;
    private boolean E;
    private boolean F;
    private boolean G;
    private String I;
    private ServiceConnection J;
    private LocationClientOption c;
    private LocationClientOption d;
    private Context f;
    private a h;
    private final Messenger i;
    private String v;
    private Boolean z;

    /* renamed from: a, reason: collision with root package name */
    private long f5601a = 0;
    private String b = null;
    private boolean e = false;
    private Messenger g = null;
    private ArrayList<BDLocationListener> j = null;
    private ArrayList<BDAbstractLocationListener> k = null;
    private BDLocation l = null;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;
    private b p = null;
    private boolean q = false;
    private final Object r = new Object();
    private long s = 0;
    private long t = 0;
    private String u = null;
    private boolean x = false;
    private boolean y = true;

    /* loaded from: classes7.dex */
    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<LocationClient> f5602a;

        public a(Looper looper, LocationClient locationClient) {
            super(looper);
            this.f5602a = new WeakReference<>(locationClient);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            LocationClient locationClient = this.f5602a.get();
            if (locationClient == null) {
                return;
            }
            int i = message.what;
            boolean z = true;
            if (i == 21) {
                Bundle data = message.getData();
                data.setClassLoader(BDLocation.class.getClassLoader());
                BDLocation bDLocation = (BDLocation) data.getParcelable("locStr");
                if (!locationClient.F && locationClient.E && bDLocation.getLocType() == 66) {
                    return;
                }
                if (!locationClient.F && locationClient.E) {
                    locationClient.F = true;
                    return;
                }
                if (!locationClient.F) {
                    locationClient.F = true;
                }
                locationClient.a(message, 21);
                return;
            }
            try {
                if (i == 303) {
                    Bundle data2 = message.getData();
                    int i2 = data2.getInt("loctype");
                    int i3 = data2.getInt("diagtype");
                    byte[] byteArray = data2.getByteArray("diagmessage");
                    if (i2 <= 0 || i3 <= 0 || byteArray == null || locationClient.k == null) {
                        return;
                    }
                    Iterator it = locationClient.k.iterator();
                    while (it.hasNext()) {
                        ((BDAbstractLocationListener) it.next()).onLocDiagnosticMessage(i2, i3, new String(byteArray, "UTF-8"));
                    }
                    return;
                }
                if (i == 406) {
                    Bundle data3 = message.getData();
                    byte[] byteArray2 = data3.getByteArray("mac");
                    String str = byteArray2 != null ? new String(byteArray2, "UTF-8") : null;
                    int i4 = data3.getInt("hotspot", -1);
                    if (locationClient.k != null) {
                        Iterator it2 = locationClient.k.iterator();
                        while (it2.hasNext()) {
                            ((BDAbstractLocationListener) it2.next()).onConnectHotSpotMessage(str, i4);
                        }
                        return;
                    }
                    return;
                }
                if (i == 701) {
                    locationClient.b((BDLocation) message.obj);
                    return;
                }
                if (i == 1300) {
                    locationClient.c(message);
                    return;
                }
                if (i == 1400) {
                    locationClient.d(message);
                    return;
                }
                if (i != 54) {
                    z = false;
                    if (i != 55) {
                        if (i == 703) {
                            Bundle data4 = message.getData();
                            int i5 = data4.getInt("id", 0);
                            if (i5 > 0) {
                                locationClient.a(i5, (Notification) data4.getParcelable("notification"));
                                return;
                            }
                            return;
                        }
                        if (i == 704) {
                            locationClient.a(message.getData().getBoolean("removenotify"));
                            return;
                        }
                        switch (i) {
                            case 1:
                                locationClient.a();
                                return;
                            case 2:
                                locationClient.b();
                                return;
                            case 3:
                                locationClient.a(message);
                                return;
                            case 4:
                                locationClient.e();
                                return;
                            case 5:
                                locationClient.b(message);
                                return;
                            case 6:
                                locationClient.e(message);
                                return;
                            default:
                                super.handleMessage(message);
                                return;
                        }
                    }
                    if (!locationClient.c.location_change_notify) {
                        return;
                    }
                } else if (!locationClient.c.location_change_notify) {
                    return;
                }
                locationClient.q = z;
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        private b() {
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0054 A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:4:0x0007, B:6:0x0015, B:9:0x001f, B:11:0x0028, B:14:0x004c, B:16:0x0054, B:18:0x005c, B:19:0x0066, B:20:0x007e, B:23:0x0080, B:24:0x008e, B:26:0x0037, B:28:0x003f, B:31:0x0090, B:33:0x0092), top: B:3:0x0007 }] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0080 A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:4:0x0007, B:6:0x0015, B:9:0x001f, B:11:0x0028, B:14:0x004c, B:16:0x0054, B:18:0x005c, B:19:0x0066, B:20:0x007e, B:23:0x0080, B:24:0x008e, B:26:0x0037, B:28:0x003f, B:31:0x0090, B:33:0x0092), top: B:3:0x0007 }] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r5 = this;
                com.baidu.location.LocationClient r0 = com.baidu.location.LocationClient.this
                java.lang.Object r0 = com.baidu.location.LocationClient.k(r0)
                monitor-enter(r0)
                com.baidu.location.LocationClient r1 = com.baidu.location.LocationClient.this     // Catch: java.lang.Throwable -> L35
                r2 = 0
                com.baidu.location.LocationClient.b(r1, r2)     // Catch: java.lang.Throwable -> L35
                com.baidu.location.LocationClient r1 = com.baidu.location.LocationClient.this     // Catch: java.lang.Throwable -> L35
                android.os.Messenger r1 = com.baidu.location.LocationClient.a(r1)     // Catch: java.lang.Throwable -> L35
                if (r1 == 0) goto L92
                com.baidu.location.LocationClient r1 = com.baidu.location.LocationClient.this     // Catch: java.lang.Throwable -> L35
                android.os.Messenger r1 = com.baidu.location.LocationClient.d(r1)     // Catch: java.lang.Throwable -> L35
                if (r1 != 0) goto L1f
                goto L92
            L1f:
                com.baidu.location.LocationClient r1 = com.baidu.location.LocationClient.this     // Catch: java.lang.Throwable -> L35
                java.util.ArrayList r1 = com.baidu.location.LocationClient.l(r1)     // Catch: java.lang.Throwable -> L35
                r2 = 1
                if (r1 == 0) goto L37
                com.baidu.location.LocationClient r1 = com.baidu.location.LocationClient.this     // Catch: java.lang.Throwable -> L35
                java.util.ArrayList r1 = com.baidu.location.LocationClient.l(r1)     // Catch: java.lang.Throwable -> L35
                int r1 = r1.size()     // Catch: java.lang.Throwable -> L35
                if (r1 >= r2) goto L4c
                goto L37
            L35:
                r1 = move-exception
                goto L94
            L37:
                com.baidu.location.LocationClient r1 = com.baidu.location.LocationClient.this     // Catch: java.lang.Throwable -> L35
                java.util.ArrayList r1 = com.baidu.location.LocationClient.m(r1)     // Catch: java.lang.Throwable -> L35
                if (r1 == 0) goto L90
                com.baidu.location.LocationClient r1 = com.baidu.location.LocationClient.this     // Catch: java.lang.Throwable -> L35
                java.util.ArrayList r1 = com.baidu.location.LocationClient.m(r1)     // Catch: java.lang.Throwable -> L35
                int r1 = r1.size()     // Catch: java.lang.Throwable -> L35
                if (r1 >= r2) goto L4c
                goto L90
            L4c:
                com.baidu.location.LocationClient r1 = com.baidu.location.LocationClient.this     // Catch: java.lang.Throwable -> L35
                boolean r1 = com.baidu.location.LocationClient.n(r1)     // Catch: java.lang.Throwable -> L35
                if (r1 == 0) goto L80
                com.baidu.location.LocationClient r1 = com.baidu.location.LocationClient.this     // Catch: java.lang.Throwable -> L35
                com.baidu.location.LocationClient$b r1 = com.baidu.location.LocationClient.o(r1)     // Catch: java.lang.Throwable -> L35
                if (r1 != 0) goto L66
                com.baidu.location.LocationClient r1 = com.baidu.location.LocationClient.this     // Catch: java.lang.Throwable -> L35
                com.baidu.location.LocationClient$b r2 = new com.baidu.location.LocationClient$b     // Catch: java.lang.Throwable -> L35
                r2.<init>()     // Catch: java.lang.Throwable -> L35
                com.baidu.location.LocationClient.a(r1, r2)     // Catch: java.lang.Throwable -> L35
            L66:
                com.baidu.location.LocationClient r1 = com.baidu.location.LocationClient.this     // Catch: java.lang.Throwable -> L35
                com.baidu.location.LocationClient$a r1 = com.baidu.location.LocationClient.c(r1)     // Catch: java.lang.Throwable -> L35
                com.baidu.location.LocationClient r2 = com.baidu.location.LocationClient.this     // Catch: java.lang.Throwable -> L35
                com.baidu.location.LocationClient$b r2 = com.baidu.location.LocationClient.o(r2)     // Catch: java.lang.Throwable -> L35
                com.baidu.location.LocationClient r3 = com.baidu.location.LocationClient.this     // Catch: java.lang.Throwable -> L35
                com.baidu.location.LocationClientOption r3 = com.baidu.location.LocationClient.f(r3)     // Catch: java.lang.Throwable -> L35
                int r3 = r3.scanSpan     // Catch: java.lang.Throwable -> L35
                long r3 = (long) r3     // Catch: java.lang.Throwable -> L35
                r1.postDelayed(r2, r3)     // Catch: java.lang.Throwable -> L35
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L35
                return
            L80:
                com.baidu.location.LocationClient r1 = com.baidu.location.LocationClient.this     // Catch: java.lang.Throwable -> L35
                com.baidu.location.LocationClient$a r1 = com.baidu.location.LocationClient.c(r1)     // Catch: java.lang.Throwable -> L35
                r2 = 4
                android.os.Message r1 = r1.obtainMessage(r2)     // Catch: java.lang.Throwable -> L35
                r1.sendToTarget()     // Catch: java.lang.Throwable -> L35
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L35
                return
            L90:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L35
                return
            L92:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L35
                return
            L94:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L35
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.LocationClient.b.run():void");
        }

        public /* synthetic */ b(LocationClient locationClient, com.baidu.location.c cVar) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public class c extends Thread {
        private c() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                if (LocationClient.this.B.booleanValue()) {
                    if (LocationClient.this.D == null) {
                        com.baidu.location.c.h.a().b();
                        LocationClient.this.D = new j(LocationClient.this.f, LocationClient.this.d, LocationClient.this, null, false);
                    }
                    LocationClient locationClient = LocationClient.this;
                    locationClient.I = locationClient.D.g();
                    if (LocationClient.this.d.firstLocType == LocationClientOption.FirstLocType.ACCURACY_IN_FIRST_LOC) {
                        LocationClient.this.D.d();
                        LocationClient.this.D.e();
                    }
                }
                LocationClient.this.h.obtainMessage(1).sendToTarget();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public /* synthetic */ c(LocationClient locationClient, com.baidu.location.c cVar) {
            this();
        }
    }

    public LocationClient(Context context) throws Exception {
        this.c = new LocationClientOption();
        this.d = new LocationClientOption();
        this.f = null;
        Boolean bool = Boolean.FALSE;
        this.z = bool;
        this.A = bool;
        this.B = Boolean.TRUE;
        this.D = null;
        this.E = false;
        this.F = false;
        this.G = false;
        this.I = null;
        this.J = new com.baidu.location.c(this);
        c();
        this.f = context;
        this.c = new LocationClientOption();
        this.d = new LocationClientOption();
        this.h = new a(Looper.getMainLooper(), this);
        this.i = new Messenger(this.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (!this.e || this.g == null) {
            return;
        }
        Message obtain = Message.obtain((Handler) null, 12);
        obtain.replyTo = this.i;
        try {
            this.g.send(obtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.f.unbindService(this.J);
            if (this.G) {
                try {
                    this.f.stopService(new Intent(this.f, (Class<?>) f.class));
                } catch (Exception unused) {
                }
                this.G = false;
            }
        } catch (Exception unused2) {
        }
        synchronized (this.r) {
            try {
                if (this.o) {
                    this.h.removeCallbacks(this.p);
                    this.o = false;
                }
            } catch (Exception unused3) {
            }
        }
        this.g = null;
        this.n = false;
        this.x = false;
        this.e = false;
        this.E = false;
        this.F = false;
        this.B = Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle d() {
        if (this.c == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("packName", this.b);
        bundle.putString("prodName", this.c.prodName);
        bundle.putString("coorType", this.c.coorType);
        bundle.putString("addrType", this.c.addrType);
        bundle.putBoolean("openGPS", this.c.openGps);
        bundle.putBoolean("location_change_notify", this.c.location_change_notify);
        bundle.putInt("scanSpan", this.c.scanSpan);
        bundle.putBoolean("enableSimulateGps", this.c.enableSimulateGps);
        bundle.putInt("timeOut", this.c.timeOut);
        bundle.putInt("priority", this.c.priority);
        bundle.putBoolean(MapPlugin.MapSearchTool, this.z.booleanValue());
        bundle.putBoolean("import", this.A.booleanValue());
        bundle.putBoolean("needDirect", this.c.mIsNeedDeviceDirect);
        bundle.putBoolean("isneedaptag", this.c.isNeedAptag);
        bundle.putBoolean("isneedpoiregion", this.c.isNeedPoiRegion);
        bundle.putBoolean("isneedregular", this.c.isNeedRegular);
        bundle.putBoolean("isneedaptagd", this.c.isNeedAptagd);
        bundle.putBoolean("isneedaltitude", this.c.isNeedAltitude);
        bundle.putBoolean("isneednewrgc", this.c.isNeedNewVersionRgc);
        bundle.putInt("autoNotifyMaxInterval", this.c.a());
        bundle.putInt("autoNotifyMinTimeInterval", this.c.getAutoNotifyMinTimeInterval());
        bundle.putInt("autoNotifyMinDistance", this.c.getAutoNotifyMinDistance());
        bundle.putFloat("autoNotifyLocSensitivity", this.c.b());
        bundle.putInt("wifitimeout", this.c.wifiCacheTimeOut);
        bundle.putInt("wfnum", com.baidu.location.b.a.a().b);
        bundle.putBoolean("ischeckper", com.baidu.location.b.a.a().f5607a);
        bundle.putFloat("wfsm", (float) com.baidu.location.b.a.a().c);
        bundle.putDouble("gnmcrm", com.baidu.location.b.a.a().f);
        bundle.putInt("gnmcon", com.baidu.location.b.a.a().g);
        bundle.putInt("iupl", com.baidu.location.b.a.a().h);
        bundle.putInt("lpcs", com.baidu.location.b.a.a().e);
        bundle.putInt("hpdts", com.baidu.location.b.a.a().o);
        bundle.putInt("oldts", com.baidu.location.b.a.a().p);
        bundle.putInt("onic", com.baidu.location.b.a.a().q);
        bundle.putInt("nlcs", com.baidu.location.b.a.a().r);
        bundle.putFloat("ncsr", com.baidu.location.b.a.a().s);
        bundle.putFloat("cscr", com.baidu.location.b.a.a().t);
        bundle.putString("connectBssid", this.I);
        bundle.putInt("cls", com.baidu.location.b.a.a().u);
        bundle.putIntArray("ocs", com.baidu.location.b.a.a().v);
        bundle.putInt("topCellNumber", com.baidu.location.b.a.a().w);
        bundle.putInt("locStrLength", com.baidu.location.b.a.a().x);
        return bundle;
    }

    public static BDLocation getBDLocationInCoorType(BDLocation bDLocation, String str) {
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        double[] coorEncrypt = Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), str);
        bDLocation2.setLatitude(coorEncrypt[1]);
        bDLocation2.setLongitude(coorEncrypt[0]);
        return bDLocation2;
    }

    public static void setAgreePrivacy(boolean z) {
        H = z;
    }

    public static void setKey(String str) {
        w = str;
    }

    public void disableAssistantLocation() {
        v.a().b();
    }

    public void disableLocInForeground(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("removenotify", z);
        Message obtainMessage = this.h.obtainMessage(704);
        obtainMessage.setData(bundle);
        obtainMessage.sendToTarget();
    }

    public void enableAssistantLocation(WebView webView) {
        v.a().a(this.f, webView, this);
    }

    public void enableLocInForeground(int i, Notification notification) {
        if (i <= 0 || notification == null) {
            Log.e("baidu_location_Client", "can not startLocInForeground if the param is unlegal");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("id", i);
        bundle.putParcelable("notification", notification);
        Message obtainMessage = this.h.obtainMessage(ah.P);
        obtainMessage.setData(bundle);
        obtainMessage.sendToTarget();
    }

    public String getAccessKey() {
        try {
            String b2 = com.baidu.location.a.a.b(this.f);
            this.v = b2;
            if (TextUtils.isEmpty(b2)) {
                throw new IllegalStateException("please setting key from Manifest.xml");
            }
            return String.format("KEY=%s", this.v);
        } catch (Exception unused) {
            return null;
        }
    }

    public BDLocation getLastKnownLocation() {
        return this.l;
    }

    public LocationClientOption getLocOption() {
        return this.c;
    }

    public String getVersion() {
        return "9.5.2.3";
    }

    public boolean isStarted() {
        return this.e;
    }

    public void onReceiveLightLocString(String str) {
    }

    @Override // com.baidu.location.b.j.a
    public void onReceiveLocation(BDLocation bDLocation) {
        if ((!this.F || this.E) && bDLocation != null) {
            Message obtainMessage = this.h.obtainMessage(701);
            obtainMessage.obj = bDLocation;
            obtainMessage.sendToTarget();
        }
    }

    public void registerLocationListener(BDAbstractLocationListener bDAbstractLocationListener) {
        if (bDAbstractLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.h.obtainMessage(FeatureCodes.VO);
        obtainMessage.obj = bDAbstractLocationListener;
        obtainMessage.sendToTarget();
    }

    public boolean requestHotSpotState() {
        if (this.g != null && this.e) {
            try {
                this.g.send(Message.obtain((Handler) null, 406));
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public int requestLocation() {
        ArrayList<BDAbstractLocationListener> arrayList;
        if (this.g == null || this.i == null) {
            return 1;
        }
        ArrayList<BDLocationListener> arrayList2 = this.j;
        if ((arrayList2 == null || arrayList2.size() < 1) && ((arrayList = this.k) == null || arrayList.size() < 1)) {
            return 2;
        }
        if (System.currentTimeMillis() - this.f5601a < 1000) {
            return 6;
        }
        this.n = true;
        Message obtainMessage = this.h.obtainMessage(4);
        obtainMessage.arg1 = 0;
        obtainMessage.sendToTarget();
        return 0;
    }

    public void restart() {
        stop();
        this.y = false;
        this.h.sendEmptyMessageDelayed(1, 1000L);
    }

    public void setLocOption(LocationClientOption locationClientOption) {
        if (locationClientOption == null) {
            locationClientOption = new LocationClientOption();
        }
        if (locationClientOption.a() > 0) {
            locationClientOption.setScanSpan(0);
            locationClientOption.setLocationNotify(true);
        }
        this.d = new LocationClientOption(locationClientOption);
        Message obtainMessage = this.h.obtainMessage(3);
        obtainMessage.obj = locationClientOption;
        obtainMessage.sendToTarget();
    }

    public void start() {
        this.y = false;
        f();
        LBSAuthManager.getInstance(this.f.getApplicationContext()).setPrivacyMode(H);
        com.baidu.location.b.a.a().a(this.f, this.d, (String) null);
        new c(this, null).start();
    }

    public void stop() {
        this.y = true;
        this.h.obtainMessage(2).sendToTarget();
        j jVar = this.D;
        if (jVar != null) {
            jVar.f();
            this.D = null;
        }
    }

    public void unRegisterLocationListener(BDAbstractLocationListener bDAbstractLocationListener) {
        if (bDAbstractLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.h.obtainMessage(FeatureCodes.POSE);
        obtainMessage.obj = bDAbstractLocationListener;
        obtainMessage.sendToTarget();
    }

    public boolean updateLocation(Location location) {
        if (this.g == null || this.i == null || location == null) {
            return false;
        }
        try {
            Message obtain = Message.obtain((Handler) null, 57);
            obtain.obj = location;
            this.g.send(obtain);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public LocationClient(Context context, LocationClientOption locationClientOption) throws Exception {
        this.c = new LocationClientOption();
        this.d = new LocationClientOption();
        this.f = null;
        Boolean bool = Boolean.FALSE;
        this.z = bool;
        this.A = bool;
        this.B = Boolean.TRUE;
        this.D = null;
        this.E = false;
        this.F = false;
        this.G = false;
        this.I = null;
        this.J = new com.baidu.location.c(this);
        c();
        this.f = context;
        this.c = locationClientOption;
        this.d = new LocationClientOption(locationClientOption);
        this.h = new a(Looper.getMainLooper(), this);
        this.i = new Messenger(this.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Message message) {
        Object obj;
        if (message == null || (obj = message.obj) == null) {
            return;
        }
        BDLocationListener bDLocationListener = (BDLocationListener) obj;
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        if (this.j.contains(bDLocationListener)) {
            return;
        }
        this.j.add(bDLocationListener);
    }

    private void c() throws Exception {
        if (H) {
            return;
        }
        Log.e("baidu_location_Client", "The location function has been stopped because you do not agree with the privacy compliance policy. Please recheck the setAgreePrivacy interface");
        throw new Exception("The location function has been stopped because you do not agree with the privacy compliance policy. Please recheck the setAgreePrivacy interface");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        int i;
        if (this.g == null) {
            return;
        }
        int g = o.g(this.f);
        com.baidu.location.c cVar = null;
        if ((System.currentTimeMillis() - this.s > 3000 || !this.c.location_change_notify || this.n) && g == 1) {
            if (!this.x || System.currentTimeMillis() - this.t > 20000 || this.n) {
                Message obtain = Message.obtain((Handler) null, 22);
                if (this.n) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("isWaitingLocTag", this.n);
                    this.n = false;
                    obtain.setData(bundle);
                }
                try {
                    obtain.replyTo = this.i;
                    this.g.send(obtain);
                    this.f5601a = System.currentTimeMillis();
                    this.m = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (g < 1) {
            BDLocation bDLocation = new BDLocation();
            if (g == -1) {
                i = 69;
            } else if (g == -2) {
                i = 70;
            } else {
                if (g == 0) {
                    i = 71;
                }
                a(bDLocation);
            }
            bDLocation.setLocType(i);
            a(bDLocation);
        }
        synchronized (this.r) {
            try {
                LocationClientOption locationClientOption = this.c;
                if (locationClientOption != null && locationClientOption.scanSpan >= 1000 && !this.o) {
                    if (this.p == null) {
                        this.p = new b(this, cVar);
                    }
                    this.h.postDelayed(this.p, this.c.scanSpan);
                    this.o = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void f() {
        LocationClientOption locationClientOption = this.d;
        if (locationClientOption == null) {
            return;
        }
        o.aY = locationClientOption.mProxyHost;
        o.aZ = locationClientOption.mProxyPort;
        o.ba = locationClientOption.mUsername;
        o.bb = locationClientOption.mPassword;
    }

    public void registerLocationListener(BDLocationListener bDLocationListener) {
        if (bDLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.h.obtainMessage(5);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public void unRegisterLocationListener(BDLocationListener bDLocationListener) {
        if (bDLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.h.obtainMessage(6);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(BDLocation bDLocation) {
        if (this.y) {
            return;
        }
        this.l = bDLocation;
        if (!this.F && bDLocation.getLocType() == 161) {
            this.E = true;
            com.baidu.location.b.a.a().a(bDLocation.getLatitude(), bDLocation.getLongitude(), bDLocation.getCoorType());
        }
        ArrayList<BDLocationListener> arrayList = this.j;
        if (arrayList != null) {
            Iterator<BDLocationListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onReceiveLocation(bDLocation);
            }
        }
        ArrayList<BDAbstractLocationListener> arrayList2 = this.k;
        if (arrayList2 != null) {
            Iterator<BDAbstractLocationListener> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                it2.next().onReceiveLocation(bDLocation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Message message) {
        Object obj;
        if (message == null || (obj = message.obj) == null) {
            return;
        }
        BDAbstractLocationListener bDAbstractLocationListener = (BDAbstractLocationListener) obj;
        if (this.k == null) {
            this.k = new ArrayList<>();
        }
        if (this.k.contains(bDAbstractLocationListener)) {
            return;
        }
        this.k.add(bDAbstractLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Message message) {
        Object obj;
        if (message == null || (obj = message.obj) == null) {
            return;
        }
        BDAbstractLocationListener bDAbstractLocationListener = (BDAbstractLocationListener) obj;
        ArrayList<BDAbstractLocationListener> arrayList = this.k;
        if (arrayList == null || !arrayList.contains(bDAbstractLocationListener)) {
            return;
        }
        this.k.remove(bDAbstractLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Message message) {
        Object obj;
        if (message == null || (obj = message.obj) == null) {
            return;
        }
        BDLocationListener bDLocationListener = (BDLocationListener) obj;
        ArrayList<BDLocationListener> arrayList = this.j;
        if (arrayList == null || !arrayList.contains(bDLocationListener)) {
            return;
        }
        this.j.remove(bDLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.e) {
            return;
        }
        if (this.B.booleanValue()) {
            boolean c2 = o.c(this.f);
            if (this.d.isOnceLocation()) {
                c2 = true;
            }
            if (c2) {
                try {
                    new d(this).start();
                } catch (Throwable unused) {
                }
            }
        }
        if (this.d.isOnceLocation()) {
            return;
        }
        this.B = Boolean.FALSE;
        this.b = this.f.getPackageName();
        this.u = this.b + "_bdls_v2.9";
        Intent intent = new Intent(this.f, (Class<?>) f.class);
        try {
            intent.putExtra("debug_dev", this.C);
        } catch (Exception unused2) {
        }
        if (this.c == null) {
            this.c = new LocationClientOption();
        }
        intent.putExtra("cache_exception", this.c.isIgnoreCacheException);
        intent.putExtra("kill_process", this.c.isIgnoreKillProcess);
        intent.putExtra("auth_key", w);
        intent.putExtra("proxyHost", this.c.mProxyHost);
        intent.putExtra("proxyPort", this.c.mProxyPort);
        intent.putExtra("username", this.c.mUsername);
        intent.putExtra("password", this.c.mPassword);
        try {
            this.f.bindService(intent, this.J, 1);
        } catch (Exception e) {
            e.printStackTrace();
            this.e = false;
        }
    }

    private void a(int i) {
        if (this.l.getCoorType() == null) {
            this.l.setCoorType(this.c.coorType);
        }
        if (this.m || ((this.c.location_change_notify && this.l.getLocType() == 61) || this.l.getLocType() == 66 || this.l.getLocType() == 67 || this.x || this.l.getLocType() == 161)) {
            ArrayList<BDLocationListener> arrayList = this.j;
            if (arrayList != null) {
                Iterator<BDLocationListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().onReceiveLocation(this.l);
                }
            }
            ArrayList<BDAbstractLocationListener> arrayList2 = this.k;
            if (arrayList2 != null) {
                Iterator<BDAbstractLocationListener> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    it2.next().onReceiveLocation(this.l);
                }
            }
            if (this.l.getLocType() == 66 || this.l.getLocType() == 67) {
                return;
            }
            this.m = false;
            this.t = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Notification notification) {
        try {
            Intent intent = new Intent(this.f, (Class<?>) f.class);
            intent.putExtra("notification", notification);
            intent.putExtra("id", i);
            intent.putExtra("command", 1);
            if (Build.VERSION.SDK_INT >= 26) {
                this.f.startForegroundService(intent);
            } else {
                this.f.startService(intent);
            }
            this.G = true;
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        Object obj;
        this.n = false;
        if (message == null || (obj = message.obj) == null) {
            return;
        }
        LocationClientOption locationClientOption = (LocationClientOption) obj;
        if (this.c.optionEquals(locationClientOption)) {
            return;
        }
        com.baidu.location.c cVar = null;
        if (this.c.scanSpan != locationClientOption.scanSpan) {
            try {
                synchronized (this.r) {
                    try {
                        if (this.o) {
                            this.h.removeCallbacks(this.p);
                            this.o = false;
                        }
                        if (locationClientOption.scanSpan >= 1000 && !this.o) {
                            if (this.p == null) {
                                this.p = new b(this, cVar);
                            }
                            this.h.postDelayed(this.p, locationClientOption.scanSpan);
                            this.o = true;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Exception unused) {
            }
        }
        this.c = new LocationClientOption(locationClientOption);
        if (this.g != null && o.g(this.f) >= 1) {
            try {
                Message obtain = Message.obtain((Handler) null, 15);
                obtain.replyTo = this.i;
                obtain.setData(d());
                this.g.send(obtain);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message, int i) {
        if (this.e) {
            try {
                Bundle data = message.getData();
                data.setClassLoader(BDLocation.class.getClassLoader());
                BDLocation bDLocation = (BDLocation) data.getParcelable("locStr");
                this.l = bDLocation;
                if (bDLocation.getLocType() == 61) {
                    this.s = System.currentTimeMillis();
                }
                if (this.l.getLocType() == 61 || this.l.getLocType() == 161) {
                    com.baidu.location.b.a.a().a(this.l.getLatitude(), this.l.getLongitude(), this.l.getCoorType());
                }
                a(i);
            } catch (Exception unused) {
            }
        }
    }

    private void a(BDLocation bDLocation) {
        ArrayList<BDLocationListener> arrayList = this.j;
        if (arrayList != null) {
            Iterator<BDLocationListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onReceiveLocation(bDLocation);
            }
        }
        ArrayList<BDAbstractLocationListener> arrayList2 = this.k;
        if (arrayList2 != null) {
            Iterator<BDAbstractLocationListener> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                it2.next().onReceiveLocation(bDLocation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        try {
            Intent intent = new Intent(this.f, (Class<?>) f.class);
            intent.putExtra("removenotify", z);
            intent.putExtra("command", 2);
            this.f.startService(intent);
            this.G = true;
        } catch (Exception unused) {
        }
    }
}
