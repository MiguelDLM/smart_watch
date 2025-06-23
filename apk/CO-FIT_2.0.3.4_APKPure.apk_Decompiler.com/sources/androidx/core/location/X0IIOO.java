package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class X0IIOO implements Runnable {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ Executor f330Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport f331XO;

    public /* synthetic */ X0IIOO(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor) {
        this.f331XO = gpsStatusTransport;
        this.f330Oo = executor;
    }

    public final void run() {
        this.f331XO.lambda$onGpsStatusChanged$0(this.f330Oo);
    }
}
