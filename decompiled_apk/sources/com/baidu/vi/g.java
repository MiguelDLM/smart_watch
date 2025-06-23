package com.baidu.vi;

import XIXIX.OOXIXo;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

/* loaded from: classes8.dex */
class g implements LocationListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VGps f10220a;

    public g(VGps vGps) {
        this.f10220a = vGps;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        float f;
        int i;
        int i2;
        int i3;
        if (location != null) {
            if (location.hasAccuracy()) {
                f = location.getAccuracy();
            } else {
                f = 0.0f;
            }
            i = this.f10220a.f;
            i2 = VGps.e;
            if (i < i2) {
                this.f10220a.b();
                return;
            }
            float bearing = location.getBearing();
            i3 = this.f10220a.f;
            this.f10220a.updateGps(location.getLongitude(), location.getLatitude(), (float) (location.getSpeed() * 3.6d), bearing, f, i3);
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
        this.f10220a.updateGps(OOXIXo.f3760XO, OOXIXo.f3760XO, 0.0f, 0.0f, 0.0f, 0);
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
        if (i == 0 || i == 1) {
            this.f10220a.updateGps(OOXIXo.f3760XO, OOXIXo.f3760XO, 0.0f, 0.0f, 0.0f, 0);
        }
    }
}
