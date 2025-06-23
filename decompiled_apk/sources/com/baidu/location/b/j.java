package com.baidu.location.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.material.timepicker.TimeModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class j {
    private static char[] s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".toCharArray();

    /* renamed from: a, reason: collision with root package name */
    String f5643a;
    String b;
    private Context d;
    private TelephonyManager e;
    private WifiManager g;
    private String i;
    private String j;
    private LocationClientOption k;
    private a l;
    private String n;
    private String o;
    private boolean p;
    private com.baidu.location.c.a f = new com.baidu.location.c.a();
    private com.baidu.location.c.p h = null;
    private String m = null;
    b c = new b();
    private String q = null;
    private long r = 0;
    private boolean t = false;
    private long u = 0;
    private boolean v = false;

    /* loaded from: classes7.dex */
    public interface a {
        void onReceiveLocation(BDLocation bDLocation);
    }

    /* loaded from: classes7.dex */
    public class b extends com.baidu.location.e.g {
        LocationManager b;
        a c;

        /* renamed from: a, reason: collision with root package name */
        String f5644a = null;
        boolean d = false;

        /* loaded from: classes7.dex */
        public class a implements LocationListener {
            private a() {
            }

            @Override // android.location.LocationListener
            public void onLocationChanged(Location location) {
                b.this.c();
                b.this.d = true;
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

            public /* synthetic */ a(b bVar, k kVar) {
                this();
            }
        }

        public b() {
            this.dB = new HashMap();
        }

        private void b() {
            try {
                this.b = (LocationManager) j.this.d.getSystemService("location");
                a aVar = new a(this, null);
                this.c = aVar;
                LocationManager locationManager = this.b;
                if (locationManager != null) {
                    try {
                        locationManager.requestLocationUpdates("network", 1000L, 0.0f, aVar, Looper.getMainLooper());
                    } catch (SecurityException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Throwable unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            LocationManager locationManager;
            a aVar = this.c;
            if (aVar == null || (locationManager = this.b) == null) {
                return;
            }
            try {
                locationManager.removeUpdates(aVar);
            } catch (Exception unused) {
            }
        }

        @Override // com.baidu.location.e.g
        public void a() {
            if (j.this.n != null && j.this.o != null) {
                this.f5644a += String.format(Locale.CHINA, "&ki=%s&sn=%s", j.this.n, j.this.o);
            }
            String str = this.f5644a + "&enc=2";
            this.f5644a = str;
            String encodeTp4 = Jni.encodeTp4(str);
            this.f5644a = null;
            this.dB.put("bloc", encodeTp4);
            this.dB.put("trtm", String.format(Locale.CHINA, TimeModel.NUMBER_FORMAT, Long.valueOf(System.currentTimeMillis())));
        }

        private void a(BDLocation bDLocation) {
            try {
                if (bDLocation.hasAddr()) {
                    Address address = bDLocation.getAddress();
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(address.country);
                    stringBuffer.append(com.huawei.openalliance.ad.constant.x.aL);
                    stringBuffer.append(address.countryCode);
                    stringBuffer.append(com.huawei.openalliance.ad.constant.x.aL);
                    stringBuffer.append(address.province);
                    stringBuffer.append(com.huawei.openalliance.ad.constant.x.aL);
                    stringBuffer.append(address.city);
                    stringBuffer.append(com.huawei.openalliance.ad.constant.x.aL);
                    stringBuffer.append(address.cityCode);
                    stringBuffer.append(com.huawei.openalliance.ad.constant.x.aL);
                    stringBuffer.append(address.district);
                    stringBuffer.append(com.huawei.openalliance.ad.constant.x.aL);
                    stringBuffer.append(address.street);
                    stringBuffer.append(com.huawei.openalliance.ad.constant.x.aL);
                    stringBuffer.append(address.streetNumber);
                    stringBuffer.append(com.huawei.openalliance.ad.constant.x.aL);
                    stringBuffer.append(address.adcode);
                    stringBuffer.append(com.huawei.openalliance.ad.constant.x.aL);
                    stringBuffer.append(address.town);
                    String encodeToString = Base64.encodeToString((System.currentTimeMillis() + "_" + stringBuffer.toString()).getBytes("UTF-8"), 0);
                    SharedPreferences a2 = ad.a(j.this.d);
                    if (a2 != null) {
                        SharedPreferences.Editor edit = a2.edit();
                        edit.putString("FirstLocAddr", encodeToString);
                        edit.apply();
                    }
                }
            } catch (Exception unused) {
            }
        }

        public void a(String str) {
            this.f5644a = str;
            b(com.baidu.location.e.e.c);
            if (j.this.t) {
                b();
                Timer timer = new Timer();
                timer.schedule(new l(this, timer), 10000L);
                SharedPreferences.Editor edit = j.this.d.getSharedPreferences("cuidRelate", 0).edit();
                edit.putLong("reqtime", System.currentTimeMillis());
                edit.apply();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:3:0x0008, code lost:
        
            r6 = r5.dA;
         */
        @Override // com.baidu.location.e.g
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a(boolean r6) {
            /*
                r5 = this;
                java.lang.String r0 = ";"
                java.lang.String r1 = "enc"
                r2 = 63
                if (r6 == 0) goto Lde
                java.lang.String r6 = r5.dA
                if (r6 == 0) goto Lde
                java.lang.String r3 = "\"enc\""
                boolean r3 = r6.contains(r3)     // Catch: java.lang.Exception -> L31
                if (r3 == 0) goto L34
                org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Exception -> L2c
                r3.<init>(r6)     // Catch: java.lang.Exception -> L2c
                boolean r4 = r3.has(r1)     // Catch: java.lang.Exception -> L2c
                if (r4 == 0) goto L34
                java.lang.String r1 = r3.getString(r1)     // Catch: java.lang.Exception -> L2c
                com.baidu.location.b.t r3 = com.baidu.location.b.t.a()     // Catch: java.lang.Exception -> L2c
                java.lang.String r6 = r3.b(r1)     // Catch: java.lang.Exception -> L2c
                goto L34
            L2c:
                r1 = move-exception
                r1.printStackTrace()     // Catch: java.lang.Exception -> L31
                goto L34
            L31:
                r6 = move-exception
                goto Ld5
            L34:
                com.baidu.location.BDLocation r1 = new com.baidu.location.BDLocation     // Catch: java.lang.Exception -> L4e
                r1.<init>(r6)     // Catch: java.lang.Exception -> L4e
                com.baidu.location.b.j r3 = com.baidu.location.b.j.this     // Catch: java.lang.Exception -> L4e
                com.baidu.location.b.j.a(r3, r6)     // Catch: java.lang.Exception -> L4e
                com.baidu.location.b.j r6 = com.baidu.location.b.j.this     // Catch: java.lang.Exception -> L4e
                com.baidu.location.LocationClientOption r6 = com.baidu.location.b.j.c(r6)     // Catch: java.lang.Exception -> L4e
                boolean r6 = r6.isOnceLocation()     // Catch: java.lang.Exception -> L4e
                if (r6 != 0) goto L56
                r5.a(r1)     // Catch: java.lang.Exception -> L4e
                goto L56
            L4e:
                com.baidu.location.BDLocation r1 = new com.baidu.location.BDLocation     // Catch: java.lang.Exception -> L31
                r1.<init>()     // Catch: java.lang.Exception -> L31
                r1.setLocType(r2)     // Catch: java.lang.Exception -> L31
            L56:
                int r6 = r1.getLocType()     // Catch: java.lang.Exception -> L31
                r3 = 161(0xa1, float:2.26E-43)
                if (r6 != r3) goto Lcb
                java.lang.String r6 = "wgs84"
                java.lang.String r3 = r1.getCoorType()     // Catch: java.lang.Exception -> L31
                boolean r6 = r6.equals(r3)     // Catch: java.lang.Exception -> L31
                if (r6 == 0) goto L82
                com.baidu.location.b.j r6 = com.baidu.location.b.j.this     // Catch: java.lang.Exception -> L31
                com.baidu.location.LocationClientOption r6 = com.baidu.location.b.j.c(r6)     // Catch: java.lang.Exception -> L31
                java.lang.String r6 = r6.coorType     // Catch: java.lang.Exception -> L31
                java.lang.String r3 = "bd09"
                boolean r6 = r6.equals(r3)     // Catch: java.lang.Exception -> L31
                if (r6 == 0) goto L8b
                java.lang.String r6 = "wgs84mc"
            L7e:
                r1.setCoorType(r6)     // Catch: java.lang.Exception -> L31
                goto L8b
            L82:
                com.baidu.location.b.j r6 = com.baidu.location.b.j.this     // Catch: java.lang.Exception -> L31
                com.baidu.location.LocationClientOption r6 = com.baidu.location.b.j.c(r6)     // Catch: java.lang.Exception -> L31
                java.lang.String r6 = r6.coorType     // Catch: java.lang.Exception -> L31
                goto L7e
            L8b:
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L31
                r6.<init>()     // Catch: java.lang.Exception -> L31
                com.baidu.location.b.j r3 = com.baidu.location.b.j.this     // Catch: java.lang.Exception -> L31
                java.lang.String r3 = r3.f5643a     // Catch: java.lang.Exception -> L31
                r6.append(r3)     // Catch: java.lang.Exception -> L31
                r6.append(r0)     // Catch: java.lang.Exception -> L31
                com.baidu.location.b.j r3 = com.baidu.location.b.j.this     // Catch: java.lang.Exception -> L31
                java.lang.String r3 = r3.b     // Catch: java.lang.Exception -> L31
                r6.append(r3)     // Catch: java.lang.Exception -> L31
                r6.append(r0)     // Catch: java.lang.Exception -> L31
                java.lang.String r0 = r1.getTime()     // Catch: java.lang.Exception -> L31
                r6.append(r0)     // Catch: java.lang.Exception -> L31
                java.lang.String r6 = r6.toString()     // Catch: java.lang.Exception -> L31
                java.lang.String r6 = com.baidu.location.Jni.en1(r6)     // Catch: java.lang.Exception -> L31
                r1.setLocationID(r6)     // Catch: java.lang.Exception -> L31
                r6 = 0
                r0 = 0
                r1.setRoadLocString(r0, r0, r6, r6)     // Catch: java.lang.Exception -> L31
                com.baidu.location.b.j r6 = com.baidu.location.b.j.this     // Catch: java.lang.Exception -> L31
                r0 = 1
                com.baidu.location.b.j.a(r6, r0)     // Catch: java.lang.Exception -> L31
                com.baidu.location.b.j r6 = com.baidu.location.b.j.this     // Catch: java.lang.Exception -> L31
                com.baidu.location.b.j$a r6 = com.baidu.location.b.j.d(r6)     // Catch: java.lang.Exception -> L31
                r6.onReceiveLocation(r1)     // Catch: java.lang.Exception -> L31
                goto Le3
            Lcb:
                com.baidu.location.b.j r6 = com.baidu.location.b.j.this     // Catch: java.lang.Exception -> L31
                int r0 = r1.getLocType()     // Catch: java.lang.Exception -> L31
                com.baidu.location.b.j.a(r6, r0)     // Catch: java.lang.Exception -> L31
                goto Le3
            Ld5:
                com.baidu.location.b.j r0 = com.baidu.location.b.j.this
                com.baidu.location.b.j.a(r0, r2)
                r6.printStackTrace()
                goto Le3
            Lde:
                com.baidu.location.b.j r6 = com.baidu.location.b.j.this
                com.baidu.location.b.j.a(r6, r2)
            Le3:
                java.util.Map<java.lang.String, java.lang.Object> r6 = r5.dB
                if (r6 == 0) goto Lea
                r6.clear()
            Lea:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.j.b.a(boolean):void");
        }
    }

    /* loaded from: classes7.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public String f5646a;
        public int b;

        public c(String str, int i) {
            this.f5646a = str;
            this.b = i;
        }
    }

    public j(Context context, LocationClientOption locationClientOption, a aVar, String str, boolean z) {
        StringBuilder sb;
        String str2 = null;
        this.d = null;
        this.e = null;
        this.g = null;
        this.i = null;
        this.j = null;
        this.n = null;
        this.o = null;
        this.f5643a = null;
        this.b = null;
        this.p = false;
        Context applicationContext = context.getApplicationContext();
        this.d = applicationContext;
        try {
            com.baidu.location.e.o.aw = applicationContext.getPackageName();
        } catch (Exception unused) {
        }
        this.p = true;
        this.k = new LocationClientOption(locationClientOption);
        this.l = aVar;
        this.f5643a = this.d.getPackageName();
        this.b = null;
        try {
            this.e = (TelephonyManager) this.d.getSystemService("phone");
            this.g = (WifiManager) this.d.getApplicationContext().getSystemService("wifi");
        } catch (Exception unused2) {
        }
        if (this.k.firstLocType == LocationClientOption.FirstLocType.ACCURACY_IN_FIRST_LOC) {
            com.baidu.location.c.h.a().a(this.d);
        }
        this.j = "&" + this.f5643a + "&" + ((String) null);
        try {
            this.b = LBSAuthManager.getInstance(this.d).getCUID();
        } catch (Throwable unused3) {
            this.b = null;
            this.e = null;
            this.g = null;
        }
        if (this.b != null) {
            com.baidu.location.e.o.n = "" + this.b;
            sb = new StringBuilder();
            sb.append("&prod=");
            sb.append(this.k.prodName);
            sb.append(":");
            sb.append(this.f5643a);
            sb.append("|&cu=");
            str2 = this.b;
        } else {
            sb = new StringBuilder();
            sb.append("&prod=");
            sb.append(this.k.prodName);
            sb.append(":");
            sb.append(this.f5643a);
            sb.append("|&im=");
        }
        sb.append(str2);
        sb.append("&coor=");
        sb.append(locationClientOption.getCoorType());
        this.i = sb.toString();
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("&fw=");
        stringBuffer.append("9.523");
        stringBuffer.append("&sdk=");
        stringBuffer.append("9.523");
        stringBuffer.append("&lt=1");
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&resid=");
        stringBuffer.append(com.tencent.connect.common.II0xO0.f26834o0IXXIx);
        locationClientOption.getAddrType();
        if (locationClientOption.getAddrType() != null && locationClientOption.getAddrType().equals(TtmlNode.COMBINE_ALL)) {
            this.i += "&addr=allj2";
            if (locationClientOption.isNeedNewVersionRgc) {
                stringBuffer.append("&adtp=n2");
            }
        }
        if (locationClientOption.isNeedAptag || locationClientOption.isNeedAptagd) {
            this.i += "&sema=";
            if (locationClientOption.isNeedAptag) {
                this.i += "aptag|";
            }
            if (locationClientOption.isNeedAptagd) {
                this.i += "aptagd2|";
            }
            this.n = com.baidu.location.a.a.b(this.d);
            this.o = com.baidu.location.a.a.c(this.d);
        }
        stringBuffer.append("&first=1");
        if (z) {
            stringBuffer.append("&state=fore");
        }
        stringBuffer.append("&os=A");
        stringBuffer.append(Build.VERSION.SDK);
        this.i += stringBuffer.toString();
    }

    private Object a(Object obj, String str) throws Exception {
        return obj.getClass().getField(str).get(obj);
    }

    private boolean i() {
        if (com.baidu.location.b.a.a().d == 0) {
            return false;
        }
        SharedPreferences sharedPreferences = this.d.getApplicationContext().getSharedPreferences("cuidRelate", 0);
        if (!sharedPreferences.contains("isInstalled")) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (!com.baidu.location.e.o.b(this.d, "com.baidu.map.location")) {
                edit.putInt("isInstalled", 0);
                return false;
            }
            edit.putInt("isInstalled", 1);
            edit.apply();
        } else if (sharedPreferences.getInt("isInstalled", -1) == 0) {
            return false;
        }
        return sharedPreferences.getInt("cuidoc", 1) != 0 && (System.currentTimeMillis() - sharedPreferences.getLong("reqtime", 0L)) / 1000 >= sharedPreferences.getLong("cuidfreq", 60L) && com.baidu.location.e.o.b(this.d) >= 2 && a(this.g) && this.h.a() > 3;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void j() {
        /*
            r11 = this;
            boolean r0 = r11.i()
            r1 = 0
            if (r0 == 0) goto Lc2
            r0 = 1
            r11.t = r0
            com.baidu.location.c.p r2 = r11.h
            r3 = 0
            if (r2 == 0) goto L67
            int r2 = r2.a()
            r4 = 10
            if (r2 < r4) goto L3e
            com.baidu.location.c.h r5 = com.baidu.location.c.h.a()
            com.baidu.location.c.p r6 = r11.h
            java.lang.String r8 = r11.h()
            boolean r9 = r11.t
            com.baidu.location.b.a r2 = com.baidu.location.b.a.a()
            int r10 = r2.b
            r7 = 9
            java.lang.String r2 = r5.a(r6, r7, r8, r9, r10)
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 != 0) goto L67
            byte[] r2 = r2.getBytes()
            java.lang.String r2 = com.baidu.location.e.o.a(r2, r1)
            goto L68
        L3e:
            com.baidu.location.c.h r4 = com.baidu.location.c.h.a()
            com.baidu.location.c.p r5 = r11.h
            int r6 = r5.a()
            java.lang.String r7 = r11.h()
            boolean r8 = r11.t
            com.baidu.location.b.a r2 = com.baidu.location.b.a.a()
            int r9 = r2.b
            java.lang.String r2 = r4.a(r5, r6, r7, r8, r9)
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 != 0) goto L67
            byte[] r2 = r2.getBytes()
            java.lang.String r2 = com.baidu.location.e.o.a(r2, r1)
            goto L68
        L67:
            r2 = r3
        L68:
            java.util.List r4 = r11.k()
            java.lang.String r4 = r11.a(r4)
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L7e
            byte[] r3 = r4.getBytes()
            java.lang.String r3 = com.baidu.location.e.o.a(r3, r1)
        L7e:
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 != 0) goto L9f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = r11.m
            r1.append(r4)
            java.lang.String r4 = "&swf5="
            r1.append(r4)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r11.m = r1
            r11.t = r0
            goto La1
        L9f:
            r11.t = r1
        La1:
            boolean r1 = android.text.TextUtils.isEmpty(r3)
            if (r1 != 0) goto Lc4
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r11.m
            r1.append(r2)
            java.lang.String r2 = "&hwf5="
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r11.m = r1
            r11.t = r0
            goto Lc4
        Lc2:
            r11.t = r1
        Lc4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.j.j():void");
    }

    private List<WifiConfiguration> k() {
        try {
            WifiManager wifiManager = this.g;
            if (wifiManager != null) {
                return wifiManager.getConfiguredNetworks();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public String b() {
        try {
            return a(15);
        } catch (Exception unused) {
            return null;
        }
    }

    public void e() {
        com.baidu.location.c.h.a().c();
    }

    public String g() {
        WifiInfo connectionInfo;
        if (this.g == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.r > 1000 && (connectionInfo = this.g.getConnectionInfo()) != null) {
            this.q = connectionInfo.getBSSID();
            this.r = currentTimeMillis;
        }
        return this.q;
    }

    public String h() {
        try {
            String g = g();
            String replace = g != null ? g.replace(":", "") : null;
            if (replace == null || replace.length() == 12) {
                return new String(replace);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00af A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String a(int r13) {
        /*
            r12 = this;
            r0 = 0
            com.baidu.location.c.h r1 = com.baidu.location.c.h.a()     // Catch: java.lang.Throwable -> L22
            com.baidu.location.c.a r2 = r12.f     // Catch: java.lang.Throwable -> L22
            android.telephony.TelephonyManager r3 = r12.e     // Catch: java.lang.Throwable -> L22
            com.baidu.location.c.a r1 = r1.a(r2, r3)     // Catch: java.lang.Throwable -> L22
            r12.f = r1     // Catch: java.lang.Throwable -> L22
            if (r1 == 0) goto L24
            boolean r1 = r1.b()     // Catch: java.lang.Throwable -> L22
            if (r1 == 0) goto L24
            com.baidu.location.c.h r1 = com.baidu.location.c.h.a()     // Catch: java.lang.Throwable -> L22
            com.baidu.location.c.a r2 = r12.f     // Catch: java.lang.Throwable -> L22
            java.lang.String r1 = r1.b(r2)     // Catch: java.lang.Throwable -> L22
            goto L25
        L22:
            r1 = r0
            goto L46
        L24:
            r1 = r0
        L25:
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L46
            if (r2 != 0) goto L46
            com.baidu.location.c.a r2 = r12.f     // Catch: java.lang.Throwable -> L46
            if (r2 == 0) goto L46
            java.lang.String r2 = r2.m     // Catch: java.lang.Throwable -> L46
            if (r2 == 0) goto L46
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L46
            r2.<init>()     // Catch: java.lang.Throwable -> L46
            r2.append(r1)     // Catch: java.lang.Throwable -> L46
            com.baidu.location.c.a r3 = r12.f     // Catch: java.lang.Throwable -> L46
            java.lang.String r3 = r3.m     // Catch: java.lang.Throwable -> L46
            r2.append(r3)     // Catch: java.lang.Throwable -> L46
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Throwable -> L46
        L46:
            r12.h = r0     // Catch: java.lang.Exception -> L8f
            android.net.wifi.WifiManager r2 = r12.g     // Catch: java.lang.Exception -> L8f
            boolean r2 = a(r2)     // Catch: java.lang.Exception -> L8f
            if (r2 == 0) goto L90
            com.baidu.location.LocationClientOption r2 = r12.k     // Catch: java.lang.Exception -> L8f
            int r2 = r2.priority     // Catch: java.lang.Exception -> L8f
            r3 = 4
            if (r2 == r3) goto L90
            com.baidu.location.c.p r2 = new com.baidu.location.c.p     // Catch: java.lang.Exception -> L8f
            android.net.wifi.WifiManager r3 = r12.g     // Catch: java.lang.Exception -> L8f
            java.util.List r3 = r3.getScanResults()     // Catch: java.lang.Exception -> L8f
            r4 = 0
            r2.<init>(r3, r4)     // Catch: java.lang.Exception -> L8f
            r12.h = r2     // Catch: java.lang.Exception -> L8f
            com.baidu.location.c.h r6 = com.baidu.location.c.h.a()     // Catch: java.lang.Exception -> L8f
            com.baidu.location.c.p r7 = r12.h     // Catch: java.lang.Exception -> L8f
            java.lang.String r9 = r12.h()     // Catch: java.lang.Exception -> L8f
            boolean r10 = r12.t     // Catch: java.lang.Exception -> L8f
            com.baidu.location.b.a r2 = com.baidu.location.b.a.a()     // Catch: java.lang.Exception -> L8f
            int r11 = r2.b     // Catch: java.lang.Exception -> L8f
            r8 = r13
            java.lang.String r13 = r6.a(r7, r8, r9, r10, r11)     // Catch: java.lang.Exception -> L8f
            com.baidu.location.LocationClientOption r2 = r12.k     // Catch: java.lang.Exception -> L8d
            if (r2 == 0) goto L91
            boolean r2 = r2.isOnceLocation()     // Catch: java.lang.Exception -> L8d
            if (r2 == 0) goto L91
            android.net.wifi.WifiManager r2 = r12.g     // Catch: java.lang.Exception -> L8d
            r2.startScan()     // Catch: java.lang.Exception -> L8d
            goto L91
        L8d:
            goto L91
        L8f:
        L90:
            r13 = r0
        L91:
            if (r1 != 0) goto L98
            if (r13 != 0) goto L98
            r12.m = r0
            return r0
        L98:
            if (r13 == 0) goto Lad
            if (r1 != 0) goto L9e
            r1 = r13
            goto Lad
        L9e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            r2.append(r13)
            java.lang.String r1 = r2.toString()
        Lad:
            if (r1 != 0) goto Lb0
            return r0
        Lb0:
            r12.m = r1
            java.lang.String r13 = r12.i
            if (r13 == 0) goto Lcb
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r0 = r12.m
            r13.append(r0)
            java.lang.String r0 = r12.i
            r13.append(r0)
            java.lang.String r13 = r13.toString()
            r12.m = r13
        Lcb:
            r12.j()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r1)
            java.lang.String r0 = r12.i
            r13.append(r0)
            java.lang.String r13 = r13.toString()
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.j.a(int):java.lang.String");
    }

    public void c() {
        if (this.m == null) {
            int g = com.baidu.location.e.o.g(this.d);
            b(g == -1 ? 69 : g == -2 ? 70 : g == 0 ? 71 : 62);
        } else if (this.p) {
            if (this.d != null) {
                h.a().a(this.d);
                this.m += h.a().b();
            }
            this.c.a(this.m);
        }
    }

    public void d() {
        if ((this.g.isWifiEnabled() || this.g.isScanAlwaysAvailable()) && this.k.priority != 4) {
            com.baidu.location.c.h.a().a(0);
        }
        if (com.baidu.location.e.o.a(this.d, com.kuaishou.weapon.p0.g.g) == 1) {
            com.baidu.location.c.h.a().f();
        }
    }

    public void f() {
        com.baidu.location.c.h.a().d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        LocationClientOption locationClientOption = this.k;
        if (locationClientOption == null || !locationClientOption.isOnceLocation()) {
            return;
        }
        BDLocation bDLocation = new BDLocation();
        bDLocation.setLocType(i);
        bDLocation.setLocationID(Jni.en1(this.f5643a + com.huawei.openalliance.ad.constant.x.aL + this.b + com.huawei.openalliance.ad.constant.x.aL + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(System.currentTimeMillis()))));
        a aVar = this.l;
        if (aVar != null) {
            aVar.onReceiveLocation(bDLocation);
        }
    }

    private String a(List<WifiConfiguration> list) {
        ArrayList<c> arrayList;
        int i;
        int i2 = 0;
        if (list == null || list.size() <= 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (WifiConfiguration wifiConfiguration : list) {
                String str = wifiConfiguration.SSID;
                try {
                    i = ((Integer) a(wifiConfiguration, "numAssociation")).intValue();
                } catch (Throwable unused) {
                    i = 0;
                }
                if (i > 0 && !TextUtils.isEmpty(str)) {
                    arrayList.add(new c(str, i));
                }
            }
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList, new k(this));
        }
        StringBuffer stringBuffer = new StringBuffer(200);
        for (c cVar : arrayList) {
            stringBuffer.append(cVar.f5646a);
            stringBuffer.append(",");
            stringBuffer.append(cVar.b);
            stringBuffer.append("|");
            i2++;
            if (i2 == 4) {
                break;
            }
        }
        if (arrayList.size() >= 5) {
            stringBuffer.append(((c) arrayList.get(4)).f5646a);
            stringBuffer.append(",");
            stringBuffer.append(((c) arrayList.get(4)).b);
        }
        return stringBuffer.toString();
    }

    public void a() {
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        String[] split;
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("content");
            String string = jSONObject.has("ideocfre") ? jSONObject.getString("ideocfre") : null;
            if (TextUtils.isEmpty(string) || !string.contains("|") || (split = string.split("\\|")) == null || split.length < 2) {
                return;
            }
            int parseInt = Integer.parseInt(split[0]);
            long parseLong = Long.parseLong(split[1]);
            SharedPreferences.Editor edit = this.d.getSharedPreferences("cuidRelate", 0).edit();
            edit.putInt("cuidoc", parseInt);
            edit.putLong("cuidfreq", parseLong);
            edit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean a(WifiManager wifiManager) {
        try {
            if (!wifiManager.isWifiEnabled()) {
                if (!wifiManager.isScanAlwaysAvailable()) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
