package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.List;

public final /* synthetic */ class IIX0o implements Runnable {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ List f311Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f312XO;

    public /* synthetic */ IIX0o(LocationManagerCompat.LocationListenerTransport locationListenerTransport, List list) {
        this.f312XO = locationListenerTransport;
        this.f311Oo = list;
    }

    public final void run() {
        this.f312XO.lambda$onLocationChanged$1(this.f311Oo);
    }
}
