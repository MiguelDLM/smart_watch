package androidx.core.location;

import android.location.Location;
import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class ooXIXxIX implements Runnable {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ Location f349Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f350XO;

    public /* synthetic */ ooXIXxIX(LocationManagerCompat.LocationListenerTransport locationListenerTransport, Location location) {
        this.f350XO = locationListenerTransport;
        this.f349Oo = location;
    }

    public final void run() {
        this.f350XO.lambda$onLocationChanged$0(this.f349Oo);
    }
}
