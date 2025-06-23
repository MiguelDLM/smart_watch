package com.baidu.platform.comapi.wnplatform.c;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class g implements LocationListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f9901a;

    public g(d dVar) {
        this.f9901a = dVar;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        Location location2;
        WLocData wLocData;
        Location location3;
        Location location4;
        if (location != null) {
            location2 = this.f9901a.w;
            if (location2 == null) {
                this.f9901a.a(location);
            } else {
                d dVar = this.f9901a;
                location3 = dVar.w;
                if (dVar.a(location, location3)) {
                    this.f9901a.w = location;
                }
                d dVar2 = this.f9901a;
                location4 = dVar2.w;
                dVar2.a(location4);
            }
            d dVar3 = this.f9901a;
            wLocData = dVar3.c;
            dVar3.a(wLocData, TKDownloadReason.KSAD_TK_NET);
            this.f9901a.h = true;
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
        if (this.f9901a.f == null) {
            return;
        }
        for (int i = 0; i < this.f9901a.f.size(); i++) {
            a aVar = (a) this.f9901a.f.get(i);
            if (aVar != null) {
                aVar.d(5);
            }
        }
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
        if (this.f9901a.f == null) {
            return;
        }
        for (int i = 0; i < this.f9901a.f.size(); i++) {
            a aVar = (a) this.f9901a.f.get(i);
            if (aVar != null) {
                aVar.d(4);
            }
        }
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
