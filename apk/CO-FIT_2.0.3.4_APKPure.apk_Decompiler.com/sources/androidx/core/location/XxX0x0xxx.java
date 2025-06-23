package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class XxX0x0xxx implements Runnable {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ String f339Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f340XO;

    public /* synthetic */ XxX0x0xxx(LocationManagerCompat.LocationListenerTransport locationListenerTransport, String str) {
        this.f340XO = locationListenerTransport;
        this.f339Oo = str;
    }

    public final void run() {
        this.f340XO.lambda$onProviderEnabled$4(this.f339Oo);
    }
}
