package com.baidu.location.b;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    public List<c> f5675a = new ArrayList();
    private LocationManager b = null;
    private b c = null;
    private boolean d = false;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static z f5676a = new z();
    }

    /* loaded from: classes7.dex */
    public class b implements LocationListener {
        private b() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location == null) {
                return;
            }
            Iterator<c> it = z.this.f5675a.iterator();
            while (it.hasNext()) {
                it.next().a(location);
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
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(Location location);
    }

    public static z a() {
        return a.f5676a;
    }

    public void b() {
        try {
            if (this.b == null) {
                this.b = (LocationManager) com.baidu.location.f.getServiceContext().getSystemService("location");
            }
            if (this.c == null) {
                this.c = new b();
            }
            LocationManager locationManager = this.b;
            if (locationManager == null || !locationManager.isProviderEnabled("network")) {
                return;
            }
            this.b.requestLocationUpdates("network", 1000L, 0.0f, this.c);
        } catch (Exception unused) {
        }
    }

    public void c() {
        LocationManager locationManager;
        b bVar = this.c;
        if (bVar == null || (locationManager = this.b) == null) {
            return;
        }
        locationManager.removeUpdates(bVar);
        this.c = null;
    }

    public void a(c cVar) {
        if (cVar == null) {
            return;
        }
        if (!this.f5675a.contains(cVar)) {
            this.f5675a.add(cVar);
        }
        if (this.f5675a.size() != 1 || this.d) {
            return;
        }
        b();
        this.d = true;
    }

    public void b(c cVar) {
        if (cVar == null) {
            return;
        }
        this.f5675a.remove(cVar);
        if (this.f5675a.size() == 0 && this.d) {
            c();
            this.d = false;
        }
    }
}
