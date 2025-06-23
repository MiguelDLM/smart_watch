package com.sma.smartv3.location;

import OXOo.OOXIXo;
import android.location.Location;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.SPUtils;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public abstract class XO extends LocationCallback {
    public abstract void II0xO0(@OOXIXo oIX0oI oix0oi);

    public abstract void oIX0oI(@OOXIXo String str);

    @Override // com.google.android.gms.location.LocationCallback
    public void onLocationResult(@OOXIXo LocationResult locationResult) {
        IIX0o.x0xO0oo(locationResult, "locationResult");
        if (locationResult.getLocations().size() > 0) {
            Location location = locationResult.getLocations().get(0);
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("MyLocationCallback onLocationResult " + location + " ->" + location.getLatitude() + ',' + location.getLongitude() + ',' + location.getAltitude() + ',' + location.getSpeed() + ", isAppForeground=" + AppUtils.isAppForeground());
            II0xO0(new oIX0oI(location.getLatitude(), location.getLongitude(), location.getAltitude(), location.getSpeed(), 0, 16, null));
            SPUtils XO2 = Xo0.f24349oIX0oI.XO();
            StringBuilder sb = new StringBuilder();
            sb.append(location.getLongitude());
            sb.append(',');
            sb.append(location.getLatitude());
            sb.append(',');
            sb.append(location.getAltitude());
            XO2.put(XoI0Ixx0.f24423XX, sb.toString());
            return;
        }
        oIX0oI("Google Map Location Failure");
    }
}
