package com.baidu.vi;

import XIXIX.OOXIXo;
import android.location.GpsStatus;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Message;

/* loaded from: classes8.dex */
final class h extends Handler {
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        int i2;
        LocationManager locationManager;
        GpsStatus.Listener listener;
        LocationManager locationManager2;
        LocationManager locationManager3;
        GpsStatus.Listener listener2;
        LocationManager locationManager4;
        LocationListener locationListener;
        VGps vGps = (VGps) message.obj;
        if (vGps == null) {
            return;
        }
        int i3 = message.what;
        if (i3 == 1) {
            i = vGps.f;
            i2 = VGps.e;
            if (i < i2) {
                vGps.updateGps(OOXIXo.f3760XO, OOXIXo.f3760XO, 0.0f, 0.0f, 0.0f, 0);
                return;
            }
            return;
        }
        if (i3 != 2) {
            if (i3 == 3) {
                locationManager2 = vGps.c;
                if (locationManager2 != null) {
                    locationManager3 = vGps.c;
                    listener2 = vGps.f10215a;
                    locationManager3.removeGpsStatusListener(listener2);
                    locationManager4 = vGps.c;
                    locationListener = vGps.b;
                    locationManager4.removeUpdates(locationListener);
                    return;
                }
                return;
            }
            return;
        }
        if (VIContext.getContext() != null) {
            vGps.c = (LocationManager) VIContext.getContext().getSystemService("location");
            locationManager = vGps.c;
            listener = vGps.f10215a;
            locationManager.addGpsStatusListener(listener);
        }
    }
}
