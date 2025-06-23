package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class xI implements Runnable {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ int f353Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f354XO;

    public /* synthetic */ xI(LocationManagerCompat.LocationListenerTransport locationListenerTransport, int i) {
        this.f354XO = locationListenerTransport;
        this.f353Oo = i;
    }

    public final void run() {
        this.f354XO.lambda$onFlushComplete$2(this.f353Oo);
    }
}
