package com.huawei.openalliance.ad.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.ck;
import com.huawei.hms.ads.ed;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.beans.metadata.Location;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.utils.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes10.dex */
public class af {
    private static Location B = null;
    private static final byte[] C = new byte[0];
    private static final String Code = "LocationUtils";
    private static final int D = 2;
    private static final int F = 1;
    private static LocationManager I = null;
    private static final int L = 1;
    private static long S = -1;
    private static final long V = 30000;
    private static String Z = null;

    /* renamed from: a, reason: collision with root package name */
    private static long f17408a = 1800000;
    private static volatile boolean b = false;

    private static void B(final Context context) {
        fb.V(Code, "loc_tag sendAsyncLocation go!");
        if (I(context)) {
            S = System.currentTimeMillis();
            fb.V(Code, "update lastRefreshTime");
            h.I(new Runnable() { // from class: com.huawei.openalliance.ad.utils.af.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        af.Z(context);
                    } catch (Throwable th) {
                        fb.Z(af.Code, "loc_tag asyncLocation exception: " + th.getClass().getSimpleName());
                    }
                }
            });
        }
    }

    private static void C(final Context context) {
        fb.Code(Code, "loc_tag getLocationByKit");
        try {
            new ae(context, new ae.a() { // from class: com.huawei.openalliance.ad.utils.af.5
                @Override // com.huawei.openalliance.ad.utils.ae.a
                public void Code() {
                    try {
                        af.V(context, 2);
                    } catch (Throwable th) {
                        fb.V(af.Code, "onLocationAcquireFailed ex: %s", th.getClass().getSimpleName());
                    }
                }

                @Override // com.huawei.openalliance.ad.utils.ae.a
                public void Code(android.location.Location location) {
                    try {
                        af.Code(location);
                    } catch (Throwable th) {
                        fb.V(af.Code, "onLocationAcquired ex: %s", th.getClass().getSimpleName());
                    }
                }
            }).Code();
        } catch (Throwable th) {
            fb.Z(Code, "loc_tag getLocationByKit, exception = " + th.getClass().getSimpleName());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r7v8 */
    private static com.huawei.openalliance.ad.beans.inner.b D(Context context) {
        ?? r7;
        boolean I2 = ck.Code(context).I();
        boolean b2 = b(context);
        try {
            r7 = a(context);
        } catch (Throwable th) {
            fb.Z(Code, "loc_tag hasLocationPermission = " + th.getClass().getSimpleName());
            r7 = 0;
        }
        if (fb.Code()) {
            fb.Code(Code, "loc_tag isBaseLocationSwitch = %s", Boolean.valueOf(I2));
            fb.Code(Code, "loc_tag isGpsSwitchOpen = %s", Boolean.valueOf(b2));
            fb.Code(Code, "loc_tag hasLocationPermission = %s", Boolean.valueOf((boolean) r7));
        }
        com.huawei.openalliance.ad.beans.inner.b bVar = new com.huawei.openalliance.ad.beans.inner.b();
        bVar.Code(I2 ? 1 : 0);
        bVar.V(b2 ? 1 : 0);
        bVar.I(r7);
        bVar.V(I2 && b2 && r7 != 0);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.huawei.openalliance.ad.beans.inner.b F(Context context) {
        boolean z = false;
        com.huawei.openalliance.ad.beans.inner.b D2 = D(context);
        if (D2.B()) {
            boolean B2 = ed.Code(context).B();
            fb.Code(Code, "loc_tag isSdkServerLocationSwitch = %s", Boolean.valueOf(B2));
            z = B2;
        }
        D2.Code(z);
        return D2;
    }

    private static boolean I(Context context) {
        long abs = Math.abs(System.currentTimeMillis() - S);
        f17408a = ed.Code(context).S();
        fb.Code(Code, "loc_tag isRefreshOk intervalRefreshTime = " + f17408a + ", intervalTime = " + abs);
        if (abs >= f17408a) {
            return true;
        }
        fb.Code(Code, "loc_tag isRefreshOk = false, too frequently (no ok)");
        return false;
    }

    private static boolean L(Context context) {
        String str;
        if (context == null) {
            str = "loc_tag isGpsSwitchOpen Context is null";
        } else {
            try {
                int i = Settings.Secure.getInt(context.getContentResolver(), "location_mode");
                fb.V(Code, "loc_tag isGpsSwitchOpen locationMode is " + i);
                return i == 3;
            } catch (Settings.SettingNotFoundException unused) {
                str = "loc_tag isGpsSwitchOpen SettingNotFoundException";
            }
        }
        fb.Z(Code, str);
        return false;
    }

    private static boolean S(Context context) {
        boolean z;
        try {
            Class.forName("com.huawei.hms.location.LocationServices");
            Class.forName("com.huawei.hms.location.FusedLocationProviderClient");
            z = true;
        } catch (Throwable unused) {
            fb.Z(Code, "loc_tag check location sdk available error");
            z = false;
        }
        return z && g.Code(context, g.I(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Z(Context context) {
        if (S(context)) {
            fb.V(Code, "loc_tag asyncLocation has location-sdk");
            try {
                C(context);
                return;
            } catch (Throwable th) {
                fb.I(Code, "loc_tag get location by kit error, " + th.getClass().getSimpleName());
                fb.Code(5, th);
            }
        } else {
            fb.V(Code, "loc_tag asyncLocation has not location-sdk");
        }
        V(context, 2);
    }

    @TargetApi(23)
    private static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        if (!V()) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.kuaishou.weapon.p0.g.g);
        arrayList.add(com.kuaishou.weapon.p0.g.h);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!ap.Code(context, (String) it.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean b(Context context) {
        try {
            return L(context);
        } catch (Throwable th) {
            fb.I(Code, "get location service switch exception: " + th.getClass().getSimpleName());
            return false;
        }
    }

    public static Location Code(Context context, RequestOptions requestOptions, Location location) {
        boolean V2 = V(context, requestOptions);
        boolean z = false;
        fb.V(Code, "loc_tag media allow: %s", Boolean.valueOf(V2));
        com.huawei.openalliance.ad.beans.inner.b F2 = F(context);
        if (V2 && F2.Z()) {
            z = true;
        }
        Location location2 = null;
        if (!z) {
            fb.V(Code, "loc_tag isLocationAvailable = false, return null");
        } else if (location == null) {
            B(context);
            Location location3 = B;
            if (location3 != null) {
                location2 = location3.Code();
            }
        } else {
            location2 = location.Code();
            location2.Code(Long.valueOf(System.currentTimeMillis()));
            location2.Code(1);
        }
        if (location2 == null) {
            location2 = new Location();
        }
        location2.Code(F2);
        return location2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(Context context, int i) {
        fb.Code(Code, "loc_tag getLocationByNative");
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        I = locationManager;
        if (locationManager == null) {
            fb.Z(Code, "loc_tag getLocationByNative, nativeLocationManager is null, return");
            return;
        }
        List<String> providers = locationManager.getProviders(true);
        String str = "network";
        if (!providers.contains("network")) {
            str = "gps";
            if (!providers.contains("gps")) {
                fb.I(Code, "loc_tag nativeLocationProvider wrong, return");
                return;
            }
        }
        Z = str;
        if (fb.Code()) {
            fb.Code(Code, "loc_tag native location provider is: %s", Z);
        }
        try {
            String str2 = Z;
            if (str2 != null) {
                if (1 == i) {
                    android.location.Location lastKnownLocation = I.getLastKnownLocation(str2);
                    if (lastKnownLocation == null) {
                        fb.I(Code, "loc_tag getLocationByNative, but location is null");
                        return;
                    } else {
                        fb.Code(Code, "loc_tag getLocationByNative getLastKnownLocation lat = %s, lon = %s", bh.Code(String.valueOf(lastKnownLocation.getLatitude())), bh.Code(String.valueOf(lastKnownLocation.getLongitude())));
                        Code(lastKnownLocation);
                        return;
                    }
                }
                if (2 != i) {
                    fb.Code(Code, "loc_tag requestLocationByNative not correct type");
                    return;
                }
                fb.V(Code, "loc_tag getLocationByNative requestLocationUpdates");
                b = false;
                final LocationListener locationListener = new LocationListener() { // from class: com.huawei.openalliance.ad.utils.af.3
                    @Override // android.location.LocationListener
                    public void onLocationChanged(android.location.Location location) {
                        try {
                            if (location != null) {
                                fb.Code(af.Code, "loc_tag getLocationByNative Listener lat = %s, lon = %s", bh.Code(String.valueOf(location.getLatitude())), bh.Code(String.valueOf(location.getLongitude())));
                                af.Code(location);
                            } else {
                                fb.I(af.Code, "loc_tag getLocationByNative Listener, but location is null");
                            }
                        } catch (Throwable th) {
                            fb.V(af.Code, "onLocationChanged ex: %s", th.getClass().getSimpleName());
                        }
                        af.V(this);
                    }

                    @Override // android.location.LocationListener
                    public void onProviderDisabled(String str3) {
                        fb.Code(af.Code, "loc_tag getLocationByNative onProviderDisabled");
                        af.V(this);
                    }

                    @Override // android.location.LocationListener
                    public void onProviderEnabled(String str3) {
                        fb.Code(af.Code, "loc_tag getLocationByNative onProviderEnabled");
                        af.V(this);
                    }

                    @Override // android.location.LocationListener
                    public void onStatusChanged(String str3, int i2, Bundle bundle) {
                        fb.Code(af.Code, "loc_tag getLocationByNative onStatusChanged");
                        af.V(this);
                    }
                };
                I.requestSingleUpdate(Z, locationListener, Looper.getMainLooper());
                bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.utils.af.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (af.b) {
                            return;
                        }
                        af.V(locationListener);
                    }
                }, 30000L);
            }
        } catch (Throwable th) {
            fb.Z(Code, "loc_tag getLocationByNative, exception = " + th.getClass().getSimpleName());
        }
    }

    public static Location Code(android.location.Location location) {
        if (location == null) {
            return null;
        }
        synchronized (C) {
            try {
                if (B == null) {
                    B = new Location();
                }
                B.Code(Double.valueOf(location.getLongitude()));
                B.V(Double.valueOf(location.getLatitude()));
                B.Code(Long.valueOf(System.currentTimeMillis()));
            } catch (Throwable th) {
                throw th;
            }
        }
        return B;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(LocationListener locationListener) {
        if (b || I == null || locationListener == null) {
            return;
        }
        fb.V(Code, "loc_tag remove native location updates");
        try {
            I.removeUpdates(locationListener);
        } catch (Throwable th) {
            fb.V(Code, "loc_tag remove native location updates ex: %s", th.getClass().getSimpleName());
        }
        b = true;
    }

    private static boolean V() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static void Code(final Context context, RequestOptions requestOptions) {
        if (V(context, requestOptions) && I(context)) {
            if (fb.Code()) {
                fb.Code(Code, "loc_tag sendAsyncLocationByNative go!");
            }
            h.I(new Runnable() { // from class: com.huawei.openalliance.ad.utils.af.1
                @Override // java.lang.Runnable
                public void run() {
                    if (af.F(context).Z()) {
                        af.V(context, 1);
                    } else {
                        fb.V(af.Code, "loc_tag sendAsyncLocationByNative failed because switch is off");
                    }
                }
            });
        }
    }

    private static boolean V(Context context, RequestOptions requestOptions) {
        Boolean Z2;
        if (requestOptions == null || requestOptions.Z() == null) {
            RequestOptions requestConfiguration = HiAd.getInstance(context).getRequestConfiguration();
            if (requestConfiguration == null || requestConfiguration.Z() == null) {
                return true;
            }
            Z2 = requestConfiguration.Z();
        } else {
            Z2 = requestOptions.Z();
        }
        return Z2.booleanValue();
    }
}
