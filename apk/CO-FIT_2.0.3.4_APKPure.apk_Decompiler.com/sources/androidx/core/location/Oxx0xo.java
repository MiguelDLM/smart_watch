package androidx.core.location;

import android.location.LocationManager;
import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Callable;

public final /* synthetic */ class Oxx0xo implements Callable {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport f325Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ LocationManager f326XO;

    public /* synthetic */ Oxx0xo(LocationManager locationManager, LocationManagerCompat.GpsStatusTransport gpsStatusTransport) {
        this.f326XO = locationManager;
        this.f325Oo = gpsStatusTransport;
    }

    public final Object call() {
        return Boolean.valueOf(this.f326XO.addGpsStatusListener(this.f325Oo));
    }
}
