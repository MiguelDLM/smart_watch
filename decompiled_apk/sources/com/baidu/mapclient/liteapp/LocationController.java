package com.baidu.mapclient.liteapp;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.baidu.navisdk.adapter.BaiduNaviManagerFactory;
import com.baidu.navisdk.adapter.struct.BNLocationData;
import com.kuaishou.weapon.p0.g;

/* loaded from: classes7.dex */
public class LocationController implements LocationListener {
    private static LocationController sInstance;
    private boolean isLocating;
    private BNLocationData mLocData;
    private LocationManager mLocationManager;

    private LocationController() {
    }

    public static synchronized LocationController getInstance() {
        LocationController locationController;
        synchronized (LocationController.class) {
            try {
                if (sInstance == null) {
                    sInstance = new LocationController();
                }
                locationController = sInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return locationController;
    }

    public boolean isLocating() {
        return this.isLocating;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        if (location == null) {
            return;
        }
        Log.e("onLocationChanged: ", location.toString());
        this.mLocData = new BNLocationData.Builder().latitude(location.getLatitude()).longitude(location.getLongitude()).accuracy(location.getAccuracy()).speed(location.getSpeed()).direction(location.getBearing()).altitude((int) location.getAltitude()).time(location.getTime()).build();
        BaiduNaviManagerFactory.getMapManager().setMyLocationData(this.mLocData);
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

    public void startLocation(Context context) {
        if (this.isLocating) {
            return;
        }
        if (this.mLocationManager == null) {
            this.mLocationManager = (LocationManager) context.getSystemService("location");
        }
        if (ContextCompat.checkSelfPermission(context, g.g) != 0 && ContextCompat.checkSelfPermission(context, g.h) != 0) {
            Log.e("LocationDemo", "initLocationClient: permission failed");
        } else {
            this.mLocationManager.requestLocationUpdates("gps", 1000L, 1.0f, this);
            this.isLocating = true;
        }
    }

    public void stopLocation() {
        this.mLocationManager.removeUpdates(this);
        this.isLocating = false;
    }
}
