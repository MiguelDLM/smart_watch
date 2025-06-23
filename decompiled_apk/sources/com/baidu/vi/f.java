package com.baidu.vi;

import XIXIX.OOXIXo;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.LocationManager;
import java.util.Iterator;

/* loaded from: classes8.dex */
class f implements GpsStatus.Listener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VGps f10219a;

    public f(VGps vGps) {
        this.f10219a = vGps;
    }

    @Override // android.location.GpsStatus.Listener
    public void onGpsStatusChanged(int i) {
        LocationManager locationManager;
        GpsStatus gpsStatus;
        int i2;
        int i3;
        int i4;
        GpsStatus gpsStatus2;
        LocationManager locationManager2;
        GpsStatus gpsStatus3;
        LocationManager locationManager3;
        if (i != 2) {
            if (i == 4) {
                locationManager = this.f10219a.c;
                if (locationManager != null) {
                    gpsStatus2 = this.f10219a.d;
                    if (gpsStatus2 != null) {
                        locationManager2 = this.f10219a.c;
                        gpsStatus3 = this.f10219a.d;
                        locationManager2.getGpsStatus(gpsStatus3);
                    } else {
                        VGps vGps = this.f10219a;
                        locationManager3 = vGps.c;
                        vGps.d = locationManager3.getGpsStatus(null);
                    }
                }
                gpsStatus = this.f10219a.d;
                Iterator<GpsSatellite> it = gpsStatus.getSatellites().iterator();
                int i5 = 0;
                while (it.hasNext()) {
                    if (it.next().usedInFix()) {
                        i5++;
                    }
                }
                i2 = VGps.e;
                if (i5 < i2) {
                    i3 = this.f10219a.f;
                    i4 = VGps.e;
                    if (i3 >= i4) {
                        this.f10219a.b();
                    }
                }
                this.f10219a.f = i5;
                return;
            }
            return;
        }
        this.f10219a.updateGps(OOXIXo.f3760XO, OOXIXo.f3760XO, 0.0f, 0.0f, 0.0f, 0);
    }
}
