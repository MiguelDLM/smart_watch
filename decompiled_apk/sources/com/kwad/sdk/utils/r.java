package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes11.dex */
public final class r {
    private static boolean aQd;
    private static com.kwad.sdk.utils.c.a aQe = new com.kwad.sdk.utils.c.a();

    @SuppressLint({"MissingPermission"})
    private static Location a(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.g) == 0) {
                Location lastKnownLocation = locationManager.getLastKnownLocation("gps");
                if (lastKnownLocation == null) {
                    aQd = true;
                }
                return lastKnownLocation;
            }
            return null;
        } catch (Exception e) {
            aQd = true;
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    private static Location b(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.g) != 0 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.h) != 0) {
                return null;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation("network");
            if (lastKnownLocation == null) {
                aQd = true;
            }
            return lastKnownLocation;
        } catch (Exception e) {
            aQd = true;
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    private static Location c(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.h) == 0) {
                Location lastKnownLocation = locationManager.getLastKnownLocation("passive");
                if (lastKnownLocation == null) {
                    aQd = true;
                }
                return lastKnownLocation;
            }
            return null;
        } catch (Exception e) {
            aQd = true;
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            return null;
        }
    }

    @Nullable
    public static com.kwad.sdk.utils.c.a ci(Context context) {
        com.kwad.sdk.utils.c.a aVar;
        com.kwad.sdk.utils.c.a aVar2 = new com.kwad.sdk.utils.c.a();
        if (av.MT() && av.MU() != null) {
            aVar2.aTt = av.MU();
            aVar2.type = 1;
            return aVar2;
        }
        if (!aQd && (((aVar = aQe) == null || aVar.aTt == null) && context != null)) {
            if (!av.MT() && !((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ab(64L)) {
                try {
                    LocationManager locationManager = (LocationManager) context.getSystemService("location");
                    if (locationManager.isProviderEnabled("gps")) {
                        aQe.aTt = a(context, locationManager);
                    }
                    if (aQe == null && locationManager.isProviderEnabled("network")) {
                        aQe.aTt = b(context, locationManager);
                    }
                    if (aQe == null && locationManager.isProviderEnabled("passive")) {
                        aQe.aTt = c(context, locationManager);
                    }
                    com.kwad.sdk.utils.c.a aVar3 = aQe;
                    aVar3.type = 0;
                    return aVar3;
                } catch (Exception e) {
                    aQd = true;
                    com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                }
            }
            return null;
        }
        return aQe;
    }
}
