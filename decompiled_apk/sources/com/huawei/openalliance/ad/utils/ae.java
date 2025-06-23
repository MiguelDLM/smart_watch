package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.location.Location;
import android.os.Looper;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hms.ads.fb;
import com.huawei.hms.location.FusedLocationProviderClient;
import com.huawei.hms.location.LocationAvailability;
import com.huawei.hms.location.LocationCallback;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.location.LocationResult;
import com.huawei.hms.location.LocationServices;

/* loaded from: classes10.dex */
public class ae {
    private static final long B = 5000;
    private static final String I = "LocationUtils";
    private static final long Z = 30000;
    private FusedLocationProviderClient C;
    LocationCallback Code;
    private volatile boolean F = false;
    private a S;
    LocationRequest V;

    /* loaded from: classes10.dex */
    public interface a {
        void Code();

        void Code(Location location);
    }

    public ae(Context context, final a aVar) {
        if (context == null || aVar == null) {
            return;
        }
        this.S = aVar;
        this.C = LocationServices.getFusedLocationProviderClient(context);
        LocationRequest locationRequest = new LocationRequest();
        this.V = locationRequest;
        locationRequest.setPriority(100);
        this.V.setNumUpdates(1);
        this.V.setInterval(5000L);
        this.Code = new LocationCallback() { // from class: com.huawei.openalliance.ad.utils.ae.1
            public void onLocationAvailability(LocationAvailability locationAvailability) {
                if (locationAvailability != null) {
                    fb.Code(ae.I, "loc_tag onLocationResult onLocationAvailability isLocationAvailable: %s", Boolean.valueOf(locationAvailability.isLocationAvailable()));
                }
            }

            public void onLocationResult(LocationResult locationResult) {
                String str;
                fb.Code(ae.I, "loc_tag getLocationByKit onLocationResult-callback");
                if (locationResult == null) {
                    str = "loc_tag getLocationByKit onLocationResult-callback is null";
                } else if (ad.Code(locationResult.getLocations())) {
                    str = "loc_tag getLocationByKit onLocationResult-callback getLocations() is wrong";
                } else {
                    Location location = (Location) locationResult.getLocations().get(0);
                    if (location != null) {
                        fb.Code(ae.I, "loc_tag getLocationByKit onLocationResult-callback lat = " + bh.Code(String.valueOf(location.getLatitude())) + ", lon = " + bh.Code(String.valueOf(location.getLongitude())));
                        aVar.Code(location);
                        ae.this.F = true;
                    }
                    str = "loc_tag getLocationByKit onLocationResult-callback location is null";
                }
                fb.I(ae.I, str);
                aVar.Code();
                ae.this.F = true;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        if (this.F) {
            return;
        }
        try {
            this.C.removeLocationUpdates(this.Code).addOnSuccessListener(new OnSuccessListener<Void>() { // from class: com.huawei.openalliance.ad.utils.ae.6
                /* renamed from: Code, reason: merged with bridge method [inline-methods] */
                public void onSuccess(Void r2) {
                    fb.Code(ae.I, "loc_tag removeLocationUpdates onSuccess");
                    ae.this.F = true;
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.huawei.openalliance.ad.utils.ae.5
                public void onFailure(Exception exc) {
                    fb.Code(ae.I, "loc_tag removeLocationUpdates onFailure:%s", exc.getClass().getSimpleName());
                    ae.this.F = false;
                }
            });
        } catch (Throwable th) {
            fb.I(I, "loc_tag removeLocationUpdates encounter exception:" + th.getClass().getSimpleName());
        }
    }

    public void Code() {
        if (this.C == null) {
            return;
        }
        this.F = false;
        this.C.requestLocationUpdates(this.V, this.Code, Looper.getMainLooper()).addOnSuccessListener(new OnSuccessListener<Void>() { // from class: com.huawei.openalliance.ad.utils.ae.3
            /* renamed from: Code, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r2) {
                fb.V(ae.I, "loc_tag requestLocationUpdates onSuccess");
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.huawei.openalliance.ad.utils.ae.2
            public void onFailure(Exception exc) {
                fb.Z(ae.I, "loc_tag requestLocationUpdates onFailure");
                ae.this.S.Code();
                ae.this.F = true;
            }
        });
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.utils.ae.4
            @Override // java.lang.Runnable
            public void run() {
                if (ae.this.F) {
                    return;
                }
                ae.this.V();
            }
        }, 30000L);
    }
}
