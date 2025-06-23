package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class xXxxox0I implements Runnable {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ String f355Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f356XO;

    public /* synthetic */ xXxxox0I(LocationManagerCompat.LocationListenerTransport locationListenerTransport, String str) {
        this.f356XO = locationListenerTransport;
        this.f355Oo = str;
    }

    public final void run() {
        this.f356XO.lambda$onProviderDisabled$5(this.f355Oo);
    }
}
