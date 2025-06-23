package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class XI0IXoo implements Runnable {

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ Executor f332Oo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport f333XO;

    public /* synthetic */ XI0IXoo(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor) {
        this.f333XO = gpsStatusTransport;
        this.f332Oo = executor;
    }

    public final void run() {
        this.f333XO.lambda$onGpsStatusChanged$1(this.f332Oo);
    }
}
